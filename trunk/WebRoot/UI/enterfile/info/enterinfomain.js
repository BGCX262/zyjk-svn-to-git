/*********************************************************************
 *<p>处理内容：menu列表js</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.5.22---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
      var grid = null;
      var tree = null;
      var myWindow = null;
      var menu=null;
       var tab;
      var openWidth="630";
      var openHeight="300";
      
      /*初始化*/
	 $(function (){
		try {	
	      /*布局*/
	   $("#layout").ligerLayout({leftWidth: 200});		
	  /*TAB*/ 
	 
	   $("#navtab").ligerTab({height:'85%'}); 

	  /*TREE*/
	   $("#tree").ligerTree({         
                //data:[{id:'1',pid:'0',children:[],text:'档案库基本情况',isexpand:'true'}],
                idFieldName :'id',
                parentIDFieldName :'pid', 
                nodeWidth : 200,
                checkbox: false,
                slide: false,    
                url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EnterfileTree",                        
                onExpand:onExpand,
                onBeforeExpand: onBeforeExpand,
                onSelect: function (node)
                    {                                                          
                       t_enter(node);
                   }
            });
            
            tree = $("#tree").ligerGetTreeManager(); 
           	tab = $("#navtab").ligerGetTabManager();
            
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

       }
      function onBeforeExpand(node){
            var nodeid=node.data.id;
            if(node.data.children && (node.data.children.length == 0)){
               tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EnterfileTree&isFlag="+$("#state").val());
            }  
       }         
     /*查看*/
        function t_enter(node){
        try{ 
                      
          	 if(node.data.id!='4'){
          	     if(node.data.id=='24'||node.data.id=='25'){
          	        f_addTab(node.data.id,node.data.text,webpath+node.data.url+"&strSysno="+getUrlParam("enterno"));
          	     }
          	     if(node.data.id=='11'){
          	        //f_addTab(node.data.id,node.data.text,webpath+node.data.url+"?enterno="+getUrlParam("enterno"));
          	        window.showModalDialog(webpath+node.data.url+"?enterno="+getUrlParam("enterno"),"","dialogHeight:600px;dialogWidth:1200px;");    
          	     }else{
          	        f_addTab(node.data.id,node.data.text,webpath+node.data.url+"?messageBean.method=look&strSysno="+getUrlParam("enterno"));
          	     }
          	 }     	
        }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
    				
        } 
        /*建立tab*/
 		function f_addTab(tabid,text, url)
            { 
            	
                tab.addTabItem({ tabid : tabid,text: text, url: url });
            } 