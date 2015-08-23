package UI.dao.zyjk;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class T_officerBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new T_officerBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new T_officerBean().findAndLockByWhere(sSqlWhere);      }       public static T_officerBean findFirst(String sSqlWhere)throws Exception {           return (T_officerBean)new T_officerBean().findFirstByWhere(sSqlWhere);      }       public static T_officerBean findFirstAndLock(String sSqlWhere)throws Exception {           return (T_officerBean)new T_officerBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new T_officerBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_officerBean bean = new T_officerBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           T_officerBean bean = new T_officerBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static T_officerBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_officerBean bean = new T_officerBean();           bean.setAutoRelease(isAutoRelease);           return (T_officerBean)bean.findFirstByWhere(sSqlWhere);      }       public static T_officerBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           T_officerBean bean = new T_officerBean();           bean.setAutoRelease(isAutoRelease);           return (T_officerBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_officerBean bean = new T_officerBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  officer_id;
String  login_id;
String  officer_name;
String  p_jyj;
String  p_zh;
String  c_pwd;
String  c_check;
String  dept_type;
String  dq_code;
String  dq1;
String  dq2;
String  dq3;
String  dq4;
String  wghcode1;
String  wghcode2;
String  wghcode3;
String  wghcode4;
String  wghcode5;
String  glsysno;
public static final String TABLENAME ="t_officer";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
T_officerBean abb = new T_officerBean();
abb.officer_id=rs.getString("officer_id");
abb.setKeyValue("OFFICER_ID","" + abb.getOfficer_id());
abb.login_id=rs.getString("login_id");
abb.setKeyValue("LOGIN_ID","" + abb.getLogin_id());
abb.officer_name=rs.getString("officer_name");
abb.setKeyValue("OFFICER_NAME","" + abb.getOfficer_name());
abb.p_jyj=rs.getString("p_jyj");
abb.setKeyValue("P_JYJ","" + abb.getP_jyj());
abb.p_zh=rs.getString("p_zh");
abb.setKeyValue("P_ZH","" + abb.getP_zh());
abb.c_pwd=rs.getString("c_pwd");
abb.setKeyValue("C_PWD","" + abb.getC_pwd());
abb.c_check=rs.getString("c_check");
abb.setKeyValue("C_CHECK","" + abb.getC_check());
abb.dept_type=rs.getString("dept_type");
abb.setKeyValue("DEPT_TYPE","" + abb.getDept_type());
abb.dq_code=rs.getString("dq_code");
abb.setKeyValue("DQ_CODE","" + abb.getDq_code());
abb.dq1=rs.getString("dq1");
abb.setKeyValue("DQ1","" + abb.getDq1());
abb.dq2=rs.getString("dq2");
abb.setKeyValue("DQ2","" + abb.getDq2());
abb.dq3=rs.getString("dq3");
abb.setKeyValue("DQ3","" + abb.getDq3());
abb.dq4=rs.getString("dq4");
abb.setKeyValue("DQ4","" + abb.getDq4());
abb.wghcode1=rs.getString("wghcode1");
abb.setKeyValue("WGHCODE1","" + abb.getWghcode1());
abb.wghcode2=rs.getString("wghcode2");
abb.setKeyValue("WGHCODE2","" + abb.getWghcode2());
abb.wghcode3=rs.getString("wghcode3");
abb.setKeyValue("WGHCODE3","" + abb.getWghcode3());
abb.wghcode4=rs.getString("wghcode4");
abb.setKeyValue("WGHCODE4","" + abb.getWghcode4());
abb.wghcode5=rs.getString("wghcode5");
abb.setKeyValue("WGHCODE5","" + abb.getWghcode5());
abb.glsysno=rs.getString("glsysno");
abb.setKeyValue("GLSYSNO","" + abb.getGlsysno());
list.add(abb);
abb.operate_mode = "edit";
}public String getOfficer_id(){ if ( this.officer_id == null){ return ""; } else {return this.officer_id;}}public String getLogin_id(){ if ( this.login_id == null){ return ""; } else {return this.login_id;}}public String getOfficer_name(){ if ( this.officer_name == null){ return ""; } else {return this.officer_name;}}public String getP_jyj(){ if ( this.p_jyj == null){ return ""; } else {return this.p_jyj;}}public String getP_zh(){ if ( this.p_zh == null){ return ""; } else {return this.p_zh;}}public String getC_pwd(){ if ( this.c_pwd == null){ return ""; } else {return this.c_pwd;}}public String getC_check(){ if ( this.c_check == null){ return ""; } else {return this.c_check;}}public String getDept_type(){ if ( this.dept_type == null){ return ""; } else {return this.dept_type;}}public String getDq_code(){ if ( this.dq_code == null){ return ""; } else {return this.dq_code;}}public String getDq1(){ if ( this.dq1 == null){ return ""; } else {return this.dq1;}}public String getDq2(){ if ( this.dq2 == null){ return ""; } else {return this.dq2;}}public String getDq3(){ if ( this.dq3 == null){ return ""; } else {return this.dq3;}}public String getDq4(){ if ( this.dq4 == null){ return ""; } else {return this.dq4;}}public String getWghcode1(){ if ( this.wghcode1 == null){ return ""; } else {return this.wghcode1;}}public String getWghcode2(){ if ( this.wghcode2 == null){ return ""; } else {return this.wghcode2;}}public String getWghcode3(){ if ( this.wghcode3 == null){ return ""; } else {return this.wghcode3;}}public String getWghcode4(){ if ( this.wghcode4 == null){ return ""; } else {return this.wghcode4;}}public String getWghcode5(){ if ( this.wghcode5 == null){ return ""; } else {return this.wghcode5;}}public String getGlsysno(){ if ( this.glsysno == null){ return ""; } else {return this.glsysno;}}public void setOfficer_id( String officer_id){sqlMaker.setField("officer_id",officer_id,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOfficer_id().equals(officer_id))
cf.add("officer_id",this.officer_id,officer_id);
}
this.officer_id=officer_id;
}
public void setLogin_id( String login_id){sqlMaker.setField("login_id",login_id,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLogin_id().equals(login_id))
cf.add("login_id",this.login_id,login_id);
}
this.login_id=login_id;
}
public void setOfficer_name( String officer_name){sqlMaker.setField("officer_name",officer_name,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOfficer_name().equals(officer_name))
cf.add("officer_name",this.officer_name,officer_name);
}
this.officer_name=officer_name;
}
public void setP_jyj( String p_jyj){sqlMaker.setField("p_jyj",p_jyj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getP_jyj().equals(p_jyj))
cf.add("p_jyj",this.p_jyj,p_jyj);
}
this.p_jyj=p_jyj;
}
public void setP_zh( String p_zh){sqlMaker.setField("p_zh",p_zh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getP_zh().equals(p_zh))
cf.add("p_zh",this.p_zh,p_zh);
}
this.p_zh=p_zh;
}
public void setC_pwd( String c_pwd){sqlMaker.setField("c_pwd",c_pwd,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getC_pwd().equals(c_pwd))
cf.add("c_pwd",this.c_pwd,c_pwd);
}
this.c_pwd=c_pwd;
}
public void setC_check( String c_check){sqlMaker.setField("c_check",c_check,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getC_check().equals(c_check))
cf.add("c_check",this.c_check,c_check);
}
this.c_check=c_check;
}
public void setDept_type( String dept_type){sqlMaker.setField("dept_type",dept_type,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDept_type().equals(dept_type))
cf.add("dept_type",this.dept_type,dept_type);
}
this.dept_type=dept_type;
}
public void setDq_code( String dq_code){sqlMaker.setField("dq_code",dq_code,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDq_code().equals(dq_code))
cf.add("dq_code",this.dq_code,dq_code);
}
this.dq_code=dq_code;
}
public void setDq1( String dq1){sqlMaker.setField("dq1",dq1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDq1().equals(dq1))
cf.add("dq1",this.dq1,dq1);
}
this.dq1=dq1;
}
public void setDq2( String dq2){sqlMaker.setField("dq2",dq2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDq2().equals(dq2))
cf.add("dq2",this.dq2,dq2);
}
this.dq2=dq2;
}
public void setDq3( String dq3){sqlMaker.setField("dq3",dq3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDq3().equals(dq3))
cf.add("dq3",this.dq3,dq3);
}
this.dq3=dq3;
}
public void setDq4( String dq4){sqlMaker.setField("dq4",dq4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDq4().equals(dq4))
cf.add("dq4",this.dq4,dq4);
}
this.dq4=dq4;
}
public void setWghcode1( String wghcode1){sqlMaker.setField("wghcode1",wghcode1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghcode1().equals(wghcode1))
cf.add("wghcode1",this.wghcode1,wghcode1);
}
this.wghcode1=wghcode1;
}
public void setWghcode2( String wghcode2){sqlMaker.setField("wghcode2",wghcode2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghcode2().equals(wghcode2))
cf.add("wghcode2",this.wghcode2,wghcode2);
}
this.wghcode2=wghcode2;
}
public void setWghcode3( String wghcode3){sqlMaker.setField("wghcode3",wghcode3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghcode3().equals(wghcode3))
cf.add("wghcode3",this.wghcode3,wghcode3);
}
this.wghcode3=wghcode3;
}
public void setWghcode4( String wghcode4){sqlMaker.setField("wghcode4",wghcode4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghcode4().equals(wghcode4))
cf.add("wghcode4",this.wghcode4,wghcode4);
}
this.wghcode4=wghcode4;
}
public void setWghcode5( String wghcode5){sqlMaker.setField("wghcode5",wghcode5,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghcode5().equals(wghcode5))
cf.add("wghcode5",this.wghcode5,wghcode5);
}
this.wghcode5=wghcode5;
}
public void setGlsysno( String glsysno){sqlMaker.setField("glsysno",glsysno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGlsysno().equals(glsysno))
cf.add("glsysno",this.glsysno,glsysno);
}
this.glsysno=glsysno;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "officer_id") != null) 
this.setOfficer_id(actionRequest.getFieldValue(i, "officer_id"));
if (actionRequest.getFieldValue(i, "login_id") != null) 
this.setLogin_id(actionRequest.getFieldValue(i, "login_id"));
if (actionRequest.getFieldValue(i, "officer_name") != null) 
this.setOfficer_name(actionRequest.getFieldValue(i, "officer_name"));
if (actionRequest.getFieldValue(i, "p_jyj") != null) 
this.setP_jyj(actionRequest.getFieldValue(i, "p_jyj"));
if (actionRequest.getFieldValue(i, "p_zh") != null) 
this.setP_zh(actionRequest.getFieldValue(i, "p_zh"));
if (actionRequest.getFieldValue(i, "c_pwd") != null) 
this.setC_pwd(actionRequest.getFieldValue(i, "c_pwd"));
if (actionRequest.getFieldValue(i, "c_check") != null) 
this.setC_check(actionRequest.getFieldValue(i, "c_check"));
if (actionRequest.getFieldValue(i, "dept_type") != null) 
this.setDept_type(actionRequest.getFieldValue(i, "dept_type"));
if (actionRequest.getFieldValue(i, "dq_code") != null) 
this.setDq_code(actionRequest.getFieldValue(i, "dq_code"));
if (actionRequest.getFieldValue(i, "dq1") != null) 
this.setDq1(actionRequest.getFieldValue(i, "dq1"));
if (actionRequest.getFieldValue(i, "dq2") != null) 
this.setDq2(actionRequest.getFieldValue(i, "dq2"));
if (actionRequest.getFieldValue(i, "dq3") != null) 
this.setDq3(actionRequest.getFieldValue(i, "dq3"));
if (actionRequest.getFieldValue(i, "dq4") != null) 
this.setDq4(actionRequest.getFieldValue(i, "dq4"));
if (actionRequest.getFieldValue(i, "wghcode1") != null) 
this.setWghcode1(actionRequest.getFieldValue(i, "wghcode1"));
if (actionRequest.getFieldValue(i, "wghcode2") != null) 
this.setWghcode2(actionRequest.getFieldValue(i, "wghcode2"));
if (actionRequest.getFieldValue(i, "wghcode3") != null) 
this.setWghcode3(actionRequest.getFieldValue(i, "wghcode3"));
if (actionRequest.getFieldValue(i, "wghcode4") != null) 
this.setWghcode4(actionRequest.getFieldValue(i, "wghcode4"));
if (actionRequest.getFieldValue(i, "wghcode5") != null) 
this.setWghcode5(actionRequest.getFieldValue(i, "wghcode5"));
if (actionRequest.getFieldValue(i, "glsysno") != null) 
this.setGlsysno(actionRequest.getFieldValue(i, "glsysno"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { T_officerBean obj = (T_officerBean)super.clone();obj.setOfficer_id(obj.officer_id);
obj.setLogin_id(obj.login_id);
obj.setOfficer_name(obj.officer_name);
obj.setP_jyj(obj.p_jyj);
obj.setP_zh(obj.p_zh);
obj.setC_pwd(obj.c_pwd);
obj.setC_check(obj.c_check);
obj.setDept_type(obj.dept_type);
obj.setDq_code(obj.dq_code);
obj.setDq1(obj.dq1);
obj.setDq2(obj.dq2);
obj.setDq3(obj.dq3);
obj.setDq4(obj.dq4);
obj.setWghcode1(obj.wghcode1);
obj.setWghcode2(obj.wghcode2);
obj.setWghcode3(obj.wghcode3);
obj.setWghcode4(obj.wghcode4);
obj.setWghcode5(obj.wghcode5);
obj.setGlsysno(obj.glsysno);
return obj;}}