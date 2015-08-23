package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtformBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtformBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtformBean().findAndLockByWhere(sSqlWhere);      }       public static PtformBean findFirst(String sSqlWhere)throws Exception {           return (PtformBean)new PtformBean().findFirstByWhere(sSqlWhere);      }       public static PtformBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtformBean)new PtformBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtformBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtformBean bean = new PtformBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtformBean bean = new PtformBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtformBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtformBean bean = new PtformBean();           bean.setAutoRelease(isAutoRelease);           return (PtformBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtformBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtformBean bean = new PtformBean();           bean.setAutoRelease(isAutoRelease);           return (PtformBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtformBean bean = new PtformBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  formid; //主键 
String  formname; //表单名称 
String  formpath; //表单路径 
String  actionname; //action名称 
public static final String TABLENAME ="ptform";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtformBean abb = new PtformBean();
abb.formid=rs.getString("formid");
abb.setKeyValue("FORMID","" + abb.getFormid());
abb.formname=rs.getString("formname");
abb.setKeyValue("FORMNAME","" + abb.getFormname());
abb.formpath=rs.getString("formpath");
abb.setKeyValue("FORMPATH","" + abb.getFormpath());
abb.actionname=rs.getString("actionname");
abb.setKeyValue("ACTIONNAME","" + abb.getActionname());
list.add(abb);
abb.operate_mode = "edit";
}public String getFormid(){ if ( this.formid == null){ return ""; } else {return this.formid;}}public String getFormname(){ if ( this.formname == null){ return ""; } else {return this.formname;}}public String getFormpath(){ if ( this.formpath == null){ return ""; } else {return this.formpath;}}public String getActionname(){ if ( this.actionname == null){ return ""; } else {return this.actionname;}}public void setFormid( String formid){sqlMaker.setField("formid",formid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFormid().equals(formid))
cf.add("formid",this.formid,formid);
}
this.formid=formid;
}
public void setFormname( String formname){sqlMaker.setField("formname",formname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFormname().equals(formname))
cf.add("formname",this.formname,formname);
}
this.formname=formname;
}
public void setFormpath( String formpath){sqlMaker.setField("formpath",formpath,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFormpath().equals(formpath))
cf.add("formpath",this.formpath,formpath);
}
this.formpath=formpath;
}
public void setActionname( String actionname){sqlMaker.setField("actionname",actionname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getActionname().equals(actionname))
cf.add("actionname",this.actionname,actionname);
}
this.actionname=actionname;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "formid") != null) 
this.setFormid(actionRequest.getFieldValue(i, "formid"));
if (actionRequest.getFieldValue(i, "formname") != null) 
this.setFormname(actionRequest.getFieldValue(i, "formname"));
if (actionRequest.getFieldValue(i, "formpath") != null) 
this.setFormpath(actionRequest.getFieldValue(i, "formpath"));
if (actionRequest.getFieldValue(i, "actionname") != null) 
this.setActionname(actionRequest.getFieldValue(i, "actionname"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtformBean obj = (PtformBean)super.clone();obj.setFormid(obj.formid);
obj.setFormname(obj.formname);
obj.setFormpath(obj.formpath);
obj.setActionname(obj.actionname);
return obj;}}