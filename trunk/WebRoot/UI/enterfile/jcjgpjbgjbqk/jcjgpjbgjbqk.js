/****************************************************
 * <p>处理内容：评价报告基本情况</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14    孙雁斌           新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="680";
var openHeight="420"; 
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
 { text: '检测评价报告', click:f_look,  icon:'pager' } 
   ]; 
 grid = sub_Grid('pjbgjbqkGrid','检测、评价报告与记录',toolbar," and jsdwbh like '%"+ getUrlParam("strSysno") +"%'");
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  //myWindow = top.$.ligerDialog.open({url:webpath+"/UI/enterfile/ldzjbxx/ldzjbxxmain.jsp?sysno="+ data.sysno +"&enterno="+data.enterno, width: openWidth,height:openHeight, title:"劳动者基本信息",
 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });
  //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: data.wtdwmc+'检测、评价报告与记录', url: webpath+'/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkmain.jsp?sysno='+ data.sysno +'&enterno='+getUrlParam("strSysno") }); 
  //window.showModalDialog(webpath+'/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkmain.jsp?sysno='+ data.sysno +'&enterno='+getUrlParam("strSysno"),"","dialogHeight:600px;dialogWidth:1000px;");    
   loadSubWindow(webpath+'/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkmain.jsp?sysno='+ data.sysno +'&enterno='+getUrlParam("strSysno"));          
  }catch (e) {
$.ligerDialog.error(e.message);
    }
    }
        
        

        /*根据条件查询*/
     function f_search(){
         try{
              var strWhere =" ";           
     
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
                    $.post(webpath+"/UI/action/Jcjgpjbgjbqk/JcjgpjbgjbqkAction_delete.action",{strSysno:strId},function(data){
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
        if(selected !=null){
          strId=selected.enterno;
        }else{
          strId="";
        }   
        myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/Jcjgpjbgjbqk/JcjgpjbgjbqkAction_findByKey.action?messageBean.method=add&jsdwbh="+getUrlParam("strSysno")+"&strSysno="+strId,  width: openWidth,height:openHeight, title: '检测、评价报告与记录',
        showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
          
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
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/Jcjgpjbgjbqk/JcjgpjbgjbqkAction_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '检测、评价报告与记录',
         showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
         
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
                 //myWindow = top.$.ligerDialog.open({url: webpath+"/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkmain.jsp?sysno="+ selected.sysno +"&enterno="+getUrlParam("strSysno"), width: "900",height:"600", title: '检测、评价报告与记录',
                 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
                 //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.wtdwmc+'检测、评价报告与记录', url: webpath+'/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkmain.jsp?sysno='+ selected.sysno +'&enterno='+getUrlParam("strSysno") });
                //window.showModalDialog(webpath+'/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkmain.jsp?sysno='+ selected.sysno +'&enterno='+getUrlParam("strSysno"),"","dialogHeight:500px;dialogWidth:1000px;");    
                loadSubWindow(webpath+'/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkmain.jsp?sysno='+ selected.sysno +'&enterno='+getUrlParam("strSysno"));
             }
          }catch (e) {
                 $.ligerDialog.error(e.message);
          }
        }
       