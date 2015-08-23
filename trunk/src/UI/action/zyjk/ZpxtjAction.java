/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27               新規作成 ;
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
 import UI.dao.zyjk.Z_pxtjBean;
@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk") 
public class ZpxtjAction extends BasicAction {


	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(ZpxtjAction.class);
	 private Z_pxtjBean z_pxtjBean; // 返回的信息;

	 private String strWhere=""; // 查询条件;

	 private String strSysno=""; // 主键编号;

	 private PageBean pageBean; // 分页类;

	 private MessageBean messageBean;// 操作状态

	/**
	*  
	* 查询信息 返回json信息
	* @return 
	*/  
	 @Action(value = "ZpxtjAction_findObjson", results = { 
	  @Result(type = "json", name = MisConstant.FINDOBJSON, params = { "includeProperties","messageBean.*,z_pxtjBean.*" }) }) 
   public String findObjson() {
	 try {
	 z_pxtjBean = new Z_pxtjBean();
	  if (!(messageBean.getMethod().equals("add"))) {
	  z_pxtjBean = (Z_pxtjBean)findByKey(z_pxtjBean, " where  ='" + strSysno + "'");
	  if (z_pxtjBean != null) {
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
	 @Action(value = "ZpxtjAction_findByKey", results = { 
	   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/cor/pxtjlist.jsp") }) 
   public String findByKey() {
	 try {
	 z_pxtjBean = new Z_pxtjBean();
	  if (!(messageBean.getMethod().equals("add"))) {
	  z_pxtjBean = (Z_pxtjBean)findByKey(z_pxtjBean, " where  ='" + strSysno + "'");
	  if (z_pxtjBean != null) {
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

	/**
	*  
	*添加方法
	* @return 
	*/  
	 @Action(value = "ZpxtjAction_insert") 
   public String insert() {
//	 try {
//	  String number = BusinessDate.getNoFormatToday() + "-" + SerialNumber.getNextSerialNo("67");
//	  z_pxtjBean.set(number);
//	  messageBean = insert(z_pxtjBean);
//	 } catch (Exception e) {;
//	 // TODO Auto-generated catch block
//	 // 设置错误返回的提示
//	 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
//	 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
//	 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
//	 }
	 return MisConstant.RETMESSAGE;
		}

	/**
	*  
	* 修改方法
	* @return 
	*/  
	 @Action(value = "ZpxtjAction_update") 
   public String update() {
//	 try {
//	 
//	  messageBean =  update(z_pxtjBean, " where  ='" + z_pxtjBean.get() + "'");;
//	 
//	 } catch (Exception e) {;
//	 // TODO Auto-generated catch block
//	 // 设置错误返回的提示
//	 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
//	 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
//	 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
//	 }
	 return MisConstant.RETMESSAGE;
		}

	/**
	*  
	* 删除改方法
	* @return 
	*/  
	 @Action(value = "ZpxtjAction_delete") 
   public String delete() {
//	 try {
//	 z_pxtjBean = new Z_pxtjBean();
//	  messageBean =  delete(z_pxtjBean, " where  ='" + z_pxtjBean.get() + "'");
//	 
//	 } catch (Exception e) {;
//	 // TODO Auto-generated catch block
//	 // 设置错误返回的提示
//	 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
//	 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
//	 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
//	 }
	 return MisConstant.RETMESSAGE;
		}

	 public Z_pxtjBean getZ_pxtjBean() {
	 return z_pxtjBean;
	 }
	 
	  public void setZ_pxtjBean(Z_pxtjBean z_pxtjBean) {
	  this.z_pxtjBean = z_pxtjBean;
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
