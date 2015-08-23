<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.system.dao.PtoperBean"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<jsp:directive.page import="st.platform.db.ConnectionManager"/>
<jsp:directive.page import="st.platform.db.DatabaseConnection"/>
<jsp:directive.page import="st.platform.db.RecordSet"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/webpath.jsp"%>
<%
	PtoperBean ptoperbean= (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
	String url="<a href='"+webpath+"zfindex.jsp' style='color: #FFFFFF'>首页</a>    |    ";
	if(null==ptoperbean){
		ptoperbean=new PtoperBean();
	}else {
		 String strSQL = "SELECT menuid,PARENTMENUID,MENULABEL,ISLEAF,MENUACTION FROM ptmenu " ;
		 strSQL = strSQL +" where menuid in( select resid from  ptoperrole,ptroleres  where operid ='"+ptoperbean.getSysno()+"' and ptoperrole.roleid = ptroleres.roleid) and menulevel=0  order by levelidx";	
        ConnectionManager cm = ConnectionManager.getInstance();

	    DatabaseConnection DBCon = cm.get();
	    
	    RecordSet rs=DBCon.executeQuery(strSQL);
	    while(rs.next()){
	    	url+="<a href='javascript:openMenu("+rs.getString("menuid")+")' style='color: #FFFFFF'>"+rs.getString("MENULABEL")+"</a>    |    ";
	    }
	    
	    cm.release();
	}
 %>
<head>
<title>职业卫生管理信息系统</title>

</head>

<!--头部-->
<div class="head">
<%--<img src="<%=webpath%>images/zyjk/header_001.jpg" width="1000" height="125" alt="" />
  --%><object 
                codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" 
                classid=clsid:D27CDB6E-AE6D-11cf-96B8-444553540000 width=1000 height=125>
        <param name="movie" value="<%=webpath%>images/zfheader.swf" />
	    <param name="wmode" value="transparent" />
        <embed src="<%=webpath%>images/zfheader.swf" 
                quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" 
                type="application/x-shockwave-flash" width="1000" height="125" 
                wmode="transparent"></embed>
      </object>

</div>
<div class="box1"><div class="box1_1">
<%=url %></div>
</div>


</html>
