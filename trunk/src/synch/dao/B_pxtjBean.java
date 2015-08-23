package synch.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class B_pxtjBean extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) throws Exception{           return new B_pxtjBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new B_pxtjBean().findAndLockByWhere(sSqlWhere);      }       public static B_pxtjBean findFirst(String sSqlWhere)throws Exception {           return (B_pxtjBean)new B_pxtjBean().findFirstByWhere(sSqlWhere);      }       public static B_pxtjBean findFirstAndLock(String sSqlWhere)throws Exception {           return (B_pxtjBean)new B_pxtjBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new B_pxtjBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_pxtjBean bean = new B_pxtjBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           B_pxtjBean bean = new B_pxtjBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static B_pxtjBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_pxtjBean bean = new B_pxtjBean();           bean.setAutoRelease(isAutoRelease);           return (B_pxtjBean)bean.findFirstByWhere(sSqlWhere);      }       public static B_pxtjBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           B_pxtjBean bean = new B_pxtjBean();           bean.setAutoRelease(isAutoRelease);           return (B_pxtjBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_pxtjBean bean = new B_pxtjBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  corpkey;
String  whdm;
String  jcrenshu;
String  jcwomen;
String  pxrenshu;
String  tjrenshu;
String  zybrenshu;
String  dlrenshu;
String  id;
String  jcnongmin;
String  tjrenshu2;
String  tjrenshu3;
String  bakdate;
public static final String TABLENAME ="b_pxtj";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
B_pxtjBean abb = new B_pxtjBean();
abb.corpkey=rs.getString("corpkey");
abb.setKeyValue("CORPKEY","" + abb.getCorpkey());
abb.whdm=rs.getString("whdm");
abb.setKeyValue("WHDM","" + abb.getWhdm());
abb.jcrenshu=rs.getString("jcrenshu");
abb.setKeyValue("JCRENSHU","" + abb.getJcrenshu());
abb.jcwomen=rs.getString("jcwomen");
abb.setKeyValue("JCWOMEN","" + abb.getJcwomen());
abb.pxrenshu=rs.getString("pxrenshu");
abb.setKeyValue("PXRENSHU","" + abb.getPxrenshu());
abb.tjrenshu=rs.getString("tjrenshu");
abb.setKeyValue("TJRENSHU","" + abb.getTjrenshu());
abb.zybrenshu=rs.getString("zybrenshu");
abb.setKeyValue("ZYBRENSHU","" + abb.getZybrenshu());
abb.dlrenshu=rs.getString("dlrenshu");
abb.setKeyValue("DLRENSHU","" + abb.getDlrenshu());
abb.id=rs.getString("id");
abb.setKeyValue("ID","" + abb.getId());
abb.jcnongmin=rs.getString("jcnongmin");
abb.setKeyValue("JCNONGMIN","" + abb.getJcnongmin());
abb.tjrenshu2=rs.getString("tjrenshu2");
abb.setKeyValue("TJRENSHU2","" + abb.getTjrenshu2());
abb.tjrenshu3=rs.getString("tjrenshu3");
abb.setKeyValue("TJRENSHU3","" + abb.getTjrenshu3());
abb.bakdate=rs.getString("bakdate");
abb.setKeyValue("BAKDATE","" + abb.getBakdate());
list.add(abb);
abb.operate_mode = "edit";
}public String getCorpkey(){ if ( this.corpkey == null){ return ""; } else {return this.corpkey;}}public String getWhdm(){ if ( this.whdm == null){ return ""; } else {return this.whdm;}}public String getJcrenshu(){ if ( this.jcrenshu == null){ return ""; } else {return this.jcrenshu;}}public String getJcwomen(){ if ( this.jcwomen == null){ return ""; } else {return this.jcwomen;}}public String getPxrenshu(){ if ( this.pxrenshu == null){ return ""; } else {return this.pxrenshu;}}public String getTjrenshu(){ if ( this.tjrenshu == null){ return ""; } else {return this.tjrenshu;}}public String getZybrenshu(){ if ( this.zybrenshu == null){ return ""; } else {return this.zybrenshu;}}public String getDlrenshu(){ if ( this.dlrenshu == null){ return ""; } else {return this.dlrenshu;}}public String getId(){ if ( this.id == null){ return ""; } else {return this.id;}}public String getJcnongmin(){ if ( this.jcnongmin == null){ return ""; } else {return this.jcnongmin;}}public String getTjrenshu2(){ if ( this.tjrenshu2 == null){ return ""; } else {return this.tjrenshu2;}}public String getTjrenshu3(){ if ( this.tjrenshu3 == null){ return ""; } else {return this.tjrenshu3;}}public String getBakdate(){ if ( this.bakdate == null){ return ""; } else {return this.bakdate;}}public void setCorpkey( String corpkey){sqlMaker.setField("corpkey",corpkey,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCorpkey().equals(corpkey))
cf.add("corpkey",this.corpkey,corpkey);
}
this.corpkey=corpkey;
}
public void setWhdm( String whdm){sqlMaker.setField("whdm",whdm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhdm().equals(whdm))
cf.add("whdm",this.whdm,whdm);
}
this.whdm=whdm;
}
public void setJcrenshu( String jcrenshu){sqlMaker.setField("jcrenshu",jcrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcrenshu().equals(jcrenshu))
cf.add("jcrenshu",this.jcrenshu,jcrenshu);
}
this.jcrenshu=jcrenshu;
}
public void setJcwomen( String jcwomen){sqlMaker.setField("jcwomen",jcwomen,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcwomen().equals(jcwomen))
cf.add("jcwomen",this.jcwomen,jcwomen);
}
this.jcwomen=jcwomen;
}
public void setPxrenshu( String pxrenshu){sqlMaker.setField("pxrenshu",pxrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxrenshu().equals(pxrenshu))
cf.add("pxrenshu",this.pxrenshu,pxrenshu);
}
this.pxrenshu=pxrenshu;
}
public void setTjrenshu( String tjrenshu){sqlMaker.setField("tjrenshu",tjrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTjrenshu().equals(tjrenshu))
cf.add("tjrenshu",this.tjrenshu,tjrenshu);
}
this.tjrenshu=tjrenshu;
}
public void setZybrenshu( String zybrenshu){sqlMaker.setField("zybrenshu",zybrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZybrenshu().equals(zybrenshu))
cf.add("zybrenshu",this.zybrenshu,zybrenshu);
}
this.zybrenshu=zybrenshu;
}
public void setDlrenshu( String dlrenshu){sqlMaker.setField("dlrenshu",dlrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDlrenshu().equals(dlrenshu))
cf.add("dlrenshu",this.dlrenshu,dlrenshu);
}
this.dlrenshu=dlrenshu;
}
public void setId( String id){sqlMaker.setField("id",id,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getId().equals(id))
cf.add("id",this.id,id);
}
this.id=id;
}
public void setJcnongmin( String jcnongmin){sqlMaker.setField("jcnongmin",jcnongmin,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcnongmin().equals(jcnongmin))
cf.add("jcnongmin",this.jcnongmin,jcnongmin);
}
this.jcnongmin=jcnongmin;
}
public void setTjrenshu2( String tjrenshu2){sqlMaker.setField("tjrenshu2",tjrenshu2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTjrenshu2().equals(tjrenshu2))
cf.add("tjrenshu2",this.tjrenshu2,tjrenshu2);
}
this.tjrenshu2=tjrenshu2;
}
public void setTjrenshu3( String tjrenshu3){sqlMaker.setField("tjrenshu3",tjrenshu3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTjrenshu3().equals(tjrenshu3))
cf.add("tjrenshu3",this.tjrenshu3,tjrenshu3);
}
this.tjrenshu3=tjrenshu3;
}
public void setBakdate( String bakdate){sqlMaker.setField("bakdate",bakdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBakdate().equals(bakdate))
cf.add("bakdate",this.bakdate,bakdate);
}
this.bakdate=bakdate;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "corpkey") != null) 
this.setCorpkey(actionRequest.getFieldValue(i, "corpkey"));
if (actionRequest.getFieldValue(i, "whdm") != null) 
this.setWhdm(actionRequest.getFieldValue(i, "whdm"));
if (actionRequest.getFieldValue(i, "jcrenshu") != null) 
this.setJcrenshu(actionRequest.getFieldValue(i, "jcrenshu"));
if (actionRequest.getFieldValue(i, "jcwomen") != null) 
this.setJcwomen(actionRequest.getFieldValue(i, "jcwomen"));
if (actionRequest.getFieldValue(i, "pxrenshu") != null) 
this.setPxrenshu(actionRequest.getFieldValue(i, "pxrenshu"));
if (actionRequest.getFieldValue(i, "tjrenshu") != null) 
this.setTjrenshu(actionRequest.getFieldValue(i, "tjrenshu"));
if (actionRequest.getFieldValue(i, "zybrenshu") != null) 
this.setZybrenshu(actionRequest.getFieldValue(i, "zybrenshu"));
if (actionRequest.getFieldValue(i, "dlrenshu") != null) 
this.setDlrenshu(actionRequest.getFieldValue(i, "dlrenshu"));
if (actionRequest.getFieldValue(i, "id") != null) 
this.setId(actionRequest.getFieldValue(i, "id"));
if (actionRequest.getFieldValue(i, "jcnongmin") != null) 
this.setJcnongmin(actionRequest.getFieldValue(i, "jcnongmin"));
if (actionRequest.getFieldValue(i, "tjrenshu2") != null) 
this.setTjrenshu2(actionRequest.getFieldValue(i, "tjrenshu2"));
if (actionRequest.getFieldValue(i, "tjrenshu3") != null) 
this.setTjrenshu3(actionRequest.getFieldValue(i, "tjrenshu3"));
if (actionRequest.getFieldValue(i, "bakdate") != null) 
this.setBakdate(actionRequest.getFieldValue(i, "bakdate"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { B_pxtjBean obj = (B_pxtjBean)super.clone();obj.setCorpkey(obj.corpkey);
obj.setWhdm(obj.whdm);
obj.setJcrenshu(obj.jcrenshu);
obj.setJcwomen(obj.jcwomen);
obj.setPxrenshu(obj.pxrenshu);
obj.setTjrenshu(obj.tjrenshu);
obj.setZybrenshu(obj.zybrenshu);
obj.setDlrenshu(obj.dlrenshu);
obj.setId(obj.id);
obj.setJcnongmin(obj.jcnongmin);
obj.setTjrenshu2(obj.tjrenshu2);
obj.setTjrenshu3(obj.tjrenshu3);
obj.setBakdate(obj.bakdate);
return obj;}}