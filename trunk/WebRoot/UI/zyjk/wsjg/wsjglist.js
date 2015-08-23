/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- jmx ---------- Note -------------------
 * 1.0  2013-05-23               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="660";
var openHeight="440"; 
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
 grid =  Grid('WsjgGrid','卫生机构列表',toolbar);  
 $("#pzsj").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  //myWindow = top.$.ligerDialog.open({url:webpath+"/UI/action/zyjk/WsjgbaAction_findByKey.action?messageBean.method=look&strSysno="+data.sysno, width: openWidth,height:openHeight, title:"卫生机构列表",
 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });
 // top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: data.jgmc+'信息', url:webpath+'/UI/zyjk/wsjg/wsjgmain.jsp?messageBean.method=look&sysno='+data.sysno }); 
 loadSubWindow(webpath+'/UI/zyjk/wsjg/wsjgmain.jsp?messageBean.method=look&sysno='+data.sysno);             
  }catch (e) {
$.ligerDialog.error(e.message);
    }
    }
       

        /*根据条件查询*/
     function f_search(){
         try{
              var strWhere = " ";           
    
     //机构名称
     var jgmc = $("#jgmc").val();
     if(jgmc.length>0) {
       strWhere += " and jgmc like '%"+jgmc+"%' ";
     }
     //地址
     var jgdz = $("#jgdz").val();
     if(jgdz.length>0) {
       strWhere += " and jgdz like '%"+jgdz+"%' ";
     }
     
     //批准文号
     var pzwh = $("#pzwh").val();
     if(pzwh.length>0) {
       strWhere += " and pzwh like '%"+pzwh+"%' ";
     }
     //批准单位
     var pzdw = $("#pzdw").val();
     if(pzdw.length>0) {
       strWhere += " and pzdw like '%"+pzdw+"%' ";
     }
     //批准时间
     var pzsj = $("#pzsj").val();
     if(pzsj.length>0) {
       strWhere += " and pzsj like '%"+pzsj+"%' ";
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
                    $.post(webpath+"/UI/action/zyjk/WsjgbaAction_delete.action",{strSysno:strId},function(data){
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
        
        if(selected==null){
         //$.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else if(selected !=null){
          strId=selected.sysno;
        }
        myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/WsjgbaAction_findByKey.action?messageBean.method=add&strSysno="+strId,  width: openWidth,height:openHeight, title: '职业卫生机构',
        showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
         //  f_search();   
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
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/WsjgbaAction_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '职业卫生机构',
         showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
         f_search(); 
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
             	
               //  myWindow = top.$.ligerDialog.open({url: webpath+"/UI/zyjk/wsjg/wsjgmain.jsp?messageBean.method=look&sysno="+selected.sysno, width: 900,height:600, title: '卫生机构信息查看',
               //  showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
              //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.jgmc+'信息', url:webpath+'/UI/zyjk/wsjg/wsjgmain.jsp?messageBean.method=look&sysno='+selected.sysno }); 
               loadSubWindow(webpath+'/UI/zyjk/wsjg/wsjgmain.jsp?messageBean.method=look&sysno='+selected.sysno);
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       
     