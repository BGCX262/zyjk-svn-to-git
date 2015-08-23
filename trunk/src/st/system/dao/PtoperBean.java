package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtoperBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtoperBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtoperBean().findAndLockByWhere(sSqlWhere);      }       public static PtoperBean findFirst(String sSqlWhere)throws Exception {           return (PtoperBean)new PtoperBean().findFirstByWhere(sSqlWhere);      }       public static PtoperBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtoperBean)new PtoperBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtoperBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtoperBean bean = new PtoperBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtoperBean bean = new PtoperBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtoperBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtoperBean bean = new PtoperBean();           bean.setAutoRelease(isAutoRelease);           return (PtoperBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtoperBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtoperBean bean = new PtoperBean();           bean.setAutoRelease(isAutoRelease);           return (PtoperBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtoperBean bean = new PtoperBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno; //系统编号 
String  operid; //人员证件号 
String  opernm; //人员姓名 
String  sex; //性别 
String  nation; //国籍 
String  birthday; //生日 
String  deptid; //部门编号 
String  indt; //调入日期 1
String  duty; //职务 
String  edudegree; //教育程度 
String  telno; //座机 
String  mobileno; //手机 
String  email; //电子邮箱 
String  passwd; //密码 
String  resume; //简历 
String  memo; //备注 
String  opersta; //操作状态 
String  issuper;
public static final String TABLENAME ="ptoper";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtoperBean abb = new PtoperBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.operid=rs.getString("operid");
abb.setKeyValue("OPERID","" + abb.getOperid());
abb.opernm=rs.getString("opernm");
abb.setKeyValue("OPERNM","" + abb.getOpernm());
abb.sex=rs.getString("sex");
abb.setKeyValue("SEX","" + abb.getSex());
abb.nation=rs.getString("nation");
abb.setKeyValue("NATION","" + abb.getNation());
abb.birthday=rs.getString("birthday");
abb.setKeyValue("BIRTHDAY","" + abb.getBirthday());
abb.deptid=rs.getString("deptid");
abb.setKeyValue("DEPTID","" + abb.getDeptid());
abb.indt=rs.getString("indt");
abb.setKeyValue("INDT","" + abb.getIndt());
abb.duty=rs.getString("duty");
abb.setKeyValue("DUTY","" + abb.getDuty());
abb.edudegree=rs.getString("edudegree");
abb.setKeyValue("EDUDEGREE","" + abb.getEdudegree());
abb.telno=rs.getString("telno");
abb.setKeyValue("TELNO","" + abb.getTelno());
abb.mobileno=rs.getString("mobileno");
abb.setKeyValue("MOBILENO","" + abb.getMobileno());
abb.email=rs.getString("email");
abb.setKeyValue("EMAIL","" + abb.getEmail());
abb.passwd=rs.getString("passwd");
abb.setKeyValue("PASSWD","" + abb.getPasswd());
abb.resume=rs.getString("resume");
abb.setKeyValue("RESUME","" + abb.getResume());
abb.memo=rs.getString("memo");
abb.setKeyValue("MEMO","" + abb.getMemo());
abb.opersta=rs.getString("opersta");
abb.setKeyValue("OPERSTA","" + abb.getOpersta());
abb.issuper=rs.getString("issuper");
abb.setKeyValue("ISSUPER","" + abb.getIssuper());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getOperid(){ if ( this.operid == null){ return ""; } else {return this.operid;}}public String getOpernm(){ if ( this.opernm == null){ return ""; } else {return this.opernm;}}public String getSex(){ if ( this.sex == null){ return ""; } else {return this.sex;}}public String getNation(){ if ( this.nation == null){ return ""; } else {return this.nation;}}public String getBirthday(){ if ( this.birthday == null){ return ""; } else {return this.birthday;}}public String getDeptid(){ if ( this.deptid == null){ return ""; } else {return this.deptid;}}public String getIndt(){ if ( this.indt == null){ return ""; } else {return this.indt;}}public String getDuty(){ if ( this.duty == null){ return ""; } else {return this.duty;}}public String getEdudegree(){ if ( this.edudegree == null){ return ""; } else {return this.edudegree;}}public String getTelno(){ if ( this.telno == null){ return ""; } else {return this.telno;}}public String getMobileno(){ if ( this.mobileno == null){ return ""; } else {return this.mobileno;}}public String getEmail(){ if ( this.email == null){ return ""; } else {return this.email;}}public String getPasswd(){ if ( this.passwd == null){ return ""; } else {return this.passwd;}}public String getResume(){ if ( this.resume == null){ return ""; } else {return this.resume;}}public String getMemo(){ if ( this.memo == null){ return ""; } else {return this.memo;}}public String getOpersta(){ if ( this.opersta == null){ return ""; } else {return this.opersta;}}public String getIssuper(){ if ( this.issuper == null){ return ""; } else {return this.issuper;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setOperid( String operid){sqlMaker.setField("operid",operid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOperid().equals(operid))
cf.add("operid",this.operid,operid);
}
this.operid=operid;
}
public void setOpernm( String opernm){sqlMaker.setField("opernm",opernm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOpernm().equals(opernm))
cf.add("opernm",this.opernm,opernm);
}
this.opernm=opernm;
}
public void setSex( String sex){sqlMaker.setField("sex",sex,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSex().equals(sex))
cf.add("sex",this.sex,sex);
}
this.sex=sex;
}
public void setNation( String nation){sqlMaker.setField("nation",nation,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNation().equals(nation))
cf.add("nation",this.nation,nation);
}
this.nation=nation;
}
public void setBirthday( String birthday){sqlMaker.setField("birthday",birthday,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBirthday().equals(birthday))
cf.add("birthday",this.birthday,birthday);
}
this.birthday=birthday;
}
public void setDeptid( String deptid){sqlMaker.setField("deptid",deptid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptid().equals(deptid))
cf.add("deptid",this.deptid,deptid);
}
this.deptid=deptid;
}
public void setIndt( String indt){sqlMaker.setField("indt",indt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIndt().equals(indt))
cf.add("indt",this.indt,indt);
}
this.indt=indt;
}
public void setDuty( String duty){sqlMaker.setField("duty",duty,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDuty().equals(duty))
cf.add("duty",this.duty,duty);
}
this.duty=duty;
}
public void setEdudegree( String edudegree){sqlMaker.setField("edudegree",edudegree,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEdudegree().equals(edudegree))
cf.add("edudegree",this.edudegree,edudegree);
}
this.edudegree=edudegree;
}
public void setTelno( String telno){sqlMaker.setField("telno",telno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTelno().equals(telno))
cf.add("telno",this.telno,telno);
}
this.telno=telno;
}
public void setMobileno( String mobileno){sqlMaker.setField("mobileno",mobileno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMobileno().equals(mobileno))
cf.add("mobileno",this.mobileno,mobileno);
}
this.mobileno=mobileno;
}
public void setEmail( String email){sqlMaker.setField("email",email,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEmail().equals(email))
cf.add("email",this.email,email);
}
this.email=email;
}
public void setPasswd( String passwd){sqlMaker.setField("passwd",passwd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPasswd().equals(passwd))
cf.add("passwd",this.passwd,passwd);
}
this.passwd=passwd;
}
public void setResume( String resume){sqlMaker.setField("resume",resume,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getResume().equals(resume))
cf.add("resume",this.resume,resume);
}
this.resume=resume;
}
public void setMemo( String memo){sqlMaker.setField("memo",memo,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMemo().equals(memo))
cf.add("memo",this.memo,memo);
}
this.memo=memo;
}
public void setOpersta( String opersta){sqlMaker.setField("opersta",opersta,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOpersta().equals(opersta))
cf.add("opersta",this.opersta,opersta);
}
this.opersta=opersta;
}
public void setIssuper( String issuper){sqlMaker.setField("issuper",issuper,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIssuper().equals(issuper))
cf.add("issuper",this.issuper,issuper);
}
this.issuper=issuper;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "operid") != null) 
this.setOperid(actionRequest.getFieldValue(i, "operid"));
if (actionRequest.getFieldValue(i, "opernm") != null) 
this.setOpernm(actionRequest.getFieldValue(i, "opernm"));
if (actionRequest.getFieldValue(i, "sex") != null) 
this.setSex(actionRequest.getFieldValue(i, "sex"));
if (actionRequest.getFieldValue(i, "nation") != null) 
this.setNation(actionRequest.getFieldValue(i, "nation"));
if (actionRequest.getFieldValue(i, "birthday") != null) 
this.setBirthday(actionRequest.getFieldValue(i, "birthday"));
if (actionRequest.getFieldValue(i, "deptid") != null) 
this.setDeptid(actionRequest.getFieldValue(i, "deptid"));
if (actionRequest.getFieldValue(i, "indt") != null) 
this.setIndt(actionRequest.getFieldValue(i, "indt"));
if (actionRequest.getFieldValue(i, "duty") != null) 
this.setDuty(actionRequest.getFieldValue(i, "duty"));
if (actionRequest.getFieldValue(i, "edudegree") != null) 
this.setEdudegree(actionRequest.getFieldValue(i, "edudegree"));
if (actionRequest.getFieldValue(i, "telno") != null) 
this.setTelno(actionRequest.getFieldValue(i, "telno"));
if (actionRequest.getFieldValue(i, "mobileno") != null) 
this.setMobileno(actionRequest.getFieldValue(i, "mobileno"));
if (actionRequest.getFieldValue(i, "email") != null) 
this.setEmail(actionRequest.getFieldValue(i, "email"));
if (actionRequest.getFieldValue(i, "passwd") != null) 
this.setPasswd(actionRequest.getFieldValue(i, "passwd"));
if (actionRequest.getFieldValue(i, "resume") != null) 
this.setResume(actionRequest.getFieldValue(i, "resume"));
if (actionRequest.getFieldValue(i, "memo") != null) 
this.setMemo(actionRequest.getFieldValue(i, "memo"));
if (actionRequest.getFieldValue(i, "opersta") != null) 
this.setOpersta(actionRequest.getFieldValue(i, "opersta"));
if (actionRequest.getFieldValue(i, "issuper") != null) 
this.setIssuper(actionRequest.getFieldValue(i, "issuper"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtoperBean obj = (PtoperBean)super.clone();obj.setSysno(obj.sysno);
obj.setOperid(obj.operid);
obj.setOpernm(obj.opernm);
obj.setSex(obj.sex);
obj.setNation(obj.nation);
obj.setBirthday(obj.birthday);
obj.setDeptid(obj.deptid);
obj.setIndt(obj.indt);
obj.setDuty(obj.duty);
obj.setEdudegree(obj.edudegree);
obj.setTelno(obj.telno);
obj.setMobileno(obj.mobileno);
obj.setEmail(obj.email);
obj.setPasswd(obj.passwd);
obj.setResume(obj.resume);
obj.setMemo(obj.memo);
obj.setOpersta(obj.opersta);
obj.setIssuper(obj.issuper);
return obj;}}