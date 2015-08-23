package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtablecolumnBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtablecolumnBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtablecolumnBean().findAndLockByWhere(sSqlWhere);      }       public static PtablecolumnBean findFirst(String sSqlWhere)throws Exception {           return (PtablecolumnBean)new PtablecolumnBean().findFirstByWhere(sSqlWhere);      }       public static PtablecolumnBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtablecolumnBean)new PtablecolumnBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtablecolumnBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtablecolumnBean bean = new PtablecolumnBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtablecolumnBean bean = new PtablecolumnBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtablecolumnBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtablecolumnBean bean = new PtablecolumnBean();           bean.setAutoRelease(isAutoRelease);           return (PtablecolumnBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtablecolumnBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtablecolumnBean bean = new PtablecolumnBean();           bean.setAutoRelease(isAutoRelease);           return (PtablecolumnBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtablecolumnBean bean = new PtablecolumnBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  columnid; //主键 
String  tableid; //表id 
String  tablename; //表名称 
String  columnname; //字段名称 
String  columndesc; //字段中文名称 
String  columnlength; //字段长度 
String  columntype; //字段类型 
String  iskey; //是否主键 
String  isnulls; //是否为空 
String  isdefault; //默认内容 
public static final String TABLENAME ="ptablecolumn";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtablecolumnBean abb = new PtablecolumnBean();
abb.columnid=rs.getString("columnid");
abb.setKeyValue("COLUMNID","" + abb.getColumnid());
abb.tableid=rs.getString("tableid");
abb.setKeyValue("TABLEID","" + abb.getTableid());
abb.tablename=rs.getString("tablename");
abb.setKeyValue("TABLENAME","" + abb.getTablename());
abb.columnname=rs.getString("columnname");
abb.setKeyValue("COLUMNNAME","" + abb.getColumnname());
abb.columndesc=rs.getString("columndesc");
abb.setKeyValue("COLUMNDESC","" + abb.getColumndesc());
abb.columnlength=rs.getString("columnlength");
abb.setKeyValue("COLUMNLENGTH","" + abb.getColumnlength());
abb.columntype=rs.getString("columntype");
abb.setKeyValue("COLUMNTYPE","" + abb.getColumntype());
abb.iskey=rs.getString("iskey");
abb.setKeyValue("ISKEY","" + abb.getIskey());
abb.isnulls=rs.getString("isnulls");
abb.setKeyValue("ISNULLS","" + abb.getIsnulls());
abb.isdefault=rs.getString("isdefault");
abb.setKeyValue("ISDEFAULT","" + abb.getIsdefault());
list.add(abb);
abb.operate_mode = "edit";
}public String getColumnid(){ if ( this.columnid == null){ return ""; } else {return this.columnid;}}public String getTableid(){ if ( this.tableid == null){ return ""; } else {return this.tableid;}}public String getTablename(){ if ( this.tablename == null){ return ""; } else {return this.tablename;}}public String getColumnname(){ if ( this.columnname == null){ return ""; } else {return this.columnname;}}public String getColumndesc(){ if ( this.columndesc == null){ return ""; } else {return this.columndesc;}}public String getColumnlength(){ if ( this.columnlength == null){ return ""; } else {return this.columnlength;}}public String getColumntype(){ if ( this.columntype == null){ return ""; } else {return this.columntype;}}public String getIskey(){ if ( this.iskey == null){ return ""; } else {return this.iskey;}}public String getIsnulls(){ if ( this.isnulls == null){ return ""; } else {return this.isnulls;}}public String getIsdefault(){ if ( this.isdefault == null){ return ""; } else {return this.isdefault;}}public void setColumnid( String columnid){sqlMaker.setField("columnid",columnid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumnid().equals(columnid))
cf.add("columnid",this.columnid,columnid);
}
this.columnid=columnid;
}
public void setTableid( String tableid){sqlMaker.setField("tableid",tableid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTableid().equals(tableid))
cf.add("tableid",this.tableid,tableid);
}
this.tableid=tableid;
}
public void setTablename( String tablename){sqlMaker.setField("tablename",tablename,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTablename().equals(tablename))
cf.add("tablename",this.tablename,tablename);
}
this.tablename=tablename;
}
public void setColumnname( String columnname){sqlMaker.setField("columnname",columnname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumnname().equals(columnname))
cf.add("columnname",this.columnname,columnname);
}
this.columnname=columnname;
}
public void setColumndesc( String columndesc){sqlMaker.setField("columndesc",columndesc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumndesc().equals(columndesc))
cf.add("columndesc",this.columndesc,columndesc);
}
this.columndesc=columndesc;
}
public void setColumnlength( String columnlength){sqlMaker.setField("columnlength",columnlength,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumnlength().equals(columnlength))
cf.add("columnlength",this.columnlength,columnlength);
}
this.columnlength=columnlength;
}
public void setColumntype( String columntype){sqlMaker.setField("columntype",columntype,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumntype().equals(columntype))
cf.add("columntype",this.columntype,columntype);
}
this.columntype=columntype;
}
public void setIskey( String iskey){sqlMaker.setField("iskey",iskey,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIskey().equals(iskey))
cf.add("iskey",this.iskey,iskey);
}
this.iskey=iskey;
}
public void setIsnulls( String isnulls){sqlMaker.setField("isnulls",isnulls,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsnulls().equals(isnulls))
cf.add("isnulls",this.isnulls,isnulls);
}
this.isnulls=isnulls;
}
public void setIsdefault( String isdefault){sqlMaker.setField("isdefault",isdefault,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsdefault().equals(isdefault))
cf.add("isdefault",this.isdefault,isdefault);
}
this.isdefault=isdefault;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "columnid") != null) 
this.setColumnid(actionRequest.getFieldValue(i, "columnid"));
if (actionRequest.getFieldValue(i, "tableid") != null) 
this.setTableid(actionRequest.getFieldValue(i, "tableid"));
if (actionRequest.getFieldValue(i, "tablename") != null) 
this.setTablename(actionRequest.getFieldValue(i, "tablename"));
if (actionRequest.getFieldValue(i, "columnname") != null) 
this.setColumnname(actionRequest.getFieldValue(i, "columnname"));
if (actionRequest.getFieldValue(i, "columndesc") != null) 
this.setColumndesc(actionRequest.getFieldValue(i, "columndesc"));
if (actionRequest.getFieldValue(i, "columnlength") != null) 
this.setColumnlength(actionRequest.getFieldValue(i, "columnlength"));
if (actionRequest.getFieldValue(i, "columntype") != null) 
this.setColumntype(actionRequest.getFieldValue(i, "columntype"));
if (actionRequest.getFieldValue(i, "iskey") != null) 
this.setIskey(actionRequest.getFieldValue(i, "iskey"));
if (actionRequest.getFieldValue(i, "isnulls") != null) 
this.setIsnulls(actionRequest.getFieldValue(i, "isnulls"));
if (actionRequest.getFieldValue(i, "isdefault") != null) 
this.setIsdefault(actionRequest.getFieldValue(i, "isdefault"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtablecolumnBean obj = (PtablecolumnBean)super.clone();obj.setColumnid(obj.columnid);
obj.setTableid(obj.tableid);
obj.setTablename(obj.tablename);
obj.setColumnname(obj.columnname);
obj.setColumndesc(obj.columndesc);
obj.setColumnlength(obj.columnlength);
obj.setColumntype(obj.columntype);
obj.setIskey(obj.iskey);
obj.setIsnulls(obj.isnulls);
obj.setIsdefault(obj.isdefault);
return obj;}}