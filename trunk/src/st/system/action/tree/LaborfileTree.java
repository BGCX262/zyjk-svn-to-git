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

public class LaborfileTree extends TreeBasic{

    
    
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
            map.put("text", "劳动者基本信息");
            map.put("url", "UI/action/ldzjbxx/LdzjbxxAction_findByKey.action");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("id", "2");
            map.put("pid", "0");
            map.put("text", "劳动者的职业史");
            map.put("url", "UI/enterfile/ldzcys/ldzcys.jsp");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("id", "3");
            map.put("pid", "0");
            map.put("text", "劳动者职业危害接触史");
            map.put("url", "UI/enterfile/ldzzywhjcs/ldzzywhjcs.jsp");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("id", "4");
            map.put("pid", "0");
            map.put("text", "职业卫生健康检查结果");
            map.put("url", "UI/enterfile/ldzjkjcjg/ldzjkjcjg.jsp");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("id", "5");
            map.put("pid", "0");
            map.put("text", "职业病诊疗情况");
            map.put("url", "UI/enterfile/ldzzybzlqk/ldzzybzlqk.jsp");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("id", "6");
            map.put("pid", "0");
            map.put("text", "治疗康复情况");
            map.put("url", "UI/enterfile/ldzkfqk/ldzkfqk.jsp");
            list.add(map);
            
            return list;
        }
    
}
