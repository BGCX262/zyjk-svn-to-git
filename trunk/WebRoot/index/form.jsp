
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/webpath.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=webpath %>css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=webpath %>js/jquery/jquery-1.7.1.min.js" language="javascript"></script>
	    <script src="<%=webpath %>js/ligerUI/js/ligerui.min.js" language="javascript"></script>
<script language="javascript">
         /* 提交*/
         function userlogin() {
                  var actionurl=webpath+"st/system/action/enterlogin/EnterLoginAction_check.action";
                 $.post(actionurl,$("form:first").serialize(),function(data){
                 
		        if(data.checkFlag=="1"){
		        
		            parent.parent.showNavi(data.widgetValue);
		         	window.location.href="zform.jsp";
		         	
		        }else{
		             if(data.checkMessage=="验证码输入有误！"){
		                alert(data.checkMessage);
		             }else{
		                window.open(webpath+"/UI/action/register/EnterMain_findByKey.action?messageBean.method=add",'newwindow','height=400,width=750,top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no');
		             }
     
		        }
		        
				},"json").error(function() { 
					alert("error");
				});
         }
             function refresh(){
	       
	        form.codeimg.src=webpath+"validate/image.jsp?"+Math.random();
	       }
        
   
</script>
</head>
<body style="background:#ffffff;">
<form name="form" method="post"  id="form" action="" style="margin:50px auto 44px; ">
  <table border="0" cellspacing="0" cellpadding="0" width="200" >
  <tr>
    <td  width="69" height="24" align="right" >用户名：</td>
    <td height="24" colspan="2" >  
      <label for="textfield"></label>
      <input name="officerBean.officer_name" type="text" id="officer_name" value="青岛顺林木业有限公司" style=" font-size:12px; border:0; border-style:none; width:131px; background:url(<%=webpath %>images/zyjk/top_006.gif) no-repeat; height:24px;" />
  </td>
  </tr>
  <tr>
    <td height="10" colspan="3"></td>
    </tr>
  <tr>
    <td  width="69" height="24" align="right" >密码：</td>
    <td height="24" colspan="2" >  
      <label for="textfield"></label>
      <input  type="password" id="c_pwd" name="officerBean.c_pwd" value="000000"  style=" font-size:12px; border:0; border-style:none; width:131px; background:url(<%=webpath %>images/zyjk/top_006.gif) no-repeat; height:24px;" />
</td>
  </tr>
  <tr>
    <td height="10" colspan="3"></td>
    </tr>
  <tr>
    <td  width="69" height="24" align="right" >验证码：</td>
    <td height="24"  width="81" >  
      <label for="textfield"></label>
      <input name="rand" type="text" id="rand"  style=" font-size:12px; border:0; border-style:none; width:69px; background:url(<%=webpath %>images/zyjk/top_007.gif) no-repeat; height:24px;" />
    </td>
    <td  width="70" >
    <img src="<%=webpath %>validate/image.jsp" style="width: 100%;height: 98%;" onclick="refresh()" id="codeimg"/>
    </td>
  </tr>
  <tr>
    <td height="10" colspan="3">&nbsp;</td>
  </tr>

  <tr>
    <td height="10" colspan="3"></td>
  </tr>
  <tr>
    <td width="200" colspan="3" align="center"><img src="<%=webpath %>images/zyjk/top_008.gif" width="91" height="26" alt="登录" style="cursor:pointer" onclick="userlogin()"/></td>
  </tr>
  </table>
  </form>
</body>
</html>