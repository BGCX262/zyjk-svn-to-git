package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtformlabelBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtformlabelBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtformlabelBean().findAndLockByWhere(sSqlWhere);      }       public static PtformlabelBean findFirst(String sSqlWhere)throws Exception {           return (PtformlabelBean)new PtformlabelBean().findFirstByWhere(sSqlWhere);      }       public static PtformlabelBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtformlabelBean)new PtformlabelBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtformlabelBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtformlabelBean bean = new PtformlabelBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtformlabelBean bean = new PtformlabelBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtformlabelBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtformlabelBean bean = new PtformlabelBean();           bean.setAutoRelease(isAutoRelease);           return (PtformlabelBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtformlabelBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtformlabelBean bean = new PtformlabelBean();           bean.setAutoRelease(isAutoRelease);           return (PtformlabelBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtformlabelBean bean = new PtformlabelBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysid; //主键 
String  formid; //表单id 
String  formname; //表单名称 
String  tablename; //表名称 
String  columnlength; //字段长度 
String  labelname; //标签名称 
String  labelid; //标签id 
String  labeltype; //标签类型 
String  enumnmae; //枚举名称 
String  ishidden; //是否隐藏字段 
String  labeldesc; //标签说明 
String  ladelindex; //标签排序 
String  isonly; //独占一行 
public static final String TABLENAME ="ptformlabel";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtformlabelBean abb = new PtformlabelBean();
abb.sysid=rs.getString("sysid");
abb.setKeyValue("SYSID","" + abb.getSysid());
abb.formid=rs.getString("formid");
abb.setKeyValue("FORMID","" + abb.getFormid());
abb.formname=rs.getString("formname");
abb.setKeyValue("FORMNAME","" + abb.getFormname());
abb.tablename=rs.getString("tablename");
abb.setKeyValue("TABLENAME","" + abb.getTablename());
abb.columnlength=rs.getString("columnlength");
abb.setKeyValue("COLUMNLENGTH","" + abb.getColumnlength());
abb.labelname=rs.getString("labelname");
abb.setKeyValue("LABELNAME","" + abb.getLabelname());
abb.labelid=rs.getString("labelid");
abb.setKeyValue("LABELID","" + abb.getLabelid());
abb.labeltype=rs.getString("labeltype");
abb.setKeyValue("LABELTYPE","" + abb.getLabeltype());
abb.enumnmae=rs.getString("enumnmae");
abb.setKeyValue("ENUMNMAE","" + abb.getEnumnmae());
abb.ishidden=rs.getString("ishidden");
abb.setKeyValue("ISHIDDEN","" + abb.getIshidden());
abb.labeldesc=rs.getString("labeldesc");
abb.setKeyValue("LABELDESC","" + abb.getLabeldesc());
abb.ladelindex=rs.getString("ladelindex");
abb.setKeyValue("LADELINDEX","" + abb.getLadelindex());
abb.isonly=rs.getString("isonly");
abb.setKeyValue("ISONLY","" + abb.getIsonly());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysid(){ if ( this.sysid == null){ return ""; } else {return this.sysid;}}public String getFormid(){ if ( this.formid == null){ return ""; } else {return this.formid;}}public String getFormname(){ if ( this.formname == null){ return ""; } else {return this.formname;}}public String getTablename(){ if ( this.tablename == null){ return ""; } else {return this.tablename;}}public String getColumnlength(){ if ( this.columnlength == null){ return ""; } else {return this.columnlength;}}public String getLabelname(){ if ( this.labelname == null){ return ""; } else {return this.labelname;}}public String getLabelid(){ if ( this.labelid == null){ return ""; } else {return this.labelid;}}public String getLabeltype(){ if ( this.labeltype == null){ return ""; } else {return this.labeltype;}}public String getEnumnmae(){ if ( this.enumnmae == null){ return ""; } else {return this.enumnmae;}}public String getIshidden(){ if ( this.ishidden == null){ return ""; } else {return this.ishidden;}}public String getLabeldesc(){ if ( this.labeldesc == null){ return ""; } else {return this.labeldesc;}}public String getLadelindex(){ if ( this.ladelindex == null){ return ""; } else {return this.ladelindex;}}public String getIsonly(){ if ( this.isonly == null){ return ""; } else {return this.isonly;}}public void setSysid( String sysid){sqlMaker.setField("sysid",sysid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysid().equals(sysid))
cf.add("sysid",this.sysid,sysid);
}
this.sysid=sysid;
}
public void setFormid( String formid){sqlMaker.setField("formid",formid,Field.TEXT);
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
public void setTablename( String tablename){sqlMaker.setField("tablename",tablename,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTablename().equals(tablename))
cf.add("tablename",this.tablename,tablename);
}
this.tablename=tablename;
}
public void setColumnlength( String columnlength){sqlMaker.setField("columnlength",columnlength,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumnlength().equals(columnlength))
cf.add("columnlength",this.columnlength,columnlength);
}
this.columnlength=columnlength;
}
public void setLabelname( String labelname){sqlMaker.setField("labelname",labelname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLabelname().equals(labelname))
cf.add("labelname",this.labelname,labelname);
}
this.labelname=labelname;
}
public void setLabelid( String labelid){sqlMaker.setField("labelid",labelid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLabelid().equals(labelid))
cf.add("labelid",this.labelid,labelid);
}
this.labelid=labelid;
}
public void setLabeltype( String labeltype){sqlMaker.setField("labeltype",labeltype,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLabeltype().equals(labeltype))
cf.add("labeltype",this.labeltype,labeltype);
}
this.labeltype=labeltype;
}
public void setEnumnmae( String enumnmae){sqlMaker.setField("enumnmae",enumnmae,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnumnmae().equals(enumnmae))
cf.add("enumnmae",this.enumnmae,enumnmae);
}
this.enumnmae=enumnmae;
}
public void setIshidden( String ishidden){sqlMaker.setField("ishidden",ishidden,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIshidden().equals(ishidden))
cf.add("ishidden",this.ishidden,ishidden);
}
this.ishidden=ishidden;
}
public void setLabeldesc( String labeldesc){sqlMaker.setField("labeldesc",labeldesc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLabeldesc().equals(labeldesc))
cf.add("labeldesc",this.labeldesc,labeldesc);
}
this.labeldesc=labeldesc;
}
public void setLadelindex( String ladelindex){sqlMaker.setField("ladelindex",ladelindex,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLadelindex().equals(ladelindex))
cf.add("ladelindex",this.ladelindex,ladelindex);
}
this.ladelindex=ladelindex;
}
public void setIsonly( String isonly){sqlMaker.setField("isonly",isonly,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsonly().equals(isonly))
cf.add("isonly",this.isonly,isonly);
}
this.isonly=isonly;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysid") != null) 
this.setSysid(actionRequest.getFieldValue(i, "sysid"));
if (actionRequest.getFieldValue(i, "formid") != null) 
this.setFormid(actionRequest.getFieldValue(i, "formid"));
if (actionRequest.getFieldValue(i, "formname") != null) 
this.setFormname(actionRequest.getFieldValue(i, "formname"));
if (actionRequest.getFieldValue(i, "tablename") != null) 
this.setTablename(actionRequest.getFieldValue(i, "tablename"));
if (actionRequest.getFieldValue(i, "columnlength") != null) 
this.setColumnlength(actionRequest.getFieldValue(i, "columnlength"));
if (actionRequest.getFieldValue(i, "labelname") != null) 
this.setLabelname(actionRequest.getFieldValue(i, "labelname"));
if (actionRequest.getFieldValue(i, "labelid") != null) 
this.setLabelid(actionRequest.getFieldValue(i, "labelid"));
if (actionRequest.getFieldValue(i, "labeltype") != null) 
this.setLabeltype(actionRequest.getFieldValue(i, "labeltype"));
if (actionRequest.getFieldValue(i, "enumnmae") != null) 
this.setEnumnmae(actionRequest.getFieldValue(i, "enumnmae"));
if (actionRequest.getFieldValue(i, "ishidden") != null) 
this.setIshidden(actionRequest.getFieldValue(i, "ishidden"));
if (actionRequest.getFieldValue(i, "labeldesc") != null) 
this.setLabeldesc(actionRequest.getFieldValue(i, "labeldesc"));
if (actionRequest.getFieldValue(i, "ladelindex") != null) 
this.setLadelindex(actionRequest.getFieldValue(i, "ladelindex"));
if (actionRequest.getFieldValue(i, "isonly") != null) 
this.setIsonly(actionRequest.getFieldValue(i, "isonly"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtformlabelBean obj = (PtformlabelBean)super.clone();obj.setSysid(obj.sysid);
obj.setFormid(obj.formid);
obj.setFormname(obj.formname);
obj.setTablename(obj.tablename);
obj.setColumnlength(obj.columnlength);
obj.setLabelname(obj.labelname);
obj.setLabelid(obj.labelid);
obj.setLabeltype(obj.labeltype);
obj.setEnumnmae(obj.enumnmae);
obj.setIshidden(obj.ishidden);
obj.setLabeldesc(obj.labeldesc);
obj.setLadelindex(obj.ladelindex);
obj.setIsonly(obj.isonly);
return obj;}}