/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-13    孙雁斌           新規作成 ;
 ****************************************************/
var actionurl;
var openWidth="980";
var openHeight="650";

         /* 提交*/
         function submitHandler() {
         var pass=document.all.unitpwd.value;
           if(pass.length>14||pass.length<6)
           {
               $.ligerDialog.error("密码要介于6到14位之间");
           
           }else if(!(document.all.unitpwd.value==document.all.c_pwd.value))
           {
                $.ligerDialog.error("两次输入的密码不一致");
           
           }
           else if($("#distcode").val()=="01")
           {          
               
               $.ligerDialog.error("请正确选择行政区划！");
           }else if(document.getElementById("dept_type").value==""){
               $.ligerDialog.error("请选择注册单位类型！");
           }else{
           
               $("#subButton").attr("disabled", true);
		      $.post(actionurl,$("form:first").serialize(),function(data){
		      $("#subButton").removeAttr('disabled'); 
		       if(data.checkFlag=="1"){
		            
		         	$.ligerDialog.confirm("单位注册成功", function (state)
                       {
                           if(state)
                           {    
                               //此处判断注册成功后的跳转页面
                               //alert(data.widgetValue);
                               //window.location.href=webpath+"index/qymain.jsp?pid=1";
                               //window.location.href=webpath+"qyindex.jsp";
                               window.close();
                           }
                       });    
		        }
		        else{                 
                     $.ligerDialog.error(data.checkMessage);
		        }
				},"json").error(function() { 
				$("#subButton").removeAttr('disabled'); 
				$.ligerDialog.error(MSG_LOAD_FALL);
				});
           }
	          
	       }
	       
	    /* 下拉框选择事件*/
        function onChange(obj){
           var objid=obj.value;
           if(objid=="1"||objid=="2"){
                objid="0205";
           }else if(objid=="3"||objid=="4"){
                 
           }
           if(null!=document.getElementById(objid)){           
              document.getElementById("0205").style.display="block"; 
              document.getElementById("0206").style.display="block"; 
           }else{
              document.getElementById("0205").style.display="none"; 
              document.getElementById("0206").style.display="none"; 
           } 
        }   
	       
	       
	        
 
        $(function () {
        try {
               actionurl=webpath+"/UI/action/register/EnterMain_insert.action";

         
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
           //var columntree  =colselect.grid.ligerGetGridManager(); 
         
             
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