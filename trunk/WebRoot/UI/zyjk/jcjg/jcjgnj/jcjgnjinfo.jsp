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
<jsp:directive.page import="UI.dao.zyjk.JcjgnjglBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script src="<%=webpath%>/UI/zyjk/jcjg/jcjgnj/jcjgnjinfo.js" type="text/javascript"></script>
<title>检测机构人员基本信息</title>
<%
	JcjgnjglBean jcjgnjglBean = (JcjgnjglBean)request.getAttribute("jcjgnjglBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
	//String jgbh=request.getParameter("jgbh");
	//System.out.println("----------------------------------"+jgbh);
	if(null==jcjgnjglBean){
		jcjgnjglBean=new JcjgnjglBean();
		//jcjgnjglBean.setJgbh(jgbh);
	}
	if(null==messageBean){
		messageBean=new MessageBean();
	}
%>      
</head>

<body class="menubody" style="width:615px">
	<br />


<form name="form" method="post"  id="form" action="<%=webpath%>/UI/action/zyjk/JcjgbaAction_insert.action">
		<div>
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="sysno" name="jcjgnjglBean.sysno" value="<%=jcjgnjglBean.getSysno()%>"/>
			 <!-- 隐藏域 机构编号jgbh -->
			<input type="hidden" id="jgbh" name="jcjgnjglBean.jgbh" value="<%=jcjgnjglBean.getJgbh()%>"/>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod()%>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		</div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">单位名称：</td>
                <td class="l-table-edit-td-left"  style="width:160px" >
                	<input name="jcjgnjglBean.jgmc" type="text" id="jgmc" value="<%=jcjgnjglBean.getJgmc()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">单位性质：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="jcjgnjglBean.dwxz" type="text" id="dwxz" value="<%=jcjgnjglBean.getDwxz()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>     
                
            	<%--<td class="l-table-edit-td-right">行政区划:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="jcjgnjglBean.distcode" type="text" id="distcode" value="<%=jcjgnjglBean.getDistcode()%>" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            --%>
            
            </tr>
            
           <tr>              
                <td class="l-table-edit-td-right">地址：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="jcjgnjglBean.dz" type="text" id="dz" value="<%=jcjgnjglBean.getDz()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	
            </tr>
            
           <tr>
                <td class="l-table-edit-td-right">法定代表人：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="jcjgnjglBean.fddbr" type="text" id="fddbr" value="<%=jcjgnjglBean.getFddbr()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">联系人：</td>
                <td class="l-table-edit-td-left" style="width:160px" > 
                <input name="jcjgnjglBean.lxr" type="text" id="lxr" value="<%=jcjgnjglBean.getLxr()%>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">联系电话：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="jcjgnjglBean.lxdh" type="text" id="lxdh" value="<%=jcjgnjglBean.getLxdh()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">传真：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="jcjgnjglBean.fax" type="text" id="fax" value="<%=jcjgnjglBean.getFax()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">资质证书号：</td>
                <td class="l-table-edit-td-left" style="width:160px" colspan="4">
                	<input name="jcjgnjglBean.zzzsbh" type="text" id="zzzsbh" value="<%=jcjgnjglBean.getZzzsbh()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                
            </tr>
             <tr>              
               <td class="l-table-edit-td-right">证书级别：</td>
                <td class="l-table-edit-td-left" style="width:160px" > 
                <input name="jcjgnjglBean.jb" type="text" id="jb" value="<%=jcjgnjglBean.getJb()%>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
                            
            	<td class="l-table-edit-td-right">有效期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="jcjgnjglBean.yxqjs" type="text" id="yxqjs" value="<%=jcjgnjglBean.getYxqjs()%>" ltype="date" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">服务项目：</td>
                <td class="l-table-edit-td-left" style="width:160px" colspan="4">
                	<textarea rows="4" style="width: 100%" name="jcjgnjglBean.fwxm" id="fwxm"><%=jcjgnjglBean.getFwxm()%></textarea>
                	<%--<input name="jcjgnjglBean.zzzsbh" type="text" id="fwxm" value="<%=jcjgnjglBean.getFwxm()%>" ltype="text" validate="{required:true}" />--%>
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
