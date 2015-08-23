<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyleft: Copyleft (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-02   孙雁斌       新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.ZczjdfbBean"/>
<jsp:directive.page import="UI.dao.zyjk.T_yhzc_bzbBean"/>
<%@ include file="/webpath.jsp"%>
<%@ page import="st.portal.html.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 Transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html>
<link href="<%=webpath%>/js/ligerUI/skins/Aqua/css/ligerui-all.css"   rel="stylesheet" type="text/css" />
<link href="<%=webpath%>/js/ligerUI/skins/ligerui-icons.css"          rel="stylesheet" type="text/css" />
<link href="<%=webpath%>/css/zpf.css"  								  rel="stylesheet" type="text/css" />   
<!--全文jquery引用 -->
<script src="<%=webpath%>/js/jquery/jquery-1.4.4.min.js"              type="text/javascript"></script>
<!-- ligerUI控件 -->
<script src="<%=webpath%>/js/ligerUI/js/core/base.js"                 type="text/javascript"></script> 
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerGrid.js"         type="text/javascript"></script> 
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerTextBox.js"      type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerCheckBox.js"     type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerMenu.js"         type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerComboBox.js"     type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerMenuBar.js"      type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerToolBar.js"      type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerButton.js"       type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerResizable.js"    type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerDrag.js"         type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerDialog.js"       type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerForm.js"         type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerDateEditor.js"   type="text/javascript"></script>

<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerSpinner.js"      type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerTip.js"          type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerTree.js"         type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerLayout.js" 	  type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerTab.js"          type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerAccordion.js" 	  type="text/javascript"></script>  


<!-- validation控件 -->
<script src="<%=webpath%>/js/jquery-validation/jquery.validate.min.js" type="text/javascript"></script> 
<script src="<%=webpath%>/js/jquery-validation/jquery.metadata.js"     type="text/javascript"></script>
<script src="<%=webpath%>/js/jquery-validation/messages_cn.js"         type="text/javascript"></script>
    
<!-- JS全局变量 -->
<script src="<%=webpath%>/js/jsConstant.js"                            type="text/javascript"></script>     
<script src="<%=webpath%>/js/zbasic.js"                                type="text/javascript"></script>
<script src="<%=webpath%>/js/zgrid.js"                                 type="text/javascript"></script>
<script src="<%=webpath%>/js/zform.js"                                 type="text/javascript"></script>



 <head>
 <title></title>
 <%
 T_yhzc_bzbBean bzbBean=(T_yhzc_bzbBean)request.getAttribute("bzbBean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
 
 
    <script language="javascript" src="<%=webpath%>/UI/zczj/zczjgl/info/bzbinfo.js"></script>
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
         <input type="hidden" id="id" name="bzbBean.id" value="<%=bzbBean.getId() %>"/>
         
         <!-- 隐藏域 主表id -->
         <input type="hidden" id="zbid" name="bzbBean.zbid" value="<%=bzbBean.getZbid() %>"/>
         
         <!-- 隐藏域 父键id -->
         <input type="hidden" id="parentid" name="bzbBean.parentid" value="<%=bzbBean.getParentid()%>"/>
         
         <!-- 隐藏域 父键集合id -->
         <input type="hidden" id="allparentid" name="bzbBean.allparentid" value="<%=bzbBean.getAllparentid()%>"/>
         
         <!-- 隐藏域 等级level -->
         <input type="hidden" id="level" name="bzbBean.level" value="<%=bzbBean.getLevel()%>"/>
         
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
     <table style="border-top: 0px;"   cellpadding="0" cellspacing="0" class="form-l-table-edit">
       <tr><td align="center">类型</td>
         <td><div>
		<% 
				     DBRdBox check = new DBRdBox("isleaf","","MOJI",bzbBean.getIsleaf());
                     out.print(check.toString());
		%>

		</div>
		<input type="hidden" id="moji" name="bzbBean.isleaf" value="<%=bzbBean.getIsleaf()%>"/>
		</td></tr>
		<tr id="bzmcTr">
			<td class="l-table-edit-td-left" align="center">标准名称</td>
			<td class="l-table-edit-td-left">
				<input class="text" id="bzmc" name="bzbBean.bzmc" value="<%=bzbBean.getBzmc() %>" style="width: 99%" />
			</td>
		</tr>
		<tr>
			<td class="l-table-edit-td-left" >顺序号</td>
			<td class="l-table-edit-td-left">
				<input class="text" id="sxh" name="bzbBean.sxh" value="<%=bzbBean.getSxh()%>" style="width: 99%" />
			</td>
		</tr>
		<tr>
			<td class="l-table-edit-td-left" >属性</td>
			<td class="l-table-edit-td-left">
				<%
					DBSelect dbsel = new DBSelect("sx", "SX","");
					dbsel.addAttr("style", "width: 150px");
					dbsel.addAttr("id", "sx");
					dbsel.addAttr("fieldType", "text");
					dbsel.addAttr("alertTitle", "属性");
					dbsel.addOption("请选择", "");
					dbsel.setDisplayAll(false);
					out.print(dbsel);
				%>
			</td>
		</tr>
		<tr>
			<td class="l-table-edit-td-left" >行政区划</td>
			<td class="l-table-edit-td-left">
				<%
					dbsel = new DBSelect("distcode", "","");
					dbsel.addAttr("style", "width: 150px");
					dbsel.addAttr("id", "distcode");
					dbsel.addAttr("fieldType", "text");
					dbsel.addAttr("alertTitle", "行政区划");
					dbsel.addOption("请选择", "");
					dbsel.setDisplayAll(false);
					out.print(dbsel);
				%>
			</td>
		</tr>
     </table>
	<table id="seltb" style="border-top: 0px;display: none"   cellpadding="0" cellspacing="0" class="form-l-table-edit" >
		<tr>
			<td class="l-table-edit-td-left">责任部门</td>
			<td  class="l-table-edit-td-left">
				<%
					dbsel = new DBSelect("bzbBean.hybmid", "bulx",bzbBean.getHybmid());
					dbsel.addAttr("style", "width: 150px");
					dbsel.addAttr("id", "hybmid");
					dbsel.addAttr("fieldType", "text");
					dbsel.addAttr("alertTitle", "责任部门");
					dbsel.addOption("请选择", "");
					dbsel.setDisplayAll(false);
					out.print(dbsel);
				%>
			</td>
		</tr>
		<tr>
			<td  class="l-table-edit-td-left">自查标准描述</td>
			<td  class="l-table-edit-td-left">
				<textarea style="width:99%" name="pdnr"  id="pdnr" value="<%=bzbBean.getBzmc() %>"><%=bzbBean.getBzmc() %></textarea>
			</td>
		</tr>
		<tr>
			<td class="l-table-edit-td-left">参考依据</td>
			<td class="l-table-edit-td-left">
				<textarea style="width:99%" name="bzbBean.ckyj"  id="ckyj" value="<%=bzbBean.getCkyj() %>"></textarea>
			</td>
		</tr>
</table>
	
 <br/>
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
