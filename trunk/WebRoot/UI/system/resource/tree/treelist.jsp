<!--
/*********************************************************************
 *<p>处理内容：TREE 管理</p>
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
	<script  src="<%=webpath%>UI/system/resource/tree/treelist.js" type="text/javascript"></script> 
</head>
<body class="formbody" > 
<div id="layout">
<!-- Tree区域 --> 
	<div position="left" title="TREE 名称">
	   <ul id="tree"  style="margin-top:3px;"> 
	</div>
	
<!-- info区域 -->
	<div class="lay-center-out"  position="center"  style="border: 0"  >
	 <form name="form" method="post"  id="form">
		<div>
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="treeid" name="ptreesBean.treeid" value=""/>
		</div>
        <table cellpadding="0" cellspacing="0" a class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">Tree名称:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptreesBean.treename" type="text" id="treename" value="" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">Tree说明:</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptreesBean.treedesc" type="text" id="treedesc" value="" ltype="text"  />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">选择表信息</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input type="text" id="tableid"/>
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">选择字段</td>
                <td class="l-table-edit-td-left" style="width:160px">
             	   <input type="text" id="columnid"/>
                </td>
                <td class="td_message">
                <input class="l-button l-button-submit" type="button"  id="creatsql" value="生成sql"/></td>
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">sql</td>
                <td class="l-table-edit-td-left" colspan="5">
                	<textarea rows="5"  name="ptreesBean.strsql" type="text" id="strsql" style="width: 100%"></textarea>
                </td>
            </tr>
        	<tr>
                <td class="l-table-edit-td-right">访问路径:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptreesBean.treepath" type="text" id="treepath" value="st.system.action.tree" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">树形id</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptreesBean.paramid" type="text" id="paramid" value=""  ltype="text"  />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">树形父节点   </td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptreesBean.parampid" type="text" id="parampid" value=""  ltype="text" />
                </td>
                <td class="td_message"></td>             
            	 <td class="l-table-edit-td-right">树形显示内容  </td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptreesBean.paramtext" type="text" id="paramtext" value=""  ltype="text" />
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
	</td>
</tr>
	
</table>
 </form>
	</div>		
</div>	
</body>
</html>
