<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.util.*"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<jsp:directive.page import="st.platform.system.cache.EnumerationType"/>
<jsp:directive.page import="UI.dao.zyjk.T_officerBean"/>
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<jsp:directive.page import="UI.dao.zyjk.Z_corBean"/>
<jsp:directive.page import="UI.dao.zyjk.WsjgbaxxBean"/>
<jsp:directive.page import="UI.dao.zyjk.JcjgbaxxBean"/>
<jsp:directive.page import="UI.dao.zyjk.PxjgbaxxBean;"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/webpath.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
T_officerBean officer=(T_officerBean)session.getAttribute(SystemAttributeNames.CORP_INFO_NAME);
//判断登陆用户类型
String dept_type=officer.getDept_type();
//System.out.println("登陆用户类型"+dept_type);

QyjbqkBean qyjbqkBean=new QyjbqkBean();
JcjgbaxxBean jcjgBean=new JcjgbaxxBean();
PxjgbaxxBean pxjgBean=new PxjgbaxxBean();
WsjgbaxxBean wsjgBean=new WsjgbaxxBean();
Z_corBean zcoreBean=new Z_corBean();

String enterno="";
String enternm="";
String deptnm="";
String corpType="";
String district="";
String leader="";
String rptype="";

String zzzsbh=""; //资质证书号
String fzdate=""; //发证日期
String yxq="";    //有效日期
String zzjb="";   //资质级别

String zsbh="";   //证书编号
String zsyxqs="";//证书有效期起
String zsyxqz="";//证书有效期止

String pzwh="";//批准文号
String pzdw="";//批准单位
String pzsj="";//批准时间


if(null!=officer){
   
	String corpkey=officer.getLogin_id();
	//System.out.println("corpkey主键:"+corpkey);
	
	qyjbqkBean=qyjbqkBean.findFirst(" where corpkey='"+ corpkey +"'");
	jcjgBean=jcjgBean.findFirst(" where sysno='"+ corpkey +"'");
	pxjgBean=pxjgBean.findFirst(" where sysno='"+ corpkey +"'");
	wsjgBean=wsjgBean.findFirst(" where sysno='"+ corpkey +"'");
	zcoreBean=zcoreBean.findFirst(" where corpkey='"+ corpkey +"'");
	
    
    
	if(null!=qyjbqkBean){
		//编号
		 enterno=qyjbqkBean.getEnterno();
		//企业名称
		 enternm=qyjbqkBean.getDwmc();
		//部门类型
		 deptnm=EnumerationType.getEnu("ZGDW", qyjbqkBean.getZhuguan());
		//企业类型
		 corpType=EnumerationType.getEnu("HYLB", qyjbqkBean.getHyfl());
		//属地
		 district=DistcodeUtil.getDistName(qyjbqkBean.getDistcode());
		//企业负责人
		 leader=qyjbqkBean.getFddbr();
		//自查上报类型
		 rptype=qyjbqkBean.getBak1();		
		
	}else{
		if(null!=jcjgBean){
			enterno=jcjgBean.getSysno();
			enternm=jcjgBean.getDwmc();
			district=DistcodeUtil.getDistName(jcjgBean.getDistcode());			
			zzzsbh=jcjgBean.getZzzsbh(); //资质证书号
			fzdate=jcjgBean.getFzdate(); //发证日期
			yxq=jcjgBean.getYxq();    //有效日期
			zzjb=jcjgBean.getZzjb();   //资质级别
			
		}
		if(null!=pxjgBean){
			enterno=pxjgBean.getSysno();
			enternm=pxjgBean.getPxjgmc();
			zsbh=pxjgBean.getZsbh();//证书编号
			zsyxqs=pxjgBean.getZsyxqs();//证书有效期起
			zsyxqz=pxjgBean.getZsyxqz();//证书有效期止
			
		}
		if(null!=wsjgBean){
			enterno=wsjgBean.getSysno();
			enternm=wsjgBean.getJgmc();
			pzwh=wsjgBean.getPzdw();//批准文号
			pzdw=wsjgBean.getPzdw();//批准单位
			pzsj=wsjgBean.getPzsj();//批准时间
			zzjb=wsjgBean.getZzjb();//资质级别
		}
		if(null!=zcoreBean){
            //编号
			 enterno=zcoreBean.getCorpkey();
			//企业名称
			 enternm=zcoreBean.getDwmc();
			//部门类型
			 deptnm=EnumerationType.getEnu("ZGDW", zcoreBean.getZhuguan());
			//企业类型
			 corpType=EnumerationType.getEnu("HYLB", zcoreBean.getHyfl());
			//属地
			 district="";
			//企业负责人
			 leader=zcoreBean.getLeader();
			//自查上报类型
			 rptype="";	
		}

	}	
}



%>
<link href="<%=webpath %>css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=webpath %>js/jquery/jquery-1.7.1.min.js" language="javascript"></script>
<script src="<%=webpath %>js/ligerUI/js/ligerui.min.js" language="javascript"></script>
<script language="javascript">

             function refresh(){
	       
	        form.codeimg.src="validate/image.jsp?"+Math.random();

	       }
        
           
                /*退出*/
         function userlogout(){
		    if(window.confirm('确定退出？')){
                   $.post(webpath+"st/system/action/login/LoginAction_remove.action",function(data){
                   
                       parent.parent.window.location.href="../qyindex.jsp";  
                   
                    });
                 }
        } 
        
        
        function enterinfo(index){
                   
              parent.parent.document.getElementById("index").value=index;
              parent.parent.document.winform.submit();
        }
        
        
        
        function sysinfo(){
           window.location.href="qyindex.jsp";
        } 
