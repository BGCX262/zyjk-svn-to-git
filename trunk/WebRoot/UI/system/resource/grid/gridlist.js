  /*********************************************************************
 *<p>处理内容：GRID list js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.14---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
 
 var tree =null;
 var menu=null;
 var actionurl = null;
 var columntree = null; 
 var colselect =null;
 var grid = null;
 var strWhere = "";
 
 var openWidth="770";
var openHeight="470";
 $(function (){
  try {	  
   $("#layout").ligerLayout({leftWidth: 265});
   $("#accordion1").ligerAccordion({ height:560});
   
   /*清空*/
   $("#reset").click();
   
   /*提交*/
   $("#subButton").click(function(){
   	f_submit()});
   
     /*添加字段*/
   $("#creatsql").click(function(){
   var gridname = $("#gridname").val();
   if(gridname!=null&&gridname!="")
   {
	   f_addg();
   }else{
   	     $.ligerDialog.warn("GridName 为空");
   }
   	 	});
   	/*创建sql*/
   $("#addsql").click(function(){
   var gridname = $("#gridname").val();
   if(gridname!=null&&gridname!="")
   {
	   f_columnsql();
   }else{
   	     $.ligerDialog.warn("GridName 为空");
   }
   	
   	
   	});
    //右键菜单
             menu = $.ligerMenu({ top: 100, left: 100, width: 120, items:
            [{ text: '删除', click: f_removes, icon: 'delete' },
             { text: '创建页面', click: f_create, icon: 'archives' }
            ]});
             
   $("#tree").ligerTree({         
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PTGridTree',
                idFieldName :'id',
                parentIDFieldName :'pid', 
                nodeWidth : 200,
                checkbox: false,
                slide: false,                        
                onSelect: function (node)
                {                       
                   var nodeid=node.data.id;         
                   f_grid(nodeid);
                },onContextmenu: function (node, e)
                { 
                    actionNodeID = node.data.text;
                    menu.show({ top: e.pageY, left: e.pageX });
                    return false;
                }
            });
    
    tree = $("#tree").ligerGetTreeManager(); 
           
          /*表格selcet树*/
          $("#tableid").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:true,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PTableTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                       
                       		var nodeid=node.data.id;  
                       		f_getColumn(nodeid);
                   		}
                       
                    }
            });
            
       /*grid*/
       $.post(webpath+"/st/system/action/table/table_getColumn.action",{key:"GridColumnTable"},function(data){
	 		 grid = $("#mainGrid").ligerGrid({ checkbox: true, 
			 columns:data,pageSizeOptions:[15,20,30,40,50], 
			 parms:{"strWhere":strWhere},
			 dataAction: 'server',url: webpath+"/st/system/action/grid/Grid_findList.action?strSysno=GridColumnTable",
			 width: '99%',height:'94%',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :true,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			 pageSize:15, enabledEdit: true,clickToEdit: false, isScroll: true,
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 },
			 toolbar: { 
                    items: [
                        { text: '新建', click:f_addNewRow,icon: 'add' },
                        { line: true },
                        { text: '修改', click:f_fab,icon: 'modify' },
                        { line: true },
                        { text: '删除', click:f_columnrem,icon:'delete' },
                        { line: true },
                        { text: '生成sql', click:f_columnsql,icon:'pager' },
                         { line: true },
                        { text: '升序', click:f_upgrid,icon:'up' },
                         { line: true },
                        { text: '降序', click:f_downgrid,icon:'back' }
                    ]
                }
			});
	 		  },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
       
       	/*字段select树*/
         colselect =$("#columnid").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:true,
                tree: { 
                checkbox: true,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                    }
            });
          columntree  =colselect.tree.ligerGetTreeManager(); 
         
       
      /*表格selcet树*/
          $("#actionname").ligerComboBox({
                width: 500,
                selectBoxWidth: 320,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:true,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=ActionsTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                         nodeWidth : 230,
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                       
                       		var nodeid=node.data.id;  
                       		f_getColumn(nodeid);
                   		}
                       
                    }
            });
           $("form").ligerForm();
       }catch (e) {
         $.ligerDialog.error(e.message);
   }	  
    		
 });          
  
  /*联动取得column*/
  function f_getColumn(nodeid)
  {
  	 if(nodeid!=""){
  	    strWhere =" where tableid='"+nodeid+"'";
  	 	columntree.clear();
		columntree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PTableColumnTree', {strWhere:strWhere});
     } 
  }
      
 
  /*添加字段*/
  function f_addg(){
  
  	 var table = $("#tableid").val();
  	 var column   = $("#columnid").val();
  	 var grid = $("#gridid").val();
  	 if(grid==""||column=="")
  	 {
  	 	  $.ligerDialog.warn("先添加必要信息");
  	 }
  	 else{
      $.post(webpath+"/st/system/action/grid/GridColumnAction_insertAll.action",{strTableName:table,strGridid:grid,strColumnName:column},function(data){
			 if(data.checkFlag==MSG_SUCCESS)
			 {
			   f_serch(grid);
			   $.ligerDialog.success(data.checkMessage);
			 }else{
			      $.ligerDialog.error(data.checkMessage);
			 }
		},"json").error(function() { 
					$.ligerDialog.error(MSG_LOAD_FALL);
		});
  	}
  }
  
  
  /*提交*/         
  function f_submit(){
    
      var sysid = $("#gridid").val();	
	            if(sysid==null||sysid==""){
	              actionurl=webpath+"/st/system/action/grid/GridAction_insert.action";
	            }else {
				   actionurl=webpath+"/st/system/action/grid/GridAction_update.action";
				} 
	     $("#subButton").attr("disabled", true);
		 $.post(actionurl,$("form:first").serialize(),function(data){
		 $("#subButton").removeAttr('disabled'); 
			 if(data.checkFlag==MSG_SUCCESS)
			 {
			 	  tree.clear();
			 	  tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"PTGridTree"});
			 
			   $.ligerDialog.success(data.checkMessage);
			 }else{
			      $.ligerDialog.error(data.checkMessage);
			 }
		},"json").error(function() { 
					 $("#subButton").removeAttr('disabled'); 
					$.ligerDialog.error(MSG_LOAD_FALL);
		});
	   $("form").ligerForm();						
				
  }          
  
 /*Grid删除*/
        function f_removes(){ 
        try {
            var node = tree.getSelected();   	         
	       if (node==null||node.data.id==1) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{	           
	           $.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state)
		         {
		          if(state)
		          {    
		          	   var strId = node.data.id;
				       $.post(webpath+"/st/system/action/grid/GridAction_delete.action",{strSysno:strId},function(data){
	
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {	 
				       	    tree.clear();
			 	 		    tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"PTGridTree"});  
				       	  	$.ligerDialog.success(data.checkMessage);
				       	  }else{
				       	    $.ligerDialog.error(data.checkMessage);
				       	  }
			 		  },"json");
		 		  }
		 		  });		 		  
	       }		  
        }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
        }
  
 /*TREE查看*/
        function f_grid(nodeid){
        try {
	      	  if (nodeid==null||nodeid==1) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       		}else{
	       			
					$.post(webpath+"/st/system/action/grid/GridAction_findByKey.action",{strSysno:nodeid},function(data){
				       	  if(data.messageBean.checkFlag==MSG_SUCCESS)
				       	  {
							  var obj = data.ptgridBean;	
							  $.each( obj, function(i, n){
 								 var sname = "#"+i;
 								 $(sname).val(n);
							 });	
			       	   
			       	       var strWhere = " ";           
			       	     
           				   if(nodeid.length>0){          
             			       strWhere = " and gridname = '"+nodeid+"'";  
            				 }
							//初始化查询起始页
	             			var manager = $("#mainGrid").ligerGetGridManager(); 
	            		    manager.set("newPage",1);
	 						 //初始化查询条件
	            			manager.set("parms",{"strWhere":strWhere});
	       		 			manager.loadData(true);         
				       	  }else{
				       	    $.ligerDialog.error(data.messageBean.checkMessage);
				       	  }
			 		  },"json");
					 
			    }
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
    				
        }
 /*创建页面*/
   function f_create(){
   try {
            var node = tree.getSelected();   	         
	       if (node==null) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{	           
		          	   var strId = node.data.id;
				       $.post(webpath+"/st/system/action/grid/GridAction_creatJsp.action",{strSysno:strId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {	 
				       	  	$.ligerDialog.success(data.checkMessage);
				       	  }else{
				       	    $.ligerDialog.error(data.checkMessage);
				       	  }
			 		  },"json");
		 		
		 			 		  
	       }		  
        }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
   }     
        
 /*grid查询*/
   function f_serch(nodeid){      
      if(nodeid.length>0){          
            strWhere = " and gridname = '"+nodeid+"'";         
       		grid.loadServerData({strWhere:strWhere},function (countmain){       	
        		 alert(countmain);});
		}else{
			 $.ligerDialog.error(data.messageBean.checkMessage);
		}
  }
  
  
  /**********************GridColumn********************************************/
  /*column 删除*/
   function f_columnrem()
    {
        	try {
        	 var strId ="''";
			       var manager = $("#mainGrid").ligerGetGridManager(); 
			       var selected = manager.getSelectedRows(); 
			   if (selected==null||selected.length == 0) {
			             $.ligerDialog.warn(MSG_NORECORD_SELECT);
			   }else{
		         $.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state)
		         {
		          if(state)
		          {
			           for(var i=0;i<selected.length;i++){
				        	strId = strId+",'"+selected[i].sysid+"'";
				       } 
				       $.post(webpath+"/st/system/action/grid/GridColumnAction_delete.action",{strSysno:strId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	  	f_serch($("#gridid").val());
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
  
  /*column 增加行*/  
     function f_addNewRow()
        {
           try {
           var gridname = $("#gridname").val();
            if (gridname==null||gridname.length == 0) {
			             $.ligerDialog.warn("请先填写gridname");
			 	return;
			 }
		      myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/grid/GridColumnAction_findByKey.action?messageBean.method=add&strSysno="+gridname,  width: openWidth,height:openHeight, title: 'DEMO编辑',
		      showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
		  	}catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
        } 

  /*column 修改行*/
    function f_fab(){
    	try {
		       var manager = $("#mainGrid").ligerGetGridManager(); 
		       var selected = manager.getSelectedRow(); 
			   if (selected==null||selected.length == 0) {
			           $.ligerDialog.warn(MSG_NORECORD_SELECT);
			    }else{
					myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/grid/GridColumnAction_findByKey.action?messageBean.method=update&strSysno="+selected.sysid, width: openWidth,height:openHeight, title: 'COLUMN编辑',
			    	showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			    }
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
    		
    }
  
  /*column 生成sql*/  
   function f_columnsql(){
   var sysid = $("#gridid").val();	
   if(sysid!=null&&sysid!=""){
      $.post(webpath+"/st/system/action/grid/GridAction_createSQL.action",{strSysno:sysid},function(data){
			 if(data.checkFlag==MSG_SUCCESS)
			 {
			   $("#sqlstr").val(data.method);
			   $.ligerDialog.success(data.checkMessage);
			 }else{
			      $.ligerDialog.error(data.checkMessage);
			 }
		},"json").error(function() { 
					$.ligerDialog.error(MSG_LOAD_FALL);
		});
     }
     }
   
  /*column 提交*/
   function f_columnupdate()
    {
        	try {
        	 var strId ="''";
			       var manager = $("#mainGrid").ligerGetGridManager(); 
			       var selected = manager.getSelectedRows(); 
			   if (selected==null||selected.length == 0) {
			             $.ligerDialog.warn(MSG_NORECORD_SELECT);
			   }else{
		         $.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state)
		         {
		          if(state)
		          {
			           for(var i=0;i<selected.length;i++){
				        	strId = strId+",'"+selected[i].customerid+"'";
				       } 
				       $.post(webpath+"/st/system/action/grid/GridColumnAction_delete.action",{strSysno:strId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	  	f_serch($("#gridid").val());
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
        
        /*升序*/
       function f_upgrid(){
       	try {
        	  var manager = $("#mainGrid").ligerGetGridManager(); 
		       var selected = manager.getSelectedRow(); 
			   if (selected==null||selected.length == 0) {
			           $.ligerDialog.warn(MSG_NORECORD_SELECT);
			    }else{
			          strId = selected.sysid;
				       $.post(webpath+"/st/system/action/grid/GridColumnAction_order.action",{strSysno:strId,strOrder:'up'},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	  	f_serch($("#gridid").val());
				       	  	$.ligerDialog.success(data.checkMessage);
				       	  }else{
				       	    $.ligerDialog.error(data.checkMessage);
				       	  }
			 		  },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
		 		  }
	 		}catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
    		
       
       } 
       
       
       /*降序*/
       function f_downgrid(){
  		 try {
        	  var manager = $("#mainGrid").ligerGetGridManager(); 
		       var selected = manager.getSelectedRow(); 
			   if (selected==null||selected.length == 0) {
			           $.ligerDialog.warn(MSG_NORECORD_SELECT);
			    }else{
			          strId = selected.sysid;
				       $.post(webpath+"/st/system/action/grid/GridColumnAction_order.action",{strSysno:strId,strOrder:'down'},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	  	f_serch($("#gridid").val());
				       	  	$.ligerDialog.success(data.checkMessage);
				       	  }else{
				       	    $.ligerDialog.error(data.checkMessage);
				       	  }
			 		  },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
		 		  }
	 		}catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
       } 
       
