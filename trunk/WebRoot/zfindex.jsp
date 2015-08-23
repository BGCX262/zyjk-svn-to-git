<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.action.index.ZfIndexAction"/>
<jsp:directive.page import="UI.action.index.QyIndexAction"/>
<jsp:directive.page import="UI.dao.zyjk.BasiclawsmainBean"/>
<jsp:directive.page import="UI.dao.zyjk.ZczjqyxxzbBean"/>
<jsp:directive.page import="UI.util.DataTable"/>
<jsp:directive.page import="UI.dao.zyjk.NewsBean"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ZfIndexAction index=new ZfIndexAction();
Map<Object,Object> map=index.getZfinfo(request);
List<BasiclawsmainBean> laws=(List<BasiclawsmainBean> )map.get("law");
List<ZczjqyxxzbBean> zczjs=(List<ZczjqyxxzbBean> )map.get("zczj");
List<NewsBean> newslist=(List<NewsBean> )map.get("news");
List<NewsBean> gglist=(List<NewsBean> )map.get("ggnews");
DataTable dt=(DataTable)map.get("table");
//新闻图片
QyIndexAction qyindex=new QyIndexAction();
Map<Object,Object> qymap=qyindex.getQyinfo();
List<NewsBean> imagelist=(List<NewsBean> )qymap.get("imagelist");
%>
<%@ include file="/webpath.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>职业卫生监督管理信息系统</title>
   <link href="css/zfindex.css" rel="stylesheet" type="text/css" />
   <script type="text/javascript" src="<%=webpath%>js/jquery/jquery-1.7.1.min.js"></script>
   <script type="text/javascript">
   		var t = n = 0, count;
	   $(document).ready(function(){	
			count=$("#banner_list a").length;
			$("#banner_list a:not(:first-child)").hide();
			$("#banner_info").html($("#banner_list a:first-child").find("img").attr('alt'));
			$("#banner_info").click(function(){
			//window.open($("#banner_list a:first-child").attr('href'), "_blank")
			});
			$("#banner li").click(function() {
				var i = $(this).text() - 1;//获取Li元素内的值，即1，2，3，4
				n = i;
				if (i >= count) return;
				$("#banner_info").html($("#banner_list a").eq(i).find("img").attr('alt'));
				$("#banner_info").unbind().click(function(){
				//window.open($("#banner_list a").eq(i).attr('href'), "_blank")
				})
				$("#banner_list a").filter(":visible").fadeOut(500).parent().children().eq(i).fadeIn(1000);
				document.getElementById("banner").style.background="";
				$(this).toggleClass("on");
				$(this).siblings().removeAttr("class");
			});
			t = setInterval("showAuto()", 4000);
			$("#banner").hover(function(){clearInterval(t)}, function(){t = setInterval("showAuto()", 4000);});
		})
		
		function showAuto()
		{
			n = n >=(count - 1) ? 0 : ++n;
			$("#banner li").eq(n).trigger('click');
		}
      
      function loadopen(type){
	      if(type=='03'){
	      	window.location.href='<%=basePath%>zfmain.jsp?mid=301';
	      }else{
	      	window.location.href='<%=basePath%>index/zfindex/newslist.jsp?type='+type;
	      }
      }
      
      function loadnews(index){
        
           window.location.href="<%=webpath %>index/zfindex/detailinfo.jsp?type=01&sysno="+index;
        
        }
        
       function hidead()
       {
       document.getElementById("ad").style.display="none";
       }
       
	</script>
	 <script>
		function openMenu(id){			
				window.location.href="<%=webpath%>zfmain.jsp?mid="+id;
		} 
 </script>
  </head>
  
  

<body>   
<!--头部-->
<jsp:include page="index/zfhead.jsp" />
<!--内容-->
<div class="main">
<!--左边-->
<div class="main_left">
<div class="box2">
<div class="box3">
<div class="lef"><img src="images/zfindex/top_001.gif" alt="工作动态" /></div>
<div class="rig"><img src="images/zfindex/top_003.gif" alt="更多" onclick="loadopen('01')" style="cursor:pointer" /></div>
<div class="clear"></div>
</div>
<div class="img1">
	<div id="banner">	
                    <div id="banner_bg"></div>  <!--标题背景-->
                    <div id="banner_info"></div> <!--标题-->
                    <ul>
                        <li class="on">1</li>
                        <li>2</li>
                        <li>3</li>
                        <li>4</li>
                    </ul>
                   <div id="banner_list">
                  <%
                          if(!imagelist.isEmpty()){
                        	  for(int i=0;i<imagelist.size();i++){
                        		  %>                     		  
  <a style="cursor:pointer" onclick="loadnews('<%=imagelist.get(i).getSysno() %>')"> <img src="<%=webpath+imagelist.get(i).getPath()%>"  title="<%=imagelist.get(i).getTitle()%>" alt="" width="293" height="238"/> </a> 
                        		  <%
                        	  }                     	  
                          }
                       %>
                  </div>
                </div>
              
