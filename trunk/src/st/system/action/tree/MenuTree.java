/*********************************************************************
 *<p>处理内容：MENU TREE</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.1 --2013.03.11---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.db.RecordSet;

public class MenuTree extends TreeBasic{

    
    
    /**
     * 取得SQL语句
     * @param accpet
     * @param syncmodel
     * @return
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
    	
    	
        
        String strSQL = "SELECT menuid,PARENTMENUID,MENULABEL,ISLEAF FROM ptmenu ";
        if(strWhere!=null&&!(strWhere.equals(""))) {
            strSQL = strSQL+strWhere;
        }else  if(strTreeID!=null&&!(strTreeID.equals(""))) {
        	
        	if(isFlag.equals("true")){
        		strSQL = strSQL + " WHERE MENUID = '"+strTreeID+"'";  
        	}else{
        		strSQL = strSQL + " WHERE PARENTMENUID = '"+strTreeID+"' and len(menuid)='3' ";  
        	}
        	
                  
       }
        strSQL+=" order by levelidx";
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
            while (rs != null && rs.next()) {
                String id = rs.getString("menuid");
                String pid = rs.getString("PARENTMENUID");
                String text = rs.getString("MENULABEL");
                String isleaf = rs.getString("ISLEAF");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", id);
                map.put("pid", pid);
                map.put("text", text);
                map.put("isexpand", "false");
                //
                if (!(isleaf.equals("1"))) {
                    List<String> childrenlist = new ArrayList<String>();
                    map.put("children", childrenlist);
                }

                //
                list.add(map);
            }
            return list;
        }
    
}
