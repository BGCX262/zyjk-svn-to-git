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
	 	var zbid="T_YHZC_BZZB370000130605000001";
	 	var myWindow=null;
	 	var openWidth="1000";
		var openHeight="650";
	 	function queryClick(){
 			document.all.tform.submit();
 		}
 		function load(xcode,ycode){
 			if(ycode=="AA"){
 				ycode="0";
 			}
 			var hylb=document.getElementById("hylb").value;
 			var whys=document.getElementById("whys").value;
 			var year=document.getElementById("year").value;
 			//window.open('<%=basePath%>UI/enterinfo/flfj_listInfo.action?distcode='+xcode+'&ZYBWHLB='+ycode+'&hylb='+hylb+'&whys='+whys+"&nianfen="+year+"&distj=3");
 			try {
			  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/zczj/tjzczjlist.jsp?distcode="+xcode+"&lx="+ycode+"&hylb="+hylb+"&whys="+whys+"&nianfen="+year+"&zbid="+zbid, width: openWidth,height:openHeight, title:"自查自纠列表",
			 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			  }catch (e) {
				$.ligerDialog.error(e.message);
			    }
    }
 		
 		function loadhg(xcode,ycode){
 			if(ycode=="A"){
 				ycode="1";
 			}
 			var hylb=document.getElementById("hylb").value;
 			var whys=document.getElementById("whys").value;
 			var year=document.getElementById("year").value;
 			//window.open('<%=basePath%>UI/enterinfo/flfj_listInfo.action?distcode='+xcode+'&ZYWSGLDJ='+ycode+'&hylb='+hylb+'&whys='+whys+"&nianfen="+year+"&distj=3");
 			try {
			  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/zczj/tjzczjlist.jsp?distcode="+xcode+"&lx="+ycode+"&hylb="+hylb+"&whys="+whys+"&nianfen="+year+"&zbid="+zbid, width: openWidth,height:openHeight, title:"自查自纠列表",
			 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
			  }catch (e) {
				$.ligerDialog.error(e.message);
			    }
		}
 		
 		function loadbhg(xcode,ycode){
 			if(ycode=="B"){
 				ycode="2";
 			}
 			var hylb=document.getElementById("hylb").value;
 			var whys=document.getElementById("whys").value;
 			var year=document.getElementById("year").value;
 			//window.open('<%=basePath%>UI/enterinfo/flfj_listInfo.action?distcode='+xcode+'&HDGLDJ='+ycode+'&hylb='+hylb+'&whys='+whys+"&nianfen="+year+"&distj=3");
 			try {
			  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/zczj/tjzczjlist.jsp?distcode="+xcode+"&lx="+ycode+"&hylb="+hylb+"&whys="+whys+"&nianfen="+year+"&zbid="+zbid, width: openWidth,height:openHeight, title:"自查自纠列表",
			 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
			  }catch (e) {
				$.ligerDialog.error(e.message);
			    }
		}
 		
 		function openZjTj(distcode){
 			
 			var hylb=document.getElementById("hylb").value;
 			var whys=document.getElementById("whys").value;
 			var year=document.getElementById("year").value;
 			
 			
 			window.open('<%=basePath%>UI/action/zczjtj/ZCZJTjAction_getZjDistcodeTable.action?distcode='+distcode+'&hylb='+hylb+'&whys='+whys+"&nianfen="+year+"&distj=3");
 			
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
  <form action="<%=basePath %>/UI/action/zczjtj/ZCZJTjAction_getZjDistcodeTable.action" id="tform" name="tform">
  	<input type="hidden"  name="year" id="year" value="<%=BusinessDate.getYear() %>"/>
  	<input type="hidden"  id="distcode" name="distcode" style="width:10px;"  fieldname="ssdq" value="<%=discode %>"   alerttitle="行政区划" fieldType="text" >
  	<table style=" width:100%" align="center"  border="0" cellspacing="0" cellpadding="0">
		 <tr height="20">
	           <td   align="center" ><span id="hy"></span>行业分类</td>
	             <td  align="center" width="18%"> 
			                        
			    <input type="hidden"    id="hylb" name="hylb" style="width:10px;"  fieldname="hylb" value="<%=hylb %>"  alerttitle="行业类别" fieldType="text" >
			    <input id="hylbname"  style="width:65%;"  fieldname="hylbname"   alerttitle="行业分类"  type="text" value="<%=EnumerationType.getEnu("HYLB", hylb)%>">
			   
	           </td>
			         
			     <td align="center"   >危害因素</td>
			     <td align="center"   width="20%">
			            
			    <input type="hidden"   id="whys" name="whys" style="width:10px;"  fieldname="whys"   alerttitle="危害因素" value="<%=whys %>" fieldType="text" >
			    <input id="whysname"  style="width:70%;"  fieldname="whysname"   alerttitle="危害因素名称"  type="text" value="<%=EnumerationType.getEnu("WHYS", whys)%>">
			    
			      </td>
			        <td align="center"><input class="l-button l-button-submit" id="savebut"  type="button" value="查看" onClick="queryClick();"> <input class="l-button l-button-submit"  type="reset"  value="重置"></td>
			          </tr>
		 	  
		 </table>
 	 </form>	
  <br>
  	<center><font size="5">按行政区域对企业基础建设情况统计</font></center>
  	<br>
  	
    	<table  class="analyzetbl" width="100%" align="center" border="0">
    		
    		<tr>
    			<th width="15%">行政区域</th>
    			<th>企业数</th>
    			<th>合格</th>
    			<th>不合格</th>
    			
    		</tr>
    		<% for(int i=0;i<dt.getRows();i++){
    		%>
    			<tr>
    				<td align="center">
    					<%if(dt.getRowMeta(i).equals("")||(dt.getRowMeta(i).indexOf("00000000")<0&&dt.getRowMeta(i).indexOf("000000")<0&&dt.getRowMeta(i).indexOf("000")<0)){ %>
    					<%=dt.getRowMetaCaption(i) %>
    					<%}else{%>
    					<a href="javascript:openZjTj('<%=dt.getRowMeta(i) %>')" ><%=dt.getRowMetaCaption(i) %></a>
    					<%}%>
    				</td>
    				<%for(int j=1;j<dt.getCols();j++){
    						if(j==1){
    					 %>
    					<td align="center"><a href="javascript:load('<%=dt.getRowMeta(i) %>','<%=dt.getColMeta(j) %>')"> <%=dt.getCellValue(i,j) %></a></td>
    				<%}else if(j==2){
    				%>
    					<td align="center"><a href="javascript:loadhg('<%=dt.getRowMeta(i) %>','<%=dt.getColMeta(j) %>')"> <%=dt.getCellValue(i,j) %></a></td>
    				<%}else{
    				%>
    					<td align="center"><a href="javascript:loadbhg('<%=dt.getRowMeta(i) %>','<%=dt.getColMeta(j) %>')"> <%=dt.getCellValue(i,j) %></a></td>
    				<% }
    				} %>
    			</tr>	
    		<%} %>
    	</table>
   
  </body>
</html>
