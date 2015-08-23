/*********************************************************************
 *<p>处理内容：demo form js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/

 var actionurl;
 
 		/* 提交*/
         function submitHandler() {
	          $("#subButton").attr("disabled", true);
		      $.post(actionurl,$("form:first").serialize(),function(data){
		      $("#subButton").removeAttr('disabled'); 
		      if(data.checkFlag==MSG_SUCCESS)
			  {
			       parent.f_search();
			       $.ligerDialog.success(data.checkMessage);
			   }else{
			       	$.ligerDialog.error(data.checkMessage);
			   }
				},"json").error(function() { 
				$("#subButton").removeAttr('disabled'); 
				$.ligerDialog.error(MSG_LOAD_FALL);
				});
	       } 
 
        $(function () {
        try {
        	    var method = $("#method").val();	
	            if(method=="add"){
	              actionurl=webpath+"/UI/action/demo/demo_insert.action";
	            }else if(method=="look"){
				  $("#subButton").hide();
				}else if(method=="update"){
				   actionurl=webpath+"/UI/action/demo/demo_update.action";
				} 
				
	        /*返回信息状态*/
	        var strFlag = $("#flag").val();
	        var strMessage = $("#message").val();
	        if(strFlag!=MSG_SUCCESS)
	        {  
			    $.ligerDialog.error(strMessage);
			 }
        
	        
	        /*关闭按钮*/
	         $("#colButton").click(function () {
					parent.myWindow.close();       
	            });
	         
	         /*验证样式提交*/
	         var v = Form();
	         $("form").ligerForm();
	            
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
     		   $.ligerDialog.error(e.message);
    	  }
        }); 
        
         
      