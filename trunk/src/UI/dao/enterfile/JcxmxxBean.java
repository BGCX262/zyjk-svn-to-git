package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class JcxmxxBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new JcxmxxBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new JcxmxxBean().findAndLockByWhere(sSqlWhere);      }       public static JcxmxxBean findFirst(String sSqlWhere)throws Exception {           return (JcxmxxBean)new JcxmxxBean().findFirstByWhere(sSqlWhere);      }       public static JcxmxxBean findFirstAndLock(String sSqlWhere)throws Exception {           return (JcxmxxBean)new JcxmxxBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new JcxmxxBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcxmxxBean bean = new JcxmxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcxmxxBean bean = new JcxmxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static JcxmxxBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcxmxxBean bean = new JcxmxxBean();           bean.setAutoRelease(isAutoRelease);           return (JcxmxxBean)bean.findFirstByWhere(sSqlWhere);      }       public static JcxmxxBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcxmxxBean bean = new JcxmxxBean();           bean.setAutoRelease(isAutoRelease);           return (JcxmxxBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcxmxxBean bean = new JcxmxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  xmmc;
String  jsdwbh;
String  jsdwmc;
String  jcdwbh;
String  jcdwmc;
String  distcode;
String  jsxmdz;
String  jsxmxz;
String  jsxmgm;
String  jsxmqk;
String  sfwc;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
String  bak6;
String  bak7;
String  bak8;
String  bak9;
String  bak10;
String  pxdwmc;
String  pxdwbh;
public static final String TABLENAME ="jcxmxx";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
JcxmxxBean abb = new JcxmxxBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.xmmc=rs.getString("xmmc");
abb.setKeyValue("XMMC","" + abb.getXmmc());
abb.jsdwbh=rs.getString("jsdwbh");
abb.setKeyValue("JSDWBH","" + abb.getJsdwbh());
abb.jsdwmc=rs.getString("jsdwmc");
abb.setKeyValue("JSDWMC","" + abb.getJsdwmc());
abb.jcdwbh=rs.getString("jcdwbh");
abb.setKeyValue("JCDWBH","" + abb.getJcdwbh());
abb.jcdwmc=rs.getString("jcdwmc");
abb.setKeyValue("JCDWMC","" + abb.getJcdwmc());
abb.distcode=rs.getString("distcode");
abb.setKeyValue("DISTCODE","" + abb.getDistcode());
abb.jsxmdz=rs.getString("jsxmdz");
abb.setKeyValue("JSXMDZ","" + abb.getJsxmdz());
abb.jsxmxz=rs.getString("jsxmxz");
abb.setKeyValue("JSXMXZ","" + abb.getJsxmxz());
abb.jsxmgm=rs.getString("jsxmgm");
abb.setKeyValue("JSXMGM","" + abb.getJsxmgm());
abb.jsxmqk=rs.getString("jsxmqk");
abb.setKeyValue("JSXMQK","" + abb.getJsxmqk());
abb.sfwc=rs.getString("sfwc");
abb.setKeyValue("SFWC","" + abb.getSfwc());
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
abb.pxdwmc=rs.getString("pxdwmc");
abb.setKeyValue("PXDWMC","" + abb.getPxdwmc());
abb.pxdwbh=rs.getString("pxdwbh");
abb.setKeyValue("PXDWBH","" + abb.getPxdwbh());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getXmmc(){ if ( this.xmmc == null){ return ""; } else {return this.xmmc;}}public String getJsdwbh(){ if ( this.jsdwbh == null){ return ""; } else {return this.jsdwbh;}}public String getJsdwmc(){ if ( this.jsdwmc == null){ return ""; } else {return this.jsdwmc;}}public String getJcdwbh(){ if ( this.jcdwbh == null){ return ""; } else {return this.jcdwbh;}}public String getJcdwmc(){ if ( this.jcdwmc == null){ return ""; } else {return this.jcdwmc;}}public String getDistcode(){ if ( this.distcode == null){ return ""; } else {return this.distcode;}}public String getJsxmdz(){ if ( this.jsxmdz == null){ return ""; } else {return this.jsxmdz;}}public String getJsxmxz(){ if ( this.jsxmxz == null){ return ""; } else {return this.jsxmxz;}}public String getJsxmgm(){ if ( this.jsxmgm == null){ return ""; } else {return this.jsxmgm;}}public String getJsxmqk(){ if ( this.jsxmqk == null){ return ""; } else {return this.jsxmqk;}}public String getSfwc(){ if ( this.sfwc == null){ return ""; } else {return this.sfwc;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public String getBak6(){ if ( this.bak6 == null){ return ""; } else {return this.bak6;}}public String getBak7(){ if ( this.bak7 == null){ return ""; } else {return this.bak7;}}public String getBak8(){ if ( this.bak8 == null){ return ""; } else {return this.bak8;}}public String getBak9(){ if ( this.bak9 == null){ return ""; } else {return this.bak9;}}public String getBak10(){ if ( this.bak10 == null){ return ""; } else {return this.bak10;}}public String getPxdwmc(){ if ( this.pxdwmc == null){ return ""; } else {return this.pxdwmc;}}public String getPxdwbh(){ if ( this.pxdwbh == null){ return ""; } else {return this.pxdwbh;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setXmmc( String xmmc){sqlMaker.setField("xmmc",xmmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXmmc().equals(xmmc))
cf.add("xmmc",this.xmmc,xmmc);
}
this.xmmc=xmmc;
}
public void setJsdwbh( String jsdwbh){sqlMaker.setField("jsdwbh",jsdwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJsdwbh().equals(jsdwbh))
cf.add("jsdwbh",this.jsdwbh,jsdwbh);
}
this.jsdwbh=jsdwbh;
}
public void setJsdwmc( String jsdwmc){sqlMaker.setField("jsdwmc",jsdwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJsdwmc().equals(jsdwmc))
cf.add("jsdwmc",this.jsdwmc,jsdwmc);
}
this.jsdwmc=jsdwmc;
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
public void setDistcode( String distcode){sqlMaker.setField("distcode",distcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDistcode().equals(distcode))
cf.add("distcode",this.distcode,distcode);
}
this.distcode=distcode;
}
public void setJsxmdz( String jsxmdz){sqlMaker.setField("jsxmdz",jsxmdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJsxmdz().equals(jsxmdz))
cf.add("jsxmdz",this.jsxmdz,jsxmdz);
}
this.jsxmdz=jsxmdz;
}
public void setJsxmxz( String jsxmxz){sqlMaker.setField("jsxmxz",jsxmxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJsxmxz().equals(jsxmxz))
cf.add("jsxmxz",this.jsxmxz,jsxmxz);
}
this.jsxmxz=jsxmxz;
}
public void setJsxmgm( String jsxmgm){sqlMaker.setField("jsxmgm",jsxmgm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJsxmgm().equals(jsxmgm))
cf.add("jsxmgm",this.jsxmgm,jsxmgm);
}
this.jsxmgm=jsxmgm;
}
public void setJsxmqk( String jsxmqk){sqlMaker.setField("jsxmqk",jsxmqk,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJsxmqk().equals(jsxmqk))
cf.add("jsxmqk",this.jsxmqk,jsxmqk);
}
this.jsxmqk=jsxmqk;
}
public void setSfwc( String sfwc){sqlMaker.setField("sfwc",sfwc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfwc().equals(sfwc))
cf.add("sfwc",this.sfwc,sfwc);
}
this.sfwc=sfwc;
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
public void setPxdwmc( String pxdwmc){sqlMaker.setField("pxdwmc",pxdwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxdwmc().equals(pxdwmc))
cf.add("pxdwmc",this.pxdwmc,pxdwmc);
}
this.pxdwmc=pxdwmc;
}
public void setPxdwbh( String pxdwbh){sqlMaker.setField("pxdwbh",pxdwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxdwbh().equals(pxdwbh))
cf.add("pxdwbh",this.pxdwbh,pxdwbh);
}
this.pxdwbh=pxdwbh;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "xmmc") != null) 
this.setXmmc(actionRequest.getFieldValue(i, "xmmc"));
if (actionRequest.getFieldValue(i, "jsdwbh") != null) 
this.setJsdwbh(actionRequest.getFieldValue(i, "jsdwbh"));
if (actionRequest.getFieldValue(i, "jsdwmc") != null) 
this.setJsdwmc(actionRequest.getFieldValue(i, "jsdwmc"));
if (actionRequest.getFieldValue(i, "jcdwbh") != null) 
this.setJcdwbh(actionRequest.getFieldValue(i, "jcdwbh"));
if (actionRequest.getFieldValue(i, "jcdwmc") != null) 
this.setJcdwmc(actionRequest.getFieldValue(i, "jcdwmc"));
if (actionRequest.getFieldValue(i, "distcode") != null) 
this.setDistcode(actionRequest.getFieldValue(i, "distcode"));
if (actionRequest.getFieldValue(i, "jsxmdz") != null) 
this.setJsxmdz(actionRequest.getFieldValue(i, "jsxmdz"));
if (actionRequest.getFieldValue(i, "jsxmxz") != null) 
this.setJsxmxz(actionRequest.getFieldValue(i, "jsxmxz"));
if (actionRequest.getFieldValue(i, "jsxmgm") != null) 
this.setJsxmgm(actionRequest.getFieldValue(i, "jsxmgm"));
if (actionRequest.getFieldValue(i, "jsxmqk") != null) 
this.setJsxmqk(actionRequest.getFieldValue(i, "jsxmqk"));
if (actionRequest.getFieldValue(i, "sfwc") != null) 
this.setSfwc(actionRequest.getFieldValue(i, "sfwc"));
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
if (actionRequest.getFieldValue(i, "pxdwmc") != null) 
this.setPxdwmc(actionRequest.getFieldValue(i, "pxdwmc"));
if (actionRequest.getFieldValue(i, "pxdwbh") != null) 
this.setPxdwbh(actionRequest.getFieldValue(i, "pxdwbh"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { JcxmxxBean obj = (JcxmxxBean)super.clone();obj.setSysno(obj.sysno);
obj.setXmmc(obj.xmmc);
obj.setJsdwbh(obj.jsdwbh);
obj.setJsdwmc(obj.jsdwmc);
obj.setJcdwbh(obj.jcdwbh);
obj.setJcdwmc(obj.jcdwmc);
obj.setDistcode(obj.distcode);
obj.setJsxmdz(obj.jsxmdz);
obj.setJsxmxz(obj.jsxmxz);
obj.setJsxmgm(obj.jsxmgm);
obj.setJsxmqk(obj.jsxmqk);
obj.setSfwc(obj.sfwc);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
obj.setBak6(obj.bak6);
obj.setBak7(obj.bak7);
obj.setBak8(obj.bak8);
obj.setBak9(obj.bak9);
obj.setBak10(obj.bak10);
obj.setPxdwmc(obj.pxdwmc);
obj.setPxdwbh(obj.pxdwbh);
return obj;}}