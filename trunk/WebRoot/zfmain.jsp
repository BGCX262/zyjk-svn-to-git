<%@ page language="java" import="st.system.dao.*,st.platform.security.SystemAttributeNames,java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
 <%@ include file="/webpath.jsp"%>
<head>
    <title>职业卫生监督管理信息平台</title>
     <link href="css/zfindexm.css" rel="stylesheet" type="text/css" />
    <link href="js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>    
    <script src="js/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
    <script  src="js/zsession.js"      type="text/javascript"></script> 
    <script  src="js/zbasic.js"      type="text/javascript"></script> 
  
        <script type="text/javascript">
            var tab = null;
            var accordion = null;
            var tree = null;
            var menu=null;
            var actionNodeID=null;
            var myWindow = null;
            
            var layout=null;
           
            
            $(function ()
            {
                //获取全局的session
                getSession();
                
                
                
                 /*布局*/
	 		  layout=$("#layout").ligerLayout({leftWidth: 200,space:4});		
			  /*TAB*/ 
			 
			  tab=$("#navtab").ligerTab({height:'105%'}); 

               
                //树型
                
                $.post(webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=SysMenuTree&strWhere="+getUrlParam("mid"),function(data){ 
					  if(data.length>0){
				  	  	var urldata=data[0];
	                  	f_addTab(urldata.id, urldata.text, urldata.url);
				  	  }
				  	  if(data.length==1){
				  	  	layout.setLeftCollapse(true);
				  	  }else{
				  	  	layout.setLeftCollapse(false);
				  	  }
				  	 $("#tree").ligerTree({
	                    data : data,
	                    //data:[{id:'01',pid:'0',children:[],text:'监管系统',isexpand:'true'}],
	                    idFieldName :'id',
	                    parentIDFieldName :'pid',       
	                    checkbox: false,
	                    slide: false,
	                    nodeWidth: 300,
	                   
	                    onSelect: function (node)
	                    {                        
	                        //if (!node.data.url) return;
	                        //var tabid = $(node.target).attr("tabid");
	                        //alert(tabid);
	                        //if (!tabid)
	                        //{
	                          //  tabid = new Date().getTime();
	                            //$(node.target).attr("tabid", tabid)
	                        //} 
	                        f_addTab(node.data.id, node.data.text, node.data.url);
	                   },
	                   onClick: function(node)
	                   {
	                      //alert(node.data.id);
	                      if(node.data.children && node.data.children.length == 0){
	                          tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=SysMenuTree&strWhere="+ node.data.id);
	                      }
	                   } 
	                    
	                });
	                tree = $("#tree").ligerGetTreeManager();
                },"json");
                    
                //树型结构管理器
               //var tip = $.ligerDialog.tip({ title: '提示信息',height:250,width:400,url:webpath+'welcome.jsp'});	
                $("#pageloading").hide();

            });
           
            function onBeforeExpand(node)
              { 
	              var nodeid=node.data.id;
	              if(node.data.children && node.data.children.length == 0){
                  tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=SysMenuTree");
                  }
              }
            
            function f_heightChanged(options)
            {
                if (tab)
                    tab.addHeight(options.diff);
                if (accordion && options.middleHeight - 24 > 0)
                    accordion.setHeight(options.middleHeight - 24);
            }
            function f_addTab(tabid,text, url)
            { 
                tab.addTabItem({ tabid : tabid,text: text, url: url });
            } 
             
             function itemclick(item, i)
        {
            alert(actionNodeID + " | " + item.text);
        }
        
        /*删除*/
        function f_remove()
        {
           alert("remove");
         $.ligerDialog.confirm('是否删除', function (yes)
         {
           var id ="''";
	       var manager = $("#maingrid4").ligerGetGridManager(); 
	       var selected = manager.getSelectedRows(); 
	       if (selected==null) {
	             $.ligerDialog.warn('请选择行');
	       }
	       for(var i=0;i<selected.length;i++){
	        id = id+",'"+selected[i].menuid+"'";
	       } 
	        
	       $.post(webpath+"/UI/sysmenu/sysmenu_delete.action",{id:id},function(data){
	         
	        
	       	  if(data.checkFlag==1)
	       	  {
	       	  	f_search();
	       	  	$.ligerDialog.success('删除成功');
	       	  }else{
	       	    $.ligerDialog.error('删除失败');
	       	  }
 		  },"json");
 		  
 		  
 		  })
        }
        
        
        /*新建*/
        function f_add()
        {
         alert("add");
		   myWindow = $.ligerDialog.open({ url: webpath+"/UI/sysmenu/sysmenu_findObj.action?check.method=add",  width: 550,height:450, title: '菜单管理',
		   showMax: true, showToggle: true, showMin: true, isResize: false, slide: false }); 
		 alert("end"); 
        }
        /*修改*/
        function f_update()
        {
            alert("update");
           var id ="''";
	       var manager = $("#maingrid4").ligerGetGridManager(); 
	       var selected = manager.getSelectedRow(); 
	       if (selected==null) {
	           $.ligerDialog.warn('请选择行');
	       }
			window = $.ligerDialog.open({url: webpath+"/UI/sysmenu/sysmenu_findObj.action?check.method=update&id="+selected.menuid, width: 550,height:450, title: '菜单管理',
		    showMax: true, showToggle: true, showMin: true, isResize: false, slide: false }); 
		  
   
        } 
        /*退出*/
       function userlogout(){
               
                $.ligerDialog.confirm("退出系统", function (state)
              {
                    if(state)
                   {    
                       $.post(webpath+"st/system/action/login/LoginAction_remove.action",function(data){            
                         if(data.checkFlag=="1"){
      
                             window.location.href="select.html";    

                          }
		        
				        },"json").error(function() { 
					           alert("error");
				        }); 
                   }else{
                   
                   }
               });	
              
		      
        }      
     </script> 
    
      <script>
		function openMenu(id){
			try{
				
			  $.post(webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=SysMenuTree&strWhere="+id,function(data){ 
			  	if(data.length>0){
			  	  	var urldata=data[0];
                  	f_addTab(urldata.id, urldata.text, urldata.url);
			  	  }
			  	   if(data.length==1){
				  	  	layout.setLeftCollapse(true);
				  	  }else{
				  	  	layout.setLeftCollapse(false);
				  	  }
			  	  tree.clear();
			      tree.append(null,data);
                },"json")
			}catch(e){
				window.location.href="<%=webpath %>zfmain.jsp?mid="+id;
				//alert(e);
			}
		} 
	
 </script>
    
<style type="text/css"> 
    .l-topmenu{width: 1000px; height:157px;}
 </style>
</head>
<body> 
<%

PtoperBean oper=(PtoperBean )session.getAttribute(SystemAttributeNames.USER_INFO_NAME);

//System.out.println("登陆用户名:"+oper.getSysno());

%>
<jsp:include page="index/zfhead.jsp" />
   <div id="layout" style="width:1000px; margin:0 auto; margin-top:4px; ">
            
            <div position="left" title="菜单导航" style="width: 300px;"> <ul id="tree"  style="margin-top:3px;width: 300px;"> </div>
            <div position="center" id="navtab">
  </div>
    <%--<jsp:include page="index/zffoot.jsp" />
--%></body>
</html>

