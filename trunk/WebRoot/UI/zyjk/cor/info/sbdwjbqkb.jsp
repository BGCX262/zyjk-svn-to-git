<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:directive.page import="st.portal.html.DBSelect"/>
<jsp:directive.page import="UI.dao.zyjk.Z_corBean"/>
<jsp:directive.page import="st.platform.system.cache.EnumerationType"/>
<%@ include file="/global.jsp" %>	

<html>
<head>
<title>申报单位基本情况</title>
<script>
	  $(function () {
        try {
          $("form").ligerForm();
             
          }catch (e) {
           
       }
        }); 
</script>
</head>


<body class="menubody" style="width:95%">
  
<% 
    Z_corBean eb = new Z_corBean();
    String enterno=request.getParameter("ENTERNO");
    //System.out.println(enterno);
    String ISEXIST="YES";
   	if(request.getAttribute("z_corBean")!=null){
   		eb=(Z_corBean)request.getAttribute("z_corBean");
   	}
   	if(null==eb){
   		eb=new Z_corBean();
   	}
	 %>
<form name="form" method="post"  id="form">


	 <br/>
	
    <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
      <tr>
        <td class="l-table-edit-td-right"  align="center">单位名称：</td>
        <td class="l-table-edit-td-left">
        	<input type="text" ltype="text" name="dwmc" id="dwmc" value="<%= eb.getDwmc()%>" />
        </td>
        <td class="td_message" style="width:100px"></td>
        <td class="l-table-edit-td-right"  align="center">建厂日期：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="jcrq" id="jcrq" value="<%=eb.getJcdate() %>" /></td>
        <td class="td_message" ></td>
      </tr>
       <tr>
        <td  class="l-table-edit-td-right" align="center">单 位 注 册 地 址：</td>
        <td class="l-table-edit-td-left" ><input type="text" ltype="text" name="dwzcdz" id="dwzcdz" value="<%=eb.getZcdz()%>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right"  align="center">邮政编码：</td>
        <td class="l-table-edit-td-left" ><input type="text" ltype="text" name="zcyzbm" id="zcyzbm" value="<%=eb.getZcyzbm() %>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-right" align="center"  id="hid000">作 业 场 所 地 址：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="zycsdz" id="zycsdz" value="<%=eb.getCsdz() %>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right"  align="center">邮政编码：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="csyzbm" id="csyzbm" value="<%=eb.getCsyzbm() %>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-right" align="center">法定代表人：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="fddbr" id="fddbr" value="<%=eb.getLeader() %>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" align="center">联系电话：</td>
        <td class="l-table-edit-td-left" ><input type="text" ltype="text" name="lxdh" id="lxdh" value="<%=eb.getLxdh() %>" /></td>
        <td class="td_message"></td>
     </tr>
     <tr>   
        <td class="l-table-edit-td-right" align="center">注册资本(万元)：</td>
        <td class="l-table-edit-td-left" ><input type="text" ltype="text" name="zjze" id="zjze" value="<%=eb.getZichan() %>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right"  align="center">主管单位：</td>
        <td class="l-table-edit-td-left" ><input type="text" ltype="text" name="zgdw" id="zgdw" value="<%=eb.getZhuguan()%>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-right" align="center">注册类型：</td>
        <td class="l-table-edit-td-left" ><input type="text" ltype="text" name="zclx" id="zclx" value="<%= EnumerationType.getEnu("ZCLX",eb.getZclx()) %>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" align="center">行业分类：</td>
        <td class="l-table-edit-td-left"><input type="hidden" name="hyfl" id="hyfl" value="<%=eb.getHyfl()%>" />
        	<input class="text"   id="hyflname" readonly   value="<%=EnumerationType.getEnu("HYLB",eb.getHyfl()) %>"  type="text" ltype="text" />
        
        </td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-right" align="center">企业年度产值(万元)：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="chanzhi" id="chanzhi" value="<%=eb.getChanzhi() %>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" align="center">资产总额(万元)：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="zichan" id="zichan" value="<%=eb.getZichan() %>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-right" align="center">是否有专门的职业卫生管理机构：</td>
        <td class="l-table-edit-td-left" >
        	<% 
	               	 DBSelect dbsel = new DBSelect("sfyzywsgljg","SF",eb.getZywsjgshu());
	 				 
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "是否有专门的职业卫生管理机构");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
       </td>
       <td class="td_message"></td>
        <td class="l-table-edit-td-right" align="center">职业卫生管理机构：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="zywsjg" id="zywsjg" value="<%=eb.getZywsjg() %>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>
       <td class="l-table-edit-td-right" align="center">职业卫生管理机构负责人：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="jgfzr" id="jgfzr" value="<%=eb.getZywsleader() %>"/></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" align="center">职业卫生管理机构联系电话：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="fzrdh" id="fzrdh" value="<%=eb.getZywslxdh() %>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-right" align="center">职业卫生管理人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="wsglrs" id="wsglrs" value="<%=eb.getZywsgl()%>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" align="center">填报类别：</td>
        <td class="l-table-edit-td-left">
        	<% 
	               	 dbsel = new DBSelect("tblb","TBLB",eb.getTblb());
	 				 dbsel.addAttr("style", "width: 202px;");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "填报类别");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
        </td>
        <td class="td_message"></td><%--
        <td class="l-table-edit-td-right" colspan="4" align="center">变更原因</td>
        <td class="l-table-edit-td-left" colspan="4"><input type="text" ltype="text" name="bgyy" id="bgyy" value="<%=eb.getBgyy() %>" style="width: 95%"/></td>
      --%></tr>
      <tr>
        <td class="l-table-edit-td-right" align="center">在岗职工总人数：</td>
        <td class="l-table-edit-td-left" colspan="4"><input type="text" ltype="text" name="zggrs" id="zggrs" value="<%=eb.getNmzgrs()%>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>  
        <td class="l-table-edit-td-right" align="center">其中：女工</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="zgngrs" id="zgngrs" value="<%=eb.getScwomen()%>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right"  align="center">农民工：</td>
        <td class="l-table-edit-td-left"  align="center"><input type="text" ltype="text" name="nmgrs" id="nmgrs" value="<%=eb.getScnongmin() %>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr> 
        <td class="l-table-edit-td-right" align="center">参加职业危害培训总人数：</td>
        <td class="l-table-edit-td-left" align="center" colspan="4"><input type="text" ltype="text" name="pxrs" id="pxrs" value="<%=eb.getPxrenshu() %>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-right" align="center">接触职业危害总人数：</td>
        <td class="l-table-edit-td-left" colspan="4"><input type="text" ltype="text" name="jcwhysrs" id="jcwhysrs" value="<%=eb.getWhrenshu() %>" /></td>
       <td class="td_message"></td>
      </tr>
      <tr> 
        <td class="l-table-edit-td-right" align="center">其中：女工</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="jcwhysngrs" id="ycwhysngrs" value="<%=eb.getWhwomen() %>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right"  align="center">农民工：</td>
        <td class="l-table-edit-td-left" align="center"><input type="text" ltype="text" name="jcwhysnmgrs" id="jcwhysnmgrs" value="<%=eb.getWhnongmin()%>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-right" align="center">职业病累计人数：</td>
        <td class="l-table-edit-td-left" colspan="4"><input type="text" ltype="text" name="zybljrs" id="zybljrs" value="<%=eb.getZybrenshu()%>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>  
        <td class="l-table-edit-td-right" align="center">新增人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="ndxzzybrs" id="ndxzzybrs" value="<%=eb.getZybrenshuxz()%>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right"  align="center">疑似人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="dqyszybrs" id="dqyszybrs" value="<%=eb.getZybrenshuys() %>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr>
        <td class="l-table-edit-td-right" align="center">岗前体检人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="gqtjrs" id="gqtjrs" value="<%=eb.getTjrenshu() %>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" align="center">岗中体检人数：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="gztjrs" id="gztjrs" value="<%=eb.getTjrenshu2() %>" /></td>
        <td class="td_message"></td>
      </tr>  
      <tr>
        <td class="l-table-edit-td-right" align="center" >离岗体检人数：</td>
        <td class="l-table-edit-td-left" colspan="4"><input type="text" ltype="text" name="lgtjrs" id="lgtjrs" value="<%=eb.getTjrenshu3()%>" /></td>
        <td class="td_message"></td>
      </tr>
       <tr>
        <td class="l-table-edit-td-right" align="center">职业病危害检测机构：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="jcjg" id="jcjg" value="<%=eb.getYsjiancejg()%>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" align="center">危害培训机构：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="pxjg" id="pxjg" value="<%=eb.getGlpeixunjg() %>" /></td>
        <td class="td_message"></td>
       </tr> 
       <tr>
        <td class="l-table-edit-td-right"  align="center">体检机构：</td>
        <td class="l-table-edit-td-left" colspan="4"><input type="text" ltype="text" name="tjjg" id="tjjg" value="<%=eb.getGltijianjg()%>" /></td>
        <td class="td_message"></td>
      </tr>
      <tr  id="hid01">
       	<td class="l-table-edit-td-right" align="center">申报人：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="tbrdh" id="tbrdh" value="<%=eb.getSbren() %>" /></td>
        <td class="td_message"></td>
        <td class="l-table-edit-td-right" align="center">申报人联系电话：</td>
        <td class="l-table-edit-td-left"><input type="text" ltype="text" name="sbrendh" id="sbrendh" value="<%=eb.getSbrendh() %>" /></td>
        <td class="td_message"></td>
      </tr>
     <%--
      <tr>  
        <td class="l-table-edit-td-right"  align="center">填表日期</td>
        <td class="l-table-edit-td-left" colspan="4"><input type="text" ltype="text" name="dqrq" id="dqrq" value="<%=eb.getYstbdate() %>" style="width: 95%"/></td>
        <td class="td_message"></td>
      </tr>
      
    --%></table>


</form>

</body>
</html>


