<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.ZyjkflfjBean"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String strSysno=request.getParameter("strSysno");	
	
    //将strSysno转为corpkey
	String corpkey="";
	ZyjkflfjBean flfjBean=new ZyjkflfjBean();
	flfjBean=flfjBean.findFirst(" where sysno='"+ strSysno +"'");
	if(null!=flfjBean){
		corpkey=flfjBean.getCorpkey();
	}

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/global.jsp"%>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>查看分类分级信息</title>
	
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
			<div tabid="home" title="分类分级信息" lselected="true" >
				<iframe style="width:100%;height:600px;" frameborder="0" name="showmessagex"
					src="<%=basePath %>/UI/action/zyjk/ZyjkflfjAction_findByKey.action?messageBean.method=look&strSysno=<%=strSysno %>"></iframe>
			</div>
			<div title="企业信息" >
				<iframe style="width:100%;;height:600px;;" frameborder="0" name="showmessagec"
					src="<%=basePath %>/UI/zyjk/cor/info/enterinfomain.jsp?corpkey=<%=corpkey %>&enterno=<%=corpkey%>"></iframe>
			</div>
		</div>
	</body>
</html>
