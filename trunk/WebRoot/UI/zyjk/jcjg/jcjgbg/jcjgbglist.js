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
var openWidth="700";
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
 { text: '详细信息', click:f_look,  icon:'pager' }, 
 { line: true }, 
 { text: '查看机构信息', click:f_lookjg,  icon:'pager' }    
   ]; 
   
  var jgno=getUrlParam("strSysno");
   if (jgno==null||jgno.length == 0){
 		grid =  Grid('pjbgjbqkGrid','检测机构评价报告管理',toolbar);  
 	}else{
 		grid =  sub_Grid('pjbgjbqkGrid','检测机构评价报告管理',toolbar," and wtdwbh like '%" + jgno+ "%' ");
 		
 		document.getElementById("jgno").value=jgno;  
 	} 
 
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  //myWindow = top.$.ligerDialog.open({url:webpath+"/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkmain.jsp?sysno="+ data.sysno +"&enterno="+data.enterno, width: openWidth,height:openHeight, title:"劳动者基本信息",
 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });
  //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: data.jsdwmc+'报告信息', url:webpath+'/UI/zyjk/jcjg/jcjgbg/jcjgbgmain.jsp?sysno='+ data.sysno +'&enterno='+data.enterno });                     
  loadSubWindow(webpath+'/UI/zyjk/jcjg/jcjgbg/jcjgbgmain.jsp?sysno='+ data.sysno +'&enterno='+data.enterno);
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
              var jgno = $("#jgno").val();
			   if(jgno.length>0) {
			     strWhere += " and wtdwbh like '%"+jgno+"%' ";
			   }
              var jgmc = $("#jgmc").val();
			   if(jgmc.length>0) {
			     strWhere += " and wtdwmc like '%"+jgmc+"%' ";
			   }
			    var pjlx = $("#pjlx").val();
			   if(pjlx.length>0) {
			     strWhere += " and pjlx like '%"+pjlx+"%' ";
			   }
			    var jsdwmc = $("#jsdwmc").val();
			   if(jsdwmc.length>0) {
			     strWhere += " and jsdwmc like '%"+jsdwmc+"%' ";
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
                    $.post(webpath+"/UI/action/zyjk/JcjgbgAction_delete.action",{strSysno:strId},function(data){
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
        myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/JcjgbgAction_findByKey.action?messageBean.method=add&jgbh="+getUrlParam("strSysno")+"&strSysno="+strId,  width: openWidth,height:openHeight, title: '检测、评价报告与记录',
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
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/JcjgbgAction_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:450, title: '检测、评价报告与记录',
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
                 // myWindow = top.$.ligerDialog.open({url: webpath+"/UI/zyjk/jcjg/jcjgbg/jcjgbgmain.jsp?sysno="+ selected.sysno +"&enterno="+selected.enterno, width: 960,height:600, title: '检测、评价报告与记录',
                 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
              //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.jsdwmc+'报告信息', url:webpath+'/UI/zyjk/jcjg/jcjgbg/jcjgbgmain.jsp?sysno='+ selected.sysno +'&enterno='+selected.jsdwbh });
              loadSubWindow(webpath+'/UI/zyjk/jcjg/jcjgbg/jcjgbgmain.jsp?sysno='+ selected.sysno +'&enterno='+selected.jsdwbh);        
             }
          }catch (e) {
                 $.ligerDialog.error(e.message);
          }
        }
        
         /*Grid查看机构信息*/
        function f_lookjg()
        {
          try {
          //alert("查看机构信息");
            var manager = $("#mainGrid").ligerGetGridManager(); 
            var selected = manager.getSelectedRow(); 
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
                 //myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/JcjgryglAction_findByKey.action?messageBean.method=look&strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '检测机构人员列表',
                 //showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
                //  myWindow = top.$.ligerDialog.open({url: webpath+"/UI/zyjk/jcjg/jcjgmain.jsp?sysno="+selected.wtdwbh, width: 960,height:600, title: '检测机构信息',
                // showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });
            //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.wtdwmc+'机构信息', url:webpath+'/UI/zyjk/jcjg/jcjgmain.jsp?sysno='+selected.wtdwbh });     
               loadSubWindow(webpath+'/UI/zyjk/jcjg/jcjgmain.jsp?sysno='+selected.wtdwbh);
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       
       