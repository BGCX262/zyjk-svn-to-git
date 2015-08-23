<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="st.portal.html.DBSelect"/>
<jsp:directive.page import="UI.dao.zyjk.Z_corBean"/>
<jsp:directive.page import="st.platform.system.cache.EnumerationType"/>
<jsp:directive.page import="UI.dao.zyjk.Z_siteBean"/>
<jsp:directive.page import="UI.dao.zyjk.Z_whBean"/>

<%@ include file="/global.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>职业危害项目申报表</title>
<%--<link href=css.css rel=stylesheet type="text/css">
--%><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 20px;
	margin-right: 0px;
	margin-bottom: 20px;
}
td {
TEXT-ALIGN: center;
}

-->
</style>
<%--<link href="<%=basePath %>/css/table.css" rel="stylesheet" type="text/css" />
--%>
<script>
	  $(function () {
        try {
          $("form").ligerForm();
             
          }catch (e) {
           
       }
        }); 
</script>


</head>
<body class="menubody" style="width: 850">
  
<% 
    Z_corBean eb = new Z_corBean();
    String enterno=request.getParameter("strSysno");
    //System.out.println(enterno);
    String ISEXIST="YES";
   	eb=eb.findFirst(" where corpkey='"+enterno+"'");
   	if(null==eb){
   		eb=new Z_corBean();
   	}
	 %>

<form  name="form1" method="post" >
  <table cellpadding="0" cellspacing="0" class="form-l-table-edit" >	
     <tr>
		   <td class="l-table-edit-td-right">单位：</td>
            <td class="l-table-edit-td-left">
		     <input name="dwmc" ltype="text" type="text" id="dwmc"  readonly="readonly"  maxlength=50 value="<%=eb.getDwmc() %>"  />
 		   </td> 
		   <td class="td_message"></td>
		   <td class="l-table-edit-td-right">日期：</td>
          <td class="l-table-edit-td-left"><input name="ystbdate" type="text" readonly="readonly"  maxlength=10 style="width: 97%" value="<%=eb.getYstbdate() %>" size="10"> </td>
     </tr>  
     <tr>
		   <td width="10%" class="l-table-edit-td-right">申报类别：</td>
    
    <td class="l-table-edit-td-left">
    	
		 <input type="hidden" name="ydwmc" value="">
		 <input type="hidden" name="yleader" value="">
        	 <input type="text" name="tblb" id="tblb" value="<%=eb.getTblb() %>" style="width: 95%"/>
        </td> 
         <td class="td_message"></td>
       <td width="10%" class="l-table-edit-td-right">变更原因：</td>
       <td colspan=2 style="TEXT-ALIGN: left" class="l-table-edit-td-left">
			
					 <input type="text" name="bgyy" id="bgyy" value="<%=eb.getBgyy() %>" style="width: 95%"/>
		    </td>
			</tr>
    <tr>
        <td class="l-table-edit-td-right">单位注册地址：</td>
        <td class="l-table-edit-td-left" style="TEXT-ALIGN: left"  ><input name="zcdz" type="text" id="zcdz"  maxlength=50 value="<%=eb.getZcdz() %>" size="45"> </td> 
         <td class="td_message"></td>
        <td class="l-table-edit-td-right">工作场所地址：</td>
        <td class="l-table-edit-td-left" style="TEXT-ALIGN: left"  ><input name="csdz" type="text" id="csdz"  maxlength=50 value="<%=eb.getCsdz() %>" size="45" style="width: 97%"> </td> 
		</tr>
    <tr>
        <td class="l-table-edit-td-right">企业规模：</td>
        <td class="l-table-edit-td-left">
			  <input name="chanzhi" type="text" id="chanzhi" readonly="readonly" maxlength=30 value="<%=EnumerationType.getEnu("QYGM",eb.getChanzhi()) %>" style="width: 97%" size="45">
		    </td> 
		 <td class="td_message"></td>    
        <td class="l-table-edit-td-right">行业分类：</td>
        <td colspan=2 class="l-table-edit-td-left">	          
		      <input name="hyflmc" type="text" id="hyflmc" readonly="readonly" maxlength=30 value="<%=EnumerationType.getEnu("HYLB",eb.getHyfl()) %>"/>
				    
			  </td>
		</tr>
 
     <tr>
	  		<td width="10%" class="l-table-edit-td-right">上属公司(或主管)：</td>
        <td  style="TEXT-ALIGN: left"  class="l-table-edit-td-left">
         <input name="zhuguan" type="text" value="<%= eb.getZhuguan() %>" style="width: 97%" size="40"> 		    
	    </td>
	    <td class="td_message"></td>			
        <td width="10%" class="l-table-edit-td-right">注册类型：</td>
        <td width="32%" style="TEXT-ALIGN: left"  class="l-table-edit-td-left">
         <input name="zclx" type="text" value="<%= EnumerationType.getEnu("ZCLX",eb.getZclx()) %>" style="width: 97%" size="40"> 	 
				</td> 
		</tr>
     <tr>
         <td class="l-table-edit-td-right">法定代表人：</td>
         <td class="l-table-edit-td-left"><input name="leader" type="text" id="leader" maxlength=20 value="<%=eb.getLeader() %>" style="width: 97%" size="40" > </td> 
		 <td class="td_message"></td>
		 <td  class="l-table-edit-td-right">联系电话：</td>
         <td  class="l-table-edit-td-left"><input name="lxdh" type="text" id="lxdh" maxlength=20 value="<%=eb.getLxdh() %>" style="width: 97%" size="45"></td>
	     <td class="td_message"></td>	
    </tr>
     <tr >
         <td  class="l-table-edit-td-right">职业卫生管理机构：</td>
         <td  class="l-table-edit-td-left">
		     <% 
	                DBSelect	 dbsel = new DBSelect("sfyzywsgljg","SF",eb.getZywsjgshu());
	 				 dbsel.addAttr("style", "width: 202px;");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "是否有专门的职业卫生管理机构");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
 				 </td>
           <td class="td_message"></td>
		     <td class="l-table-edit-td-right">职业卫生管理人数专职：</td>
         <td  class="l-table-edit-td-left"><input name="zywsgl" type="text"  maxlength=30 value="<%=eb.getZywsgl() %>" style="width: 97%" size="10"> </td>
		   <td class="td_message"></td>
		</tr>
     <tr >
		 <td class="l-table-edit-td-right">职业卫生管理人数兼职：</td>
         <td  class="l-table-edit-td-left"><input name="swrenshuxz" type="text"  maxlength=10 value="<%=eb.getSwrenshuxz() %>" style="width: 97%" size="10"> </td>
	     <td class="td_message"></td>
	</tr>
    <tr>
      <td class="l-table-edit-td-right">劳动者总人数：</td>
      <td   class="l-table-edit-td-left"><input name="nmzgrs" type="text" id="nmzgrs" maxlength=6 value="<%=eb.getNmzgrs() %>" style="width: 97%" size="10">
	  </td>
      <td class="td_message"></td>
      <td class="l-table-edit-td-right">职业病累计人数：</td>
      <td  class="l-table-edit-td-left" ><input name="zybrenshu" type="text" maxlength=4 value="<%=eb.getZybrenshu() %>" style="width: 97%" size="4">
	  </td>
	  <td class="td_message"></td>
	</tr>
	<tr>		
      <td class="l-table-edit-td-right">填表人：</td>
      <td  class="l-table-edit-td-left" > <input name="sbren" type="text" id="sbren" maxlength=16 value="<%=eb.getSbren() %>" style="width: 50%" size="16"><br></td>       
	 <td class="td_message"></td>
	  <td class="l-table-edit-td-right">电话：</td>
	 <td  class="l-table-edit-td-left" ><input name="sbrendh" type="text" id="sbrendh" maxlength=20 value="<%=eb.getSbrendh() %>" style="width: 50%" size="20"></td>	     
      <td class="td_message"></td>    
     </tr>
  	
