/*********************************************************************
 *<p>处理内容：role TREE</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.1 --2013.03.21---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.tree;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.db.RecordSet;
import st.system.dao.PtroleBean;

public class PtOperTree extends TreeBasic{

    
    
    /**
     * 取得SQL语句
     * @param accpet
     * @param syncmodel
     * @return
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
        
        String strSQL = "SELECT PTOperRole.OperID ,PTRole.RoleID AS roleid,PTRole.PARROLEID AS parroleid," +
        		"PTRole.RoleDesc AS roledesc FROM PTRole,PTOperRole WHERE  (PTRole.RoleID=PTOperRole.RoleID) ";
        if(strWhere!=null&&!(strWhere.equals(""))) {
            strSQL = strSQL+strWhere;
        }else  if(strTreeID!=null&&!(strTreeID.equals(""))) {
        		strSQL = strSQL + " and  operid= '"+strTreeID+"'";  
        }
        return strSQL;
        
    }  
        /**
         * 对结果集合进行处理
         * @param accpet
         * @param syncmodel
         * @return
         */
        @SuppressWarnings("unchecked")
		public List<Map<String, Object>> getTree(RecordSet rs) {
        	

        	PtroleBean  ptRoleBean=new PtroleBean();
        	List<Map<String, Object>> list = new ArrayList<Map<String, Object>> ();
        	List<String> idlist=new ArrayList<String>();
            
        	
        	try {
        		List<PtroleBean> operlist=new ArrayList<PtroleBean>();
				operlist=ptRoleBean.findByWhere(" where 1=1");
				
			    while (rs != null && rs.next()) {
		                String id = rs.getString("roleid");		               
		                idlist.add(id);
		            }
				System.out.println("需要遍历的节点"+idlist);
				for(int i=0;i<operlist.size();i++){
	        		Map<String, Object> map = new HashMap<String, Object>();
	        		String roleid=operlist.get(i).getRoleid();
	        		map.put("id", roleid);
	        		map.put("pid", operlist.get(i).getParroleid());
	        		map.put("text", operlist.get(i).getRoledesc());
	        		if(idlist.indexOf(roleid)>=0){
	        			map.put("ischecked", "true");
	        		}

	        		list.add(map);
	        	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 	
       
            return list;
        }
    
}
