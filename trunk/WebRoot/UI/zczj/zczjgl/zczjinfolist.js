/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-03    孙雁斌           新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="650";
var openHeight="450"; 
//var zbid;
var sqlc="";
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
 { text: '判定', click:f_judge,icon:'msn' }    
   ]; 
   
 grid =  sub_Grid('BzbGrid','自查自纠',toolbar," and zbid='"+ $("#zbid").val() +"'");  
 //document.getElementById("zbid").value=zbid;
 
  /*TREE*/
 $("#tree").ligerTree({         
             data:[{id:'1',pid:'0',children:[],text:$("#bzzmc").val(),isexpand:'false'}],
             idFieldName :'id',
             parentIDFieldName :'pid', 
             //url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",
             nodeWidth : 200,
             checkbox: false,
             //isexpand:true,
             slide: false,                        
          //   onExpand:onExpand,
             onBeforeExpand: onBeforeExpand,
            onClick: function(node)
                  {
                     if(node.data.children && node.data.children.length == 0){
                         var strWhere=" ";             
                         //tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree&strWhere="+ strWhere);
                         //tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=BzbTree");
                     }
                  }, 
             onSelect: function (node)
                 {                                                          
                   var nodeid=node.data.id;                                      
                    t_enter(nodeid);
                }
         });
         
         tree = $("#tree").ligerGetTreeManager(); 
         
         $("#zcsj").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
 
  }catch (e) {
	$.ligerDialog.error(e.message);
    }
    }
    
    /*展开事件*/ 
      function onExpand(node){
            var nodeid=node.data.id;

       }
       /*Tree展开事件*/ 
      function onBeforeExpand(node){
            var nodeid=node.data.id;
            if(node.data.children && node.data.children.length == 0){
               //tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree");
               tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=EBzbTree&strTreeID="+ $("#zbid").val());
            }  
        }         
        
     /*Tree查看*/
        function t_enter(nodeid){
        try{           
          
          if(nodeid=="1"){
            var strWhere = "  and zbid='"+ $("#zbid").val() +"' and parentid in('0','1')";    
          }else{
             var strWhere = "  and zbid='"+ $("#zbid").val() +"' and parentid='"+nodeid+"'";    
          }       
                 	
			//alert(strWhere);	
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
                         strId = strId+",'"+selected[i].id+"'";
                       }
                    }
                    $.post(webpath+"/UI/action/zyjkbzb/BzbAction_delete.action",{strSysno:strId},function(data){
                       if(data.checkFlag==MSG_SUCCESS){
                         //f_search();                        
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
         var node = tree.getSelected();    
        var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        var strId;
        if(null==node){
            $.ligerDialog.warn("请先选择上级结点");
        }else{
            myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjkbzb/BzbAction_findByKey.action?messageBean.method=add&parentid="+ node.data.id +"&zbid="+ $("#zbid").val(),  width: openWidth,height:openHeight, title: '自查自纠',
            showMax: true, showToggle: true, showMin: false, isResize: false, slide: false });
        }
 
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
          strId=selected.id;
        }
        
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjkbzb/BzbAction_findByKey.action?messageBean.method=update&strSysno="+strId+"&zbid="+zbid, width: openWidth,height:openHeight, title: '自查自纠',
         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
         //f_search(); 
        }
        }catch (e) {
                 $.ligerDialog.error(e.message);
       } 
        } 
        
        
        function f_judge()
        {
        
        try {
          
        var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        var strId;
        if(selected==null){
         $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else if(selected !=null){
          strId=selected.id;
        }
        
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjkpd/BzbAction_findByKey.action?messageBean.method=add&strSysno="+strId+"&zbid="+zbid, width: openWidth,height:openHeight, title: '评判标准',
         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
         //f_search(); 
        }
        }catch (e) {
                 $.ligerDialog.error(e.message);
       } 
           
        }
        
        
