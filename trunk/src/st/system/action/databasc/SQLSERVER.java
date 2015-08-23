package st.system.action.databasc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import st.system.dao.PtableBean;
import st.system.dao.PtablecolumnBean;

/**
 * 移植到sqlserver
 * @author Administrator
 *
 */
public class SQLSERVER {
    ConnectionManager cm = ConnectionManager.getInstance();
    DatabaseConnection DBCon = cm.getConnection();
    
    String DataName = "zpf";
    
    //取得连接
    public SQLSERVER(){
        try {
            // DBCon = new DatabaseConnection("net.sourceforge.jtds.jdbc.Driver", "jdbc:jtds:sqlserver://localhost:1433/zpf", "sa", "yjzh");
            DBCon = new DatabaseConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://localhost:1433;DatabaseName=zpf", "sa", "sa123");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    //创建表结构
    
    //描述sql server 只支持sp_addextendedproperty方式添加描述信息，所以CREATE TABLE语句不能直接添加
    public void createTable(PtableBean ptable,List<PtablecolumnBean> list,String primary ){
        try { 
        
        RecordSet gridRS  =   DBCon.executeQuery("SELECT name FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].["+ptable.getTablename()+"]') AND type in (N'U')");
        System.out.println(gridRS.getRecordCount());
        while (gridRS != null && gridRS.next()) {
            System.out.println(gridRS.getString("name"));
           if(gridRS.getString("name")!=null&&!(gridRS.getString("name").equals("")))
           {
            int sta = DBCon.executeUpdate(" DROP TABLE dbo."+ptable.getTablename());
           }
        }
         DBCon.commit();
        String sql =" CREATE TABLE [dbo].["+ptable.getTablename()+"](";
        for(int i=0;i<list.size();i++)
        {
            PtablecolumnBean ptcolumn = list.get(i);
            sql = sql+"["+ptcolumn.getColumnname()+"] ";
            if(ptcolumn.getColumntype().equals("varchar")){
                sql =sql+"[nvarchar] ";
            }else{
                sql =sql+"["+ptcolumn.getColumntype()+"] ";
            }
            if(ptcolumn.getColumnlength().equals("0")){
            
            }else{
                sql =sql+" ("+ptcolumn.getColumnlength()+")";
            }
                    
            sql =sql+" "+ptcolumn.getIsnulls()+",";
            
        }
        if(primary==null)
        {
            sql = sql.substring(0, sql.length()-1)+"";
            sql =sql +")";
        }else{
        sql =sql +" CONSTRAINT [PK_"+ptable.getTablename()+"] PRIMARY KEY CLUSTERED" +
                " ( ["+primary+"] ASC )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, " +
                "IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON" +
                " [PRIMARY]) ON [PRIMARY]";
        }
      System.out.println(sql);
            DBCon.executeUpdate(sql);
            DBCon.executeUpdate("SET ANSI_PADDING OFF");
            for(int i=0;i<list.size();i++)
            {
                PtablecolumnBean ptcolumn = list.get(i);
                String column = "EXEC sys.sp_addextendedproperty @name=N'MS_Description', " +
                        "@value=N'"+ptcolumn.getColumndesc()+"' , @level0type=N'SCHEMA',@level0name=N'dbo', " +
                        "@level1type=N'TABLE',@level1name=N'"+ptcolumn.getTablename()+"'," +
                        " @level2type=N'COLUMN',@level2name=N'"+ptcolumn.getColumnname()+"'";
                DBCon.executeUpdate(column);
            }
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
           //DBCon.close();
            e.printStackTrace();
        }
    }
    
    
    //数据移植
    
    public void insertData(PtableBean ptable, RecordSet gridRS,Map<String,String> map){
        String insertSQL = "INSERT INTO ["+ptable.getTablename()+"]";
        
        while (gridRS != null && gridRS.next()) {
            String  column  = "(";
            String  values = "VALUES(";
            for (int i = 0; i < gridRS.getColumnCount(); i++) {

                String mark = gridRS.getFieldName(i);
                String value = gridRS.getString(gridRS.getFieldName(i)).trim().replace("\r\n", "");
                column = column+"["+mark+"]"+",";
                if(map.get(mark)==null)
                {
                    values = values +"'"+value+"',";
                }
                else if(map.get(mark)!=null){
                    if(value.equals(""))
                    {
                        values = values +"'"+0+"',";
                    }else{
                        values = values +"'"+value+"',";
                    }
                }
            }

            values = values.substring(0, values.length()-1)+"";
            column = column.substring(0, column.length()-1)+"";
            
            String sql = insertSQL +column+") "+values+")";
            //System.out.println(sql);
            try {
              
                DBCon.executeUpdate(sql);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println(sql);
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println(sql);
                e.printStackTrace();
            }
        }
                                  
    }
    
    
}
