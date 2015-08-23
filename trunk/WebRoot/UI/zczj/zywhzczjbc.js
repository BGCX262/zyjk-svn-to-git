/*********************************************************************
 *<p>处理内容：ptdept form js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.6.17---- 孙雁斌--------- 新规作成<br>
 ***********************************************************************/
 
        var actionurl;
        
        /* 提交*/
         function submitHandler() {
         	 // getResult();
	          $("#subButton").attr("disabled", true);
	          $("#bak1").val("3");
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
	    function getResult(){
    	
	   // 	var objs=document.getElementsByTagName("select");
	   // 	var hgcount=0;
	   // 	var bhgcount=0;
	   // 	for(var i=0;i<objs.length;i++){
	    //		var obj=objs[i];
	    //		var val=obj.value;
	    //		//alert(val);
	    //		if(val==1){
	    //			hgcount++;
	    //		}else if(val==2){
	    //			bhgcount++;
	    	//	}
	    	//}
	    	var arr = document.getElementsByTagName('input');
            var hgcount=0;
	    	var bhgcount=0;
            var i=0;
            for(var n=0;n<arr.length;n++){
                if(arr[n].type=='radio' &&arr[n].checked==true&&arr[n].name.indexOf("jdhc")<0&&arr[n].value==1){
                  hgcount++;           
                }else if(arr[n].type=='radio' &&arr[n].checked==true&&arr[n].name.indexOf("jdhc")<0&&arr[n].value==2){
                  bhgcount++;           
                }
            
            }
	    	document.getElementById("hgx").value=hgcount;
	    	document.getElementById("bhgx").value=bhgcount;
	    	var str_percent = Math.round( hgcount / 60 *100);
	    	document.getElementById("hgl").value=str_percent;
	    	//alert("合格："+hgcount+"不合格："+bhgcount);
	    }
        
        
         function getHCResult(){
	    	var arr = document.getElementsByTagName('input');
            var hgcount=0;
	    	var bhgcount=0;
            var i=0;
            for(var n=0;n<arr.length;n++){
                if(arr[n].type=='radio' &&arr[n].checked==true&&arr[n].name.indexOf("jdhc")>0&&arr[n].value==1){
                  hgcount++;           
                }else if(arr[n].type=='radio' &&arr[n].checked==true&&arr[n].name.indexOf("jdhc")>0&&arr[n].value==2){
                  bhgcount++;           
                }
            
            }
	    	document.getElementById("fhgx").value=hgcount;
	    	document.getElementById("fbhgx").value=bhgcount;
	    	var str_percent = Math.round( hgcount / 60 *100);
	    	document.getElementById("fhgl").value=str_percent;
	    	//alert("合格："+hgcount+"不合格："+bhgcount);
	    }
 
        $(function () {
        try {
        	    
        //	    var arr = document.getElementsByTagName('input');
        //      var i=0;
        //      for(var n=0;n<arr.length;n++){
        //        if(arr[n].type=='radio'&&arr[n].name.indexOf("hcyj")<0){
        //          arr[n].disabled="disabled";           
        //        }
        //    }
        	    
        	    
        	    
        	    var method = $("#method").val();	
	            if(method=="add"){
	              actionurl=webpath+"/UI/action/zyjkck/ZczjAction_insert.action";
	            }else if(method=="look"){
				  $("#subButton").hide();
				  $("#colButton").hide();
				}else if(method=="update"){
				   actionurl=webpath+"/UI/action/zyjkck/ZczjAction_update.action";
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
                    	{    if(node.data.children && node.data.children.length == 0){
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
                   				$("#ditcode").val("");
                   				$("#enuditcode").val("");
                   			}else{
                   				$("#ditcode").val(node.data.id);
                   			}
                   		    
                   		}
                   	
                       
                    }
            });
			
			
			  
	        /*关闭按钮*/
	         $("#colButton").click(function () {
					//parent.myWindow.close();
					top.$.ligerDialog.close(); 
					top.$.ligerDialog.hide()    
					//top.$.ligerDialog.close();   
	            });
	         
          var  columntree = colselect.tree.ligerGetTreeManager();
           //var columntree  =colselect.grid.ligerGetGridManager(); 
			
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
        
	            
	         if($("#state").val()=="0"){
               document.getElementById("dwmc").disabled=true;
               //document.getElementById("lxr").disabled=true;
               //document.getElementById("enuditcode").disabled=true;
               //document.getElementById("lxdh").disabled=true;
               //document.getElementById("hcjg").style.display = "none";
               //document.getElementsByName("hcjgc").style.display = "none";
            }
	        
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
     		   $.ligerDialog.error(e.message);
    	  }
        }); 
        
  
        
        
        