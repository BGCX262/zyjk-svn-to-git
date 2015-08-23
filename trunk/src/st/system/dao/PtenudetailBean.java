package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtenudetailBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtenudetailBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtenudetailBean().findAndLockByWhere(sSqlWhere);      }       public static PtenudetailBean findFirst(String sSqlWhere)throws Exception {           return (PtenudetailBean)new PtenudetailBean().findFirstByWhere(sSqlWhere);      }       public static PtenudetailBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtenudetailBean)new PtenudetailBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtenudetailBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtenudetailBean bean = new PtenudetailBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtenudetailBean bean = new PtenudetailBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtenudetailBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtenudetailBean bean = new PtenudetailBean();           bean.setAutoRelease(isAutoRelease);           return (PtenudetailBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtenudetailBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtenudetailBean bean = new PtenudetailBean();           bean.setAutoRelease(isAutoRelease);           return (PtenudetailBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtenudetailBean bean = new PtenudetailBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  enutype; //枚举类型 
String  enuitemvalue; //枚举值 
String  enuitemlabel; //枚举内容 
String  enuitemdesc; //枚举描述 
String  dispno; //排序 
String  enuitemexpand; // 
String  enuitemspell; // 
String  parentid; //父节点 
public static final String TABLENAME ="ptenudetail";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtenudetailBean abb = new PtenudetailBean();
abb.enutype=rs.getString("enutype");
abb.setKeyValue("ENUTYPE","" + abb.getEnutype());
abb.enuitemvalue=rs.getString("enuitemvalue");
abb.setKeyValue("ENUITEMVALUE","" + abb.getEnuitemvalue());
abb.enuitemlabel=rs.getString("enuitemlabel");
abb.setKeyValue("ENUITEMLABEL","" + abb.getEnuitemlabel());
abb.enuitemdesc=rs.getString("enuitemdesc");
abb.setKeyValue("ENUITEMDESC","" + abb.getEnuitemdesc());
abb.dispno=rs.getString("dispno");
abb.setKeyValue("DISPNO","" + abb.getDispno());
abb.enuitemexpand=rs.getString("enuitemexpand");
abb.setKeyValue("ENUITEMEXPAND","" + abb.getEnuitemexpand());
abb.enuitemspell=rs.getString("enuitemspell");
abb.setKeyValue("ENUITEMSPELL","" + abb.getEnuitemspell());
abb.parentid=rs.getString("parentid");
abb.setKeyValue("PARENTID","" + abb.getParentid());
list.add(abb);
abb.operate_mode = "edit";
}public String getEnutype(){ if ( this.enutype == null){ return ""; } else {return this.enutype;}}public String getEnuitemvalue(){ if ( this.enuitemvalue == null){ return ""; } else {return this.enuitemvalue;}}public String getEnuitemlabel(){ if ( this.enuitemlabel == null){ return ""; } else {return this.enuitemlabel;}}public String getEnuitemdesc(){ if ( this.enuitemdesc == null){ return ""; } else {return this.enuitemdesc;}}public String getDispno(){ if ( this.dispno == null){ return ""; } else {return this.dispno;}}public String getEnuitemexpand(){ if ( this.enuitemexpand == null){ return ""; } else {return this.enuitemexpand;}}public String getEnuitemspell(){ if ( this.enuitemspell == null){ return ""; } else {return this.enuitemspell;}}public String getParentid(){ if ( this.parentid == null){ return ""; } else {return this.parentid;}}public void setEnutype( String enutype){sqlMaker.setField("enutype",enutype,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnutype().equals(enutype))
cf.add("enutype",this.enutype,enutype);
}
this.enutype=enutype;
}
public void setEnuitemvalue( String enuitemvalue){sqlMaker.setField("enuitemvalue",enuitemvalue,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnuitemvalue().equals(enuitemvalue))
cf.add("enuitemvalue",this.enuitemvalue,enuitemvalue);
}
this.enuitemvalue=enuitemvalue;
}
public void setEnuitemlabel( String enuitemlabel){sqlMaker.setField("enuitemlabel",enuitemlabel,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnuitemlabel().equals(enuitemlabel))
cf.add("enuitemlabel",this.enuitemlabel,enuitemlabel);
}
this.enuitemlabel=enuitemlabel;
}
public void setEnuitemdesc( String enuitemdesc){sqlMaker.setField("enuitemdesc",enuitemdesc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnuitemdesc().equals(enuitemdesc))
cf.add("enuitemdesc",this.enuitemdesc,enuitemdesc);
}
this.enuitemdesc=enuitemdesc;
}
public void setDispno( String dispno){sqlMaker.setField("dispno",dispno,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getDispno().equals(dispno))
cf.add("dispno",this.dispno,dispno);
}
this.dispno=dispno;
}
public void setEnuitemexpand( String enuitemexpand){sqlMaker.setField("enuitemexpand",enuitemexpand,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnuitemexpand().equals(enuitemexpand))
cf.add("enuitemexpand",this.enuitemexpand,enuitemexpand);
}
this.enuitemexpand=enuitemexpand;
}
public void setEnuitemspell( String enuitemspell){sqlMaker.setField("enuitemspell",enuitemspell,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnuitemspell().equals(enuitemspell))
cf.add("enuitemspell",this.enuitemspell,enuitemspell);
}
this.enuitemspell=enuitemspell;
}
public void setParentid( String parentid){sqlMaker.setField("parentid",parentid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParentid().equals(parentid))
cf.add("parentid",this.parentid,parentid);
}
this.parentid=parentid;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "enutype") != null) 
this.setEnutype(actionRequest.getFieldValue(i, "enutype"));
if (actionRequest.getFieldValue(i, "enuitemvalue") != null) 
this.setEnuitemvalue(actionRequest.getFieldValue(i, "enuitemvalue"));
if (actionRequest.getFieldValue(i, "enuitemlabel") != null) 
this.setEnuitemlabel(actionRequest.getFieldValue(i, "enuitemlabel"));
if (actionRequest.getFieldValue(i, "enuitemdesc") != null) 
this.setEnuitemdesc(actionRequest.getFieldValue(i, "enuitemdesc"));
if (actionRequest.getFieldValue(i, "dispno") != null) 
this.setDispno(actionRequest.getFieldValue(i, "dispno"));
if (actionRequest.getFieldValue(i, "enuitemexpand") != null) 
this.setEnuitemexpand(actionRequest.getFieldValue(i, "enuitemexpand"));
if (actionRequest.getFieldValue(i, "enuitemspell") != null) 
this.setEnuitemspell(actionRequest.getFieldValue(i, "enuitemspell"));
if (actionRequest.getFieldValue(i, "parentid") != null) 
this.setParentid(actionRequest.getFieldValue(i, "parentid"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtenudetailBean obj = (PtenudetailBean)super.clone();obj.setEnutype(obj.enutype);
obj.setEnuitemvalue(obj.enuitemvalue);
obj.setEnuitemlabel(obj.enuitemlabel);
obj.setEnuitemdesc(obj.enuitemdesc);
obj.setDispno(obj.dispno);
obj.setEnuitemexpand(obj.enuitemexpand);
obj.setEnuitemspell(obj.enuitemspell);
obj.setParentid(obj.parentid);
return obj;}}