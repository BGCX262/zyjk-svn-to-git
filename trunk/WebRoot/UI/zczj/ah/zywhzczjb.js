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
         	  if($("#zcsj").val()==""||$("#enuditcode").val()==""){
         	    $.ligerDialog.error("有未填数据项");
         	  }else{
         	  	
         	    $("#subButton").attr("disabled", true);
         	    $("#zcButton").attr("disabled", true);
         	   
         	  	$("#bak1").val("1");
		      $.post(actionurl,$("form:first").serialize(),function(data){
		        $("#subButton").removeAttr('disabled'); 
		         $("#zcButton").removeAttr('disabled');
		      if(data.checkFlag==MSG_SUCCESS)
			  {
			     //  parent.f_search();	
			     	 actionurl=webpath+"/UI/action/zyjk/ZczjAction_insert.action";  
			     	  $("#sysno").val("");   	       	  			  
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
	          
	       }
	       
	        
	    function getResult(){
    		    	
	    	var arr = document.getElementsByTagName('input');
	    	var objs;
            var hgcount=0;
	    	var bhgcount=0;
            var i=0;
            for(var n=0;n<arr.length;n++){
            //alert("value:"+arr[n].value);
                if(arr[n].type=='radio'&&arr[n].checked==true&&arr[n].value==1){
                  hgcount++;           
                }else if(arr[n].type=='radio'&&arr[n].checked==true&&arr[n].value==2){
                  bhgcount++;           
                }
            
            }
	    	//var objs=document.getElementsByTagName("select");
	    	//var hgcount=0;
	    	//var bhgcount=0;
	    	//for(var i=0;i<objs.length;i++){
	    		//var obj=objs[i];
	    		//var val=obj.value;
	    		//alert(val);
	    		//if(val==1){
	    			//hgcount++;
	    		//}else if(val==2){
	    			//bhgcount++;
	    		//}
	    	//}
	    	document.getElementById("hgx").value=hgcount;
	    	document.getElementById("bhgx").value=bhgcount;
	    	var str_percent = Math.round( hgcount / 60 *100);
	    	document.getElementById("hgl").value=str_percent;
	    	//alert("合格："+hgcount+"不合格："+bhgcount);
	    }
         
     
        $(function () {
        try {
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
                                    columntree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree");
                            }
		
                   		},
                   		onClick:function(node){
                   		    $("#ditcode").val(node.data.id);
                   		}
                   	
                       
                    }
            });
         
          var  columntree = colselect.tree.ligerGetTreeManager();
           //var columntree  =colselect.grid.ligerGetGridManager(); 
        	    
        	    
        	    var method = $("#method").val();	
        	   // var bak1 = $("#bak1").val();	
	            if(method=="add"){
	            	var bak1=$("#bak1").val();
			     	  if(bak1=="2"){
			         	    actionurl=webpath+"/UI/action/zyjk/ZczjAction_update.action";
			         	  }else{
			         		actionurl=webpath+"/UI/action/zyjk/ZczjAction_insert.action";  	
			         		
			         	}
	            }else if(method=="look"){
				  $("#subButton").hide();
				  $("#zcButton").hide();
				}else if(method=="update"){
					var bak1=$("#bak1").val();
			     	  if(bak1=="2"){
			         	    actionurl=webpath+"/UI/action/zyjk/ZczjAction_update.action";
			         	  }else{
			         		actionurl=webpath+"/UI/action/zyjk/ZczjAction_update.action";	
			         		
			         	}
				} 
				
	         
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
        
     function zc(){
     	
     	$("#subButton").attr("disabled", true);
     	$("#zcButton").attr("disabled", true);
     	
         $("#bak1").val("2");		
	    $.post(actionurl,$("form:first").serialize(),function(data){
		        $("#subButton").removeAttr('disabled'); 
		        $("#zcButton").removeAttr('disabled'); 
		      if(data.checkFlag==MSG_SUCCESS)
			  {
			     //  parent.f_search();	
			     	$("#sysno").val(data.widgetName);	
			     	 actionurl=webpath+"/UI/action/zyjk/ZczjAction_update.action";       	  			  
			       $.ligerDialog.success(data.checkMessage);
			       
			      // top.tab.refresh(top.tab.getSelectedTabItemID());	
			   }else{
			       $.ligerDialog.error(data.checkMessage);
			   }
				},"json").error(function() { 
				$("#subButton").removeAttr('disabled'); 
				$.ligerDialog.error(MSG_LOAD_FALL);
				});
     }   
  
        
        
        