<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-22               新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
     <script language="javascript" src="<%=webpath%>/UI/zyjk/pxjg/pxjglist.js"></script>
  </head>
  <body  class="bodystyle">
  <div id="layout">
 
 <!-- 中间区域 -->
 <div class="lay-center-out"  position="center"  style="border: 0"  >
   <!-- 查询区域 -->
    <div>
    <table class="table_search_layout_1"    cellpadding="0" cellspacing="0"  >
<tr>
  
  <td class="l-table-edit-td-right" >培训机构名称：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="pxjgmc" type="text" id="pxjgmc" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >地址：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="pxjgdz" type="text" id="pxjgdz" ltype="text"  class="l-research-area-input"/>   
  </td> 
<td align="left">
<input id="searchButton"   class="l-button l-button-submit" type="button" value=" 查询 " onclick="f_search()" />
 </td> 
 </tr>
<tr>
  <td class="l-table-edit-td-right" >有效期始：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="zsyxqs" type="text" id="zsyxqs" ltype="date"  />   
  </td> 
  <td class="l-table-edit-td-right" >有效期止：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="zsyxqz" type="text" id="zsyxqz" ltype="date"  />   
  </td> 
<td align="left">
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
