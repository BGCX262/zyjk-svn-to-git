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
     <script language="javascript" src="<%=webpath%>/UI/zyjk/jsxmsts/jgjsxmlist.js"></script>
  </head>
  <body  class="bodystyle">
   <input type="hidden" name="jsdwbh" id="jsdwbh"/>
  <div id="layout">
	 <!-- TREE区域 -->
	 <%--<div position="left" title="菜单"> <ul id="tree"  style="margin-top:3px;"> </div>
	 --%><!-- 中间区域 -->
	 <div class="lay-center-out"  position="center"  style="border: 0"  >
     <!-- 查询区域 -->
    <div>
    <table class="table_search_layout_1"    cellpadding="0" cellspacing="0"  >
<tr>
  
  <td class="l-table-edit-td-right" >项目名称：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="xmmc" type="text" id="xmmc" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >项目性质：</td> 
  <td class="l-table-edit-td-left" >   
   <% 
				               	 DBSelect dbsel = new DBSelect("xmxz","JSXMXZ","");
				 				 dbsel.addAttr("style", "width: 140px;");
				 				 dbsel.addAttr("id", "xmxz");
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
<td align="left">&nbsp;
 </td> 
 </tr>
<tr>
  
  <td class="l-table-edit-td-right" >检测机构名称：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="jcjgmc" type="text" id="jcjgmc" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >项目地址：</td> 
  <td class="l-table-edit-td-left" >   
   <input name="xmdz" type="text" id="xmdz" ltype="text"  class="l-research-area-input"/>   
  </td> 
   <td class="l-table-edit-td-right" >&nbsp;</td> 
  <td class="l-table-edit-td-left" >   
  &nbsp;
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
