package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyfhypffglBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyfhypffglBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyfhypffglBean().findAndLockByWhere(sSqlWhere);      }       public static QyfhypffglBean findFirst(String sSqlWhere)throws Exception {           return (QyfhypffglBean)new QyfhypffglBean().findFirstByWhere(sSqlWhere);      }       public static QyfhypffglBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyfhypffglBean)new QyfhypffglBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyfhypffglBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyfhypffglBean bean = new QyfhypffglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyfhypffglBean bean = new QyfhypffglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyfhypffglBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyfhypffglBean bean = new QyfhypffglBean();           bean.setAutoRelease(isAutoRelease);           return (QyfhypffglBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyfhypffglBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyfhypffglBean bean = new QyfhypffglBean();           bean.setAutoRelease(isAutoRelease);           return (QyfhypffglBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyfhypffglBean bean = new QyfhypffglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  enterno;
String  entername;
String  ypbh;
String  ypmc;
String  cjbh;
String  cjmc;
String  gz;
String  gzdd;
String  ghzq;
String  bz;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qyfhypffgl";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyfhypffglBean abb = new QyfhypffglBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.entername=rs.getString("entername");
abb.setKeyValue("ENTERNAME","" + abb.getEntername());
abb.ypbh=rs.getString("ypbh");
abb.setKeyValue("YPBH","" + abb.getYpbh());
abb.ypmc=rs.getString("ypmc");
abb.setKeyValue("YPMC","" + abb.getYpmc());
abb.cjbh=rs.getString("cjbh");
abb.setKeyValue("CJBH","" + abb.getCjbh());
abb.cjmc=rs.getString("cjmc");
abb.setKeyValue("CJMC","" + abb.getCjmc());
abb.gz=rs.getString("gz");
abb.setKeyValue("GZ","" + abb.getGz());
abb.gzdd=rs.getString("gzdd");
abb.setKeyValue("GZDD","" + abb.getGzdd());
abb.ghzq=rs.getString("ghzq");
abb.setKeyValue("GHZQ","" + abb.getGhzq());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getEntername(){ if ( this.entername == null){ return ""; } else {return this.entername;}}public String getYpbh(){ if ( this.ypbh == null){ return ""; } else {return this.ypbh;}}public String getYpmc(){ if ( this.ypmc == null){ return ""; } else {return this.ypmc;}}public String getCjbh(){ if ( this.cjbh == null){ return ""; } else {return this.cjbh;}}public String getCjmc(){ if ( this.cjmc == null){ return ""; } else {return this.cjmc;}}public String getGz(){ if ( this.gz == null){ return ""; } else {return this.gz;}}public String getGzdd(){ if ( this.gzdd == null){ return ""; } else {return this.gzdd;}}public String getGhzq(){ if ( this.ghzq == null){ return ""; } else {return this.ghzq;}}public String getBz(){ if ( this.bz == null){ return ""; } else {return this.bz;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setEntername( String entername){sqlMaker.setField("entername",entername,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEntername().equals(entername))
cf.add("entername",this.entername,entername);
}
this.entername=entername;
}
public void setYpbh( String ypbh){sqlMaker.setField("ypbh",ypbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYpbh().equals(ypbh))
cf.add("ypbh",this.ypbh,ypbh);
}
this.ypbh=ypbh;
}
public void setYpmc( String ypmc){sqlMaker.setField("ypmc",ypmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYpmc().equals(ypmc))
cf.add("ypmc",this.ypmc,ypmc);
}
this.ypmc=ypmc;
}
public void setCjbh( String cjbh){sqlMaker.setField("cjbh",cjbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCjbh().equals(cjbh))
cf.add("cjbh",this.cjbh,cjbh);
}
this.cjbh=cjbh;
}
public void setCjmc( String cjmc){sqlMaker.setField("cjmc",cjmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCjmc().equals(cjmc))
cf.add("cjmc",this.cjmc,cjmc);
}
this.cjmc=cjmc;
}
public void setGz( String gz){sqlMaker.setField("gz",gz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGz().equals(gz))
cf.add("gz",this.gz,gz);
}
this.gz=gz;
}
public void setGzdd( String gzdd){sqlMaker.setField("gzdd",gzdd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGzdd().equals(gzdd))
cf.add("gzdd",this.gzdd,gzdd);
}
this.gzdd=gzdd;
}
public void setGhzq( String ghzq){sqlMaker.setField("ghzq",ghzq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGhzq().equals(ghzq))
cf.add("ghzq",this.ghzq,ghzq);
}
this.ghzq=ghzq;
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
if (actionRequest.getFieldValue(i, "enterno") != null) 
this.setEnterno(actionRequest.getFieldValue(i, "enterno"));
if (actionRequest.getFieldValue(i, "entername") != null) 
this.setEntername(actionRequest.getFieldValue(i, "entername"));
if (actionRequest.getFieldValue(i, "ypbh") != null) 
this.setYpbh(actionRequest.getFieldValue(i, "ypbh"));
if (actionRequest.getFieldValue(i, "ypmc") != null) 
this.setYpmc(actionRequest.getFieldValue(i, "ypmc"));
if (actionRequest.getFieldValue(i, "cjbh") != null) 
this.setCjbh(actionRequest.getFieldValue(i, "cjbh"));
if (actionRequest.getFieldValue(i, "cjmc") != null) 
this.setCjmc(actionRequest.getFieldValue(i, "cjmc"));
if (actionRequest.getFieldValue(i, "gz") != null) 
this.setGz(actionRequest.getFieldValue(i, "gz"));
if (actionRequest.getFieldValue(i, "gzdd") != null) 
this.setGzdd(actionRequest.getFieldValue(i, "gzdd"));
if (actionRequest.getFieldValue(i, "ghzq") != null) 
this.setGhzq(actionRequest.getFieldValue(i, "ghzq"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyfhypffglBean obj = (QyfhypffglBean)super.clone();obj.setSysno(obj.sysno);
obj.setEnterno(obj.enterno);
obj.setEntername(obj.entername);
obj.setYpbh(obj.ypbh);
obj.setYpmc(obj.ypmc);
obj.setCjbh(obj.cjbh);
obj.setCjmc(obj.cjmc);
obj.setGz(obj.gz);
obj.setGzdd(obj.gzdd);
obj.setGhzq(obj.ghzq);
obj.setBz(obj.bz);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}