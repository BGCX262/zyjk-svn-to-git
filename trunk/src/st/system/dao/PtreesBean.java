package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtreesBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtreesBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtreesBean().findAndLockByWhere(sSqlWhere);      }       public static PtreesBean findFirst(String sSqlWhere)throws Exception {           return (PtreesBean)new PtreesBean().findFirstByWhere(sSqlWhere);      }       public static PtreesBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtreesBean)new PtreesBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtreesBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtreesBean bean = new PtreesBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtreesBean bean = new PtreesBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtreesBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtreesBean bean = new PtreesBean();           bean.setAutoRelease(isAutoRelease);           return (PtreesBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtreesBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtreesBean bean = new PtreesBean();           bean.setAutoRelease(isAutoRelease);           return (PtreesBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtreesBean bean = new PtreesBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  treeid;
String  treename;
String  treedesc;
String  strsql;
String  paramid;
String  parampid;
String  paramtext;
String  isroot;
String  treepath;
public static final String TABLENAME ="ptrees";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtreesBean abb = new PtreesBean();
abb.treeid=rs.getString("treeid");
abb.setKeyValue("TREEID","" + abb.getTreeid());
abb.treename=rs.getString("treename");
abb.setKeyValue("TREENAME","" + abb.getTreename());
abb.treedesc=rs.getString("treedesc");
abb.setKeyValue("TREEDESC","" + abb.getTreedesc());
abb.strsql=rs.getString("strsql");
abb.setKeyValue("STRSQL","" + abb.getStrsql());
abb.paramid=rs.getString("paramid");
abb.setKeyValue("PARAMID","" + abb.getParamid());
abb.parampid=rs.getString("parampid");
abb.setKeyValue("PARAMPID","" + abb.getParampid());
abb.paramtext=rs.getString("paramtext");
abb.setKeyValue("PARAMTEXT","" + abb.getParamtext());
abb.isroot=rs.getString("isroot");
abb.setKeyValue("ISROOT","" + abb.getIsroot());
abb.treepath=rs.getString("treepath");
abb.setKeyValue("TREEPATH","" + abb.getTreepath());
list.add(abb);
abb.operate_mode = "edit";
}public String getTreeid(){ if ( this.treeid == null){ return ""; } else {return this.treeid;}}public String getTreename(){ if ( this.treename == null){ return ""; } else {return this.treename;}}public String getTreedesc(){ if ( this.treedesc == null){ return ""; } else {return this.treedesc;}}public String getStrsql(){ if ( this.strsql == null){ return ""; } else {return this.strsql;}}public String getParamid(){ if ( this.paramid == null){ return ""; } else {return this.paramid;}}public String getParampid(){ if ( this.parampid == null){ return ""; } else {return this.parampid;}}public String getParamtext(){ if ( this.paramtext == null){ return ""; } else {return this.paramtext;}}public String getIsroot(){ if ( this.isroot == null){ return ""; } else {return this.isroot;}}public String getTreepath(){ if ( this.treepath == null){ return ""; } else {return this.treepath;}}public void setTreeid( String treeid){sqlMaker.setField("treeid",treeid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTreeid().equals(treeid))
cf.add("treeid",this.treeid,treeid);
}
this.treeid=treeid;
}
public void setTreename( String treename){sqlMaker.setField("treename",treename,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTreename().equals(treename))
cf.add("treename",this.treename,treename);
}
this.treename=treename;
}
public void setTreedesc( String treedesc){sqlMaker.setField("treedesc",treedesc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTreedesc().equals(treedesc))
cf.add("treedesc",this.treedesc,treedesc);
}
this.treedesc=treedesc;
}
public void setStrsql( String strsql){sqlMaker.setField("strsql",strsql,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getStrsql().equals(strsql))
cf.add("strsql",this.strsql,strsql);
}
this.strsql=strsql;
}
public void setParamid( String paramid){sqlMaker.setField("paramid",paramid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParamid().equals(paramid))
cf.add("paramid",this.paramid,paramid);
}
this.paramid=paramid;
}
public void setParampid( String parampid){sqlMaker.setField("parampid",parampid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParampid().equals(parampid))
cf.add("parampid",this.parampid,parampid);
}
this.parampid=parampid;
}
public void setParamtext( String paramtext){sqlMaker.setField("paramtext",paramtext,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParamtext().equals(paramtext))
cf.add("paramtext",this.paramtext,paramtext);
}
this.paramtext=paramtext;
}
public void setIsroot( String isroot){sqlMaker.setField("isroot",isroot,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsroot().equals(isroot))
cf.add("isroot",this.isroot,isroot);
}
this.isroot=isroot;
}
public void setTreepath( String treepath){sqlMaker.setField("treepath",treepath,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTreepath().equals(treepath))
cf.add("treepath",this.treepath,treepath);
}
this.treepath=treepath;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "treeid") != null) 
this.setTreeid(actionRequest.getFieldValue(i, "treeid"));
if (actionRequest.getFieldValue(i, "treename") != null) 
this.setTreename(actionRequest.getFieldValue(i, "treename"));
if (actionRequest.getFieldValue(i, "treedesc") != null) 
this.setTreedesc(actionRequest.getFieldValue(i, "treedesc"));
if (actionRequest.getFieldValue(i, "strsql") != null) 
this.setStrsql(actionRequest.getFieldValue(i, "strsql"));
if (actionRequest.getFieldValue(i, "paramid") != null) 
this.setParamid(actionRequest.getFieldValue(i, "paramid"));
if (actionRequest.getFieldValue(i, "parampid") != null) 
this.setParampid(actionRequest.getFieldValue(i, "parampid"));
if (actionRequest.getFieldValue(i, "paramtext") != null) 
this.setParamtext(actionRequest.getFieldValue(i, "paramtext"));
if (actionRequest.getFieldValue(i, "isroot") != null) 
this.setIsroot(actionRequest.getFieldValue(i, "isroot"));
if (actionRequest.getFieldValue(i, "treepath") != null) 
this.setTreepath(actionRequest.getFieldValue(i, "treepath"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtreesBean obj = (PtreesBean)super.clone();obj.setTreeid(obj.treeid);
obj.setTreename(obj.treename);
obj.setTreedesc(obj.treedesc);
obj.setStrsql(obj.strsql);
obj.setParamid(obj.paramid);
obj.setParampid(obj.parampid);
obj.setParamtext(obj.paramtext);
obj.setIsroot(obj.isroot);
obj.setTreepath(obj.treepath);
return obj;}}