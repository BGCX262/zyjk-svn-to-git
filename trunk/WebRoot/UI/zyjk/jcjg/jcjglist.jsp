<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-17               新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
     <script language="javascript" src="<%=webpath%>/UI/zyjk/jcjg/jcjglist.js"></script>
  </head>
  <body  class="bodystyle">
  <div id="layout">
 <!-- TREE区域
 <div position="left" title="菜单"> <ul id="tree"  style="margin-top:3px;"> </div> -->
 <!-- 中间区域 -->
 <div class="lay-center-out"  position="center"  style="border: 0"  >
   <!-- 查询区域 -->
    <div>
    <table class="table_search_layout_1"    cellpadding="0" cellspacing="0"  >
<tr>
  
  <td class="l-table-edit-td-right" >单位名称：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="dwmc" type="text" id="dwmc" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >资质证书编号：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="zzzsbh" type="text" id="zzzsbh" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >法定代表人：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="fddbr" type="text" id="fddbr" ltype="text"  class="l-research-area-input"/>   
  </td> 
<td align="left">
<input id="searchButton"   class="l-button l-button-submit" type="button" value=" 查询 " onclick="f_search()" />
 </td> 
 </tr>
<tr>
  <td class="l-table-edit-td-right" >发证日期：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="fzdate" type="text" id="fzdate" ltype="date"  />   
  </td> 
  <td class="l-table-edit-td-right" >有效期：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="yxq" type="text" id="yxq" ltype="date"  />   
  </td> 
  
  <td class="l-table-edit-td-right" >联系电话：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="lxdh" type="text" id="lxdh" ltype="text"  class="l-research-area-input"/>   
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
