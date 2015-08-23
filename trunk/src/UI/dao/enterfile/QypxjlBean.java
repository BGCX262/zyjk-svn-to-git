package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QypxjlBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QypxjlBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QypxjlBean().findAndLockByWhere(sSqlWhere);      }       public static QypxjlBean findFirst(String sSqlWhere)throws Exception {           return (QypxjlBean)new QypxjlBean().findFirstByWhere(sSqlWhere);      }       public static QypxjlBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QypxjlBean)new QypxjlBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QypxjlBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QypxjlBean bean = new QypxjlBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QypxjlBean bean = new QypxjlBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QypxjlBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QypxjlBean bean = new QypxjlBean();           bean.setAutoRelease(isAutoRelease);           return (QypxjlBean)bean.findFirstByWhere(sSqlWhere);      }       public static QypxjlBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QypxjlBean bean = new QypxjlBean();           bean.setAutoRelease(isAutoRelease);           return (QypxjlBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QypxjlBean bean = new QypxjlBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  enterno;
String  enternm;
String  rybh;
String  ryxm;
String  pxlx;
String  cj;
String  gz;
String  fj;
String  pxdate;
String  pxjgno;
String  pxjgmc;
String  pxxs;
String  llkh;
String  sckh;
String  bkqk;
String  kcmc;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qypxjl";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QypxjlBean abb = new QypxjlBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.enternm=rs.getString("enternm");
abb.setKeyValue("ENTERNM","" + abb.getEnternm());
abb.rybh=rs.getString("rybh");
abb.setKeyValue("RYBH","" + abb.getRybh());
abb.ryxm=rs.getString("ryxm");
abb.setKeyValue("RYXM","" + abb.getRyxm());
abb.pxlx=rs.getString("pxlx");
abb.setKeyValue("PXLX","" + abb.getPxlx());
abb.cj=rs.getString("cj");
abb.setKeyValue("CJ","" + abb.getCj());
abb.gz=rs.getString("gz");
abb.setKeyValue("GZ","" + abb.getGz());
abb.fj=rs.getString("fj");
abb.setKeyValue("FJ","" + abb.getFj());
abb.pxdate=rs.getString("pxdate");
abb.setKeyValue("PXDATE","" + abb.getPxdate());
abb.pxjgno=rs.getString("pxjgno");
abb.setKeyValue("PXJGNO","" + abb.getPxjgno());
abb.pxjgmc=rs.getString("pxjgmc");
abb.setKeyValue("PXJGMC","" + abb.getPxjgmc());
abb.pxxs=rs.getString("pxxs");
abb.setKeyValue("PXXS","" + abb.getPxxs());
abb.llkh=rs.getString("llkh");
abb.setKeyValue("LLKH","" + abb.getLlkh());
abb.sckh=rs.getString("sckh");
abb.setKeyValue("SCKH","" + abb.getSckh());
abb.bkqk=rs.getString("bkqk");
abb.setKeyValue("BKQK","" + abb.getBkqk());
abb.kcmc=rs.getString("kcmc");
abb.setKeyValue("KCMC","" + abb.getKcmc());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getEnternm(){ if ( this.enternm == null){ return ""; } else {return this.enternm;}}public String getRybh(){ if ( this.rybh == null){ return ""; } else {return this.rybh;}}public String getRyxm(){ if ( this.ryxm == null){ return ""; } else {return this.ryxm;}}public String getPxlx(){ if ( this.pxlx == null){ return ""; } else {return this.pxlx;}}public String getCj(){ if ( this.cj == null){ return ""; } else {return this.cj;}}public String getGz(){ if ( this.gz == null){ return ""; } else {return this.gz;}}public String getFj(){ if ( this.fj == null){ return ""; } else {return this.fj;}}public String getPxdate(){ if ( this.pxdate == null){ return ""; } else {return this.pxdate;}}public String getPxjgno(){ if ( this.pxjgno == null){ return ""; } else {return this.pxjgno;}}public String getPxjgmc(){ if ( this.pxjgmc == null){ return ""; } else {return this.pxjgmc;}}public String getPxxs(){ if ( this.pxxs == null){ return ""; } else {return this.pxxs;}}public String getLlkh(){ if ( this.llkh == null){ return ""; } else {return this.llkh;}}public String getSckh(){ if ( this.sckh == null){ return ""; } else {return this.sckh;}}public String getBkqk(){ if ( this.bkqk == null){ return ""; } else {return this.bkqk;}}public String getKcmc(){ if ( this.kcmc == null){ return ""; } else {return this.kcmc;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setEnternm( String enternm){sqlMaker.setField("enternm",enternm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnternm().equals(enternm))
cf.add("enternm",this.enternm,enternm);
}
this.enternm=enternm;
}
public void setRybh( String rybh){sqlMaker.setField("rybh",rybh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRybh().equals(rybh))
cf.add("rybh",this.rybh,rybh);
}
this.rybh=rybh;
}
public void setRyxm( String ryxm){sqlMaker.setField("ryxm",ryxm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRyxm().equals(ryxm))
cf.add("ryxm",this.ryxm,ryxm);
}
this.ryxm=ryxm;
}
public void setPxlx( String pxlx){sqlMaker.setField("pxlx",pxlx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxlx().equals(pxlx))
cf.add("pxlx",this.pxlx,pxlx);
}
this.pxlx=pxlx;
}
public void setCj( String cj){sqlMaker.setField("cj",cj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCj().equals(cj))
cf.add("cj",this.cj,cj);
}
this.cj=cj;
}
public void setGz( String gz){sqlMaker.setField("gz",gz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGz().equals(gz))
cf.add("gz",this.gz,gz);
}
this.gz=gz;
}
public void setFj( String fj){sqlMaker.setField("fj",fj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFj().equals(fj))
cf.add("fj",this.fj,fj);
}
this.fj=fj;
}
public void setPxdate( String pxdate){sqlMaker.setField("pxdate",pxdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxdate().equals(pxdate))
cf.add("pxdate",this.pxdate,pxdate);
}
this.pxdate=pxdate;
}
public void setPxjgno( String pxjgno){sqlMaker.setField("pxjgno",pxjgno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxjgno().equals(pxjgno))
cf.add("pxjgno",this.pxjgno,pxjgno);
}
this.pxjgno=pxjgno;
}
public void setPxjgmc( String pxjgmc){sqlMaker.setField("pxjgmc",pxjgmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxjgmc().equals(pxjgmc))
cf.add("pxjgmc",this.pxjgmc,pxjgmc);
}
this.pxjgmc=pxjgmc;
}
public void setPxxs( String pxxs){sqlMaker.setField("pxxs",pxxs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxxs().equals(pxxs))
cf.add("pxxs",this.pxxs,pxxs);
}
this.pxxs=pxxs;
}
public void setLlkh( String llkh){sqlMaker.setField("llkh",llkh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLlkh().equals(llkh))
cf.add("llkh",this.llkh,llkh);
}
this.llkh=llkh;
}
public void setSckh( String sckh){sqlMaker.setField("sckh",sckh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSckh().equals(sckh))
cf.add("sckh",this.sckh,sckh);
}
this.sckh=sckh;
}
public void setBkqk( String bkqk){sqlMaker.setField("bkqk",bkqk,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBkqk().equals(bkqk))
cf.add("bkqk",this.bkqk,bkqk);
}
this.bkqk=bkqk;
}
public void setKcmc( String kcmc){sqlMaker.setField("kcmc",kcmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getKcmc().equals(kcmc))
cf.add("kcmc",this.kcmc,kcmc);
}
this.kcmc=kcmc;
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
if (actionRequest.getFieldValue(i, "enternm") != null) 
this.setEnternm(actionRequest.getFieldValue(i, "enternm"));
if (actionRequest.getFieldValue(i, "rybh") != null) 
this.setRybh(actionRequest.getFieldValue(i, "rybh"));
if (actionRequest.getFieldValue(i, "ryxm") != null) 
this.setRyxm(actionRequest.getFieldValue(i, "ryxm"));
if (actionRequest.getFieldValue(i, "pxlx") != null) 
this.setPxlx(actionRequest.getFieldValue(i, "pxlx"));
if (actionRequest.getFieldValue(i, "cj") != null) 
this.setCj(actionRequest.getFieldValue(i, "cj"));
if (actionRequest.getFieldValue(i, "gz") != null) 
this.setGz(actionRequest.getFieldValue(i, "gz"));
if (actionRequest.getFieldValue(i, "fj") != null) 
this.setFj(actionRequest.getFieldValue(i, "fj"));
if (actionRequest.getFieldValue(i, "pxdate") != null) 
this.setPxdate(actionRequest.getFieldValue(i, "pxdate"));
if (actionRequest.getFieldValue(i, "pxjgno") != null) 
this.setPxjgno(actionRequest.getFieldValue(i, "pxjgno"));
if (actionRequest.getFieldValue(i, "pxjgmc") != null) 
this.setPxjgmc(actionRequest.getFieldValue(i, "pxjgmc"));
if (actionRequest.getFieldValue(i, "pxxs") != null) 
this.setPxxs(actionRequest.getFieldValue(i, "pxxs"));
if (actionRequest.getFieldValue(i, "llkh") != null) 
this.setLlkh(actionRequest.getFieldValue(i, "llkh"));
if (actionRequest.getFieldValue(i, "sckh") != null) 
this.setSckh(actionRequest.getFieldValue(i, "sckh"));
if (actionRequest.getFieldValue(i, "bkqk") != null) 
this.setBkqk(actionRequest.getFieldValue(i, "bkqk"));
if (actionRequest.getFieldValue(i, "kcmc") != null) 
this.setKcmc(actionRequest.getFieldValue(i, "kcmc"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QypxjlBean obj = (QypxjlBean)super.clone();obj.setSysno(obj.sysno);
obj.setEnterno(obj.enterno);
obj.setEnternm(obj.enternm);
obj.setRybh(obj.rybh);
obj.setRyxm(obj.ryxm);
obj.setPxlx(obj.pxlx);
obj.setCj(obj.cj);
obj.setGz(obj.gz);
obj.setFj(obj.fj);
obj.setPxdate(obj.pxdate);
obj.setPxjgno(obj.pxjgno);
obj.setPxjgmc(obj.pxjgmc);
obj.setPxxs(obj.pxxs);
obj.setLlkh(obj.llkh);
obj.setSckh(obj.sckh);
obj.setBkqk(obj.bkqk);
obj.setKcmc(obj.kcmc);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}