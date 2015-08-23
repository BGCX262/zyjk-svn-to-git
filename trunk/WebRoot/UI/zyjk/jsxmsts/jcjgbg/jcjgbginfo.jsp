<!--
/****************************************************
 * <p>处理内容：评价报告基本情况</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14    孙雁斌           新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.JcjgpjbgjbqkBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 JcjgpjbgjbqkBean jcjgpjbgjbqkbean = (JcjgpjbgjbqkBean)request.getAttribute("jcjgpjbgjbqkbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>/UI/zyjk/jsxmsts/jcjgbg/jcjgbginfo.js"></script>
  </head>
  <body class="menubody" style="width: 635" onload="bodyload()">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form" enctype="multipart/form-data">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="jcjgpjbgjbqkbean.sysno" value="<%=jcjgpjbgjbqkbean.getSysno() %>"/>
         <!-- 建设单位编号id -->
         <input type="hidden" id="jsdwbh" name="jcjgpjbgjbqkbean.jsdwbh" value="<%=jcjgpjbgjbqkbean.getJsdwbh() %>"/>
         
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         
         <input type="hidden" id="wtdwbh" name="jcjgpjbgjbqkbean.wtdwbh" value="<%=jcjgpjbgjbqkbean.getWtdwbh() %>"/>
         
          <input name="jcjgpjbgjbqkbean.bgfj" type="hidden" id="bgfj" value="<%=jcjgpjbgjbqkbean.getBgfj() %>" />
          
          <input name="jcjgpjbgjbqkbean.xmbh" type="hidden" id="xmbh" value="<%=jcjgpjbgjbqkbean.getXmbh() %>" />
          
          <input name="jcjgpjbgjbqkbean.xmmc" type="hidden" id="xmmc" value="<%=jcjgpjbgjbqkbean.getXmmc()%>" />
               	   
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" >
             <tr>
                <td class="l-table-edit-td-right">委托单位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.wtdwmc" type="text" id="wtdwmc" value="<%=jcjgpjbgjbqkbean.getWtdwmc() %>" onkeyup="getEnterinfo(this.value)" ltype="text" validate="{required:true }" />
               		<div id="_mainGrid"  style="position:absolute;z-index: 1001;background: white; width: 200px;" ></div>
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">建设单位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.jsdwmc" type="text" id="jsdwmc" value="<%=jcjgpjbgjbqkbean.getJsdwmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">项目地址：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.xmdz" type="text" id="xmdz" value="<%=jcjgpjbgjbqkbean.getXmdz() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">项目总投资额：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.xmztze" type="text" id="xmztze" value="<%=jcjgpjbgjbqkbean.getXmztze() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">样品数量：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.ypsl" type="text" id="ypsl" value="<%=jcjgpjbgjbqkbean.getYpsl() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">评价类型：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                
                   <% 
				               	 DBSelect dbsel = new DBSelect("jcjgpjbgjbqkbean.pjlx","PJLX",jcjgpjbgjbqkbean.getPjlx());
				 				 //dbsel.addAttr("style", "width: 202px;");
				 				 dbsel.addAttr("id", "pjlx");
				                 dbsel.addAttr("check", "notBlank");
				                 dbsel.addAttr("required", "true");
				                 dbsel.addAttr("showName", "评价类型");
				                 dbsel.addOption("请选择","");
			 	             	 dbsel.setDisplayAll(false);
				                 out.print(dbsel);
				            %>  
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">样品采集时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.ypcjsj" type="text" id="ypcjsj" value="<%=jcjgpjbgjbqkbean.getYpcjsj() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">实验室分析时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.sysfxsj" type="text" id="sysfxsj" value="<%=jcjgpjbgjbqkbean.getSysfxsj()%>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">编制人：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.bzr" type="text" id="bzr" value="<%=jcjgpjbgjbqkbean.getBzr()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">编制日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.bzrq" type="text" id="bzrq" value="<%=jcjgpjbgjbqkbean.getBzrq()%>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">审核人：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.shrxm" type="text" id="shrxm" value="<%=jcjgpjbgjbqkbean.getShrxm() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">审核日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.shrq" type="text" id="shrq" value="<%=jcjgpjbgjbqkbean.getShrq() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
             <tr>
                <td class="l-table-edit-td-right">授权签字：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.sqqz" type="text" id="sqqz" value="<%=jcjgpjbgjbqkbean.getSqqz()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">签字日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.qzrq" type="text" id="qzrq" value="<%=jcjgpjbgjbqkbean.getQzrq() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">符合项数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.fhxs" type="text" id="fhxs" value="<%=jcjgpjbgjbqkbean.getFhxs() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">不符合项数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.bfhxs" type="text" id="bfhxs" value="<%=jcjgpjbgjbqkbean.getBfhxs()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr><%--
            
            <tr>
                <td class="l-table-edit-td-right">报告收费：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.bgsf" type="text" id="bgsf" value="<%=jcjgpjbgjbqkbean.getBgsf() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">合同附件：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcjgpjbgjbqkbean.htfj" type="text" id="htfj" value="<%=jcjgpjbgjbqkbean.getHtfj()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            --%><tr>
                <td class="l-table-edit-td-right">报告附件：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input type="file" name="file" id="file" title="报告附件"/>
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">报告是否合格：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                    <% 
				               	 dbsel = new DBSelect("jcjgpjbgjbqkbean.sfhg","SF",jcjgpjbgjbqkbean.getSfhg());
				 				 //dbsel.addAttr("style", "width: 202px;");
				 				 dbsel.addAttr("id", "sfhg");
				                 dbsel.addAttr("check", "notBlank");
				                 dbsel.addAttr("required", "true");
				                 dbsel.addAttr("showName", "报告是否合格");
				                 dbsel.addOption("请选择","");
			 	             	 dbsel.setDisplayAll(false);
				                 out.print(dbsel);
				            %>  
                
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
            	<td colspan="6" align="center" style="font-size: 16px;font-weight: bold;">
            		<%if(jcjgpjbgjbqkbean.getBgfj()!=null&&!jcjgpjbgjbqkbean.getBgfj().equals("null")&&!jcjgpjbgjbqkbean.getBgfj().equals("")){
            		%>
            			<a href="<%=webpath+jcjgpjbgjbqkbean.getBgfj()%>">检测报告下载</a>
            		<%} %>
            	</td>
            </tr>
        </table>
 <br />
<table align="center">
<tr>
 <td>
     <input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /> 
     <input type="button" value="关闭" id="colButton" class="l-button l-button-test"/>
 </td>
</tr>
 
</table>
 </form>
    
</body>  
</html> 
