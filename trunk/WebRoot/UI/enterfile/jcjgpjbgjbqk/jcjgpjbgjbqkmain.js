/*********************************************************************
 *<p>处理内容：menu列表js</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.5.29---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
      var grid = null;
      var tree = null;
      var myWindow = null;
      var menu=null;
       var tab;
      var openWidth="630";
      var openHeight="550";
      
      /*初始化*/
	 $(function (){
		try {	
	      /*布局*/
	   $("#layout").ligerLayout({leftWidth: 200});		
	  /*TAB*/ 
	 
	   $("#navtab").ligerTab({height:'100%'}); 

	  /*TREE*/
	   $("#tree").ligerTree({         
               // data:[{id:'1',pid:'0',children:[],text:'检测、评价报告与记录',isexpand:'false'}],
                idFieldName :'id',
                parentIDFieldName :'pid', 
                nodeWidth : 200,
                checkbox: false,
                slide: false,
                url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=ReportTree",                        
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
            //alert(node.data.pid);
            if(node.data.children && (node.data.children.length == 0)){
               tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=ReportTree");
            }  
       }         
     /*查看*/
        function t_enter(node){
        try{
                   
          	//f_addTab(node.data.id,node.data.text,webpath+node.data.url+"?messageBean.method=look&strSysno="+getUrlParam("enterno"));
          	//alert("sysno:"+getUrlParam("sysno"));
          	//alert("enterno:"+getUrlParam("enterno"));
          	 //alert("sysno:"+getUrlParam("sysno"));	    
          	if(node.data.id=='2'||node.data.id=='5'){
          	   var pdurl=null;
          	   if(node.data.id=='2'){
          	      pdurl=webpath+"/UI/action/jcdwjbxx/LoginAction_loadDlxx.action";
          	   }else{
          	      pdurl=webpath+"/UI/action/jcpjjyxx/LoginAction_loadDlxx.action";
          	   }         	   
          	   //此处判断是增加记录操作还是修改记录操作
          	   $.post(pdurl,{bgbh:getUrlParam("sysno")},function(data) {
		             //var obj=JSON.parse(data);
		             //alert("bgbh:"+getUrlParam("sysno"));
		            if(data.checkFlag=="1"){
		              f_addTab(node.data.id,node.data.text,webpath+node.data.url+"?messageBean.method=update&bgbh="+getUrlParam("sysno") +"&dwbh="+getUrlParam("enterno"));
		            }else{
		              f_addTab(node.data.id,node.data.text,webpath+node.data.url+"?messageBean.method=add&bgbh="+ getUrlParam("sysno") +"&dwbh="+getUrlParam("enterno"));
		            }
		     
		       });
          	             	 
          	}else{
          	   //alert("bgbh:"+getUrlParam("sysno"));
          	   f_addTab(node.data.id,node.data.text,webpath+node.data.url+"?dwbh="+ getUrlParam("enterno") +"&bgbh="+ getUrlParam("sysno") +"&strSysno="+getUrlParam("sysno"));
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