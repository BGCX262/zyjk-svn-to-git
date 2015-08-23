package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class ZyjkflfjBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new ZyjkflfjBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new ZyjkflfjBean().findAndLockByWhere(sSqlWhere);      }       public static ZyjkflfjBean findFirst(String sSqlWhere)throws Exception {           return (ZyjkflfjBean)new ZyjkflfjBean().findFirstByWhere(sSqlWhere);      }       public static ZyjkflfjBean findFirstAndLock(String sSqlWhere)throws Exception {           return (ZyjkflfjBean)new ZyjkflfjBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new ZyjkflfjBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZyjkflfjBean bean = new ZyjkflfjBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           ZyjkflfjBean bean = new ZyjkflfjBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static ZyjkflfjBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZyjkflfjBean bean = new ZyjkflfjBean();           bean.setAutoRelease(isAutoRelease);           return (ZyjkflfjBean)bean.findFirstByWhere(sSqlWhere);      }       public static ZyjkflfjBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           ZyjkflfjBean bean = new ZyjkflfjBean();           bean.setAutoRelease(isAutoRelease);           return (ZyjkflfjBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZyjkflfjBean bean = new ZyjkflfjBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  corpkey;
String  dwmc;
String  dwdz;
String  lxr;
String  lxdh;
String  fddbr;
String  jdgldj;
String  wsgldj;
String  whlb;
String  jcrs;
String  whysmc;
String  whys;
String  doc1;
String  doc2;
String  doc3;
String  doc4;
String  doc5;
String  doc6;
String  doc7;
String  doc8;
String  doc9;
String  doc10;
String  doc11;
String  doc12;
String  doc13;
String  doc14;
String  doc15;
String  doc16;
String  doc17;
String  doc18;
String  doc19;
String  doc20;
String  doc21;
String  doc22;
String  doc23;
String  doc24;
String  doc25;
String  ptr;
String  jdry1;
String  jdry2;
String  date1;
String  date2;
String  jdrybh1;
String  jdrybh2;
String  zongfen;
String  nianfen;
String  bz1;
String  bz2;
String  bz3;
String  bz4;
String  bz5;
String  bz6;
String  bz7;
String  bz8;
String  bz9;
String  bz10;
String  bz11;
String  bz12;
String  bz13;
String  bz14;
String  bz15;
String  bz16;
String  bz17;
String  bz18;
String  bz19;
String  bz20;
String  bz21;
String  bz22;
String  bz23;
String  bz24;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
String  distcode;
String  wghkey;
public static final String TABLENAME ="zyjkflfj";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
ZyjkflfjBean abb = new ZyjkflfjBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.corpkey=rs.getString("corpkey");
abb.setKeyValue("CORPKEY","" + abb.getCorpkey());
abb.dwmc=rs.getString("dwmc");
abb.setKeyValue("DWMC","" + abb.getDwmc());
abb.dwdz=rs.getString("dwdz");
abb.setKeyValue("DWDZ","" + abb.getDwdz());
abb.lxr=rs.getString("lxr");
abb.setKeyValue("LXR","" + abb.getLxr());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.fddbr=rs.getString("fddbr");
abb.setKeyValue("FDDBR","" + abb.getFddbr());
abb.jdgldj=rs.getString("jdgldj");
abb.setKeyValue("JDGLDJ","" + abb.getJdgldj());
abb.wsgldj=rs.getString("wsgldj");
abb.setKeyValue("WSGLDJ","" + abb.getWsgldj());
abb.whlb=rs.getString("whlb");
abb.setKeyValue("WHLB","" + abb.getWhlb());
abb.jcrs=rs.getString("jcrs");
abb.setKeyValue("JCRS","" + abb.getJcrs());
abb.whysmc=rs.getString("whysmc");
abb.setKeyValue("WHYSMC","" + abb.getWhysmc());
abb.whys=rs.getString("whys");
abb.setKeyValue("WHYS","" + abb.getWhys());
abb.doc1=rs.getString("doc1");
abb.setKeyValue("DOC1","" + abb.getDoc1());
abb.doc2=rs.getString("doc2");
abb.setKeyValue("DOC2","" + abb.getDoc2());
abb.doc3=rs.getString("doc3");
abb.setKeyValue("DOC3","" + abb.getDoc3());
abb.doc4=rs.getString("doc4");
abb.setKeyValue("DOC4","" + abb.getDoc4());
abb.doc5=rs.getString("doc5");
abb.setKeyValue("DOC5","" + abb.getDoc5());
abb.doc6=rs.getString("doc6");
abb.setKeyValue("DOC6","" + abb.getDoc6());
abb.doc7=rs.getString("doc7");
abb.setKeyValue("DOC7","" + abb.getDoc7());
abb.doc8=rs.getString("doc8");
abb.setKeyValue("DOC8","" + abb.getDoc8());
abb.doc9=rs.getString("doc9");
abb.setKeyValue("DOC9","" + abb.getDoc9());
abb.doc10=rs.getString("doc10");
abb.setKeyValue("DOC10","" + abb.getDoc10());
abb.doc11=rs.getString("doc11");
abb.setKeyValue("DOC11","" + abb.getDoc11());
abb.doc12=rs.getString("doc12");
abb.setKeyValue("DOC12","" + abb.getDoc12());
abb.doc13=rs.getString("doc13");
abb.setKeyValue("DOC13","" + abb.getDoc13());
abb.doc14=rs.getString("doc14");
abb.setKeyValue("DOC14","" + abb.getDoc14());
abb.doc15=rs.getString("doc15");
abb.setKeyValue("DOC15","" + abb.getDoc15());
abb.doc16=rs.getString("doc16");
abb.setKeyValue("DOC16","" + abb.getDoc16());
abb.doc17=rs.getString("doc17");
abb.setKeyValue("DOC17","" + abb.getDoc17());
abb.doc18=rs.getString("doc18");
abb.setKeyValue("DOC18","" + abb.getDoc18());
abb.doc19=rs.getString("doc19");
abb.setKeyValue("DOC19","" + abb.getDoc19());
abb.doc20=rs.getString("doc20");
abb.setKeyValue("DOC20","" + abb.getDoc20());
abb.doc21=rs.getString("doc21");
abb.setKeyValue("DOC21","" + abb.getDoc21());
abb.doc22=rs.getString("doc22");
abb.setKeyValue("DOC22","" + abb.getDoc22());
abb.doc23=rs.getString("doc23");
abb.setKeyValue("DOC23","" + abb.getDoc23());
abb.doc24=rs.getString("doc24");
abb.setKeyValue("DOC24","" + abb.getDoc24());
abb.doc25=rs.getString("doc25");
abb.setKeyValue("DOC25","" + abb.getDoc25());
abb.ptr=rs.getString("ptr");
abb.setKeyValue("PTR","" + abb.getPtr());
abb.jdry1=rs.getString("jdry1");
abb.setKeyValue("JDRY1","" + abb.getJdry1());
abb.jdry2=rs.getString("jdry2");
abb.setKeyValue("JDRY2","" + abb.getJdry2());
abb.date1=rs.getString("date1");
abb.setKeyValue("DATE1","" + abb.getDate1());
abb.date2=rs.getString("date2");
abb.setKeyValue("DATE2","" + abb.getDate2());
abb.jdrybh1=rs.getString("jdrybh1");
abb.setKeyValue("JDRYBH1","" + abb.getJdrybh1());
abb.jdrybh2=rs.getString("jdrybh2");
abb.setKeyValue("JDRYBH2","" + abb.getJdrybh2());
abb.zongfen=rs.getString("zongfen");
abb.setKeyValue("ZONGFEN","" + abb.getZongfen());
abb.nianfen=rs.getString("nianfen");
abb.setKeyValue("NIANFEN","" + abb.getNianfen());
abb.bz1=rs.getString("bz1");
abb.setKeyValue("BZ1","" + abb.getBz1());
abb.bz2=rs.getString("bz2");
abb.setKeyValue("BZ2","" + abb.getBz2());
abb.bz3=rs.getString("bz3");
abb.setKeyValue("BZ3","" + abb.getBz3());
abb.bz4=rs.getString("bz4");
abb.setKeyValue("BZ4","" + abb.getBz4());
abb.bz5=rs.getString("bz5");
abb.setKeyValue("BZ5","" + abb.getBz5());
abb.bz6=rs.getString("bz6");
abb.setKeyValue("BZ6","" + abb.getBz6());
abb.bz7=rs.getString("bz7");
abb.setKeyValue("BZ7","" + abb.getBz7());
abb.bz8=rs.getString("bz8");
abb.setKeyValue("BZ8","" + abb.getBz8());
abb.bz9=rs.getString("bz9");
abb.setKeyValue("BZ9","" + abb.getBz9());
abb.bz10=rs.getString("bz10");
abb.setKeyValue("BZ10","" + abb.getBz10());
abb.bz11=rs.getString("bz11");
abb.setKeyValue("BZ11","" + abb.getBz11());
abb.bz12=rs.getString("bz12");
abb.setKeyValue("BZ12","" + abb.getBz12());
abb.bz13=rs.getString("bz13");
abb.setKeyValue("BZ13","" + abb.getBz13());
abb.bz14=rs.getString("bz14");
abb.setKeyValue("BZ14","" + abb.getBz14());
abb.bz15=rs.getString("bz15");
abb.setKeyValue("BZ15","" + abb.getBz15());
abb.bz16=rs.getString("bz16");
abb.setKeyValue("BZ16","" + abb.getBz16());
abb.bz17=rs.getString("bz17");
abb.setKeyValue("BZ17","" + abb.getBz17());
abb.bz18=rs.getString("bz18");
abb.setKeyValue("BZ18","" + abb.getBz18());
abb.bz19=rs.getString("bz19");
abb.setKeyValue("BZ19","" + abb.getBz19());
abb.bz20=rs.getString("bz20");
abb.setKeyValue("BZ20","" + abb.getBz20());
abb.bz21=rs.getString("bz21");
abb.setKeyValue("BZ21","" + abb.getBz21());
abb.bz22=rs.getString("bz22");
abb.setKeyValue("BZ22","" + abb.getBz22());
abb.bz23=rs.getString("bz23");
abb.setKeyValue("BZ23","" + abb.getBz23());
abb.bz24=rs.getString("bz24");
abb.setKeyValue("BZ24","" + abb.getBz24());
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
abb.distcode=rs.getString("distcode");
abb.setKeyValue("DISTCODE","" + abb.getDistcode());
abb.wghkey=rs.getString("wghkey");
abb.setKeyValue("WGHKEY","" + abb.getWghkey());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getCorpkey(){ if ( this.corpkey == null){ return ""; } else {return this.corpkey;}}public String getDwmc(){ if ( this.dwmc == null){ return ""; } else {return this.dwmc;}}public String getDwdz(){ if ( this.dwdz == null){ return ""; } else {return this.dwdz;}}public String getLxr(){ if ( this.lxr == null){ return ""; } else {return this.lxr;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getFddbr(){ if ( this.fddbr == null){ return ""; } else {return this.fddbr;}}public String getJdgldj(){ if ( this.jdgldj == null){ return ""; } else {return this.jdgldj;}}public String getWsgldj(){ if ( this.wsgldj == null){ return ""; } else {return this.wsgldj;}}public String getWhlb(){ if ( this.whlb == null){ return ""; } else {return this.whlb;}}public String getJcrs(){ if ( this.jcrs == null){ return ""; } else {return this.jcrs;}}public String getWhysmc(){ if ( this.whysmc == null){ return ""; } else {return this.whysmc;}}public String getWhys(){ if ( this.whys == null){ return ""; } else {return this.whys;}}public String getDoc1(){ if ( this.doc1 == null){ return ""; } else {return this.doc1;}}public String getDoc2(){ if ( this.doc2 == null){ return ""; } else {return this.doc2;}}public String getDoc3(){ if ( this.doc3 == null){ return ""; } else {return this.doc3;}}public String getDoc4(){ if ( this.doc4 == null){ return ""; } else {return this.doc4;}}public String getDoc5(){ if ( this.doc5 == null){ return ""; } else {return this.doc5;}}public String getDoc6(){ if ( this.doc6 == null){ return ""; } else {return this.doc6;}}public String getDoc7(){ if ( this.doc7 == null){ return ""; } else {return this.doc7;}}public String getDoc8(){ if ( this.doc8 == null){ return ""; } else {return this.doc8;}}public String getDoc9(){ if ( this.doc9 == null){ return ""; } else {return this.doc9;}}public String getDoc10(){ if ( this.doc10 == null){ return ""; } else {return this.doc10;}}public String getDoc11(){ if ( this.doc11 == null){ return ""; } else {return this.doc11;}}public String getDoc12(){ if ( this.doc12 == null){ return ""; } else {return this.doc12;}}public String getDoc13(){ if ( this.doc13 == null){ return ""; } else {return this.doc13;}}public String getDoc14(){ if ( this.doc14 == null){ return ""; } else {return this.doc14;}}public String getDoc15(){ if ( this.doc15 == null){ return ""; } else {return this.doc15;}}public String getDoc16(){ if ( this.doc16 == null){ return ""; } else {return this.doc16;}}public String getDoc17(){ if ( this.doc17 == null){ return ""; } else {return this.doc17;}}public String getDoc18(){ if ( this.doc18 == null){ return ""; } else {return this.doc18;}}public String getDoc19(){ if ( this.doc19 == null){ return ""; } else {return this.doc19;}}public String getDoc20(){ if ( this.doc20 == null){ return ""; } else {return this.doc20;}}public String getDoc21(){ if ( this.doc21 == null){ return ""; } else {return this.doc21;}}public String getDoc22(){ if ( this.doc22 == null){ return ""; } else {return this.doc22;}}public String getDoc23(){ if ( this.doc23 == null){ return ""; } else {return this.doc23;}}public String getDoc24(){ if ( this.doc24 == null){ return ""; } else {return this.doc24;}}public String getDoc25(){ if ( this.doc25 == null){ return ""; } else {return this.doc25;}}public String getPtr(){ if ( this.ptr == null){ return ""; } else {return this.ptr;}}public String getJdry1(){ if ( this.jdry1 == null){ return ""; } else {return this.jdry1;}}public String getJdry2(){ if ( this.jdry2 == null){ return ""; } else {return this.jdry2;}}public String getDate1(){ if ( this.date1 == null){ return ""; } else {return this.date1;}}public String getDate2(){ if ( this.date2 == null){ return ""; } else {return this.date2;}}public String getJdrybh1(){ if ( this.jdrybh1 == null){ return ""; } else {return this.jdrybh1;}}public String getJdrybh2(){ if ( this.jdrybh2 == null){ return ""; } else {return this.jdrybh2;}}public String getZongfen(){ if ( this.zongfen == null){ return ""; } else {return this.zongfen;}}public String getNianfen(){ if ( this.nianfen == null){ return ""; } else {return this.nianfen;}}public String getBz1(){ if ( this.bz1 == null){ return ""; } else {return this.bz1;}}public String getBz2(){ if ( this.bz2 == null){ return ""; } else {return this.bz2;}}public String getBz3(){ if ( this.bz3 == null){ return ""; } else {return this.bz3;}}public String getBz4(){ if ( this.bz4 == null){ return ""; } else {return this.bz4;}}public String getBz5(){ if ( this.bz5 == null){ return ""; } else {return this.bz5;}}public String getBz6(){ if ( this.bz6 == null){ return ""; } else {return this.bz6;}}public String getBz7(){ if ( this.bz7 == null){ return ""; } else {return this.bz7;}}public String getBz8(){ if ( this.bz8 == null){ return ""; } else {return this.bz8;}}public String getBz9(){ if ( this.bz9 == null){ return ""; } else {return this.bz9;}}public String getBz10(){ if ( this.bz10 == null){ return ""; } else {return this.bz10;}}public String getBz11(){ if ( this.bz11 == null){ return ""; } else {return this.bz11;}}public String getBz12(){ if ( this.bz12 == null){ return ""; } else {return this.bz12;}}public String getBz13(){ if ( this.bz13 == null){ return ""; } else {return this.bz13;}}public String getBz14(){ if ( this.bz14 == null){ return ""; } else {return this.bz14;}}public String getBz15(){ if ( this.bz15 == null){ return ""; } else {return this.bz15;}}public String getBz16(){ if ( this.bz16 == null){ return ""; } else {return this.bz16;}}public String getBz17(){ if ( this.bz17 == null){ return ""; } else {return this.bz17;}}public String getBz18(){ if ( this.bz18 == null){ return ""; } else {return this.bz18;}}public String getBz19(){ if ( this.bz19 == null){ return ""; } else {return this.bz19;}}public String getBz20(){ if ( this.bz20 == null){ return ""; } else {return this.bz20;}}public String getBz21(){ if ( this.bz21 == null){ return ""; } else {return this.bz21;}}public String getBz22(){ if ( this.bz22 == null){ return ""; } else {return this.bz22;}}public String getBz23(){ if ( this.bz23 == null){ return ""; } else {return this.bz23;}}public String getBz24(){ if ( this.bz24 == null){ return ""; } else {return this.bz24;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public String getDistcode(){ if ( this.distcode == null){ return ""; } else {return this.distcode;}}public String getWghkey(){ if ( this.wghkey == null){ return ""; } else {return this.wghkey;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setCorpkey( String corpkey){sqlMaker.setField("corpkey",corpkey,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCorpkey().equals(corpkey))
cf.add("corpkey",this.corpkey,corpkey);
}
this.corpkey=corpkey;
}
public void setDwmc( String dwmc){sqlMaker.setField("dwmc",dwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwmc().equals(dwmc))
cf.add("dwmc",this.dwmc,dwmc);
}
this.dwmc=dwmc;
}
public void setDwdz( String dwdz){sqlMaker.setField("dwdz",dwdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwdz().equals(dwdz))
cf.add("dwdz",this.dwdz,dwdz);
}
this.dwdz=dwdz;
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
public void setFddbr( String fddbr){sqlMaker.setField("fddbr",fddbr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFddbr().equals(fddbr))
cf.add("fddbr",this.fddbr,fddbr);
}
this.fddbr=fddbr;
}
public void setJdgldj( String jdgldj){sqlMaker.setField("jdgldj",jdgldj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJdgldj().equals(jdgldj))
cf.add("jdgldj",this.jdgldj,jdgldj);
}
this.jdgldj=jdgldj;
}
public void setWsgldj( String wsgldj){sqlMaker.setField("wsgldj",wsgldj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWsgldj().equals(wsgldj))
cf.add("wsgldj",this.wsgldj,wsgldj);
}
this.wsgldj=wsgldj;
}
public void setWhlb( String whlb){sqlMaker.setField("whlb",whlb,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhlb().equals(whlb))
cf.add("whlb",this.whlb,whlb);
}
this.whlb=whlb;
}
public void setJcrs( String jcrs){sqlMaker.setField("jcrs",jcrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcrs().equals(jcrs))
cf.add("jcrs",this.jcrs,jcrs);
}
this.jcrs=jcrs;
}
public void setWhysmc( String whysmc){sqlMaker.setField("whysmc",whysmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhysmc().equals(whysmc))
cf.add("whysmc",this.whysmc,whysmc);
}
this.whysmc=whysmc;
}
public void setWhys( String whys){sqlMaker.setField("whys",whys,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhys().equals(whys))
cf.add("whys",this.whys,whys);
}
this.whys=whys;
}
public void setDoc1( String doc1){sqlMaker.setField("doc1",doc1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc1().equals(doc1))
cf.add("doc1",this.doc1,doc1);
}
this.doc1=doc1;
}
public void setDoc2( String doc2){sqlMaker.setField("doc2",doc2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc2().equals(doc2))
cf.add("doc2",this.doc2,doc2);
}
this.doc2=doc2;
}
public void setDoc3( String doc3){sqlMaker.setField("doc3",doc3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc3().equals(doc3))
cf.add("doc3",this.doc3,doc3);
}
this.doc3=doc3;
}
public void setDoc4( String doc4){sqlMaker.setField("doc4",doc4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc4().equals(doc4))
cf.add("doc4",this.doc4,doc4);
}
this.doc4=doc4;
}
public void setDoc5( String doc5){sqlMaker.setField("doc5",doc5,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc5().equals(doc5))
cf.add("doc5",this.doc5,doc5);
}
this.doc5=doc5;
}
public void setDoc6( String doc6){sqlMaker.setField("doc6",doc6,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc6().equals(doc6))
cf.add("doc6",this.doc6,doc6);
}
this.doc6=doc6;
}
public void setDoc7( String doc7){sqlMaker.setField("doc7",doc7,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc7().equals(doc7))
cf.add("doc7",this.doc7,doc7);
}
this.doc7=doc7;
}
public void setDoc8( String doc8){sqlMaker.setField("doc8",doc8,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc8().equals(doc8))
cf.add("doc8",this.doc8,doc8);
}
this.doc8=doc8;
}
public void setDoc9( String doc9){sqlMaker.setField("doc9",doc9,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc9().equals(doc9))
cf.add("doc9",this.doc9,doc9);
}
this.doc9=doc9;
}
public void setDoc10( String doc10){sqlMaker.setField("doc10",doc10,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc10().equals(doc10))
cf.add("doc10",this.doc10,doc10);
}
this.doc10=doc10;
}
public void setDoc11( String doc11){sqlMaker.setField("doc11",doc11,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc11().equals(doc11))
cf.add("doc11",this.doc11,doc11);
}
this.doc11=doc11;
}
public void setDoc12( String doc12){sqlMaker.setField("doc12",doc12,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc12().equals(doc12))
cf.add("doc12",this.doc12,doc12);
}
this.doc12=doc12;
}
public void setDoc13( String doc13){sqlMaker.setField("doc13",doc13,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc13().equals(doc13))
cf.add("doc13",this.doc13,doc13);
}
this.doc13=doc13;
}
public void setDoc14( String doc14){sqlMaker.setField("doc14",doc14,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc14().equals(doc14))
cf.add("doc14",this.doc14,doc14);
}
this.doc14=doc14;
}
public void setDoc15( String doc15){sqlMaker.setField("doc15",doc15,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc15().equals(doc15))
cf.add("doc15",this.doc15,doc15);
}
this.doc15=doc15;
}
public void setDoc16( String doc16){sqlMaker.setField("doc16",doc16,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc16().equals(doc16))
cf.add("doc16",this.doc16,doc16);
}
this.doc16=doc16;
}
public void setDoc17( String doc17){sqlMaker.setField("doc17",doc17,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc17().equals(doc17))
cf.add("doc17",this.doc17,doc17);
}
this.doc17=doc17;
}
public void setDoc18( String doc18){sqlMaker.setField("doc18",doc18,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc18().equals(doc18))
cf.add("doc18",this.doc18,doc18);
}
this.doc18=doc18;
}
public void setDoc19( String doc19){sqlMaker.setField("doc19",doc19,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc19().equals(doc19))
cf.add("doc19",this.doc19,doc19);
}
this.doc19=doc19;
}
public void setDoc20( String doc20){sqlMaker.setField("doc20",doc20,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc20().equals(doc20))
cf.add("doc20",this.doc20,doc20);
}
this.doc20=doc20;
}
public void setDoc21( String doc21){sqlMaker.setField("doc21",doc21,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc21().equals(doc21))
cf.add("doc21",this.doc21,doc21);
}
this.doc21=doc21;
}
public void setDoc22( String doc22){sqlMaker.setField("doc22",doc22,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc22().equals(doc22))
cf.add("doc22",this.doc22,doc22);
}
this.doc22=doc22;
}
public void setDoc23( String doc23){sqlMaker.setField("doc23",doc23,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc23().equals(doc23))
cf.add("doc23",this.doc23,doc23);
}
this.doc23=doc23;
}
public void setDoc24( String doc24){sqlMaker.setField("doc24",doc24,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc24().equals(doc24))
cf.add("doc24",this.doc24,doc24);
}
this.doc24=doc24;
}
public void setDoc25( String doc25){sqlMaker.setField("doc25",doc25,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDoc25().equals(doc25))
cf.add("doc25",this.doc25,doc25);
}
this.doc25=doc25;
}
public void setPtr( String ptr){sqlMaker.setField("ptr",ptr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPtr().equals(ptr))
cf.add("ptr",this.ptr,ptr);
}
this.ptr=ptr;
}
public void setJdry1( String jdry1){sqlMaker.setField("jdry1",jdry1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJdry1().equals(jdry1))
cf.add("jdry1",this.jdry1,jdry1);
}
this.jdry1=jdry1;
}
public void setJdry2( String jdry2){sqlMaker.setField("jdry2",jdry2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJdry2().equals(jdry2))
cf.add("jdry2",this.jdry2,jdry2);
}
this.jdry2=jdry2;
}
public void setDate1( String date1){sqlMaker.setField("date1",date1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDate1().equals(date1))
cf.add("date1",this.date1,date1);
}
this.date1=date1;
}
public void setDate2( String date2){sqlMaker.setField("date2",date2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDate2().equals(date2))
cf.add("date2",this.date2,date2);
}
this.date2=date2;
}
public void setJdrybh1( String jdrybh1){sqlMaker.setField("jdrybh1",jdrybh1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJdrybh1().equals(jdrybh1))
cf.add("jdrybh1",this.jdrybh1,jdrybh1);
}
this.jdrybh1=jdrybh1;
}
public void setJdrybh2( String jdrybh2){sqlMaker.setField("jdrybh2",jdrybh2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJdrybh2().equals(jdrybh2))
cf.add("jdrybh2",this.jdrybh2,jdrybh2);
}
this.jdrybh2=jdrybh2;
}
public void setZongfen( String zongfen){sqlMaker.setField("zongfen",zongfen,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZongfen().equals(zongfen))
cf.add("zongfen",this.zongfen,zongfen);
}
this.zongfen=zongfen;
}
public void setNianfen( String nianfen){sqlMaker.setField("nianfen",nianfen,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNianfen().equals(nianfen))
cf.add("nianfen",this.nianfen,nianfen);
}
this.nianfen=nianfen;
}
public void setBz1( String bz1){sqlMaker.setField("bz1",bz1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz1().equals(bz1))
cf.add("bz1",this.bz1,bz1);
}
this.bz1=bz1;
}
public void setBz2( String bz2){sqlMaker.setField("bz2",bz2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz2().equals(bz2))
cf.add("bz2",this.bz2,bz2);
}
this.bz2=bz2;
}
public void setBz3( String bz3){sqlMaker.setField("bz3",bz3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz3().equals(bz3))
cf.add("bz3",this.bz3,bz3);
}
this.bz3=bz3;
}
public void setBz4( String bz4){sqlMaker.setField("bz4",bz4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz4().equals(bz4))
cf.add("bz4",this.bz4,bz4);
}
this.bz4=bz4;
}
public void setBz5( String bz5){sqlMaker.setField("bz5",bz5,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz5().equals(bz5))
cf.add("bz5",this.bz5,bz5);
}
this.bz5=bz5;
}
public void setBz6( String bz6){sqlMaker.setField("bz6",bz6,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz6().equals(bz6))
cf.add("bz6",this.bz6,bz6);
}
this.bz6=bz6;
}
public void setBz7( String bz7){sqlMaker.setField("bz7",bz7,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz7().equals(bz7))
cf.add("bz7",this.bz7,bz7);
}
this.bz7=bz7;
}
public void setBz8( String bz8){sqlMaker.setField("bz8",bz8,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz8().equals(bz8))
cf.add("bz8",this.bz8,bz8);
}
this.bz8=bz8;
}
public void setBz9( String bz9){sqlMaker.setField("bz9",bz9,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz9().equals(bz9))
cf.add("bz9",this.bz9,bz9);
}
this.bz9=bz9;
}
public void setBz10( String bz10){sqlMaker.setField("bz10",bz10,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz10().equals(bz10))
cf.add("bz10",this.bz10,bz10);
}
this.bz10=bz10;
}
public void setBz11( String bz11){sqlMaker.setField("bz11",bz11,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz11().equals(bz11))
cf.add("bz11",this.bz11,bz11);
}
this.bz11=bz11;
}
public void setBz12( String bz12){sqlMaker.setField("bz12",bz12,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz12().equals(bz12))
cf.add("bz12",this.bz12,bz12);
}
this.bz12=bz12;
}
public void setBz13( String bz13){sqlMaker.setField("bz13",bz13,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz13().equals(bz13))
cf.add("bz13",this.bz13,bz13);
}
this.bz13=bz13;
}
public void setBz14( String bz14){sqlMaker.setField("bz14",bz14,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz14().equals(bz14))
cf.add("bz14",this.bz14,bz14);
}
this.bz14=bz14;
}
public void setBz15( String bz15){sqlMaker.setField("bz15",bz15,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz15().equals(bz15))
cf.add("bz15",this.bz15,bz15);
}
this.bz15=bz15;
}
public void setBz16( String bz16){sqlMaker.setField("bz16",bz16,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz16().equals(bz16))
cf.add("bz16",this.bz16,bz16);
}
this.bz16=bz16;
}
public void setBz17( String bz17){sqlMaker.setField("bz17",bz17,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz17().equals(bz17))
cf.add("bz17",this.bz17,bz17);
}
this.bz17=bz17;
}
public void setBz18( String bz18){sqlMaker.setField("bz18",bz18,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz18().equals(bz18))
cf.add("bz18",this.bz18,bz18);
}
this.bz18=bz18;
}
public void setBz19( String bz19){sqlMaker.setField("bz19",bz19,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz19().equals(bz19))
cf.add("bz19",this.bz19,bz19);
}
this.bz19=bz19;
}
public void setBz20( String bz20){sqlMaker.setField("bz20",bz20,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz20().equals(bz20))
cf.add("bz20",this.bz20,bz20);
}
this.bz20=bz20;
}
public void setBz21( String bz21){sqlMaker.setField("bz21",bz21,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz21().equals(bz21))
cf.add("bz21",this.bz21,bz21);
}
this.bz21=bz21;
}
public void setBz22( String bz22){sqlMaker.setField("bz22",bz22,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz22().equals(bz22))
cf.add("bz22",this.bz22,bz22);
}
this.bz22=bz22;
}
public void setBz23( String bz23){sqlMaker.setField("bz23",bz23,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz23().equals(bz23))
cf.add("bz23",this.bz23,bz23);
}
this.bz23=bz23;
}
public void setBz24( String bz24){sqlMaker.setField("bz24",bz24,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz24().equals(bz24))
cf.add("bz24",this.bz24,bz24);
}
this.bz24=bz24;
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
public void setDistcode( String distcode){sqlMaker.setField("distcode",distcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDistcode().equals(distcode))
cf.add("distcode",this.distcode,distcode);
}
this.distcode=distcode;
}
public void setWghkey( String wghkey){sqlMaker.setField("wghkey",wghkey,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghkey().equals(wghkey))
cf.add("wghkey",this.wghkey,wghkey);
}
this.wghkey=wghkey;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "corpkey") != null) 
this.setCorpkey(actionRequest.getFieldValue(i, "corpkey"));
if (actionRequest.getFieldValue(i, "dwmc") != null) 
this.setDwmc(actionRequest.getFieldValue(i, "dwmc"));
if (actionRequest.getFieldValue(i, "dwdz") != null) 
this.setDwdz(actionRequest.getFieldValue(i, "dwdz"));
if (actionRequest.getFieldValue(i, "lxr") != null) 
this.setLxr(actionRequest.getFieldValue(i, "lxr"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "fddbr") != null) 
this.setFddbr(actionRequest.getFieldValue(i, "fddbr"));
if (actionRequest.getFieldValue(i, "jdgldj") != null) 
this.setJdgldj(actionRequest.getFieldValue(i, "jdgldj"));
if (actionRequest.getFieldValue(i, "wsgldj") != null) 
this.setWsgldj(actionRequest.getFieldValue(i, "wsgldj"));
if (actionRequest.getFieldValue(i, "whlb") != null) 
this.setWhlb(actionRequest.getFieldValue(i, "whlb"));
if (actionRequest.getFieldValue(i, "jcrs") != null) 
this.setJcrs(actionRequest.getFieldValue(i, "jcrs"));
if (actionRequest.getFieldValue(i, "whysmc") != null) 
this.setWhysmc(actionRequest.getFieldValue(i, "whysmc"));
if (actionRequest.getFieldValue(i, "whys") != null) 
this.setWhys(actionRequest.getFieldValue(i, "whys"));
if (actionRequest.getFieldValue(i, "doc1") != null) 
this.setDoc1(actionRequest.getFieldValue(i, "doc1"));
if (actionRequest.getFieldValue(i, "doc2") != null) 
this.setDoc2(actionRequest.getFieldValue(i, "doc2"));
if (actionRequest.getFieldValue(i, "doc3") != null) 
this.setDoc3(actionRequest.getFieldValue(i, "doc3"));
if (actionRequest.getFieldValue(i, "doc4") != null) 
this.setDoc4(actionRequest.getFieldValue(i, "doc4"));
if (actionRequest.getFieldValue(i, "doc5") != null) 
this.setDoc5(actionRequest.getFieldValue(i, "doc5"));
if (actionRequest.getFieldValue(i, "doc6") != null) 
this.setDoc6(actionRequest.getFieldValue(i, "doc6"));
if (actionRequest.getFieldValue(i, "doc7") != null) 
this.setDoc7(actionRequest.getFieldValue(i, "doc7"));
if (actionRequest.getFieldValue(i, "doc8") != null) 
this.setDoc8(actionRequest.getFieldValue(i, "doc8"));
if (actionRequest.getFieldValue(i, "doc9") != null) 
this.setDoc9(actionRequest.getFieldValue(i, "doc9"));
if (actionRequest.getFieldValue(i, "doc10") != null) 
this.setDoc10(actionRequest.getFieldValue(i, "doc10"));
if (actionRequest.getFieldValue(i, "doc11") != null) 
this.setDoc11(actionRequest.getFieldValue(i, "doc11"));
if (actionRequest.getFieldValue(i, "doc12") != null) 
this.setDoc12(actionRequest.getFieldValue(i, "doc12"));
if (actionRequest.getFieldValue(i, "doc13") != null) 
this.setDoc13(actionRequest.getFieldValue(i, "doc13"));
if (actionRequest.getFieldValue(i, "doc14") != null) 
this.setDoc14(actionRequest.getFieldValue(i, "doc14"));
if (actionRequest.getFieldValue(i, "doc15") != null) 
this.setDoc15(actionRequest.getFieldValue(i, "doc15"));
if (actionRequest.getFieldValue(i, "doc16") != null) 
this.setDoc16(actionRequest.getFieldValue(i, "doc16"));
if (actionRequest.getFieldValue(i, "doc17") != null) 
this.setDoc17(actionRequest.getFieldValue(i, "doc17"));
if (actionRequest.getFieldValue(i, "doc18") != null) 
this.setDoc18(actionRequest.getFieldValue(i, "doc18"));
if (actionRequest.getFieldValue(i, "doc19") != null) 
this.setDoc19(actionRequest.getFieldValue(i, "doc19"));
if (actionRequest.getFieldValue(i, "doc20") != null) 
this.setDoc20(actionRequest.getFieldValue(i, "doc20"));
if (actionRequest.getFieldValue(i, "doc21") != null) 
this.setDoc21(actionRequest.getFieldValue(i, "doc21"));
if (actionRequest.getFieldValue(i, "doc22") != null) 
this.setDoc22(actionRequest.getFieldValue(i, "doc22"));
if (actionRequest.getFieldValue(i, "doc23") != null) 
this.setDoc23(actionRequest.getFieldValue(i, "doc23"));
if (actionRequest.getFieldValue(i, "doc24") != null) 
this.setDoc24(actionRequest.getFieldValue(i, "doc24"));
if (actionRequest.getFieldValue(i, "doc25") != null) 
this.setDoc25(actionRequest.getFieldValue(i, "doc25"));
if (actionRequest.getFieldValue(i, "ptr") != null) 
this.setPtr(actionRequest.getFieldValue(i, "ptr"));
if (actionRequest.getFieldValue(i, "jdry1") != null) 
this.setJdry1(actionRequest.getFieldValue(i, "jdry1"));
if (actionRequest.getFieldValue(i, "jdry2") != null) 
this.setJdry2(actionRequest.getFieldValue(i, "jdry2"));
if (actionRequest.getFieldValue(i, "date1") != null) 
this.setDate1(actionRequest.getFieldValue(i, "date1"));
if (actionRequest.getFieldValue(i, "date2") != null) 
this.setDate2(actionRequest.getFieldValue(i, "date2"));
if (actionRequest.getFieldValue(i, "jdrybh1") != null) 
this.setJdrybh1(actionRequest.getFieldValue(i, "jdrybh1"));
if (actionRequest.getFieldValue(i, "jdrybh2") != null) 
this.setJdrybh2(actionRequest.getFieldValue(i, "jdrybh2"));
if (actionRequest.getFieldValue(i, "zongfen") != null) 
this.setZongfen(actionRequest.getFieldValue(i, "zongfen"));
if (actionRequest.getFieldValue(i, "nianfen") != null) 
this.setNianfen(actionRequest.getFieldValue(i, "nianfen"));
if (actionRequest.getFieldValue(i, "bz1") != null) 
this.setBz1(actionRequest.getFieldValue(i, "bz1"));
if (actionRequest.getFieldValue(i, "bz2") != null) 
this.setBz2(actionRequest.getFieldValue(i, "bz2"));
if (actionRequest.getFieldValue(i, "bz3") != null) 
this.setBz3(actionRequest.getFieldValue(i, "bz3"));
if (actionRequest.getFieldValue(i, "bz4") != null) 
this.setBz4(actionRequest.getFieldValue(i, "bz4"));
if (actionRequest.getFieldValue(i, "bz5") != null) 
this.setBz5(actionRequest.getFieldValue(i, "bz5"));
if (actionRequest.getFieldValue(i, "bz6") != null) 
this.setBz6(actionRequest.getFieldValue(i, "bz6"));
if (actionRequest.getFieldValue(i, "bz7") != null) 
this.setBz7(actionRequest.getFieldValue(i, "bz7"));
if (actionRequest.getFieldValue(i, "bz8") != null) 
this.setBz8(actionRequest.getFieldValue(i, "bz8"));
if (actionRequest.getFieldValue(i, "bz9") != null) 
this.setBz9(actionRequest.getFieldValue(i, "bz9"));
if (actionRequest.getFieldValue(i, "bz10") != null) 
this.setBz10(actionRequest.getFieldValue(i, "bz10"));
if (actionRequest.getFieldValue(i, "bz11") != null) 
this.setBz11(actionRequest.getFieldValue(i, "bz11"));
if (actionRequest.getFieldValue(i, "bz12") != null) 
this.setBz12(actionRequest.getFieldValue(i, "bz12"));
if (actionRequest.getFieldValue(i, "bz13") != null) 
this.setBz13(actionRequest.getFieldValue(i, "bz13"));
if (actionRequest.getFieldValue(i, "bz14") != null) 
this.setBz14(actionRequest.getFieldValue(i, "bz14"));
if (actionRequest.getFieldValue(i, "bz15") != null) 
this.setBz15(actionRequest.getFieldValue(i, "bz15"));
if (actionRequest.getFieldValue(i, "bz16") != null) 
this.setBz16(actionRequest.getFieldValue(i, "bz16"));
if (actionRequest.getFieldValue(i, "bz17") != null) 
this.setBz17(actionRequest.getFieldValue(i, "bz17"));
if (actionRequest.getFieldValue(i, "bz18") != null) 
this.setBz18(actionRequest.getFieldValue(i, "bz18"));
if (actionRequest.getFieldValue(i, "bz19") != null) 
this.setBz19(actionRequest.getFieldValue(i, "bz19"));
if (actionRequest.getFieldValue(i, "bz20") != null) 
this.setBz20(actionRequest.getFieldValue(i, "bz20"));
if (actionRequest.getFieldValue(i, "bz21") != null) 
this.setBz21(actionRequest.getFieldValue(i, "bz21"));
if (actionRequest.getFieldValue(i, "bz22") != null) 
this.setBz22(actionRequest.getFieldValue(i, "bz22"));
if (actionRequest.getFieldValue(i, "bz23") != null) 
this.setBz23(actionRequest.getFieldValue(i, "bz23"));
if (actionRequest.getFieldValue(i, "bz24") != null) 
this.setBz24(actionRequest.getFieldValue(i, "bz24"));
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
if (actionRequest.getFieldValue(i, "distcode") != null) 
this.setDistcode(actionRequest.getFieldValue(i, "distcode"));
if (actionRequest.getFieldValue(i, "wghkey") != null) 
this.setWghkey(actionRequest.getFieldValue(i, "wghkey"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { ZyjkflfjBean obj = (ZyjkflfjBean)super.clone();obj.setSysno(obj.sysno);
obj.setCorpkey(obj.corpkey);
obj.setDwmc(obj.dwmc);
obj.setDwdz(obj.dwdz);
obj.setLxr(obj.lxr);
obj.setLxdh(obj.lxdh);
obj.setFddbr(obj.fddbr);
obj.setJdgldj(obj.jdgldj);
obj.setWsgldj(obj.wsgldj);
obj.setWhlb(obj.whlb);
obj.setJcrs(obj.jcrs);
obj.setWhysmc(obj.whysmc);
obj.setWhys(obj.whys);
obj.setDoc1(obj.doc1);
obj.setDoc2(obj.doc2);
obj.setDoc3(obj.doc3);
obj.setDoc4(obj.doc4);
obj.setDoc5(obj.doc5);
obj.setDoc6(obj.doc6);
obj.setDoc7(obj.doc7);
obj.setDoc8(obj.doc8);
obj.setDoc9(obj.doc9);
obj.setDoc10(obj.doc10);
obj.setDoc11(obj.doc11);
obj.setDoc12(obj.doc12);
obj.setDoc13(obj.doc13);
obj.setDoc14(obj.doc14);
obj.setDoc15(obj.doc15);
obj.setDoc16(obj.doc16);
obj.setDoc17(obj.doc17);
obj.setDoc18(obj.doc18);
obj.setDoc19(obj.doc19);
obj.setDoc20(obj.doc20);
obj.setDoc21(obj.doc21);
obj.setDoc22(obj.doc22);
obj.setDoc23(obj.doc23);
obj.setDoc24(obj.doc24);
obj.setDoc25(obj.doc25);
obj.setPtr(obj.ptr);
obj.setJdry1(obj.jdry1);
obj.setJdry2(obj.jdry2);
obj.setDate1(obj.date1);
obj.setDate2(obj.date2);
obj.setJdrybh1(obj.jdrybh1);
obj.setJdrybh2(obj.jdrybh2);
obj.setZongfen(obj.zongfen);
obj.setNianfen(obj.nianfen);
obj.setBz1(obj.bz1);
obj.setBz2(obj.bz2);
obj.setBz3(obj.bz3);
obj.setBz4(obj.bz4);
obj.setBz5(obj.bz5);
obj.setBz6(obj.bz6);
obj.setBz7(obj.bz7);
obj.setBz8(obj.bz8);
obj.setBz9(obj.bz9);
obj.setBz10(obj.bz10);
obj.setBz11(obj.bz11);
obj.setBz12(obj.bz12);
obj.setBz13(obj.bz13);
obj.setBz14(obj.bz14);
obj.setBz15(obj.bz15);
obj.setBz16(obj.bz16);
obj.setBz17(obj.bz17);
obj.setBz18(obj.bz18);
obj.setBz19(obj.bz19);
obj.setBz20(obj.bz20);
obj.setBz21(obj.bz21);
obj.setBz22(obj.bz22);
obj.setBz23(obj.bz23);
obj.setBz24(obj.bz24);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
obj.setDistcode(obj.distcode);
obj.setWghkey(obj.wghkey);
return obj;}}