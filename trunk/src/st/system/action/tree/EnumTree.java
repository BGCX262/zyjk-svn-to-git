/*********************************************************************
 *<p>处理内容：Enm TREE</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.1 --2013.03.19---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.db.RecordSet;

public class EnumTree extends TreeBasic{

    
    
    /**
     * 取得SQL语句
     * @param accpet
     * @param syncmodel
     * @return
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
    	
    	
        
        String strSQL = "SELECT ENUTYPE,ENUNAME,PARENUTYPE FROM ptenumain ";
        if(strWhere!=null&&!(strWhere.equals(""))) {
            strSQL = strSQL+strWhere;
        }else  if(strTreeID!=null&&!(strTreeID.equals(""))) {
        	      	
        		strSQL = strSQL + " WHERE ENUTYPE = '"+strTreeID+"'";  
        	
                  
       }
       
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
                String id = rs.getString("ENUTYPE");
                String pid = rs.getString("PARENUTYPE");
                String text = rs.getString("ENUNAME")+"("+rs.getString("ENUTYPE")+")";
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", id);
                map.put("pid", pid);
                map.put("text", text);
                //

                //
                list.add(map);
            }
            return list;
        }
    
}
