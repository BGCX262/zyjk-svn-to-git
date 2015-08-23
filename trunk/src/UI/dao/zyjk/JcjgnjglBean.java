package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class JcjgnjglBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new JcjgnjglBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new JcjgnjglBean().findAndLockByWhere(sSqlWhere);      }       public static JcjgnjglBean findFirst(String sSqlWhere)throws Exception {           return (JcjgnjglBean)new JcjgnjglBean().findFirstByWhere(sSqlWhere);      }       public static JcjgnjglBean findFirstAndLock(String sSqlWhere)throws Exception {           return (JcjgnjglBean)new JcjgnjglBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new JcjgnjglBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgnjglBean bean = new JcjgnjglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcjgnjglBean bean = new JcjgnjglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static JcjgnjglBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgnjglBean bean = new JcjgnjglBean();           bean.setAutoRelease(isAutoRelease);           return (JcjgnjglBean)bean.findFirstByWhere(sSqlWhere);      }       public static JcjgnjglBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcjgnjglBean bean = new JcjgnjglBean();           bean.setAutoRelease(isAutoRelease);           return (JcjgnjglBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgnjglBean bean = new JcjgnjglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  jgbh;
String  jgmc;
String  dwxz;
String  dz;
String  fddbr;
String  lxr;
String  lxdh;
String  fax;
String  zzzsbh;
String  jb;
String  yxqks;
String  yxqjs;
String  fwxm;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="jcjgnjgl";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
JcjgnjglBean abb = new JcjgnjglBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.jgbh=rs.getString("jgbh");
abb.setKeyValue("JGBH","" + abb.getJgbh());
abb.jgmc=rs.getString("jgmc");
abb.setKeyValue("JGMC","" + abb.getJgmc());
abb.dwxz=rs.getString("dwxz");
abb.setKeyValue("DWXZ","" + abb.getDwxz());
abb.dz=rs.getString("dz");
abb.setKeyValue("DZ","" + abb.getDz());
abb.fddbr=rs.getString("fddbr");
abb.setKeyValue("FDDBR","" + abb.getFddbr());
abb.lxr=rs.getString("lxr");
abb.setKeyValue("LXR","" + abb.getLxr());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.fax=rs.getString("fax");
abb.setKeyValue("FAX","" + abb.getFax());
abb.zzzsbh=rs.getString("zzzsbh");
abb.setKeyValue("ZZZSBH","" + abb.getZzzsbh());
abb.jb=rs.getString("jb");
abb.setKeyValue("JB","" + abb.getJb());
abb.yxqks=rs.getString("yxqks");
abb.setKeyValue("YXQKS","" + abb.getYxqks());
abb.yxqjs=rs.getString("yxqjs");
abb.setKeyValue("YXQJS","" + abb.getYxqjs());
abb.fwxm=rs.getString("fwxm");
abb.setKeyValue("FWXM","" + abb.getFwxm());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getJgbh(){ if ( this.jgbh == null){ return ""; } else {return this.jgbh;}}public String getJgmc(){ if ( this.jgmc == null){ return ""; } else {return this.jgmc;}}public String getDwxz(){ if ( this.dwxz == null){ return ""; } else {return this.dwxz;}}public String getDz(){ if ( this.dz == null){ return ""; } else {return this.dz;}}public String getFddbr(){ if ( this.fddbr == null){ return ""; } else {return this.fddbr;}}public String getLxr(){ if ( this.lxr == null){ return ""; } else {return this.lxr;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getFax(){ if ( this.fax == null){ return ""; } else {return this.fax;}}public String getZzzsbh(){ if ( this.zzzsbh == null){ return ""; } else {return this.zzzsbh;}}public String getJb(){ if ( this.jb == null){ return ""; } else {return this.jb;}}public String getYxqks(){ if ( this.yxqks == null){ return ""; } else {return this.yxqks;}}public String getYxqjs(){ if ( this.yxqjs == null){ return ""; } else {return this.yxqjs;}}public String getFwxm(){ if ( this.fwxm == null){ return ""; } else {return this.fwxm;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setJgbh( String jgbh){sqlMaker.setField("jgbh",jgbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgbh().equals(jgbh))
cf.add("jgbh",this.jgbh,jgbh);
}
this.jgbh=jgbh;
}
public void setJgmc( String jgmc){sqlMaker.setField("jgmc",jgmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJgmc().equals(jgmc))
cf.add("jgmc",this.jgmc,jgmc);
}
this.jgmc=jgmc;
}
public void setDwxz( String dwxz){sqlMaker.setField("dwxz",dwxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwxz().equals(dwxz))
cf.add("dwxz",this.dwxz,dwxz);
}
this.dwxz=dwxz;
}
public void setDz( String dz){sqlMaker.setField("dz",dz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDz().equals(dz))
cf.add("dz",this.dz,dz);
}
this.dz=dz;
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
public void setZzzsbh( String zzzsbh){sqlMaker.setField("zzzsbh",zzzsbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZzzsbh().equals(zzzsbh))
cf.add("zzzsbh",this.zzzsbh,zzzsbh);
}
this.zzzsbh=zzzsbh;
}
public void setJb( String jb){sqlMaker.setField("jb",jb,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJb().equals(jb))
cf.add("jb",this.jb,jb);
}
this.jb=jb;
}
public void setYxqks( String yxqks){sqlMaker.setField("yxqks",yxqks,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYxqks().equals(yxqks))
cf.add("yxqks",this.yxqks,yxqks);
}
this.yxqks=yxqks;
}
public void setYxqjs( String yxqjs){sqlMaker.setField("yxqjs",yxqjs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYxqjs().equals(yxqjs))
cf.add("yxqjs",this.yxqjs,yxqjs);
}
this.yxqjs=yxqjs;
}
public void setFwxm( String fwxm){sqlMaker.setField("fwxm",fwxm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFwxm().equals(fwxm))
cf.add("fwxm",this.fwxm,fwxm);
}
this.fwxm=fwxm;
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
if (actionRequest.getFieldValue(i, "jgbh") != null) 
this.setJgbh(actionRequest.getFieldValue(i, "jgbh"));
if (actionRequest.getFieldValue(i, "jgmc") != null) 
this.setJgmc(actionRequest.getFieldValue(i, "jgmc"));
if (actionRequest.getFieldValue(i, "dwxz") != null) 
this.setDwxz(actionRequest.getFieldValue(i, "dwxz"));
if (actionRequest.getFieldValue(i, "dz") != null) 
this.setDz(actionRequest.getFieldValue(i, "dz"));
if (actionRequest.getFieldValue(i, "fddbr") != null) 
this.setFddbr(actionRequest.getFieldValue(i, "fddbr"));
if (actionRequest.getFieldValue(i, "lxr") != null) 
this.setLxr(actionRequest.getFieldValue(i, "lxr"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "fax") != null) 
this.setFax(actionRequest.getFieldValue(i, "fax"));
if (actionRequest.getFieldValue(i, "zzzsbh") != null) 
this.setZzzsbh(actionRequest.getFieldValue(i, "zzzsbh"));
if (actionRequest.getFieldValue(i, "jb") != null) 
this.setJb(actionRequest.getFieldValue(i, "jb"));
if (actionRequest.getFieldValue(i, "yxqks") != null) 
this.setYxqks(actionRequest.getFieldValue(i, "yxqks"));
if (actionRequest.getFieldValue(i, "yxqjs") != null) 
this.setYxqjs(actionRequest.getFieldValue(i, "yxqjs"));
if (actionRequest.getFieldValue(i, "fwxm") != null) 
this.setFwxm(actionRequest.getFieldValue(i, "fwxm"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { JcjgnjglBean obj = (JcjgnjglBean)super.clone();obj.setSysno(obj.sysno);
obj.setJgbh(obj.jgbh);
obj.setJgmc(obj.jgmc);
obj.setDwxz(obj.dwxz);
obj.setDz(obj.dz);
obj.setFddbr(obj.fddbr);
obj.setLxr(obj.lxr);
obj.setLxdh(obj.lxdh);
obj.setFax(obj.fax);
obj.setZzzsbh(obj.zzzsbh);
obj.setJb(obj.jb);
obj.setYxqks(obj.yxqks);
obj.setYxqjs(obj.yxqjs);
obj.setFwxm(obj.fwxm);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}