<!--
/*********************************************************************
 *<p>处理内容：grid info</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.portal.action.*,st.system.dao.PtgridscolumnBean"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<title>信息</title>
<%
    PtgridscolumnBean ptgridcolumnBean = (PtgridscolumnBean)request.getAttribute("ptgridcolumnBean");
	String strGridName = request.getParameter("gridname");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
%>
<script  src="<%=webpath%>/UI/system/resource/grid/gridinfo.js" type="text/javascript"></script> 
</head>
<body class="formbody" style="width: 750px">
	<div class="div_form">
<div class="searchtitle">          
	<img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
</div>
<div class="navline"></div>
<form name="form" method="post"  id="form">
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="sysid" name="ptgridcolumnBean.sysid" value="<%=ptgridcolumnBean.getSysid() %>"/>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		    <!-- Grid名称 -->	
		 	<input type="hidden" id="gridn" name="gridn" value="<%=ptgridcolumnBean.getGridname() %>"/>
        <table cellpadding="0" cellspacing="0"  class="table-edit" >
        
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
                <td class="td_message"></td>
                <td  class="l-table-edit-td-right"></td>
                <td  class="l-table-edit-td-left" style="width:160px">
                <input class="l-button l-button-submit" type="button"  id="addcolumn" value="添加字段"/>
                </td><td  class="td_message"></td>
            </tr>
            
            <tr>
                <td  class="l-table-edit-td-right">Grid名称:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	<input name="ptgridcolumnBean.gridname" type="text" id="gridname"  value="<%=ptgridcolumnBean.getGridname()%>" ltype="text" />
                </td>
                <td class="td_message"></td>
                <td  class="l-table-edit-td-right">表名称</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	<input name="ptgridcolumnBean.tablename" type="text" id="tablename" value="<%=ptgridcolumnBean.getTablename()%>" ltype="text" />
                </td>
                <td class="td_message"></td>
                <td  class="l-table-edit-td-right"></td>
                <td  class="l-table-edit-td-left" style="width:160px">
                </td><td  class="td_message"></td>
            </tr>
            
            <tr>
            	<td  class="l-table-edit-td-right">字段名称</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	<input name="ptgridcolumnBean.columnname" type="text" id="columnname" value="<%=ptgridcolumnBean.getColumnname()%>"  ltype="text" />
                </td>
                <td  class="td_message"></td>
                <td   class="l-table-edit-td-right" >字段说明</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                 	<input name="ptgridcolumnBean.columndesc" type="text" id="columndesc" value="<%=ptgridcolumnBean.getColumndesc()%>"  ltype="text" />
                </td>
                <td  class="td_message"></td>
                <td  class="l-table-edit-td-right"></td>
                <td  class="l-table-edit-td-left" style="width:160px">
                </td><td  class="td_message"></td>
            </tr>   
             <tr>
			  <td  class="l-table-edit-td-right">是否显示</td>
			  <td  class="l-table-edit-td-left" style="width:180px">
				  <%
					   DBSelect dbsel = new DBSelect("columnhide", "BOOLTYPE",ptgridcolumnBean.getColumnhide());
					   dbsel.addAttr("style", "width: 100%");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "ptgridcolumnBean.columnhide");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %>
               </td>
               <td  class="td_message"></td>
               <td  class="l-table-edit-td-right">显示宽度</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                    <input name="ptgridcolumnBean.columnwidth" type="text" id="columnwidth" value="<%=ptgridcolumnBean.getColumnwidth()%>"   />
                </td>
                <td  class="td_message"></td>
                <td  class="l-table-edit-td-right"></td>
                <td  class="l-table-edit-td-left" style="width:160px">
                </td><td  class="td_message"></td>
            </tr>
               <tr>
			  <td  class="l-table-edit-td-right">查询条件</td>
			  <td  class="l-table-edit-td-left" style="width:180px">
				  <%
				  	   
					    dbsel = new DBSelect("isfind", "BOOLTYPE",ptgridcolumnBean.getIsfind());
					   dbsel.addAttr("style", "width: 100%");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "ptgridcolumnBean.isfind");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %>
               </td>
               <td  class="td_message"></td>
               <td  class="l-table-edit-td-right">排序</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	<input type="text" id="dispno" name="ptgridcolumnBean.dispno" value="<%=ptgridcolumnBean.getDispno()%>" />
                </td><td  class="td_message"></td>
                <td  class="l-table-edit-td-right"></td>
                <td  class="l-table-edit-td-left" style="width:160px">
                </td><td  class="td_message"></td>
            </tr>
            <tr>
                <td  class="l-table-edit-td-right" >字段类型</td>
                <td  class="l-table-edit-td-left" colspan="4" style="width:160px">
                   <%
					   dbsel = new DBSelect("columnstate", "fieldtype",ptgridcolumnBean.getColumnstate());
					   dbsel.addAttr("style", "width: 100%");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "ptgridcolumnBean.columnstate");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %>
                </td>
                <td  class="td_message"></td>
                <td  class="l-table-edit-td-right"></td>
                <td  class="l-table-edit-td-left" style="width:160px">
                </td><td  class="td_message"></td>
            </tr>  
            <tr>
                <td  class="l-table-edit-td-right">字段枚举:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                   	<input type="text" id="columnmenu" name="ptgridcolumnBean.columnmenu" value="<%=ptgridcolumnBean.getColumnmenu()%>"/>
                </td>
                <td  class="td_message"></td>
                
                <td  class="l-table-edit-td-right">字段对齐:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	  <%
					   dbsel = new DBSelect("columnalign", "fieldalign",ptgridcolumnBean.getColumnalign());
					   dbsel.addAttr("style", "width: 100%");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "ptgridcolumnBean.columnalign");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %>
				  </td>
                <td  class="td_message"></td>
                <td  class="l-table-edit-td-right"></td>
                <td  class="l-table-edit-td-left" style="width:160px">
                </td><td  class="td_message"></td>
            </tr>
        
        </table>

 <br />
<table class="button_table">
<tr>
	<td>
		<input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /> 
		<input type="button" value="关闭" id="colButton" class="l-button l-button-test"/>
	</td>
</tr>
	
</table>
 </form>
    </div>
    <div style="display:none"></div>
</body>
</html>