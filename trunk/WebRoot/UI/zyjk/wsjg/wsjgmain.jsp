<!--
/*********************************************************************
 *<p>处理内容：treemenu列表</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>

<%
	String sysno=request.getParameter("sysno");
 %>
<head>
<script  src="<%=webpath%>/UI/zyjk/wsjg/wsjgmain.js" type="text/javascript"></script> 
</head> 
<body class="treemenubody" style="padding:10px">

  <div id="layout">
            
            <div position="left" title="检测机构信息导航"> <ul id="tree"  style="margin-top:3px;"> </div>
            <div position="center" id="navtab">
              <div tabid="1" title="基本信息"  >
            	<iframe style="height:100%" frameborder="0" name="showmessage" src="<%=webpath%>/UI/action/zyjk/WsjgbaAction_findByKey.action?messageBean.method=look&strSysno=<%=sysno%>"></iframe>
            </div>           
  </div></body>
</html>