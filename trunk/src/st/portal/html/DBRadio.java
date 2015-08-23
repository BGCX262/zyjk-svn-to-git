package st.portal.html;

import java.sql.SQLException;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;

public class DBRadio {

    ConnectionManager cm = ConnectionManager.getInstance();
    DatabaseConnection DBCon =  cm.get();    
    RecordSet gridRS;
    
    String radioname ="";
    String radioenuType ="";
    String radiodefValue ="";
    String radioid = "";
    String strSql = "";
    /**
     * 声明下拉列表对象
     * @param name 对象标示
     * @param enuType 枚举类型
     * @param defValue 缺省值
     */
    public DBRadio(String id,String name,String enuType,String defValue)
    {
        radioid = id;
        radioname     = name;
        radioenuType  = enuType;
        radiodefValue = defValue;
    }
    /**
     * 声明下拉列表对象
     * @param name 对象标示
     * @param enuType 枚举类型
     */
    public DBRadio(String id,String name,String enuType)
    {
        radioid = id;
        radioname     = name;
        radioenuType  = enuType;
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

         String sql = "Select * from ptenudetail where enutype ='"+radioenuType+"' ";
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
         
         String ret_str = "<table style='width:70px'>";
        
         String radiostr = "";
         int index = 0;
         String hidevalue ="";
         while ( gridRS != null && gridRS.next() ) {
             index++;
             String value = gridRS.getString("ENUITEMVALUE");
             String label = gridRS.getString("ENUITEMLABEL");
            // System.out.println(radiodefValue);
             
             if(radiodefValue.equals(value))
             {
                 
            	 hidevalue = value;
                 if(value.equals("2")){
                	 radiostr = "<tr><td style='color: #FF3030;'><input id='"+radioid+"_"+index+"' type='radio' name='"+radioid+"' value='"+value+"' checked='checked'/><label for='"+radioname+"_"+index+"'>"+label+"</label></tr></td>";
                 }else{
                	 radiostr = "<tr><td ><input id='"+radioid+"_"+index+"' type='radio' name='"+radioid+"' value='"+value+"' checked='checked'/><label for='"+radioname+"_"+index+"'>"+label+"</label></tr></td>";
                 }
            	 
             }else{
                 radiostr = "<tr><td><input id='"+radioid+"_"+index+"'  type='radio' name='"+radioid+"' value='"+value+"' /><label for='"+radioname+"_"+index+"'>"+label+"</label></tr></td>";
             }
         
             ret_str = ret_str +"  "+radiostr ;
     }
         ret_str =ret_str+"";
        ret_str+="</table>"; 
    // System.out.println(ret_str);
       return ret_str;
     }
}
