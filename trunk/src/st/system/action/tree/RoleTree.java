/*********************************************************************
 *<p>处理内容：role TREE</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.1 --2013.03.21---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import st.platform.db.RecordSet;
import st.platform.security.SystemAttributeNames;
import st.system.dao.PtoperBean;

public class RoleTree extends TreeBasic{

    
    
    /**
     * 取得SQL语句
     * @param accpet
     * @param syncmodel
     * @return
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
    	
        PtoperBean ptoperbean = (PtoperBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.USER_INFO_NAME);  
        
        
        String strSQL = "SELECT roleid,ROLEDESC,STATUS,PARROLEID,isleaf FROM ptrole ";
        if(strWhere!=null&&!(strWhere.equals(""))) {
            strSQL = strSQL+strWhere;
        }else  if(strTreeID!=null&&!(strTreeID.equals(""))) {
        	
        	if(isFlag.equals("leafpoint")){
        		strSQL = strSQL + " WHERE  roleid= '"+strTreeID+"'";  
        	}else{
        		strSQL = strSQL + " WHERE  PARROLEID= '"+strTreeID+"'";  
        	}
        	if(ptoperbean!=null){
                strSQL = strSQL + " and  deptid= '"+ptoperbean.getDeptid()+"'";
            }
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
                String id = rs.getString("roleid");
                String pid = rs.getString("PARROLEID");
                String text = rs.getString("ROLEDESC");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", id);
                map.put("pid", pid);
                map.put("text", text);
                list.add(map);
            }
            return list;
        }
    
}
