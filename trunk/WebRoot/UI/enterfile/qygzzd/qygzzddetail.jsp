<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27               新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.QygzzdBean"/>
<jsp:directive.page import="st.portal.action.MessageBean"/>
<%@ include file="/global.jsp"%>
<%
	QygzzdBean qygzzdBean=(QygzzdBean)request.getAttribute("qygzzdBean");
	if(null==qygzzdBean){
		qygzzdBean=new QygzzdBean();
	}
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>规章制度</title>
  <script language="javascript" src="<%=webpath%>//UI/enterfile/qygzzd/qygzzddetail.js"></script>
</head>
<body  class="menubody" style="width: 350;" onload="bodyload();">
	<form  name="form" id="form" method="post" enctype="multipart/form-data">
		 <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qygzzdBean.sysno" value="<%=qygzzdBean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="fjpath" name="qygzzdBean.fjpath" value="<%=qygzzdBean.getFjpath() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         
         <input type="hidden" id="enterno" name="qygzzdBean.enterno" value="<%=qygzzdBean.getEnterno() %>"/>
     	</div>
		<table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
			<tr>
            	<td class="l-table-edit-td-right">制度类型：</td>
            	<td  class="l-table-edit-td-left" style="width:160px">
						 <input name="qygzzdBean.gzzdlb" type="text" id="gzzdlb" value="<%=qygzzdBean.getGzzdlb() %>" ltype="text" validate="{required:true}"/>
				</td>
            </tr>
            <tr>
            	<td class="l-table-edit-td-right">制定时间：</td>
            	<td  class="l-table-edit-td-left" style="width:160px">
						 <input name="qygzzdBean.editdate" type="text" id="editdate" value="<%=qygzzdBean.getEditdate() %>" ltype="date"  validate="{required:true}"/>
				</td>
            </tr>
            <tr>
            	<td class="l-table-edit-td-right">公布地点：</td>
            	<td  class="l-table-edit-td-left" style="width:160px">
					 <input name="qygzzdBean.gbdd" type="text" id="gbdd" value="<%=qygzzdBean.getGbdd() %>" ltype="text"  />
				</td>
            </tr>
		 	<tr>
            	<td class="l-table-edit-td-right">附件：</td>
            	<td  class="l-table-edit-td-left" style="width:160px">
						<input type="file" name="file" style="" id="file" title="照片"/>
					<%--<input type="button" onclick="upload()" value="上传"  id="scbt"/>
				--%></td>
            </tr>
            <tr>
            	<td colspan="2" align="center" style="font-size: 16px;font-weight: bold;">
            		<%if(qygzzdBean.getFjpath()!=null&&!qygzzdBean.getFjpath().equals("null")&&!qygzzdBean.getFjpath().equals("")){
            		%>
            			<a href="<%=webpath+qygzzdBean.getFjpath()%>"><%=qygzzdBean.getGzzdlb() %></a>
            		<%} %>
            	</td>
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
</body>
</html>
