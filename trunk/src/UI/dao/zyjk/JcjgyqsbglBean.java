package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class JcjgyqsbglBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new JcjgyqsbglBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new JcjgyqsbglBean().findAndLockByWhere(sSqlWhere);      }       public static JcjgyqsbglBean findFirst(String sSqlWhere)throws Exception {           return (JcjgyqsbglBean)new JcjgyqsbglBean().findFirstByWhere(sSqlWhere);      }       public static JcjgyqsbglBean findFirstAndLock(String sSqlWhere)throws Exception {           return (JcjgyqsbglBean)new JcjgyqsbglBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new JcjgyqsbglBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgyqsbglBean bean = new JcjgyqsbglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcjgyqsbglBean bean = new JcjgyqsbglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static JcjgyqsbglBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgyqsbglBean bean = new JcjgyqsbglBean();           bean.setAutoRelease(isAutoRelease);           return (JcjgyqsbglBean)bean.findFirstByWhere(sSqlWhere);      }       public static JcjgyqsbglBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           JcjgyqsbglBean bean = new JcjgyqsbglBean();           bean.setAutoRelease(isAutoRelease);           return (JcjgyqsbglBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           JcjgyqsbglBean bean = new JcjgyqsbglBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  jgbh;
String  jgmc;
String  no;
String  sbmc;
String  ggxh;
String  sl;
String  mpbh;
String  sccj;
String  gmrq;
String  jd;
String  yt;
String  zjjdrq;
String  jdzq;
String  state;
String  zgbh;
String  zgxm;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="jcjgyqsbgl";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
JcjgyqsbglBean abb = new JcjgyqsbglBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.jgbh=rs.getString("jgbh");
abb.setKeyValue("JGBH","" + abb.getJgbh());
abb.jgmc=rs.getString("jgmc");
abb.setKeyValue("JGMC","" + abb.getJgmc());
abb.no=rs.getString("no");
abb.setKeyValue("NO","" + abb.getNo());
abb.sbmc=rs.getString("sbmc");
abb.setKeyValue("SBMC","" + abb.getSbmc());
abb.ggxh=rs.getString("ggxh");
abb.setKeyValue("GGXH","" + abb.getGgxh());
abb.sl=rs.getString("sl");
abb.setKeyValue("SL","" + abb.getSl());
abb.mpbh=rs.getString("mpbh");
abb.setKeyValue("MPBH","" + abb.getMpbh());
abb.sccj=rs.getString("sccj");
abb.setKeyValue("SCCJ","" + abb.getSccj());
abb.gmrq=rs.getString("gmrq");
abb.setKeyValue("GMRQ","" + abb.getGmrq());
abb.jd=rs.getString("jd");
abb.setKeyValue("JD","" + abb.getJd());
abb.yt=rs.getString("yt");
abb.setKeyValue("YT","" + abb.getYt());
abb.zjjdrq=rs.getString("zjjdrq");
abb.setKeyValue("ZJJDRQ","" + abb.getZjjdrq());
abb.jdzq=rs.getString("jdzq");
abb.setKeyValue("JDZQ","" + abb.getJdzq());
abb.state=rs.getString("state");
abb.setKeyValue("STATE","" + abb.getState());
abb.zgbh=rs.getString("zgbh");
abb.setKeyValue("ZGBH","" + abb.getZgbh());
abb.zgxm=rs.getString("zgxm");
abb.setKeyValue("ZGXM","" + abb.getZgxm());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getJgbh(){ if ( this.jgbh == null){ return ""; } else {return this.jgbh;}}public String getJgmc(){ if ( this.jgmc == null){ return ""; } else {return this.jgmc;}}public String getNo(){ if ( this.no == null){ return ""; } else {return this.no;}}public String getSbmc(){ if ( this.sbmc == null){ return ""; } else {return this.sbmc;}}public String getGgxh(){ if ( this.ggxh == null){ return ""; } else {return this.ggxh;}}public String getSl(){ if ( this.sl == null){ return ""; } else {return this.sl;}}public String getMpbh(){ if ( this.mpbh == null){ return ""; } else {return this.mpbh;}}public String getSccj(){ if ( this.sccj == null){ return ""; } else {return this.sccj;}}public String getGmrq(){ if ( this.gmrq == null){ return ""; } else {return this.gmrq;}}public String getJd(){ if ( this.jd == null){ return ""; } else {return this.jd;}}public String getYt(){ if ( this.yt == null){ return ""; } else {return this.yt;}}public String getZjjdrq(){ if ( this.zjjdrq == null){ return ""; } else {return this.zjjdrq;}}public String getJdzq(){ if ( this.jdzq == null){ return ""; } else {return this.jdzq;}}public String getState(){ if ( this.state == null){ return ""; } else {return this.state;}}public String getZgbh(){ if ( this.zgbh == null){ return ""; } else {return this.zgbh;}}public String getZgxm(){ if ( this.zgxm == null){ return ""; } else {return this.zgxm;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setNo( String no){sqlMaker.setField("no",no,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNo().equals(no))
cf.add("no",this.no,no);
}
this.no=no;
}
public void setSbmc( String sbmc){sqlMaker.setField("sbmc",sbmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSbmc().equals(sbmc))
cf.add("sbmc",this.sbmc,sbmc);
}
this.sbmc=sbmc;
}
public void setGgxh( String ggxh){sqlMaker.setField("ggxh",ggxh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGgxh().equals(ggxh))
cf.add("ggxh",this.ggxh,ggxh);
}
this.ggxh=ggxh;
}
public void setSl( String sl){sqlMaker.setField("sl",sl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSl().equals(sl))
cf.add("sl",this.sl,sl);
}
this.sl=sl;
}
public void setMpbh( String mpbh){sqlMaker.setField("mpbh",mpbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMpbh().equals(mpbh))
cf.add("mpbh",this.mpbh,mpbh);
}
this.mpbh=mpbh;
}
public void setSccj( String sccj){sqlMaker.setField("sccj",sccj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSccj().equals(sccj))
cf.add("sccj",this.sccj,sccj);
}
this.sccj=sccj;
}
public void setGmrq( String gmrq){sqlMaker.setField("gmrq",gmrq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGmrq().equals(gmrq))
cf.add("gmrq",this.gmrq,gmrq);
}
this.gmrq=gmrq;
}
public void setJd( String jd){sqlMaker.setField("jd",jd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJd().equals(jd))
cf.add("jd",this.jd,jd);
}
this.jd=jd;
}
public void setYt( String yt){sqlMaker.setField("yt",yt,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYt().equals(yt))
cf.add("yt",this.yt,yt);
}
this.yt=yt;
}
public void setZjjdrq( String zjjdrq){sqlMaker.setField("zjjdrq",zjjdrq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZjjdrq().equals(zjjdrq))
cf.add("zjjdrq",this.zjjdrq,zjjdrq);
}
this.zjjdrq=zjjdrq;
}
public void setJdzq( String jdzq){sqlMaker.setField("jdzq",jdzq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJdzq().equals(jdzq))
cf.add("jdzq",this.jdzq,jdzq);
}
this.jdzq=jdzq;
}
public void setState( String state){sqlMaker.setField("state",state,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getState().equals(state))
cf.add("state",this.state,state);
}
this.state=state;
}
public void setZgbh( String zgbh){sqlMaker.setField("zgbh",zgbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZgbh().equals(zgbh))
cf.add("zgbh",this.zgbh,zgbh);
}
this.zgbh=zgbh;
}
public void setZgxm( String zgxm){sqlMaker.setField("zgxm",zgxm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZgxm().equals(zgxm))
cf.add("zgxm",this.zgxm,zgxm);
}
this.zgxm=zgxm;
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
if (actionRequest.getFieldValue(i, "no") != null) 
this.setNo(actionRequest.getFieldValue(i, "no"));
if (actionRequest.getFieldValue(i, "sbmc") != null) 
this.setSbmc(actionRequest.getFieldValue(i, "sbmc"));
if (actionRequest.getFieldValue(i, "ggxh") != null) 
this.setGgxh(actionRequest.getFieldValue(i, "ggxh"));
if (actionRequest.getFieldValue(i, "sl") != null) 
this.setSl(actionRequest.getFieldValue(i, "sl"));
if (actionRequest.getFieldValue(i, "mpbh") != null) 
this.setMpbh(actionRequest.getFieldValue(i, "mpbh"));
if (actionRequest.getFieldValue(i, "sccj") != null) 
this.setSccj(actionRequest.getFieldValue(i, "sccj"));
if (actionRequest.getFieldValue(i, "gmrq") != null) 
this.setGmrq(actionRequest.getFieldValue(i, "gmrq"));
if (actionRequest.getFieldValue(i, "jd") != null) 
this.setJd(actionRequest.getFieldValue(i, "jd"));
if (actionRequest.getFieldValue(i, "yt") != null) 
this.setYt(actionRequest.getFieldValue(i, "yt"));
if (actionRequest.getFieldValue(i, "zjjdrq") != null) 
this.setZjjdrq(actionRequest.getFieldValue(i, "zjjdrq"));
if (actionRequest.getFieldValue(i, "jdzq") != null) 
this.setJdzq(actionRequest.getFieldValue(i, "jdzq"));
if (actionRequest.getFieldValue(i, "state") != null) 
this.setState(actionRequest.getFieldValue(i, "state"));
if (actionRequest.getFieldValue(i, "zgbh") != null) 
this.setZgbh(actionRequest.getFieldValue(i, "zgbh"));
if (actionRequest.getFieldValue(i, "zgxm") != null) 
this.setZgxm(actionRequest.getFieldValue(i, "zgxm"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { JcjgyqsbglBean obj = (JcjgyqsbglBean)super.clone();obj.setSysno(obj.sysno);
obj.setJgbh(obj.jgbh);
obj.setJgmc(obj.jgmc);
obj.setNo(obj.no);
obj.setSbmc(obj.sbmc);
obj.setGgxh(obj.ggxh);
obj.setSl(obj.sl);
obj.setMpbh(obj.mpbh);
obj.setSccj(obj.sccj);
obj.setGmrq(obj.gmrq);
obj.setJd(obj.jd);
obj.setYt(obj.yt);
obj.setZjjdrq(obj.zjjdrq);
obj.setJdzq(obj.jdzq);
obj.setState(obj.state);
obj.setZgbh(obj.zgbh);
obj.setZgxm(obj.zgxm);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}