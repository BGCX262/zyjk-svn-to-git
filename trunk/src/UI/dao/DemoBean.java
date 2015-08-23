package UI.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class DemoBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new DemoBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new DemoBean().findAndLockByWhere(sSqlWhere);      }       public static DemoBean findFirst(String sSqlWhere)throws Exception {           return (DemoBean)new DemoBean().findFirstByWhere(sSqlWhere);      }       public static DemoBean findFirstAndLock(String sSqlWhere)throws Exception {           return (DemoBean)new DemoBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new DemoBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           DemoBean bean = new DemoBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           DemoBean bean = new DemoBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static DemoBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           DemoBean bean = new DemoBean();           bean.setAutoRelease(isAutoRelease);           return (DemoBean)bean.findFirstByWhere(sSqlWhere);      }       public static DemoBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           DemoBean bean = new DemoBean();           bean.setAutoRelease(isAutoRelease);           return (DemoBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           DemoBean bean = new DemoBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  customerid; //主键 
String  companyname; //公司名 
String  contactname; //联系名 
String  contacttitle; //职务 
String  address; //地址 
String  city; //城市 
String  region; //地区 
String  postalcode; //邮编 
String  country; //国家 
String  phone; //电话 
String  fax; //传真 
public static final String TABLENAME ="demo";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
DemoBean abb = new DemoBean();
abb.customerid=rs.getString("customerid");
abb.setKeyValue("CUSTOMERID","" + abb.getCustomerid());
abb.companyname=rs.getString("companyname");
abb.setKeyValue("COMPANYNAME","" + abb.getCompanyname());
abb.contactname=rs.getString("contactname");
abb.setKeyValue("CONTACTNAME","" + abb.getContactname());
abb.contacttitle=rs.getString("contacttitle");
abb.setKeyValue("CONTACTTITLE","" + abb.getContacttitle());
abb.address=rs.getString("address");
abb.setKeyValue("ADDRESS","" + abb.getAddress());
abb.city=rs.getString("city");
abb.setKeyValue("CITY","" + abb.getCity());
abb.region=rs.getString("region");
abb.setKeyValue("REGION","" + abb.getRegion());
abb.postalcode=rs.getString("postalcode");
abb.setKeyValue("POSTALCODE","" + abb.getPostalcode());
abb.country=rs.getString("country");
abb.setKeyValue("COUNTRY","" + abb.getCountry());
abb.phone=rs.getString("phone");
abb.setKeyValue("PHONE","" + abb.getPhone());
abb.fax=rs.getString("fax");
abb.setKeyValue("FAX","" + abb.getFax());
list.add(abb);
abb.operate_mode = "edit";
}public String getCustomerid(){ if ( this.customerid == null){ return ""; } else {return this.customerid;}}public String getCompanyname(){ if ( this.companyname == null){ return ""; } else {return this.companyname;}}public String getContactname(){ if ( this.contactname == null){ return ""; } else {return this.contactname;}}public String getContacttitle(){ if ( this.contacttitle == null){ return ""; } else {return this.contacttitle;}}public String getAddress(){ if ( this.address == null){ return ""; } else {return this.address;}}public String getCity(){ if ( this.city == null){ return ""; } else {return this.city;}}public String getRegion(){ if ( this.region == null){ return ""; } else {return this.region;}}public String getPostalcode(){ if ( this.postalcode == null){ return ""; } else {return this.postalcode;}}public String getCountry(){ if ( this.country == null){ return ""; } else {return this.country;}}public String getPhone(){ if ( this.phone == null){ return ""; } else {return this.phone;}}public String getFax(){ if ( this.fax == null){ return ""; } else {return this.fax;}}public void setCustomerid( String customerid){sqlMaker.setField("customerid",customerid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCustomerid().equals(customerid))
cf.add("customerid",this.customerid,customerid);
}
this.customerid=customerid;
}
public void setCompanyname( String companyname){sqlMaker.setField("companyname",companyname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCompanyname().equals(companyname))
cf.add("companyname",this.companyname,companyname);
}
this.companyname=companyname;
}
public void setContactname( String contactname){sqlMaker.setField("contactname",contactname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getContactname().equals(contactname))
cf.add("contactname",this.contactname,contactname);
}
this.contactname=contactname;
}
public void setContacttitle( String contacttitle){sqlMaker.setField("contacttitle",contacttitle,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getContacttitle().equals(contacttitle))
cf.add("contacttitle",this.contacttitle,contacttitle);
}
this.contacttitle=contacttitle;
}
public void setAddress( String address){sqlMaker.setField("address",address,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getAddress().equals(address))
cf.add("address",this.address,address);
}
this.address=address;
}
public void setCity( String city){sqlMaker.setField("city",city,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCity().equals(city))
cf.add("city",this.city,city);
}
this.city=city;
}
public void setRegion( String region){sqlMaker.setField("region",region,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRegion().equals(region))
cf.add("region",this.region,region);
}
this.region=region;
}
public void setPostalcode( String postalcode){sqlMaker.setField("postalcode",postalcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPostalcode().equals(postalcode))
cf.add("postalcode",this.postalcode,postalcode);
}
this.postalcode=postalcode;
}
public void setCountry( String country){sqlMaker.setField("country",country,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCountry().equals(country))
cf.add("country",this.country,country);
}
this.country=country;
}
public void setPhone( String phone){sqlMaker.setField("phone",phone,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPhone().equals(phone))
cf.add("phone",this.phone,phone);
}
this.phone=phone;
}
public void setFax( String fax){sqlMaker.setField("fax",fax,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFax().equals(fax))
cf.add("fax",this.fax,fax);
}
this.fax=fax;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "customerid") != null) 
this.setCustomerid(actionRequest.getFieldValue(i, "customerid"));
if (actionRequest.getFieldValue(i, "companyname") != null) 
this.setCompanyname(actionRequest.getFieldValue(i, "companyname"));
if (actionRequest.getFieldValue(i, "contactname") != null) 
this.setContactname(actionRequest.getFieldValue(i, "contactname"));
if (actionRequest.getFieldValue(i, "contacttitle") != null) 
this.setContacttitle(actionRequest.getFieldValue(i, "contacttitle"));
if (actionRequest.getFieldValue(i, "address") != null) 
this.setAddress(actionRequest.getFieldValue(i, "address"));
if (actionRequest.getFieldValue(i, "city") != null) 
this.setCity(actionRequest.getFieldValue(i, "city"));
if (actionRequest.getFieldValue(i, "region") != null) 
this.setRegion(actionRequest.getFieldValue(i, "region"));
if (actionRequest.getFieldValue(i, "postalcode") != null) 
this.setPostalcode(actionRequest.getFieldValue(i, "postalcode"));
if (actionRequest.getFieldValue(i, "country") != null) 
this.setCountry(actionRequest.getFieldValue(i, "country"));
if (actionRequest.getFieldValue(i, "phone") != null) 
this.setPhone(actionRequest.getFieldValue(i, "phone"));
if (actionRequest.getFieldValue(i, "fax") != null) 
this.setFax(actionRequest.getFieldValue(i, "fax"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { DemoBean obj = (DemoBean)super.clone();obj.setCustomerid(obj.customerid);
obj.setCompanyname(obj.companyname);
obj.setContactname(obj.contactname);
obj.setContacttitle(obj.contacttitle);
obj.setAddress(obj.address);
obj.setCity(obj.city);
obj.setRegion(obj.region);
obj.setPostalcode(obj.postalcode);
obj.setCountry(obj.country);
obj.setPhone(obj.phone);
obj.setFax(obj.fax);
return obj;}}