</div>

<%
	for(int i=0;i<newslist.size();i++){
		NewsBean news=newslist.get(i);
	%>
		
		<div class="text1">
		<%if(news.getTitle().length()>20){ %>
		<a href="<%=path %>/index/zfindex/detailinfo.jsp?sysno=<%=news.getSysno()%>&type=01" target="_blank"><%=news.getTitle().substring(0,20) %>...</a>
		<%}else{ %>
		<a href="<%=path %>/index/zfindex/detailinfo.jsp?sysno=<%=news.getSysno()%>&type=01" target="_blank"><%=news.getTitle() %></a>
		<%} %>
		
		</div>
		
		
	<%}
 %>

<div class="clear"></div>
</div>

<div class="box5">
<div class="box7">
<div class="lef"><img src="images/zfindex/top_009.gif" alt="案例分析" /></div>
<div class="rig"><img src="images/zfindex/top_003.gif" alt="更多"  onclick="loadopen('02')" style="cursor:pointer"  /></div>
<div class="clear"></div>
</div>
<%
	for(int i=0;i<laws.size();i++){
		BasiclawsmainBean law=laws.get(i);
	%>
		<div class="text4">
		<div class="text5">
		<a href="<%=path %>/index/zfindex/detailinfo.jsp?sysno=<%=law.getSysno()%>&type=02" href="#"><%=law.getMaintitle() %></a></div>
		<div class="text6"></div>
		<div class="clear"></div>
		</div>
		
	<%}
 %>

</div>


<div class="box5">
<div class="box7">
<div class="lef"><img src="images/zfindex/top_005.gif" alt="法律法规" /></div>
<div class="rig"><img src="images/zfindex/top_003.gif" alt="更多"  onclick="loadopen('02')" style="cursor:pointer"  /></div>
<div class="clear"></div>
</div>
<%
	for(int i=0;i<laws.size();i++){
		BasiclawsmainBean law=laws.get(i);
	%>
		<div class="text4">
		<div class="text5">
		<a href="<%=path %>/index/zfindex/detailinfo.jsp?sysno=<%=law.getSysno()%>&type=02" href="#"><%=law.getMaintitle() %></a></div>
		<div class="text6"></div>
		<div class="clear"></div>
		</div>
		
	<%}
 %>

</div>
</div>
<!--右边-->
<div class="main_right">
<%--<div class="box8">
<div class="box9">
<div class="lef"><img src="images/zfindex/top_004.gif" alt="申报进度" /></div>
<div class="clear"> </div>
</div>
<div class="box10">
<table width="420" border="0"  cellspacing="1" cellpadding="0"  bgcolor="#025992" style="font-size:13px;background: #025992;">
 
	<tr height="25">
		<td align="center" bgcolor="#ebebeb">行政区划</td>
		<td align="center" bgcolor="#ebebeb">企业</td>
		<td align="center" bgcolor="#ebebeb">合格</td>
		<td align="center" bgcolor="#ebebeb">不合格</td>
		
	</tr>
	
  	<% 
  	int count=15-dt.getRows();
  		
  	for(int i=0;i<dt.getRows();i++){
    		%>
    			<tr height="24">
    				<td bgcolor="#ffffff" align="center">
    					<%if(dt.getRowMeta(i).contains("00000000")||dt.getRowMeta(i).equals("")){ %>
    					<%=dt.getRowMetaCaption(i) %>
    					<%}else{%>
    					<a href="javascript:openZjTj('<%=dt.getRowMeta(i) %>')" ><%=dt.getRowMetaCaption(i) %></a>
    					<%}%>
    				</td>
    				<%for(int j=1;j<dt.getCols();j++){
    						if(j<=1){
    					 %>
    					<td bgcolor="#ffffff" align="center"><a href="javascript:load('<%=dt.getRowMeta(i) %>','<%=dt.getColMeta(j) %>')"> <%=dt.getCellValue(i,j) %></a></td>
    				<%}else if(j==2){
    				%>
    					<td bgcolor="#ffffff" align="center"><a href="javascript:loadhg('<%=dt.getRowMeta(i) %>','<%=dt.getColMeta(j) %>')"> <%=dt.getCellValue(i,j) %></a></td>
    				<%}else{
    				%>
    					<td bgcolor="#ffffff" align="center"><a href="javascript:loadbhg('<%=dt.getRowMeta(i) %>','<%=dt.getColMeta(j) %>')"> <%=dt.getCellValue(i,j) %></a></td>
    				<% }
    				} %>
    			</tr>	
    		<%} %>
 		<%for(int i=0;i<count;i++){%>
    			<tr height="24">
    				<td bgcolor="#ffffff" align="center">
    					
    				</td>
    				
    					<td bgcolor="#ffffff" align="center"></td>
    				
    					<td bgcolor="#ffffff" align="center"></td>
    				
    					<td bgcolor="#ffffff" align="center"></td>
    				
    			</tr>	
    		<%} %>
  </table>

