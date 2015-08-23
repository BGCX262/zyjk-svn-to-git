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
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<%@ include file="/global.jsp"%>
<%
	QyjbqkBean qyjbqkBean=(QyjbqkBean)request.getAttribute("qyjbqkBean");
	if(null==qyjbqkBean){
		qyjbqkBean=new QyjbqkBean();
	}
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
	if(null==messageBean){
		messageBean=new MessageBean();
	}
 %>
<! DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html>
<head>
<title>职业卫生许可证</title>
  <script language="javascript" src="<%=webpath%>//UI/enterfile/zywsxkz/zywsxkz.js"></script>
</head>
<body  class="menubody" style="width: 580" onload="bodyload();">
	<form  name="form" id="form" method="post" action="<%=webpath %>/UI/enterfile/zywsxkz/ZywsxkzUpAction_update.action" enctype="multipart/form-data">
		 <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="enterno" name="qyjbqkBean.enterno" value="<%=qyjbqkBean.getEnterno() %>"/>
         
         <input type="hidden" id="zywsxkzz" name="qyjbqkBean.zywsxkzz" value="<%=qyjbqkBean.getZywsxkzz() %>"/>
         <input type="hidden" id="zywsxkzf" name="qyjbqkBean.zywsxkzf" value="<%=qyjbqkBean.getZywsxkzf() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     	</div>
		<table cellpadding="0" cellspacing="0" class="form-l-table-edit" >
			
		 	<tr>
            	<td class="l-table-edit-td-right">职业卫生安全许可证</td>
            	<td  class="l-table-edit-td-left" style="width:160px">
						正本：<input type="file" name="file" style="" id="file" title="正"/>
					<%--<input type="button" onclick="upload()" value="上传"  id="scbt"/>
					
				--%>
				</td>
				<td  class="l-table-edit-td-left" style="width:160px">
					副本：<input type="file" name="filef" style="" id="filef" title="副"/>
				</td>
            </tr>
            <tr>
            	<td colspan="2" align="center" style="font-size: 16px;font-weight: bold;">
            		<%if(qyjbqkBean.getZywsxkzz()!=null&&!qyjbqkBean.getZywsxkzz().equals("null")&&!qyjbqkBean.getZywsxkzz().equals("")){
            		%>
            			职业卫生安全许可证正本：<br />
            			<img src="<%=webpath+qyjbqkBean.getZywsxkzz()%>" alt="职业卫生许可证正本" width="300px" height="300px"/>
            		<%} %>
            	</td>
            </tr>
            
             <tr>
            	<td colspan="2" align="center" style="font-size: 16px;font-weight: bold;">
            		<%if(qyjbqkBean.getZywsxkzf()!=null&&!qyjbqkBean.getZywsxkzf().equals("null")&&!qyjbqkBean.getZywsxkzf().equals("")){
            		%>
            			职业卫生安全许可证副本：<br />
            			<img src="<%=webpath+qyjbqkBean.getZywsxkzf()%>" alt="职业卫生许可证副本" width="300px" height="300px"/>
            		<%} %>
            	</td>
            </tr>
          </table>  
          <br />
			<table align="center">
			<tr>
			 <td>
			     <input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /> 
			    
			 </td>
			</tr>
			 
			</table>
	</form>
</body>
</html>
