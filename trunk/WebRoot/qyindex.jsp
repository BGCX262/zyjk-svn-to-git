<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/webpath.jsp"%>
<head>


<title>职业卫生管理信息系统</title>

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
		     if(data.checkFlag=="0"){
		        $("#framePage").attr("src","<%=webpath%>index/left.jsp");
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
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(3)'>接害人员名单</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(2)'>职业卫生管理机构</a></td>";

		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(4)'>职业卫生档案</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(19)'>基础建设</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(17)'>建设项目三同时</a></td>";
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
		        $(".box1").html(str);
		        
		        
		        $("#framePage").attr("src","<%=webpath%>index/left.jsp");
		        $("#loginform").attr("src","<%=webpath%>index/zform.jsp");
		     }
		     
		     });
          }catch (e) {
     		  alert("error");
    	  }
    	  
        });

	       /* 注册*/
	       function reg()
	       {
	         try {
                   window.location.href=webpath+"/UI/action/register/EnterMain_findByKey.action?messageBean.method=add"; 
             }catch (e) {
              $.ligerDialog.error(e.message);
             }  
	      
	       }
        function showNavi(dept_type){
        //alert("enterno:"+enterno);
        
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
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(17)'>建设项目三同时</a></td>";
		             
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
		        $(".box1").html(str);
        }
        
        function enterinfo(index){
              document.getElementById("index").value=index;
              document.winform.submit();
        }
        
        
        
        function sysinfo(){
            $("#framePage").attr("src","<%=webpath%>index/left.jsp");
        } 
        
        function loadPage(index){
          //alert("index"+index);
          window.location.href=webpath+"index/qymain.jsp?pid="+index;
        }
        
        //iframe高度自适应
        function dyniframesize(down) {  
             var pTar = null;  
                if(document.getElementById){  
                
                pTar = document.getElementById(down);  
                
                }else{  
				
				eval('pTar = ' + down + ';');  
				
				}
				  
				if (pTar && !window.opera){  
			    //begin resizing iframe  
				pTar.style.display="block"  
				if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight){  
				//ns6 syntax  
				pTar.height = pTar.contentDocument.body.offsetHeight +20;  
				//pTar.width = pTar.contentDocument.body.scrollWidth+20;  
				}  
				else if (pTar.Document && pTar.Document.body.scrollHeight){  
				//ie5+ syntax  
				pTar.height = pTar.Document.body.scrollHeight;  
				//pTar.width = pTar.Document.body.scrollWidth;  
			    }  
		       }  
		} 
	    
</script>

	       
</head>

<body>
<jsp:include page="index/qyindexhead.jsp" />
<div class="box1" ></div>


<!--内容-->

<%--<jsp:include page="index/left.jsp" />--%>

<iframe id="framePage" name="framePage" style=" width:1000px;margin:0px auto;background:#ffffff;" src="" 
frameborder="0"  scrolling="no" onload="javascript:dyniframesize('framePage');"> 
</iframe>

<!--右边-->

<jsp:include page="index/qyindexfoot.jsp" />
</body>

</html>