</div>
</div>
--%>
<div class="box2">
<div class="box3">
<div class="lef"><img src="images/zfindex/top_008.gif" alt="公文公告" /></div>
<div class="rig"><img src="images/zfindex/top_003.gif" alt="更多" onclick="loadopen('01')" style="cursor:pointer" /></div>
<div class="clear"></div>
</div>


<%
	for(int i=0;i<gglist.size();i++){
		NewsBean news=gglist.get(i);
	%>
		
		<div class="text4">
		<div class="text5">
		<%if(news.getTitle().length()>20){ %>
		<a href="<%=path %>/index/zfindex/detailinfo.jsp?sysno=<%=news.getSysno()%>&type=01" target="_blank"><%=news.getTitle().substring(0,20) %>...</a>
		<%}else{ %>
		<a href="<%=path %>/index/zfindex/detailinfo.jsp?sysno=<%=news.getSysno()%>&type=01" target="_blank"><%=news.getTitle() %></a>
		<%} %>
		</div>
		<div class="text6"></div>
		<div class="clear"></div>
		</div>
		
		
	<%}
 %>

<div class="clear" style="height: 2px"></div>
</div>

<div class="box5">
<div class="box7">
<div class="lef"><img src="images/zfindex/top_010.gif" alt="职业标准" /></div>
<div class="rig"><img src="images/zfindex/top_003.gif" alt="更多"  onclick="loadopen('02')" style="cursor:pointer"  /></div>
<div class="clear"></div>
</div>
<%
	for(int i=0;i<laws.size();i++){
		BasiclawsmainBean law=laws.get(i);
	%>
		<div class="text4">
		<div class="text5">
		<a href="<%=path %>/index/zfindex/detailinfo.jsp?sysno=<%=law.getSysno()%>&type=02" href="#"><%=law.getMaintitle() %></a></div>
		<div class="text6"></div>
		<div class="clear"></div>
		</div>
		
	<%}
 %>

</div>

<div class="box5">
<div class="box7">
<div class="lef"><img src="images/zfindex/top_011.gif" alt="基本常识" /></div>
<div class="rig"><img src="images/zfindex/top_003.gif" alt="更多"  onclick="loadopen('02')" style="cursor:pointer"  /></div>
<div class="clear"></div>
</div>
<%
	for(int i=0;i<laws.size();i++){
		BasiclawsmainBean law=laws.get(i);
	%>
		<div class="text4">
		<div class="text5">
		<a href="<%=path %>/index/zfindex/detailinfo.jsp?sysno=<%=law.getSysno()%>&type=02" href="#"><%=law.getMaintitle() %></a></div>
		<div class="text6"></div>
		<div class="clear"></div>
		</div>
		
	<%}
 %>

</div>
</div>
<div class="clear"></div>

</div>

<%--<div id="ad" style="position:absolute" style="background: #A6DBD8;width: 60px;
            height: 40px;float:left;margin: 5px;">
<div style="FONT-SIZE: 9pt; CURSOR: hand" align=right onclick="hidead()">×</div>
<div><a href="<%=webpath %>index.jsp">传统主页</a></div>
</div>
--%><jsp:include page="index/zffoot.jsp" />
</body>
<%--<script type="text/javascript">
var x = 50,y = 60
var xin = true, yin = true
var step = 1
var delay = 20
var obj=document.getElementById("ad")
function floatAD() {
var L=T=0
var R= document.body.clientWidth-obj.offsetWidth
var B = document.body.clientHeight-obj.offsetHeight
obj.style.left = x + document.body.scrollLeft
obj.style.top = y + document.body.scrollTop
x = x + step*(xin?1:-1)
if (x < L) { xin = true; x = L}
if (x > R){ xin = false; x = R}
y = y + step*(yin?1:-1)
if (y < T) { yin = true; y = T }
if (y > B) { yin = false; y = B }
}
var itl= setInterval("floatAD()", delay)
obj.onmouseover=function(){clearInterval(itl)}
obj.onmouseout=function(){itl=setInterval("floatAD()", delay)}
</script>

--%></html>
