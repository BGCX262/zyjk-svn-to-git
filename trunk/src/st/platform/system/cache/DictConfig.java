package st.platform.system.cache;

import java.util.Hashtable;

import st.platform.db.DBUtil;
import st.platform.db.RecordSet;
import st.platform.utils.Basic;

public class DictConfig {
	private static Hashtable hashtable;
	
	static {
        init();
    }
	public  static void init()
	{    
       
        try {            
             RecordSet rs = DBUtil.getRecord(" select * from ptdictmain " );//where datasetid='"+Datasetid+"' ");
             hashtable = new Hashtable();
            
             while(rs.next())
             {
            	  DictMain dictMain = new DictMain();
            	            	  
            	  dictMain.setFdatasetid(rs.getString("datasetid").trim());
            	  dictMain.setFdatasetname(rs.getString("datasetname").trim());
            	  dictMain.setFgridtype(rs.getString("gridtype").trim());
            	  dictMain.setFistotal(Basic.IsTrue(rs.getString("istotal").trim()));
            	  dictMain.setFischeck(Basic.IsTrue(rs.getString("ischeck").trim()));
            	  dictMain.setFpagesize(Basic.getInt(rs.getString("pagesize").trim()));
            	  dictMain.setFbottomvisible(Basic.IsTrue(rs.getString("bottomvisible").trim()));
            	  dictMain.setFisconfirmdelete(Basic.IsTrue(rs.getString("isconfirmdelete").trim()));
            	  dictMain.setFisconfirmcancel(Basic.IsTrue(rs.getString("isconfirmcancel").trim()));
            	  dictMain.setFisdirectdelete(Basic.IsTrue(rs.getString("isdirectdelete").trim()));
            	  dictMain.setFwherestr(rs.getString("wherestr").trim());
            	  dictMain.setForderstr(rs.getString("orderstr").trim());
            	  dictMain.setFsqlstr(rs.getString("sqlstr").trim());
            	  
            	  dictMain.intiDictDetail();
            	  
            	  hashtable.put(rs.getString("datasetid").trim().toLowerCase(), dictMain);
             }
             //System.out.println("hashtable2"+hashtable.size());
        } catch(Exception e) {
        	
             e.printStackTrace();
        }        
   }
	
	public static DictMain getDictMain(String Datasetid)
	{
		if (hashtable == null || hashtable.size()==0)
			init();
		
		return (DictMain)hashtable.get(Datasetid.trim().toLowerCase());
	}
	
	public static DictDetail getDictDetail(String Datasetid,String fieldName)
	{
		 DictMain dictMain = getDictMain(Datasetid);
		 if (dictMain != null)
			 return dictMain.getDictDetail(fieldName);
		 else
			 return null;
	}
	
}
