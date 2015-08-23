<!--
/*********************************************************************
 *<p>处理内容：DATABASC 列表</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.14---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
	<script  src="<%=webpath%>UI/system/resource/databasc/databasclist.js" type="text/javascript"></script> 
</head>
<body class="bodystyle"> 
<div style="margin-top: -5px;margin-left: 10px"> 
	   	bean路径:<input type="text" id="beanpath" value="UI.dao"/>
	   </div>
<div id="layout">

<!-- 操作区域 -->
<div position="top"> 
	<div id="menubar"></div> 
</div>

<!-- Tree区域 --> 
	  <div position="left" title="表名称">
	   
	    <ul id="tree"  style="margin-top:3px;overflow:scroll;height:480px;width:280px">
	   </div>
	
<!-- 中间区域 -->
	<div class="lay-center-out"  position="center"  style="border: 0"  >
	<div>
		<textarea rows="13" cols="" style="width: 100%"></textarea>
	</div>
	 	<div id="mainGrid"></div>
	</div>		
</div>	
</body>
</html>
