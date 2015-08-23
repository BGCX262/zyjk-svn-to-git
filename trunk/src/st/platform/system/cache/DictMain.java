package st.platform.system.cache;

import java.util.Hashtable;

import st.platform.db.*;
import st.platform.utils.*;

public class DictMain {
	
	private Hashtable hashtable;
	private String fdatasetid;
	private String fdatasetname;
	private String fgridtype;
	private boolean fistotal;
	private boolean fischeck;
	private int      fpagesize;
	private boolean fbottomvisible;
	private boolean fisconfirmdelete;
	private boolean fisconfirmcancel;	
	private boolean fisdirectdelete;
	private String fwherestr;
	private String forderstr;
	private String fsqlstr;
	public boolean isFbottomvisible() {
		return fbottomvisible;
	}
	public void setFbottomvisible(boolean fbottomvisible) {
		this.fbottomvisible = fbottomvisible;
	}
	public String getFdatasetid() {
		return fdatasetid;
	}
	public void setFdatasetid(String fdatasetid) {
		this.fdatasetid = fdatasetid;
	}
	public String getFdatasetname() {
		return fdatasetname;
	}
	public void setFdatasetname(String fdatasetname) {
		this.fdatasetname = fdatasetname;
	}
	public String getFgridtype() {
		return fgridtype;
	}
	public void setFgridtype(String fgridtype) {
		this.fgridtype = fgridtype;
	}
	public boolean isFischeck() {
		return fischeck;
	}
	public void setFischeck(boolean fischeck) {
		this.fischeck = fischeck;
	}
	public boolean isFisconfirmcancel() {
		return fisconfirmcancel;
	}
	public void setFisconfirmcancel(boolean fisconfirmcancel) {
		this.fisconfirmcancel = fisconfirmcancel;
	}
	public boolean isFisconfirmdelete() {
		return fisconfirmdelete;
	}
	public void setFisconfirmdelete(boolean fisconfirmdelete) {
		this.fisconfirmdelete = fisconfirmdelete;
	}
	public boolean isFisdirectdelete() {
		return fisdirectdelete;
	}
	public void setFisdirectdelete(boolean fisdirectdelete) {
		this.fisdirectdelete = fisdirectdelete;
	}
	public boolean isFistotal() {
		return fistotal;
	}
	public void setFistotal(boolean fistotal) {
		this.fistotal = fistotal;
	}
	public String getForderstr() {
		return forderstr;
	}
	public void setForderstr(String forderstr) {
		this.forderstr = forderstr;
	}
	public int getFpagesize() {
		return fpagesize;
	}
	public void setFpagesize(int fpagesize) {
		this.fpagesize = fpagesize;
	}
	public String getFsqlstr() {
		return fsqlstr;
	}
	public void setFsqlstr(String fsqlstr) {
		this.fsqlstr = fsqlstr;
	}
	public String getFwherestr() {
		return fwherestr;
	}
	public void setFwherestr(String fwherestr) {
		this.fwherestr = fwherestr;
	}
	public Hashtable getHashtable() {
		return hashtable;
	}
	public void setHashtable(Hashtable hashtable) {
		this.hashtable = hashtable;
	}
	
	public void intiDictDetail()
	{    
		RecordSet commonRS;
        try {            
             RecordSet rs = DBUtil.getRecord("select * from ptdictdetail where datasetid='"+fdatasetid+"'");

             hashtable = new Hashtable();
           
             while(rs.next())
             {
            	  DictDetail dictDetail = new DictDetail();
            	  dictDetail.setFdatasetid(rs.getString("datasetid").trim());         	  
            	  
            	  dictDetail.setFfieldname(rs.getString("fieldname").trim());
            	  dictDetail.setFfieldlabel(rs.getString("fieldlabel").trim());
            	  dictDetail.setFfieldtype(rs.getString("fieldtype").trim());
            	  dictDetail.setFdropdownexp(rs.getString("dropdownexp").trim());            	  
            	  dictDetail.setFfieldwidth(Basic.getInt(rs.getString("fieldwidth").trim()));
            	  dictDetail.setFfieldvisible(Basic.IsTrue(rs.getString("fieldvisible").trim()));
            	  dictDetail.setFfieldalign(rs.getString("fieldalign").trim());
            	  
            	  dictDetail.setFfieldorder(Basic.IsTrue(rs.getString("fieldorder").trim()));
            	  dictDetail.setFfieldisallownull(Basic.IsTrue(rs.getString("fieldisallownull").trim()));
            	  
            	  dictDetail.setFfieldmaxlength(Basic.getInt(rs.getString("fieldmaxlength").trim()));
            	  dictDetail.setFfieldintlength(Basic.getInt(rs.getString("fieldintlength").trim()));
            	  dictDetail.setFfielddecimallength(Basic.getInt(rs.getString("fielddecimallength").trim()));
            	  dictDetail.setFfieldminvalue(rs.getString("fieldminvalue").trim());
            	  dictDetail.setFfieldmaxvalue(rs.getString("fieldmaxvalue").trim());
            	  
//            	  dictDetail.setFfieldgraph(Basic.IsTrue(rs.getString("fieldgraph").trim()));
//            	  dictDetail.setFfieldgraphtype(rs.getString("fieldgraphtype").trim());
//            	  
//            	  dictDetail.setFfieldminambittype(rs.getString("fieldminambittype").trim());
//            	  
//            	  if (dictDetail.getFfieldminambittype().trim().equals("sql"))
//            	  {
//            		  commonRS = DBUtil.getRecord(rs.getString("fieldminambit").trim());
//            		  if (commonRS.next())
//            			  dictDetail.setFfieldminambit(commonRS.getString(0).trim()); 
//            	  }else
//            	  {
//            		  dictDetail.setFfieldminambit(rs.getString("fieldminambit").trim());
//            	  }
//            	  
//            	  dictDetail.setFfieldminambitcolor(rs.getString("fieldminambitcolor").trim());
//            	  dictDetail.setFfieldmaxambittype(rs.getString("fieldmaxambittype").trim());
//            	  
//            	  if (dictDetail.getFfieldmaxambittype().trim().equals("sql"))
//            	  {
//            		  commonRS = DBUtil.getRecord(rs.getString("fieldmaxambit").trim());
//            		  if (commonRS.next())
//            			  dictDetail.setFfieldmaxambit(commonRS.getString(0).trim()); 
//            	  }else
//            	  {
//            		  dictDetail.setFfieldmaxambit(rs.getString("fieldmaxambit").trim());
//            	  }
//            	  
//            	  dictDetail.setFfieldmaxambitcolor(rs.getString("fieldmaxambitcolor").trim());

            	  hashtable.put(rs.getString("fieldname").trim().toLowerCase(), dictDetail);
             }
             //System.out.println("hashtable1"+hashtable.size());
        } catch(Exception e) {
        	
        	e.printStackTrace();
        } 
   }
	
	public DictDetail getDictDetail(String fieldName)
	{
		return (DictDetail)hashtable.get(fieldName.trim().toLowerCase());
	}
}
