/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-05               新規作成 ;
 ****************************************************/
package UI.action.news;





 import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import st.platform.db.SerialNumber;
import st.platform.utils.Config;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import UI.action.upload.FileUploadService;
import UI.dao.zyjk.NewsBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
@ParentPackage("struts-filter")
@Namespace("/UI/action/qynews") 
public class QyNewsAction extends BasicAction {


	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(QyNewsAction.class);
	 private NewsBean newsBean; // 返回的信息;

	 private String strWhere=""; // 查询条件;

	 private String strSysno=""; // 主键编号;

	 private PageBean pageBean; // 分页类;

	 private MessageBean messageBean;// 操作状态
	 
	 private File file;

	 private String fileFileName;
		
	 private String timeseria;

	/**
	*  
	* 查询信息 返回json信息
	* @return 
	*/  
	 @Action(value = "NewsAction_findObjson", results = { 
	  @Result(type = "json", name = MisConstant.FINDOBJSON, params = { "includeProperties","messageBean.*,newsBean.*" }) }) 
   public String findObjson() {
	 try {
	 newsBean = new NewsBean();
	  if (!(messageBean.getMethod().equals("add"))) {
	  newsBean = (NewsBean)findByKey(newsBean, " where sysno ='" + strSysno + "'");
	  if (newsBean != null) {
	  messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
	  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
	   }else{
	  messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	   }
	   }
	 } catch (Exception e) {;
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
	* @return 
	*/  
	 @Action(value = "NewsAction_findByKey", results = { 
	   @Result(name = MisConstant.FINDBYKEY, location = "/UI/qynews/newslookinfo.jsp") }) 
   public String findByKey() {
	 try {
	 newsBean = new NewsBean();
	  if (!(messageBean.getMethod().equals("add"))) {
	  newsBean = (NewsBean)findByKey(newsBean, " where sysno ='" + strSysno + "'");
	  if (newsBean != null) {
	  messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
	  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
	   }else{
	  messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	   }
	   }
	 } catch (Exception e) {;
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
	*添加方法
	* @return 
	*/  
	 @Action(value = "NewsAction_insert", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/news/newsinfo.jsp") })  
   public String insert() {
		 
	 try {
	HttpServletResponse response=ServletActionContext.getResponse();	 
	response.setContentType("text/html;charset=utf-8");  
	  String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-" + SerialNumber.getNextSerialNo("67");
	  //newsBean.setTitle(number);
	  newsBean.setSysno(number);
	  
	  if (file != null) {
			//if(Config.getProperty("photoState").equals("1")){
		         FileUploadService fs = new FileUploadService();
		             try {
		            	 timeseria=String.valueOf( System.currentTimeMillis());
						String path = fs.uploadHeadIcon(file, fileFileName, timeseria, "");
						newsBean.setPath(path);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				
			}
	  
	  messageBean = insert(newsBean);
	  //RenderUtils.renderHtml(response, json.toString(), "no-cache:false"); 
	 } catch (Exception e) {;
	 // TODO Auto-generated catch block
	 // 设置错误返回的提示
	 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
	 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	 }
//	 HttpServletResponse response=ServletActionContext.getResponse();	 
//		response.setContentType("text/html;charset=utf-8"); 
	 return MisConstant.FINDBYKEY;
		}

	/**
	*  
	* 修改方法
	* @return 
	*/  
	 @Action(value = "NewsAction_update", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/news/newsinfo.jsp") })  
   public String update() {
	 try {
		
		  if (file != null) {
				//if(Config.getProperty("photoState").equals("1")){
			         FileUploadService fs = new FileUploadService();
			             try {
			            	 NewsBean news=new NewsBean();
			        		 news=news.findFirst(" where sysno ='" + newsBean.getSysno() + "'");
			        		 if(null==news){
			        			 news=new NewsBean();
			        		 }
			            	 timeseria=String.valueOf( System.currentTimeMillis());
							String path = fs.uploadHeadIcon(file, fileFileName, timeseria, news.getPath());
							newsBean.setPath(path);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					
				}
	  messageBean =  update(newsBean, " where sysno ='" + newsBean.getSysno() + "'");;
	 
	 } catch (Exception e) {;
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
	* @return 
	*/  
	 @Action(value = "NewsAction_delete") 
   public String delete() {
	 try {
	 newsBean = new NewsBean();
	  messageBean =  delete(newsBean, " where  sysno in (" + strSysno + ")");
	 
	 } catch (Exception e) {;
	 // TODO Auto-generated catch block
	 // 设置错误返回的提示
	 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
	 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	 }
	 return MisConstant.RETMESSAGE;
		}

	 public NewsBean getNewsBean() {
	 return newsBean;
	 }
	 
	  public void setNewsBean(NewsBean newsBean) {
	  this.newsBean = newsBean;
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

	public String getTimeseria() {
		return timeseria;
	}

	public void setTimeseria(String timeseria) {
		this.timeseria = timeseria;
	}
	  
	  
	 
}
