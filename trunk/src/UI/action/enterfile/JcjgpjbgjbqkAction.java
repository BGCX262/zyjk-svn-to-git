/****************************************************
 * <p>处理内容：评价报告基本情况</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.enterfile;

import java.io.File;

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
import UI.action.upload.FileUploadService;
import UI.dao.enterfile.JcjgpjbgjbqkBean;
import UI.dao.enterfile.QyjbqkBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/Jcjgpjbgjbqk")
public class JcjgpjbgjbqkAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(JcjgpjbgjbqkAction.class);

    private JcjgpjbgjbqkBean jcjgpjbgjbqkbean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String enterno=""; //企业主键编号
	
	private String jsdwbh="";//建设单位编号
	
	private File file;

	private String fileFileName;

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "JcjgpjbgjbqkAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,jcjgpjbgjbqkbean.*" }) })
	public String findObjson() {
		try {
			JcjgpjbgjbqkBean jcjgpjbgjbqkbean = new JcjgpjbgjbqkBean();
			if (!(messageBean.getMethod().equals("add"))) {
				jcjgpjbgjbqkbean = (JcjgpjbgjbqkBean) findByKey(jcjgpjbgjbqkbean,
						" where  sysno='" + strSysno + "'");
				if (jcjgpjbgjbqkbean != null) {
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
	@Action(value = "JcjgpjbgjbqkAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkdetail.jsp") })
	public String findByKey() {
		try {
			jcjgpjbgjbqkbean = new JcjgpjbgjbqkBean();
			jcjgpjbgjbqkbean.setJsdwbh(jsdwbh);	
			
			QyjbqkBean qyBean =new QyjbqkBean();		
			qyBean=qyBean.findFirst(" where enterno='"+ jsdwbh +"'");
			if(null!=qyBean){
                //建设单位名称
				jcjgpjbgjbqkbean.setJsdwmc(qyBean.getDwmc());
			}
			if (!(messageBean.getMethod().equals("add"))) {
				jcjgpjbgjbqkbean = (JcjgpjbgjbqkBean) findByKey(jcjgpjbgjbqkbean,
						" where  sysno='" + strSysno + "'");
				if (jcjgpjbgjbqkbean != null) {
					//messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					//messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
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
	@Action(value = "JcjgpjbgjbqkAction_insert", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkdetail.jsp") })
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
			 if (file != null) {
					//if(Config.getProperty("photoState").equals("1")){
				         FileUploadService fs = new FileUploadService();
				             try {
				            	// timeseria=String.valueOf( System.currentTimeMillis());
								String path = fs.uploadFile(file, fileFileName, "1", "");
								jcjgpjbgjbqkbean.setBgfj(path);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						
					}
			jcjgpjbgjbqkbean.setSysno(number);
			messageBean = insert(jcjgpjbgjbqkbean);
			 //执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(jcjgpjbgjbqkbean, jcjgpjbgjbqkbean.getClass().getName(), "jcjgpjbgjbqk", "sysno", number, "add",cm);
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
		return MisConstant.FINDBYKEY;
	}

	/**
	 * 
	 * 修改方法
	 * 
	 * @return
	 */
	@Action(value = "JcjgpjbgjbqkAction_update", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqkdetail.jsp") })
	public String update() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			if (file != null) {
				//if(Config.getProperty("photoState").equals("1")){
			         FileUploadService fs = new FileUploadService();
			             try {
			            	// timeseria=String.valueOf( System.currentTimeMillis());
							String path = fs.uploadFile(file, fileFileName, "1", jcjgpjbgjbqkbean.getBgfj());
							jcjgpjbgjbqkbean.setBgfj(path);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					
				}

			messageBean = update(jcjgpjbgjbqkbean, " where  sysno='"
					+ jcjgpjbgjbqkbean.getSysno() + "'");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(jcjgpjbgjbqkbean, jcjgpjbgjbqkbean.getClass().getName(), "jcjgpjbgjbqk", "sysno", jcjgpjbgjbqkbean.getSysno(), "update",cm);
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
		return MisConstant.FINDBYKEY;
	}

	/**
	 * 
	 * 删除改方法
	 * 
	 * @return
	 */
	@Action(value = "JcjgpjbgjbqkAction_delete")
	public String delete() {
		 //开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			jcjgpjbgjbqkbean = new JcjgpjbgjbqkBean();
			messageBean = delete(jcjgpjbgjbqkbean, " where  sysno in (" + strSysno + ")");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(jcjgpjbgjbqkbean, jcjgpjbgjbqkbean.getClass().getName(), "jcjgpjbgjbqk", "sysno", strSysno, "delete",cm);
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

	
    
	

	public JcjgpjbgjbqkBean getJcjgpjbgjbqkbean() {
		return jcjgpjbgjbqkbean;
	}

	public void setJcjgpjbgjbqkbean(JcjgpjbgjbqkBean jcjgpjbgjbqkbean) {
		this.jcjgpjbgjbqkbean = jcjgpjbgjbqkbean;
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

	public String getJsdwbh() {
		return jsdwbh;
	}

	public void setJsdwbh(String jsdwbh) {
		this.jsdwbh = jsdwbh;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	

}
