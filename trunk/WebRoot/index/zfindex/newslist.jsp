<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-05               新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.system.dao.PtdeptBean"/>
<jsp:directive.page import="org.apache.struts2.ServletActionContext"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	 PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
        
     String distcode=dept.getDistcode();
     String type=request.getParameter("type");
     String title="工作动态";
     if(type.equals("01")){
     	title="工作动态";
     }else if(type.equals("02")){
     	title="法律法规";
     }else if(type.equals("03")){
     	title="法律法规";
     }
 %>
<%@ include file="/global.jsp"%>
<html>
 <head>
 <title>职业卫生监督管理信息系统-<%=title %>列表</title>
 	<link href="<%=webpath%>css/zfindex.css" rel="stylesheet" type="text/css" />
     <script language="javascript" src="<%=webpath%>index/zfindex/newslist.js"></script>
      <script>
		function openMenu(id){			
				window.location.href="<%=webpath %>zfmain.jsp?mid="+id;
		} 
 </script>
  </head>
  <body>
  <!--头部-->
<jsp:include page="/index/zfhead.jsp" />
<input type="hidden" name="distcode" id="distcode" value="<%=distcode %>"/>
  <center>
  <div id="layout" style="width: 1000px;">
 <!-- TREE区域 -->
 <%--<div position="left" title="菜单"> <ul id="tree"  style="margin-top:3px;"> </div>
 --%><!-- 中间区域 -->
 <div class="lay-center-out"  position="center"  style="border: 0;width: 1000px"  >
   <!-- grid区域 -->
  <div id="mainGrid" ></div>
  </div>
</div>  
</center>
<jsp:include page="/index/zffoot.jsp" />
</body>  
</html> 
