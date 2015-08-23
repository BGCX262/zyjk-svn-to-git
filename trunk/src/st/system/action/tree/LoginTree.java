/*********************************************************************
 *<p>处理内容：Actions TREE</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.1 --2013.06.06---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.db.RecordSet;

public class LoginTree extends TreeBasic{

    /*
     * 取得SQL语句
     * (non-Javadoc)
     * @see st.system.action.tree.TreeBasic#getSQL(java.lang.String, java.lang.String, java.lang.String)
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
        
        String strSQL = "select deptno,parentdeptid,deptnm from ptdept where parentdeptid in('40-37000000-001','1') ";
//        if(strWhere!=null&&!(strWhere.equals(""))) {
//            strSQL = strSQL+strWhere;
//       }
        
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
            String id=rs.getString("deptno");
 			String pid=rs.getString("parentdeptid");
 			String name=rs.getString("deptnm");
            map.put("id", id);
            map.put("pid", pid);
            map.put("text", name);
            map.put("isexpand", "true");
            list.add(map);
        }
        return list;
        
    }
}
