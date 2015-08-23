<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.NewsBean"/>
<jsp:directive.page import="st.portal.action.MessageBean"/>
<jsp:directive.page import="UI.dao.zyjk.BasiclawsmainBean"/>
<jsp:directive.page import="st.platform.db.ConnectionManager"/>
<jsp:directive.page import="UI.dao.zyjk.BasiclawsdtlBean"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String sysno=request.getParameter("sysno");
String type=request.getParameter("type");
ConnectionManager cm = ConnectionManager.getInstance();
NewsBean newsBean=new NewsBean();
BasiclawsmainBean laws=new BasiclawsmainBean();
if(type.equals("01")){
newsBean=newsBean.findFirst(" where sysno='"+sysno+"'");
if(newsBean==null){
	newsBean=new NewsBean();
}
}else {
laws=laws.findFirst(" where sysno='"+sysno+"'");
if(null==laws){
	laws=new BasiclawsmainBean();
}
}

 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");

%>
<%@ include file="/global.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻列表</title>
  </head>
  
  <body  style="background:#fff;text-align: center;margin:10px 20px 10px 20px;" >
   				<%if(type.equals("01")){ %>	
				<div class="detail" style="text-align:center;">
					<div class="detail_content">
						<div style="TEXT-ALIGN: center;font-size: 20px" ><%=newsBean.getTitle() %></div>
						<div class="detail_xx"> 发表日期：<font color="#919191"><%=newsBean.getIsscuedate() %> </font>&nbsp;&nbsp;发布人：<%=newsBean.getIsscueperson() %>
						&nbsp;&nbsp;来源：<%=newsBean.getMessageorigin()%></div>
					</div>	
				</div>	  
				
				 <div style="TEXT-ALIGN: left">
				<%=newsBean.getContent() %>
				 </div>
				 <%} else{%>
				 <div class="detail" style="text-align:center;font-size: 20px">
					<div class="detail_content">
						<div style="TEXT-ALIGN: center" class="detail_title"><%=laws.getMaintitle() %></div>
						
					</div>	
				</div>	  
				<hr color="#7B7B7B">
				 <div style="TEXT-ALIGN: left">
				 		<%=laws.getHeadcontent() %>
				 		<br>
							<%
								BasiclawsdtlBean de=new BasiclawsdtlBean();
								List<BasiclawsdtlBean> des=de.findByWhere(" where LAWSYSNO='"+laws.getSysno()+"'");
								if(!des.isEmpty()){
									for(int i=0;i<des.size();i++){
									BasiclawsdtlBean d=des.get(i);
									if(d.getItemcode().indexOf("0000000000000")<1&&d.getItemcode().indexOf("00000000")>1){
								%>
									<p style="color: #FF0000;"><%=d.getItemcontent()%></p>
								<%}else{%>
									<p>&nbsp;&nbsp;&nbsp;&nbsp;<%=d.getItemcontent()%></p>
										<%}
									}
								}
							 %>
						<br>
						<%=laws.getTailcontent() %>
				 </div>
				 <%} %>
	</br>			 
	<%--<div><li style="float:center"><a href="javascript:history.go(-1)">返回</a></li></div>			 
  --%></body>
  <%cm.release(); %>
</html>
