/*********************************************************************
 *<p>处理内容：Actions TREE</p>
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

import org.apache.struts2.ServletActionContext;

import st.platform.db.RecordSet;
import st.platform.security.SystemAttributeNames;
import st.system.dao.PtdeptBean;

public class TDQTree extends TreeBasic{
	String discode="";
    /*
     * 取得SQL语句
     * (non-Javadoc)
     * @see st.system.action.tree.TreeBasic#getSQL(java.lang.String, java.lang.String, java.lang.String)
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
        
       
//        if(strWhere!=null&&!(strWhere.equals(""))) {
//            strSQL = strSQL+strWhere;
//       }
        PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
        String dqcode=dept.getDeptno();
		String[] dises=dqcode.split("-");
		
		if(dises[1].length()>8){
			if(dises[1].indexOf("0000")>=0){
				dqcode=dqcode.substring(3, 7);
				discode=dqcode+"00";
			}else if(dises[1].indexOf("00")>=0&&dises[1].indexOf("0000")<0){
				dqcode=dqcode.substring(3, 9);
				discode=dqcode;
			}else if(dises[1].indexOf("00")<0&&dises[1].indexOf("0000")<0){
				dqcode=dqcode.substring(3, 11);
				discode=dqcode;
			}
		}else{
				if(dises[1].substring(0,6).indexOf("0000")>=0){
				dqcode=dqcode.substring(3, 5);
				discode=dqcode+"0000";
			}else if(dises[1].substring(0,6).indexOf("00")>=0&&dises[1].substring(0,6).indexOf("0000")<0){
				dqcode=dqcode.substring(3, 7);
				discode=dqcode+"00";
			}else if(dises[1].substring(0,6).indexOf("00")<0&&dises[1].substring(0,6).indexOf("0000")<0){
				dqcode=dqcode.substring(3, 9);
				discode=dqcode;
			}
		}
		 String strSQL = "select dqbh as id,dqdj,dqmc as label,sjdqbh as pid from T_Diqu where dqbh like '"+dqcode+"%' order by id";
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
            String id=rs.getString("id");
 			String pid=rs.getString("pid");
 			//String xid=id+"00";
 			if(id.length()==2){
 				id=id+"0000";
 			}else if(id.length()==4){
 				id=id+"00";
 			}
 			
 			if(pid.length()==2){
 				pid=pid+"0000";
 			}else if(pid.length()==4){
 				pid=pid+"00";
 			}
 			
 			if(id.equals(discode)){
 				pid="0";
 			}
 			String name=rs.getString("label");
            map.put("id", id);
            map.put("pid", pid);
            map.put("text", name);
            map.put("isexpand", "false");
            list.add(map);
        }
        return list;
        
    }
}
