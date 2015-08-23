package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyzybsgczjlBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyzybsgczjlBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyzybsgczjlBean().findAndLockByWhere(sSqlWhere);      }       public static QyzybsgczjlBean findFirst(String sSqlWhere)throws Exception {           return (QyzybsgczjlBean)new QyzybsgczjlBean().findFirstByWhere(sSqlWhere);      }       public static QyzybsgczjlBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyzybsgczjlBean)new QyzybsgczjlBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyzybsgczjlBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybsgczjlBean bean = new QyzybsgczjlBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzybsgczjlBean bean = new QyzybsgczjlBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyzybsgczjlBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybsgczjlBean bean = new QyzybsgczjlBean();           bean.setAutoRelease(isAutoRelease);           return (QyzybsgczjlBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyzybsgczjlBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzybsgczjlBean bean = new QyzybsgczjlBean();           bean.setAutoRelease(isAutoRelease);           return (QyzybsgczjlBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybsgczjlBean bean = new QyzybsgczjlBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  enterno;
String  entername;
String  frdb;
String  bgr;
String  lxdh;
String  fsdate;
String  cjbh;
String  cjmc;
String  jcrs;
String  fbrs;
String  zlrs;
String  swrs;
String  whname;
String  sgjg;
String  jl;
String  bgdate;
String  bgdw;
String  fzr;
String  date;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qyzybsgczjl";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyzybsgczjlBean abb = new QyzybsgczjlBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.entername=rs.getString("entername");
abb.setKeyValue("ENTERNAME","" + abb.getEntername());
abb.frdb=rs.getString("frdb");
abb.setKeyValue("FRDB","" + abb.getFrdb());
abb.bgr=rs.getString("bgr");
abb.setKeyValue("BGR","" + abb.getBgr());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.fsdate=rs.getString("fsdate");
abb.setKeyValue("FSDATE","" + abb.getFsdate());
abb.cjbh=rs.getString("cjbh");
abb.setKeyValue("CJBH","" + abb.getCjbh());
abb.cjmc=rs.getString("cjmc");
abb.setKeyValue("CJMC","" + abb.getCjmc());
abb.jcrs=rs.getString("jcrs");
abb.setKeyValue("JCRS","" + abb.getJcrs());
abb.fbrs=rs.getString("fbrs");
abb.setKeyValue("FBRS","" + abb.getFbrs());
abb.zlrs=rs.getString("zlrs");
abb.setKeyValue("ZLRS","" + abb.getZlrs());
abb.swrs=rs.getString("swrs");
abb.setKeyValue("SWRS","" + abb.getSwrs());
abb.whname=rs.getString("whname");
abb.setKeyValue("WHNAME","" + abb.getWhname());
abb.sgjg=rs.getString("sgjg");
abb.setKeyValue("SGJG","" + abb.getSgjg());
abb.jl=rs.getString("jl");
abb.setKeyValue("JL","" + abb.getJl());
abb.bgdate=rs.getString("bgdate");
abb.setKeyValue("BGDATE","" + abb.getBgdate());
abb.bgdw=rs.getString("bgdw");
abb.setKeyValue("BGDW","" + abb.getBgdw());
abb.fzr=rs.getString("fzr");
abb.setKeyValue("FZR","" + abb.getFzr());
abb.date=rs.getString("date");
abb.setKeyValue("DATE","" + abb.getDate());
abb.bak1=rs.getString("bak1");
abb.setKeyValue("BAK1","" + abb.getBak1());
abb.bak2=rs.getString("bak2");
abb.setKeyValue("BAK2","" + abb.getBak2());
abb.bak3=rs.getString("bak3");
abb.setKeyValue("BAK3","" + abb.getBak3());
abb.bak4=rs.getString("bak4");
abb.setKeyValue("BAK4","" + abb.getBak4());
abb.bak5=rs.getString("bak5");
abb.setKeyValue("BAK5","" + abb.getBak5());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getEntername(){ if ( this.entername == null){ return ""; } else {return this.entername;}}public String getFrdb(){ if ( this.frdb == null){ return ""; } else {return this.frdb;}}public String getBgr(){ if ( this.bgr == null){ return ""; } else {return this.bgr;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getFsdate(){ if ( this.fsdate == null){ return ""; } else {return this.fsdate;}}public String getCjbh(){ if ( this.cjbh == null){ return ""; } else {return this.cjbh;}}public String getCjmc(){ if ( this.cjmc == null){ return ""; } else {return this.cjmc;}}public String getJcrs(){ if ( this.jcrs == null){ return ""; } else {return this.jcrs;}}public String getFbrs(){ if ( this.fbrs == null){ return ""; } else {return this.fbrs;}}public String getZlrs(){ if ( this.zlrs == null){ return ""; } else {return this.zlrs;}}public String getSwrs(){ if ( this.swrs == null){ return ""; } else {return this.swrs;}}public String getWhname(){ if ( this.whname == null){ return ""; } else {return this.whname;}}public String getSgjg(){ if ( this.sgjg == null){ return ""; } else {return this.sgjg;}}public String getJl(){ if ( this.jl == null){ return ""; } else {return this.jl;}}public String getBgdate(){ if ( this.bgdate == null){ return ""; } else {return this.bgdate;}}public String getBgdw(){ if ( this.bgdw == null){ return ""; } else {return this.bgdw;}}public String getFzr(){ if ( this.fzr == null){ return ""; } else {return this.fzr;}}public String getDate(){ if ( this.date == null){ return ""; } else {return this.date;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setEnterno( String enterno){sqlMaker.setField("enterno",enterno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnterno().equals(enterno))
cf.add("enterno",this.enterno,enterno);
}
this.enterno=enterno;
}
public void setEntername( String entername){sqlMaker.setField("entername",entername,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEntername().equals(entername))
cf.add("entername",this.entername,entername);
}
this.entername=entername;
}
public void setFrdb( String frdb){sqlMaker.setField("frdb",frdb,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFrdb().equals(frdb))
cf.add("frdb",this.frdb,frdb);
}
this.frdb=frdb;
}
public void setBgr( String bgr){sqlMaker.setField("bgr",bgr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBgr().equals(bgr))
cf.add("bgr",this.bgr,bgr);
}
this.bgr=bgr;
}
public void setLxdh( String lxdh){sqlMaker.setField("lxdh",lxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLxdh().equals(lxdh))
cf.add("lxdh",this.lxdh,lxdh);
}
this.lxdh=lxdh;
}
public void setFsdate( String fsdate){sqlMaker.setField("fsdate",fsdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFsdate().equals(fsdate))
cf.add("fsdate",this.fsdate,fsdate);
}
this.fsdate=fsdate;
}
public void setCjbh( String cjbh){sqlMaker.setField("cjbh",cjbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCjbh().equals(cjbh))
cf.add("cjbh",this.cjbh,cjbh);
}
this.cjbh=cjbh;
}
public void setCjmc( String cjmc){sqlMaker.setField("cjmc",cjmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCjmc().equals(cjmc))
cf.add("cjmc",this.cjmc,cjmc);
}
this.cjmc=cjmc;
}
public void setJcrs( String jcrs){sqlMaker.setField("jcrs",jcrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcrs().equals(jcrs))
cf.add("jcrs",this.jcrs,jcrs);
}
this.jcrs=jcrs;
}
public void setFbrs( String fbrs){sqlMaker.setField("fbrs",fbrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFbrs().equals(fbrs))
cf.add("fbrs",this.fbrs,fbrs);
}
this.fbrs=fbrs;
}
public void setZlrs( String zlrs){sqlMaker.setField("zlrs",zlrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZlrs().equals(zlrs))
cf.add("zlrs",this.zlrs,zlrs);
}
this.zlrs=zlrs;
}
public void setSwrs( String swrs){sqlMaker.setField("swrs",swrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSwrs().equals(swrs))
cf.add("swrs",this.swrs,swrs);
}
this.swrs=swrs;
}
public void setWhname( String whname){sqlMaker.setField("whname",whname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhname().equals(whname))
cf.add("whname",this.whname,whname);
}
this.whname=whname;
}
public void setSgjg( String sgjg){sqlMaker.setField("sgjg",sgjg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSgjg().equals(sgjg))
cf.add("sgjg",this.sgjg,sgjg);
}
this.sgjg=sgjg;
}
public void setJl( String jl){sqlMaker.setField("jl",jl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJl().equals(jl))
cf.add("jl",this.jl,jl);
}
this.jl=jl;
}
public void setBgdate( String bgdate){sqlMaker.setField("bgdate",bgdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBgdate().equals(bgdate))
cf.add("bgdate",this.bgdate,bgdate);
}
this.bgdate=bgdate;
}
public void setBgdw( String bgdw){sqlMaker.setField("bgdw",bgdw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBgdw().equals(bgdw))
cf.add("bgdw",this.bgdw,bgdw);
}
this.bgdw=bgdw;
}
public void setFzr( String fzr){sqlMaker.setField("fzr",fzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzr().equals(fzr))
cf.add("fzr",this.fzr,fzr);
}
this.fzr=fzr;
}
public void setDate( String date){sqlMaker.setField("date",date,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDate().equals(date))
cf.add("date",this.date,date);
}
this.date=date;
}
public void setBak1( String bak1){sqlMaker.setField("bak1",bak1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak1().equals(bak1))
cf.add("bak1",this.bak1,bak1);
}
this.bak1=bak1;
}
public void setBak2( String bak2){sqlMaker.setField("bak2",bak2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak2().equals(bak2))
cf.add("bak2",this.bak2,bak2);
}
this.bak2=bak2;
}
public void setBak3( String bak3){sqlMaker.setField("bak3",bak3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak3().equals(bak3))
cf.add("bak3",this.bak3,bak3);
}
this.bak3=bak3;
}
public void setBak4( String bak4){sqlMaker.setField("bak4",bak4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak4().equals(bak4))
cf.add("bak4",this.bak4,bak4);
}
this.bak4=bak4;
}
public void setBak5( String bak5){sqlMaker.setField("bak5",bak5,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak5().equals(bak5))
cf.add("bak5",this.bak5,bak5);
}
this.bak5=bak5;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "enterno") != null) 
this.setEnterno(actionRequest.getFieldValue(i, "enterno"));
if (actionRequest.getFieldValue(i, "entername") != null) 
this.setEntername(actionRequest.getFieldValue(i, "entername"));
if (actionRequest.getFieldValue(i, "frdb") != null) 
this.setFrdb(actionRequest.getFieldValue(i, "frdb"));
if (actionRequest.getFieldValue(i, "bgr") != null) 
this.setBgr(actionRequest.getFieldValue(i, "bgr"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "fsdate") != null) 
this.setFsdate(actionRequest.getFieldValue(i, "fsdate"));
if (actionRequest.getFieldValue(i, "cjbh") != null) 
this.setCjbh(actionRequest.getFieldValue(i, "cjbh"));
if (actionRequest.getFieldValue(i, "cjmc") != null) 
this.setCjmc(actionRequest.getFieldValue(i, "cjmc"));
if (actionRequest.getFieldValue(i, "jcrs") != null) 
this.setJcrs(actionRequest.getFieldValue(i, "jcrs"));
if (actionRequest.getFieldValue(i, "fbrs") != null) 
this.setFbrs(actionRequest.getFieldValue(i, "fbrs"));
if (actionRequest.getFieldValue(i, "zlrs") != null) 
this.setZlrs(actionRequest.getFieldValue(i, "zlrs"));
if (actionRequest.getFieldValue(i, "swrs") != null) 
this.setSwrs(actionRequest.getFieldValue(i, "swrs"));
if (actionRequest.getFieldValue(i, "whname") != null) 
this.setWhname(actionRequest.getFieldValue(i, "whname"));
if (actionRequest.getFieldValue(i, "sgjg") != null) 
this.setSgjg(actionRequest.getFieldValue(i, "sgjg"));
if (actionRequest.getFieldValue(i, "jl") != null) 
this.setJl(actionRequest.getFieldValue(i, "jl"));
if (actionRequest.getFieldValue(i, "bgdate") != null) 
this.setBgdate(actionRequest.getFieldValue(i, "bgdate"));
if (actionRequest.getFieldValue(i, "bgdw") != null) 
this.setBgdw(actionRequest.getFieldValue(i, "bgdw"));
if (actionRequest.getFieldValue(i, "fzr") != null) 
this.setFzr(actionRequest.getFieldValue(i, "fzr"));
if (actionRequest.getFieldValue(i, "date") != null) 
this.setDate(actionRequest.getFieldValue(i, "date"));
if (actionRequest.getFieldValue(i, "bak1") != null) 
this.setBak1(actionRequest.getFieldValue(i, "bak1"));
if (actionRequest.getFieldValue(i, "bak2") != null) 
this.setBak2(actionRequest.getFieldValue(i, "bak2"));
if (actionRequest.getFieldValue(i, "bak3") != null) 
this.setBak3(actionRequest.getFieldValue(i, "bak3"));
if (actionRequest.getFieldValue(i, "bak4") != null) 
this.setBak4(actionRequest.getFieldValue(i, "bak4"));
if (actionRequest.getFieldValue(i, "bak5") != null) 
this.setBak5(actionRequest.getFieldValue(i, "bak5"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyzybsgczjlBean obj = (QyzybsgczjlBean)super.clone();obj.setSysno(obj.sysno);
obj.setEnterno(obj.enterno);
obj.setEntername(obj.entername);
obj.setFrdb(obj.frdb);
obj.setBgr(obj.bgr);
obj.setLxdh(obj.lxdh);
obj.setFsdate(obj.fsdate);
obj.setCjbh(obj.cjbh);
obj.setCjmc(obj.cjmc);
obj.setJcrs(obj.jcrs);
obj.setFbrs(obj.fbrs);
obj.setZlrs(obj.zlrs);
obj.setSwrs(obj.swrs);
obj.setWhname(obj.whname);
obj.setSgjg(obj.sgjg);
obj.setJl(obj.jl);
obj.setBgdate(obj.bgdate);
obj.setBgdw(obj.bgdw);
obj.setFzr(obj.fzr);
obj.setDate(obj.date);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}