package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class Z_siteBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new Z_siteBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new Z_siteBean().findAndLockByWhere(sSqlWhere);      }       public static Z_siteBean findFirst(String sSqlWhere)throws Exception {           return (Z_siteBean)new Z_siteBean().findFirstByWhere(sSqlWhere);      }       public static Z_siteBean findFirstAndLock(String sSqlWhere)throws Exception {           return (Z_siteBean)new Z_siteBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new Z_siteBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           Z_siteBean bean = new Z_siteBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           Z_siteBean bean = new Z_siteBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static Z_siteBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           Z_siteBean bean = new Z_siteBean();           bean.setAutoRelease(isAutoRelease);           return (Z_siteBean)bean.findFirstByWhere(sSqlWhere);      }       public static Z_siteBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           Z_siteBean bean = new Z_siteBean();           bean.setAutoRelease(isAutoRelease);           return (Z_siteBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           Z_siteBean bean = new Z_siteBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  corpkey;
String  zymc;
String  miaoshu;
String  id;
String  jcrenshu;
public static final String TABLENAME ="z_site";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
Z_siteBean abb = new Z_siteBean();
abb.corpkey=rs.getString("corpkey");
abb.setKeyValue("CORPKEY","" + abb.getCorpkey());
abb.zymc=rs.getString("zymc");
abb.setKeyValue("ZYMC","" + abb.getZymc());
abb.miaoshu=rs.getString("miaoshu");
abb.setKeyValue("MIAOSHU","" + abb.getMiaoshu());
abb.id=rs.getString("id");
abb.setKeyValue("ID","" + abb.getId());
abb.jcrenshu=rs.getString("jcrenshu");
abb.setKeyValue("JCRENSHU","" + abb.getJcrenshu());
list.add(abb);
abb.operate_mode = "edit";
}public String getCorpkey(){ if ( this.corpkey == null){ return ""; } else {return this.corpkey;}}public String getZymc(){ if ( this.zymc == null){ return ""; } else {return this.zymc;}}public String getMiaoshu(){ if ( this.miaoshu == null){ return ""; } else {return this.miaoshu;}}public String getId(){ if ( this.id == null){ return ""; } else {return this.id;}}public String getJcrenshu(){ if ( this.jcrenshu == null){ return ""; } else {return this.jcrenshu;}}public void setCorpkey( String corpkey){sqlMaker.setField("corpkey",corpkey,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCorpkey().equals(corpkey))
cf.add("corpkey",this.corpkey,corpkey);
}
this.corpkey=corpkey;
}
public void setZymc( String zymc){sqlMaker.setField("zymc",zymc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZymc().equals(zymc))
cf.add("zymc",this.zymc,zymc);
}
this.zymc=zymc;
}
public void setMiaoshu( String miaoshu){sqlMaker.setField("miaoshu",miaoshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMiaoshu().equals(miaoshu))
cf.add("miaoshu",this.miaoshu,miaoshu);
}
this.miaoshu=miaoshu;
}
public void setId( String id){sqlMaker.setField("id",id,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getId().equals(id))
cf.add("id",this.id,id);
}
this.id=id;
}
public void setJcrenshu( String jcrenshu){sqlMaker.setField("jcrenshu",jcrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcrenshu().equals(jcrenshu))
cf.add("jcrenshu",this.jcrenshu,jcrenshu);
}
this.jcrenshu=jcrenshu;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "corpkey") != null) 
this.setCorpkey(actionRequest.getFieldValue(i, "corpkey"));
if (actionRequest.getFieldValue(i, "zymc") != null) 
this.setZymc(actionRequest.getFieldValue(i, "zymc"));
if (actionRequest.getFieldValue(i, "miaoshu") != null) 
this.setMiaoshu(actionRequest.getFieldValue(i, "miaoshu"));
if (actionRequest.getFieldValue(i, "id") != null) 
this.setId(actionRequest.getFieldValue(i, "id"));
if (actionRequest.getFieldValue(i, "jcrenshu") != null) 
this.setJcrenshu(actionRequest.getFieldValue(i, "jcrenshu"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { Z_siteBean obj = (Z_siteBean)super.clone();obj.setCorpkey(obj.corpkey);
obj.setZymc(obj.zymc);
obj.setMiaoshu(obj.miaoshu);
obj.setId(obj.id);
obj.setJcrenshu(obj.jcrenshu);
return obj;}}