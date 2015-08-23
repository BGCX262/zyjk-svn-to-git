/*********************************************************************
 *<p>处理内容：枚举列表js</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.19---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
      var maintree=null;
      var detailtree=null;
      var openWidth="630";
      var openHeight="300";
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
                        { text: '新建', click:grid_add,icon: 'add' },
                        { line: true },
                        { text: '修改', click:grid_modi,icon: 'modify' },
                        { line: true },
                        { text: '删除', click:grid_del,icon:'delete' }
                    ];
		grid = Grid("EnumGrid","枚举管理",toolbar);
        
        /*TREE*/
             $("#maintree").ligerTree({         
                data:[{id:'system',pid:'0',children:[],text:'枚举管理',isexpand:'false'}],
                idFieldName :'id',
                parentIDFieldName :'pid', 
                nodeWidth : 200,
                checkbox: false,
                slide: false,                        
                onBeforeExpand: onBeforeExpand,
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
            
            tree = $("#maintree").ligerGetTreeManager(); 
            
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
		function onDblClickRow(data, rowindex, rowobj){
		     
		}
		
       
       /*展开前事件*/
        function onBeforeExpand(node){
            var nodeid=node.data.id;
            if(node.data.children && node.data.children.length == 0){
              tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EnumTree");              
            }  
        }
        
        
        /*左侧树删除方法*/
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
		               
         
				       $.post(webpath+"/st/system/action/enum/enum_delete.action",{strSysno:strId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	  	f_search();				       	   
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
        
        /*左侧树新建方法*/
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
           
		   myWindow = $.ligerDialog.open({ url: webpath+"/st/system/action/enum/enum_findByKey.action?messageBean.method=add",  width: openWidth,height:openHeight, title: '枚举管理',
		   showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
           //f_search();	
		   }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}  
        }
        
        /*左侧树修改方法*/
        function f_update(){ 
         try {
         var node = tree.getSelected(); 

         var parent=tree.getParent(node); 
 	       
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

			myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/enum/enum_findByKey.action?messageBean.method=update&enutype="+strId, width: openWidth,height:openHeight, title: '枚举管理',
		    showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
			//f_search();	
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

            $.post(webpath+"/st/system/action/tree/tree_getTree.action",{strTreeName:"EnumTree",strTreeID:strId},function(data){
             		       	
			      if (node){
			      var nodedata = data
			      //var i=data.length-1;
			      nodes.push(data[0]);			      
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
             $.post(webpath+"/st/system/action/tree/tree_getTree.action",{strTreeName:"EnumTree",strTreeID:strId,isFlag:"leafpoint"},function(data){       	
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
        
        
        /*查看*/
        function t_enter(nodeid){
        try{           
           var strWhere = " ";           
             if(nodeid.length>0){          
                 strWhere = " and enutype = '"+nodeid+"'";  
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
        
        /*右侧grid增加方法*/
        function grid_add(){
        try {
            var node = tree.getSelected();            
            if(node==null){
                $.ligerDialog.warn(MSG_NORECORD_SELECT);
            }else{
                var nodeid=node.data.id;
                myWindow = $.ligerDialog.open({ url: webpath+"/st/system/action/enudetail/enudetail_findByKey.action?messageBean.method=add&ptEnuMainBean.enutype="+nodeid,  width: openWidth,height:openHeight, title: '枚举管理',
		        showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
            } 

          }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}  
        }
         /*右侧grid修改方法*/
        function grid_modi(){
        
        try {
            var node = tree.getSelected(); 
            var nodeid=node.data.id;
 	       
	       var manager = $("#mainGrid").ligerGetGridManager(); 
	       var selected = manager.getSelectedRow(); 
	       
	       var strId;
	       
	       if(selected==null||node==null){
	        $.ligerDialog.warn(MSG_NORECORD_SELECT);	         
	       }else{
	         strId=selected.enuitemvalue;
	       }
	       if (strId==null||strId.length == 0) {
	            $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{
		    alert("strId:"+strId);
			myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/enudetail/enudetail_findByKey.action?messageBean.method=update&strSysno="+strId+"&ptEnuMainBean.enutype="+nodeid, width: openWidth,height:openHeight, title: '菜单管理',
		    showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
			f_search(nodeid);	
		   }
		   }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  } 
            
        
        }
         /*右侧grid删除方法*/
        function grid_del(){
             
            
            try {
            
               var node = tree.getSelected(); 
 	       	   var nodeid=node.data.id;
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
				        	strId = strId+",'"+selected[i].enuitemvalue+"'";
				          }		              
		                 }
         
				       $.post(webpath+"/st/system/action/enudetail/enudetail_delete.action",{strSysno:strId,enutype:nodeid},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	  	 f_search(nodeid);  			       	   
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
        
       /*右侧grid查询*/
	    function f_search(strEnutype)
        {
        	try{
		     	 var strWhere = " and enutype='"+ strEnutype +"'";           
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