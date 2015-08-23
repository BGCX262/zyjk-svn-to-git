<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:directive.page import="st.portal.html.DBSelect"/>
<jsp:directive.page import="st.platform.system.cache.EnumerationType"/>
<jsp:directive.page import="st.portal.action.MessageBean"/>
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<jsp:directive.page import="st.platform.db.SerialNumber"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<jsp:directive.page import="UI.util.*"/>
<jsp:directive.page import="UI.dao.enterfile.*"/>
<jsp:directive.page import="UI.dao.zyjk.*"/>
<jsp:directive.page import="st.system.dao.PtenudetailBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp" %>
<head>
<title>单位基本信息</title>
<%
String state=request.getParameter("state");
String strSysno=request.getParameter("strSysno");
QyjbqkBean qyjbqkBean =new QyjbqkBean();

    //企业用户	
	T_officerBean officer=(T_officerBean )session.getAttribute(SystemAttributeNames.CORP_INFO_NAME);
	//此处判断是否企业初次登陆系统
    if(null!=officer){		 
		 qyjbqkBean=qyjbqkBean.findFirst(" where corpkey='"+officer.getLogin_id()+"'");
		 if(null==qyjbqkBean){
			 Z_corBean zcorebean=new Z_corBean();
		     zcorebean=zcorebean.findFirst(" where corpkey='"+ strSysno +"'");
		     qyjbqkBean=new QyjbqkBean();
			 Reflect.setVOFromForm(qyjbqkBean, zcorebean);
			 qyjbqkBean.setFddbr(zcorebean.getLeader());
			 //转换主管单位
			 PtenudetailBean detailBean=new PtenudetailBean();
			 detailBean=detailBean.findFirst(" where enutype='ZGDW' and enuitemlabel like '%"+ zcorebean.getZhuguan() +"%'");
			 if(null!=detailBean&&!"".equals(detailBean)){
				 //国属省属县属企业  
				 qyjbqkBean.setZhuguan(detailBean.getEnuitemvalue()); 	 
			 }else{
				 //其他主管类型企业
				 qyjbqkBean.setZhuguan("05");
				 qyjbqkBean.setOtherzg(zcorebean.getZhuguan());
			 }
			 
			 qyjbqkBean.setZczb(zcorebean.getZichan());
			 qyjbqkBean.setZywsfzr(zcorebean.getZywsleader());
		 }else{
			 qyjbqkBean = (QyjbqkBean)request.getAttribute("qyjbqkBean");
		 }
		 
	}
//点击登陆页面右侧的表单打开单位信息表时去掉最下的提交按钮
String showButton=request.getParameter("showButton");
MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
%>
    <style>
     #leftitem {
	       background-color:#eaf2ff;
     }
   </style> 
<script language="javascript" src="<%=webpath%>/UI/enterfile/qyenterinfo.js"></script>
</head>
<body class="menubody" style="width: 780">
<%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>
         
   <div class="navline" ></div> --%> 
<form name="form" method="post"  id="form">
<!-- 隐藏域 主键id -->
<input type="hidden" id="enterno" name="qyjbqkBean.enterno" value="<%=qyjbqkBean.getEnterno() %>"/>
<input type="hidden" id="corpkey" name="qyjbqkBean.corpkey" value="<%=qyjbqkBean.getCorpkey() %>"/>
 <!--  -->           
