/*********************************************************************
 *<p>处理内容：demo form js</p>
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
        
	        actionurl=webpath+"/st/system/action/detail/DetailSetAction_submint.action";
        	
	        /*返回信息状态*/
	        var strFlag = $("#flag").val();
	        var strMessage = $("#message").val();
	        if(strFlag!=MSG_SUCCESS)
	        {  
			    $.ligerDialog.error(strMessage);
			}
		        
		    /*添加字段*/
		 	$("#addcolumn").click(function(){
			 		addrows();
		   	});
	        
	        /*提交*/
		    $("#subButton").click(function(){
		   			f_submit();
		   	});
	        /*关闭按钮*/
	         $("#colButton").click(function () {
					parent.myWindow.close();       
	            });
	         
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
                checkbox: true,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                    }
            });
          columntree  =colselect.tree.ligerGetTreeManager(); 
	      $("form").ligerForm();

          }catch (e) {
     		   $.ligerDialog.error(e.message);
    	  }
        });  
        
   /*提交*/         
  function f_submit(){
	   
	     $("#subButton").attr("disabled", true);
		 $.post(actionurl,$("form:first").serialize(),function(data){
		 $("#subButton").removeAttr('disabled'); 
			  if(data.messageBean.checkFlag==MSG_SUCCESS)
			  {
			     parent.f_serch($("#formid").val());
			     var strcont = data.strContent;
			     $("#textTable").html(strcont);
			     $.ligerDialog.success(data.messageBean.checkMessage);
			   }else{
			       	$.ligerDialog.error(data.messageBean.checkMessage);
			  }
		},"json").error(function() { 
					 $("#subButton").removeAttr('disabled'); 
					$.ligerDialog.error(MSG_LOAD_FALL);
		});
	   $("form").ligerForm();						
				
  }          
       
        
  /*联动取得column*/
  function f_getColumn(nodeid)
  {
  	 if(nodeid!=""){
  	 	var strWhere =" where tableid='"+nodeid+"'";
  	 	columntree.clear();
		columntree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PTableColumnTree', {strWhere:strWhere});
     } 
  }
  
  //添加内容的行
   function addrows(){
   	var tableid = $("#tableid").val();
    var columnid = $("#columnid").val();
    var formid = $("#formid").val();
    var strhid = $("#strHid").val();

  		 if(tableid!=null&&tableid!=""&&columnid!=null&&columnid!="")
  	     {
  	         
			 $.post(webpath+"/st/system/action/detail/DetailSetAction_insert.action",{strHidden:strhid,strTable:tableid,strFormName:formid,strColumn:columnid},
			 function(data){
	 			 if(data.messageBean.checkFlag==MSG_SUCCESS)
			      {
			      	 //刷新grid
			       	  parent.f_grid($("#formid").val());
			       	  alert(data.strContent);
			       	  $("#textTable").html(data.strContent);
			       	 
			       	  $.ligerDialog.success(data.messageBean.checkMessage);
			      }else{
			       	  $.ligerDialog.error(data.messageBean.checkMessage);
			      }
	 			 $("form").ligerForm();	
	 		  },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
  	     }else{
   	     $.ligerDialog.warn("GridName 为空");
  		 }
   }
  
   //删除当前行<tr>
        function removerow(obj) {
             var columnid = obj.id;
              var formid = $("#formid").val();
             alert(columnid);
			 $.post(webpath+"/st/system/action/detail/DetailSetAction_delcolumn.action",{strColumn:columnid,strFormName:formid},
			 function(data){
	 			 if(data.messageBean.checkFlag==MSG_SUCCESS)
			      {
			      	 //刷新grid
			       	  parent.f_grid($("#formid"));
			       	  $("#textTable").html(data.strContent);
			       		
			       	  $.ligerDialog.success(data.messageBean.checkMessage);
			      }else{
			       	  $.ligerDialog.error(data.messageBean.checkMessage);
			      }
	 			  $("form").ligerForm();
	 		  },"json").error(function(){$.ligerDialog.error(MSG_LOAD_FALL)});
  	     }

      
      