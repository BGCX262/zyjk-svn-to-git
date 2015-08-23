<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.action.index.IndexAction"/>
<jsp:directive.page import="java.util.Map"/>
<jsp:directive.page import="java.util.HashMap"/>
<%
	IndexAction index=new IndexAction();
	Map map=index.getTSinfo(request);
	if(null==map){
		map=new HashMap();
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>系统提示</title>
</head>
<body > 
   	<div style="background: #FFFFFF;font-size: 14px;margin-left: 30px;">
   		<p>最新填报的企业有<a style="color: red;text-decoration: none;"><%=map.get("qyCount") %>个</a></p>
   		<p>企业自查自纠最新填报<a style="color: red;text-decoration: none;"><%=map.get("zczjCount") %>条</a></p>
   		<p>分类分级最新填报<a style="color: red;text-decoration: none;"><%=map.get("flfjCount") %>条</a></p>
   		<p>检测机构资质过期有<a style="color: red;text-decoration: none;"><%=map.get("jcjgCount") %>家</a></p>
   		<p>培训机构资质过期有<a style="color: red;text-decoration: none;"><%=map.get("pxjgCount") %>家</a></p>
   	</div>
</body>
</html>
