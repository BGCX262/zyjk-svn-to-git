/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-02   孙雁斌            新規作成 ;
 ****************************************************/
 var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="600";
var openHeight="350"; 
var zbid;
//初始;
$(function (){
try{
 /*布局*/
 $("#layout").ligerLayout({leftWidth: 200 });
 /*grid*/    
 var toolbar =   [
  { line: true },
 { text: '添加', click:f_add,icon: 'modify' }, 
  { line: true },
  { text: '修改', click:f_update,icon: 'modify' }
   ]; 
   
  zbid=getUrlParam("zbid"); 
   
 grid =  sub_Grid('ZczjpzbGrid','判定列表',toolbar," and ffsysn='"+ $("#sysno").val() +"'");  
 document.getElementById("zbid").value=zbid;
 
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 
    }
       

        /*根据条件查询*/
     function f_search(){
         try{
              var strWhere = " ";           
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
        
        /*销除*/
      function f_add(){ 
         try {
          
        var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        var strId;
        
        //salert("fasfsafa"+);
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjkpd/PdAction_findByKey.action?messageBean.method=add&sysno="+ $("#sysno").val(), width: openWidth,height:openHeight, title: '自查自纠',
         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
         //f_search(); 
        }catch (e) {
                 $.ligerDialog.error(e.message);
       } 
        } 
 
 
 
 
        
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
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjkpd/PdAction_findByKey.action?messageBean.method=update&sysno='"+ $("sysno").val() +"'&strSysno="+strId, width: openWidth,height:openHeight, title: '自查自纠',
         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
         //f_search(); 
        }
        }catch (e) {
                 $.ligerDialog.error(e.message);
       } 
        } 