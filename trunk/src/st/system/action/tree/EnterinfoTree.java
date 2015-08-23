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

public class EnterinfoTree extends TreeBasic{

    
    
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
            map.put("text", "新版");
            map.put("url", "");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "2");
            map.put("pid", "0");
            map.put("text", "旧版");
            map.put("url", "");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "3");
            map.put("pid", "2");
            map.put("text", "基本信息");
            map.put("url", "/UI/action/zyjk/ZcorAction_findByKey.action");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "4");
            map.put("pid", "2");
            map.put("text", "职业病危害作业场所");
            map.put("url", "/UI/zyjk/cor/info/zsitelist.jsp");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "5");
            map.put("pid", "2");
            map.put("text", "申报单位基本生产情况");
            map.put("url", "/UI/zyjk/cor/info/zsclist.jsp");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "6");
            map.put("pid", "2");
            map.put("text", "场所职业病危害因素汇总表");
            map.put("url", "/UI/zyjk/cor/info/zwhlist.jsp");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "7");
            map.put("pid", "2");
            map.put("text", "人员管理情况汇总表");
            map.put("url", "/UI/zyjk/cor/info/zpxtjlist.jsp");
            list.add(map);
            map = new HashMap<String, Object>();
            map.put("id", "8");
            map.put("pid", "1");
            map.put("text", "新职业病危害项目申报表");
            map.put("url", "/UI/zyjk/cor/info/newTable.jsp");
            list.add(map);
//            map = new HashMap<String, Object>();
//            map.put("id", "7");
//            map.put("pid", "0");
//            map.put("text", "分类分级查询");
//            map.put("url", "/UI/zyjk/flfj/flfjlist.jsp");
//            list.add(map);
//            map = new HashMap<String, Object>();
//            map.put("id", "8");
//            map.put("pid", "0");
//            map.put("text", "分类分级打分");
//            map.put("url", "/UI/zyjk/cor/info/zyjkfl.jsp");
//            list.add(map);
           
            return list;
        }
    
}
