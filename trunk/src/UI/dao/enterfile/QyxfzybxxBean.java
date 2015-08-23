package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyxfzybxxBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyxfzybxxBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyxfzybxxBean().findAndLockByWhere(sSqlWhere);      }       public static QyxfzybxxBean findFirst(String sSqlWhere)throws Exception {           return (QyxfzybxxBean)new QyxfzybxxBean().findFirstByWhere(sSqlWhere);      }       public static QyxfzybxxBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyxfzybxxBean)new QyxfzybxxBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyxfzybxxBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyxfzybxxBean bean = new QyxfzybxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyxfzybxxBean bean = new QyxfzybxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyxfzybxxBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyxfzybxxBean bean = new QyxfzybxxBean();           bean.setAutoRelease(isAutoRelease);           return (QyxfzybxxBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyxfzybxxBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyxfzybxxBean bean = new QyxfzybxxBean();           bean.setAutoRelease(isAutoRelease);           return (QyxfzybxxBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyxfzybxxBean bean = new QyxfzybxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  enterno;
String  entername;
String  ldzbh;
String  ldzxm;
String  sex;
String  age;
String  lxdh;
String  gz;
String  zl;
String  jhage;
String  czrq;
String  fzrq;
String  result;
String  zgl;
String  cfjqdate;
String  swdate;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qyxfzybxx";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyxfzybxxBean abb = new QyxfzybxxBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.entername=rs.getString("entername");
abb.setKeyValue("ENTERNAME","" + abb.getEntername());
abb.ldzbh=rs.getString("ldzbh");
abb.setKeyValue("LDZBH","" + abb.getLdzbh());
abb.ldzxm=rs.getString("ldzxm");
abb.setKeyValue("LDZXM","" + abb.getLdzxm());
abb.sex=rs.getString("sex");
abb.setKeyValue("SEX","" + abb.getSex());
abb.age=rs.getString("age");
abb.setKeyValue("AGE","" + abb.getAge());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.gz=rs.getString("gz");
abb.setKeyValue("GZ","" + abb.getGz());
abb.zl=rs.getString("zl");
abb.setKeyValue("ZL","" + abb.getZl());
abb.jhage=rs.getString("jhage");
abb.setKeyValue("JHAGE","" + abb.getJhage());
abb.czrq=rs.getString("czrq");
abb.setKeyValue("CZRQ","" + abb.getCzrq());
abb.fzrq=rs.getString("fzrq");
abb.setKeyValue("FZRQ","" + abb.getFzrq());
abb.result=rs.getString("result");
abb.setKeyValue("RESULT","" + abb.getResult());
abb.zgl=rs.getString("zgl");
abb.setKeyValue("ZGL","" + abb.getZgl());
abb.cfjqdate=rs.getString("cfjqdate");
abb.setKeyValue("CFJQDATE","" + abb.getCfjqdate());
abb.swdate=rs.getString("swdate");
abb.setKeyValue("SWDATE","" + abb.getSwdate());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getEntername(){ if ( this.entername == null){ return ""; } else {return this.entername;}}public String getLdzbh(){ if ( this.ldzbh == null){ return ""; } else {return this.ldzbh;}}public String getLdzxm(){ if ( this.ldzxm == null){ return ""; } else {return this.ldzxm;}}public String getSex(){ if ( this.sex == null){ return ""; } else {return this.sex;}}public String getAge(){ if ( this.age == null){ return ""; } else {return this.age;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getGz(){ if ( this.gz == null){ return ""; } else {return this.gz;}}public String getZl(){ if ( this.zl == null){ return ""; } else {return this.zl;}}public String getJhage(){ if ( this.jhage == null){ return ""; } else {return this.jhage;}}public String getCzrq(){ if ( this.czrq == null){ return ""; } else {return this.czrq;}}public String getFzrq(){ if ( this.fzrq == null){ return ""; } else {return this.fzrq;}}public String getResult(){ if ( this.result == null){ return ""; } else {return this.result;}}public String getZgl(){ if ( this.zgl == null){ return ""; } else {return this.zgl;}}public String getCfjqdate(){ if ( this.cfjqdate == null){ return ""; } else {return this.cfjqdate;}}public String getSwdate(){ if ( this.swdate == null){ return ""; } else {return this.swdate;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setEnterno( String enterno){sqlMaker.setField("enterno",enterno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnterno().equals(enterno))
cf.add("enterno",this.enterno,enterno);
}
this.enterno=enterno;
}
public void setEntername( String entername){sqlMaker.setField("entername",entername,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEntername().equals(entername))
cf.add("entername",this.entername,entername);
}
this.entername=entername;
}
public void setLdzbh( String ldzbh){sqlMaker.setField("ldzbh",ldzbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLdzbh().equals(ldzbh))
cf.add("ldzbh",this.ldzbh,ldzbh);
}
this.ldzbh=ldzbh;
}
public void setLdzxm( String ldzxm){sqlMaker.setField("ldzxm",ldzxm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLdzxm().equals(ldzxm))
cf.add("ldzxm",this.ldzxm,ldzxm);
}
this.ldzxm=ldzxm;
}
public void setSex( String sex){sqlMaker.setField("sex",sex,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSex().equals(sex))
cf.add("sex",this.sex,sex);
}
this.sex=sex;
}
public void setAge( String age){sqlMaker.setField("age",age,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getAge().equals(age))
cf.add("age",this.age,age);
}
this.age=age;
}
public void setLxdh( String lxdh){sqlMaker.setField("lxdh",lxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLxdh().equals(lxdh))
cf.add("lxdh",this.lxdh,lxdh);
}
this.lxdh=lxdh;
}
public void setGz( String gz){sqlMaker.setField("gz",gz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGz().equals(gz))
cf.add("gz",this.gz,gz);
}
this.gz=gz;
}
public void setZl( String zl){sqlMaker.setField("zl",zl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZl().equals(zl))
cf.add("zl",this.zl,zl);
}
this.zl=zl;
}
public void setJhage( String jhage){sqlMaker.setField("jhage",jhage,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJhage().equals(jhage))
cf.add("jhage",this.jhage,jhage);
}
this.jhage=jhage;
}
public void setCzrq( String czrq){sqlMaker.setField("czrq",czrq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCzrq().equals(czrq))
cf.add("czrq",this.czrq,czrq);
}
this.czrq=czrq;
}
public void setFzrq( String fzrq){sqlMaker.setField("fzrq",fzrq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzrq().equals(fzrq))
cf.add("fzrq",this.fzrq,fzrq);
}
this.fzrq=fzrq;
}
public void setResult( String result){sqlMaker.setField("result",result,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getResult().equals(result))
cf.add("result",this.result,result);
}
this.result=result;
}
public void setZgl( String zgl){sqlMaker.setField("zgl",zgl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZgl().equals(zgl))
cf.add("zgl",this.zgl,zgl);
}
this.zgl=zgl;
}
public void setCfjqdate( String cfjqdate){sqlMaker.setField("cfjqdate",cfjqdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCfjqdate().equals(cfjqdate))
cf.add("cfjqdate",this.cfjqdate,cfjqdate);
}
this.cfjqdate=cfjqdate;
}
public void setSwdate( String swdate){sqlMaker.setField("swdate",swdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSwdate().equals(swdate))
cf.add("swdate",this.swdate,swdate);
}
this.swdate=swdate;
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
if (actionRequest.getFieldValue(i, "enterno") != null) 
this.setEnterno(actionRequest.getFieldValue(i, "enterno"));
if (actionRequest.getFieldValue(i, "entername") != null) 
this.setEntername(actionRequest.getFieldValue(i, "entername"));
if (actionRequest.getFieldValue(i, "ldzbh") != null) 
this.setLdzbh(actionRequest.getFieldValue(i, "ldzbh"));
if (actionRequest.getFieldValue(i, "ldzxm") != null) 
this.setLdzxm(actionRequest.getFieldValue(i, "ldzxm"));
if (actionRequest.getFieldValue(i, "sex") != null) 
this.setSex(actionRequest.getFieldValue(i, "sex"));
if (actionRequest.getFieldValue(i, "age") != null) 
this.setAge(actionRequest.getFieldValue(i, "age"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "gz") != null) 
this.setGz(actionRequest.getFieldValue(i, "gz"));
if (actionRequest.getFieldValue(i, "zl") != null) 
this.setZl(actionRequest.getFieldValue(i, "zl"));
if (actionRequest.getFieldValue(i, "jhage") != null) 
this.setJhage(actionRequest.getFieldValue(i, "jhage"));
if (actionRequest.getFieldValue(i, "czrq") != null) 
this.setCzrq(actionRequest.getFieldValue(i, "czrq"));
if (actionRequest.getFieldValue(i, "fzrq") != null) 
this.setFzrq(actionRequest.getFieldValue(i, "fzrq"));
if (actionRequest.getFieldValue(i, "result") != null) 
this.setResult(actionRequest.getFieldValue(i, "result"));
if (actionRequest.getFieldValue(i, "zgl") != null) 
this.setZgl(actionRequest.getFieldValue(i, "zgl"));
if (actionRequest.getFieldValue(i, "cfjqdate") != null) 
this.setCfjqdate(actionRequest.getFieldValue(i, "cfjqdate"));
if (actionRequest.getFieldValue(i, "swdate") != null) 
this.setSwdate(actionRequest.getFieldValue(i, "swdate"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyxfzybxxBean obj = (QyxfzybxxBean)super.clone();obj.setSysno(obj.sysno);
obj.setEnterno(obj.enterno);
obj.setEntername(obj.entername);
obj.setLdzbh(obj.ldzbh);
obj.setLdzxm(obj.ldzxm);
obj.setSex(obj.sex);
obj.setAge(obj.age);
obj.setLxdh(obj.lxdh);
obj.setGz(obj.gz);
obj.setZl(obj.zl);
obj.setJhage(obj.jhage);
obj.setCzrq(obj.czrq);
obj.setFzrq(obj.fzrq);
obj.setResult(obj.result);
obj.setZgl(obj.zgl);
obj.setCfjqdate(obj.cfjqdate);
obj.setSwdate(obj.swdate);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}