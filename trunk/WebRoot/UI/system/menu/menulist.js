/*********************************************************************
 *<p>处理内容：menu列表js</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
      var grid = null;
      var tree = null;
      var myWindow = null;
      var menu=null;
      var openWidth="630";
      var openHeight="300";
      
      /*初始化*/
	 $(function (){
		try {	
	      /*布局*/
	   $("#layout").ligerLayout({leftWidth: 200});		
	  /*GRID*/ 
	  var toolbar =  [
                        { text: '新建', click:f_add,icon: 'add' },
                        { line: true },
                        { text: '修改', click:f_update,icon: 'modify' },
                        { line: true },
                        { text: '删除', click:f_remove,icon:'delete' },
                        { line: true },
                        { text: '查看', click:f_look,  icon:'pager' }
                    ];
		grid = Grid("MenuGrid","菜单管理",toolbar);

	  /*TREE*/
	   $("#tree").ligerTree({         
                data:[{id:'1',pid:'0',children:[],text:'菜单管理',isexpand:'false'}],
                idFieldName :'id',
                parentIDFieldName :'pid', 
                nodeWidth : 200,
                checkbox: false,
                slide: false,                        
                onExpand:onExpand,
                onSelect: function (node)
                    {                       
                       var nodeid=node.data.id;                                      
                       t_enter(nodeid);
                   },
                onContextmenu: function (node, e)
                    { 
                    actionNodeID = node.data.text;
                    menu.show({ top: e.pageY, left: e.pageX });
                    return false;
                    }                 
              
            });
            
            tree = $("#tree").ligerGetTreeManager(); 
            
             /*右键菜单*/
                menu = $.ligerMenu({ top: 100, left: 100, width: 120, items:
            [
            { text: '增加', click: f_add,  icon: 'add' },
            { text: '修改', click: f_update, icon: 'modify' },
            { line: true },
            { text: '删除', click: f_remove, icon: 'delete' }
            ]
              });	
	 	}catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
      
      			  
	  });   
      
      /*双击事件*/
      function onDblClickRow (data, rowindex, rowobj){
		     try {
					myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/menu/menu_findByKey.action?messageBean.method=look&strSysno="+data.menuid, width: openWidth,height:openHeight, title: '菜单管理',
				    showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			  }catch (e) {
	     		    $.ligerDialog.error(e.message);
	    	  }
      }
      

       /*展开事件*/ 
      function onExpand(node){
       var nodeid=node.data.id;
             if(node.data.children && node.data.children.length == 0){
                          var strWhere = " ";                   
                          //strWhere = " where menuid='"+nodeid+"'";  
                          tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=MenuTree");
                      }

       }        
     /*查看*/
        function t_enter(nodeid){
        try{           
          var strWhere = " ";           
             if(nodeid.length>0){          
                 strWhere = " and parentmenuid = '"+nodeid+"' or menuid='"+nodeid+"'";  
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
        
            var node = tree.getSelected(); 
 	       	
           var strId ="''";
	       var manager = $("#mainGrid").ligerGetGridManager(); 
	       var selected = manager.getSelectedRows(); 
	       	         
	       if (selected==null&&node==null) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{	           
	           $.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state)
		         {
		          if(state)
		          {    
		               if(selected!=null&&selected.length>0){
		               
		                  for(var i=0;i<selected.length;i++){
				        	strId = strId+",'"+selected[i].menuid+"'";
				          }
		               }else{
		                  strId = strId+",'"+node.data.id+"'";
		               }
		               
         
				       $.post(webpath+"/st/system/action/menu/menu_delete.action",{strSysno:strId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	  	//f_search();				       	   
				       	  	$.ligerDialog.success(data.checkMessage);
				       	  }else{
				       	    $.ligerDialog.error(data.checkMessage);
				       	  }
			 		  },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
			 		  //去掉节点
			 		  tree.remove(node.target);
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
           var manager = $("#mainGrid").ligerGetGridManager(); 
	       var selected = manager.getSelectedRow(); 
	       
	       var strId;
	       
	       if(node==null&&selected==null){
	        $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else if(selected !=null){
	         strId=selected.menuid;
	       }else{
	         strId=node.data.id;
	       }
           
		   myWindow = $.ligerDialog.open({ url: webpath+"/st/system/action/menu/menu_findByKey.action?messageBean.method=add&ptMenuBean.parentmenuid="+strId,  width: openWidth,height:openHeight, title: '菜单管理',
		   showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
           //f_search();	
		   }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}  
        }
        
        /*修改*/
        function f_update(){ 
         try {
           var node = tree.getSelected();  
	       var manager = $("#mainGrid").ligerGetGridManager(); 
	       var selected = manager.getSelectedRow();  
	       var strId;
	       if(node==null&&selected==null){
	        $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else if(selected !=null){
	         strId=selected.menuid;
	       }else{
	         strId=node.data.id;
	       }
	       if (strId==null||strId.length == 0) {
	            $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{
		  
			myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/menu/menu_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '菜单管理',
		    showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
			//f_search();	
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
					myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/menu/menu_findByKey.action?messageBean.method=look&strSysno="+selected.menuid, width: openWidth,height:openHeight, title: '菜单管理',
			    	showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			    }
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
        }
        
       
        /*增加结点*/ 
        function node_add(strId){
        try{
         var node = tree.getSelected();
          var nodes = [];         
            $.post(webpath+"/st/system/action/tree/tree_getTree.action",{strTreeName:"MenuTree",strTreeID:strId,isFlag:"false"},function(data){
             		       	
			      if (node){
			      var nodedata = data
			      var i=data.length-1;
			  //    alert("length:"+data.length);
			  //    for(var j=0;j<data.length;j++){
			  //      alert(j+":"+data[j].text);
			  //    }
			      nodes.push(data[i]);			      
                  tree.append(node.target, nodes);  
                  }	
			},"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
			}catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
        }
        
         /*修改结点*/
        function node_modi(strId){
          try{
        var node = tree.getSelected(); 
          var nodes = [];     
             $.post(webpath+"/st/system/action/tree/tree_getTree.action",{strTreeName:"MenuTree",strTreeID:strId,isFlag:"true"},function(data){       	
			      if (node){
			      var nodedata = data;
                      tree.update(node.target,data[0]); 
                  }	
	             },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
	       }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
        }