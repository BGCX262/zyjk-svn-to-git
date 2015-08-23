<!--
/****************************************************
 * <p>处理内容：用人单位配备的防护设施及个人防护用品</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14  新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.JcyrdwfhssxxBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 JcyrdwfhssxxBean jcyrdwfhssxxbean = (JcyrdwfhssxxBean)request.getAttribute("jcyrdwfhssxxbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/jcyrdwfhssxx/jcyrdwfhssxxdetail.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="jcyrdwfhssxxbean.sysno" value="<%=jcyrdwfhssxxbean.getSysno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         <input type="hidden" id="bgbh" name="jcyrdwfhssxxbean.bgbh" value="<%=jcyrdwfhssxxbean.getBgbh() %>"/>
         <input type="hidden" id="dwbh" name="jcyrdwfhssxxbean.dwbh" value="<%=jcyrdwfhssxxbean.getDwbh() %>"/>
         <input type="hidden" id="sysno" name="jcyrdwfhssxxbean.jcdwbh" value="<%=jcyrdwfhssxxbean.getJcdwbh() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">单位名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcyrdwfhssxxbean.dwmc" type="text" id="dwmc" value="<%=jcyrdwfhssxxbean.getDwmc()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">检测单位名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcyrdwfhssxxbean.jcdwmc" type="text" id="jcdwmc" value="<%=jcyrdwfhssxxbean.getJcdwmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">车间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcyrdwfhssxxbean.cj" type="text" id="cj" value="<%=jcyrdwfhssxxbean.getCj()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">生产工序：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcyrdwfhssxxbean.scgx" type="text" id="scgx" value="<%=jcyrdwfhssxxbean.getScgx() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">防护设施：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcyrdwfhssxxbean.fhss" type="text" id="fhss" value="<%=jcyrdwfhssxxbean.getFhss() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">个人防护用品：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcyrdwfhssxxbean.fhyp" type="text" id="fhyp" value="<%=jcyrdwfhssxxbean.getFhyp()%>" ltype="text" validate="{required:true }" />
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
