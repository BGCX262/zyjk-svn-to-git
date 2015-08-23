package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtableBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtableBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtableBean().findAndLockByWhere(sSqlWhere);      }       public static PtableBean findFirst(String sSqlWhere)throws Exception {           return (PtableBean)new PtableBean().findFirstByWhere(sSqlWhere);      }       public static PtableBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtableBean)new PtableBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtableBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtableBean bean = new PtableBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtableBean bean = new PtableBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtableBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtableBean bean = new PtableBean();           bean.setAutoRelease(isAutoRelease);           return (PtableBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtableBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtableBean bean = new PtableBean();           bean.setAutoRelease(isAutoRelease);           return (PtableBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtableBean bean = new PtableBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  tableid;
String  tablename;
String  tabledesc;
String  beanname;
String  beanpath;
String  strsql;
public static final String TABLENAME ="ptable";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtableBean abb = new PtableBean();
abb.tableid=rs.getString("tableid");
abb.setKeyValue("TABLEID","" + abb.getTableid());
abb.tablename=rs.getString("tablename");
abb.setKeyValue("TABLENAME","" + abb.getTablename());
abb.tabledesc=rs.getString("tabledesc");
abb.setKeyValue("TABLEDESC","" + abb.getTabledesc());
abb.beanname=rs.getString("beanname");
abb.setKeyValue("BEANNAME","" + abb.getBeanname());
abb.beanpath=rs.getString("beanpath");
abb.setKeyValue("BEANPATH","" + abb.getBeanpath());
abb.strsql=rs.getString("strsql");
abb.setKeyValue("STRSQL","" + abb.getStrsql());
list.add(abb);
abb.operate_mode = "edit";
}public String getTableid(){ if ( this.tableid == null){ return ""; } else {return this.tableid;}}public String getTablename(){ if ( this.tablename == null){ return ""; } else {return this.tablename;}}public String getTabledesc(){ if ( this.tabledesc == null){ return ""; } else {return this.tabledesc;}}public String getBeanname(){ if ( this.beanname == null){ return ""; } else {return this.beanname;}}public String getBeanpath(){ if ( this.beanpath == null){ return ""; } else {return this.beanpath;}}public String getStrsql(){ if ( this.strsql == null){ return ""; } else {return this.strsql;}}public void setTableid( String tableid){sqlMaker.setField("tableid",tableid,Field.TEXT);
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
public void setTabledesc( String tabledesc){sqlMaker.setField("tabledesc",tabledesc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTabledesc().equals(tabledesc))
cf.add("tabledesc",this.tabledesc,tabledesc);
}
this.tabledesc=tabledesc;
}
public void setBeanname( String beanname){sqlMaker.setField("beanname",beanname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBeanname().equals(beanname))
cf.add("beanname",this.beanname,beanname);
}
this.beanname=beanname;
}
public void setBeanpath( String beanpath){sqlMaker.setField("beanpath",beanpath,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBeanpath().equals(beanpath))
cf.add("beanpath",this.beanpath,beanpath);
}
this.beanpath=beanpath;
}
public void setStrsql( String strsql){sqlMaker.setField("strsql",strsql,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getStrsql().equals(strsql))
cf.add("strsql",this.strsql,strsql);
}
this.strsql=strsql;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "tableid") != null) 
this.setTableid(actionRequest.getFieldValue(i, "tableid"));
if (actionRequest.getFieldValue(i, "tablename") != null) 
this.setTablename(actionRequest.getFieldValue(i, "tablename"));
if (actionRequest.getFieldValue(i, "tabledesc") != null) 
this.setTabledesc(actionRequest.getFieldValue(i, "tabledesc"));
if (actionRequest.getFieldValue(i, "beanname") != null) 
this.setBeanname(actionRequest.getFieldValue(i, "beanname"));
if (actionRequest.getFieldValue(i, "beanpath") != null) 
this.setBeanpath(actionRequest.getFieldValue(i, "beanpath"));
if (actionRequest.getFieldValue(i, "strsql") != null) 
this.setStrsql(actionRequest.getFieldValue(i, "strsql"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtableBean obj = (PtableBean)super.clone();obj.setTableid(obj.tableid);
obj.setTablename(obj.tablename);
obj.setTabledesc(obj.tabledesc);
obj.setBeanname(obj.beanname);
obj.setBeanpath(obj.beanpath);
obj.setStrsql(obj.strsql);
return obj;}}