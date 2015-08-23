package worksynch.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class SynchrecordBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new SynchrecordBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new SynchrecordBean().findAndLockByWhere(sSqlWhere);      }       public static SynchrecordBean findFirst(String sSqlWhere)throws Exception {           return (SynchrecordBean)new SynchrecordBean().findFirstByWhere(sSqlWhere);      }       public static SynchrecordBean findFirstAndLock(String sSqlWhere)throws Exception {           return (SynchrecordBean)new SynchrecordBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new SynchrecordBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           SynchrecordBean bean = new SynchrecordBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           SynchrecordBean bean = new SynchrecordBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static SynchrecordBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           SynchrecordBean bean = new SynchrecordBean();           bean.setAutoRelease(isAutoRelease);           return (SynchrecordBean)bean.findFirstByWhere(sSqlWhere);      }       public static SynchrecordBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           SynchrecordBean bean = new SynchrecordBean();           bean.setAutoRelease(isAutoRelease);           return (SynchrecordBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           SynchrecordBean bean = new SynchrecordBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  tablename;
String  keyname;
String  mainkey;
String  classname;
String  czrq;
String  czsj;
String  czlx;
String  zxyj;
String  status1;
String  desc1;
String  tbrq1;
String  tbsj1;
String  exp1;
String  status2;
String  desc2;
String  tbrq2;
String  tbsj2;
String  exp2;
String  status3;
String  desc3;
String  tbrq3;
String  tbsj3;
String  exp3;
String  status4;
String  desc4;
String  tbrq4;
String  tbsj4;
String  exp4;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="synchrecord";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
SynchrecordBean abb = new SynchrecordBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.tablename=rs.getString("tablename");
abb.setKeyValue("TABLENAME","" + abb.getTablename());
abb.keyname=rs.getString("keyname");
abb.setKeyValue("KEYNAME","" + abb.getKeyname());
abb.mainkey=rs.getString("mainkey");
abb.setKeyValue("MAINKEY","" + abb.getMainkey());
abb.classname=rs.getString("classname");
abb.setKeyValue("CLASSNAME","" + abb.getClassname());
abb.czrq=rs.getString("czrq");
abb.setKeyValue("CZRQ","" + abb.getCzrq());
abb.czsj=rs.getString("czsj");
abb.setKeyValue("CZSJ","" + abb.getCzsj());
abb.czlx=rs.getString("czlx");
abb.setKeyValue("CZLX","" + abb.getCzlx());
abb.zxyj=rs.getString("zxyj");
abb.setKeyValue("ZXYJ","" + abb.getZxyj());
abb.status1=rs.getString("status1");
abb.setKeyValue("STATUS1","" + abb.getStatus1());
abb.desc1=rs.getString("desc1");
abb.setKeyValue("DESC1","" + abb.getDesc1());
abb.tbrq1=rs.getString("tbrq1");
abb.setKeyValue("TBRQ1","" + abb.getTbrq1());
abb.tbsj1=rs.getString("tbsj1");
abb.setKeyValue("TBSJ1","" + abb.getTbsj1());
abb.exp1=rs.getString("exp1");
abb.setKeyValue("EXP1","" + abb.getExp1());
abb.status2=rs.getString("status2");
abb.setKeyValue("STATUS2","" + abb.getStatus2());
abb.desc2=rs.getString("desc2");
abb.setKeyValue("DESC2","" + abb.getDesc2());
abb.tbrq2=rs.getString("tbrq2");
abb.setKeyValue("TBRQ2","" + abb.getTbrq2());
abb.tbsj2=rs.getString("tbsj2");
abb.setKeyValue("TBSJ2","" + abb.getTbsj2());
abb.exp2=rs.getString("exp2");
abb.setKeyValue("EXP2","" + abb.getExp2());
abb.status3=rs.getString("status3");
abb.setKeyValue("STATUS3","" + abb.getStatus3());
abb.desc3=rs.getString("desc3");
abb.setKeyValue("DESC3","" + abb.getDesc3());
abb.tbrq3=rs.getString("tbrq3");
abb.setKeyValue("TBRQ3","" + abb.getTbrq3());
abb.tbsj3=rs.getString("tbsj3");
abb.setKeyValue("TBSJ3","" + abb.getTbsj3());
abb.exp3=rs.getString("exp3");
abb.setKeyValue("EXP3","" + abb.getExp3());
abb.status4=rs.getString("status4");
abb.setKeyValue("STATUS4","" + abb.getStatus4());
abb.desc4=rs.getString("desc4");
abb.setKeyValue("DESC4","" + abb.getDesc4());
abb.tbrq4=rs.getString("tbrq4");
abb.setKeyValue("TBRQ4","" + abb.getTbrq4());
abb.tbsj4=rs.getString("tbsj4");
abb.setKeyValue("TBSJ4","" + abb.getTbsj4());
abb.exp4=rs.getString("exp4");
abb.setKeyValue("EXP4","" + abb.getExp4());
abb.bak1=rs.getString("bak1");
abb.setKeyValue("BAK1","" + abb.getBak1());
abb.bak2=rs.getString("bak2");
abb.setKeyValue("BAK2","" + abb.getBak2());
abb.bak3=rs.getString("bak3");
abb.setKeyValue("BAK3","" + abb.getBak3());
abb.bak4=rs.getString("bak4");
abb.setKeyValue("BAK4","" + abb.getBak4());
abb.bak5=rs.getString("bak5");
abb.setKeyValue("BAK5","" + abb.getBak5());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getTablename(){ if ( this.tablename == null){ return ""; } else {return this.tablename;}}public String getKeyname(){ if ( this.keyname == null){ return ""; } else {return this.keyname;}}public String getMainkey(){ if ( this.mainkey == null){ return ""; } else {return this.mainkey;}}public String getClassname(){ if ( this.classname == null){ return ""; } else {return this.classname;}}public String getCzrq(){ if ( this.czrq == null){ return ""; } else {return this.czrq;}}public String getCzsj(){ if ( this.czsj == null){ return ""; } else {return this.czsj;}}public String getCzlx(){ if ( this.czlx == null){ return ""; } else {return this.czlx;}}public String getZxyj(){ if ( this.zxyj == null){ return ""; } else {return this.zxyj;}}public String getStatus1(){ if ( this.status1 == null){ return ""; } else {return this.status1;}}public String getDesc1(){ if ( this.desc1 == null){ return ""; } else {return this.desc1;}}public String getTbrq1(){ if ( this.tbrq1 == null){ return ""; } else {return this.tbrq1;}}public String getTbsj1(){ if ( this.tbsj1 == null){ return ""; } else {return this.tbsj1;}}public String getExp1(){ if ( this.exp1 == null){ return ""; } else {return this.exp1;}}public String getStatus2(){ if ( this.status2 == null){ return ""; } else {return this.status2;}}public String getDesc2(){ if ( this.desc2 == null){ return ""; } else {return this.desc2;}}public String getTbrq2(){ if ( this.tbrq2 == null){ return ""; } else {return this.tbrq2;}}public String getTbsj2(){ if ( this.tbsj2 == null){ return ""; } else {return this.tbsj2;}}public String getExp2(){ if ( this.exp2 == null){ return ""; } else {return this.exp2;}}public String getStatus3(){ if ( this.status3 == null){ return ""; } else {return this.status3;}}public String getDesc3(){ if ( this.desc3 == null){ return ""; } else {return this.desc3;}}public String getTbrq3(){ if ( this.tbrq3 == null){ return ""; } else {return this.tbrq3;}}public String getTbsj3(){ if ( this.tbsj3 == null){ return ""; } else {return this.tbsj3;}}public String getExp3(){ if ( this.exp3 == null){ return ""; } else {return this.exp3;}}public String getStatus4(){ if ( this.status4 == null){ return ""; } else {return this.status4;}}public String getDesc4(){ if ( this.desc4 == null){ return ""; } else {return this.desc4;}}public String getTbrq4(){ if ( this.tbrq4 == null){ return ""; } else {return this.tbrq4;}}public String getTbsj4(){ if ( this.tbsj4 == null){ return ""; } else {return this.tbsj4;}}public String getExp4(){ if ( this.exp4 == null){ return ""; } else {return this.exp4;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setTablename( String tablename){sqlMaker.setField("tablename",tablename,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTablename().equals(tablename))
cf.add("tablename",this.tablename,tablename);
}
this.tablename=tablename;
}
public void setKeyname( String keyname){sqlMaker.setField("keyname",keyname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getKeyname().equals(keyname))
cf.add("keyname",this.keyname,keyname);
}
this.keyname=keyname;
}
public void setMainkey( String mainkey){sqlMaker.setField("mainkey",mainkey,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMainkey().equals(mainkey))
cf.add("mainkey",this.mainkey,mainkey);
}
this.mainkey=mainkey;
}
public void setClassname( String classname){sqlMaker.setField("classname",classname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getClassname().equals(classname))
cf.add("classname",this.classname,classname);
}
this.classname=classname;
}
public void setCzrq( String czrq){sqlMaker.setField("czrq",czrq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCzrq().equals(czrq))
cf.add("czrq",this.czrq,czrq);
}
this.czrq=czrq;
}
public void setCzsj( String czsj){sqlMaker.setField("czsj",czsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCzsj().equals(czsj))
cf.add("czsj",this.czsj,czsj);
}
this.czsj=czsj;
}
public void setCzlx( String czlx){sqlMaker.setField("czlx",czlx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCzlx().equals(czlx))
cf.add("czlx",this.czlx,czlx);
}
this.czlx=czlx;
}
public void setZxyj( String zxyj){sqlMaker.setField("zxyj",zxyj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZxyj().equals(zxyj))
cf.add("zxyj",this.zxyj,zxyj);
}
this.zxyj=zxyj;
}
public void setStatus1( String status1){sqlMaker.setField("status1",status1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getStatus1().equals(status1))
cf.add("status1",this.status1,status1);
}
this.status1=status1;
}
public void setDesc1( String desc1){sqlMaker.setField("desc1",desc1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDesc1().equals(desc1))
cf.add("desc1",this.desc1,desc1);
}
this.desc1=desc1;
}
public void setTbrq1( String tbrq1){sqlMaker.setField("tbrq1",tbrq1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTbrq1().equals(tbrq1))
cf.add("tbrq1",this.tbrq1,tbrq1);
}
this.tbrq1=tbrq1;
}
public void setTbsj1( String tbsj1){sqlMaker.setField("tbsj1",tbsj1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTbsj1().equals(tbsj1))
cf.add("tbsj1",this.tbsj1,tbsj1);
}
this.tbsj1=tbsj1;
}
public void setExp1( String exp1){sqlMaker.setField("exp1",exp1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getExp1().equals(exp1))
cf.add("exp1",this.exp1,exp1);
}
this.exp1=exp1;
}
public void setStatus2( String status2){sqlMaker.setField("status2",status2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getStatus2().equals(status2))
cf.add("status2",this.status2,status2);
}
this.status2=status2;
}
public void setDesc2( String desc2){sqlMaker.setField("desc2",desc2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDesc2().equals(desc2))
cf.add("desc2",this.desc2,desc2);
}
this.desc2=desc2;
}
public void setTbrq2( String tbrq2){sqlMaker.setField("tbrq2",tbrq2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTbrq2().equals(tbrq2))
cf.add("tbrq2",this.tbrq2,tbrq2);
}
this.tbrq2=tbrq2;
}
public void setTbsj2( String tbsj2){sqlMaker.setField("tbsj2",tbsj2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTbsj2().equals(tbsj2))
cf.add("tbsj2",this.tbsj2,tbsj2);
}
this.tbsj2=tbsj2;
}
public void setExp2( String exp2){sqlMaker.setField("exp2",exp2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getExp2().equals(exp2))
cf.add("exp2",this.exp2,exp2);
}
this.exp2=exp2;
}
public void setStatus3( String status3){sqlMaker.setField("status3",status3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getStatus3().equals(status3))
cf.add("status3",this.status3,status3);
}
this.status3=status3;
}
public void setDesc3( String desc3){sqlMaker.setField("desc3",desc3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDesc3().equals(desc3))
cf.add("desc3",this.desc3,desc3);
}
this.desc3=desc3;
}
public void setTbrq3( String tbrq3){sqlMaker.setField("tbrq3",tbrq3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTbrq3().equals(tbrq3))
cf.add("tbrq3",this.tbrq3,tbrq3);
}
this.tbrq3=tbrq3;
}
public void setTbsj3( String tbsj3){sqlMaker.setField("tbsj3",tbsj3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTbsj3().equals(tbsj3))
cf.add("tbsj3",this.tbsj3,tbsj3);
}
this.tbsj3=tbsj3;
}
public void setExp3( String exp3){sqlMaker.setField("exp3",exp3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getExp3().equals(exp3))
cf.add("exp3",this.exp3,exp3);
}
this.exp3=exp3;
}
public void setStatus4( String status4){sqlMaker.setField("status4",status4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getStatus4().equals(status4))
cf.add("status4",this.status4,status4);
}
this.status4=status4;
}
public void setDesc4( String desc4){sqlMaker.setField("desc4",desc4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDesc4().equals(desc4))
cf.add("desc4",this.desc4,desc4);
}
this.desc4=desc4;
}
public void setTbrq4( String tbrq4){sqlMaker.setField("tbrq4",tbrq4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTbrq4().equals(tbrq4))
cf.add("tbrq4",this.tbrq4,tbrq4);
}
this.tbrq4=tbrq4;
}
public void setTbsj4( String tbsj4){sqlMaker.setField("tbsj4",tbsj4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTbsj4().equals(tbsj4))
cf.add("tbsj4",this.tbsj4,tbsj4);
}
this.tbsj4=tbsj4;
}
public void setExp4( String exp4){sqlMaker.setField("exp4",exp4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getExp4().equals(exp4))
cf.add("exp4",this.exp4,exp4);
}
this.exp4=exp4;
}
public void setBak1( String bak1){sqlMaker.setField("bak1",bak1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak1().equals(bak1))
cf.add("bak1",this.bak1,bak1);
}
this.bak1=bak1;
}
public void setBak2( String bak2){sqlMaker.setField("bak2",bak2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak2().equals(bak2))
cf.add("bak2",this.bak2,bak2);
}
this.bak2=bak2;
}
public void setBak3( String bak3){sqlMaker.setField("bak3",bak3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak3().equals(bak3))
cf.add("bak3",this.bak3,bak3);
}
this.bak3=bak3;
}
public void setBak4( String bak4){sqlMaker.setField("bak4",bak4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak4().equals(bak4))
cf.add("bak4",this.bak4,bak4);
}
this.bak4=bak4;
}
public void setBak5( String bak5){sqlMaker.setField("bak5",bak5,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak5().equals(bak5))
cf.add("bak5",this.bak5,bak5);
}
this.bak5=bak5;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "tablename") != null) 
this.setTablename(actionRequest.getFieldValue(i, "tablename"));
if (actionRequest.getFieldValue(i, "keyname") != null) 
this.setKeyname(actionRequest.getFieldValue(i, "keyname"));
if (actionRequest.getFieldValue(i, "mainkey") != null) 
this.setMainkey(actionRequest.getFieldValue(i, "mainkey"));
if (actionRequest.getFieldValue(i, "classname") != null) 
this.setClassname(actionRequest.getFieldValue(i, "classname"));
if (actionRequest.getFieldValue(i, "czrq") != null) 
this.setCzrq(actionRequest.getFieldValue(i, "czrq"));
if (actionRequest.getFieldValue(i, "czsj") != null) 
this.setCzsj(actionRequest.getFieldValue(i, "czsj"));
if (actionRequest.getFieldValue(i, "czlx") != null) 
this.setCzlx(actionRequest.getFieldValue(i, "czlx"));
if (actionRequest.getFieldValue(i, "zxyj") != null) 
this.setZxyj(actionRequest.getFieldValue(i, "zxyj"));
if (actionRequest.getFieldValue(i, "status1") != null) 
this.setStatus1(actionRequest.getFieldValue(i, "status1"));
if (actionRequest.getFieldValue(i, "desc1") != null) 
this.setDesc1(actionRequest.getFieldValue(i, "desc1"));
if (actionRequest.getFieldValue(i, "tbrq1") != null) 
this.setTbrq1(actionRequest.getFieldValue(i, "tbrq1"));
if (actionRequest.getFieldValue(i, "tbsj1") != null) 
this.setTbsj1(actionRequest.getFieldValue(i, "tbsj1"));
if (actionRequest.getFieldValue(i, "exp1") != null) 
this.setExp1(actionRequest.getFieldValue(i, "exp1"));
if (actionRequest.getFieldValue(i, "status2") != null) 
this.setStatus2(actionRequest.getFieldValue(i, "status2"));
if (actionRequest.getFieldValue(i, "desc2") != null) 
this.setDesc2(actionRequest.getFieldValue(i, "desc2"));
if (actionRequest.getFieldValue(i, "tbrq2") != null) 
this.setTbrq2(actionRequest.getFieldValue(i, "tbrq2"));
if (actionRequest.getFieldValue(i, "tbsj2") != null) 
this.setTbsj2(actionRequest.getFieldValue(i, "tbsj2"));
if (actionRequest.getFieldValue(i, "exp2") != null) 
this.setExp2(actionRequest.getFieldValue(i, "exp2"));
if (actionRequest.getFieldValue(i, "status3") != null) 
this.setStatus3(actionRequest.getFieldValue(i, "status3"));
if (actionRequest.getFieldValue(i, "desc3") != null) 
this.setDesc3(actionRequest.getFieldValue(i, "desc3"));
if (actionRequest.getFieldValue(i, "tbrq3") != null) 
this.setTbrq3(actionRequest.getFieldValue(i, "tbrq3"));
if (actionRequest.getFieldValue(i, "tbsj3") != null) 
this.setTbsj3(actionRequest.getFieldValue(i, "tbsj3"));
if (actionRequest.getFieldValue(i, "exp3") != null) 
this.setExp3(actionRequest.getFieldValue(i, "exp3"));
if (actionRequest.getFieldValue(i, "status4") != null) 
this.setStatus4(actionRequest.getFieldValue(i, "status4"));
if (actionRequest.getFieldValue(i, "desc4") != null) 
this.setDesc4(actionRequest.getFieldValue(i, "desc4"));
if (actionRequest.getFieldValue(i, "tbrq4") != null) 
this.setTbrq4(actionRequest.getFieldValue(i, "tbrq4"));
if (actionRequest.getFieldValue(i, "tbsj4") != null) 
this.setTbsj4(actionRequest.getFieldValue(i, "tbsj4"));
if (actionRequest.getFieldValue(i, "exp4") != null) 
this.setExp4(actionRequest.getFieldValue(i, "exp4"));
if (actionRequest.getFieldValue(i, "bak1") != null) 
this.setBak1(actionRequest.getFieldValue(i, "bak1"));
if (actionRequest.getFieldValue(i, "bak2") != null) 
this.setBak2(actionRequest.getFieldValue(i, "bak2"));
if (actionRequest.getFieldValue(i, "bak3") != null) 
this.setBak3(actionRequest.getFieldValue(i, "bak3"));
if (actionRequest.getFieldValue(i, "bak4") != null) 
this.setBak4(actionRequest.getFieldValue(i, "bak4"));
if (actionRequest.getFieldValue(i, "bak5") != null) 
this.setBak5(actionRequest.getFieldValue(i, "bak5"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { SynchrecordBean obj = (SynchrecordBean)super.clone();obj.setSysno(obj.sysno);
obj.setTablename(obj.tablename);
obj.setKeyname(obj.keyname);
obj.setMainkey(obj.mainkey);
obj.setClassname(obj.classname);
obj.setCzrq(obj.czrq);
obj.setCzsj(obj.czsj);
obj.setCzlx(obj.czlx);
obj.setZxyj(obj.zxyj);
obj.setStatus1(obj.status1);
obj.setDesc1(obj.desc1);
obj.setTbrq1(obj.tbrq1);
obj.setTbsj1(obj.tbsj1);
obj.setExp1(obj.exp1);
obj.setStatus2(obj.status2);
obj.setDesc2(obj.desc2);
obj.setTbrq2(obj.tbrq2);
obj.setTbsj2(obj.tbsj2);
obj.setExp2(obj.exp2);
obj.setStatus3(obj.status3);
obj.setDesc3(obj.desc3);
obj.setTbrq3(obj.tbrq3);
obj.setTbsj3(obj.tbsj3);
obj.setExp3(obj.exp3);
obj.setStatus4(obj.status4);
obj.setDesc4(obj.desc4);
obj.setTbrq4(obj.tbrq4);
obj.setTbsj4(obj.tbsj4);
obj.setExp4(obj.exp4);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}