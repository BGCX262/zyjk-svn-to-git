/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- jmx ---------- Note -------------------
 * 1.0  2013-05-17               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="700";
var openHeight="560"; 
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
 { text: '查看人员', click:f_lookry,  icon:'pager' }, 
 { line: true }, 
 { text: '查看评价报告', click:f_lookbg,  icon:'pager' }, 
 { line: true }, 
 { text: '查看设备', click:f_looksb,  icon:'pager' }  
   ]; 
 grid =  Grid('JcjgGrid','检测机构列表',toolbar);  
 
  $("#fzdate").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
  
   $("#yxq").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
 
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  //myWindow = top.$.ligerDialog.open({url:webpath+"/UI/action/zyjk/JcjgbaAction_findByKey.action?messageBean.method=look&strSysno="+data.sysno, width: openWidth,height:openHeight, title:"检测机构列表",
 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });
 //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: data.dwmc+'信息', url: webpath+'/UI/zyjk/jcjg/jcjgmain.jsp?sysno='+data.sysno });
   loadSubWindow(webpath+'/UI/zyjk/jcjg/jcjgmain.jsp?sysno='+data.sysno);          
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
   //单位名称
   var dwmc = $("#dwmc").val();
   if(dwmc.length>0) {
     strWhere += " and dwmc like '%"+dwmc+"%' ";
   }
   //资质证书编号
   var zzzsbh = $("#zzzsbh").val();
   if(zzzsbh.length>0) {
     strWhere += " and zzzsbh like '%"+zzzsbh+"%' ";
   }
   //行政区划
   //var distcode = $("#distcode").val();
   //if(distcode.length>0) {
   //  strWhere = " and distcode like '%"+distcode+"%' ";
   //}
   //发证日期
   var fzdate = $("#fzdate").val();
   if(fzdate.length>0) {
     strWhere += " and fzdate like '%"+fzdate+"%' ";
   }
   //有效期
   var yxq = $("#yxq").val();
   if(yxq.length>0) {
     strWhere += " and yxq like '%"+yxq+"%' ";
   }
   //法定代表人
   var fddbr = $("#fddbr").val();
   if(fddbr.length>0) {
     strWhere += " and fddbr like '%"+fddbr+"%' ";
   }
   //联系电话
   var lxdh = $("#lxdh").val();
   if(lxdh.length>0) {
     strWhere += " and lxdh like '%"+lxdh+"%' ";
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
      var strId="''";
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
                  $.post(webpath+"/UI/action/zyjk/JcjgbaAction_delete.action",{strSysno:strId},function(data){
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
        strId=selected.sysno;
      }
      //myWindow =top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/JcjgbaAction_findByKey.action?messageBean.method=add&strSysno="+strId,  width: openWidth,height:openHeight, title: '检测机构列表',
      //showMax: true, showToggle: true, showMin: false, isResize: false, slide: false ,buttons: [
      ///          { text: '确定', onclick: f_selectContactOK },
       //         { text: '取消', onclick: f_selectContactCancel}]
       //        });  
       myWindow =top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/JcjgbaAction_findByKey.action?messageBean.method=add&strSysno="+strId,  width: openWidth,height:openHeight, title: '检测机构',
      showMax: false, showToggle: false, showMin: false, isResize: false, slide: false});         
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
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/JcjgbaAction_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '检测机构',
         showMax: false, showToggle: false, showMin: false, isResize: false, slide: false }); 
         //f_search(); 
        }
        }catch (e) {
                 $.ligerDialog.error(e.message);
       } 
        } 
  ///
   /////
        function f_selectContactOK(item, dialog)
        {
			var fn=dialog.frame.submitForm || dialog.frame.window.submitForm; 
			//alert(fn);
			//alert(fn());
			//setTimeout(fn,10000)
			fn();
           	//f_search();
           
          //  dialog.close();
        }
        function f_selectContactCancel(item, dialog)
        {
            dialog.close();
        }
        ////
  ///     
        /*Grid查看*/
        function f_look()
        {
          try {
            var manager = $("#mainGrid").ligerGetGridManager(); 
            var selected = manager.getSelectedRow(); 
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
             	
              //   myWindow =top.$.ligerDialog.open({url: webpath+"/UI/zyjk/jcjg/jcjgmain.jsp?sysno="+selected.sysno, width: 1000,height:600, title: '检测机构列表',
              //   showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
             //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.dwmc+'信息', url: webpath+'/UI/zyjk/jcjg/jcjgmain.jsp?sysno='+selected.sysno });
               loadSubWindow(webpath+'/UI/zyjk/jcjg/jcjgmain.jsp?sysno='+selected.sysno);
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
        
         /*Grid查看机构人员*/
        function f_lookry()
        {
          try {
            var manager = $("#mainGrid").ligerGetGridManager(); 
            var selected = manager.getSelectedRow(); 
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
             	
               //  myWindow =top.$.ligerDialog.open({url: webpath+"/UI/zyjk/jcjg/jcjgry/jcjgrylist.jsp?strSysno="+selected.sysno, width: 900,height:openHeight, title: '检测机构列表',
               //  showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
                top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: '检测机构人员列表', url:webpath+'/UI/zyjk/jcjg/jcjgry/jcjgrylist.jsp?strSysno='+selected.sysno });
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
        
         /*Grid查看机构报告*/
        function f_lookbg()
        {
          try {
            var manager = $("#mainGrid").ligerGetGridManager(); 
            var selected = manager.getSelectedRow(); 
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
             	
              //   myWindow =top.$.ligerDialog.open({url: webpath+"/UI/zyjk/jcjg/jcjgbg/jcjgbglist.jsp?strSysno="+selected.sysno, width: 900,height:openHeight, title: '检测机构列表',
              //   showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
               top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: '检测机构报告列表', url:webpath+'/UI/zyjk/jcjg/jcjgbg/jcjgbglist.jsp?strSysno='+selected.sysno });
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       
         /*Grid查看机构设备*/
        function f_looksb()
        {
          try {
            var manager = $("#mainGrid").ligerGetGridManager(); 
            var selected = manager.getSelectedRow(); 
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
             	
              //   myWindow =top.$.ligerDialog.open({url: webpath+"/UI/zyjk/jcjg/jcjgsb/jcjgsblist.jsp?strSysno="+selected.sysno, width: 900,height:openHeight, title: '检测机构列表',
              //   showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });
               top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: '检测机构设备列表', url:webpath+"/UI/zyjk/jcjg/jcjgsb/jcjgsblist.jsp?strSysno="+selected.sysno }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       