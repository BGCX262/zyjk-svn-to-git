<!--
/*********************************************************************
 *<p>处理内容：enudetail 表单域</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.20---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  import="st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script src="<%=webpath%>/UI/system/enum/enudetailinfo.js" type="text/javascript"></script>
<title>信息</title>
<%
    PtenudetailBean ptEnuDetailBean = (PtenudetailBean)request.getAttribute("ptEnuDetailBean");
    PtenumainBean ptEnuMainBean = (PtenumainBean)request.getAttribute("ptEnuMainBean");
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
            <!-- 操作 -->		 	
		 	<input type="hidden" id="enutype" name="ptEnuMainBean.enutype" value="<%=ptEnuMainBean.getEnutype() %>"/>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>

		</div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">枚举值:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptEnuDetailBean.enuitemvalue" type="text" id="enuitemvalue" value="<%=ptEnuDetailBean.getEnuitemvalue() %>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">枚举名称:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptEnuDetailBean.enuitemlabel" type="text" id="enuitemlabel" value="<%=ptEnuDetailBean.getEnuitemlabel() %>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">枚举描述:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptEnuDetailBean.enuitemdesc" type="text" id="enuitemdesc" value="<%=ptEnuDetailBean.getEnuitemdesc() %>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">编号:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptEnuDetailBean.dispno" type="text" id="dispno" value="<%=ptEnuDetailBean.getDispno() %>" ltype="text" validate="{required:true}" />
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
