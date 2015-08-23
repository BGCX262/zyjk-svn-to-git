<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27               新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.Z_corBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 Z_corBean z_corBean = (Z_corBean)request.getAttribute("z_corBean");
  if( z_corBean ==null)
  {
        z_corBean  = new Z_corBean();
  }
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
  if(messageBean==null)
  {
      messageBean = new MessageBean();
  }
 %>
    <script language="javascript" src="<%=webpath%>//UI/zyjk/cor//zcordetail.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">企业编号：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="z_corBean.corpkey" type="text" id="corpkey" value="<%=z_corBean.getCorpkey() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">企业名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="z_corBean.dwmc" type="text" id="dwmc" value="<%=z_corBean.getDwmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">建厂日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                                   </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">注册地址：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="z_corBean.zcdz" type="text" id="zcdz" value="<%=z_corBean.getZcdz() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">注册地址编码：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="z_corBean.zcyzbm" type="text" id="zcyzbm" value="<%=z_corBean.getZcyzbm() %>" ltype="text" validate="{required:true,minlength:0,maxlength:6}" />
                </td>
                <td class="td_message"></td>
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
