<!--
/*********************************************************************
 *<p>处理内容：detail 设置</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.portal.action.*,st.system.dao.PtgridscolumnBean"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.system.dao.PtformlabelBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<title>信息</title>
<%
    PtformlabelBean ptformlabelBean = (PtformlabelBean)request.getAttribute("ptformlabelBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
%>
<script  src="<%=webpath%>/UI/system/resource/grid/gridinfo.js" type="text/javascript"></script> 
</head>
<body class="formbody" style="width: 550">
	<div class="div_form">
<div class="searchtitle">          
	<img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
</div>
<div class="navline"></div>
<form name="form" method="post"  id="form">
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="sysid" name="ptformlabelBean.sysid" value="<%=ptformlabelBean.getSysid() %>"/>
			<input type="hidden" id="formid" name="ptformlabelBean.formid" value="<%=ptformlabelBean.getFormid() %>"/>
        <table cellpadding="0" cellspacing="0"  class="table-edit" >
           <tr>              
                <td class="l-table-edit-td-right">form名称</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptformlabelBean.formname" type="text" readonly="readonly" id="formname" value="<%=ptformlabelBean.getFormname()%>" ltype="text" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">TABLE名称</td>
                <td class="l-table-edit-td-left" style="width:160px">
             	   <input name="ptformlabelBean.tablename" type="text" readonly="readonly" id="tablename" value="<%=ptformlabelBean.getTablename()%>" ltype="text" />
                </td>
                <td class="td_message">
                </td>
            </tr>
            <tr>
            	<td  class="l-table-edit-td-right">标签名称</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	<input name="ptformlabelBean.labelname" type="text" id="labelname" value="<%=ptformlabelBean.getLabelname()%>"  ltype="text" />
                </td>
                <td  class="td_message"></td>
                <td   class="l-table-edit-td-right" >标签id</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                 	<input name="ptformlabelBean.labelid" type="text" id="labelid" value="<%=ptformlabelBean.getLabelid()%>"  ltype="text" />
                </td><td  class="td_message"></td>
            </tr>   
            <tr>
            	<td  class="l-table-edit-td-right">字段长度</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                	<input name="ptformlabelBean.columnlength" type="text" id="columnlength" value="<%=ptformlabelBean.getColumnlength()%>"  ltype="text" />
                </td>
                <td  class="td_message"></td>
                <td   class="l-table-edit-td-right" >标签id</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                 	<input name="ptformlabelBean.labelid" type="text" id="labelid" value="<%=ptformlabelBean.getLabelid()%>"  ltype="text" />
                </td><td  class="td_message"></td>
            </tr>   
            <tr>
                <td  class="l-table-edit-td-right" >标签类型</td>
                <td  class="l-table-edit-td-left" colspan="4" style="width:160px">
                   <%
                       DBSelect dbsel = new DBSelect("labeltype", "fieldtype",ptformlabelBean.getLabeltype());
					   dbsel.addAttr("style", "width: 100%");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "ptformlabelBean.labeltype");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %>
                </td>
                <td  class="td_message"></td>
            </tr>  
            <tr>
                <td  class="l-table-edit-td-right">字段枚举:</td>
                <td  class="l-table-edit-td-left" style="width:160px">
                   	<input type="text" id="enumnmae" name="ptformlabelBean.enumnmae" value="<%=ptformlabelBean.getEnumnmae()%>"/>
                </td>
                <td  class="td_message"></td>
                
                <td  class="l-table-edit-td-right"></td>
                <td  class="l-table-edit-td-left" style="width:160px">
				  </td>
                <td  class="td_message"></td>
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