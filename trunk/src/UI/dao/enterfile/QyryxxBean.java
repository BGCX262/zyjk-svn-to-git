package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyryxxBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyryxxBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyryxxBean().findAndLockByWhere(sSqlWhere);      }       public static QyryxxBean findFirst(String sSqlWhere)throws Exception {           return (QyryxxBean)new QyryxxBean().findFirstByWhere(sSqlWhere);      }       public static QyryxxBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyryxxBean)new QyryxxBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyryxxBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyryxxBean bean = new QyryxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyryxxBean bean = new QyryxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyryxxBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyryxxBean bean = new QyryxxBean();           bean.setAutoRelease(isAutoRelease);           return (QyryxxBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyryxxBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyryxxBean bean = new QyryxxBean();           bean.setAutoRelease(isAutoRelease);           return (QyryxxBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyryxxBean bean = new QyryxxBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  enterno;
String  enternm;
String  name;
String  pxjgno;
String  pxjgmc;
String  sex;
String  idcard;
String  deptname;
String  deptno;
String  gz;
String  zw;
String  whcd;
String  sxzy;
String  lxdh;
String  byyx;
String  clzdate;
String  birthday;
String  hj;
String  sfxy;
String  xyqk;
String  grah;
String  jws;
String  hzdate;
String  yxq;
String  zsno;
String  remark;
String  wfwzjl;
String  zrsgjl;
String  beizhu;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
String  whys;
String  whysname;
public static final String TABLENAME ="qyryxx";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyryxxBean abb = new QyryxxBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.enternm=rs.getString("enternm");
abb.setKeyValue("ENTERNM","" + abb.getEnternm());
abb.name=rs.getString("name");
abb.setKeyValue("NAME","" + abb.getName());
abb.pxjgno=rs.getString("pxjgno");
abb.setKeyValue("PXJGNO","" + abb.getPxjgno());
abb.pxjgmc=rs.getString("pxjgmc");
abb.setKeyValue("PXJGMC","" + abb.getPxjgmc());
abb.sex=rs.getString("sex");
abb.setKeyValue("SEX","" + abb.getSex());
abb.idcard=rs.getString("idcard");
abb.setKeyValue("IDCARD","" + abb.getIdcard());
abb.deptname=rs.getString("deptname");
abb.setKeyValue("DEPTNAME","" + abb.getDeptname());
abb.deptno=rs.getString("deptno");
abb.setKeyValue("DEPTNO","" + abb.getDeptno());
abb.gz=rs.getString("gz");
abb.setKeyValue("GZ","" + abb.getGz());
abb.zw=rs.getString("zw");
abb.setKeyValue("ZW","" + abb.getZw());
abb.whcd=rs.getString("whcd");
abb.setKeyValue("WHCD","" + abb.getWhcd());
abb.sxzy=rs.getString("sxzy");
abb.setKeyValue("SXZY","" + abb.getSxzy());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.byyx=rs.getString("byyx");
abb.setKeyValue("BYYX","" + abb.getByyx());
abb.clzdate=rs.getString("clzdate");
abb.setKeyValue("CLZDATE","" + abb.getClzdate());
abb.birthday=rs.getString("birthday");
abb.setKeyValue("BIRTHDAY","" + abb.getBirthday());
abb.hj=rs.getString("hj");
abb.setKeyValue("HJ","" + abb.getHj());
abb.sfxy=rs.getString("sfxy");
abb.setKeyValue("SFXY","" + abb.getSfxy());
abb.xyqk=rs.getString("xyqk");
abb.setKeyValue("XYQK","" + abb.getXyqk());
abb.grah=rs.getString("grah");
abb.setKeyValue("GRAH","" + abb.getGrah());
abb.jws=rs.getString("jws");
abb.setKeyValue("JWS","" + abb.getJws());
abb.hzdate=rs.getString("hzdate");
abb.setKeyValue("HZDATE","" + abb.getHzdate());
abb.yxq=rs.getString("yxq");
abb.setKeyValue("YXQ","" + abb.getYxq());
abb.zsno=rs.getString("zsno");
abb.setKeyValue("ZSNO","" + abb.getZsno());
abb.remark=rs.getString("remark");
abb.setKeyValue("REMARK","" + abb.getRemark());
abb.wfwzjl=rs.getString("wfwzjl");
abb.setKeyValue("WFWZJL","" + abb.getWfwzjl());
abb.zrsgjl=rs.getString("zrsgjl");
abb.setKeyValue("ZRSGJL","" + abb.getZrsgjl());
abb.beizhu=rs.getString("beizhu");
abb.setKeyValue("BEIZHU","" + abb.getBeizhu());
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
abb.whys=rs.getString("whys");
abb.setKeyValue("WHYS","" + abb.getWhys());
abb.whysname=rs.getString("whysname");
abb.setKeyValue("WHYSNAME","" + abb.getWhysname());
list.add(abb);
abb.operate_mode = "edit";
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getEnternm(){ if ( this.enternm == null){ return ""; } else {return this.enternm;}}public String getName(){ if ( this.name == null){ return ""; } else {return this.name;}}public String getPxjgno(){ if ( this.pxjgno == null){ return ""; } else {return this.pxjgno;}}public String getPxjgmc(){ if ( this.pxjgmc == null){ return ""; } else {return this.pxjgmc;}}public String getSex(){ if ( this.sex == null){ return ""; } else {return this.sex;}}public String getIdcard(){ if ( this.idcard == null){ return ""; } else {return this.idcard;}}public String getDeptname(){ if ( this.deptname == null){ return ""; } else {return this.deptname;}}public String getDeptno(){ if ( this.deptno == null){ return ""; } else {return this.deptno;}}public String getGz(){ if ( this.gz == null){ return ""; } else {return this.gz;}}public String getZw(){ if ( this.zw == null){ return ""; } else {return this.zw;}}public String getWhcd(){ if ( this.whcd == null){ return ""; } else {return this.whcd;}}public String getSxzy(){ if ( this.sxzy == null){ return ""; } else {return this.sxzy;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getByyx(){ if ( this.byyx == null){ return ""; } else {return this.byyx;}}public String getClzdate(){ if ( this.clzdate == null){ return ""; } else {return this.clzdate;}}public String getBirthday(){ if ( this.birthday == null){ return ""; } else {return this.birthday;}}public String getHj(){ if ( this.hj == null){ return ""; } else {return this.hj;}}public String getSfxy(){ if ( this.sfxy == null){ return ""; } else {return this.sfxy;}}public String getXyqk(){ if ( this.xyqk == null){ return ""; } else {return this.xyqk;}}public String getGrah(){ if ( this.grah == null){ return ""; } else {return this.grah;}}public String getJws(){ if ( this.jws == null){ return ""; } else {return this.jws;}}public String getHzdate(){ if ( this.hzdate == null){ return ""; } else {return this.hzdate;}}public String getYxq(){ if ( this.yxq == null){ return ""; } else {return this.yxq;}}public String getZsno(){ if ( this.zsno == null){ return ""; } else {return this.zsno;}}public String getRemark(){ if ( this.remark == null){ return ""; } else {return this.remark;}}public String getWfwzjl(){ if ( this.wfwzjl == null){ return ""; } else {return this.wfwzjl;}}public String getZrsgjl(){ if ( this.zrsgjl == null){ return ""; } else {return this.zrsgjl;}}public String getBeizhu(){ if ( this.beizhu == null){ return ""; } else {return this.beizhu;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public String getWhys(){ if ( this.whys == null){ return ""; } else {return this.whys;}}public String getWhysname(){ if ( this.whysname == null){ return ""; } else {return this.whysname;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setEnternm( String enternm){sqlMaker.setField("enternm",enternm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnternm().equals(enternm))
cf.add("enternm",this.enternm,enternm);
}
this.enternm=enternm;
}
public void setName( String name){sqlMaker.setField("name",name,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getName().equals(name))
cf.add("name",this.name,name);
}
this.name=name;
}
public void setPxjgno( String pxjgno){sqlMaker.setField("pxjgno",pxjgno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxjgno().equals(pxjgno))
cf.add("pxjgno",this.pxjgno,pxjgno);
}
this.pxjgno=pxjgno;
}
public void setPxjgmc( String pxjgmc){sqlMaker.setField("pxjgmc",pxjgmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxjgmc().equals(pxjgmc))
cf.add("pxjgmc",this.pxjgmc,pxjgmc);
}
this.pxjgmc=pxjgmc;
}
public void setSex( String sex){sqlMaker.setField("sex",sex,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSex().equals(sex))
cf.add("sex",this.sex,sex);
}
this.sex=sex;
}
public void setIdcard( String idcard){sqlMaker.setField("idcard",idcard,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getIdcard().equals(idcard))
cf.add("idcard",this.idcard,idcard);
}
this.idcard=idcard;
}
public void setDeptname( String deptname){sqlMaker.setField("deptname",deptname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptname().equals(deptname))
cf.add("deptname",this.deptname,deptname);
}
this.deptname=deptname;
}
public void setDeptno( String deptno){sqlMaker.setField("deptno",deptno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDeptno().equals(deptno))
cf.add("deptno",this.deptno,deptno);
}
this.deptno=deptno;
}
public void setGz( String gz){sqlMaker.setField("gz",gz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGz().equals(gz))
cf.add("gz",this.gz,gz);
}
this.gz=gz;
}
public void setZw( String zw){sqlMaker.setField("zw",zw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZw().equals(zw))
cf.add("zw",this.zw,zw);
}
this.zw=zw;
}
public void setWhcd( String whcd){sqlMaker.setField("whcd",whcd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhcd().equals(whcd))
cf.add("whcd",this.whcd,whcd);
}
this.whcd=whcd;
}
public void setSxzy( String sxzy){sqlMaker.setField("sxzy",sxzy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSxzy().equals(sxzy))
cf.add("sxzy",this.sxzy,sxzy);
}
this.sxzy=sxzy;
}
public void setLxdh( String lxdh){sqlMaker.setField("lxdh",lxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLxdh().equals(lxdh))
cf.add("lxdh",this.lxdh,lxdh);
}
this.lxdh=lxdh;
}
public void setByyx( String byyx){sqlMaker.setField("byyx",byyx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getByyx().equals(byyx))
cf.add("byyx",this.byyx,byyx);
}
this.byyx=byyx;
}
public void setClzdate( String clzdate){sqlMaker.setField("clzdate",clzdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getClzdate().equals(clzdate))
cf.add("clzdate",this.clzdate,clzdate);
}
this.clzdate=clzdate;
}
public void setBirthday( String birthday){sqlMaker.setField("birthday",birthday,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBirthday().equals(birthday))
cf.add("birthday",this.birthday,birthday);
}
this.birthday=birthday;
}
public void setHj( String hj){sqlMaker.setField("hj",hj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHj().equals(hj))
cf.add("hj",this.hj,hj);
}
this.hj=hj;
}
public void setSfxy( String sfxy){sqlMaker.setField("sfxy",sfxy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfxy().equals(sfxy))
cf.add("sfxy",this.sfxy,sfxy);
}
this.sfxy=sfxy;
}
public void setXyqk( String xyqk){sqlMaker.setField("xyqk",xyqk,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXyqk().equals(xyqk))
cf.add("xyqk",this.xyqk,xyqk);
}
this.xyqk=xyqk;
}
public void setGrah( String grah){sqlMaker.setField("grah",grah,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGrah().equals(grah))
cf.add("grah",this.grah,grah);
}
this.grah=grah;
}
public void setJws( String jws){sqlMaker.setField("jws",jws,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJws().equals(jws))
cf.add("jws",this.jws,jws);
}
this.jws=jws;
}
public void setHzdate( String hzdate){sqlMaker.setField("hzdate",hzdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHzdate().equals(hzdate))
cf.add("hzdate",this.hzdate,hzdate);
}
this.hzdate=hzdate;
}
public void setYxq( String yxq){sqlMaker.setField("yxq",yxq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYxq().equals(yxq))
cf.add("yxq",this.yxq,yxq);
}
this.yxq=yxq;
}
public void setZsno( String zsno){sqlMaker.setField("zsno",zsno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZsno().equals(zsno))
cf.add("zsno",this.zsno,zsno);
}
this.zsno=zsno;
}
public void setRemark( String remark){sqlMaker.setField("remark",remark,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getRemark().equals(remark))
cf.add("remark",this.remark,remark);
}
this.remark=remark;
}
public void setWfwzjl( String wfwzjl){sqlMaker.setField("wfwzjl",wfwzjl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWfwzjl().equals(wfwzjl))
cf.add("wfwzjl",this.wfwzjl,wfwzjl);
}
this.wfwzjl=wfwzjl;
}
public void setZrsgjl( String zrsgjl){sqlMaker.setField("zrsgjl",zrsgjl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZrsgjl().equals(zrsgjl))
cf.add("zrsgjl",this.zrsgjl,zrsgjl);
}
this.zrsgjl=zrsgjl;
}
public void setBeizhu( String beizhu){sqlMaker.setField("beizhu",beizhu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBeizhu().equals(beizhu))
cf.add("beizhu",this.beizhu,beizhu);
}
this.beizhu=beizhu;
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
public void setWhys( String whys){sqlMaker.setField("whys",whys,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhys().equals(whys))
cf.add("whys",this.whys,whys);
}
this.whys=whys;
}
public void setWhysname( String whysname){sqlMaker.setField("whysname",whysname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhysname().equals(whysname))
cf.add("whysname",this.whysname,whysname);
}
this.whysname=whysname;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "sysno") != null) 
this.setSysno(actionRequest.getFieldValue(i, "sysno"));
if (actionRequest.getFieldValue(i, "enterno") != null) 
this.setEnterno(actionRequest.getFieldValue(i, "enterno"));
if (actionRequest.getFieldValue(i, "enternm") != null) 
this.setEnternm(actionRequest.getFieldValue(i, "enternm"));
if (actionRequest.getFieldValue(i, "name") != null) 
this.setName(actionRequest.getFieldValue(i, "name"));
if (actionRequest.getFieldValue(i, "pxjgno") != null) 
this.setPxjgno(actionRequest.getFieldValue(i, "pxjgno"));
if (actionRequest.getFieldValue(i, "pxjgmc") != null) 
this.setPxjgmc(actionRequest.getFieldValue(i, "pxjgmc"));
if (actionRequest.getFieldValue(i, "sex") != null) 
this.setSex(actionRequest.getFieldValue(i, "sex"));
if (actionRequest.getFieldValue(i, "idcard") != null) 
this.setIdcard(actionRequest.getFieldValue(i, "idcard"));
if (actionRequest.getFieldValue(i, "deptname") != null) 
this.setDeptname(actionRequest.getFieldValue(i, "deptname"));
if (actionRequest.getFieldValue(i, "deptno") != null) 
this.setDeptno(actionRequest.getFieldValue(i, "deptno"));
if (actionRequest.getFieldValue(i, "gz") != null) 
this.setGz(actionRequest.getFieldValue(i, "gz"));
if (actionRequest.getFieldValue(i, "zw") != null) 
this.setZw(actionRequest.getFieldValue(i, "zw"));
if (actionRequest.getFieldValue(i, "whcd") != null) 
this.setWhcd(actionRequest.getFieldValue(i, "whcd"));
if (actionRequest.getFieldValue(i, "sxzy") != null) 
this.setSxzy(actionRequest.getFieldValue(i, "sxzy"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "byyx") != null) 
this.setByyx(actionRequest.getFieldValue(i, "byyx"));
if (actionRequest.getFieldValue(i, "clzdate") != null) 
this.setClzdate(actionRequest.getFieldValue(i, "clzdate"));
if (actionRequest.getFieldValue(i, "birthday") != null) 
this.setBirthday(actionRequest.getFieldValue(i, "birthday"));
if (actionRequest.getFieldValue(i, "hj") != null) 
this.setHj(actionRequest.getFieldValue(i, "hj"));
if (actionRequest.getFieldValue(i, "sfxy") != null) 
this.setSfxy(actionRequest.getFieldValue(i, "sfxy"));
if (actionRequest.getFieldValue(i, "xyqk") != null) 
this.setXyqk(actionRequest.getFieldValue(i, "xyqk"));
if (actionRequest.getFieldValue(i, "grah") != null) 
this.setGrah(actionRequest.getFieldValue(i, "grah"));
if (actionRequest.getFieldValue(i, "jws") != null) 
this.setJws(actionRequest.getFieldValue(i, "jws"));
if (actionRequest.getFieldValue(i, "hzdate") != null) 
this.setHzdate(actionRequest.getFieldValue(i, "hzdate"));
if (actionRequest.getFieldValue(i, "yxq") != null) 
this.setYxq(actionRequest.getFieldValue(i, "yxq"));
if (actionRequest.getFieldValue(i, "zsno") != null) 
this.setZsno(actionRequest.getFieldValue(i, "zsno"));
if (actionRequest.getFieldValue(i, "remark") != null) 
this.setRemark(actionRequest.getFieldValue(i, "remark"));
if (actionRequest.getFieldValue(i, "wfwzjl") != null) 
this.setWfwzjl(actionRequest.getFieldValue(i, "wfwzjl"));
if (actionRequest.getFieldValue(i, "zrsgjl") != null) 
this.setZrsgjl(actionRequest.getFieldValue(i, "zrsgjl"));
if (actionRequest.getFieldValue(i, "beizhu") != null) 
this.setBeizhu(actionRequest.getFieldValue(i, "beizhu"));
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
if (actionRequest.getFieldValue(i, "whys") != null) 
this.setWhys(actionRequest.getFieldValue(i, "whys"));
if (actionRequest.getFieldValue(i, "whysname") != null) 
this.setWhysname(actionRequest.getFieldValue(i, "whysname"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyryxxBean obj = (QyryxxBean)super.clone();obj.setSysno(obj.sysno);
obj.setEnterno(obj.enterno);
obj.setEnternm(obj.enternm);
obj.setName(obj.name);
obj.setPxjgno(obj.pxjgno);
obj.setPxjgmc(obj.pxjgmc);
obj.setSex(obj.sex);
obj.setIdcard(obj.idcard);
obj.setDeptname(obj.deptname);
obj.setDeptno(obj.deptno);
obj.setGz(obj.gz);
obj.setZw(obj.zw);
obj.setWhcd(obj.whcd);
obj.setSxzy(obj.sxzy);
obj.setLxdh(obj.lxdh);
obj.setByyx(obj.byyx);
obj.setClzdate(obj.clzdate);
obj.setBirthday(obj.birthday);
obj.setHj(obj.hj);
obj.setSfxy(obj.sfxy);
obj.setXyqk(obj.xyqk);
obj.setGrah(obj.grah);
obj.setJws(obj.jws);
obj.setHzdate(obj.hzdate);
obj.setYxq(obj.yxq);
obj.setZsno(obj.zsno);
obj.setRemark(obj.remark);
obj.setWfwzjl(obj.wfwzjl);
obj.setZrsgjl(obj.zrsgjl);
obj.setBeizhu(obj.beizhu);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
obj.setWhys(obj.whys);
obj.setWhysname(obj.whysname);
return obj;}}