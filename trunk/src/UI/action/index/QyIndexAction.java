package UI.action.index;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import UI.dao.zyjk.NewsBean;


public class QyIndexAction {
	
	public Map<Object,Object> getQyinfo(){
		
		Map<Object,Object> map=new HashMap<Object, Object>();
		
		ConnectionManager cm = ConnectionManager.getInstance();

	    DatabaseConnection DBCon = cm.get();
	    
	    //System.out.println("#############################################");
	   
	    
	    try {
	    	
	    	//法律法规
	    	 String sql="select top 6 SYSNO,TITLE,ISSCUEDATE from news where MESSAGETYPE='01' order by ISSCUEDATE desc";
	    	 RecordSet rs=DBCon.executeQuery(sql);
	    	 List<NewsBean> newslist=new ArrayList<NewsBean>(); 
	    	
			 while(rs.next()){
				 NewsBean news=new NewsBean();
				 news.setSysno(rs.getString("SYSNO"));
				 news.setTitle(rs.getString("TITLE"));
				 news.setIsscuedate(rs.getString("ISSCUEDATE"));
				 newslist.add(news);
			 }
			 map.put("newslist", newslist);
			 
			 sql=" select top 4 SYSNO,TITLE,ISSCUEDATE from news where MESSAGETYPE='02' order by ISSCUEDATE desc";
			 rs=DBCon.executeQuery(sql);
			 List<NewsBean> noticelist=new ArrayList<NewsBean>();
			 while(rs.next()){
				 NewsBean alarm=new NewsBean();
				 alarm.setSysno(rs.getString("SYSNO"));
				 alarm.setTitle(rs.getString("TITLE"));
				 alarm.setIsscuedate(rs.getString("ISSCUEDATE"));
				 noticelist.add(alarm);
			 }
			 map.put("noticelist", noticelist);
			 
			 
			 sql=" select top 4 SYSNO,TITLE,ISSCUEDATE from news where MESSAGETYPE='03' order by ISSCUEDATE desc";
			 rs=DBCon.executeQuery(sql);
			 List<NewsBean> questionlist=new ArrayList<NewsBean>();
			 while(rs.next()){
				 NewsBean question=new NewsBean();
				 question.setSysno(rs.getString("SYSNO"));
				 question.setTitle(rs.getString("TITLE"));
				 question.setIsscuedate(rs.getString("ISSCUEDATE"));
				 questionlist.add(question);
			 }
			 map.put("questionlist", questionlist);
			 
			 //新闻图片
			 
			 sql=" select top 4 SYSNO,TITLE,ISSCUEDATE,path from news where path is not null order by ISSCUEDATE desc";
			 rs=DBCon.executeQuery(sql);
			 List<NewsBean> imagelist=new ArrayList<NewsBean>();
			 while(rs.next()){
				 NewsBean image=new NewsBean();
				 image.setSysno(rs.getString("SYSNO"));
				 image.setTitle(rs.getString("TITLE"));
				 image.setIsscuedate(rs.getString("ISSCUEDATE"));
				 image.setPath(rs.getString("path"));
				 imagelist.add(image);
			 }
			 map.put("imagelist", imagelist);
			 
			 
			 
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
