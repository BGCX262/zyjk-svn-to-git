<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="st.portal.html.DBSelect"/>
<jsp:directive.page import="st.platform.system.cache.EnumerationType"/>
<jsp:directive.page import="UI.action.tj.TjBean"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//统计出得数据
List lista=(List)request.getAttribute("lista");
List listb=(List)request.getAttribute("listb");
List listc=(List)request.getAttribute("listc");
List listd=(List)request.getAttribute("listd");
List liste=(List)request.getAttribute("liste");
List listf=(List)request.getAttribute("listf");
List listg=(List)request.getAttribute("listg");
List listh=(List)request.getAttribute("listh");
List listj=(List)request.getAttribute("listj");
//y轴数据
List yname=(List)request.getAttribute("yname");
List ycode=(List)request.getAttribute("ycode");

String kind=(String)request.getAttribute("kind");
String discode=(String)request.getAttribute("discode");
String hylb=(String)request.getAttribute("hylb");
String whys=(String)request.getAttribute("whys");
String bt="";
String xbt="";
int xxx=0;
int yyy=0;
if(kind.equals("1111")){
	xbt="职业病危害按行政区域统计表";
	bt="地区";
}
if(kind.equals("2222")){
	xbt="职业病危害按行行业类别统计表";
	bt="行业类别";
}
if(kind.equals("3333")){
	
	xbt="职业病危害按行危害因素统计表";
	bt="危害因素";
}
if(kind.equals("4444")){
	xbt="职业病危害按企业规模统计表";
	bt="企业规模";
}
%>
<%@ include file="/listglobal.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>职业危害因素分布情况</title>
   
  </head>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/tongji.css">
     <link href="<%=basePath%>/css/analyze.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="<%=basePath%>/css/base.css" type="text/css" />
 	<script type="text/javascript">
 		function queryClick(){
 			document.all.tform.submit();
 		}
 	
 		function tableClick(){
 			document.all.tform.action="<%=basePath %>/UI/enterinfo/table_geData.action";
 			document.all.tform.submit();
 		}
 	
 	</script>
 
 <body>
 <br/>
    	<form action="<%=basePath %>/UI/enterinfo/newtj_enterPerCount.action" id="tform" name="tform">
    	<input type="hidden" name="kind" value="<%=kind %>"/>
 	<table style=" width:100%" align="center"  border="0" cellspacing="0" cellpadding="0">
	   <tr height="20">
           <td   align="center" ><span id="hy"></span>行业分类</td>
             <td  align="center" width="18%"> 
		                        
		    <input type="hidden" class="text"     id="hylb" name="hylb" style="width:10px;"  fieldname="hylb"   alerttitle="行业类别" fieldType="text" >
		    <input class="text"   id="hylbname"  style="width:65%;"  fieldname="hylbname"   alerttitle="行政区划"  type="text" value="<%=EnumerationType.getEnu("HYLB", hylb)%>">
		    <input type="button" value="选择" onClick="treehylb('hylb','hylbname');">
              
           </td>
          
            <td align="center"   >行政区划</td>
            <td align="center"  width="20%">
            
    <input type="hidden" class="text"     id="distcode" name="discode" style="width:10px;"  fieldname="ssdq"   alerttitle="行政区划" fieldType="text" >
    <input class="text"   id="distcodename"  style="width:70%;"  fieldname="DISTCODENAME"   alerttitle="行政区划"  type="text" value="<%=EnumerationType.getEnu("DISTCODE", discode)%>">
    <input type="button" value="选择" onClick="xzqhtree('distcode','distcodename');">
      </td>
         
     <td align="center"   >危害因素</td>
     <td align="center"   width="20%">
            
    <input type="hidden" class="text"     id="whys" name="whys" style="width:10px;"  fieldname="whys"   alerttitle="危害因素" fieldType="text" >
    <input class="text"   id="whysname"  style="width:70%;"  fieldname="whysname"   alerttitle="危害因素名称"  type="text" value="<%=EnumerationType.getEnu("WHYS", whys)%>">
    <input type="button" value="选择" onClick="whystree('whys','whysname');">
      </td>
        <td align="center"><input id="savebut"  type="button" value="查看" onClick="queryClick();"> <input class="buttonGrooveDisable"    type="button" onclick="restvic()" value="重置"></td>
          </tr>
 	  
 	</table>
 	<br>
 		<div style='display: ;' id='contentdiv1'>
 		<center><h3><%=xbt%></h3></center>
    		<table class="GridTable" width="98%" align="center" id="tablexl" border="1">
    			<tr>
				    <td  align="center" class="bt" width="30%"><%=bt %></td>
				    <td  align="center" class="bt">涉及的企业数</td>
				    <td  align="center" class="bt">接触危害的人数</td>
				   
			  </tr>
			  
			  <%	String xAxis="";
        			String dataSeries="";
			  		for(int i=0;i<yname.size();i++){
			  			//PtenudetailBean p=(PtenudetailBean)list.get(i);
			  			if(!ycode.get(i).equals("hj")&&!ycode.get(i).equals("370200")){
			  				xAxis+=yname.get(i)+",";
			  			}
			  		%>
			  		<tr>
			  		<td align="center" class="bt"><%=yname.get(i) %></td>
			  		
			  		<%//企业数
			  			if(null!=lista){
			  			//for(int q=0;q<lista.size();q++){
			  				List <TjBean> list1=(ArrayList)lista.get(i);
			  				for(int w=0;w<list1.size();w++){
				  				if(list1.get(w).getSl().toString().length()>0){
				  					if(!ycode.get(i).equals("hj")&&!ycode.get(i).equals("370200")){
				  						dataSeries+=list1.get(w).getSl().toString()+",";
				  					}
				        			
				        		}else{
				        			if(!ycode.get(i).equals("hj")&&!ycode.get(i).equals("370200")){
										dataSeries+="0,";
										}
								}
			  			%>
			  				<td align="center"><a href="javaScript:doOnLoadt('<%=list1.get(w).getYcode() %>','<%=list1.get(w).getXcode() %>')" ><%=list1.get(w).getSl().toString() %></a></td>
			  			<%}
			  			//}
			  			}else{
			  				
									dataSeries+="0,";
								
			  			%>
			  				<td></td>
			  			<%}
			  		 %>
			  		
			  		
			  		 <%//危害人数
			  		 	if(null!=listd){
			  			//for(int q=0;q<listc.size();q++){
			  				List <TjBean> list1=(ArrayList)listd.get(i);
			  				for(int w=0;w<list1.size();w++){
			  					
			  			%>
			  				<td align="center"><a href="javaScript:doOnLoadt('<%=list1.get(w).getYcode() %>','<%=list1.get(w).getXcode() %>')" ><%=list1.get(w).getSl().toString() %></a></td>
			  			<%}
			  			//}
			  			}else{
			  			%>
			  				<td></td>
			  				
			  			<%}
			  		 %>
			  		
			  		</tr> 
			  	<% }
			  	if(xAxis.length()>0){
        		xAxis=xAxis.substring(0,xAxis.length()-1);
        		dataSeries=dataSeries.substring(0,dataSeries.length()-1);
        	}
			   %><%--
			 <tr>
			   <td class="bt" align="center">合计</td>
			   <td  align="center"><%=GetCountUtil.getCount(lista) %></td>
			   <td align="center"><%=GetCountUtil.getCount(listb) %></td>
			   <td  align="center"><%=GetCountUtil.getCount(listc) %></td>
			   <td  align="center"><%=GetCountUtil.getCount(listd) %></td>
			   <td  align="center"><%=GetCountUtil.getCount(liste) %></td>
			   <td  align="center"><%=GetCountUtil.getCount(listf) %></td>
			   <td  align="center"><%=GetCountUtil.getCount(listg) %></td>
			   <td  align="center"><%=GetCountUtil.getCount(listh) %></td>
			   <td  align="center"><%=GetCountUtil.getCount(listj) %></td>
			  
			   </tr>
    		--%></table>
    	</div>
    	<div style='display:none ;' id='contentdiv2' align=center></div>
        <div style='display:none ;' id='contentdiv3' align=center></div>
        <div style='display:none;'  id='contentdiv4' align=center></div>	
    	</form>
  </body>
  <%@include file="entercharts.jsp"%>
  <script type="text/javascript">
  	 function doOnLoadt(code,name) {
	 	 	var kind="<%=kind%>";
	 	 	if(kind=="1111"){
	 	 		//window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?distcode='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 		}
	 	 		window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?distcode='+code);
	 	 		
	 	 	}
	 	 	if(kind=="2222"){
	 	 		//window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?hyfl='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 			window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?distcode='+code);
	 	 		}else{
	 	 			
	 	 		window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?hyfl='+code);
	 	 		}
	 	 	}
			if(kind=="3333"){
	 	 		//window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?hyfl='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 			window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?distcode='+code);
	 	 		}else{
	 	 			
	 	 		window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?whys='+code);
	 	 		}
	 	 	}
	 	 	if(kind=="4444"){
	 	 		//window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?hyfl='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 			window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?distcode='+code);
	 	 		}else{
	 	 			
	 	 		window.open('<%=basePath%>UI/enterinfo/enterinfo_listInfo.action?chanzhi='+code);
	 	 		}
	 	 	}
		}
		
  </script>
  <script>
	function showdiv(idx) {
		for ( var i = 1 ; i < 5 ; i++ ) {
		   if ( i == idx ){
 		      document.all['contentdiv'+i].style.display='';
 		      if(i!=1){showChart(i,'统计报表','<%=xAxis %>','<%=dataSeries %>');}
		   }else{
		      document.all['contentdiv'+i].style.display='none';
			}
		}
	}
	
function restvic(){
		document.getElementById("hylb").value="";
		document.getElementById("hylbname").value="";
		document.getElementById("distcode").value="";
		document.getElementById("distcodename").value="";
		document.getElementById("whys").value="";
		document.getElementById("whysname").value="";
	}
	var hylbtest="<%=hylb%>";
 		if(hylbtest!=null&&hylbtest!=""&hylbtest!="nulll"){
 			document.getElementById("hylb").value=hylbtest;
 		}	
</script>
</html>
