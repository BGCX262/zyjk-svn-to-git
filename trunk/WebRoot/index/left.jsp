<%@ page language="java"  pageEncoding="UTF-8"%>

<jsp:directive.page import="UI.dao.zyjk.NewsBean"/>
<jsp:directive.page import="java.util.*"/>

<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>

<jsp:directive.page import="UI.dao.zyjk.T_officerBean"/>

<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<jsp:directive.page import="UI.action.index.QyIndexAction"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/webpath.jsp"%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>职业卫生管理信息系统</title>
<%
T_officerBean officer=(T_officerBean)session.getAttribute(SystemAttributeNames.CORP_INFO_NAME);
//判断登陆用户类型
//String dept_type=officer.getDept_type();

QyjbqkBean qyjbqkBean=new QyjbqkBean();
String enterno="";
if(null!=officer){
	String corpkey=officer.getLogin_id();
	qyjbqkBean=qyjbqkBean.findFirst(" where corpkey='"+ corpkey +"'");
    if(officer.getDept_type().equals("1")){
    	if(null==qyjbqkBean){
    		enterno=corpkey;
    	}else{
    		enterno=qyjbqkBean.getEnterno();
    	}
    	
    }else{
    	
    }	
}

QyIndexAction index=new QyIndexAction();

Map<Object,Object> map=index.getQyinfo();
List<NewsBean> newslist=(List<NewsBean> )map.get("newslist");
List<NewsBean> noticelist=(List<NewsBean> )map.get("noticelist");
List<NewsBean> questionlist=(List<NewsBean> )map.get("questionlist");
//新闻图片
List<NewsBean> imagelist=(List<NewsBean> )map.get("imagelist");
%>
<link href="<%=webpath %>css/style.css" rel="stylesheet" type="text/css" />
<style>
     a:link 
     { 
     color:#FFFFFF; 
     }
     
     a:visited
     {
     color:#FFFFFF;
     
     } 

</style>
<script src="<%=webpath %>js/jquery/jquery-1.7.1.min.js" language="javascript"></script>
	    <script src="<%=webpath %>js/ligerUI/js/ligerui.min.js" language="javascript"></script>
	    <script src="<%=webpath %>js/json2.js" language="javascript" ></script>
		<script language="javascript">
		var actionurl;
		var openWidth;
		var openHeight;
		var myWindow = null;

        
        
        		/*初始化*/
	    $(function () {
           try {
            openWidth="980";
            openHeight="600"; 
		    actionurl=webpath+"st/system/action/enterlogin/EnterLoginAction_check.action";
		     $.post(webpath+"/st/system/action/enterlogin/LoginAction_loadDlxx.action",function(data) {
		     var obj=JSON.parse(data); 
		     if(obj.checkFlag=="0"){
		        $("#framePage").attr("src","<%=webpath%>index/left.jsp");
		        //alert("欢迎使用职业卫生信息管理系统");
		        $("#loginform").attr("src","<%=webpath%>index/form.jsp");
		        $(".box1").html("欢迎使用职业卫生信息管理系统");
		     }else{
		        
		        var dept_type=data.widgetValue;
		        if(dept_type=="1"){
		             str="<form id='winform' name='winform' method='post' action='qyindex.jsp'>";
                     str+="<input type='hidden' id='index' name='index'/>";
		             str+="<table align='left' style='valign:center;margin-bottom:-10px;'><tr>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='sysinfo()'>系统首页</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(1)'>用人单位基本信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(3)'>接触危害因素人员汇总</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(2)'>职业卫生管理机构</a></td>";
		             
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(4)'>职业卫生档案</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(19)'>基础建设</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(22)'>密码修改</a></td>";
		             str+="</tr></table></form>";
		        }else if(dept_type=="2"){
		             str="<form id='winform' name='winform' method='post' action='qyindex.jsp'>";
                     str+="<input type='hidden' id='index' name='index'/>";
		             str+="<table align='left' style='valign:center;margin-bottom:-10px;'><tr>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='sysinfo()'>系统首页</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(1)'>基本信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(2)'>人员信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(3)'>年检管理</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(4)'>检测设备管理</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(5)'>检测与评价报告管理</a></td>";
		             //str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(22)'>系统提醒</a></td>";
		             str+="</tr></table></form>";
		             
		        }else if(dept_type=="3"){
		             str="<form id='winform' name='winform' method='post' action='qyindex.jsp'>";
                     str+="<input type='hidden' id='index' name='index'/>";
		             str+="<table align='left' style='valign:center;margin-bottom:-10px;'><tr>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='sysinfo()'>系统首页</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(1)'>基本信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(2)'>讲师信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(3)'>培训信息</a></td>";
		             //str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(4)'>系统提醒</a></td>";
		             str+="</tr></table></form>";
		        
		        
		        }else if(dept_type=="4"){
		             str="<form id='winform' name='winform' method='post' action='qyindex.jsp'>";
                     str+="<input type='hidden' id='index' name='index'/>";
		             str+="<table align='left' style='valign:center;margin-bottom:-10px;'><tr>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='sysinfo()'>系统首页</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(1)'>基本信息</a></td>";
		             //str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(2)'>人员信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(3)'>体检信息</a></td>";
		             str+="</tr></table></form>";
		        
		        
		        }
		         //alert("========================");		        		        
		        //$(".box1").html(str);
		         //alert("111111111111111111111111111");		
		        $("#loginform").attr("src","<%=webpath%>index/zform.jsp");
		        //alert("222222222222222222222");		
		        $("#framePage").attr("src","<%=webpath%>index/left.jsp");
		        
		        //alert("##############################");	
		     }
		     
		     });
          }catch (e) {
     		  alert("error");
    	  }
    	  
        });
        
        
        
        function loadnews(sbtype,index){
        
             if(sbtype=="6"){
                 window.location.href="<%=webpath %>UI/qynews/newslist.jsp?strSysno="+index;
             }else if(sbtype=="7"){
                 window.location.href="<%=webpath %>/UI/action/qynews/NewsAction_findByKey.action?messageBean.method=look&strSysno="+index;
             }
            
        
        }
        
        
        function enterinfo(index){
                   
              document.getElementById("index").value=index;
              document.winform.submit();
        }
        
        function sysinfo(){
           window.location.href="qyindex.jsp";
        } 
        
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
        
