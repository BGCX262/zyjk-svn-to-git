/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-22    孙雁斌           新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="980";
var openHeight="700"; 
var sqlc="";
//初始;
$(function (){
try{
 /*布局*/
 $("#layout").ligerLayout({leftWidth: 200 });
 /*grid*/    
 var toolbar =   [
 {text: '增加', click:f_add,  icon:'add'},
 {text: '修改', click:f_update,  icon:'modify'},
 {text: '删除', click:f_remove,  icon:'delete'},
 { text: '档案库信息', click:f_look,  icon:'pager'} 
   ]; 
   
 
  var distcode=document.getElementById("distcode").value;

  if(distcode!=null&&distcode.length>0){
  		if(distcode.indexOf("00000000")>=0){
				distcode=distcode.substring(0, 4);
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				distcode=distcode.substring(0, 6);
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				distcode=distcode.substring(0, 9);
			}
			sqlc+=" and distcode like '"+distcode+"%'";
  }  
 
   
 grid =  sub_Grid('qyjbqkGrid','企业列表',toolbar,sqlc); 
 
 /*行业分类*/
            $("#hylbname").ligerComboBox({
                width: 130,
                selectBoxWidth: 200,
                selectBoxHeight: 250, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=HYFLTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                                              		
                       		$("#hylbname").val(node.data.text);
                       		$("#hylb").val(node.data.id);
                   		}
                       
                    }
            }); 
 
/*TREE
  $("#tree").ligerTree({         
              //data:[{id:'1',pid:'0',children:[],text:'行政区划',isexpand:'false'}],
              idFieldName :'id',
              parentIDFieldName :'pid', 
                url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree&strWhere= and Depth in (1,2,3) ",
              nodeWidth : 200,
              checkbox: false,
              slide: false,                        
              //onExpand:onExpand,
               onBeforeExpand: function(node)
                  {
                     if(node.data.children && node.data.children.length == 0){
                       var strWhere="";
               		 		//alert(node.data.depth);
               		 		if(node.data.depth=='2'){
               		 			strWhere=" and code like '"+node.data.id.substring(0, 6)+"%' and depth=3 ";
               		 			tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":strWhere});
               		 		
               		 		}else if(node.data.depth=='3'){
               		 			strWhere=" and code like '"+node.data.id.substring(0, 9)+"%' and depth=4 ";
               		 			//alert(strWhere);
               		 			tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":strWhere});
               		 		}else{
                            	tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":" and Depth in (1,2,3) "});
               		 		}
                     }
                  }, 
             
              onSelect: function (node)
                  {                       
                     var nodeid=node.data.id;                                      
                     t_enter(nodeid);
                 }
          });
          
          tree = $("#tree").ligerGetTreeManager();  
          
         */ 
          
          var colselect=$("#distcodename").ligerComboBox({
                width: 130,
                selectBoxWidth: 200,
                selectBoxHeight: 400, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree&strWhere= and Depth in (1,2,3) ', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid', 
                        onBeforeExpand: function(node)
		                 {
		                   if(node.data.children && node.data.children.length == 0){
                              var strWhere="";
               		 		//alert(node.data.depth);
               		 		
               		 		if(node.data.depth=='2'){
               		 			strWhere=" and code like '"+node.data.id.substring(0, 6)+"%' and depth=3 ";
               		 			tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":strWhere});
               		 		
               		 		}else if(node.data.depth=='3'){
               		 			strWhere=" and code like '"+node.data.id.substring(0, 9)+"%' and depth=4 ";
               		 			//alert(strWhere);
               		 			tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":strWhere});
               		 		}else{
                            	tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":" and Depth in (1,2,3) "});
               		 		}
               		 		
               		 	   }
		                 },
		         //        onSelect: function (node)
                 // {                       
                 //    var nodeid=node.data.id;                                      
                 //    t_enter(nodeid);
                 //},
                   		onClick: function (node)
                    	{                                              		
                       		
                       		$("#distcode").val(node.data.id);
                       		$("#distcodename").val(node.data.text);               		 		
                       		f_search();
                   		}
                       
                    }
            });
            var  columntree = colselect.tree.ligerGetTreeManager();
          
          
          
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
   var manager = $("#mainGrid").ligerGetGridManager(); 
  var selected = manager.getSelectedRow(); 
  // myWindow = top.$.ligerDialog.open({url: webpath+"/UI/enterfile/info/enterinfomain.jsp?enterno="+selected.enterno, width: openWidth,height:openHeight, title: '企业列表',
  //               showMax: true, showToggle: true, showMin: false, isResize: true, slide: false });
  //  top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: data.dwmc+'档案库', url: webpath+'UI/enterfile/info/enterinfomain.jsp?enterno='+data.enterno });
    //window.showModalDialog( webpath+'UI/enterfile/info/enterinfomain.jsp?enterno='+data.enterno ,"","dialogHeight:700px;dialogWidth:1200px;");                      
  loadSubWindow(webpath+'UI/enterfile/info/enterinfomain.jsp?enterno='+data.enterno );
   //window.open(webpath+'UI/enterfile/info/enterinfomain.jsrp?enterno='+data.enterno,"newwindow","height=700px,width=1200px,toolbar=yes,menubar=yes,scrollbars=yes,resizable=yes,location=no,status=yes");
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
               tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree");
            }  
        }         
        
     /*Tree查看*/
        function t_enter(nodeid){
        try{           
          var strWhere = " ";           
            if(nodeid.indexOf("00000000")>=0){
				nodeid=nodeid.substring(0, 4);
			}else if(nodeid.indexOf("000000")>=0&&nodeid.indexOf("00000000")<0){
				nodeid=nodeid.substring(0, 6);
			}else if(nodeid.indexOf("000000")<0&&nodeid.indexOf("00000000")<0&&nodeid.indexOf("000")>=0){
				nodeid=nodeid.substring(0, 9);
			}
			strWhere+=" and distcode like '"+nodeid+"%'";	
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
              
     //行业分类 
     var hylb=$("#hylb").val();
 
     if(hylb.length>0) {
       //alert("111");
       strWhere += " and corpkey in (select corpkey from Z_cor where  hyfl like '%"+hylb+"%') ";
     }                     
     //组织机构代码
     var zzjgdm = $("#zzjgdm").val();
   
     if(null!=zzjgdm&&zzjgdm.length>0) {
       strWhere += " and zzjgdm like '%"+zzjgdm+"%' ";
     }
     //主管单位
     var zhuguan = $("#zhuguan").val();
   
     if(null!=zhuguan&&zhuguan.length>0) {
       strWhere += " and zhuguan like '%"+zhuguan+"%' ";
     }
     
     //单位名称
     var dwmc = $("#dwmc").val();
     if(null!=dwmc&&dwmc.length>0) {
       strWhere += " and dwmc like '%"+dwmc+"%' ";
     }
     
     //区划
      var ditcode = $("#distcode").val();
      if(ditcode.length>0) {
        if(ditcode.indexOf("00000000")>=0){
		    ditcode=ditcode.substring(0, 4);
		}else if(ditcode.indexOf("000000")>=0&&ditcode.indexOf("00000000")<0){
		    ditcode=ditcode.substring(0, 6);
		}else if(ditcode.indexOf("000000")<0&&ditcode.indexOf("00000000")<0&&ditcode.indexOf("000")>=0){
		    ditcode=ditcode.substring(0, 9);
		}
        strWhere += " and distcode like '%"+ditcode+"%' ";
      }
     
      
     //注册地址
     var zcdz = $("#zcdz").val();
     if(null!=zcdz&&zcdz.length>0) {
       strWhere += " and zcdz like '%"+zcdz+"%' ";
     }
     //负责人
     var leader = $("#leader").val();
     if(null!=leader&&leader.length>0) {
       strWhere += " and leader like '%"+leader+"%' ";
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
           var node = tree.getSelected(); 
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
                         strId = strId+",'"+selected[i].enterno+"'";
                       }
                    }else{
                       strId = strId+",'"+node.data.id+"'";
                    }
                    $.post(webpath+"//UI/action/enterfile/EnterMain_delete.action",{strSysno:strId},function(data){
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

         //  var node = tree.getSelected();
         var manager1 = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager1.getSelectedRow(); 
        
        var strId;
        if(selected !=null){
          strId=selected.enterno;
        }else{
          strId="";
        }
        myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/enterfile/EnterMain_findByKey.action?messageBean.method=add&strSysno="+strId,  width: openWidth,height:openHeight, title: '用人单位详细信息',
        showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
        //f_search();   
        }catch (e) {
                $.ligerDialog.error(e.message);
         }  
        }
        
        /*修改*/
        function f_update(){ 
         try {
        //   var node = tree.getSelected(); 
         //  var parent=tree.getParent(node); 
        var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        var strId;
        if(selected !=null){
          strId=selected.enterno;
        }else{
          strId="";
        }
        
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/enterfile/EnterMain_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '用人单位详细信息',
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
            var myw = screen.availWidth-200;       
            var myh = screen.availHeight-100;  
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
                // myWindow = top.$.ligerDialog.open({url: webpath+"UI/enterfile/info/enterinfomain.jsp?enterno="+selected.enterno, width: myw,height:myh, title: '企业档案库',
                // showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
               // window.open(webpath+"UI/enterfile/info/enterinfomain.jsp?enterno="+selected.enterno,"newwindow","height=700px,width=1200px,toolbar=yes,menubar=yes,scrollbars=yes,resizable=yes,location=no,status=yes");
             //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.dwmc+'档案库', url: webpath+'UI/enterfile/info/enterinfomain.jsp?enterno='+selected.enterno });
             //alert("test");
             //  window.showModalDialog(webpath+"UI/enterfile/info/enterinfomain.jsp?enterno="+selected.enterno,"","dialogHeight:700px;dialogWidth:1200px;status:no;location:no;resize:no");    
             loadSubWindow(webpath+"UI/enterfile/info/enterinfomain.jsp?enterno="+selected.enterno);
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        } 