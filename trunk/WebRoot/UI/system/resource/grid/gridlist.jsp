<!--
/*********************************************************************
 *<p>处理内容：grid 管理</p>
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
	<script  src="<%=webpath%>UI/system/resource/grid/gridlist.js" type="text/javascript"></script> 
</head>
<body class="formbody" > 
<div id="layout">
<!-- Tree区域 --> 
	<div position="left" title="GridTree">
	   <ul id="tree"  style="margin-top:3px;overflow:scroll;height:540px;width:250px">
	</div>
	
<!-- info区域 -->
	<div class="lay-center-out"  position="center"  style="border: 0"  >
    <div id="accordion1"> 
     <div title="Grid列表">
  	<div id="mainGrid"></div>
  </div>
     <div title="Grid信息">
	 <form name="form" method="post"  id="form">
		<div style="margin-top: 10px">
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="gridid" name="ptgridBean.gridid" value=""/>
		</div>
		
		
		<fieldset style="border-color: black;margin-left: 20px" >
		<legend style="color: red;">第一步:</legend>
        <table cellpadding="0" cellspacing="0"  class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">grid名称:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptgridBean.gridname" type="text" id="gridname" value="" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">grid说明:</td>
                <td class="l-table-edit-td-left"  style="width:160px"> 
                <input name="ptgridBean.griddesc" type="text" id="griddesc" value="" ltype="text"  />
                 
               </td> 
                <td class="td_message"><input type="button" value="提交"  class="l-button l-button-submit" /> </td>
            </tr>
          </table>
          </fieldset>
           <br />
        <fieldset style="border-color: black;margin-left: 20px" >
		<legend style="color: red;">第二步:</legend>
           <table cellpadding="0" cellspacing="0"  class="form-l-table-edit" >
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
                <input class="l-button l-button-submit" type="button"  id="creatsql" value="添加字段"/></td>
            </tr>
          </table>
         </fieldset>
          <br />
         <fieldset style="border-color: black;margin-left: 20px" >
         <legend style="color: red;">第三步:</legend>
           <table cellpadding="0" cellspacing="0"  class="form-l-table-edit" >
             <tr>              
                <td class="l-table-edit-td-right">sql</td>
                <td class="l-table-edit-td-left" colspan="5">
                	<textarea rows="5"  name="ptgridBean.sqlstr" type="text" id="sqlstr" style="width: 100%"></textarea>
                </td>
            </tr>
        	<tr>
                <td class="l-table-edit-td-right">pagesize</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptgridBean.pagesize" type="text" id="pagesize" value="15" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">sqlWHERE</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                	<input name="ptgridBean.wherestr" type="text" id="wherestr" value=" where(1=1)" ltype="text"  />
               </td> 
                <td class="td_message"> </td>
                  <td><input class="l-button l-button-submit" type="button"  id="addsql" value="生成sql"/>
                  </td>
            </tr>
            </table>
           </fieldset>
            <br />
           <fieldset style="border-color: black;margin-left: 20px" >
           <legend style="color: red;">第四步:</legend>
           <table cellpadding="0" cellspacing="0"  class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">jsp名称</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptgridBean.fieldname" type="text" id="fieldname" value="15" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">jsp路径</td>
                <td class="l-table-edit-td-left" colspan="4" > 
                <input name="ptgridBean.fieldpath" type="text" id="fieldpath"  ltype="text"  />
               </td> 
                <td class="td_message"></td>
            </tr>
           <tr>
                <td class="l-table-edit-td-right">是否tree查询</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<%
					   DBSelect dbsel = new DBSelect("istree", "BOOLTYPE");
					   dbsel.addAttr("style", "width: 100%");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "ptgridcolumnBean.istree");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %>
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">tree名称</td>
                <td class="l-table-edit-td-left" colspan="4" >
                 <input type="text" id="treename" name="ptgridBean.treename" /> 
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">oderbystr</td>
                <td class="l-table-edit-td-left" style="width:160px">
               <input type="text" id="orderstr" name="ptgridBean.orderstr" /> 
                </td>
                <td class="l-table-edit-td-right">action</td>
                 <td class="l-table-edit-td-left" colspan="4" >
                	<input name="ptgridBean.actionname" style="width: 300px" id="actionname"  />
                </td>
                <td class="td_message"></td>
            </tr>
         </table>
        </fieldset>
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
 </div>
</div>		
</body>
</html>
