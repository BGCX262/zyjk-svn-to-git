/*********************************************************************
 *<p>处理内容：SYSMENU TRE 系统开始的菜单树形结构</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.1 --2013.03.26---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import st.platform.db.RecordSet;
import st.platform.security.SystemAttributeNames;
import st.portal.system.dao.PtOperBean;
import st.system.dao.PtoperBean;

public class SysMenuTree extends TreeBasic{

    
    
    /**
     * 取得SQL语句
     * @param accpet
     * @param syncmodel
     * @return
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
    	
        //取出session中的用户名称
        PtoperBean ptoperbean= (PtoperBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.USER_INFO_NAME);
        
        
        String strSQL = "SELECT menuid,PARENTMENUID,MENULABEL,ISLEAF,MENUACTION FROM ptmenu " ;
        System.out.println("strWhere:"+strWhere);
        if(strWhere!=null&&!(strWhere.equals(""))) { 
           strSQL = strSQL+" where PARENTMENUID='"+ strWhere +"' and  menuid in( select resid from  ptoperrole,ptroleres  where operid ='"+ptoperbean.getSysno()+"' and ptoperrole.roleid = ptroleres.roleid)";
        }else{
           strSQL = strSQL +" where menuid in( select resid from  ptoperrole,ptroleres  where operid ='"+ptoperbean.getSysno()+"' and ptoperrole.roleid = ptroleres.roleid)";	
        }
        String strOrder=" order by levelidx";
        strSQL=strSQL+strOrder;
        return strSQL;
        
        
       // SELECT menuid,PARENTMENUID,MENULABEL,ISLEAF,MENUACTION FROM ptmenu 
        
        
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
                String id = rs.getString("menuid");
                String pid = rs.getString("PARENTMENUID");
                String text = rs.getString("MENULABEL");
                String isleaf = rs.getString("ISLEAF");
                String url=rs.getString("MENUACTION");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", id);
                map.put("pid", pid);
                map.put("text", text);
                map.put("url", url);
                //
                if (!(isleaf.equals("1"))) {
                    List<String> childrenlist = new ArrayList<String>();
                    //childrenlist.add("");
                    map.put("isexpand", "false");
                    map.put("children", childrenlist);
                }

                //
                list.add(map);
            }
            return list;
        }
    
}
