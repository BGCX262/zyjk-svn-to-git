/*********************************************************************
 *<p>处理内容：ptdetp TREE</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.1 --2013.03.20---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.db.RecordSet;
import st.platform.utils.Config;

public class PtdeptTree extends TreeBasic{

    
    
    /**
     * 取得SQL语句
     * @param accpet
     * @param syncmodel
     * @return
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
    	
    	
        
        String strSQL = "SELECT deptno,deptnm,DEPTLVL,DISTCODE,CREATEDT,NORMALPEOS,REALPEOS,MANAGERNM,PARENTDEPTID,DEPTINFO,BMJC FROM ptdept where 1=1 ";
        
        
        
        if(strWhere!=null&&!(strWhere.equals(""))) {
            strSQL = strSQL+strWhere;
        }else  if(strTreeID!=null&&!(strTreeID.equals(""))) {
        	
        	//if(isFlag.equals("leafpoint")){
        		strSQL = strSQL + " and deptnm = '"+strTreeID+"'";  
        //	}else{
        	//	strSQL = strSQL + " WHERE parentdeptid = '"+strTreeID+"'";  
        //	}
        	
                
       }
        String distcode=Config.getProperty("distcode");
        
        if(null!=distcode&&distcode!=""){
        	strSQL+=" and deptno like '%"+distcode+"%'";
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
                String id = rs.getString("deptno");
                String pid = rs.getString("PARENTDEPTID");
                String text = rs.getString("deptnm");
                
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", id);
                map.put("pid", pid);
                map.put("text", text);
                map.put("isexpand","false");
                list.add(map);
            }
            return list;
        }
    
}
