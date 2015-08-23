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
 
 		function ssss(){
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
	              actionurl=webpath+"/UI/action/zyjk/JcjgbaAction_insert.action";
	            }else if(method=="look"){
				  $("#subButton").hide();
				  $("#colButton").hide();
				}else if(method=="update"){
				   actionurl=webpath+"/UI/action/zyjk/JcjgbaAction_update.action";
				} 
				
	          var colselect = $("#enuditcode").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 400, 
                textField:'text',
                treeLeafOnly:true,
                tree: { 
                  idFieldName :'id',
	             parentIDFieldName :'pid', 
	             url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree&strWhere= and Depth in (1,2,3) ",
	             
	             nodeWidth : 200,
	             checkbox: false,
	             slide: false, 
	             method:"post",       
             //parms:{"strWhere":" and Depth in (1,2) "},                
          //   onExpand:onExpand,
            // onBeforeExpand: onBeforeExpand,
           	 onBeforeExpand: function(node)
                  {
                     if(node.data.children && node.data.children.length == 0){
                       var strWhere="";
               		 		//alert(node.data.depth);
               		 		if(node.data.depth=='2'){
               		 			strWhere=" and code like '"+node.data.id.substring(0, 6)+"%' and depth=3 ";
               		 			tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":strWhere});
               		 		
               		 		}else if(node.data.depth=='3'){
               		 			strWhere=" and code like '"+node.data.id.substring(0, 9)+"%' and depth=4 ";
               		 			//alert(strWhere);
               		 			tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":strWhere});
               		 		}else{
                            	tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":" and Depth in (1,2,3) "});
               		 		}
                     }
                  }, 
	             onClick:function(node){
	             				
                   				$("#distcode").val(node.data.id);
                   				$("#enuditcode").val(node.data.text);
                   		}
                       
                    }
            });
              var  tree = colselect.tree.ligerGetTreeManager();
			
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
        
        
       
        
        
        