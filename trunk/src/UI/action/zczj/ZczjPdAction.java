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
import UI.dao.zyjk.ZczjdfbBean;
import UI.dao.zyjk.ZczjpzbBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjkpd") 
public class ZczjPdAction extends BasicAction{
	
	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(ZczjPdAction.class);
	
	
	private T_yhzc_bzzbBean bzzbBean;
	
	private T_yhzc_bzbBean bzbBean;	
	
	private ZczjpzbBean pzbBean;	
	
	private List<ZczjpzbBean> pzbBeanlist;
	
	private String strSysno;
	
	private MessageBean messageBean;// 操作状态
	
	private String zbid="";
	
	private String parentid="";
	
	private String sysno="";
	

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "BzbAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,bzbBean.*" }) })
	public String findObjson() {
		try {
			T_yhzc_bzbBean bzbBean = new T_yhzc_bzbBean();
			if (!(messageBean.getMethod().equals("add"))) {
				bzbBean = (T_yhzc_bzbBean) findByKey(bzbBean,
						" where  id='" + strSysno + "'");
				if (bzbBean != null) {
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
	@Action(value = "BzbAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zczj/zczjgl/info/pdinfo.jsp") })
	public String findByKey() {
		try {
			pzbBean=new ZczjpzbBean();
            
			if (!(messageBean.getMethod().equals("add"))) {
				pzbBean = (ZczjpzbBean) findByKey(pzbBean,
						" where  sysno='" + strSysno + "'");
				if (pzbBean != null) {
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
	 * 查询信息 返回jsp
	 * 
	 * @return
	 */
	@Action(value = "PdAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zczj/zczjgl/info/pddetail.jsp") })
	public String findInfoByKey() {
		try {
			pzbBean=new ZczjpzbBean();
			//System.out.println("***************"+sysno);
			pzbBean.setFfsysn(sysno);
			//pzbBean.setRnsysno(rnsysno);
			
			//pzbBean.setXmsysno(xmsysno);
			//pzbBeanlist=new ArrayList<ZczjpzbBean>();
			if (!(messageBean.getMethod().equals("add"))) {
				pzbBean = (ZczjpzbBean) findByKey(pzbBean,
						" where  sysno='" + strSysno + "'");
				if (pzbBean != null) {
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
	@Action(value = "BzbAction_insert")
	public String insert() {
		try {
			String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			pzbBean.setSysno(number);
			messageBean = insert(pzbBean);

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
	@Action(value = "BzbAction_update")
	public String update() {
		try {

			messageBean = update(pzbBean, " where  sysno='"
					+ pzbBean.getSysno() + "'");

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
	@Action(value = "BzbAction_delete")
	public String delete() {
		try {
			bzbBean = new T_yhzc_bzbBean();
			messageBean = delete(bzbBean, " where  id in (" + strSysno + ")");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
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

	public String getZbid() {
		return zbid;
	}

	public void setZbid(String zbid) {
		this.zbid = zbid;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public ZczjpzbBean getPzbBean() {
		return pzbBean;
	}

	public void setPzbBean(ZczjpzbBean pzbBean) {
		this.pzbBean = pzbBean;
	}

	public List<ZczjpzbBean> getPzbBeanlist() {
		return pzbBeanlist;
	}

	public void setPzbBeanlist(List<ZczjpzbBean> pzbBeanlist) {
		this.pzbBeanlist = pzbBeanlist;
	}

	public String getSysno() {
		return sysno;
	}

	public void setSysno(String sysno) {
		this.sysno = sysno;
	}

	
	 
	 
}
