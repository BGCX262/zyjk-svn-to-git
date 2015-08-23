package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtroleBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtroleBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtroleBean().findAndLockByWhere(sSqlWhere);      }       public static PtroleBean findFirst(String sSqlWhere)throws Exception {           return (PtroleBean)new PtroleBean().findFirstByWhere(sSqlWhere);      }       public static PtroleBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtroleBean)new PtroleBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtroleBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtroleBean bean = new PtroleBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtroleBean bean = new PtroleBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtroleBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtroleBean bean = new PtroleBean();           bean.setAutoRelease(isAutoRelease);           return (PtroleBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtroleBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtroleBean bean = new PtroleBean();           bean.setAutoRelease(isAutoRelease);           return (PtroleBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtroleBean bean = new PtroleBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  roleid;
String  roledesc;
String  status;
String  parroleid;
String  isleaf;
String  deptid;
public static final String TABLENAME ="ptrole";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtroleBean abb = new PtroleBean();
abb.roleid=rs.getString("roleid");
abb.setKeyValue("ROLEID","" + abb.getRoleid());
abb.roledesc=rs.getString("roledesc");
abb.setKeyValue("ROLEDESC","" + abb.getRoledesc());
abb.status=rs.getString("status");
abb.setKeyValue("STATUS","" + abb.getStatus());
abb.parroleid=rs.getString("parroleid");
abb.setKeyValue("PARROLEID","" + abb.getParroleid());
abb.isleaf=rs.getString("isleaf");
abb.setKeyValue("ISLEAF","" + abb.getIsleaf());
abb.deptid=rs.getString("deptid");
abb.setKeyValue("DEPTID","" + abb.getDeptid());
list.add(abb);
abb.operate_mode = "edit";
}public String getRoleid(){ if ( this.roleid == null){ return ""; } else {return this.roleid;}}public String getRoledesc(){ if ( this.roledesc == null){ return ""; } else {return this.roledesc;}}public String getStatus(){ if ( this.status == null){ return ""; } else {return this.status;}}public String getParroleid(){ if ( this.parroleid == null){ return ""; } else {return this.parroleid;}}public String getIsleaf(){ if ( this.isleaf == null){ return ""; } else {return this.isleaf;}}public String getDeptid(){ if ( this.deptid == null){ return ""; } else {return this.deptid;}}public void setRoleid( String roleid){sqlMaker.setField("roleid",roleid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRoleid().equals(roleid))
cf.add("roleid",this.roleid,roleid);
}
this.roleid=roleid;
}
public void setRoledesc( String roledesc){sqlMaker.setField("roledesc",roledesc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRoledesc().equals(roledesc))
cf.add("roledesc",this.roledesc,roledesc);
}
this.roledesc=roledesc;
}
public void setStatus( String status){sqlMaker.setField("status",status,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getStatus().equals(status))
cf.add("status",this.status,status);
}
this.status=status;
}
public void setParroleid( String parroleid){sqlMaker.setField("parroleid",parroleid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParroleid().equals(parroleid))
cf.add("parroleid",this.parroleid,parroleid);
}
this.parroleid=parroleid;
}
public void setIsleaf( String isleaf){sqlMaker.setField("isleaf",isleaf,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsleaf().equals(isleaf))
cf.add("isleaf",this.isleaf,isleaf);
}
this.isleaf=isleaf;
}
public void setDeptid( String deptid){sqlMaker.setField("deptid",deptid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptid().equals(deptid))
cf.add("deptid",this.deptid,deptid);
}
this.deptid=deptid;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "roleid") != null) 
this.setRoleid(actionRequest.getFieldValue(i, "roleid"));
if (actionRequest.getFieldValue(i, "roledesc") != null) 
this.setRoledesc(actionRequest.getFieldValue(i, "roledesc"));
if (actionRequest.getFieldValue(i, "status") != null) 
this.setStatus(actionRequest.getFieldValue(i, "status"));
if (actionRequest.getFieldValue(i, "parroleid") != null) 
this.setParroleid(actionRequest.getFieldValue(i, "parroleid"));
if (actionRequest.getFieldValue(i, "isleaf") != null) 
this.setIsleaf(actionRequest.getFieldValue(i, "isleaf"));
if (actionRequest.getFieldValue(i, "deptid") != null) 
this.setDeptid(actionRequest.getFieldValue(i, "deptid"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtroleBean obj = (PtroleBean)super.clone();obj.setRoleid(obj.roleid);
obj.setRoledesc(obj.roledesc);
obj.setStatus(obj.status);
obj.setParroleid(obj.parroleid);
obj.setIsleaf(obj.isleaf);
obj.setDeptid(obj.deptid);
return obj;}}