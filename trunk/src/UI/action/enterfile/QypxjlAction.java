/****************************************************
 * <p>处理内容：企业培训记录</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-24     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.enterfile;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.SerialNumber;
import st.platform.security.SystemAttributeNames;
import st.platform.utils.Config;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import worksynch.util.WriteRecordUtil;
import UI.dao.enterfile.QygljgrymxBean;
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.enterfile.QypxjlBean;
import UI.dao.enterfile.QywsgljgBean;
import UI.dao.zyjk.T_officerBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
import UI.util.DistcodeUtil;

@ParentPackage("struts-filter")
@Namespace("/UI/action/qypxjl")
public class QypxjlAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(QypxjlAction.class);

    private QypxjlBean qypxjlBean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String enterno=""; //企业主键编号
	

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "QypxjlAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,qypxjlBean.*" }) })
	public String findObjson() {
		try {
			QypxjlBean qypxjlBean = new QypxjlBean();
			T_officerBean officer=(T_officerBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.CORP_INFO_NAME);
			 if(null!=officer){
				 //Z_corBean cor=new Z_corBean();
				 QyjbqkBean qyjbqkbean=new QyjbqkBean();
				 qyjbqkbean=qyjbqkbean.findFirst(" where corpkey='"+officer.getLogin_id()+"'");
				 if(qyjbqkbean!=null){
					 //cor=new Z_corBean();
					 qypxjlBean.setEnternm(qyjbqkbean.getDwmc());
				 }
			 }
			if (!(messageBean.getMethod().equals("add"))) {
				qypxjlBean = (QypxjlBean) findByKey(qypxjlBean,
						" where sysno ='" + strSysno + "'");
				if (qypxjlBean != null) {
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
	@Action(value = "QypxjlAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/qypxjl/qypxjldetail.jsp") })
	public String findByKey() {
		try {
			qypxjlBean = new QypxjlBean();
			qypxjlBean.setEnterno(enterno);			
			//用人单位名称
			QyjbqkBean qyBean=new QyjbqkBean();
			qyBean=qyBean.findFirst(" where enterno='"+ enterno +"'");
			if(null!=qyBean&&!"".equals(qyBean)){
				qypxjlBean.setEnternm(qyBean.getDwmc());	
			}
			if (!(messageBean.getMethod().equals("add"))) {
				qypxjlBean = (QypxjlBean) findByKey(qypxjlBean,
						" where  sysno='" + strSysno + "'");
				if (qypxjlBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
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
	@Action(value = "QypxjlAction_insert")
	public String insert() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			qypxjlBean.setSysno(number);
			messageBean = insert(qypxjlBean);
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qypxjlBean, qypxjlBean.getClass().getName(), "qypxjl", "sysno", number, "add",cm);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
			//关闭线程
			 if ( count > 0 ) {
               dc.commit();
          } else {
               dc.rollback();
          }
			cm.release();
		}
		return MisConstant.RETMESSAGE;
	}

	/**
	 * 
	 * 修改方法
	 * 
	 * @return
	 */
	@Action(value = "QypxjlAction_update")
	public String update() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {

			messageBean = update(qypxjlBean, " where  sysno='"
					+ qypxjlBean.getSysno() + "'");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qypxjlBean, qypxjlBean.getClass().getName(), "qypxjl", "sysno", qypxjlBean.getSysno(), "update",cm);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
			//关闭线程
			 if ( count > 0 ) {
               dc.commit();
          } else {
               dc.rollback();
          }
			cm.release();
		}
		return MisConstant.RETMESSAGE;
	}

	/**
	 * 
	 * 删除改方法
	 * 
	 * @return
	 */
	@Action(value = "QypxjlAction_delete")
	public String delete() {
		 //开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			qypxjlBean = new QypxjlBean();
			messageBean = delete(qypxjlBean, " where  sysno in (" + strSysno + ")");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qypxjlBean, qypxjlBean.getClass().getName(), "qypxjl", "sysno", strSysno, "delete",cm);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
            //关闭线程
			 if ( count > 0 ) {
                dc.commit();
           } else {
                dc.rollback();
           }
			cm.release();
		}
		return MisConstant.RETMESSAGE;
	}

	
    
	public QypxjlBean getQypxjlBean() {
		return qypxjlBean;
	}

	public void setQypxjlBean(QypxjlBean qypxjlBean) {
		this.qypxjlBean = qypxjlBean;
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

	public String getEnterno() {
		return enterno;
	}

	public void setEnterno(String enterno) {
		this.enterno = enterno;
	}

	
    
	
}
