<!--
/*********************************************************************
 *<p>处理内容：treemenu列表</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.5.22---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java" import="UI.dao.zyjk.*,UI.dao.enterfile.*,st.platform.security.SystemAttributeNames,java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>

<%
	//此处判断是企业用户登陆还是监管用户登陆
    String enterno=request.getParameter("enterno");
    String state="1";
    
    String url="/UI/action/enterfile/EnterMain_findByKey.action?messageBean.method=look&state=1&strSysno="+enterno;
    //T_officerBean  officer=(T_officerBean)session.getAttribute(SystemAttributeNames.CORP_INFO_NAME);
    //if(!"".equals(officer)&&null!=officer){
   // 	//状态位置0
   // 	state="0";
   // 	url="/UI/action/enterfile/EnterMain_findByKey.action?messageBean.method=add&state=0&strSysno="+officer.getLogin_id();   
   // }
 %>
<head>
<title>企业安全档案管理</title>
<script  src="<%=webpath%>/UI/enterfile/info/enterinfomain.js" type="text/javascript"></script> 
</head> 
<body class="treemenubody" style="padding:10px">
<input type="hidden" id="state" value="<%=state %>"/>   
  <div id="layout" style="height:700px">
            <div position="left" title="档案库信息导航"> <ul id="tree"  style="margin-top:3px;"> </div>
            <div position="center" id="navtab">
              <div tabid="1" title="基本信息" >
            	<iframe  frameborder="0" name="showmessage" src="<%=webpath+url%>"></iframe>
            </div>           
  </div></body>
</html>