<!--
/*********************************************************************
 *<p>处理内容：role表单域</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.21---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  import="st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script src="<%=webpath%>/UI/system/role/roleinfo.js" type="text/javascript"></script>
<title>信息</title>
<%
    PtroleBean ptRoleBean = (PtroleBean)request.getAttribute("ptRoleBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
%>      
</head>

<body class="menubody" style="width: 580">
<div class="searchtitle">          
	<img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
</div>
<div class="navline" ></div>

<form name="form" method="post"  id="form">
		<div>
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="roleid" name="ptRoleBean.roleid" value="<%=ptRoleBean.getRoleid() %>"/>
			<!-- 隐藏域 父键id -->
			<input type="hidden" id="parroleid" name="ptRoleBean.parroleid" value="<%=ptRoleBean.getParroleid() %>"/>
			
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		</div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">角色描述:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptRoleBean.roledesc" type="text" id="roledesc" value="<%=ptRoleBean.getRoledesc() %>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">角色状态:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptRoleBean.status" type="text" id="status" value="<%=ptRoleBean.getStatus() %>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            
        </table>
 <br />
<table align="center">
<tr>
	<td>
		<input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /> 
		<input type="button" value="关闭" id="colButton" class="l-button l-button-test"/>
	</td>
</tr>
	
</table>
 </form>
</body>
</html>
