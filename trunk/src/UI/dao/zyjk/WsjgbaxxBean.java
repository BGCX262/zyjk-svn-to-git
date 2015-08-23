package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class WsjgbaxxBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new WsjgbaxxBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new WsjgbaxxBean().findAndLockByWhere(sSqlWhere);      }       public static WsjgbaxxBean findFirst(String sSqlWhere)throws Exception {           return (WsjgbaxxBean)new WsjgbaxxBean().findFirstByWhere(sSqlWhere);      }       public static WsjgbaxxBean findFirstAndLock(String sSqlWhere)throws Exception {           return (WsjgbaxxBean)new WsjgbaxxBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new WsjgbaxxBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           WsjgbaxxBean bean = new WsjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           WsjgbaxxBean bean = new WsjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static WsjgbaxxBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           WsjgbaxxBean bean = new WsjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return (WsjgbaxxBean)bean.findFirstByWhere(sSqlWhere);      }       public static WsjgbaxxBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           WsjgbaxxBean bean = new WsjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return (WsjgbaxxBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           WsjgbaxxBean bean = new WsjgbaxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  jgmc;
String  jgdz;
String  fddbr;
String  lxr;
String  lxdh;
String  fax;
String  pzwh;
String  pzdw;
String  pzsj;
String  zzjb;
String  jcxm;
String  bz;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="wsjgbaxx";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
WsjgbaxxBean abb = new WsjgbaxxBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.jgmc=rs.getString("jgmc");
abb.setKeyValue("JGMC","" + abb.getJgmc());
abb.jgdz=rs.getString("jgdz");
abb.setKeyValue("JGDZ","" + abb.getJgdz());
abb.fddbr=rs.getString("fddbr");
abb.setKeyValue("FDDBR","" + abb.getFddbr());
abb.lxr=rs.getString("lxr");
abb.setKeyValue("LXR","" + abb.getLxr());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.fax=rs.getString("fax");
abb.setKeyValue("FAX","" + abb.getFax());
abb.pzwh=rs.getString("pzwh");
abb.setKeyValue("PZWH","" + abb.getPzwh());
abb.pzdw=rs.getString("pzdw");
abb.setKeyValue("PZDW","" + abb.getPzdw());
abb.pzsj=rs.getString("pzsj");
abb.setKeyValue("PZSJ","" + abb.getPzsj());
abb.zzjb=rs.getString("zzjb");
abb.setKeyValue("ZZJB","" + abb.getZzjb());
abb.jcxm=rs.getString("jcxm");
abb.setKeyValue("JCXM","" + abb.getJcxm());
abb.bz=rs.getString("bz");
abb.setKeyValue("BZ","" + abb.getBz());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getJgmc(){ if ( this.jgmc == null){ return ""; } else {return this.jgmc;}}public String getJgdz(){ if ( this.jgdz == null){ return ""; } else {return this.jgdz;}}public String getFddbr(){ if ( this.fddbr == null){ return ""; } else {return this.fddbr;}}public String getLxr(){ if ( this.lxr == null){ return ""; } else {return this.lxr;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getFax(){ if ( this.fax == null){ return ""; } else {return this.fax;}}public String getPzwh(){ if ( this.pzwh == null){ return ""; } else {return this.pzwh;}}public String getPzdw(){ if ( this.pzdw == null){ return ""; } else {return this.pzdw;}}public String getPzsj(){ if ( this.pzsj == null){ return ""; } else {return this.pzsj;}}public String getZzjb(){ if ( this.zzjb == null){ return ""; } else {return this.zzjb;}}public String getJcxm(){ if ( this.jcxm == null){ return ""; } else {return this.jcxm;}}public String getBz(){ if ( this.bz == null){ return ""; } else {return this.bz;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setJgmc( String jgmc){sqlMaker.setField("jgmc",jgmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgmc().equals(jgmc))
cf.add("jgmc",this.jgmc,jgmc);
}
this.jgmc=jgmc;
}
public void setJgdz( String jgdz){sqlMaker.setField("jgdz",jgdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgdz().equals(jgdz))
cf.add("jgdz",this.jgdz,jgdz);
}
this.jgdz=jgdz;
}
public void setFddbr( String fddbr){sqlMaker.setField("fddbr",fddbr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFddbr().equals(fddbr))
cf.add("fddbr",this.fddbr,fddbr);
}
this.fddbr=fddbr;
}
public void setLxr( String lxr){sqlMaker.setField("lxr",lxr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLxr().equals(lxr))
cf.add("lxr",this.lxr,lxr);
}
this.lxr=lxr;
}
public void setLxdh( String lxdh){sqlMaker.setField("lxdh",lxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLxdh().equals(lxdh))
cf.add("lxdh",this.lxdh,lxdh);
}
this.lxdh=lxdh;
}
public void setFax( String fax){sqlMaker.setField("fax",fax,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFax().equals(fax))
cf.add("fax",this.fax,fax);
}
this.fax=fax;
}
public void setPzwh( String pzwh){sqlMaker.setField("pzwh",pzwh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPzwh().equals(pzwh))
cf.add("pzwh",this.pzwh,pzwh);
}
this.pzwh=pzwh;
}
public void setPzdw( String pzdw){sqlMaker.setField("pzdw",pzdw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPzdw().equals(pzdw))
cf.add("pzdw",this.pzdw,pzdw);
}
this.pzdw=pzdw;
}
public void setPzsj( String pzsj){sqlMaker.setField("pzsj",pzsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPzsj().equals(pzsj))
cf.add("pzsj",this.pzsj,pzsj);
}
this.pzsj=pzsj;
}
public void setZzjb( String zzjb){sqlMaker.setField("zzjb",zzjb,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZzjb().equals(zzjb))
cf.add("zzjb",this.zzjb,zzjb);
}
this.zzjb=zzjb;
}
public void setJcxm( String jcxm){sqlMaker.setField("jcxm",jcxm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcxm().equals(jcxm))
cf.add("jcxm",this.jcxm,jcxm);
}
this.jcxm=jcxm;
}
public void setBz( String bz){sqlMaker.setField("bz",bz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBz().equals(bz))
cf.add("bz",this.bz,bz);
}
this.bz=bz;
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
if (actionRequest.getFieldValue(i, "jgmc") != null) 
this.setJgmc(actionRequest.getFieldValue(i, "jgmc"));
if (actionRequest.getFieldValue(i, "jgdz") != null) 
this.setJgdz(actionRequest.getFieldValue(i, "jgdz"));
if (actionRequest.getFieldValue(i, "fddbr") != null) 
this.setFddbr(actionRequest.getFieldValue(i, "fddbr"));
if (actionRequest.getFieldValue(i, "lxr") != null) 
this.setLxr(actionRequest.getFieldValue(i, "lxr"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "fax") != null) 
this.setFax(actionRequest.getFieldValue(i, "fax"));
if (actionRequest.getFieldValue(i, "pzwh") != null) 
this.setPzwh(actionRequest.getFieldValue(i, "pzwh"));
if (actionRequest.getFieldValue(i, "pzdw") != null) 
this.setPzdw(actionRequest.getFieldValue(i, "pzdw"));
if (actionRequest.getFieldValue(i, "pzsj") != null) 
this.setPzsj(actionRequest.getFieldValue(i, "pzsj"));
if (actionRequest.getFieldValue(i, "zzjb") != null) 
this.setZzjb(actionRequest.getFieldValue(i, "zzjb"));
if (actionRequest.getFieldValue(i, "jcxm") != null) 
this.setJcxm(actionRequest.getFieldValue(i, "jcxm"));
if (actionRequest.getFieldValue(i, "bz") != null) 
this.setBz(actionRequest.getFieldValue(i, "bz"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { WsjgbaxxBean obj = (WsjgbaxxBean)super.clone();obj.setSysno(obj.sysno);
obj.setJgmc(obj.jgmc);
obj.setJgdz(obj.jgdz);
obj.setFddbr(obj.fddbr);
obj.setLxr(obj.lxr);
obj.setLxdh(obj.lxdh);
obj.setFax(obj.fax);
obj.setPzwh(obj.pzwh);
obj.setPzdw(obj.pzdw);
obj.setPzsj(obj.pzsj);
obj.setZzjb(obj.zzjb);
obj.setJcxm(obj.jcxm);
obj.setBz(obj.bz);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}