</script>
<script type="text/javascript" src="<%=webpath%>js/jquery-1.2.6.pack.js"></script>
<style type="text/css">

#banner {position:relative; width:293px; height:238px; border:1px solid #666; overflow:hidden;text-align:left;}
#banner_list img {border:0px;}
#banner_bg {position:absolute; bottom:0;background-color:#000;height:30px;filter: Alpha(Opacity=30);opacity:0.3;z-index:1000;cursor:pointer; width:293px; }
#banner_info{position:absolute; bottom:0; left:5px;height:22px;color:#fff;z-index:1001;cursor:pointer}
#banner_text {position:absolute;width:120px;z-index:1002; right:3px; bottom:3px;}
#banner ul {position:absolute;list-style-type:none;filter: Alpha(Opacity=80);opacity:0.8; border:1px solid #fff;z-index:1002;
			margin:0; padding:0; bottom:3px; right:5px;}
#banner ul li { padding:0px 8px;float:left;display:block;color:#FFF;border:#e5eaff 1px solid;background:#6f4f67;cursor:pointer}
#banner ul li.on { background:#900}
#banner_list a{position:absolute;} <!-- 让四张图片都可以重叠在一起-->
</style>	       
</head>

<body style="background:#ffffff;height:475px;">


<!--内容-->

<!--左边-->
<div class="main_left" >
<div class="box2">
<div class="box3">
<div class="lef"><img src="<%=webpath%>images/zyjk/top_001.gif" width="150" height="35" alt="新闻动态" /></div>
<div class="rig"> <img src="<%=webpath%>images/zyjk/top_003.gif" width="52" height="35" alt="more" 
style="cursor:pointer" onclick="loadnews(6,1)"/>
</div>
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
  <a style="cursor:pointer" onclick="loadnews(7,'<%=imagelist.get(i).getSysno() %>')"> <img src="<%=webpath+imagelist.get(i).getPath()%>"  title="<%=imagelist.get(i).getTitle()%>" 
  alt="<%if(imagelist.get(i).getTitle().length()<13){
		out.println(imagelist.get(i).getTitle());
	}else{
		out.println(imagelist.get(i).getTitle().substring(0,13)+"...");
	}%>" width="293" height="238"/> </a> 
                        		  <%
                        	  }                     	  
                          }
                       %>
                   </div>
                </div>
            </div>          
