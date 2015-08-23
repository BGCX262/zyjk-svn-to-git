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
<jsp:directive.page import="UI.dao.zyjk.JcjgyqsbglBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script src="<%=webpath%>/UI/zyjk/jcjg/jcjgsb/jcjgsbinfo.js" type="text/javascript"></script>
<title>检测机构基本信息</title>
<%
	JcjgyqsbglBean jcjgyqsbglBean = (JcjgyqsbglBean)request.getAttribute("jcjgyqsbglBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
	if(null==jcjgyqsbglBean){
		jcjgyqsbglBean=new JcjgyqsbglBean();
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

--%><form name="form" method="post"  id="form" action="<%=webpath%>/UI/action/zyjk/JcjgbaAction_insert.action">
		<div>
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="sysno" name="jcjgyqsbglBean.sysno" value="<%=jcjgyqsbglBean.getSysno()%>"/>
			 <!-- 隐藏域 机构编号jgbh -->
			<input type="hidden" id="jgbh" name="jcjgyqsbglBean.jgbh" value="<%=jcjgyqsbglBean.getJgbh()%>"/>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod()%>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		</div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">设备名称：</td>
                <td class="l-table-edit-td-left">
                	<input name="jcjgyqsbglBean.sbmc" type="text" id="sbmc" value="<%=jcjgyqsbglBean.getSbmc()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                
            	<%--<td class="l-table-edit-td-right">行政区划:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="jcjgyqsbglBean.distcode" type="text" id="distcode" value="<%=jcjgyqsbglBean.getDistcode()%>" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            --%>
             <td class="l-table-edit-td-right">规格型号：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgyqsbglBean.ggxh" type="text" id="ggxh" value="<%=jcjgyqsbglBean.getGgxh()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>     
            </tr>
            <%--<tr>              
                <td class="l-table-edit-td-right">地址:</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgyqsbglBean.pxjgdz" type="text" id="pxjgdz" value="<%=jcjgyqsbglBean.getPxjgdz()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	
            </tr>
            
             --%><tr>
                <td class="l-table-edit-td-right">数量：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgyqsbglBean.sl" type="text" id="sl" value="<%=jcjgyqsbglBean.getSl()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">铭牌编号：</td>
                <td class="l-table-edit-td-left"   > 
                <input name="jcjgyqsbglBean.mpbh" type="text" id="mpbh" value="<%=jcjgyqsbglBean.getMpbh()%>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">生产厂家：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgyqsbglBean.sccj" type="text" id="sccj" value="<%=jcjgyqsbglBean.getSccj()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">购买日期：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgyqsbglBean.gmrq" type="text" id="gmrq" value="<%=jcjgyqsbglBean.getGmrq()%>" ltype="date" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">精度：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgyqsbglBean.jd" type="text" id="jd" value="<%=jcjgyqsbglBean.getJd()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">用途：</td>
                <td class="l-table-edit-td-left"   > 
                <input name="jcjgyqsbglBean.yt" type="text" id="yt" value="<%=jcjgyqsbglBean.getYt()%>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
             <tr>              
               <td class="l-table-edit-td-right">最近检定日期：</td>
                <td class="l-table-edit-td-left"   > 
                <input name="jcjgyqsbglBean.zjjdrq" type="text" id="zjjdrq" value="<%=jcjgyqsbglBean.getZjjdrq()%>" ltype="date" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
                            
            	<td class="l-table-edit-td-right">检定周期：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgyqsbglBean.jdzq" type="text" id="jdzq" value="<%=jcjgyqsbglBean.getJdzq()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">状态：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgyqsbglBean.state" type="text" id="state" value="<%=jcjgyqsbglBean.getState()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">主管姓名：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgyqsbglBean.zgxm" type="text" id="zgxm" value="<%=jcjgyqsbglBean.getZgxm()%>" ltype="text" validate="{required:true}" />
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
