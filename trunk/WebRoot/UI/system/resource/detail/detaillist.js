/*********************************************************************
 *<p>处理内容：detail list js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.14---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
 
 var tree =null;
 var menu=null;
 var actionurl = null;
 var openWidth="820";
var openHeight="570";
  
 $(function (){
		try {	  
   $("#layout").ligerLayout({leftWidth: 250});
   
   
   /*清空*/
   $("#reset").click();
  
   	
   /*info修改*/
   $("#addinfo").click(function(){
    var formid = $("#formid").val();
    if(formid!=null&&formid!="")
    {
       /*表单域设置*/
   		f_fab();
   	}else{
   		$.ligerDialog.error("请先选择form");
   	}
   
   	});
   	
   /*提交*/
   $("#subButton").click(function(){
   	f_submit()
   	});
   
   /*表单域tree*/
   $("#tree").ligerTree({         
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=FormTree',
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
             { text: '创建INFO', click: f_create, icon: 'add' } ]});
         
         /*grid*/
       $.post(webpath+"/st/system/action/table/table_getColumn.action",{key:"FormTable"},function(data){
	 		 grid = $("#mainGrid").ligerGrid({ checkbox: true, 
			 columns:data,pageSizeOptions:[15,20,30,40,50], 
			 parms:"",
			 dataAction: 'server',url: webpath+"/st/system/action/grid/Grid_findList.action?strSysno=FormTable",
			 width: '100%',height:'100%',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :true,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			 pageSize:10, enabledEdit: true,clickToEdit: false, isScroll: true,
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 },
			 toolbar: { 
                    items: [
                        { text: '删除', click:f_columnrem,icon:'delete' }
                    ]
                }
			});
	 		  },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
								
          /*表格selcet树*/
          $("#actionname").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
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
            
   
  
  /*提交*/         
  function f_submit(){
    
      var sysid = $("#formid").val();
	     if(sysid==''){
	         actionurl=webpath+"/st/system/action/detail/DetailAction_insert.action";
	     }else {
			 actionurl=webpath+"/st/system/action/detail/DetailAction_update.action";
	     } 
	     $("#subButton").attr("disabled", true);
		 $.post(actionurl,$("form:first").serialize(),function(data){
		 $("#subButton").removeAttr('disabled'); 
			 if(data.checkFlag==MSG_SUCCESS)
			 {
			 	  tree.clear();
			 	  tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"FormTree"});
			 
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
				       $.post(webpath+"/st/system/action/detail/DetailAction_delete.action",{strSysno:strId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {	 
				       	    tree.clear();
			 	 		    tree.loadData("1", webpath+'/st/system/action/tree/tree_getTree.action', {strTreeName:"FormTree"});  
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
    function f_create(){
     try {
            var node = tree.getSelected();   	         
	       if (node==null) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{	           
	           $.ligerDialog.confirm("是否要覆盖原有文件", function (state)
		         {
		          if(state)
		          {    
		          	   var strId = node.data.id;
				       $.post(webpath+"/st/system/action/detail/DetailAction_createJsp.action",{strSysno:strId},function(data){
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
  
 /*查看*/
        function f_grid(nodeid){
        try {
		       var node = tree.getSelected();   	         
	      	  if (node==null||node.data.id==1) {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       		}else{
	       		   var strId = node.data.id;
					$.post(webpath+"/st/system/action/detail/DetailAction_findObjson.action",{strSysno:strId},function(data){
				       	  if(data.messageBean.checkFlag==MSG_SUCCESS)
				       	  {
							  var obj = data.ptformBean;	
							  $.each( obj, function(i, n){
 								 var sname = "#"+i;
 								 $(sname).val(n);
							 });	
			       	   		 f_serch(strId);
				       	  }else{
				       	    $.ligerDialog.error(data.messageBean.checkMessage);
				       	  }
			 		  },"json");
					 
			    }
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
    				
        } 
  ////////////////////////////////////////////////////////////////////////////////
  
   /*grid查询*/
   function f_serch(nodeid){      
  
  	  var strWhere = " ";           
      if(nodeid.length>0){          
            strWhere = " and formid = '"+nodeid+"'";         
       		grid.loadServerData({strWhere:strWhere},function (countmain){       	
        		 alert(countmain);});
		}else{
			 $.ligerDialog.error(data.messageBean.checkMessage);
		}
  }
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
				       $.post(webpath+"/st/system/action/detail/DetailSetAction_delete.action",{strSysno:strId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	  	f_serch($("#formid").val());
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
  
  
    /*表单域设置*/
    function f_fab(){
    	try {
    	var node = tree.getSelected();  
    	var strId = $("#formid").val(); 	         
	       if (strId=="") {
	           $.ligerDialog.warn(MSG_NORECORD_SELECT);
	       }else{
	      			
					myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/detail/DetailSetAction_findInfo.action?strSysno="+strId, width: openWidth,height:openHeight, title: '表单域设计',
			    	showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			    }
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
    		
    }
    
  /*column类型修改*/
    function f_labelset(){
    	try {
		       var manager = $("#mainGrid").ligerGetGridManager(); 
		       var selected = manager.getSelectedRow(); 
			   if (selected==null||selected.length == 0) {
			           $.ligerDialog.warn(MSG_NORECORD_SELECT);
			    }else{
					myWindow = $.ligerDialog.open({url: webpath+"/st/system/action/detail/DetailSetAction_findByKey.action?strSysno="+selected.sysid, width: openWidth,height:openHeight, title: '页面',
			    	showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			    }
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
    		
    }