package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyldzzysBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyldzzysBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyldzzysBean().findAndLockByWhere(sSqlWhere);      }       public static QyldzzysBean findFirst(String sSqlWhere)throws Exception {           return (QyldzzysBean)new QyldzzysBean().findFirstByWhere(sSqlWhere);      }       public static QyldzzysBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyldzzysBean)new QyldzzysBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyldzzysBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyldzzysBean bean = new QyldzzysBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyldzzysBean bean = new QyldzzysBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyldzzysBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyldzzysBean bean = new QyldzzysBean();           bean.setAutoRelease(isAutoRelease);           return (QyldzzysBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyldzzysBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyldzzysBean bean = new QyldzzysBean();           bean.setAutoRelease(isAutoRelease);           return (QyldzzysBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyldzzysBean bean = new QyldzzysBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  ldzbh;
String  ldzxm;
String  enterno;
String  entername;
String  csgz;
String  gzgw;
String  kssj;
String  jssj;
String  whys;
String  whysmc;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qyldzzys";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyldzzysBean abb = new QyldzzysBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.ldzbh=rs.getString("ldzbh");
abb.setKeyValue("LDZBH","" + abb.getLdzbh());
abb.ldzxm=rs.getString("ldzxm");
abb.setKeyValue("LDZXM","" + abb.getLdzxm());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.entername=rs.getString("entername");
abb.setKeyValue("ENTERNAME","" + abb.getEntername());
abb.csgz=rs.getString("csgz");
abb.setKeyValue("CSGZ","" + abb.getCsgz());
abb.gzgw=rs.getString("gzgw");
abb.setKeyValue("GZGW","" + abb.getGzgw());
abb.kssj=rs.getString("kssj");
abb.setKeyValue("KSSJ","" + abb.getKssj());
abb.jssj=rs.getString("jssj");
abb.setKeyValue("JSSJ","" + abb.getJssj());
abb.whys=rs.getString("whys");
abb.setKeyValue("WHYS","" + abb.getWhys());
abb.whysmc=rs.getString("whysmc");
abb.setKeyValue("WHYSMC","" + abb.getWhysmc());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getLdzbh(){ if ( this.ldzbh == null){ return ""; } else {return this.ldzbh;}}public String getLdzxm(){ if ( this.ldzxm == null){ return ""; } else {return this.ldzxm;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getEntername(){ if ( this.entername == null){ return ""; } else {return this.entername;}}public String getCsgz(){ if ( this.csgz == null){ return ""; } else {return this.csgz;}}public String getGzgw(){ if ( this.gzgw == null){ return ""; } else {return this.gzgw;}}public String getKssj(){ if ( this.kssj == null){ return ""; } else {return this.kssj;}}public String getJssj(){ if ( this.jssj == null){ return ""; } else {return this.jssj;}}public String getWhys(){ if ( this.whys == null){ return ""; } else {return this.whys;}}public String getWhysmc(){ if ( this.whysmc == null){ return ""; } else {return this.whysmc;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setCsgz( String csgz){sqlMaker.setField("csgz",csgz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCsgz().equals(csgz))
cf.add("csgz",this.csgz,csgz);
}
this.csgz=csgz;
}
public void setGzgw( String gzgw){sqlMaker.setField("gzgw",gzgw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGzgw().equals(gzgw))
cf.add("gzgw",this.gzgw,gzgw);
}
this.gzgw=gzgw;
}
public void setKssj( String kssj){sqlMaker.setField("kssj",kssj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getKssj().equals(kssj))
cf.add("kssj",this.kssj,kssj);
}
this.kssj=kssj;
}
public void setJssj( String jssj){sqlMaker.setField("jssj",jssj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJssj().equals(jssj))
cf.add("jssj",this.jssj,jssj);
}
this.jssj=jssj;
}
public void setWhys( String whys){sqlMaker.setField("whys",whys,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhys().equals(whys))
cf.add("whys",this.whys,whys);
}
this.whys=whys;
}
public void setWhysmc( String whysmc){sqlMaker.setField("whysmc",whysmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhysmc().equals(whysmc))
cf.add("whysmc",this.whysmc,whysmc);
}
this.whysmc=whysmc;
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
if (actionRequest.getFieldValue(i, "enterno") != null) 
this.setEnterno(actionRequest.getFieldValue(i, "enterno"));
if (actionRequest.getFieldValue(i, "entername") != null) 
this.setEntername(actionRequest.getFieldValue(i, "entername"));
if (actionRequest.getFieldValue(i, "csgz") != null) 
this.setCsgz(actionRequest.getFieldValue(i, "csgz"));
if (actionRequest.getFieldValue(i, "gzgw") != null) 
this.setGzgw(actionRequest.getFieldValue(i, "gzgw"));
if (actionRequest.getFieldValue(i, "kssj") != null) 
this.setKssj(actionRequest.getFieldValue(i, "kssj"));
if (actionRequest.getFieldValue(i, "jssj") != null) 
this.setJssj(actionRequest.getFieldValue(i, "jssj"));
if (actionRequest.getFieldValue(i, "whys") != null) 
this.setWhys(actionRequest.getFieldValue(i, "whys"));
if (actionRequest.getFieldValue(i, "whysmc") != null) 
this.setWhysmc(actionRequest.getFieldValue(i, "whysmc"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyldzzysBean obj = (QyldzzysBean)super.clone();obj.setSysno(obj.sysno);
obj.setLdzbh(obj.ldzbh);
obj.setLdzxm(obj.ldzxm);
obj.setEnterno(obj.enterno);
obj.setEntername(obj.entername);
obj.setCsgz(obj.csgz);
obj.setGzgw(obj.gzgw);
obj.setKssj(obj.kssj);
obj.setJssj(obj.jssj);
obj.setWhys(obj.whys);
obj.setWhysmc(obj.whysmc);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}