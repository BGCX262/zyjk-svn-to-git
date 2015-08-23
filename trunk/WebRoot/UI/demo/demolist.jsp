<!--
/*********************************************************************
 *<p>处理内容：demo列表</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
	<script  src="<%=webpath%>/UI/demo/demolist.js" type="text/javascript"></script> 
</head>
<body class="bodystyle"> 
<div id="layout">
<!-- 查询区域 -->
	<div    position="top"> 
	<table class="table_search_layout_1"    cellpadding="0" cellspacing="0"  >
	    <tr >
            <td class="l-table-edit-td-right" >   
            	公司名：
            </td>
	        <td  class="l-table-edit-td-left">
	        	<input name="companyName" type="text" id="companyName" ltype="text"  />
	        </td>
            <td align="left">
         		<input id="searchButton"   class="l-button l-button-submit" type="l-button l-button-submit" value=" 查询 " onclick="f_search()" />   
            </td>
	</table>
	</div>
	<!-- GRID区域 -->
	<div position="center"  style="border: 0" id="mainGrid" >
	</div>		
</div>	
</body>
</html>
