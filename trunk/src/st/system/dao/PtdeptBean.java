package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtdeptBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtdeptBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtdeptBean().findAndLockByWhere(sSqlWhere);      }       public static PtdeptBean findFirst(String sSqlWhere)throws Exception {           return (PtdeptBean)new PtdeptBean().findFirstByWhere(sSqlWhere);      }       public static PtdeptBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtdeptBean)new PtdeptBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtdeptBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtdeptBean bean = new PtdeptBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtdeptBean bean = new PtdeptBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtdeptBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtdeptBean bean = new PtdeptBean();           bean.setAutoRelease(isAutoRelease);           return (PtdeptBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtdeptBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtdeptBean bean = new PtdeptBean();           bean.setAutoRelease(isAutoRelease);           return (PtdeptBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtdeptBean bean = new PtdeptBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  deptno; //机构编号 
String  deptnm; //机构名称 
String  deptlvl; //机构级别 
String  distcode; //地区编号 
String  createdt; //创建时间 
String  normalpeos; //正常人数 
String  realpeos; //实际人数 
String  managernm; //管理人员名称 
String  parentdeptid; //上级部门编号 
String  deptaddr; //部门地址 
String  deptinfo; //部门信息 
String  descname; //描述名称 
String  bmjc; //部门简称 
String  bmzt; //部门状态 
public static final String TABLENAME ="ptdept";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtdeptBean abb = new PtdeptBean();
abb.deptno=rs.getString("deptno");
abb.setKeyValue("DEPTNO","" + abb.getDeptno());
abb.deptnm=rs.getString("deptnm");
abb.setKeyValue("DEPTNM","" + abb.getDeptnm());
abb.deptlvl=rs.getString("deptlvl");
abb.setKeyValue("DEPTLVL","" + abb.getDeptlvl());
abb.distcode=rs.getString("distcode");
abb.setKeyValue("DISTCODE","" + abb.getDistcode());
abb.createdt=rs.getString("createdt");
abb.setKeyValue("CREATEDT","" + abb.getCreatedt());
abb.normalpeos=rs.getString("normalpeos");
abb.setKeyValue("NORMALPEOS","" + abb.getNormalpeos());
abb.realpeos=rs.getString("realpeos");
abb.setKeyValue("REALPEOS","" + abb.getRealpeos());
abb.managernm=rs.getString("managernm");
abb.setKeyValue("MANAGERNM","" + abb.getManagernm());
abb.parentdeptid=rs.getString("parentdeptid");
abb.setKeyValue("PARENTDEPTID","" + abb.getParentdeptid());
abb.deptaddr=rs.getString("deptaddr");
abb.setKeyValue("DEPTADDR","" + abb.getDeptaddr());
abb.deptinfo=rs.getString("deptinfo");
abb.setKeyValue("DEPTINFO","" + abb.getDeptinfo());
abb.descname=rs.getString("descname");
abb.setKeyValue("DESCNAME","" + abb.getDescname());
abb.bmjc=rs.getString("bmjc");
abb.setKeyValue("BMJC","" + abb.getBmjc());
abb.bmzt=rs.getString("bmzt");
abb.setKeyValue("BMZT","" + abb.getBmzt());
list.add(abb);
abb.operate_mode = "edit";
}public String getDeptno(){ if ( this.deptno == null){ return ""; } else {return this.deptno;}}public String getDeptnm(){ if ( this.deptnm == null){ return ""; } else {return this.deptnm;}}public String getDeptlvl(){ if ( this.deptlvl == null){ return ""; } else {return this.deptlvl;}}public String getDistcode(){ if ( this.distcode == null){ return ""; } else {return this.distcode;}}public String getCreatedt(){ if ( this.createdt == null){ return ""; } else {return this.createdt;}}public String getNormalpeos(){ if ( this.normalpeos == null){ return ""; } else {return this.normalpeos;}}public String getRealpeos(){ if ( this.realpeos == null){ return ""; } else {return this.realpeos;}}public String getManagernm(){ if ( this.managernm == null){ return ""; } else {return this.managernm;}}public String getParentdeptid(){ if ( this.parentdeptid == null){ return ""; } else {return this.parentdeptid;}}public String getDeptaddr(){ if ( this.deptaddr == null){ return ""; } else {return this.deptaddr;}}public String getDeptinfo(){ if ( this.deptinfo == null){ return ""; } else {return this.deptinfo;}}public String getDescname(){ if ( this.descname == null){ return ""; } else {return this.descname;}}public String getBmjc(){ if ( this.bmjc == null){ return ""; } else {return this.bmjc;}}public String getBmzt(){ if ( this.bmzt == null){ return ""; } else {return this.bmzt;}}public void setDeptno( String deptno){sqlMaker.setField("deptno",deptno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptno().equals(deptno))
cf.add("deptno",this.deptno,deptno);
}
this.deptno=deptno;
}
public void setDeptnm( String deptnm){sqlMaker.setField("deptnm",deptnm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptnm().equals(deptnm))
cf.add("deptnm",this.deptnm,deptnm);
}
this.deptnm=deptnm;
}
public void setDeptlvl( String deptlvl){sqlMaker.setField("deptlvl",deptlvl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptlvl().equals(deptlvl))
cf.add("deptlvl",this.deptlvl,deptlvl);
}
this.deptlvl=deptlvl;
}
public void setDistcode( String distcode){sqlMaker.setField("distcode",distcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDistcode().equals(distcode))
cf.add("distcode",this.distcode,distcode);
}
this.distcode=distcode;
}
public void setCreatedt( String createdt){sqlMaker.setField("createdt",createdt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCreatedt().equals(createdt))
cf.add("createdt",this.createdt,createdt);
}
this.createdt=createdt;
}
public void setNormalpeos( String normalpeos){sqlMaker.setField("normalpeos",normalpeos,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNormalpeos().equals(normalpeos))
cf.add("normalpeos",this.normalpeos,normalpeos);
}
this.normalpeos=normalpeos;
}
public void setRealpeos( String realpeos){sqlMaker.setField("realpeos",realpeos,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRealpeos().equals(realpeos))
cf.add("realpeos",this.realpeos,realpeos);
}
this.realpeos=realpeos;
}
public void setManagernm( String managernm){sqlMaker.setField("managernm",managernm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getManagernm().equals(managernm))
cf.add("managernm",this.managernm,managernm);
}
this.managernm=managernm;
}
public void setParentdeptid( String parentdeptid){sqlMaker.setField("parentdeptid",parentdeptid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParentdeptid().equals(parentdeptid))
cf.add("parentdeptid",this.parentdeptid,parentdeptid);
}
this.parentdeptid=parentdeptid;
}
public void setDeptaddr( String deptaddr){sqlMaker.setField("deptaddr",deptaddr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptaddr().equals(deptaddr))
cf.add("deptaddr",this.deptaddr,deptaddr);
}
this.deptaddr=deptaddr;
}
public void setDeptinfo( String deptinfo){sqlMaker.setField("deptinfo",deptinfo,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptinfo().equals(deptinfo))
cf.add("deptinfo",this.deptinfo,deptinfo);
}
this.deptinfo=deptinfo;
}
public void setDescname( String descname){sqlMaker.setField("descname",descname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDescname().equals(descname))
cf.add("descname",this.descname,descname);
}
this.descname=descname;
}
public void setBmjc( String bmjc){sqlMaker.setField("bmjc",bmjc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBmjc().equals(bmjc))
cf.add("bmjc",this.bmjc,bmjc);
}
this.bmjc=bmjc;
}
public void setBmzt( String bmzt){sqlMaker.setField("bmzt",bmzt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBmzt().equals(bmzt))
cf.add("bmzt",this.bmzt,bmzt);
}
this.bmzt=bmzt;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "deptno") != null) 
this.setDeptno(actionRequest.getFieldValue(i, "deptno"));
if (actionRequest.getFieldValue(i, "deptnm") != null) 
this.setDeptnm(actionRequest.getFieldValue(i, "deptnm"));
if (actionRequest.getFieldValue(i, "deptlvl") != null) 
this.setDeptlvl(actionRequest.getFieldValue(i, "deptlvl"));
if (actionRequest.getFieldValue(i, "distcode") != null) 
this.setDistcode(actionRequest.getFieldValue(i, "distcode"));
if (actionRequest.getFieldValue(i, "createdt") != null) 
this.setCreatedt(actionRequest.getFieldValue(i, "createdt"));
if (actionRequest.getFieldValue(i, "normalpeos") != null) 
this.setNormalpeos(actionRequest.getFieldValue(i, "normalpeos"));
if (actionRequest.getFieldValue(i, "realpeos") != null) 
this.setRealpeos(actionRequest.getFieldValue(i, "realpeos"));
if (actionRequest.getFieldValue(i, "managernm") != null) 
this.setManagernm(actionRequest.getFieldValue(i, "managernm"));
if (actionRequest.getFieldValue(i, "parentdeptid") != null) 
this.setParentdeptid(actionRequest.getFieldValue(i, "parentdeptid"));
if (actionRequest.getFieldValue(i, "deptaddr") != null) 
this.setDeptaddr(actionRequest.getFieldValue(i, "deptaddr"));
if (actionRequest.getFieldValue(i, "deptinfo") != null) 
this.setDeptinfo(actionRequest.getFieldValue(i, "deptinfo"));
if (actionRequest.getFieldValue(i, "descname") != null) 
this.setDescname(actionRequest.getFieldValue(i, "descname"));
if (actionRequest.getFieldValue(i, "bmjc") != null) 
this.setBmjc(actionRequest.getFieldValue(i, "bmjc"));
if (actionRequest.getFieldValue(i, "bmzt") != null) 
this.setBmzt(actionRequest.getFieldValue(i, "bmzt"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtdeptBean obj = (PtdeptBean)super.clone();obj.setDeptno(obj.deptno);
obj.setDeptnm(obj.deptnm);
obj.setDeptlvl(obj.deptlvl);
obj.setDistcode(obj.distcode);
obj.setCreatedt(obj.createdt);
obj.setNormalpeos(obj.normalpeos);
obj.setRealpeos(obj.realpeos);
obj.setManagernm(obj.managernm);
obj.setParentdeptid(obj.parentdeptid);
obj.setDeptaddr(obj.deptaddr);
obj.setDeptinfo(obj.deptinfo);
obj.setDescname(obj.descname);
obj.setBmjc(obj.bmjc);
obj.setBmzt(obj.bmzt);
return obj;}}