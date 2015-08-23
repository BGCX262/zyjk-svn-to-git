package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class OrganizationBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new OrganizationBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new OrganizationBean().findAndLockByWhere(sSqlWhere);      }       public static OrganizationBean findFirst(String sSqlWhere)throws Exception {           return (OrganizationBean)new OrganizationBean().findFirstByWhere(sSqlWhere);      }       public static OrganizationBean findFirstAndLock(String sSqlWhere)throws Exception {           return (OrganizationBean)new OrganizationBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new OrganizationBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           OrganizationBean bean = new OrganizationBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           OrganizationBean bean = new OrganizationBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static OrganizationBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           OrganizationBean bean = new OrganizationBean();           bean.setAutoRelease(isAutoRelease);           return (OrganizationBean)bean.findFirstByWhere(sSqlWhere);      }       public static OrganizationBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           OrganizationBean bean = new OrganizationBean();           bean.setAutoRelease(isAutoRelease);           return (OrganizationBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           OrganizationBean bean = new OrganizationBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  guid;
String  userguid;
String  groupguid;
String  name;
String  upguid;
String  type;
String  depth;
String  ordernum;
String  isupinformationnode;
String  code;
String  mapname;
String  parentguids;
String  adminguids;
String  adminnames;
String  parentnames;
String  xzwgbm;
String  zyfzr;
String  zyfzrguid;
String  fgfzr;
String  fgfzrguid;
String  firstnodecode;
String  secondnodecode;
String  thirdnodecode;
String  fourthnodecode;
public static final String TABLENAME ="organization";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
OrganizationBean abb = new OrganizationBean();
abb.guid=rs.getString("guid");
abb.setKeyValue("GUID","" + abb.getGuid());
abb.userguid=rs.getString("userguid");
abb.setKeyValue("USERGUID","" + abb.getUserguid());
abb.groupguid=rs.getString("groupguid");
abb.setKeyValue("GROUPGUID","" + abb.getGroupguid());
abb.name=rs.getString("name");
abb.setKeyValue("NAME","" + abb.getName());
abb.upguid=rs.getString("upguid");
abb.setKeyValue("UPGUID","" + abb.getUpguid());
abb.type=rs.getString("type");
abb.setKeyValue("TYPE","" + abb.getType());
abb.depth=rs.getString("depth");
abb.setKeyValue("DEPTH","" + abb.getDepth());
abb.ordernum=rs.getString("ordernum");
abb.setKeyValue("ORDERNUM","" + abb.getOrdernum());
abb.isupinformationnode=rs.getString("isupinformationnode");
abb.setKeyValue("ISUPINFORMATIONNODE","" + abb.getIsupinformationnode());
abb.code=rs.getString("code");
abb.setKeyValue("CODE","" + abb.getCode());
abb.mapname=rs.getString("mapname");
abb.setKeyValue("MAPNAME","" + abb.getMapname());
abb.parentguids=rs.getString("parentguids");
abb.setKeyValue("PARENTGUIDS","" + abb.getParentguids());
abb.adminguids=rs.getString("adminguids");
abb.setKeyValue("ADMINGUIDS","" + abb.getAdminguids());
abb.adminnames=rs.getString("adminnames");
abb.setKeyValue("ADMINNAMES","" + abb.getAdminnames());
abb.parentnames=rs.getString("parentnames");
abb.setKeyValue("PARENTNAMES","" + abb.getParentnames());
abb.xzwgbm=rs.getString("xzwgbm");
abb.setKeyValue("XZWGBM","" + abb.getXzwgbm());
abb.zyfzr=rs.getString("zyfzr");
abb.setKeyValue("ZYFZR","" + abb.getZyfzr());
abb.zyfzrguid=rs.getString("zyfzrguid");
abb.setKeyValue("ZYFZRGUID","" + abb.getZyfzrguid());
abb.fgfzr=rs.getString("fgfzr");
abb.setKeyValue("FGFZR","" + abb.getFgfzr());
abb.fgfzrguid=rs.getString("fgfzrguid");
abb.setKeyValue("FGFZRGUID","" + abb.getFgfzrguid());
abb.firstnodecode=rs.getString("firstnodecode");
abb.setKeyValue("FIRSTNODECODE","" + abb.getFirstnodecode());
abb.secondnodecode=rs.getString("secondnodecode");
abb.setKeyValue("SECONDNODECODE","" + abb.getSecondnodecode());
abb.thirdnodecode=rs.getString("thirdnodecode");
abb.setKeyValue("THIRDNODECODE","" + abb.getThirdnodecode());
abb.fourthnodecode=rs.getString("fourthnodecode");
abb.setKeyValue("FOURTHNODECODE","" + abb.getFourthnodecode());
list.add(abb);
abb.operate_mode = "edit";
}public String getGuid(){ if ( this.guid == null){ return ""; } else {return this.guid;}}public String getUserguid(){ if ( this.userguid == null){ return ""; } else {return this.userguid;}}public String getGroupguid(){ if ( this.groupguid == null){ return ""; } else {return this.groupguid;}}public String getName(){ if ( this.name == null){ return ""; } else {return this.name;}}public String getUpguid(){ if ( this.upguid == null){ return ""; } else {return this.upguid;}}public String getType(){ if ( this.type == null){ return ""; } else {return this.type;}}public String getDepth(){ if ( this.depth == null){ return ""; } else {return this.depth;}}public String getOrdernum(){ if ( this.ordernum == null){ return ""; } else {return this.ordernum;}}public String getIsupinformationnode(){ if ( this.isupinformationnode == null){ return ""; } else {return this.isupinformationnode;}}public String getCode(){ if ( this.code == null){ return ""; } else {return this.code;}}public String getMapname(){ if ( this.mapname == null){ return ""; } else {return this.mapname;}}public String getParentguids(){ if ( this.parentguids == null){ return ""; } else {return this.parentguids;}}public String getAdminguids(){ if ( this.adminguids == null){ return ""; } else {return this.adminguids;}}public String getAdminnames(){ if ( this.adminnames == null){ return ""; } else {return this.adminnames;}}public String getParentnames(){ if ( this.parentnames == null){ return ""; } else {return this.parentnames;}}public String getXzwgbm(){ if ( this.xzwgbm == null){ return ""; } else {return this.xzwgbm;}}public String getZyfzr(){ if ( this.zyfzr == null){ return ""; } else {return this.zyfzr;}}public String getZyfzrguid(){ if ( this.zyfzrguid == null){ return ""; } else {return this.zyfzrguid;}}public String getFgfzr(){ if ( this.fgfzr == null){ return ""; } else {return this.fgfzr;}}public String getFgfzrguid(){ if ( this.fgfzrguid == null){ return ""; } else {return this.fgfzrguid;}}public String getFirstnodecode(){ if ( this.firstnodecode == null){ return ""; } else {return this.firstnodecode;}}public String getSecondnodecode(){ if ( this.secondnodecode == null){ return ""; } else {return this.secondnodecode;}}public String getThirdnodecode(){ if ( this.thirdnodecode == null){ return ""; } else {return this.thirdnodecode;}}public String getFourthnodecode(){ if ( this.fourthnodecode == null){ return ""; } else {return this.fourthnodecode;}}public void setGuid( String guid){sqlMaker.setField("guid",guid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGuid().equals(guid))
cf.add("guid",this.guid,guid);
}
this.guid=guid;
}
public void setUserguid( String userguid){sqlMaker.setField("userguid",userguid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getUserguid().equals(userguid))
cf.add("userguid",this.userguid,userguid);
}
this.userguid=userguid;
}
public void setGroupguid( String groupguid){sqlMaker.setField("groupguid",groupguid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGroupguid().equals(groupguid))
cf.add("groupguid",this.groupguid,groupguid);
}
this.groupguid=groupguid;
}
public void setName( String name){sqlMaker.setField("name",name,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getName().equals(name))
cf.add("name",this.name,name);
}
this.name=name;
}
public void setUpguid( String upguid){sqlMaker.setField("upguid",upguid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getUpguid().equals(upguid))
cf.add("upguid",this.upguid,upguid);
}
this.upguid=upguid;
}
public void setType( String type){sqlMaker.setField("type",type,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getType().equals(type))
cf.add("type",this.type,type);
}
this.type=type;
}
public void setDepth( String depth){sqlMaker.setField("depth",depth,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDepth().equals(depth))
cf.add("depth",this.depth,depth);
}
this.depth=depth;
}
public void setOrdernum( String ordernum){sqlMaker.setField("ordernum",ordernum,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOrdernum().equals(ordernum))
cf.add("ordernum",this.ordernum,ordernum);
}
this.ordernum=ordernum;
}
public void setIsupinformationnode( String isupinformationnode){sqlMaker.setField("isupinformationnode",isupinformationnode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsupinformationnode().equals(isupinformationnode))
cf.add("isupinformationnode",this.isupinformationnode,isupinformationnode);
}
this.isupinformationnode=isupinformationnode;
}
public void setCode( String code){sqlMaker.setField("code",code,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCode().equals(code))
cf.add("code",this.code,code);
}
this.code=code;
}
public void setMapname( String mapname){sqlMaker.setField("mapname",mapname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMapname().equals(mapname))
cf.add("mapname",this.mapname,mapname);
}
this.mapname=mapname;
}
public void setParentguids( String parentguids){sqlMaker.setField("parentguids",parentguids,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParentguids().equals(parentguids))
cf.add("parentguids",this.parentguids,parentguids);
}
this.parentguids=parentguids;
}
public void setAdminguids( String adminguids){sqlMaker.setField("adminguids",adminguids,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getAdminguids().equals(adminguids))
cf.add("adminguids",this.adminguids,adminguids);
}
this.adminguids=adminguids;
}
public void setAdminnames( String adminnames){sqlMaker.setField("adminnames",adminnames,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getAdminnames().equals(adminnames))
cf.add("adminnames",this.adminnames,adminnames);
}
this.adminnames=adminnames;
}
public void setParentnames( String parentnames){sqlMaker.setField("parentnames",parentnames,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParentnames().equals(parentnames))
cf.add("parentnames",this.parentnames,parentnames);
}
this.parentnames=parentnames;
}
public void setXzwgbm( String xzwgbm){sqlMaker.setField("xzwgbm",xzwgbm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXzwgbm().equals(xzwgbm))
cf.add("xzwgbm",this.xzwgbm,xzwgbm);
}
this.xzwgbm=xzwgbm;
}
public void setZyfzr( String zyfzr){sqlMaker.setField("zyfzr",zyfzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZyfzr().equals(zyfzr))
cf.add("zyfzr",this.zyfzr,zyfzr);
}
this.zyfzr=zyfzr;
}
public void setZyfzrguid( String zyfzrguid){sqlMaker.setField("zyfzrguid",zyfzrguid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZyfzrguid().equals(zyfzrguid))
cf.add("zyfzrguid",this.zyfzrguid,zyfzrguid);
}
this.zyfzrguid=zyfzrguid;
}
public void setFgfzr( String fgfzr){sqlMaker.setField("fgfzr",fgfzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFgfzr().equals(fgfzr))
cf.add("fgfzr",this.fgfzr,fgfzr);
}
this.fgfzr=fgfzr;
}
public void setFgfzrguid( String fgfzrguid){sqlMaker.setField("fgfzrguid",fgfzrguid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFgfzrguid().equals(fgfzrguid))
cf.add("fgfzrguid",this.fgfzrguid,fgfzrguid);
}
this.fgfzrguid=fgfzrguid;
}
public void setFirstnodecode( String firstnodecode){sqlMaker.setField("firstnodecode",firstnodecode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFirstnodecode().equals(firstnodecode))
cf.add("firstnodecode",this.firstnodecode,firstnodecode);
}
this.firstnodecode=firstnodecode;
}
public void setSecondnodecode( String secondnodecode){sqlMaker.setField("secondnodecode",secondnodecode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSecondnodecode().equals(secondnodecode))
cf.add("secondnodecode",this.secondnodecode,secondnodecode);
}
this.secondnodecode=secondnodecode;
}
public void setThirdnodecode( String thirdnodecode){sqlMaker.setField("thirdnodecode",thirdnodecode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getThirdnodecode().equals(thirdnodecode))
cf.add("thirdnodecode",this.thirdnodecode,thirdnodecode);
}
this.thirdnodecode=thirdnodecode;
}
public void setFourthnodecode( String fourthnodecode){sqlMaker.setField("fourthnodecode",fourthnodecode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFourthnodecode().equals(fourthnodecode))
cf.add("fourthnodecode",this.fourthnodecode,fourthnodecode);
}
this.fourthnodecode=fourthnodecode;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "guid") != null) 
this.setGuid(actionRequest.getFieldValue(i, "guid"));
if (actionRequest.getFieldValue(i, "userguid") != null) 
this.setUserguid(actionRequest.getFieldValue(i, "userguid"));
if (actionRequest.getFieldValue(i, "groupguid") != null) 
this.setGroupguid(actionRequest.getFieldValue(i, "groupguid"));
if (actionRequest.getFieldValue(i, "name") != null) 
this.setName(actionRequest.getFieldValue(i, "name"));
if (actionRequest.getFieldValue(i, "upguid") != null) 
this.setUpguid(actionRequest.getFieldValue(i, "upguid"));
if (actionRequest.getFieldValue(i, "type") != null) 
this.setType(actionRequest.getFieldValue(i, "type"));
if (actionRequest.getFieldValue(i, "depth") != null) 
this.setDepth(actionRequest.getFieldValue(i, "depth"));
if (actionRequest.getFieldValue(i, "ordernum") != null) 
this.setOrdernum(actionRequest.getFieldValue(i, "ordernum"));
if (actionRequest.getFieldValue(i, "isupinformationnode") != null) 
this.setIsupinformationnode(actionRequest.getFieldValue(i, "isupinformationnode"));
if (actionRequest.getFieldValue(i, "code") != null) 
this.setCode(actionRequest.getFieldValue(i, "code"));
if (actionRequest.getFieldValue(i, "mapname") != null) 
this.setMapname(actionRequest.getFieldValue(i, "mapname"));
if (actionRequest.getFieldValue(i, "parentguids") != null) 
this.setParentguids(actionRequest.getFieldValue(i, "parentguids"));
if (actionRequest.getFieldValue(i, "adminguids") != null) 
this.setAdminguids(actionRequest.getFieldValue(i, "adminguids"));
if (actionRequest.getFieldValue(i, "adminnames") != null) 
this.setAdminnames(actionRequest.getFieldValue(i, "adminnames"));
if (actionRequest.getFieldValue(i, "parentnames") != null) 
this.setParentnames(actionRequest.getFieldValue(i, "parentnames"));
if (actionRequest.getFieldValue(i, "xzwgbm") != null) 
this.setXzwgbm(actionRequest.getFieldValue(i, "xzwgbm"));
if (actionRequest.getFieldValue(i, "zyfzr") != null) 
this.setZyfzr(actionRequest.getFieldValue(i, "zyfzr"));
if (actionRequest.getFieldValue(i, "zyfzrguid") != null) 
this.setZyfzrguid(actionRequest.getFieldValue(i, "zyfzrguid"));
if (actionRequest.getFieldValue(i, "fgfzr") != null) 
this.setFgfzr(actionRequest.getFieldValue(i, "fgfzr"));
if (actionRequest.getFieldValue(i, "fgfzrguid") != null) 
this.setFgfzrguid(actionRequest.getFieldValue(i, "fgfzrguid"));
if (actionRequest.getFieldValue(i, "firstnodecode") != null) 
this.setFirstnodecode(actionRequest.getFieldValue(i, "firstnodecode"));
if (actionRequest.getFieldValue(i, "secondnodecode") != null) 
this.setSecondnodecode(actionRequest.getFieldValue(i, "secondnodecode"));
if (actionRequest.getFieldValue(i, "thirdnodecode") != null) 
this.setThirdnodecode(actionRequest.getFieldValue(i, "thirdnodecode"));
if (actionRequest.getFieldValue(i, "fourthnodecode") != null) 
this.setFourthnodecode(actionRequest.getFieldValue(i, "fourthnodecode"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { OrganizationBean obj = (OrganizationBean)super.clone();obj.setGuid(obj.guid);
obj.setUserguid(obj.userguid);
obj.setGroupguid(obj.groupguid);
obj.setName(obj.name);
obj.setUpguid(obj.upguid);
obj.setType(obj.type);
obj.setDepth(obj.depth);
obj.setOrdernum(obj.ordernum);
obj.setIsupinformationnode(obj.isupinformationnode);
obj.setCode(obj.code);
obj.setMapname(obj.mapname);
obj.setParentguids(obj.parentguids);
obj.setAdminguids(obj.adminguids);
obj.setAdminnames(obj.adminnames);
obj.setParentnames(obj.parentnames);
obj.setXzwgbm(obj.xzwgbm);
obj.setZyfzr(obj.zyfzr);
obj.setZyfzrguid(obj.zyfzrguid);
obj.setFgfzr(obj.fgfzr);
obj.setFgfzrguid(obj.fgfzrguid);
obj.setFirstnodecode(obj.firstnodecode);
obj.setSecondnodecode(obj.secondnodecode);
obj.setThirdnodecode(obj.thirdnodecode);
obj.setFourthnodecode(obj.fourthnodecode);
return obj;}}