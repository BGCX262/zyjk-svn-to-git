<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.T_yhzc_bzbBean"/>
<jsp:directive.page import="st.portal.action.MessageBean"/>
<jsp:directive.page import="UI.dao.zyjk.ZczjqyxxzbBean"/>
<jsp:directive.page import="UI.dao.zyjk.ZczjdfbBean"/>
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<jsp:directive.page import="UI.util.*"/>
<jsp:directive.page import="UI.dao.zyjk.T_officerBean"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<%@ page import="st.portal.html.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
ZczjqyxxzbBean zczjqyxxzbBean=(ZczjqyxxzbBean)request.getAttribute("zczjqyxxzbBean");
QyjbqkBean qyjbqkBean=new QyjbqkBean();
qyjbqkBean=qyjbqkBean.findFirst(" where enterno='"+ zczjqyxxzbBean.getEnterno() +"'");
if(null==qyjbqkBean){
	qyjbqkBean=new QyjbqkBean();
}

if(null==zczjqyxxzbBean){
	zczjqyxxzbBean=new ZczjqyxxzbBean();
}
if(null==messageBean){
	messageBean=new MessageBean();
}
String state="1";
T_officerBean officer=(T_officerBean )session.getAttribute(SystemAttributeNames.CORP_INFO_NAME);
if(null!=officer){		 
	state="0"; 
}
//String login_id=request.getParameter("login_id");
//QyjbqkBean qyjbqkbean=new QyjbqkBean();
//qyjbqkbean=qyjbqkbean.findFirst(" where corpkey='"+ login_id +"'");


//if(null!=qyjbqkbean&&!"".equals(qyjbqkbean)){
	
	//Reflect.setVOFromForm(zczjqyxxzbBean, qyjbqkbean);	
//}


List<T_yhzc_bzbBean> list=(List<T_yhzc_bzbBean>)request.getAttribute("list");
Map<Object,Object> nrmap=(Map<Object,Object>)request.getAttribute("nrmap");
Map<Object,Object> ffmap=(Map<Object,Object>)request.getAttribute("ffmap");
Map<Object,Object> dfmap=(Map<Object,Object>)request.getAttribute("dfmap");
int con=0;
%>
<%@ include file="/webpath.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>自查自纠表</title>
<link href="<%=webpath%>/js/ligerUI/skins/Aqua/css/ligerui-all.css"   rel="stylesheet" type="text/css" />
<link href="<%=webpath%>/js/ligerUI/skins/ligerui-icons.css"          rel="stylesheet" type="text/css" />
<link href="<%=webpath%>/css/zpf.css"  								  rel="stylesheet" type="text/css" />
<!--全文jquery引用 -->
<script src="<%=webpath%>/js/jquery/jquery-1.5.2.min.js"              type="text/javascript"></script>

<!-- ligerUI控件 -->
<script src="<%=webpath%>/js/ligerUI/js/core/base.js"                 type="text/javascript"></script> 
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerGrid.js"         type="text/javascript"></script> 
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerTextBox.js"      type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerCheckBox.js"     type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerMenu.js"         type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerComboBox.js"     type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerMenuBar.js"      type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerToolBar.js"      type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerButton.js"       type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerResizable.js"    type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerDrag.js"         type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerDialog.js"       type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerForm.js"         type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerDateEditor.js"   type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerSpinner.js"      type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerTip.js"          type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerTree.js"         type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerLayout.js" 	  type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerTab.js"          type="text/javascript"></script>
<script src="<%=webpath%>/js/ligerUI/js/plugins/ligerAccordion.js" 	  type="text/javascript"></script>  
<!-- validation控件 -->
<script src="<%=webpath%>/js/jquery-validation/jquery.validate.min.js" type="text/javascript"></script> 
<script src="<%=webpath%>/js/jquery-validation/jquery.metadata.js"     type="text/javascript"></script>
<script src="<%=webpath%>/js/jquery-validation/messages_cn.js"         type="text/javascript"></script>
    
