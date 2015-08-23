package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QygzzdBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QygzzdBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QygzzdBean().findAndLockByWhere(sSqlWhere);      }       public static QygzzdBean findFirst(String sSqlWhere)throws Exception {           return (QygzzdBean)new QygzzdBean().findFirstByWhere(sSqlWhere);      }       public static QygzzdBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QygzzdBean)new QygzzdBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QygzzdBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QygzzdBean bean = new QygzzdBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QygzzdBean bean = new QygzzdBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QygzzdBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QygzzdBean bean = new QygzzdBean();           bean.setAutoRelease(isAutoRelease);           return (QygzzdBean)bean.findFirstByWhere(sSqlWhere);      }       public static QygzzdBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QygzzdBean bean = new QygzzdBean();           bean.setAutoRelease(isAutoRelease);           return (QygzzdBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QygzzdBean bean = new QygzzdBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  sysno;
String  enterno;
String  gzzdlb;
String  fjpath;
String  scdate;
String  editdate;
String  gbdd;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
public static final String TABLENAME ="qygzzd";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QygzzdBean abb = new QygzzdBean();
abb.sysno=rs.getString("sysno");
abb.setKeyValue("SYSNO","" + abb.getSysno());
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.gzzdlb=rs.getString("gzzdlb");
abb.setKeyValue("GZZDLB","" + abb.getGzzdlb());
abb.fjpath=rs.getString("fjpath");
abb.setKeyValue("FJPATH","" + abb.getFjpath());
abb.scdate=rs.getString("scdate");
abb.setKeyValue("SCDATE","" + abb.getScdate());
abb.editdate=rs.getString("editdate");
abb.setKeyValue("EDITDATE","" + abb.getEditdate());
abb.gbdd=rs.getString("gbdd");
abb.setKeyValue("GBDD","" + abb.getGbdd());
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
}public String getSysno(){ if ( this.sysno == null){ return ""; } else {return this.sysno;}}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getGzzdlb(){ if ( this.gzzdlb == null){ return ""; } else {return this.gzzdlb;}}public String getFjpath(){ if ( this.fjpath == null){ return ""; } else {return this.fjpath;}}public String getScdate(){ if ( this.scdate == null){ return ""; } else {return this.scdate;}}public String getEditdate(){ if ( this.editdate == null){ return ""; } else {return this.editdate;}}public String getGbdd(){ if ( this.gbdd == null){ return ""; } else {return this.gbdd;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public void setSysno( String sysno){sqlMaker.setField("sysno",sysno,Field.TEXT);
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
public void setGzzdlb( String gzzdlb){sqlMaker.setField("gzzdlb",gzzdlb,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGzzdlb().equals(gzzdlb))
cf.add("gzzdlb",this.gzzdlb,gzzdlb);
}
this.gzzdlb=gzzdlb;
}
public void setFjpath( String fjpath){sqlMaker.setField("fjpath",fjpath,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFjpath().equals(fjpath))
cf.add("fjpath",this.fjpath,fjpath);
}
this.fjpath=fjpath;
}
public void setScdate( String scdate){sqlMaker.setField("scdate",scdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScdate().equals(scdate))
cf.add("scdate",this.scdate,scdate);
}
this.scdate=scdate;
}
public void setEditdate( String editdate){sqlMaker.setField("editdate",editdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEditdate().equals(editdate))
cf.add("editdate",this.editdate,editdate);
}
this.editdate=editdate;
}
public void setGbdd( String gbdd){sqlMaker.setField("gbdd",gbdd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGbdd().equals(gbdd))
cf.add("gbdd",this.gbdd,gbdd);
}
this.gbdd=gbdd;
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
if (actionRequest.getFieldValue(i, "gzzdlb") != null) 
this.setGzzdlb(actionRequest.getFieldValue(i, "gzzdlb"));
if (actionRequest.getFieldValue(i, "fjpath") != null) 
this.setFjpath(actionRequest.getFieldValue(i, "fjpath"));
if (actionRequest.getFieldValue(i, "scdate") != null) 
this.setScdate(actionRequest.getFieldValue(i, "scdate"));
if (actionRequest.getFieldValue(i, "editdate") != null) 
this.setEditdate(actionRequest.getFieldValue(i, "editdate"));
if (actionRequest.getFieldValue(i, "gbdd") != null) 
this.setGbdd(actionRequest.getFieldValue(i, "gbdd"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QygzzdBean obj = (QygzzdBean)super.clone();obj.setSysno(obj.sysno);
obj.setEnterno(obj.enterno);
obj.setGzzdlb(obj.gzzdlb);
obj.setFjpath(obj.fjpath);
obj.setScdate(obj.scdate);
obj.setEditdate(obj.editdate);
obj.setGbdd(obj.gbdd);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
return obj;}}