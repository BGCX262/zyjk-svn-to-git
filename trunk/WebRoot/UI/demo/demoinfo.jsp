<!--
/*********************************************************************
 *<p>处理内容：demo 表单域</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.portal.action.*"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<title>信息</title>
<%
	DemoBean demoBean = (DemoBean)request.getAttribute("demoBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
%>
<script  src="<%=webpath%>/UI/demo/demoinfo.js" type="text/javascript"></script> 
</head>
<body class="formbody" style="width: 550">
	<div class="div_form">
<div class="searchtitle">          
	<img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
</div>
<div class="navline"></div>
<form name="form" method="post"  id="form">
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="customerid" name="demoBean.customerid" value="<%=demoBean.getCustomerid() %>"/>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		
        <table cellpadding="0" cellspacing="0"  class="table-edit" >
            <tr>
                <td  class="l-table-edit-td-right">企业名:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	<input name="demoBean.companyname" type="text" id="companyname" value="<%=demoBean.getCompanyname()%>" ltype="text" validate="{required:true,minlength:3,maxlength:10}" />
                </td>
                <td class="td_message"></td>
                <td  class="l-table-edit-td-right">联系人:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	<input name="demoBean.contactname" type="text" id="contactname" value="<%=demoBean.getContactname()%>" ltype="text" validate="{required:true,minlength:3,maxlength:10}" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
            	<td  class="l-table-edit-td-right">传真:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	<input name="demoBean.fax" type="text" id="fax" value="<%=demoBean.getFax()%>"  ltype="text" validate="{required:true,minlength:3,maxlength:10}" />
                </td>
                <td  class="td_message"></td>
                <td   class="l-table-edit-td-right" >性别:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                 <%
                 	 DBRadio dbrad = new DBRadio("contacttitle","demoBean.contacttitle","SEX",demoBean.getContacttitle());
                    out.print(dbrad.toString());
                 %>
                </td><td  class="td_message"></td>
            </tr>   
             <tr>
			  <td  class="l-table-edit-td-right">城市:</td>
			  <td  class="l-table-edit-td-left" style="width:180px">
				  <%
				  	   
					   DBSelect dbsel = new DBSelect("city", "CHKRESULT",demoBean.getCity());
					   dbsel.addAttr("style", "width: 100%");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "demoBean.city");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %>
               </td>
               <td  class="td_message"></td>
               <td  class="l-table-edit-td-right">时间:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                    <input name="demoBean.region" type="text" id="region" value="<%=demoBean.getRegion()%>" ltype="date" validate="{required:true}" />
                </td><td  class="td_message"></td>
            </tr>
            <tr>
                <td  class="l-table-edit-td-right" >国家:</td>
                <td  class="l-table-edit-td-left" colspan="4" style="width:160px">
                    <%
                 	 	DBCheckBox check = new DBCheckBox("country","demoBean.country","CHKRESULT",demoBean.getCountry());
                     	out.print(check.toString());
                   %>
                </td>
                <td  class="td_message"></td>
            </tr>  
            <tr>
                <td  class="l-table-edit-td-right">年龄:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                    <input name="demoBean.phone" type="text" id="phone" value="<%=demoBean.getPhone()%>"  ltype='spinner' ligerui="{type:'int'}" value="20" class="required" validate="{digits:true,min:1,max:100}" />
                </td>
                <td  class="td_message"></td>
                
                <td  class="l-table-edit-td-right">Email:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	<input name="demoBean.postalcode" type="text" id="postalcode" value="<%=demoBean.getPostalcode()%>" ltype="text" validate="{required:true,email:true}" /></td>
                <td  class="td_message"></td>
            </tr>
            
            <tr>
                <td  class="l-table-edit-td-right">地址:</td>
                <td  class="l-table-edit-td-left" colspan="4" > 
                <textarea cols="110"  rows="3" class="l-textarea" id="address" name="demoBean.address"  style="width:430px" validate="{required:true}" ><%=demoBean.getAddress()%></textarea>
                </td> 
                <td  class="td_message"></td>
            </tr>
        </table>

 <br />
<table class="button_table">
<tr>
	<td>
		<input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /> 
		<input type="button" value="关闭" id="colButton" class="l-button l-button-test"/>
	</td>
</tr>
	
</table>
 </form>
    </div>
    <div style="display:none"></div>
</body>
</html>