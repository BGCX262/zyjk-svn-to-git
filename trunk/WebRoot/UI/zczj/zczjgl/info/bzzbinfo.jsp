<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-02   孙雁斌       新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.T_yhzc_bzzbBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 T_yhzc_bzzbBean bzzbBean=(T_yhzc_bzzbBean)request.getAttribute("bzzbBean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");

 %>
    <script language="javascript" src="<%=webpath%>//UI/zczj/zczjgl/info/bzzbinfo.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 操作method -->      
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="id" name="bzzbBean.id" value="<%=bzzbBean.getId() %>"/>
            
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" >
        <tr>
        <td class="l-table-edit-td-right">检查表名称</td>
                <td class="l-table-edit-td-left" style="width:160px">
                
                  <input type="text" id="bzzmc" name="bzzbBean.bzzmc" value="<%=bzzbBean.getBzzmc() %>"/>         
                </td>
                <td class="td_message"></td>
        </tr>
        <tr>
          <td class="l-table-edit-td-right">监管分类</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <% 
                 DBSelect dbsel = new DBSelect("bzzbBean.jglx","",bzzbBean.getJglx());
	 				 dbsel.addAttr("style", "width: 202px;");
	 				 dbsel.addAttr("id", "jglx");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "监管分类");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	           %>
                </td>
                <td class="td_message"></td>
        </tr>

           
             <tr>
                <td class="l-table-edit-td-right">标准描述</td>
                <td class="l-table-edit-td-left" style="width:160px" rowspan="3">
                    <textarea class="l-textarea"  id="bzsm" name="bzzbBean.bzsm"  style="width:475px" ><%=bzzbBean.getBzsm()%></textarea>           
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
