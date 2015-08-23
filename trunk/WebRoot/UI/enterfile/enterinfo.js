/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-22    孙雁斌           新規作成 ;
 ****************************************************/
var actionurl;
var openWidth="980";
var openHeight="650";

         /* 提交*/
         function submitHandler() {
             if($("#distcode").val()=="01"){
                    $.ligerDialog.error("请正确选择行政区划！");
             }else{
                 $("#subButton").attr("disabled", true);
		         $.post(actionurl,$("form:first").serialize(),function(data){
		         $("#subButton").removeAttr('disabled'); 
		         if(data.checkFlag==MSG_SUCCESS)
			     {
			       $.ligerDialog.success(data.checkMessage); 	
			       top.tab.reload(top.tab.getSelectedTabItemID());
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
             if(method=="add"){
               actionurl=webpath+"UI/action/enterfile/EnterMain_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
               $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"UI/action/enterfile/EnterMain_update.action";
             } 
         
         	 var colselect =$("#enuditcode").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:false,
                tree: {
                data:[{id:'01',pid:'0',children:[],text:'行政区划',isexpand:'false'}], 
                //url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree', 
                        checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onBeforeExpand: function (node)
                    	{                                              		
                       		 if(node.data.children && node.data.children.length == 0){
                                   var strWhere="";
                       		 		//alert(node.data.depth);
                       		 		if(node.data.depth=='2'){
                       		 			strWhere=" and code like '"+node.data.id.substring(0, 6)+"%' and depth=3 ";
                       		 			columntree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EDistCodeTree",{"strWhere":strWhere});
                       		 		
                       		 		}else if(node.data.depth=='3'){
                       		 			strWhere=" and code like '"+node.data.id.substring(0, 9)+"%' and depth=4 ";
                       		 			//alert(strWhere);
                       		 			columntree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EDistCodeTree",{"strWhere":strWhere});
                       		 		}else{
                                    	columntree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EDistCodeTree",{"strWhere":" and Depth in (1,2) "});
                       		 		}
                            }
		
                   		},
                   		onClick:function(node){
                   		    $("#distcode").val(node.data.id);
                   		}
                   	
                       
                    }
            });
         
          var  columntree = colselect.tree.ligerGetTreeManager();
           //var columntree  =colselect.grid.ligerGetGridManager(); 
           
          $("#hyflname").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 250, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=HYFLTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                                              		
                       		$("#hyfl").val(node.data.id);
                   		}
                       
                    }
            });
          $("#whysname").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 250, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=WHYSTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                                              		
                       		$("#whysname").val(node.data.text);
                       		$("#whys").val(node.data.id);
                   		}
                       
                    }
            });  
             
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
      //           top.myWindow.close(); 
            top.$.ligerDialog.close(); 
			top.$.ligerDialog.hide();   
            });
            
            
          
          /*验证样式提交*/
          var v = Form();
          $("form").ligerForm();
             
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
                $.ligerDialog.error(e.message);
       }
        }); 