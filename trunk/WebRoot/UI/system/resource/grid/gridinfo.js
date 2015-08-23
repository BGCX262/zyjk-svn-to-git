/*********************************************************************
 *<p>处理内容：GIRD form js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
 var tree =null;
 var menu=null;
 var actionurl = null;
 var columntree = null; 
 var colselect =null;
 var grid = null;
        $(function () {
        try {
                  
        	    var method = $("#method").val();	
	            if(method=="add"){
	              actionurl=webpath+"/st/system/action/grid/GridColumnAction_insert.action";
	            }else if(method=="look"){
				  $("#subButton").hide();
				}else if(method=="update"){
				   actionurl=webpath+"/st/system/action/grid/GridColumnAction_update.action";
				} 
        	
	        /*返回信息状态*/
	        var strFlag = $("#flag").val();
	        var strMessage = $("#message").val();
	        if(strFlag==MSG_SUCCESS)
	        {  
	        
			 }else{
			    $.ligerDialog.error(strMessage);
			 }
        
        
        
    /*添加字段*/
 	$("#addcolumn").click(function(){
 		 var gridname = $("#gridn").val();
  		 var tableid = $("#tableid").val();
  		 var columnid = $("#columnid").val();
  		 if(tableid!=null&&tableid!="")
  	     {
		   	$("#gridname").val(gridname);
		   	$("#tablename").val(tableid);
		   	$("#columnname").val(columnid);
		   	
		   	
		   	 $.post(webpath+"/st/system/action/databasc/DataBasc_findColumn.action",{strTableName:tableid,strColumnName:columnid},function(data){
			 if(data.messageBean.checkFlag==MSG_SUCCESS)
			 {
				$("#columndesc").val(data.ptableColumnBean.columndesc);			   
			 }else{
			      $.ligerDialog.error(data.messageBean.checkMessage);
			 }
			 },"json").error(function() { 
					$.ligerDialog.error(MSG_LOAD_FALL);
		  });
		   	
		   	
  	     }else{
   	     $.ligerDialog.warn("GridName 为空");
  		 }
   	  });
        
	        
	        /*关闭按钮*/
	         $("#colButton").click(function () {
					parent.myWindow.close();       
	            });
	         
	       
	             /*表格selcet树*/
        /* $("#columnmenu").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:true,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PTenumTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid'
                        }
                });      */
           
             /*表格selcet树*/
          $("#tableid").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:true,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PTableTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                       
                       		var nodeid=node.data.id;  
                       		f_getColumn(nodeid);
                   		}
                       
                    }
            });
           
               
	      	/*字段select树*/
         colselect =$("#columnid").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:true,
                tree: { 
                checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                    }
            });
          columntree  =colselect.tree.ligerGetTreeManager(); 
                 
	         /*验证样式*/   
	         $.metadata.setType("attr", "validate");
	         
	          var v = $("form").validate({
	          //调试状态，不会提交数据的
                debug: true,
                errorPlacement: function (lable, element) {

                    if (element.hasClass("l-textarea")) {
                        element.addClass("l-textarea-invalid");
                    }
                    else if (element.hasClass("l-text-field")) {
                        element.parent().addClass("l-text-invalid");
                    }

                    var nextCell = element.parents("td:first").next("td");
                    nextCell.find("div.l-exclamation").remove(); 
                    $('<div class="l-exclamation" title="' + lable.html() + '"></div>').appendTo(nextCell)
                    element.parents("td:first").ligerTip(); 
                },
                success: function (lable) {
                    var element = $("#" + lable.attr("for"));
                    var nextCell = element.parents("td:first").next("td");
                    if (element.hasClass("l-textarea")) {
                        element.removeClass("l-textarea-invalid");
                    }
                    else if (element.hasClass("l-text-field")) {
                        element.parent().removeClass("l-text-invalid");
                    }
                    nextCell.find("div.l-exclamation").remove();
                },
	                //调试状态，不会提交数据的
	                submitHandler: function () {
	                  $("#subButton").attr("disabled", true);
		                    $.post(actionurl,$("form:first").serialize(),function(data){
		                     $("#subButton").removeAttr('disabled'); 
							 if(data.checkFlag==MSG_SUCCESS)
			       	  		   {
			       	  			  parent.f_serch($("#gridname").val());
			       	  			  $.ligerDialog.success(data.checkMessage);
			       	 			}else{
			       	  			   $.ligerDialog.error(data.checkMessage);
			       				}
							},"json").error(function() { 
							    $("#subButton").removeAttr('disabled'); 
								$.ligerDialog.error(MSG_LOAD_FALL);
							});
	                }
	            });
	            $("form").ligerForm();
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
     		   $.ligerDialog.error(e.message);
    	  }
        });  
        
        
        
          /*联动取得column*/
  function f_getColumn(nodeid)
  {
  	 if(nodeid!=""){
  	 	var strWhere =" where tableid='"+nodeid+"'";
  	 	columntree.clear();
		columntree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PTableColumnTree', {strWhere:strWhere});
     } 
  }
      
      