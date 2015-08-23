<!--
/****************************************************
 * <p>处理内容：劳动者基本信息</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29    孙雁斌           新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.QyryxxBean"/>
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyryxxBean qyryxxbean = (QyryxxBean)request.getAttribute("qyryxxbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 QyjbqkBean qyBean=new QyjbqkBean();
 //员工所在企业主键
 String enterno=request.getParameter("enterno");
 String enternm=qyryxxbean.getEnternm();
 if(null!=enterno){
	 qyBean=qyBean.findFirst(" where enterno='"+ enterno +"'");
	 enternm=qyBean.getDwmc();
 }
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/ldzjbxx//ldzjbxxdetail.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyryxxbean.sysno" value="<%=qyryxxbean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="enterno" name="qyryxxbean.enterno" value="<%=qyryxxbean.getEnterno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">姓  名：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyryxxbean.name" type="text" id="name" value="<%=qyryxxbean.getName() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">性 别：</td>
                <td class="l-table-edit-td-left">
        	    <% 
        	         DBSelect dbsel = new DBSelect("sex","sex",qyryxxbean.getSex());
	 				 dbsel.addAttr("style", "width: 202px;");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("name","qyryxxbean.sex");
	                 dbsel.addAttr("showName", "性别");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                </td> 
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">身份证号：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyryxxbean.idcard" type="text" id="idcard" value="<%=qyryxxbean.getIdcard() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">工 种：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyryxxbean.gz" type="text" id="gz" value="<%=qyryxxbean.getGz() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">所在单位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyryxxbean.enternm" readonly type="text" id="enternm" value="<%=enternm %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">职务：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <% 
        	         dbsel = new DBSelect("zw","ZW",qyryxxbean.getZw());
	 				 dbsel.addAttr("style", "width: 202px;");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("name","qyryxxbean.zw");
	                 dbsel.addAttr("showName", "职务");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">文化程度：</td>
                
                <td class="l-table-edit-td-left">
        	    <% 
        	         dbsel = new DBSelect("whcd","EDUDEGREE",qyryxxbean.getWhcd());
	 				 dbsel.addAttr("style", "width: 202px;");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("name","qyryxxbean.whcd");
	                 dbsel.addAttr("showName", "文化程度");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                </td> 
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">有效期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyryxxbean.yxq" type="text" id="yxq" value="<%=qyryxxbean.getYxq() %>" ltype="date"  />
                </td>
                <td class="td_message"></td>
                
            </tr>
             <tr>
                <td class="l-table-edit-td-right">初领证日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyryxxbean.clzdate" type="text" id="clzdate" value="<%=qyryxxbean.getClzdate() %>" ltype="date" />
                </td>
                <td class="td_message"></td>
                
                <td class="l-table-edit-td-right">毕业院校：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyryxxbean.byyx" type="text" id="byyx" value="<%=qyryxxbean.getByyx() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">联系电话：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyryxxbean.lxdh" type="text" id="lxdh" value="<%=qyryxxbean.getLxdh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">证书编号：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyryxxbean.zsno" type="text" id="zsno" value="<%=qyryxxbean.getZsno() %>" ltype="text" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">所学专业：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyryxxbean.sxzy" type="text" id="sxzy" value="<%=qyryxxbean.getSxzy() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
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
