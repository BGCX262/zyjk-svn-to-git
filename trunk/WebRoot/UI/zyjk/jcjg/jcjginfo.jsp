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
<jsp:directive.page import="UI.dao.zyjk.JcjgbaxxBean"/>
<jsp:directive.page import="UI.util.DistcodeUtil"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<script src="<%=webpath%>/UI/zyjk/jcjg/jcjginfo.js" type="text/javascript"></script>
<title>检测机构基本信息</title>
<%
	JcjgbaxxBean jcjgbaxxBean = (JcjgbaxxBean)request.getAttribute("jcjgbaxxBean");
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
	if(null==jcjgbaxxBean){
		jcjgbaxxBean=new JcjgbaxxBean();
	}
	if(null==messageBean){
		messageBean=new MessageBean();
	}
%>      
</head>

<body class="menubody" style="width:650">

<form name="form" method="post"  id="form" action="<%=webpath%>/UI/action/zyjk/JcjgbaAction_insert.action">
		<div>
		    <!-- 隐藏域 主键id -->
			<input type="hidden" id="sysno" name="jcjgbaxxBean.sysno" value="<%=jcjgbaxxBean.getSysno()%>"/>
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
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.dwmc" type="text" id="dwmc" value="<%=jcjgbaxxBean.getDwmc()%>" ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td> 
                
            	<td class="l-table-edit-td-right">行政区划：</td>
                <td class="l-table-edit-td-left" >
                	<input type="text" ltype="text" name="enuditcode" id="enuditcode" value="<%=DistcodeUtil.getDistName(jcjgbaxxBean.getDistcode())%>" style="width: 95%" validate="{required:true}"/>
                	<input name="jcjgbaxxBean.distcode" type="hidden" id="distcode" value="<%=jcjgbaxxBean.getDistcode()%>" validate="{required:false}" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">资质证书编号：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.zzzsbh" type="text" id="zzzsbh" value="<%=jcjgbaxxBean.getZzzsbh()%>"ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td>              
            	<td class="l-table-edit-td-right">发证日期：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.fzdate" type="text" id="fzdate" value="<%=jcjgbaxxBean.getFzdate()%>" ltype="date" validate="{required:false}" />
                </td>
                 <td class="td_message"></td>
            </tr>
            
             <tr>
                <td class="l-table-edit-td-right">发证机关：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.fzjg" type="text" id="fzjg" value="<%=jcjgbaxxBean.getFzjg()%>" ltype="text" validate="{required:false}" />
                </td>
                 <td class="td_message"></td>
                <td class="l-table-edit-td-right">有效日期：</td>
                <td class="l-table-edit-td-left"   > 
                <input name="jcjgbaxxBean.yxq" type="text" id="yxq" value="<%=jcjgbaxxBean.getYxq()%>" ltype="date" validate="{required:false}" />
               </td> 
               <td class="td_message"></td>  
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">资质级别：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.zzjb" type="text" id="zzjb" value="<%=jcjgbaxxBean.getZzjb()%>"ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td>              
            	<td class="l-table-edit-td-right">技术负责人：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.jsfzr" type="text" id="jsfzr" value="<%=jcjgbaxxBean.getJsfzr()%>" ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td> 
            </tr>
             <tr>
                <td class="l-table-edit-td-right">质量负责人：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.zlfzr" type="text" id="zlfzr" value="<%=jcjgbaxxBean.getZlfzr()%>" ltype="text" validate="{required:false}" />
                </td>
                 <td class="td_message"></td>
                <td class="l-table-edit-td-right">职工人数：</td>
                <td class="l-table-edit-td-left"   > 
                <input name="jcjgbaxxBean.zgrs" type="text" id="zgrs" value="<%=jcjgbaxxBean.getZgrs()%>" ltype="text" validate="{required:false}" />
               </td> 
                <td class="td_message"></td> 
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">专业技术人员数：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.zyjsrys" type="text" id="zyjsrys" value="<%=jcjgbaxxBean.getZyjsrys()%>"ltype="text" validate="{required:false}" />
                </td>
                 <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">取得资质人员数：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.qdzszyrs" type="text" id="qdzszyrs" value="<%=jcjgbaxxBean.getQdzszyrs()%>" ltype="text" validate="{required:false}" />
                </td>
                 <td class="td_message"></td>
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">计量认证证书号：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.jlrzzsh" type="text" id="jlrzzsh" value="<%=jcjgbaxxBean.getJlrzzsh()%>"ltype="text" validate="{required:false}" />
                </td>
                 <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">仪器设备数：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.yqsbs" type="text" id="yqsbs" value="<%=jcjgbaxxBean.getYqsbs()%>" ltype="text" validate="{required:false}" />
                </td>
                 <td class="td_message"></td>
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">法人执照编号：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.frzzbh" type="text" id="frzzbh" value="<%=jcjgbaxxBean.getFrzzbh()%>"ltype="text" validate="{required:false}" />
                </td>
                  <td class="td_message"></td>            
            	<td class="l-table-edit-td-right">注册资金：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.zczj" type="text" id="zczj" value="<%=jcjgbaxxBean.getZczj()%>" ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">颁发机关：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.bfjg" type="text" id="bfjg" value="<%=jcjgbaxxBean.getBfjg()%>"ltype="text" validate="{required:false}" />
                </td>
                 <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">单位性质：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.dwxz" type="text" id="dwxz" value="<%=jcjgbaxxBean.getDwxz()%>" ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td> 
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">注册地址：</td>
                <td class="l-table-edit-td-left" style="width:360px" colspan="4">
                	<input name="jcjgbaxxBean.zcdz" type="text" id="zcdz" value="<%=jcjgbaxxBean.getZcdz()%>"ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td>           
            	<%--<td class="l-table-edit-td-right">行政区划:</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.distcode" type="text" id="distcode" value="<%=jcjgbaxxBean.getDistcode()%>" validate="{required:false}" />
                </td>
                 
            --%></tr>
            <tr>              
                <td class="l-table-edit-td-right">办公地址：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.bgdz" type="text" id="bgdz" value="<%=jcjgbaxxBean.getBgdz()%>"ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td>              
            	<td class="l-table-edit-td-right">邮政编码：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.zpcode" type="text" id="zpcode" value="<%=jcjgbaxxBean.getZpcode()%>" ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td> 
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">法定代表人：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.fddbr" type="text" id="fddbr" value="<%=jcjgbaxxBean.getFddbr()%>"ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td>              
            	<td class="l-table-edit-td-right">联系电话：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.dbrlxdh" type="text" id="dbrlxdh" value="<%=jcjgbaxxBean.getDbrlxdh()%>" ltype="text" validate="{required:false}" />
                </td>
                <td class="td_message"></td> 
            </tr>
            <tr>              
                <td class="l-table-edit-td-right">联系人：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.lxr" type="text" id="lxr" value="<%=jcjgbaxxBean.getLxr()%>"ltype="text" validate="{required:false}" />
                </td>
                 <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">联系电话：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.lxdh" type="text" id="lxdh" value="<%=jcjgbaxxBean.getLxdh()%>" ltype="text" validate="{required:false}" />
                </td>
               <td class="td_message"></td>  
            </tr>
             <tr>              
                <td class="l-table-edit-td-right">传真：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.fax" type="text" id="fax" value="<%=jcjgbaxxBean.getFax()%>"ltype="text" validate="{required:false}" />
                </td>
                 <td class="td_message"></td>             
            	<td class="l-table-edit-td-right">电子邮箱：</td>
                <td class="l-table-edit-td-left"  >
                	<input name="jcjgbaxxBean.email" type="text" id="email" value="<%=jcjgbaxxBean.getEmail()%>" ltype="text" validate="{required:false}" />
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
