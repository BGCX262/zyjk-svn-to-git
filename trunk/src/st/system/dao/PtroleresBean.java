package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtroleresBean extends AbstractBasicBean implements Cloneable {
     /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static List find(String sSqlWhere) throws Exception{           return new PtroleresBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtroleresBean().findAndLockByWhere(sSqlWhere);      }       public static PtroleresBean findFirst(String sSqlWhere)throws Exception {           return (PtroleresBean)new PtroleresBean().findFirstByWhere(sSqlWhere);      }       public static PtroleresBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtroleresBean)new PtroleresBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtroleresBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtroleresBean bean = new PtroleresBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtroleresBean bean = new PtroleresBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtroleresBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtroleresBean bean = new PtroleresBean();           bean.setAutoRelease(isAutoRelease);           return (PtroleresBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtroleresBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtroleresBean bean = new PtroleresBean();           bean.setAutoRelease(isAutoRelease);           return (PtroleresBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtroleresBean bean = new PtroleresBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  resid;
String  roleid;
public static final String TABLENAME ="ptroleres";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
@SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtroleresBean abb = new PtroleresBean();
abb.resid=rs.getString("resid");
abb.setKeyValue("RESID","" + abb.getResid());
abb.roleid=rs.getString("roleid");
abb.setKeyValue("ROLEID","" + abb.getRoleid());
list.add(abb);
abb.operate_mode = "edit";
}public String getResid(){ if ( this.resid == null){ return ""; } else {return this.resid;}}public String getRoleid(){ if ( this.roleid == null){ return ""; } else {return this.roleid;}}public void setResid( String resid){sqlMaker.setField("resid",resid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getResid().equals(resid))
cf.add("resid",this.resid,resid);
}
this.resid=resid;
}
public void setRoleid( String roleid){sqlMaker.setField("roleid",roleid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRoleid().equals(roleid))
cf.add("roleid",this.roleid,roleid);
}
this.roleid=roleid;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "resid") != null) 
this.setResid(actionRequest.getFieldValue(i, "resid"));
if (actionRequest.getFieldValue(i, "roleid") != null) 
this.setRoleid(actionRequest.getFieldValue(i, "roleid"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtroleresBean obj = (PtroleresBean)super.clone();obj.setResid(obj.resid);
obj.setRoleid(obj.roleid);
return obj;}}