package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyzybzlqkBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyzybzlqkBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyzybzlqkBean().findAndLockByWhere(sSqlWhere);      }       public static QyzybzlqkBean findFirst(String sSqlWhere)throws Exception {           return (QyzybzlqkBean)new QyzybzlqkBean().findFirstByWhere(sSqlWhere);      }       public static QyzybzlqkBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyzybzlqkBean)new QyzybzlqkBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyzybzlqkBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybzlqkBean bean = new QyzybzlqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzybzlqkBean bean = new QyzybzlqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyzybzlqkBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybzlqkBean bean = new QyzybzlqkBean();           bean.setAutoRelease(isAutoRelease);           return (QyzybzlqkBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyzybzlqkBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzybzlqkBean bean = new QyzybzlqkBean();           bean.setAutoRelease(isAutoRelease);           return (QyzybzlqkBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybzlqkBean bean = new QyzybzlqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  ldzbh;
String  ldzxm;
String  zddwbh;
String  zddwmc;
String  sfdl;
String  zybyldy;
String  zybjt;
String  zybhlf;
String  fzqjf;
String  scfxf;
String  zzscbzj;
String  ydajbzf;
String  jybzj;
String  ylf;
String  szbzj;
String  gyqsfxj;
String  ycbzj;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qyzybzlqk";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyzybzlqkBean abb = new QyzybzlqkBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.ldzbh=rs.getString("ldzbh");
abb.setKeyValue("LDZBH","" + abb.getLdzbh());
abb.ldzxm=rs.getString("ldzxm");
abb.setKeyValue("LDZXM","" + abb.getLdzxm());
abb.zddwbh=rs.getString("zddwbh");
abb.setKeyValue("ZDDWBH","" + abb.getZddwbh());
abb.zddwmc=rs.getString("zddwmc");
abb.setKeyValue("ZDDWMC","" + abb.getZddwmc());
abb.sfdl=rs.getString("sfdl");
abb.setKeyValue("SFDL","" + abb.getSfdl());
abb.zybyldy=rs.getString("zybyldy");
abb.setKeyValue("ZYBYLDY","" + abb.getZybyldy());
abb.zybjt=rs.getString("zybjt");
abb.setKeyValue("ZYBJT","" + abb.getZybjt());
abb.zybhlf=rs.getString("zybhlf");
abb.setKeyValue("ZYBHLF","" + abb.getZybhlf());
abb.fzqjf=rs.getString("fzqjf");
abb.setKeyValue("FZQJF","" + abb.getFzqjf());
abb.scfxf=rs.getString("scfxf");
abb.setKeyValue("SCFXF","" + abb.getScfxf());
abb.zzscbzj=rs.getString("zzscbzj");
abb.setKeyValue("ZZSCBZJ","" + abb.getZzscbzj());
abb.ydajbzf=rs.getString("ydajbzf");
abb.setKeyValue("YDAJBZF","" + abb.getYdajbzf());
abb.jybzj=rs.getString("jybzj");
abb.setKeyValue("JYBZJ","" + abb.getJybzj());
abb.ylf=rs.getString("ylf");
abb.setKeyValue("YLF","" + abb.getYlf());
abb.szbzj=rs.getString("szbzj");
abb.setKeyValue("SZBZJ","" + abb.getSzbzj());
abb.gyqsfxj=rs.getString("gyqsfxj");
abb.setKeyValue("GYQSFXJ","" + abb.getGyqsfxj());
abb.ycbzj=rs.getString("ycbzj");
abb.setKeyValue("YCBZJ","" + abb.getYcbzj());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getLdzbh(){ if ( this.ldzbh == null){ return ""; } else {return this.ldzbh;}}public String getLdzxm(){ if ( this.ldzxm == null){ return ""; } else {return this.ldzxm;}}public String getZddwbh(){ if ( this.zddwbh == null){ return ""; } else {return this.zddwbh;}}public String getZddwmc(){ if ( this.zddwmc == null){ return ""; } else {return this.zddwmc;}}public String getSfdl(){ if ( this.sfdl == null){ return ""; } else {return this.sfdl;}}public String getZybyldy(){ if ( this.zybyldy == null){ return ""; } else {return this.zybyldy;}}public String getZybjt(){ if ( this.zybjt == null){ return ""; } else {return this.zybjt;}}public String getZybhlf(){ if ( this.zybhlf == null){ return ""; } else {return this.zybhlf;}}public String getFzqjf(){ if ( this.fzqjf == null){ return ""; } else {return this.fzqjf;}}public String getScfxf(){ if ( this.scfxf == null){ return ""; } else {return this.scfxf;}}public String getZzscbzj(){ if ( this.zzscbzj == null){ return ""; } else {return this.zzscbzj;}}public String getYdajbzf(){ if ( this.ydajbzf == null){ return ""; } else {return this.ydajbzf;}}public String getJybzj(){ if ( this.jybzj == null){ return ""; } else {return this.jybzj;}}public String getYlf(){ if ( this.ylf == null){ return ""; } else {return this.ylf;}}public String getSzbzj(){ if ( this.szbzj == null){ return ""; } else {return this.szbzj;}}public String getGyqsfxj(){ if ( this.gyqsfxj == null){ return ""; } else {return this.gyqsfxj;}}public String getYcbzj(){ if ( this.ycbzj == null){ return ""; } else {return this.ycbzj;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setZddwbh( String zddwbh){sqlMaker.setField("zddwbh",zddwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZddwbh().equals(zddwbh))
cf.add("zddwbh",this.zddwbh,zddwbh);
}
this.zddwbh=zddwbh;
}
public void setZddwmc( String zddwmc){sqlMaker.setField("zddwmc",zddwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZddwmc().equals(zddwmc))
cf.add("zddwmc",this.zddwmc,zddwmc);
}
this.zddwmc=zddwmc;
}
public void setSfdl( String sfdl){sqlMaker.setField("sfdl",sfdl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfdl().equals(sfdl))
cf.add("sfdl",this.sfdl,sfdl);
}
this.sfdl=sfdl;
}
public void setZybyldy( String zybyldy){sqlMaker.setField("zybyldy",zybyldy,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getZybyldy().equals(zybyldy))
cf.add("zybyldy",this.zybyldy,zybyldy);
}
this.zybyldy=zybyldy;
}
public void setZybjt( String zybjt){sqlMaker.setField("zybjt",zybjt,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getZybjt().equals(zybjt))
cf.add("zybjt",this.zybjt,zybjt);
}
this.zybjt=zybjt;
}
public void setZybhlf( String zybhlf){sqlMaker.setField("zybhlf",zybhlf,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getZybhlf().equals(zybhlf))
cf.add("zybhlf",this.zybhlf,zybhlf);
}
this.zybhlf=zybhlf;
}
public void setFzqjf( String fzqjf){sqlMaker.setField("fzqjf",fzqjf,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getFzqjf().equals(fzqjf))
cf.add("fzqjf",this.fzqjf,fzqjf);
}
this.fzqjf=fzqjf;
}
public void setScfxf( String scfxf){sqlMaker.setField("scfxf",scfxf,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getScfxf().equals(scfxf))
cf.add("scfxf",this.scfxf,scfxf);
}
this.scfxf=scfxf;
}
public void setZzscbzj( String zzscbzj){sqlMaker.setField("zzscbzj",zzscbzj,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getZzscbzj().equals(zzscbzj))
cf.add("zzscbzj",this.zzscbzj,zzscbzj);
}
this.zzscbzj=zzscbzj;
}
public void setYdajbzf( String ydajbzf){sqlMaker.setField("ydajbzf",ydajbzf,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getYdajbzf().equals(ydajbzf))
cf.add("ydajbzf",this.ydajbzf,ydajbzf);
}
this.ydajbzf=ydajbzf;
}
public void setJybzj( String jybzj){sqlMaker.setField("jybzj",jybzj,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getJybzj().equals(jybzj))
cf.add("jybzj",this.jybzj,jybzj);
}
this.jybzj=jybzj;
}
public void setYlf( String ylf){sqlMaker.setField("ylf",ylf,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getYlf().equals(ylf))
cf.add("ylf",this.ylf,ylf);
}
this.ylf=ylf;
}
public void setSzbzj( String szbzj){sqlMaker.setField("szbzj",szbzj,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getSzbzj().equals(szbzj))
cf.add("szbzj",this.szbzj,szbzj);
}
this.szbzj=szbzj;
}
public void setGyqsfxj( String gyqsfxj){sqlMaker.setField("gyqsfxj",gyqsfxj,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getGyqsfxj().equals(gyqsfxj))
cf.add("gyqsfxj",this.gyqsfxj,gyqsfxj);
}
this.gyqsfxj=gyqsfxj;
}
public void setYcbzj( String ycbzj){sqlMaker.setField("ycbzj",ycbzj,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getYcbzj().equals(ycbzj))
cf.add("ycbzj",this.ycbzj,ycbzj);
}
this.ycbzj=ycbzj;
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
if (actionRequest.getFieldValue(i, "zddwbh") != null) 
this.setZddwbh(actionRequest.getFieldValue(i, "zddwbh"));
if (actionRequest.getFieldValue(i, "zddwmc") != null) 
this.setZddwmc(actionRequest.getFieldValue(i, "zddwmc"));
if (actionRequest.getFieldValue(i, "sfdl") != null) 
this.setSfdl(actionRequest.getFieldValue(i, "sfdl"));
if (actionRequest.getFieldValue(i, "zybyldy") != null) 
this.setZybyldy(actionRequest.getFieldValue(i, "zybyldy"));
if (actionRequest.getFieldValue(i, "zybjt") != null) 
this.setZybjt(actionRequest.getFieldValue(i, "zybjt"));
if (actionRequest.getFieldValue(i, "zybhlf") != null) 
this.setZybhlf(actionRequest.getFieldValue(i, "zybhlf"));
if (actionRequest.getFieldValue(i, "fzqjf") != null) 
this.setFzqjf(actionRequest.getFieldValue(i, "fzqjf"));
if (actionRequest.getFieldValue(i, "scfxf") != null) 
this.setScfxf(actionRequest.getFieldValue(i, "scfxf"));
if (actionRequest.getFieldValue(i, "zzscbzj") != null) 
this.setZzscbzj(actionRequest.getFieldValue(i, "zzscbzj"));
if (actionRequest.getFieldValue(i, "ydajbzf") != null) 
this.setYdajbzf(actionRequest.getFieldValue(i, "ydajbzf"));
if (actionRequest.getFieldValue(i, "jybzj") != null) 
this.setJybzj(actionRequest.getFieldValue(i, "jybzj"));
if (actionRequest.getFieldValue(i, "ylf") != null) 
this.setYlf(actionRequest.getFieldValue(i, "ylf"));
if (actionRequest.getFieldValue(i, "szbzj") != null) 
this.setSzbzj(actionRequest.getFieldValue(i, "szbzj"));
if (actionRequest.getFieldValue(i, "gyqsfxj") != null) 
this.setGyqsfxj(actionRequest.getFieldValue(i, "gyqsfxj"));
if (actionRequest.getFieldValue(i, "ycbzj") != null) 
this.setYcbzj(actionRequest.getFieldValue(i, "ycbzj"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyzybzlqkBean obj = (QyzybzlqkBean)super.clone();obj.setSysno(obj.sysno);
obj.setLdzbh(obj.ldzbh);
obj.setLdzxm(obj.ldzxm);
obj.setZddwbh(obj.zddwbh);
obj.setZddwmc(obj.zddwmc);
obj.setSfdl(obj.sfdl);
obj.setZybyldy(obj.zybyldy);
obj.setZybjt(obj.zybjt);
obj.setZybhlf(obj.zybhlf);
obj.setFzqjf(obj.fzqjf);
obj.setScfxf(obj.scfxf);
obj.setZzscbzj(obj.zzscbzj);
obj.setYdajbzf(obj.ydajbzf);
obj.setJybzj(obj.jybzj);
obj.setYlf(obj.ylf);
obj.setSzbzj(obj.szbzj);
obj.setGyqsfxj(obj.gyqsfxj);
obj.setYcbzj(obj.ycbzj);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}