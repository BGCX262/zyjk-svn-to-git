package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyzywsjkjcjgBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyzywsjkjcjgBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyzywsjkjcjgBean().findAndLockByWhere(sSqlWhere);      }       public static QyzywsjkjcjgBean findFirst(String sSqlWhere)throws Exception {           return (QyzywsjkjcjgBean)new QyzywsjkjcjgBean().findFirstByWhere(sSqlWhere);      }       public static QyzywsjkjcjgBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyzywsjkjcjgBean)new QyzywsjkjcjgBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyzywsjkjcjgBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzywsjkjcjgBean bean = new QyzywsjkjcjgBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzywsjkjcjgBean bean = new QyzywsjkjcjgBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyzywsjkjcjgBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzywsjkjcjgBean bean = new QyzywsjkjcjgBean();           bean.setAutoRelease(isAutoRelease);           return (QyzywsjkjcjgBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyzywsjkjcjgBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzywsjkjcjgBean bean = new QyzywsjkjcjgBean();           bean.setAutoRelease(isAutoRelease);           return (QyzywsjkjcjgBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzywsjkjcjgBean bean = new QyzywsjkjcjgBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  ldzbh;
String  ldzxm;
String  enterno;
String  entername;
String  jcdate;
String  fc;
String  dw;
String  wl;
String  gq;
String  gz;
String  lg;
String  normal;
String  recheck;
String  patient;
String  jjz;
String  qtjh;
String  tjdwbh;
String  tjdwmc;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qyzywsjkjcjg";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyzywsjkjcjgBean abb = new QyzywsjkjcjgBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.ldzbh=rs.getString("ldzbh");
abb.setKeyValue("LDZBH","" + abb.getLdzbh());
abb.ldzxm=rs.getString("ldzxm");
abb.setKeyValue("LDZXM","" + abb.getLdzxm());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.entername=rs.getString("entername");
abb.setKeyValue("ENTERNAME","" + abb.getEntername());
abb.jcdate=rs.getString("jcdate");
abb.setKeyValue("JCDATE","" + abb.getJcdate());
abb.fc=rs.getString("fc");
abb.setKeyValue("FC","" + abb.getFc());
abb.dw=rs.getString("dw");
abb.setKeyValue("DW","" + abb.getDw());
abb.wl=rs.getString("wl");
abb.setKeyValue("WL","" + abb.getWl());
abb.gq=rs.getString("gq");
abb.setKeyValue("GQ","" + abb.getGq());
abb.gz=rs.getString("gz");
abb.setKeyValue("GZ","" + abb.getGz());
abb.lg=rs.getString("lg");
abb.setKeyValue("LG","" + abb.getLg());
abb.normal=rs.getString("normal");
abb.setKeyValue("NORMAL","" + abb.getNormal());
abb.recheck=rs.getString("recheck");
abb.setKeyValue("RECHECK","" + abb.getRecheck());
abb.patient=rs.getString("patient");
abb.setKeyValue("PATIENT","" + abb.getPatient());
abb.jjz=rs.getString("jjz");
abb.setKeyValue("JJZ","" + abb.getJjz());
abb.qtjh=rs.getString("qtjh");
abb.setKeyValue("QTJH","" + abb.getQtjh());
abb.tjdwbh=rs.getString("tjdwbh");
abb.setKeyValue("TJDWBH","" + abb.getTjdwbh());
abb.tjdwmc=rs.getString("tjdwmc");
abb.setKeyValue("TJDWMC","" + abb.getTjdwmc());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getLdzbh(){ if ( this.ldzbh == null){ return ""; } else {return this.ldzbh;}}public String getLdzxm(){ if ( this.ldzxm == null){ return ""; } else {return this.ldzxm;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getEntername(){ if ( this.entername == null){ return ""; } else {return this.entername;}}public String getJcdate(){ if ( this.jcdate == null){ return ""; } else {return this.jcdate;}}public String getFc(){ if ( this.fc == null){ return ""; } else {return this.fc;}}public String getDw(){ if ( this.dw == null){ return ""; } else {return this.dw;}}public String getWl(){ if ( this.wl == null){ return ""; } else {return this.wl;}}public String getGq(){ if ( this.gq == null){ return ""; } else {return this.gq;}}public String getGz(){ if ( this.gz == null){ return ""; } else {return this.gz;}}public String getLg(){ if ( this.lg == null){ return ""; } else {return this.lg;}}public String getNormal(){ if ( this.normal == null){ return ""; } else {return this.normal;}}public String getRecheck(){ if ( this.recheck == null){ return ""; } else {return this.recheck;}}public String getPatient(){ if ( this.patient == null){ return ""; } else {return this.patient;}}public String getJjz(){ if ( this.jjz == null){ return ""; } else {return this.jjz;}}public String getQtjh(){ if ( this.qtjh == null){ return ""; } else {return this.qtjh;}}public String getTjdwbh(){ if ( this.tjdwbh == null){ return ""; } else {return this.tjdwbh;}}public String getTjdwmc(){ if ( this.tjdwmc == null){ return ""; } else {return this.tjdwmc;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
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
public void setJcdate( String jcdate){sqlMaker.setField("jcdate",jcdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcdate().equals(jcdate))
cf.add("jcdate",this.jcdate,jcdate);
}
this.jcdate=jcdate;
}
public void setFc( String fc){sqlMaker.setField("fc",fc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFc().equals(fc))
cf.add("fc",this.fc,fc);
}
this.fc=fc;
}
public void setDw( String dw){sqlMaker.setField("dw",dw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDw().equals(dw))
cf.add("dw",this.dw,dw);
}
this.dw=dw;
}
public void setWl( String wl){sqlMaker.setField("wl",wl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWl().equals(wl))
cf.add("wl",this.wl,wl);
}
this.wl=wl;
}
public void setGq( String gq){sqlMaker.setField("gq",gq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGq().equals(gq))
cf.add("gq",this.gq,gq);
}
this.gq=gq;
}
public void setGz( String gz){sqlMaker.setField("gz",gz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGz().equals(gz))
cf.add("gz",this.gz,gz);
}
this.gz=gz;
}
public void setLg( String lg){sqlMaker.setField("lg",lg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLg().equals(lg))
cf.add("lg",this.lg,lg);
}
this.lg=lg;
}
public void setNormal( String normal){sqlMaker.setField("normal",normal,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNormal().equals(normal))
cf.add("normal",this.normal,normal);
}
this.normal=normal;
}
public void setRecheck( String recheck){sqlMaker.setField("recheck",recheck,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRecheck().equals(recheck))
cf.add("recheck",this.recheck,recheck);
}
this.recheck=recheck;
}
public void setPatient( String patient){sqlMaker.setField("patient",patient,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPatient().equals(patient))
cf.add("patient",this.patient,patient);
}
this.patient=patient;
}
public void setJjz( String jjz){sqlMaker.setField("jjz",jjz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJjz().equals(jjz))
cf.add("jjz",this.jjz,jjz);
}
this.jjz=jjz;
}
public void setQtjh( String qtjh){sqlMaker.setField("qtjh",qtjh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getQtjh().equals(qtjh))
cf.add("qtjh",this.qtjh,qtjh);
}
this.qtjh=qtjh;
}
public void setTjdwbh( String tjdwbh){sqlMaker.setField("tjdwbh",tjdwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTjdwbh().equals(tjdwbh))
cf.add("tjdwbh",this.tjdwbh,tjdwbh);
}
this.tjdwbh=tjdwbh;
}
public void setTjdwmc( String tjdwmc){sqlMaker.setField("tjdwmc",tjdwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTjdwmc().equals(tjdwmc))
cf.add("tjdwmc",this.tjdwmc,tjdwmc);
}
this.tjdwmc=tjdwmc;
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
if (actionRequest.getFieldValue(i, "ldzbh") != null) 
this.setLdzbh(actionRequest.getFieldValue(i, "ldzbh"));
if (actionRequest.getFieldValue(i, "ldzxm") != null) 
this.setLdzxm(actionRequest.getFieldValue(i, "ldzxm"));
if (actionRequest.getFieldValue(i, "enterno") != null) 
this.setEnterno(actionRequest.getFieldValue(i, "enterno"));
if (actionRequest.getFieldValue(i, "entername") != null) 
this.setEntername(actionRequest.getFieldValue(i, "entername"));
if (actionRequest.getFieldValue(i, "jcdate") != null) 
this.setJcdate(actionRequest.getFieldValue(i, "jcdate"));
if (actionRequest.getFieldValue(i, "fc") != null) 
this.setFc(actionRequest.getFieldValue(i, "fc"));
if (actionRequest.getFieldValue(i, "dw") != null) 
this.setDw(actionRequest.getFieldValue(i, "dw"));
if (actionRequest.getFieldValue(i, "wl") != null) 
this.setWl(actionRequest.getFieldValue(i, "wl"));
if (actionRequest.getFieldValue(i, "gq") != null) 
this.setGq(actionRequest.getFieldValue(i, "gq"));
if (actionRequest.getFieldValue(i, "gz") != null) 
this.setGz(actionRequest.getFieldValue(i, "gz"));
if (actionRequest.getFieldValue(i, "lg") != null) 
this.setLg(actionRequest.getFieldValue(i, "lg"));
if (actionRequest.getFieldValue(i, "normal") != null) 
this.setNormal(actionRequest.getFieldValue(i, "normal"));
if (actionRequest.getFieldValue(i, "recheck") != null) 
this.setRecheck(actionRequest.getFieldValue(i, "recheck"));
if (actionRequest.getFieldValue(i, "patient") != null) 
this.setPatient(actionRequest.getFieldValue(i, "patient"));
if (actionRequest.getFieldValue(i, "jjz") != null) 
this.setJjz(actionRequest.getFieldValue(i, "jjz"));
if (actionRequest.getFieldValue(i, "qtjh") != null) 
this.setQtjh(actionRequest.getFieldValue(i, "qtjh"));
if (actionRequest.getFieldValue(i, "tjdwbh") != null) 
this.setTjdwbh(actionRequest.getFieldValue(i, "tjdwbh"));
if (actionRequest.getFieldValue(i, "tjdwmc") != null) 
this.setTjdwmc(actionRequest.getFieldValue(i, "tjdwmc"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyzywsjkjcjgBean obj = (QyzywsjkjcjgBean)super.clone();obj.setSysno(obj.sysno);
obj.setLdzbh(obj.ldzbh);
obj.setLdzxm(obj.ldzxm);
obj.setEnterno(obj.enterno);
obj.setEntername(obj.entername);
obj.setJcdate(obj.jcdate);
obj.setFc(obj.fc);
obj.setDw(obj.dw);
obj.setWl(obj.wl);
obj.setGq(obj.gq);
obj.setGz(obj.gz);
obj.setLg(obj.lg);
obj.setNormal(obj.normal);
obj.setRecheck(obj.recheck);
obj.setPatient(obj.patient);
obj.setJjz(obj.jjz);
obj.setQtjh(obj.qtjh);
obj.setTjdwbh(obj.tjdwbh);
obj.setTjdwmc(obj.tjdwmc);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}