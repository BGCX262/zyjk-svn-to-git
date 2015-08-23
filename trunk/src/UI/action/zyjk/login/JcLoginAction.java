package UI.action.zyjk.login;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import st.platform.security.SystemAttributeNames;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.system.action.login.LoginAction;
import UI.dao.zyjk.T_officerBean;
import UI.message.MisConstant;

@ParentPackage("struts-filter")
@Namespace("/UI/zyjk/jclogin")  
public class JcLoginAction extends BasicAction{
	 private static Logger logger = Logger.getLogger(LoginAction.class);

	    private static final long serialVersionUID = 1L;

	    private T_officerBean officerBean;
	    
	    private MessageBean messageBean = new MessageBean();// 操作状态
	    
	    private String strWhere="";
	    
	    private String opernm="";
	    
	    private String passwd="";
	    
	    /**
	     * 检查登陆 
	     */
	    @Action(value = "JcLoginAction_check")
	    public String check(){
	        try {
	            ServletActionContext.getContext().getSession().put("login", "false");
	            if(null==officerBean){
	            	officerBean=new T_officerBean();
	            }
	            
	            // 判断用户姓名和密码是否一致
	            // 判断账户是否已经停用
	            if (  null==officerBean.getOfficer_name() || null==officerBean.getC_pwd()||officerBean.getOfficer_name().equals("") ||officerBean.getC_pwd().equals("")  ) {
	                return LOGIN;
	            } else {
	            	strWhere = " where officer_name='" + officerBean.getOfficer_name() + "' and c_pwd='" + officerBean.getC_pwd() + "' and dept_type='2'";
	            }
	            
	            //如果用户名和密码正确
	            officerBean=officerBean.findFirst(strWhere);
	            
	           
	            Map<String,Object> map;
	            if (officerBean != null) {
	            	ServletActionContext.getContext().getSession().put(SystemAttributeNames.JCJG_INFO_NAME, officerBean);  
	            	ServletActionContext.getContext().getSession().put(SystemAttributeNames.OPER_TYPE,"2");
	                messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
	                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
	            }else{
	                messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	            }
	        }catch (Exception e) {
	            // TODO Auto-generated catch block
	            // 设置错误返回的提示
	            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
	            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	        }
	        
	        return MisConstant.RETMESSAGE;
	    }
	    /**
	     * 注销
	     * @return
	     */
	    @Action(value = "JcLoginAction_remove")
	    public String remove() {
	        // 注销情况session
	        try
	        {
	            ServletActionContext.getContext().getSession().clear();
	            return SUCCESS;
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            logger.error(MisConstant.MSG_NO_DATA, e);
	        }
	        return SUCCESS;
	    }
	    

	    /**
	     * 修改密码
	     * @return 分别对返回类型为sucess和error设置返回的对象格式<br>
	     *         自定义返回对象checkResult
	     */
	    @Action(value = "JcLoginAction_editPassWord")
	    public String editPassWord() {
	    	
			try {

				
				messageBean = update(officerBean, " where  officer_id='"+ officerBean.getOfficer_id() + "'");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				// 设置错误返回的提示
				logger.error(MisConstant.MSG_OPERATE_FAIL, e);
				messageBean.setCheckFlag(MisConstant.MSG_FAIL);
				messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
			}
			 return MisConstant.RETMESSAGE;
	    }

		public MessageBean getMessageBean() {
			return messageBean;
		}

		public void setMessageBean(MessageBean messageBean) {
			this.messageBean = messageBean;
		}

		public T_officerBean getOfficerBean() {
			return officerBean;
		}

		public void setOfficerBean(T_officerBean officerBean) {
			this.officerBean = officerBean;
		}

		public String getOpernm() {
			return opernm;
		}

		public void setOpernm(String opernm) {
			this.opernm = opernm;
		}

		public String getPasswd() {
			return passwd;
		}

		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}

		public String getStrWhere() {
			return strWhere;
		}

		public void setStrWhere(String strWhere) {
			this.strWhere = strWhere;
		}
	    
	    
}
