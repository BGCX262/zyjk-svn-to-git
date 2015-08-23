/****************************************************
 * <p>处理内容：评价报告基本情况</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14    新規作成 ;
 ****************************************************/
 
        var actionurl;
      
		var  _grid ;
       

         /* 提交*/
         function submitHandler() {
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
        
        
        function sss(){
        
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
      
      function bodyload(){
 			var mess=$("#message").val();
           if(mess!=null&&mess!=""&&mess.length>0){
           		alert(mess);
           		top.tab.reload(top.tab.getSelectedTabItemID());
           }
 		}
         
     $(function () {
        
        try {
        	 var colselect =$("#enuditcode").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 400, 
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
                   			if(node.data.id=='01'){
                   				$("#distcode").val("");
                   				$("#enuditcode").val("");
                   			}else{
                   				$("#distcode").val(node.data.id);
                   			}
                   		    
                   		}
                    }
            });
         
          var  columntree = colselect.tree.ligerGetTreeManager();
        
             
             var method = $("#method").val();  
             if(method=="add"){
               actionurl=webpath+"/UI/action/zyjk/JcxmAction_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
                $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"//UI/action/zyjk/JcxmAction_update.action";
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
                 top.$.ligerDialog.close(); 
                 top.$.ligerDialog.hide();       
             });
          
          /*验证样式提交*/
          var v = Form();
          $("form").ligerForm();
          
          $.post(webpath+"/st/system/action/table/table_getColumn.action",{key:'cxqyGrid'},function(data){
	 		_grid = $("#_mainGrid").ligerGrid({checkbox: true,
			 columns:data,pageSizeOptions:[15,20,30,40,50], 
			 rownumbers:true,
			 checkbox: false,
			 //parms:{strWhere:" and dwmc like '%"+name+"%'"},
			 dataAction: 'server',url: webpath+"/st/system/action/grid/Grid_findList.action?strSysno=cxqyGrid",
			 width: '200',height:'350',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :false,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			
			 pageSize:15,
			  onSelectRow:function (data, rowindex, rowobj)
                {      
                       $("#jsdwbh").val(data.enterno);
                       $("#jsdwmc").val(data.dwmc);
                       //$("#sex").val(data.sex);
                     
                      document.getElementById("_mainGrid").style.display="none";
                },
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 }
			 
			});
			document.getElementById("_mainGrid").style.display="none";
			if(_grid!=null)
			{
				return _grid;
		    }
	 		},"json").error(function() { 
				$.ligerDialog.error(MSG_LOAD_FALL)});
             
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
                $.ligerDialog.error(e.message);
       }
        }); 
        
     function getEnterinfo(name){
     	document.getElementById("_mainGrid").style.display="";
	     	try{           
	     	var strWhere = " ";           
	        if(name.length>0){          
	            strWhere = " and dwmc like '%"+name+"%'";  
	        }         
	        var manager = $("#_mainGrid").ligerGetGridManager();  
	        //初始化查询起始页
	         manager.set("newPage",1);
	         //初始化查询条件
	         manager.set("parms",{"strWhere":strWhere});
	         manager.loadData(true);
	   }catch (e) {
	           $.ligerDialog.error(e.message);
	    }
     }    
    
 function uploadImage() {
				document.getElementById("form").action=actionurl;

                document.getElementById("form").submit();
            	
		}       