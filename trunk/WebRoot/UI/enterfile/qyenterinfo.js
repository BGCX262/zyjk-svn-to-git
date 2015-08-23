/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-19    孙雁斌           新規作成 ;
 ****************************************************/
var actionurl;
var openWidth="980";
var openHeight="650";

         /* 提交*/
         function submitHandler() {
 
         		 if($("#gszch").val()==""){
		            $.ligerDialog.warn("工商注册号不能为空！");		         
		         }else if($("#zhuguan").val()==""){		         
		              $.ligerDialog.warn("主管单位不能为空！");
		         }else if($("#zzjgdm").val()==""){
		         
		              $.ligerDialog.warn("组织机构代码不能为空！");
		         }else if($("#distcode").val()==""){
		               $.ligerDialog.warn("行政区划不能为空！");
		          } else if($("#distcode").val()=="01"||$("#distcode").val()=="370200000000"){
                    $.ligerDialog.warn("请正确选择具体的行政区划！");
	             }else{
	                 $("#subButton").attr("disabled", true);
			      $.post(actionurl,$("form:first").serialize(),function(data){
			      $("#subButton").removeAttr('disabled'); 
			      if(data.checkFlag==MSG_SUCCESS)
				  {
				  		 parent.flag.value='2';	
				  		 parent.mainkey.value=data.widgetValue;	
				  		 	  		 
				  		 actionurl=webpath+"UI/action/enter/EnterMain_update.action";
				  		 $("#enterno").val(data.widgetValue);
				       $.ligerDialog.success(data.checkMessage); 	
				   }else{
				       	$.ligerDialog.error(data.checkMessage);
				   }
					},"json").error(function() { 
					$("#subButton").removeAttr('disabled'); 
					$.ligerDialog.error(MSG_LOAD_FALL);
					});
	             
	             }
	         
		          
		       } 
         /*修改表格*/
         function editCorp(){
             var method=parent.isMethod();

              if(method=="add"){
                  window.location.href=webpath+"/UI/action/enter/EnterMain_editByKey.action?messageBean.method=add&strSysno="+$("#strSysno").val(); 
              }else if(method=="update"){
                  window.location.href=webpath+"/UI/action/enter/EnterMain_editByKey.action?messageBean.method=update&strSysno="+$("#strSysno").val();
              }
         }
        /*当主管单位选其他时增加input框*/
        function addTd(_obj){
          if(_obj.value=="05"){
            document.getElementById("othertype").style.display="block"; 
          }
        }
 
        $(function () {
        try {
        
           /*主管单位类型如为05，则隐藏input框*/
           if(document.getElementById("zhuguan").value=="05"){          
              document.getElementById("othertype").style.display="block"; 
           } 
        
             var method = $("#method").val();  
             if(method=="add"){
               /*当从zform.jsp传的showButton参数为1时隐藏提交按钮*/
              var showButton=$("#showButton").val();
              if(showButton=='1'){
                 $("#subButton").hide();
              }
              actionurl=webpath+"UI/action/enter/EnterMain_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
               $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"UI/action/enter/EnterMain_update.action";
             } 
         
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
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=WHYSTree', checkbox: true,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                          
                    		 var data = this.getChecked(); 
                    		 var ids="";
                    		 var nm="";
				            for (var i = 0; i < data.length; i++)
				            {
				                ids+=data[i]['data']['id']+";";
				                nm+=data[i]['data']['text']+";";
				            }                    		
                       		$("#whysname").val(nm);
                       		$("#whys").val(ids);
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
           
         
          
          /*验证样式提交*/
          var v = Form();
          $("form").ligerForm();
             
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
                $.ligerDialog.error(e.message);
       }
        }); 