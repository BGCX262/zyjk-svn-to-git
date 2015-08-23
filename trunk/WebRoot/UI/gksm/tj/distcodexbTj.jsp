<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.util.DataTable"/>
<jsp:directive.page import="UI.util.BusinessDate"/>
<jsp:directive.page import="st.platform.system.cache.EnumerationType"/>
<jsp:directive.page import="UI.util.DistcodeUtil"/>
<jsp:directive.page import="UI.util.CommenUtil"/>

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
		discode="370200000000";
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
	  	 var colselect=$("#distcodename").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 400, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree&strWhere= and Depth in (1,2,3) ', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid', 
                        onBeforeExpand: function(node)
		                 {
		                    if(node.data.children && node.data.children.length == 0){
		                      var strWhere="";
		              		 		//alert(node.data.depth);
		              		 		if(node.data.depth=='2'){
		              		 			strWhere=" and code like '"+node.data.id.substring(0, 6)+"%' and depth=3 ";
		              		 			columntree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":strWhere});
		              		 		
		              		 		}else if(node.data.depth=='3'){
		              		 			strWhere=" and code like '"+node.data.id.substring(0, 9)+"%' and depth=4 ";
		              		 			//alert(strWhere);
		              		 			columntree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":strWhere});
		              		 		}else{
		                           		columntree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":" and Depth in (1,2) "});
		              		 		}
		                    }
		                 },
                   		onClick: function (node)
                    	{                                              		
                       		$("#distcode").val(node.data.id);
                       		$("#distcodename").val(node.data.text);
                   		}
                       
                    }
            });
            var  columntree = colselect.tree.ligerGetTreeManager();
            
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
  <form action="<%=basePath %>/UI/action/zczjtj/ZCZJTjAction_getDistcodeTable.action" id="tform" name="tform">
  	 <input type="hidden"  name="year" id="year" value="<%=BusinessDate.getYear() %>"/>
  	<table style=" width:100%" align="center"  border="0" cellspacing="0" cellpadding="0">
		   <tr height="20">
	           <td   align="center" ><span id="hy"></span>行业分类</td>
	             <td  align="center" width="18%"> 
			                        
			    <input type="hidden"    id="hylb" name="hylb" style="width:10px;"  fieldname="hylb" value="<%=hylb %>"  alerttitle="行业类别" fieldType="text" >
			    <input id="hylbname"  style="width:65%;"  fieldname="hylbname"   alerttitle="行政区划"  type="text" value="<%=EnumerationType.getEnu("HYLB", hylb)%>">
			   
	           </td>
	          
	            <td align="center"   >行政区划</td>
	            <td align="center"  width="20%">
			            
			    <input type="hidden"  id="distcode" name="distcode" style="width:10px;"  fieldname="ssdq" value="<%=discode %>"   alerttitle="行政区划" fieldType="text" >
			    <input   id="distcodename"  style="width:70%;"  fieldname="DISTCODENAME"   alerttitle="行政区划"  type="text" value="<%=DistcodeUtil.getDistName(discode)%>">
			   
			      </td>
			         
			     
			        <td align="center"><input class="l-button l-button-submit" id="savebut"  type="button" value="查看" onClick="queryClick();"> </td>
			          </tr>
			<tr height="20">
			<td align="center"   >危害因素</td>
			     <td align="center"   width="20%">
			            
			    <input type="hidden"   id="whys" name="whys" style="width:10px;"  fieldname="whys"   alerttitle="危害因素" value="<%=whys %>" fieldType="text" >
			    <input id="whysname"  style="width:70%;"  fieldname="whysname"   alerttitle="危害因素名称"  type="text" value="<%=EnumerationType.getEnu("WHYS", whys)%>">
			      </td>
			  <td align="center"   ></td>    
			   <td align="center">
			   
			   </td>   
			<td align="center">
			<input class="l-button l-button-submit"    type="reset"  value="重置">
			</td>
			
			</tr>          
		 	  
		 </table>
 	 </form>	
  <br>
  	<center><font size="5">工矿商贸企业职业卫生统计表（按地区续2）</font></center>
  	<br>
  	
    	<table  class="analyzetbl" width="100%" align="center" border="0">
    	
			   <tr>
			    <th rowspan="3">地区</th>
			    <th rowspan="3"><p>职业</p>
			    <p>病危</p>
			    <p>害因</p>
			    <p>素检</p>
			    <p>测企</p>
			    <p>业数</p>
			    <p>(个)</p></th>
			    <th rowspan="3"><p>检测</p>
			    <p>率(%)</p></th>
			    <th colspan="11">检测点数（个）</th>
			    <th colspan="11">达标点数（个） </th>
			    <th colspan="11">达标率（%） </th>
			  </tr>
			  <tr>
			    <th rowspan="2"><p>合</p>
			    <p>计</p></th>
			    <th colspan="3">粉尘</th>
			    <th colspan="2">化学毒物</th>
			    <th colspan="3">物理因素</th>
			    <th colspan="2">生物因素</th>
			    <th rowspan="2"><p>合</p>
			    <p>计</p></th>
			    <th colspan="3">粉尘</th>
			    <th colspan="2">化学毒物</th>
			    <th colspan="3">物理因素</th>
			    <th colspan="2">生物因素</th> 
			    <th rowspan="2"><p>合</p>
			    <p>计</p></th>
			    <th colspan="3">粉尘</th> 
			    <th colspan="2">化学毒物</th>
			    <th colspan="3">物理因素</th>
			    <th colspan="2">生物因素</th>
			   
			  </tr>
			  <tr>
			    <th><p>小计</p>
			    </th>
			    <th><p>矽</p>
			    <p>尘</p></th>
			    <th><p>石</p>
			    <p>棉</p>
			    <p>尘</p></th>
			    <th>小计</th>
			    <th><p>高毒和</p>
			    <p>极度、高</p>
			    <p>度危害</p>
			    <p>化学物</p>
			    <p>质</p></th>
			    <th><p>小</p>
			    <p>计</p></th>
			    <th><p>电</p>
			    <p>离</p>
			    <p>辐</p>
			    <p>射</p></th>
			    <th><p>噪</p>
			    <p>声</p></th>
			    <th><p>小</p>
			    <p>计</p></th>
			    <th><p>炭</p>
			    <p>疽</p>
			    <p>杆</p>
			    <p>菌</p></th>
			    <th>小计</th>
			    <th><p>矽</p>
			    <p>尘</p></th>
			    <th><p>石</p>
			      <p>棉</p>
			    <p>尘</p></th>
			    <th>小计</th>
			    <th><p>高毒和</p>
			      <p>极度、高</p>
			      <p>度危害</p>
			      <p>化学物</p>
			    <p>质</p></th>
			    <th><p>小</p>
			    <p>计</p></th>
			    <th><p>电</p>
			      <p>离</p>
			      <p>辐</p>
			    <p>射</p></th>
			    <th><p>噪</p>
			    <p>声</p></th>
			    <th><p>小</p>
			    <p>计</p></th>
			    <th><p>炭</p>
			      <p>疽</p>
			      <p>杆</p>
			    <p>菌</p></th>
			    <th>小计</th>
			    <th><p>矽</p>
			    <p>尘</p></th>
			    <th><p>石</p>
			      <p>棉</p>
			    <p>尘</p></th>
			    <th>小计</th>
			    <th><p>高毒和</p>
			      <p>极度、高</p>
			      <p>度危害</p>
			      <p>化学物</p>
			    <p>质</p></th>
			    <th><p>小</p>
			    <p>计</p></th>
			    <th><p>电</p>
			      <p>离</p>
			      <p>辐</p>
			    <p>射</p></th>
			    <th><p>噪</p>
			    <p>声</p></th>
			    <th><p>小</p>
			    <p>计</p></th>
			    <th><p>炭</p>
			      <p>疽</p>
			      <p>杆</p>
			    <p>菌</p></th>
			    
			    
			    
			    
			   
			   
			  </tr>
    		<% for(int i=0;i<dt.getRows();i++){
    		%>
    			<tr>
    				<td align="center">
    					<%if(dt.getRowMeta(i).contains("00000000")||dt.getRowMeta(i).equals("")){ %>
    					<%=dt.getRowMetaCaption(i) %>
    					<%}else{%>
    					<a  href="#" ><%=dt.getRowMetaCaption(i) %></a>
    					<%}%>
    				</td>
    				<%for(int j=1;j<dt.getCols();j++){
    						if(j==1){
    					 %>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<%}else if(j==2){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<%}else if(j==3){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==4){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==5){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==6){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==7){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==8){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==9){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==10){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==11){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==12){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==13){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==14){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==15){
    				%>
    					<td align="center"><a href=""><%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==16){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==17){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==18){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==19){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==20){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==21){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==22){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==23){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==24){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==25){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==26){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==27){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==28){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==29){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==30){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==31){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==32){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==33){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==34){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }else if(j==35){
    				%>
    					<td align="center"><a href=""> <%=dt.getCellValue(i,j) %></a></td>
    				<% }
    				} %>
    			</tr>	
    		<%} %>
    	</table>
   
  </body>
</html>
