/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="900";
var openHeight="680"; 
//初始;
$(function (){
try{
 /*布局*/
 $("#layout").ligerLayout({leftWidth: 200 });
 /*grid*/    
 var toolbar =   [
 
 { text: '查看', click:f_look,  icon:'pager' } 
   ]; 
 _grid = $("#mainGrid").ligerGrid({ checkbox: true, 
			 columns:[
               	 	{ display: '企业编号', name: 'corpkey', align: 'center',hide:'true', width: 140 },
	                { display: '单位名称', name: 'dwmc', width: 160, align: 'center' },  
	                { display: '法定代表人', name: 'leader', width: 130, minWidth: 100 }, 
	                { display: '单位地址', name: 'zcdz',width: 130, minWidth: 160  },
	                { display: '联系电话', name: 'lxdh',width: 130, minWidth: 100 },
	                { display: '危害人数', name: 'whrenshu',width: 130, minWidth: 60  },
	                { display: '地区1', name: 'dq3',width: 130,hide:'true', minWidth: 60  },
	                { display: '地区2', name: 'dq4',width: 130,hide:'true', minWidth: 60  },
	                { display: '危害因素', name: 'whysnm',width: 130, minWidth: 160  },
	                { display: '危害因素代码', name: 'whys',width: 130,hide:'true', minWidth: 60  }
                ],
              pageSizeOptions:[15,20,30,40,50], 
			 rownumbers:true,parms:"",
			 dataAction: 'server',url: webpath+"/UI/action/zyjk/ZyjkflfjAction_findList.action",
			 width: '100%',height:'100%',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :false,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			 onDblClickRow:onDblClickRow,
			 pageSize:15,
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 }
			 
			});
/*TREE*/
  $("#tree").ligerTree({         
              data:[{id:'1',pid:'0',children:[],text:'行政区划',isexpand:'false'}],
              idFieldName :'id',
              parentIDFieldName :'pid', 
              nodeWidth : 200,
              checkbox: false,
              slide: false,                        
              onExpand:onExpand,
              onBeforeExpand: onBeforeExpand,
              onSelect: function (node)
                  {                       
                     var nodeid=node.data.id;                                      
                     t_enter(nodeid);
                 },
              onContextmenu: function (node, e)
                  { 
                  actionNodeID = node.data.text;
                  menu.show({ top: e.pageY, left: e.pageX });
                  return false;
                  }
            
          });
          
          tree = $("#tree").ligerGetTreeManager();  
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 		f_select();
    }
    /*展开事件*/ 
      function onExpand(node){
            var nodeid=node.data.id;

       }
       /*Tree展开事件*/ 
      function onBeforeExpand(node){
            var nodeid=node.data.id;
            if(node.data.children && node.data.children.length == 0){
               tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=TDQTree");
            }  
        }         
        
     /*Tree查看*/
        function t_enter(nodeid){
        try{           
          var strWhere = " ";           
            if(nodeid.length>=8){
				if(nodeid.indexOf("0000")>=0){
						strWhere+=" and DQ4 like '"+nodeid.substring(0, 4)+"%'";
				}else if(nodeid.indexOf("00")>=0&&nodeid.indexOf("0000")<0){
						strWhere+=" and DQ4 like '"+nodeid.substring(0, 6)+"%'";
				}else if(nodeid.indexOf("00")<0&&nodeid.indexOf("0000")<0){
						strWhere+=" and DQ4 like '"+nodeid+"%'";
					}
				}else if(nodeid.length>=6){
					if(nodeid.indexOf("00")>=0){
						strWhere+=" and DQ3 like '"+nodeid.substring(0, 4)+"%'";
					}else if(nodeid.indexOf("00")<0){
						strWhere+=" and DQ3 like '"+nodeid+"%'";
					}
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

		function f_select()
        {
        	var manager = $("#mainGrid").ligerGetGridManager();
            return manager.getSelectedRow();
        }

        /*根据条件查询*/
     function f_search(){
         try{
              var strWhere = " ";           
     //企业编号
     var corpkey = $("#corpkey").val();
     
     if(corpkey.length>0) {
       strWhere = " and corpkey like '%"+corpkey+"%' ";
     }
    
     //单位名称
     var dwmc = $("#dwmc").val();
     if(dwmc.length>0) {
       strWhere = " and dwmc like '%"+dwmc+"%' ";
     }
      
     //注册地址
     var zcdz = $("#zcdz").val();
     if(zcdz.length>0) {
       strWhere = " and zcdz like '%"+zcdz+"%' ";
     }
     //负责人
     var leader = $("#leader").val();
     if(leader.length>0) {
       strWhere = " and leader like '%"+leader+"%' ";
     }
     //联系电话
     //var lxdh = $("#lxdh").val();
     //if(lxdh.length>0) {
      // strWhere = " and lxdh like '%"+lxdh+"%' ";
     //}
     
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
                         strId = strId+",'"+selected[i].corpkey+"'";
                       }
                    }else{
                       strId = strId+",'"+node.data.id+"'";
                    }
                    $.post(webpath+"//UI/action/zyjk/ZcorAction_delete.action",{strSysno:strId},function(data){
                       if(data.checkFlag==MSG_SUCCESS){
                         f_search();                        
                         $.ligerDialog.success(data.checkMessage);
                       }else{
                         $.ligerDialog.error(data.checkMessage);
                       }
                   },"json").error(function() { 
                             $.ligerDialog.error(MSG_LOAD_FALL)});
                   //去掉节点
                   tree.remove(node.target);
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
          // var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        
        var strId;
        if(selected !=null){
          strId=selected.corpkey;
        }else{
          strId="";
        }
        myWindow = $.ligerDialog.open({ url: webpath+"/UI/action/zyjk/ZcorAction_findByKey.action?messageBean.method=add&strSysno="+strId,  width: openWidth,height:openHeight, title: '申报企业列表',
        showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
           f_search();   
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
          strId=selected.corpkey;
        }else{
          strId="";
        }
        
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = $.ligerDialog.open({url: webpath+"/UI/action/zyjk/ZcorAction_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '申报企业列表',
         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
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
                 myWindow = $.ligerDialog.open({url: webpath+"/UI/zyjk/cor/info/enterinfomain.jsp?corpkey="+selected.corpkey, width: openWidth,height:openHeight, title: '申报企业列表',
                 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       
        /*增加结点*/ 
        function node_add(strId){
        try{
         var node = tree.getSelected();
          var nodes = [];         
            $.post(webpath+"/st/system/action/tree/tree_getTree.action",{strTreeName:"",strTreeID:strId},function(data){
                             
               if (node){
               var nodedata = data
               var i=data.length-1;
               nodes.push(data[i]);                
                  tree.append(node.target, nodes);  
                  }  
         },"json").error(function() { 
                             $.ligerDialog.error(MSG_LOAD_FALL)});
         }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
        
         /*修改结点*/
        function node_modi(strId){
          try{
        var node = tree.getSelected(); 
          var nodes = [];     
             $.post(webpath+"/st/system/action/tree/tree_getTree.action",{strTreeName:"",strTreeID:strId,isFlag:"leafpoint"},function(data){           
               if (node){
               var nodedata = data;
                      tree.update(node.target,data[0]); 
                  }  
              },"json").error(function() { 
                             $.ligerDialog.error(MSG_LOAD_FALL)});
        }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
