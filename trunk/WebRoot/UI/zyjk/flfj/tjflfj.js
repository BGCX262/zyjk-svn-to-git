/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- jmx ---------- Note -------------------
 * 1.0  2013-05-06               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="1000";
var openHeight="610"; 
var discode="";
var whereStr = " ";  
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
   distcode=getUrlParam("distcode");
  var lx= getUrlParam("lx");
  var hyfl=getUrlParam("hylb");
  var whys=getUrlParam("whys");
  var qygm=getUrlParam("qygm");
 var zclx=getUrlParam("zclx");
 //discode=$("#discode").val();
  if(discode!=null&&discode.length>0){
	if(discode.length>=8){
		if(discode.indexOf("0000")>=0){
				whereStr+=" and distcode like '"+discode.substring(0, 4)+"%'";
		}else if(discode.indexOf("00")>=0&&discode.indexOf("0000")<0){
				whereStr+=" and distcode like '"+discode.substring(0, 6)+"%'";
		}else if(discode.indexOf("00")<0&&discode.indexOf("0000")<0){
				whereStr+=" and distcode like '"+discode+"%'";
			}
	}else if(discode.length>=6){
		if(discode.indexOf("00")>=0){
			whereStr+=" and distcode like '"+discode.substring(0, 4)+"%'";
		}else if(discode.indexOf("00")<0){
			whereStr+=" and distcode like '"+discode+"%'";
		}
	} 
}
	
 //危害分类
  if(hyfl!=null&&hyfl.length>0){
  	whereStr+=" and a.corpkey in (select Z_cor.corpkey from Z_cor where hyfl like '"+hyfl+"%')";
  }
  //危害因素
  if(whys!=null&&whys.length>0){
  	whereStr+=" and a.corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
  }
  //企业规模
  if(qygm!=null&&qygm.length>0){
  	whereStr+=" and a.corpkey in (select Z_cor.corpkey from Z_cor where chanzhi ='"+qygm+"')";
  }
   //注册类型
  if(zclx!=null&&zclx.length>0){
  	whereStr+=" and a.corpkey in (select Z_cor.corpkey from Z_cor where zclx ='"+zclx+"')";
  }    
 grid =  sub_Grid('ZyjkflfjhzGrid','分类分级',toolbar," and bak2!='2'"+whereStr);  
            
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
                }
         });
         
         tree = $("#tree").ligerGetTreeManager(); 
 */
     $("#date1").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
     
     
     
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
		         //        onSelect: function (node)
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
  myWindow =top.$.ligerDialog.open({url:webpath+"/UI/action/zyjk/ZyjkflfjAction_findByKey.action?messageBean.method=look&strSysno="+data.sysno, width: openWidth,height:openHeight, title:"分类分级",
 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false,buttons: [
         //       { text: '确定', onclick: f_selectContactOK },
                { text: '取消', onclick: f_selectContactCancel}]
               });       
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
                  
          var strWhere = " "+whereStr;           
            if(nodeid.length>=8){
				if(nodeid.indexOf("0000")>=0){
						strWhere+=" and distcode like '"+nodeid.substring(0, 4)+"%'";
				}else if(nodeid.indexOf("00")>=0&&nodeid.indexOf("0000")<0){
						strWhere+=" and distcode like '"+nodeid.substring(0, 6)+"%'";
				}else if(nodeid.indexOf("00")<0&&nodeid.indexOf("0000")<0){
						strWhere+=" and distcode like '"+nodeid+"%'";
					}
				}else if(nodeid.length>=6){
					if(nodeid.indexOf("00")>=0){
						strWhere+=" and distcode like '"+nodeid.substring(0, 4)+"%'";
					}else if(nodeid.indexOf("00")<0){
						strWhere+=" and distcode like '"+nodeid+"%'";
					}
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
              var strWhere=" and bak2!='2'"+whereStr; 
              
     //
     var hylb=$("#hylb").val();
 
     if(hylb.length>0) {
       //alert("111");
       strWhere += " and corpkey in (select corpkey from Z_cor where  hyfl like '%"+hylb+"%') ";
     }                   
     //
     
     //
     var dwmc = $("#dwmc").val();
     if(dwmc.length>0) {
       strWhere += " and dwmc like '%"+dwmc+"%' ";
     }
     //
     var lxr = $("#lxr").val();
     if(lxr.length>0) {
       strWhere += " and lxr like '%"+lxr+"%' ";
     }
     
     //区划
      var ditcode = $("#distcode").val();
      if(ditcode.length>0) {
      
       if(ditcode.length>=8){
		          if(ditcode.indexOf("0000")>=0){
				       strWhere+=" and distcode like '"+ditcode.substring(0, 4)+"%'";
		          }else if(ditcode.indexOf("00")>=0&&ditcode.indexOf("0000")<0){
				       strWhere+=" and distcode like '"+ditcode.substring(0, 6)+"%'";
		          }else if(ditcode.indexOf("00")<0&&ditcode.indexOf("0000")<0){
				       strWhere+=" and distcode like '"+ditcode+"%'";
			      }
	         }else if(ditcode.length>=6){
		          if(ditcode.indexOf("00")>=0){
			          strWhere+=" and distcode like '"+ditcode.substring(0, 4)+"%'";
		          }else if(ditcode.indexOf("00")<0){
			         strWhere+=" and distcode like '"+ditcode+"%'";
		          }
	         } 
	        
      }
     
     //
     //var lxdh = $("#lxdh").val();
     //if(lxdh.length>0) {
      // strWhere = " and lxdh like '%"+lxdh+"%' ";
     //}
     //
     var jdgldj = $("#jdgldj").val();
     if(jdgldj.length>0) {
       strWhere += " and jdgldj like '%"+jdgldj+"%' ";
     }
     //
     var wsgldj = $("#wsgldj").val();
     if(wsgldj.length>0) {
       strWhere += " and wsgldj like '%"+wsgldj+"%' ";
     }
     //
     var whlb = $("#whlb").val();
     if(whlb.length>0) {
       strWhere += " and whlb like '%"+whlb+"%' ";
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
                    $.post(webpath+"/UI/action/zyjk/ZyjkflfjAction_delete.action",{strSysno:strId},function(data){
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
        //myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/ZyjkflfjAction_findByKey.action?messageBean.method=add&strSysno="+strId,  width: openWidth,height:openHeight, title: '分类分级',
       // showMax: true, showToggle: true, showMin: false, isResize: false, slide: false,buttons: [
         //       { text: '确定', onclick: f_selectContactOK },
          //      { text: '取消', onclick: f_selectContactCancel}]
         //      }); 
         myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/ZyjkflfjAction_findByKey.action?messageBean.method=add&strSysno="+strId,  width: openWidth,height:openHeight, title: '分类分级',
        showMax: true, showToggle: true, showMin: false, isResize: false, slide: false
               });        
         //window.parent.openWin("添加","win1",980,700,webpath+"/UI/action/zyjk/ZyjkflfjAction_findByKey.action?messageBean.method=add&strSysno="+strId);
           
           //f_search();   
        }catch (e) {
                $.ligerDialog.error(e.message);
         }  
        }
        /////
        function f_selectContactOK(item, dialog)
        {
			var fn=dialog.frame.formsubmit || dialog.frame.window.formsubmit; 
			fn();
           	f_search();
            dialog.close();
        }
        function f_selectContactCancel(item, dialog)
        {
            dialog.close();
        }
        ////
        
        /*修改*/
        function f_update(){ 
         try {
         
        var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
       // alert(selected);
        var strId;
        if(selected==null){
         $.ligerDialog.warn(MSG_NORECORD_SELECT);
         return;
        }else if(selected !=null){
          strId=selected.sysno;
        }
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/ZyjkflfjAction_findByKey.action?messageBean.method=update&strSysno="+strId, width: openWidth,height:openHeight, title: '分类分级',
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
             	//alert(selected.sysno);
                // myWindow =top.$.ligerDialog.open({url: webpath+"/UI/zyjk/flfj/flfjmain.jsp?strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '分类分级',
               //  showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
               // top.tab.addTabItem ({tabid : top.tab.getNewTabid(),text: selected.dwmc+'分类分级信息', url:webpath+'/UI/zyjk/flfj/flfjmain.jsp?strSysno='+selected.sysno });
               loadSubWindow(webpath+'/UI/zyjk/flfj/flfjmain.jsp?strSysno='+selected.sysno);
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
       
     