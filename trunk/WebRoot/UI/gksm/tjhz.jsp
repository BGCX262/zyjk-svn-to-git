<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="<%=basePath%>css/gkstyle.css" rel="stylesheet" type="text/css" />
    <title>工矿商贸相关统计</title>
    
  </head>
  
  <body>
  		
    	<table class="gktable">
    		<tr>
    			<th colspan="4" style="height: 45;text-align: center;font-size: 16"> 工矿商贸企业职业卫生统计表</th>
    		</tr>
    		<tr>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmTjAction_getDistcodeTable.action')">工矿商贸企业职业卫生统计表(按地区)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmXaTjAction_getDistcodeTable.action')">工矿商贸企业职业卫生统计表(按地区续1)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmXbTjAction_getDistcodeTable.action')">工矿商贸企业职业卫生统计表(按地区续2)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmXcTjAction_getDistcodeTable.action')">工矿商贸企业职业卫生统计表(按地区续2)</a></td>
    		</tr>	
    		<tr>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmHylbTjAction_getHylbTable.action')">工矿商贸企业职业卫生统计表(按行业类别)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmHylbXaTjAction_getHylbTable.action')">工矿商贸企业职业卫生统计表(按行业续1)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmHylbXbTjAction_getHylbTable.action')">工矿商贸企业职业卫生统计表(按行业续2)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmHylbXcTjAction_getHylbTable.action')">工矿商贸企业职业卫生统计表(按行业续2)</a></td>
    		</tr>	
    		<tr>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmQygmTjAction_getQygmTable.action')">工矿商贸企业职业卫生统计表(按规模)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmQygmXaTjAction_getQygmTable.action')">工矿商贸企业职业卫生统计表(按规模续1)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmQygmXbTjAction_getQygmTable.action')">工矿商贸企业职业卫生统计表(按规模续2)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmQygmXcTjAction_getQygmTable.action')">工矿商贸企业职业卫生统计表(按规模续2)</a></td>
    		</tr>	
    		<tr>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmZclxTjAction_getZclxTable.action')">工矿商贸企业职业卫生统计表(按注册类型)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmZclxXaTjAction_getZclxTable.action')">工矿商贸企业职业卫生统计表(按类型续1)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmZclxXbTjAction_getZclxTable.action')">工矿商贸企业职业卫生统计表(按类型续2)</a></td>
    			<td><a href="javascript:window.open('<%=basePath %>UI/action/gksmtj/GksmZclxXcTjAction_getZclxTable.action')">工矿商贸企业职业卫生统计表(按类型续2)</a></td>
    		</tr>	
    	</table>
  </body>
</html>
