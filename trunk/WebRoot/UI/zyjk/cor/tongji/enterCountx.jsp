<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	xbt="根据行政区域查询统计查阅申报企业情况、职业健康管理机构和设施、培训情况";
	bt="地区";
}
if(kind.equals("2222")){
	xbt="根据行业类别查询统计查阅申报企业情况、职业健康管理机构和设施、培训情况";
	bt="行业类别";
	
}
if(kind.equals("3333")){
	xbt="根据职业危害因素查询统计查阅申报企业情况、职业健康管理机构和设施、培训情况";
	bt="危害因素";
}
if(kind.equals("4444")){
	xbt="根据企业规模查询统计查阅申报企业情况、职业健康管理机构和设施、培训情况";
	bt="企业规模";
}
%>
<%@ include file="/global.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>职业危害因素分布情况</title>
   
  </head>
     <link href="<%=basePath%>/css/analyze.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="<%=basePath%>/css/base.css" type="text/css" />
 	<script type="text/javascript">
 		function queryClick(){
 			document.all.tform.submit();
 		}
 		
 		function tableClick(){
 			document.all.tform.action="<%=basePath %>/UI/enterinfo/tableB_geData.action";
 			document.all.tform.submit();
 		}
 		 $(function () {
	  	 var colselect=$("#distcodename").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 400, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=TDQTree', checkbox: false,
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
 <br/>
    	<form action="<%=basePath %>/UI/enterinfo/enterinfotj_enterCount.action" id="tform" name="tform">
    	<input type="hidden" name="kind" value="<%=kind %>"/>
 	<table style=" width:100%" align="center"  border="0" cellspacing="0" cellpadding="0">
	   <tr height="20">
           <td   align="center" ><span id="hy"></span>行业分类</td>
             <td  align="center" width="18%"> 
		                        
		    <input type="hidden" class="text" id="hylb" name="hylb" style="width:10px;"  fieldname="hylb"   alerttitle="行业类别" fieldType="text" >
		    <input class="text"   id="hylbname"  style="width:65%;"  fieldname="hylbname"   alerttitle="行政区划"  type="text" value="<%=EnumerationType.getEnu("HYLB", hylb)%>">
		     
           </td>
          
            <td align="center"   >行政区划</td>
            <td align="center"  width="20%">
            
    <input type="hidden" class="text"     id="distcode" name="discode" style="width:10px;"  fieldname="ssdq"   alerttitle="行政区划" fieldType="text" >
    <input class="text"   id="distcodename"  style="width:70%;"  fieldname="DISTCODENAME"   alerttitle="行政区划"  type="text" value="<%=EnumerationType.getEnu("DISTCODE", discode)%>">
      </td>
         
     <td align="center"   >危害因素</td>
     <td align="center"   width="20%">
            
    <input type="hidden" class="text"     id="whys" name="whys" style="width:10px;"  fieldname="whys"   alerttitle="危害因素" fieldType="text" >
    <input class="text"   id="whysname"  style="width:70%;"  fieldname="whysname"   alerttitle="危害因素名称"  type="text" value="<%=EnumerationType.getEnu("WHYS", whys)%>">
     </td>
        <td align="center"><input id="savebut" class="buttonGrooveDisable"    type="button" value="查询" onClick="queryClick();"> <input class="buttonGrooveDisable"   type="button" onclick="restvic()" value="重置"></td>
          </tr>
 	  
 	</table>
 	
 	<br>
 		<center><h3><%=xbt %></h3></center>
    		<table class="analyzetbl" width="100%" align="center" border="0">
			  <tr>
			  <th align="center" width="8%"><%=bt %></th>
			    <th align="center" width="8%">企业数</th>
			    <th align="center" >申报企业</th>
			    <th align="center" >设置卫生管理机构企业</th>
			    <th align="center" >配备职业卫生管理人员企业</th>
			    <th align="center" >有警示标示企业</th>
			    <th align="center" >有职业病防治设施企业</th>
			    <th align="center" >发放个人用品企业</th>
			    <th align="center" >企业卫生培训企业</th>
			    <th align="center" >企业卫生培训人数</th>
			    <th align="center" >建立职业健康监护档案企业</th>
			  </tr>
			  <%
			  		String xAxis="";
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
			  		 <%//申报企业
			  		 	if(null!=listb){
			  			//for(int q=0;q<listb.size();q++){
			  				List <TjBean> list1=(ArrayList)listb.get(i);
			  				for(int w=0;w<list1.size();w++){
			  			%>
			  				<td align="center"><a href="javaScript:doOnLoadtSb('<%=list1.get(w).getYcode() %>','<%=list1.get(w).getXcode() %>')" ><%=list1.get(w).getSl().toString() %></a></td>
			  			<%}
			  			//}
			  			}else{
			  			%>
			  				<td></td>
			  			<%}
			  		 %>
			  		 <%//设置卫生管理机构企业
			  		 	if(null!=listc){
			  			//for(int q=0;q<listc.size();q++){
			  				List <TjBean> list1=(ArrayList)listc.get(i);
			  				for(int w=0;w<list1.size();w++){
			  					if(null!=list1.get(w).getSl().toString() &&!list1.get(w).getSl().toString().equals("")&&!list1.get(w).getSl().toString().equals("null")){
			  						xxx=Integer.parseInt(list1.get(w).getSl().toString());
			  					}
			  			%>
			  				<td align="center"><a href="javaScript:doOnLoadt('<%=list1.get(w).getYcode() %>','<%=list1.get(w).getXcode() %>')" ><%=list1.get(w).getSl().toString() %></a></td>
			  			<%}
			  			//}
			  			}else{
			  			%>
			  				<td></td>
			  				
			  			<%}
			  		 %>
			  		 <%//配备职业卫生管理人员企业
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
			  		  <td></td>
			  		 <td></td>
			  		 <%//发放个人用品企业
			  		 	if(null!=liste){
			  		 		if(i<liste.size()){
			  			//for(int q=0;q<listc.size();q++){
			  				List <TjBean> list1=(ArrayList)liste.get(i);
			  				for(int w=0;w<list1.size();w++){
			  			%>
			  				<td align="center"><a href="javaScript:doOnLoadt('<%=list1.get(w).getYcode() %>','<%=list1.get(w).getXcode() %>')" ><%=list1.get(w).getSl().toString() %></a></td>
			  			<%}
			  			}else{
			  			%>	
			  				<td></td>
			  			<%}
			  			}else{
			  			%>
			  				<td></td>
			  			
			  			<%}
			  		 %>
			  		
			  		  <%//企业卫生培训企业
			  		  	if(null!=listf){
			  			//for(int q=0;q<listd.size();q++){
			  				List <TjBean> list1=(ArrayList)listf.get(i);
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
			  		  <%//企业卫生培训人数
			  		  	if(null!=listg){
			  			//for(int q=0;q<liste.size();q++){
			  				List <TjBean> list1=(ArrayList)listg.get(i);
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
			  		
			  		 <td></td>	
			  		</tr> 
			  	<% }
			  		if(xAxis.length()>0){
		        		xAxis=xAxis.substring(0,xAxis.length()-1);
		        		dataSeries=dataSeries.substring(0,dataSeries.length()-1);
		        	}
			   %>
			   <%--<tr>
			   <td class="bt" align="center">合计</td>
			   <%
			   for(int j=0;j<12;j++){
			  			%>
			  				<td>
			  					
			  				</td>
			  		<%}
			  		 %>
			   </tr>
    		--%></table>
    	
    	</form>
  </body>
  <script type="text/javascript">
  	 function doOnLoadt(code,name) {
	 	 	var kind="<%=kind%>";
	 	 	if(kind=="1111"){
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?distcode='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 		}
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?distcode='+code);
	 	 		try {
			  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?distcode='+code, width: openWidth,height:openHeight, title:"申报企业列表",
			 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
			  }catch (e) {
				$.ligerDialog.error(e.message);
			    }
	 	 		
	 	 	}
	 	 	if(kind=="2222"){
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?hyfl='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 			//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?distcode='+code);
	 	 			try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?distcode='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}else{
	 	 			
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?hyfl='+code);
	 	 		try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?hyfl='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}
	 	 	}
	 	 	if(kind=="3333"){
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?hyfl='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 			//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?distcode='+code);
	 	 			try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?distcode='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}else{
	 	 			
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?whys='+code);
	 	 		try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?whys='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}
	 	 	}
			if(kind=="4444"){
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?hyfl='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 			//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?distcode='+code);
	 	 			try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?distcode='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}else{
	 	 			
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?chanzhi='+code);
	 	 		try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?chanzhi='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}
	 	 	}
		}
		 function doOnLoadtSb(code,name) {
	 	 	var kind="<%=kind%>";
	 	 	if(kind=="1111"){
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?distcode='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 		}
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?distcode='+code);
	 	 		try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?distcode='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		
	 	 	}
	 	 	if(kind=="2222"){
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?hyfl='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 			//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?distcode='+code);
	 	 			try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?distcode='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}else{
	 	 			
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?hyfl='+code);
	 	 		try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?hyfl='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}
	 	 	}
	 	 	if(kind=="3333"){
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?hyfl='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 			//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?distcode='+code);
	 	 			try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?distcode='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}else{
	 	 			
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?whys='+code);
	 	 		try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?whys='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}
	 	 	}
			if(kind=="4444"){
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?hyfl='+code+'&name='+name);
	 	 		if(code=="hj"){
	 	 			code="370200";
	 	 			//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?distcode='+code);
	 	 			try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?distcode='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
	 	 		}else{
	 	 			
	 	 		//window.open('<%=basePath%>UI/zyjk/cor/tjzcorlist.jsp?chanzhi='+code);
	 	 		try {
					  myWindow = top.$.ligerDialog.open({url:webpath+'/UI/zyjk/cor/tjzcorlist.jsp?chanzhi='+code, width: openWidth,height:openHeight, title:"申报企业列表",
					 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });  
					  }catch (e) {
						$.ligerDialog.error(e.message);
					    }
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
