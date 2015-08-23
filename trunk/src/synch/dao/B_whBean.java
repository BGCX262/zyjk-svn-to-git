package synch.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class B_whBean extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) throws Exception{           return new B_whBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new B_whBean().findAndLockByWhere(sSqlWhere);      }       public static B_whBean findFirst(String sSqlWhere)throws Exception {           return (B_whBean)new B_whBean().findFirstByWhere(sSqlWhere);      }       public static B_whBean findFirstAndLock(String sSqlWhere)throws Exception {           return (B_whBean)new B_whBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new B_whBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_whBean bean = new B_whBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           B_whBean bean = new B_whBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static B_whBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_whBean bean = new B_whBean();           bean.setAutoRelease(isAutoRelease);           return (B_whBean)bean.findFirstByWhere(sSqlWhere);      }       public static B_whBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           B_whBean bean = new B_whBean();           bean.setAutoRelease(isAutoRelease);           return (B_whBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_whBean bean = new B_whBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  corpkey;
String  siteid;
String  whdm;
String  source;
String  sbstate;
String  czfs;
String  sfgl;
String  jcrenshu;
String  jcwomen;
String  ndorqd;
String  ndorqddw;
String  gcfh;
String  gtfh;
String  id;
String  jcnongmin;
String  bakdate;
public static final String TABLENAME ="b_wh";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
B_whBean abb = new B_whBean();
abb.corpkey=rs.getString("corpkey");
abb.setKeyValue("CORPKEY","" + abb.getCorpkey());
abb.siteid=rs.getString("siteid");
abb.setKeyValue("SITEID","" + abb.getSiteid());
abb.whdm=rs.getString("whdm");
abb.setKeyValue("WHDM","" + abb.getWhdm());
abb.source=rs.getString("source");
abb.setKeyValue("SOURCE","" + abb.getSource());
abb.sbstate=rs.getString("sbstate");
abb.setKeyValue("SBSTATE","" + abb.getSbstate());
abb.czfs=rs.getString("czfs");
abb.setKeyValue("CZFS","" + abb.getCzfs());
abb.sfgl=rs.getString("sfgl");
abb.setKeyValue("SFGL","" + abb.getSfgl());
abb.jcrenshu=rs.getString("jcrenshu");
abb.setKeyValue("JCRENSHU","" + abb.getJcrenshu());
abb.jcwomen=rs.getString("jcwomen");
abb.setKeyValue("JCWOMEN","" + abb.getJcwomen());
abb.ndorqd=rs.getString("ndorqd");
abb.setKeyValue("NDORQD","" + abb.getNdorqd());
abb.ndorqddw=rs.getString("ndorqddw");
abb.setKeyValue("NDORQDDW","" + abb.getNdorqddw());
abb.gcfh=rs.getString("gcfh");
abb.setKeyValue("GCFH","" + abb.getGcfh());
abb.gtfh=rs.getString("gtfh");
abb.setKeyValue("GTFH","" + abb.getGtfh());
abb.id=rs.getString("id");
abb.setKeyValue("ID","" + abb.getId());
abb.jcnongmin=rs.getString("jcnongmin");
abb.setKeyValue("JCNONGMIN","" + abb.getJcnongmin());
abb.bakdate=rs.getString("bakdate");
abb.setKeyValue("BAKDATE","" + abb.getBakdate());
list.add(abb);
abb.operate_mode = "edit";
}public String getCorpkey(){ if ( this.corpkey == null){ return ""; } else {return this.corpkey;}}public String getSiteid(){ if ( this.siteid == null){ return ""; } else {return this.siteid;}}public String getWhdm(){ if ( this.whdm == null){ return ""; } else {return this.whdm;}}public String getSource(){ if ( this.source == null){ return ""; } else {return this.source;}}public String getSbstate(){ if ( this.sbstate == null){ return ""; } else {return this.sbstate;}}public String getCzfs(){ if ( this.czfs == null){ return ""; } else {return this.czfs;}}public String getSfgl(){ if ( this.sfgl == null){ return ""; } else {return this.sfgl;}}public String getJcrenshu(){ if ( this.jcrenshu == null){ return ""; } else {return this.jcrenshu;}}public String getJcwomen(){ if ( this.jcwomen == null){ return ""; } else {return this.jcwomen;}}public String getNdorqd(){ if ( this.ndorqd == null){ return ""; } else {return this.ndorqd;}}public String getNdorqddw(){ if ( this.ndorqddw == null){ return ""; } else {return this.ndorqddw;}}public String getGcfh(){ if ( this.gcfh == null){ return ""; } else {return this.gcfh;}}public String getGtfh(){ if ( this.gtfh == null){ return ""; } else {return this.gtfh;}}public String getId(){ if ( this.id == null){ return ""; } else {return this.id;}}public String getJcnongmin(){ if ( this.jcnongmin == null){ return ""; } else {return this.jcnongmin;}}public String getBakdate(){ if ( this.bakdate == null){ return ""; } else {return this.bakdate;}}public void setCorpkey( String corpkey){sqlMaker.setField("corpkey",corpkey,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCorpkey().equals(corpkey))
cf.add("corpkey",this.corpkey,corpkey);
}
this.corpkey=corpkey;
}
public void setSiteid( String siteid){sqlMaker.setField("siteid",siteid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSiteid().equals(siteid))
cf.add("siteid",this.siteid,siteid);
}
this.siteid=siteid;
}
public void setWhdm( String whdm){sqlMaker.setField("whdm",whdm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhdm().equals(whdm))
cf.add("whdm",this.whdm,whdm);
}
this.whdm=whdm;
}
public void setSource( String source){sqlMaker.setField("source",source,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSource().equals(source))
cf.add("source",this.source,source);
}
this.source=source;
}
public void setSbstate( String sbstate){sqlMaker.setField("sbstate",sbstate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSbstate().equals(sbstate))
cf.add("sbstate",this.sbstate,sbstate);
}
this.sbstate=sbstate;
}
public void setCzfs( String czfs){sqlMaker.setField("czfs",czfs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCzfs().equals(czfs))
cf.add("czfs",this.czfs,czfs);
}
this.czfs=czfs;
}
public void setSfgl( String sfgl){sqlMaker.setField("sfgl",sfgl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfgl().equals(sfgl))
cf.add("sfgl",this.sfgl,sfgl);
}
this.sfgl=sfgl;
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
public void setNdorqd( String ndorqd){sqlMaker.setField("ndorqd",ndorqd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNdorqd().equals(ndorqd))
cf.add("ndorqd",this.ndorqd,ndorqd);
}
this.ndorqd=ndorqd;
}
public void setNdorqddw( String ndorqddw){sqlMaker.setField("ndorqddw",ndorqddw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNdorqddw().equals(ndorqddw))
cf.add("ndorqddw",this.ndorqddw,ndorqddw);
}
this.ndorqddw=ndorqddw;
}
public void setGcfh( String gcfh){sqlMaker.setField("gcfh",gcfh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGcfh().equals(gcfh))
cf.add("gcfh",this.gcfh,gcfh);
}
this.gcfh=gcfh;
}
public void setGtfh( String gtfh){sqlMaker.setField("gtfh",gtfh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGtfh().equals(gtfh))
cf.add("gtfh",this.gtfh,gtfh);
}
this.gtfh=gtfh;
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
public void setBakdate( String bakdate){sqlMaker.setField("bakdate",bakdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBakdate().equals(bakdate))
cf.add("bakdate",this.bakdate,bakdate);
}
this.bakdate=bakdate;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "corpkey") != null) 
this.setCorpkey(actionRequest.getFieldValue(i, "corpkey"));
if (actionRequest.getFieldValue(i, "siteid") != null) 
this.setSiteid(actionRequest.getFieldValue(i, "siteid"));
if (actionRequest.getFieldValue(i, "whdm") != null) 
this.setWhdm(actionRequest.getFieldValue(i, "whdm"));
if (actionRequest.getFieldValue(i, "source") != null) 
this.setSource(actionRequest.getFieldValue(i, "source"));
if (actionRequest.getFieldValue(i, "sbstate") != null) 
this.setSbstate(actionRequest.getFieldValue(i, "sbstate"));
if (actionRequest.getFieldValue(i, "czfs") != null) 
this.setCzfs(actionRequest.getFieldValue(i, "czfs"));
if (actionRequest.getFieldValue(i, "sfgl") != null) 
this.setSfgl(actionRequest.getFieldValue(i, "sfgl"));
if (actionRequest.getFieldValue(i, "jcrenshu") != null) 
this.setJcrenshu(actionRequest.getFieldValue(i, "jcrenshu"));
if (actionRequest.getFieldValue(i, "jcwomen") != null) 
this.setJcwomen(actionRequest.getFieldValue(i, "jcwomen"));
if (actionRequest.getFieldValue(i, "ndorqd") != null) 
this.setNdorqd(actionRequest.getFieldValue(i, "ndorqd"));
if (actionRequest.getFieldValue(i, "ndorqddw") != null) 
this.setNdorqddw(actionRequest.getFieldValue(i, "ndorqddw"));
if (actionRequest.getFieldValue(i, "gcfh") != null) 
this.setGcfh(actionRequest.getFieldValue(i, "gcfh"));
if (actionRequest.getFieldValue(i, "gtfh") != null) 
this.setGtfh(actionRequest.getFieldValue(i, "gtfh"));
if (actionRequest.getFieldValue(i, "id") != null) 
this.setId(actionRequest.getFieldValue(i, "id"));
if (actionRequest.getFieldValue(i, "jcnongmin") != null) 
this.setJcnongmin(actionRequest.getFieldValue(i, "jcnongmin"));
if (actionRequest.getFieldValue(i, "bakdate") != null) 
this.setBakdate(actionRequest.getFieldValue(i, "bakdate"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { B_whBean obj = (B_whBean)super.clone();obj.setCorpkey(obj.corpkey);
obj.setSiteid(obj.siteid);
obj.setWhdm(obj.whdm);
obj.setSource(obj.source);
obj.setSbstate(obj.sbstate);
obj.setCzfs(obj.czfs);
obj.setSfgl(obj.sfgl);
obj.setJcrenshu(obj.jcrenshu);
obj.setJcwomen(obj.jcwomen);
obj.setNdorqd(obj.ndorqd);
obj.setNdorqddw(obj.ndorqddw);
obj.setGcfh(obj.gcfh);
obj.setGtfh(obj.gtfh);
obj.setId(obj.id);
obj.setJcnongmin(obj.jcnongmin);
obj.setBakdate(obj.bakdate);
return obj;}}