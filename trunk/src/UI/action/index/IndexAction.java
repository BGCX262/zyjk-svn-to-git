package UI.action.index;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import UI.action.zczj.ZczjAction;
import UI.dao.zyjk.BasiclawsmainBean;
import UI.dao.zyjk.NewsBean;
import UI.dao.zyjk.Z_corBean;
import UI.dao.zyjk.ZczjqyxxzbBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
import UI.util.DataTable;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import st.platform.security.SystemAttributeNames;
import st.portal.action.BasicAction;
import st.system.dao.OrganizationBean;
import st.system.dao.PtdeptBean;
import st.system.dao.PtoperBean;
@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk") 
public class IndexAction extends BasicAction{
	
	public Map<Object,Object> getTSinfo(HttpServletRequest request){
		
		Map<Object,Object> map=new HashMap<Object, Object>();
		
		ConnectionManager cm = ConnectionManager.getInstance();

	    DatabaseConnection DBCon = cm.get();
		PtoperBean oper = (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
		String dqcode=oper.getDeptid();
	    PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
	   
	    
	    try {
	    	
	    	//最新基础填报的个数
			 String zcdistcode=dept.getDistcode();
			 if(zcdistcode.indexOf("00000000")>=0){
				 zcdistcode=zcdistcode.substring(0, 4);
				}else if(zcdistcode.indexOf("000000")>=0&&zcdistcode.indexOf("00000000")<0){
					zcdistcode=zcdistcode.substring(0, 6);
				}else if(zcdistcode.indexOf("000000")<0&&zcdistcode.indexOf("00000000")<0&&zcdistcode.indexOf("000")>=0){
					zcdistcode=zcdistcode.substring(0, 9);
				}
			 String  sql=" select count(*) as zczjCount  from zczjqyxxzb where bak1='1' "+" and ditcode like '"+zcdistcode+"%'"+" and zcsj between '"+BusinessDate.getSubtrationDay(-10)+"' and '"+BusinessDate.getNowDay()+"'";
			 RecordSet rs=DBCon.executeQuery(sql);
			 //List<ZczjqyxxzbBean> zczjs=new ArrayList<ZczjqyxxzbBean>();
			 String zczjCount="0";
			 while(rs.next()){
				 zczjCount= rs.getString("zczjCount");
			 }
			 map.put("zczjCount", zczjCount);
			 
			 //最新填报的企业
			 sql=" select count(*) as qyCount from qyjbqk where ystbdate between '"+BusinessDate.getSubtrationDay(-10)+"' and '"+BusinessDate.getNowDay()+"'";
			 rs=DBCon.executeQuery(sql);
			 String qyCount="0";
			 while(rs.next()){
				 qyCount=rs.getString("qyCount");
			 }
			 map.put("qyCount", qyCount);
			 
			 //最新的分类分级信息
			 sql=" select count(*) as flfjCount from zyjkflfj where date1 between '"+BusinessDate.getSubtrationDay(-10)+"' and '"+BusinessDate.getNowDay()+"'";
			 rs=DBCon.executeQuery(sql);
			 String flfjCount="0";
			 while(rs.next()){
				 flfjCount=rs.getString("flfjCount");
			 }
			 map.put("flfjCount", flfjCount);
			 
			 //资质过期的检测机构
			 
			 sql=" select count(*) as jcjgCount from jcjgbaxx where yxq<'"+BusinessDate.getNowDay()+"'";
			 rs=DBCon.executeQuery(sql);
			 String jcjgCount="0";
			 while(rs.next()){
				 jcjgCount=rs.getString("jcjgCount");
			 }
			 map.put("jcjgCount", jcjgCount);
			 
			 //资质过期的培训机构
			 sql=" select count(*) as pxjgCount from pxjgbaxx where zsyxqz<'"+BusinessDate.getNowDay()+"'";
			 rs=DBCon.executeQuery(sql);
			 String pxjgCount="0";
			 while(rs.next()){
				 pxjgCount=rs.getString("pxjgCount");
			 }
			 map.put("pxjgCount", pxjgCount);
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cm.release();
			
		}
	    
		
		return map;
	}

}
