/*********************************************************************
 *<p>处理内容：ptResource TREE</p>
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

import org.apache.struts2.ServletActionContext;

import st.platform.db.RecordSet;
import st.platform.security.SystemAttributeNames;
import st.portal.action.BasicAction;
import st.system.dao.PtmenuBean;
import st.system.dao.PtoperBean;


public class PtResTree extends TreeBasic{

    
    
    /**
     * 取得SQL语句
     * @param accpet
     * @param syncmodel
     * @return
     */
    public String getSQL(String strWhere,String strTreeID,String isFlag) {
    	String strSQL ="select menuid,ptmenu.menulabel AS roledesc,ptrole.roleid as roleid,ptrole.parroleid as parroleid " +
    			"from ptroleres,ptmenu,ptrole where ptmenu.menuid=ptroleres.resid  ";
        if(strWhere!=null&&!(strWhere.equals(""))) {
            strSQL = strSQL+strWhere;
        }else  if(strTreeID!=null&&!(strTreeID.equals(""))) {
        	strSQL = strSQL + " and  ptroleres.roleid= '"+strTreeID+"'";  
       }
        System.out.println("----------------------------:"+strSQL);
        return strSQL;
        
    }  
        /**
         * 对结果集合进行处理
         * @param accpet
         * @param syncmodel
         * @return
         */
        public List<Map<String, Object>> getTree(RecordSet rs) {
        	
            PtmenuBean  ptResBean=new PtmenuBean();
        	List<Map<String, Object>> list = new ArrayList<Map<String, Object>> ();
        	List<String> idlist=new ArrayList<String>();
            
        	
        	try {
        		List<PtmenuBean> reslist=new ArrayList<PtmenuBean>();
                // 查询出所有的树形结构
                //根据权限进行判断
                PtoperBean ptoperbean = (PtoperBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.USER_INFO_NAME);  
                if(ptoperbean!=null){
                    String issuper = ptoperbean.getIssuper();
                    //当人员是超级管理员
                    System.out.println(issuper);
                    System.out.println(ptoperbean.getDeptid());
                    if(issuper.equals("1")){
                        reslist=ptResBean.findByWhere(" where 1=1");
                    }else{
                        String strSQL ="select menuid,parentmenuid,menulevel,isleaf,menudesc,menulabel,menuicon,menuaction,levelidx " +
                        "from ptdeptres,ptmenu where ptmenu.menuid=ptdeptres.resid  and ptdeptres.deptid = '"+ptoperbean.getDeptid()+"' ";
                        BasicAction basc = new BasicAction();
                        RecordSet gridRS = basc.executeQuery(strSQL);
                        while (gridRS != null && gridRS.next()) {
                            PtmenuBean menubean = new PtmenuBean();
                            menubean.setMenuid(gridRS.getString("menuid"));
                            menubean.setParentmenuid(gridRS.getString("parentmenuid"));
                            menubean.setMenulevel(gridRS.getString("menulevel"));
                            menubean.setIsleaf(gridRS.getString("isleaf"));
                            menubean.setMenudesc(gridRS.getString("menudesc"));
                            menubean.setMenulabel(gridRS.getString("menulabel"));
                            reslist.add(menubean);
                        }
                    }
                }
                reslist=ptResBean.findByWhere(" where 1=1");
			    while (rs != null && rs.next()) {
		                String resid = rs.getString("menuid");
		                
		                idlist.add(resid);
		            }
				Map<String, Object> map;
				for(int i=0;i<reslist.size();i++){
					map = new HashMap<String, Object>();
	        		String ResID=reslist.get(i).getMenuid();
	        		map.put("id", ResID);
	        		map.put("pid", reslist.get(i).getParentmenuid());
	        		map.put("text", reslist.get(i).getMenulabel());
	        		if(idlist.indexOf(ResID)>=0){
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
