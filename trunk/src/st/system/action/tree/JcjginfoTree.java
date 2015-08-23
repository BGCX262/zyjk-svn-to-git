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
import st.system.action.tree.TreeBasic;

public class JcjginfoTree extends TreeBasic{

    
    
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
            map.put("id", "1");
            map.put("pid", "0");
            map.put("text", "基本信息");
            map.put("url", "/UI/action/zyjk/JcjgbaAction_findByKey.action");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "2");
            map.put("pid", "0");
            map.put("text", "人员信息");
            map.put("url", "/UI/zyjk/jcjg/jcjgry/jcjgrylist.jsp");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "3");
            map.put("pid", "0");
            map.put("text", "检测设备管理");
            map.put("url", "/UI/zyjk/jcjg/jcjgsb/jcjgsblist.jsp");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "4");
            map.put("pid", "0");
            map.put("text", "年检管理");
            map.put("url", "/UI/zyjk/jcjg/jcjgnj/jcjgnjList.jsp");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "5");
            map.put("pid", "0");
            map.put("text", "评价报告");
            map.put("url", "/UI/zyjk/jcjg/jcjgbg/jcjgbglist.jsp");
            list.add(map);
            
           
            return list;
        }
    
}
