package st.platform.control.business;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Vector;
import st.platform.db.*;
import st.platform.control.convert.*;
import st.portal.system.dao.*;
import st.platform.common.*;
import st.platform.system.cache.*;


public class GraphAction {
     
     protected RecordSet rs;
     protected SQLResponse res;
     protected ActionRequest req;
     protected DatabaseConnection dc;
     
     protected PtOperBean operator;
         
    
     private   String   fDataSetID;
     private   DictMain dictMain;
     
     //SQL查询语句
     private String fSQLStr="";
     
     //查询条件
     private String fwhereStr="";
     
     //排序条件
     private String forderStr="";

     public  LogManager logManager;

     protected String reqxml;

     
     private    String   fgridSql     = "";
     private    String   fgraphSql    = "";
     private    String   fgraphID     = "";
    
     
     static  Vector PARAM_MOTHOD = new Vector();;

     public GraphAction() {

     }

     public int execute(ActionRequest req, SQLResponse res) {
          this.req = req;
          this.res = res;
          int result = 0;
          
          ConnectionManager cm = ConnectionManager.getInstance();
          cm.logManager = logManager;
          
          try {
              
                fDataSetID = req.getFieldValue("dictid");
                dictMain   = DictConfig.getDictMain(fDataSetID); 
                  
                fSQLStr    = req.getFieldValue("sqlStr");
                fwhereStr  = req.getFieldValue("whereStr");
                forderStr  = req.getFieldValue("orderStr");
            
                  
                if (fSQLStr.trim().equals(""))
                    fSQLStr = dictMain.getFsqlstr();
                
                if (fwhereStr.trim().equals(""))
                    fwhereStr = dictMain.getFwherestr();
                
                if (forderStr.trim().equals(""))
                    forderStr = dictMain.getForderstr();
              
                
                if(forderStr.toLowerCase().trim().lastIndexOf(" desc") > 0)
                    forderStr  = forderStr.substring(0,forderStr.length() -5);
                     
              
                fgridSql = fSQLStr + " " + fwhereStr + " " + forderStr; 
               
              
               //获取数据连结对象
               dc = cm.get();             
              
               if (!req.getmethodName().trim().equals(""))
                    result = call(req.getmethodName().trim());
               else
                    result = doBusiness();
               
               
               
               
               if (fgraphSql.trim().equals(""))
               {
                   setData(false, 0, "给 setGraphSql()图形数据走向执行语句函数");
                   return result;
               }
               
               if (fgraphID.trim().equals(""))
               {
                   setData(false, 0, "给 setGraphID()图形显示标示函数");
                   return result;
               }
               
               //System.out.println("***************************************");
               
               //System.out.println( fgraphID +"&" + fgraphSql);
               
               
                setData(true, 0, fgraphID +"&" + fgraphSql );
              
                 cm.release();
                 return result;
          }
          catch(Exception sqle)
          {
              cm.release(); 
              if(logManager != null)
                    logManager.setError(sqle);
               
              return -1;
          }
         
     }

     public int doBusiness()
          throws Exception {
          
          return 0;
     }
     
     
     /**
      * 赋值人员对象
      */
     public void setOperator(PtOperBean operator) {
          this.operator = operator;
     }
     
     /**
      * 获取数据连接对象
      */
     public DatabaseConnection getDatabaseConnection()
     {
         return dc;
     }
     
     /**
      * 获取列表执行语句
      * @return 列表执行语句
      */
     public String getGridSql()
     {
         return fgridSql;
     }
     /**
      * 图形数据走向执行语句
      * @param graphSql 数据走向执行语句
      */
     public void setGraphSql(String graphSql)
     {
         fgraphSql = graphSql;
     }
     
     /**
      * 图形显示标示 
      * @param graphID 显示标示 
      */
     public void setGraphID(String graphID)
     {
         fgraphID = graphID;
     }
     private  void setData(boolean isSuccess, int type, String message) {
          this.res.setResult(isSuccess);
          this.res.setType(type);
          this.res.setMessage(message);
     }
        
     public int call(String methodname) throws SQLException,Exception {

         Method method = null;
         try {
             method = this.getClass().getMethod(methodname, new Class[] {});
         } catch (SecurityException ex) {
             throw new Exception("方法访问权限不够：" + methodname);
         } catch (NoSuchMethodException ex) {
             throw new Exception("方法不存在：" + methodname);
         }

         Object obj = null;
         try {
             obj = method.invoke(this, PARAM_MOTHOD.toArray());

             if (obj != null) {
                 return Integer.parseInt(obj.toString());
             }

         }
         catch (InvocationTargetException ex1)
         {           
             throw new Exception(ex1.getTargetException().getMessage());
         } catch (IllegalArgumentException ex1) {
             throw new Exception("传递的方法参数不对:" + methodname);
         } catch (IllegalAccessException ex1) {
             throw new Exception("方法访问权限不够：" + methodname);
         }
         
         return 0;
     }  

}
