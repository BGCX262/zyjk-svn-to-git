package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class T_diquBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new T_diquBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new T_diquBean().findAndLockByWhere(sSqlWhere);      }       public static T_diquBean findFirst(String sSqlWhere)throws Exception {           return (T_diquBean)new T_diquBean().findFirstByWhere(sSqlWhere);      }       public static T_diquBean findFirstAndLock(String sSqlWhere)throws Exception {           return (T_diquBean)new T_diquBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new T_diquBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_diquBean bean = new T_diquBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           T_diquBean bean = new T_diquBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static T_diquBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_diquBean bean = new T_diquBean();           bean.setAutoRelease(isAutoRelease);           return (T_diquBean)bean.findFirstByWhere(sSqlWhere);      }       public static T_diquBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           T_diquBean bean = new T_diquBean();           bean.setAutoRelease(isAutoRelease);           return (T_diquBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           T_diquBean bean = new T_diquBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  dqbh;
String  dqdj;
String  dqmc;
String  sjdqbh;
public static final String TABLENAME ="t_diqu";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
T_diquBean abb = new T_diquBean();
abb.dqbh=rs.getString("dqbh");
abb.setKeyValue("DQBH","" + abb.getDqbh());
abb.dqdj=rs.getString("dqdj");
abb.setKeyValue("DQDJ","" + abb.getDqdj());
abb.dqmc=rs.getString("dqmc");
abb.setKeyValue("DQMC","" + abb.getDqmc());
abb.sjdqbh=rs.getString("sjdqbh");
abb.setKeyValue("SJDQBH","" + abb.getSjdqbh());
list.add(abb);
abb.operate_mode = "edit";
}public String getDqbh(){ if ( this.dqbh == null){ return ""; } else {return this.dqbh;}}public String getDqdj(){ if ( this.dqdj == null){ return ""; } else {return this.dqdj;}}public String getDqmc(){ if ( this.dqmc == null){ return ""; } else {return this.dqmc;}}public String getSjdqbh(){ if ( this.sjdqbh == null){ return ""; } else {return this.sjdqbh;}}public void setDqbh( String dqbh){sqlMaker.setField("dqbh",dqbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDqbh().equals(dqbh))
cf.add("dqbh",this.dqbh,dqbh);
}
this.dqbh=dqbh;
}
public void setDqdj( String dqdj){sqlMaker.setField("dqdj",dqdj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDqdj().equals(dqdj))
cf.add("dqdj",this.dqdj,dqdj);
}
this.dqdj=dqdj;
}
public void setDqmc( String dqmc){sqlMaker.setField("dqmc",dqmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDqmc().equals(dqmc))
cf.add("dqmc",this.dqmc,dqmc);
}
this.dqmc=dqmc;
}
public void setSjdqbh( String sjdqbh){sqlMaker.setField("sjdqbh",sjdqbh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSjdqbh().equals(sjdqbh))
cf.add("sjdqbh",this.sjdqbh,sjdqbh);
}
this.sjdqbh=sjdqbh;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "dqbh") != null) 
this.setDqbh(actionRequest.getFieldValue(i, "dqbh"));
if (actionRequest.getFieldValue(i, "dqdj") != null) 
this.setDqdj(actionRequest.getFieldValue(i, "dqdj"));
if (actionRequest.getFieldValue(i, "dqmc") != null) 
this.setDqmc(actionRequest.getFieldValue(i, "dqmc"));
if (actionRequest.getFieldValue(i, "sjdqbh") != null) 
this.setSjdqbh(actionRequest.getFieldValue(i, "sjdqbh"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { T_diquBean obj = (T_diquBean)super.clone();obj.setDqbh(obj.dqbh);
obj.setDqdj(obj.dqdj);
obj.setDqmc(obj.dqmc);
obj.setSjdqbh(obj.sjdqbh);
return obj;}}