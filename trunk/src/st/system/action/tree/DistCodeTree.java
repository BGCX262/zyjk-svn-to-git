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
import st.system.dao.PtoperBean;

public class DistCodeTree extends TreeBasic{

    /*
     * 取得SQL语句
     * (non-Javadoc)
     * @see st.system.action.tree.TreeBasic#getSQL(java.lang.String, java.lang.String, java.lang.String)
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
        
        String strSQL = "select distinct name,code,Depth,firstNodeCode,secondNodeCode,thirdNodeCode,fourthNodeCode,ordernum from organization where  code not in ('370213008007','370213008001')  ";
       
       
        
        if(strWhere!=null&&!(strWhere.equals(""))) {
            strSQL = strSQL+strWhere;
        }
        //else{
    	//    strSQL = strSQL+"where Depth in (1,2) and code not in ('370213008007','370213008001') ";
        //}
        PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
        String distcode="";
        if(null!=dept){
        	distcode=dept.getDistcode();
        }
       
        
        if(distcode!=null&&!distcode.equals("null")&&!distcode.equals("")){
        	if(distcode.indexOf("00000000")>=0){
				distcode=distcode.substring(0, 4);
				strWhere+=" and code like '"+distcode+"%'";
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				distcode=distcode.substring(0, 6);
				strWhere+=" and code like '"+distcode+"%'";
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				distcode=distcode.substring(0, 9);
				strWhere+=" and code like '"+distcode+"%'";
			}
        	
        }else{
        	strWhere+=" and code ='0000000000000000'";
        }
        strSQL = strSQL+strWhere;
        String strOrder=" order by ordernum";
        strSQL=strSQL+strOrder;
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
             String id=rs.getString("code").trim();
	          String pid=rs.getString("firstNodeCode").trim();
	          String depth=rs.getString("Depth");
	          if(depth.equals("1")){
				pid="0";
			  }else if(depth.equals("2")){
			  	pid=rs.getString("code").trim().substring(0, 4)+"00000000";
			  }else if(depth.equals("3")){
			  	pid=rs.getString("code").trim().substring(0, 6)+"000000";
			  }else if(depth.equals("4")){
			  	pid=rs.getString("code").trim().substring(0, 9)+"000";
			  }
 			String name=rs.getString("name");
            map.put("id", id);
            map.put("pid", pid);
            map.put("text", name);
            map.put("depth", depth);
            map.put("isexpand", "true");
           //System.out.println("pid:"+pid);
            if (pid.indexOf("0000")>=0){
                List<String> childrenlist = new ArrayList<String>();
                //childrenlist.add("");
                map.put("isexpand", "false");
                map.put("children", childrenlist);
            }
            list.add(map);
        }
        return list;
        
    }
}
