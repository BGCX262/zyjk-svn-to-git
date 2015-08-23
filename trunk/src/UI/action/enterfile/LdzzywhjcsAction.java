/****************************************************
 * <p>处理内容：劳动者职业危害接触史</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.enterfile;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.SerialNumber;
import st.platform.utils.Config;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import worksynch.util.WriteRecordUtil;
import UI.dao.enterfile.QyldzzywhjcsBean;
import UI.dao.enterfile.QyryxxBean;
import UI.dao.enterfile.QyzybfhssBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/ldzzywhjcs")
public class LdzzywhjcsAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(LdzzywhjcsAction.class);

    private QyldzzywhjcsBean  qyldzzywhjcsbean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String ldzbh=""; 

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "LdzzywhjcsAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,qyldzzywhjcsbean.*" }) })
	public String findObjson() {
		try {
			QyldzzywhjcsBean qyldzzywhjcsbean = new QyldzzywhjcsBean();
			if (!(messageBean.getMethod().equals("add"))) {
				qyldzzywhjcsbean = (QyldzzywhjcsBean) findByKey(qyldzzywhjcsbean,
						" where  sysno='" + strSysno + "'");
				if (qyldzzywhjcsbean != null) {
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
	@Action(value = "LdzzywhjcsAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/ldzzywhjcs/ldzzywhjcsdetail.jsp") })
	public String findByKey() {
		try {
			qyldzzywhjcsbean = new QyldzzywhjcsBean();
			qyldzzywhjcsbean.setLdzbh(ldzbh);
//			劳动者姓名
			QyryxxBean qyryBean =new QyryxxBean();		
			qyryBean=qyryBean.findFirst(" where sysno='"+ ldzbh +"'");
			if(null!=qyryBean){
				qyldzzywhjcsbean.setLdzxm(qyryBean.getName());
			}
			
			if (!(messageBean.getMethod().equals("add"))) {
				qyldzzywhjcsbean = (QyldzzywhjcsBean) findByKey(qyldzzywhjcsbean,
						" where  sysno='" + strSysno + "'");
				if (qyldzzywhjcsbean != null) {
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
	@Action(value = "LdzzywhjcsAction_insert")
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
			qyldzzywhjcsbean.setSysno(number);
			messageBean = insert(qyldzzywhjcsbean);
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qyldzzywhjcsbean, qyldzzywhjcsbean.getClass().getName(), "qyldzzywhjcs", "sysno", number, "add",cm);
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
	@Action(value = "LdzzywhjcsAction_update")
	public String update() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {

			messageBean = update(qyldzzywhjcsbean, " where  sysno='"
					+ qyldzzywhjcsbean.getSysno() + "'");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qyldzzywhjcsbean, qyldzzywhjcsbean.getClass().getName(), "qyldzzywhjcs", "sysno", qyldzzywhjcsbean.getSysno(), "update",cm);
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
	@Action(value = "LdzzywhjcsAction_delete")
	public String delete() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			qyldzzywhjcsbean = new QyldzzywhjcsBean();
			messageBean = delete(qyldzzywhjcsbean, " where  sysno in (" + strSysno + ")");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qyldzzywhjcsbean, qyldzzywhjcsbean.getClass().getName(), "qyldzzywhjcs", "sysno", strSysno, "delete",cm);
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

	


	public QyldzzywhjcsBean getQyldzzywhjcsbean() {
		return qyldzzywhjcsbean;
	}

	public void setQyldzzywhjcsbean(QyldzzywhjcsBean qyldzzywhjcsbean) {
		this.qyldzzywhjcsbean = qyldzzywhjcsbean;
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

	public String getLdzbh() {
		return ldzbh;
	}

	public void setLdzbh(String ldzbh) {
		this.ldzbh = ldzbh;
	}

	
	
	

}
