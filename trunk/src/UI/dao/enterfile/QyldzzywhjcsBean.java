package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyldzzywhjcsBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyldzzywhjcsBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyldzzywhjcsBean().findAndLockByWhere(sSqlWhere);      }       public static QyldzzywhjcsBean findFirst(String sSqlWhere)throws Exception {           return (QyldzzywhjcsBean)new QyldzzywhjcsBean().findFirstByWhere(sSqlWhere);      }       public static QyldzzywhjcsBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyldzzywhjcsBean)new QyldzzywhjcsBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyldzzywhjcsBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyldzzywhjcsBean bean = new QyldzzywhjcsBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyldzzywhjcsBean bean = new QyldzzywhjcsBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyldzzywhjcsBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyldzzywhjcsBean bean = new QyldzzywhjcsBean();           bean.setAutoRelease(isAutoRelease);           return (QyldzzywhjcsBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyldzzywhjcsBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyldzzywhjcsBean bean = new QyldzzywhjcsBean();           bean.setAutoRelease(isAutoRelease);           return (QyldzzywhjcsBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyldzzywhjcsBean bean = new QyldzzywhjcsBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  ldzbh;
String  ldzxm;
String  zygz;
String  gzgw;
String  jcsj;
String  whys1;
String  whysmc1;
String  twa1;
String  whys2;
String  whysmc2;
String  twa2;
String  whys3;
String  whysmc3;
String  twa3;
String  whys4;
String  whysmc4;
String  twa4;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qyldzzywhjcs";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyldzzywhjcsBean abb = new QyldzzywhjcsBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.ldzbh=rs.getString("ldzbh");
abb.setKeyValue("LDZBH","" + abb.getLdzbh());
abb.ldzxm=rs.getString("ldzxm");
abb.setKeyValue("LDZXM","" + abb.getLdzxm());
abb.zygz=rs.getString("zygz");
abb.setKeyValue("ZYGZ","" + abb.getZygz());
abb.gzgw=rs.getString("gzgw");
abb.setKeyValue("GZGW","" + abb.getGzgw());
abb.jcsj=rs.getString("jcsj");
abb.setKeyValue("JCSJ","" + abb.getJcsj());
abb.whys1=rs.getString("whys1");
abb.setKeyValue("WHYS1","" + abb.getWhys1());
abb.whysmc1=rs.getString("whysmc1");
abb.setKeyValue("WHYSMC1","" + abb.getWhysmc1());
abb.twa1=rs.getString("twa1");
abb.setKeyValue("TWA1","" + abb.getTwa1());
abb.whys2=rs.getString("whys2");
abb.setKeyValue("WHYS2","" + abb.getWhys2());
abb.whysmc2=rs.getString("whysmc2");
abb.setKeyValue("WHYSMC2","" + abb.getWhysmc2());
abb.twa2=rs.getString("twa2");
abb.setKeyValue("TWA2","" + abb.getTwa2());
abb.whys3=rs.getString("whys3");
abb.setKeyValue("WHYS3","" + abb.getWhys3());
abb.whysmc3=rs.getString("whysmc3");
abb.setKeyValue("WHYSMC3","" + abb.getWhysmc3());
abb.twa3=rs.getString("twa3");
abb.setKeyValue("TWA3","" + abb.getTwa3());
abb.whys4=rs.getString("whys4");
abb.setKeyValue("WHYS4","" + abb.getWhys4());
abb.whysmc4=rs.getString("whysmc4");
abb.setKeyValue("WHYSMC4","" + abb.getWhysmc4());
abb.twa4=rs.getString("twa4");
abb.setKeyValue("TWA4","" + abb.getTwa4());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getLdzbh(){ if ( this.ldzbh == null){ return ""; } else {return this.ldzbh;}}public String getLdzxm(){ if ( this.ldzxm == null){ return ""; } else {return this.ldzxm;}}public String getZygz(){ if ( this.zygz == null){ return ""; } else {return this.zygz;}}public String getGzgw(){ if ( this.gzgw == null){ return ""; } else {return this.gzgw;}}public String getJcsj(){ if ( this.jcsj == null){ return ""; } else {return this.jcsj;}}public String getWhys1(){ if ( this.whys1 == null){ return ""; } else {return this.whys1;}}public String getWhysmc1(){ if ( this.whysmc1 == null){ return ""; } else {return this.whysmc1;}}public String getTwa1(){ if ( this.twa1 == null){ return ""; } else {return this.twa1;}}public String getWhys2(){ if ( this.whys2 == null){ return ""; } else {return this.whys2;}}public String getWhysmc2(){ if ( this.whysmc2 == null){ return ""; } else {return this.whysmc2;}}public String getTwa2(){ if ( this.twa2 == null){ return ""; } else {return this.twa2;}}public String getWhys3(){ if ( this.whys3 == null){ return ""; } else {return this.whys3;}}public String getWhysmc3(){ if ( this.whysmc3 == null){ return ""; } else {return this.whysmc3;}}public String getTwa3(){ if ( this.twa3 == null){ return ""; } else {return this.twa3;}}public String getWhys4(){ if ( this.whys4 == null){ return ""; } else {return this.whys4;}}public String getWhysmc4(){ if ( this.whysmc4 == null){ return ""; } else {return this.whysmc4;}}public String getTwa4(){ if ( this.twa4 == null){ return ""; } else {return this.twa4;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setZygz( String zygz){sqlMaker.setField("zygz",zygz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZygz().equals(zygz))
cf.add("zygz",this.zygz,zygz);
}
this.zygz=zygz;
}
public void setGzgw( String gzgw){sqlMaker.setField("gzgw",gzgw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGzgw().equals(gzgw))
cf.add("gzgw",this.gzgw,gzgw);
}
this.gzgw=gzgw;
}
public void setJcsj( String jcsj){sqlMaker.setField("jcsj",jcsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcsj().equals(jcsj))
cf.add("jcsj",this.jcsj,jcsj);
}
this.jcsj=jcsj;
}
public void setWhys1( String whys1){sqlMaker.setField("whys1",whys1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhys1().equals(whys1))
cf.add("whys1",this.whys1,whys1);
}
this.whys1=whys1;
}
public void setWhysmc1( String whysmc1){sqlMaker.setField("whysmc1",whysmc1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhysmc1().equals(whysmc1))
cf.add("whysmc1",this.whysmc1,whysmc1);
}
this.whysmc1=whysmc1;
}
public void setTwa1( String twa1){sqlMaker.setField("twa1",twa1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTwa1().equals(twa1))
cf.add("twa1",this.twa1,twa1);
}
this.twa1=twa1;
}
public void setWhys2( String whys2){sqlMaker.setField("whys2",whys2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhys2().equals(whys2))
cf.add("whys2",this.whys2,whys2);
}
this.whys2=whys2;
}
public void setWhysmc2( String whysmc2){sqlMaker.setField("whysmc2",whysmc2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhysmc2().equals(whysmc2))
cf.add("whysmc2",this.whysmc2,whysmc2);
}
this.whysmc2=whysmc2;
}
public void setTwa2( String twa2){sqlMaker.setField("twa2",twa2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTwa2().equals(twa2))
cf.add("twa2",this.twa2,twa2);
}
this.twa2=twa2;
}
public void setWhys3( String whys3){sqlMaker.setField("whys3",whys3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhys3().equals(whys3))
cf.add("whys3",this.whys3,whys3);
}
this.whys3=whys3;
}
public void setWhysmc3( String whysmc3){sqlMaker.setField("whysmc3",whysmc3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhysmc3().equals(whysmc3))
cf.add("whysmc3",this.whysmc3,whysmc3);
}
this.whysmc3=whysmc3;
}
public void setTwa3( String twa3){sqlMaker.setField("twa3",twa3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTwa3().equals(twa3))
cf.add("twa3",this.twa3,twa3);
}
this.twa3=twa3;
}
public void setWhys4( String whys4){sqlMaker.setField("whys4",whys4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhys4().equals(whys4))
cf.add("whys4",this.whys4,whys4);
}
this.whys4=whys4;
}
public void setWhysmc4( String whysmc4){sqlMaker.setField("whysmc4",whysmc4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhysmc4().equals(whysmc4))
cf.add("whysmc4",this.whysmc4,whysmc4);
}
this.whysmc4=whysmc4;
}
public void setTwa4( String twa4){sqlMaker.setField("twa4",twa4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTwa4().equals(twa4))
cf.add("twa4",this.twa4,twa4);
}
this.twa4=twa4;
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
if (actionRequest.getFieldValue(i, "zygz") != null) 
this.setZygz(actionRequest.getFieldValue(i, "zygz"));
if (actionRequest.getFieldValue(i, "gzgw") != null) 
this.setGzgw(actionRequest.getFieldValue(i, "gzgw"));
if (actionRequest.getFieldValue(i, "jcsj") != null) 
this.setJcsj(actionRequest.getFieldValue(i, "jcsj"));
if (actionRequest.getFieldValue(i, "whys1") != null) 
this.setWhys1(actionRequest.getFieldValue(i, "whys1"));
if (actionRequest.getFieldValue(i, "whysmc1") != null) 
this.setWhysmc1(actionRequest.getFieldValue(i, "whysmc1"));
if (actionRequest.getFieldValue(i, "twa1") != null) 
this.setTwa1(actionRequest.getFieldValue(i, "twa1"));
if (actionRequest.getFieldValue(i, "whys2") != null) 
this.setWhys2(actionRequest.getFieldValue(i, "whys2"));
if (actionRequest.getFieldValue(i, "whysmc2") != null) 
this.setWhysmc2(actionRequest.getFieldValue(i, "whysmc2"));
if (actionRequest.getFieldValue(i, "twa2") != null) 
this.setTwa2(actionRequest.getFieldValue(i, "twa2"));
if (actionRequest.getFieldValue(i, "whys3") != null) 
this.setWhys3(actionRequest.getFieldValue(i, "whys3"));
if (actionRequest.getFieldValue(i, "whysmc3") != null) 
this.setWhysmc3(actionRequest.getFieldValue(i, "whysmc3"));
if (actionRequest.getFieldValue(i, "twa3") != null) 
this.setTwa3(actionRequest.getFieldValue(i, "twa3"));
if (actionRequest.getFieldValue(i, "whys4") != null) 
this.setWhys4(actionRequest.getFieldValue(i, "whys4"));
if (actionRequest.getFieldValue(i, "whysmc4") != null) 
this.setWhysmc4(actionRequest.getFieldValue(i, "whysmc4"));
if (actionRequest.getFieldValue(i, "twa4") != null) 
this.setTwa4(actionRequest.getFieldValue(i, "twa4"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyldzzywhjcsBean obj = (QyldzzywhjcsBean)super.clone();obj.setSysno(obj.sysno);
obj.setLdzbh(obj.ldzbh);
obj.setLdzxm(obj.ldzxm);
obj.setZygz(obj.zygz);
obj.setGzgw(obj.gzgw);
obj.setJcsj(obj.jcsj);
obj.setWhys1(obj.whys1);
obj.setWhysmc1(obj.whysmc1);
obj.setTwa1(obj.twa1);
obj.setWhys2(obj.whys2);
obj.setWhysmc2(obj.whysmc2);
obj.setTwa2(obj.twa2);
obj.setWhys3(obj.whys3);
obj.setWhysmc3(obj.whysmc3);
obj.setTwa3(obj.twa3);
obj.setWhys4(obj.whys4);
obj.setWhysmc4(obj.whysmc4);
obj.setTwa4(obj.twa4);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}