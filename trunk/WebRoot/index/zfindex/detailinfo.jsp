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
String title="工作动态";
  if(type.equals("01")){
     	title="工作动态";
     }else if(type.equals("02")){
     	title="法律法规";
     }else if(type.equals("03")){
     	title="法律法规";
     }else if(type.equals("04")){
    	 title="基础建设报表";
    	 
     }

%>
<%@ include file="/global.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><%=title %>信息</title>
      <link href="<%=path %>/css/zfindex.css" rel="stylesheet" type="text/css" />
      <script language="javascript">
       $(function () {
          if(getUrlParam("type")=="04"){
              $("#framePage").attr("src","<%=path %>/UI/action/zyjk/ZczjAction_getZczjList.action?messageBean.method=look&zbid=T_YHZC_BZZB370000130605000001&strSysno=<%=sysno%>");
          }else{
              $("#framePage").attr("src","<%=path %>/index/zfindex/newslookinfo.jsp?sysno=<%=sysno %>&type=<%=type %>");
          }
       
       });
      
      </script>
       <script>
		function openMenu(id){			
				window.location.href="<%=webpath %>zfmain.jsp?mid="+id;
		} 
 	</script>
  </head>
  
  <body>
  	<jsp:include page="/index/zfhead.jsp" />
   			<iframe id="framePage" scrolling="auto" frameborder="0" src="" width="1000px" height="500px"></iframe>
	<jsp:include page="/index/zffoot.jsp" />		 
	</body>

</html>
