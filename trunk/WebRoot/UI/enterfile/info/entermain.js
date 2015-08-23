/*********************************************************************
 *<p>处理内容：menu列表js</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.6.16---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
      var grid = null;
      var tree = null;
      var myWindow = null;
      var menu=null;
       var tab;
      var openWidth="630";
      var openHeight="300";
      var jgbh=null;
      
      /*初始化*/
	 $(function (){
		try {	
	      /*布局*/
	   $("#layout").ligerLayout({leftWidth: 200,height: '100%',heightDiff:-0});		
	  /*TAB*/ 
	 
	   $("#navtab").ligerTab({height:'100%'}); 

	  /*TREE*/
	   $("#tree").ligerTree({         
                data:[{id:'1',pid:'0',children:[],text:'企业档案库',isexpand:'true'}],
                idFieldName :'id',
                parentIDFieldName :'pid', 
                nodeWidth : 200,
                checkbox: false,
                slide: false,
                url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EnterViewTree",                        
                onExpand:onExpand,
                //onBeforeExpand: onBeforeExpand,
                onSelect: function (node)
                    {                                                          
                       t_enter(node);
                   }
            });
            
            tree = $("#tree").ligerGetTreeManager(); 
           	tab = $("#navtab").ligerGetTabManager();
           	//jgbh=document.getElementById("jgbh").value;
           	
            
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
               tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EnterViewTree");
            }  
       }         
     /*查看*/
        function t_enter(node){
        try{ 
             
             if(node.data.id=='19'){
          	    
          	 }
          	 if(node.data.id=='20'){
          	 	if( $("#state").val()=='1'){
          	 		$.ligerDialog.warn("请先提交保存企业信息！");
          	 		return;
          	 	}
          	    f_addTab(node.data.id,node.data.text,webpath+node.data.url+"&strSysno="+$("#enterno").val());
          	 }
          	 if(node.data.id=='21'){
          	    f_addTab(node.data.id,node.data.text,webpath+node.data.url+"?enterno="+$("#enterno").val());
          	 }   
          	 if(node.data.id=='23'){
          	    f_addTab(node.data.id,node.data.text,webpath+node.data.url+"&enterno="+$("#enterno").val());
          	 }          
          	 if(node.data.id!='4'&&node.data.id!='19'){
          	     //f_addTab(node.data.id,node.data.text,webpath+node.data.url+"?messageBean.method=add&strSysno="+getUrlParam("enterno"));
          	     f_addTab(node.data.id,node.data.text,webpath+node.data.url+"?messageBean.method=add&strSysno="+$("#enterno").val());
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