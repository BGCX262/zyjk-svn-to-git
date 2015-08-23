/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-06               新規作成 ;
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
 import UI.dao.zyjk.Z_scclBean;
@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk") 
public class ZscclAction extends BasicAction {


	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(ZscclAction.class);
	 private Z_scclBean z_scclBean; // 返回的信息;

	 private String strWhere=""; // 查询条件;

	 private String strSysno=""; // 主键编号;

	 private PageBean pageBean; // 分页类;

	 private MessageBean messageBean;// 操作状态

	/**
	*  
	* 查询信息 返回json信息
	* @return 
	*/  
	 @Action(value = "ZscclAction_findObjson", results = { 
	  @Result(type = "json", name = MisConstant.FINDOBJSON, params = { "includeProperties","messageBean.*,z_scclBean.*" }) }) 
   public String findObjson() {
	 try {
	 z_scclBean = new Z_scclBean();
	  if (!(messageBean.getMethod().equals("add"))) {
	  z_scclBean = (Z_scclBean)findByKey(z_scclBean, " where  ='" + strSysno + "'");
	  if (z_scclBean != null) {
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
	 @Action(value = "ZscclAction_findByKey", results = { 
	   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/flfj/zyjkfl.jsp") }) 
   public String findByKey() {
	 try {
	 z_scclBean = new Z_scclBean();
	  if (!(messageBean.getMethod().equals("add"))) {
	  z_scclBean = (Z_scclBean)findByKey(z_scclBean, " where  ='" + strSysno + "'");
	  if (z_scclBean != null) {
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


	 public Z_scclBean getZ_scclBean() {
	 return z_scclBean;
	 }
	 
	  public void setZ_scclBean(Z_scclBean z_scclBean) {
	  this.z_scclBean = z_scclBean;
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
