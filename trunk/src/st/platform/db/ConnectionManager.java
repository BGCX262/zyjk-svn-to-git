package st.platform.db;
import java.util.HashMap;
import java.util.StringTokenizer;
import st.platform.common.LogManager;
import st.platform.utils.*;

public class ConnectionManager {
  /**
   * 线程标识<--->数据库连接(Key-Value)
   */
    private static HashMap conns = null;

    private static ConnectionManager manager = null;
    public   LogManager logManager;
    
    String DBType     = "";
    String sconnID    = "";
    String sDBPool    = "";
    String sDBDriver  = "";
    String sConnStr   = "";
    String user       = "";
    String passwd     = "";
    
    public void setConnID(String SconnID)throws Exception
    {
        if (!sconnID.equals("connID"))
            getConfig();
    } 
    
    private void getConfig()throws Exception
    {
       
        try
        {
            StringTokenizer stringtokenizer = new StringTokenizer(Config.getDbConnectionStr(sconnID), "|");
            DBType = stringtokenizer.nextToken();
            sDBPool = stringtokenizer.nextToken();
            sDBDriver = stringtokenizer.nextToken();
            sConnStr = stringtokenizer.nextToken();
            user = stringtokenizer.nextToken();
            passwd = stringtokenizer.nextToken();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
  
    private ConnectionManager()throws Exception {       
         if (conns == null)
             conns = new HashMap();
         
        getConfig();
    }
    /**
     *  /** 得到管理实例
     *
     *@return     ConnectionManager
     *@roseuid    3E62D37A011D
     */
    public static ConnectionManager getInstance() {
        if (manager == null) {
            try
            {
                manager = new ConnectionManager();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return manager;
    }

   /**
    * 得到缺省的数据库连接,以线程ID保存
    *
    * @return zt.power.front.db.DatabaseConnection
    * @roseuid 3E5EB1AE011A
    */
   public DatabaseConnection get() 
   {      
     
       String id = "" + Thread.currentThread().hashCode();
     
       if (conns.containsKey(id)) {
           return (DatabaseConnection) conns.get(id);
       }
           
       DatabaseConnection dc = getConnection();    
       conns.put(id, dc);
       dc.DbType     = DBType;
       dc.logManager = logManager;
              
       return dc;
   }
   
   public DatabaseConnection getConnection() 
   {
         
       DatabaseConnection con=null;
       try {
           con = new DatabaseConnection(sDBPool);
           con.DbType = DBType;
           con.logManager = logManager;
       }
       catch (Exception ex) {
                   
           try {
               con = new DatabaseConnection(sDBDriver, sConnStr, user, passwd);
               con.DbType = DBType;
               con.logManager = logManager;
           }
           catch (Exception ex1) {
               ex1.printStackTrace();
           }
       }
       if(con.getConnection()==null){
           return null;
       }else{
           return con;
       }
   }
   
   
   /**
    * 释放数据库连接
    *
    * @roseuid 3E5EB1CE030B
    */
   public void release() 
   {
       String id = "" + Thread.currentThread().hashCode();
       
      if (conns.containsKey(id))
      {
           DatabaseConnection dc = (DatabaseConnection)conns.get(id) ;
           dc.close() ;
           conns.remove(id) ;
       }
   }

   /**
    * 释放指定的数据库连接
    *
    * @param id
    */
   public void release(DatabaseConnection databaseconnection) {

       try
       {
           databaseconnection.close();
       }
       catch(Exception exception)
       {
           exception.printStackTrace();
       }
   } 

   
}
