<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-27    孙雁斌            新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.QyfhypffglBean"/>
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyfhypffglBean qyfhypffglBean = (QyfhypffglBean)request.getAttribute("qyfhypffglBean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 

 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/fhypffgl//fhypffgldetail.js"></script>
  </head>
  <body class="menubody" style="width: 660">
  <div class="searchtitle">        
  <%--<img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyfhypffglBean.sysno" value="<%=qyfhypffglBean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="enterno" name="qyfhypffglBean.enterno" value="<%=qyfhypffglBean.getEnterno() %>"/>
                 
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit"  align="center">
            <tr>
               
               <%--<td class="l-table-edit-td-right">用品编号：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyfhypffglBean.ypbh" type="text" id="ypbh" value="<%=qyfhypffglBean.getYpbh()%>" ltype="text" />
                </td>
                <td class="td_message"></td>
                
                --%><td class="l-table-edit-td-right" style="width:160px">防护用品：</td>
                <td class="l-table-edit-td-left" >
                   <input name="qyfhypffglBean.ypmc" type="text" id="ypmc" value="<%=qyfhypffglBean.getYpmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">车间：</td>
                <td class="l-table-edit-td-left" >
                   <input name="qyfhypffglBean.cjmc" type="text" id="cjmc" value="<%=qyfhypffglBean.getCjmc()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right" style="width:160px">工种：</td>
                <td class="l-table-edit-td-left">
                   <input name="qyfhypffglBean.gz" type="text" id="gz" value="<%=qyfhypffglBean.getGz()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">工作地点：</td>
                <td class="l-table-edit-td-left" >
                    <input name="qyfhypffglBean.gzdd" type="text" id="gzdd" value="<%=qyfhypffglBean.getGzdd() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                 <td class="l-table-edit-td-right">更换周期：</td>
                <td class="l-table-edit-td-left" >
                    <input name="qyfhypffglBean.ghzq" type="text" id="ghzq" value="<%=qyfhypffglBean.getGhzq() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
           
            <tr>
            <td class="l-table-edit-td-right" style="width:160px">备注：</td>
                <td class="l-table-edit-td-left"  colspan="4">       
                   <textarea  class="l-textarea"  cols="110"  rows="4" id="bz" name="qyfhypffglBean.bz"  
                style="width:550px" ><%=qyfhypffglBean.getBz() %></textarea> 
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
