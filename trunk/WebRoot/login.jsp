<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/webpath.jsp"%>
<head>
<title>login</title>
<style>
		body {
			margin-top: 0px;
			margin-right: 0px;
			margin-left: 0px;
			margin-bottom: 0px;
			background-color: #2ab2e6;
		
		} 
		a:link { 
            color:#FFFFFF; 
            text-decoration:underline; 
        }

	</style>
	<link href="<%=webpath %>js/ligerUI/skins/Aqua/css/ligerui-form.css" rel="stylesheet" type="text/css" /> 
		<link href="<%=webpath %>js/ligerUI/skins/Aqua/css/ligerui-tree.css" rel="stylesheet" type="text/css" /> 
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
          }catch (e) {
     		  alert("error");
    	  }
    	  
        });
             /* 提交*/
         function userlogin() {
		      $.post(actionurl,$("form:first").serialize(),function(data){
		      
		        if(data.checkFlag=="1"){
		         	window.location.href="UI/enterfile/info/entermain.jsp"; 
		        }else{                 
                    window.open(webpath+"/UI/action/register/EnterMain_findByKey.action?messageBean.method=add",'newwindow','height=400,width=750,top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
		        }
				},"json").error(function() { 
					alert("error");
				});
		     
	       }
	       /* 注册*/
	       function reg()
	       {
	         try {
                   //window.open(webpath+"/UI/action/register/EnterMain_findByKey.action?messageBean.method=add",'newwindow','height=400,width=750,top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
                   //parent.window.close();
                   window.location.href=webpath+"/UI/action/register/EnterMain_findByKey.action?messageBean.method=add"; 
             }catch (e) {
              $.ligerDialog.error(e.message);
             }  
	      
	       }
</script>	       
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<!-- ImageReady Slices (login.psd) -->
<form name="form" method="post"  id="form">
<table id="__01" width="901" height="550" border="0"  align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td rowspan="9">
			<img src="images/login/bg_001.gif" width="1" height="549" alt=""></td>
		<td rowspan="9">
			<img src="images/login/login_02.gif" width="43" height="549" alt=""></td>
		<td>
			<img src="images/login/bg_002_01.gif" width="222" height="160" alt=""></td>
		<td colspan="6">
			<img src="images/login/bg_002_02.gif" width="365" height="160" alt=""></td>
		<td>
			<img src="images/login/bg_002_03.gif" width="203" height="160" alt=""></td>
		<td rowspan="9">
			<img src="images/login/login_06.gif" width="66" height="549" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="1" height="160" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login/bg_002_04.gif" width="222" height="47" alt=""></td>
		<td colspan="6">
			<img src="images/login/bg_002_05.gif" width="365" height="47" alt=""></td>
		<td>
			<img src="images/login/bg_002_06.gif" width="203" height="47" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="1" height="47" alt=""></td>
	</tr>
	<tr>
		<td rowspan="7">
			<img src="images/login/bg_002_07.gif" width="222" height="342" alt=""></td>
		<td colspan="6">
			<img src="images/login/bg_002_08.jpg" width="365" height="27" alt=""></td>
		<td rowspan="7">
			<img src="images/login/bg_002_09.gif" width="203" height="342" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="1" height="27" alt=""></td>
	</tr>
	<tr>
		<td colspan="4">
			<img src="images/login/bg_002_08-14.jpg" width="266" height="2" alt=""></td>
		<td rowspan="5">
			<img src="images/login/bot_002.gif" width="64" height="62" alt="" style="cursor:pointer" onclick="userlogin()"></td>
		<td rowspan="6">
			<img src="images/login/bg_002_08-16.jpg" width="35" height="315" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="1" height="2" alt=""></td>
	</tr>
	<tr>
		<td colspan="2" rowspan="2">
			<img src="images/login/bg_002_08-17.jpg" width="128" height="36" alt=""></td>
		<td>
			<!--<img src="images/login/login_17.jpg" width="117" height="19" alt="">-->
			<input type="text" id="officer_name" name="officerBean.officer_name" value="青岛顺林木业有限公司" style="font-size:12; width: 100%;height: 100%;margin-top: -1px;margin-bottom: -1px"/>
			
			</td>
		<td rowspan="5">
			<img src="images/login/bg_002_08-19.jpg" width="21" height="313" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="1" height="19" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login/bg_002_08-20.jpg" width="117" height="17" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="1" height="17" alt=""></td>
	</tr>
	<tr>
		<td rowspan="3">
			<img src="images/login/bg_002_08-21.jpg" width="127" height="277" alt=""></td>
		<td colspan="2">
			<!--<img src="images/login/bot_001.gif" width="118" height="19" alt=""></td>
		-->
		<input type="password" id="c_pwd" name="officerBean.c_pwd" value="000000" style="font-size:12; width: 97%;height:100%;margin-top: -2px;margin-bottom: -1px"/>
		<td>
			<img src="images/login/fgf.gif" width="1" height="19" alt=""></td>
	</tr>
	<tr>
		<td colspan="2" rowspan="2">
			<img src="images/login/bg_002_08-23.jpg" width="118" height="258" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="1" height="5" alt=""></td>
	</tr>
	<tr>
		<td background="images/login/bg_002_08-24.jpg" width="64" height="253" align="center" valign="top">
			<%--<img src="images/login/bg_002_08-24.jpg" width="64" height="253" alt="">--%>
			<div style="height:32px; line-height:32px; text-align:center;color: #4F4F4F;font-weight: bold">
			<a href="javascript:reg()" >注册</a>
			</div>
			</td>
		<td>
			<img src="images/login/fgf.gif" width="1" height="253" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login/fgf.gif" width="1" height="1" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="43" height="1" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="222" height="1" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="127" height="1" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="1" height="1" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="117" height="1" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="21" height="1" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="64" height="1" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="35" height="1" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="203" height="1" alt=""></td>
		<td>
			<img src="images/login/fgf.gif" width="66" height="1" alt=""></td>
		<td></td>
	</tr>
</table>
</form>
<!-- End ImageReady Slices -->
</body>
</html>