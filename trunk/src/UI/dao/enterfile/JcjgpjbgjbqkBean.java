package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class JcjgpjbgjbqkBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new JcjgpjbgjbqkBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new JcjgpjbgjbqkBean().findAndLockByWhere(sSqlWhere);      }       public static JcjgpjbgjbqkBean findFirst(String sSqlWhere)throws Exception {           return (JcjgpjbgjbqkBean)new JcjgpjbgjbqkBean().findFirstByWhere(sSqlWhere);      }       public static JcjgpjbgjbqkBean findFirstAndLock(String sSqlWhere)throws Exception {           return (JcjgpjbgjbqkBean)new JcjgpjbgjbqkBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new JcjgpjbgjbqkBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgpjbgjbqkBean bean = new JcjgpjbgjbqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcjgpjbgjbqkBean bean = new JcjgpjbgjbqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static JcjgpjbgjbqkBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgpjbgjbqkBean bean = new JcjgpjbgjbqkBean();           bean.setAutoRelease(isAutoRelease);           return (JcjgpjbgjbqkBean)bean.findFirstByWhere(sSqlWhere);      }       public static JcjgpjbgjbqkBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcjgpjbgjbqkBean bean = new JcjgpjbgjbqkBean();           bean.setAutoRelease(isAutoRelease);           return (JcjgpjbgjbqkBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgpjbgjbqkBean bean = new JcjgpjbgjbqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  bgbh;
String  wtdwbh;
String  wtdwmc;
String  ypsl;
String  pjlx;
String  ypcjsj;
String  sysfxsj;
String  bzr;
String  bzrq;
String  shrxm;
String  shrq;
String  sqqz;
String  qzrq;
String  jsdwmc;
String  jsdwbh;
String  xmdz;
String  fhxs;
String  bfhxs;
String  xmztze;
String  bgsf;
String  htfj;
String  bgfj;
String  sfhg;
String  qp;
String  jp;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
String  xmbh;
String  xmmc;
public static final String TABLENAME ="jcjgpjbgjbqk";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
JcjgpjbgjbqkBean abb = new JcjgpjbgjbqkBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.bgbh=rs.getString("bgbh");
abb.setKeyValue("BGBH","" + abb.getBgbh());
abb.wtdwbh=rs.getString("wtdwbh");
abb.setKeyValue("WTDWBH","" + abb.getWtdwbh());
abb.wtdwmc=rs.getString("wtdwmc");
abb.setKeyValue("WTDWMC","" + abb.getWtdwmc());
abb.ypsl=rs.getString("ypsl");
abb.setKeyValue("YPSL","" + abb.getYpsl());
abb.pjlx=rs.getString("pjlx");
abb.setKeyValue("PJLX","" + abb.getPjlx());
abb.ypcjsj=rs.getString("ypcjsj");
abb.setKeyValue("YPCJSJ","" + abb.getYpcjsj());
abb.sysfxsj=rs.getString("sysfxsj");
abb.setKeyValue("SYSFXSJ","" + abb.getSysfxsj());
abb.bzr=rs.getString("bzr");
abb.setKeyValue("BZR","" + abb.getBzr());
abb.bzrq=rs.getString("bzrq");
abb.setKeyValue("BZRQ","" + abb.getBzrq());
abb.shrxm=rs.getString("shrxm");
abb.setKeyValue("SHRXM","" + abb.getShrxm());
abb.shrq=rs.getString("shrq");
abb.setKeyValue("SHRQ","" + abb.getShrq());
abb.sqqz=rs.getString("sqqz");
abb.setKeyValue("SQQZ","" + abb.getSqqz());
abb.qzrq=rs.getString("qzrq");
abb.setKeyValue("QZRQ","" + abb.getQzrq());
abb.jsdwmc=rs.getString("jsdwmc");
abb.setKeyValue("JSDWMC","" + abb.getJsdwmc());
abb.jsdwbh=rs.getString("jsdwbh");
abb.setKeyValue("JSDWBH","" + abb.getJsdwbh());
abb.xmdz=rs.getString("xmdz");
abb.setKeyValue("XMDZ","" + abb.getXmdz());
abb.fhxs=rs.getString("fhxs");
abb.setKeyValue("FHXS","" + abb.getFhxs());
abb.bfhxs=rs.getString("bfhxs");
abb.setKeyValue("BFHXS","" + abb.getBfhxs());
abb.xmztze=rs.getString("xmztze");
abb.setKeyValue("XMZTZE","" + abb.getXmztze());
abb.bgsf=rs.getString("bgsf");
abb.setKeyValue("BGSF","" + abb.getBgsf());
abb.htfj=rs.getString("htfj");
abb.setKeyValue("HTFJ","" + abb.getHtfj());
abb.bgfj=rs.getString("bgfj");
abb.setKeyValue("BGFJ","" + abb.getBgfj());
abb.sfhg=rs.getString("sfhg");
abb.setKeyValue("SFHG","" + abb.getSfhg());
abb.qp=rs.getString("qp");
abb.setKeyValue("QP","" + abb.getQp());
abb.jp=rs.getString("jp");
abb.setKeyValue("JP","" + abb.getJp());
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
abb.xmbh=rs.getString("xmbh");
abb.setKeyValue("XMBH","" + abb.getXmbh());
abb.xmmc=rs.getString("xmmc");
abb.setKeyValue("XMMC","" + abb.getXmmc());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getBgbh(){ if ( this.bgbh == null){ return ""; } else {return this.bgbh;}}public String getWtdwbh(){ if ( this.wtdwbh == null){ return ""; } else {return this.wtdwbh;}}public String getWtdwmc(){ if ( this.wtdwmc == null){ return ""; } else {return this.wtdwmc;}}public String getYpsl(){ if ( this.ypsl == null){ return ""; } else {return this.ypsl;}}public String getPjlx(){ if ( this.pjlx == null){ return ""; } else {return this.pjlx;}}public String getYpcjsj(){ if ( this.ypcjsj == null){ return ""; } else {return this.ypcjsj;}}public String getSysfxsj(){ if ( this.sysfxsj == null){ return ""; } else {return this.sysfxsj;}}public String getBzr(){ if ( this.bzr == null){ return ""; } else {return this.bzr;}}public String getBzrq(){ if ( this.bzrq == null){ return ""; } else {return this.bzrq;}}public String getShrxm(){ if ( this.shrxm == null){ return ""; } else {return this.shrxm;}}public String getShrq(){ if ( this.shrq == null){ return ""; } else {return this.shrq;}}public String getSqqz(){ if ( this.sqqz == null){ return ""; } else {return this.sqqz;}}public String getQzrq(){ if ( this.qzrq == null){ return ""; } else {return this.qzrq;}}public String getJsdwmc(){ if ( this.jsdwmc == null){ return ""; } else {return this.jsdwmc;}}public String getJsdwbh(){ if ( this.jsdwbh == null){ return ""; } else {return this.jsdwbh;}}public String getXmdz(){ if ( this.xmdz == null){ return ""; } else {return this.xmdz;}}public String getFhxs(){ if ( this.fhxs == null){ return ""; } else {return this.fhxs;}}public String getBfhxs(){ if ( this.bfhxs == null){ return ""; } else {return this.bfhxs;}}public String getXmztze(){ if ( this.xmztze == null){ return ""; } else {return this.xmztze;}}public String getBgsf(){ if ( this.bgsf == null){ return ""; } else {return this.bgsf;}}public String getHtfj(){ if ( this.htfj == null){ return ""; } else {return this.htfj;}}public String getBgfj(){ if ( this.bgfj == null){ return ""; } else {return this.bgfj;}}public String getSfhg(){ if ( this.sfhg == null){ return ""; } else {return this.sfhg;}}public String getQp(){ if ( this.qp == null){ return ""; } else {return this.qp;}}public String getJp(){ if ( this.jp == null){ return ""; } else {return this.jp;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public String getXmbh(){ if ( this.xmbh == null){ return ""; } else {return this.xmbh;}}public String getXmmc(){ if ( this.xmmc == null){ return ""; } else {return this.xmmc;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setWtdwbh( String wtdwbh){sqlMaker.setField("wtdwbh",wtdwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWtdwbh().equals(wtdwbh))
cf.add("wtdwbh",this.wtdwbh,wtdwbh);
}
this.wtdwbh=wtdwbh;
}
public void setWtdwmc( String wtdwmc){sqlMaker.setField("wtdwmc",wtdwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWtdwmc().equals(wtdwmc))
cf.add("wtdwmc",this.wtdwmc,wtdwmc);
}
this.wtdwmc=wtdwmc;
}
public void setYpsl( String ypsl){sqlMaker.setField("ypsl",ypsl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYpsl().equals(ypsl))
cf.add("ypsl",this.ypsl,ypsl);
}
this.ypsl=ypsl;
}
public void setPjlx( String pjlx){sqlMaker.setField("pjlx",pjlx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPjlx().equals(pjlx))
cf.add("pjlx",this.pjlx,pjlx);
}
this.pjlx=pjlx;
}
public void setYpcjsj( String ypcjsj){sqlMaker.setField("ypcjsj",ypcjsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYpcjsj().equals(ypcjsj))
cf.add("ypcjsj",this.ypcjsj,ypcjsj);
}
this.ypcjsj=ypcjsj;
}
public void setSysfxsj( String sysfxsj){sqlMaker.setField("sysfxsj",sysfxsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysfxsj().equals(sysfxsj))
cf.add("sysfxsj",this.sysfxsj,sysfxsj);
}
this.sysfxsj=sysfxsj;
}
public void setBzr( String bzr){sqlMaker.setField("bzr",bzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBzr().equals(bzr))
cf.add("bzr",this.bzr,bzr);
}
this.bzr=bzr;
}
public void setBzrq( String bzrq){sqlMaker.setField("bzrq",bzrq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBzrq().equals(bzrq))
cf.add("bzrq",this.bzrq,bzrq);
}
this.bzrq=bzrq;
}
public void setShrxm( String shrxm){sqlMaker.setField("shrxm",shrxm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getShrxm().equals(shrxm))
cf.add("shrxm",this.shrxm,shrxm);
}
this.shrxm=shrxm;
}
public void setShrq( String shrq){sqlMaker.setField("shrq",shrq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getShrq().equals(shrq))
cf.add("shrq",this.shrq,shrq);
}
this.shrq=shrq;
}
public void setSqqz( String sqqz){sqlMaker.setField("sqqz",sqqz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSqqz().equals(sqqz))
cf.add("sqqz",this.sqqz,sqqz);
}
this.sqqz=sqqz;
}
public void setQzrq( String qzrq){sqlMaker.setField("qzrq",qzrq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getQzrq().equals(qzrq))
cf.add("qzrq",this.qzrq,qzrq);
}
this.qzrq=qzrq;
}
public void setJsdwmc( String jsdwmc){sqlMaker.setField("jsdwmc",jsdwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJsdwmc().equals(jsdwmc))
cf.add("jsdwmc",this.jsdwmc,jsdwmc);
}
this.jsdwmc=jsdwmc;
}
public void setJsdwbh( String jsdwbh){sqlMaker.setField("jsdwbh",jsdwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJsdwbh().equals(jsdwbh))
cf.add("jsdwbh",this.jsdwbh,jsdwbh);
}
this.jsdwbh=jsdwbh;
}
public void setXmdz( String xmdz){sqlMaker.setField("xmdz",xmdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXmdz().equals(xmdz))
cf.add("xmdz",this.xmdz,xmdz);
}
this.xmdz=xmdz;
}
public void setFhxs( String fhxs){sqlMaker.setField("fhxs",fhxs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFhxs().equals(fhxs))
cf.add("fhxs",this.fhxs,fhxs);
}
this.fhxs=fhxs;
}
public void setBfhxs( String bfhxs){sqlMaker.setField("bfhxs",bfhxs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBfhxs().equals(bfhxs))
cf.add("bfhxs",this.bfhxs,bfhxs);
}
this.bfhxs=bfhxs;
}
public void setXmztze( String xmztze){sqlMaker.setField("xmztze",xmztze,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXmztze().equals(xmztze))
cf.add("xmztze",this.xmztze,xmztze);
}
this.xmztze=xmztze;
}
public void setBgsf( String bgsf){sqlMaker.setField("bgsf",bgsf,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBgsf().equals(bgsf))
cf.add("bgsf",this.bgsf,bgsf);
}
this.bgsf=bgsf;
}
public void setHtfj( String htfj){sqlMaker.setField("htfj",htfj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHtfj().equals(htfj))
cf.add("htfj",this.htfj,htfj);
}
this.htfj=htfj;
}
public void setBgfj( String bgfj){sqlMaker.setField("bgfj",bgfj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBgfj().equals(bgfj))
cf.add("bgfj",this.bgfj,bgfj);
}
this.bgfj=bgfj;
}
public void setSfhg( String sfhg){sqlMaker.setField("sfhg",sfhg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfhg().equals(sfhg))
cf.add("sfhg",this.sfhg,sfhg);
}
this.sfhg=sfhg;
}
public void setQp( String qp){sqlMaker.setField("qp",qp,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getQp().equals(qp))
cf.add("qp",this.qp,qp);
}
this.qp=qp;
}
public void setJp( String jp){sqlMaker.setField("jp",jp,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJp().equals(jp))
cf.add("jp",this.jp,jp);
}
this.jp=jp;
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
public void setXmbh( String xmbh){sqlMaker.setField("xmbh",xmbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXmbh().equals(xmbh))
cf.add("xmbh",this.xmbh,xmbh);
}
this.xmbh=xmbh;
}
public void setXmmc( String xmmc){sqlMaker.setField("xmmc",xmmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXmmc().equals(xmmc))
cf.add("xmmc",this.xmmc,xmmc);
}
this.xmmc=xmmc;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "bgbh") != null) 
this.setBgbh(actionRequest.getFieldValue(i, "bgbh"));
if (actionRequest.getFieldValue(i, "wtdwbh") != null) 
this.setWtdwbh(actionRequest.getFieldValue(i, "wtdwbh"));
if (actionRequest.getFieldValue(i, "wtdwmc") != null) 
this.setWtdwmc(actionRequest.getFieldValue(i, "wtdwmc"));
if (actionRequest.getFieldValue(i, "ypsl") != null) 
this.setYpsl(actionRequest.getFieldValue(i, "ypsl"));
if (actionRequest.getFieldValue(i, "pjlx") != null) 
this.setPjlx(actionRequest.getFieldValue(i, "pjlx"));
if (actionRequest.getFieldValue(i, "ypcjsj") != null) 
this.setYpcjsj(actionRequest.getFieldValue(i, "ypcjsj"));
if (actionRequest.getFieldValue(i, "sysfxsj") != null) 
this.setSysfxsj(actionRequest.getFieldValue(i, "sysfxsj"));
if (actionRequest.getFieldValue(i, "bzr") != null) 
this.setBzr(actionRequest.getFieldValue(i, "bzr"));
if (actionRequest.getFieldValue(i, "bzrq") != null) 
this.setBzrq(actionRequest.getFieldValue(i, "bzrq"));
if (actionRequest.getFieldValue(i, "shrxm") != null) 
this.setShrxm(actionRequest.getFieldValue(i, "shrxm"));
if (actionRequest.getFieldValue(i, "shrq") != null) 
this.setShrq(actionRequest.getFieldValue(i, "shrq"));
if (actionRequest.getFieldValue(i, "sqqz") != null) 
this.setSqqz(actionRequest.getFieldValue(i, "sqqz"));
if (actionRequest.getFieldValue(i, "qzrq") != null) 
this.setQzrq(actionRequest.getFieldValue(i, "qzrq"));
if (actionRequest.getFieldValue(i, "jsdwmc") != null) 
this.setJsdwmc(actionRequest.getFieldValue(i, "jsdwmc"));
if (actionRequest.getFieldValue(i, "jsdwbh") != null) 
this.setJsdwbh(actionRequest.getFieldValue(i, "jsdwbh"));
if (actionRequest.getFieldValue(i, "xmdz") != null) 
this.setXmdz(actionRequest.getFieldValue(i, "xmdz"));
if (actionRequest.getFieldValue(i, "fhxs") != null) 
this.setFhxs(actionRequest.getFieldValue(i, "fhxs"));
if (actionRequest.getFieldValue(i, "bfhxs") != null) 
this.setBfhxs(actionRequest.getFieldValue(i, "bfhxs"));
if (actionRequest.getFieldValue(i, "xmztze") != null) 
this.setXmztze(actionRequest.getFieldValue(i, "xmztze"));
if (actionRequest.getFieldValue(i, "bgsf") != null) 
this.setBgsf(actionRequest.getFieldValue(i, "bgsf"));
if (actionRequest.getFieldValue(i, "htfj") != null) 
this.setHtfj(actionRequest.getFieldValue(i, "htfj"));
if (actionRequest.getFieldValue(i, "bgfj") != null) 
this.setBgfj(actionRequest.getFieldValue(i, "bgfj"));
if (actionRequest.getFieldValue(i, "sfhg") != null) 
this.setSfhg(actionRequest.getFieldValue(i, "sfhg"));
if (actionRequest.getFieldValue(i, "qp") != null) 
this.setQp(actionRequest.getFieldValue(i, "qp"));
if (actionRequest.getFieldValue(i, "jp") != null) 
this.setJp(actionRequest.getFieldValue(i, "jp"));
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
if (actionRequest.getFieldValue(i, "xmbh") != null) 
this.setXmbh(actionRequest.getFieldValue(i, "xmbh"));
if (actionRequest.getFieldValue(i, "xmmc") != null) 
this.setXmmc(actionRequest.getFieldValue(i, "xmmc"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { JcjgpjbgjbqkBean obj = (JcjgpjbgjbqkBean)super.clone();obj.setSysno(obj.sysno);
obj.setBgbh(obj.bgbh);
obj.setWtdwbh(obj.wtdwbh);
obj.setWtdwmc(obj.wtdwmc);
obj.setYpsl(obj.ypsl);
obj.setPjlx(obj.pjlx);
obj.setYpcjsj(obj.ypcjsj);
obj.setSysfxsj(obj.sysfxsj);
obj.setBzr(obj.bzr);
obj.setBzrq(obj.bzrq);
obj.setShrxm(obj.shrxm);
obj.setShrq(obj.shrq);
obj.setSqqz(obj.sqqz);
obj.setQzrq(obj.qzrq);
obj.setJsdwmc(obj.jsdwmc);
obj.setJsdwbh(obj.jsdwbh);
obj.setXmdz(obj.xmdz);
obj.setFhxs(obj.fhxs);
obj.setBfhxs(obj.bfhxs);
obj.setXmztze(obj.xmztze);
obj.setBgsf(obj.bgsf);
obj.setHtfj(obj.htfj);
obj.setBgfj(obj.bgfj);
obj.setSfhg(obj.sfhg);
obj.setQp(obj.qp);
obj.setJp(obj.jp);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
obj.setXmbh(obj.xmbh);
obj.setXmmc(obj.xmmc);
return obj;}}