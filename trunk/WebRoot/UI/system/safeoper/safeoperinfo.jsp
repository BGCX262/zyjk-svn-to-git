<!--
/*********************************************************************
 *<p>处理内容：safeoper 表单域</p>
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
<script src="<%=webpath%>/UI/system/safeoper/safeoperinfo.js" type="text/javascript"></script>
<title>信息</title>
<%
    PtoperBean ptOperBean= (PtoperBean)request.getAttribute("ptOperBean");
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
			<input type="hidden" id="sysno" name="ptOperBean.sysno" value="<%=ptOperBean.getSysno() %>"/>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		</div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">人员证件号:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptOperBean.operid" type="text" id="operid" value="<%=ptOperBean.getOperid() %>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">人员姓名:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptOperBean.opernm" type="text" id="opernm" value="<%=ptOperBean.getOpernm() %>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">性别:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptOperBean.sex" type="text" id="sex" value="<%=ptOperBean.getSex() %>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">国籍:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptOperBean.nation" type="text" id="nation" value="<%=ptOperBean.getNation() %>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">生日:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptOperBean.birthday" type="text" id="birthday" value="<%=ptOperBean.getBirthday() %>" ltype="date" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">部门编号:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptOperBean.deptid" type="text" id="deptid" value="<%=ptOperBean.getDeptid() %>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">调入日期:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptOperBean.indt" type="text" id="indt" value="<%=ptOperBean.getIndt() %>"ltype="date" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">职务:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptOperBean.duty" type="text" id="duty" value="<%=ptOperBean.getDuty() %>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">教育程度:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptOperBean.edudegree" type="text" id="edudegree" value="<%=ptOperBean.getEdudegree() %>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">座机:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptOperBean.telno" type="text" id="telno" value="<%=ptOperBean.getTelno() %>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">手机:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptOperBean.mobileno" type="text" id="mobileno" value="<%=ptOperBean.getMobileno() %>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">电子邮箱:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptOperBean.email" type="text" id="email" value="<%=ptOperBean.getEmail() %>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">密码:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptOperBean.passwd" type="text" id="passwd" value="<%=ptOperBean.getPasswd()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">操作状态:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptOperBean.opersta" type="text" id="opersta" value="<%=ptOperBean.getOpersta() %>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
          
            <tr>              
                <td class="l-table-edit-td-right">简历:</td>
                <td class="l-table-edit-td-left" style="width:160px" colspan="4">               	
                 <textarea  cols="110"  rows="3" class="l-textarea" id="resume" name="ptOperBean.resume"  style="width:430px" validate="{required:true}" ><%=ptOperBean.getResume() %></textarea>
                </td>
                <td class="td_message"></td>             
            	
            </tr>
            
            <tr>              
                <td class="l-table-edit-td-right">备注:</td>
                <td class="l-table-edit-td-left" style="width:160px" colspan="4">
                 <textarea  cols="110"  rows="3" class="l-textarea" id="memo" name="ptOperBean.memo"  style="width:430px" validate="{required:true}" ><%=ptOperBean.getMemo() %></textarea>
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
