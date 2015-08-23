<!--
/*********************************************************************
 *<p>处理内容：ptdept 表单域</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.20---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  import="st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.util.DistcodeUtil"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script src="<%=webpath%>/UI/system/ptdept/ptdeptinfo.js" type="text/javascript"></script>
<title>信息</title>
<%
	PtdeptBean ptDeptBean = (PtdeptBean)request.getAttribute("ptDeptBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
%>      
</head>

<body class="menubody">
<div class="searchtitle">          
	<img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
</div>
<div class="navline" ></div>

<form name="form" method="post"  id="form">
		<div>
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="deptno" name="ptDeptBean.deptno" value="<%=ptDeptBean.getDeptno()%>"/>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod()%>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		</div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" >
            <tr>
                <td class="l-table-edit-td-right">机构名称:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptDeptBean.deptnm" type="text" id="deptnm" value="<%=ptDeptBean.getDeptnm()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">机构级别:</td>
                <td class="l-table-edit-td-left" style="width:160px" > 
                <input name="ptDeptBean.deptlvl" type="text" id="deptlvl" value="<%=ptDeptBean.getDeptlvl()%>" ltype="text" validate="{required:false}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">地区:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="distcodename" type="text" id="distcodename" value="<%=DistcodeUtil.getDistName(ptDeptBean.getDistcode())%>" ltype="text" validate="{required:true}" />
                	<input name="ptDeptBean.distcode" type="hidden" id="distcode" value="<%=ptDeptBean.getDistcode()%>" ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">创建时间:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptDeptBean.createdt" type="text" id="createdt" value="<%=ptDeptBean.getCreatedt()%>" ltype="date" validate="{required:false}" />
                </td>
                <td class="td_message"></td>
            </tr>
            
             <tr>
                <td class="l-table-edit-td-right">正常人数:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptDeptBean.normalpeos" type="text" id="normalpeos" value="<%=ptDeptBean.getNormalpeos()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">实际人数:</td>
                <td class="l-table-edit-td-left" style="width:160px" > 
                <input name="ptDeptBean.realpeos" type="text" id="realpeos" value="<%=ptDeptBean.getRealpeos()%>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">管理人员名称:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptDeptBean.managernm" type="text" id="managernm" value="<%=ptDeptBean.getManagernm()%>"ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">部门地址:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptDeptBean.deptaddr" type="text" id="deptaddr" value="<%=ptDeptBean.getDeptaddr()%>" ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">描述名称:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptDeptBean.descname" type="text" id="descname" value="<%=ptDeptBean.getDescname()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">部门简称:</td>
                <td class="l-table-edit-td-left" style="width:160px" > 
                <input name="ptDeptBean.bmjc" type="text" id="bmjc" value="<%=ptDeptBean.getBmjc()%>" ltype="text" validate="{required:false}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">部门状态:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptDeptBean.bmzt" type="text" id="bmzt" value="<%=ptDeptBean.getBmzt()%>"ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">上级部门编号:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="ptDeptBean.parentdeptid" type="text" id="parentdeptid" value="<%=ptDeptBean.getParentdeptid()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
            
             <tr>
                <td class="l-table-edit-td-right">部门信息:</td>
                <td class="l-table-edit-td-left" style="width:160px" colspan="4">
                  <textarea  cols="110"  rows="3" class="l-textarea" id="deptinfo" name="ptDeptBean.deptinfo"  style="width:430px" validate="{required:false}" ><%=ptDeptBean.getDeptinfo()%></textarea>               
                </td>
               
                <td class="td_message"></td>
            </tr>
        </table>
 <br />
<table align="center">
<tr>
	<td>
		<input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /> 
		<input type="button" value="关闭" id="colButton" class="l-button l-button-test"/>
	</td>
</tr>
	
</table>
 </form>
    <div style="display:none"></div>   
</body>

</html>
