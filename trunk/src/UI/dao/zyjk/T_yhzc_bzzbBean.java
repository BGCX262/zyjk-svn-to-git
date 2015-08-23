package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class T_yhzc_bzzbBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new T_yhzc_bzzbBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new T_yhzc_bzzbBean().findAndLockByWhere(sSqlWhere);      }       public static T_yhzc_bzzbBean findFirst(String sSqlWhere)throws Exception {           return (T_yhzc_bzzbBean)new T_yhzc_bzzbBean().findFirstByWhere(sSqlWhere);      }       public static T_yhzc_bzzbBean findFirstAndLock(String sSqlWhere)throws Exception {           return (T_yhzc_bzzbBean)new T_yhzc_bzzbBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new T_yhzc_bzzbBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_yhzc_bzzbBean bean = new T_yhzc_bzzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           T_yhzc_bzzbBean bean = new T_yhzc_bzzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static T_yhzc_bzzbBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_yhzc_bzzbBean bean = new T_yhzc_bzzbBean();           bean.setAutoRelease(isAutoRelease);           return (T_yhzc_bzzbBean)bean.findFirstByWhere(sSqlWhere);      }       public static T_yhzc_bzzbBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           T_yhzc_bzzbBean bean = new T_yhzc_bzzbBean();           bean.setAutoRelease(isAutoRelease);           return (T_yhzc_bzzbBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_yhzc_bzzbBean bean = new T_yhzc_bzzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  id;
String  bzzmc;
String  bzsm;
String  jglx;
String  isdel;
String  czzt;
String  ver;
public static final String TABLENAME ="t_yhzc_bzzb";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
T_yhzc_bzzbBean abb = new T_yhzc_bzzbBean();
abb.id=rs.getString("id");
abb.setKeyValue("ID","" + abb.getId());
abb.bzzmc=rs.getString("bzzmc");
abb.setKeyValue("BZZMC","" + abb.getBzzmc());
abb.bzsm=rs.getString("bzsm");
abb.setKeyValue("BZSM","" + abb.getBzsm());
abb.jglx=rs.getString("jglx");
abb.setKeyValue("JGLX","" + abb.getJglx());
abb.isdel=rs.getString("isdel");
abb.setKeyValue("ISDEL","" + abb.getIsdel());
abb.czzt=rs.getString("czzt");
abb.setKeyValue("CZZT","" + abb.getCzzt());
abb.ver=rs.getString("ver");
abb.setKeyValue("VER","" + abb.getVer());
list.add(abb);
abb.operate_mode = "edit";
}public String getId(){ if ( this.id == null){ return ""; } else {return this.id;}}public String getBzzmc(){ if ( this.bzzmc == null){ return ""; } else {return this.bzzmc;}}public String getBzsm(){ if ( this.bzsm == null){ return ""; } else {return this.bzsm;}}public String getJglx(){ if ( this.jglx == null){ return ""; } else {return this.jglx;}}public String getIsdel(){ if ( this.isdel == null){ return ""; } else {return this.isdel;}}public String getCzzt(){ if ( this.czzt == null){ return ""; } else {return this.czzt;}}public String getVer(){ if ( this.ver == null){ return ""; } else {return this.ver;}}public void setId( String id){sqlMaker.setField("id",id,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getId().equals(id))
cf.add("id",this.id,id);
}
this.id=id;
}
public void setBzzmc( String bzzmc){sqlMaker.setField("bzzmc",bzzmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBzzmc().equals(bzzmc))
cf.add("bzzmc",this.bzzmc,bzzmc);
}
this.bzzmc=bzzmc;
}
public void setBzsm( String bzsm){sqlMaker.setField("bzsm",bzsm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBzsm().equals(bzsm))
cf.add("bzsm",this.bzsm,bzsm);
}
this.bzsm=bzsm;
}
public void setJglx( String jglx){sqlMaker.setField("jglx",jglx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJglx().equals(jglx))
cf.add("jglx",this.jglx,jglx);
}
this.jglx=jglx;
}
public void setIsdel( String isdel){sqlMaker.setField("isdel",isdel,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsdel().equals(isdel))
cf.add("isdel",this.isdel,isdel);
}
this.isdel=isdel;
}
public void setCzzt( String czzt){sqlMaker.setField("czzt",czzt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCzzt().equals(czzt))
cf.add("czzt",this.czzt,czzt);
}
this.czzt=czzt;
}
public void setVer( String ver){sqlMaker.setField("ver",ver,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getVer().equals(ver))
cf.add("ver",this.ver,ver);
}
this.ver=ver;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "id") != null) 
this.setId(actionRequest.getFieldValue(i, "id"));
if (actionRequest.getFieldValue(i, "bzzmc") != null) 
this.setBzzmc(actionRequest.getFieldValue(i, "bzzmc"));
if (actionRequest.getFieldValue(i, "bzsm") != null) 
this.setBzsm(actionRequest.getFieldValue(i, "bzsm"));
if (actionRequest.getFieldValue(i, "jglx") != null) 
this.setJglx(actionRequest.getFieldValue(i, "jglx"));
if (actionRequest.getFieldValue(i, "isdel") != null) 
this.setIsdel(actionRequest.getFieldValue(i, "isdel"));
if (actionRequest.getFieldValue(i, "czzt") != null) 
this.setCzzt(actionRequest.getFieldValue(i, "czzt"));
if (actionRequest.getFieldValue(i, "ver") != null) 
this.setVer(actionRequest.getFieldValue(i, "ver"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { T_yhzc_bzzbBean obj = (T_yhzc_bzzbBean)super.clone();obj.setId(obj.id);
obj.setBzzmc(obj.bzzmc);
obj.setBzsm(obj.bzsm);
obj.setJglx(obj.jglx);
obj.setIsdel(obj.isdel);
obj.setCzzt(obj.czzt);
obj.setVer(obj.ver);
return obj;}}