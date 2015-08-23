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
<jsp:directive.page import="UI.dao.zyjk.WsjgbaxxBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script src="<%=webpath%>/UI/zyjk/wsjg/wsjginfo.js" type="text/javascript"></script>
<title>检测机构基本信息</title>
<%
	WsjgbaxxBean wsjgbaxxBean = (WsjgbaxxBean)request.getAttribute("wsjgbaxxBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
	if(null==wsjgbaxxBean){
		wsjgbaxxBean=new WsjgbaxxBean();
	}
	if(null==messageBean){
		messageBean=new MessageBean();
	}
%>      
</head>

<body class="menubody" style="width:95%">
<%--<div class="searchtitle">          
	<img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
</div>
<div class="navline" ></div>

--%><form name="form" method="post"  id="form" action="<%=webpath%>/UI/action/zyjk/JcjgbaAction_insert.action">
		<div>
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="sysno" name="wsjgbaxxBean.sysno" value="<%=wsjgbaxxBean.getSysno()%>"/>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod()%>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		</div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">机构名称：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="wsjgbaxxBean.jgmc" type="text" id="jgmc" value="<%=wsjgbaxxBean.getJgmc()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                
            	<%--<td class="l-table-edit-td-right">行政区划:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="wsjgbaxxBean.distcode" type="text" id="distcode" value="<%=wsjgbaxxBean.getDistcode()%>" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            --%>
             <td class="l-table-edit-td-right">地址：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="wsjgbaxxBean.jgdz" type="text" id="jgdz" value="<%=wsjgbaxxBean.getJgdz()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>     
            </tr>
            <%--<tr>              
                <td class="l-table-edit-td-right">地址:</td>
                <td class="l-table-edit-td-left"  >
                	<input name="wsjgbaxxBean.pxjgdz" type="text" id="pxjgdz" value="<%=wsjgbaxxBean.getPxjgdz()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	
            </tr>
            
             --%><tr>
                <td class="l-table-edit-td-right">法定代表人：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="wsjgbaxxBean.fddbr" type="text" id="fddbr" value="<%=wsjgbaxxBean.getFddbr()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">联系人：</td>
                <td class="l-table-edit-td-left"   > 
                <input name="wsjgbaxxBean.lxr" type="text" id="lxr" value="<%=wsjgbaxxBean.getLxr()%>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">联系电话：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="wsjgbaxxBean.lxdh" type="text" id="lxdh" value="<%=wsjgbaxxBean.getLxdh()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">传真：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="wsjgbaxxBean.fax" type="text" id="fax" value="<%=wsjgbaxxBean.getFax()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">批准文号：</td>
                <td class="l-table-edit-td-left"   >
                	<input name="wsjgbaxxBean.pzwh" type="text" id="pzwh" value="<%=wsjgbaxxBean.getPzwh()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">资质级别：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="wsjgbaxxBean.zzjb" type="text" id="zzjb" value="<%=wsjgbaxxBean.getZzjb()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td> 
            </tr>
             <tr>              
               <td class="l-table-edit-td-right">批准单位：</td>
                <td class="l-table-edit-td-left"   > 
                <input name="wsjgbaxxBean.pzdw" type="text" id="pzdw" value="<%=wsjgbaxxBean.getPzdw()%>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
                            
            	<td class="l-table-edit-td-right">批准时间：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="wsjgbaxxBean.pzsj" type="text" id="pzsj" value="<%=wsjgbaxxBean.getPzsj()%>" ltype="date" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>              
                            
            	<td class="l-table-edit-td-right">体检项目：</td>
                <td class="l-table-edit-td-left"   colspan="4">
                 <textarea cols="110"  rows="4" class="l-textarea" id="jcxm" name="wsjgbaxxBean.jcxm"  style="width:475px" validate="{required:true}" ><%=wsjgbaxxBean.getJcxm()%></textarea>
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">备注：</td>
                <td class="l-table-edit-td-left"   colspan="4">
                 <textarea cols="110"  rows="4" class="l-textarea" id="bz" name="wsjgbaxxBean.bz"  style="width:475px" ><%=wsjgbaxxBean.getBz()%></textarea>
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
