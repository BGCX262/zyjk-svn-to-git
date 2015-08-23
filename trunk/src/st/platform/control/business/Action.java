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

public class Action {
     protected RecordSet rs;
     protected SQLResponse res;
     protected ActionRequest req;
     protected DatabaseConnection dc;
     
     protected PtOperBean operator;
     private   PtdeptBean dept;

     public    LogManager logManager;

     protected String reqxml;


     static  Vector PARAM_MOTHOD = new Vector();;

     public Action() {

     }

     public int execute(ActionRequest req, SQLResponse res) {
          this.req = req;
          this.res = res;
          int result = 0;
          
          ConnectionManager cm = ConnectionManager.getInstance();
          cm.logManager = logManager;
          
          try {
              
               dc = cm.get(); 
               dc.begin();
              
               if (!req.getmethodName().trim().equals(""))
                    result = call(req.getmethodName().trim());
               else
                    result = doBusiness();

          }
          catch (SQLException ex)
            {
               result = -1;
               res.setResult(false);
               res.setType(0);
               res.setMessage(ex.getMessage());
               
               if(logManager != null)
                    logManager.setError(ex);
            } 
          catch(Exception sqle) {
             
               result = -1;
               res.setResult(false);
               res.setType(0);
               res.setMessage(sqle.getMessage());
               
               if(logManager != null)
                    logManager.setError(sqle);
               
          } finally {
               try {
                    if(result < 0) {
                         res.setResult(false);
                         dc.rollback();
                    } else {
                         dc.commit();
                    }
                    cm.release();
               } catch(Exception e) {
                    res.setResult(false);
                    res.setType(0);
                    res.setMessage(e.getMessage());
               }
               return 0;
          }
     }

     public int doBusiness()
          throws Exception {
          
          return 0;
     }
     
     
     /**
      * 根据枚举类型和类型值 返回枚举名称
      *  @param  enumType 枚举类型
      *  @param  enumName 枚举值
      *  @return  枚举名称
      */
     public String  getEnumValue(String enumType, String enumName) {
         return EnumerationType.getEnumName(enumType,enumName);
     }
     
     /**
      * 根据枚举类型和类型值 返回枚举扩展值
      *  @param  enumType 枚举类型
      *  @param  enumName 枚举值
      *  @return  枚举扩展值
      */
     public String  getEnumExtend(String enumType, String enumName) {
         return EnumerationType.getEnumExtend(enumType,enumName);
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
      * 获取人员对象
      */
     public PtOperBean getOperator() {
          return operator;
     }
     /**
      * 获取部门对象
      */
    public PtdeptBean getDept() {
        try{
            dept = (PtdeptBean)dept.findFirstByWhere("where DEPTID ='"+operator.getDeptid()+"'");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return dept;
    }
    /**
     * 向前台返回操作错误信息
     * @param message错误信息
     */
     public void setError(String message) {
         setData(false, 0, message);
     }
     /**
      * 向前台返回操作成功信息
      * @param message操作成功信息
      */
     public void setSuccess(String message) {
          setData(true, 0, message);
     }
     /**
      * 向前台返回业务ＸＭＬ数据信息
      * @param xmlStr　ＸＭＬ数据信息
      */
     public void setXml(String xmlStr) {
          setData(true, 3, xmlStr);
     }
     /**
      * 向前台返回业务操作信息
      * @param htmlStr
      */
     public void setMessage(String htmlStr) {
          setData(true, 2, htmlStr);
     }
     /**
      * 向前台返回业务记录信息
      * @param fieldName 记录字段
      * @param fieldValue记录值 
      */
     public void addFiled(String fieldName,String fieldValue) {
         this.res.addField(fieldName,fieldValue);
     }
     
     public void setRecordset(RecordSet recordset)
    {
        this.res.setRecordset(recordset);
        this.res.setResult(true);
        this.res.setType(1);
    }
        
     public void setData(boolean isSuccess, int type, String message) {
          this.res.setResult(isSuccess);
          this.res.setType(type);
          this.res.setMessage(message);
     }
         
         
     /**
      * 记录业务操作信息日志
      * @param logMsg 操作信息
      */
     public void setLogMessage(String logMsg) {
         logManager.setMessage(logMsg);
     }
     /**
      * 记录业务操作错误日志
      * @param logError操作错误信息
      */
     public void setLogError(String logError) {
         logManager.setError(logError);
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
