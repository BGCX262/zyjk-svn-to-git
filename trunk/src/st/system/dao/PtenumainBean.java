package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtenumainBean extends AbstractBasicBean implements Cloneable {
     /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static List find(String sSqlWhere) throws Exception{           return new PtenumainBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtenumainBean().findAndLockByWhere(sSqlWhere);      }       public static PtenumainBean findFirst(String sSqlWhere)throws Exception {           return (PtenumainBean)new PtenumainBean().findFirstByWhere(sSqlWhere);      }       public static PtenumainBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtenumainBean)new PtenumainBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtenumainBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtenumainBean bean = new PtenumainBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtenumainBean bean = new PtenumainBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtenumainBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtenumainBean bean = new PtenumainBean();           bean.setAutoRelease(isAutoRelease);           return (PtenumainBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtenumainBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtenumainBean bean = new PtenumainBean();           bean.setAutoRelease(isAutoRelease);           return (PtenumainBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtenumainBean bean = new PtenumainBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  enutype;
String  enuname;
String  valuetype;
String  enudesc;
String  parenutype;
String  isleaf;
public static final String TABLENAME ="ptenumain";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
@SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtenumainBean abb = new PtenumainBean();
abb.enutype=rs.getString("enutype");
abb.setKeyValue("ENUTYPE","" + abb.getEnutype());
abb.enuname=rs.getString("enuname");
abb.setKeyValue("ENUNAME","" + abb.getEnuname());
abb.valuetype=rs.getString("valuetype");
abb.setKeyValue("VALUETYPE","" + abb.getValuetype());
abb.enudesc=rs.getString("enudesc");
abb.setKeyValue("ENUDESC","" + abb.getEnudesc());
abb.parenutype=rs.getString("parenutype");
abb.setKeyValue("PARENUTYPE","" + abb.getParenutype());
abb.isleaf=rs.getString("isleaf");
abb.setKeyValue("ISLEAF","" + abb.getIsleaf());
list.add(abb);
abb.operate_mode = "edit";
}public String getEnutype(){ if ( this.enutype == null){ return ""; } else {return this.enutype;}}public String getEnuname(){ if ( this.enuname == null){ return ""; } else {return this.enuname;}}public String getValuetype(){ if ( this.valuetype == null){ return ""; } else {return this.valuetype;}}public String getEnudesc(){ if ( this.enudesc == null){ return ""; } else {return this.enudesc;}}public String getParenutype(){ if ( this.parenutype == null){ return ""; } else {return this.parenutype;}}public String getIsleaf(){ if ( this.isleaf == null){ return ""; } else {return this.isleaf;}}public void setEnutype( String enutype){sqlMaker.setField("enutype",enutype,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnutype().equals(enutype))
cf.add("enutype",this.enutype,enutype);
}
this.enutype=enutype;
}
public void setEnuname( String enuname){sqlMaker.setField("enuname",enuname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnuname().equals(enuname))
cf.add("enuname",this.enuname,enuname);
}
this.enuname=enuname;
}
public void setValuetype( String valuetype){sqlMaker.setField("valuetype",valuetype,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getValuetype().equals(valuetype))
cf.add("valuetype",this.valuetype,valuetype);
}
this.valuetype=valuetype;
}
public void setEnudesc( String enudesc){sqlMaker.setField("enudesc",enudesc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnudesc().equals(enudesc))
cf.add("enudesc",this.enudesc,enudesc);
}
this.enudesc=enudesc;
}
public void setParenutype( String parenutype){sqlMaker.setField("parenutype",parenutype,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParenutype().equals(parenutype))
cf.add("parenutype",this.parenutype,parenutype);
}
this.parenutype=parenutype;
}
public void setIsleaf( String isleaf){sqlMaker.setField("isleaf",isleaf,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsleaf().equals(isleaf))
cf.add("isleaf",this.isleaf,isleaf);
}
this.isleaf=isleaf;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "enutype") != null) 
this.setEnutype(actionRequest.getFieldValue(i, "enutype"));
if (actionRequest.getFieldValue(i, "enuname") != null) 
this.setEnuname(actionRequest.getFieldValue(i, "enuname"));
if (actionRequest.getFieldValue(i, "valuetype") != null) 
this.setValuetype(actionRequest.getFieldValue(i, "valuetype"));
if (actionRequest.getFieldValue(i, "enudesc") != null) 
this.setEnudesc(actionRequest.getFieldValue(i, "enudesc"));
if (actionRequest.getFieldValue(i, "parenutype") != null) 
this.setParenutype(actionRequest.getFieldValue(i, "parenutype"));
if (actionRequest.getFieldValue(i, "isleaf") != null) 
this.setIsleaf(actionRequest.getFieldValue(i, "isleaf"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtenumainBean obj = (PtenumainBean)super.clone();obj.setEnutype(obj.enutype);
obj.setEnuname(obj.enuname);
obj.setValuetype(obj.valuetype);
obj.setEnudesc(obj.enudesc);
obj.setParenutype(obj.parenutype);
obj.setIsleaf(obj.isleaf);
return obj;}}