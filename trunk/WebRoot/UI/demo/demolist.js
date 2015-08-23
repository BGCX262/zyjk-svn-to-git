/*********************************************************************
 *<p>处理内容：demo列表js</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/


var grid = null;
var myWindow = null;
var colum = null;
var openWidth="570";
var openHeight="450";
 
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
                        { text: '查看', click:f_look,  icon:'pager' }
                    ];
		grid = Grid("DemoGrid","菜单",toolbar," and companyname like '%333%'");

	 	}catch (e) {
     		   $.ligerDialog.error(e.message);
    		}	  
	  });   
		
		/*双击事件*/
		function onDblClickRow(data, rowindex, rowobj){
		     try {
					myWindow = $.ligerDialog.open({url: webpath+"/UI/action/demo/demo_findByKey.action?messageBean.method=look&strSysno="+data.customerid, width: openWidth,height:openHeight, title: '菜单管理',
				    showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			  }catch (e) {
	     		    $.ligerDialog.error(e.message);
	    	  }
		}
		/*查询*/
	    function f_search()
        {
        	try{
		     	 var strWhere = " ";           
	       	     var companyName = $("#companyName").val();
	             if(companyName.length>0) {
	                strWhere = " and companyname like '%"+companyName+"%' ";
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
        
        
        /*删除*/
        function f_remove()
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
				       $.post(webpath+"/UI/action/demo/demo_delete.action",{strSysno:strId},function(data){
				       	  if(data.checkFlag==MSG_SUCCESS)
				       	  {
				       	  	f_search();
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
        function f_add()
        {
          try {
		      myWindow = $.ligerDialog.open({url: webpath+"/UI/action/demo/demo_findByKey.action?messageBean.method=add",  width: openWidth,height:openHeight, title: 'DEMO编辑',
		      showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
		  	}catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
        }
        
        /*修改*/
        function f_update()
        {
          try {
		       var manager = $("#mainGrid").ligerGetGridManager(); 
		       var selected = manager.getSelectedRow(); 
			   if (selected==null||selected.length == 0) {
			           $.ligerDialog.warn(MSG_NORECORD_SELECT);
			    }else{
					myWindow = $.ligerDialog.open({url: webpath+"/UI/action/demo/demo_findByKey.action?messageBean.method=update&strSysno="+selected.customerid, width: openWidth,height:openHeight, title: 'DEMO编辑',
			    	showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
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
					myWindow = $.ligerDialog.open({url: webpath+"/UI/action/demo/demo_findByKey.action?messageBean.method=look&strSysno="+selected.customerid, width: openWidth,height:openHeight, title: 'DEMO编辑',
			    	showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
			    }
		  }catch (e) {
     		    $.ligerDialog.error(e.message);
    	  }
        }