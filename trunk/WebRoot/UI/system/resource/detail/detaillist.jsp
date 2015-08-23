<!--
/*********************************************************************
 *<p>处理内容：DETAIL 管理</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.14---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
	<script  src="<%=webpath%>UI/system/resource/detail/detaillist.js" type="text/javascript"></script> 
</head>
<body class="formbody" > 
<div id="layout">
<!-- Tree区域 --> 
	  <div position="left"  title="表单名称">
	   <ul id="tree"  style="margin-top:3px;"> 
	   </div>
<!-- Detailm区域 -->
	<div class="lay-center-out"  position="center"  style="border: 0"  >
	<div>
	 <form name="form" method="post"  id="form">
		<div>
			<input type="hidden" id="formid" name="ptformBean.formid" value=""/>
		</div>
        <table cellpadding="0" cellspacing="0" a class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">FORM名称:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptformBean.formname" type="text" id="formname" value="" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">JSP路径:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptformBean.formpath" type="text" id="formpath" value="" ltype="text"  />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">ACTION</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptformBean.actionname" type="text" id="actionname" value="" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right"></td>
                <td class="l-table-edit-td-left" colspan="4" > 
                
               </td> 
                <td class="td_message"></td>
            </tr>
        </table>
 <br />
<table align="center">
<tr>
	<td>
	    <input type="reset"  value="清空" id="reset" class="l-button l-button-submit" /> 
		<input type="button" value="提交" id="subButton" class="l-button l-button-submit" /> 
		<input type="button" value="设置info页面" id="addinfo" class="l-button l-button-submit" /> 
	</td>
</tr>
</table>
 <br />
 </form>
 </div>
 <div id="mainGrid"></div>	
</div>	
</body>
</html>
