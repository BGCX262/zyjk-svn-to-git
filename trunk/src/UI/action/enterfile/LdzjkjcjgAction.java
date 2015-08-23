/****************************************************
 * <p>处理内容：职业卫生健康检查结果</p>
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
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.enterfile.QyryxxBean;
import UI.dao.enterfile.QyzywsjkjcjgBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/ldzjkjcjg")
public class LdzjkjcjgAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(LdzjkjcjgAction.class);
    
	private QyzywsjkjcjgBean qyzywsjkjcjgbean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String ldzbh="";   //劳动者编号
	
	private String enterno=""; //企业编号
    
	private String tjdwbh="";  //体检单位编号
	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "LdzjkjcjgAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,qyzywsjkjcjgbean.*" }) })
	public String findObjson() {
		try {
			QyzywsjkjcjgBean qyzywsjkjcjgbean = new QyzywsjkjcjgBean();
			if (!(messageBean.getMethod().equals("add"))) {
				qyzywsjkjcjgbean = (QyzywsjkjcjgBean) findByKey(qyzywsjkjcjgbean,
						" where  sysno='" + strSysno + "'");
				if (qyzywsjkjcjgbean != null) {
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
	@Action(value = "LdzjkjcjgAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/ldzjkjcjg/ldzjkjcjgdetail.jsp") })
	public String findByKey() {
		try {
			qyzywsjkjcjgbean = new QyzywsjkjcjgBean();
			
			qyzywsjkjcjgbean.setLdzbh(ldzbh);
			qyzywsjkjcjgbean.setEnterno(enterno);
			qyzywsjkjcjgbean.setTjdwbh(tjdwbh);
            //劳动者姓名
			QyryxxBean qyryBean =new QyryxxBean();		
			qyryBean=qyryBean.findFirst(" where sysno='"+ ldzbh +"'");
			if(null!=qyryBean){
				qyzywsjkjcjgbean.setLdzxm(qyryBean.getName());
			}
           //检查单位名称
			QyjbqkBean qyBean=new QyjbqkBean();
			qyBean=qyBean.findFirst(" where enterno='"+ enterno +"'");
			if(null!=qyBean){
				qyzywsjkjcjgbean.setEntername(qyBean.getDwmc());
			}
			if (!(messageBean.getMethod().equals("add"))) {
				qyzywsjkjcjgbean = (QyzywsjkjcjgBean) findByKey(qyzywsjkjcjgbean,
						" where  sysno='" + strSysno + "'");
				if (qyzywsjkjcjgbean != null) {
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
	 * @return
	 */
	@Action(value = "LdzjkjcjgAction_loginFindByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/wsjg/tjqk/tjqkinfo.jsp") })
	public String loginFindByKey() {
		try {
			qyzywsjkjcjgbean = new QyzywsjkjcjgBean();
			
			qyzywsjkjcjgbean.setLdzbh(ldzbh);
			qyzywsjkjcjgbean.setEnterno(enterno);
			qyzywsjkjcjgbean.setTjdwbh(tjdwbh);
			
			if (!(messageBean.getMethod().equals("add"))) {
				qyzywsjkjcjgbean = (QyzywsjkjcjgBean) findByKey(qyzywsjkjcjgbean,
						" where  sysno='" + strSysno + "'");
				if (qyzywsjkjcjgbean != null) {
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
	@Action(value = "LdzjkjcjgAction_insert")
	public String insert() {
		 //开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			qyzywsjkjcjgbean.setSysno(number);
			messageBean = insert(qyzywsjkjcjgbean);
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qyzywsjkjcjgbean, qyzywsjkjcjgbean.getClass().getName(), "qyzywsjkjcjg", "sysno", number, "add",cm);
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
	@Action(value = "LdzjkjcjgAction_update")
	public String update() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {

			messageBean = update(qyzywsjkjcjgbean, " where  sysno='"
					+ qyzywsjkjcjgbean.getSysno() + "'");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qyzywsjkjcjgbean, qyzywsjkjcjgbean.getClass().getName(), "qyzywsjkjcjg", "sysno", qyzywsjkjcjgbean.getSysno(), "update",cm);
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
	@Action(value = "LdzjkjcjgAction_delete")
	public String delete() {
		 //开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			qyzywsjkjcjgbean = new QyzywsjkjcjgBean();
			messageBean = delete(qyzywsjkjcjgbean, " where  sysno in (" + strSysno + ")");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qyzywsjkjcjgbean, qyzywsjkjcjgbean.getClass().getName(), "qyzywsjkjcjg", "sysno", strSysno, "delete",cm);
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

	
    

	public QyzywsjkjcjgBean getQyzywsjkjcjgbean() {
		return qyzywsjkjcjgbean;
	}

	public void setQyzywsjkjcjgbean(QyzywsjkjcjgBean qyzywsjkjcjgbean) {
		this.qyzywsjkjcjgbean = qyzywsjkjcjgbean;
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

	public String getEnterno() {
		return enterno;
	}

	public void setEnterno(String enterno) {
		this.enterno = enterno;
	}

	public String getTjdwbh() {
		return tjdwbh;
	}

	public void setTjdwbh(String tjdwbh) {
		this.tjdwbh = tjdwbh;
	}

	
	
	

}
