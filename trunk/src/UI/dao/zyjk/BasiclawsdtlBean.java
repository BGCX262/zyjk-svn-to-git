package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class BasiclawsdtlBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new BasiclawsdtlBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new BasiclawsdtlBean().findAndLockByWhere(sSqlWhere);      }       public static BasiclawsdtlBean findFirst(String sSqlWhere)throws Exception {           return (BasiclawsdtlBean)new BasiclawsdtlBean().findFirstByWhere(sSqlWhere);      }       public static BasiclawsdtlBean findFirstAndLock(String sSqlWhere)throws Exception {           return (BasiclawsdtlBean)new BasiclawsdtlBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new BasiclawsdtlBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           BasiclawsdtlBean bean = new BasiclawsdtlBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           BasiclawsdtlBean bean = new BasiclawsdtlBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static BasiclawsdtlBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           BasiclawsdtlBean bean = new BasiclawsdtlBean();           bean.setAutoRelease(isAutoRelease);           return (BasiclawsdtlBean)bean.findFirstByWhere(sSqlWhere);      }       public static BasiclawsdtlBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           BasiclawsdtlBean bean = new BasiclawsdtlBean();           bean.setAutoRelease(isAutoRelease);           return (BasiclawsdtlBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           BasiclawsdtlBean bean = new BasiclawsdtlBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  lawsysno;
String  itemcode;
String  itemcontent;
String  duties;
String  fill1;
String  fill2;
String  fill3;
String  fill4;
String  fill5;
String  fill6;
public static final String TABLENAME ="basiclawsdtl";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
BasiclawsdtlBean abb = new BasiclawsdtlBean();
abb.lawsysno=rs.getString("lawsysno");
abb.setKeyValue("LAWSYSNO","" + abb.getLawsysno());
abb.itemcode=rs.getString("itemcode");
abb.setKeyValue("ITEMCODE","" + abb.getItemcode());
abb.itemcontent=rs.getString("itemcontent");
abb.setKeyValue("ITEMCONTENT","" + abb.getItemcontent());
abb.duties=rs.getString("duties");
abb.setKeyValue("DUTIES","" + abb.getDuties());
abb.fill1=rs.getString("fill1");
abb.setKeyValue("FILL1","" + abb.getFill1());
abb.fill2=rs.getString("fill2");
abb.setKeyValue("FILL2","" + abb.getFill2());
abb.fill3=rs.getString("fill3");
abb.setKeyValue("FILL3","" + abb.getFill3());
abb.fill4=rs.getString("fill4");
abb.setKeyValue("FILL4","" + abb.getFill4());
abb.fill5=rs.getString("fill5");
abb.setKeyValue("FILL5","" + abb.getFill5());
abb.fill6=rs.getString("fill6");
abb.setKeyValue("FILL6","" + abb.getFill6());
list.add(abb);
abb.operate_mode = "edit";
}public String getLawsysno(){ if ( this.lawsysno == null){ return ""; } else {return this.lawsysno;}}public String getItemcode(){ if ( this.itemcode == null){ return ""; } else {return this.itemcode;}}public String getItemcontent(){ if ( this.itemcontent == null){ return ""; } else {return this.itemcontent;}}public String getDuties(){ if ( this.duties == null){ return ""; } else {return this.duties;}}public String getFill1(){ if ( this.fill1 == null){ return ""; } else {return this.fill1;}}public String getFill2(){ if ( this.fill2 == null){ return ""; } else {return this.fill2;}}public String getFill3(){ if ( this.fill3 == null){ return ""; } else {return this.fill3;}}public String getFill4(){ if ( this.fill4 == null){ return ""; } else {return this.fill4;}}public String getFill5(){ if ( this.fill5 == null){ return ""; } else {return this.fill5;}}public String getFill6(){ if ( this.fill6 == null){ return ""; } else {return this.fill6;}}public void setLawsysno( String lawsysno){sqlMaker.setField("lawsysno",lawsysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLawsysno().equals(lawsysno))
cf.add("lawsysno",this.lawsysno,lawsysno);
}
this.lawsysno=lawsysno;
}
public void setItemcode( String itemcode){sqlMaker.setField("itemcode",itemcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getItemcode().equals(itemcode))
cf.add("itemcode",this.itemcode,itemcode);
}
this.itemcode=itemcode;
}
public void setItemcontent( String itemcontent){sqlMaker.setField("itemcontent",itemcontent,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getItemcontent().equals(itemcontent))
cf.add("itemcontent",this.itemcontent,itemcontent);
}
this.itemcontent=itemcontent;
}
public void setDuties( String duties){sqlMaker.setField("duties",duties,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDuties().equals(duties))
cf.add("duties",this.duties,duties);
}
this.duties=duties;
}
public void setFill1( String fill1){sqlMaker.setField("fill1",fill1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFill1().equals(fill1))
cf.add("fill1",this.fill1,fill1);
}
this.fill1=fill1;
}
public void setFill2( String fill2){sqlMaker.setField("fill2",fill2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFill2().equals(fill2))
cf.add("fill2",this.fill2,fill2);
}
this.fill2=fill2;
}
public void setFill3( String fill3){sqlMaker.setField("fill3",fill3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFill3().equals(fill3))
cf.add("fill3",this.fill3,fill3);
}
this.fill3=fill3;
}
public void setFill4( String fill4){sqlMaker.setField("fill4",fill4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFill4().equals(fill4))
cf.add("fill4",this.fill4,fill4);
}
this.fill4=fill4;
}
public void setFill5( String fill5){sqlMaker.setField("fill5",fill5,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFill5().equals(fill5))
cf.add("fill5",this.fill5,fill5);
}
this.fill5=fill5;
}
public void setFill6( String fill6){sqlMaker.setField("fill6",fill6,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFill6().equals(fill6))
cf.add("fill6",this.fill6,fill6);
}
this.fill6=fill6;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "lawsysno") != null) 
this.setLawsysno(actionRequest.getFieldValue(i, "lawsysno"));
if (actionRequest.getFieldValue(i, "itemcode") != null) 
this.setItemcode(actionRequest.getFieldValue(i, "itemcode"));
if (actionRequest.getFieldValue(i, "itemcontent") != null) 
this.setItemcontent(actionRequest.getFieldValue(i, "itemcontent"));
if (actionRequest.getFieldValue(i, "duties") != null) 
this.setDuties(actionRequest.getFieldValue(i, "duties"));
if (actionRequest.getFieldValue(i, "fill1") != null) 
this.setFill1(actionRequest.getFieldValue(i, "fill1"));
if (actionRequest.getFieldValue(i, "fill2") != null) 
this.setFill2(actionRequest.getFieldValue(i, "fill2"));
if (actionRequest.getFieldValue(i, "fill3") != null) 
this.setFill3(actionRequest.getFieldValue(i, "fill3"));
if (actionRequest.getFieldValue(i, "fill4") != null) 
this.setFill4(actionRequest.getFieldValue(i, "fill4"));
if (actionRequest.getFieldValue(i, "fill5") != null) 
this.setFill5(actionRequest.getFieldValue(i, "fill5"));
if (actionRequest.getFieldValue(i, "fill6") != null) 
this.setFill6(actionRequest.getFieldValue(i, "fill6"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { BasiclawsdtlBean obj = (BasiclawsdtlBean)super.clone();obj.setLawsysno(obj.lawsysno);
obj.setItemcode(obj.itemcode);
obj.setItemcontent(obj.itemcontent);
obj.setDuties(obj.duties);
obj.setFill1(obj.fill1);
obj.setFill2(obj.fill2);
obj.setFill3(obj.fill3);
obj.setFill4(obj.fill4);
obj.setFill5(obj.fill5);
obj.setFill6(obj.fill6);
return obj;}}