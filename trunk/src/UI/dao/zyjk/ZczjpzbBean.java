package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class ZczjpzbBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new ZczjpzbBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new ZczjpzbBean().findAndLockByWhere(sSqlWhere);      }       public static ZczjpzbBean findFirst(String sSqlWhere)throws Exception {           return (ZczjpzbBean)new ZczjpzbBean().findFirstByWhere(sSqlWhere);      }       public static ZczjpzbBean findFirstAndLock(String sSqlWhere)throws Exception {           return (ZczjpzbBean)new ZczjpzbBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new ZczjpzbBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZczjpzbBean bean = new ZczjpzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           ZczjpzbBean bean = new ZczjpzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static ZczjpzbBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZczjpzbBean bean = new ZczjpzbBean();           bean.setAutoRelease(isAutoRelease);           return (ZczjpzbBean)bean.findFirstByWhere(sSqlWhere);      }       public static ZczjpzbBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           ZczjpzbBean bean = new ZczjpzbBean();           bean.setAutoRelease(isAutoRelease);           return (ZczjpzbBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZczjpzbBean bean = new ZczjpzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  xmsysno;
String  rnsysno;
String  ffsysn;
String  pd;
String  ppbz;
String  distcode;
String  version;
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
public static final String TABLENAME ="zczjpzb";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
ZczjpzbBean abb = new ZczjpzbBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.xmsysno=rs.getString("xmsysno");
abb.setKeyValue("XMSYSNO","" + abb.getXmsysno());
abb.rnsysno=rs.getString("rnsysno");
abb.setKeyValue("RNSYSNO","" + abb.getRnsysno());
abb.ffsysn=rs.getString("ffsysn");
abb.setKeyValue("FFSYSN","" + abb.getFfsysn());
abb.pd=rs.getString("pd");
abb.setKeyValue("PD","" + abb.getPd());
abb.ppbz=rs.getString("ppbz");
abb.setKeyValue("PPBZ","" + abb.getPpbz());
abb.distcode=rs.getString("distcode");
abb.setKeyValue("DISTCODE","" + abb.getDistcode());
abb.version=rs.getString("version");
abb.setKeyValue("VERSION","" + abb.getVersion());
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
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getXmsysno(){ if ( this.xmsysno == null){ return ""; } else {return this.xmsysno;}}public String getRnsysno(){ if ( this.rnsysno == null){ return ""; } else {return this.rnsysno;}}public String getFfsysn(){ if ( this.ffsysn == null){ return ""; } else {return this.ffsysn;}}public String getPd(){ if ( this.pd == null){ return ""; } else {return this.pd;}}public String getPpbz(){ if ( this.ppbz == null){ return ""; } else {return this.ppbz;}}public String getDistcode(){ if ( this.distcode == null){ return ""; } else {return this.distcode;}}public String getVersion(){ if ( this.version == null){ return ""; } else {return this.version;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public String getBak6(){ if ( this.bak6 == null){ return ""; } else {return this.bak6;}}public String getBak7(){ if ( this.bak7 == null){ return ""; } else {return this.bak7;}}public String getBak8(){ if ( this.bak8 == null){ return ""; } else {return this.bak8;}}public String getBak9(){ if ( this.bak9 == null){ return ""; } else {return this.bak9;}}public String getBak10(){ if ( this.bak10 == null){ return ""; } else {return this.bak10;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setXmsysno( String xmsysno){sqlMaker.setField("xmsysno",xmsysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXmsysno().equals(xmsysno))
cf.add("xmsysno",this.xmsysno,xmsysno);
}
this.xmsysno=xmsysno;
}
public void setRnsysno( String rnsysno){sqlMaker.setField("rnsysno",rnsysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRnsysno().equals(rnsysno))
cf.add("rnsysno",this.rnsysno,rnsysno);
}
this.rnsysno=rnsysno;
}
public void setFfsysn( String ffsysn){sqlMaker.setField("ffsysn",ffsysn,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFfsysn().equals(ffsysn))
cf.add("ffsysn",this.ffsysn,ffsysn);
}
this.ffsysn=ffsysn;
}
public void setPd( String pd){sqlMaker.setField("pd",pd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPd().equals(pd))
cf.add("pd",this.pd,pd);
}
this.pd=pd;
}
public void setPpbz( String ppbz){sqlMaker.setField("ppbz",ppbz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPpbz().equals(ppbz))
cf.add("ppbz",this.ppbz,ppbz);
}
this.ppbz=ppbz;
}
public void setDistcode( String distcode){sqlMaker.setField("distcode",distcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDistcode().equals(distcode))
cf.add("distcode",this.distcode,distcode);
}
this.distcode=distcode;
}
public void setVersion( String version){sqlMaker.setField("version",version,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getVersion().equals(version))
cf.add("version",this.version,version);
}
this.version=version;
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
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "xmsysno") != null) 
this.setXmsysno(actionRequest.getFieldValue(i, "xmsysno"));
if (actionRequest.getFieldValue(i, "rnsysno") != null) 
this.setRnsysno(actionRequest.getFieldValue(i, "rnsysno"));
if (actionRequest.getFieldValue(i, "ffsysn") != null) 
this.setFfsysn(actionRequest.getFieldValue(i, "ffsysn"));
if (actionRequest.getFieldValue(i, "pd") != null) 
this.setPd(actionRequest.getFieldValue(i, "pd"));
if (actionRequest.getFieldValue(i, "ppbz") != null) 
this.setPpbz(actionRequest.getFieldValue(i, "ppbz"));
if (actionRequest.getFieldValue(i, "distcode") != null) 
this.setDistcode(actionRequest.getFieldValue(i, "distcode"));
if (actionRequest.getFieldValue(i, "version") != null) 
this.setVersion(actionRequest.getFieldValue(i, "version"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { ZczjpzbBean obj = (ZczjpzbBean)super.clone();obj.setSysno(obj.sysno);
obj.setXmsysno(obj.xmsysno);
obj.setRnsysno(obj.rnsysno);
obj.setFfsysn(obj.ffsysn);
obj.setPd(obj.pd);
obj.setPpbz(obj.ppbz);
obj.setDistcode(obj.distcode);
obj.setVersion(obj.version);
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
return obj;}}