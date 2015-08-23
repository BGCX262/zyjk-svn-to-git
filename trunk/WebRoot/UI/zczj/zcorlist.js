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
var openWidth="980";
var openHeight="650"; 
var discode="";
//初始;
$(function (){
try{
 /*布局*/
 $("#layout").ligerLayout({leftWidth: 200 });
 /*grid*/    
 var toolbar =   [
 
 { text: '查看', click:f_look,  icon:'pager' } 
   ]; 
 
 discode=$("#discode").val();
  var strWhere = " and corpkey not in(select corpkey from zczjqyxxzb)"; 
            
	if(discode.length>=8){
		if(discode.indexOf("0000")>=0){
				strWhere+=" and DQ4 like '"+discode.substring(0, 4)+"%'";
		}else if(discode.indexOf("00")>=0&&discode.indexOf("0000")<0){
				strWhere+=" and DQ4 like '"+discode.substring(0, 6)+"%'";
		}else if(discode.indexOf("00")<0&&discode.indexOf("0000")<0){
				strWhere+=" and DQ4 like '"+discode+"%'";
			}
	}else if(discode.length>=6){
		if(discode.indexOf("00")>=0){
			strWhere+=" and DQ3 like '"+discode.substring(0, 4)+"%'";
		}else if(discode.indexOf("00")<0){
			strWhere+=" and DQ3 like '"+discode+"%'";
		}
	} 
  
 grid = sub_Grid('ZcorGrid','申报企业列表',toolbar,strWhere); 
/*TREE
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
          */
          
          var colselect=$("#distcodename").ligerComboBox({
                width: 130,
                selectBoxWidth: 200,
                selectBoxHeight: 400, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=TDQTree&strWhere= and Depth in (1,2,3) ', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid', 
                        onBeforeExpand: function(node)
		                 {
		                    var nodeid=node.data.id;
                            if(node.data.children && node.data.children.length == 0){
                            tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=TDQTree");
                            } 
		                 },
		           //      onSelect: function (node)
                  //{                       
                  //   alert("11111");
                 //    var nodeid=node.data.id;                                      
                 //    t_enter(nodeid);
                 //},
                   		onClick: function (node)
                    	{                                              		
                       		//var nodeid=node.data.id;                                      
                            //t_enter(nodeid);
                            //alert(node.data.id);
                            //t_enter(node.data.id);
                       		$("#distcode").val(node.data.id);
                       		//alert(node.data.text);
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
 
  // myWindow = top.$.ligerDialog.open({url: webpath+"/UI/zyjk/cor/info/enterinfomain.jsp?corpkey="+data.corpkey, width: openWidth,height:openHeight, title: '申报企业列表',
  //               showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
  // top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: data.dwmc+'申报信息', url:webpath+"/UI/zyjk/cor/info/enterinfomain.jsp?corpkey="+data.corpkey });                  
  loadSubWindow(webpath+"/UI/zyjk/cor/info/enterinfomain.jsp?corpkey="+data.corpkey);
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

        /*根据条件查询*/
     function f_search(){
         try{
              var strWhere = " and corpkey not in(select corpkey from zczjqyxxzb where bak1 in ('1','3') and zbid='T_YHZC_BZZB370000130605000001')";           
     //企业编号
     var corpkey = $("#corpkey").val();
     
     if(corpkey.length>0) {
       strWhere += " and corpkey like '%"+corpkey+"%' ";
     }
    
    
      //区划
      var ditcode = $("#distcode").val();
        if(ditcode.length>0) {
             if(ditcode.length>=8){
		          if(ditcode.indexOf("0000")>=0){
				       strWhere+=" and DQ4 like '"+ditcode.substring(0, 4)+"%'";
		          }else if(ditcode.indexOf("00")>=0&&ditcode.indexOf("0000")<0){
				       strWhere+=" and DQ4 like '"+ditcode.substring(0, 6)+"%'";
		          }else if(ditcode.indexOf("00")<0&&ditcode.indexOf("0000")<0){
				       strWhere+=" and DQ4 like '"+ditcode+"%'";
			      }
	         }else if(ditcode.length>=6){
		          if(ditcode.indexOf("00")>=0){
			          strWhere+=" and DQ3 like '"+ditcode.substring(0, 4)+"%'";
		          }else if(ditcode.indexOf("00")<0){
			         strWhere+=" and DQ3 like '"+ditcode+"%'";
		          }
	         } 
       }
    
     //单位名称
     var dwmc = $("#dwmc").val();
     if(dwmc.length>0) {
       strWhere += " and dwmc like '%"+dwmc+"%' ";
     }
      
     //注册地址
     var zcdz = $("#zcdz").val();
     if(zcdz.length>0) {
       strWhere += " and zcdz like '%"+zcdz+"%' ";
     }
     //负责人
     var leader = $("#leader").val();
     if(leader.length>0) {
       strWhere += " and leader like '%"+leader+"%' ";
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
                // myWindow = top.$.ligerDialog.open({url: webpath+"/UI/zyjk/cor/info/enterinfomain.jsp?corpkey="+selected.corpkey, width: openWidth,height:openHeight, title: '申报企业列表',
                // showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
               //top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.dwmc+'申报信息', url:webpath+"/UI/zyjk/cor/info/enterinfomain.jsp?corpkey="+selected.corpkey });  
               loadSubWindow(webpath+"/UI/zyjk/cor/info/enterinfomain.jsp?corpkey="+selected.corpkey);
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       