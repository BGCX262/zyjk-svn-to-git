/****************************************************
 * <p>处理内容：劳动者健康检查结果</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29  新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="670";
var openHeight="400"; 
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
 { text: '人员', click:f_lookry,  icon:'pager' },
 { line: true }, 
 { text: '单位', click:f_lookdw,  icon:'pager' },
 { line: true }, 
 { text: '体检机构', click:f_looktj,  icon:'pager' }    
   ]; 
   
   
   $("#zcsj").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
   $("#zcsje").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
   
   
 grid = sub_Grid('qyzywsjkjcjgGrid','劳动者健康检查结果',toolbar," and tjdwbh like '%" + getUrlParam("tjdwbh") + "%' ");
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/action/ldzjkjcjg/LdzjkjcjgAction_findByKey.action?messageBean.method=look&enterno="+ getUrlParam("enterno") +"&strSysno="+data.sysno, width: openWidth,height:openHeight, title:"劳动者健康检查结果",
 showMax: false, showToggle: false, showMin: false, isResize: true, slide: false }); 
  }catch (e) {
$.ligerDialog.error(e.message);
    }
    }
        
        

        /*根据条件查询*/
     function f_search(){
         try{
              var strWhere = " and tjdwbh like '%" + getUrlParam("tjdwbh") + "%' ";           
              
     
             var manager = $("#mainGrid").ligerGetGridManager();  
              //manager.loadServerData({strWhere:strWhere},function (countmain) {
             //   alert(countmain);
              //});
                var jgmc = $("#jgmc").val();
			   if(jgmc.length>0) {
			     strWhere += " and jgmc like '%"+jgmc+"%' ";
			   }
			    var jcdwmc = $("#jcdwmc").val();
			   if(jcdwmc.length>0) {
			     strWhere += " and entername like '%"+jcdwmc+"%' ";
			   }
			    var ldzxm = $("#ldzxm").val();
			   if(ldzxm.length>0) {
			     strWhere += " and ldzxm like '%"+ldzxm+"%' ";
			   }
			   
			   
			   //开始时间
                var zcsj = $("#zcsj").val();
               if(zcsj.length>0) {
                   strWhere += " and jcdate >= '"+zcsj+"' ";
               }
     
              //结束时间
                var zcsje = $("#zcsje").val();
                if(zcsj.length>0) {
                    strWhere += " and jcdate <= '"+zcsje+"' ";
                }		   
			   
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
                    $.post(webpath+"//UI/action//ldzjkjcjg/LdzjkjcjgAction_delete.action",{strSysno:strId},function(data){
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
        myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/ldzjkjcjg/LdzjkjcjgAction_loginFindByKey.action?messageBean.method=add&tjdwbh="+ getUrlParam("enterno") +"&ldzbh="+getUrlParam("strSysno")+"&strSysno="+strId,  width: openWidth,height:openHeight, title: '劳动者健康检查结果',
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
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/ldzjkjcjg/LdzjkjcjgAction_findByKey.action?messageBean.method=update&enterno="+ getUrlParam("enterno") +"&strSysno="+strId, width: openWidth,height:openHeight, title: '劳动者健康检查结果',
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
                 myWindow = top.$.ligerDialog.open({url: webpath+"//UI/action/ldzjkjcjg/LdzjkjcjgAction_findByKey.action?messageBean.method=look&enterno="+ getUrlParam("enterno") +"&strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '劳动者健康检查结果',
                showMax: false, showToggle: false, showMin: false, isResize: true, slide: false }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
        /*人员*/
        function f_lookry(){
             try {
                var manager = $("#mainGrid").ligerGetGridManager(); 
                var selected = manager.getSelectedRow(); 
                if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
                }else{
                //alert("selected.ldzbh:"+selected.ldzbh);
                //  top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.ldzxm+'基本信息', url: webpath+'/UI/enterfile/ldzjbxx/ldzjbxxmain.jsp?sysno='+ selected.ldzbh +'&enterno='+selected.enterno });
               loadSubWindow(webpath+'/UI/enterfile/ldzjbxx/ldzjbxxmain.jsp?sysno='+ selected.ldzbh +'&enterno='+selected.enterno);
                }
            }catch (e) {
                 $.ligerDialog.error(e.message);
            }
        }
        /*单位*/
        function f_lookdw(){
             try {
                var manager = $("#mainGrid").ligerGetGridManager(); 
                var selected = manager.getSelectedRow(); 
                if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
                }else{
                   //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.entername+'档案库', url: webpath+'UI/enterfile/info/enterinfomain.jsp?enterno='+selected.enterno });
                   loadSubWindow(webpath+'UI/enterfile/info/enterinfomain.jsp?enterno='+selected.enterno);
                }
            }catch (e) {
                $.ligerDialog.error(e.message);
            }
        }
        /*体检*/
        function f_looktj(){
            try {
                var manager = $("#mainGrid").ligerGetGridManager(); 
                var selected = manager.getSelectedRow(); 
                if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
                }else{
                   //alert("selected.tjdwbh:"+selected.tjdwbh);
                   //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.tjdwmc+'信息', url:webpath+'/UI/zyjk/wsjg/wsjgmain.jsp?messageBean.method=look&sysno='+selected.tjdwbh });      
                  loadSubWindow(webpath+'/UI/zyjk/wsjg/wsjgmain.jsp?messageBean.method=look&sysno='+selected.tjdwbh);
                }
            }catch (e) {
                 $.ligerDialog.error(e.message);
            }
        }
       