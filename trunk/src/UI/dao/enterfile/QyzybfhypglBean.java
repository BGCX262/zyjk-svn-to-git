package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyzybfhypglBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyzybfhypglBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyzybfhypglBean().findAndLockByWhere(sSqlWhere);      }       public static QyzybfhypglBean findFirst(String sSqlWhere)throws Exception {           return (QyzybfhypglBean)new QyzybfhypglBean().findFirstByWhere(sSqlWhere);      }       public static QyzybfhypglBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyzybfhypglBean)new QyzybfhypglBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyzybfhypglBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybfhypglBean bean = new QyzybfhypglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzybfhypglBean bean = new QyzybfhypglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyzybfhypglBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybfhypglBean bean = new QyzybfhypglBean();           bean.setAutoRelease(isAutoRelease);           return (QyzybfhypglBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyzybfhypglBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzybfhypglBean bean = new QyzybfhypglBean();           bean.setAutoRelease(isAutoRelease);           return (QyzybfhypglBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybfhypglBean bean = new QyzybfhypglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  enterno;
String  entername;
String  xh;
String  fhypmc;
String  ggxh;
String  fffw;
String  syqx;
String  sl;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
String  buydate;
String  seller;
public static final String TABLENAME ="qyzybfhypgl";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyzybfhypglBean abb = new QyzybfhypglBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.entername=rs.getString("entername");
abb.setKeyValue("ENTERNAME","" + abb.getEntername());
abb.xh=rs.getString("xh");
abb.setKeyValue("XH","" + abb.getXh());
abb.fhypmc=rs.getString("fhypmc");
abb.setKeyValue("FHYPMC","" + abb.getFhypmc());
abb.ggxh=rs.getString("ggxh");
abb.setKeyValue("GGXH","" + abb.getGgxh());
abb.fffw=rs.getString("fffw");
abb.setKeyValue("FFFW","" + abb.getFffw());
abb.syqx=rs.getString("syqx");
abb.setKeyValue("SYQX","" + abb.getSyqx());
abb.sl=rs.getString("sl");
abb.setKeyValue("SL","" + abb.getSl());
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
abb.buydate=rs.getString("buydate");
abb.setKeyValue("BUYDATE","" + abb.getBuydate());
abb.seller=rs.getString("seller");
abb.setKeyValue("SELLER","" + abb.getSeller());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getEntername(){ if ( this.entername == null){ return ""; } else {return this.entername;}}public String getXh(){ if ( this.xh == null){ return ""; } else {return this.xh;}}public String getFhypmc(){ if ( this.fhypmc == null){ return ""; } else {return this.fhypmc;}}public String getGgxh(){ if ( this.ggxh == null){ return ""; } else {return this.ggxh;}}public String getFffw(){ if ( this.fffw == null){ return ""; } else {return this.fffw;}}public String getSyqx(){ if ( this.syqx == null){ return ""; } else {return this.syqx;}}public String getSl(){ if ( this.sl == null){ return ""; } else {return this.sl;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public String getBuydate(){ if ( this.buydate == null){ return ""; } else {return this.buydate;}}public String getSeller(){ if ( this.seller == null){ return ""; } else {return this.seller;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setXh( String xh){sqlMaker.setField("xh",xh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXh().equals(xh))
cf.add("xh",this.xh,xh);
}
this.xh=xh;
}
public void setFhypmc( String fhypmc){sqlMaker.setField("fhypmc",fhypmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFhypmc().equals(fhypmc))
cf.add("fhypmc",this.fhypmc,fhypmc);
}
this.fhypmc=fhypmc;
}
public void setGgxh( String ggxh){sqlMaker.setField("ggxh",ggxh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGgxh().equals(ggxh))
cf.add("ggxh",this.ggxh,ggxh);
}
this.ggxh=ggxh;
}
public void setFffw( String fffw){sqlMaker.setField("fffw",fffw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFffw().equals(fffw))
cf.add("fffw",this.fffw,fffw);
}
this.fffw=fffw;
}
public void setSyqx( String syqx){sqlMaker.setField("syqx",syqx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSyqx().equals(syqx))
cf.add("syqx",this.syqx,syqx);
}
this.syqx=syqx;
}
public void setSl( String sl){sqlMaker.setField("sl",sl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSl().equals(sl))
cf.add("sl",this.sl,sl);
}
this.sl=sl;
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
public void setBuydate( String buydate){sqlMaker.setField("buydate",buydate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBuydate().equals(buydate))
cf.add("buydate",this.buydate,buydate);
}
this.buydate=buydate;
}
public void setSeller( String seller){sqlMaker.setField("seller",seller,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSeller().equals(seller))
cf.add("seller",this.seller,seller);
}
this.seller=seller;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "enterno") != null) 
this.setEnterno(actionRequest.getFieldValue(i, "enterno"));
if (actionRequest.getFieldValue(i, "entername") != null) 
this.setEntername(actionRequest.getFieldValue(i, "entername"));
if (actionRequest.getFieldValue(i, "xh") != null) 
this.setXh(actionRequest.getFieldValue(i, "xh"));
if (actionRequest.getFieldValue(i, "fhypmc") != null) 
this.setFhypmc(actionRequest.getFieldValue(i, "fhypmc"));
if (actionRequest.getFieldValue(i, "ggxh") != null) 
this.setGgxh(actionRequest.getFieldValue(i, "ggxh"));
if (actionRequest.getFieldValue(i, "fffw") != null) 
this.setFffw(actionRequest.getFieldValue(i, "fffw"));
if (actionRequest.getFieldValue(i, "syqx") != null) 
this.setSyqx(actionRequest.getFieldValue(i, "syqx"));
if (actionRequest.getFieldValue(i, "sl") != null) 
this.setSl(actionRequest.getFieldValue(i, "sl"));
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
if (actionRequest.getFieldValue(i, "buydate") != null) 
this.setBuydate(actionRequest.getFieldValue(i, "buydate"));
if (actionRequest.getFieldValue(i, "seller") != null) 
this.setSeller(actionRequest.getFieldValue(i, "seller"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyzybfhypglBean obj = (QyzybfhypglBean)super.clone();obj.setSysno(obj.sysno);
obj.setEnterno(obj.enterno);
obj.setEntername(obj.entername);
obj.setXh(obj.xh);
obj.setFhypmc(obj.fhypmc);
obj.setGgxh(obj.ggxh);
obj.setFffw(obj.fffw);
obj.setSyqx(obj.syqx);
obj.setSl(obj.sl);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
obj.setBuydate(obj.buydate);
obj.setSeller(obj.seller);
return obj;}}