<!--
/*********************************************************************
 *<p>处理内容：menu 表单域</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  import="st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script src="<%=webpath%>/UI/system/menu/menuinfo.js" type="text/javascript"></script>
<title>表信息</title>
<%
	PtmenuBean ptMenuBean = (PtmenuBean)request.getAttribute("ptMenuBean");
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
			<input type="hidden" id="menuid" name="ptMenuBean.menuid" value="<%=ptMenuBean.getMenuid() %>"/>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="message.method" value="<%=messageBean.getMethod() %>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		 	 <!-- 隐藏域 父节点id -->
			<input type="hidden" id="parentmenuid" name="ptMenuBean.parentmenuid" value="<%=ptMenuBean.getParentmenuid() %>"/>
		</div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">菜单名称:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptMenuBean.menulabel" type="text" id="menulabel" value="<%=ptMenuBean.getMenulabel() %>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">菜单描述:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptMenuBean.menudesc" type="text" id="menudesc" value="<%=ptMenuBean.getMenudesc() %>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">菜单顺序:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptMenuBean.levelidx" type="text" id="levelidx" value="<%=ptMenuBean.getLevelidx() %>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">菜单行为:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptMenuBean.menuaction" type="text" id="menuaction" value="<%=ptMenuBean.getMenuaction() %>" ltype="text" validate="{required:false}" />
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
