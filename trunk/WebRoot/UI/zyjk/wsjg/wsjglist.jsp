<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-23               新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp" %>
 <head>
 <title></title>
     <script language="javascript" src="<%=webpath%>/UI/zyjk/wsjg/wsjglist.js"></script>
  </head>
  <body  class="bodystyle">
  <div id="layout">
 
 <!-- 中间区域 -->
 <div class="lay-center-out"  position="center"  style="border: 0"  >
   <!-- 查询区域 -->
    <div>
    <table class="table_search_layout_1"    cellpadding="0" cellspacing="0"  >
<tr>
 
  <td class="l-table-edit-td-right" >机构名称：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="jgmc" type="text" id="jgmc" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >地址：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="jgdz" type="text" id="jgdz" ltype="text"  class="l-research-area-input"/>   
  </td>
  <td class="l-table-edit-td-left" ></td>  
<td class="l-table-edit-td-left">
<input id="searchButton"   class="l-button l-button-submit" type="button" value=" 查询 " onclick="f_search()" />
 </td> 
 </tr>
<tr>
 
  <td class="l-table-edit-td-right" >批准文号：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="pzwh" type="text" id="pzwh" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >批准单位：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="pzdw" type="text" id="pzdw" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >批准时间：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="pzsj" type="text" id="pzsj" ltype="date"  />   
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
