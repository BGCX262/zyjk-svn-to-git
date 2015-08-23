
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- jmx ---------- Note -------------------
 * 1.0  2013-04-28               新規作成 ;
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
		grid = sub_Grid("ZsiteAction", "\u4f01\u4e1a\u5de5\u4f5c\u573a\u6240", "", " and corpkey like '%" + getUrlParam("strSysno") + "%' ");
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
		//myWindow = $.ligerDialog.open({url:webpath + "/UI/action/zyjk/ZsiteAction_findByKey.action?messageBean.method=look&strSysno=" + data.corpkey, width:openWidth, height:openHeight, title:"\u4f01\u4e1a\u5de5\u4f5c\u573a\u6240", showMax:true, showToggle:true, showMin:false, isResize:true, slide:false});
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
     //作业场所名称
		var zymc = $("#zymc").val();
		if (zymc.length > 0) {
			strWhere = " and zymc like '%" + zymc + "%' ";
		}
     //作业场所描述
		var miaoshu = $("#miaoshu").val();
		if (miaoshu.length > 0) {
			strWhere = " and miaoshu like '%" + miaoshu + "%' ";
		}
     //序号
		var id = $("#id").val();
		if (id.length > 0) {
			strWhere = " and id like '%" + id + "%' ";
		}
     //接触危害人数
		var jcrenshu = $("#jcrenshu").val();
		if (jcrenshu.length > 0) {
			strWhere = " and jcrenshu like '%" + jcrenshu + "%' ";
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
/*Grid查看*/
function f_look() {
	try {
		var manager = $("#mainGrid").ligerGetGridManager();
		var selected = manager.getSelectedRow();
		if (selected == null || selected.length == 0) {
			$.ligerDialog.warn(MSG_NORECORD_SELECT);
		} else {
			myWindow = $.ligerDialog.open({url:webpath + "/UI/action/zyjk/ZsiteAction_findByKey.action?messageBean.method=look&strSysno=" + selected.corpkey, width:openWidth, height:openHeight, title:"\u4f01\u4e1a\u5de5\u4f5c\u573a\u6240", showMax:false, showToggle:false, showMin:false, isResize:false, slide:false});
		}
	}
	catch (e) {
		$.ligerDialog.error(e.message);
	}
}

