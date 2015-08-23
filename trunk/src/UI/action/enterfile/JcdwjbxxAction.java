/****************************************************
 * <p>处理内容：被检测单位基本信息</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.enterfile;

import java.sql.SQLException;

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
import UI.dao.enterfile.JcdwjbxxBean;
import UI.dao.enterfile.JcpjjyxxBean;
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.enterfile.QyldzzysBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/jcdwjbxx")
public class JcdwjbxxAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(JcdwjbxxAction.class);

    private JcdwjbxxBean jcdwjbxxbean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String dwbh="";  //单位编号 
	
	private String bgbh="";  //报告编号
	
	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "JcdwjbxxAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,jcdwjbxxbean.*" }) })
	public String findObjson() {
		try {
			JcdwjbxxBean jcdwjbxxbean = new JcdwjbxxBean();
			if (!(messageBean.getMethod().equals("add"))) {
				jcdwjbxxbean = (JcdwjbxxBean) findByKey(jcdwjbxxbean,
						" where  sysno='" + strSysno + "'");
				if (jcdwjbxxbean != null) {
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
	@Action(value = "JcdwjbxxAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/jcdwjbxx/jcdwjbxxdetail.jsp") })
	public String findByKey() {
		try {
			jcdwjbxxbean = new JcdwjbxxBean();
			jcdwjbxxbean.setDwbh(dwbh);
			jcdwjbxxbean.setBgbh(bgbh);
			QyjbqkBean qyBean =new QyjbqkBean();		
			qyBean=qyBean.findFirst(" where enterno='"+ dwbh +"'");
			if(null!=qyBean){
                //建设单位名称
				jcdwjbxxbean.setDwmc(qyBean.getDwmc());
				//单位地址
				jcdwjbxxbean.setDwdz(qyBean.getZcdz());
				//所属行业
				jcdwjbxxbean.setSshy(qyBean.getHyfl());
				//员工总数
				jcdwjbxxbean.setYgrs(qyBean.getNmzgrs());
				//企业性质
				jcdwjbxxbean.setQyxz(qyBean.getZclx());
				//体检单位
				jcdwjbxxbean.setTjdwmc(qyBean.getGltijianjg());
			}
			if (!(messageBean.getMethod().equals("add"))) {
				jcdwjbxxbean = (JcdwjbxxBean) findByKey(jcdwjbxxbean,
						" where  bgbh='" + bgbh + "' and dwbh='"+ dwbh +"'" );
				if (jcdwjbxxbean != null) {
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
	@Action(value = "JcdwjbxxAction_insert")
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
			jcdwjbxxbean.setSysno(number);
			messageBean = insert(jcdwjbxxbean);
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(jcdwjbxxbean, jcdwjbxxbean.getClass().getName(), "jcdwjbxx", "sysno", number, "add",cm);
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
	@Action(value = "JcdwjbxxAction_update")
	public String update() {
        //开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {

			messageBean = update(jcdwjbxxbean, " where  sysno='"
					+ jcdwjbxxbean.getSysno() + "'");
            //执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(jcdwjbxxbean, jcdwjbxxbean.getClass().getName(), "jcdwjbxx", "sysno", jcdwjbxxbean.getSysno(), "update",cm);
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
	@Action(value = "JcdwjbxxAction_delete")
	public String delete() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			jcdwjbxxbean = new JcdwjbxxBean();
			messageBean = delete(jcdwjbxxbean, " where  sysno in (" + strSysno + ")");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(jcdwjbxxbean, jcdwjbxxbean.getClass().getName(), "jcdwjbxx", "sysno", strSysno, "delete",cm);
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
     * 根据jcpjjyxx表是否有记录来决定是增加操作还是修改操作
     * @return
     * @throws SQLException
     * @throws Exception
     */
	@Action(value = "LoginAction_loadDlxx")
    public String loadDlxx() throws SQLException, Exception {
    	try{
    				
    		JcdwjbxxBean jcdwjbxxbean = new JcdwjbxxBean();
    		jcdwjbxxbean=jcdwjbxxbean.findFirst(" where bgbh='"+ bgbh +"'");
    		if(null==messageBean){
    			messageBean=new MessageBean();	
    		}
    		
    		if (null !=jcdwjbxxbean ) {

    			// 设置正确返回的提示
    			messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
    		} else {
    			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
            logger.error(MisConstant.MSG_NO_DATA, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
    		
    	}
		
		return MisConstant.RETMESSAGE;
	}

	public JcdwjbxxBean getJcdwjbxxbean() {
		return jcdwjbxxbean;
	}

	public void setJcdwjbxxbean(JcdwjbxxBean jcdwjbxxbean) {
		this.jcdwjbxxbean = jcdwjbxxbean;
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

	public String getDwbh() {
		return dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}


}
