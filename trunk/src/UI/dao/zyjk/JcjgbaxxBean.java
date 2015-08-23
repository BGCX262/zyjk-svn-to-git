package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class JcjgbaxxBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new JcjgbaxxBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new JcjgbaxxBean().findAndLockByWhere(sSqlWhere);      }       public static JcjgbaxxBean findFirst(String sSqlWhere)throws Exception {           return (JcjgbaxxBean)new JcjgbaxxBean().findFirstByWhere(sSqlWhere);      }       public static JcjgbaxxBean findFirstAndLock(String sSqlWhere)throws Exception {           return (JcjgbaxxBean)new JcjgbaxxBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new JcjgbaxxBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgbaxxBean bean = new JcjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcjgbaxxBean bean = new JcjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static JcjgbaxxBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgbaxxBean bean = new JcjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return (JcjgbaxxBean)bean.findFirstByWhere(sSqlWhere);      }       public static JcjgbaxxBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcjgbaxxBean bean = new JcjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return (JcjgbaxxBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgbaxxBean bean = new JcjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  dwmc;
String  gszch;
String  zzjgdm;
String  zzzsbh;
String  distcode;
String  fzdate;
String  fzjg;
String  yxq;
String  fwxm;
String  zzjb;
String  jsfzr;
String  zlfzr;
String  zgrs;
String  zyjsrys;
String  qdzszyrs;
String  pjgjrs;
String  pszjrs;
String  pjqtrs;
String  jcgjrs;
String  jczjrs;
String  jcqtrs;
String  zlgsrs;
String  zlzjrs;
String  zlqtrs;
String  jlrzzsh;
String  yqsbs;
String  frzzbh;
String  zczj;
String  bfjg;
String  dwxz;
String  zcdz;
String  bgdz;
String  zpcode;
String  fddbr;
String  dbrlxdh;
String  lxr;
String  lxdh;
String  fax;
String  email;
String  bz;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="jcjgbaxx";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
JcjgbaxxBean abb = new JcjgbaxxBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.dwmc=rs.getString("dwmc");
abb.setKeyValue("DWMC","" + abb.getDwmc());
abb.gszch=rs.getString("gszch");
abb.setKeyValue("GSZCH","" + abb.getGszch());
abb.zzjgdm=rs.getString("zzjgdm");
abb.setKeyValue("ZZJGDM","" + abb.getZzjgdm());
abb.zzzsbh=rs.getString("zzzsbh");
abb.setKeyValue("ZZZSBH","" + abb.getZzzsbh());
abb.distcode=rs.getString("distcode");
abb.setKeyValue("DISTCODE","" + abb.getDistcode());
abb.fzdate=rs.getString("fzdate");
abb.setKeyValue("FZDATE","" + abb.getFzdate());
abb.fzjg=rs.getString("fzjg");
abb.setKeyValue("FZJG","" + abb.getFzjg());
abb.yxq=rs.getString("yxq");
abb.setKeyValue("YXQ","" + abb.getYxq());
abb.fwxm=rs.getString("fwxm");
abb.setKeyValue("FWXM","" + abb.getFwxm());
abb.zzjb=rs.getString("zzjb");
abb.setKeyValue("ZZJB","" + abb.getZzjb());
abb.jsfzr=rs.getString("jsfzr");
abb.setKeyValue("JSFZR","" + abb.getJsfzr());
abb.zlfzr=rs.getString("zlfzr");
abb.setKeyValue("ZLFZR","" + abb.getZlfzr());
abb.zgrs=rs.getString("zgrs");
abb.setKeyValue("ZGRS","" + abb.getZgrs());
abb.zyjsrys=rs.getString("zyjsrys");
abb.setKeyValue("ZYJSRYS","" + abb.getZyjsrys());
abb.qdzszyrs=rs.getString("qdzszyrs");
abb.setKeyValue("QDZSZYRS","" + abb.getQdzszyrs());
abb.pjgjrs=rs.getString("pjgjrs");
abb.setKeyValue("PJGJRS","" + abb.getPjgjrs());
abb.pszjrs=rs.getString("pszjrs");
abb.setKeyValue("PSZJRS","" + abb.getPszjrs());
abb.pjqtrs=rs.getString("pjqtrs");
abb.setKeyValue("PJQTRS","" + abb.getPjqtrs());
abb.jcgjrs=rs.getString("jcgjrs");
abb.setKeyValue("JCGJRS","" + abb.getJcgjrs());
abb.jczjrs=rs.getString("jczjrs");
abb.setKeyValue("JCZJRS","" + abb.getJczjrs());
abb.jcqtrs=rs.getString("jcqtrs");
abb.setKeyValue("JCQTRS","" + abb.getJcqtrs());
abb.zlgsrs=rs.getString("zlgsrs");
abb.setKeyValue("ZLGSRS","" + abb.getZlgsrs());
abb.zlzjrs=rs.getString("zlzjrs");
abb.setKeyValue("ZLZJRS","" + abb.getZlzjrs());
abb.zlqtrs=rs.getString("zlqtrs");
abb.setKeyValue("ZLQTRS","" + abb.getZlqtrs());
abb.jlrzzsh=rs.getString("jlrzzsh");
abb.setKeyValue("JLRZZSH","" + abb.getJlrzzsh());
abb.yqsbs=rs.getString("yqsbs");
abb.setKeyValue("YQSBS","" + abb.getYqsbs());
abb.frzzbh=rs.getString("frzzbh");
abb.setKeyValue("FRZZBH","" + abb.getFrzzbh());
abb.zczj=rs.getString("zczj");
abb.setKeyValue("ZCZJ","" + abb.getZczj());
abb.bfjg=rs.getString("bfjg");
abb.setKeyValue("BFJG","" + abb.getBfjg());
abb.dwxz=rs.getString("dwxz");
abb.setKeyValue("DWXZ","" + abb.getDwxz());
abb.zcdz=rs.getString("zcdz");
abb.setKeyValue("ZCDZ","" + abb.getZcdz());
abb.bgdz=rs.getString("bgdz");
abb.setKeyValue("BGDZ","" + abb.getBgdz());
abb.zpcode=rs.getString("zpcode");
abb.setKeyValue("ZPCODE","" + abb.getZpcode());
abb.fddbr=rs.getString("fddbr");
abb.setKeyValue("FDDBR","" + abb.getFddbr());
abb.dbrlxdh=rs.getString("dbrlxdh");
abb.setKeyValue("DBRLXDH","" + abb.getDbrlxdh());
abb.lxr=rs.getString("lxr");
abb.setKeyValue("LXR","" + abb.getLxr());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.fax=rs.getString("fax");
abb.setKeyValue("FAX","" + abb.getFax());
abb.email=rs.getString("email");
abb.setKeyValue("EMAIL","" + abb.getEmail());
abb.bz=rs.getString("bz");
abb.setKeyValue("BZ","" + abb.getBz());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getDwmc(){ if ( this.dwmc == null){ return ""; } else {return this.dwmc;}}public String getGszch(){ if ( this.gszch == null){ return ""; } else {return this.gszch;}}public String getZzjgdm(){ if ( this.zzjgdm == null){ return ""; } else {return this.zzjgdm;}}public String getZzzsbh(){ if ( this.zzzsbh == null){ return ""; } else {return this.zzzsbh;}}public String getDistcode(){ if ( this.distcode == null){ return ""; } else {return this.distcode;}}public String getFzdate(){ if ( this.fzdate == null){ return ""; } else {return this.fzdate;}}public String getFzjg(){ if ( this.fzjg == null){ return ""; } else {return this.fzjg;}}public String getYxq(){ if ( this.yxq == null){ return ""; } else {return this.yxq;}}public String getFwxm(){ if ( this.fwxm == null){ return ""; } else {return this.fwxm;}}public String getZzjb(){ if ( this.zzjb == null){ return ""; } else {return this.zzjb;}}public String getJsfzr(){ if ( this.jsfzr == null){ return ""; } else {return this.jsfzr;}}public String getZlfzr(){ if ( this.zlfzr == null){ return ""; } else {return this.zlfzr;}}public String getZgrs(){ if ( this.zgrs == null){ return ""; } else {return this.zgrs;}}public String getZyjsrys(){ if ( this.zyjsrys == null){ return ""; } else {return this.zyjsrys;}}public String getQdzszyrs(){ if ( this.qdzszyrs == null){ return ""; } else {return this.qdzszyrs;}}public String getPjgjrs(){ if ( this.pjgjrs == null){ return ""; } else {return this.pjgjrs;}}public String getPszjrs(){ if ( this.pszjrs == null){ return ""; } else {return this.pszjrs;}}public String getPjqtrs(){ if ( this.pjqtrs == null){ return ""; } else {return this.pjqtrs;}}public String getJcgjrs(){ if ( this.jcgjrs == null){ return ""; } else {return this.jcgjrs;}}public String getJczjrs(){ if ( this.jczjrs == null){ return ""; } else {return this.jczjrs;}}public String getJcqtrs(){ if ( this.jcqtrs == null){ return ""; } else {return this.jcqtrs;}}public String getZlgsrs(){ if ( this.zlgsrs == null){ return ""; } else {return this.zlgsrs;}}public String getZlzjrs(){ if ( this.zlzjrs == null){ return ""; } else {return this.zlzjrs;}}public String getZlqtrs(){ if ( this.zlqtrs == null){ return ""; } else {return this.zlqtrs;}}public String getJlrzzsh(){ if ( this.jlrzzsh == null){ return ""; } else {return this.jlrzzsh;}}public String getYqsbs(){ if ( this.yqsbs == null){ return ""; } else {return this.yqsbs;}}public String getFrzzbh(){ if ( this.frzzbh == null){ return ""; } else {return this.frzzbh;}}public String getZczj(){ if ( this.zczj == null){ return ""; } else {return this.zczj;}}public String getBfjg(){ if ( this.bfjg == null){ return ""; } else {return this.bfjg;}}public String getDwxz(){ if ( this.dwxz == null){ return ""; } else {return this.dwxz;}}public String getZcdz(){ if ( this.zcdz == null){ return ""; } else {return this.zcdz;}}public String getBgdz(){ if ( this.bgdz == null){ return ""; } else {return this.bgdz;}}public String getZpcode(){ if ( this.zpcode == null){ return ""; } else {return this.zpcode;}}public String getFddbr(){ if ( this.fddbr == null){ return ""; } else {return this.fddbr;}}public String getDbrlxdh(){ if ( this.dbrlxdh == null){ return ""; } else {return this.dbrlxdh;}}public String getLxr(){ if ( this.lxr == null){ return ""; } else {return this.lxr;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getFax(){ if ( this.fax == null){ return ""; } else {return this.fax;}}public String getEmail(){ if ( this.email == null){ return ""; } else {return this.email;}}public String getBz(){ if ( this.bz == null){ return ""; } else {return this.bz;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setDwmc( String dwmc){sqlMaker.setField("dwmc",dwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwmc().equals(dwmc))
cf.add("dwmc",this.dwmc,dwmc);
}
this.dwmc=dwmc;
}
public void setGszch( String gszch){sqlMaker.setField("gszch",gszch,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGszch().equals(gszch))
cf.add("gszch",this.gszch,gszch);
}
this.gszch=gszch;
}
public void setZzjgdm( String zzjgdm){sqlMaker.setField("zzjgdm",zzjgdm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZzjgdm().equals(zzjgdm))
cf.add("zzjgdm",this.zzjgdm,zzjgdm);
}
this.zzjgdm=zzjgdm;
}
public void setZzzsbh( String zzzsbh){sqlMaker.setField("zzzsbh",zzzsbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZzzsbh().equals(zzzsbh))
cf.add("zzzsbh",this.zzzsbh,zzzsbh);
}
this.zzzsbh=zzzsbh;
}
public void setDistcode( String distcode){sqlMaker.setField("distcode",distcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDistcode().equals(distcode))
cf.add("distcode",this.distcode,distcode);
}
this.distcode=distcode;
}
public void setFzdate( String fzdate){sqlMaker.setField("fzdate",fzdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzdate().equals(fzdate))
cf.add("fzdate",this.fzdate,fzdate);
}
this.fzdate=fzdate;
}
public void setFzjg( String fzjg){sqlMaker.setField("fzjg",fzjg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzjg().equals(fzjg))
cf.add("fzjg",this.fzjg,fzjg);
}
this.fzjg=fzjg;
}
public void setYxq( String yxq){sqlMaker.setField("yxq",yxq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYxq().equals(yxq))
cf.add("yxq",this.yxq,yxq);
}
this.yxq=yxq;
}
public void setFwxm( String fwxm){sqlMaker.setField("fwxm",fwxm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFwxm().equals(fwxm))
cf.add("fwxm",this.fwxm,fwxm);
}
this.fwxm=fwxm;
}
public void setZzjb( String zzjb){sqlMaker.setField("zzjb",zzjb,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZzjb().equals(zzjb))
cf.add("zzjb",this.zzjb,zzjb);
}
this.zzjb=zzjb;
}
public void setJsfzr( String jsfzr){sqlMaker.setField("jsfzr",jsfzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJsfzr().equals(jsfzr))
cf.add("jsfzr",this.jsfzr,jsfzr);
}
this.jsfzr=jsfzr;
}
public void setZlfzr( String zlfzr){sqlMaker.setField("zlfzr",zlfzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZlfzr().equals(zlfzr))
cf.add("zlfzr",this.zlfzr,zlfzr);
}
this.zlfzr=zlfzr;
}
public void setZgrs( String zgrs){sqlMaker.setField("zgrs",zgrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZgrs().equals(zgrs))
cf.add("zgrs",this.zgrs,zgrs);
}
this.zgrs=zgrs;
}
public void setZyjsrys( String zyjsrys){sqlMaker.setField("zyjsrys",zyjsrys,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZyjsrys().equals(zyjsrys))
cf.add("zyjsrys",this.zyjsrys,zyjsrys);
}
this.zyjsrys=zyjsrys;
}
public void setQdzszyrs( String qdzszyrs){sqlMaker.setField("qdzszyrs",qdzszyrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getQdzszyrs().equals(qdzszyrs))
cf.add("qdzszyrs",this.qdzszyrs,qdzszyrs);
}
this.qdzszyrs=qdzszyrs;
}
public void setPjgjrs( String pjgjrs){sqlMaker.setField("pjgjrs",pjgjrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPjgjrs().equals(pjgjrs))
cf.add("pjgjrs",this.pjgjrs,pjgjrs);
}
this.pjgjrs=pjgjrs;
}
public void setPszjrs( String pszjrs){sqlMaker.setField("pszjrs",pszjrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPszjrs().equals(pszjrs))
cf.add("pszjrs",this.pszjrs,pszjrs);
}
this.pszjrs=pszjrs;
}
public void setPjqtrs( String pjqtrs){sqlMaker.setField("pjqtrs",pjqtrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPjqtrs().equals(pjqtrs))
cf.add("pjqtrs",this.pjqtrs,pjqtrs);
}
this.pjqtrs=pjqtrs;
}
public void setJcgjrs( String jcgjrs){sqlMaker.setField("jcgjrs",jcgjrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcgjrs().equals(jcgjrs))
cf.add("jcgjrs",this.jcgjrs,jcgjrs);
}
this.jcgjrs=jcgjrs;
}
public void setJczjrs( String jczjrs){sqlMaker.setField("jczjrs",jczjrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJczjrs().equals(jczjrs))
cf.add("jczjrs",this.jczjrs,jczjrs);
}
this.jczjrs=jczjrs;
}
public void setJcqtrs( String jcqtrs){sqlMaker.setField("jcqtrs",jcqtrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcqtrs().equals(jcqtrs))
cf.add("jcqtrs",this.jcqtrs,jcqtrs);
}
this.jcqtrs=jcqtrs;
}
public void setZlgsrs( String zlgsrs){sqlMaker.setField("zlgsrs",zlgsrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZlgsrs().equals(zlgsrs))
cf.add("zlgsrs",this.zlgsrs,zlgsrs);
}
this.zlgsrs=zlgsrs;
}
public void setZlzjrs( String zlzjrs){sqlMaker.setField("zlzjrs",zlzjrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZlzjrs().equals(zlzjrs))
cf.add("zlzjrs",this.zlzjrs,zlzjrs);
}
this.zlzjrs=zlzjrs;
}
public void setZlqtrs( String zlqtrs){sqlMaker.setField("zlqtrs",zlqtrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZlqtrs().equals(zlqtrs))
cf.add("zlqtrs",this.zlqtrs,zlqtrs);
}
this.zlqtrs=zlqtrs;
}
public void setJlrzzsh( String jlrzzsh){sqlMaker.setField("jlrzzsh",jlrzzsh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJlrzzsh().equals(jlrzzsh))
cf.add("jlrzzsh",this.jlrzzsh,jlrzzsh);
}
this.jlrzzsh=jlrzzsh;
}
public void setYqsbs( String yqsbs){sqlMaker.setField("yqsbs",yqsbs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYqsbs().equals(yqsbs))
cf.add("yqsbs",this.yqsbs,yqsbs);
}
this.yqsbs=yqsbs;
}
public void setFrzzbh( String frzzbh){sqlMaker.setField("frzzbh",frzzbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFrzzbh().equals(frzzbh))
cf.add("frzzbh",this.frzzbh,frzzbh);
}
this.frzzbh=frzzbh;
}
public void setZczj( String zczj){sqlMaker.setField("zczj",zczj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZczj().equals(zczj))
cf.add("zczj",this.zczj,zczj);
}
this.zczj=zczj;
}
public void setBfjg( String bfjg){sqlMaker.setField("bfjg",bfjg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBfjg().equals(bfjg))
cf.add("bfjg",this.bfjg,bfjg);
}
this.bfjg=bfjg;
}
public void setDwxz( String dwxz){sqlMaker.setField("dwxz",dwxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwxz().equals(dwxz))
cf.add("dwxz",this.dwxz,dwxz);
}
this.dwxz=dwxz;
}
public void setZcdz( String zcdz){sqlMaker.setField("zcdz",zcdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZcdz().equals(zcdz))
cf.add("zcdz",this.zcdz,zcdz);
}
this.zcdz=zcdz;
}
public void setBgdz( String bgdz){sqlMaker.setField("bgdz",bgdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBgdz().equals(bgdz))
cf.add("bgdz",this.bgdz,bgdz);
}
this.bgdz=bgdz;
}
public void setZpcode( String zpcode){sqlMaker.setField("zpcode",zpcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZpcode().equals(zpcode))
cf.add("zpcode",this.zpcode,zpcode);
}
this.zpcode=zpcode;
}
public void setFddbr( String fddbr){sqlMaker.setField("fddbr",fddbr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFddbr().equals(fddbr))
cf.add("fddbr",this.fddbr,fddbr);
}
this.fddbr=fddbr;
}
public void setDbrlxdh( String dbrlxdh){sqlMaker.setField("dbrlxdh",dbrlxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDbrlxdh().equals(dbrlxdh))
cf.add("dbrlxdh",this.dbrlxdh,dbrlxdh);
}
this.dbrlxdh=dbrlxdh;
}
public void setLxr( String lxr){sqlMaker.setField("lxr",lxr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLxr().equals(lxr))
cf.add("lxr",this.lxr,lxr);
}
this.lxr=lxr;
}
public void setLxdh( String lxdh){sqlMaker.setField("lxdh",lxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLxdh().equals(lxdh))
cf.add("lxdh",this.lxdh,lxdh);
}
this.lxdh=lxdh;
}
public void setFax( String fax){sqlMaker.setField("fax",fax,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFax().equals(fax))
cf.add("fax",this.fax,fax);
}
this.fax=fax;
}
public void setEmail( String email){sqlMaker.setField("email",email,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEmail().equals(email))
cf.add("email",this.email,email);
}
this.email=email;
}
public void setBz( String bz){sqlMaker.setField("bz",bz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz().equals(bz))
cf.add("bz",this.bz,bz);
}
this.bz=bz;
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
if (actionRequest.getFieldValue(i, "dwmc") != null) 
this.setDwmc(actionRequest.getFieldValue(i, "dwmc"));
if (actionRequest.getFieldValue(i, "gszch") != null) 
this.setGszch(actionRequest.getFieldValue(i, "gszch"));
if (actionRequest.getFieldValue(i, "zzjgdm") != null) 
this.setZzjgdm(actionRequest.getFieldValue(i, "zzjgdm"));
if (actionRequest.getFieldValue(i, "zzzsbh") != null) 
this.setZzzsbh(actionRequest.getFieldValue(i, "zzzsbh"));
if (actionRequest.getFieldValue(i, "distcode") != null) 
this.setDistcode(actionRequest.getFieldValue(i, "distcode"));
if (actionRequest.getFieldValue(i, "fzdate") != null) 
this.setFzdate(actionRequest.getFieldValue(i, "fzdate"));
if (actionRequest.getFieldValue(i, "fzjg") != null) 
this.setFzjg(actionRequest.getFieldValue(i, "fzjg"));
if (actionRequest.getFieldValue(i, "yxq") != null) 
this.setYxq(actionRequest.getFieldValue(i, "yxq"));
if (actionRequest.getFieldValue(i, "fwxm") != null) 
this.setFwxm(actionRequest.getFieldValue(i, "fwxm"));
if (actionRequest.getFieldValue(i, "zzjb") != null) 
this.setZzjb(actionRequest.getFieldValue(i, "zzjb"));
if (actionRequest.getFieldValue(i, "jsfzr") != null) 
this.setJsfzr(actionRequest.getFieldValue(i, "jsfzr"));
if (actionRequest.getFieldValue(i, "zlfzr") != null) 
this.setZlfzr(actionRequest.getFieldValue(i, "zlfzr"));
if (actionRequest.getFieldValue(i, "zgrs") != null) 
this.setZgrs(actionRequest.getFieldValue(i, "zgrs"));
if (actionRequest.getFieldValue(i, "zyjsrys") != null) 
this.setZyjsrys(actionRequest.getFieldValue(i, "zyjsrys"));
if (actionRequest.getFieldValue(i, "qdzszyrs") != null) 
this.setQdzszyrs(actionRequest.getFieldValue(i, "qdzszyrs"));
if (actionRequest.getFieldValue(i, "pjgjrs") != null) 
this.setPjgjrs(actionRequest.getFieldValue(i, "pjgjrs"));
if (actionRequest.getFieldValue(i, "pszjrs") != null) 
this.setPszjrs(actionRequest.getFieldValue(i, "pszjrs"));
if (actionRequest.getFieldValue(i, "pjqtrs") != null) 
this.setPjqtrs(actionRequest.getFieldValue(i, "pjqtrs"));
if (actionRequest.getFieldValue(i, "jcgjrs") != null) 
this.setJcgjrs(actionRequest.getFieldValue(i, "jcgjrs"));
if (actionRequest.getFieldValue(i, "jczjrs") != null) 
this.setJczjrs(actionRequest.getFieldValue(i, "jczjrs"));
if (actionRequest.getFieldValue(i, "jcqtrs") != null) 
this.setJcqtrs(actionRequest.getFieldValue(i, "jcqtrs"));
if (actionRequest.getFieldValue(i, "zlgsrs") != null) 
this.setZlgsrs(actionRequest.getFieldValue(i, "zlgsrs"));
if (actionRequest.getFieldValue(i, "zlzjrs") != null) 
this.setZlzjrs(actionRequest.getFieldValue(i, "zlzjrs"));
if (actionRequest.getFieldValue(i, "zlqtrs") != null) 
this.setZlqtrs(actionRequest.getFieldValue(i, "zlqtrs"));
if (actionRequest.getFieldValue(i, "jlrzzsh") != null) 
this.setJlrzzsh(actionRequest.getFieldValue(i, "jlrzzsh"));
if (actionRequest.getFieldValue(i, "yqsbs") != null) 
this.setYqsbs(actionRequest.getFieldValue(i, "yqsbs"));
if (actionRequest.getFieldValue(i, "frzzbh") != null) 
this.setFrzzbh(actionRequest.getFieldValue(i, "frzzbh"));
if (actionRequest.getFieldValue(i, "zczj") != null) 
this.setZczj(actionRequest.getFieldValue(i, "zczj"));
if (actionRequest.getFieldValue(i, "bfjg") != null) 
this.setBfjg(actionRequest.getFieldValue(i, "bfjg"));
if (actionRequest.getFieldValue(i, "dwxz") != null) 
this.setDwxz(actionRequest.getFieldValue(i, "dwxz"));
if (actionRequest.getFieldValue(i, "zcdz") != null) 
this.setZcdz(actionRequest.getFieldValue(i, "zcdz"));
if (actionRequest.getFieldValue(i, "bgdz") != null) 
this.setBgdz(actionRequest.getFieldValue(i, "bgdz"));
if (actionRequest.getFieldValue(i, "zpcode") != null) 
this.setZpcode(actionRequest.getFieldValue(i, "zpcode"));
if (actionRequest.getFieldValue(i, "fddbr") != null) 
this.setFddbr(actionRequest.getFieldValue(i, "fddbr"));
if (actionRequest.getFieldValue(i, "dbrlxdh") != null) 
this.setDbrlxdh(actionRequest.getFieldValue(i, "dbrlxdh"));
if (actionRequest.getFieldValue(i, "lxr") != null) 
this.setLxr(actionRequest.getFieldValue(i, "lxr"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "fax") != null) 
this.setFax(actionRequest.getFieldValue(i, "fax"));
if (actionRequest.getFieldValue(i, "email") != null) 
this.setEmail(actionRequest.getFieldValue(i, "email"));
if (actionRequest.getFieldValue(i, "bz") != null) 
this.setBz(actionRequest.getFieldValue(i, "bz"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { JcjgbaxxBean obj = (JcjgbaxxBean)super.clone();obj.setSysno(obj.sysno);
obj.setDwmc(obj.dwmc);
obj.setGszch(obj.gszch);
obj.setZzjgdm(obj.zzjgdm);
obj.setZzzsbh(obj.zzzsbh);
obj.setDistcode(obj.distcode);
obj.setFzdate(obj.fzdate);
obj.setFzjg(obj.fzjg);
obj.setYxq(obj.yxq);
obj.setFwxm(obj.fwxm);
obj.setZzjb(obj.zzjb);
obj.setJsfzr(obj.jsfzr);
obj.setZlfzr(obj.zlfzr);
obj.setZgrs(obj.zgrs);
obj.setZyjsrys(obj.zyjsrys);
obj.setQdzszyrs(obj.qdzszyrs);
obj.setPjgjrs(obj.pjgjrs);
obj.setPszjrs(obj.pszjrs);
obj.setPjqtrs(obj.pjqtrs);
obj.setJcgjrs(obj.jcgjrs);
obj.setJczjrs(obj.jczjrs);
obj.setJcqtrs(obj.jcqtrs);
obj.setZlgsrs(obj.zlgsrs);
obj.setZlzjrs(obj.zlzjrs);
obj.setZlqtrs(obj.zlqtrs);
obj.setJlrzzsh(obj.jlrzzsh);
obj.setYqsbs(obj.yqsbs);
obj.setFrzzbh(obj.frzzbh);
obj.setZczj(obj.zczj);
obj.setBfjg(obj.bfjg);
obj.setDwxz(obj.dwxz);
obj.setZcdz(obj.zcdz);
obj.setBgdz(obj.bgdz);
obj.setZpcode(obj.zpcode);
obj.setFddbr(obj.fddbr);
obj.setDbrlxdh(obj.dbrlxdh);
obj.setLxr(obj.lxr);
obj.setLxdh(obj.lxdh);
obj.setFax(obj.fax);
obj.setEmail(obj.email);
obj.setBz(obj.bz);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}