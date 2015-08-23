/*********************************************************************
 *<p>处理内容：部门资源列表js</p>
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
	              actionurl=webpath+"/st/system/action/role/deptres_insert.action";
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
                var strOperId=$("#deptid").val();
                if(strOperId.indexOf(",")>0){
                      var limit=strOperId.indexOf(",");
                      strOperId=strOperId.substring(0,limit);
                 }   
               /*TREE*/              
               $("#tree").ligerTree({         
                     //data:[{id:'1',pid:'0',children:[],text:'资源列表',isexpand:'true'}],
                     url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=PtDeptResTree&strTreeID="+strOperId,
                     idFieldName :'id',
                     parentIDFieldName :'pid', 
                     nodeWidth : 200,
                     checkbox: true,
                     slide: false,                        
                   //  onExpand:onExpand,
                     onSelect: function (node)
                     {                       
                       var nodeid=node.data.id;                                                            
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
                     var strDeptid=$("#deptid").val();
                     /*提交增加方法*/
                      $.post(actionurl,{strSysno:strroletext,strDeptid:strDeptid},function(data){
				       	   if(data.checkFlag==MSG_SUCCESS)
				       	   {
				       	       var strDeptid=$("#deptid").val();  	   
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
               
 