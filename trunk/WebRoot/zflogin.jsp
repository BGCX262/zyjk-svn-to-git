<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/webpath.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>职业卫生管理信息系统</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<link href="js/ligerUI/skins/Aqua/css/ligerui-form.css" rel="stylesheet" type="text/css" /> 
<link href="js/ligerUI/skins/Aqua/css/ligerui-tree.css" rel="stylesheet" type="text/css" /> 	
<script src="js/jquery/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="js/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
<script type="text/javascript">
		var actionurl;
		
		
	    $(function () {
           try {
           var tree = null;

		   actionurl=webpath+"st/system/action/login/LoginAction_check.action";
		  
            
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
		         	window.location.href="zfindex.jsp"; 
		        }else{
		           alert("密码有误");
		        }
				},"json").error(function() { 
					alert("error");
				});
		     
	       }
	       
	   
            
</script>
</head>
<body>
<form name="form" method="post"  id="form">
<div class="box1">
<div class="box2">
  <table border="0" cellspacing="0" cellpadding="0" width="230">
  <tr>
    <td  width="56" height="24" align="right" >部门：</td>
    <td height="24" colspan="2"  align="left"> 
      <label for="textfield"></label>
      <input type="text" id="deptnm" name="deptnm" value="青岛职业健康处" style=" font-size:12px; border:0; border-style:none; width:164px; background:url(images/dl_001.gif) no-repeat; height:22px;" />
      <input name="ptoperBean.deptid" id="deptid" title="deptid" value="40-37020000-029" type="hidden"
						size="30" maxlength="2048" />
    </td>
  </tr>
  <tr>
    <td height="10" colspan="3"></td>
    </tr>
  <tr>
    <td  width="56" height="24" align="right" >用户名：</td>
    <td height="24" colspan="2" align="left" > 
      <label for="textfield"></label>
      <input  type="text" id="opernm" name="ptoperBean.opernm" value="zyjk" style=" font-size:12px; border:0; border-style:none; width:164px; background:url(images/dl_001.gif) no-repeat; height:22px;" />
   </td>
  </tr>
  <tr>
    <td height="10" colspan="3"></td>
    </tr>
  <tr>
    <td  width="56" height="24" align="right" >密码：</td>
    <td  height="24" colspan="2" align="left">
      <label for="textfield"></label>
      <input type="password" id="passwd" name="ptoperBean.passwd" value="000000" style=" font-size:12px; border:0; border-style:none; width:164px; background:url(images/dl_001.gif) no-repeat; height:22px;" />
   
     </td>
    
  </tr>
  <tr>
    <td height="10" colspan="3"></td>
  </tr>
  <tr>
    <td colspan="3" align="center"><img src="images/dl_003.gif" width="100" height="28" alt="登录" style="cursor:pointer" onclick="userlogin()" /></td>
  </tr>
  </table>
  </div>
</div>

</form>
</body>

</html>
