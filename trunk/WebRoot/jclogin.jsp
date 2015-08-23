<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/webpath.jsp"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>检测机构登陆</title>
		<link href="js/ligerUI/skins/Aqua/css/ligerui-form.css" rel="stylesheet" type="text/css" /> 
		<link href="js/ligerUI/skins/Aqua/css/ligerui-tree.css" rel="stylesheet" type="text/css" /> 
		<link href="css/login/login-box.css" rel="stylesheet" type="text/css" />	
		<script src="js/jquery/jquery-1.7.1.min.js" type="text/javascript"></script>
	    <script src="js/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
		<script type="text/javascript">
		var actionurl;
		
		/*初始化*/
	    $(function () {
           try {
           
		    actionurl=webpath+"/UI/zyjk/jclogin/JcLoginAction_check.action";
          }catch (e) {
     		  alert("error");
    	  }
    	  
        });
             /* 提交*/
         function userlogin() {
		      $.post(actionurl,$("form:first").serialize(),function(data){
		      
		        if(data.checkFlag=="1"){
		         	window.location.href="UI/zyjk/jcjg/login/jcjgmain.jsp"; 
		        }else{
		           alert("用户名或密码错误");
		        }
				},"json").error(function() { 
					alert("error");
				});
		     
	       }
            
</script>
	</head>
	<body style="background: #EAEEF5;height: 100%">
	<form name="form" method="post"  id="form">
	    <div>
		</div>
		<table align="center" style="margin-top: 100px">
			<tr>
				<td>
			<div id="login-box">
				<h2>
					检测机构登陆
				</h2>
				<br />
				<br />
				<br />
				<br />
				<div id="login-box-name" >
					名称:
				</div>
				<div id="login-box-field" >
					<input name="officerBean.officer_name" id=Officer_Name class="form-login" title="Officer_Name" 
					value="青岛中一监测"	size="30" maxlength="2048" />
				</div>		<br />
				<div id="login-box-name">
					密 码:
				</div>
				<div id="login-box-field">
					<input name="officerBean.c_pwd" id="c_pwd" type="password" class="form-login" title="C_PWD"
						value="000000" size="30" maxlength="2048" onclick="" />
				</div>
				<br />
				<span class="login-box-options">
				</span>
				<img  id="subButton"
				 src="css/login/login-btn.png" width="103" height="42" style="margin-left:150px; margin-top: 20px" onclick="userlogin()"/> 
			</div>
			</td>
			</tr>
		</table>
		</form>
	</body>
</html>
