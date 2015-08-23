/*********************************************************************
 *<p>处理内容：menu form js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
 
        var actionurl;
        
        /* 提交*/
         function submitHandler() {
	          $("#subButton").attr("disabled", true);
		      $.post(actionurl,$("form:first").serialize(),function(data){
		      $("#subButton").removeAttr('disabled'); 
		      if(data.checkFlag==MSG_SUCCESS)
			  {
			       var parentmenuid=$("#parentmenuid").val();
			       var menuid=$("#menuid").val();

			       var method=$("#method").val();
			       
			       /*判断增加修改状态*/
			       if(method=="add"){
			       parent.node_add(parentmenuid);
			       }else if(method=="update"){
			       parent.node_modi(menuid);
			       }
			       
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
	              actionurl=webpath+"/st/system/action/menu/menu_insert.action";
	            }else if(method=="look"){
				  $("#subButton").hide();
				}else if(method=="update"){
				   actionurl=webpath+"/st/system/action/menu/menu_update.action";
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
 
        