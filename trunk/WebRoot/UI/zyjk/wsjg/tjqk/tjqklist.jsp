<!--
/****************************************************
 * <p>处理内容：劳动者健康检查结果</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29  新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
     <script language="javascript" src="<%=webpath%>/UI/zyjk/wsjg/tjqk/tjqklist.js"></script>
  </head>
  <body  class="bodystyle">
  <div id="layout">
	 <!-- TREE区域 -->
	 <%--<div position="left" title="菜单"> <ul id="tree"  style="margin-top:3px;"> </div>
	 --%><!-- 中间区域 -->
	 <div class="lay-center-out"  position="center"  style="border: 0"  >
     <!-- 查询区域 -->
    <div>
    <table class="table_search_layout_1"    cellpadding="0" cellspacing="0"  >
<tr>
  
  <td class="l-table-edit-td-right" >机构名称：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="jgmc" type="text" id="jgmc" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >检查单位名称：</td> 
  <td class="l-table-edit-td-left" >   
   <input name="jcdwmc" type="text" id="jcdwmc" ltype="text"  class="l-research-area-input"/>   
  </td> 
   <td class="l-table-edit-td-right" >劳动者姓名：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="ldzxm" type="text" id="ldzxm" ltype="text"  class="l-research-area-input"/>   
  </td> 
 </tr>
<tr>

<td class="l-table-edit-td-right" >自查时间段：</td> 
  <td class="l-table-edit-td-left" colspan="3"> 
  	<table>
  	<tr>
  		<td><input name="zcsj" type="text" id="zcsj" ltype="date"  /></td>
  		<td>——</td>
  		<td>  <input name="zcsje" type="text" id="zcsje" ltype="date"  /></td>
  	</tr>
  </table>  
  		</td>
  		<td align="left">
       <input id="searchButton"   class="l-button l-button-submit" type="button" value=" 查询 " onclick="f_search()" />
       </td> 
   </tr>

    </table>
    </div>
   <!-- grid区域 -->
  <div id="mainGrid"></div>
  </div>
  </div>
</body>  
</html> 
