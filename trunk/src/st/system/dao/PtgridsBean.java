package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtgridsBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtgridsBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtgridsBean().findAndLockByWhere(sSqlWhere);      }       public static PtgridsBean findFirst(String sSqlWhere)throws Exception {           return (PtgridsBean)new PtgridsBean().findFirstByWhere(sSqlWhere);      }       public static PtgridsBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtgridsBean)new PtgridsBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtgridsBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtgridsBean bean = new PtgridsBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtgridsBean bean = new PtgridsBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtgridsBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtgridsBean bean = new PtgridsBean();           bean.setAutoRelease(isAutoRelease);           return (PtgridsBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtgridsBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtgridsBean bean = new PtgridsBean();           bean.setAutoRelease(isAutoRelease);           return (PtgridsBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtgridsBean bean = new PtgridsBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  gridid;
String  gridname;
String  griddesc;
String  sqlstr;
String  wherestr;
String  orderstr;
String  actionname;
String  treename;
String  pagesize;
String  istree;
String  fieldname;
String  fieldpath;
String  treeright;
String  dispno;
public static final String TABLENAME ="ptgrids";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtgridsBean abb = new PtgridsBean();
abb.gridid=rs.getString("gridid");
abb.setKeyValue("GRIDID","" + abb.getGridid());
abb.gridname=rs.getString("gridname");
abb.setKeyValue("GRIDNAME","" + abb.getGridname());
abb.griddesc=rs.getString("griddesc");
abb.setKeyValue("GRIDDESC","" + abb.getGriddesc());
abb.sqlstr=rs.getString("sqlstr");
abb.setKeyValue("SQLSTR","" + abb.getSqlstr());
abb.wherestr=rs.getString("wherestr");
abb.setKeyValue("WHERESTR","" + abb.getWherestr());
abb.orderstr=rs.getString("orderstr");
abb.setKeyValue("ORDERSTR","" + abb.getOrderstr());
abb.actionname=rs.getString("actionname");
abb.setKeyValue("ACTIONNAME","" + abb.getActionname());
abb.treename=rs.getString("treename");
abb.setKeyValue("TREENAME","" + abb.getTreename());
abb.pagesize=rs.getString("pagesize");
abb.setKeyValue("PAGESIZE","" + abb.getPagesize());
abb.istree=rs.getString("istree");
abb.setKeyValue("ISTREE","" + abb.getIstree());
abb.fieldname=rs.getString("fieldname");
abb.setKeyValue("FIELDNAME","" + abb.getFieldname());
abb.fieldpath=rs.getString("fieldpath");
abb.setKeyValue("FIELDPATH","" + abb.getFieldpath());
abb.treeright=rs.getString("treeright");
abb.setKeyValue("TREERIGHT","" + abb.getTreeright());
abb.dispno=rs.getString("dispno");
abb.setKeyValue("DISPNO","" + abb.getDispno());
list.add(abb);
abb.operate_mode = "edit";
}public String getGridid(){ if ( this.gridid == null){ return ""; } else {return this.gridid;}}public String getGridname(){ if ( this.gridname == null){ return ""; } else {return this.gridname;}}public String getGriddesc(){ if ( this.griddesc == null){ return ""; } else {return this.griddesc;}}public String getSqlstr(){ if ( this.sqlstr == null){ return ""; } else {return this.sqlstr;}}public String getWherestr(){ if ( this.wherestr == null){ return ""; } else {return this.wherestr;}}public String getOrderstr(){ if ( this.orderstr == null){ return ""; } else {return this.orderstr;}}public String getActionname(){ if ( this.actionname == null){ return ""; } else {return this.actionname;}}public String getTreename(){ if ( this.treename == null){ return ""; } else {return this.treename;}}public String getPagesize(){ if ( this.pagesize == null){ return ""; } else {return this.pagesize;}}public String getIstree(){ if ( this.istree == null){ return ""; } else {return this.istree;}}public String getFieldname(){ if ( this.fieldname == null){ return ""; } else {return this.fieldname;}}public String getFieldpath(){ if ( this.fieldpath == null){ return ""; } else {return this.fieldpath;}}public String getTreeright(){ if ( this.treeright == null){ return ""; } else {return this.treeright;}}public String getDispno(){ if ( this.dispno == null){ return ""; } else {return this.dispno;}}public void setGridid( String gridid){sqlMaker.setField("gridid",gridid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGridid().equals(gridid))
cf.add("gridid",this.gridid,gridid);
}
this.gridid=gridid;
}
public void setGridname( String gridname){sqlMaker.setField("gridname",gridname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGridname().equals(gridname))
cf.add("gridname",this.gridname,gridname);
}
this.gridname=gridname;
}
public void setGriddesc( String griddesc){sqlMaker.setField("griddesc",griddesc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGriddesc().equals(griddesc))
cf.add("griddesc",this.griddesc,griddesc);
}
this.griddesc=griddesc;
}
public void setSqlstr( String sqlstr){sqlMaker.setField("sqlstr",sqlstr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSqlstr().equals(sqlstr))
cf.add("sqlstr",this.sqlstr,sqlstr);
}
this.sqlstr=sqlstr;
}
public void setWherestr( String wherestr){sqlMaker.setField("wherestr",wherestr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWherestr().equals(wherestr))
cf.add("wherestr",this.wherestr,wherestr);
}
this.wherestr=wherestr;
}
public void setOrderstr( String orderstr){sqlMaker.setField("orderstr",orderstr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOrderstr().equals(orderstr))
cf.add("orderstr",this.orderstr,orderstr);
}
this.orderstr=orderstr;
}
public void setActionname( String actionname){sqlMaker.setField("actionname",actionname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getActionname().equals(actionname))
cf.add("actionname",this.actionname,actionname);
}
this.actionname=actionname;
}
public void setTreename( String treename){sqlMaker.setField("treename",treename,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTreename().equals(treename))
cf.add("treename",this.treename,treename);
}
this.treename=treename;
}
public void setPagesize( String pagesize){sqlMaker.setField("pagesize",pagesize,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPagesize().equals(pagesize))
cf.add("pagesize",this.pagesize,pagesize);
}
this.pagesize=pagesize;
}
public void setIstree( String istree){sqlMaker.setField("istree",istree,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIstree().equals(istree))
cf.add("istree",this.istree,istree);
}
this.istree=istree;
}
public void setFieldname( String fieldname){sqlMaker.setField("fieldname",fieldname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFieldname().equals(fieldname))
cf.add("fieldname",this.fieldname,fieldname);
}
this.fieldname=fieldname;
}
public void setFieldpath( String fieldpath){sqlMaker.setField("fieldpath",fieldpath,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFieldpath().equals(fieldpath))
cf.add("fieldpath",this.fieldpath,fieldpath);
}
this.fieldpath=fieldpath;
}
public void setTreeright( String treeright){sqlMaker.setField("treeright",treeright,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTreeright().equals(treeright))
cf.add("treeright",this.treeright,treeright);
}
this.treeright=treeright;
}
public void setDispno( String dispno){sqlMaker.setField("dispno",dispno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDispno().equals(dispno))
cf.add("dispno",this.dispno,dispno);
}
this.dispno=dispno;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "gridid") != null) 
this.setGridid(actionRequest.getFieldValue(i, "gridid"));
if (actionRequest.getFieldValue(i, "gridname") != null) 
this.setGridname(actionRequest.getFieldValue(i, "gridname"));
if (actionRequest.getFieldValue(i, "griddesc") != null) 
this.setGriddesc(actionRequest.getFieldValue(i, "griddesc"));
if (actionRequest.getFieldValue(i, "sqlstr") != null) 
this.setSqlstr(actionRequest.getFieldValue(i, "sqlstr"));
if (actionRequest.getFieldValue(i, "wherestr") != null) 
this.setWherestr(actionRequest.getFieldValue(i, "wherestr"));
if (actionRequest.getFieldValue(i, "orderstr") != null) 
this.setOrderstr(actionRequest.getFieldValue(i, "orderstr"));
if (actionRequest.getFieldValue(i, "actionname") != null) 
this.setActionname(actionRequest.getFieldValue(i, "actionname"));
if (actionRequest.getFieldValue(i, "treename") != null) 
this.setTreename(actionRequest.getFieldValue(i, "treename"));
if (actionRequest.getFieldValue(i, "pagesize") != null) 
this.setPagesize(actionRequest.getFieldValue(i, "pagesize"));
if (actionRequest.getFieldValue(i, "istree") != null) 
this.setIstree(actionRequest.getFieldValue(i, "istree"));
if (actionRequest.getFieldValue(i, "fieldname") != null) 
this.setFieldname(actionRequest.getFieldValue(i, "fieldname"));
if (actionRequest.getFieldValue(i, "fieldpath") != null) 
this.setFieldpath(actionRequest.getFieldValue(i, "fieldpath"));
if (actionRequest.getFieldValue(i, "treeright") != null) 
this.setTreeright(actionRequest.getFieldValue(i, "treeright"));
if (actionRequest.getFieldValue(i, "dispno") != null) 
this.setDispno(actionRequest.getFieldValue(i, "dispno"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtgridsBean obj = (PtgridsBean)super.clone();obj.setGridid(obj.gridid);
obj.setGridname(obj.gridname);
obj.setGriddesc(obj.griddesc);
obj.setSqlstr(obj.sqlstr);
obj.setWherestr(obj.wherestr);
obj.setOrderstr(obj.orderstr);
obj.setActionname(obj.actionname);
obj.setTreename(obj.treename);
obj.setPagesize(obj.pagesize);
obj.setIstree(obj.istree);
obj.setFieldname(obj.fieldname);
obj.setFieldpath(obj.fieldpath);
obj.setTreeright(obj.treeright);
obj.setDispno(obj.dispno);
return obj;}}