package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class ZczjqyxxzbBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new ZczjqyxxzbBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new ZczjqyxxzbBean().findAndLockByWhere(sSqlWhere);      }       public static ZczjqyxxzbBean findFirst(String sSqlWhere)throws Exception {           return (ZczjqyxxzbBean)new ZczjqyxxzbBean().findFirstByWhere(sSqlWhere);      }       public static ZczjqyxxzbBean findFirstAndLock(String sSqlWhere)throws Exception {           return (ZczjqyxxzbBean)new ZczjqyxxzbBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new ZczjqyxxzbBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZczjqyxxzbBean bean = new ZczjqyxxzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           ZczjqyxxzbBean bean = new ZczjqyxxzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static ZczjqyxxzbBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZczjqyxxzbBean bean = new ZczjqyxxzbBean();           bean.setAutoRelease(isAutoRelease);           return (ZczjqyxxzbBean)bean.findFirstByWhere(sSqlWhere);      }       public static ZczjqyxxzbBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           ZczjqyxxzbBean bean = new ZczjqyxxzbBean();           bean.setAutoRelease(isAutoRelease);           return (ZczjqyxxzbBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           ZczjqyxxzbBean bean = new ZczjqyxxzbBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  enterno;
String  corpkey;
String  dwmc;
String  zbid;
String  lxr;
String  lxdh;
String  ditcode;
String  hgx;
String  bhgx;
String  hgl;
String  zcsj;
String  jcr1;
String  jc2;
String  jcrbh1;
String  jcrbh2;
String  fzr;
String  deptno;
String  deptname;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
String  fhgx;
String  fbhgx;
String  fhgl;
public static final String TABLENAME ="zczjqyxxzb";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
ZczjqyxxzbBean abb = new ZczjqyxxzbBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.corpkey=rs.getString("corpkey");
abb.setKeyValue("CORPKEY","" + abb.getCorpkey());
abb.dwmc=rs.getString("dwmc");
abb.setKeyValue("DWMC","" + abb.getDwmc());
abb.zbid=rs.getString("zbid");
abb.setKeyValue("ZBID","" + abb.getZbid());
abb.lxr=rs.getString("lxr");
abb.setKeyValue("LXR","" + abb.getLxr());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.ditcode=rs.getString("ditcode");
abb.setKeyValue("DITCODE","" + abb.getDitcode());
abb.hgx=rs.getString("hgx");
abb.setKeyValue("HGX","" + abb.getHgx());
abb.bhgx=rs.getString("bhgx");
abb.setKeyValue("BHGX","" + abb.getBhgx());
abb.hgl=rs.getString("hgl");
abb.setKeyValue("HGL","" + abb.getHgl());
abb.zcsj=rs.getString("zcsj");
abb.setKeyValue("ZCSJ","" + abb.getZcsj());
abb.jcr1=rs.getString("jcr1");
abb.setKeyValue("JCR1","" + abb.getJcr1());
abb.jc2=rs.getString("jc2");
abb.setKeyValue("JC2","" + abb.getJc2());
abb.jcrbh1=rs.getString("jcrbh1");
abb.setKeyValue("JCRBH1","" + abb.getJcrbh1());
abb.jcrbh2=rs.getString("jcrbh2");
abb.setKeyValue("JCRBH2","" + abb.getJcrbh2());
abb.fzr=rs.getString("fzr");
abb.setKeyValue("FZR","" + abb.getFzr());
abb.deptno=rs.getString("deptno");
abb.setKeyValue("DEPTNO","" + abb.getDeptno());
abb.deptname=rs.getString("deptname");
abb.setKeyValue("DEPTNAME","" + abb.getDeptname());
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
abb.fhgx=rs.getString("fhgx");
abb.setKeyValue("FHGX","" + abb.getFhgx());
abb.fbhgx=rs.getString("fbhgx");
abb.setKeyValue("FBHGX","" + abb.getFbhgx());
abb.fhgl=rs.getString("fhgl");
abb.setKeyValue("FHGL","" + abb.getFhgl());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getCorpkey(){ if ( this.corpkey == null){ return ""; } else {return this.corpkey;}}public String getDwmc(){ if ( this.dwmc == null){ return ""; } else {return this.dwmc;}}public String getZbid(){ if ( this.zbid == null){ return ""; } else {return this.zbid;}}public String getLxr(){ if ( this.lxr == null){ return ""; } else {return this.lxr;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getDitcode(){ if ( this.ditcode == null){ return ""; } else {return this.ditcode;}}public String getHgx(){ if ( this.hgx == null){ return ""; } else {return this.hgx;}}public String getBhgx(){ if ( this.bhgx == null){ return ""; } else {return this.bhgx;}}public String getHgl(){ if ( this.hgl == null){ return ""; } else {return this.hgl;}}public String getZcsj(){ if ( this.zcsj == null){ return ""; } else {return this.zcsj;}}public String getJcr1(){ if ( this.jcr1 == null){ return ""; } else {return this.jcr1;}}public String getJc2(){ if ( this.jc2 == null){ return ""; } else {return this.jc2;}}public String getJcrbh1(){ if ( this.jcrbh1 == null){ return ""; } else {return this.jcrbh1;}}public String getJcrbh2(){ if ( this.jcrbh2 == null){ return ""; } else {return this.jcrbh2;}}public String getFzr(){ if ( this.fzr == null){ return ""; } else {return this.fzr;}}public String getDeptno(){ if ( this.deptno == null){ return ""; } else {return this.deptno;}}public String getDeptname(){ if ( this.deptname == null){ return ""; } else {return this.deptname;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public String getFhgx(){ if ( this.fhgx == null){ return ""; } else {return this.fhgx;}}public String getFbhgx(){ if ( this.fbhgx == null){ return ""; } else {return this.fbhgx;}}public String getFhgl(){ if ( this.fhgl == null){ return ""; } else {return this.fhgl;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setCorpkey( String corpkey){sqlMaker.setField("corpkey",corpkey,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCorpkey().equals(corpkey))
cf.add("corpkey",this.corpkey,corpkey);
}
this.corpkey=corpkey;
}
public void setDwmc( String dwmc){sqlMaker.setField("dwmc",dwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwmc().equals(dwmc))
cf.add("dwmc",this.dwmc,dwmc);
}
this.dwmc=dwmc;
}
public void setZbid( String zbid){sqlMaker.setField("zbid",zbid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZbid().equals(zbid))
cf.add("zbid",this.zbid,zbid);
}
this.zbid=zbid;
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
public void setDitcode( String ditcode){sqlMaker.setField("ditcode",ditcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDitcode().equals(ditcode))
cf.add("ditcode",this.ditcode,ditcode);
}
this.ditcode=ditcode;
}
public void setHgx( String hgx){sqlMaker.setField("hgx",hgx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHgx().equals(hgx))
cf.add("hgx",this.hgx,hgx);
}
this.hgx=hgx;
}
public void setBhgx( String bhgx){sqlMaker.setField("bhgx",bhgx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBhgx().equals(bhgx))
cf.add("bhgx",this.bhgx,bhgx);
}
this.bhgx=bhgx;
}
public void setHgl( String hgl){sqlMaker.setField("hgl",hgl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHgl().equals(hgl))
cf.add("hgl",this.hgl,hgl);
}
this.hgl=hgl;
}
public void setZcsj( String zcsj){sqlMaker.setField("zcsj",zcsj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZcsj().equals(zcsj))
cf.add("zcsj",this.zcsj,zcsj);
}
this.zcsj=zcsj;
}
public void setJcr1( String jcr1){sqlMaker.setField("jcr1",jcr1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcr1().equals(jcr1))
cf.add("jcr1",this.jcr1,jcr1);
}
this.jcr1=jcr1;
}
public void setJc2( String jc2){sqlMaker.setField("jc2",jc2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJc2().equals(jc2))
cf.add("jc2",this.jc2,jc2);
}
this.jc2=jc2;
}
public void setJcrbh1( String jcrbh1){sqlMaker.setField("jcrbh1",jcrbh1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcrbh1().equals(jcrbh1))
cf.add("jcrbh1",this.jcrbh1,jcrbh1);
}
this.jcrbh1=jcrbh1;
}
public void setJcrbh2( String jcrbh2){sqlMaker.setField("jcrbh2",jcrbh2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcrbh2().equals(jcrbh2))
cf.add("jcrbh2",this.jcrbh2,jcrbh2);
}
this.jcrbh2=jcrbh2;
}
public void setFzr( String fzr){sqlMaker.setField("fzr",fzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFzr().equals(fzr))
cf.add("fzr",this.fzr,fzr);
}
this.fzr=fzr;
}
public void setDeptno( String deptno){sqlMaker.setField("deptno",deptno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptno().equals(deptno))
cf.add("deptno",this.deptno,deptno);
}
this.deptno=deptno;
}
public void setDeptname( String deptname){sqlMaker.setField("deptname",deptname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptname().equals(deptname))
cf.add("deptname",this.deptname,deptname);
}
this.deptname=deptname;
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
public void setFhgx( String fhgx){sqlMaker.setField("fhgx",fhgx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFhgx().equals(fhgx))
cf.add("fhgx",this.fhgx,fhgx);
}
this.fhgx=fhgx;
}
public void setFbhgx( String fbhgx){sqlMaker.setField("fbhgx",fbhgx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFbhgx().equals(fbhgx))
cf.add("fbhgx",this.fbhgx,fbhgx);
}
this.fbhgx=fbhgx;
}
public void setFhgl( String fhgl){sqlMaker.setField("fhgl",fhgl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFhgl().equals(fhgl))
cf.add("fhgl",this.fhgl,fhgl);
}
this.fhgl=fhgl;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "enterno") != null) 
this.setEnterno(actionRequest.getFieldValue(i, "enterno"));
if (actionRequest.getFieldValue(i, "corpkey") != null) 
this.setCorpkey(actionRequest.getFieldValue(i, "corpkey"));
if (actionRequest.getFieldValue(i, "dwmc") != null) 
this.setDwmc(actionRequest.getFieldValue(i, "dwmc"));
if (actionRequest.getFieldValue(i, "zbid") != null) 
this.setZbid(actionRequest.getFieldValue(i, "zbid"));
if (actionRequest.getFieldValue(i, "lxr") != null) 
this.setLxr(actionRequest.getFieldValue(i, "lxr"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "ditcode") != null) 
this.setDitcode(actionRequest.getFieldValue(i, "ditcode"));
if (actionRequest.getFieldValue(i, "hgx") != null) 
this.setHgx(actionRequest.getFieldValue(i, "hgx"));
if (actionRequest.getFieldValue(i, "bhgx") != null) 
this.setBhgx(actionRequest.getFieldValue(i, "bhgx"));
if (actionRequest.getFieldValue(i, "hgl") != null) 
this.setHgl(actionRequest.getFieldValue(i, "hgl"));
if (actionRequest.getFieldValue(i, "zcsj") != null) 
this.setZcsj(actionRequest.getFieldValue(i, "zcsj"));
if (actionRequest.getFieldValue(i, "jcr1") != null) 
this.setJcr1(actionRequest.getFieldValue(i, "jcr1"));
if (actionRequest.getFieldValue(i, "jc2") != null) 
this.setJc2(actionRequest.getFieldValue(i, "jc2"));
if (actionRequest.getFieldValue(i, "jcrbh1") != null) 
this.setJcrbh1(actionRequest.getFieldValue(i, "jcrbh1"));
if (actionRequest.getFieldValue(i, "jcrbh2") != null) 
this.setJcrbh2(actionRequest.getFieldValue(i, "jcrbh2"));
if (actionRequest.getFieldValue(i, "fzr") != null) 
this.setFzr(actionRequest.getFieldValue(i, "fzr"));
if (actionRequest.getFieldValue(i, "deptno") != null) 
this.setDeptno(actionRequest.getFieldValue(i, "deptno"));
if (actionRequest.getFieldValue(i, "deptname") != null) 
this.setDeptname(actionRequest.getFieldValue(i, "deptname"));
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
if (actionRequest.getFieldValue(i, "fhgx") != null) 
this.setFhgx(actionRequest.getFieldValue(i, "fhgx"));
if (actionRequest.getFieldValue(i, "fbhgx") != null) 
this.setFbhgx(actionRequest.getFieldValue(i, "fbhgx"));
if (actionRequest.getFieldValue(i, "fhgl") != null) 
this.setFhgl(actionRequest.getFieldValue(i, "fhgl"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { ZczjqyxxzbBean obj = (ZczjqyxxzbBean)super.clone();obj.setSysno(obj.sysno);
obj.setEnterno(obj.enterno);
obj.setCorpkey(obj.corpkey);
obj.setDwmc(obj.dwmc);
obj.setZbid(obj.zbid);
obj.setLxr(obj.lxr);
obj.setLxdh(obj.lxdh);
obj.setDitcode(obj.ditcode);
obj.setHgx(obj.hgx);
obj.setBhgx(obj.bhgx);
obj.setHgl(obj.hgl);
obj.setZcsj(obj.zcsj);
obj.setJcr1(obj.jcr1);
obj.setJc2(obj.jc2);
obj.setJcrbh1(obj.jcrbh1);
obj.setJcrbh2(obj.jcrbh2);
obj.setFzr(obj.fzr);
obj.setDeptno(obj.deptno);
obj.setDeptname(obj.deptname);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
obj.setFhgx(obj.fhgx);
obj.setFbhgx(obj.fbhgx);
obj.setFhgl(obj.fhgl);
return obj;}}