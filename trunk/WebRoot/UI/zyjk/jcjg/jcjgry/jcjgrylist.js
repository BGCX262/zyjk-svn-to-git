/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-24               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="620";
var openHeight="350"; 
//初始;
$(function (){
try{
 /*布局*/
 $("#layout").ligerLayout({leftWidth: 200 });
 /*grid*/    
 var toolbar =   [
 { text: '新建', click:f_add,icon: 'add' }, 
 { line: true },
 { text: '修改', click:f_update,icon: 'modify' },
 { line: true },
 { text: '删除', click:f_remove,icon:'delete' }, 
 { line: true }, 
 { text: '查看', click:f_look,  icon:'pager' }, 
 { line: true }, 
 { text: '查看机构信息', click:f_lookjg,  icon:'pager' }  
   ]; 
   
   		var jgno=getUrlParam("strSysno");
	     if (jgno==null||jgno.length == 0){
	 			grid =  Grid('JcjgryGrid','检测机构人员',toolbar); 
	 		}else {
	 			grid =  sub_Grid('JcjgryGrid','检测机构人员',toolbar, " and jgbh like '%" + jgno+ "%' "); 
	 			//$("#jgno").val()=jgno;
	 			document.getElementById("jgno").value=jgno;
	 		} 
	 		
	 	$("#fzdate").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });	
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  //myWindow = top.$.ligerDialog.open({url:webpath+"/UI/action/zyjk/JcjgryglAction_findByKey.action?messageBean.method=look&strSysno="+data.sysno, width: openWidth,height:openHeight, title:"检测机构人员列表",
 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });
 // top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: data.name+'职业卫生信息', url:webpath+'/UI/zyjk/jcjg/jcjgry/jcjgrymain.jsp?strSysno='+data.sysno });             
  loadSubWindow(webpath+'/UI/zyjk/jcjg/jcjgry/jcjgrymain.jsp?strSysno='+data.sysno);
  }catch (e) {
$.ligerDialog.error(e.message);
    }
    }
       /*Tree展开事件*/ 
      function onBeforeExpand(node){
            var nodeid=node.data.id;
            if(node.data.children && node.data.children.length == 0){
               tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=");
            }  
        }         
        
     /*Tree查看*/
        function t_enter(nodeid){
        try{           
          var strWhere = " ";           
             if(nodeid.length>0){          
                 strWhere = " and parentmenuid = '"+nodeid+"' or menuid='"+nodeid+"'";  
             }         
             var manager = $("#mainGrid").ligerGetGridManager();  
             //初始化查询起始页
              manager.set("newPage",1);
              //初始化查询条件
              manager.set("parms",{"strWhere":strWhere});
              manager.loadData(true);
        }catch (e) {
                $.ligerDialog.error(e.message);
         }
                 
        } 

        /*根据条件查询*/
     function f_search(){
         try{
              var strWhere = " ";           
     //机构编号
     var jgbh = $("#jgno").val();
     if(jgbh.length>0) {
       strWhere += " and jgbh like '%"+jgbh+"%' ";
     }
     //机构名称
     var jgmc = $("#jgmc").val();
     if(jgmc.length>0) {
       strWhere += " and jgmc like '%"+jgmc+"%' ";
     }
     //姓名
     var name = $("#name").val();
     if(name.length>0) {
       strWhere += " and name like '%"+name+"%' ";
     }
     
     //职务
     var zw = $("#zw").val();
     if(zw.length>0) {
       strWhere += " and zw like '%"+zw+"%' ";
     }
     //岗位
     var gw = $("#gw").val();
     if(gw.length>0) {
       strWhere += " and gw like '%"+gw+"%' ";
     }
     //资质证书编号
     var zzzsbh = $("#zzzsbh").val();
     if(zzzsbh.length>0) {
       strWhere += " and zzzsbh like '%"+zzzsbh+"%' ";
     }
     //发证日期
     var fzdate = $("#fzdate").val();
     if(fzdate.length>0) {
       strWhere += " and fzdate like '%"+fzdate+"%' ";
     }
             var manager = $("#mainGrid").ligerGetGridManager();  
              //manager.loadServerData({strWhere:strWhere},function (countmain) {
             //   alert(countmain);
              //});
              //初始化查询起始页
              manager.set("newPage",1);
              //初始化查询条件
              manager.set("parms",{"strWhere":strWhere});
              manager.loadData(true);
             }catch (e) {
                $.ligerDialog.error(e.message);
         }
        }
        
        /*删除*/
        function f_remove(){ 
        try {
            
           var strId ="''";
        var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRows(); 
        if (selected==null) {
            $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{              
            $.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state)
              {
               if(state)
               {    
                    if(selected!=null&&selected.length>0){
                       for(var i=0;i<selected.length;i++){
                         strId = strId+",'"+selected[i].sysno+"'";
                       }
                    }else{
                       strId = strId+",'"+node.data.id+"'";
                    }
                    $.post(webpath+"/UI/action/zyjk/JcjgryglAction_delete.action",{strSysno:strId},function(data){
                       if(data.checkFlag==MSG_SUCCESS){
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
        function f_add(){
           try {

          //alert("11111111111111111");
           var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        
        var strId;
        
        var jgbh=$("#jgno").val();
        myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/JcjgryglAction_findByKey.action?messageBean.method=add&strSysno="+strId+"&jgbh="+jgbh,  width: openWidth,height:openHeight, title: '检测机构人员',
        showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
          // f_search();   
        }catch (e) {
                $.ligerDialog.error(e.message);
         }  
        }
        
        /*修改*/
        function f_update(){ 
         try {
           
          
        var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        var strId;
        if(selected==null){
         $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else if(selected !=null){
          strId=selected.sysno;
        }
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/JcjgryglAction_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '检测机构人员',
         showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
         //f_search(); 
        }
        }catch (e) {
                 $.ligerDialog.error(e.message);
       } 
        } 
        
        /*Grid查看*/
        function f_look()
        {
          try {
            var manager = $("#mainGrid").ligerGetGridManager(); 
            var selected = manager.getSelectedRow(); 
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
                 //myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/JcjgryglAction_findByKey.action?messageBean.method=look&strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '检测机构人员列表',
                 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
                 // myWindow = top.$.ligerDialog.open({url: webpath+"/UI/zyjk/jcjg/jcjgry/jcjgrymain.jsp?strSysno="+selected.sysno, width: 900,height:700, title: '检测机构人员列表',
                 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
                // top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.name+'职业卫生信息', url:webpath+'/UI/zyjk/jcjg/jcjgry/jcjgrymain.jsp?strSysno='+selected.sysno }); 
                loadSubWindow(webpath+'/UI/zyjk/jcjg/jcjgry/jcjgrymain.jsp?strSysno='+selected.sysno);
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
        
         /*Grid查看机构信息*/
        function f_lookjg()
        {
          try {
            var manager = $("#mainGrid").ligerGetGridManager(); 
            var selected = manager.getSelectedRow(); 
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
                 //myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/JcjgryglAction_findByKey.action?messageBean.method=look&strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '检测机构人员列表',
                 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
                 // myWindow = top.$.ligerDialog.open({url: webpath+"/UI/zyjk/jcjg/jcjgmain.jsp?sysno="+selected.jgbh, width: 980,height:600, title: '检测机构信息',
                 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
                 //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.jgmc+'机构信息', url:webpath+'/UI/zyjk/jcjg/jcjgmain.jsp?sysno='+selected.jgbh });
                 loadSubWindow(webpath+'/UI/zyjk/jcjg/jcjgmain.jsp?sysno='+selected.jgbh);
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       
       