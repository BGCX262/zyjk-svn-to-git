package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class JcpjjyxxBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new JcpjjyxxBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new JcpjjyxxBean().findAndLockByWhere(sSqlWhere);      }       public static JcpjjyxxBean findFirst(String sSqlWhere)throws Exception {           return (JcpjjyxxBean)new JcpjjyxxBean().findFirstByWhere(sSqlWhere);      }       public static JcpjjyxxBean findFirstAndLock(String sSqlWhere)throws Exception {           return (JcpjjyxxBean)new JcpjjyxxBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new JcpjjyxxBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcpjjyxxBean bean = new JcpjjyxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcpjjyxxBean bean = new JcpjjyxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static JcpjjyxxBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcpjjyxxBean bean = new JcpjjyxxBean();           bean.setAutoRelease(isAutoRelease);           return (JcpjjyxxBean)bean.findFirstByWhere(sSqlWhere);      }       public static JcpjjyxxBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcpjjyxxBean bean = new JcpjjyxxBean();           bean.setAutoRelease(isAutoRelease);           return (JcpjjyxxBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcpjjyxxBean bean = new JcpjjyxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  bgbh;
String  dwbh;
String  dwmc;
String  jcdwbh;
String  jcdwmc;
String  zzgl;
String  gcjs;
String  gtfh;
String  wsbj;
String  yjjy;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="jcpjjyxx";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
JcpjjyxxBean abb = new JcpjjyxxBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.bgbh=rs.getString("bgbh");
abb.setKeyValue("BGBH","" + abb.getBgbh());
abb.dwbh=rs.getString("dwbh");
abb.setKeyValue("DWBH","" + abb.getDwbh());
abb.dwmc=rs.getString("dwmc");
abb.setKeyValue("DWMC","" + abb.getDwmc());
abb.jcdwbh=rs.getString("jcdwbh");
abb.setKeyValue("JCDWBH","" + abb.getJcdwbh());
abb.jcdwmc=rs.getString("jcdwmc");
abb.setKeyValue("JCDWMC","" + abb.getJcdwmc());
abb.zzgl=rs.getString("zzgl");
abb.setKeyValue("ZZGL","" + abb.getZzgl());
abb.gcjs=rs.getString("gcjs");
abb.setKeyValue("GCJS","" + abb.getGcjs());
abb.gtfh=rs.getString("gtfh");
abb.setKeyValue("GTFH","" + abb.getGtfh());
abb.wsbj=rs.getString("wsbj");
abb.setKeyValue("WSBJ","" + abb.getWsbj());
abb.yjjy=rs.getString("yjjy");
abb.setKeyValue("YJJY","" + abb.getYjjy());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getBgbh(){ if ( this.bgbh == null){ return ""; } else {return this.bgbh;}}public String getDwbh(){ if ( this.dwbh == null){ return ""; } else {return this.dwbh;}}public String getDwmc(){ if ( this.dwmc == null){ return ""; } else {return this.dwmc;}}public String getJcdwbh(){ if ( this.jcdwbh == null){ return ""; } else {return this.jcdwbh;}}public String getJcdwmc(){ if ( this.jcdwmc == null){ return ""; } else {return this.jcdwmc;}}public String getZzgl(){ if ( this.zzgl == null){ return ""; } else {return this.zzgl;}}public String getGcjs(){ if ( this.gcjs == null){ return ""; } else {return this.gcjs;}}public String getGtfh(){ if ( this.gtfh == null){ return ""; } else {return this.gtfh;}}public String getWsbj(){ if ( this.wsbj == null){ return ""; } else {return this.wsbj;}}public String getYjjy(){ if ( this.yjjy == null){ return ""; } else {return this.yjjy;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setDwbh( String dwbh){sqlMaker.setField("dwbh",dwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwbh().equals(dwbh))
cf.add("dwbh",this.dwbh,dwbh);
}
this.dwbh=dwbh;
}
public void setDwmc( String dwmc){sqlMaker.setField("dwmc",dwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwmc().equals(dwmc))
cf.add("dwmc",this.dwmc,dwmc);
}
this.dwmc=dwmc;
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
public void setZzgl( String zzgl){sqlMaker.setField("zzgl",zzgl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZzgl().equals(zzgl))
cf.add("zzgl",this.zzgl,zzgl);
}
this.zzgl=zzgl;
}
public void setGcjs( String gcjs){sqlMaker.setField("gcjs",gcjs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGcjs().equals(gcjs))
cf.add("gcjs",this.gcjs,gcjs);
}
this.gcjs=gcjs;
}
public void setGtfh( String gtfh){sqlMaker.setField("gtfh",gtfh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGtfh().equals(gtfh))
cf.add("gtfh",this.gtfh,gtfh);
}
this.gtfh=gtfh;
}
public void setWsbj( String wsbj){sqlMaker.setField("wsbj",wsbj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWsbj().equals(wsbj))
cf.add("wsbj",this.wsbj,wsbj);
}
this.wsbj=wsbj;
}
public void setYjjy( String yjjy){sqlMaker.setField("yjjy",yjjy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYjjy().equals(yjjy))
cf.add("yjjy",this.yjjy,yjjy);
}
this.yjjy=yjjy;
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
if (actionRequest.getFieldValue(i, "bgbh") != null) 
this.setBgbh(actionRequest.getFieldValue(i, "bgbh"));
if (actionRequest.getFieldValue(i, "dwbh") != null) 
this.setDwbh(actionRequest.getFieldValue(i, "dwbh"));
if (actionRequest.getFieldValue(i, "dwmc") != null) 
this.setDwmc(actionRequest.getFieldValue(i, "dwmc"));
if (actionRequest.getFieldValue(i, "jcdwbh") != null) 
this.setJcdwbh(actionRequest.getFieldValue(i, "jcdwbh"));
if (actionRequest.getFieldValue(i, "jcdwmc") != null) 
this.setJcdwmc(actionRequest.getFieldValue(i, "jcdwmc"));
if (actionRequest.getFieldValue(i, "zzgl") != null) 
this.setZzgl(actionRequest.getFieldValue(i, "zzgl"));
if (actionRequest.getFieldValue(i, "gcjs") != null) 
this.setGcjs(actionRequest.getFieldValue(i, "gcjs"));
if (actionRequest.getFieldValue(i, "gtfh") != null) 
this.setGtfh(actionRequest.getFieldValue(i, "gtfh"));
if (actionRequest.getFieldValue(i, "wsbj") != null) 
this.setWsbj(actionRequest.getFieldValue(i, "wsbj"));
if (actionRequest.getFieldValue(i, "yjjy") != null) 
this.setYjjy(actionRequest.getFieldValue(i, "yjjy"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { JcpjjyxxBean obj = (JcpjjyxxBean)super.clone();obj.setSysno(obj.sysno);
obj.setBgbh(obj.bgbh);
obj.setDwbh(obj.dwbh);
obj.setDwmc(obj.dwmc);
obj.setJcdwbh(obj.jcdwbh);
obj.setJcdwmc(obj.jcdwmc);
obj.setZzgl(obj.zzgl);
obj.setGcjs(obj.gcjs);
obj.setGtfh(obj.gtfh);
obj.setWsbj(obj.wsbj);
obj.setYjjy(obj.yjjy);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}