</table>
<br/> 
<br/>
<table style="font-size:20px;width:750px">	
 <tr>
<td colspan="5" style="text-align:center"><h5>职业病危害因素分布情况</h5></td>
 
 </tr>
 <tr>
 	<td class="l-table-edit-td-right" style="width:50px">作业场所名称</td>
 	<td class="l-table-edit-td-right" style="width:50px">职业病危害因素名称</td>
 	<td class="l-table-edit-td-right" style="width:50px">现场浓度(强度)</td>
 	<td class="l-table-edit-td-right" style="width:50px">接触人数(可重复)</td>
 	<td class="l-table-edit-td-right" style="width:50px">接触人数(不重复)</td>
 </tr>
 
 	<%
 		Z_siteBean si=new Z_siteBean();
 		List<Z_siteBean> sis=si.findByWhere(" where corpkey='"+eb.getCorpkey()+"'");
 		for(int i=0;i<sis.size();i++){
 			Z_siteBean s=sis.get(i);
 			Z_whBean wh=new Z_whBean();
 			List<Z_whBean> whs=wh.find(" where siteID='"+s.getId()+"' and corpkey='"+s.getCorpkey()+"'");
 			for(int j=0;j<whs.size();j++){
 				Z_whBean zwh=whs.get(j);
 			%>
 			<tr>
 			<td class="l-table-edit-td-left" style="width:50px"><input name="" type="text" id="" maxlength=20 value="<%=s.getZymc() %>"  /></td>
 			<td class="l-table-edit-td-left" style="width:50px"><input name="" type="text" id="" maxlength=20 value="<%=EnumerationType.getEnu("WHYS",zwh.getWhdm()) %>" /></td>
 			<td class="l-table-edit-td-left" style="width:50px"><input name="" type="text" id="" maxlength=20 value="<%=zwh.getNdorqd() %>"  /></td>
 			<td class="l-table-edit-td-left" style="width:50px"><input name="" type="text" id="" maxlength=20 value="<%=zwh.getJcrenshu() %>" /></td>
 			<td class="l-table-edit-td-left" style="width:50px"><input name="" type="text" id="" maxlength=20 value="<%=s.getJcrenshu() %>"  /></td>
 			 </tr>
 		<%}
 		}
 	 %>

</table>
</form>

  </body>
</html>
