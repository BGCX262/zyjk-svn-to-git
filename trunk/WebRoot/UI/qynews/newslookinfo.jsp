<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.NewsBean"/>
<jsp:directive.page import="st.portal.action.MessageBean"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
NewsBean newsBean=(NewsBean)request.getAttribute("newsBean");
if(newsBean==null){
	newsBean=new NewsBean();
}

 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");

%>
<%@ include file="/global.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻列表</title>
    <link rel=stylesheet type=text/css href="<%=webpath %>/css/corp.css"/>
    <script type="text/javascript" src="<%=path%>/FCKeditor/fckeditor.js"></script>
    <script language="javascript" src="<%=path%>/UI/news/newsinfo.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
  </head>
  
  <body  style="background:#fff;" style="text-align: center">
  
  
  <div>
         <!-- 操作method -->      
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="newsBean.sysno" value="<%=newsBean.getSysno()%>"/>
            
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
   	
   					<center>
				<div class="detail" style="text-align:center;">
					<div class="detail_content">
						<div style="TEXT-ALIGN: center" class="detail_title"><%=newsBean.getTitle() %></div>
						</br>
						<div class="detail_xx"> 发表日期：<font color="#919191"><%=newsBean.getIsscuedate() %> </font>&nbsp;&nbsp;发布人：<%=newsBean.getIsscueperson() %>
						&nbsp;&nbsp;来源：<%=newsBean.getMessageorigin()%></div>
					</div>	
				</div>
				<div style="border-bottom: 1px solid #AECAF0;width:85%;" ></div>   	  
				</center>
				       
				 <div style="TEXT-ALIGN: left;margin:20px">
				<%=newsBean.getContent() %>
				 </div>
				 
	</br>
	
	<%--<div class="cz" style="margin-left: 400px">
	<li style="text-align:left;"><a href="javascript:history.go(-1)">返回</a></li>
	</div>	
				 
			 
  --%></body>
</html>
