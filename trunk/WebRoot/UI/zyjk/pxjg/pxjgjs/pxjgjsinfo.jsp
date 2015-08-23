<!--
/*********************************************************************
 *<p>处理内容：ptdept 表单域</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.5.17----jmx --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  import="st.system.dao.*, st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.PxjgjsxxBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script src="<%=webpath%>/UI/zyjk/pxjg/pxjgjs/pxjgjsinfo.js" type="text/javascript"></script>
<title>讲师基本信息</title>
<%
	PxjgjsxxBean pxjgjsxxBean = (PxjgjsxxBean)request.getAttribute("pxjgjsxxBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
	if(null==pxjgjsxxBean){
		pxjgjsxxBean=new PxjgjsxxBean();
	}
	if(null==messageBean){
		messageBean=new MessageBean();
	}
%>      
</head>

<body class="menubody">
<%--<div class="searchtitle">          
	<img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
</div>
<div class="navline" ></div>

--%><form name="form" method="post"  id="form" >
		<div>
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="sysno" name="pxjgjsxxBean.sysno" value="<%=pxjgjsxxBean.getSysno()%>"/>
			<!-- 隐藏域 机构编号jgbh -->
			<input type="hidden" id="jgbh" name="pxjgjsxxBean.jgbh" value="<%=pxjgjsxxBean.getJgbh()%>"/>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod()%>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		</div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">姓名：</td>
                <td class="l-table-edit-td-left" >
                	<input name="pxjgjsxxBean.name" type="text" id="name" value="<%=pxjgjsxxBean.getName()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                
            	<%--<td class="l-table-edit-td-right">行政区划:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="pxjgjsxxBean.distcode" type="text" id="distcode" value="<%=pxjgjsxxBean.getDistcode()%>" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            --%>
             <td class="l-table-edit-td-right">性别：</td>
                <td class="l-table-edit-td-left"  >
                	 <%
					   DBSelect dbsel = new DBSelect("sex", "SEX",pxjgjsxxBean.getSex());
					   dbsel.addAttr("style", "width: 160px");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "pxjgjsxxBean.sex");
					   dbsel.addOption("请选择","");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %>
                </td>
                <td class="td_message"></td>     
            </tr>
            <%--<tr>              
                <td class="l-table-edit-td-right">地址:</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgjsxxBean.pxjgdz" type="text" id="pxjgdz" value="<%=pxjgjsxxBean.getPxjgdz()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	
            </tr>
            
             --%><tr>
                <td class="l-table-edit-td-right">出生年月：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgjsxxBean.birthday" type="text" id="birthday" value="<%=pxjgjsxxBean.getBirthday()%>" ltype="date" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">学历：</td>
                <td class="l-table-edit-td-left"   > 
                 <%
					   dbsel = new DBSelect("education", "EDUDEGREE",pxjgjsxxBean.getEducation());
					   dbsel.addAttr("style", "width: 160px");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "pxjgjsxxBean.education");
					   dbsel.addOption("请选择","");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %> 
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">所学专业：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgjsxxBean.sxzy" type="text" id="sxzy" value="<%=pxjgjsxxBean.getSxzy()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">职务：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgjsxxBean.zw" type="text" id="zw" value="<%=pxjgjsxxBean.getZw()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">职称：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgjsxxBean.zc" type="text" id="zc" value="<%=pxjgjsxxBean.getZc()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                 <td class="l-table-edit-td-right">资质证书编号：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgjsxxBean.zzzsh" type="text" id="zzzsh" value="<%=pxjgjsxxBean.getZzzsh()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>    
            </tr>
           
             <tr>              
                 
            	<td class="l-table-edit-td-right">发证时间：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgjsxxBean.fzsh" type="text" id="fzsh" value="<%=pxjgjsxxBean.getFzsh()%>" ltype="date" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                  <td class="l-table-edit-td-right">到期时间：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgjsxxBean.dqsj" type="text" id="dqsj" value="<%=pxjgjsxxBean.getDqsj()%>"ltype="date" validate="{required:true}" />
                </td>
                <td class="td_message"></td>          
            </tr>
            
            
        </table>
 <br /><%--
 <input type="submit" value="提交"/><input type="button" value="gettab" onclick="getTab()"/><input type="submit" value="提交"/>
--%><table align="center">
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
