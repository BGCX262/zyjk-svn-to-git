<!--
/*********************************************************************
 *<p>处理内容：ptdept 表单域</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.5.17----jmx --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  import="st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.JcjgpjryglBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script src="<%=webpath%>/UI/zyjk/jcjg/jcjgry/jcjgryinfo.js" type="text/javascript"></script>
<title>检测机构人员基本信息</title>
<%
	JcjgpjryglBean jcjgpjryglBean = (JcjgpjryglBean)request.getAttribute("jcjgpjryglBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
	//String jgbh=request.getParameter("jgbh");
	//System.out.println("----------------------------------"+jgbh);
	if(null==jcjgpjryglBean){
		jcjgpjryglBean=new JcjgpjryglBean();
		//jcjgpjryglBean.setJgbh(jgbh);
	}
	if(null==messageBean){
		messageBean=new MessageBean();
	}
%>      
</head>

<body class="menubody" style="width: 550">
	<br />

<form name="form" method="post"  id="form" action="<%=webpath%>/UI/action/zyjk/JcjgbaAction_insert.action">
		<div>
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="sysno" name="jcjgpjryglBean.sysno" value="<%=jcjgpjryglBean.getSysno()%>"/>
			 <!-- 隐藏域 机构编号jgbh -->
			<input type="hidden" id="jgbh" name="jcjgpjryglBean.jgbh" value="<%=jcjgpjryglBean.getJgbh()%>"/>
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
                	<input name="jcjgpjryglBean.name" type="text" id="name" value="<%=jcjgpjryglBean.getName()%>" ltype="text" validate="{required:true}" />
                </td>
                
                
            	<%--<td class="l-table-edit-td-right">行政区划:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="jcjgpjryglBean.distcode" type="text" id="distcode" value="<%=jcjgpjryglBean.getDistcode()%>" validate="{required:true}" />
                </td>
                 
            --%>
             <td class="l-table-edit-td-right">性别：</td>
                <td class="l-table-edit-td-left"  >
                	 <%
					   DBSelect dbsel = new DBSelect("sex", "SEX",jcjgpjryglBean.getSex());
					   dbsel.addAttr("style", "width: 160px");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "jcjgpjryglBean.sex");
					   dbsel.addOption("请选择","");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %>
                </td>
                      
            </tr>
            <%--<tr>              
                <td class="l-table-edit-td-right">地址:</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgpjryglBean.pxjgdz" type="text" id="pxjgdz" value="<%=jcjgpjryglBean.getPxjgdz()%>"ltype="text" validate="{required:true}" />
                </td>
                              
            	
            </tr>
            
             --%><tr>
                <td class="l-table-edit-td-right">出生年月：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgpjryglBean.birthday" type="text" id="birthday" value="<%=jcjgpjryglBean.getBirthday()%>" ltype="date" validate="{required:true}" />
                </td>
                 
                <td class="l-table-edit-td-right">学历：</td>
                <td class="l-table-edit-td-left"   > 
                <%
					   dbsel = new DBSelect("xl", "EDUDEGREE",jcjgpjryglBean.getXl());
					   dbsel.addAttr("style", "width: 160px");
					   dbsel.addAttr("notnull", "true");
					   dbsel.addAttr("name", "jcjgpjryglBean.xl");
					   dbsel.setDisplayAll(false);
					   out.print(dbsel);
				  %> 
               </td> 
                 
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">所学专业：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgpjryglBean.sxzy" type="text" id="sxzy" value="<%=jcjgpjryglBean.getSxzy()%>"ltype="text" validate="{required:true}" />
                </td>
                              
            	<td class="l-table-edit-td-right">职务：</td>
                <td class="l-table-edit-td-left"  >
                 <input name="jcjgpjryglBean.zw" type="text" id="zw" value="<%=jcjgpjryglBean.getZw()%>" ltype="text" validate="{required:true}" />
                </td>
                 
            </tr>
             <tr>
                <td class="l-table-edit-td-right">职称：</td>
                <td class="l-table-edit-td-left"   colspan="4">
                	<input name="jcjgpjryglBean.zc" type="text" id="zc" value="<%=jcjgpjryglBean.getZc()%>" ltype="text" validate="{required:true}" />
                </td>
                 
                
            </tr>
             <tr>              
               <td class="l-table-edit-td-right">岗位：</td>
                <td class="l-table-edit-td-left"   > 
                <input name="jcjgpjryglBean.gw" type="text" id="gw" value="<%=jcjgpjryglBean.getGw()%>" ltype="text" validate="{required:true}" />
               </td> 
                 
                            
            	<td class="l-table-edit-td-right">工作年限：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgpjryglBean.gznx" type="text" id="gznx" value="<%=jcjgpjryglBean.getGznx()%>" ltype="text" validate="{required:true}" />
                </td>
                 
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">资质证书编号：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgpjryglBean.zzzsbh" type="text" id="zzzsbh" value="<%=jcjgpjryglBean.getZzzsbh()%>"ltype="text" validate="{required:true}" />
                </td>
                              
            	<td class="l-table-edit-td-right">发证时间：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgpjryglBean.fzdate" type="text" id="fzdate" value="<%=jcjgpjryglBean.getFzdate()%>" ltype="date" validate="{required:true}" />
                </td>
                 
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
