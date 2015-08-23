package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class JcjgpjryglBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new JcjgpjryglBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new JcjgpjryglBean().findAndLockByWhere(sSqlWhere);      }       public static JcjgpjryglBean findFirst(String sSqlWhere)throws Exception {           return (JcjgpjryglBean)new JcjgpjryglBean().findFirstByWhere(sSqlWhere);      }       public static JcjgpjryglBean findFirstAndLock(String sSqlWhere)throws Exception {           return (JcjgpjryglBean)new JcjgpjryglBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new JcjgpjryglBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgpjryglBean bean = new JcjgpjryglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcjgpjryglBean bean = new JcjgpjryglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static JcjgpjryglBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgpjryglBean bean = new JcjgpjryglBean();           bean.setAutoRelease(isAutoRelease);           return (JcjgpjryglBean)bean.findFirstByWhere(sSqlWhere);      }       public static JcjgpjryglBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcjgpjryglBean bean = new JcjgpjryglBean();           bean.setAutoRelease(isAutoRelease);           return (JcjgpjryglBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgpjryglBean bean = new JcjgpjryglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  jgbh;
String  jgmc;
String  no;
String  name;
String  sex;
String  birthday;
String  xl;
String  sxzy;
String  zw;
String  zc;
String  deptno;
String  deptname;
String  gw;
String  gznx;
String  zzzsbh;
String  fzdate;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="jcjgpjrygl";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
JcjgpjryglBean abb = new JcjgpjryglBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.jgbh=rs.getString("jgbh");
abb.setKeyValue("JGBH","" + abb.getJgbh());
abb.jgmc=rs.getString("jgmc");
abb.setKeyValue("JGMC","" + abb.getJgmc());
abb.no=rs.getString("no");
abb.setKeyValue("NO","" + abb.getNo());
abb.name=rs.getString("name");
abb.setKeyValue("NAME","" + abb.getName());
abb.sex=rs.getString("sex");
abb.setKeyValue("SEX","" + abb.getSex());
abb.birthday=rs.getString("birthday");
abb.setKeyValue("BIRTHDAY","" + abb.getBirthday());
abb.xl=rs.getString("xl");
abb.setKeyValue("XL","" + abb.getXl());
abb.sxzy=rs.getString("sxzy");
abb.setKeyValue("SXZY","" + abb.getSxzy());
abb.zw=rs.getString("zw");
abb.setKeyValue("ZW","" + abb.getZw());
abb.zc=rs.getString("zc");
abb.setKeyValue("ZC","" + abb.getZc());
abb.deptno=rs.getString("deptno");
abb.setKeyValue("DEPTNO","" + abb.getDeptno());
abb.deptname=rs.getString("deptname");
abb.setKeyValue("DEPTNAME","" + abb.getDeptname());
abb.gw=rs.getString("gw");
abb.setKeyValue("GW","" + abb.getGw());
abb.gznx=rs.getString("gznx");
abb.setKeyValue("GZNX","" + abb.getGznx());
abb.zzzsbh=rs.getString("zzzsbh");
abb.setKeyValue("ZZZSBH","" + abb.getZzzsbh());
abb.fzdate=rs.getString("fzdate");
abb.setKeyValue("FZDATE","" + abb.getFzdate());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getJgbh(){ if ( this.jgbh == null){ return ""; } else {return this.jgbh;}}public String getJgmc(){ if ( this.jgmc == null){ return ""; } else {return this.jgmc;}}public String getNo(){ if ( this.no == null){ return ""; } else {return this.no;}}public String getName(){ if ( this.name == null){ return ""; } else {return this.name;}}public String getSex(){ if ( this.sex == null){ return ""; } else {return this.sex;}}public String getBirthday(){ if ( this.birthday == null){ return ""; } else {return this.birthday;}}public String getXl(){ if ( this.xl == null){ return ""; } else {return this.xl;}}public String getSxzy(){ if ( this.sxzy == null){ return ""; } else {return this.sxzy;}}public String getZw(){ if ( this.zw == null){ return ""; } else {return this.zw;}}public String getZc(){ if ( this.zc == null){ return ""; } else {return this.zc;}}public String getDeptno(){ if ( this.deptno == null){ return ""; } else {return this.deptno;}}public String getDeptname(){ if ( this.deptname == null){ return ""; } else {return this.deptname;}}public String getGw(){ if ( this.gw == null){ return ""; } else {return this.gw;}}public String getGznx(){ if ( this.gznx == null){ return ""; } else {return this.gznx;}}public String getZzzsbh(){ if ( this.zzzsbh == null){ return ""; } else {return this.zzzsbh;}}public String getFzdate(){ if ( this.fzdate == null){ return ""; } else {return this.fzdate;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setNo( String no){sqlMaker.setField("no",no,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNo().equals(no))
cf.add("no",this.no,no);
}
this.no=no;
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
public void setXl( String xl){sqlMaker.setField("xl",xl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXl().equals(xl))
cf.add("xl",this.xl,xl);
}
this.xl=xl;
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
public void setDeptno( String deptno){sqlMaker.setField("deptno",deptno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptno().equals(deptno))
cf.add("deptno",this.deptno,deptno);
}
this.deptno=deptno;
}
public void setDeptname( String deptname){sqlMaker.setField("deptname",deptname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptname().equals(deptname))
cf.add("deptname",this.deptname,deptname);
}
this.deptname=deptname;
}
public void setGw( String gw){sqlMaker.setField("gw",gw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGw().equals(gw))
cf.add("gw",this.gw,gw);
}
this.gw=gw;
}
public void setGznx( String gznx){sqlMaker.setField("gznx",gznx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGznx().equals(gznx))
cf.add("gznx",this.gznx,gznx);
}
this.gznx=gznx;
}
public void setZzzsbh( String zzzsbh){sqlMaker.setField("zzzsbh",zzzsbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZzzsbh().equals(zzzsbh))
cf.add("zzzsbh",this.zzzsbh,zzzsbh);
}
this.zzzsbh=zzzsbh;
}
public void setFzdate( String fzdate){sqlMaker.setField("fzdate",fzdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzdate().equals(fzdate))
cf.add("fzdate",this.fzdate,fzdate);
}
this.fzdate=fzdate;
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
if (actionRequest.getFieldValue(i, "no") != null) 
this.setNo(actionRequest.getFieldValue(i, "no"));
if (actionRequest.getFieldValue(i, "name") != null) 
this.setName(actionRequest.getFieldValue(i, "name"));
if (actionRequest.getFieldValue(i, "sex") != null) 
this.setSex(actionRequest.getFieldValue(i, "sex"));
if (actionRequest.getFieldValue(i, "birthday") != null) 
this.setBirthday(actionRequest.getFieldValue(i, "birthday"));
if (actionRequest.getFieldValue(i, "xl") != null) 
this.setXl(actionRequest.getFieldValue(i, "xl"));
if (actionRequest.getFieldValue(i, "sxzy") != null) 
this.setSxzy(actionRequest.getFieldValue(i, "sxzy"));
if (actionRequest.getFieldValue(i, "zw") != null) 
this.setZw(actionRequest.getFieldValue(i, "zw"));
if (actionRequest.getFieldValue(i, "zc") != null) 
this.setZc(actionRequest.getFieldValue(i, "zc"));
if (actionRequest.getFieldValue(i, "deptno") != null) 
this.setDeptno(actionRequest.getFieldValue(i, "deptno"));
if (actionRequest.getFieldValue(i, "deptname") != null) 
this.setDeptname(actionRequest.getFieldValue(i, "deptname"));
if (actionRequest.getFieldValue(i, "gw") != null) 
this.setGw(actionRequest.getFieldValue(i, "gw"));
if (actionRequest.getFieldValue(i, "gznx") != null) 
this.setGznx(actionRequest.getFieldValue(i, "gznx"));
if (actionRequest.getFieldValue(i, "zzzsbh") != null) 
this.setZzzsbh(actionRequest.getFieldValue(i, "zzzsbh"));
if (actionRequest.getFieldValue(i, "fzdate") != null) 
this.setFzdate(actionRequest.getFieldValue(i, "fzdate"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { JcjgpjryglBean obj = (JcjgpjryglBean)super.clone();obj.setSysno(obj.sysno);
obj.setJgbh(obj.jgbh);
obj.setJgmc(obj.jgmc);
obj.setNo(obj.no);
obj.setName(obj.name);
obj.setSex(obj.sex);
obj.setBirthday(obj.birthday);
obj.setXl(obj.xl);
obj.setSxzy(obj.sxzy);
obj.setZw(obj.zw);
obj.setZc(obj.zc);
obj.setDeptno(obj.deptno);
obj.setDeptname(obj.deptname);
obj.setGw(obj.gw);
obj.setGznx(obj.gznx);
obj.setZzzsbh(obj.zzzsbh);
obj.setFzdate(obj.fzdate);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}