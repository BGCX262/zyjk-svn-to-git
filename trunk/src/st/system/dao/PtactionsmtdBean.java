package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtactionsmtdBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtactionsmtdBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtactionsmtdBean().findAndLockByWhere(sSqlWhere);      }       public static PtactionsmtdBean findFirst(String sSqlWhere)throws Exception {           return (PtactionsmtdBean)new PtactionsmtdBean().findFirstByWhere(sSqlWhere);      }       public static PtactionsmtdBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtactionsmtdBean)new PtactionsmtdBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtactionsmtdBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtactionsmtdBean bean = new PtactionsmtdBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtactionsmtdBean bean = new PtactionsmtdBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtactionsmtdBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtactionsmtdBean bean = new PtactionsmtdBean();           bean.setAutoRelease(isAutoRelease);           return (PtactionsmtdBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtactionsmtdBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtactionsmtdBean bean = new PtactionsmtdBean();           bean.setAutoRelease(isAutoRelease);           return (PtactionsmtdBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtactionsmtdBean bean = new PtactionsmtdBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysid; //主键 
String  actionname; //action名称 
String  namespace; //名称空间 
String  method; //方法名称 
String  actionid; //actionid 
public static final String TABLENAME ="ptactionsmtd";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtactionsmtdBean abb = new PtactionsmtdBean();
abb.sysid=rs.getString("sysid");
abb.setKeyValue("SYSID","" + abb.getSysid());
abb.actionname=rs.getString("actionname");
abb.setKeyValue("ACTIONNAME","" + abb.getActionname());
abb.namespace=rs.getString("namespace");
abb.setKeyValue("NAMESPACE","" + abb.getNamespace());
abb.method=rs.getString("method");
abb.setKeyValue("METHOD","" + abb.getMethod());
abb.actionid=rs.getString("actionid");
abb.setKeyValue("ACTIONID","" + abb.getActionid());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysid(){ if ( this.sysid == null){ return ""; } else {return this.sysid;}}public String getActionname(){ if ( this.actionname == null){ return ""; } else {return this.actionname;}}public String getNamespace(){ if ( this.namespace == null){ return ""; } else {return this.namespace;}}public String getMethod(){ if ( this.method == null){ return ""; } else {return this.method;}}public String getActionid(){ if ( this.actionid == null){ return ""; } else {return this.actionid;}}public void setSysid( String sysid){sqlMaker.setField("sysid",sysid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysid().equals(sysid))
cf.add("sysid",this.sysid,sysid);
}
this.sysid=sysid;
}
public void setActionname( String actionname){sqlMaker.setField("actionname",actionname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getActionname().equals(actionname))
cf.add("actionname",this.actionname,actionname);
}
this.actionname=actionname;
}
public void setNamespace( String namespace){sqlMaker.setField("namespace",namespace,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNamespace().equals(namespace))
cf.add("namespace",this.namespace,namespace);
}
this.namespace=namespace;
}
public void setMethod( String method){sqlMaker.setField("method",method,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMethod().equals(method))
cf.add("method",this.method,method);
}
this.method=method;
}
public void setActionid( String actionid){sqlMaker.setField("actionid",actionid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getActionid().equals(actionid))
cf.add("actionid",this.actionid,actionid);
}
this.actionid=actionid;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysid") != null) 
this.setSysid(actionRequest.getFieldValue(i, "sysid"));
if (actionRequest.getFieldValue(i, "actionname") != null) 
this.setActionname(actionRequest.getFieldValue(i, "actionname"));
if (actionRequest.getFieldValue(i, "namespace") != null) 
this.setNamespace(actionRequest.getFieldValue(i, "namespace"));
if (actionRequest.getFieldValue(i, "method") != null) 
this.setMethod(actionRequest.getFieldValue(i, "method"));
if (actionRequest.getFieldValue(i, "actionid") != null) 
this.setActionid(actionRequest.getFieldValue(i, "actionid"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtactionsmtdBean obj = (PtactionsmtdBean)super.clone();obj.setSysid(obj.sysid);
obj.setActionname(obj.actionname);
obj.setNamespace(obj.namespace);
obj.setMethod(obj.method);
obj.setActionid(obj.actionid);
return obj;}}