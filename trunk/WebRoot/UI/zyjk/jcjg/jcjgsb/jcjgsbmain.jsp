<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.JcjgyqsbglBean"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String strSysno=request.getParameter("strSysno");
	//String jgbh=request.getParameter("jgbh");	
	//将设备编号转为机构编号
	String jgbh="";
	JcjgyqsbglBean jgsbBean=new JcjgyqsbglBean();
	jgsbBean=jgsbBean.findFirst(" where sysno='"+ strSysno +"'");
	if(null!=jgsbBean){
		jgbh=jgsbBean.getJgbh();
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
		<div id="navtab1"
			style="width:100%;height:100%;overflow:hidden; border:1px solid #A3C0E8; ">
			<div tabid="home" title="设备信息" lselected="true" style="height:580px">
				<iframe  style="width:100%;height:600px;" frameborder="0" name="showmessagex"
					src="<%=basePath %>/UI/action/zyjk/JcjgsbAction_findByKey.action?messageBean.method=look&strSysno=<%=strSysno %>"></iframe>
			</div>
			<div title="检测机构信息" >
				<iframe  style="width:100%;height:600px;" frameborder="0" name="showmessagec"
					src="<%=basePath %>/UI/zyjk/jcjg/jcjgmain.jsp?sysno=<%=jgbh %>"></iframe>
			</div>
		</div>
	</body>
</html>
