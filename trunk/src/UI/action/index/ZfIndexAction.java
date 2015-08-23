package UI.action.index;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import st.platform.security.SystemAttributeNames;
import st.system.dao.OrganizationBean;
import st.system.dao.PtdeptBean;
import st.system.dao.PtoperBean;
import UI.dao.zyjk.BasiclawsmainBean;
import UI.dao.zyjk.NewsBean;
import UI.dao.zyjk.ZczjqyxxzbBean;
import UI.util.DataTable;

public class ZfIndexAction {
	
	public Map<Object,Object> getZfinfo(HttpServletRequest request){
		
		Map<Object,Object> map=new HashMap<Object, Object>();
		
		ConnectionManager cm = ConnectionManager.getInstance();

	    DatabaseConnection DBCon = cm.get();
		PtoperBean oper = (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
		String dqcode=oper.getDeptid();
	    PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
	   
	    
	    try {
	    	
	    	//法律法规
	    	 String sql=" select top 9 sysno,maintitle from basiclawsmain order by  EDITDT desc";
	    	 RecordSet rs=DBCon.executeQuery(sql);
	    	 List<BasiclawsmainBean> laws=new ArrayList<BasiclawsmainBean>(); 
	    	
			 while(rs.next()){
				 BasiclawsmainBean law=new BasiclawsmainBean();
				 law.setSysno(rs.getString("sysno"));
				 law.setMaintitle(rs.getString("maintitle"));
				 laws.add(law);
			 }
			 map.put("law", laws);
			 
			 String zcdistcode=dept.getDistcode();
			 if(zcdistcode.indexOf("00000000")>=0){
				 zcdistcode=zcdistcode.substring(0, 4);
				}else if(zcdistcode.indexOf("000000")>=0&&zcdistcode.indexOf("00000000")<0){
					zcdistcode=zcdistcode.substring(0, 6);
				}else if(zcdistcode.indexOf("000000")<0&&zcdistcode.indexOf("00000000")<0&&zcdistcode.indexOf("000")>=0){
					zcdistcode=zcdistcode.substring(0, 9);
				}
			 sql=" select top 10 sysno,enterno,dwmc,lxr,lxdh,zcsj from zczjqyxxzb where bak1='1' "+" and ditcode like '"+zcdistcode+"%'"+"order by zcsj desc";
			 rs=DBCon.executeQuery(sql);
			 List<ZczjqyxxzbBean> zczjs=new ArrayList<ZczjqyxxzbBean>();
			 while(rs.next()){
				 ZczjqyxxzbBean zc=new ZczjqyxxzbBean();
				 zc.setSysno(rs.getString("sysno"));
				 zc.setEnterno(rs.getString("enterno"));
				 zc.setDwmc(rs.getString("dwmc"));
				 zc.setLxr(rs.getString("lxr"));
				 zc.setLxdh(rs.getString("lxdh"));
				 zc.setZcsj(rs.getString("zcsj"));
				 zczjs.add(zc);
			 }
			 map.put("zczj", zczjs);
			 
			 
			 sql=" select top 4 sysno,title,isscuedate,path from news where MESSAGETYPE='01' order by ISSCUEDATE desc";
			 rs=DBCon.executeQuery(sql);
			 List<NewsBean> newslist=new ArrayList<NewsBean>();
			 while(rs.next()){
				 NewsBean news=new NewsBean();
				 news.setSysno(rs.getString("sysno"));
				 news.setTitle(rs.getString("title"));
				 news.setIsscuedate(rs.getString("isscuedate"));
				 news.setPath(rs.getString("path"));
				
				 newslist.add(news);
			 }
			 map.put("news", newslist);
			 
			 
			 sql=" select top 5 sysno,title,isscuedate,path from news where MESSAGETYPE='01' order by ISSCUEDATE desc";
			 rs=DBCon.executeQuery(sql);
			 List<NewsBean> gglist=new ArrayList<NewsBean>();
			 while(rs.next()){
				 NewsBean news=new NewsBean();
				 news.setSysno(rs.getString("sysno"));
				 news.setTitle(rs.getString("title"));
				 news.setIsscuedate(rs.getString("isscuedate"));
				 news.setPath(rs.getString("path"));
				
				 gglist.add(news);
			 }
			 map.put("ggnews", gglist);
		        
			   String  distcode=dept.getDistcode();
				//System.out.println("dqcode:"+dqcode);
				//String discode =  st.platform.utils.Config.getProperty("discode");
				String sqlc=" and 1=1 and zczjqyxxzb.bak1='1'";
				String xsql=" and 1=1";
				if(null==distcode&&"".equals(distcode)&&"null".equals(distcode)){
					if(distcode.equals("370200")){
						distcode="3702";
					}
					sqlc+=" and ditcode like '"+distcode+"%'";
					xsql+=" and code like '"+distcode+"%'";
				}else{
					if(distcode.indexOf("00000000")>=0){
						distcode=distcode.substring(0, 4);
						xsql+=" and code like '"+distcode+"%' and depth in (1,2)";
					}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
						distcode=distcode.substring(0, 6);
						xsql+=" and code like '"+distcode+"%' and depth in (2,3)";
					}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
						distcode=distcode.substring(0, 9);
						xsql+=" and code like '"+distcode+"%' and depth in (3,4)";
					}
					sqlc+=" and ditcode like '"+distcode+"%'";
					//xsql+=" and code like '"+distcode+"%'";
				}
				
				
				
				
				ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
				DatabaseConnection dcc = cmm.get();
				List<OrganizationBean> rows=new ArrayList<OrganizationBean>();
				OrganizationBean pt=new OrganizationBean();
			
				rows=pt.find(" where 1=1 and depth in (1,2) "+xsql+" order by ordernum");
					//System.out.println(" where enutype='DISTCODE'  "+xsql);
					DataTable table=new DataTable(rows.size(),3);
					for(int i=0;i<rows.size();i++){
						OrganizationBean pb=rows.get(i);
						table.addRow(pb.getCode(), pb.getName(), i+1);
					}
					//table.addCol("AA", "小计",0);
					table.addCol("AA", "企业数", 1);
					table.addCol("A", "合格", 2);
					table.addCol("B", "不合格", 3);
					//对合格企业的统计
					sql="select count(*) as num,ditcode from zczjqyxxzb where 1=1 "+sqlc+" and hgx>30 group by ditcode ";
					rs = dcc.executeQuery(sql);
					while(rs.next()){
						distcode= rs.getString("ditcode");
//						 if(distcode.length()>6){
//							 distcode=distcode.substring(0, 6);
//						 }
						 distcode=distcode.substring(0, 6)+"000000";
		                 String num = rs.getString("num");
		                 if (!table.addCellValue(distcode, "A", Integer.parseInt(num))) {
		                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
		                 }
					}
					//对不合格企业的统计
					sql="select count(*) as num,ditcode from zczjqyxxzb where 1=1 "+sqlc+" and hgx<=30 group by ditcode ";
					//System.out.println(sql);
					rs = dcc.executeQuery(sql);
					while(rs.next()){
						distcode= rs.getString("ditcode");
					    distcode=distcode.substring(0, 6)+"000000";
		                 String num = rs.getString("num");
		                 if (!table.addCellValue(distcode, "B", Integer.parseInt(num))) {
		                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
		                 }
					}
					//对企业总数的统计
					sql="select count(*) as num,ditcode from zczjqyxxzb where 1=1 "+sqlc+" group by ditcode";
					rs = dcc.executeQuery(sql);
					while(rs.next()){
						distcode= rs.getString("ditcode");
						distcode=distcode.substring(0, 6)+"000000";
		                 String num = rs.getString("num");
		                 if (!table.addCellValue(distcode, "AA", Integer.parseInt(num))) {
		                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
		                 }
					}
		map.put("table", table);
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