</script>
</head>
<body>
<div class="login" style="margin:0px auto 0px;">				
			<h1 style="height:25px;"></h1>
			<%
			if(dept_type.equals("1")){
				%>
				 <h6>
				
				欢迎您：<span><%=enternm %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
				
				主管单位：<%=deptnm%><br/>
				企业类型：<%=corpType%><br/>
				属地：<%=district%><br/>
				企业负责人：<%=leader %><br/>
				自查上报类型：<%=rptype %><br/>
			  <a target="_blank" style="cursor: pointer"  
			  onclick='$("#framePage",parent.parent.document).attr("src","<%=webpath %>UI/action/enter/EnterMain_findByKey.action?messageBean.method=add&enterno=<%=enterno %>&strSysno=<%=enterno %>&showButton=1")'>
			  用人单位基本信息</a>
			  
			  &nbsp;
			  <a target="_blank" style="cursor: pointer" 
			  onclick='$("#framePage",parent.parent.document).attr("src","<%=webpath %>UI/system/user/qymodifypass.jsp?enterno=<%=enterno %>")'>修改密码</a>&nbsp;
			  <a href="javascript:userlogout();">退出</a><br/>
			 <br/>
			</h6>
				<%
			}else if(dept_type.equals("2")){
				%>
				<h6>
				
				欢迎您：<span><%=enternm %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>				
				属地：<%=district%><br/>
				资质证书号：<%=zzzsbh%><br/>
				发证日期：<%=fzdate%><br/>
				
				<%
				   //有有效日期判断
				    String nowDay=BusinessDate.getNowDay();				    
				    
				    int result=nowDay.compareTo(yxq);
				    if(result>0||result==0)
				    {
				    	%>	
				    	<span style="color: #FF3030">
				    	<%
				    	out.println("有效日期："+yxq);
				    	%>
				    	</span>
				    	<% 
				    }else{
				    	out.println("有效日期："+yxq);
				    }
			    %>
			    <br/>
				资质级别：<%=zzjb%><br/>
			  <a target="_blank" style="cursor: pointer"  
			  onclick='$("#framePage",parent.parent.document).attr("src","<%=webpath %>/UI/action/zyjk/JcjgbaAction_findByKey.action?messageBean.method=look&strSysno=<%=enterno %>")'>
			  基本信息</a>&nbsp;&nbsp;
			  <a target="_blank" style="cursor: pointer" 
			  onclick='$("#framePage",parent.parent.document).attr("src","<%=webpath %>UI/system/user/qymodifypass.jsp?enterno=<%=enterno %>")'>修改密码</a>&nbsp;&nbsp;
			  <a href="javascript:userlogout();">退出</a><br/>
			 <br/>
			</h6>
				<%
			}else if(dept_type.equals("3")){
				%>
				<h6>
				
				欢迎您：<span><%=enternm %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>				
				属地：<%=district%><br/>
				证书编号：<%=zsbh%><br/>
				证书有效期起：<%=zsyxqs%><br/>
				<%
				   //证书有效期判断
				    String nowDay=BusinessDate.getNowDay();				    
				    
				    int result=nowDay.compareTo(zsyxqz);
				    if(result>0||result==0)
				    {
				    	%>	
				    	<span style="color: #FF3030">
				    	<%
				    	out.println("证书有效期止："+zsyxqz);
				    	%>
				    	</span>
				    	<% 
				    }else{
				    	out.println("证书有效期止："+zsyxqz);
				    }
			    %>
				
				
				<br/>
			  <a target="_blank" style="cursor: pointer"  
			  onclick='$("#framePage",parent.parent.document).attr("src","<%=webpath %>/UI/action/zyjk/PxjgbaAction_loginFindByKey.action?messageBean.method=look&strSysno=<%=enterno %>")'>
			  基本信息</a>&nbsp;&nbsp;
			  <a target="_blank" style="cursor: pointer" 
			  onclick='$("#framePage",parent.parent.document).attr("src","<%=webpath %>UI/system/user/qymodifypass.jsp?enterno=<%=enterno %>")'>修改密码</a>&nbsp;&nbsp;
			  <a href="javascript:userlogout();">退出</a><br/>
			 <br/>
			</h6>
				<%
			}else if(dept_type.equals("4")){
				%>
				<h6>
				
				欢迎您：<span><%=enternm %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
				企业类型：<%=corpType%><br/>
				属地：<%=district%><br/>
				批准文号：<%=pzwh%><br/>
				批准单位：<%=pzdw%><br/>
				批准时间：<%=pzsj%><br/>
				资质级别：<%=zzjb%><br/>
			  <a target="_blank" style="cursor: pointer"  
			  onclick='$("#framePage",parent.parent.document).attr("src","<%=webpath %>/UI/action/zyjk/WsjgbaAction_findByKey.action?messageBean.method=look&strSysno=<%=enterno %>")'>
			  基本信息</a>&nbsp;&nbsp;
			  <a target="_blank" style="cursor: pointer" 
			  onclick='$("#framePage",parent.parent.document).attr("src","<%=webpath %>UI/system/user/qymodifypass.jsp?enterno=<%=enterno %>")'>修改密码</a>&nbsp;&nbsp;
			  <a href="javascript:userlogout();">退出</a><br/>
			 <br/>
			</h6>
				
				<%
			}
			%>
</div>
</body>
</html>