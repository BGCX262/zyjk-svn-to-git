package st.platform.db;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import st.platform.utils.*;

public class DBUtil
{
    public DBUtil()
    {
    }

    public static String sqlEncode(String s)
    {
        if(s == null || s.equals(""))
            return "";
        String s1 = s;
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < s1.length(); i++)
        {
            char c = s1.charAt(i);
            if(c == '\'')
                stringbuffer.append("''");
            else
                stringbuffer.append(c);
        }

        return stringbuffer.toString();
    }

    public static ResultSet getResult(String sqlStr)
    {
        DatabaseConnection databaseconnection;
        databaseconnection  = null;
        ResultSet resultset = null;
       
        try
        {
            ConnectionManager connectionmanager = ConnectionManager.getInstance();
            databaseconnection = connectionmanager.getConnection();
            resultset = databaseconnection.executeResultSetQuery(sqlStr);
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(databaseconnection != null)
                databaseconnection.close();
        }
        return resultset;
       
    }

    public static ResultSet getResult(String connID, String sqlStr)
    {
        DatabaseConnection databaseconnection;
        databaseconnection = null;
        ResultSet resultset = null;
        try
        {
            ConnectionManager connectionmanager = ConnectionManager.getInstance();
            if(connID != null && !connID.equals(""))
                connectionmanager.setConnID(connID);
            
            databaseconnection = connectionmanager.getConnection();
            resultset = databaseconnection.executeResultSetQuery(sqlStr);
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(databaseconnection != null)
                databaseconnection.close();          
        }
        return resultset;
    }

    public static RecordSet getRecord(String connID, String sqlStr)
    {
        DatabaseConnection databaseconnection;
        databaseconnection = null;
        RecordSet recordset = null;
        try
        {
            ConnectionManager connectionmanager = ConnectionManager.getInstance();
            if(connID != null && !connID.equals(""))
                connectionmanager.setConnID(connID);
            
            databaseconnection = connectionmanager.getConnection();
            recordset = databaseconnection.executeQuery(sqlStr);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(databaseconnection != null)
                databaseconnection.close();
            
        }
        return recordset;
    }

    public static RecordSet getRecord(String sqlStr)
    {
        DatabaseConnection databaseconnection = null;
        RecordSet recordset = null;
        try
        {
            databaseconnection = ConnectionManager.getInstance().getConnection();
            recordset = databaseconnection.executeQuery(sqlStr);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(databaseconnection != null)
                databaseconnection.close();
        }
        return recordset;
       
    }

    public static String getCellValue(String tableName, String fieldName, String whereStr)
        throws Exception
    {
        if(tableName == null || fieldName == null || whereStr == null)
            return null;
        if(whereStr.trim().equals(""))
            whereStr = "(1=1)";
        try
        {
            String sqlStr = "select " + fieldName;
            sqlStr = sqlStr + " from " + tableName;
            sqlStr = sqlStr + " where " + whereStr;
            RecordSet recordset = getRecord(sqlStr);            
            
            if(recordset.next())
            {
                String fieldValue = recordset.getString(0);
                if(fieldValue != null)
                    return fieldValue.trim();
            }
            recordset.close();
            return null;
        }
        catch(Exception exception)
        {
            throw exception;
        }
    }

    public static String getNoInLogStr(String s)
    {
        if(s.equals(""))
            return s;
        String s1 = "(or|=|'|delete|update|select|drop|all|OR|DELETE|AND|UPDATE|SELECT|DROP|TRUNCATE|truncate)";
        Pattern pattern = Pattern.compile(s1);
        Matcher matcher = pattern.matcher(s);
        if(matcher.find())
            throw new IllegalArgumentException("您提交的数据中含有非法的字符，请修改后重新提交！！！");
        else
            return s;
    }
    
    /**
     * 按要求转码
     *
     * @param content
     * @param fromEncoding
     * @param toEncoding
     * @return
     */
    public static String toDB(String content, String fromEncoding, String toEncoding) {
        if (content == null)
            return null;
        try {
            byte[] tt;
            if (fromEncoding == null) {
                tt = content.getBytes();
            } else {
                //logger.info("formEncoding is "+fromEncoding);
                tt = content.getBytes(fromEncoding);
            }
            if (toEncoding == null)
                return new String(tt);
            return new String(tt, toEncoding);
        } catch (Exception e) {
            return content;
        }
    }

    /**
     * 按要求转码
     *
     * @param content
     * @param fromEncoding
     * @param toEncoding
     * @return
     */
    public static String fromDB(String content, String fromEncoding, String toEncoding) {
        return toDB(content, fromEncoding, toEncoding);
    }

    /**
     * 按要求将web编码转为DB编码(by wxj)
     * 从配置文件中读取转码要求，将字符串转码。
     *
     * @param p_value
     * @return
     */
    public static String toDB(String p_value) 
    {
      if (!Basic.IsTrue(Config.getProperty("isdbencode")))
          return p_value;
      
        String encod1 = Config.getProperty("web_server_encoding");
        String encod2 = Config.getProperty("db_server_encoding");
        
        return toDB(p_value, encod1, encod2);
    }

    /**
     * 按要求将DB编码转为web编码(by wxj)
     * 从配置文件中读取转码要求，将字符串转码。
     *
     * @param p_value
     * @return
     */
    public static String fromDB(String p_value) 
    {
        
        if (!Basic.IsTrue(Config.getProperty("iswebencode")))
              return p_value;
        
        String encod1 = Config.getProperty("db_server_encoding");
        String encod2 = Config.getProperty("web_server_encoding");
        
        
        return fromDB(p_value, encod1, encod2);
    }

}
