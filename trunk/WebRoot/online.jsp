<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="UI.dao.zyjk.T_officerBean"%>
<%@ page import="st.platform.security.SystemAttributeNames"%>
<%@ page  import="st.system.dao.PtdeptBean" %>
<%
	String isDept=(String)request.getSession().getAttribute(SystemAttributeNames.OPER_TYPE);
	
	
	if(isDept.equals("1")){
		PtdeptBean opdept=(PtdeptBean)request.getSession().getAttribute(SystemAttributeNames.DEPT_INFO_NAME);
		if(null==opdept){
			out.println("<script language=\"javascript\">alert ('操作员超时，请重新签到！'); if(top){ top.location.href='"+request.getContextPath()+"/zflogin.jsp'; } else { location.href = '"+request.getContextPath()+"/index.jsp';} </script>");
			return;
		}
	}else {
		T_officerBean tofficer=(T_officerBean)request.getSession().getAttribute(SystemAttributeNames.CORP_INFO_NAME);
		if(null==tofficer){
			out.println("<script language=\"javascript\">alert ('操作员超时，请重新签到！'); if(top){ top.location.href='"+request.getContextPath()+"/qyindex.jsp'; } else { location.href = '"+request.getContextPath()+"/index.jsp';} </script>");
			return;
		}
	}
	
	
%>
