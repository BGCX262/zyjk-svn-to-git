<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-03    孙雁斌               新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.system.dao.PtdeptBean"/>
<jsp:directive.page import="org.apache.struts2.ServletActionContext"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<jsp:directive.page import="UI.dao.zyjk.T_yhzc_bzzbBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
    String zbid=request.getParameter("strSysno");
    //System.out.println("打印主键:"+zbid);
    T_yhzc_bzzbBean bzzbBean=new T_yhzc_bzzbBean();
    String bzzmc=bzzbBean.findFirst(" where id='"+ zbid +"'").getBzzmc();
 %>
     <script language="javascript" src="<%=webpath%>UI/zczj/zczjgl/zczjinfolist.js"></script>
  </head>
  <body  class="bodystyle">
  <input type="hidden" name="zbid" id="zbid" value="<%=zbid %>"/>
  <input type="hidden" name="bzzmc" id="bzzmc" value="<%=bzzmc %>"/>
  <div id="layout">
 <!-- TREE区域 -->
 <div position="left" title="菜单"> <ul id="tree"  style="margin-top:3px;"> </div>
 <!-- 中间区域 -->
 <div class="lay-center-out"  position="center"  style="border: 0"  >
   <!-- grid区域 -->
  <div id="mainGrid"></div>
  </div>
</div>  
</body>  
</html> 
