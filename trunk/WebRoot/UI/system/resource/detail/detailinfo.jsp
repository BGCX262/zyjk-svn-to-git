<!--
/*********************************************************************
 *<p>处理内容：detail info</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.portal.action.*,st.system.dao.*"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<title>信息</title>
<%
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
%>
<style type="text/css">
	input{
		width: 60px;
	}
	.l-text-field{
		width: 80px;
	}
</style>
<script  src="<%=webpath%>/UI/system/resource/detail/detailinfo.js" type="text/javascript"></script> 
</head>
<body class="formbody" style="width: 550">
	<div class="div_form">
<div class="searchtitle">          
	<img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
</div>
<div class="navline"></div>
<form name="form" method="post"  id="form">
		<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
	        <input type="text"  id="formid" name="strFormName" value="<%=request.getAttribute("strFormName") %>"/>
        <table cellpadding="0" cellspacing="0"   class="table-edit" >
           <tr> 
                <td  class="l-table-edit-td-right">隐藏</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <%
                       DBSelect dbsel = new DBSelect("strHid", "BOOLTYPE","0");
					   dbsel.addAttr("style", "width: 100%");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "strHidden");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %>
                </td>             
                <td class="l-table-edit-td-right">表信息</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input type="text" id="tableid" name="strTable"/>
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">字段</td>
                <td class="l-table-edit-td-left" style="width:160px">
             	   <input type="text" id="columnid" name="strColumn" />
                </td>
                <td class="td_message">
                <input class="l-button l-button-submit" type="button"  id="addcolumn" value="添加字段"/></td>
            </tr>
         </table> 
        <div id="textTable" style="width: 700px">
        	<% out.print(request.getAttribute("strContent")); %>
        </div>
 <br />
<table class="button_table">
<tr>
	<td>
		<input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /> 
		<input type="button" value="关闭" id="colButton" class="l-button l-button-test"/>
	</td>
</tr>
</table> </form>




    </div>
    <div style="display:none"></div>
</body>
</html>