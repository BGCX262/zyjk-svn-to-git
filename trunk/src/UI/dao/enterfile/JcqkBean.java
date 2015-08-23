package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class JcqkBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new JcqkBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new JcqkBean().findAndLockByWhere(sSqlWhere);      }       public static JcqkBean findFirst(String sSqlWhere)throws Exception {           return (JcqkBean)new JcqkBean().findFirstByWhere(sSqlWhere);      }       public static JcqkBean findFirstAndLock(String sSqlWhere)throws Exception {           return (JcqkBean)new JcqkBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new JcqkBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcqkBean bean = new JcqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcqkBean bean = new JcqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static JcqkBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcqkBean bean = new JcqkBean();           bean.setAutoRelease(isAutoRelease);           return (JcqkBean)bean.findFirstByWhere(sSqlWhere);      }       public static JcqkBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcqkBean bean = new JcqkBean();           bean.setAutoRelease(isAutoRelease);           return (JcqkBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcqkBean bean = new JcqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  bgbh;
String  dwbh;
String  dwmc;
String  jcdwbh;
String  jcdwmc;
String  jclb;
String  cj;
String  jcgz;
String  zyd;
String  jcsj;
String  jcxm;
String  ctwa;
String  pcwta;
String  twapd;
String  cstel;
String  pcstel;
String  stelpd;
String  jcnd;
String  cxbs;
String  ndpd;
String  lex8h;
String  zsbzxz;
String  zspd;
String  cljg;
String  zdbzxz;
String  zdpd;
String  dcqd;
String  gpbzxz;
String  gppd;
String  wbgt;
String  gwbzxz;
String  gwpd;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
String  fzdz;
String  bzxz;
String  dxpd;
public static final String TABLENAME ="jcqk";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
JcqkBean abb = new JcqkBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.bgbh=rs.getString("bgbh");
abb.setKeyValue("BGBH","" + abb.getBgbh());
abb.dwbh=rs.getString("dwbh");
abb.setKeyValue("DWBH","" + abb.getDwbh());
abb.dwmc=rs.getString("dwmc");
abb.setKeyValue("DWMC","" + abb.getDwmc());
abb.jcdwbh=rs.getString("jcdwbh");
abb.setKeyValue("JCDWBH","" + abb.getJcdwbh());
abb.jcdwmc=rs.getString("jcdwmc");
abb.setKeyValue("JCDWMC","" + abb.getJcdwmc());
abb.jclb=rs.getString("jclb");
abb.setKeyValue("JCLB","" + abb.getJclb());
abb.cj=rs.getString("cj");
abb.setKeyValue("CJ","" + abb.getCj());
abb.jcgz=rs.getString("jcgz");
abb.setKeyValue("JCGZ","" + abb.getJcgz());
abb.zyd=rs.getString("zyd");
abb.setKeyValue("ZYD","" + abb.getZyd());
abb.jcsj=rs.getString("jcsj");
abb.setKeyValue("JCSJ","" + abb.getJcsj());
abb.jcxm=rs.getString("jcxm");
abb.setKeyValue("JCXM","" + abb.getJcxm());
abb.ctwa=rs.getString("ctwa");
abb.setKeyValue("CTWA","" + abb.getCtwa());
abb.pcwta=rs.getString("pcwta");
abb.setKeyValue("PCWTA","" + abb.getPcwta());
abb.twapd=rs.getString("twapd");
abb.setKeyValue("TWAPD","" + abb.getTwapd());
abb.cstel=rs.getString("cstel");
abb.setKeyValue("CSTEL","" + abb.getCstel());
abb.pcstel=rs.getString("pcstel");
abb.setKeyValue("PCSTEL","" + abb.getPcstel());
abb.stelpd=rs.getString("stelpd");
abb.setKeyValue("STELPD","" + abb.getStelpd());
abb.jcnd=rs.getString("jcnd");
abb.setKeyValue("JCND","" + abb.getJcnd());
abb.cxbs=rs.getString("cxbs");
abb.setKeyValue("CXBS","" + abb.getCxbs());
abb.ndpd=rs.getString("ndpd");
abb.setKeyValue("NDPD","" + abb.getNdpd());
abb.lex8h=rs.getString("lex8h");
abb.setKeyValue("LEX8H","" + abb.getLex8h());
abb.zsbzxz=rs.getString("zsbzxz");
abb.setKeyValue("ZSBZXZ","" + abb.getZsbzxz());
abb.zspd=rs.getString("zspd");
abb.setKeyValue("ZSPD","" + abb.getZspd());
abb.cljg=rs.getString("cljg");
abb.setKeyValue("CLJG","" + abb.getCljg());
abb.zdbzxz=rs.getString("zdbzxz");
abb.setKeyValue("ZDBZXZ","" + abb.getZdbzxz());
abb.zdpd=rs.getString("zdpd");
abb.setKeyValue("ZDPD","" + abb.getZdpd());
abb.dcqd=rs.getString("dcqd");
abb.setKeyValue("DCQD","" + abb.getDcqd());
abb.gpbzxz=rs.getString("gpbzxz");
abb.setKeyValue("GPBZXZ","" + abb.getGpbzxz());
abb.gppd=rs.getString("gppd");
abb.setKeyValue("GPPD","" + abb.getGppd());
abb.wbgt=rs.getString("wbgt");
abb.setKeyValue("WBGT","" + abb.getWbgt());
abb.gwbzxz=rs.getString("gwbzxz");
abb.setKeyValue("GWBZXZ","" + abb.getGwbzxz());
abb.gwpd=rs.getString("gwpd");
abb.setKeyValue("GWPD","" + abb.getGwpd());
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
abb.fzdz=rs.getString("fzdz");
abb.setKeyValue("FZDZ","" + abb.getFzdz());
abb.bzxz=rs.getString("bzxz");
abb.setKeyValue("BZXZ","" + abb.getBzxz());
abb.dxpd=rs.getString("dxpd");
abb.setKeyValue("DXPD","" + abb.getDxpd());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getBgbh(){ if ( this.bgbh == null){ return ""; } else {return this.bgbh;}}public String getDwbh(){ if ( this.dwbh == null){ return ""; } else {return this.dwbh;}}public String getDwmc(){ if ( this.dwmc == null){ return ""; } else {return this.dwmc;}}public String getJcdwbh(){ if ( this.jcdwbh == null){ return ""; } else {return this.jcdwbh;}}public String getJcdwmc(){ if ( this.jcdwmc == null){ return ""; } else {return this.jcdwmc;}}public String getJclb(){ if ( this.jclb == null){ return ""; } else {return this.jclb;}}public String getCj(){ if ( this.cj == null){ return ""; } else {return this.cj;}}public String getJcgz(){ if ( this.jcgz == null){ return ""; } else {return this.jcgz;}}public String getZyd(){ if ( this.zyd == null){ return ""; } else {return this.zyd;}}public String getJcsj(){ if ( this.jcsj == null){ return ""; } else {return this.jcsj;}}public String getJcxm(){ if ( this.jcxm == null){ return ""; } else {return this.jcxm;}}public String getCtwa(){ if ( this.ctwa == null){ return ""; } else {return this.ctwa;}}public String getPcwta(){ if ( this.pcwta == null){ return ""; } else {return this.pcwta;}}public String getTwapd(){ if ( this.twapd == null){ return ""; } else {return this.twapd;}}public String getCstel(){ if ( this.cstel == null){ return ""; } else {return this.cstel;}}public String getPcstel(){ if ( this.pcstel == null){ return ""; } else {return this.pcstel;}}public String getStelpd(){ if ( this.stelpd == null){ return ""; } else {return this.stelpd;}}public String getJcnd(){ if ( this.jcnd == null){ return ""; } else {return this.jcnd;}}public String getCxbs(){ if ( this.cxbs == null){ return ""; } else {return this.cxbs;}}public String getNdpd(){ if ( this.ndpd == null){ return ""; } else {return this.ndpd;}}public String getLex8h(){ if ( this.lex8h == null){ return ""; } else {return this.lex8h;}}public String getZsbzxz(){ if ( this.zsbzxz == null){ return ""; } else {return this.zsbzxz;}}public String getZspd(){ if ( this.zspd == null){ return ""; } else {return this.zspd;}}public String getCljg(){ if ( this.cljg == null){ return ""; } else {return this.cljg;}}public String getZdbzxz(){ if ( this.zdbzxz == null){ return ""; } else {return this.zdbzxz;}}public String getZdpd(){ if ( this.zdpd == null){ return ""; } else {return this.zdpd;}}public String getDcqd(){ if ( this.dcqd == null){ return ""; } else {return this.dcqd;}}public String getGpbzxz(){ if ( this.gpbzxz == null){ return ""; } else {return this.gpbzxz;}}public String getGppd(){ if ( this.gppd == null){ return ""; } else {return this.gppd;}}public String getWbgt(){ if ( this.wbgt == null){ return ""; } else {return this.wbgt;}}public String getGwbzxz(){ if ( this.gwbzxz == null){ return ""; } else {return this.gwbzxz;}}public String getGwpd(){ if ( this.gwpd == null){ return ""; } else {return this.gwpd;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public String getFzdz(){ if ( this.fzdz == null){ return ""; } else {return this.fzdz;}}public String getBzxz(){ if ( this.bzxz == null){ return ""; } else {return this.bzxz;}}public String getDxpd(){ if ( this.dxpd == null){ return ""; } else {return this.dxpd;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setBgbh( String bgbh){sqlMaker.setField("bgbh",bgbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBgbh().equals(bgbh))
cf.add("bgbh",this.bgbh,bgbh);
}
this.bgbh=bgbh;
}
public void setDwbh( String dwbh){sqlMaker.setField("dwbh",dwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwbh().equals(dwbh))
cf.add("dwbh",this.dwbh,dwbh);
}
this.dwbh=dwbh;
}
public void setDwmc( String dwmc){sqlMaker.setField("dwmc",dwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwmc().equals(dwmc))
cf.add("dwmc",this.dwmc,dwmc);
}
this.dwmc=dwmc;
}
public void setJcdwbh( String jcdwbh){sqlMaker.setField("jcdwbh",jcdwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcdwbh().equals(jcdwbh))
cf.add("jcdwbh",this.jcdwbh,jcdwbh);
}
this.jcdwbh=jcdwbh;
}
public void setJcdwmc( String jcdwmc){sqlMaker.setField("jcdwmc",jcdwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcdwmc().equals(jcdwmc))
cf.add("jcdwmc",this.jcdwmc,jcdwmc);
}
this.jcdwmc=jcdwmc;
}
public void setJclb( String jclb){sqlMaker.setField("jclb",jclb,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJclb().equals(jclb))
cf.add("jclb",this.jclb,jclb);
}
this.jclb=jclb;
}
public void setCj( String cj){sqlMaker.setField("cj",cj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCj().equals(cj))
cf.add("cj",this.cj,cj);
}
this.cj=cj;
}
public void setJcgz( String jcgz){sqlMaker.setField("jcgz",jcgz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcgz().equals(jcgz))
cf.add("jcgz",this.jcgz,jcgz);
}
this.jcgz=jcgz;
}
public void setZyd( String zyd){sqlMaker.setField("zyd",zyd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZyd().equals(zyd))
cf.add("zyd",this.zyd,zyd);
}
this.zyd=zyd;
}
public void setJcsj( String jcsj){sqlMaker.setField("jcsj",jcsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcsj().equals(jcsj))
cf.add("jcsj",this.jcsj,jcsj);
}
this.jcsj=jcsj;
}
public void setJcxm( String jcxm){sqlMaker.setField("jcxm",jcxm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcxm().equals(jcxm))
cf.add("jcxm",this.jcxm,jcxm);
}
this.jcxm=jcxm;
}
public void setCtwa( String ctwa){sqlMaker.setField("ctwa",ctwa,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCtwa().equals(ctwa))
cf.add("ctwa",this.ctwa,ctwa);
}
this.ctwa=ctwa;
}
public void setPcwta( String pcwta){sqlMaker.setField("pcwta",pcwta,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPcwta().equals(pcwta))
cf.add("pcwta",this.pcwta,pcwta);
}
this.pcwta=pcwta;
}
public void setTwapd( String twapd){sqlMaker.setField("twapd",twapd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTwapd().equals(twapd))
cf.add("twapd",this.twapd,twapd);
}
this.twapd=twapd;
}
public void setCstel( String cstel){sqlMaker.setField("cstel",cstel,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCstel().equals(cstel))
cf.add("cstel",this.cstel,cstel);
}
this.cstel=cstel;
}
public void setPcstel( String pcstel){sqlMaker.setField("pcstel",pcstel,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPcstel().equals(pcstel))
cf.add("pcstel",this.pcstel,pcstel);
}
this.pcstel=pcstel;
}
public void setStelpd( String stelpd){sqlMaker.setField("stelpd",stelpd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getStelpd().equals(stelpd))
cf.add("stelpd",this.stelpd,stelpd);
}
this.stelpd=stelpd;
}
public void setJcnd( String jcnd){sqlMaker.setField("jcnd",jcnd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcnd().equals(jcnd))
cf.add("jcnd",this.jcnd,jcnd);
}
this.jcnd=jcnd;
}
public void setCxbs( String cxbs){sqlMaker.setField("cxbs",cxbs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCxbs().equals(cxbs))
cf.add("cxbs",this.cxbs,cxbs);
}
this.cxbs=cxbs;
}
public void setNdpd( String ndpd){sqlMaker.setField("ndpd",ndpd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNdpd().equals(ndpd))
cf.add("ndpd",this.ndpd,ndpd);
}
this.ndpd=ndpd;
}
public void setLex8h( String lex8h){sqlMaker.setField("lex8h",lex8h,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLex8h().equals(lex8h))
cf.add("lex8h",this.lex8h,lex8h);
}
this.lex8h=lex8h;
}
public void setZsbzxz( String zsbzxz){sqlMaker.setField("zsbzxz",zsbzxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZsbzxz().equals(zsbzxz))
cf.add("zsbzxz",this.zsbzxz,zsbzxz);
}
this.zsbzxz=zsbzxz;
}
public void setZspd( String zspd){sqlMaker.setField("zspd",zspd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZspd().equals(zspd))
cf.add("zspd",this.zspd,zspd);
}
this.zspd=zspd;
}
public void setCljg( String cljg){sqlMaker.setField("cljg",cljg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCljg().equals(cljg))
cf.add("cljg",this.cljg,cljg);
}
this.cljg=cljg;
}
public void setZdbzxz( String zdbzxz){sqlMaker.setField("zdbzxz",zdbzxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZdbzxz().equals(zdbzxz))
cf.add("zdbzxz",this.zdbzxz,zdbzxz);
}
this.zdbzxz=zdbzxz;
}
public void setZdpd( String zdpd){sqlMaker.setField("zdpd",zdpd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZdpd().equals(zdpd))
cf.add("zdpd",this.zdpd,zdpd);
}
this.zdpd=zdpd;
}
public void setDcqd( String dcqd){sqlMaker.setField("dcqd",dcqd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDcqd().equals(dcqd))
cf.add("dcqd",this.dcqd,dcqd);
}
this.dcqd=dcqd;
}
public void setGpbzxz( String gpbzxz){sqlMaker.setField("gpbzxz",gpbzxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGpbzxz().equals(gpbzxz))
cf.add("gpbzxz",this.gpbzxz,gpbzxz);
}
this.gpbzxz=gpbzxz;
}
public void setGppd( String gppd){sqlMaker.setField("gppd",gppd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGppd().equals(gppd))
cf.add("gppd",this.gppd,gppd);
}
this.gppd=gppd;
}
public void setWbgt( String wbgt){sqlMaker.setField("wbgt",wbgt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWbgt().equals(wbgt))
cf.add("wbgt",this.wbgt,wbgt);
}
this.wbgt=wbgt;
}
public void setGwbzxz( String gwbzxz){sqlMaker.setField("gwbzxz",gwbzxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGwbzxz().equals(gwbzxz))
cf.add("gwbzxz",this.gwbzxz,gwbzxz);
}
this.gwbzxz=gwbzxz;
}
public void setGwpd( String gwpd){sqlMaker.setField("gwpd",gwpd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGwpd().equals(gwpd))
cf.add("gwpd",this.gwpd,gwpd);
}
this.gwpd=gwpd;
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
public void setFzdz( String fzdz){sqlMaker.setField("fzdz",fzdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzdz().equals(fzdz))
cf.add("fzdz",this.fzdz,fzdz);
}
this.fzdz=fzdz;
}
public void setBzxz( String bzxz){sqlMaker.setField("bzxz",bzxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBzxz().equals(bzxz))
cf.add("bzxz",this.bzxz,bzxz);
}
this.bzxz=bzxz;
}
public void setDxpd( String dxpd){sqlMaker.setField("dxpd",dxpd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDxpd().equals(dxpd))
cf.add("dxpd",this.dxpd,dxpd);
}
this.dxpd=dxpd;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "bgbh") != null) 
this.setBgbh(actionRequest.getFieldValue(i, "bgbh"));
if (actionRequest.getFieldValue(i, "dwbh") != null) 
this.setDwbh(actionRequest.getFieldValue(i, "dwbh"));
if (actionRequest.getFieldValue(i, "dwmc") != null) 
this.setDwmc(actionRequest.getFieldValue(i, "dwmc"));
if (actionRequest.getFieldValue(i, "jcdwbh") != null) 
this.setJcdwbh(actionRequest.getFieldValue(i, "jcdwbh"));
if (actionRequest.getFieldValue(i, "jcdwmc") != null) 
this.setJcdwmc(actionRequest.getFieldValue(i, "jcdwmc"));
if (actionRequest.getFieldValue(i, "jclb") != null) 
this.setJclb(actionRequest.getFieldValue(i, "jclb"));
if (actionRequest.getFieldValue(i, "cj") != null) 
this.setCj(actionRequest.getFieldValue(i, "cj"));
if (actionRequest.getFieldValue(i, "jcgz") != null) 
this.setJcgz(actionRequest.getFieldValue(i, "jcgz"));
if (actionRequest.getFieldValue(i, "zyd") != null) 
this.setZyd(actionRequest.getFieldValue(i, "zyd"));
if (actionRequest.getFieldValue(i, "jcsj") != null) 
this.setJcsj(actionRequest.getFieldValue(i, "jcsj"));
if (actionRequest.getFieldValue(i, "jcxm") != null) 
this.setJcxm(actionRequest.getFieldValue(i, "jcxm"));
if (actionRequest.getFieldValue(i, "ctwa") != null) 
this.setCtwa(actionRequest.getFieldValue(i, "ctwa"));
if (actionRequest.getFieldValue(i, "pcwta") != null) 
this.setPcwta(actionRequest.getFieldValue(i, "pcwta"));
if (actionRequest.getFieldValue(i, "twapd") != null) 
this.setTwapd(actionRequest.getFieldValue(i, "twapd"));
if (actionRequest.getFieldValue(i, "cstel") != null) 
this.setCstel(actionRequest.getFieldValue(i, "cstel"));
if (actionRequest.getFieldValue(i, "pcstel") != null) 
this.setPcstel(actionRequest.getFieldValue(i, "pcstel"));
if (actionRequest.getFieldValue(i, "stelpd") != null) 
this.setStelpd(actionRequest.getFieldValue(i, "stelpd"));
if (actionRequest.getFieldValue(i, "jcnd") != null) 
this.setJcnd(actionRequest.getFieldValue(i, "jcnd"));
if (actionRequest.getFieldValue(i, "cxbs") != null) 
this.setCxbs(actionRequest.getFieldValue(i, "cxbs"));
if (actionRequest.getFieldValue(i, "ndpd") != null) 
this.setNdpd(actionRequest.getFieldValue(i, "ndpd"));
if (actionRequest.getFieldValue(i, "lex8h") != null) 
this.setLex8h(actionRequest.getFieldValue(i, "lex8h"));
if (actionRequest.getFieldValue(i, "zsbzxz") != null) 
this.setZsbzxz(actionRequest.getFieldValue(i, "zsbzxz"));
if (actionRequest.getFieldValue(i, "zspd") != null) 
this.setZspd(actionRequest.getFieldValue(i, "zspd"));
if (actionRequest.getFieldValue(i, "cljg") != null) 
this.setCljg(actionRequest.getFieldValue(i, "cljg"));
if (actionRequest.getFieldValue(i, "zdbzxz") != null) 
this.setZdbzxz(actionRequest.getFieldValue(i, "zdbzxz"));
if (actionRequest.getFieldValue(i, "zdpd") != null) 
this.setZdpd(actionRequest.getFieldValue(i, "zdpd"));
if (actionRequest.getFieldValue(i, "dcqd") != null) 
this.setDcqd(actionRequest.getFieldValue(i, "dcqd"));
if (actionRequest.getFieldValue(i, "gpbzxz") != null) 
this.setGpbzxz(actionRequest.getFieldValue(i, "gpbzxz"));
if (actionRequest.getFieldValue(i, "gppd") != null) 
this.setGppd(actionRequest.getFieldValue(i, "gppd"));
if (actionRequest.getFieldValue(i, "wbgt") != null) 
this.setWbgt(actionRequest.getFieldValue(i, "wbgt"));
if (actionRequest.getFieldValue(i, "gwbzxz") != null) 
this.setGwbzxz(actionRequest.getFieldValue(i, "gwbzxz"));
if (actionRequest.getFieldValue(i, "gwpd") != null) 
this.setGwpd(actionRequest.getFieldValue(i, "gwpd"));
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
if (actionRequest.getFieldValue(i, "fzdz") != null) 
this.setFzdz(actionRequest.getFieldValue(i, "fzdz"));
if (actionRequest.getFieldValue(i, "bzxz") != null) 
this.setBzxz(actionRequest.getFieldValue(i, "bzxz"));
if (actionRequest.getFieldValue(i, "dxpd") != null) 
this.setDxpd(actionRequest.getFieldValue(i, "dxpd"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { JcqkBean obj = (JcqkBean)super.clone();obj.setSysno(obj.sysno);
obj.setBgbh(obj.bgbh);
obj.setDwbh(obj.dwbh);
obj.setDwmc(obj.dwmc);
obj.setJcdwbh(obj.jcdwbh);
obj.setJcdwmc(obj.jcdwmc);
obj.setJclb(obj.jclb);
obj.setCj(obj.cj);
obj.setJcgz(obj.jcgz);
obj.setZyd(obj.zyd);
obj.setJcsj(obj.jcsj);
obj.setJcxm(obj.jcxm);
obj.setCtwa(obj.ctwa);
obj.setPcwta(obj.pcwta);
obj.setTwapd(obj.twapd);
obj.setCstel(obj.cstel);
obj.setPcstel(obj.pcstel);
obj.setStelpd(obj.stelpd);
obj.setJcnd(obj.jcnd);
obj.setCxbs(obj.cxbs);
obj.setNdpd(obj.ndpd);
obj.setLex8h(obj.lex8h);
obj.setZsbzxz(obj.zsbzxz);
obj.setZspd(obj.zspd);
obj.setCljg(obj.cljg);
obj.setZdbzxz(obj.zdbzxz);
obj.setZdpd(obj.zdpd);
obj.setDcqd(obj.dcqd);
obj.setGpbzxz(obj.gpbzxz);
obj.setGppd(obj.gppd);
obj.setWbgt(obj.wbgt);
obj.setGwbzxz(obj.gwbzxz);
obj.setGwpd(obj.gwpd);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
obj.setFzdz(obj.fzdz);
obj.setBzxz(obj.bzxz);
obj.setDxpd(obj.dxpd);
return obj;}}