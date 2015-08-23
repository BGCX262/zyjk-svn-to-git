package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyzybfhssBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyzybfhssBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyzybfhssBean().findAndLockByWhere(sSqlWhere);      }       public static QyzybfhssBean findFirst(String sSqlWhere)throws Exception {           return (QyzybfhssBean)new QyzybfhssBean().findFirstByWhere(sSqlWhere);      }       public static QyzybfhssBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyzybfhssBean)new QyzybfhssBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyzybfhssBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybfhssBean bean = new QyzybfhssBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzybfhssBean bean = new QyzybfhssBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyzybfhssBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybfhssBean bean = new QyzybfhssBean();           bean.setAutoRelease(isAutoRelease);           return (QyzybfhssBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyzybfhssBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyzybfhssBean bean = new QyzybfhssBean();           bean.setAutoRelease(isAutoRelease);           return (QyzybfhssBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyzybfhssBean bean = new QyzybfhssBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  enterno;
String  entername;
String  no;
String  fhssmc;
String  sbbh;
String  xh;
String  ffgn;
String  szcj;
String  cjbh;
String  szbw;
String  whzq;
String  tyrq;
String  whry;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qyzybfhss";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyzybfhssBean abb = new QyzybfhssBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.entername=rs.getString("entername");
abb.setKeyValue("ENTERNAME","" + abb.getEntername());
abb.no=rs.getString("no");
abb.setKeyValue("NO","" + abb.getNo());
abb.fhssmc=rs.getString("fhssmc");
abb.setKeyValue("FHSSMC","" + abb.getFhssmc());
abb.sbbh=rs.getString("sbbh");
abb.setKeyValue("SBBH","" + abb.getSbbh());
abb.xh=rs.getString("xh");
abb.setKeyValue("XH","" + abb.getXh());
abb.ffgn=rs.getString("ffgn");
abb.setKeyValue("FFGN","" + abb.getFfgn());
abb.szcj=rs.getString("szcj");
abb.setKeyValue("SZCJ","" + abb.getSzcj());
abb.cjbh=rs.getString("cjbh");
abb.setKeyValue("CJBH","" + abb.getCjbh());
abb.szbw=rs.getString("szbw");
abb.setKeyValue("SZBW","" + abb.getSzbw());
abb.whzq=rs.getString("whzq");
abb.setKeyValue("WHZQ","" + abb.getWhzq());
abb.tyrq=rs.getString("tyrq");
abb.setKeyValue("TYRQ","" + abb.getTyrq());
abb.whry=rs.getString("whry");
abb.setKeyValue("WHRY","" + abb.getWhry());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getEntername(){ if ( this.entername == null){ return ""; } else {return this.entername;}}public String getNo(){ if ( this.no == null){ return ""; } else {return this.no;}}public String getFhssmc(){ if ( this.fhssmc == null){ return ""; } else {return this.fhssmc;}}public String getSbbh(){ if ( this.sbbh == null){ return ""; } else {return this.sbbh;}}public String getXh(){ if ( this.xh == null){ return ""; } else {return this.xh;}}public String getFfgn(){ if ( this.ffgn == null){ return ""; } else {return this.ffgn;}}public String getSzcj(){ if ( this.szcj == null){ return ""; } else {return this.szcj;}}public String getCjbh(){ if ( this.cjbh == null){ return ""; } else {return this.cjbh;}}public String getSzbw(){ if ( this.szbw == null){ return ""; } else {return this.szbw;}}public String getWhzq(){ if ( this.whzq == null){ return ""; } else {return this.whzq;}}public String getTyrq(){ if ( this.tyrq == null){ return ""; } else {return this.tyrq;}}public String getWhry(){ if ( this.whry == null){ return ""; } else {return this.whry;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setNo( String no){sqlMaker.setField("no",no,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNo().equals(no))
cf.add("no",this.no,no);
}
this.no=no;
}
public void setFhssmc( String fhssmc){sqlMaker.setField("fhssmc",fhssmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFhssmc().equals(fhssmc))
cf.add("fhssmc",this.fhssmc,fhssmc);
}
this.fhssmc=fhssmc;
}
public void setSbbh( String sbbh){sqlMaker.setField("sbbh",sbbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSbbh().equals(sbbh))
cf.add("sbbh",this.sbbh,sbbh);
}
this.sbbh=sbbh;
}
public void setXh( String xh){sqlMaker.setField("xh",xh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getXh().equals(xh))
cf.add("xh",this.xh,xh);
}
this.xh=xh;
}
public void setFfgn( String ffgn){sqlMaker.setField("ffgn",ffgn,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFfgn().equals(ffgn))
cf.add("ffgn",this.ffgn,ffgn);
}
this.ffgn=ffgn;
}
public void setSzcj( String szcj){sqlMaker.setField("szcj",szcj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSzcj().equals(szcj))
cf.add("szcj",this.szcj,szcj);
}
this.szcj=szcj;
}
public void setCjbh( String cjbh){sqlMaker.setField("cjbh",cjbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCjbh().equals(cjbh))
cf.add("cjbh",this.cjbh,cjbh);
}
this.cjbh=cjbh;
}
public void setSzbw( String szbw){sqlMaker.setField("szbw",szbw,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSzbw().equals(szbw))
cf.add("szbw",this.szbw,szbw);
}
this.szbw=szbw;
}
public void setWhzq( String whzq){sqlMaker.setField("whzq",whzq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhzq().equals(whzq))
cf.add("whzq",this.whzq,whzq);
}
this.whzq=whzq;
}
public void setTyrq( String tyrq){sqlMaker.setField("tyrq",tyrq,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTyrq().equals(tyrq))
cf.add("tyrq",this.tyrq,tyrq);
}
this.tyrq=tyrq;
}
public void setWhry( String whry){sqlMaker.setField("whry",whry,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhry().equals(whry))
cf.add("whry",this.whry,whry);
}
this.whry=whry;
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
if (actionRequest.getFieldValue(i, "no") != null) 
this.setNo(actionRequest.getFieldValue(i, "no"));
if (actionRequest.getFieldValue(i, "fhssmc") != null) 
this.setFhssmc(actionRequest.getFieldValue(i, "fhssmc"));
if (actionRequest.getFieldValue(i, "sbbh") != null) 
this.setSbbh(actionRequest.getFieldValue(i, "sbbh"));
if (actionRequest.getFieldValue(i, "xh") != null) 
this.setXh(actionRequest.getFieldValue(i, "xh"));
if (actionRequest.getFieldValue(i, "ffgn") != null) 
this.setFfgn(actionRequest.getFieldValue(i, "ffgn"));
if (actionRequest.getFieldValue(i, "szcj") != null) 
this.setSzcj(actionRequest.getFieldValue(i, "szcj"));
if (actionRequest.getFieldValue(i, "cjbh") != null) 
this.setCjbh(actionRequest.getFieldValue(i, "cjbh"));
if (actionRequest.getFieldValue(i, "szbw") != null) 
this.setSzbw(actionRequest.getFieldValue(i, "szbw"));
if (actionRequest.getFieldValue(i, "whzq") != null) 
this.setWhzq(actionRequest.getFieldValue(i, "whzq"));
if (actionRequest.getFieldValue(i, "tyrq") != null) 
this.setTyrq(actionRequest.getFieldValue(i, "tyrq"));
if (actionRequest.getFieldValue(i, "whry") != null) 
this.setWhry(actionRequest.getFieldValue(i, "whry"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyzybfhssBean obj = (QyzybfhssBean)super.clone();obj.setSysno(obj.sysno);
obj.setEnterno(obj.enterno);
obj.setEntername(obj.entername);
obj.setNo(obj.no);
obj.setFhssmc(obj.fhssmc);
obj.setSbbh(obj.sbbh);
obj.setXh(obj.xh);
obj.setFfgn(obj.ffgn);
obj.setSzcj(obj.szcj);
obj.setCjbh(obj.cjbh);
obj.setSzbw(obj.szbw);
obj.setWhzq(obj.whzq);
obj.setTyrq(obj.tyrq);
obj.setWhry(obj.whry);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}