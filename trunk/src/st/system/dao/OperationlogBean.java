package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class OperationlogBean extends AbstractBasicBean implements Cloneable {
     /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static List find(String sSqlWhere) throws Exception{           return new OperationlogBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new OperationlogBean().findAndLockByWhere(sSqlWhere);      }       public static OperationlogBean findFirst(String sSqlWhere)throws Exception {           return (OperationlogBean)new OperationlogBean().findFirstByWhere(sSqlWhere);      }       public static OperationlogBean findFirstAndLock(String sSqlWhere)throws Exception {           return (OperationlogBean)new OperationlogBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new OperationlogBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           OperationlogBean bean = new OperationlogBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           OperationlogBean bean = new OperationlogBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static OperationlogBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           OperationlogBean bean = new OperationlogBean();           bean.setAutoRelease(isAutoRelease);           return (OperationlogBean)bean.findFirstByWhere(sSqlWhere);      }       public static OperationlogBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           OperationlogBean bean = new OperationlogBean();           bean.setAutoRelease(isAutoRelease);           return (OperationlogBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           OperationlogBean bean = new OperationlogBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  bussinessmain;
String  bussinesssub;
String  operation;
String  sqlscript;
String  result;
String  errorinfo;
String  ip;
String  idcard;
String  filldate;
public static final String TABLENAME ="operationlog";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
@SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
OperationlogBean abb = new OperationlogBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.bussinessmain=rs.getString("bussinessmain");
abb.setKeyValue("BUSSINESSMAIN","" + abb.getBussinessmain());
abb.bussinesssub=rs.getString("bussinesssub");
abb.setKeyValue("BUSSINESSSUB","" + abb.getBussinesssub());
abb.operation=rs.getString("operation");
abb.setKeyValue("OPERATION","" + abb.getOperation());
abb.sqlscript=rs.getString("sqlscript");
abb.setKeyValue("SQLSCRIPT","" + abb.getSqlscript());
abb.result=rs.getString("result");
abb.setKeyValue("RESULT","" + abb.getResult());
abb.errorinfo=rs.getString("errorinfo");
abb.setKeyValue("ERRORINFO","" + abb.getErrorinfo());
abb.ip=rs.getString("ip");
abb.setKeyValue("IP","" + abb.getIp());
abb.idcard=rs.getString("idcard");
abb.setKeyValue("IDCARD","" + abb.getIdcard());
abb.filldate=rs.getString("filldate");
abb.setKeyValue("FILLDATE","" + abb.getFilldate());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getBussinessmain(){ if ( this.bussinessmain == null){ return ""; } else {return this.bussinessmain;}}public String getBussinesssub(){ if ( this.bussinesssub == null){ return ""; } else {return this.bussinesssub;}}public String getOperation(){ if ( this.operation == null){ return ""; } else {return this.operation;}}public String getSqlscript(){ if ( this.sqlscript == null){ return ""; } else {return this.sqlscript;}}public String getResult(){ if ( this.result == null){ return ""; } else {return this.result;}}public String getErrorinfo(){ if ( this.errorinfo == null){ return ""; } else {return this.errorinfo;}}public String getIp(){ if ( this.ip == null){ return ""; } else {return this.ip;}}public String getIdcard(){ if ( this.idcard == null){ return ""; } else {return this.idcard;}}public String getFilldate(){ if ( this.filldate == null){ return ""; } else {return this.filldate;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setBussinessmain( String bussinessmain){sqlMaker.setField("bussinessmain",bussinessmain,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBussinessmain().equals(bussinessmain))
cf.add("bussinessmain",this.bussinessmain,bussinessmain);
}
this.bussinessmain=bussinessmain;
}
public void setBussinesssub( String bussinesssub){sqlMaker.setField("bussinesssub",bussinesssub,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBussinesssub().equals(bussinesssub))
cf.add("bussinesssub",this.bussinesssub,bussinesssub);
}
this.bussinesssub=bussinesssub;
}
public void setOperation( String operation){sqlMaker.setField("operation",operation,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOperation().equals(operation))
cf.add("operation",this.operation,operation);
}
this.operation=operation;
}
public void setSqlscript( String sqlscript){sqlMaker.setField("sqlscript",sqlscript,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSqlscript().equals(sqlscript))
cf.add("sqlscript",this.sqlscript,sqlscript);
}
this.sqlscript=sqlscript;
}
public void setResult( String result){sqlMaker.setField("result",result,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getResult().equals(result))
cf.add("result",this.result,result);
}
this.result=result;
}
public void setErrorinfo( String errorinfo){sqlMaker.setField("errorinfo",errorinfo,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getErrorinfo().equals(errorinfo))
cf.add("errorinfo",this.errorinfo,errorinfo);
}
this.errorinfo=errorinfo;
}
public void setIp( String ip){sqlMaker.setField("ip",ip,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIp().equals(ip))
cf.add("ip",this.ip,ip);
}
this.ip=ip;
}
public void setIdcard( String idcard){sqlMaker.setField("idcard",idcard,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIdcard().equals(idcard))
cf.add("idcard",this.idcard,idcard);
}
this.idcard=idcard;
}
public void setFilldate( String filldate){sqlMaker.setField("filldate",filldate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFilldate().equals(filldate))
cf.add("filldate",this.filldate,filldate);
}
this.filldate=filldate;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "bussinessmain") != null) 
this.setBussinessmain(actionRequest.getFieldValue(i, "bussinessmain"));
if (actionRequest.getFieldValue(i, "bussinesssub") != null) 
this.setBussinesssub(actionRequest.getFieldValue(i, "bussinesssub"));
if (actionRequest.getFieldValue(i, "operation") != null) 
this.setOperation(actionRequest.getFieldValue(i, "operation"));
if (actionRequest.getFieldValue(i, "sqlscript") != null) 
this.setSqlscript(actionRequest.getFieldValue(i, "sqlscript"));
if (actionRequest.getFieldValue(i, "result") != null) 
this.setResult(actionRequest.getFieldValue(i, "result"));
if (actionRequest.getFieldValue(i, "errorinfo") != null) 
this.setErrorinfo(actionRequest.getFieldValue(i, "errorinfo"));
if (actionRequest.getFieldValue(i, "ip") != null) 
this.setIp(actionRequest.getFieldValue(i, "ip"));
if (actionRequest.getFieldValue(i, "idcard") != null) 
this.setIdcard(actionRequest.getFieldValue(i, "idcard"));
if (actionRequest.getFieldValue(i, "filldate") != null) 
this.setFilldate(actionRequest.getFieldValue(i, "filldate"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { OperationlogBean obj = (OperationlogBean)super.clone();obj.setSysno(obj.sysno);
obj.setBussinessmain(obj.bussinessmain);
obj.setBussinesssub(obj.bussinesssub);
obj.setOperation(obj.operation);
obj.setSqlscript(obj.sqlscript);
obj.setResult(obj.result);
obj.setErrorinfo(obj.errorinfo);
obj.setIp(obj.ip);
obj.setIdcard(obj.idcard);
obj.setFilldate(obj.filldate);
return obj;}}