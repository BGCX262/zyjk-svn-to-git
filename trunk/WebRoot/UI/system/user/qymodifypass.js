/*********************************************************************
 *<p>处理内容：ptdept form js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.6.18---- 孙雁斌--------- 新规作成<br>
 ***********************************************************************/
 
        var actionurl;
        
        /* 提交*/
         function submitHandler() {
           var pass=document.all.unitpwd.value;
           if(pass.length>14||pass.length<6)
           {
               $.ligerDialog.error("密码要介于6到14位之间");
           
           }else if(!(document.all.unitpwd.value==document.all.c_pwd.value))
           {
                $.ligerDialog.error("两次输入的密码不一致");
           
           }else
           {
              $("#subButton").attr("disabled", true);
		      $.post(actionurl,$("form:first").serialize(),function(data){
		      $("#subButton").removeAttr('disabled'); 
		      if(data.checkFlag==MSG_SUCCESS)
			  {
			     		       	  			  
			       $.ligerDialog.success(data.checkMessage);
			       top.tab.refresh(top.tab.getSelectedTabItemID());	
			   }else{
			       $.ligerDialog.error(data.checkMessage);
			   }
				},"json").error(function() { 
				$("#subButton").removeAttr('disabled'); 
				$.ligerDialog.error(MSG_LOAD_FALL);
				});
           
           }
                             
	       } 

 
        $(function () {
        try {
        	    var method = $("#method").val();	
	            actionurl=webpath+"/st/system/action/enterlogin/LoginAction_editPassWord.action";
				
			
			/*验证样式提交*/
	         var v = Form();
	         $("form").ligerForm();
			
	        /*返回信息状态*/
	        var strFlag = $("#flag").val();
	        var strMessage = $("#message").val();
	        if(strFlag!=MSG_SUCCESS)
	        {  
			    $.ligerDialog.error(strMessage);
			 }
        
	         
	        /*重置按钮*/
	         $("#colButton").click(function () {
                    $("#unitpwd").val(""); 
                    $("#c_pwd").val("");  
	            });
	            

	        
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
     		   $.ligerDialog.error(e.message);
    	  }
        }); 
        
  
        
        
        