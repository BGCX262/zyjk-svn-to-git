package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PxjgjsxxBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PxjgjsxxBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PxjgjsxxBean().findAndLockByWhere(sSqlWhere);      }       public static PxjgjsxxBean findFirst(String sSqlWhere)throws Exception {           return (PxjgjsxxBean)new PxjgjsxxBean().findFirstByWhere(sSqlWhere);      }       public static PxjgjsxxBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PxjgjsxxBean)new PxjgjsxxBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PxjgjsxxBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PxjgjsxxBean bean = new PxjgjsxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PxjgjsxxBean bean = new PxjgjsxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PxjgjsxxBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PxjgjsxxBean bean = new PxjgjsxxBean();           bean.setAutoRelease(isAutoRelease);           return (PxjgjsxxBean)bean.findFirstByWhere(sSqlWhere);      }       public static PxjgjsxxBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PxjgjsxxBean bean = new PxjgjsxxBean();           bean.setAutoRelease(isAutoRelease);           return (PxjgjsxxBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PxjgjsxxBean bean = new PxjgjsxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  jgbh;
String  jgmc;
String  name;
String  sex;
String  birthday;
String  education;
String  sxzy;
String  zw;
String  zc;
String  zzzsh;
String  fzsh;
String  dqsj;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="pxjgjsxx";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PxjgjsxxBean abb = new PxjgjsxxBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.jgbh=rs.getString("jgbh");
abb.setKeyValue("JGBH","" + abb.getJgbh());
abb.jgmc=rs.getString("jgmc");
abb.setKeyValue("JGMC","" + abb.getJgmc());
abb.name=rs.getString("name");
abb.setKeyValue("NAME","" + abb.getName());
abb.sex=rs.getString("sex");
abb.setKeyValue("SEX","" + abb.getSex());
abb.birthday=rs.getString("birthday");
abb.setKeyValue("BIRTHDAY","" + abb.getBirthday());
abb.education=rs.getString("education");
abb.setKeyValue("EDUCATION","" + abb.getEducation());
abb.sxzy=rs.getString("sxzy");
abb.setKeyValue("SXZY","" + abb.getSxzy());
abb.zw=rs.getString("zw");
abb.setKeyValue("ZW","" + abb.getZw());
abb.zc=rs.getString("zc");
abb.setKeyValue("ZC","" + abb.getZc());
abb.zzzsh=rs.getString("zzzsh");
abb.setKeyValue("ZZZSH","" + abb.getZzzsh());
abb.fzsh=rs.getString("fzsh");
abb.setKeyValue("FZSH","" + abb.getFzsh());
abb.dqsj=rs.getString("dqsj");
abb.setKeyValue("DQSJ","" + abb.getDqsj());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getJgbh(){ if ( this.jgbh == null){ return ""; } else {return this.jgbh;}}public String getJgmc(){ if ( this.jgmc == null){ return ""; } else {return this.jgmc;}}public String getName(){ if ( this.name == null){ return ""; } else {return this.name;}}public String getSex(){ if ( this.sex == null){ return ""; } else {return this.sex;}}public String getBirthday(){ if ( this.birthday == null){ return ""; } else {return this.birthday;}}public String getEducation(){ if ( this.education == null){ return ""; } else {return this.education;}}public String getSxzy(){ if ( this.sxzy == null){ return ""; } else {return this.sxzy;}}public String getZw(){ if ( this.zw == null){ return ""; } else {return this.zw;}}public String getZc(){ if ( this.zc == null){ return ""; } else {return this.zc;}}public String getZzzsh(){ if ( this.zzzsh == null){ return ""; } else {return this.zzzsh;}}public String getFzsh(){ if ( this.fzsh == null){ return ""; } else {return this.fzsh;}}public String getDqsj(){ if ( this.dqsj == null){ return ""; } else {return this.dqsj;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setJgbh( String jgbh){sqlMaker.setField("jgbh",jgbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgbh().equals(jgbh))
cf.add("jgbh",this.jgbh,jgbh);
}
this.jgbh=jgbh;
}
public void setJgmc( String jgmc){sqlMaker.setField("jgmc",jgmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgmc().equals(jgmc))
cf.add("jgmc",this.jgmc,jgmc);
}
this.jgmc=jgmc;
}
public void setName( String name){sqlMaker.setField("name",name,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getName().equals(name))
cf.add("name",this.name,name);
}
this.name=name;
}
public void setSex( String sex){sqlMaker.setField("sex",sex,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSex().equals(sex))
cf.add("sex",this.sex,sex);
}
this.sex=sex;
}
public void setBirthday( String birthday){sqlMaker.setField("birthday",birthday,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBirthday().equals(birthday))
cf.add("birthday",this.birthday,birthday);
}
this.birthday=birthday;
}
public void setEducation( String education){sqlMaker.setField("education",education,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEducation().equals(education))
cf.add("education",this.education,education);
}
this.education=education;
}
public void setSxzy( String sxzy){sqlMaker.setField("sxzy",sxzy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSxzy().equals(sxzy))
cf.add("sxzy",this.sxzy,sxzy);
}
this.sxzy=sxzy;
}
public void setZw( String zw){sqlMaker.setField("zw",zw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZw().equals(zw))
cf.add("zw",this.zw,zw);
}
this.zw=zw;
}
public void setZc( String zc){sqlMaker.setField("zc",zc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZc().equals(zc))
cf.add("zc",this.zc,zc);
}
this.zc=zc;
}
public void setZzzsh( String zzzsh){sqlMaker.setField("zzzsh",zzzsh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZzzsh().equals(zzzsh))
cf.add("zzzsh",this.zzzsh,zzzsh);
}
this.zzzsh=zzzsh;
}
public void setFzsh( String fzsh){sqlMaker.setField("fzsh",fzsh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzsh().equals(fzsh))
cf.add("fzsh",this.fzsh,fzsh);
}
this.fzsh=fzsh;
}
public void setDqsj( String dqsj){sqlMaker.setField("dqsj",dqsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDqsj().equals(dqsj))
cf.add("dqsj",this.dqsj,dqsj);
}
this.dqsj=dqsj;
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
if (actionRequest.getFieldValue(i, "jgbh") != null) 
this.setJgbh(actionRequest.getFieldValue(i, "jgbh"));
if (actionRequest.getFieldValue(i, "jgmc") != null) 
this.setJgmc(actionRequest.getFieldValue(i, "jgmc"));
if (actionRequest.getFieldValue(i, "name") != null) 
this.setName(actionRequest.getFieldValue(i, "name"));
if (actionRequest.getFieldValue(i, "sex") != null) 
this.setSex(actionRequest.getFieldValue(i, "sex"));
if (actionRequest.getFieldValue(i, "birthday") != null) 
this.setBirthday(actionRequest.getFieldValue(i, "birthday"));
if (actionRequest.getFieldValue(i, "education") != null) 
this.setEducation(actionRequest.getFieldValue(i, "education"));
if (actionRequest.getFieldValue(i, "sxzy") != null) 
this.setSxzy(actionRequest.getFieldValue(i, "sxzy"));
if (actionRequest.getFieldValue(i, "zw") != null) 
this.setZw(actionRequest.getFieldValue(i, "zw"));
if (actionRequest.getFieldValue(i, "zc") != null) 
this.setZc(actionRequest.getFieldValue(i, "zc"));
if (actionRequest.getFieldValue(i, "zzzsh") != null) 
this.setZzzsh(actionRequest.getFieldValue(i, "zzzsh"));
if (actionRequest.getFieldValue(i, "fzsh") != null) 
this.setFzsh(actionRequest.getFieldValue(i, "fzsh"));
if (actionRequest.getFieldValue(i, "dqsj") != null) 
this.setDqsj(actionRequest.getFieldValue(i, "dqsj"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PxjgjsxxBean obj = (PxjgjsxxBean)super.clone();obj.setSysno(obj.sysno);
obj.setJgbh(obj.jgbh);
obj.setJgmc(obj.jgmc);
obj.setName(obj.name);
obj.setSex(obj.sex);
obj.setBirthday(obj.birthday);
obj.setEducation(obj.education);
obj.setSxzy(obj.sxzy);
obj.setZw(obj.zw);
obj.setZc(obj.zc);
obj.setZzzsh(obj.zzzsh);
obj.setFzsh(obj.fzsh);
obj.setDqsj(obj.dqsj);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}