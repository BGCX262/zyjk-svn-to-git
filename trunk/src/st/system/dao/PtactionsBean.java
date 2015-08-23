package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtactionsBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtactionsBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtactionsBean().findAndLockByWhere(sSqlWhere);      }       public static PtactionsBean findFirst(String sSqlWhere)throws Exception {           return (PtactionsBean)new PtactionsBean().findFirstByWhere(sSqlWhere);      }       public static PtactionsBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtactionsBean)new PtactionsBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtactionsBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtactionsBean bean = new PtactionsBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtactionsBean bean = new PtactionsBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtactionsBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtactionsBean bean = new PtactionsBean();           bean.setAutoRelease(isAutoRelease);           return (PtactionsBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtactionsBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtactionsBean bean = new PtactionsBean();           bean.setAutoRelease(isAutoRelease);           return (PtactionsBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtactionsBean bean = new PtactionsBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysid; //主键 
String  actionname; //action名称 
String  actionpath; //路径 
String  actiondesc; //中文说明 
String  beanname; //对象名称 
String  infopage; //信息页面 
String  namespace; //命名空间 
public static final String TABLENAME ="ptactions";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtactionsBean abb = new PtactionsBean();
abb.sysid=rs.getString("sysid");
abb.setKeyValue("SYSID","" + abb.getSysid());
abb.actionname=rs.getString("actionname");
abb.setKeyValue("ACTIONNAME","" + abb.getActionname());
abb.actionpath=rs.getString("actionpath");
abb.setKeyValue("ACTIONPATH","" + abb.getActionpath());
abb.actiondesc=rs.getString("actiondesc");
abb.setKeyValue("ACTIONDESC","" + abb.getActiondesc());
abb.beanname=rs.getString("beanname");
abb.setKeyValue("BEANNAME","" + abb.getBeanname());
abb.infopage=rs.getString("infopage");
abb.setKeyValue("INFOPAGE","" + abb.getInfopage());
abb.namespace=rs.getString("namespace");
abb.setKeyValue("NAMESPACE","" + abb.getNamespace());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysid(){ if ( this.sysid == null){ return ""; } else {return this.sysid;}}public String getActionname(){ if ( this.actionname == null){ return ""; } else {return this.actionname;}}public String getActionpath(){ if ( this.actionpath == null){ return ""; } else {return this.actionpath;}}public String getActiondesc(){ if ( this.actiondesc == null){ return ""; } else {return this.actiondesc;}}public String getBeanname(){ if ( this.beanname == null){ return ""; } else {return this.beanname;}}public String getInfopage(){ if ( this.infopage == null){ return ""; } else {return this.infopage;}}public String getNamespace(){ if ( this.namespace == null){ return ""; } else {return this.namespace;}}public void setSysid( String sysid){sqlMaker.setField("sysid",sysid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysid().equals(sysid))
cf.add("sysid",this.sysid,sysid);
}
this.sysid=sysid;
}
public void setActionname( String actionname){sqlMaker.setField("actionname",actionname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getActionname().equals(actionname))
cf.add("actionname",this.actionname,actionname);
}
this.actionname=actionname;
}
public void setActionpath( String actionpath){sqlMaker.setField("actionpath",actionpath,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getActionpath().equals(actionpath))
cf.add("actionpath",this.actionpath,actionpath);
}
this.actionpath=actionpath;
}
public void setActiondesc( String actiondesc){sqlMaker.setField("actiondesc",actiondesc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getActiondesc().equals(actiondesc))
cf.add("actiondesc",this.actiondesc,actiondesc);
}
this.actiondesc=actiondesc;
}
public void setBeanname( String beanname){sqlMaker.setField("beanname",beanname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBeanname().equals(beanname))
cf.add("beanname",this.beanname,beanname);
}
this.beanname=beanname;
}
public void setInfopage( String infopage){sqlMaker.setField("infopage",infopage,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getInfopage().equals(infopage))
cf.add("infopage",this.infopage,infopage);
}
this.infopage=infopage;
}
public void setNamespace( String namespace){sqlMaker.setField("namespace",namespace,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNamespace().equals(namespace))
cf.add("namespace",this.namespace,namespace);
}
this.namespace=namespace;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysid") != null) 
this.setSysid(actionRequest.getFieldValue(i, "sysid"));
if (actionRequest.getFieldValue(i, "actionname") != null) 
this.setActionname(actionRequest.getFieldValue(i, "actionname"));
if (actionRequest.getFieldValue(i, "actionpath") != null) 
this.setActionpath(actionRequest.getFieldValue(i, "actionpath"));
if (actionRequest.getFieldValue(i, "actiondesc") != null) 
this.setActiondesc(actionRequest.getFieldValue(i, "actiondesc"));
if (actionRequest.getFieldValue(i, "beanname") != null) 
this.setBeanname(actionRequest.getFieldValue(i, "beanname"));
if (actionRequest.getFieldValue(i, "infopage") != null) 
this.setInfopage(actionRequest.getFieldValue(i, "infopage"));
if (actionRequest.getFieldValue(i, "namespace") != null) 
this.setNamespace(actionRequest.getFieldValue(i, "namespace"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtactionsBean obj = (PtactionsBean)super.clone();obj.setSysid(obj.sysid);
obj.setActionname(obj.actionname);
obj.setActionpath(obj.actionpath);
obj.setActiondesc(obj.actiondesc);
obj.setBeanname(obj.beanname);
obj.setInfopage(obj.infopage);
obj.setNamespace(obj.namespace);
return obj;}}