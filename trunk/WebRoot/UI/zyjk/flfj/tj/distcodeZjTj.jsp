<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.util.DataTable"/>
<jsp:directive.page import="UI.util.BusinessDate"/>
<jsp:directive.page import="st.platform.system.cache.EnumerationType"/>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
DataTable dt=(DataTable)request.getAttribute("table");
String discode=(String)request.getAttribute("distcode");
String hylb=(String)request.getAttribute("hylb");
String whys=(String)request.getAttribute("whys");
if(null==discode){
	discode="";
}else{
	if(discode.equals("3702")){
		discode="370200";
	}
}
if(null==hylb){
	hylb="";
}
if(null==whys){
	whys="";
}
%>
<%@ include file="/global.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>按行政区域统计分类分级情况</title>

  </head>
  <link href="<%=request.getContextPath()%>/css/analyze.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/base.css" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/index.js"></script>
	<!-- form util -->
	 	<script language="javascript" src="<%=request.getContextPath() %>/js/formutils.js"></script>
	<!-- 时间控件 -->
	 	<script language="javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"  defer="defer"></script>
	 <script type="text/javascript">
	  var myWindow = null;
		 var openWidth="1000";
		var openHeight="650";
	 	function queryClick(){
 			document.all.tform.submit();
 		}
 		function loadFl(xcode,ycode){
 			if(ycode=="AA"){
 				ycode="";
 			}
 			var hylb=document.getElementById("hylb").value;
 			var whys=document.getElementById("whys").value;
 			var year=document.getElementById("year").value;
 			//window.open('<%=basePath%>/UI/zyjk/flfj/tjflfj.jsp?distcode='+xcode+'&ZYBWHLB='+ycode+'&hylb='+hylb+'&whys='+whys+"&nianfen="+year);
 			try {
			  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/flfj/tjflfj.jsp?distcode='+xcode+'&ZYBWHLB='+ycode+'&hylb='+hylb+'&whys='+whys+'&nianfen='+year, width: openWidth,height:openHeight, title:"自查自纠列表",
			 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			  }catch (e) {
				$.ligerDialog.error(e.message);
			  }
 		}
 		function loadWFl(xcode,ycode){
 			if(ycode=="CC"){
 				ycode="";
 			}
 			var hylb=document.getElementById("hylb").value;
 			var whys=document.getElementById("whys").value;
 			var year=document.getElementById("year").value;
 			//window.open('<%=basePath%>/UI/zyjk/flfj/tjflfj.jsp?distcode='+xcode+'&ZYWSGLDJ='+ycode+'&hylb='+hylb+'&whys='+whys+"&nianfen="+year);
 			try {
			  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/zyjk/flfj/tjflfj.jsp?distcode='+xcode+'&ZYBWHLB='+ycode+'&hylb='+hylb+'&whys='+whys+'&nianfen='+year, width: openWidth,height:openHeight, title:"自查自纠列表",
			 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			  }catch (e) {
				$.ligerDialog.error(e.message);
			  }
 		}
 		function loadFj(xcode,ycode){
 			if(ycode=="BB"){
 				ycode="";
 			}
 			var hylb=document.getElementById("hylb").value;
 			var whys=document.getElementById("whys").value;
 			var year=document.getElementById("year").value;
 			//window.open('<%=basePath%>/UI/zyjk/flfj/tjflfj.jsp?distcode='+xcode+'&HDGLDJ='+ycode+'&hylb='+hylb+'&whys='+whys+"&nianfen="+year);
 			try {
			  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/flfj/tjflfj.jsp?distcode='+xcode+'&ZYWSGLDJ='+ycode+'&hylb='+hylb+'&whys='+whys+'&nianfen='+year, width: openWidth,height:openHeight, title:"自查自纠列表",
			 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			  }catch (e) {
				$.ligerDialog.error(e.message);
			  }
 		}
 		 $(function () {
            
           $("#hylbname").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 250, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=HYFLTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                                              		
                       		$("#hylbname").val(node.data.text);
                       		$("#hylb").val(node.data.id);
                   		}
                       
                    }
            }); 
             
             $("#whysname").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 250, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=WHYSTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                                              		
                       		$("#whysname").val(node.data.text);
                       		$("#whys").val(node.data.id);
                   		}
                       
                    }
            });  
	  
	  })
	 </script>	
  <body>
  <form action="<%=basePath %>/UI/action/flfjtj/FLFJTjAction_getDistcodeTable.action" id="tform" name="tform">
  	<input type="hidden"  name="year" id="year" value="<%=BusinessDate.getYear() %>"/>
  	<table style=" width:100%" align="center"  border="0" cellspacing="0" cellpadding="0">
		   <tr height="20">
	           <td   align="center" ><span id="hy"></span>行业分类</td>
	             <td  align="center" width="18%"> 
			                        
			    <input type="hidden" class="text"     id="hylb" name="hylb" style="width:10px;"  fieldname="hylb" value="<%=hylb %>"  alerttitle="行业类别" fieldType="text" >
			    <input class="text"   id="hylbname"  style="width:65%;"  fieldname="hylbname"   alerttitle="行政区划"  type="text" value="<%=EnumerationType.getEnu("HYLB", hylb)%>">
			     
	           </td><%--
	          
	            <td align="center"   >行政区划</td>
	            --%><td align="center"  width="20%">
			            
			    <input type="hidden" class="text"     id="distcode" name="distcode" style="width:10px;"  fieldname="ssdq" value="<%=discode %>"   alerttitle="行政区划" fieldType="text" >
			    <%--<input class="text"   id="distcodename"  style="width:70%;"  fieldname="DISTCODENAME"   alerttitle="行政区划"  type="text" value="<%=Util.getIsNullString(user.common.EnumerationType.getEnu("DISTCODE", discode))%>">
			    <input type="button" value="选择" onClick="xzqhtree('distcode','distcodename');">
			      --%></td>
			         
			     <td align="center"   >危害因素</td>
			     <td align="center"   width="20%">
			            
			    <input type="hidden" class="text"     id="whys" name="whys" style="width:10px;"  fieldname="whys"   alerttitle="危害因素" value="<%=whys %>" fieldType="text" >
			    <input class="text"   id="whysname"  style="width:70%;"  fieldname="whysname"   alerttitle="危害因素名称"  type="text" value="<%=EnumerationType.getEnu("WHYS", whys)%>">
			      </td>
			         <td align="center"><input id="savebut" class="l-button l-button-submit"  type="button" value="查看" onClick="queryClick();"> <input class="l-button l-button-submit"    type="reset"  value="重置"></td>
			           </tr>
		 	  
		 </table>
 	 </form>	
  <br>
  	<center><font size="5">按行政区域对企业分类分级统计</font></center>
  	<br>
  	
    	<table  class="analyzetbl" width="100%" align="center" border="0">
    		<tr>
    			
    			<th rowspan="2" width="10%">行政区域</th>
    			
    			<th colspan="3">职业病危害类别</th>
    			<th colspan="4">职业卫生管理等级</th>
    			<th colspan="5">监督管理等级</th>
    		</tr>
    		<tr>
    			<th width="10%">小计</th>
    			<th>重点</th>
    			<th>一般</th>
    			<th>小计</th>
    			<th>A</th>
    			<th>B</th>
    			<th>C</th>
    			<th>小计</th>
    			<th>一级</th>
    			<th>二级</th>
    			<th>三级</th>
    			<th>四级</th>
    		</tr>
    		<% for(int i=0;i<dt.getRows();i++){
    		%>
    			<tr>
    				<td align="center">
    					<%=dt.getRowMetaCaption(i) %>
    				</td>
    				<%for(int j=1;j<dt.getCols();j++){
    						if(j<=3){
    					 %>
    					<td align="center"><a href="javascript:loadFl('<%=dt.getRowMeta(i) %>','<%=dt.getColMeta(j) %>')"> <%=dt.getCellValue(i,j) %></a></td>
    				<%}else if(j>3&&j<=7){
    				%>
    					<td align="center"><a href="javascript:loadWFl('<%=dt.getRowMeta(i) %>','<%=dt.getColMeta(j) %>')"> <%=dt.getCellValue(i,j) %></a></td>
    				<%}else{
    				%>
    					<td align="center"><a href="javascript:loadFj('<%=dt.getRowMeta(i) %>','<%=dt.getColMeta(j) %>')"> <%=dt.getCellValue(i,j) %></a></td>
    				<% }
    				} %>
    			</tr>	
    		<%} %>
    	</table>
   
  </body>
</html>
