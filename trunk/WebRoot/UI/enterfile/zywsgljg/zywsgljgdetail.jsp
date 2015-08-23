<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27             新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QygljgrymxBean qygljgrymxbean = (QygljgrymxBean)request.getAttribute("qygljgrymxbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>/UI/enterfile/zywsgljg/zywsgljgdetail.js"></script>
  
  </head>
  <body class="menubody" style="width: 585">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qygljgrymxbean.sysno" value="<%=qygljgrymxbean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="enterno" name="qygljgrymxbean.enterno" value="<%=qygljgrymxbean.getEnterno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         
          <input type="hidden" id="deptno" name="qygljgrymxbean.deptno" value="<%=qygljgrymxbean.getDeptno() %>"/>
          <input type="hidden" id="wsjgname" name="qygljgrymxbean.wsjgname" value="<%=qygljgrymxbean.getWsjgname()%>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">姓名：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qygljgrymxbean.name" type="text" id="name" value="<%=qygljgrymxbean.getName() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>    
                <td class="l-table-edit-td-right">性别：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <% 
	               	 DBSelect dbsel = new DBSelect("qygljgrymxbean.sex","SEX",qygljgrymxbean.getSex());
	 				 //dbsel.addAttr("style", "width: 202px;");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "是否专职");
	                 //dbsel.addAttr("name","qygljgrymxbean.sex");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	               %>
                
                </td>
               <td class="td_message"></td>      
            </tr>
            <tr>
                <td class="l-table-edit-td-right">出生年月：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qygljgrymxbean.birthday" type="text" id="birthday" value="<%=qygljgrymxbean.getBirthday() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>     
                <td class="l-table-edit-td-right">行政职务：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qygljgrymxbean.duty" type="text" id="duty" value="<%=qygljgrymxbean.getDuty() %>" ltype="text" />
                </td>
                <td class="td_message"></td>     
            </tr>
            <tr>
                
                <td class="l-table-edit-td-right">是否专职：</td>
                <td class="l-table-edit-td-left"  >
        	       <% 
	               	 dbsel = new DBSelect("iszz","SF",qygljgrymxbean.getIszz());
	 				 //dbsel.addAttr("style", "width: 202px;");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "是否专职");
	                 dbsel.addAttr("name","qygljgrymxbean.iszz");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	               %>
                 </td>
                 <td class="td_message"></td>    
            </tr>
            <tr>
            <td class="l-table-edit-td-right">受过何种职业卫生的培训和教育：</td>
            <td class="l-table-edit-td-left" colspan="4">
           <textarea  class="l-textarea"   cols="110"  rows="4" id="experience" name="qygljgrymxbean.experience"  style="width:475px" ><%=qygljgrymxbean.getExperience()%></textarea>              
                </td>
                 <td class="td_message"></td>     
            </tr>
            <tr>
                <td class="l-table-edit-td-right">备注：</td>
                <td class="l-table-edit-td-left" colspan="4">
        <textarea  class="l-textarea"  cols="110"  rows="4" id="remark" name="qygljgrymxbean.remark"  style="width:475px" ><%=qygljgrymxbean.getRemark()%></textarea>
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
