/*********************************************************************
 *<p>处理内容：actions list js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.14---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
 
 var tree =null;
 var menu=null;
 var actionurl = null;
var grid =null;
 $(function (){
		try {	  
   $("#layout").ligerLayout({leftWidth: 250});
   $("form").ligerForm();
   
   /*清空*/
   $("#reset").click();
   
   /*提交*/
   $("#subButton").click(function(){
   	f_submit()});
   
   /*init*/
   $("#initButton").click(function(){
   	f_init()});
   	
    /*GRID*/ 
		grid = Grid("ActionGrid","菜单");
   
   
   
   $("#tree").ligerTree({         
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=ActionsTree',
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
             
             //右键菜单
             menu = $.ligerMenu({ top: 100, left: 100, width: 120, items:
            [{ text: '删除', click: f_remove, icon: 'delete' },
             { text: '创建ACTION', click: f_screate, icon: 'add' } ]});
             
     }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}	  
 });          
            

   /*表格selcet树*/
          $("#beanname").ligerComboBox({
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
                    }
            });
  
  
  	/*双击事件*/
		function onDblClickRow(data, rowindex, rowobj){
		     try {
			  }catch (e) {
	     		    $.ligerDialog.error(e.message);
	    	  }
		}
  
  /*提交*/         
  function f_submit(){
    
      var sysid = $("#sysid").val();	
	            if(sysid==null||sysid==""){
	            	
	              actionurl=webpath+"/st/system/action/actions/ResActions_insert.action";
	            }else {
				   actionurl=webpath+"/st/system/action/actions/ResActions_update.action";
				} 
	   
	     $("#subButton").attr("disabled", true);
		 $.post(actionurl,$("form:first").serialize(),function(data){
		 $("#subButton").removeAttr('disabled'); 
			 if(data.checkFlag==MSG_SUCCESS)
			 {
			 	  tree.clear();
			 	  tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"ActionsTree"});
			 
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
  
 /*删除*/
        function f_remove(){ 
        try {
            var node = tree.getSelected();   	         
	       if (node==null) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{	           
	           $.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state)
		         {
		          if(state)
		          {    
		          	   var strId = node.data.id;
				       $.post(webpath+"/st/system/action/actions/ResActions_delete.action",{strSysno:strId},function(data){
	
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {	 
				       	    tree.clear();
			 	 		    tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"ActionsTree"});  
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
 
 /*创建*/
    function f_screate(){
     try {
            var node = tree.getSelected();   	         
	       if (node==null) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{	           
	          
		         
		          	   var strId = node.data.id;
				       $.post(webpath+"/st/system/action/actions/ResActions_create.action",{strSysno:strId},function(data){
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
  
 /*查看*/
        function f_grid(nodeid){
        try {
		       var node = tree.getSelected();   	         
	      	  if (node==null||node.data.id==1) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       		}else{
	       		   var strId = node.data.id;
					$.post(webpath+"/st/system/action/actions/ResActions_findByKey.action",{strSysno:strId},function(data){
				       	  if(data.messageBean.checkFlag==MSG_SUCCESS)
				       	  {
							  var obj = data.ptactionBean;	
							  $.each( obj, function(i, n){
 								 var sname = "#"+i;
 								 $(sname).val(n);
							 });	
			       	   		var strWhere = " ";            
                		     strWhere = " and actionid = '"+strId+"'";  
        
       	   					//初始化查询起始页
	      					 grid.set("newPage",1);
	 	   					//初始化查询条件
	       					grid.set("parms",{"strWhere":strWhere});
	      					grid.loadData(true);
				       	  	$.ligerDialog.success(data.messageBean.checkMessage);
				       	  }else{
				       	    $.ligerDialog.error(data.messageBean.checkMessage);
				       	  }
			 		  },"json");
					 
			    }
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
    				
        } 
  
  /*初始化*/
  function 	f_init(){
  
      try {
			$.post(webpath+"/st/system/action/actions/ResActions_init.action",function(data){
			 if(data.messageBean.checkFlag==MSG_SUCCESS)
			{
				$.ligerDialog.success(data.messageBean.checkMessage);
			}else{
			 $.ligerDialog.error(data.messageBean.checkMessage);
			}
			},"json"); 
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
  
  }      