<%

if(!newslist.isEmpty()){
for(int i=0;i<newslist.size();i++){
	%>
<div class="text1">
<div class="text2" style="text-overflow:ellipsis; overflow:hidden; white-space:nowrap">	
<a style="cursor:pointer" title="<%=newslist.get(i).getTitle() %>"onclick="loadnews(7,'<%=newslist.get(i).getSysno() %>')"> <%=newslist.get(i).getTitle()%></a>	
</div>	
<div class="text3">	
	<%=newslist.get(i).getIsscuedate()%>
</div>
<div class="clear"></div>
</div>	
	<%
}
}
%>
<div class="clear"></div>
</div>
<div class="box4">
<div class="box5">
<div class="box7">
<div class="lef"><img src="<%=webpath%>images/zyjk/top_010.gif" width="150" height="35" alt="公告通知" /></div>
<div class="rig"><img src="<%=webpath%>images/zyjk/top_003.gif" width="52" height="35" alt="more"  style="cursor:pointer" onclick="loadnews(6,2)"/></div>
<div class="clear"></div>
</div>
<%

if(!noticelist.isEmpty()){
for(int i=0;i<noticelist.size();i++){
	%>
<div class="text4">
<div class="text5" style="text-overflow:ellipsis; overflow:hidden; white-space:nowrap">	
	<a style="cursor:pointer"  title="<%=noticelist.get(i).getTitle() %>" onclick="loadnews(7,'<%=noticelist.get(i).getSysno() %>') ">
	<%if(noticelist.get(i).getTitle().length()<15){
		out.println(noticelist.get(i).getTitle());
	}else{
		out.println(noticelist.get(i).getTitle().substring(0,13)+"...");
	}%></a>
</div>	
<div class="text6">	
	<%=noticelist.get(i).getIsscuedate()%>
</div>
<div class="clear"></div>
</div>	
	<%
}
}
%>

</div>
<div class="box6">
<div class="box7">
<div class="lef"><img src="<%=webpath%>images/zyjk/top_011.gif" width="150" height="35" alt="常见问题" /></div>
<div class="rig"><img src="<%=webpath%>images/zyjk/top_003.gif" width="52" height="35" alt="more" style="cursor:pointer" onclick="loadnews(6,3)"/></div>
<div class="clear"></div>
</div>
<%

if(!questionlist.isEmpty()){
for(int i=0;i<questionlist.size();i++){
	%>
<div class="text4">
<div class="text5" style="text-overflow:ellipsis; overflow:hidden; white-space:nowrap">	
	<a style="cursor:pointer" title="<%=questionlist.get(i).getTitle() %> " onclick="loadnews(7,'<%=questionlist.get(i).getSysno() %>')">
	<%if(questionlist.get(i).getTitle().length()<15){
		out.println(questionlist.get(i).getTitle());
	}else{
		out.println(questionlist.get(i).getTitle().substring(0,13)+"...");
	}%></a>
</div>	
<div class="text6">	
	<%=questionlist.get(i).getIsscuedate()%>
</div>
<div class="clear"></div>
</div>	
	<%
}
}
%>

</div>
<div class="clear"></div>
</div>



</div>

<div class="main_right">
<div class="box8">
<div class="box9">
<div class="lef"><img src="<%=webpath%>images/zyjk/top_005.gif" width="150" height="35" alt="用户登录" /></div>
<div class="clear"> </div>
</div>
<iframe id="loginform" name="loginform" style="width:235px;height:260px; " src="" 
frameborder="no" border="0"  scrolling="no"> 
</iframe>

</div>
<div class="img2"><img src="<%=webpath%>images/zyjk/top_012.jpg" width="242" height="80" alt="" /></div>
<div class="img2"><img src="<%=webpath%>images/zyjk/top_013.jpg" width="242" height="80" alt="" /></div>
</div>
<div class="clear"></div>



</body>

</html>
