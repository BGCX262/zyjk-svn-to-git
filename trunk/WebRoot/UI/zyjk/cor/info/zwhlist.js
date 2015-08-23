
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-02               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu = null;
var openWidth = "630";
var openHeight = "300"; 
//初始;
$(function () {
	try {
		/*布局*/
		$("#layout").ligerLayout({leftWidth:200});
		/*grid*/
		grid = sub_Grid("ZwhGrid", "\u5371\u5bb3\u56e0\u7d20\u6c47\u603b\u8868", ""," and a.corpkey=b.corpkey and a.id=b.id and b.corpkey like '%" + getUrlParam("strSysno") + "%' ");
		//var corpkey = getUrlParam("strSysno");
		//var strWhere = " and corpkey like '%" + corpkey + "%' ";
		//var manager = $("#mainGrid").ligerGetGridManager();
		//manager.set("newPage", 1);
		//manager.set("parms", {"strWhere":strWhere});
		//manager.loadData(true);
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
});
/*grid双击事件*/
function onDblClickRow(data, rowindex, rowobj) {
	try {
		//myWindow = $.ligerDialog.open({url:webpath + "/UI/action/zyjk/ZwhAction_findByKey.action?messageBean.method=look&strSysno=" + data.corpkey, width:openWidth, height:openHeight, title:"\u5371\u5bb3\u56e0\u7d20\u6c47\u603b\u8868", showMax:true, showToggle:true, showMin:false, isResize:true, slide:false});
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
		var corpkey = $("#corpkey").val();
		if (corpkey.length > 0) {
			strWhere = " and corpkey like '%" + corpkey + "%' ";
		}
     //作业场所
		var siteid = $("#siteid").val();
		if (siteid.length > 0) {
			strWhere = " and siteid like '%" + siteid + "%' ";
		}
     //危害因素
		var whdm = $("#whdm").val();
		if (whdm.length > 0) {
			strWhere = " and whdm like '%" + whdm + "%' ";
		}
     //设备状态
		var sbstate = $("#sbstate").val();
		if (sbstate.length > 0) {
			strWhere = " and sbstate like '%" + sbstate + "%' ";
		}
     //操作方式
		var czfs = $("#czfs").val();
		if (czfs.length > 0) {
			strWhere = " and czfs like '%" + czfs + "%' ";
		}
     //是否隔离
		var sfgl = $("#sfgl").val();
		if (sfgl.length > 0) {
			strWhere = " and sfgl like '%" + sfgl + "%' ";
		}
     //接触人数
		var jcrenshu = $("#jcrenshu").val();
		if (jcrenshu.length > 0) {
			strWhere = " and jcrenshu like '%" + jcrenshu + "%' ";
		}
     //女工人数
		var jcwomen = $("#jcwomen").val();
		if (jcwomen.length > 0) {
			strWhere = " and jcwomen like '%" + jcwomen + "%' ";
		}
     //浓度
		var ndorqd = $("#ndorqd").val();
		if (ndorqd.length > 0) {
			strWhere = " and ndorqd like '%" + ndorqd + "%' ";
		}
     //浓度单位
		var ndorqddw = $("#ndorqddw").val();
		if (ndorqddw.length > 0) {
			strWhere = " and ndorqddw like '%" + ndorqddw + "%' ";
		}
     //工程防护措施
		var gcfh = $("#gcfh").val();
		if (gcfh.length > 0) {
			strWhere = " and gcfh like '%" + gcfh + "%' ";
		}
     //个体防护
		var gtfh = $("#gtfh").val();
		if (gtfh.length > 0) {
			strWhere = " and gtfh like '%" + gtfh + "%' ";
		}
     //序号
		var id = $("#id").val();
		if (id.length > 0) {
			strWhere = " and id like '%" + id + "%' ";
		}
     //农民工
		var jcnongmin = $("#jcnongmin").val();
		if (jcnongmin.length > 0) {
			strWhere = " and jcnongmin like '%" + jcnongmin + "%' ";
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
		var node = tree.getSelected();
		var strId = "''";
		var manager = $("#mainGrid").ligerGetGridManager();
		var selected = manager.getSelectedRows();
		if (selected == null && node == null) {
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
					$.post(webpath + "/UI/action/zyjk/ZwhAction_delete.action", {strSysno:strId}, function (data) {
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
		var node = tree.getSelected();
		var manager = $("#mainGrid").ligerGetGridManager();
		var selected = manager.getSelectedRow();
		var strId;
		if (node == null && selected == null) {
			$.ligerDialog.warn(MSG_NORECORD_SELECT);
		} else {
			if (selected != null) {
				strId = selected.corpkey;
			} else {
				strId = node.data.id;
			}
		}
		myWindow = $.ligerDialog.open({url:webpath + "/UI/action/zyjk/ZwhAction_findByKey.action?messageBean.method=add&strSysno=" + strId, width:openWidth, height:openHeight, title:"\u5371\u5bb3\u56e0\u7d20\u6c47\u603b\u8868", showMax:false, showToggle:false, showMin:false, isResize:false, slide:false});
		f_search();
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
}
/*修改*/
function f_update() {
	try {
		var node = tree.getSelected();
		var parent = tree.getParent(node);
		var manager = $("#mainGrid").ligerGetGridManager();
		var selected = manager.getSelectedRow();
		var strId;
		if (node == null && selected == null) {
			$.ligerDialog.warn(MSG_NORECORD_SELECT);
		} else {
			if (selected != null) {
				strId = selected.menuid;
			} else {
				strId = node.data.id;
			}
		}
		if (strId == null || strId.length == 0) {
			$.ligerDialog.warn(MSG_NORECORD_SELECT);
		} else {
			myWindow = $.ligerDialog.open({url:webpath + "/UI/action/zyjk/ZwhAction_findByKey.action?messageBean.method=update&strSysno=" + strId, width:openWidth, height:openHeight, title:"\u5371\u5bb3\u56e0\u7d20\u6c47\u603b\u8868", showMax:false, showToggle:false, showMin:false, isResize:false, slide:false});
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
			myWindow = $.ligerDialog.open({url:webpath + "/UI/action/zyjk/ZwhAction_findByKey.action?messageBean.method=look&strSysno=" + selected.corpkey, width:openWidth, height:openHeight, title:"\u5371\u5bb3\u56e0\u7d20\u6c47\u603b\u8868", showMax:false, showToggle:false, showMin:false, isResize:false, slide:false});
		}
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
}