<!-- JS全局变量 -->
<script src="<%=webpath%>/js/jsConstant.js"                            type="text/javascript"></script>     
<script src="<%=webpath%>/js/zbasic.js"                                 type="text/javascript"></script>
<script src="<%=webpath%>/js/zgrid.js"                                 type="text/javascript"></script>
<script src="<%=webpath%>/js/zform.js"                                 type="text/javascript"></script>
	<script src="<%=webpath%>/UI/zczj/zywhzczjbn.js" type="text/javascript"></script>
	
	<style>
		body,td,th {font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 12px;color: #1d1007; line-height:24px} 
		.table{border:solid #B0C4DE; border-width:1px 0px 0px 1px;}
		.tableth{border:solid #B0C4DE; border-width:0px 1px 1px 0px; padding-left:10px;}
		.tabletd{border:solid #B0C4DE; border-width:0px 1px 1px 0px; padding-left:10px;}
	</style>
  </head>
  
  <body>
    	<form name="form" id="form" action="">
    		<div>
			    <!-- 隐藏域 主键id -->
				<input type="hidden" id="sysno" name="zczjqyxxzbBean.sysno" value="<%=zczjqyxxzbBean.getSysno()%>"/>
				 <!-- 隐藏域 主键id -->
				<input type="hidden" id="zbid" name="zczjqyxxzbBean.zbid" value="<%=zczjqyxxzbBean.getZbid()%>"/>
				<!-- 操作method -->		 	
			 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod()%>"/>
			 	<!-- 操作状态flag -->	
			 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
			 	<!-- 操作message信息 -->	
			 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
			 	<!--区划 -->	
			 	<input type="hidden"  id="ditcode" name="zczjqyxxzbBean.ditcode" value="<%=zczjqyxxzbBean.getDitcode()%>"/>
			 	<!-- -->	
			 	<input type="hidden" id="state" value="<%=state %>"/>
			 	<!-- -->	
			 	<input type="hidden" id="bak1" name="zczjqyxxzbBean.bak1" value="<%=zczjqyxxzbBean.getBak1() %>"/>
			 	<!--国家数据库主键 -->	
			 	<input type="hidden" id="corpkey" name="zczjqyxxzbBean.corpkey" value="<%=zczjqyxxzbBean.getCorpkey() %>"/>
			 	<!--企业主键 -->	
			 	<input type="hidden" id="" name="" value="<%=zczjqyxxzbBean.getEnterno() %>"/>
			</div>
			
    		<table width="90%" align="center">
    			<tr>
    				<td colspan="10" height="50" align="center" style="font-size: 25px;padding-top: 5px;">用人单位职业卫生基础建设自查自纠表</td>
    			</tr>
    			<tr>
    				<td class="l-table-edit-td-right">企业名称：</td>
    				<td ><input  type="text" id="dwmc" readonly name="zczjqyxxzbBean.dwmc" value="<%=zczjqyxxzbBean.getDwmc()%>"/></td>
    				
    				<td class="l-table-edit-td-right">单位地址：</td>
    				<td>
    				<input type="text"  id="dwdz" name="" readonly value="<%=qyjbqkBean.getZcdz() %>"/></td>
    				
    				<td class="l-table-edit-td-right">所在地区：</td>
    				<td>
    				<input type="text"  id="enuditcode" name="" value="<%=DistcodeUtil.getDistName(zczjqyxxzbBean.getDitcode())%>"/></td>
    				
    				</tr>
    				<tr>
    				<td class="l-table-edit-td-right">联系人：</td>
    				<td><input  type="text" id="lxr" name="zczjqyxxzbBean.lxr" value="<%=zczjqyxxzbBean.getLxr()%>"/></td>
    				<td class="l-table-edit-td-right">电话：</td>
    				<td><input type="text"  id="lxdh" name="zczjqyxxzbBean.lxdh" value="<%=zczjqyxxzbBean.getLxdh()%>"/></td>
    				<td class="l-table-edit-td-right">自查日期：</td>
    				<td><input type="text" id="zcsj" name="zczjqyxxzbBean.zcsj" value="<%=zczjqyxxzbBean.getZcsj()%>" ltype="date"/></td>
    			</tr>
    		</table>
    		<br>
    		<table width="90%" border="1" align="center" class="table">
    		<tr>
    			<th class="tableth" style="width: 10%;text-align: center;">项目</th>
    			<th class="tableth" style="width: 20%;text-align: center;">主要内容</th>
    			<th class="tableth" style="width: 70%;text-align: center;">方法</th>
    			<th class="tableth" style="width: 10%;text-align: center;">自查结果</th>
    		</tr>
    		<%for(int i=0;i<list.size();i++){ 
    			T_yhzc_bzbBean zb=list.get(i);
    			List<T_yhzc_bzbBean> nrlist=(List<T_yhzc_bzbBean>)nrmap.get(zb);
    		%>
    			<tr onMouseOver=this.style.backgroundColor:'#eaf2ff';this.style.cursor='hand' onMouseOut=this.style.backgroundColor=''>
    				<td class="tabletd" rowspan="<%=zb.getBz() %>">
    					<%=zb.getBzmc() %>
    				</td>
    				<%for(int j=0;j<nrlist.size();j++){
    					T_yhzc_bzbBean nrbz=nrlist.get(j);
    					List<T_yhzc_bzbBean> fflist=(List<T_yhzc_bzbBean>)ffmap.get(nrbz);
    				 %>
    					<td class="tabletd" rowspan="<%=nrbz.getBz()%>">
    						<%=nrbz.getBzmc() %>
    					</td>
    					<%for(int c=0;c<fflist.size();c++){
    						T_yhzc_bzbBean ffbz=fflist.get(c);
    						ZczjdfbBean df=(ZczjdfbBean)dfmap.get(ffbz);
    						if(null==df){
    							df=new ZczjdfbBean();
    						}
    					 %>
    					 <td class="tabletd" rowspan="<%=ffbz.getBz()%>">
    						<%=ffbz.getBzmc() %>
    					</td>
    						
    					
    					<%if(df.getFs().equals("2")){ %>
    						<td class="tabletd" rowspan="<%=ffbz.getBz()%>" style="color: #FFFF;">
    					<%}else{ %>
    						<td class="tabletd" rowspan="<%=ffbz.getBz()%>">
    					<%} %>
    						
    						<input type="hidden" id="zlsysno<%=con %>" name="beans[<%=con %>].zlsysno" value="<%=zb.getZbid() %>"/>
    						<input type="hidden" id="xmsysno<%=con %>" name="beans[<%=con %>].xmsysno" value="<%=zb.getId() %>"/>
    						<input type="hidden" id="nrsysno<%=con %>" name="beans[<%=con %>].nrsysno" value="<%=nrbz.getId() %>"/>
    						<input type="hidden" id="ffsysno<%=con %>" name="beans[<%=con %>].ffsysno" value="<%=ffbz.getId() %>"/>
    						<% 
				               	 //DBSelect dbsel = new DBSelect("beans["+con+"].fs","SFHG",df.getFs());
				 				 //dbsel.addAttr("style", "width: 202px;");
				                 //dbsel.addAttr("check", "notBlank");
				                 //dbsel.addAttr("required", "true");
				                 //dbsel.addAttr("showName", "是否合格");
			 	             	 //dbsel.setDisplayAll(false);
				                 //out.print(dbsel);
				                 DBRadio check = new DBRadio("beans["+con+"].fs","beans["+con+"].fs","SFHG",df.getFs());
                     	         out.print(check.toString());
				            %>
    					
    					</td>
    					
    					</tr>
    					<% 
    						con++;
    					//System.out.println(con++);
    					} %>
    				<%} %>
    			
    		<%} %>
    		<tr>
    			<td class="tabletd">
    			<center>
    			总计</br>
    				（60项）
    			</center>
    				
    			</td>
    			<td colspan="3" height="40px" class="tabletd">
    				<table >
    					<tr>
    						<td>合格</td><td><input type="text" readonly="readonly" name="zczjqyxxzbBean.hgx" id="hgx" validate="{required:true}" value="<%=zczjqyxxzbBean.getHgx() %>" style="width: 25px"/></td><td>项，</td>
    						<td>不合格</td><td><input type="text" readonly="readonly" name="zczjqyxxzbBean.bhgx" id="bhgx" validate="{required:true}" value="<%=zczjqyxxzbBean.getBhgx() %>" style="width: 25px"/></td><td>项，</td>
    						<td>合格率</td><td><input type="text" readonly="readonly" name="zczjqyxxzbBean.hgl" id="hgl" validate="{required:true}" value="<%=zczjqyxxzbBean.getHgl() %>" style="width: 25px"/></td><td>%</td>
    						<td><input type="button" value="计算结果" onclick="getResult()" class="l-button l-button-test"/></td>
    					</tr>
    				</table>
    			</td>
    			
    		</tr>
    		</table>
    		<br>
    		<table align="center">
			<tr>
				<td>
					<input type="button" value="暂存" id="zcButton" onclick="zc()" class="l-button l-button-submit" /> 
				</td>
				<td>
					<input type="submit" value="上报" id="subButton" class="l-button l-button-submit" /> 
				</td>
			</tr>
				
			</table>
			<br>
    	</form>
  </body>
 
</html>
