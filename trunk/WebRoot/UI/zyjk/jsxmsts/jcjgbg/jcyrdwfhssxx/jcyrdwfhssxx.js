/****************************************************
 * <p>处理内容：用人单位配备的防护设施及个人防护用品</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="630";
var openHeight="300"; 
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
   
  var bgbh=getUrlParam("bgbh");
 if (bgbh==null||bgbh.length == 0){
 		//grid =  Grid('pjbgjbqkGrid','检测机构评价报告管理',toolbar);  
 		
 		grid = Grid('yrdwfhGrid','用人单位配备的防护设施及个人防护用品',toolbar);
 	}else{
 		//grid =  sub_Grid('pjbgjbqkGrid','检测机构评价报告管理',toolbar," and wtdwbh like '%" + jgno+ "%' ");
 		//grid = sub_Grid('jcqkGrid','检测情况',toolbar, " and bgbh like '%" + bgbh+ "%' ");
 		grid = sub_Grid('yrdwfhGrid','用人单位配备的防护设施及个人防护用品',toolbar," and bgbh like '%" + bgbh+ "%' ");
 		document.getElementById("bgbh").value=bgbh;  
 	}  
 
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/action/zyjk/JcyrdwfhssxxAction_findByKey.action?messageBean.method=look&enterno="+ getUrlParam("enterno") +"&strSysno="+data.sysno, width: openWidth,height:openHeight, title:"用人单位配备的防护设施及个人防护用品",
 showMax: false, showToggle: false, showMin: false, isResize: true, slide: false }); 
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
                    $.post(webpath+"/UI/action/zyjk/JcyrdwfhssxxAction_delete.action",{strSysno:strId},function(data){
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
        var bgbh=document.getElementById("bgbh").value;
        myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/JcyrdwfhssxxAction_findByKey.action?messageBean.method=add&enterno="+ getUrlParam("enterno") +"&bgbh="+bgbh+"&strSysno="+strId,  width: openWidth,height:openHeight, title: '用人单位配备的防护设施及个人防护用品',
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
        if(selected !=null){
          strId=selected.sysno;
        }else{
          strId="";
        }
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/JcyrdwfhssxxAction_findByKey.action?messageBean.method=update&enterno="+ getUrlParam("enterno") +"&strSysno="+strId, width: openWidth,height:openHeight, title: '用人单位配备的防护设施及个人防护用品',
         showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
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
                 myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/JcyrdwfhssxxAction_findByKey.action?messageBean.method=look&enterno="+ getUrlParam("enterno") +"&strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '用人单位配备的防护设施及个人防护用品',
                 showMax: false, showToggle: false, showMin: false, isResize: true, slide: false }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       