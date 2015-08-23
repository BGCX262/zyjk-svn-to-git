package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class JcdwjbxxBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new JcdwjbxxBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new JcdwjbxxBean().findAndLockByWhere(sSqlWhere);      }       public static JcdwjbxxBean findFirst(String sSqlWhere)throws Exception {           return (JcdwjbxxBean)new JcdwjbxxBean().findFirstByWhere(sSqlWhere);      }       public static JcdwjbxxBean findFirstAndLock(String sSqlWhere)throws Exception {           return (JcdwjbxxBean)new JcdwjbxxBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new JcdwjbxxBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcdwjbxxBean bean = new JcdwjbxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcdwjbxxBean bean = new JcdwjbxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static JcdwjbxxBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcdwjbxxBean bean = new JcdwjbxxBean();           bean.setAutoRelease(isAutoRelease);           return (JcdwjbxxBean)bean.findFirstByWhere(sSqlWhere);      }       public static JcdwjbxxBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcdwjbxxBean bean = new JcdwjbxxBean();           bean.setAutoRelease(isAutoRelease);           return (JcdwjbxxBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcdwjbxxBean bean = new JcdwjbxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  bgbh;
String  dwbh;
String  dwmc;
String  dwdz;
String  sshy;
String  lxr;
String  lxdh;
String  qygm;
String  qyxz;
String  ygrs;
String  sbzs;
String  sftj;
String  tjdwmc;
String  tjdwbh;
String  sfypj;
String  sfkzxgpj;
String  sfzywhjc;
String  sflxpf;
String  sfslgl;
String  gylc;
String  zjyj;
String  jcbdt;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="jcdwjbxx";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
JcdwjbxxBean abb = new JcdwjbxxBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.bgbh=rs.getString("bgbh");
abb.setKeyValue("BGBH","" + abb.getBgbh());
abb.dwbh=rs.getString("dwbh");
abb.setKeyValue("DWBH","" + abb.getDwbh());
abb.dwmc=rs.getString("dwmc");
abb.setKeyValue("DWMC","" + abb.getDwmc());
abb.dwdz=rs.getString("dwdz");
abb.setKeyValue("DWDZ","" + abb.getDwdz());
abb.sshy=rs.getString("sshy");
abb.setKeyValue("SSHY","" + abb.getSshy());
abb.lxr=rs.getString("lxr");
abb.setKeyValue("LXR","" + abb.getLxr());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.qygm=rs.getString("qygm");
abb.setKeyValue("QYGM","" + abb.getQygm());
abb.qyxz=rs.getString("qyxz");
abb.setKeyValue("QYXZ","" + abb.getQyxz());
abb.ygrs=rs.getString("ygrs");
abb.setKeyValue("YGRS","" + abb.getYgrs());
abb.sbzs=rs.getString("sbzs");
abb.setKeyValue("SBZS","" + abb.getSbzs());
abb.sftj=rs.getString("sftj");
abb.setKeyValue("SFTJ","" + abb.getSftj());
abb.tjdwmc=rs.getString("tjdwmc");
abb.setKeyValue("TJDWMC","" + abb.getTjdwmc());
abb.tjdwbh=rs.getString("tjdwbh");
abb.setKeyValue("TJDWBH","" + abb.getTjdwbh());
abb.sfypj=rs.getString("sfypj");
abb.setKeyValue("SFYPJ","" + abb.getSfypj());
abb.sfkzxgpj=rs.getString("sfkzxgpj");
abb.setKeyValue("SFKZXGPJ","" + abb.getSfkzxgpj());
abb.sfzywhjc=rs.getString("sfzywhjc");
abb.setKeyValue("SFZYWHJC","" + abb.getSfzywhjc());
abb.sflxpf=rs.getString("sflxpf");
abb.setKeyValue("SFLXPF","" + abb.getSflxpf());
abb.sfslgl=rs.getString("sfslgl");
abb.setKeyValue("SFSLGL","" + abb.getSfslgl());
abb.gylc=rs.getString("gylc");
abb.setKeyValue("GYLC","" + abb.getGylc());
abb.zjyj=rs.getString("zjyj");
abb.setKeyValue("ZJYJ","" + abb.getZjyj());
abb.jcbdt=rs.getString("jcbdt");
abb.setKeyValue("JCBDT","" + abb.getJcbdt());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getBgbh(){ if ( this.bgbh == null){ return ""; } else {return this.bgbh;}}public String getDwbh(){ if ( this.dwbh == null){ return ""; } else {return this.dwbh;}}public String getDwmc(){ if ( this.dwmc == null){ return ""; } else {return this.dwmc;}}public String getDwdz(){ if ( this.dwdz == null){ return ""; } else {return this.dwdz;}}public String getSshy(){ if ( this.sshy == null){ return ""; } else {return this.sshy;}}public String getLxr(){ if ( this.lxr == null){ return ""; } else {return this.lxr;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getQygm(){ if ( this.qygm == null){ return ""; } else {return this.qygm;}}public String getQyxz(){ if ( this.qyxz == null){ return ""; } else {return this.qyxz;}}public String getYgrs(){ if ( this.ygrs == null){ return ""; } else {return this.ygrs;}}public String getSbzs(){ if ( this.sbzs == null){ return ""; } else {return this.sbzs;}}public String getSftj(){ if ( this.sftj == null){ return ""; } else {return this.sftj;}}public String getTjdwmc(){ if ( this.tjdwmc == null){ return ""; } else {return this.tjdwmc;}}public String getTjdwbh(){ if ( this.tjdwbh == null){ return ""; } else {return this.tjdwbh;}}public String getSfypj(){ if ( this.sfypj == null){ return ""; } else {return this.sfypj;}}public String getSfkzxgpj(){ if ( this.sfkzxgpj == null){ return ""; } else {return this.sfkzxgpj;}}public String getSfzywhjc(){ if ( this.sfzywhjc == null){ return ""; } else {return this.sfzywhjc;}}public String getSflxpf(){ if ( this.sflxpf == null){ return ""; } else {return this.sflxpf;}}public String getSfslgl(){ if ( this.sfslgl == null){ return ""; } else {return this.sfslgl;}}public String getGylc(){ if ( this.gylc == null){ return ""; } else {return this.gylc;}}public String getZjyj(){ if ( this.zjyj == null){ return ""; } else {return this.zjyj;}}public String getJcbdt(){ if ( this.jcbdt == null){ return ""; } else {return this.jcbdt;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSysno().equals(sysno))
cf.add("sysno",this.sysno,sysno);
}
this.sysno=sysno;
}
public void setBgbh( String bgbh){sqlMaker.setField("bgbh",bgbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBgbh().equals(bgbh))
cf.add("bgbh",this.bgbh,bgbh);
}
this.bgbh=bgbh;
}
public void setDwbh( String dwbh){sqlMaker.setField("dwbh",dwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwbh().equals(dwbh))
cf.add("dwbh",this.dwbh,dwbh);
}
this.dwbh=dwbh;
}
public void setDwmc( String dwmc){sqlMaker.setField("dwmc",dwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwmc().equals(dwmc))
cf.add("dwmc",this.dwmc,dwmc);
}
this.dwmc=dwmc;
}
public void setDwdz( String dwdz){sqlMaker.setField("dwdz",dwdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwdz().equals(dwdz))
cf.add("dwdz",this.dwdz,dwdz);
}
this.dwdz=dwdz;
}
public void setSshy( String sshy){sqlMaker.setField("sshy",sshy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSshy().equals(sshy))
cf.add("sshy",this.sshy,sshy);
}
this.sshy=sshy;
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
public void setQygm( String qygm){sqlMaker.setField("qygm",qygm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getQygm().equals(qygm))
cf.add("qygm",this.qygm,qygm);
}
this.qygm=qygm;
}
public void setQyxz( String qyxz){sqlMaker.setField("qyxz",qyxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getQyxz().equals(qyxz))
cf.add("qyxz",this.qyxz,qyxz);
}
this.qyxz=qyxz;
}
public void setYgrs( String ygrs){sqlMaker.setField("ygrs",ygrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYgrs().equals(ygrs))
cf.add("ygrs",this.ygrs,ygrs);
}
this.ygrs=ygrs;
}
public void setSbzs( String sbzs){sqlMaker.setField("sbzs",sbzs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSbzs().equals(sbzs))
cf.add("sbzs",this.sbzs,sbzs);
}
this.sbzs=sbzs;
}
public void setSftj( String sftj){sqlMaker.setField("sftj",sftj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSftj().equals(sftj))
cf.add("sftj",this.sftj,sftj);
}
this.sftj=sftj;
}
public void setTjdwmc( String tjdwmc){sqlMaker.setField("tjdwmc",tjdwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTjdwmc().equals(tjdwmc))
cf.add("tjdwmc",this.tjdwmc,tjdwmc);
}
this.tjdwmc=tjdwmc;
}
public void setTjdwbh( String tjdwbh){sqlMaker.setField("tjdwbh",tjdwbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTjdwbh().equals(tjdwbh))
cf.add("tjdwbh",this.tjdwbh,tjdwbh);
}
this.tjdwbh=tjdwbh;
}
public void setSfypj( String sfypj){sqlMaker.setField("sfypj",sfypj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfypj().equals(sfypj))
cf.add("sfypj",this.sfypj,sfypj);
}
this.sfypj=sfypj;
}
public void setSfkzxgpj( String sfkzxgpj){sqlMaker.setField("sfkzxgpj",sfkzxgpj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfkzxgpj().equals(sfkzxgpj))
cf.add("sfkzxgpj",this.sfkzxgpj,sfkzxgpj);
}
this.sfkzxgpj=sfkzxgpj;
}
public void setSfzywhjc( String sfzywhjc){sqlMaker.setField("sfzywhjc",sfzywhjc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfzywhjc().equals(sfzywhjc))
cf.add("sfzywhjc",this.sfzywhjc,sfzywhjc);
}
this.sfzywhjc=sfzywhjc;
}
public void setSflxpf( String sflxpf){sqlMaker.setField("sflxpf",sflxpf,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSflxpf().equals(sflxpf))
cf.add("sflxpf",this.sflxpf,sflxpf);
}
this.sflxpf=sflxpf;
}
public void setSfslgl( String sfslgl){sqlMaker.setField("sfslgl",sfslgl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfslgl().equals(sfslgl))
cf.add("sfslgl",this.sfslgl,sfslgl);
}
this.sfslgl=sfslgl;
}
public void setGylc( String gylc){sqlMaker.setField("gylc",gylc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGylc().equals(gylc))
cf.add("gylc",this.gylc,gylc);
}
this.gylc=gylc;
}
public void setZjyj( String zjyj){sqlMaker.setField("zjyj",zjyj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZjyj().equals(zjyj))
cf.add("zjyj",this.zjyj,zjyj);
}
this.zjyj=zjyj;
}
public void setJcbdt( String jcbdt){sqlMaker.setField("jcbdt",jcbdt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcbdt().equals(jcbdt))
cf.add("jcbdt",this.jcbdt,jcbdt);
}
this.jcbdt=jcbdt;
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
if (actionRequest.getFieldValue(i, "bgbh") != null) 
this.setBgbh(actionRequest.getFieldValue(i, "bgbh"));
if (actionRequest.getFieldValue(i, "dwbh") != null) 
this.setDwbh(actionRequest.getFieldValue(i, "dwbh"));
if (actionRequest.getFieldValue(i, "dwmc") != null) 
this.setDwmc(actionRequest.getFieldValue(i, "dwmc"));
if (actionRequest.getFieldValue(i, "dwdz") != null) 
this.setDwdz(actionRequest.getFieldValue(i, "dwdz"));
if (actionRequest.getFieldValue(i, "sshy") != null) 
this.setSshy(actionRequest.getFieldValue(i, "sshy"));
if (actionRequest.getFieldValue(i, "lxr") != null) 
this.setLxr(actionRequest.getFieldValue(i, "lxr"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "qygm") != null) 
this.setQygm(actionRequest.getFieldValue(i, "qygm"));
if (actionRequest.getFieldValue(i, "qyxz") != null) 
this.setQyxz(actionRequest.getFieldValue(i, "qyxz"));
if (actionRequest.getFieldValue(i, "ygrs") != null) 
this.setYgrs(actionRequest.getFieldValue(i, "ygrs"));
if (actionRequest.getFieldValue(i, "sbzs") != null) 
this.setSbzs(actionRequest.getFieldValue(i, "sbzs"));
if (actionRequest.getFieldValue(i, "sftj") != null) 
this.setSftj(actionRequest.getFieldValue(i, "sftj"));
if (actionRequest.getFieldValue(i, "tjdwmc") != null) 
this.setTjdwmc(actionRequest.getFieldValue(i, "tjdwmc"));
if (actionRequest.getFieldValue(i, "tjdwbh") != null) 
this.setTjdwbh(actionRequest.getFieldValue(i, "tjdwbh"));
if (actionRequest.getFieldValue(i, "sfypj") != null) 
this.setSfypj(actionRequest.getFieldValue(i, "sfypj"));
if (actionRequest.getFieldValue(i, "sfkzxgpj") != null) 
this.setSfkzxgpj(actionRequest.getFieldValue(i, "sfkzxgpj"));
if (actionRequest.getFieldValue(i, "sfzywhjc") != null) 
this.setSfzywhjc(actionRequest.getFieldValue(i, "sfzywhjc"));
if (actionRequest.getFieldValue(i, "sflxpf") != null) 
this.setSflxpf(actionRequest.getFieldValue(i, "sflxpf"));
if (actionRequest.getFieldValue(i, "sfslgl") != null) 
this.setSfslgl(actionRequest.getFieldValue(i, "sfslgl"));
if (actionRequest.getFieldValue(i, "gylc") != null) 
this.setGylc(actionRequest.getFieldValue(i, "gylc"));
if (actionRequest.getFieldValue(i, "zjyj") != null) 
this.setZjyj(actionRequest.getFieldValue(i, "zjyj"));
if (actionRequest.getFieldValue(i, "jcbdt") != null) 
this.setJcbdt(actionRequest.getFieldValue(i, "jcbdt"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { JcdwjbxxBean obj = (JcdwjbxxBean)super.clone();obj.setSysno(obj.sysno);
obj.setBgbh(obj.bgbh);
obj.setDwbh(obj.dwbh);
obj.setDwmc(obj.dwmc);
obj.setDwdz(obj.dwdz);
obj.setSshy(obj.sshy);
obj.setLxr(obj.lxr);
obj.setLxdh(obj.lxdh);
obj.setQygm(obj.qygm);
obj.setQyxz(obj.qyxz);
obj.setYgrs(obj.ygrs);
obj.setSbzs(obj.sbzs);
obj.setSftj(obj.sftj);
obj.setTjdwmc(obj.tjdwmc);
obj.setTjdwbh(obj.tjdwbh);
obj.setSfypj(obj.sfypj);
obj.setSfkzxgpj(obj.sfkzxgpj);
obj.setSfzywhjc(obj.sfzywhjc);
obj.setSflxpf(obj.sflxpf);
obj.setSfslgl(obj.sfslgl);
obj.setGylc(obj.gylc);
obj.setZjyj(obj.zjyj);
obj.setJcbdt(obj.jcbdt);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}