<!--
/*********************************************************************
 *<p>处理内容：ptdeptmenu列表</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.20---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.platform.utils.Config"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script  src="<%=webpath%>/UI/system/ptdept/ptdeptlist.js" type="text/javascript"></script> 
</head> 
<body class="treemenubody" style="padding:10px">
<input type="hidden" name="distcode" id="distcode" value="<%=Config.getProperty("distcode") %>"/>
  <div id="layout">
            
            <div position="left" title="菜单"> <ul id="tree"  style="margin-top:3px;overflow:scroll;height:530px;width:200px"> </div>
            <div class="lay-center-out" position="center" id="mainGrid"></div>           
  </div> 
</body>
</html>