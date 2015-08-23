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
			 qyjbqkBean.setZhuguan(detailBean.getEnuitemvalue()); 
			 //
			 qyjbqkBean.setZczb(zcorebean.getZichan());
			 qyjbqkBean.setZywsfzr(zcorebean.getZywsleader());
			 //System.out.println("==================================测试打印=================================");
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
<script language="javascript" src="<%=webpath%>/UI/enterfile/enterinfolook.js"></script>
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
     <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
         <tr>
        <td class="l-table-edit-td-left" id="leftitem">单位名称：</td>
        <td class="l-table-edit-td-left" style="width:150px">
        <%= qyjbqkBean.getDwmc()%></td>
        <td class="td_message" style="width:100px"></td>
                
         <td class="l-table-edit-td-left" id="leftitem">企业工商注册号：</td>
        <td class="l-table-edit-td-left"  style="width:150px"><%=qyjbqkBean.getGszch() %></td>
        <td class="td_message"></td>
      </tr>
      
      <tr>
         
        <td class="l-table-edit-td-left" id="leftitem">组织机构代码：</td>
        <td class="l-table-edit-td-left"  style="width:150px">
       <%= qyjbqkBean.getZzjgdm()%></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  id="leftitem">行政区划：</td>
        <td class="l-table-edit-td-left"  style="width:150px">
        <%=DistcodeUtil.getDistName(qyjbqkBean.getDistcode())%></td>
        <td class="td_message"></td>
      </tr>
      <tr>

        
        <td  class="l-table-edit-td-left" id="leftitem">单 位 注 册 地 址：</td>
        <td class="l-table-edit-td-left"  style="width:150px">
       <%=qyjbqkBean.getZcdz()%></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" id="leftitem">建厂日期：</td>
        <td class="l-table-edit-td-left"  style="width:150px">
       <%=qyjbqkBean.getJcdate() %></td>
        <td class="td_message"></td>
      
      </tr>
      
      <tr>     
        <td class="l-table-edit-td-left" id="leftitem">注册地址邮政编码：</td>
        <td class="l-table-edit-td-left"  style="width:150px">
        <%=qyjbqkBean.getZcyzbm() %></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" id="leftitem">作 业 场 所 地 址：</td>
        <td class="l-table-edit-td-left" style="width:150px" >
        <%=qyjbqkBean.getCsdz() %></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left"  id="leftitem">作业场所邮政编码：</td>
        <td class="l-table-edit-td-left"  style="width:150px">
        <%=qyjbqkBean.getCsyzbm() %></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  id="leftitem">法定代表人：</td>
        <td class="l-table-edit-td-left" style="width:150px">
        <%=qyjbqkBean.getFddbr() %></td>      
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left" width="15%"  id="leftitem">联系电话：</td>
        <td class="l-table-edit-td-left" style="width:150px">
        <%=qyjbqkBean.getLxdh() %></td>
         <td class="td_message"></td>
         <td class="l-table-edit-td-left"   id="leftitem" >注册资本(万元)：</td>
        <td class="l-table-edit-td-left"  style="width:150px">
        <%=qyjbqkBean.getZczb() %></td>    
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
         <td class="l-table-edit-td-left" style="width:150px">
	    <%=EnumerationType.getEnu("ZCLX", qyjbqkBean.getZclx())%>	  			            
         </td>
         <td class="td_message"></td>
         <td class="l-table-edit-td-left"  id="leftitem">行业分类：</td>
         <td class="l-table-edit-td-left" style="width:150px"><input type="hidden" name="qyjbqkBean.hyfl" id="hyfl" value="<%=qyjbqkBean.getHyfl()%>" />
         	<input type="hidden" name="qyjbqkBean.hyfl1" id="hyfl1" value="<%=qyjbqkBean.getHyfl1()%>" />
         	<input type="hidden" name="qyjbqkBean.hyfl2" id="hyfl2" value="<%=qyjbqkBean.getHyfl2()%>" />
       <%=EnumerationType.getEnu("HYLB", qyjbqkBean.getHyfl())%>                      
         
         </td>
         <td class="td_message"></td>
      </tr> 
       <tr>
        
        <td class="l-table-edit-td-left"  id="leftitem">企业年度产值(万元)：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getChanzhi() %></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  id="leftitem">资产总额(万元)：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getZichan() %></td>
        <td class="td_message"></td>
      </tr> 
      <tr>
       <td class="l-table-edit-td-left"  id="leftitem">主管单位：</td>
        <td class="l-table-edit-td-left"  style="width:150px">
        <%=EnumerationType.getEnu("ZGDW", qyjbqkBean.getZhuguan())%>
                      
       </td>    
        <td class="td_message"></td>
      </tr>
      <tr id="othertype" style="display:none">
      <td class="l-table-edit-td-right"  style="color:red ">其他主管单位类型: </td>
        <td class="l-table-edit-td-left"  >
       <%=qyjbqkBean.getOtherzg() %> 
       </td>    
        <td class="td_message"></td>
      
      </tr>    
       <tr>
         <td class="l-table-edit-td-left"  id="leftitem">是否有专门职业卫生管理机构：</td>
         <td class="l-table-edit-td-left"  style="width:150px">
          <%=EnumerationType.getEnu("SF", qyjbqkBean.getZywsjgshu())%>
        	
         </td>
         <td class="td_message"></td>
         <td class="l-table-edit-td-left"  id="leftitem">职业卫生管理机构：</td>
         <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getZywsjg() %></td>
         <td class="td_message"></td>
         
      </tr>
     
      <tr>
         <td class="l-table-edit-td-left"  id="leftitem">职业卫生管理负责人：</td>
         <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getZywsfzr() %></td>
         <td class="td_message"></td>
         <td class="l-table-edit-td-left" id="leftitem">职业卫生机构联系电话：</td>
         <td  class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getZywslxdh() %></td>
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
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getZywsgl()%></td>
        <td class="td_message"></td>
          <td class="l-table-edit-td-left" id="leftitem">职业病危害因素：</td>
        
        <td class="l-table-edit-td-left" style="width:150px">
        	        
			    <input type="hidden"   id="whys" name="qyjbqkBean.whys" style="width:10px;"  fieldname="whys"   alerttitle="危害因素" value="<%=qyjbqkBean.getWhys() %>" fieldType="text" />
			    <%=qyjbqkBean.getWhysname() %>		    
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
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getNmzgrs()%></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left" id="leftitem" >其中：女工</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getScwomen()%></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" width="12%"  id="leftitem">农民工</td>
        <td class="l-table-edit-td-left" style="width:150px" > <%=qyjbqkBean.getScnongmin() %></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left"  id="leftitem">接触职业危害总人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getWhrenshu() %></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left"  id="leftitem">其中：女工</td>
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getWhwomen() %></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" width="12%"  id="leftitem">农民工</td>
        <td class="l-table-edit-td-left" style="width:150px" ><%=qyjbqkBean.getWhnongmin()%></td> 
        <td class="td_message"></td>
      </tr>
      
      <tr>
        <td class="l-table-edit-td-left"  id="leftitem">职业病累计人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getZybrenshu()%></td>
        <td class="td_message"></td>        
        <td class="l-table-edit-td-left"  id="leftitem">新增职业病人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getZybrenshuxz()%></td>    
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-left"   id="leftitem">疑似职业病人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getZybrenshuys() %></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" width="20%" id="leftitem">调离人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getDlrenshu() %></td>
        <td class="td_message"></td>
      
      </tr>
      
      <tr>
        <td class="l-table-edit-td-left" width="20%"   id="leftitem" >参加职业危害培训总人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getPxrenshu() %></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  id="leftitem">岗前体检人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getTjrenshu() %></td>
        <td class="td_message"></td>
      </tr>
      <tr>

        <td class="l-table-edit-td-left" id="leftitem">在岗体检人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getTjrenshu2() %></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"     id="leftitem">离岗体检人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"> <%=qyjbqkBean.getTjrenshu3()%></td>
        <td class="td_message"></td>
      </tr>
       <tr>
        <td class="l-table-edit-td-left"  id="leftitem">职业病危害检测机构：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getYsjiancejg()%></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left"  id="leftitem">职业卫生培训机构：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getGlpeixunjg() %></td>
        <td class="td_message"></td>
      </tr>
      
       <tr>
       	<td class="l-table-edit-td-left"  id="leftitem">职业健康查体机构：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getGltijianjg()%></td>
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
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getJcfcren() %></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-left" id="leftitem" >接触化学毒物的人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getJchxren() %></td>
        <td class="td_message"></td>
      </tr>
      
      <tr>
        <td class="l-table-edit-td-left" id="leftitem">接触物理因素的人数：</td>
        <td class="l-table-edit-td-left"  style="width:150px"><%=qyjbqkBean.getJcwlren() %></td>
       	<td class="td_message"></td>
       	<td class="l-table-edit-td-left"  id="leftitem">接触辐射的人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getJcfsren() %></td>
        <td class="td_message"></td>
      </tr>
      <tr>
         <td class="l-table-edit-td-left"  id="leftitem">接触其他职业危害因素的人数：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getJcqtren() %></td>
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
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getYstbren() %></td>
        <td class="td_message"></td>
         <td class="l-table-edit-td-left"  id="leftitem">联系电话：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getSbrendh() %></td>
        <td class="td_message"></td>

      </tr>
      <tr>
              <td class="l-table-edit-td-left"    id="leftitem">填表日期：</td>
        <td class="l-table-edit-td-left" style="width:150px"><%=qyjbqkBean.getYstbdate() %></td>
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
     <input class="l-button l-button-edit"
     	type="button" value="信息修改" id="editButton" onclick="editCorp();"/>
</tr>
</table>
   <br/>
</form>
</body>
</html>
