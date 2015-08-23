<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:directive.page import="UI.dao.zyjk.ZyjkflfjBean"/>
<jsp:directive.page import="UI.dao.zyjk.Z_corBean"/>
<jsp:directive.page import="UI.dao.zyjk.Z_whBean"/>
<jsp:directive.page import="st.platform.system.cache.EnumerationType"/>
<jsp:directive.page import="UI.util.CommenUtil"/>
<jsp:directive.page import="st.portal.action.MessageBean"/>
<%@ include file="/global.jsp"%>
<%
 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ZyjkflfjBean bean=(ZyjkflfjBean)request.getAttribute("zyjkflfjBean");
MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
String result= (String)request.getAttribute("result");

String corpkey=request.getParameter("strSysno");
Z_corBean cor=new Z_corBean();
cor=cor.findFirst(" where corpkey='"+corpkey+"'");
if(null==bean){
	bean=new ZyjkflfjBean();
	//bean.setDistcode(_om.getDept().getDeptid().substring(3, 9));
	//String[] dises=_om.getDept().getDeptid().split("-");
	//if(dises[1].length()>8){
	//	bean.setDistcode(_om.getDept().getDeptid().substring(3, 11));
	//}
}else{
	corpkey=bean.getCorpkey();
	//bean.setDistcode(_om.getDept().getDeptid().substring(3, 9));
	//String[] dises=_om.getDept().getDeptid().split("-");
	//if(dises[1].length()>8){
	//	bean.setDistcode(_om.getDept().getDeptid().substring(3, 11));
	//}
}
if(null!=cor){
	bean.setDwmc(cor.getDwmc());
	bean.setFddbr(cor.getLeader());
	bean.setDwdz(cor.getZcdz());
	bean.setLxr(cor.getSbren());
	bean.setLxdh(cor.getLxdh());
	bean.setJcrs(cor.getWhrenshu());
	//bean.setDistcode(cor.getDq3());
	//bean.setDistcode(_om.getDept().getDeptid().substring(3, 9));
	//String[] dises=_om.getDept().getDeptid().split("-");
	//if(dises[1].length()>8){
	//	bean.setDistcode(_om.getDept().getDeptid().substring(3, 11));
	//}
	Z_whBean zwh=new Z_whBean();
	List<Z_whBean> cors=zwh.findByWhere(" where corpkey='"+corpkey+"'");
	String whys="";
	String whysname="";
	if(null!=cors){
		for(int i=0;i<cors.size();i++){
			Z_whBean z=cors.get(i);
			whys+=z.getWhdm()+",";
			whysname+=EnumerationType.getEnu("WHYS",z.getWhdm())+",";
		}
	}
	if(whys.length()>0){
		whys=whys.substring(0,whys.length()-1);
		whysname=whysname.substring(0,whysname.length()-1);
	}
	bean.setWhys(whys);
	bean.setWhysmc(whysname);
}
if(null==messageBean){
	messageBean=new MessageBean();
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	
    <base href="<%=basePath%>">
    <base target='_self'>
    <title>青岛市职业卫生分类及分级管理评定表</title>
	<script language="javascript" src="<%=webpath %>/js/Validator.js"></script>
	<script language="javascript" src="<%=webpath %>/UI/zyjk/flfj/zyjkfl.js"></script>
	<link href="<%=basePath %>/css/catvff.css" rel="stylesheet" type="text/css" />
	<style>
		.tablecon{
			
		}
		.tablecon td{
			height: 40px;
		}
		
		table{
        border:solid #B0C4DE; 
        border-width:1px 0px 0px 1px;
        }
		
		
		td{
		border:solid #B0C4DE; 
		border-width:0px 1px 1px 0px;
		padding:5px 5px 5px 5px;
		}
		
		.sbcx {
	    width: 80px;
	    margin-left: 10px;
	    padding-bottom: 2px;
	    font-size:12px;
        }
        
	</style>
  </head>
  <script type="text/javascript">
  	
  	function booleanbak(bak){
  		if(bak=="00"||bak=="06"){
  			var ches=document.getElementsByName("zyjkflfjBean.whlb");
  			for(var i=0;i<ches.length;i++){
  				if(ches[i].value=="B"){
  					//alert(ches[i].value);
  					ches[i].checked=true;
  				}else{
  					ches[i].checked=false;
  				}
  			}
  		}else{
  			var ches=document.getElementsByName("zyjkflfjBean.whlb");
  			for(var i=0;i<ches.length;i++){
  				if(ches[i].value=="A"){
  					//alert(ches[i].value);
  					ches[i].checked=true;
  				}else{
  					ches[i].checked=false;
  				}	
  			}
  		}
  	}
  	
  </script>
    <script type="text/javascript">
  	function addDocsxxxxxx(){
  		var vals=0;
  		for(var i=1;i<25;i++){
  			var dd=document.getElementById("doc"+i).value;
  			if(dd==""){
  				dd=0;
  			}
  			//alert(dd);
  			vals+=parseInt(dd);
  		}
  		//alert(vals);
  		document.getElementById("zongfen").value=vals;
  	}
  	
  	function openZcor(){
  	
  		top.$.ligerDialog.open({ title: '选择企业', name:'winselector',width: 980, height: 600, url: '<%=webpath %>/UI/zyjk/flfj/zcorlist.jsp', buttons: [
                { text: '确定', onclick: f_selectContactOK },
                { text: '取消', onclick: f_selectContactCancel }
            ]
            });
            
  		
		
  	}
  	
  	///////
  	 function f_selectContactOK(item, dialog)
        {
			var fn = dialog.frame.f_select || dialog.frame.window.f_select; 
            var data = fn(); 
            if (!data)
            {
                alert('请选择行!');
                return;
            }
            var _whys=data.whys;
            var _whysnm=data.whysnm;
            document.getElementById("corpkey").value=data.corpkey;
			document.getElementById("dwmc").value=data.dwmc;
			document.getElementById("fddbr").value=data.leader;
			document.getElementById("dwdz").value=data.zcdz;
			document.getElementById("lxr").value=data.leader;
			document.getElementById("lxdh").value=data.lxdh;
			document.getElementById("jcrs").value=data.whrenshu;
			document.getElementById("whys").value=_whys.substring(0,_whys.length-1);
			document.getElementById("whysmc").value=_whysnm.substring(0,_whysnm.length-1);
			
			//根据危害因素判断危害类别是否为重点
			//alert(getCompare(vals[7]));
			if(getCompare(_whysnm)){
	  			isWhlbChecked(true);
			}else{
				isWhlbChecked(false);
			}
			//根据危害人数判断危害类别是否为重点
			if(data.whrenshu>=50){
				isWhlbChecked(true);
			}else{
				isWhlbChecked(false);
			}
            dialog.close();
        }
        function f_selectContactCancel(item, dialog)
        {
            dialog.close();
        }
  	/////
  		function openWgh(){
  		var dwmcname=document.getElementById("dwmc").value;
  		var val=window.showModalDialog("<%=basePath%>/UI/enterinfo/flfj/wghlist.jsp?dwmc="+encodeURI(encodeURI(dwmcname)),"ken", "dialogWidth=990px;dialogHeight=550px");
  		if(val==null||val.length<1){
				return;
			}
		//alert(val);	
		var vals=val.split("||");
		document.getElementById("wghkey").value=vals[0];
		document.getElementById("dwmc").value=vals[1];
		document.getElementById("fddbr").value=vals[2];
		document.getElementById("dwdz").value=vals[3];
		document.getElementById("lxr").value=vals[4];
		document.getElementById("lxdh").value=vals[5];
		//document.getElementById("jcrs").value=vals[5];
  	}
  	
  	function openWhys(){
  		var val=window.showModalDialog("<%=basePath%>/UI/tree/flfjhylbtree.jsp","ken", "dialogWidth=220px;dialogHeight=450px");
  		if(val==null||val.length<1){
				return;
			}
		//alert(val);	
		var vals=val.split("||");
		document.getElementById("whys").value=vals[0].substring(0,vals[0].length-1);
		document.getElementById("whysmc").value=vals[1].substring(0,vals[1].length-1);
		if(getCompare(vals[1])){
  			isWhlbChecked(true);
		}else{
			isWhlbChecked(false);
		}
		
  	}
  	
  	function bodyload(){
  		//根据危害因素判断危害类别是否为重点
		var cWhys=document.getElementById("whysmc").value;
		if(getCompare(cWhys)){
  			isWhlbChecked(true);
		}else{
			isWhlbChecked(false);
		}
		//根据危害人数判断危害类别是否为重点
		var cWhrs=document.getElementById("jcrs").value;
		if(cWhrs>=50){
			isWhlbChecked(true);
		}else{
			isWhlbChecked(false);
		}
  	}
  </script>
 <%
 	if(null!=result&&!"null".equals(result)&&!"".equals(result)){
 %>
 		<script type="text/javascript">
 			alert('<%=result%>');
 		</script>
 <%}
  %>
  <body onload="bodyload();">
  <br>
    	<form action="<%=path %>/UI/enterinfo/flfj_addBean.action" name="form1" id="form1" method="post">
    		<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="message.method" value="<%=messageBean.getMethod() %>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
    		<br><input name="zyjkflfjBean.sysno" id="sysno" value="<%=bean.getSysno() %>" type="hidden"/>
    		<input name="zyjkflfjBean.corpkey" id="corpkey" value="<%=corpkey %>" type="hidden"/>
    		<input name="zyjkflfjBean.wghkey" id="wghkey" value="<%=corpkey %>" type="hidden"/>
    		<input name="zyjkflfjBean.distcode" id="distcode" value="<%=bean.getDistcode() %>" type="hidden"/>
    		<%--<input name="zyjkflfjBean.jdgldj" id="jdgldj"  type="hidden"/>
    		--%><table  align="center" width="93%"  cellspacing="0" cellpadding="0">
    			
    			<tr>
    				<td align="center" height="25px">单位名称</td>
    				<td colspan="3"><input type="text" id="dwmc" name="zyjkflfjBean.dwmc" value="<%=bean.getDwmc()%>" style="width: 50%;height: 85%"/> <input class="sbcx" type="button" value=" 申报查询 " onclick="openZcor()" style="height: 85%"/> <!--  <input type="button" value="网格化查询" onclick="openWgh()"/>--></td>
    				<td width="15%" align="center">法定代表人</td>
    				<td align="center" width="20%"><input type="text" id="fddbr" name="zyjkflfjBean.fddbr" value="<%=bean.getFddbr() %>" style="width: 100%;height: 85%"/></td>
    			</tr>
    			<tr>
    				<td align="center" width="15%" height="25px">地址</td>
    				<td><input type="text" id="dwdz" name="zyjkflfjBean.dwdz" value="<%=bean.getDwdz()%>" style="width: 100%;height: 85%"/></td>
    				<td align="center" width="15%">联系人</td>
    				<td><input type="text" id="lxr" name="zyjkflfjBean.lxr" value="<%=bean.getLxr()%>" style="width: 100%;height: 85%"/></td>
    				<td align="center" width="15%">联系电话</td>
    				<td><input type="text" id="lxdh" name="zyjkflfjBean.lxdh" value="<%=bean.getLxdh()%>" style="width: 100%;height: 85%"/></td>
    			</tr>
    			<tr>
    				<td align="center" height="25px">主要职业危害因素</td>
    				<td colspan="3">
    				<input type="hidden" id="whys" name="zyjkflfjBean.whys" value="<%=bean.getWhys()%>" style="width: 70%;height: 85%"/>
    				<input type="text" id="whysmc" name="zyjkflfjBean.whysmc" value="<%=bean.getWhysmc()%>" style="width: 70%;height: 85%"/><!-- <input type="button" value="选择危害因素" onclick="openWhys()"/> --></td>
    				<td align="center">接触人数</td>
    				<td><input type="text" id="jcrs" name="zyjkflfjBean.jcrs" value="<%=bean.getJcrs() %>" onblur="compareRs(this.value);" style="width: 100%;height: 85%"/></td>
    			</tr>
    			
    		</table>
    		
    		<br>
    		<table  align="center" width="93%"  cellspacing="0" cellpadding="0">
    			<tr>
    				<td width="5%" align="center">项目</td>
    				<td width="25%" align="center">评查内容</td>
    				<td width="5%" align="center">分值</td>
    				<td width="55%" align="center">评查标准</td>
    				<td width="10%" align="center">得分</td>
    				<%--<td width="20%" align="center">备注</td>
    			--%></tr>
    			<tr>
    				<td rowspan="6">一、组织机构及制度建设</td>
    				<td>1、职业病防治责任制</td>
    				<td align="center">3</td>
    				<td>查阅书面材料，领导小组包括用人单位法定代表人（负责人），部门分工、岗位职责及工会代表等内容，没有不得分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第一项" id="doc1" name="zyjkflfjBean.doc1" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc1() %>"/> </td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz1" name="zyjkflfjBean.bz1"><%=bean.getBz1() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>2、职业卫生管理机构和管理人员</td>
    				<td align="center">3</td>
    				<td>查阅相关文件，设置职业卫生管理机构，未设置扣2分；配备专、兼职的管理人员，未配备扣1分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第二项" id="doc2" name="zyjkflfjBean.doc2" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc2() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz2" name="zyjkflfjBean.bz2"><%=bean.getBz2() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>3、职业病防治计划和实施方案</td>
    				<td align="center">3</td>
    				<td>查阅书面材料，未制定，不得分。计划包括目标、措施、经费投入、保障条件等内容，实施方案包括时间进度、实施步骤、技术要求等内容，缺少一项扣1分，扣完为止。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第三项" id="doc3" name="zyjkflfjBean.doc3" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc3() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz3" name="zyjkflfjBean.bz3"><%=bean.getBz3() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>4、职业卫生管理制度和岗位操作规程</td>
    				<td align="center">3</td>
    				<td>各项管理制度体系健全，包括职业病危害项目申报、职业病危害因素监测、职业卫生培训、职业健康检查等各项制度，职业病危害岗位应制定相应的操作规程，缺一项扣1分，扣完为止。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第四项" id="doc4" name="zyjkflfjBean.doc4" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc4() %>"/></td>			
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz4" name="zyjkflfjBean.bz4"><%=bean.getBz4() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>5、职业病危害事故应急救援预案</td>
    				<td align="center">3</td>
    				<td>预案应明确责任人、组织架构、事故疏散线路、技术处理方案、医疗救护等内容，并定期进行演练，缺一项扣1分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第五项" id="doc5" name="zyjkflfjBean.doc5" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc5() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz5" name="zyjkflfjBean.bz5"><%=bean.getBz5() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>6、依法参加工伤保险</td>
    				<td align="center">3</td>
    				<td>查阅工伤保险缴费凭证和劳动者保险号，未参加保险不得分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第六项" id="doc6" name="zyjkflfjBean.doc6" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc6() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz6" name="zyjkflfjBean.bz6"><%=bean.getBz6() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td rowspan="5">二、前期预防</td>
    				<td>7、职业病危害项目申报</td>
    				<td align="center">3</td>
    				<td>未申报或未如实申报不得分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第七项" id="doc7" name="zyjkflfjBean.doc7" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc7() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz7" name="zyjkflfjBean.bz7"><%=bean.getBz7() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>8、建设项目职业病危害评价、审核</td>
    				<td align="center">4</td>
    				<td>年内若无建设项目，此项不扣分。年内有建设项目，未开展建设项目职业病危害评价与审核，不得分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第八项" id="doc8" name="zyjkflfjBean.doc8" onblur="compareFS(4,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc8() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz8" name="zyjkflfjBean.bz8"><%=bean.getBz8() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>9、生产工艺布局</td>
    				<td align="center">4</td>
    				<td>按照《工业企业设计卫生标准》要求，生产布局合理，有害和无害作业分开；一项不合理扣1分，扣完为止。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第九项" id="doc9" name="zyjkflfjBean.doc9" onblur="compareFS(4,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc9() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz9" name="zyjkflfjBean.bz9"><%=bean.getBz9() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>10、工作场所应急设施</td>
    				<td align="center">3</td>
    				<td>可能发生急性职业病危害工作场所设置报警装置、冲洗装置、应急撤离通道，配备现场急救用品，未设置不得分，应急救援设施不能正常工作的扣3分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第十项" id="doc10" name="zyjkflfjBean.doc10" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc10() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz10" name="zyjkflfjBean.bz10"><%=bean.getBz10() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>11、职业卫生培训</td>
    				<td align="center">4</td>
    				<td>主要负责人或管理人员接受职业卫生法律法规及相关知识培训，查培训合格证，未培训扣2分；企业内部劳动者培训，查培训记录，没有扣2分，培训人数不全扣1分； </td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第十一项" id="doc11" name="zyjkflfjBean.doc11" onblur="compareFS(4,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc11() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz11" name="zyjkflfjBean.bz11"><%=bean.getBz11() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td rowspan="4">三、职业病危害告知</td>
    				<td>12、订立劳动合同</td>
    				<td align="center">3</td>
    				<td>合同中写明工作过程中可能产生的职业病危害及其后果、防护措施和待遇等。未写明不得分，内容不全扣1分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第十二项" id="doc12" name="zyjkflfjBean.doc12" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc12() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz12" name="zyjkflfjBean.bz12"><%=bean.getBz12() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>13、公告栏告知</td>
    				<td align="center">3</td>
    				<td>公布有关职业病防治的规章制度、操作规程、职业病危害事故应急救援措施和工作场所职业病危害因素检测结果等。未告知相关内容不得分。 </td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第十三项" id="doc13" name="zyjkflfjBean.doc13" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc13() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz13" name="zyjkflfjBean.bz13"><%=bean.getBz13() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>14、作业岗位危害告知</td>
    				<td align="center">3</td>
    				<td>产生严重职业病危害的作业岗位，醒目位置设置警示标识和中文警示说明。警示说明应当载明产生职业病危害的种类、后果、预防以及应急救治措施等内容。无警示标识扣1分，无中文警示说明扣2 分。 </td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第十四项" id="doc14" name="zyjkflfjBean.doc14" onblur="compareFS(3,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc14() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz14" name="zyjkflfjBean.bz14"><%=bean.getBz14() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>15、有毒化学品使用</td>
    				<td align="center">4</td>
    				<td>不清楚所使用化学品的成分，使用化学品未附具中文说明书的，不得分。 </td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第十五项" id="doc15" name="zyjkflfjBean.doc15" onblur="compareFS(4,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc15() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz15" name="zyjkflfjBean.bz15"><%=bean.getBz15() %></textarea></td>
    			--%></tr>
    			
    			<tr>
    				<td rowspan="4">四、职业危害检测与防护</td>
    				<td>16、工作场所职业病危害因素检测、评价</td>
    				<td align="center">10</td>
    				<td>未进行检测评价的不得分，检测机构不具有资质的检测评价报告，不得分，检测项目不全的扣3分；检测评价结果公告告知，没告知扣3分；有专人负责的日常监测，没有扣2分，评价结果定期向安监部门报告，未报告扣2分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第十六项" id="doc16" name="zyjkflfjBean.doc16" onblur="compareFS(10,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc16() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz16" name="zyjkflfjBean.bz16"><%=bean.getBz16() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>17、职业病危害因素的强度（浓度）符合国家职业卫生标准</td>
    				<td align="center">5</td>
    				<td>一个作业点、一种职业病危害因素不达标扣1分，扣完为止。 </td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第十七项" id="doc17" name="zyjkflfjBean.doc17" onblur="compareFS(5,this.value,this);addDocsxxxxxx();compareF(this.value);" value="<%=bean.getDoc17() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz17" name="zyjkflfjBean.bz17"><%=bean.getBz17() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>18、职业病防护设施</td>
    				<td align="center">5</td>
    				<td>根据需要有效配备职业病防护设施，未配备不得分；防护设施不符合需求、擅自停用、未进行维护、检修的，扣3分。 </td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第十八项" id="doc18" name="zyjkflfjBean.doc18" onblur="compareFS(5,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc18() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz18" name="zyjkflfjBean.bz18"><%=bean.getBz18() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>19、个人防护用品配备</td>
    				<td align="center">4</td>
    				<td>未提供不得分；提供的个人防护用品不符合要求扣2分；个人防护用品未按要求使用扣2分，未建立防护用品发放记录台账的扣1分。 </td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第十九项" id="doc19" name="zyjkflfjBean.doc19" onblur="compareFS(4,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc19() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz19" name="zyjkflfjBean.bz19"><%=bean.getBz19() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td rowspan="2">五、职业健康监护</td>
    				<td>20、按规定组织劳动者进行岗前、在岗和离岗职业健康检查</td>
    				<td align="center">10</td>
    				<td>未进行职业健康检查的不得分，未取得资质的职业健康检查不得分；一名工人未体检或未按要求检查扣1分，扣完为止。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第二十项" id="doc20" name="zyjkflfjBean.doc20" onblur="compareFS(10,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc20() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz20" name="zyjkflfjBean.bz20"><%=bean.getBz20() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>21、疑似职业病病人和有职业禁忌证人员处理</td>
    				<td align="center">5</td>
    				<td>安排对疑似职业病病人进行诊断，未安排诊断的，扣3分；对不适宜从事原工作的职业禁忌人员，调离原岗位，并妥善安置，未安排扣2分。 </td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第二十一项" id="doc21" name="zyjkflfjBean.doc21" onblur="compareFS(5,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc21() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz21" name="zyjkflfjBean.bz21"><%=bean.getBz21() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td rowspan="2">六、职业卫生档案管理</td>
    				<td>22、职业卫生基本档案</td>
    				<td align="center">5</td>
    				<td>职业卫生基本档案应包括企业基本情况、接触的危害因素及作业点分布情况、作业场所危害因素监测报告，劳动者职业查体报告等，未建立不得分，缺1项扣1分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第二十二项" id="doc22" name="zyjkflfjBean.doc22" onblur="compareFS(5,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc22() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz22" name="zyjkflfjBean.bz22"><%=bean.getBz22() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>23、劳动者职业健康监护档案</td>
    				<td align="center">5</td>
    				<td>职业健康监护档案应一人一档，内容包括劳动者的职业史、职业病危害接触史、职业健康检查结果和职业病诊疗等有关个人健康资料，未建立档案不得分，档案不健全的扣2分。 </td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第二十三项" id="doc23" name="zyjkflfjBean.doc23" onblur="compareFS(5,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc23() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz23" name="zyjkflfjBean.bz23"><%=bean.getBz23() %></textarea></td>
    			--%></tr>
    			<tr>
    				<td>七、群众监督</td>
    				<td>24、建立工会，开展群众监督，签订集体合同。</td>
    				<td align="center">2</td>
    				<td>核查文件，开展“安康杯”竞赛，查阅劳动安全卫生专项集体合同等，没有不得分。</td>
    				<td><input type="text" style="width: 100%;height: 100%;" notnull="true" controlName="第二十四项" id="doc24" name="zyjkflfjBean.doc24"  onkeyup="compareFS(2,this.value,this);addDocsxxxxxx();" value="<%=bean.getDoc24() %>"/></td>
    				<%--<td><textarea style="width: 100%;height: 100%;" id="bz24" name="zyjkflfjBean.bz24"><%=bean.getBz24() %></textarea></td>
    			--%></tr>
    		</table><br>
    		<table align="center" width="93%">
    			<tr>
    				<td width="100%" align="right">总分:<input type="text" readonly="readonly" name="zyjkflfjBean.zongfen" id="zongfen" value="<%=bean.getZongfen() %>"/> </td>
    			</tr>
    		</table>
    		<table align="center" width="93%"   cellspacing="0" cellpadding="0">
    			<tr>
    			<%--
    				<td align="center" width="100px">存在情况</td>
    				<td  width="35%">
    					
    					   <%
										    DBSelect dbsel = new DBSelect("CZWT", "CZWT", bean.getBak1());
										    dbsel.addAttr("style", "width: 100%");
										    dbsel.addAttr("notnull", "true");
										    dbsel.addAttr("controlName", "存在情况");
										    dbsel.addAttr("name", "zyjkflfjBean.bak1");
										    dbsel.addAttr("id", "bak1");
										    dbsel.addAttr("onchange", "booleanbak(this.value)");
										    dbsel.setDisplayAll(false);
										    dbsel.addOption("请选择","00");
										    out.print(dbsel);
							 %>
    				</td>--%>
    				<td align="center" width="120px" height="30px">职业病危害类别</td>
    				<td width="35%">
    					
    					<%=CommenUtil.getCheckBox("ZYBWHLB",bean.getWhlb(),"zyjkflfjBean.whlb","whlb") %>
    				</td>
    				<td align="center">职业卫生管理等级</td>
    				<td width="35%">
    				
    					<%=CommenUtil.getCheckBox("ZYWSGLDJ",bean.getWsgldj(),"zyjkflfjBean.wsgldj","wsgldj") %>
    				</td>
    			</tr>
    			<%--
    				<tr>
    				<td align="center">其他</td>
    				<td colspan="5">
    					<input type="text" name="zyjkflfjBean.bak2" id="bak2" value="" style="width: 100%"/>
    				</td>
    			</tr>
    			--%><tr>
    				
    				
    				<td align="center" width="120px" height="30px">核定监督管理等级</td>
    				<td colspan="3">
    					
    					<%=CommenUtil.getCheckBox("HDGLDJ",bean.getJdgldj(),"zyjkflfjBean.jdgldj","jdgldj") %>
    				</td>
    				
    			</tr>
    			
    		</table>
    		<br>
    		<table align="center">
                 <tr>
                     <td>
                          <input type="button" value="提交" id="subButton" class="l-button l-button-submit" onclick="formsubmit();"/> 
                          <input type="reset" value="重置" id="colButton" class="l-button l-button-test"/>
                    </td>
                </tr>
            </table>
    	</form>
  </body>

</html>
