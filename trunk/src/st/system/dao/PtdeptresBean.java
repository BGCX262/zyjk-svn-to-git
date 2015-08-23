package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtdeptresBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtdeptresBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtdeptresBean().findAndLockByWhere(sSqlWhere);      }       public static PtdeptresBean findFirst(String sSqlWhere)throws Exception {           return (PtdeptresBean)new PtdeptresBean().findFirstByWhere(sSqlWhere);      }       public static PtdeptresBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtdeptresBean)new PtdeptresBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtdeptresBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtdeptresBean bean = new PtdeptresBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtdeptresBean bean = new PtdeptresBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtdeptresBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtdeptresBean bean = new PtdeptresBean();           bean.setAutoRelease(isAutoRelease);           return (PtdeptresBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtdeptresBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtdeptresBean bean = new PtdeptresBean();           bean.setAutoRelease(isAutoRelease);           return (PtdeptresBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtdeptresBean bean = new PtdeptresBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  deptid;
String  resid;
public static final String TABLENAME ="ptdeptres";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtdeptresBean abb = new PtdeptresBean();
abb.deptid=rs.getString("deptid");
abb.setKeyValue("DEPTID","" + abb.getDeptid());
abb.resid=rs.getString("resid");
abb.setKeyValue("RESID","" + abb.getResid());
list.add(abb);
abb.operate_mode = "edit";
}public String getDeptid(){ if ( this.deptid == null){ return ""; } else {return this.deptid;}}public String getResid(){ if ( this.resid == null){ return ""; } else {return this.resid;}}public void setDeptid( String deptid){sqlMaker.setField("deptid",deptid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptid().equals(deptid))
cf.add("deptid",this.deptid,deptid);
}
this.deptid=deptid;
}
public void setResid( String resid){sqlMaker.setField("resid",resid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getResid().equals(resid))
cf.add("resid",this.resid,resid);
}
this.resid=resid;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "deptid") != null) 
this.setDeptid(actionRequest.getFieldValue(i, "deptid"));
if (actionRequest.getFieldValue(i, "resid") != null) 
this.setResid(actionRequest.getFieldValue(i, "resid"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtdeptresBean obj = (PtdeptresBean)super.clone();obj.setDeptid(obj.deptid);
obj.setResid(obj.resid);
return obj;}}