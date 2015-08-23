/*********************************************************************
 *<p>处理内容：menu列表js</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 贾明欣 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 贾明欣 --------- 新规作成<br>
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
	 
	   $("#navtab").ligerTab({height:'105%'}); 

	  /*TREE*/
	   $("#tree").ligerTree({         
               // data:[{id:'1',pid:'0',children:[],text:'检测机构基本情况',isexpand:'false'}],
                idFieldName :'id',
                parentIDFieldName :'pid', 
                nodeWidth : 200,
                checkbox: false,
                slide: false,    
                url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=JcjginfoTree",                    
                onExpand:onExpand,
                onBeforeExpand: onBeforeExpand,
                onSelect: function (node)
                    {                                                          
                       t_enter(node);
                   }
            });
            
            tree = $("#tree").ligerGetTreeManager(); 
           	tab = $("#navtab").ligerGetTabManager();
           	
           	var message=document.getElementById("message").value;
           	if(message!="null"||message!=""){
           		//alert(message);
           		// top.tab.reload(top.tab.getSelectedTabItemID());	
           	}
            
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
            //alert(node.data.pid);
            if(node.data.children && (node.data.children.length == 0)){
               tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=JcjginfoTree");
            }  
       }         
     /*查看*/
        function t_enter(node){
        try{           
          	f_addTab(node.data.id,node.data.text,webpath+node.data.url+"?messageBean.method=look&strSysno="+getUrlParam("sysno"));
        }catch (e) {
     		   $.ligerDialog.error(e.message);
    		}
    				
        } 
        /*建立tab*/
 		function f_addTab(tabid,text, url)
            { 
            	
                tab.addTabItem({ tabid : tabid,text: text, url: url });
            } 