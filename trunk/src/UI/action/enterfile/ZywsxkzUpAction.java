/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  孙雁斌;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-07     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.enterfile;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import UI.action.upload.FileUploadService;
import UI.dao.enterfile.QyjbqkBean;
import UI.message.MisConstant;
@ParentPackage("struts-filter")
@Namespace("/UI/enterfile/zywsxkz")
public class ZywsxkzUpAction extends BasicAction {

	private static final long serialVersionUID = 572146812454l;
	private static Logger logger = Logger.getLogger(ZywsxkzUpAction.class);
	
	private QyjbqkBean qyjbqkBean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String enterno=""; //企业主键编号
	
	 private File file;

	 private String fileFileName;
	 
	 private File filef;

	 private String filefFileName;
		
	 private String timeseria;
	 

	 /**
		 * 
		 * 查询信息 返回jsp
		 * 
		 * @return
		 */
		@Action(value = "ZywsxkzUpAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/zywsxkz/zywsxkz.jsp") })
		public String findByKey() {
			try {
				qyjbqkBean = new QyjbqkBean();
				qyjbqkBean = (QyjbqkBean) findByKey(qyjbqkBean,
						" where  enterno='" + strSysno + "'");
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
		 * 修改方法
		 * 
		 * @return
		 */
		@Action(value = "ZywsxkzUpAction_update",results = { @Result(name = MisConstant.FINDBYKEY,  location = "/UI/enterfile/zywsxkz/zywsxkz.jsp") })
		public String update() {
			try {
				 if (file != null) {
						//if(Config.getProperty("photoState").equals("1")){
					         FileUploadService fs = new FileUploadService();
					             try {
					            	timeseria=String.valueOf( System.currentTimeMillis());
									String path = fs.uploadFile(file, fileFileName, timeseria, qyjbqkBean.getZywsxkzz());
									qyjbqkBean.setZywsxkzz(path);
									
									
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
							
						}
				 if (filef != null) {
						//if(Config.getProperty("photoState").equals("1")){
					         FileUploadService fs = new FileUploadService();
					             try {
					            	 timeseria=String.valueOf( System.currentTimeMillis());
									 String path = fs.uploadFile(filef, filefFileName, timeseria, qyjbqkBean.getZywsxkzf());
									  qyjbqkBean.setZywsxkzf(path);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
							
						}
				messageBean = update(qyjbqkBean, " where  enterno='"
						+ qyjbqkBean.getEnterno() + "'");
				messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
				messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// 设置错误返回的提示
				logger.error(MisConstant.MSG_OPERATE_FAIL, e);
				messageBean.setCheckFlag(MisConstant.MSG_FAIL);
				messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
			}
			return MisConstant.FINDBYKEY;
		}

	public String getEnterno() {
		return enterno;
	}

	public void setEnterno(String enterno) {
		this.enterno = enterno;
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

	public QyjbqkBean getQyjbqkBean() {
		return qyjbqkBean;
	}

	public void setQyjbqkBean(QyjbqkBean qyjbqkBean) {
		this.qyjbqkBean = qyjbqkBean;
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

	public String getTimeseria() {
		return timeseria;
	}

	public void setTimeseria(String timeseria) {
		this.timeseria = timeseria;
	}

	public File getFilef() {
		return filef;
	}

	public void setFilef(File filef) {
		this.filef = filef;
	}

	public String getFilefFileName() {
		return filefFileName;
	}

	public void setFilefFileName(String filefFileName) {
		this.filefFileName = filefFileName;
	}
	 
	 
	 

}