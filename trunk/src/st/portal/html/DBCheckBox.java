package st.portal.html;

import java.sql.SQLException;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;

public class DBCheckBox {

    ConnectionManager cm = ConnectionManager.getInstance();
    DatabaseConnection DBCon =  cm.get();    
    RecordSet gridRS;
    
    String boxid = "";
    String boxname ="";
    String boxenuType ="";
    String boxdefValue ="";
    
    String strSql = "";
    /**
     * 声明下拉列表对象
     * @param name 对象标示
     * @param enuType 枚举类型
     * @param defValue 缺省值
     */
    public DBCheckBox(String id,String name,String enuType,String defValue)
    {
        boxname     = name;
        boxenuType  = enuType;
        boxid = id;
        boxdefValue = defValue;
    }
    /**
     * 声明下拉列表对象
     * @param name 对象标示
     * @param enuType 枚举类型
     */
    public DBCheckBox(String id,String name,String enuType)
    {
        boxname     = name;
        boxenuType  = enuType;
        boxid = id;
    }
    
   
     
     /**
      * 赋值Sql语句
      * @param sqlString
      */
     public void setSqlString(String sqlString) {
         strSql = sqlString;
     }
     
    
      
     /**
      * 返回下拉框对象
      */
     public String toString()
     {

         String sql = "Select * from ptenudetail where enutype ='"+boxenuType+"' ";
         if(!strSql.equals(""))
         {
             sql = sql+strSql;
         }

        try {
            gridRS = DBCon.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
         String ret_str = "";
         String radiostr = "";
         int index = 0;
         String boxArry[] = boxdefValue.split(",");
         while ( gridRS != null && gridRS.next() ) {
             String state ="0";
             index++;
             String value = gridRS.getString("ENUITEMVALUE");
             String label = gridRS.getString("ENUITEMLABEL");
          for(int i=0;i<boxArry.length;i++)
          {
              String boxstr = boxArry[i].toString().trim();
             if(boxstr.equals(value))
             {
                 state="1";
                 radiostr = "<input id='"+boxid+"_"+index+"'   type='checkbox' name='"+boxname+"' value='"+value+"' checked='checked' /><label for='"+boxid+"_"+index+"'>"+label+"</label>";
                 break;
             }
          }
          if(state.equals("0")){
              radiostr = "<input id='"+boxid+"_"+index+"'  type='checkbox' name='"+boxname+"' value='"+value+"' /><label for='"+boxid+"_"+index+"'>"+label+"</label>";
          }
             ret_str = ret_str +" "+radiostr+"&nbsp;&nbsp;&nbsp;&nbsp;" ;
     }
    // System.out.println(ret_str);
       return ret_str;
     }
}
