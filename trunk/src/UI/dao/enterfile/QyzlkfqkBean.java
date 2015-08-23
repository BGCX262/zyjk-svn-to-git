package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyzlkfqkBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyzlkfqkBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyzlkfqkBean().findAndLockByWhere(sSqlWhere);      }       public static QyzlkfqkBean findFirst(String sSqlWhere)throws Exception {           return (QyzlkfqkBean)new QyzlkfqkBean().findFirstByWhere(sSqlWhere);      }       public static QyzlkfqkBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyzlkfqkBean)new QyzlkfqkBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyzlkfqkBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzlkfqkBean bean = new QyzlkfqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzlkfqkBean bean = new QyzlkfqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyzlkfqkBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzlkfqkBean bean = new QyzlkfqkBean();           bean.setAutoRelease(isAutoRelease);           return (QyzlkfqkBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyzlkfqkBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzlkfqkBean bean = new QyzlkfqkBean();           bean.setAutoRelease(isAutoRelease);           return (QyzlkfqkBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzlkfqkBean bean = new QyzlkfqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  ldzbh;
String  ldzxm;
String  sj;
String  zl;
String  kf;
String  zldwbh;
String  zldwmc;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qyzlkfqk";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyzlkfqkBean abb = new QyzlkfqkBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.ldzbh=rs.getString("ldzbh");
abb.setKeyValue("LDZBH","" + abb.getLdzbh());
abb.ldzxm=rs.getString("ldzxm");
abb.setKeyValue("LDZXM","" + abb.getLdzxm());
abb.sj=rs.getString("sj");
abb.setKeyValue("SJ","" + abb.getSj());
abb.zl=rs.getString("zl");
abb.setKeyValue("ZL","" + abb.getZl());
abb.kf=rs.getString("kf");
abb.setKeyValue("KF","" + abb.getKf());
abb.zldwbh=rs.getString("zldwbh");
abb.setKeyValue("ZLDWBH","" + abb.getZldwbh());
abb.zldwmc=rs.getString("zldwmc");
abb.setKeyValue("ZLDWMC","" + abb.getZldwmc());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getLdzbh(){ if ( this.ldzbh == null){ return ""; } else {return this.ldzbh;}}public String getLdzxm(){ if ( this.ldzxm == null){ return ""; } else {return this.ldzxm;}}public String getSj(){ if ( this.sj == null){ return ""; } else {return this.sj;}}public String getZl(){ if ( this.zl == null){ return ""; } else {return this.zl;}}public String getKf(){ if ( this.kf == null){ return ""; } else {return this.kf;}}public String getZldwbh(){ if ( this.zldwbh == null){ return ""; } else {return this.zldwbh;}}public String getZldwmc(){ if ( this.zldwmc == null){ return ""; } else {return this.zldwmc;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setSj( String sj){sqlMaker.setField("sj",sj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSj().equals(sj))
cf.add("sj",this.sj,sj);
}
this.sj=sj;
}
public void setZl( String zl){sqlMaker.setField("zl",zl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZl().equals(zl))
cf.add("zl",this.zl,zl);
}
this.zl=zl;
}
public void setKf( String kf){sqlMaker.setField("kf",kf,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getKf().equals(kf))
cf.add("kf",this.kf,kf);
}
this.kf=kf;
}
public void setZldwbh( String zldwbh){sqlMaker.setField("zldwbh",zldwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZldwbh().equals(zldwbh))
cf.add("zldwbh",this.zldwbh,zldwbh);
}
this.zldwbh=zldwbh;
}
public void setZldwmc( String zldwmc){sqlMaker.setField("zldwmc",zldwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZldwmc().equals(zldwmc))
cf.add("zldwmc",this.zldwmc,zldwmc);
}
this.zldwmc=zldwmc;
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
if (actionRequest.getFieldValue(i, "sj") != null) 
this.setSj(actionRequest.getFieldValue(i, "sj"));
if (actionRequest.getFieldValue(i, "zl") != null) 
this.setZl(actionRequest.getFieldValue(i, "zl"));
if (actionRequest.getFieldValue(i, "kf") != null) 
this.setKf(actionRequest.getFieldValue(i, "kf"));
if (actionRequest.getFieldValue(i, "zldwbh") != null) 
this.setZldwbh(actionRequest.getFieldValue(i, "zldwbh"));
if (actionRequest.getFieldValue(i, "zldwmc") != null) 
this.setZldwmc(actionRequest.getFieldValue(i, "zldwmc"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyzlkfqkBean obj = (QyzlkfqkBean)super.clone();obj.setSysno(obj.sysno);
obj.setLdzbh(obj.ldzbh);
obj.setLdzxm(obj.ldzxm);
obj.setSj(obj.sj);
obj.setZl(obj.zl);
obj.setKf(obj.kf);
obj.setZldwbh(obj.zldwbh);
obj.setZldwmc(obj.zldwmc);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}