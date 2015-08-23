<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/webpath.jsp"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>新一代综合监管系统</title>
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
           var tree = null;

		   actionurl=webpath+"st/system/action/login/LoginAction_check";
		  
            
            $("#deptnm").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PtdeptTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                       
                       		
                       		$("#deptid").val(node.data.id);
                       		$("#deptnm").val(node.data.text);
                   		}
                       
                    }
            });
            
  
		   
          }catch (e) {
     		  alert("error");
    	  }
    	  
        });
             /* 提交*/
         function userlogin() {
		      $.post(actionurl,$("form:first").serialize(),function(data){
		     // alert(data.checkFlag);
		        if(data.checkFlag=="1"){
		         	window.location.href="index.jsp"; 
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
					新一代综合监管系统
				</h2>
				<br />
				<br />
				<table class="logintable">
					<tr>
					<td>
					部门:
					</td>
					<td>
					<input name="deptnm" id="deptnm" class="form-login" title="deptnm" value="青岛职业健康处"
						size="30" maxlength="2048" />
					<input name="ptoperBean.deptid" id="deptid" title="deptid" value="40-37020000-029" type="hidden"
						size="30" maxlength="2048" />	
					<td>	
				</tr>
				<tr>
				<td>
					用户名:
				</td>
				<td>
					<input name="ptoperBean.opernm" id=opernm class="form-login" title="Username" value="zyjk"
						size="30" maxlength="2048" />
				</td>
				</tr>
				<tr>
					<td>
					密 码:
				</td>
				<td>
					<input name="ptoperBean.passwd" id="passwd" type="password" class="form-login" title="Password"
						value="000000" size="30" maxlength="2048" onclick="" />
				</td>
				</tr>
				<tr>
				<td colspan="2">
				<img  id="subButton"
				 src="css/login/login-btn.png" width="103" height="42" style="margin-left:150px; margin-top: 20px" onclick="userlogin()"/> 
			</td></tr>
			</table>
			</td>
			</tr>
		</table>
		</form>
	</body>
</html>
