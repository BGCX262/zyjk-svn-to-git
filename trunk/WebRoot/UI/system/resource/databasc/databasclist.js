/*********************************************************************
 *<p>处理内容：databasc list js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.14---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
 
 var tree =null;
 var menu=null;

      
 $(function (){
		try {	  
		
	  //布局
        $("#layout").ligerLayout({leftWidth: 265 ,topHeight:25});
	  //menuBar	 
       $("#menubar").ligerToolBar({ items: [
                          { text: '初始化结构', click: f_initData },
          				  { text: '执行sql', click: f_runSQL },
          				  { line: true },
          				  { text: 'toSQLSERVER', click: f_tosqlserver },
          				  { text: 'toMySQL', click: f_tomysql }
                    ]
            });
      //树形tree
      $("#tree").ligerTree({         
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PTableTree',
                idFieldName :'id',
                parentIDFieldName :'pid', 
                nodeWidth : 200,
                checkbox: false,
                slide: false,                        
                onSelect: function (node)
                {                       
                       var nodeid=node.data.id;         
                       f_grid(nodeid);
                 },
               onContextmenu: function (node, e)
                 { 
                    actionNodeID = node.data.text;
                    menu.show({ top: e.pageY, left: e.pageX });
                    return false;
                 }
            });
        tree = $("#tree").ligerGetTreeManager(); 
        
        /*GRID*/
        $.post(webpath+"/st/system/action/table/table_getColumn.action",{key:"DisctionaryGrid"},function(data){
	 		 grid = $("#mainGrid").ligerGrid({ checkbox: true, 
			 columns:data,pageSizeOptions:[15,20,30,40,50], 
			 rownumbers:true,parms:"",
			 dataAction: 'server',url:  webpath+"/st/system/action/grid/Grid_findList.action?strSysno=DisctionaryGrid",
			 width: '100%',height:'100%',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :false,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			 pageSize:10,
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 }
	 		  },"json");
	 		});
             
             tree = $("#tree").ligerGetTreeManager(); 
            
             //右键菜单
            menu = $.ligerMenu({ top: 100, left: 100, width: 120, items:
            [
            { text: '更新结构', click: f_update,  icon: 'add' },
            { text: 'CreatBean', click: f_init, icon: 'modify' },
            ]});   
    		 }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}	  
 		});          
            
  /*初始化数据结构*/         
  function f_initData(){
  	$.post(webpath+"/st/system/action/databasc/DataBasc_initDataBasc.action",function(data){
  		if(data.checkFlag==MSG_SUCCESS){
  		tree.clear();
		tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"PTableTree"});  
			    $.ligerDialog.success(data.checkMessage);
			 }else{
			     $.ligerDialog.error(data.checkMessage);
			 }
  	},"json")
  
  }       
  
  /*向sqlserver移植数据*/         
  function f_tosqlserver(){
  	$.post(webpath+"/st/system/action/databasc/DataTransp_initDataBasc.action",function(data){
  		if(data.checkFlag==MSG_SUCCESS){
  		tree.clear();
		tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"PTableTree"});  
			    $.ligerDialog.success(data.checkMessage);
			 }else{
			     $.ligerDialog.error(data.checkMessage);
			 }
  	},"json")
  
  } 
  /*向mysql移植数据*/ 
  function f_tomysql(){
     $.post(webpath+"/st/system/action/databasc/DataTransp_initMysqlDataBasc.action",function(data){
  		if(data.checkFlag==MSG_SUCCESS){
  		tree.clear();
		tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"PTableTree"});  
			    $.ligerDialog.success(data.checkMessage);
			 }else{
			     $.ligerDialog.error(data.checkMessage);
			 }
  	},"json")
     
  }
        
        /*执行sql*/    
  function f_runSQL(){
  
  
  }    
  
  
  /*更改数据结构*/         
  function f_update(){
    
     var node = tree.getSelected(); 
     var text = node.data.text;
     if(node==null&&selected==null){
	        $.ligerDialog.warn(MSG_NORECORD_SELECT);
	  }else{
	  	$.post(webpath+"/st/system/action/databasc/DataBasc_initDataBasc.action?strTableName="+text,function(data){
	  		if(data.checkFlag==MSG_SUCCESS){
				    $.ligerDialog.success(data.checkMessage);
				 }else{
				     $.ligerDialog.error(data.checkMessage);
				 }
	  	},"json")
    }
  }          
  
  
  /*初始化对象*/         
  function f_init(){
    
     var node = tree.getSelected(); 
     var text = node.data.text;
     if(node==null){
	        $.ligerDialog.warn(MSG_NORECORD_SELECT);
	  }else{
	  var path = $("#beanpath").val();
	  if(path==null)
	  {
	  	$.ligerDialog.warn("路径不能为空");
	  }

	  	$.post(webpath+"/st/system/action/databasc/DataBasc_creatBean.action?strTableName="+text+"&strBeanPath="+path,function(data){
	  		if(data.checkFlag==MSG_SUCCESS){
				    $.ligerDialog.success(data.checkMessage);
				 }else{
				     $.ligerDialog.error(data.checkMessage);
				 }
	  	},"json")
    }
  }        
  
 /*查看*/
        function f_grid(nodeid){
        try{           
          var strWhere = " ";           
             if(nodeid.length>0){          
                 strWhere = " and tableid = '"+nodeid+"'";  
             }         
       		//初始化查询起始页
	             grid.set("newPage",1);
	 			 //初始化查询条件
	             grid.set("parms",{"strWhere":strWhere});
	       		 grid.loadData(true);
        }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
    				
        } 
  
        