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
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>

<%
     //从职业卫生档案处查看企业的申报信息
     //分类分级处查看企业的申报信息
     String enterno=request.getParameter("enterno");
     QyjbqkBean qyBean=new QyjbqkBean();
     qyBean=qyBean.findFirst(" where enterno='"+ enterno  +"'");     
     String corpkey="";
     if(null!=qyBean&&!"".equals(qyBean)){
    	  corpkey=qyBean.getCorpkey();
     }else{
    	  corpkey=request.getParameter("corpkey");	 
     }
     
 %>
<head>
<script  src="<%=webpath%>/UI/zyjk/cor/info/enterinfomain.js" type="text/javascript"></script> 
</head> 
<body class="treemenubody" style="padding:10px;height:800px">
<input type="hidden" id="corpkey" name="corpkey" value="<%=corpkey %>"/>
  <div id="layout" style="height:100%">
            
            <div position="left" title="企业信息导航"> <ul id="tree"  style="margin-top:3px;"> </div>
            <div position="center" id="navtab">
              <div tabid="1" title="申报情况（2012版）"  >
            	<iframe frameborder="0" name="showmessage" src="<%=webpath%>UI/zyjk/cor/info/newTable.jsp?messageBean.method=look&strSysno=<%=corpkey%>"></iframe>
            </div>           
  </div></body>
</html>