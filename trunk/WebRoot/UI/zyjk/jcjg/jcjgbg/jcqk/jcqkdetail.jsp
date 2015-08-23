<!--
/****************************************************
 * <p>处理内容：劳动者从业史</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29    劳动者从业史               新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.JcqkBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 JcqkBean jcqkbean = (JcqkBean)request.getAttribute("jcqkbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>/UI/zyjk/jcjg/jcjgbg/jcqk/jcqkdetail.js"></script>  
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="jcqkbean.sysno" value="<%=jcqkbean.getSysno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         
         <input name="jcqkbean.jcdwmc" type="hidden" id="jcdwmc" value="<%=jcqkbean.getJcdwmc() %>" ltype="text" />
         <input name="jcqkbean.jcdwbh" type="hidden" id="jcdwbh" value="<%=jcqkbean.getJcdwbh() %>" ltype="text" />
           <input type="hidden" id="bgbh" name="jcqkbean.bgbh" value="<%=jcqkbean.getBgbh() %>"/> 
           <input type="hidden" id="dwbh" name="jcqkbean.dwbh" value="<%=jcqkbean.getDwbh() %>"/>   
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <%--<td class="l-table-edit-td-right">检测单位名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.jcdwmc" type="text" id="jcdwmc" value="<%=jcqkbean.getJcdwmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                --%><td class="l-table-edit-td-right">检测类别：</td>
                <td class="l-table-edit-td-left"  colspan="4">
                   <%--<input name="jcqkbean.jclb" type="text" id="jclb" value="<%=jcqkbean.getJclb() %>" ltype="text" validate="{required:true }" />
                --%>
                	<% 
				               	 DBSelect dbsel = new DBSelect("jcqkbean.jclb","JCLB",jcqkbean.getJclb());
				 				 dbsel.addAttr("style", "width: 260px;");
				 				 dbsel.addAttr("id", "jclb");
				               //  dbsel.addAttr("check", "notBlank");
				                 dbsel.addAttr("required", "true");
				                 dbsel.addAttr("showName", "检测类别");
				                 dbsel.addOption("请选择","");
				                 dbsel.addAttr("onchange","onChange(this)");
			 	             	 dbsel.setDisplayAll(false);
				                 out.print(dbsel);
				            %>  
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">车间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.cj" type="text" id="cj" value="<%=jcqkbean.getCj() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">接触工种：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.jcgz" type="text" id="jcgz" value="<%=jcqkbean.getJcgz() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">单位名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.dwmc" type="text" id="dwmc" value="<%=jcqkbean.getDwmc() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">检测项目：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.jcxm" type="text" id="jcxm" value="<%=jcqkbean.getJcxm() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>                
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">作业点：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.zyd" type="text" id="zyd" value="<%=jcqkbean.getZyd() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">接触时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.jcsj" type="text" id="jcsj" value="<%=jcqkbean.getJcsj() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
                      
        </table>
        
        
        <table id="01" style="display:none" class="form-l-table-edit" cellpadding="0" cellspacing="0" align="center">
        <tr>
        <td class="l-table-edit-td-right">CSTEL：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.cstel" type="text" id="cstel" value="<%=jcqkbean.getCstel()%>" ltype="text" />
                </td>
                <td class="td_message"></td>
        <td class="l-table-edit-td-right">PCSTEL：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.pcstel" type="text" id="pcstel" value="<%=jcqkbean.getPcstel()%>" ltype="text"  />
                </td>
                <td class="td_message"></td>        
        </tr>
        <tr>
        <td class="l-table-edit-td-right">STEL判定：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.stelpd" type="text" id="stelpd" value="<%=jcqkbean.getStelpd()%>" ltype="text"  />
                </td>
                <td class="td_message"></td>
        
        </tr>
        </table>
        
        <table id="0205" style="display:none" class="form-l-table-edit" cellpadding="0" cellspacing="0" align="center">
        <tr>
                
                <td class="l-table-edit-td-right">CTWA：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.ctwa" type="text" id="ctwa" value="<%=jcqkbean.getCtwa()%>" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">PCTWA：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.pcwta" type="text" id="pcwta" value="<%=jcqkbean.getPcwta() %>" ltype="text" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                
                <td class="l-table-edit-td-right">TWA判定：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.twapd" type="text" id="twapd" value="<%=jcqkbean.getTwapd()%>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
        </table>
        <table id="030406" style="display:none" class="form-l-table-edit" cellpadding="0" cellspacing="0" align="center">
            <tr>
                
                <td class="l-table-edit-td-right">接触浓度：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.jcnd" type="text" id="jcnd" value="<%=jcqkbean.getJcnd() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
                 <td class="l-table-edit-td-right">超限倍数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.cxbs" type="text" id="cxbs" value="<%=jcqkbean.getCxbs()%>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>          
            <tr>
                <td class="l-table-edit-td-right">浓度判定：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.ndpd" type="text" id="ndpd" value="<%=jcqkbean.getNdpd() %>" ltype="text" />
                </td>
                <td class="td_message"></td>
            </tr>
        </table>
      
        <table id="07" style="display:none" class="form-l-table-edit" cellpadding="0" cellspacing="0" align="center">
           <tr>
                <td class="l-table-edit-td-right">LEX8H：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.lex8h" type="text" id="lex8h" value="<%=jcqkbean.getLex8h() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">噪声标准限值：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.zsbzxz" type="text" id="zsbzxz" value="<%=jcqkbean.getZsbzxz() %>" ltype="text" />
                </td>
                <td class="td_message"></td>
            </tr>
           <tr>
               <td class="l-table-edit-td-right">噪声判定：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.zspd" type="text" id="zspd" value="<%=jcqkbean.getZspd()%>" ltype="text"  />
                </td>
                <td class="td_message"></td>        
           </tr>
        </table>
        
        <table id="08" style="display:none" class="form-l-table-edit" cellpadding="0" cellspacing="0" align="center">
          <tr>
               
                <td class="l-table-edit-td-right">测量结果：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.cljg" type="text" id="cljg" value="<%=jcqkbean.getCljg() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">震动标准限值：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.zdbzxz" type="text" id="zdbzxz" value="<%=jcqkbean.getZdbzxz() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">震动判定：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.zdpd" type="text" id="zdpd" value="<%=jcqkbean.getZdpd() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
        </table>
        <table id="09" style="display:none" class="form-l-table-edit" cellpadding="0" cellspacing="0" align="center">
            
            <tr>
                <td class="l-table-edit-td-right">电场强度：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.dcqd" type="text" id="dcqd" value="<%=jcqkbean.getDcqd() %>" ltype="text" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">工频标准限值：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.gpbzxz" type="text" id="gpbzxz" value="<%=jcqkbean.getGpbzxz()%>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
            <td class="l-table-edit-td-right">工频判定：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.gppd" type="text" id="gppd" value="<%=jcqkbean.getGppd()%>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
        </table>
        <table id="10" style="display:none" class="form-l-table-edit" cellpadding="0" cellspacing="0" align="center">
            <tr>
                
                <td class="l-table-edit-td-right">WBGT：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.wbgt" type="text" id="wbgt" value="<%=jcqkbean.getWbgt() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">高温标准限值：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.gwbzxz" type="text" id="gwbzxz" value="<%=jcqkbean.getGwbzxz() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">高温判定：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.gwpd" type="text" id="gwpd" value="<%=jcqkbean.getGwpd() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
        
        </table>
        
        <table id="11" style="display:none" class="form-l-table-edit" cellpadding="0" cellspacing="0" align="center">
            <tr>
                
                <td class="l-table-edit-td-right">辐照度值：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.fzdz" type="text" id="fzdz" value="<%=jcqkbean.getFzdz() %>" ltype="text" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">标准限值：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.bzxz" type="text" id="bzxz" value="<%=jcqkbean.getBzxz() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">单项判定：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcqkbean.dxpd" type="text" id="dxpd" value="<%=jcqkbean.getDxpd() %>" ltype="text"  />
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
