<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  孙雁斌;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-18    孙雁斌           新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="st.system.dao.PtoperBean"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 PtoperBean ptoperBean = (PtoperBean)request.getAttribute("ptoperBean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 if(null==messageBean){
	 
	 messageBean=new MessageBean();
 }
 if(null==ptoperBean){
	 
	 ptoperBean=(PtoperBean )session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
 }
 %>
    <script language="javascript" src="<%=webpath%>/UI/system/user/modifypass.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
              
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="ptoperBean.sysno" value="<%=ptoperBean.getSysno()%>"/>
         <!-- 操作method -->      
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">输入新密码：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="unitpwd"  type="password" id="unitpwd"  ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">验证新密码：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                    <input name="ptoperBean.passwd"  type="password" id="passwd"  ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
        </table>
 <br />
<table align="center">
<tr>
 <td>
     <input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /> 
     <input type="button" value="重置" id="colButton" class="l-button l-button-test"/>
 </td>
</tr>
 
</table>
 </form>
    
</body>  
</html> 
