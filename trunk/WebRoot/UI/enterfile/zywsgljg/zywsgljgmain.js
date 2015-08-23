/****************************************************
 * <p>处理内容：职业卫生管理机构</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-08-19               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="700";
var openHeight="360"; 
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
 { text: '机构成员', click:f_member,  icon:'pager' }  
   ]; 
 grid = sub_Grid('qywsjgGrid','职业卫生管理机构',toolbar," and enterno like '%" + getUrlParam("strSysno") + "%'");
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/action/qywsjg/QywsjgAction_findByKey.action?messageBean.method=look&strSysno="+data.sysno, width: openWidth,height:openHeight, title:"职业卫生管理机构",
 showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
  }catch (e) {
$.ligerDialog.error(e.message);
    }
    }

        /*根据条件查询*/
     function f_search(){
         try{
              var strWhere = " and enterno like '%" + getUrlParam("strSysno") + "%' ";       
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
        if (selected==null&&node==null) {
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
                    $.post(webpath+"//UI/action/qywsjg/QywsjgAction_delete.action",{strSysno:strId},function(data){
                       if(data.checkFlag==MSG_SUCCESS){
                         //f_search();                        
                         $.ligerDialog.success(data.checkMessage);
                         f_search();  
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
        if(selected !=null){
          strId=selected.enterno;
        }else{
          strId="";
        }                                                                 
        myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/qywsjg/QywsjgAction_findByKey.action?messageBean.method=add&enterno="+getUrlParam("strSysno"),  width: openWidth,height:openHeight, title: '职业卫生管理机构',
        showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
           //f_search();   
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
        if(selected !=null){
          strId=selected.sysno;
        }else{
          strId="";
        }
        //alert("strId:"+strId);
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/qywsjg/QywsjgAction_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '职业卫生管理机构',
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
                 myWindow = top.$.ligerDialog.open({url: webpath+"//UI/action/qywsjg/QywsjgAction_findByKey.action?messageBean.method=look&strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '职业卫生管理机构',
                 showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       function f_member(){
            try {
            var manager = $("#mainGrid").ligerGetGridManager(); 
            var selected = manager.getSelectedRow(); 
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
             	
              top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.jgmc+'人员信息', url:webpath+'/UI/enterfile/zywsgljg/zywsgljg.jsp?enterno='+selected.enterno+'&deptno='+selected.sysno }); 
              
              //alert("enterno"+selected.enterno);
              //alert("deptno"+selected.sysno);
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
       
       }