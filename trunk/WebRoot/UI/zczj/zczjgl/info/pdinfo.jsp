<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-02   孙雁斌       新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.ZczjpzbBean"/>
<jsp:directive.page import="java.util.*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 //T_yhzc_bzbBean bzbBean=(T_yhzc_bzbBean)request.getAttribute("bzbBean");
 //List<ZczjpzbBean> pzbBeanlist=(List<ZczjpzbBean>)request.getAttribute("pzbBeanlist"); 
 ZczjpzbBean pzbBean=(ZczjpzbBean)request.getAttribute("pzbBean"); 
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 String sysno=request.getParameter("strSysno");
 %>
    <script language="javascript" src="<%=webpath%>//UI/zczj/zczjgl/info/pdinfo.js"></script>
  </head>
 <body  class="bodystyle">
  <input type="hidden" name="zbid" id="zbid"/>
  <input type="hidden" name="" id="sysno" value="<%=sysno %>"/>
  <input type="hidden" name="distcode" id="distcode" value=""/>
  <div id="layout">
 <!-- 中间区域 -->
 <div class="lay-center-out"  position="center"  style="border: 0"  >
   <!-- grid区域 -->
  <div id="mainGrid"></div>
  </div>
</div>  
</body>  
</html> 
