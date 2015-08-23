<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/webpath.jsp"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>监管系统企业端登陆</title>
		<link href="js/ligerUI/skins/Aqua/css/ligerui-form.css" rel="stylesheet" type="text/css" /> 
		<link href="js/ligerUI/skins/Aqua/css/ligerui-tree.css" rel="stylesheet" type="text/css" /> 
		<link href="css/login/login-box.css" rel="stylesheet" type="text/css" />	
		<script src="js/jquery/jquery-1.7.1.min.js" type="text/javascript"></script>
	    <script src="js/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
		<script type="text/javascript">
		var actionurl;
		var openWidth;
		var openHeight;
		var myWindow = null;
		/*初始化*/
	    $(function () {
           try {
            openWidth="980";
            openHeight="600"; 
		    actionurl=webpath+"st/system/action/enterlogin/EnterLoginAction_check";
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
	<body style="background: #EAEEF5;height: 100%">
	<form name="form" method="post"  id="form">
	    <div>
		</div>
		<table align="center" style="margin-top: 100px">
			<tr>
				<td>
			<div id="login-box">
				<h2>
					企业端登陆
				</h2>
				<br />
				<br />
				<table class="logintable">
					<tr>
					<td>
					企业名称:
					</td>
					<td>
					<input name="officerBean.officer_name" id=officer_name class="form-login" title="Officer_Name" 
					value="青岛顺林木业有限公司"	size="30" maxlength="2048" />
				</td>
				</tr>
				<tr>
				<td>
					密 码:
				</td>
				<td>
					<input name="officerBean.c_pwd" id="c_pwd" type="password" class="form-login" title="C_PWD"
						value="000000" size="30" maxlength="2048" onclick="" />
				</td>
				</tr>
				<tr>
				<td>
				<img  id="regButton"
				 src="css/login/reg-btn.png" width="103" height="42" style="margin-left:2px; margin-top: 20px" onclick="reg()"/> 
				</td>
				
				<td>
				<img  id="subButton"
				 src="css/login/login-btn.png" width="103" height="42" style="margin-left:130px; margin-top: 20px" onclick="userlogin()"/> 
				</td>

				</tr>
				</table>
				</div>
			</td>
			</tr>
		</table>
		</form>
	</body>
</html>
