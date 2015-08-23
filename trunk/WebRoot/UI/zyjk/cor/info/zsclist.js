
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27               新規作成 ;
 ****************************************************/
var grid = null;
var myWindow = null;
var menu = null;
var openWidth = "630";
var openHeight = "300"; 
//初始;
$(function () {
	try {
		/*布局*/
		$("#layout").ligerLayout();
		 _grid = $("#mainGrid").ligerGrid({ checkbox: true, 
			 columns:[
               	 	{ display: '原、辅材料情况', columns:[
	                    { display: '名称', name: 'amc', align: 'center' }, 
	                    { display: '用量', name: 'anianliang',align: 'center' },
	                    { display: '单位', name: 'adanwei',align: 'center' }
               		 ]
               		},
               		{ display: '中间产品情况', columns:[
	                   { display: '名称', name: 'bmc', align: 'center'}, 
	                    { display: '用量', name: 'bnianliang',align: 'center'},
	                    { display: '单位', name: 'bdanwei',align: 'center' }
               		 ]
               		},
               		{ display: '主要产品、副产品情况', columns:[
	                   	{ display: '名称', name: 'mc', align: 'center'}, 
	                    { display: '用量', name: 'nianliang', align: 'center' },
	                    { display: '单位', name: 'danwei', align: 'center' }
               		 ]
               		}
                ],
              pageSizeOptions:[15,20,30,40,50], 
			 rownumbers:true,parms:"",
			 dataAction: 'server',url: webpath+"/UI/action/zyjk/ZscAction_findList.action?strSysno="+getUrlParam("strSysno"),
			 width: '100%',height:'100%',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :false,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			 onDblClickRow:onDblClickRow,
			 pageSize:15,
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 }
			 
			});
		//var corpkey = getUrlParam("strSysno");
		//var strWhere = " and corpkey like '%" + corpkey + "%' ";
		//var manager = $("#mainGrid").ligerGetGridManager();
		//manager.set("newPage", 1);
		//manager.set("parms", {"strWhere":strWhere});
		//manager.loadData(true);
		//f_search();
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
});
/*grid双击事件*/
function onDblClickRow(data, rowindex, rowobj) {
	try {
		//myWindow = $.ligerDialog.open({url:webpath + "/UI/action/zyjk/ZpxtjAction_findByKey.action?messageBean.method=look&strSysno=" + data.corpkey, width:openWidth, height:openHeight, title:"\u4f01\u4e1a\u57f9\u8bad\u4f53\u68c0\u5217\u8868", showMax:true, showToggle:true, showMin:false, isResize:true, slide:false});
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
}



/*Tree展开事件*/
function onBeforeExpand(node) {
	var nodeid = node.data.id;
	if (node.data.children && node.data.children.length == 0) {
		tree.loadData(node.target, webpath + "/st/system/action/tree/tree_getTree.action?strTreeName=");
	}
}
/*Tree查看*/
function t_enter(nodeid) {
	try {
		var strWhere = " ";
		if (nodeid.length > 0) {
			strWhere = " and parentmenuid = '" + nodeid + "' or menuid='" + nodeid + "'";
		}
		var manager = $("#mainGrid").ligerGetGridManager();  
             //初始化查询起始页
		manager.set("newPage", 1);
              //初始化查询条件
		manager.set("parms", {"strWhere":strWhere});
		manager.loadData(true);
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
}
/*根据条件查询*/
function f_search() {
	try {
		var strWhere = " ";           
     //企业编号
		var corpkey = getUrlParam("strSysno");
		//alert(corpkey);
		if (corpkey.length > 0) {
			strWhere = " and corpkey like '%" + corpkey + "%' ";
		}
		var manager = $("#mainGrid").ligerGetGridManager();  
              //manager.loadServerData({strWhere:strWhere},function (countmain) {
             //   alert(countmain);
              //});
              //初始化查询起始页
		manager.set("newPage", 1);
              //初始化查询条件
		manager.set("parms", {"strWhere":strWhere});
		manager.loadData(true);
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
}
/*删除*/
function f_remove() {
	try {
		var strId = "''";
		var manager = $("#mainGrid").ligerGetGridManager();
		var selected = manager.getSelectedRows();
		if (selected == null) {
			$.ligerDialog.warn(MSG_NORECORD_SELECT);
		} else {
			$.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state) {
				if (state) {
					if (selected != null && selected.length > 0) {
						for (var i = 0; i < selected.length; i++) {
							strId = strId + ",'" + selected[i].corpkey + "'";
						}
					} else {
						strId = strId + ",'" + node.data.id + "'";
					}
					$.post(webpath + "/UI/action/zyjk/ZpxtjAction_delete.action", {strSysno:strId}, function (data) {
						if (data.checkFlag == MSG_SUCCESS) {
							f_search();
							$.ligerDialog.success(data.checkMessage);
						} else {
							$.ligerDialog.error(data.checkMessage);
						}
					}, "json").error(function () {
						$.ligerDialog.error(MSG_LOAD_FALL);
					});
                   //去掉节点
					tree.remove(node.target);
				}
			});
		}
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
}
/*新建*/
function f_add() {
	try {
		var manager = $("#mainGrid").ligerGetGridManager();
		var selected = manager.getSelectedRow();
		var strId;
		if (selected == null) {
			$.ligerDialog.warn(MSG_NORECORD_SELECT);
		} else {
			if (selected != null) {
				strId = selected.corpkey;
			}
		}
		myWindow = $.ligerDialog.open({url:webpath + "/UI/action/zyjk/ZpxtjAction_findByKey.action?messageBean.method=add&strSysno=" + strId, width:openWidth, height:openHeight, title:"\u4f01\u4e1a\u57f9\u8bad\u4f53\u68c0\u5217\u8868", showMax:false, showToggle:false, showMin:false, isResize:false, slide:false});
		f_search();
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
}
/*修改*/
function f_update() {
	try {
		var manager = $("#mainGrid").ligerGetGridManager();
		var selected = manager.getSelectedRow();
		var strId;
		if (selected == null) {
			$.ligerDialog.warn(MSG_NORECORD_SELECT);
		} else {
			if (selected != null) {
				strId = selected.menuid;
			}
		}
		if (strId == null || strId.length == 0) {
			$.ligerDialog.warn(MSG_NORECORD_SELECT);
		} else {
			myWindow = $.ligerDialog.open({url:webpath + "/UI/action/zyjk/ZpxtjAction_findByKey.action?messageBean.method=update&strSysno=" + strId, width:openWidth, height:openHeight, title:"\u4f01\u4e1a\u57f9\u8bad\u4f53\u68c0\u5217\u8868", showMax:false, showToggle:false, showMin:false, isResize:false, slide:false});
			f_search();
		}
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
}
/*Grid查看*/
function f_look() {
	try {
		var manager = $("#mainGrid").ligerGetGridManager();
		var selected = manager.getSelectedRow();
		if (selected == null || selected.length == 0) {
			$.ligerDialog.warn(MSG_NORECORD_SELECT);
		} else {
			myWindow = $.ligerDialog.open({url:webpath + "/UI/action/zyjk/ZpxtjAction_findByKey.action?messageBean.method=look&strSysno=" + selected.corpkey, width:openWidth, height:openHeight, title:"\u4f01\u4e1a\u57f9\u8bad\u4f53\u68c0\u5217\u8868", showMax:false, showToggle:false, showMin:false, isResize:false, slide:false});
		}
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
}

