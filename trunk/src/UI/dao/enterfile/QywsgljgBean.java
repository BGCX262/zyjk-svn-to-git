package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QywsgljgBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QywsgljgBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QywsgljgBean().findAndLockByWhere(sSqlWhere);      }       public static QywsgljgBean findFirst(String sSqlWhere)throws Exception {           return (QywsgljgBean)new QywsgljgBean().findFirstByWhere(sSqlWhere);      }       public static QywsgljgBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QywsgljgBean)new QywsgljgBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QywsgljgBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QywsgljgBean bean = new QywsgljgBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QywsgljgBean bean = new QywsgljgBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QywsgljgBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QywsgljgBean bean = new QywsgljgBean();           bean.setAutoRelease(isAutoRelease);           return (QywsgljgBean)bean.findFirstByWhere(sSqlWhere);      }       public static QywsgljgBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QywsgljgBean bean = new QywsgljgBean();           bean.setAutoRelease(isAutoRelease);           return (QywsgljgBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QywsgljgBean bean = new QywsgljgBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  enterno;
String  jgbh;
String  jgmc;
String  creardate;
String  fgfzr;
String  fgfzrdh;
String  fgfzrsj;
String  jgrs;
String  glrs;
String  zzfzrs;
String  jzfzrs;
String  jgfzr;
String  jgfzrdh;
String  jgfzrsj;
String  fzrzw;
String  fzrzc;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qywsgljg";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QywsgljgBean abb = new QywsgljgBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.jgbh=rs.getString("jgbh");
abb.setKeyValue("JGBH","" + abb.getJgbh());
abb.jgmc=rs.getString("jgmc");
abb.setKeyValue("JGMC","" + abb.getJgmc());
abb.creardate=rs.getString("creardate");
abb.setKeyValue("CREARDATE","" + abb.getCreardate());
abb.fgfzr=rs.getString("fgfzr");
abb.setKeyValue("FGFZR","" + abb.getFgfzr());
abb.fgfzrdh=rs.getString("fgfzrdh");
abb.setKeyValue("FGFZRDH","" + abb.getFgfzrdh());
abb.fgfzrsj=rs.getString("fgfzrsj");
abb.setKeyValue("FGFZRSJ","" + abb.getFgfzrsj());
abb.jgrs=rs.getString("jgrs");
abb.setKeyValue("JGRS","" + abb.getJgrs());
abb.glrs=rs.getString("glrs");
abb.setKeyValue("GLRS","" + abb.getGlrs());
abb.zzfzrs=rs.getString("zzfzrs");
abb.setKeyValue("ZZFZRS","" + abb.getZzfzrs());
abb.jzfzrs=rs.getString("jzfzrs");
abb.setKeyValue("JZFZRS","" + abb.getJzfzrs());
abb.jgfzr=rs.getString("jgfzr");
abb.setKeyValue("JGFZR","" + abb.getJgfzr());
abb.jgfzrdh=rs.getString("jgfzrdh");
abb.setKeyValue("JGFZRDH","" + abb.getJgfzrdh());
abb.jgfzrsj=rs.getString("jgfzrsj");
abb.setKeyValue("JGFZRSJ","" + abb.getJgfzrsj());
abb.fzrzw=rs.getString("fzrzw");
abb.setKeyValue("FZRZW","" + abb.getFzrzw());
abb.fzrzc=rs.getString("fzrzc");
abb.setKeyValue("FZRZC","" + abb.getFzrzc());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getJgbh(){ if ( this.jgbh == null){ return ""; } else {return this.jgbh;}}public String getJgmc(){ if ( this.jgmc == null){ return ""; } else {return this.jgmc;}}public String getCreardate(){ if ( this.creardate == null){ return ""; } else {return this.creardate;}}public String getFgfzr(){ if ( this.fgfzr == null){ return ""; } else {return this.fgfzr;}}public String getFgfzrdh(){ if ( this.fgfzrdh == null){ return ""; } else {return this.fgfzrdh;}}public String getFgfzrsj(){ if ( this.fgfzrsj == null){ return ""; } else {return this.fgfzrsj;}}public String getJgrs(){ if ( this.jgrs == null){ return ""; } else {return this.jgrs;}}public String getGlrs(){ if ( this.glrs == null){ return ""; } else {return this.glrs;}}public String getZzfzrs(){ if ( this.zzfzrs == null){ return ""; } else {return this.zzfzrs;}}public String getJzfzrs(){ if ( this.jzfzrs == null){ return ""; } else {return this.jzfzrs;}}public String getJgfzr(){ if ( this.jgfzr == null){ return ""; } else {return this.jgfzr;}}public String getJgfzrdh(){ if ( this.jgfzrdh == null){ return ""; } else {return this.jgfzrdh;}}public String getJgfzrsj(){ if ( this.jgfzrsj == null){ return ""; } else {return this.jgfzrsj;}}public String getFzrzw(){ if ( this.fzrzw == null){ return ""; } else {return this.fzrzw;}}public String getFzrzc(){ if ( this.fzrzc == null){ return ""; } else {return this.fzrzc;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setCreardate( String creardate){sqlMaker.setField("creardate",creardate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCreardate().equals(creardate))
cf.add("creardate",this.creardate,creardate);
}
this.creardate=creardate;
}
public void setFgfzr( String fgfzr){sqlMaker.setField("fgfzr",fgfzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFgfzr().equals(fgfzr))
cf.add("fgfzr",this.fgfzr,fgfzr);
}
this.fgfzr=fgfzr;
}
public void setFgfzrdh( String fgfzrdh){sqlMaker.setField("fgfzrdh",fgfzrdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFgfzrdh().equals(fgfzrdh))
cf.add("fgfzrdh",this.fgfzrdh,fgfzrdh);
}
this.fgfzrdh=fgfzrdh;
}
public void setFgfzrsj( String fgfzrsj){sqlMaker.setField("fgfzrsj",fgfzrsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFgfzrsj().equals(fgfzrsj))
cf.add("fgfzrsj",this.fgfzrsj,fgfzrsj);
}
this.fgfzrsj=fgfzrsj;
}
public void setJgrs( String jgrs){sqlMaker.setField("jgrs",jgrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgrs().equals(jgrs))
cf.add("jgrs",this.jgrs,jgrs);
}
this.jgrs=jgrs;
}
public void setGlrs( String glrs){sqlMaker.setField("glrs",glrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGlrs().equals(glrs))
cf.add("glrs",this.glrs,glrs);
}
this.glrs=glrs;
}
public void setZzfzrs( String zzfzrs){sqlMaker.setField("zzfzrs",zzfzrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZzfzrs().equals(zzfzrs))
cf.add("zzfzrs",this.zzfzrs,zzfzrs);
}
this.zzfzrs=zzfzrs;
}
public void setJzfzrs( String jzfzrs){sqlMaker.setField("jzfzrs",jzfzrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJzfzrs().equals(jzfzrs))
cf.add("jzfzrs",this.jzfzrs,jzfzrs);
}
this.jzfzrs=jzfzrs;
}
public void setJgfzr( String jgfzr){sqlMaker.setField("jgfzr",jgfzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgfzr().equals(jgfzr))
cf.add("jgfzr",this.jgfzr,jgfzr);
}
this.jgfzr=jgfzr;
}
public void setJgfzrdh( String jgfzrdh){sqlMaker.setField("jgfzrdh",jgfzrdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgfzrdh().equals(jgfzrdh))
cf.add("jgfzrdh",this.jgfzrdh,jgfzrdh);
}
this.jgfzrdh=jgfzrdh;
}
public void setJgfzrsj( String jgfzrsj){sqlMaker.setField("jgfzrsj",jgfzrsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgfzrsj().equals(jgfzrsj))
cf.add("jgfzrsj",this.jgfzrsj,jgfzrsj);
}
this.jgfzrsj=jgfzrsj;
}
public void setFzrzw( String fzrzw){sqlMaker.setField("fzrzw",fzrzw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzrzw().equals(fzrzw))
cf.add("fzrzw",this.fzrzw,fzrzw);
}
this.fzrzw=fzrzw;
}
public void setFzrzc( String fzrzc){sqlMaker.setField("fzrzc",fzrzc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzrzc().equals(fzrzc))
cf.add("fzrzc",this.fzrzc,fzrzc);
}
this.fzrzc=fzrzc;
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
if (actionRequest.getFieldValue(i, "jgbh") != null) 
this.setJgbh(actionRequest.getFieldValue(i, "jgbh"));
if (actionRequest.getFieldValue(i, "jgmc") != null) 
this.setJgmc(actionRequest.getFieldValue(i, "jgmc"));
if (actionRequest.getFieldValue(i, "creardate") != null) 
this.setCreardate(actionRequest.getFieldValue(i, "creardate"));
if (actionRequest.getFieldValue(i, "fgfzr") != null) 
this.setFgfzr(actionRequest.getFieldValue(i, "fgfzr"));
if (actionRequest.getFieldValue(i, "fgfzrdh") != null) 
this.setFgfzrdh(actionRequest.getFieldValue(i, "fgfzrdh"));
if (actionRequest.getFieldValue(i, "fgfzrsj") != null) 
this.setFgfzrsj(actionRequest.getFieldValue(i, "fgfzrsj"));
if (actionRequest.getFieldValue(i, "jgrs") != null) 
this.setJgrs(actionRequest.getFieldValue(i, "jgrs"));
if (actionRequest.getFieldValue(i, "glrs") != null) 
this.setGlrs(actionRequest.getFieldValue(i, "glrs"));
if (actionRequest.getFieldValue(i, "zzfzrs") != null) 
this.setZzfzrs(actionRequest.getFieldValue(i, "zzfzrs"));
if (actionRequest.getFieldValue(i, "jzfzrs") != null) 
this.setJzfzrs(actionRequest.getFieldValue(i, "jzfzrs"));
if (actionRequest.getFieldValue(i, "jgfzr") != null) 
this.setJgfzr(actionRequest.getFieldValue(i, "jgfzr"));
if (actionRequest.getFieldValue(i, "jgfzrdh") != null) 
this.setJgfzrdh(actionRequest.getFieldValue(i, "jgfzrdh"));
if (actionRequest.getFieldValue(i, "jgfzrsj") != null) 
this.setJgfzrsj(actionRequest.getFieldValue(i, "jgfzrsj"));
if (actionRequest.getFieldValue(i, "fzrzw") != null) 
this.setFzrzw(actionRequest.getFieldValue(i, "fzrzw"));
if (actionRequest.getFieldValue(i, "fzrzc") != null) 
this.setFzrzc(actionRequest.getFieldValue(i, "fzrzc"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QywsgljgBean obj = (QywsgljgBean)super.clone();obj.setSysno(obj.sysno);
obj.setEnterno(obj.enterno);
obj.setJgbh(obj.jgbh);
obj.setJgmc(obj.jgmc);
obj.setCreardate(obj.creardate);
obj.setFgfzr(obj.fgfzr);
obj.setFgfzrdh(obj.fgfzrdh);
obj.setFgfzrsj(obj.fgfzrsj);
obj.setJgrs(obj.jgrs);
obj.setGlrs(obj.glrs);
obj.setZzfzrs(obj.zzfzrs);
obj.setJzfzrs(obj.jzfzrs);
obj.setJgfzr(obj.jgfzr);
obj.setJgfzrdh(obj.jgfzrdh);
obj.setJgfzrsj(obj.jgfzrsj);
obj.setFzrzw(obj.fzrzw);
obj.setFzrzc(obj.fzrzc);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}