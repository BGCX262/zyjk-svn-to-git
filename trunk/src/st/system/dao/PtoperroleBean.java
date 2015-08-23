package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtoperroleBean extends AbstractBasicBean implements Cloneable {
     /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static List find(String sSqlWhere) throws Exception{           return new PtoperroleBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtoperroleBean().findAndLockByWhere(sSqlWhere);      }       public static PtoperroleBean findFirst(String sSqlWhere)throws Exception {           return (PtoperroleBean)new PtoperroleBean().findFirstByWhere(sSqlWhere);      }       public static PtoperroleBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtoperroleBean)new PtoperroleBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtoperroleBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtoperroleBean bean = new PtoperroleBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtoperroleBean bean = new PtoperroleBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtoperroleBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtoperroleBean bean = new PtoperroleBean();           bean.setAutoRelease(isAutoRelease);           return (PtoperroleBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtoperroleBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtoperroleBean bean = new PtoperroleBean();           bean.setAutoRelease(isAutoRelease);           return (PtoperroleBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtoperroleBean bean = new PtoperroleBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  roleid;
String  operid;
public static final String TABLENAME ="ptoperrole";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
@SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtoperroleBean abb = new PtoperroleBean();
abb.roleid=rs.getString("roleid");
abb.setKeyValue("ROLEID","" + abb.getRoleid());
abb.operid=rs.getString("operid");
abb.setKeyValue("OPERID","" + abb.getOperid());
list.add(abb);
abb.operate_mode = "edit";
}public String getRoleid(){ if ( this.roleid == null){ return ""; } else {return this.roleid;}}public String getOperid(){ if ( this.operid == null){ return ""; } else {return this.operid;}}public void setRoleid( String roleid){sqlMaker.setField("roleid",roleid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRoleid().equals(roleid))
cf.add("roleid",this.roleid,roleid);
}
this.roleid=roleid;
}
public void setOperid( String operid){sqlMaker.setField("operid",operid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOperid().equals(operid))
cf.add("operid",this.operid,operid);
}
this.operid=operid;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "roleid") != null) 
this.setRoleid(actionRequest.getFieldValue(i, "roleid"));
if (actionRequest.getFieldValue(i, "operid") != null) 
this.setOperid(actionRequest.getFieldValue(i, "operid"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtoperroleBean obj = (PtoperroleBean)super.clone();obj.setRoleid(obj.roleid);
obj.setOperid(obj.operid);
return obj;}}