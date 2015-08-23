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
			
			
	        /*返回信息状态*/
	        var strFlag = $("#flag").val();
	        var strMessage = $("#message").val();
	        if(strFlag==MSG_SUCCESS)
	        {  
	        
			 }else{
			    $.ligerDialog.error(strMessage);
			 }
	        /*提交*/
		    $("#subButton").click(function(){
		        alert("123123");
		   			f_submit();
		   	});
	        /*关闭按钮*/
	         $("#colButton").click(function () {
					parent.myWindow.close();       
	            });
	         
	        /*枚举树*/
            $("#enumnmae").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:true,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=MenuTree', checkbox: false,
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
	         
	            $("form").ligerForm();
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
     		   $.ligerDialog.error(e.message);
    	  }
        });  
        
     /*提交*/         
  function f_submit(){
	     actionurl=webpath+"/st/system/action/detail/DetailSetAction_submint.action";
	     alert(actionurl);
	     $("#subButton").attr("disabled", true);
		 $.post(actionurl,$("form:first").serialize(),function(data){
		 $("#subButton").removeAttr('disabled'); 
			 if(data.checkFlag==MSG_SUCCESS)
			 {
			 	  tree.clear();
			 	  tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"FormTree"});
			 
			   $.ligerDialog.success(data.checkMessage);
			 }else{
			      $.ligerDialog.error(data.checkMessage);
			 }
		},"json").error(function() { 
					 $("#subButton").removeAttr('disabled'); 
					$.ligerDialog.error(MSG_LOAD_FALL);
		});
	   $("form").ligerForm();						
				
  }        

      
      