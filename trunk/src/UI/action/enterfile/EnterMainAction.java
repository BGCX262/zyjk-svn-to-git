/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  孙雁斌;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-22     孙雁斌          新規作成 ;
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
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.enterfile.QywsgljgBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/enterfile")
public class EnterMainAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(EnterMainAction.class);

	//private QyjbqkBean qyjbqkBean; 
	private QyjbqkBean qyjbqkBean; // 返回的信息;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "EnterMain_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,qyjbqkBean.*" }) })
	public String findObjson() {
		try {
			qyjbqkBean = new QyjbqkBean();
			if (!(messageBean.getMethod().equals("add"))) {
				qyjbqkBean = (QyjbqkBean) findByKey(qyjbqkBean,
						" where enterno ='" + strSysno + "'");
				if (qyjbqkBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean
							.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
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
	@Action(value = "EnterMain_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/enterinfo.jsp") })
	public String findByKey() {
		try {
			qyjbqkBean = new QyjbqkBean();
			if (!(messageBean.getMethod().equals("add"))) {
				qyjbqkBean = (QyjbqkBean) findByKey(qyjbqkBean,
						" where enterno ='" + strSysno + "'");
				if (qyjbqkBean != null) {
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
	@Action(value = "EnterMain_insert")
	public String insert() {
        //开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count1=0;
        int count2=0;
		try {
			String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			qyjbqkBean.setEnterno(number);
			MessageBean qymessageBean = insert(qyjbqkBean);
			
			//企业卫生机构
			QywsgljgBean wsjgBean=new QywsgljgBean();
			String wsjgno=Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
			+ SerialNumber.getNextSerialNo("67");
			wsjgBean.setJgmc(qyjbqkBean.getZywsjg());//机构名称
			if(null!=qyjbqkBean.getZywsjg()&&!"".equals(qyjbqkBean.getZywsjg())){
				wsjgBean.setSysno(wsjgno);   //主键
				wsjgBean.setEnterno(number);  //单位编号
				wsjgBean.setZzfzrs(qyjbqkBean.getZywsgl());//专职负责人数
				wsjgBean.setJzfzrs(qyjbqkBean.getSwrenshuxz());//兼职负责人数
				wsjgBean.setJgfzr(qyjbqkBean.getZywsfzr());//机构负责人
				wsjgBean.setJgfzrdh(qyjbqkBean.getZywslxdh());//机构负责人电话
				MessageBean wsmessageBean = insert(wsjgBean);
				count2=wsmessageBean.getCheckFlag();
			}
			
			
            //执行同步操作
			count1=qymessageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count1==1&&count2==1){
					WriteRecordUtil.write(qyjbqkBean, qyjbqkBean.getClass().getName(), "qyjbqk", "enterno", number, "add",cm);
					WriteRecordUtil.write(wsjgBean, wsjgBean.getClass().getName(), "qywsgljg", "sysno", wsjgno, "add",cm);
				}
			}
//			单位主键
			messageBean.setWidgetValue(number);
			messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
			//关闭线程
			 if ( count1 > 0&& count2 > 0 ) {
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
	@Action(value = "EnterMain_update")
	public String update() {
        //开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count1=0;
        int count2=0;
		try {

			MessageBean	qymessageBean = update(qyjbqkBean, " where enterno ='"
					+ qyjbqkBean.getEnterno() + "'");
//			企业卫生机构
			
			QywsgljgBean wsjgBean=new QywsgljgBean();
			wsjgBean=wsjgBean.findFirst(" where enterno='"+ qyjbqkBean.getEnterno() +"'");
			wsjgBean.setJgmc(qyjbqkBean.getZywsjg());//机构名称
			if(null!=qyjbqkBean.getZywsjg()&&!"".equals(qyjbqkBean.getZywsjg())){
				//wsjgBean.setSysno(wsjgno);   //主键
				wsjgBean.setEnterno(qyjbqkBean.getEnterno());  //单位编号
				wsjgBean.setZzfzrs(qyjbqkBean.getZywsgl());//专职负责人数
				wsjgBean.setJzfzrs(qyjbqkBean.getSwrenshuxz());//兼职负责人数
				wsjgBean.setJgfzr(qyjbqkBean.getZywsfzr());//机构负责人
				wsjgBean.setJgfzrdh(qyjbqkBean.getZywslxdh());//机构负责人电话
				MessageBean wsmessageBean = update(wsjgBean, " where enterno ='"
						+ qyjbqkBean.getEnterno() + "'");
				count2=wsmessageBean.getCheckFlag();
			}
			
            //执行同步操作
			count1=qymessageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count2==1&&count1==1){
					WriteRecordUtil.write(qyjbqkBean, qyjbqkBean.getClass().getName(), "qyjbqk", "enterno", qyjbqkBean.getEnterno(), "update",cm);
					WriteRecordUtil.write(wsjgBean, wsjgBean.getClass().getName(), "qywsgljg", "sysno", wsjgBean.getSysno(), "update",cm);
				}
			}
             //单位主键
			 messageBean.setWidgetValue(qyjbqkBean.getEnterno());
			 messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
			 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
            //关闭线程
			 if ( count2 > 0&&count1 > 0 ) {
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
	@Action(value = "EnterMain_delete")
	public String delete() {
        //开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count1=0;
        int count2=0;
		try {
			qyjbqkBean = new QyjbqkBean();
			MessageBean qymessageBean = delete(qyjbqkBean, " where enterno in (" + strSysno + ")");
            //企业卫生机构
			QywsgljgBean wsjgBean=new QywsgljgBean();
			MessageBean wsmessageBean = delete(wsjgBean, " where enterno in (" + strSysno + ")");
			
			
            //执行同步操作
			count1=qymessageBean.getCheckFlag();
			count2=wsmessageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count1==1&&count2 > 0){
					WriteRecordUtil.write(qyjbqkBean, qyjbqkBean.getClass().getName(), "qyjbqk", "enterno", strSysno, "delete",cm);
					WriteRecordUtil.write(wsjgBean, wsjgBean.getClass().getName(), "qywsgljg", "enterno", strSysno, "delete",cm);
					
				}
			}
			 messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
			 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
             //关闭线程
			 if ( count1 > 0&&count2 > 0 ) {
                 dc.commit();
            } else {
                 dc.rollback();
            }
			cm.release();
		}
		return MisConstant.RETMESSAGE;
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

	public QyjbqkBean getQyjbqkBean() {
		return qyjbqkBean;
	}

	public void setQyjbqkBean(QyjbqkBean qyjbqkBean) {
		this.qyjbqkBean = qyjbqkBean;
	}
    
	
}
