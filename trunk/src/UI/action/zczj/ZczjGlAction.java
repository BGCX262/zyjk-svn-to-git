/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-02      孙雁斌         新規作成 ;
 ****************************************************/
package UI.action.zczj;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.SerialNumber;
import st.platform.utils.Config;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import UI.dao.zyjk.T_yhzc_bzbBean;
import UI.dao.zyjk.T_yhzc_bzzbBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjkgl") 
public class ZczjGlAction extends BasicAction{
	
	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(ZczjGlAction.class);
	
	
	private T_yhzc_bzzbBean bzzbBean;
	
	private T_yhzc_bzbBean bzbBean;	
	
	private String strSysno;
	
	private MessageBean messageBean;// 操作状态
	
	private String sysno;//添加操作完成后，返回的主键
	

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "BzzbAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,bzzbBean.*" }) })
	public String findObjson() {
		try {
			T_yhzc_bzzbBean bzzbBean = new T_yhzc_bzzbBean();
			if (!(messageBean.getMethod().equals("add"))) {
				bzzbBean = (T_yhzc_bzzbBean) findByKey(bzzbBean,
						" where  id='" + strSysno + "'");
				if (bzzbBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
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
	 * 
	 * @return
	 */
	@Action(value = "BzzbAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zczj/zczjgl/info/bzzbinfo.jsp") })
	public String findByKey() {
		try {
			bzzbBean = new T_yhzc_bzzbBean();
			if (!(messageBean.getMethod().equals("add"))) {
				bzzbBean = (T_yhzc_bzzbBean) findByKey(bzzbBean,
						" where  id='" + strSysno + "'");
				if (bzzbBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
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
	 * 添加方法
	 * 
	 * @return
	 */
	@Action(value = "BzzbAction_insert")
	public String insert() {
		try {
			String number = "T_YHZC_BZZB"+Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			bzzbBean.setId(number);
			messageBean = insert(bzzbBean);
		} catch (Exception e) {

			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}

	/**
	 * 
	 * 修改方法
	 * 
	 * @return
	 */
	@Action(value = "BzzbAction_update")
	public String update() {
		try {

			messageBean = update(bzzbBean, " where  id='"
					+ bzzbBean.getId() + "'");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}

	/**
	 * 
	 * 删除改方法
	 * 
	 * @return
	 */
	@Action(value = "BzzbAction_delete")
	public String delete() {
		try {
			bzzbBean = new T_yhzc_bzzbBean();
			messageBean = delete(bzzbBean, " where  id in (" + strSysno + ")");
			
			T_yhzc_bzbBean bzbBean=new T_yhzc_bzbBean();
			//List<T_yhzc_bzbBean> bzblist=new ArrayList<T_yhzc_bzbBean>();
			//bzblist=bzbBean.find(" where zbid='"+ strSysno +"'");
			
			//for(int i=0;i<bzblist.size();i++){
				
				messageBean = delete(bzbBean, " where  zbid in (" + strSysno + ")");
			//}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}
    
	
	/**
	 * 
	 * 查询信息 返回jsp
	 * 
	 * @return
	 */
	@Action(value = "BzbAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zczj/zczjgl/zczjinfolist.jsp") })
	public String findGridByKey() {
		try {
			bzzbBean = new T_yhzc_bzzbBean();
			if (!(messageBean.getMethod().equals("add"))) {
				bzzbBean = (T_yhzc_bzzbBean) findByKey(bzzbBean,
						" where  id='" + strSysno + "'");
				if (bzzbBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.FINDBYKEY;
	}

	public T_yhzc_bzbBean getBzbBean() {
		return bzbBean;
	}

	public void setBzbBean(T_yhzc_bzbBean bzbBean) {
		this.bzbBean = bzbBean;
	}

	public T_yhzc_bzzbBean getBzzbBean() {
		return bzzbBean;
	}

	public void setBzzbBean(T_yhzc_bzzbBean bzzbBean) {
		this.bzzbBean = bzzbBean;
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

	public String getSysno() {
		return sysno;
	}

	public void setSysno(String sysno) {
		this.sysno = sysno;
	}
	 
	 
}
