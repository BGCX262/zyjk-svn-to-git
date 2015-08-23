package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PxjgbaxxBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PxjgbaxxBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PxjgbaxxBean().findAndLockByWhere(sSqlWhere);      }       public static PxjgbaxxBean findFirst(String sSqlWhere)throws Exception {           return (PxjgbaxxBean)new PxjgbaxxBean().findFirstByWhere(sSqlWhere);      }       public static PxjgbaxxBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PxjgbaxxBean)new PxjgbaxxBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PxjgbaxxBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PxjgbaxxBean bean = new PxjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PxjgbaxxBean bean = new PxjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PxjgbaxxBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PxjgbaxxBean bean = new PxjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return (PxjgbaxxBean)bean.findFirstByWhere(sSqlWhere);      }       public static PxjgbaxxBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PxjgbaxxBean bean = new PxjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return (PxjgbaxxBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PxjgbaxxBean bean = new PxjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  pxjgmc;
String  pxjgdz;
String  fddbr;
String  frlxdh;
String  jwfzr;
String  jwfzrlxdh;
String  jglxr;
String  jglxdh;
String  lxdh;
String  fax;
String  zczj;
String  creatdate;
String  zgrs;
String  zyjs;
String  jzjs;
String  glrs;
String  qt;
String  jxcd;
String  zy;
String  zl;
String  zdmj;
String  dnsl;
String  fzjg;
String  zsbh;
String  zsyxqs;
String  zsyxqz;
String  bz;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="pxjgbaxx";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PxjgbaxxBean abb = new PxjgbaxxBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.pxjgmc=rs.getString("pxjgmc");
abb.setKeyValue("PXJGMC","" + abb.getPxjgmc());
abb.pxjgdz=rs.getString("pxjgdz");
abb.setKeyValue("PXJGDZ","" + abb.getPxjgdz());
abb.fddbr=rs.getString("fddbr");
abb.setKeyValue("FDDBR","" + abb.getFddbr());
abb.frlxdh=rs.getString("frlxdh");
abb.setKeyValue("FRLXDH","" + abb.getFrlxdh());
abb.jwfzr=rs.getString("jwfzr");
abb.setKeyValue("JWFZR","" + abb.getJwfzr());
abb.jwfzrlxdh=rs.getString("jwfzrlxdh");
abb.setKeyValue("JWFZRLXDH","" + abb.getJwfzrlxdh());
abb.jglxr=rs.getString("jglxr");
abb.setKeyValue("JGLXR","" + abb.getJglxr());
abb.jglxdh=rs.getString("jglxdh");
abb.setKeyValue("JGLXDH","" + abb.getJglxdh());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.fax=rs.getString("fax");
abb.setKeyValue("FAX","" + abb.getFax());
abb.zczj=rs.getString("zczj");
abb.setKeyValue("ZCZJ","" + abb.getZczj());
abb.creatdate=rs.getString("creatdate");
abb.setKeyValue("CREATDATE","" + abb.getCreatdate());
abb.zgrs=rs.getString("zgrs");
abb.setKeyValue("ZGRS","" + abb.getZgrs());
abb.zyjs=rs.getString("zyjs");
abb.setKeyValue("ZYJS","" + abb.getZyjs());
abb.jzjs=rs.getString("jzjs");
abb.setKeyValue("JZJS","" + abb.getJzjs());
abb.glrs=rs.getString("glrs");
abb.setKeyValue("GLRS","" + abb.getGlrs());
abb.qt=rs.getString("qt");
abb.setKeyValue("QT","" + abb.getQt());
abb.jxcd=rs.getString("jxcd");
abb.setKeyValue("JXCD","" + abb.getJxcd());
abb.zy=rs.getString("zy");
abb.setKeyValue("ZY","" + abb.getZy());
abb.zl=rs.getString("zl");
abb.setKeyValue("ZL","" + abb.getZl());
abb.zdmj=rs.getString("zdmj");
abb.setKeyValue("ZDMJ","" + abb.getZdmj());
abb.dnsl=rs.getString("dnsl");
abb.setKeyValue("DNSL","" + abb.getDnsl());
abb.fzjg=rs.getString("fzjg");
abb.setKeyValue("FZJG","" + abb.getFzjg());
abb.zsbh=rs.getString("zsbh");
abb.setKeyValue("ZSBH","" + abb.getZsbh());
abb.zsyxqs=rs.getString("zsyxqs");
abb.setKeyValue("ZSYXQS","" + abb.getZsyxqs());
abb.zsyxqz=rs.getString("zsyxqz");
abb.setKeyValue("ZSYXQZ","" + abb.getZsyxqz());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getPxjgmc(){ if ( this.pxjgmc == null){ return ""; } else {return this.pxjgmc;}}public String getPxjgdz(){ if ( this.pxjgdz == null){ return ""; } else {return this.pxjgdz;}}public String getFddbr(){ if ( this.fddbr == null){ return ""; } else {return this.fddbr;}}public String getFrlxdh(){ if ( this.frlxdh == null){ return ""; } else {return this.frlxdh;}}public String getJwfzr(){ if ( this.jwfzr == null){ return ""; } else {return this.jwfzr;}}public String getJwfzrlxdh(){ if ( this.jwfzrlxdh == null){ return ""; } else {return this.jwfzrlxdh;}}public String getJglxr(){ if ( this.jglxr == null){ return ""; } else {return this.jglxr;}}public String getJglxdh(){ if ( this.jglxdh == null){ return ""; } else {return this.jglxdh;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getFax(){ if ( this.fax == null){ return ""; } else {return this.fax;}}public String getZczj(){ if ( this.zczj == null){ return ""; } else {return this.zczj;}}public String getCreatdate(){ if ( this.creatdate == null){ return ""; } else {return this.creatdate;}}public String getZgrs(){ if ( this.zgrs == null){ return ""; } else {return this.zgrs;}}public String getZyjs(){ if ( this.zyjs == null){ return ""; } else {return this.zyjs;}}public String getJzjs(){ if ( this.jzjs == null){ return ""; } else {return this.jzjs;}}public String getGlrs(){ if ( this.glrs == null){ return ""; } else {return this.glrs;}}public String getQt(){ if ( this.qt == null){ return ""; } else {return this.qt;}}public String getJxcd(){ if ( this.jxcd == null){ return ""; } else {return this.jxcd;}}public String getZy(){ if ( this.zy == null){ return ""; } else {return this.zy;}}public String getZl(){ if ( this.zl == null){ return ""; } else {return this.zl;}}public String getZdmj(){ if ( this.zdmj == null){ return ""; } else {return this.zdmj;}}public String getDnsl(){ if ( this.dnsl == null){ return ""; } else {return this.dnsl;}}public String getFzjg(){ if ( this.fzjg == null){ return ""; } else {return this.fzjg;}}public String getZsbh(){ if ( this.zsbh == null){ return ""; } else {return this.zsbh;}}public String getZsyxqs(){ if ( this.zsyxqs == null){ return ""; } else {return this.zsyxqs;}}public String getZsyxqz(){ if ( this.zsyxqz == null){ return ""; } else {return this.zsyxqz;}}public String getBz(){ if ( this.bz == null){ return ""; } else {return this.bz;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setPxjgmc( String pxjgmc){sqlMaker.setField("pxjgmc",pxjgmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxjgmc().equals(pxjgmc))
cf.add("pxjgmc",this.pxjgmc,pxjgmc);
}
this.pxjgmc=pxjgmc;
}
public void setPxjgdz( String pxjgdz){sqlMaker.setField("pxjgdz",pxjgdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxjgdz().equals(pxjgdz))
cf.add("pxjgdz",this.pxjgdz,pxjgdz);
}
this.pxjgdz=pxjgdz;
}
public void setFddbr( String fddbr){sqlMaker.setField("fddbr",fddbr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFddbr().equals(fddbr))
cf.add("fddbr",this.fddbr,fddbr);
}
this.fddbr=fddbr;
}
public void setFrlxdh( String frlxdh){sqlMaker.setField("frlxdh",frlxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFrlxdh().equals(frlxdh))
cf.add("frlxdh",this.frlxdh,frlxdh);
}
this.frlxdh=frlxdh;
}
public void setJwfzr( String jwfzr){sqlMaker.setField("jwfzr",jwfzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJwfzr().equals(jwfzr))
cf.add("jwfzr",this.jwfzr,jwfzr);
}
this.jwfzr=jwfzr;
}
public void setJwfzrlxdh( String jwfzrlxdh){sqlMaker.setField("jwfzrlxdh",jwfzrlxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJwfzrlxdh().equals(jwfzrlxdh))
cf.add("jwfzrlxdh",this.jwfzrlxdh,jwfzrlxdh);
}
this.jwfzrlxdh=jwfzrlxdh;
}
public void setJglxr( String jglxr){sqlMaker.setField("jglxr",jglxr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJglxr().equals(jglxr))
cf.add("jglxr",this.jglxr,jglxr);
}
this.jglxr=jglxr;
}
public void setJglxdh( String jglxdh){sqlMaker.setField("jglxdh",jglxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJglxdh().equals(jglxdh))
cf.add("jglxdh",this.jglxdh,jglxdh);
}
this.jglxdh=jglxdh;
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
public void setZczj( String zczj){sqlMaker.setField("zczj",zczj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZczj().equals(zczj))
cf.add("zczj",this.zczj,zczj);
}
this.zczj=zczj;
}
public void setCreatdate( String creatdate){sqlMaker.setField("creatdate",creatdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCreatdate().equals(creatdate))
cf.add("creatdate",this.creatdate,creatdate);
}
this.creatdate=creatdate;
}
public void setZgrs( String zgrs){sqlMaker.setField("zgrs",zgrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZgrs().equals(zgrs))
cf.add("zgrs",this.zgrs,zgrs);
}
this.zgrs=zgrs;
}
public void setZyjs( String zyjs){sqlMaker.setField("zyjs",zyjs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZyjs().equals(zyjs))
cf.add("zyjs",this.zyjs,zyjs);
}
this.zyjs=zyjs;
}
public void setJzjs( String jzjs){sqlMaker.setField("jzjs",jzjs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJzjs().equals(jzjs))
cf.add("jzjs",this.jzjs,jzjs);
}
this.jzjs=jzjs;
}
public void setGlrs( String glrs){sqlMaker.setField("glrs",glrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGlrs().equals(glrs))
cf.add("glrs",this.glrs,glrs);
}
this.glrs=glrs;
}
public void setQt( String qt){sqlMaker.setField("qt",qt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getQt().equals(qt))
cf.add("qt",this.qt,qt);
}
this.qt=qt;
}
public void setJxcd( String jxcd){sqlMaker.setField("jxcd",jxcd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJxcd().equals(jxcd))
cf.add("jxcd",this.jxcd,jxcd);
}
this.jxcd=jxcd;
}
public void setZy( String zy){sqlMaker.setField("zy",zy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZy().equals(zy))
cf.add("zy",this.zy,zy);
}
this.zy=zy;
}
public void setZl( String zl){sqlMaker.setField("zl",zl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZl().equals(zl))
cf.add("zl",this.zl,zl);
}
this.zl=zl;
}
public void setZdmj( String zdmj){sqlMaker.setField("zdmj",zdmj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZdmj().equals(zdmj))
cf.add("zdmj",this.zdmj,zdmj);
}
this.zdmj=zdmj;
}
public void setDnsl( String dnsl){sqlMaker.setField("dnsl",dnsl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDnsl().equals(dnsl))
cf.add("dnsl",this.dnsl,dnsl);
}
this.dnsl=dnsl;
}
public void setFzjg( String fzjg){sqlMaker.setField("fzjg",fzjg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzjg().equals(fzjg))
cf.add("fzjg",this.fzjg,fzjg);
}
this.fzjg=fzjg;
}
public void setZsbh( String zsbh){sqlMaker.setField("zsbh",zsbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZsbh().equals(zsbh))
cf.add("zsbh",this.zsbh,zsbh);
}
this.zsbh=zsbh;
}
public void setZsyxqs( String zsyxqs){sqlMaker.setField("zsyxqs",zsyxqs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZsyxqs().equals(zsyxqs))
cf.add("zsyxqs",this.zsyxqs,zsyxqs);
}
this.zsyxqs=zsyxqs;
}
public void setZsyxqz( String zsyxqz){sqlMaker.setField("zsyxqz",zsyxqz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZsyxqz().equals(zsyxqz))
cf.add("zsyxqz",this.zsyxqz,zsyxqz);
}
this.zsyxqz=zsyxqz;
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
if (actionRequest.getFieldValue(i, "pxjgmc") != null) 
this.setPxjgmc(actionRequest.getFieldValue(i, "pxjgmc"));
if (actionRequest.getFieldValue(i, "pxjgdz") != null) 
this.setPxjgdz(actionRequest.getFieldValue(i, "pxjgdz"));
if (actionRequest.getFieldValue(i, "fddbr") != null) 
this.setFddbr(actionRequest.getFieldValue(i, "fddbr"));
if (actionRequest.getFieldValue(i, "frlxdh") != null) 
this.setFrlxdh(actionRequest.getFieldValue(i, "frlxdh"));
if (actionRequest.getFieldValue(i, "jwfzr") != null) 
this.setJwfzr(actionRequest.getFieldValue(i, "jwfzr"));
if (actionRequest.getFieldValue(i, "jwfzrlxdh") != null) 
this.setJwfzrlxdh(actionRequest.getFieldValue(i, "jwfzrlxdh"));
if (actionRequest.getFieldValue(i, "jglxr") != null) 
this.setJglxr(actionRequest.getFieldValue(i, "jglxr"));
if (actionRequest.getFieldValue(i, "jglxdh") != null) 
this.setJglxdh(actionRequest.getFieldValue(i, "jglxdh"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "fax") != null) 
this.setFax(actionRequest.getFieldValue(i, "fax"));
if (actionRequest.getFieldValue(i, "zczj") != null) 
this.setZczj(actionRequest.getFieldValue(i, "zczj"));
if (actionRequest.getFieldValue(i, "creatdate") != null) 
this.setCreatdate(actionRequest.getFieldValue(i, "creatdate"));
if (actionRequest.getFieldValue(i, "zgrs") != null) 
this.setZgrs(actionRequest.getFieldValue(i, "zgrs"));
if (actionRequest.getFieldValue(i, "zyjs") != null) 
this.setZyjs(actionRequest.getFieldValue(i, "zyjs"));
if (actionRequest.getFieldValue(i, "jzjs") != null) 
this.setJzjs(actionRequest.getFieldValue(i, "jzjs"));
if (actionRequest.getFieldValue(i, "glrs") != null) 
this.setGlrs(actionRequest.getFieldValue(i, "glrs"));
if (actionRequest.getFieldValue(i, "qt") != null) 
this.setQt(actionRequest.getFieldValue(i, "qt"));
if (actionRequest.getFieldValue(i, "jxcd") != null) 
this.setJxcd(actionRequest.getFieldValue(i, "jxcd"));
if (actionRequest.getFieldValue(i, "zy") != null) 
this.setZy(actionRequest.getFieldValue(i, "zy"));
if (actionRequest.getFieldValue(i, "zl") != null) 
this.setZl(actionRequest.getFieldValue(i, "zl"));
if (actionRequest.getFieldValue(i, "zdmj") != null) 
this.setZdmj(actionRequest.getFieldValue(i, "zdmj"));
if (actionRequest.getFieldValue(i, "dnsl") != null) 
this.setDnsl(actionRequest.getFieldValue(i, "dnsl"));
if (actionRequest.getFieldValue(i, "fzjg") != null) 
this.setFzjg(actionRequest.getFieldValue(i, "fzjg"));
if (actionRequest.getFieldValue(i, "zsbh") != null) 
this.setZsbh(actionRequest.getFieldValue(i, "zsbh"));
if (actionRequest.getFieldValue(i, "zsyxqs") != null) 
this.setZsyxqs(actionRequest.getFieldValue(i, "zsyxqs"));
if (actionRequest.getFieldValue(i, "zsyxqz") != null) 
this.setZsyxqz(actionRequest.getFieldValue(i, "zsyxqz"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PxjgbaxxBean obj = (PxjgbaxxBean)super.clone();obj.setSysno(obj.sysno);
obj.setPxjgmc(obj.pxjgmc);
obj.setPxjgdz(obj.pxjgdz);
obj.setFddbr(obj.fddbr);
obj.setFrlxdh(obj.frlxdh);
obj.setJwfzr(obj.jwfzr);
obj.setJwfzrlxdh(obj.jwfzrlxdh);
obj.setJglxr(obj.jglxr);
obj.setJglxdh(obj.jglxdh);
obj.setLxdh(obj.lxdh);
obj.setFax(obj.fax);
obj.setZczj(obj.zczj);
obj.setCreatdate(obj.creatdate);
obj.setZgrs(obj.zgrs);
obj.setZyjs(obj.zyjs);
obj.setJzjs(obj.jzjs);
obj.setGlrs(obj.glrs);
obj.setQt(obj.qt);
obj.setJxcd(obj.jxcd);
obj.setZy(obj.zy);
obj.setZl(obj.zl);
obj.setZdmj(obj.zdmj);
obj.setDnsl(obj.dnsl);
obj.setFzjg(obj.fzjg);
obj.setZsbh(obj.zsbh);
obj.setZsyxqs(obj.zsyxqs);
obj.setZsyxqz(obj.zsyxqz);
obj.setBz(obj.bz);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}