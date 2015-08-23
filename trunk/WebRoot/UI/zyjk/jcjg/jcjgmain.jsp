<!--
/*********************************************************************
 *<p>处理内容：treemenu列表</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author jmx 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- jmx --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.portal.action.MessageBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>

<%
	String sysno=request.getParameter("sysno");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
	if(null==messageBean){
		messageBean=new MessageBean();
	}
	
	//System.out.println("打印编号主键:"+sysno);
	//sysno="20130609-20130001455";
	
 %>
<head>
<script  src="<%=webpath%>/UI/zyjk/jcjg/jcjgmain.js" type="text/javascript"></script> 
</head> 
<body class="treemenubody" style="padding:10px">
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod()%>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
  <div id="layout">
            
            <div position="left" title="检测机构信息导航"> <ul id="tree"  style="margin-top:3px;"> </div>
            <div position="center" id="navtab">
              <div tabid="1" title="基本信息"  >
            	<iframe style="height:100%" frameborder="0" name="showmessage" src="<%=webpath%>/UI/action/zyjk/JcjgbaAction_findByKey.action?messageBean.method=look&strSysno=<%=sysno%>"></iframe>
            </div>           
  </div>
  </body>
</html>