/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-06               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="1000";
var openHeight="650"; 
var zbid;
var sqlc="";
var zgsql="";
var dtsql="";
//初始;
$(function (){
try{
 /*布局*/
 $("#layout").ligerLayout({leftWidth: 200 });
 /*grid*/    
 var toolbar =   [
 //{ text: '新建', click:f_add,icon: 'add' }, 
 //{ line: true },
 //{ text: '修改', click:f_update,icon: 'modify' },
 //{ line: true },
 { text: '删除', click:f_remove,icon:'delete' }, 
 { line: true }, 
 { text: '查看', click:f_look,  icon:'pager' },
 { line: true }, 
 { text: '自改情况', click:f_zgqk,  icon:'msn' }, 
 { line: true },
 { text: '核查', click:f_check,  icon:'msn' }
   ]; 
   
  zbid=getUrlParam("zbid"); 
  
  var distcode=document.getElementById("distcode").value;

  if(distcode!=null&&distcode.length>0){
  		if(distcode.indexOf("00000000")>=0){
				distcode=distcode.substring(0, 4);
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				distcode=distcode.substring(0, 6);
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				distcode=distcode.substring(0, 9);
			}
			sqlc+=" and ditcode like '"+distcode+"%'";
  }
  //判断是否县属以上企业
 
 if(getUrlParam("zhuguan")=='04'){
   zgsql+=" and enterno in (select enterno from qyjbqk where zhuguan<>'04')";
 } 
 
 
 grid =  sub_Grid('ZczjGrid','自查自纠',toolbar," and bak1 in ('1','3') and zbid='" + getUrlParam("zbid") + "'"+sqlc+zgsql);  
 document.getElementById("zbid").value=zbid;
 
  /*TREE*/
  /*
 tree=$("#tree").ligerTree({         
             //data:[{id:'1',pid:'0',children:[],text:'行政区划',isexpand:'false'}],
             idFieldName :'id',
             parentIDFieldName :'pid', 
             url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree&strWhere= and Depth in (1,2,3) ",
             
             nodeWidth : 200,
             checkbox: false,
             slide: false, 
             method:"post",       
             //parms:{"strWhere":" and Depth in (1,2) "},                
          //   onExpand:onExpand,
            // onBeforeExpand: onBeforeExpand,
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
         $("#zcsj").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
         $("#zcsje").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
         
    $("#hyflname").ligerComboBox({
                width: 130,
                selectBoxWidth: 180,
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
                       		$("#hyflname").val(node.data.text);
                       		$("#hyfl").val(node.data.id);
                   		}
                       
                    }
            });
            
      $("#prjName").ligerComboBox({
                width: 130,
                selectBoxWidth: 180,
                selectBoxHeight: 250, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=BzbTree&strTreeID=T_YHZC_BZZB370000130605000001', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                                              		
                       		
                       		$("#prjName").val(node.data.text);
                       		$("#prjLevel").val(node.data.level);
                       		$("#prj").val(node.data.id);
                   		}
                       
                    }
            });      
         
         
         
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
		              		 			columntree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":strWhere});
		              		 		
		              		 		}else if(node.data.depth=='3'){
		              		 			strWhere=" and code like '"+node.data.id.substring(0, 9)+"%' and depth=4 ";
		              		 			//alert(strWhere);
		              		 			columntree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":strWhere});
		              		 		}else{
		                           		columntree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree",{"strWhere":" and Depth in (1,2) "});
		              		 		}
		                    }
		                 },
		                 //onSelect: function (node)
                 // {                       
                 //    var nodeid=node.data.id;                                      
                 //    t_enter(nodeid);
                 //},
                   		onClick: function (node)
                    	{                                              		
                       		//t_enter(node.data.id);
                       		
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
  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/action/zyjk/ZczjAction_getZczjList.action?messageBean.method=look&strSysno="+data.sysno+"&zbid="+zbid, width: openWidth,height:openHeight, title:"自查自纠",
 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
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
			strWhere+=" and ditcode like '"+nodeid+"%'  and bak1 in ('1','3')"+zgsql;
			dtsql=strWhere;
				
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
              var strWhere = " and bak1 in ('1','3') and zbid='" + getUrlParam("zbid") + "'"+zgsql; 
                           
     //单位名称
     var dwmc = $("#dwmc").val();
     if(dwmc.length>0) {
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
        strWhere += " and ditcode like '%"+ditcode+"%' ";
       }
   
   //行业分类
   var hyfl = $("#hyfl").val();
     if(hyfl.length>0) {
       strWhere += " and enterno  in(select enterno from qyjbqk where hyfl = '"+ hyfl +"') ";
     }
     
     //项目类别
     var prj = $("#prj").val();
     if(prj.length>0) {
       var prjLevel = $("#prjLevel").val();
       if(prjLevel=='1'){
          $.ligerDialog.warn("请选择详细检查项目");
       }else{
          strWhere += " and zbid in(select zbsysno from zczjdfb where  fs='1' and nrsysno like '%"+ prj +"%') ";
       }
     }
     
   
     //自查开始时间
     var zcsj = $("#zcsj").val();
     if(zcsj.length>0) {
       strWhere += " and zcsj >= '"+zcsj+"' ";
     }
     
     //自查结束时间
     var zcsje = $("#zcsje").val();
     if(zcsj.length>0) {
       strWhere += " and zcsj <= '"+zcsje+"' ";
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
                    }
                    $.post(webpath+"/UI/action/zyjk/ZczjAction_delete.action",{strSysno:strId},function(data){
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
        
        myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/ZczjAction_getZczjList.action?messageBean.method=add&strSysno="+strId+"&zbid="+zbid,  width: openWidth,height:openHeight, title: '自查自纠',
        showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
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
        if(selected==null){
         $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else if(selected !=null){
          strId=selected.sysno;
        }
        
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/ZczjAction_getZczjList.action?messageBean.method=update&strSysno="+strId+"&zbid="+zbid, width: openWidth,height:openHeight, title: '自查自纠',
         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
         //f_search(); 
        }
        }catch (e) {
                 $.ligerDialog.error(e.message);
       } 
        } 
        
        
        /*核查*/
        function f_check(){
           
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
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjkck/ZczjAction_getZczjList.action?messageBean.method=update&strSysno="+strId+"&zbid="+zbid, width: openWidth,height:openHeight, title: '自查自纠',
         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
         //f_search(); 
        }
        }catch (e) {
                 $.ligerDialog.error(e.message);
       } 
        }
        
         /*自改情况*/
        function f_zgqk(){
           
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
         //myWindow = top.$.ligerDialog.open({url: webpath+"/UI/zczj/zglist.jsp?zbid="+strId, width: openWidth,height:openHeight, title: '自查自纠',
         //showMax: true, showToggle: true, showMin: false, isResize: false, slide: false });
          top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: '自改情况', url:webpath+"/UI/zczj/zglist.jsp?zbid="+strId });            
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
                 myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/ZczjAction_getZczjList.action?messageBean.method=look&strSysno="+selected.sysno+"&zbid="+zbid, width: openWidth,height:openHeight, title: '自查自纠列表',
                 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }