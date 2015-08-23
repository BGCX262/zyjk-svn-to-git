/****************************************************
 * <p>处理内容：Tree</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-03-21               新規作成 ;
 ****************************************************/
package st.system.action.tree;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import st.platform.db.RecordSet;
public class PTableColumnTree extends TreeBasic {
	private static final long serialVersionUID = 1L;
	/**
	* 取得SQL语句
	* @param strWhere
	* @param strTreeID
	* @param isFlag
	* @throws Exception
	*/  
   public String getSQL(String strWhere,String strTreeID,String isFlag) {
	String strSQL = "Select columnid,tableid,tablename,columnname,columndesc,columnlength,columntype,iskey from ptablecolumn";
	 if(strWhere!=null&&!(strWhere.equals(""))) {
	 strSQL = strSQL+strWhere;
	}
	 return strSQL;
	}  
	
	
	/**
	* 对结果集合进行处理
	* @param rs
	* @@return 
	*/  
   public List<Map<String, Object>> getTree(RecordSet rs)  {
	  List<Map<String, Object>> list = new ArrayList<Map<String, Object>> ();
	  Map<String, Object> map = new HashMap<String, Object>();
	 map.put("id", "1");
	 map.put("pid", "0");
	 map.put("text","表字段树");
	 List<String> childrenlist = new ArrayList<String>(); 
	 map.put("children", childrenlist);
	 list.add(map);  
	
	 while (rs != null && rs.next()) {
	 map = new HashMap<String, Object>();
	 String id = rs.getString("columnid");
	  String pid = "1"; 
	 String text = rs.getString("columnname");
	 map.put("id", id); 
	 map.put("pid", pid); 
	 map.put("text", text); 
	 list.add(map);
	}
	 return list;
	}
	
	
}
