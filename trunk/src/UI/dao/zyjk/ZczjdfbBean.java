package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class ZczjdfbBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new ZczjdfbBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new ZczjdfbBean().findAndLockByWhere(sSqlWhere);      }       public static ZczjdfbBean findFirst(String sSqlWhere)throws Exception {           return (ZczjdfbBean)new ZczjdfbBean().findFirstByWhere(sSqlWhere);      }       public static ZczjdfbBean findFirstAndLock(String sSqlWhere)throws Exception {           return (ZczjdfbBean)new ZczjdfbBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new ZczjdfbBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZczjdfbBean bean = new ZczjdfbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           ZczjdfbBean bean = new ZczjdfbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static ZczjdfbBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZczjdfbBean bean = new ZczjdfbBean();           bean.setAutoRelease(isAutoRelease);           return (ZczjdfbBean)bean.findFirstByWhere(sSqlWhere);      }       public static ZczjdfbBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           ZczjdfbBean bean = new ZczjdfbBean();           bean.setAutoRelease(isAutoRelease);           return (ZczjdfbBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZczjdfbBean bean = new ZczjdfbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  zbsysno;
String  zlsysno;
String  xmsysno;
String  nrsysno;
String  ffsysno;
String  fs;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
String  jdhc;
String  zgrq;
String  hcyj;
String  bak6;
String  bak7;
String  bak8;
String  bak9;
String  bak10;
String  zghc;
String  zcjl;
public static final String TABLENAME ="zczjdfb";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
ZczjdfbBean abb = new ZczjdfbBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.zbsysno=rs.getString("zbsysno");
abb.setKeyValue("ZBSYSNO","" + abb.getZbsysno());
abb.zlsysno=rs.getString("zlsysno");
abb.setKeyValue("ZLSYSNO","" + abb.getZlsysno());
abb.xmsysno=rs.getString("xmsysno");
abb.setKeyValue("XMSYSNO","" + abb.getXmsysno());
abb.nrsysno=rs.getString("nrsysno");
abb.setKeyValue("NRSYSNO","" + abb.getNrsysno());
abb.ffsysno=rs.getString("ffsysno");
abb.setKeyValue("FFSYSNO","" + abb.getFfsysno());
abb.fs=rs.getString("fs");
abb.setKeyValue("FS","" + abb.getFs());
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
abb.jdhc=rs.getString("jdhc");
abb.setKeyValue("JDHC","" + abb.getJdhc());
abb.zgrq=rs.getString("zgrq");
abb.setKeyValue("ZGRQ","" + abb.getZgrq());
abb.hcyj=rs.getString("hcyj");
abb.setKeyValue("HCYJ","" + abb.getHcyj());
abb.bak6=rs.getString("bak6");
abb.setKeyValue("BAK6","" + abb.getBak6());
abb.bak7=rs.getString("bak7");
abb.setKeyValue("BAK7","" + abb.getBak7());
abb.bak8=rs.getString("bak8");
abb.setKeyValue("BAK8","" + abb.getBak8());
abb.bak9=rs.getString("bak9");
abb.setKeyValue("BAK9","" + abb.getBak9());
abb.bak10=rs.getString("bak10");
abb.setKeyValue("BAK10","" + abb.getBak10());
abb.zghc=rs.getString("zghc");
abb.setKeyValue("ZGHC","" + abb.getZghc());
abb.zcjl=rs.getString("zcjl");
abb.setKeyValue("ZCJL","" + abb.getZcjl());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getZbsysno(){ if ( this.zbsysno == null){ return ""; } else {return this.zbsysno;}}public String getZlsysno(){ if ( this.zlsysno == null){ return ""; } else {return this.zlsysno;}}public String getXmsysno(){ if ( this.xmsysno == null){ return ""; } else {return this.xmsysno;}}public String getNrsysno(){ if ( this.nrsysno == null){ return ""; } else {return this.nrsysno;}}public String getFfsysno(){ if ( this.ffsysno == null){ return ""; } else {return this.ffsysno;}}public String getFs(){ if ( this.fs == null){ return ""; } else {return this.fs;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public String getJdhc(){ if ( this.jdhc == null){ return ""; } else {return this.jdhc;}}public String getZgrq(){ if ( this.zgrq == null){ return ""; } else {return this.zgrq;}}public String getHcyj(){ if ( this.hcyj == null){ return ""; } else {return this.hcyj;}}public String getBak6(){ if ( this.bak6 == null){ return ""; } else {return this.bak6;}}public String getBak7(){ if ( this.bak7 == null){ return ""; } else {return this.bak7;}}public String getBak8(){ if ( this.bak8 == null){ return ""; } else {return this.bak8;}}public String getBak9(){ if ( this.bak9 == null){ return ""; } else {return this.bak9;}}public String getBak10(){ if ( this.bak10 == null){ return ""; } else {return this.bak10;}}public String getZghc(){ if ( this.zghc == null){ return ""; } else {return this.zghc;}}public String getZcjl(){ if ( this.zcjl == null){ return ""; } else {return this.zcjl;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setZbsysno( String zbsysno){sqlMaker.setField("zbsysno",zbsysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZbsysno().equals(zbsysno))
cf.add("zbsysno",this.zbsysno,zbsysno);
}
this.zbsysno=zbsysno;
}
public void setZlsysno( String zlsysno){sqlMaker.setField("zlsysno",zlsysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZlsysno().equals(zlsysno))
cf.add("zlsysno",this.zlsysno,zlsysno);
}
this.zlsysno=zlsysno;
}
public void setXmsysno( String xmsysno){sqlMaker.setField("xmsysno",xmsysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXmsysno().equals(xmsysno))
cf.add("xmsysno",this.xmsysno,xmsysno);
}
this.xmsysno=xmsysno;
}
public void setNrsysno( String nrsysno){sqlMaker.setField("nrsysno",nrsysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNrsysno().equals(nrsysno))
cf.add("nrsysno",this.nrsysno,nrsysno);
}
this.nrsysno=nrsysno;
}
public void setFfsysno( String ffsysno){sqlMaker.setField("ffsysno",ffsysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFfsysno().equals(ffsysno))
cf.add("ffsysno",this.ffsysno,ffsysno);
}
this.ffsysno=ffsysno;
}
public void setFs( String fs){sqlMaker.setField("fs",fs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFs().equals(fs))
cf.add("fs",this.fs,fs);
}
this.fs=fs;
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
public void setJdhc( String jdhc){sqlMaker.setField("jdhc",jdhc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJdhc().equals(jdhc))
cf.add("jdhc",this.jdhc,jdhc);
}
this.jdhc=jdhc;
}
public void setZgrq( String zgrq){sqlMaker.setField("zgrq",zgrq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZgrq().equals(zgrq))
cf.add("zgrq",this.zgrq,zgrq);
}
this.zgrq=zgrq;
}
public void setHcyj( String hcyj){sqlMaker.setField("hcyj",hcyj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHcyj().equals(hcyj))
cf.add("hcyj",this.hcyj,hcyj);
}
this.hcyj=hcyj;
}
public void setBak6( String bak6){sqlMaker.setField("bak6",bak6,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak6().equals(bak6))
cf.add("bak6",this.bak6,bak6);
}
this.bak6=bak6;
}
public void setBak7( String bak7){sqlMaker.setField("bak7",bak7,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak7().equals(bak7))
cf.add("bak7",this.bak7,bak7);
}
this.bak7=bak7;
}
public void setBak8( String bak8){sqlMaker.setField("bak8",bak8,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak8().equals(bak8))
cf.add("bak8",this.bak8,bak8);
}
this.bak8=bak8;
}
public void setBak9( String bak9){sqlMaker.setField("bak9",bak9,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak9().equals(bak9))
cf.add("bak9",this.bak9,bak9);
}
this.bak9=bak9;
}
public void setBak10( String bak10){sqlMaker.setField("bak10",bak10,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak10().equals(bak10))
cf.add("bak10",this.bak10,bak10);
}
this.bak10=bak10;
}
public void setZghc( String zghc){sqlMaker.setField("zghc",zghc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZghc().equals(zghc))
cf.add("zghc",this.zghc,zghc);
}
this.zghc=zghc;
}
public void setZcjl( String zcjl){sqlMaker.setField("zcjl",zcjl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZcjl().equals(zcjl))
cf.add("zcjl",this.zcjl,zcjl);
}
this.zcjl=zcjl;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "zbsysno") != null) 
this.setZbsysno(actionRequest.getFieldValue(i, "zbsysno"));
if (actionRequest.getFieldValue(i, "zlsysno") != null) 
this.setZlsysno(actionRequest.getFieldValue(i, "zlsysno"));
if (actionRequest.getFieldValue(i, "xmsysno") != null) 
this.setXmsysno(actionRequest.getFieldValue(i, "xmsysno"));
if (actionRequest.getFieldValue(i, "nrsysno") != null) 
this.setNrsysno(actionRequest.getFieldValue(i, "nrsysno"));
if (actionRequest.getFieldValue(i, "ffsysno") != null) 
this.setFfsysno(actionRequest.getFieldValue(i, "ffsysno"));
if (actionRequest.getFieldValue(i, "fs") != null) 
this.setFs(actionRequest.getFieldValue(i, "fs"));
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
if (actionRequest.getFieldValue(i, "jdhc") != null) 
this.setJdhc(actionRequest.getFieldValue(i, "jdhc"));
if (actionRequest.getFieldValue(i, "zgrq") != null) 
this.setZgrq(actionRequest.getFieldValue(i, "zgrq"));
if (actionRequest.getFieldValue(i, "hcyj") != null) 
this.setHcyj(actionRequest.getFieldValue(i, "hcyj"));
if (actionRequest.getFieldValue(i, "bak6") != null) 
this.setBak6(actionRequest.getFieldValue(i, "bak6"));
if (actionRequest.getFieldValue(i, "bak7") != null) 
this.setBak7(actionRequest.getFieldValue(i, "bak7"));
if (actionRequest.getFieldValue(i, "bak8") != null) 
this.setBak8(actionRequest.getFieldValue(i, "bak8"));
if (actionRequest.getFieldValue(i, "bak9") != null) 
this.setBak9(actionRequest.getFieldValue(i, "bak9"));
if (actionRequest.getFieldValue(i, "bak10") != null) 
this.setBak10(actionRequest.getFieldValue(i, "bak10"));
if (actionRequest.getFieldValue(i, "zghc") != null) 
this.setZghc(actionRequest.getFieldValue(i, "zghc"));
if (actionRequest.getFieldValue(i, "zcjl") != null) 
this.setZcjl(actionRequest.getFieldValue(i, "zcjl"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { ZczjdfbBean obj = (ZczjdfbBean)super.clone();obj.setSysno(obj.sysno);
obj.setZbsysno(obj.zbsysno);
obj.setZlsysno(obj.zlsysno);
obj.setXmsysno(obj.xmsysno);
obj.setNrsysno(obj.nrsysno);
obj.setFfsysno(obj.ffsysno);
obj.setFs(obj.fs);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
obj.setJdhc(obj.jdhc);
obj.setZgrq(obj.zgrq);
obj.setHcyj(obj.hcyj);
obj.setBak6(obj.bak6);
obj.setBak7(obj.bak7);
obj.setBak8(obj.bak8);
obj.setBak9(obj.bak9);
obj.setBak10(obj.bak10);
obj.setZghc(obj.zghc);
obj.setZcjl(obj.zcjl);
return obj;}}