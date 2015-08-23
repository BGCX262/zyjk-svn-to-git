/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- jmx ---------- Note -------------------
 * 1.0  2013-05-22               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="750";
var openHeight="550"; 
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
 { text: '查看讲师信息', click:f_lookjs,  icon:'pager' }  
   ]; 
 grid =  Grid('PxjgGrid','培训机构列表',toolbar);  
  $("#zsyxqs").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
  
   $("#zsyxqz").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  //myWindow = $.ligerDialog.open({url:webpath+"/UI/action/zyjk/PxjgbaAction_findByKey.action?messageBean.method=look&strSysno="+data.sysno, width: openWidth,height:openHeight, title:"培训机构列表",
 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });
 // top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: data.pxjgmc+'机构信息', url: webpath+'/UI/zyjk/pxjg/pxjgmain.jsp?messageBean.method=look&sysno='+data.sysno }); 
  loadSubWindow(webpath+'/UI/zyjk/pxjg/pxjgmain.jsp?messageBean.method=look&sysno='+data.sysno);           
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
    
     //培训机构名称
     var pxjgmc = $("#pxjgmc").val();
     if(pxjgmc.length>0) {
       strWhere += " and pxjgmc like '%"+pxjgmc+"%' ";
     }
     //地址
     var pxjgdz = $("#pxjgdz").val();
     if(pxjgdz.length>0) {
       strWhere += " and pxjgdz like '%"+pxjgdz+"%' ";
     }
    
     //有效期始
     var zsyxqs = $("#zsyxqs").val();
     if(zsyxqs.length>0) {
       strWhere += " and zsyxqs like '%"+zsyxqs+"%' ";
     }
     //有效期止
     var zsyxqz = $("#zsyxqz").val();
     if(zsyxqz.length>0) {
       strWhere += " and zsyxqz like '%"+zsyxqz+"%' ";
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
                    $.post(webpath+"/UI/action/zyjk/PxjgbaAction_delete.action",{strSysno:strId},function(data){
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
           var manager =$("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        
        var strId;
        
       
        myWindow =top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/PxjgbaAction_findByKey.action?messageBean.method=add&strSysno="+strId,  width: openWidth,height:openHeight, title: '培训机构列表',
        showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
        //   f_search();   
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
        if(selected==null||selected.length == 0){
         $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else if(selected !=null){
          strId=selected.sysno;
        }
        
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/PxjgbaAction_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '培训机构列表',
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
             	
                // myWindow = top.$.ligerDialog.open({url: webpath+"/UI/zyjk/pxjg/pxjgmain.jsp?messageBean.method=look&sysno="+selected.sysno, width: 800,height:600, title: '培训机构列表',
                // showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
               //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.pxjgmc+'机构信息', url: webpath+'/UI/zyjk/pxjg/pxjgmain.jsp?messageBean.method=look&sysno='+selected.sysno }); 
               loadSubWindow(webpath+'/UI/zyjk/pxjg/pxjgmain.jsp?messageBean.method=look&sysno='+selected.sysno);
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
      /*Grid查看*/
        function f_lookjs()
        {
          try {
            var manager = $("#mainGrid").ligerGetGridManager(); 
            var selected = manager.getSelectedRow(); 
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
             	
                 //myWindow = top.$.ligerDialog.open({url: webpath+"/UI/zyjk/pxjg/pxjgjs/pxjgjslist.jsp?messageBean.method=look&strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '培训机构列表',
                 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
                 top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: '培训讲师列表', url: webpath+'/UI/zyjk/pxjg/pxjgjs/pxjgjslist.jsp?messageBean.method=look&strSysno='+selected.sysno }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       
        
       