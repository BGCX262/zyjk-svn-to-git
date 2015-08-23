<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/webpath.jsp"%>
<html>
<head>
<title>zflogin</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
		body {
			margin-top: 0px;
			margin-right: 0px;
			margin-left: 0px;
			margin-bottom: 0px;
			background-color: #2ab2e6;
		
		} 
	</style>
<title></title>
		<link href="js/ligerUI/skins/Aqua/css/ligerui-form.css" rel="stylesheet" type="text/css" /> 
		<link href="js/ligerUI/skins/Aqua/css/ligerui-tree.css" rel="stylesheet" type="text/css" /> 	
		<script src="js/jquery/jquery-1.7.1.min.js" type="text/javascript"></script>
	    <script src="js/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
		<script type="text/javascript">
		var actionurl;
		
		
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
 
         function userlogin() {
		      $.post(actionurl,$("form:first").serialize(),function(data){
		     // alert(data.checkFlag);
		        if(data.checkFlag=="1"){
		         	window.location.href="index.jsp"; 
		        }else{
		           alert("密码有误");
		        }
				},"json").error(function() { 
					alert("error");
				});
		     
	       }
	       
	   
            
</script>
	
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<!-- ImageReady Slices (zflogin.psd) -->
<form name="form" method="post"  id="form">
<table id="__01" width="901" height="549" border="0" align="center"  cellpadding="0" cellspacing="0">
	<tr>
		<td rowspan="11">
			<img src="images/zflogin/bg_001.gif" width="1" height="549" alt=""></td>
		<td rowspan="11">
			<img src="images/zflogin/zflogin_02.gif" width="43" height="549" alt=""></td>
		<td>
			<img src="images/zflogin/bg_002_01.gif" width="222" height="160" alt=""></td>
		<td colspan="5">
			<img src="images/zflogin/bg_002_02.gif" width="365" height="160" alt=""></td>
		<td>
			<img src="images/zflogin/bg_002_03.gif" width="203" height="160" alt=""></td>
		<td rowspan="11">
			<img src="images/zflogin/zflogin_06.gif" width="66" height="549" alt=""></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="160" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/zflogin/bg_002_04.gif" width="222" height="47" alt=""></td>
		<td colspan="5">
			<img src="images/zflogin/bg_002_05.gif" width="365" height="47" alt=""></td>
		<td>
			<img src="images/zflogin/bg_002_06.gif" width="203" height="47" alt=""></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="47" alt=""></td>
	</tr>
	<tr>
		<td rowspan="9">
			<img src="images/zflogin/bg_002_07.gif" width="222" height="342" alt=""></td>
		<td colspan="5">
			<img src="images/zflogin/bg_002_08.jpg" width="365" height="19" alt=""></td>
		<td rowspan="9">
			<img src="images/zflogin/bg_002_09.gif" width="203" height="342" alt=""></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="19" alt=""></td>
	</tr>
	<tr>
		<td rowspan="8">
			<img src="images/zflogin/bg_002_08-14.jpg" width="75" height="323" alt=""></td>
		<td rowspan="2">
			<input type="text" id="deptnm" name="deptnm" value="青岛职业健康处" style="font-size:12; width: 100px;height: 100%;margin-top: -1px;margin-bottom: -1px"/></td>
		    <input name="ptoperBean.deptid" id="deptid" title="deptid" value="40-37020000-029" type="hidden"
						size="30" maxlength="2048" />
		<td colspan="3">
			<img src="images/zflogin/bg_002_08-16.jpg" width="108" height="8" alt=""></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="8" alt=""></td>
	</tr>
	<tr>
		<td rowspan="7">
			<img src="images/zflogin/bg_002_08-17.jpg" width="9" height="315" alt=""></td>
		<td rowspan="5">
			<img src="images/zflogin/bot_002.gif" width="64" height="62" alt=""  style="cursor:pointer" onclick="userlogin()"></td>
		<td rowspan="7">
			<img src="images/zflogin/bg_002_08-19.jpg" width="35" height="315" alt=""></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="11" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/zflogin/bg_002_08-20.jpg" width="182" height="10" alt=""></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="10" alt=""></td>
	</tr>
	<tr>
		<td>
			<input type="text" id="opernm" name="ptoperBean.opernm" value="zyjk" style="font-size:12; width: 97%;height: 100%;margin-top: -1px;margin-bottom: -1px"/></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="19" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/zflogin/bg_002_08-22.jpg" width="182" height="12" alt=""></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="12" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<input type="password" id="passwd" name="ptoperBean.passwd" value="000000" style="font-size:12; width: 97%;height:100%;margin-top: -2px;margin-bottom: -1px"/></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="10" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/zflogin/bg_002_08-24.jpg" width="64" height="253" alt=""></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="9" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/zflogin/bg_002_08-25.jpg" width="182" height="244" alt=""></td>
		<td>
			<img src="images/zflogin/hyphen.gif" width="1" height="244" alt=""></td>
	</tr>
</table>
</form>
<!-- End ImageReady Slices -->
</body>
</html>