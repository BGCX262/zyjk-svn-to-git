<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<STYLE type=text/css>
.style1 {
	COLOR: #ff0000
}
.back1 {
	BACKGROUND-COLOR: #c2e254
}
BODY {
	FONT-SIZE: 12px; COLOR: #006699
}
TD {
	FONT-SIZE: 12px; COLOR: #006699
}
TH {
	FONT-SIZE: 12px; COLOR: #006699
}
.STYLE2 {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #009900
}
A:link {
	COLOR: #0033cc; TEXT-DECORATION: none
}
A:visited {
	COLOR: #006699; TEXT-DECORATION: none
}
A:hover {
	COLOR: #0033cc; TEXT-DECORATION: blink
}
A:active {
	COLOR: #006699; TEXT-DECORATION: none
}
</STYLE>
		<title>系统提示信息</title>

	</head>
	<BODY class=back3 leftMargin=0 topMargin=0 marginwidth="0"
		marginheight="0">
		<TABLE cellSpacing=0 cellPadding=0 border=0>
			<TBODY>
				<TR>
					<TD height=115></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE height=157 cellSpacing=0 cellPadding=0 width=544 align=center
			border=0>
			<TBODY>
				<TR vAlign=center align=middle>
					<TD background="<%=path%>/images/tz-002.gif">
						<TABLE cellSpacing=0 cellPadding=0 border=0>
							<TBODY>
								<TR>
									<TD style="PADDING-LEFT: 100px; PADDING-TOP: 10px" align=middle>
										<span>【Session过期请重新登陆】</span>
										<A href="javascript:window.history.back()"> <FONT
											color=#ff0000 size="5">返回</FONT> </A>
										<P>
										</P>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</BODY>
</html>
