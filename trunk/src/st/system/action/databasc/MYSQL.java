/*********************************************************************
 *<p>处理内容：移植到mysql Action</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.5.14---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.databasc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import st.system.dao.PtableBean;
import st.system.dao.PtablecolumnBean;

public class MYSQL {
    ConnectionManager cm = ConnectionManager.getInstance();
    DatabaseConnection DBCon = cm.getConnection();
    
    String DataName = "zpf";
    
    //取得连接
    public MYSQL(){
        try {
            DBCon = new DatabaseConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/z_sb?autoReconnect=true", "root", "root");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    //创建表结构
    public void createTable(PtableBean ptable,List<PtablecolumnBean> list,String primary ){
        try { 
        RecordSet gridRS  =   DBCon.executeQuery("SELECT * FROM information_schema.TABLES  WHERE table_schema='"+ ptable.getTablename() +"'");
        System.out.println(gridRS.getRecordCount());
        while (gridRS != null && gridRS.next()) {
            System.out.println(gridRS.getString("name"));
           if(gridRS.getString("name")!=null&&!(gridRS.getString("name").equals("")))
           {
            int sta = DBCon.executeUpdate(" DROP TABLE "+ptable.getTablename());
           }
        }
        DBCon.commit();
        String sql =" CREATE TABLE "+ptable.getTablename()+"(";
        for(int i=0;i<list.size();i++)
        {
            PtablecolumnBean ptcolumn = list.get(i);
            sql = sql+ptcolumn.getColumnname()+" ";
            if(ptcolumn.getColumntype().equals("varchar")){
                sql =sql+"nvarchar ";
            }else{
                sql =sql+""+ptcolumn.getColumntype()+" ";
            }
            
            if(ptcolumn.getColumnlength().equals("0")){
            
            }else{
                sql =sql+" ("+ptcolumn.getColumnlength()+")";
            }
                    
            sql =sql+" "+ptcolumn.getIsnulls()+" COMMENT '"+ ptcolumn.getColumndesc() +"',";
        }
          sql = sql.substring(0, sql.length()-1)+"";
          sql =sql +")";      
            DBCon.executeUpdate(sql);
            if(primary!=null)
            {                          
            	DBCon.executeUpdate("ALTER TABLE "+ ptable.getTablename() +" ADD PRIMARY KEY ("+ primary +")");
            }
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
           //DBCon.close();
            e.printStackTrace();
        }
    }
    
    
    //数据移植
    
    public void insertData(PtableBean ptable, RecordSet gridRS,Map<String,String> map){
        String insertSQL = "INSERT INTO "+ptable.getTablename();
        
        while (gridRS != null && gridRS.next()) {
            String  column  = "(";
            String  values = "VALUES(";
            for (int i = 0; i < gridRS.getColumnCount(); i++) {

                String mark = gridRS.getFieldName(i);
                String value = gridRS.getString(gridRS.getFieldName(i)).trim().replace("\r\n", "");
                column = column+mark+",";
                
                if(map.get(mark)==null)
                {
                    values = values +"'"+value+"',";
                }
                else if(map.get(mark)!=null&&map.get(mark).equals("decimal")){                	
                    if(value.equals(""))
                    {                       
                        values = values +"'"+0+"',";
                    }else{
                        values = values +"'"+value+"',";
                    }                    
                }else if(map.get(mark)!=null&&map.get(mark).equals("date")){
                	
                    if(value.equals(""))
                    {
                    	values = values +"'1900-01-01',";
                    }else{
                        values = values +"'"+value+"',";
                    }                    
                	
                	
                }
                
            }

            values = values.substring(0, values.length()-1)+"";
            column = column.substring(0, column.length()-1)+"";
            
            String sql = insertSQL +column+") "+values+")";
            try {
              
                DBCon.executeUpdate(sql);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
                                  
    }
    
    
}
