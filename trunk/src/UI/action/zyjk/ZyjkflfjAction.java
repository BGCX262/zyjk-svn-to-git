/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-06               新規作成 ;
 ****************************************************/
package UI.action.zyjk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import st.platform.db.SerialNumber;
import st.platform.security.OperatorManager;
import st.platform.security.SystemAttributeNames;
import st.platform.utils.Config;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.system.dao.PtoperBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
import UI.dao.zyjk.T_officerBean;
import UI.dao.zyjk.ZyjkflfjBean;

@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk")
public class ZyjkflfjAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(ZyjkflfjAction.class);

	private ZyjkflfjBean zyjkflfjBean; // 返回的信息;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态

	/**
	 * 生产情况列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "ZyjkflfjAction_findList")
	public String findList() throws Exception {
		try {
			// 初始化查询条件
			ConnectionManager cm = ConnectionManager.getInstance();

			DatabaseConnection DBCon = cm.get();

			if (pageBean == null) {
				pageBean = new PageBean();

			}
			// 返回的页数
			RecordSet gridRS;
			// 统计记录的数据量
			String strCountSQL = "select count(*)  from Z_cor where 1=1 "
					+ strWhere;
			//System.out.println("countSQL::" + strCountSQL);
			gridRS = DBCon.executeQuery(strCountSQL);
			if (gridRS.next()) {
				pageBean.setTotal(gridRS.getInt(0));
				// System.out.println(pageBean.getTotal());
			}
			// 查询内容
			List<Map<String, String>> listDate = new ArrayList<Map<String, String>>();
			Map<String, String> map;
			String strFSQL = "select corpkey,dwmc,leader,zcdz,lxdh,whrenshu,dq3,dq4,dbo.getWHYS(corpkey) as whys,dbo.getWHYSNM(corpkey) as whysnm,dq1  from Z_cor where 1=1";
			gridRS = DBCon.executeQuery(strFSQL, strWhere, "", pageBean
					.getPageSize()
					* (pageBean.getPage() - 1) + 1, pageBean.getPageSize(),
					pageBean.getTotal());

			while (gridRS != null && gridRS.next()) {
				map = new HashMap<String, String>();
				for (int i = 0; i < gridRS.getColumnCount(); i++) {

					String mark = gridRS.getFieldName(i);
					String value = gridRS.getString(gridRS.getFieldName(i))
							.trim().replace("\r\n", "");

					map.put(mark, value);

				}
				listDate.add(map);
			}
			pageBean.setDataSet(listDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MisConstant.FINDLIST;
	}

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "ZyjkflfjAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,zyjkflfjBean.*" }) })
	public String findObjson() {
		try {
			zyjkflfjBean = new ZyjkflfjBean();
			if (!(messageBean.getMethod().equals("add"))) {
				zyjkflfjBean = (ZyjkflfjBean) findByKey(zyjkflfjBean,
						" where  sysno='" + strSysno + "'");
				if (zyjkflfjBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean
							.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
			;
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
	@Action(value = "ZyjkflfjAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/flfj/zyjkfl.jsp") })
	public String findByKey() {
		try {
			zyjkflfjBean = new ZyjkflfjBean();
			if (!(messageBean.getMethod().equals("add"))) {
				zyjkflfjBean = (ZyjkflfjBean) findByKey(zyjkflfjBean,
						" where  sysno='" + strSysno + "'");
				if (zyjkflfjBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean
							.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
			;
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
	@Action(value = "ZyjkflfjAction_insert")
	public String insert() {
		try {
			String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			zyjkflfjBean.setSysno(number);
			zyjkflfjBean.setNianfen(BusinessDate.getYear());
			zyjkflfjBean.setDate1(BusinessDate.getNowDay());
			zyjkflfjBean.setBak2("1");
			// HttpServletRequest request=ServletActionContext.getRequest();
			// OperatorManager om = (OperatorManager)
			// request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
			// zyjkflfjBean.setBak3(om.getDept().getDeptid());
			DatabaseConnection DBCon = null;
			ConnectionManager dc = ConnectionManager.getInstance();
			DBCon = dc.getConnection();
			String sql = "update zyjkflfj set bak2='2' where corpkey='"
					+ zyjkflfjBean.getCorpkey() + "'";
			DBCon.executeUpdate(sql);
			DBCon.close();
			messageBean = insert(zyjkflfjBean);

		} catch (Exception e) {
			;
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
	@Action(value = "ZyjkflfjAction_update")
	public String update() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			//OperatorManager om = (OperatorManager) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
			//zyjkflfjBean.setBak3(om.getDept().getDeptid());
			PtoperBean ptoperbean = (PtoperBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.USER_INFO_NAME);
			zyjkflfjBean.setBak3(ptoperbean.getDeptid());
			messageBean = update(zyjkflfjBean, " where  sysno='"+ zyjkflfjBean.getSysno() + "'");

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
	@Action(value = "ZyjkflfjAction_delete")
	public String delete() {
		try {
			zyjkflfjBean = new ZyjkflfjBean();
			messageBean = delete(zyjkflfjBean, " where sysno in (" + strSysno + ")");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}

	public ZyjkflfjBean getZyjkflfjBean() {
		return zyjkflfjBean;
	}

	public void setZyjkflfjBean(ZyjkflfjBean zyjkflfjBean) {
		this.zyjkflfjBean = zyjkflfjBean;
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
