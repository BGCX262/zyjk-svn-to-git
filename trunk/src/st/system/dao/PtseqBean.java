package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtseqBean extends AbstractBasicBean implements Cloneable {
     /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static List find(String sSqlWhere) throws Exception{           return new PtseqBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtseqBean().findAndLockByWhere(sSqlWhere);      }       public static PtseqBean findFirst(String sSqlWhere)throws Exception {           return (PtseqBean)new PtseqBean().findFirstByWhere(sSqlWhere);      }       public static PtseqBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtseqBean)new PtseqBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtseqBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtseqBean bean = new PtseqBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtseqBean bean = new PtseqBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtseqBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtseqBean bean = new PtseqBean();           bean.setAutoRelease(isAutoRelease);           return (PtseqBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtseqBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtseqBean bean = new PtseqBean();           bean.setAutoRelease(isAutoRelease);           return (PtseqBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtseqBean bean = new PtseqBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  seqno;
String  seqtype;
String  ldate;
String  basnum;
String  nums;
String  memo;
public static final String TABLENAME ="ptseq";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
@SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtseqBean abb = new PtseqBean();
abb.seqno=rs.getString("seqno");
abb.setKeyValue("SEQNO","" + abb.getSeqno());
abb.seqtype=rs.getString("seqtype");
abb.setKeyValue("SEQTYPE","" + abb.getSeqtype());
abb.ldate=rs.getString("ldate");
abb.setKeyValue("LDATE","" + abb.getLdate());
abb.basnum=rs.getString("basnum");
abb.setKeyValue("BASNUM","" + abb.getBasnum());
abb.nums=rs.getString("nums");
abb.setKeyValue("NUMS","" + abb.getNums());
abb.memo=rs.getString("memo");
abb.setKeyValue("MEMO","" + abb.getMemo());
list.add(abb);
abb.operate_mode = "edit";
}public String getSeqno(){ if ( this.seqno == null){ return ""; } else {return this.seqno;}}public String getSeqtype(){ if ( this.seqtype == null){ return ""; } else {return this.seqtype;}}public String getLdate(){ if ( this.ldate == null){ return ""; } else {return this.ldate;}}public String getBasnum(){ if ( this.basnum == null){ return ""; } else {return this.basnum;}}public String getNums(){ if ( this.nums == null){ return ""; } else {return this.nums;}}public String getMemo(){ if ( this.memo == null){ return ""; } else {return this.memo;}}public void setSeqno( String seqno){sqlMaker.setField("seqno",seqno,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getSeqno().equals(seqno))
cf.add("seqno",this.seqno,seqno);
}
this.seqno=seqno;
}
public void setSeqtype( String seqtype){sqlMaker.setField("seqtype",seqtype,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSeqtype().equals(seqtype))
cf.add("seqtype",this.seqtype,seqtype);
}
this.seqtype=seqtype;
}
public void setLdate( String ldate){sqlMaker.setField("ldate",ldate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLdate().equals(ldate))
cf.add("ldate",this.ldate,ldate);
}
this.ldate=ldate;
}
public void setBasnum( String basnum){sqlMaker.setField("basnum",basnum,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getBasnum().equals(basnum))
cf.add("basnum",this.basnum,basnum);
}
this.basnum=basnum;
}
public void setNums( String nums){sqlMaker.setField("nums",nums,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getNums().equals(nums))
cf.add("nums",this.nums,nums);
}
this.nums=nums;
}
public void setMemo( String memo){sqlMaker.setField("memo",memo,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMemo().equals(memo))
cf.add("memo",this.memo,memo);
}
this.memo=memo;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "seqno") != null) 
this.setSeqno(actionRequest.getFieldValue(i, "seqno"));
if (actionRequest.getFieldValue(i, "seqtype") != null) 
this.setSeqtype(actionRequest.getFieldValue(i, "seqtype"));
if (actionRequest.getFieldValue(i, "ldate") != null) 
this.setLdate(actionRequest.getFieldValue(i, "ldate"));
if (actionRequest.getFieldValue(i, "basnum") != null) 
this.setBasnum(actionRequest.getFieldValue(i, "basnum"));
if (actionRequest.getFieldValue(i, "nums") != null) 
this.setNums(actionRequest.getFieldValue(i, "nums"));
if (actionRequest.getFieldValue(i, "memo") != null) 
this.setMemo(actionRequest.getFieldValue(i, "memo"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtseqBean obj = (PtseqBean)super.clone();obj.setSeqno(obj.seqno);
obj.setSeqtype(obj.seqtype);
obj.setLdate(obj.ldate);
obj.setBasnum(obj.basnum);
obj.setNums(obj.nums);
obj.setMemo(obj.memo);
return obj;}}