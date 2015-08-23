<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:directive.page import="st.portal.action.MessageBean"/>
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<jsp:directive.page import="UI.util.*"/>
<jsp:directive.page import="UI.dao.zyjk.T_officerBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp" %>
<head>
<title>企业注册界面</title>
<%

T_officerBean officerBean =new T_officerBean();
QyjbqkBean qyjbqkBean=new QyjbqkBean();
MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");

%>
<script language="javascript" src="<%=webpath%>/UI/enterfile/register.js"></script>
</head>
<body class="menubody" style="width: 780;">
<%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div> 
--%><form name="form" method="post"  id="form">
<!-- 隐藏域 主键id -->
<input type="hidden" id="enterno" name="qyjbqkBean.enterno" value="<%=qyjbqkBean.getEnterno() %>"/>
<input type="hidden" id="login_id" name="officerBean.login_id" value="<%=officerBean.getLogin_id() %>"/>
<input type="hidden" id="corpkey" name="qyjbqkBean.corpkey" value="<%=qyjbqkBean.getCorpkey() %>"/>         
<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
<input type="hidden"  id="distcode" name="qyjbqkBean.distcode" value="<%=qyjbqkBean.getDistcode()%>"/>
  
<!-- 操作method -->   
<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
<!-- 操作message信息 -->    
<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
	    <br/>
     	<center><h2>注册界面</h2></center>
    	<br/>
     <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
      <tr>
        <td class="l-table-edit-td-right" >单位类型：</td>
        <td class="l-table-edit-td-left"  >
        <% 
				               	 DBSelect dbsel = new DBSelect("officerBean.dept_type","regType",officerBean.getDept_type());
				 				 dbsel.addAttr("id", "dept_type");
				                 dbsel.addAttr("check", "notBlank");
				                 dbsel.addAttr("showName", "单位类型");
				                 dbsel.addAttr("onchange","onChange(this)");
				                 dbsel.addOption("请选择","");
			 	             	 dbsel.setDisplayAll(false);
				                 out.print(dbsel);
	    %>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" >单位名称：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="officerBean.officer_name" id="officer_name" value="<%=officerBean.getOfficer_name() %>" style="width: 97%" /></td>
        <td class="td_message"></td>
      </tr>
      
      <tr>
        <td class="l-table-edit-td-right" >单 位 注 册 地 址：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.zcdz" id="zcdz" value="<%=qyjbqkBean.getZcdz() %>" style="width: 97%" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" >法定代表人：</td>
        <td class="l-table-edit-td-left" ><input type="text" ltype="text" name="qyjbqkBean.fddbr" id="fddbr" value="<%=qyjbqkBean.getFddbr() %>" style="width: 97%"/> </td>
        <td class="td_message"></td>
      </tr>
       
       <tr>
        <td class="l-table-edit-td-right">登录密码：</td>
        <td class="l-table-edit-td-left"  > <input name="unitpwd"  type="password" id="unitpwd"  ltype="text" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right">确认密码：</td>
        <td class="l-table-edit-td-left"  ><input type="password" ltype="text" name="officerBean.c_pwd" id="c_pwd" value="<%=officerBean.getC_pwd() %>" style="width: 95%"/></td>
        <td class="td_message"></td>

      </tr>
      <tr id="0205">
        <td class="l-table-edit-td-right" >组织机构代码：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.zzjgdm" id="zzjgdm" value="<%=qyjbqkBean.getZzjgdm()%>" style="width: 97%" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" >行政区划：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="" id="enuditcode" value="<%=DistcodeUtil.getDistName(qyjbqkBean.getDistcode())%>" style="width: 95%" /></td>
        <td class="td_message"></td>
      </tr>
      <tr id="0206">
        <td class="l-table-edit-td-right">企业工商注册号：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.gszch" id="gszch" value="<%=qyjbqkBean.getGszch() %>" style="width: 95%" /></td>
        <td class="td_message"></td>
        
      </tr>
    </table>
       
   <br/>
   
    <table  class="button_table">
   <tr>
     <td>
     <input type="submit" value="注册" id="subButton" class="l-button l-button-submit" /> 
</tr>
</table>
</form> 
</body>
</html>


