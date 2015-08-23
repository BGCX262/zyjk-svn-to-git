package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtgridscolumnBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtgridscolumnBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtgridscolumnBean().findAndLockByWhere(sSqlWhere);      }       public static PtgridscolumnBean findFirst(String sSqlWhere)throws Exception {           return (PtgridscolumnBean)new PtgridscolumnBean().findFirstByWhere(sSqlWhere);      }       public static PtgridscolumnBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtgridscolumnBean)new PtgridscolumnBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtgridscolumnBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtgridscolumnBean bean = new PtgridscolumnBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtgridscolumnBean bean = new PtgridscolumnBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtgridscolumnBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtgridscolumnBean bean = new PtgridscolumnBean();           bean.setAutoRelease(isAutoRelease);           return (PtgridscolumnBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtgridscolumnBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtgridscolumnBean bean = new PtgridscolumnBean();           bean.setAutoRelease(isAutoRelease);           return (PtgridscolumnBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtgridscolumnBean bean = new PtgridscolumnBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysid;
String  gridname;
String  tablename;
String  columnname;
String  columndesc;
String  columntype;
String  columnlength;
String  columnhide;
String  columnwidth;
String  columnstate;
String  columnmenu;
String  columnalign;
String  isfind;
String  dispno;
public static final String TABLENAME ="ptgridscolumn";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtgridscolumnBean abb = new PtgridscolumnBean();
abb.sysid=rs.getString("sysid");
abb.setKeyValue("SYSID","" + abb.getSysid());
abb.gridname=rs.getString("gridname");
abb.setKeyValue("GRIDNAME","" + abb.getGridname());
abb.tablename=rs.getString("tablename");
abb.setKeyValue("TABLENAME","" + abb.getTablename());
abb.columnname=rs.getString("columnname");
abb.setKeyValue("COLUMNNAME","" + abb.getColumnname());
abb.columndesc=rs.getString("columndesc");
abb.setKeyValue("COLUMNDESC","" + abb.getColumndesc());
abb.columntype=rs.getString("columntype");
abb.setKeyValue("COLUMNTYPE","" + abb.getColumntype());
abb.columnlength=rs.getString("columnlength");
abb.setKeyValue("COLUMNLENGTH","" + abb.getColumnlength());
abb.columnhide=rs.getString("columnhide");
abb.setKeyValue("COLUMNHIDE","" + abb.getColumnhide());
abb.columnwidth=rs.getString("columnwidth");
abb.setKeyValue("COLUMNWIDTH","" + abb.getColumnwidth());
abb.columnstate=rs.getString("columnstate");
abb.setKeyValue("COLUMNSTATE","" + abb.getColumnstate());
abb.columnmenu=rs.getString("columnmenu");
abb.setKeyValue("COLUMNMENU","" + abb.getColumnmenu());
abb.columnalign=rs.getString("columnalign");
abb.setKeyValue("COLUMNALIGN","" + abb.getColumnalign());
abb.isfind=rs.getString("isfind");
abb.setKeyValue("ISFIND","" + abb.getIsfind());
abb.dispno=rs.getString("dispno");
abb.setKeyValue("DISPNO","" + abb.getDispno());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysid(){ if ( this.sysid == null){ return ""; } else {return this.sysid;}}public String getGridname(){ if ( this.gridname == null){ return ""; } else {return this.gridname;}}public String getTablename(){ if ( this.tablename == null){ return ""; } else {return this.tablename;}}public String getColumnname(){ if ( this.columnname == null){ return ""; } else {return this.columnname;}}public String getColumndesc(){ if ( this.columndesc == null){ return ""; } else {return this.columndesc;}}public String getColumntype(){ if ( this.columntype == null){ return ""; } else {return this.columntype;}}public String getColumnlength(){ if ( this.columnlength == null){ return ""; } else {return this.columnlength;}}public String getColumnhide(){ if ( this.columnhide == null){ return ""; } else {return this.columnhide;}}public String getColumnwidth(){ if ( this.columnwidth == null){ return ""; } else {return this.columnwidth;}}public String getColumnstate(){ if ( this.columnstate == null){ return ""; } else {return this.columnstate;}}public String getColumnmenu(){ if ( this.columnmenu == null){ return ""; } else {return this.columnmenu;}}public String getColumnalign(){ if ( this.columnalign == null){ return ""; } else {return this.columnalign;}}public String getIsfind(){ if ( this.isfind == null){ return ""; } else {return this.isfind;}}public String getDispno(){ if ( this.dispno == null){ return ""; } else {return this.dispno;}}public void setSysid( String sysid){sqlMaker.setField("sysid",sysid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysid().equals(sysid))
cf.add("sysid",this.sysid,sysid);
}
this.sysid=sysid;
}
public void setGridname( String gridname){sqlMaker.setField("gridname",gridname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGridname().equals(gridname))
cf.add("gridname",this.gridname,gridname);
}
this.gridname=gridname;
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
public void setColumntype( String columntype){sqlMaker.setField("columntype",columntype,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumntype().equals(columntype))
cf.add("columntype",this.columntype,columntype);
}
this.columntype=columntype;
}
public void setColumnlength( String columnlength){sqlMaker.setField("columnlength",columnlength,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumnlength().equals(columnlength))
cf.add("columnlength",this.columnlength,columnlength);
}
this.columnlength=columnlength;
}
public void setColumnhide( String columnhide){sqlMaker.setField("columnhide",columnhide,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumnhide().equals(columnhide))
cf.add("columnhide",this.columnhide,columnhide);
}
this.columnhide=columnhide;
}
public void setColumnwidth( String columnwidth){sqlMaker.setField("columnwidth",columnwidth,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumnwidth().equals(columnwidth))
cf.add("columnwidth",this.columnwidth,columnwidth);
}
this.columnwidth=columnwidth;
}
public void setColumnstate( String columnstate){sqlMaker.setField("columnstate",columnstate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumnstate().equals(columnstate))
cf.add("columnstate",this.columnstate,columnstate);
}
this.columnstate=columnstate;
}
public void setColumnmenu( String columnmenu){sqlMaker.setField("columnmenu",columnmenu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumnmenu().equals(columnmenu))
cf.add("columnmenu",this.columnmenu,columnmenu);
}
this.columnmenu=columnmenu;
}
public void setColumnalign( String columnalign){sqlMaker.setField("columnalign",columnalign,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getColumnalign().equals(columnalign))
cf.add("columnalign",this.columnalign,columnalign);
}
this.columnalign=columnalign;
}
public void setIsfind( String isfind){sqlMaker.setField("isfind",isfind,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsfind().equals(isfind))
cf.add("isfind",this.isfind,isfind);
}
this.isfind=isfind;
}
public void setDispno( String dispno){sqlMaker.setField("dispno",dispno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDispno().equals(dispno))
cf.add("dispno",this.dispno,dispno);
}
this.dispno=dispno;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysid") != null) 
this.setSysid(actionRequest.getFieldValue(i, "sysid"));
if (actionRequest.getFieldValue(i, "gridname") != null) 
this.setGridname(actionRequest.getFieldValue(i, "gridname"));
if (actionRequest.getFieldValue(i, "tablename") != null) 
this.setTablename(actionRequest.getFieldValue(i, "tablename"));
if (actionRequest.getFieldValue(i, "columnname") != null) 
this.setColumnname(actionRequest.getFieldValue(i, "columnname"));
if (actionRequest.getFieldValue(i, "columndesc") != null) 
this.setColumndesc(actionRequest.getFieldValue(i, "columndesc"));
if (actionRequest.getFieldValue(i, "columntype") != null) 
this.setColumntype(actionRequest.getFieldValue(i, "columntype"));
if (actionRequest.getFieldValue(i, "columnlength") != null) 
this.setColumnlength(actionRequest.getFieldValue(i, "columnlength"));
if (actionRequest.getFieldValue(i, "columnhide") != null) 
this.setColumnhide(actionRequest.getFieldValue(i, "columnhide"));
if (actionRequest.getFieldValue(i, "columnwidth") != null) 
this.setColumnwidth(actionRequest.getFieldValue(i, "columnwidth"));
if (actionRequest.getFieldValue(i, "columnstate") != null) 
this.setColumnstate(actionRequest.getFieldValue(i, "columnstate"));
if (actionRequest.getFieldValue(i, "columnmenu") != null) 
this.setColumnmenu(actionRequest.getFieldValue(i, "columnmenu"));
if (actionRequest.getFieldValue(i, "columnalign") != null) 
this.setColumnalign(actionRequest.getFieldValue(i, "columnalign"));
if (actionRequest.getFieldValue(i, "isfind") != null) 
this.setIsfind(actionRequest.getFieldValue(i, "isfind"));
if (actionRequest.getFieldValue(i, "dispno") != null) 
this.setDispno(actionRequest.getFieldValue(i, "dispno"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtgridscolumnBean obj = (PtgridscolumnBean)super.clone();obj.setSysid(obj.sysid);
obj.setGridname(obj.gridname);
obj.setTablename(obj.tablename);
obj.setColumnname(obj.columnname);
obj.setColumndesc(obj.columndesc);
obj.setColumntype(obj.columntype);
obj.setColumnlength(obj.columnlength);
obj.setColumnhide(obj.columnhide);
obj.setColumnwidth(obj.columnwidth);
obj.setColumnstate(obj.columnstate);
obj.setColumnmenu(obj.columnmenu);
obj.setColumnalign(obj.columnalign);
obj.setIsfind(obj.isfind);
obj.setDispno(obj.dispno);
return obj;}}