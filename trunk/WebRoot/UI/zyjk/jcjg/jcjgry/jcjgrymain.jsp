<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.JcjgpjryglBean"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String strSysno=request.getParameter("strSysno");
	//将机构人员编号转为机构编号
	String jgbh="";
	JcjgpjryglBean jgryBean=new JcjgpjryglBean();
	jgryBean=jgryBean.findFirst(" where sysno='"+ strSysno +"'");
	if(null!=jgryBean){
		jgbh=jgryBean.getJgbh();
	}
	
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/global.jsp"%>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>查看人员信息</title>
	
	</head>
	   
    <script type="text/javascript">
        var tab;
        $(function ()
        {
            
            $("#navtab1").ligerTab(
            {
            //打开tab页  
            onAfterSelectTabItem: onAfterSelectTabItem
            
            }
            
            ); 
            tab = $("#navtab1").ligerGetTabManager();
            
        });
        
        function onAfterSelectTabItem(tabid){
          tab.reload(tab.getSelectedTabItemID());
        }
    </script>
	<body style="padding:10px">
	<input type="hidden" id="strSysno" name="strSysno" value="<%=strSysno %>"/>
		<div id="navtab1"
			style="width:100%;height:100%;overflow:hidden; border:1px solid #A3C0E8; ">
			<div tabid="home" title="人员信息" lselected="true" style="height:580px">
				<iframe style="width:100%;height:600px;" frameborder="0" name="showmessagex"
					src="<%=basePath %>/UI/action/zyjk/JcjgryglAction_findByKey.action?messageBean.method=look&strSysno=<%=strSysno %>"></iframe>
			</div>
			<div tabid="jcjgxx" title="检测机构信息">
				<iframe style="width:100%;height:600px;" frameborder="0" name="showmessagec"
					src="<%=basePath %>/UI/zyjk/jcjg/jcjgmain.jsp?sysno=<%=jgbh %>"></iframe>
			</div>
		</div>
	</body>
</html>
