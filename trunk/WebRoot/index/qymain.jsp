<%@ page language="java" import="st.platform.security.SystemAttributeNames,java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.T_officerBean"/>
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<jsp:directive.page import="UI.dao.zyjk.Z_corBean"/>
<jsp:directive.page import="UI.dao.zyjk.WsjgbaxxBean"/>
<jsp:directive.page import="UI.dao.zyjk.JcjgbaxxBean"/>
<jsp:directive.page import="UI.dao.zyjk.PxjgbaxxBean"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
 <%@ include file="/webpath.jsp"%>
<head>
    <title>职业卫生管理信息平台-企业端</title>
     <link href="<%=webpath %>css/stylem.css" rel="stylesheet" type="text/css" />
    <link href="<%=webpath %>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <script src="<%=webpath %>js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>    
    <script src="<%=webpath %>js/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
    <script  src="<%=webpath %>js/zsession.js"      type="text/javascript"></script> 
    <script  src="<%=webpath %>js/zbasic.js"      type="text/javascript"></script> 
  
    <script type="text/javascript">
            var tab = null;
            var accordion = null;
            var tree = null;
            var myWindow = null;
            var treeurl=null;
            var dept_type=null;
            var openWidth="1000";
            var openHeight="650"; 
            var manager =null;
           // var isLeftCollapse=null;
            $(".l-tree .l-body span").live('mouseover', function (e) {
            if (!this.title) 
                this.title = $(this).text();
            });
            
            $(function ()
            {
                //获取全局的session
                //getSession();
                //布局
             var   actionurl=webpath+"st/system/action/enterlogin/EnterLoginAction_check.action";
		     $.post(webpath+"/st/system/action/enterlogin/LoginAction_loadDlxx.action",function(data) {
		     if(data.checkFlag=="0"){
		        //$("#framePage").attr("src","<%=webpath%>index/left.jsp");
		        //$("#loginform").attr("src","<%=webpath%>index/form.jsp");
		        $(".box1").html("欢迎使用职业卫生信息管理系统");
		     }else{
		         //判断单位的登陆类型
		         dept_type=data.widgetValue;
		         //判断单位的主键
		         
		        if(dept_type=="1"){
		             str="<form id='winform' name='winform' method='post' action='qyindex.jsp'>";
                     str+="<input type='hidden' id='index' name='index'/>";
		             str+="<table align='left' style='valign:center;margin-bottom:-10px;'><tr>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='sysinfo()'>系统首页</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(1)'>用人单位基本信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(3)'>接触危害因素人员汇总</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(2)'>职业卫生管理机构</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(4)'>职业卫生档案</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(19)'>基础建设</a></td>";
		              str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(17)'>建设项目三同时</a></td>";
		             
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(22)'>密码修改</a></td>";
		             str+="</tr></table></form>";
		             treeurl=webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EnterViewTree";
		             		             
		        }else if(dept_type=="2"){
		             str="<form id='winform' name='winform' method='post' action='qyindex.jsp'>";
                     str+="<input type='hidden' id='index' name='index'/>";
		             str+="<table align='left' style='valign:center;margin-bottom:-10px;'><tr>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='sysinfo()'>系统首页</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(1)'>基本信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(2)'>人员信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(4)'>年检管理</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(3)'>检测设备管理</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(5)'>检测与评价报告管理</a></td>";
		             //str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(22)'>系统提醒</a></td>";
		             str+="</tr></table></form>";
		             treeurl=webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=JcjgLoginTree";
		        }else if(dept_type=="3"){
		             str="<form id='winform' name='winform' method='post' action='qyindex.jsp'>";
                     str+="<input type='hidden' id='index' name='index'/>";
		             str+="<table align='left' style='valign:center;margin-bottom:-10px;'><tr>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='sysinfo()'>系统首页</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(1)'>基本信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(2)'>讲师信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(3)'>培训信息</a></td>";
		             //str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(4)'>系统提醒</a></td>";
		             str+="</tr></table></form>";
		             treeurl=webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=PxjgLoginTree";
		        
		        }else if(dept_type=="4"){
		             str="<form id='winform' name='winform' method='post' action='qyindex.jsp'>";
                     str+="<input type='hidden' id='index' name='index'/>";
		             str+="<table align='left' style='valign:center;margin-bottom:-10px;'><tr>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='sysinfo()'>系统首页</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(1)'>基本信息</a></td>";
		             //str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(2)'>人员信息</a></td>";
		             str+="<td><a style='padding-right: 14px;margin-bottom:-20px;cursor: pointer;font-weight:bold;' onclick='loadPage(3)'>体检信息</a></td>";
		             str+="</tr></table></form>";
		             treeurl=webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=WsjginfoTree";
		        
		        }		    
		        
		       
		        $(".box1").html(str);
		        //$("#framePage").attr("src","<%=webpath%>index/left.jsp");
		        //$("#loginform").attr("src","<%=webpath%>index/zform.jsp");
		         getTreeData(treeurl);
		     }
		     
		     });
                
                
                
               manager=$("#layout1").ligerLayout({ leftWidth: 190, height: '100%',space:4,onHeightChanged: f_heightChanged });

                var height = $(".l-layout-center").height();
                var width = $(".l-layout-center").width();

                //Tab
                $("#framecenter").ligerTab({ height: height });

                //面板
                $("#accordion1").ligerAccordion({ height: height - 24, speed: null });
                
                //面板
                $("#accordion2").ligerAccordion({ height: height - 24,speed: null });
                
                
              
                

                $(".l-link").hover(function ()
                {
                    $(this).addClass("l-link-over");
                }, function ()
                {
                    $(this).removeClass("l-link-over");
                });
            
                   
                
                    
                tab = $("#framecenter").ligerGetTabManager();
                accordion = $("#accordion1").ligerGetAccordionManager();

                $("#pageloading").hide();

            });
            
            
            
            function f_heightChanged(options)
            {
               // if (tab)
               //     tab.addHeight(options.diff);
               // if (accordion && options.middleHeight - 24 > 0)
              //      accordion.setHeight(options.middleHeight - 24);
            }
            function f_addTab(tabid,text, url)
            { 
                tab.addTabItem({ tabid : tabid,text: text, url: url });
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
        
        function sysinfo(){
            window.location.href="../qyindex.jsp";
        }
        
        //function loadPage(index){
          //alert("index"+index);
          // window.location.href=webpath+"\index\\qymain.jsp?pid="+index;
        //}
        
        function loadPage(id){
			try{
		      //alert("tree:"+tree);
		      //alert(id);
			  $.post(treeurl,function(data){ 
			        var treedata2=[];
			        var treedata3=[];
	       	        $.each(data,function(idx,item){
                    //if(item.pid==id||item.id==id){
                    if(item.pid==id){
                    //树形json 
                    treedata2.push({id:item.id,pid:'0',text:item.text,url:item.url});
                    //alert("treedata:"+treedata2.length);
                    }else if(item.pid==id||item.id==id){
                     treedata3.push({id:item.id,pid:item.pid,text:item.text,url:item.url});
                    }
                }); 
                    //alert("treedata2:"+treedata2.length);
           if(treedata2.length>1){
               //
               //alert("tree:"+tree);
               if(null!=tree){
                   
                   tree.clear();
                   tree.append(null,treedata2);
               }else{
                   loadTree(treedata2);
               }
               manager.setLeftCollapse(false);
                
           }else if(treedata3.length<2){
             /*
               var flag=$("#flag").val();
               if(flag=='1'){
                  alert("请先填录完毕单位基本信息！");
               }
             */
              var flag=$("#flag").val();
               if(flag=='1'&&id!='1'){
                  $.ligerDialog.warn("请先提交保存单位信息！");
          	      return; 
               }
             
               var _mainkey=$("#mainkey").val();
               var url=webpath+treedata3[0].url+"?enterno="+_mainkey+"&strSysno="+_mainkey;

                        if(treedata3[0].id=='1'){
                           if($("#flag").val()=='1'){
                             url=webpath+treedata3[0].url+"?messageBean.method=add&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }else{
                             url=webpath+treedata3[0].url+"?messageBean.method=update&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }
                           
                        } 
               //alert(url);           
               if (!treedata3[0].url) return;
               //var tabid = $(treedata2[0].target).attr("tabid"); 
               //alert("tabid:"+tabid);
               var tabid=id;
               f_addTab(tabid, treedata3[0].text, url);
               //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: treedata2[0].text, url:url });  
               //tab.reload(tab.getSelectedTabItemID());
               manager.setLeftCollapse(true);
                
           }
                    
                    
 		        },"json");
			//判断子结点个数
			
       
            
			}catch(e){
				window.location.href="<%=webpath %>index/qymain.jsp?pid="+id;
				//alert(e);
			}
		} 
		/*根据treeurl字符串，拼接树形data*/
        function getTreeData(_treeurl){
        //alert("mainkey:"+$("#mainkey").val());
        	var _mainkey=null;
               //alert("_mainkey:"+_mainkey);
               var treedata=[];
               var treedata1=[];
                $.post(_treeurl,function(data){ 
                
	       	       var pid=getUrlParam("pid");
	       	       
	       	        $.each(data,function(idx,item){
                    //if(item.pid==pid||item.id==pid){
                    if(item.pid==pid){
                    //树形json
                    //var treedata=[{id:item.id,pid:item.pid,text:item.text,url:item.url}];
                    treedata.push({id:item.id,pid:'0',text:item.text,url:item.url});                    
                    //alert(treedata);                   
                  }else if(item.pid==pid||item.id==pid){
                     treedata1.push({id:item.id,pid:item.pid,text:item.text,url:item.url}); 
                  }
                });
	       	     //判断子结点个数
           if(treedata.length>1){
               loadTree(treedata);
               manager.setLeftCollapse(false);  
           }else if(treedata1.length<2){
               
               
                _mainkey=$("#mainkey").val();
               var url=webpath+treedata1[0].url+"?enterno="+_mainkey+"&strSysno="+_mainkey;
             
                        if(treedata1[0].id=='1'){
                           if($("#flag").val()=='1'){
                             url=webpath+treedata1[0].url+"?messageBean.method=add&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }else{
                             url=webpath+treedata1[0].url+"?messageBean.method=update&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }
                           
                       } 
                       
               var flag=$("#flag").val();
               if(flag=='1'&&treedata1[0].id!='1'){
                  $.ligerDialog.warn("请先提交保存单位信息！");
          	      return; 
               } 
               
                          
               if (!treedata1[0].url) return;
               //var tabid = $(treedata[0].target).attr("tabid");
               
               var tabid=treedata1[0].id; 
               //alert("tabid1:"+tabid);
               f_addTab(tabid, treedata1[0].text, url); 
               manager.setLeftCollapse(true);
               
           }         	       
	       	     
 		        },"json");
                
        }  
        
        /*修改页面*/
        function isMethod(){
              var url=null;
              var _mainkey=$("#mainkey").val();
              var method=null;
              if($("#flag").val()=='1'){
                    method="add";
              }else{
                     method="update";                   
              }
              return method;
              
        }
        
        /*根据树形data，生成左侧树*/
        function loadTree(treedata){
           
        var _mainkey=null;
            $("#tree1").ligerTree({
                    data:treedata,
                    idFieldName :'id',
                    parentIDFieldName :'pid',       
                    checkbox: false,
                    slide: false,
                    nodeWidth: 300,
                    onSelect: function (node)
                    {   
                        
                        _mainkey=$("#mainkey").val();
                        
                        //alert("_mainkey:"+_mainkey);
                        if( $("#flag").val()=='1'&&node.data.id!='1'){
          	 	        	$.ligerDialog.warn("请先提交保存单位信息！");
          	 		        return;
          	 	        }
          	 	        
                        if (!node.data.url) return;
                        var tabid = $(node.target).attr("tabid");
                        if (!tabid)
                        {
                            tabid = new Date().getTime();
                            $(node.target).attr("tabid", tabid)
                        }
                        //var url=webpath+node.data.url+"?enterno="+_mainkey;
                        var url=webpath+node.data.url+"?enterno="+_mainkey+"&strSysno="+_mainkey;

                        if(treeurl.indexOf("EnterViewTree")>0&&node.data.id=='1'){
                        //alert("flag:"+$("#flag").val());
                           if($("#flag").val()=='1'){
                             url=webpath+node.data.url+"?messageBean.method=add&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }else{
                             url=webpath+node.data.url+"?messageBean.method=update&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }
                           
                        }
                        if(treeurl.indexOf("JcjgLoginTree")>0){
                          //url=webpath+node.data.url+"?messageBean.method=update&strSysno="+_mainkey; 
                          
                          if($("#flag").val()=='1'){
                             url=webpath+node.data.url+"?messageBean.method=add&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }else{
                             url=webpath+node.data.url+"?messageBean.method=update&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }
                          
                        }
                        if(treeurl.indexOf("PxjgLoginTree")>0){
                         
                          if($("#flag").val()=='1'){
                             url=webpath+node.data.url+"?messageBean.method=add&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }else{
                             url=webpath+node.data.url+"?messageBean.method=update&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }
                        }
                        
                        if(treeurl.indexOf("WsjginfoTree")>0){
                          if($("#flag").val()=='1'){
                             url=webpath+node.data.url+"?messageBean.method=add&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }else{
                             url=webpath+node.data.url+"?messageBean.method=update&strSysno="+_mainkey+"&enterno="+_mainkey;
                           }
                        }
                        
                        if(node.data.id=="20"||node.data.id=="23"||node.data.id=="24"||node.data.id=="25"){
                            //url=webpath+node.data.url+"&enterno="+_mainkey;
                            url=webpath+node.data.url+"&enterno="+_mainkey+"&strsysno="+_mainkey;
                        }
                        
                        if(node.data.id=="20"){
                            //alert("1111111111111");
                               try {
                               
                                   myWindow = top.$.ligerDialog.open({ url: url,  width: openWidth,height:openHeight, title: '自查自纠表',
                                   showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
 
                               }catch (e) {
                                    $.ligerDialog.error(e.message);
                               }  
         
                        }else if(node.data.id=="11"){
                               try {
                                    window.showModalDialog(url,"","dialogHeight:600px;dialogWidth:1200px;");    
          	    
                               }catch (e) {
                                    $.ligerDialog.error(e.message);
                               }  
         
                        }else{
                            f_addTab(tabid, node.data.text, url); 
                        }
                       
                   },
                   onClick: function(node)
                   {
                      if(node.data.children && node.data.children.length == 0){
                          tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EnterViewTree");
                      }
                   } 
                    
                });
                //树型结构管理器
                tree = $("#tree1").ligerGetTreeManager();
        
        }
     </script> 
     
    
<style type="text/css"> 
    .l-topmenu{width: 1000px; height:157px;}
 </style>
 <%
 T_officerBean officer=(T_officerBean)session.getAttribute(SystemAttributeNames.CORP_INFO_NAME);
 String loginId=officer.getLogin_id();
 
 QyjbqkBean qyjbqkBean=new QyjbqkBean();
 qyjbqkBean=qyjbqkBean.findFirst(" where corpkey='"+ loginId +"'");
 JcjgbaxxBean jcjgBean=new JcjgbaxxBean();
 jcjgBean=jcjgBean.findFirst(" where sysno='"+ loginId +"'");
 PxjgbaxxBean pxjgBean=new PxjgbaxxBean();
 pxjgBean=pxjgBean.findFirst(" where sysno='"+ loginId +"'");
 WsjgbaxxBean wsjgBean=new WsjgbaxxBean();
 wsjgBean=wsjgBean.findFirst(" where sysno='"+ loginId +"'");
 Z_corBean zcoreBean=new Z_corBean();
 String flag="1";
 
 
 String mainkey="";
 String dept_type=officer.getDept_type();
 if(dept_type.equals("1")){
	 if(null==qyjbqkBean){
		 
		 mainkey=officer.getLogin_id();
	 }else{
		 flag="2";
		 mainkey=qyjbqkBean.getEnterno();
	 }	 
 }else if(dept_type.equals("2")){
     if(null==jcjgBean){		 
		 mainkey=officer.getLogin_id();
	 }else{
		 flag="2";
		 mainkey=loginId;
	 }	
 }else if(dept_type.equals("3")){
	 
     if(null==pxjgBean){
		 
		 mainkey=officer.getLogin_id();
	 }else{
		 flag="2";
		 mainkey=loginId;
	 }	 
 }else if(dept_type.equals("4")){
	 mainkey=officer.getLogin_id();
     if(null==wsjgBean){
		 
		 mainkey=officer.getLogin_id();
	 }else{
		 flag="2";
		 mainkey=loginId;
	 }	 
 }

 %>
</head>
<body> 
<input type="hidden" id="mainkey" name="mainkey" value="<%=mainkey %>"/>
<input type="hidden" id="flag" name="flag" value="<%=flag %>"/>
<jsp:include page="../index/qyindexhead.jsp" />
<div class="box1" ></div>
  <div id="layout1" style="width:1000px; margin:0 auto; margin-top:4px; "> 
        <div position="left"  title="菜单" id="accordion1" > 
                    <div>
                    <div style=" height:7px;"></div>
                         <ul id="tree1" style="margin-top:3px;">
                    </div> 
                   
        </div>
        <div position="center" id="framecenter"> 
        </div>
            <div tabid="home" title="我的主页" style="height:300px" ><%--
                <iframe frameborder="0" name="home" id="home" src="<%=webpath %>welcome.jsp"></iframe>
            --%></div> 
  </div> 
    <jsp:include page="../index/qyindexfoot.jsp" />
</body>
</html>

