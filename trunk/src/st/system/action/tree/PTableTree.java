/*********************************************************************
 *<p>处理内容：数据库表 TREE</p>
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

public class PTableTree extends TreeBasic {

    /**
     * 取得SQL语句
     * @param accpet
     * @param syncmodel
     * @return
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
        
        String strSQL = "SELECT tableid,tablename,tabledesc FROM ptable ";
        
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
        
        map.put("id", "1");
        map.put("pid", "0");
        map.put("text","数据库");
        List<String> childrenlist = new ArrayList<String>();
        map.put("children", childrenlist);
        list.add(map);
        while (rs != null && rs.next()) {
             map = new HashMap<String, Object>();
            String id = rs.getString("tableid");
            String pid = "1";
            String text = rs.getString("tablename");
           
            map.put("id", id);
            map.put("pid", pid);
            map.put("text", text);
            list.add(map);
        }
        return list;
        
    }

}
