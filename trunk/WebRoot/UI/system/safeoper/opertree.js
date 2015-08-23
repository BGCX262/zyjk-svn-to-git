/*********************************************************************
 *<p>处理内容：opertree列表js</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.22---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
      var tree = null;
      var actionurl;
        $(function (){
         try{ 
         
                var method = $("#method").val();	
	            if(method=="add"){
	                actionurl=webpath+"/st/system/action/ptoper/ptoper_insert.action";
	            }
              	        	
	            /*返回信息状态*/
	            var strFlag = $("#flag").val();
	            var strMessage = $("#message").val();
	            if(strFlag==MSG_SUCCESS)
	            {  
			    }else{
			        $.ligerDialog.error(strMessage);
			    }
         
                /*关闭按钮*/
	            $("#colButton").click(function () {
		            parent.myWindow.close();       
	            });
               var strOperId=$("#operid").val();
               if(strOperId.indexOf(",")>0){
               var limit=strOperId.indexOf(",");
                strOperId=strOperId.substring(0,limit);
            }   
                /*TREE*/            
                $("#tree").ligerTree({         
                         //data:[{id:'1',pid:'0',children:[],text:'角色列表',isexpand:'true'}],
                         url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=PtOperTree&strTreeID="+strOperId,
                         idFieldName :'id',
                         parentIDFieldName :'pid', 
                         nodeWidth : 200,
                         checkbox: true,
                         slide: false,                        
                        // onBeforeExpand: onBeforeExpand,
                        // onExpand:onExpand,
                         onSelect: function (node)
                         {                       
                                                             
                         }            
                });
            
                tree = $("#tree").ligerGetTreeManager(); 
                $("#subButton").click(function () {
                  
                      var notes = tree.getChecked();
                      var strroletext = "";
                      for (var i = 0; i < notes.length; i++)
                      {
                         strroletext += notes[i].data.id + ",";
                      }
                 
                      var strRoleId=$("#operid").val();
                      /*提交删除方法*/
                      alert("删除");
                      $.post(webpath+"/st/system/action/ptoper/ptoper_delete.action",{strRoleno:strRoleId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {	       	   
				       	  	$.ligerDialog.success(data.checkMessage);
				       	  }else{
				       	    $.ligerDialog.error(data.checkMessage);
				       	  }
			 		   },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
                      /*提交增加方法*/
                      alert("增加");
                      $.post(actionurl,{strSysno:strroletext,strRoleno:strRoleId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	       var strRoleId=$("#operid").val();
		       	   		       $.ligerDialog.success(data.checkMessage);
				       	  }else{
				       	       $.ligerDialog.error(data.checkMessage);
				       	  }
			 		  },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
		             
	                });
            
            }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}	
   
        });
         
    