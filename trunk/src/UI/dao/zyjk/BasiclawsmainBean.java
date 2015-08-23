package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class BasiclawsmainBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new BasiclawsmainBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new BasiclawsmainBean().findAndLockByWhere(sSqlWhere);      }       public static BasiclawsmainBean findFirst(String sSqlWhere)throws Exception {           return (BasiclawsmainBean)new BasiclawsmainBean().findFirstByWhere(sSqlWhere);      }       public static BasiclawsmainBean findFirstAndLock(String sSqlWhere)throws Exception {           return (BasiclawsmainBean)new BasiclawsmainBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new BasiclawsmainBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           BasiclawsmainBean bean = new BasiclawsmainBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           BasiclawsmainBean bean = new BasiclawsmainBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static BasiclawsmainBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           BasiclawsmainBean bean = new BasiclawsmainBean();           bean.setAutoRelease(isAutoRelease);           return (BasiclawsmainBean)bean.findFirstByWhere(sSqlWhere);      }       public static BasiclawsmainBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           BasiclawsmainBean bean = new BasiclawsmainBean();           bean.setAutoRelease(isAutoRelease);           return (BasiclawsmainBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           BasiclawsmainBean bean = new BasiclawsmainBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  maintitle;
String  subtitle;
String  headcontent;
String  maincontent;
String  tailcontent;
String  lawstatus;
String  lawtp;
String  publishdeptnm;
String  throughdt;
String  effectivedt;
String  editdt;
String  lawcode;
String  lawseqno;
String  allpy;
String  simplepy;
public static final String TABLENAME ="basiclawsmain";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
BasiclawsmainBean abb = new BasiclawsmainBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.maintitle=rs.getString("maintitle");
abb.setKeyValue("MAINTITLE","" + abb.getMaintitle());
abb.subtitle=rs.getString("subtitle");
abb.setKeyValue("SUBTITLE","" + abb.getSubtitle());
abb.headcontent=rs.getString("headcontent");
abb.setKeyValue("HEADCONTENT","" + abb.getHeadcontent());
abb.maincontent=rs.getString("maincontent");
abb.setKeyValue("MAINCONTENT","" + abb.getMaincontent());
abb.tailcontent=rs.getString("tailcontent");
abb.setKeyValue("TAILCONTENT","" + abb.getTailcontent());
abb.lawstatus=rs.getString("lawstatus");
abb.setKeyValue("LAWSTATUS","" + abb.getLawstatus());
abb.lawtp=rs.getString("lawtp");
abb.setKeyValue("LAWTP","" + abb.getLawtp());
abb.publishdeptnm=rs.getString("publishdeptnm");
abb.setKeyValue("PUBLISHDEPTNM","" + abb.getPublishdeptnm());
abb.throughdt=rs.getString("throughdt");
abb.setKeyValue("THROUGHDT","" + abb.getThroughdt());
abb.effectivedt=rs.getString("effectivedt");
abb.setKeyValue("EFFECTIVEDT","" + abb.getEffectivedt());
abb.editdt=rs.getString("editdt");
abb.setKeyValue("EDITDT","" + abb.getEditdt());
abb.lawcode=rs.getString("lawcode");
abb.setKeyValue("LAWCODE","" + abb.getLawcode());
abb.lawseqno=rs.getString("lawseqno");
abb.setKeyValue("LAWSEQNO","" + abb.getLawseqno());
abb.allpy=rs.getString("allpy");
abb.setKeyValue("ALLPY","" + abb.getAllpy());
abb.simplepy=rs.getString("simplepy");
abb.setKeyValue("SIMPLEPY","" + abb.getSimplepy());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getMaintitle(){ if ( this.maintitle == null){ return ""; } else {return this.maintitle;}}public String getSubtitle(){ if ( this.subtitle == null){ return ""; } else {return this.subtitle;}}public String getHeadcontent(){ if ( this.headcontent == null){ return ""; } else {return this.headcontent;}}public String getMaincontent(){ if ( this.maincontent == null){ return ""; } else {return this.maincontent;}}public String getTailcontent(){ if ( this.tailcontent == null){ return ""; } else {return this.tailcontent;}}public String getLawstatus(){ if ( this.lawstatus == null){ return ""; } else {return this.lawstatus;}}public String getLawtp(){ if ( this.lawtp == null){ return ""; } else {return this.lawtp;}}public String getPublishdeptnm(){ if ( this.publishdeptnm == null){ return ""; } else {return this.publishdeptnm;}}public String getThroughdt(){ if ( this.throughdt == null){ return ""; } else {return this.throughdt;}}public String getEffectivedt(){ if ( this.effectivedt == null){ return ""; } else {return this.effectivedt;}}public String getEditdt(){ if ( this.editdt == null){ return ""; } else {return this.editdt;}}public String getLawcode(){ if ( this.lawcode == null){ return ""; } else {return this.lawcode;}}public String getLawseqno(){ if ( this.lawseqno == null){ return ""; } else {return this.lawseqno;}}public String getAllpy(){ if ( this.allpy == null){ return ""; } else {return this.allpy;}}public String getSimplepy(){ if ( this.simplepy == null){ return ""; } else {return this.simplepy;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setMaintitle( String maintitle){sqlMaker.setField("maintitle",maintitle,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMaintitle().equals(maintitle))
cf.add("maintitle",this.maintitle,maintitle);
}
this.maintitle=maintitle;
}
public void setSubtitle( String subtitle){sqlMaker.setField("subtitle",subtitle,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSubtitle().equals(subtitle))
cf.add("subtitle",this.subtitle,subtitle);
}
this.subtitle=subtitle;
}
public void setHeadcontent( String headcontent){sqlMaker.setField("headcontent",headcontent,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHeadcontent().equals(headcontent))
cf.add("headcontent",this.headcontent,headcontent);
}
this.headcontent=headcontent;
}
public void setMaincontent( String maincontent){sqlMaker.setField("maincontent",maincontent,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMaincontent().equals(maincontent))
cf.add("maincontent",this.maincontent,maincontent);
}
this.maincontent=maincontent;
}
public void setTailcontent( String tailcontent){sqlMaker.setField("tailcontent",tailcontent,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTailcontent().equals(tailcontent))
cf.add("tailcontent",this.tailcontent,tailcontent);
}
this.tailcontent=tailcontent;
}
public void setLawstatus( String lawstatus){sqlMaker.setField("lawstatus",lawstatus,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLawstatus().equals(lawstatus))
cf.add("lawstatus",this.lawstatus,lawstatus);
}
this.lawstatus=lawstatus;
}
public void setLawtp( String lawtp){sqlMaker.setField("lawtp",lawtp,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLawtp().equals(lawtp))
cf.add("lawtp",this.lawtp,lawtp);
}
this.lawtp=lawtp;
}
public void setPublishdeptnm( String publishdeptnm){sqlMaker.setField("publishdeptnm",publishdeptnm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPublishdeptnm().equals(publishdeptnm))
cf.add("publishdeptnm",this.publishdeptnm,publishdeptnm);
}
this.publishdeptnm=publishdeptnm;
}
public void setThroughdt( String throughdt){sqlMaker.setField("throughdt",throughdt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getThroughdt().equals(throughdt))
cf.add("throughdt",this.throughdt,throughdt);
}
this.throughdt=throughdt;
}
public void setEffectivedt( String effectivedt){sqlMaker.setField("effectivedt",effectivedt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEffectivedt().equals(effectivedt))
cf.add("effectivedt",this.effectivedt,effectivedt);
}
this.effectivedt=effectivedt;
}
public void setEditdt( String editdt){sqlMaker.setField("editdt",editdt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEditdt().equals(editdt))
cf.add("editdt",this.editdt,editdt);
}
this.editdt=editdt;
}
public void setLawcode( String lawcode){sqlMaker.setField("lawcode",lawcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLawcode().equals(lawcode))
cf.add("lawcode",this.lawcode,lawcode);
}
this.lawcode=lawcode;
}
public void setLawseqno( String lawseqno){sqlMaker.setField("lawseqno",lawseqno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLawseqno().equals(lawseqno))
cf.add("lawseqno",this.lawseqno,lawseqno);
}
this.lawseqno=lawseqno;
}
public void setAllpy( String allpy){sqlMaker.setField("allpy",allpy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getAllpy().equals(allpy))
cf.add("allpy",this.allpy,allpy);
}
this.allpy=allpy;
}
public void setSimplepy( String simplepy){sqlMaker.setField("simplepy",simplepy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSimplepy().equals(simplepy))
cf.add("simplepy",this.simplepy,simplepy);
}
this.simplepy=simplepy;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "maintitle") != null) 
this.setMaintitle(actionRequest.getFieldValue(i, "maintitle"));
if (actionRequest.getFieldValue(i, "subtitle") != null) 
this.setSubtitle(actionRequest.getFieldValue(i, "subtitle"));
if (actionRequest.getFieldValue(i, "headcontent") != null) 
this.setHeadcontent(actionRequest.getFieldValue(i, "headcontent"));
if (actionRequest.getFieldValue(i, "maincontent") != null) 
this.setMaincontent(actionRequest.getFieldValue(i, "maincontent"));
if (actionRequest.getFieldValue(i, "tailcontent") != null) 
this.setTailcontent(actionRequest.getFieldValue(i, "tailcontent"));
if (actionRequest.getFieldValue(i, "lawstatus") != null) 
this.setLawstatus(actionRequest.getFieldValue(i, "lawstatus"));
if (actionRequest.getFieldValue(i, "lawtp") != null) 
this.setLawtp(actionRequest.getFieldValue(i, "lawtp"));
if (actionRequest.getFieldValue(i, "publishdeptnm") != null) 
this.setPublishdeptnm(actionRequest.getFieldValue(i, "publishdeptnm"));
if (actionRequest.getFieldValue(i, "throughdt") != null) 
this.setThroughdt(actionRequest.getFieldValue(i, "throughdt"));
if (actionRequest.getFieldValue(i, "effectivedt") != null) 
this.setEffectivedt(actionRequest.getFieldValue(i, "effectivedt"));
if (actionRequest.getFieldValue(i, "editdt") != null) 
this.setEditdt(actionRequest.getFieldValue(i, "editdt"));
if (actionRequest.getFieldValue(i, "lawcode") != null) 
this.setLawcode(actionRequest.getFieldValue(i, "lawcode"));
if (actionRequest.getFieldValue(i, "lawseqno") != null) 
this.setLawseqno(actionRequest.getFieldValue(i, "lawseqno"));
if (actionRequest.getFieldValue(i, "allpy") != null) 
this.setAllpy(actionRequest.getFieldValue(i, "allpy"));
if (actionRequest.getFieldValue(i, "simplepy") != null) 
this.setSimplepy(actionRequest.getFieldValue(i, "simplepy"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { BasiclawsmainBean obj = (BasiclawsmainBean)super.clone();obj.setSysno(obj.sysno);
obj.setMaintitle(obj.maintitle);
obj.setSubtitle(obj.subtitle);
obj.setHeadcontent(obj.headcontent);
obj.setMaincontent(obj.maincontent);
obj.setTailcontent(obj.tailcontent);
obj.setLawstatus(obj.lawstatus);
obj.setLawtp(obj.lawtp);
obj.setPublishdeptnm(obj.publishdeptnm);
obj.setThroughdt(obj.throughdt);
obj.setEffectivedt(obj.effectivedt);
obj.setEditdt(obj.editdt);
obj.setLawcode(obj.lawcode);
obj.setLawseqno(obj.lawseqno);
obj.setAllpy(obj.allpy);
obj.setSimplepy(obj.simplepy);
return obj;}}