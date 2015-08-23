<!--
/****************************************************
 * <p>处理内容：评价报告基本情况</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14  新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*, st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.JcxmxxBean"/>
<jsp:directive.page import="UI.util.DistcodeUtil"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 JcxmxxBean jcxmxxBean = (JcxmxxBean)request.getAttribute("jcxmxxBean");

 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
  if(null==jcxmxxBean){
 	jcxmxxBean=new JcxmxxBean();
 }
 if(null==messageBean){
 	messageBean=new MessageBean();
 }
 %>
    <script language="javascript" src="<%=webpath%>/UI/zyjk/jsxmsts/jsxminfo.js"></script>
  </head>
  <body class="menubody" style="width:90%;" onload="bodyload()">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form"  enctype="multipart/form-data">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="jcxmxxBean.sysno" value="<%=jcxmxxBean.getSysno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         <input type="hidden" id="jsdwbh" name="jcxmxxBean.jsdwbh" value="<%=jcxmxxBean.getJsdwbh() %>"/>
         <input type="hidden" id="jsdwmc" name="jcxmxxBean.jsdwmc" value="<%=jcxmxxBean.getJsdwmc() %>"/>
         <input type="hidden" id="distcode" name="jcxmxxBean.distcode" value="<%=jcxmxxBean.getDistcode() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" >
             <tr>
                <td class="l-table-edit-td-right">项目名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcxmxxBean.xmmc" type="text" id="xmmc" value="<%=jcxmxxBean.getXmmc() %>" ltype="text" />
                </td>
                <td class="td_message"></td>
                 <td class="l-table-edit-td-right">建设地址：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcxmxxBean.jsxmdz" type="text" id="xmdz" value="<%=jcxmxxBean.getJsxmdz() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                
            </tr>
             <tr>
               <td class="l-table-edit-td-right">建设性质：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<% 
				               	 DBSelect dbsel = new DBSelect("jcxmxxBean.jsxmxz","JSXMXZ",jcxmxxBean.getJsxmxz());
				 				 dbsel.addAttr("style", "width: 180px;");
				 				 dbsel.addAttr("id", "jsxmxz");
				                 dbsel.addAttr("check", "notBlank");
				                 dbsel.addAttr("required", "true");
				                 dbsel.addAttr("showName", "建设性质");
				                 dbsel.addOption("请选择","");
			 	             	 dbsel.setDisplayAll(false);
				                 out.print(dbsel);
				            %>  
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">所在地区：</td>
    			<td  class="l-table-edit-td-left">
    				<input type="text"  id="enuditcode" name="" value="<%=DistcodeUtil.getDistName(jcxmxxBean.getDistcode())%>"/></td>
    			<td class="td_message"></td>
            </tr>
            
            
            <tr>
               
                <td class="l-table-edit-td-right">评审单位：</td>
    			<td  class="l-table-edit-td-left">
    				 <input name="jcxmxxBean.pxdwmc" type="text" id="pxdwmc" value="<%=jcxmxxBean.getPxdwmc() %>" ltype="text" validate="{required:true }" />
                </td>
    			<td class="td_message"></td>
            </tr>
            
            
            
            <tr>
                <td class="l-table-edit-td-right">建设规模情况：</td>
                <td class="l-table-edit-td-left" style="width:160px" colspan="5">
                   <%--<input name="jcxmxxBean.jsxmgm" type="text" id="jsxmgm" value="<%=jcxmxxBean.getJsxmgm() %>" ltype="text" validate="{required:true }" />--%>
                	  <textarea  class="l-textarea"  cols="110"  rows="4" id="jsxmgm" name="jcxmxxBean.jsxmgm"  
                style="width:475px" ><%=jcxmxxBean.getJsxmgm()%></textarea>     
                </td>
               
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
