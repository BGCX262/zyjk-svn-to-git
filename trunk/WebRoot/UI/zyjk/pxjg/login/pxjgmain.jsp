<!--
/*********************************************************************
 *<p>处理内容：treemenu列表</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author  改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2----  jmx--------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.T_officerBean"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>

<%
	String sysno=request.getParameter("sysno");
	T_officerBean officer=(T_officerBean)session.getAttribute(SystemAttributeNames.JCJG_INFO_NAME);
	//System.out.println("ssssssssssssssssssssss:"+messageBean);
	if(null==officer){
		officer=new T_officerBean();
	}
 %>
<head>
<title>职业危害防治信息平台-培训机构</title>
<script  src="<%=webpath%>/UI/zyjk/pxjg/login/pxjgmain.js" type="text/javascript"></script> 
<style>
	 /* 顶部 */ 
    .l-topmenu{ margin:0; padding:0; height:31px; line-height:31px; background:url('<%=webpath%>images/top.jpg') repeat-x bottom;  position:relative; border-top:1px solid #1D438B;  }
    .l-topmenu-logo{ color:#E7E7E7; padding-left:35px; line-height:26px;background:url('<%=webpath%>images/msn.gif') no-repeat 10px 5px;}
    .l-topmenu-welcome{  position:absolute; height:24px; line-height:24px;  right:30px; top:2px;color:#070A0C;}
    .l-topmenu-welcome a{ color:#E7E7E7; text-decoration:underline} 
</style>
</head> 
<body class="treemenubody" style="padding:10px">
	<div id="topmenu" class="l-topmenu">
	    <div class="l-topmenu-logo">职业危害防治信息平台-培训机构</div>
	    <div class="l-topmenu-welcome">
	    </div> 
	</div>
  <div id="layout">
            
            <div position="left" title="培训机构导航"> <ul id="tree"  style="margin-top:3px;"> </div>
            <div position="center" id="navtab">
              <div tabid="1" title="基本信息"  >
            	<iframe frameborder="0" name="showmessage" src="<%=webpath%>/UI/action/zyjk/PxjgbaAction_loginFindByKey.action?messageBean.method=edit&strSysno=<%=officer.getLogin_id()%>"></iframe>
            </div>           
  </div>
  <div  style="height:32px; line-height:32px; text-align:center;">
           信软科技
    </div>
  </body>
</html>