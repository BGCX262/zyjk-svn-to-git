/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-05               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="900";
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
 { text: '查看', click:f_look,  icon:'pager' } 
   ]; 
 grid =  Grid('NewsGrid','新闻列表',toolbar);  
 
  $("#isscuedate").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
 
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/action/news/NewsAction_findByKey.action?messageBean.method=look&strSysno="+data.sysno, width: openWidth,height:openHeight, title:"新闻信息",
 showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
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
     //标题
     var title = $("#title").val();
     if(title.length>0) {
       strWhere += " and title like '%"+title+"%' ";
     }
     //时间
     var isscuedate = $("#isscuedate").val();
     if(isscuedate.length>0) {
       strWhere += " and isscuedate like '%"+isscuedate+"%' ";
     }
     //类型
     var messagetype = $("#messagetype").val();
     if(messagetype.length>0) {
       strWhere += " and messagetype like '%"+messagetype+"%' ";
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
                    }
                    $.post(webpath+"/UI/action/news/NewsAction_delete.action",{strSysno:strId},function(data){
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

             var manager = $("#mainGrid").ligerGetGridManager(); 
             var selected = manager.getSelectedRow();        
             var strId;
             myWindow =top.$.ligerDialog.open({ url: webpath+"/UI/action/news/NewsAction_findByKey.action?messageBean.method=add&strSysno="+strId,  width: openWidth,height:openHeight, title: '新闻信息',
             showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
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
        var strId=selected.sysno;

        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{        
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/news/NewsAction_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '新闻信息',
         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
        // f_search(); 
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
                 myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/news/NewsAction_findByKey.action?messageBean.method=look&strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '新闻信息',
                 showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
      