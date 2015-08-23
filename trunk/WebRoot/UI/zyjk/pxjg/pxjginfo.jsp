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
<jsp:directive.page import="UI.dao.zyjk.PxjgbaxxBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp" %>
<head>
<script src="<%=webpath%>/UI/zyjk/pxjg/pxjginfo.js" type="text/javascript"></script>
<title>检测机构基本信息</title>
<%
	PxjgbaxxBean pxjgbaxxBean = (PxjgbaxxBean)request.getAttribute("pxjgbaxxBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
	if(null==pxjgbaxxBean){
		pxjgbaxxBean=new PxjgbaxxBean();
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
			<input type="hidden" id="sysno" name="pxjgbaxxBean.sysno" value="<%=pxjgbaxxBean.getSysno()%>"/>
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
                <td class="l-table-edit-td-left">
                	<input name="pxjgbaxxBean.pxjgmc" type="text" id="pxjgmc" value="<%=pxjgbaxxBean.getPxjgmc()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                
            	<%--<td class="l-table-edit-td-right">行政区划:</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	<input name="pxjgbaxxBean.distcode" type="text" id="distcode" value="<%=pxjgbaxxBean.getDistcode()%>" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            --%>
             <td class="l-table-edit-td-right">地址：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.pxjgdz" type="text" id="pxjgdz" value="<%=pxjgbaxxBean.getPxjgdz()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>     
            </tr>
            <%--<tr>              
                <td class="l-table-edit-td-right">地址:</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.pxjgdz" type="text" id="pxjgdz" value="<%=pxjgbaxxBean.getPxjgdz()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	
            </tr>
            
             --%><tr>
                <td class="l-table-edit-td-right">法人代表：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.fddbr" type="text" id="fddbr" value="<%=pxjgbaxxBean.getFddbr()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">法人联系电话：</td>
                <td class="l-table-edit-td-left"   > 
                <input name="pxjgbaxxBean.frlxdh" type="text" id="frlxdh" value="<%=pxjgbaxxBean.getFrlxdh()%>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">教务负责人：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.jwfzr" type="text" id="jwfzr" value="<%=pxjgbaxxBean.getJwfzr()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">教务负责人联系电话：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.jwfzrlxdh" type="text" id="jwfzrlxdh" value="<%=pxjgbaxxBean.getJwfzrlxdh()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">联系人：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.jglxr" type="text" id="jglxr" value="<%=pxjgbaxxBean.getJglxr()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">联系电话：</td>
                <td class="l-table-edit-td-left"   > 
                <input name="pxjgbaxxBean.jglxdh" type="text" id="jglxdh" value="<%=pxjgbaxxBean.getJglxdh()%>" ltype="text" validate="{required:true}" />
               </td> 
                <td class="td_message"></td>
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">传真：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.fax" type="text" id="fax" value="<%=pxjgbaxxBean.getFax()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">注册资金：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.Zczj" type="text" id="Zczj" value="<%=pxjgbaxxBean.getZczj()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">成立时间：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.creatdate" type="text" id="creatdate" value="<%=pxjgbaxxBean.getCreatdate()%>"ltype="date" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">职工人数：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.zgrs" type="text" id="zgrs" value="<%=pxjgbaxxBean.getZgrs()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">教师（专）：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.zyjs" type="text" id="zyjs" value="<%=pxjgbaxxBean.getZyjs()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">教师（兼）：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.jzjs" type="text" id="jzjs" value="<%=pxjgbaxxBean.getJzjs()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">管理人员：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.glrs" type="text" id="glrs" value="<%=pxjgbaxxBean.getGlrs()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">其他：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.qt" type="text" id="qt" value="<%=pxjgbaxxBean.getQt()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">教学场地：</td>
                <td class="l-table-edit-td-left"   >
                	<input name="pxjgbaxxBean.jxcd" type="text" id="jxcd" value="<%=pxjgbaxxBean.getJxcd()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>          
            	<td class="l-table-edit-td-right">自有：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.zy" type="text" id="zy" value="<%=pxjgbaxxBean.getZy()%>" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">租赁：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.zl" type="text" id="zl" value="<%=pxjgbaxxBean.getZl()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">占地面积：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.zdmj" type="text" id="zdmj" value="<%=pxjgbaxxBean.getZdmj()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">电脑数量：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.dnsl" type="text" id="dnsl" value="<%=pxjgbaxxBean.getDnsl()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">发证机关：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.fzjg" type="text" id="fzjg" value="<%=pxjgbaxxBean.getFzjg()%>" ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">证书编号：</td>
                <td class="l-table-edit-td-left"   colspan="4">
                	<input name="pxjgbaxxBean.zsbh" type="text" id="zsbh" value="<%=pxjgbaxxBean.getZsbh()%>"ltype="text" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">证书有效期始：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.zsyxqs" type="text" id="zsyxqs" value="<%=pxjgbaxxBean.getZsyxqs()%>"ltype="date" validate="{required:true}" />
                </td>
                <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">证书有效期止：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="pxjgbaxxBean.zsyxqz" type="text" id="zsyxqz" value="<%=pxjgbaxxBean.getZsyxqz()%>" ltype="date" validate="{required:true}" />
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
