package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QygljgrymxBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QygljgrymxBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QygljgrymxBean().findAndLockByWhere(sSqlWhere);      }       public static QygljgrymxBean findFirst(String sSqlWhere)throws Exception {           return (QygljgrymxBean)new QygljgrymxBean().findFirstByWhere(sSqlWhere);      }       public static QygljgrymxBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QygljgrymxBean)new QygljgrymxBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QygljgrymxBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QygljgrymxBean bean = new QygljgrymxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QygljgrymxBean bean = new QygljgrymxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QygljgrymxBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QygljgrymxBean bean = new QygljgrymxBean();           bean.setAutoRelease(isAutoRelease);           return (QygljgrymxBean)bean.findFirstByWhere(sSqlWhere);      }       public static QygljgrymxBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QygljgrymxBean bean = new QygljgrymxBean();           bean.setAutoRelease(isAutoRelease);           return (QygljgrymxBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QygljgrymxBean bean = new QygljgrymxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  jgno;
String  enterno;
String  name;
String  sex;
String  birthday;
String  deptno;
String  wsjgname;
String  duty;
String  experience;
String  iszz;
String  remark;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qygljgrymx";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QygljgrymxBean abb = new QygljgrymxBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.jgno=rs.getString("jgno");
abb.setKeyValue("JGNO","" + abb.getJgno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.name=rs.getString("name");
abb.setKeyValue("NAME","" + abb.getName());
abb.sex=rs.getString("sex");
abb.setKeyValue("SEX","" + abb.getSex());
abb.birthday=rs.getString("birthday");
abb.setKeyValue("BIRTHDAY","" + abb.getBirthday());
abb.deptno=rs.getString("deptno");
abb.setKeyValue("DEPTNO","" + abb.getDeptno());
abb.wsjgname=rs.getString("wsjgname");
abb.setKeyValue("WSJGNAME","" + abb.getWsjgname());
abb.duty=rs.getString("duty");
abb.setKeyValue("DUTY","" + abb.getDuty());
abb.experience=rs.getString("experience");
abb.setKeyValue("EXPERIENCE","" + abb.getExperience());
abb.iszz=rs.getString("iszz");
abb.setKeyValue("ISZZ","" + abb.getIszz());
abb.remark=rs.getString("remark");
abb.setKeyValue("REMARK","" + abb.getRemark());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getJgno(){ if ( this.jgno == null){ return ""; } else {return this.jgno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getName(){ if ( this.name == null){ return ""; } else {return this.name;}}public String getSex(){ if ( this.sex == null){ return ""; } else {return this.sex;}}public String getBirthday(){ if ( this.birthday == null){ return ""; } else {return this.birthday;}}public String getDeptno(){ if ( this.deptno == null){ return ""; } else {return this.deptno;}}public String getWsjgname(){ if ( this.wsjgname == null){ return ""; } else {return this.wsjgname;}}public String getDuty(){ if ( this.duty == null){ return ""; } else {return this.duty;}}public String getExperience(){ if ( this.experience == null){ return ""; } else {return this.experience;}}public String getIszz(){ if ( this.iszz == null){ return ""; } else {return this.iszz;}}public String getRemark(){ if ( this.remark == null){ return ""; } else {return this.remark;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setJgno( String jgno){sqlMaker.setField("jgno",jgno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgno().equals(jgno))
cf.add("jgno",this.jgno,jgno);
}
this.jgno=jgno;
}
public void setEnterno( String enterno){sqlMaker.setField("enterno",enterno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnterno().equals(enterno))
cf.add("enterno",this.enterno,enterno);
}
this.enterno=enterno;
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
public void setDeptno( String deptno){sqlMaker.setField("deptno",deptno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptno().equals(deptno))
cf.add("deptno",this.deptno,deptno);
}
this.deptno=deptno;
}
public void setWsjgname( String wsjgname){sqlMaker.setField("wsjgname",wsjgname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWsjgname().equals(wsjgname))
cf.add("wsjgname",this.wsjgname,wsjgname);
}
this.wsjgname=wsjgname;
}
public void setDuty( String duty){sqlMaker.setField("duty",duty,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDuty().equals(duty))
cf.add("duty",this.duty,duty);
}
this.duty=duty;
}
public void setExperience( String experience){sqlMaker.setField("experience",experience,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getExperience().equals(experience))
cf.add("experience",this.experience,experience);
}
this.experience=experience;
}
public void setIszz( String iszz){sqlMaker.setField("iszz",iszz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIszz().equals(iszz))
cf.add("iszz",this.iszz,iszz);
}
this.iszz=iszz;
}
public void setRemark( String remark){sqlMaker.setField("remark",remark,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRemark().equals(remark))
cf.add("remark",this.remark,remark);
}
this.remark=remark;
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
if (actionRequest.getFieldValue(i, "jgno") != null) 
this.setJgno(actionRequest.getFieldValue(i, "jgno"));
if (actionRequest.getFieldValue(i, "enterno") != null) 
this.setEnterno(actionRequest.getFieldValue(i, "enterno"));
if (actionRequest.getFieldValue(i, "name") != null) 
this.setName(actionRequest.getFieldValue(i, "name"));
if (actionRequest.getFieldValue(i, "sex") != null) 
this.setSex(actionRequest.getFieldValue(i, "sex"));
if (actionRequest.getFieldValue(i, "birthday") != null) 
this.setBirthday(actionRequest.getFieldValue(i, "birthday"));
if (actionRequest.getFieldValue(i, "deptno") != null) 
this.setDeptno(actionRequest.getFieldValue(i, "deptno"));
if (actionRequest.getFieldValue(i, "wsjgname") != null) 
this.setWsjgname(actionRequest.getFieldValue(i, "wsjgname"));
if (actionRequest.getFieldValue(i, "duty") != null) 
this.setDuty(actionRequest.getFieldValue(i, "duty"));
if (actionRequest.getFieldValue(i, "experience") != null) 
this.setExperience(actionRequest.getFieldValue(i, "experience"));
if (actionRequest.getFieldValue(i, "iszz") != null) 
this.setIszz(actionRequest.getFieldValue(i, "iszz"));
if (actionRequest.getFieldValue(i, "remark") != null) 
this.setRemark(actionRequest.getFieldValue(i, "remark"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QygljgrymxBean obj = (QygljgrymxBean)super.clone();obj.setSysno(obj.sysno);
obj.setJgno(obj.jgno);
obj.setEnterno(obj.enterno);
obj.setName(obj.name);
obj.setSex(obj.sex);
obj.setBirthday(obj.birthday);
obj.setDeptno(obj.deptno);
obj.setWsjgname(obj.wsjgname);
obj.setDuty(obj.duty);
obj.setExperience(obj.experience);
obj.setIszz(obj.iszz);
obj.setRemark(obj.remark);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}