package synch.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class B_sccpBean extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) throws Exception{           return new B_sccpBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new B_sccpBean().findAndLockByWhere(sSqlWhere);      }       public static B_sccpBean findFirst(String sSqlWhere)throws Exception {           return (B_sccpBean)new B_sccpBean().findFirstByWhere(sSqlWhere);      }       public static B_sccpBean findFirstAndLock(String sSqlWhere)throws Exception {           return (B_sccpBean)new B_sccpBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new B_sccpBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_sccpBean bean = new B_sccpBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           B_sccpBean bean = new B_sccpBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static B_sccpBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_sccpBean bean = new B_sccpBean();           bean.setAutoRelease(isAutoRelease);           return (B_sccpBean)bean.findFirstByWhere(sSqlWhere);      }       public static B_sccpBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           B_sccpBean bean = new B_sccpBean();           bean.setAutoRelease(isAutoRelease);           return (B_sccpBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_sccpBean bean = new B_sccpBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  corpkey;
String  mc;
String  nianliang;
String  danwei;
String  id;
String  bakdate;
public static final String TABLENAME ="b_sccp";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
B_sccpBean abb = new B_sccpBean();
abb.corpkey=rs.getString("corpkey");
abb.setKeyValue("CORPKEY","" + abb.getCorpkey());
abb.mc=rs.getString("mc");
abb.setKeyValue("MC","" + abb.getMc());
abb.nianliang=rs.getString("nianliang");
abb.setKeyValue("NIANLIANG","" + abb.getNianliang());
abb.danwei=rs.getString("danwei");
abb.setKeyValue("DANWEI","" + abb.getDanwei());
abb.id=rs.getString("id");
abb.setKeyValue("ID","" + abb.getId());
abb.bakdate=rs.getString("bakdate");
abb.setKeyValue("BAKDATE","" + abb.getBakdate());
list.add(abb);
abb.operate_mode = "edit";
}public String getCorpkey(){ if ( this.corpkey == null){ return ""; } else {return this.corpkey;}}public String getMc(){ if ( this.mc == null){ return ""; } else {return this.mc;}}public String getNianliang(){ if ( this.nianliang == null){ return ""; } else {return this.nianliang;}}public String getDanwei(){ if ( this.danwei == null){ return ""; } else {return this.danwei;}}public String getId(){ if ( this.id == null){ return ""; } else {return this.id;}}public String getBakdate(){ if ( this.bakdate == null){ return ""; } else {return this.bakdate;}}public void setCorpkey( String corpkey){sqlMaker.setField("corpkey",corpkey,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCorpkey().equals(corpkey))
cf.add("corpkey",this.corpkey,corpkey);
}
this.corpkey=corpkey;
}
public void setMc( String mc){sqlMaker.setField("mc",mc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMc().equals(mc))
cf.add("mc",this.mc,mc);
}
this.mc=mc;
}
public void setNianliang( String nianliang){sqlMaker.setField("nianliang",nianliang,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNianliang().equals(nianliang))
cf.add("nianliang",this.nianliang,nianliang);
}
this.nianliang=nianliang;
}
public void setDanwei( String danwei){sqlMaker.setField("danwei",danwei,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDanwei().equals(danwei))
cf.add("danwei",this.danwei,danwei);
}
this.danwei=danwei;
}
public void setId( String id){sqlMaker.setField("id",id,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getId().equals(id))
cf.add("id",this.id,id);
}
this.id=id;
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
if (actionRequest.getFieldValue(i, "mc") != null) 
this.setMc(actionRequest.getFieldValue(i, "mc"));
if (actionRequest.getFieldValue(i, "nianliang") != null) 
this.setNianliang(actionRequest.getFieldValue(i, "nianliang"));
if (actionRequest.getFieldValue(i, "danwei") != null) 
this.setDanwei(actionRequest.getFieldValue(i, "danwei"));
if (actionRequest.getFieldValue(i, "id") != null) 
this.setId(actionRequest.getFieldValue(i, "id"));
if (actionRequest.getFieldValue(i, "bakdate") != null) 
this.setBakdate(actionRequest.getFieldValue(i, "bakdate"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { B_sccpBean obj = (B_sccpBean)super.clone();obj.setCorpkey(obj.corpkey);
obj.setMc(obj.mc);
obj.setNianliang(obj.nianliang);
obj.setDanwei(obj.danwei);
obj.setId(obj.id);
obj.setBakdate(obj.bakdate);
return obj;}}