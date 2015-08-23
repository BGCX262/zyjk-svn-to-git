/*********************************************************************
 *<p>处理内容：MENU TREE</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.1 --2013.05.29---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.db.RecordSet;
import st.system.action.tree.TreeBasic;

public class ReportTree extends TreeBasic{

    
    
    /**
     * 取得SQL语句
     * @param accpet
     * @param syncmodel
     * @return
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
    	
    	
        
        return "";
        
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
            
            map = new HashMap<String, Object>();
            map.put("id", "1");
            map.put("pid", "0");
            map.put("text", "评价报告基本情况");
            map.put("url", "UI/action/Jcjgpjbgjbqk/JcjgpjbgjbqkAction_findByKey.action");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("id", "2");
            map.put("pid", "0");
            map.put("text", "被检测单位基本信息");
            //map.put("url", "UI/enterfile/jcdwjbxx/jcdwjbxx.jsp");
            map.put("url", "UI/action/jcdwjbxx/JcdwjbxxAction_findByKey.action");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("id", "3");
            map.put("pid", "0");
            map.put("text", "检测情况");
            map.put("url", "UI/enterfile/jcqk/jcqk.jsp");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("id", "4");
            map.put("pid", "0");
            map.put("text", "用人单位配备的防护设施及个人防护用品");
            map.put("url", "UI/enterfile/jcyrdwfhssxx/jcyrdwfhssxx.jsp");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("id", "5");
            map.put("pid", "0");
            map.put("text", "检测评价建议");
            //map.put("url", "UI/enterfile/jcpjjyxx/jcpjjyxx.jsp");
            map.put("url", "UI/action/jcpjjyxx/JcpjjyxxAction_findByKey.action");
            list.add(map);
            
            
            return list;
        }
    
}
