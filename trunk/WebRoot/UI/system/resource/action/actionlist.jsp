<!--
/*********************************************************************
 *<p>处理内容：ACTION 管理</p>
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
	<script  src="<%=webpath%>UI/system/resource/action/actionlist.js" type="text/javascript"></script> 
</head>
<body class="formbody" > 
<div id="layout">
<!-- Tree区域 --> 
<div position="left"  title="Action名称">

	   <ul id="tree"  style="margin-top:3px;overflow:scroll;;height:630px;width:200px"> 
	   </div>
	
<!-- info区域 -->
	<div class="lay-center-out"  position="center"  style="border: 0"  >
	<div>
	 <form name="form" method="post"  id="form">
		<div>
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="sysid" name="ptactionBean.sysid" value=""/>
		</div>
        <table cellpadding="0" cellspacing="0" a class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">ACTION名称:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptactionBean.actionname" type="text" id="actionname" value="" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">ACTION 路径:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptactionBean.actionpath" type="text" id="actionpath" value="" ltype="text"  />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">ACTION说明:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptactionBean.actiondesc" type="text" id="actiondesc" ltype="text" />
                </td>
                <td class="td_message"></td>             
            	  <td class="l-table-edit-td-right">BEAN名称:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptactionBean.beanname" type="text" id="beanname" value=""  ltype="text"  />
               </td> 
                <td class="td_message"></td>
            </tr>
        	<tr>
                <td class="l-table-edit-td-right">信息页面:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptactionBean.infopage" type="text" id="infopage" value=""  ltype="text" />
                </td>
                 <td class="l-table-edit-td-right"></td>
                <td class="l-table-edit-td-left" style="width:160px">
                	
                </td>
                <td class="td_message"></td>  
            </tr>
        </table>
 <br />
<table align="center">
<tr>
	<td>
	    <input type="reset" value="清空" id="reset" class="l-button l-button-submit" /> 
		<input type="button" value="提交" id="subButton" class="l-button l-button-submit" /> 
		<input type="button" value="初始化" id="initButton" class="l-button l-button-submit" /> 
	</td>
</tr>
	
</table>
 </form>
 </div>
<br/>
	<!-- GRID区域 -->
	<div style="border: 0" id="mainGrid" >
	</div>	
	</div>		
</div>	
</body>
</html>
