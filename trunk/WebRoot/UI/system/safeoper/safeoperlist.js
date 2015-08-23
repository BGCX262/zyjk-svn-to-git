/*********************************************************************
 *<p>处理内容：safeoper列表js</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.21---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
      var grid = null;
      var tree = null;
      var myWindow = null;
      var menu=null;
      var openWidth="630";
      var openHeight="500";
      
       /*初始化*/
	 $(function (){
		try {	
	      /*布局*/
	   $("#layout").ligerLayout({leftWidth: 200});
		 /*查询按钮*/	   
	   $("#searchButton").click(function(){
		   		f_search();
		   });
	  /*GRID*/ 
	  var toolbar =  [
                        { text: '新建', click:f_add,icon: 'add' },
                        { line: true },
                        { text: '修改', click:f_update,icon: 'modify' },
                        { line: true },
                        { text: '删除', click:f_remove,icon:'delete' },
                        { line: true },
                        { text: '查看', click:f_look,  icon:'pager' },
                        { line: true },
                        { text: '人员授权', click:f_grant,  icon:'msn' }
                    ];
		grid = Grid("SafeOperGrid","人员管理",toolbar);
		
		/*TREE*/       
        $("#tree").ligerTree({         
                   data:[{id:'1',pid:'0',children:[],text:'部门列表',isexpand:'false'}],
                   idFieldName :'id',
                   parentIDFieldName :'pid', 
                   nodeWidth : 200,
                   checkbox: false,
                   slide: false,                        
                   onBeforeExpand: onBeforeExpand,
                   onExpand:onExpand,
                   onSelect: function (node)
                   {                       
                       var nodeid=node.data.id;                                     
                       t_enter(nodeid);
                   }
            });
            
            tree = $("#tree").ligerGetTreeManager(); 

	 	}catch (e) {
     		   $.ligerDialog.error(e.message);
    		}	  
	  });   
		
		/*双击事件*/
		function onDblClickRow(data, rowindex, rowobj){
		     try {
				 myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/safeoper/safeoper_findByKey.action?messageBean.method=look&strSysno="+data.sysno, width: openWidth,height:openHeight, title: '人员管理',
				 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			 }catch (e) {
	     		  $.ligerDialog.error(e.message);
	    	 }
		}
             
          function onBeforeExpand(node){
               
          }
          /*展开事件*/
          function onExpand(node){
               var nodeid=node.data.id;
               if(node.data.children && node.data.children.length == 0){
               tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=PtdeptTree");
              }  
          }
                 
          /*查看*/
          function t_enter(nodeid){
             try{           
                  var strWhere = " ";           
                  if(nodeid.length>0){          
                      strWhere = " and deptid = '"+nodeid+"'";  
                  }         
       		      //初始化查询起始页
	             var manager = $("#mainGrid").ligerGetGridManager(); 
	             manager.set("newPage",1);
	 			 //初始化查询条件
	             manager.set("parms",{"strWhere":strWhere});
	       		 manager.loadData(true);
            }catch (e) {
     		      $.ligerDialog.error(e.message);
    		}    				
        } 
        
          /*查询*/
	      function f_search()
          {
        	try{
		     	 var strWhere = " ";           
	       		 //初始化查询起始页
	             var manager = $("#mainGrid").ligerGetGridManager(); 
	             manager.set("newPage",1);
	 			 //初始化查询条件
	             manager.set("parms",{"strWhere":strWhere});
	       		 manager.loadData(true);
       		}catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
        }
        
         /*删除*/
          function f_remove(){ 
          try {
         	       	
                var strId ="''";
	            var manager = $("#mainGrid").ligerGetGridManager(); 
	            var selected = manager.getSelectedRows(); 	       	         
	            if (selected==null) {
	                $.ligerDialog.warn(MSG_NORECORD_SELECT);
	            }else{	           
	                $.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state)
		        {
		          if(state)
		          {    
		               if(selected!=null&&selected.length>0){		               
		                  for(var i=0;i<selected.length;i++){
				        	strId = strId+",'"+selected[i].sysno+"'";
				          }
		               }
		               
         
				       $.post(webpath+"/st/system/action/safeoper/safeoper_delete.action",{strSysno:strId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	  	//f_search();				       	   
				       	  	$.ligerDialog.success(data.checkMessage);
				       	  }else{
				       	    $.ligerDialog.error(data.checkMessage);
				       	  }
			 		  },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
		 		  }
		 		  });		 		  
	       }		  
        }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
        }
        
        /*新建*/
        function f_add(){
           try {
                var node = tree.getSelected();	       
	            var strId;      
	            if(node==null){
	                  $.ligerDialog.warn(MSG_NORECORD_SELECT);
	            }else{
	                  strId=node.data.id;
	            }
           
		        myWindow = $.ligerDialog.open({ url: webpath+"/st/system/action/safeoper/safeoper_findByKey.action?messageBean.method=add&ptOperBean.deptid="+strId,  width: openWidth,height:openHeight, title: '人员管理',
		        showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
                //f_search();	
		   }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}  
        }
        
        /*修改*/
        function f_update(){ 
         try {
	           var manager = $("#mainGrid").ligerGetGridManager(); 
	           var selected = manager.getSelectedRow();
	           var strId;
	           if(selected==null){
	                $.ligerDialog.warn(MSG_NORECORD_SELECT);
	           }else{
	                strId=selected.sysno;
	           }
	       
	           if (strId==null||strId.length == 0) {
	                $.ligerDialog.warn(MSG_NORECORD_SELECT);
	           }else{
		  
			        myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/safeoper/safeoper_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '人员管理',
		            showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
			       // f_search();	
		       }
		   }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  } 
        } 
        
        /*查看*/
        function f_look()
        {
          try {
		        var manager = $("#mainGrid").ligerGetGridManager(); 
		        var selected = manager.getSelectedRow(); 
			    if (selected==null||selected.length == 0) {
			           $.ligerDialog.warn(MSG_NORECORD_SELECT);
			    }else{
					myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/safeoper/safeoper_findByKey.action?messageBean.method=look&strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '人员管理',
			    	showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			    }
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
        }
        
        /*人员授权*/
        function f_grant(){
             
              try {           
                  var node = tree.getSelected();
	              var strId;
	              var manager = $("#mainGrid").ligerGetGridManager(); 
		          var selected = manager.getSelectedRow(); 	       
	              if(selected==null||selected.length == 0){
	                  $.ligerDialog.warn(MSG_NORECORD_SELECT);
	              }else{
	                  strId=selected.sysno;
	              }
           
		          myWindow = $.ligerDialog.open({ url: webpath+"/st/system/action/ptoper/ptoper_findByKey.action?messageBean.method=add&ptOPerRoleBean.operid="+strId,  width: 300,height:600, title: '人员授权',
		          showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
		   }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}      
        
        }
       
        