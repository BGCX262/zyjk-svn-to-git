/*********************************************************************
 *<p>处理内容：SAFEOPER Action</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.03.21---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.safeoper;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.system.dao.PtoperBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
@ParentPackage("struts-filter")
@Namespace("/st/system/action/safeoper") 
public class SafeOperAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(SafeOperAction.class);

	private String strWhere=""; //查询条件

	private String strSysno=""; //主键编号

	private MessageBean messageBean ;//操作状态

	private PtoperBean ptOperBean; //返回的信息

	private List<Map<String, Object>> list;
	

	

	/**
	 *添加方法
	 * @return String 返回操作结果
	 */
	@Action(value = "safeoper_insert")
	public String insert() {
		try {
			String number = BusinessDate.getNoFormatToday() + "-" + st.platform.db.SerialNumber.getNextSerialNo("67");
			ptOperBean.setSysno(number);
			
			messageBean = insert(ptOperBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}


	/**
	 * 查询信息
	 * 
	 * @return String 返回操作结果
	 */
	 @Action(value = "safeoper_findByKey", results = {
			    @Result(name = MisConstant.FINDBYKEY, location = "/UI/system/safeoper/safeoperinfo.jsp") }) 
	public String findByKey() {
		try {
			logger.debug(messageBean.getMethod());
			//ptMenuBean = new PtmenuBean();
			
			if (!(messageBean.getMethod().equals("add"))) {
				ptOperBean = new PtoperBean();
				ptOperBean = (PtoperBean) findByKey(ptOperBean," where sysno ='" + strSysno + "'");
				
				if (ptOperBean == null) {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}else{
								
				ptOperBean.setDeptid(ptOperBean.getDeptid());

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}

		return MisConstant.FINDBYKEY;
	}

	/**
	 * 修改
	 * 
	 * @return String 返回操作结果
	 */
	 @Action(value = "safeoper_update") 
	public String update() {
		logger.debug("修改");
		try {
			messageBean = update(ptOperBean, " where sysno ='"	+ ptOperBean.getSysno() + "'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}

		return MisConstant.RETMESSAGE;
	}

	/**
	 * 删除方法
	 * 
	 * @return String 返回操作结果
	 */
	 @Action(value = "safeoper_delete") 
	public String delete() {
		try {
			ptOperBean = new PtoperBean();
			messageBean = delete(ptOperBean, " where sysno in (" + strSysno
					+ ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}

		return MisConstant.RETMESSAGE;
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	

	public MessageBean getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
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

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		SafeOperAction.logger = logger;
	}


	public PtoperBean getPtOperBean() {
		return ptOperBean;
	}


	public void setPtOperBean(PtoperBean ptOperBean) {
		this.ptOperBean = ptOperBean;
	}


	
	
	
}
