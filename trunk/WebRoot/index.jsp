<%@ page language="java" import="st.system.dao.*,st.platform.security.SystemAttributeNames,java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>系统后台管理</title>
    <link href="js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>    
    <script src="js/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
    <script  src="js/zsession.js"      type="text/javascript"></script> 
    <script src="indexdata.js" type="text/javascript"></script>
    <%@ include file="/webpath.jsp"%>
        <script type="text/javascript">
            var tab = null;
            var accordion = null;
            var tree = null;
            var menu=null;
            var actionNodeID=null;
            var myWindow = null;
            var tip=null;
            
            $(".l-tree .l-body span").live('mouseover', function (e) {
            if (!this.title) 
                this.title = $(this).text();
            });
            
            $(function ()
            {
                //获取全局的session
                getSession();
                //布局
                $("#layout1").ligerLayout({ leftWidth: 190, height: '100%',heightDiff:0,space:4,onHeightChanged: f_heightChanged });

                var height = $(".l-layout-center").height();
                var width = $(".l-layout-center").width();

                //Tab
                $("#framecenter").ligerTab({ height: height });

                //面板
                $("#accordion1").ligerAccordion({ height: height - 24, speed: null });
                
                //面板
                $("#accordion2").ligerAccordion({ height: height - 24,speed: null });
                
                
                //右键菜单
                menu = $.ligerMenu({ top: 100, left: 100, width: 120, items:
            [
            { text: '增加', click: itemclick,  icon: 'add' },
            { text: '修改', click: itemclick, icon: 'modi' },
            { line: true },
            { text: '删除', click: itemclick, icon: 'del' }
            ]
              });
                

                $(".l-link").hover(function ()
                {
                    $(this).addClass("l-link-over");
                }, function ()
                {
                    $(this).removeClass("l-link-over");
                });
                //树型
                $("#tree1").ligerTree({
                  //  data : indexdata,
                    //data:[{id:'01',pid:'0',children:[],text:'监管系统',isexpand:'true'}],
                    idFieldName :'id',
                    parentIDFieldName :'pid',       
                    checkbox: false,
                    slide: false,
                    nodeWidth: 300,
                    //onBeforeExpand: onBeforeExpand,
                    url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=SysMenuTree",
                    onContextmenu: function (node, e)
                     { 
                      actionNodeID = node.data.text;
                       menu.show({ top: e.pageY, left: e.pageX });
                       return false;
                    },
                    onSelect: function (node)
                    {                        
                        if (!node.data.url) return;
                        var tabid = $(node.target).attr("tabid");
                        //alert(tabid);
                        if (!tabid)
                        {
                            tabid = new Date().getTime();
                            $(node.target).attr("tabid", tabid)
                        } 
                        f_addTab(tabid, node.data.text, node.data.url);
                   },
                   onClick: function(node)
                   {
                      //alert(node.data.id);
                      if(node.data.children && node.data.children.length == 0){
                          tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=SysMenuTree&strWhere="+ node.data.id);
                      }
                   } 
                    
                });
                    
                tab = $("#framecenter").ligerGetTabManager();
                accordion = $("#accordion1").ligerGetAccordionManager();
                //树型结构管理器
                tree = $("#tree1").ligerGetTreeManager();
                
                 if (!tip) {
		                tip = $.ligerDialog.tip({ title: '提示信息',height:250,width:400,url:webpath+'welcome.jsp'});
		            }
		            else {
		                var visabled = tip.get('visible');
		                if (!visabled) tip.show();
		                tip.set('content', '内容改变');
		        }
                
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
     
    
<style type="text/css"> 
    body,html{height:100%;}
    body{ padding:0px; margin:0;   overflow:hidden;}  
    .l-link{ display:block; height:26px; line-height:26px; padding-left:10px; text-decoration:underline; color:#333;}
    .l-link2{text-decoration:underline; color:white; margin-left:2px;margin-right:2px;}
    .l-layout-top{background:#102A49; color:White;}
    .l-layout-bottom{ background:#E5EDEF; text-align:center;}
    #pageloading{position:absolute; left:0px; top:0px; background:white url('loading.gif') no-repeat center; width:100%; height:100%;z-index:99999;}
    .l-link{ display:block; line-height:22px; height:22px; padding-left:16px;border:1px solid white; margin:4px;}
    .l-link-over{ background:#FFEEAC; border:1px solid #DB9F00;} 
    .l-winbar{ background:#2B5A76; height:30px; position:absolute; left:0px; bottom:0px; width:100%; z-index:99999;}
    .space{ color:#E7E7E7;}
    /* 顶部 */ 
    .l-topmenu{ margin:0; padding:0; height:31px; line-height:31px; background:url('images/top.jpg') repeat-x bottom;  position:relative; border-top:1px solid #1D438B;  }
    .l-topmenu-logo{ color:#E7E7E7; padding-left:35px; line-height:26px;background:url('images/msn.gif') no-repeat 10px 5px;}
    .l-topmenu-welcome{  position:absolute; height:24px; line-height:24px;  right:30px; top:2px;color:#070A0C;}
    .l-topmenu-welcome a{ color:#E7E7E7; text-decoration:underline} 

 </style>
</head>
<body style="padding:0px;background:#EAEEF5;"> 
<%

PtoperBean oper=(PtoperBean )session.getAttribute(SystemAttributeNames.USER_INFO_NAME);

//System.out.println("登陆用户名:"+oper.getSysno());

%>
<div id="pageloading"></div>  
<div id="topmenu" class="l-topmenu">
    <div class="l-topmenu-logo">职业危害信息管理系统</div>
    <div class="l-topmenu-welcome">
     <span class="space">|</span>
        <a href="#" class="l-link2" target="">帮助</a> 
        <span class="space">|</span>
         <a href="javascript:userlogout()" class="l-link2">退出</a>
    </div> 
</div>
  <div id="layout1" style="width:99.2%; margin:0 auto; margin-top:4px; "> 
        <div position="left"  title="主要菜单" id="accordion1"> 
                    <div title="菜单">
                    <div style=" height:7px;"></div>
                         <ul id="tree1" style="margin-top:3px;">
                    </div> 
                     <div title="资源管理" class="l-scroll">
                         <a class="l-link" href="javascript:f_addTab('listpage1','DEMO','UI/demo/demolist.jsp')">DEMO</a> 
                         <a class="l-link" href="javascript:f_addTab('listpage2','DATA Dictionary','UI/system/resource/databasc/databasclist.jsp')">DATA Dictionary</a> 
                         <a class="l-link" href="javascript:f_addTab('listpage3','ACTION','UI/system/resource/action/actionlist.jsp')">ACTION</a> 
                   		 <a class="l-link" href="javascript:f_addTab('listpage5','TREE','UI/system/resource/tree/treelist.jsp')">TREE</a>
                   		 <a class="l-link" href="javascript:f_addTab('listpage4','GRID','UI/system/resource/grid/gridlist.jsp')">GRID</a> 
                   		 <a class="l-link" href="javascript:f_addTab('listpage6','DETAIL','UI/system/resource/detail/detaillist.jsp')">DETAIL</a> 
                   		 <a class="l-link" href="javascript:f_addTab('listpage7','MENU','UI/system/menu/menulist.jsp')">MENU</a> 
                   		 <a class="l-link" href="javascript:f_addTab('listpage8','CENSUS','UI/system/menu/menulist.jsp')">CENSUS</a> 
                   		 <a class="l-link" href="javascript:f_addTab('listpage9','WORKFLOW','UI/system/menu/menulist.jsp')">WORKFLOW</a> 
                    </div>
        </div>
        <div position="center" id="framecenter"> 
        </div>
            <div tabid="home" title="我的主页" style="height:300px" >
                <%--<iframe frameborder="0" name="home" id="home" src="welcome.jsp"></iframe>
            --%></div> 
        </div> 
    <div  style="height:0px; line-height:32px; text-align:center;">
           
    </div>
    <div style="display:none"></div>
    
</body>
</html>

