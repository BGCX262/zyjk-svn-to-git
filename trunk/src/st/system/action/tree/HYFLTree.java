package st.system.action.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.db.RecordSet;

public class HYFLTree extends TreeBasic{

    /*
     * 取得SQL语句
     * (non-Javadoc)
     * @see st.system.action.tree.TreeBasic#getSQL(java.lang.String, java.lang.String, java.lang.String)
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
        
        String strSQL = " select  enuitemvalue,enuitemlabel  from  ptenudetail where enutype='HYLB'  ";
        //}
        String strOrder=" ";
        strSQL=strSQL+strOrder;
        
        return strSQL;
        
    }  
    /**
     * 对结果集合进行处理
     * @param accpet
     * @param syncmodel
     * @return
     */
    public List<Map<String, Object>> getTree(RecordSet rs) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>> ();
        Map<String, Object> map = new HashMap<String, Object>();
        
        
        while (rs != null && rs.next()) {
             map = new HashMap<String, Object>();
             String id=rs.getString("enuitemvalue");
				
			String pid="";
			if(id.length()==2){
				pid="0";
			}else if(id.length()==4){
				pid=id.substring(0,2);
			}else{
				pid=id.substring(0,4);
			}
				
			String name=rs.getString("enuitemlabel");
            map.put("id", id);
            map.put("pid", pid);
            map.put("text", name);
           
            map.put("isexpand", "false");
          
            list.add(map);
        }
        return list;
        
    }
}
