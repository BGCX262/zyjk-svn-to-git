/*********************************************************************
 *<p>处理内容：ptdept form js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.5.17---- --------- 新规作成<br>
 ***********************************************************************/
 
        var actionurl;
        
        /* 提交*/
         function submitHandler() {
	          $("#subButton").attr("disabled", true);
		      $.post(actionurl,$("form:first").serialize(),function(data){
		      $("#subButton").removeAttr('disabled'); 
		      if(data.checkFlag==MSG_SUCCESS)
			  {
			     //  parent.f_search();	
			     		       	  			  
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
 
        $(function () {
        try {
        	    var method = $("#method").val();	
	            if(method=="add"){
	              actionurl=webpath+"/UI/action/zyjk/PxjgbaAction_insert.action";
	            }else if(method=="look"){
				  $("#subButton").hide();
				  $("#colButton").hide();
				}else if(method=="update"){
				   actionurl=webpath+"/UI/action/zyjk/PxjgbaAction_update.action";
				} 
				
	          $("#distcode").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:true,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                       
                       		
                       		
                   		}
                       
                    }
            });
			
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
        
	         
	        /*关闭按钮*/
	         $("#colButton").click(function () {
					//parent.myWindow.close();
					top.$.ligerDialog.close(); 
					top.$.ligerDialog.hide()    
					//top.$.ligerDialog.close();   
	            });
	         
	        
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
     		   $.ligerDialog.error(e.message);
    	  }
        }); 
        
        
       
        
        
        