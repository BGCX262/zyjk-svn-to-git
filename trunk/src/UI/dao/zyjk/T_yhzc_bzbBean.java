package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class T_yhzc_bzbBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new T_yhzc_bzbBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new T_yhzc_bzbBean().findAndLockByWhere(sSqlWhere);      }       public static T_yhzc_bzbBean findFirst(String sSqlWhere)throws Exception {           return (T_yhzc_bzbBean)new T_yhzc_bzbBean().findFirstByWhere(sSqlWhere);      }       public static T_yhzc_bzbBean findFirstAndLock(String sSqlWhere)throws Exception {           return (T_yhzc_bzbBean)new T_yhzc_bzbBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new T_yhzc_bzbBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_yhzc_bzbBean bean = new T_yhzc_bzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           T_yhzc_bzbBean bean = new T_yhzc_bzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static T_yhzc_bzbBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_yhzc_bzbBean bean = new T_yhzc_bzbBean();           bean.setAutoRelease(isAutoRelease);           return (T_yhzc_bzbBean)bean.findFirstByWhere(sSqlWhere);      }       public static T_yhzc_bzbBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           T_yhzc_bzbBean bean = new T_yhzc_bzbBean();           bean.setAutoRelease(isAutoRelease);           return (T_yhzc_bzbBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_yhzc_bzbBean bean = new T_yhzc_bzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  id;
String  zbid;
String  type;
String  bzmc;
String  parentid;
String  sxh;
String  level;
String  isimport;
String  isleaf;
String  ckyjid;
String  ckyjby;
String  hybmid;
String  ckyj;
String  allparentid;
String  isdel;
String  czzt;
String  ver;
String  jcqk;
String  zgzrr;
String  zgsx;
String  agwcsj;
String  sfyh;
String  sfyzg;
String  bz;
String  comment;
public static final String TABLENAME ="t_yhzc_bzb";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
T_yhzc_bzbBean abb = new T_yhzc_bzbBean();
abb.id=rs.getString("id");
abb.setKeyValue("ID","" + abb.getId());
abb.zbid=rs.getString("zbid");
abb.setKeyValue("ZBID","" + abb.getZbid());
abb.type=rs.getString("type");
abb.setKeyValue("TYPE","" + abb.getType());
abb.bzmc=rs.getString("bzmc");
abb.setKeyValue("BZMC","" + abb.getBzmc());
abb.parentid=rs.getString("parentid");
abb.setKeyValue("PARENTID","" + abb.getParentid());
abb.sxh=rs.getString("sxh");
abb.setKeyValue("SXH","" + abb.getSxh());
abb.level=rs.getString("level");
abb.setKeyValue("LEVEL","" + abb.getLevel());
abb.isimport=rs.getString("isimport");
abb.setKeyValue("ISIMPORT","" + abb.getIsimport());
abb.isleaf=rs.getString("isleaf");
abb.setKeyValue("ISLEAF","" + abb.getIsleaf());
abb.ckyjid=rs.getString("ckyjid");
abb.setKeyValue("CKYJID","" + abb.getCkyjid());
abb.ckyjby=rs.getString("ckyjby");
abb.setKeyValue("CKYJBY","" + abb.getCkyjby());
abb.hybmid=rs.getString("hybmid");
abb.setKeyValue("HYBMID","" + abb.getHybmid());
abb.ckyj=rs.getString("ckyj");
abb.setKeyValue("CKYJ","" + abb.getCkyj());
abb.allparentid=rs.getString("allparentid");
abb.setKeyValue("ALLPARENTID","" + abb.getAllparentid());
abb.isdel=rs.getString("isdel");
abb.setKeyValue("ISDEL","" + abb.getIsdel());
abb.czzt=rs.getString("czzt");
abb.setKeyValue("CZZT","" + abb.getCzzt());
abb.ver=rs.getString("ver");
abb.setKeyValue("VER","" + abb.getVer());
abb.jcqk=rs.getString("jcqk");
abb.setKeyValue("JCQK","" + abb.getJcqk());
abb.zgzrr=rs.getString("zgzrr");
abb.setKeyValue("ZGZRR","" + abb.getZgzrr());
abb.zgsx=rs.getString("zgsx");
abb.setKeyValue("ZGSX","" + abb.getZgsx());
abb.agwcsj=rs.getString("agwcsj");
abb.setKeyValue("AGWCSJ","" + abb.getAgwcsj());
abb.sfyh=rs.getString("sfyh");
abb.setKeyValue("SFYH","" + abb.getSfyh());
abb.sfyzg=rs.getString("sfyzg");
abb.setKeyValue("SFYZG","" + abb.getSfyzg());
abb.bz=rs.getString("bz");
abb.setKeyValue("BZ","" + abb.getBz());
abb.comment=rs.getString("comment");
abb.setKeyValue("COMMENT","" + abb.getComment());
list.add(abb);
abb.operate_mode = "edit";
}public String getId(){ if ( this.id == null){ return ""; } else {return this.id;}}public String getZbid(){ if ( this.zbid == null){ return ""; } else {return this.zbid;}}public String getType(){ if ( this.type == null){ return ""; } else {return this.type;}}public String getBzmc(){ if ( this.bzmc == null){ return ""; } else {return this.bzmc;}}public String getParentid(){ if ( this.parentid == null){ return ""; } else {return this.parentid;}}public String getSxh(){ if ( this.sxh == null){ return ""; } else {return this.sxh;}}public String getLevel(){ if ( this.level == null){ return ""; } else {return this.level;}}public String getIsimport(){ if ( this.isimport == null){ return ""; } else {return this.isimport;}}public String getIsleaf(){ if ( this.isleaf == null){ return ""; } else {return this.isleaf;}}public String getCkyjid(){ if ( this.ckyjid == null){ return ""; } else {return this.ckyjid;}}public String getCkyjby(){ if ( this.ckyjby == null){ return ""; } else {return this.ckyjby;}}public String getHybmid(){ if ( this.hybmid == null){ return ""; } else {return this.hybmid;}}public String getCkyj(){ if ( this.ckyj == null){ return ""; } else {return this.ckyj;}}public String getAllparentid(){ if ( this.allparentid == null){ return ""; } else {return this.allparentid;}}public String getIsdel(){ if ( this.isdel == null){ return ""; } else {return this.isdel;}}public String getCzzt(){ if ( this.czzt == null){ return ""; } else {return this.czzt;}}public String getVer(){ if ( this.ver == null){ return ""; } else {return this.ver;}}public String getJcqk(){ if ( this.jcqk == null){ return ""; } else {return this.jcqk;}}public String getZgzrr(){ if ( this.zgzrr == null){ return ""; } else {return this.zgzrr;}}public String getZgsx(){ if ( this.zgsx == null){ return ""; } else {return this.zgsx;}}public String getAgwcsj(){ if ( this.agwcsj == null){ return ""; } else {return this.agwcsj;}}public String getSfyh(){ if ( this.sfyh == null){ return ""; } else {return this.sfyh;}}public String getSfyzg(){ if ( this.sfyzg == null){ return ""; } else {return this.sfyzg;}}public String getBz(){ if ( this.bz == null){ return ""; } else {return this.bz;}}public String getComment(){ if ( this.comment == null){ return ""; } else {return this.comment;}}public void setId( String id){sqlMaker.setField("id",id,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getId().equals(id))
cf.add("id",this.id,id);
}
this.id=id;
}
public void setZbid( String zbid){sqlMaker.setField("zbid",zbid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZbid().equals(zbid))
cf.add("zbid",this.zbid,zbid);
}
this.zbid=zbid;
}
public void setType( String type){sqlMaker.setField("type",type,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getType().equals(type))
cf.add("type",this.type,type);
}
this.type=type;
}
public void setBzmc( String bzmc){sqlMaker.setField("bzmc",bzmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBzmc().equals(bzmc))
cf.add("bzmc",this.bzmc,bzmc);
}
this.bzmc=bzmc;
}
public void setParentid( String parentid){sqlMaker.setField("parentid",parentid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParentid().equals(parentid))
cf.add("parentid",this.parentid,parentid);
}
this.parentid=parentid;
}
public void setSxh( String sxh){sqlMaker.setField("sxh",sxh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSxh().equals(sxh))
cf.add("sxh",this.sxh,sxh);
}
this.sxh=sxh;
}
public void setLevel( String level){sqlMaker.setField("level",level,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLevel().equals(level))
cf.add("level",this.level,level);
}
this.level=level;
}
public void setIsimport( String isimport){sqlMaker.setField("isimport",isimport,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsimport().equals(isimport))
cf.add("isimport",this.isimport,isimport);
}
this.isimport=isimport;
}
public void setIsleaf( String isleaf){sqlMaker.setField("isleaf",isleaf,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIsleaf().equals(isleaf))
cf.add("isleaf",this.isleaf,isleaf);
}
this.isleaf=isleaf;
}
public void setCkyjid( String ckyjid){sqlMaker.setField("ckyjid",ckyjid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCkyjid().equals(ckyjid))
cf.add("ckyjid",this.ckyjid,ckyjid);
}
this.ckyjid=ckyjid;
}
public void setCkyjby( String ckyjby){sqlMaker.setField("ckyjby",ckyjby,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCkyjby().equals(ckyjby))
cf.add("ckyjby",this.ckyjby,ckyjby);
}
this.ckyjby=ckyjby;
}
public void setHybmid( String hybmid){sqlMaker.setField("hybmid",hybmid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHybmid().equals(hybmid))
cf.add("hybmid",this.hybmid,hybmid);
}
this.hybmid=hybmid;
}
public void setCkyj( String ckyj){sqlMaker.setField("ckyj",ckyj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCkyj().equals(ckyj))
cf.add("ckyj",this.ckyj,ckyj);
}
this.ckyj=ckyj;
}
public void setAllparentid( String allparentid){sqlMaker.setField("allparentid",allparentid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getAllparentid().equals(allparentid))
cf.add("allparentid",this.allparentid,allparentid);
}
this.allparentid=allparentid;
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
public void setJcqk( String jcqk){sqlMaker.setField("jcqk",jcqk,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcqk().equals(jcqk))
cf.add("jcqk",this.jcqk,jcqk);
}
this.jcqk=jcqk;
}
public void setZgzrr( String zgzrr){sqlMaker.setField("zgzrr",zgzrr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZgzrr().equals(zgzrr))
cf.add("zgzrr",this.zgzrr,zgzrr);
}
this.zgzrr=zgzrr;
}
public void setZgsx( String zgsx){sqlMaker.setField("zgsx",zgsx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZgsx().equals(zgsx))
cf.add("zgsx",this.zgsx,zgsx);
}
this.zgsx=zgsx;
}
public void setAgwcsj( String agwcsj){sqlMaker.setField("agwcsj",agwcsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getAgwcsj().equals(agwcsj))
cf.add("agwcsj",this.agwcsj,agwcsj);
}
this.agwcsj=agwcsj;
}
public void setSfyh( String sfyh){sqlMaker.setField("sfyh",sfyh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfyh().equals(sfyh))
cf.add("sfyh",this.sfyh,sfyh);
}
this.sfyh=sfyh;
}
public void setSfyzg( String sfyzg){sqlMaker.setField("sfyzg",sfyzg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfyzg().equals(sfyzg))
cf.add("sfyzg",this.sfyzg,sfyzg);
}
this.sfyzg=sfyzg;
}
public void setBz( String bz){sqlMaker.setField("bz",bz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz().equals(bz))
cf.add("bz",this.bz,bz);
}
this.bz=bz;
}
public void setComment( String comment){sqlMaker.setField("comment",comment,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getComment().equals(comment))
cf.add("comment",this.comment,comment);
}
this.comment=comment;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "id") != null) 
this.setId(actionRequest.getFieldValue(i, "id"));
if (actionRequest.getFieldValue(i, "zbid") != null) 
this.setZbid(actionRequest.getFieldValue(i, "zbid"));
if (actionRequest.getFieldValue(i, "type") != null) 
this.setType(actionRequest.getFieldValue(i, "type"));
if (actionRequest.getFieldValue(i, "bzmc") != null) 
this.setBzmc(actionRequest.getFieldValue(i, "bzmc"));
if (actionRequest.getFieldValue(i, "parentid") != null) 
this.setParentid(actionRequest.getFieldValue(i, "parentid"));
if (actionRequest.getFieldValue(i, "sxh") != null) 
this.setSxh(actionRequest.getFieldValue(i, "sxh"));
if (actionRequest.getFieldValue(i, "level") != null) 
this.setLevel(actionRequest.getFieldValue(i, "level"));
if (actionRequest.getFieldValue(i, "isimport") != null) 
this.setIsimport(actionRequest.getFieldValue(i, "isimport"));
if (actionRequest.getFieldValue(i, "isleaf") != null) 
this.setIsleaf(actionRequest.getFieldValue(i, "isleaf"));
if (actionRequest.getFieldValue(i, "ckyjid") != null) 
this.setCkyjid(actionRequest.getFieldValue(i, "ckyjid"));
if (actionRequest.getFieldValue(i, "ckyjby") != null) 
this.setCkyjby(actionRequest.getFieldValue(i, "ckyjby"));
if (actionRequest.getFieldValue(i, "hybmid") != null) 
this.setHybmid(actionRequest.getFieldValue(i, "hybmid"));
if (actionRequest.getFieldValue(i, "ckyj") != null) 
this.setCkyj(actionRequest.getFieldValue(i, "ckyj"));
if (actionRequest.getFieldValue(i, "allparentid") != null) 
this.setAllparentid(actionRequest.getFieldValue(i, "allparentid"));
if (actionRequest.getFieldValue(i, "isdel") != null) 
this.setIsdel(actionRequest.getFieldValue(i, "isdel"));
if (actionRequest.getFieldValue(i, "czzt") != null) 
this.setCzzt(actionRequest.getFieldValue(i, "czzt"));
if (actionRequest.getFieldValue(i, "ver") != null) 
this.setVer(actionRequest.getFieldValue(i, "ver"));
if (actionRequest.getFieldValue(i, "jcqk") != null) 
this.setJcqk(actionRequest.getFieldValue(i, "jcqk"));
if (actionRequest.getFieldValue(i, "zgzrr") != null) 
this.setZgzrr(actionRequest.getFieldValue(i, "zgzrr"));
if (actionRequest.getFieldValue(i, "zgsx") != null) 
this.setZgsx(actionRequest.getFieldValue(i, "zgsx"));
if (actionRequest.getFieldValue(i, "agwcsj") != null) 
this.setAgwcsj(actionRequest.getFieldValue(i, "agwcsj"));
if (actionRequest.getFieldValue(i, "sfyh") != null) 
this.setSfyh(actionRequest.getFieldValue(i, "sfyh"));
if (actionRequest.getFieldValue(i, "sfyzg") != null) 
this.setSfyzg(actionRequest.getFieldValue(i, "sfyzg"));
if (actionRequest.getFieldValue(i, "bz") != null) 
this.setBz(actionRequest.getFieldValue(i, "bz"));
if (actionRequest.getFieldValue(i, "comment") != null) 
this.setComment(actionRequest.getFieldValue(i, "comment"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { T_yhzc_bzbBean obj = (T_yhzc_bzbBean)super.clone();obj.setId(obj.id);
obj.setZbid(obj.zbid);
obj.setType(obj.type);
obj.setBzmc(obj.bzmc);
obj.setParentid(obj.parentid);
obj.setSxh(obj.sxh);
obj.setLevel(obj.level);
obj.setIsimport(obj.isimport);
obj.setIsleaf(obj.isleaf);
obj.setCkyjid(obj.ckyjid);
obj.setCkyjby(obj.ckyjby);
obj.setHybmid(obj.hybmid);
obj.setCkyj(obj.ckyj);
obj.setAllparentid(obj.allparentid);
obj.setIsdel(obj.isdel);
obj.setCzzt(obj.czzt);
obj.setVer(obj.ver);
obj.setJcqk(obj.jcqk);
obj.setZgzrr(obj.zgzrr);
obj.setZgsx(obj.zgsx);
obj.setAgwcsj(obj.agwcsj);
obj.setSfyh(obj.sfyh);
obj.setSfyzg(obj.sfyzg);
obj.setBz(obj.bz);
obj.setComment(obj.comment);
return obj;}}