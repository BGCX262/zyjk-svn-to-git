<!--
/****************************************************
 * <p>处理内容：评价报告基本情况</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14     新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
     <script language="javascript" src="<%=webpath%>/UI/zyjk/jsxmsts/jcjgbg/jcjgbglist.js"></script>
  </head>
  <body  class="bodystyle">
   <input type="hidden" name="enterno" id="enterno"/>
   <input type="hidden" name="xmbh" id="xmbh"/>
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
  <td class="l-table-edit-td-right" >评价类型：</td> 
  <td class="l-table-edit-td-left" >   
   <% 
				               	 DBSelect dbsel = new DBSelect("pjlx","PJLX","");
				 				 //dbsel.addAttr("style", "width: 202px;");
				 				 dbsel.addAttr("id", "pjlx");
				 				 dbsel.addAttr("class","l-research-area-input");
				                 dbsel.addAttr("check", "notBlank");
				                 dbsel.addAttr("required", "true");
				                 dbsel.addAttr("showName", "评价类型");
				                 dbsel.addOption("请选择","");
			 	             	 dbsel.setDisplayAll(false);
				                 out.print(dbsel);
				            %>  
  </td> 
   <td class="l-table-edit-td-right" >建设单位：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="jsdwmc" type="text" id="jsdwmc" ltype="text"  class="l-research-area-input"/>   
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