<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
<!-- 操作method -->   
<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
<!-- 操作message信息 -->    
<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
<!-- -->	
<input type="hidden"  id="distcode" name="qyjbqkBean.distcode" value="<%=qyjbqkBean.getDistcode()%>"/>
<!-- 判断提交按钮是否存在的标志位-->	
<input type="hidden"  id="showButton" name="showButton" value="<%=showButton%>"/>
<!-- strSysno-->
<input type="hidden"  id="strSysno" name="strSysno" value="<%=strSysno%>"/>
    	<br/>
     <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center" >
         <tr>
        <td class="l-table-edit-td-left" id="leftitem">单位名称：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.dwmc" id="dwmc" value="<%= qyjbqkBean.getDwmc()%>" style="width: 97%" validate="{required:true}"/></td>
        <td class="td_message" style="width:100px"></td>
                
         <td class="l-table-edit-td-left" id="leftitem">企业工商注册号：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.gszch" id="gszch" value="<%=qyjbqkBean.getGszch() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      
      <tr>
         
        <td class="l-table-edit-td-left" id="leftitem">组织机构代码：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.zzjgdm" id="zzjgdm" value="<%= qyjbqkBean.getZzjgdm()%>" style="width: 97%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  id="leftitem">行政区划：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="" id="enuditcode" value="<%=DistcodeUtil.getDistName(qyjbqkBean.getDistcode())%>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      <tr>

        
        <td  class="l-table-edit-td-left" id="leftitem">单 位 注 册 地 址：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.zcdz" id="zcdz" value="<%=qyjbqkBean.getZcdz()%>" style="width: 97%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" id="leftitem">建厂日期：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="date" name="qyjbqkBean.jcdate" id="jcdate" value="<%=qyjbqkBean.getJcdate() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      
      </tr>
      
      <tr>     
        <td class="l-table-edit-td-left" id="leftitem">注册地址邮政编码：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.zcyzbm" id="zcyzbm" value="<%=qyjbqkBean.getZcyzbm() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" id="leftitem">作 业 场 所 地 址：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.csdz" id="csdz" value="<%=qyjbqkBean.getCsdz() %>" style="width: 97%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left"  id="leftitem">作业场所邮政编码：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.csyzbm" id="csyzbm" value="<%=qyjbqkBean.getCsyzbm() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  id="leftitem">法定代表人：</td>
        <td class="l-table-edit-td-left" style="width:13%"><input type="text" ltype="text" name="qyjbqkBean.fddbr" id="fddbr" value="<%=qyjbqkBean.getFddbr() %>" style="width: 95%" validate="{required:true}"/></td>      
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left" width="15%"  id="leftitem">联系电话：</td>
        <td class="l-table-edit-td-left" width="12%"><input type="text" ltype="text" name="qyjbqkBean.lxdh" id="lxdh" value="<%=qyjbqkBean.getLxdh() %>" style="width: 95%" validate="{required:true}"/></td>
         <td class="td_message"></td>
         <td class="l-table-edit-td-left"   id="leftitem" >注册资本(万元)：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.zczb" id="zczb" value="<%=qyjbqkBean.getZczb() %>" style="width: 95%" validate="{required:true}"/></td>    
        <td class="td_message"></td>
      </tr>
      
      <%--<tr>
        <td class="l-table-edit-td-left"  >法人代表身份证号</td>
        <td class="l-table-edit-td-left" style="width:13%"><input type="text" ltype="text" name="qyjbqkBean.frdbsfzh" id="frdbsfzh" value="<%=qyjbqkBean.getFrdbsfzh() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" width="15%"  >法人邮箱</td>
        <td class="l-table-edit-td-left" width="12%"><input type="text" ltype="text" name="qyjbqkBean.ddremail" id="ddremail" value="<%=qyjbqkBean.getDdremail() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      
      
      --%><tr> 
         <td class="l-table-edit-td-left"  id="leftitem">注册类型：</td>
         <td class="l-table-edit-td-left" >
          <% 
				               	 DBSelect dbsel = new DBSelect("qyjbqkBean.zclx","ZCLX",qyjbqkBean.getZclx());
				 				 //dbsel.addAttr("style", "width: 202px;");
				 				 dbsel.addAttr("id", "zclx");
				                 dbsel.addAttr("check", "notBlank");
				                 dbsel.addAttr("required", "true");
				                 dbsel.addAttr("showName", "是否合格");
				                 dbsel.addOption("请选择","");
			 	             	 dbsel.setDisplayAll(false);
				                 out.print(dbsel);
				            %>
         </td>
         <td class="td_message"></td>
         <td class="l-table-edit-td-left"  id="leftitem">行业分类：</td>
         <td class="l-table-edit-td-left" ><input type="hidden" name="qyjbqkBean.hyfl" id="hyfl" value="<%=qyjbqkBean.getHyfl()%>" />
         	<input type="hidden" name="qyjbqkBean.hyfl1" id="hyfl1" value="<%=qyjbqkBean.getHyfl1()%>" />
         	<input type="hidden" name="qyjbqkBean.hyfl2" id="hyfl2" value="<%=qyjbqkBean.getHyfl2()%>" />
        <input  id="hyflname"  type="text" value="<%=EnumerationType.getEnu("HYLB", qyjbqkBean.getHyfl())%>"/>	                      
         
         </td>
         <td class="td_message"></td>
      </tr> 
       <tr>
        
        <td class="l-table-edit-td-left"  id="leftitem">企业年度产值(万元)：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.chanzhi" id="chanzhi" value="<%=qyjbqkBean.getChanzhi() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  id="leftitem">资产总额(万元)：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" name="qyjbqkBean.zichan" id="zichan" value="<%=qyjbqkBean.getZichan() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr> 
      <tr>
       <td class="l-table-edit-td-left"  id="leftitem">主管单位：</td>
        <td class="l-table-edit-td-left"  >
                      <% 
	               	 dbsel = new DBSelect("qyjbqkBean.zhuguan","ZGDW",qyjbqkBean.getZhuguan());
	 				 dbsel.addAttr("style", "width: 202px;");
	 				  dbsel.addAttr("id", "zhuguan");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("onchange","addTd(this)");
	                 dbsel.addAttr("showName", "主管单位");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
       </td>    
        <td class="td_message"></td>
      </tr>
      <tr id="othertype" style="display:none">
      <td class="l-table-edit-td-right"  style="color:red ">其他主管单位类型: </td>
        <td class="l-table-edit-td-left"  >
        <input type="text" id="otherzg" name="qyjbqkBean.otherzg"  value="<%=qyjbqkBean.getOtherzg() %>"/>      
       </td>    
        <td class="td_message"></td>
      
      </tr>    
       <tr>
         <td class="l-table-edit-td-left"  id="leftitem">是否有专门职业卫生管理机构：</td>
         <td class="l-table-edit-td-left"  >
        	<% 
	               	 dbsel = new DBSelect("qyjbqkBean.zywsjgshu","SF",qyjbqkBean.getZywsjgshu());
	 				 dbsel.addAttr("style", "width: 202px;");
	 				  dbsel.addAttr("id", "zywsjgshu");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "是否有专门的职业卫生管理机构");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
         </td>
         <td class="td_message"></td>
         <td class="l-table-edit-td-left"  id="leftitem">职业卫生管理机构：</td>
         <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.zywsjg" id="zywsjg" value="<%=qyjbqkBean.getZywsjg() %>" style="width: 95%" validate="{required:true}"/></td>
         <td class="td_message"></td>
         
      </tr>
     
      <tr>
         <td class="l-table-edit-td-left"  id="leftitem">职业卫生管理负责人：</td>
         <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.zywsfzr" id="zywsfzr" value="<%=qyjbqkBean.getZywsfzr() %>" style="width: 95%" validate="{required:true}"/></td>
         <td class="td_message"></td>
         <td class="l-table-edit-td-left" id="leftitem">职业卫生机构联系电话：</td>
         <td  class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.zywslxdh" id="zywslxdh" value="<%=qyjbqkBean.getZywslxdh() %>" style="width: 95%" validate="{required:true}"/></td>
         <td class="td_message"></td>
        
      </tr>
     <%--
      <tr>
          <td class="l-table-edit-td-left"  >填报类别</td>
        
        <td class="l-table-edit-td-left">
        	<% 
	               	 dbsel = new DBSelect("qyjbqkBean.tblb","TBLB",qyjbqkBean.getTblb());
	 				 dbsel.addAttr("style", "width: 202px;");
	 				 dbsel.addAttr("id", "tblb");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "填报类别");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
        </td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"    >变更原因</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.bgyy" id="bgyy" value="<%=qyjbqkBean.getBgyy() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      
      </tr>
      
       --%>
       <tr>
         <td class="l-table-edit-td-left"  id="leftitem">职业卫生管理人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.zywsgl" id="zywsgl" value="<%=qyjbqkBean.getZywsgl()%>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
          <td class="l-table-edit-td-left" id="leftitem">职业病危害因素：</td>
        
        <td class="l-table-edit-td-left" >
        	        
			    <input type="hidden"   id="whys" name="qyjbqkBean.whys" style="width:10px;"  fieldname="whys"   alerttitle="危害因素" value="<%=qyjbqkBean.getWhys() %>" fieldType="text" />
			    <input id="whysname" name="qyjbqkBean.whysname"  style="width:100%;"  fieldname="whysname"   alerttitle="危害因素名称"  type="text" value="<%=qyjbqkBean.getWhysname() %>" />
			    
			    
        </td>
        <td class="td_message"></td>
      
      </tr><%--
      
       <tr>
        <td class="l-table-edit-td-left"  >其他原因具体说明</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text"  name="qyjbqkBean.qtbgyy" id="qtbgyy" value="<%=qyjbqkBean.getQtbgyy()%>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left">是否存在重大危险源</td>
        <td class="l-table-edit-td-left"  >
        <% 
	               	 dbsel = new DBSelect("qyjbqkBean.sfczzdwxy","SF",qyjbqkBean.getSfczzdwxy());
	 				 dbsel.addAttr("style", "width: 202px;");
	 				 dbsel.addAttr("id", "sfczzdwxy");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "是否存在重大危险源");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	     %>
      </td>
      <td class="td_message"></td>
      </tr>
      
      --%><tr>
        <td class="l-table-edit-td-left" id="leftitem">在岗职工总人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.nmzgrs" id="nmzgrs" value="<%=qyjbqkBean.getNmzgrs()%>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left" id="leftitem" >其中：女工</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.scwomen" id="scwomen" value="<%=qyjbqkBean.getScwomen()%>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" width="12%"  id="leftitem">农民工</td>
        <td class="l-table-edit-td-left" width="8%" ><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.scnongmin" id="scnongmin" value="<%=qyjbqkBean.getScnongmin() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left"  id="leftitem">接触职业危害总人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.whrenshu" id="whrenshu" value="<%=qyjbqkBean.getWhrenshu() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left"  id="leftitem">其中：女工</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.whwomen" id="whwomen" value="<%=qyjbqkBean.getWhwomen() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" width="12%"  id="leftitem">农民工</td>
        <td class="l-table-edit-td-left" width="8%"  ><input type="text" ligerui="{type:'int'}" ltype="spinner" name="qyjbqkBean.whnongmin" id="whnongmin" value="<%=qyjbqkBean.getWhnongmin()%>" style="width: 95%" validate="{required:true}"/></td> 
        <td class="td_message"></td>
      </tr>
      
      <tr>
        <td class="l-table-edit-td-left"  id="leftitem">职业病累计人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.zybrenshu" id="zybrenshu" value="<%=qyjbqkBean.getZybrenshu()%>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>        
        <td class="l-table-edit-td-left"  id="leftitem">新增职业病人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.zybrenshuxz" id="zybrenshuxz" value="<%=qyjbqkBean.getZybrenshuxz()%>" style="width: 95%" validate="{required:true}"/></td>    
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left"   id="leftitem">疑似职业病人数：</td>
        <td class="l-table-edit-td-left"   ><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.zybrenshuys" id="zybrenshuys" value="<%=qyjbqkBean.getZybrenshuys() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" width="20%" id="leftitem">调离人数：</td>
        <td class="l-table-edit-td-left" width="8%"><input type="text" ltype="text"  name="qyjbqkBean.dlrenshu" id="dlrenshu" value="<%=qyjbqkBean.getDlrenshu() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      
      </tr>
      
      <tr>
        <td class="l-table-edit-td-left" width="20%"   id="leftitem" >参加职业危害培训总人数：</td>
        <td class="l-table-edit-td-left" width="8%"    ><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.pxrenshu" id="pxrenshu" value="<%=qyjbqkBean.getPxrenshu() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  id="leftitem">岗前体检人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.tjrenshu" id="tjrenshu" value="<%=qyjbqkBean.getTjrenshu() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      <tr>

        <td class="l-table-edit-td-left" id="leftitem">在岗体检人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.tjrenshu2" id="tjrenshu2" value="<%=qyjbqkBean.getTjrenshu2() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"     id="leftitem">离岗体检人数：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="spinner" ligerui="{type:'int'}" name="qyjbqkBean.tjrenshu3" id="tjrenshu3" value="<%=qyjbqkBean.getTjrenshu3()%>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
       <tr>
        <td class="l-table-edit-td-left"  id="leftitem">职业病危害检测机构：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.ysjiancejg" id="ysjiancejg" value="<%=qyjbqkBean.getYsjiancejg()%>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  id="leftitem">职业卫生培训机构：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.glpeixunjg" id="glpeixunjg" value="<%=qyjbqkBean.getGlpeixunjg() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      
       <tr>
       	<td class="l-table-edit-td-left"  id="leftitem">职业健康查体机构：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.gltijianjg" id="gltijianjg" value="<%=qyjbqkBean.getGltijianjg()%>" style="width: 95%" validate="{required:true}"/></td>
       	<td class="td_message"></td>

        <%--<td class="l-table-edit-td-left"    >检测日期</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="date" name="qyjbqkBean.ysjiancedate" id="ysjiancedate" value="<%=qyjbqkBean.getYsjiancedate() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>--%>
      </tr>
      
      <%--<tr>
       	<td class="l-table-edit-td-left"  >体检日期</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="date" name="qyjbqkBean.gltijiandate" id="gltijiandate" value="<%=qyjbqkBean.getGltijiandate() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  >培训日期</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="date" name="qyjbqkBean.glpeixundate" id="glpeixundate" value="<%=qyjbqkBean.getGlpeixundate() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      
      --%><tr>
       	<td class="l-table-edit-td-left"  id="leftitem">接触粉尘的人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" name="qyjbqkBean.jcfcren" id="jcfcren" value="<%=qyjbqkBean.getJcfcren() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" id="leftitem" >接触化学毒物的人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" name="qyjbqkBean.jchxren" id="jchxren" value="<%=qyjbqkBean.getJchxren() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      
      <tr>
        <td class="l-table-edit-td-left" id="leftitem">接触物理因素的人数：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="spinner" name="qyjbqkBean.jcwlren" id="jcwlren" value="<%=qyjbqkBean.getJcwlren() %>" style="width: 95%" validate="{required:true}"/></td>
       	<td class="td_message"></td>
       	<td class="l-table-edit-td-left"  id="leftitem">接触辐射的人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" name="qyjbqkBean.jcfsren" id="jcfsren" value="<%=qyjbqkBean.getJcfsren() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      </tr>
      <tr>
         <td class="l-table-edit-td-left"  id="leftitem">接触其他职业危害因素的人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="spinner" name="qyjbqkBean.jcqtren" id="jcqtren" value="<%=qyjbqkBean.getJcqtren() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <%--<td class="l-table-edit-td-left">合同内告知职业病危害人数</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="text" name="qyjbqkBean.htngzzywhrs" id="htngzzywhrs" value="<%=qyjbqkBean.getHtngzzywhrs() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
      --%></tr>
      <%--<tr>
       	<td class="l-table-edit-td-left"  >职业病危害作业岗位数</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.zybzygws" id="zybzygws" value="<%=qyjbqkBean.getZybzygws() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  >设置警示标识岗位数</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.szjsbzgws" id="szjsbzgws" value="<%=qyjbqkBean.getSzjsbzgws() %>" style="width: 95%" validate="{required:true}"/></td>     
        <td class="td_message"></td>
      </tr>
      
       <tr>
       	<td class="l-table-edit-td-left"  >应职业卫生培训数</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.yzywspxs" id="yzywspxs" value="<%=qyjbqkBean.getZybzygws() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  >应职业健康检查人数</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.yzyjkjcs" id="yzyjkjcs" value="<%=qyjbqkBean.getSzjsbzgws() %>" style="width: 95%" validate="{required:true}"/></td>     
        <td class="td_message"></td>
      </tr>
      
                  --%><tr>
          	<td class="l-table-edit-td-left"  id="leftitem">联系人：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.ystbren" id="ystbren" value="<%=qyjbqkBean.getYstbren() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
         <td class="l-table-edit-td-left"  id="leftitem">联系电话：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.sbrendh" id="sbrendh" value="<%=qyjbqkBean.getSbrendh() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>

      </tr>
      <tr>
              <td class="l-table-edit-td-left"    id="leftitem">填表日期：</td>
        <td class="l-table-edit-td-left"  ><input type="text" ltype="date" name="qyjbqkBean.ystbdate" id="ystbdate" value="<%=qyjbqkBean.getYstbdate() %>" style="width: 95%" validate="{required:true}"/></td>
        <td class="td_message"></td>
               	
       	<%--<td class="l-table-edit-td-left"  >当前填报部门</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="qyjbqkBean.ystbbm" id="ystbbm" value="<%=qyjbqkBean.getYstbbm() %>" style="width: 95%" validate="{required:true}"/></td>       
        <td class="td_message"></td>
      
      --%></tr>
    </table>
   <br/>
    <table  class="button_table">
   <tr>
     <td>
     <input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /> 

</tr>
</table>
</form> 
</body>
</html>
