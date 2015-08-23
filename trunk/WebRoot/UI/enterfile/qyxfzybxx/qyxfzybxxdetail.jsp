<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27               新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.QyxfzybxxBean"/>
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyxfzybxxBean qyxfzybxxBean = (QyxfzybxxBean)request.getAttribute("qyxfzybxxBean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 QyjbqkBean qyBean=new QyjbqkBean();
 //员工所在企业主键
 String enterno=request.getParameter("enterno");
 String enternm=qyxfzybxxBean.getEntername();
 if(null!=enterno){
	 qyBean=qyBean.findFirst(" where enterno='"+ enterno +"'");
	 enternm=qyBean.getDwmc();
 }
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/qyxfzybxx//qyxfzybxxdetail.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyxfzybxxBean.sysno" value="<%=qyxfzybxxBean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="enterno" name="qyxfzybxxBean.enterno" value="<%=qyxfzybxxBean.getEnterno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">姓名：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.ldzxm" type="text" id="ldzxm" value="<%=qyxfzybxxBean.getLdzxm() %>" ltype="text" validate="{required:true }" />
                   <input name="qyxfzybxxBean.ldzbh" type="hidden" id="ldzbh" value="<%=qyxfzybxxBean.getLdzbh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">性别：</td>
                
                <td class="l-table-edit-td-left"  >
        	    <% 
	               	 DBSelect dbsel = new DBSelect("sex","sex",qyxfzybxxBean.getSex());
	 				 dbsel.addAttr("style", "width: 202px;");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "性 别");
	                 dbsel.addAttr("name", "qyxfzybxxBean.sex");
	                 dbsel.addOption("请选择", "");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                </td>
                <td class="td_message"></td>
                
            </tr>
            <tr>
                
                <td class="l-table-edit-td-right">年龄：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.age" type="text" id="age" value="<%=qyxfzybxxBean.getSex() %>" ltype="spinner" ligerui="{type:'int'}" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">工作单位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.entername" readonly type="text" id="entername" value="<%=enternm %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">联系电话：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.lxdh" type="text" id="lxdh" value="<%=qyxfzybxxBean.getLxdh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">工种：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.gz" type="text" id="gz" value="<%=qyxfzybxxBean.getGz() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">种类：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <% 
	               	 dbsel = new DBSelect("zl","ZYBZL",qyxfzybxxBean.getZl());
	 				 dbsel.addAttr("style", "width: 102px;");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "种类");
	                 dbsel.addAttr("name", "qyxfzybxxBean.zl");
	                 dbsel.addOption("请选择", "");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">接害年龄：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.jhage" type="text" id="jhage" value="<%=qyxfzybxxBean.getJhage() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">初诊日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.czrq" type="text" id="czrq" value="<%=qyxfzybxxBean.getCzrq() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">复诊日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.fzrq" type="text" id="fzrq" value="<%=qyxfzybxxBean.getFzrq() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">尘肺晋期时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.cfjqdate" type="text" id="cfjqdate" value="<%=qyxfzybxxBean.getCfjqdate() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">死亡时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.swdate" type="text" id="swdate" value="<%=qyxfzybxxBean.getSwdate()%>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">结论：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                    <input name="qyxfzybxxBean.result" type="text" id="result" value="<%=qyxfzybxxBean.getResult() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">总工龄：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyxfzybxxBean.zgl" type="text" id="zgl" value="<%=qyxfzybxxBean.getZgl() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">备注：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                    <input name="qyxfzybxxBean.bak1" type="text" id="bak1" value="<%=qyxfzybxxBean.getBak1() %>" ltype="text" />
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
