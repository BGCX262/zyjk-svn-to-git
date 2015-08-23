/*********************************************************************
 *<p>处理内容：TREE list js</p>
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
 $(function (){
		try {	  
   $("#layout").ligerLayout({leftWidth: 250});

   
   /*清空*/
   $("#reset").click();
   
   /*提交*/
   $("#subButton").click(function(){
   	f_submit()});
   
     /*创建sql*/
   $("#creatsql").click(function(){
   	f_creatsql()});
   
   $("#tree").ligerTree({         
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PTree',
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
             { text: '创建', click: f_create, icon: 'add' } ]});
          
          
          /*数据结构树*/
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
                       		//f_getSQL(nodeid);
                       		f_getColumn(nodeid);
                   		}
                       
                    }
            });
       
       	/*数据结构树*/
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
          $("form").ligerForm();
       }catch (e) {
         $.ligerDialog.error(e.message);
   }	  
    		
 });          
  
  /*联动取得column*/
  function f_getColumn(nodeid)
  {
  	 if(nodeid!=""){
  	 	var strWhere =" where tableid='"+nodeid+"'";
  	 	columntree.clear();
		columntree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=PTableColumnTree', {strWhere:strWhere});
     } 
  }
      
  /*查询sql*/          
  function f_getSQL(nodeid)
  {
  	 $.post(webpath+"/st/system/action/databasc/DataBasc_findByKey.action",{strSysno:nodeid},function(data){
				       	  if(data.messageBean.checkFlag==MSG_SUCCESS)
				       	  {	 
				       	    $("#strsql").val(data.ptableBean.strsql);
				       	  }else{
				       	    $.ligerDialog.error(data.messageBean.checkMessage);
				       	  }
			 		  },"json");
  }
  
  /*生成sql*/
  function f_creatsql(){
  	
  	 var table = $("#tableid").val();
  	 var column   = $("#columnid").val();
  	  re = new RegExp(";","g");  
  	 column = column.replace(re, ",");  
  	 var strsql = "select " +column+"  from "+table; 
     $("#strsql").val(strsql);
  }
  
  /*创建*/
  function f_create()
  {
  try {
           var node = tree.getSelected();   	         
	       if (node==null||node.data.id==1) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{	           
	           $.ligerDialog.confirm("确定要创建,可能会覆盖原有文件", function (state)
		         {
		          if(state)
		          {    
		          	   var strId = node.data.id;
				       $.post(webpath+"/st/system/action/tree/tree_getCreat.action",{strTreeID:strId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {	 
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
  
  /*提交*/         
  function f_submit(){
    
      var sysid = $("#treeid").val();	
	            if(sysid==null||sysid==""){
	              actionurl=webpath+"/st/system/action/tree/tree_insert.action";
	            }else {
				   actionurl=webpath+"/st/system/action/tree/tree_update.action";
				} 
	     $("#subButton").attr("disabled", true);
		 $.post(actionurl,$("form:first").serialize(),function(data){
		 $("#subButton").removeAttr('disabled'); 
			 if(data.checkFlag==MSG_SUCCESS)
			 {
			 	  tree.clear();
			 	  tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"PTree"});
			 
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
	       if (node==null||node.data.id==1) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{	           
	           $.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state)
		         {
		          if(state)
		          {    
		          	   var strId = node.data.id;
				       $.post(webpath+"/st/system/action/tree/tree_delete.action",{strTreeID:strId},function(data){
	
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {	 
				       	    tree.clear();
			 	 		    tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"PTree"});  
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
  
 /*查看*/
        function f_grid(nodeid){
        try {
		       var node = tree.getSelected();   	         
	      	  if (node==null||node.data.id==1) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       		}else{
	       		   var strId = node.data.id;
					$.post(webpath+"/st/system/action/tree/tree_findByKey.action",{strTreeID:strId},function(data){
				       	  if(data.messageBean.checkFlag==MSG_SUCCESS)
				       	  {
							  var obj = data.ptreesBean;	
							  $.each( obj, function(i, n){
 								 var sname = "#"+i;
 								 $(sname).val(n);
							 });	
			       	   
				       	  	//$.ligerDialog.success(data.messageBean.checkMessage);
				       	  }else{
				       	    $.ligerDialog.error(data.messageBean.checkMessage);
				       	  }
			 		  },"json");
					 
			    }
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
    				
        } 
  
        