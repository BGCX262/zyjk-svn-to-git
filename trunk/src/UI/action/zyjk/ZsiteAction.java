/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-28               新規作成 ;
 ****************************************************/
package UI.action.zyjk;





 import org.apache.log4j.Logger;
 import org.apache.struts2.convention.annotation.Action;
 import org.apache.struts2.convention.annotation.Namespace;
 import org.apache.struts2.convention.annotation.ParentPackage;
 import org.apache.struts2.convention.annotation.Result;
 
 import st.platform.db.SerialNumber;
 import st.portal.action.BasicAction;
 import st.portal.action.MessageBean;
 import st.portal.action.PageBean;
 import UI.message.MisConstant;
 import UI.util.BusinessDate;
 import UI.dao.zyjk.Z_siteBean;
@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk") 
public class ZsiteAction extends BasicAction {


	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(ZsiteAction.class);
	 private Z_siteBean z_siteBean; // 返回的信息;

	 private String strWhere=""; // 查询条件;

	 private String strSysno=""; // 主键编号;

	 private PageBean pageBean; // 分页类;

	 private MessageBean messageBean;// 操作状态

	/**
	*  
	* 查询信息 返回json信息
	* @return 
	*/  
	 @Action(value = "ZsiteAction_findObjson", results = { 
	  @Result(type = "json", name = MisConstant.FINDOBJSON, params = { "includeProperties","messageBean.*,z_siteBean.*" }) }) 
   public String findObjson() {
	 try {
	 z_siteBean = new Z_siteBean();
	  if (!(messageBean.getMethod().equals("add"))) {
	  z_siteBean = (Z_siteBean)findByKey(z_siteBean, " where  ='" + strSysno + "'");
	  if (z_siteBean != null) {
	  messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
	  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
	   }else{
	  messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	   }
	   }
	 } catch (Exception e) {;
	 // TODO Auto-generated catch block
	 // 设置错误返回的提示
	 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
	 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	 }
	 return MisConstant.FINDOBJSON;
		}

	/**
	*  
	* 查询信息 返回jsp
	* @return 
	*/  
	 @Action(value = "ZsiteAction_findByKey", results = { 
	   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/cor/pxtjlist.jsp") }) 
   public String findByKey() {
	 try {
	 z_siteBean = new Z_siteBean();
	  if (!(messageBean.getMethod().equals("add"))) {
	  z_siteBean = (Z_siteBean)findByKey(z_siteBean, " where  ='" + strSysno + "'");
	  if (z_siteBean != null) {
	  messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
	  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
	   }else{
	  messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	   }
	   }
	 } catch (Exception e) {;
	 // TODO Auto-generated catch block
	 // 设置错误返回的提示
	 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
	 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	 }
	 return MisConstant.FINDBYKEY;
		}

	

	 public Z_siteBean getZ_siteBean() {
	 return z_siteBean;
	 }
	 
	  public void setZ_siteBean(Z_siteBean z_siteBean) {
	  this.z_siteBean = z_siteBean;
	 }
	 
	  public MessageBean getMessageBean() {
	  return messageBean;
	 }
	 
	  public void setMessageBean(MessageBean messageBean) {
	   this.messageBean = messageBean;
	 }
	 
	  public PageBean getPageBean() {
	  return pageBean;
	 }
	 
	  public void setPageBean(PageBean pageBean) {
	   this.pageBean = pageBean;
	 }
	 
	  public String getStrSysno() {
	  return strSysno;
	 }
	 
	  public void setStrSysno(String strSysno) {
	   this.strSysno = strSysno;
	 }
	 
	  public String getStrWhere() {
	  return strWhere;
	 }
	 
	  public void setStrWhere(String strWhere) {
	   this.strWhere = strWhere;
	 }
	 
}
