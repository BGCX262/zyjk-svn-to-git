/*********************************************************************
 *<p>处理内容： 系统登陆管理</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.18---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.login;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import st.platform.db.sql.AbstractBasicBean;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.system.dao.PtdeptBean;
import st.system.dao.PtoperBean;
import UI.message.MisConstant;
import st.platform.security.SystemAttributeNames;




@ParentPackage("struts-filter")
@Namespace("/st/system/action/login")  
public class LoginAction extends BasicAction{

    private static Logger logger = Logger.getLogger(LoginAction.class);

    private static final long serialVersionUID = 1L;

    private PtoperBean ptoperBean = new PtoperBean(); //人员信息
    
    private PtdeptBean ptdeptBean =new PtdeptBean();  //部门信息
    
    private MessageBean messageBean = new MessageBean();// 操作状态
    
    private String strWhere="";
    
    private String opernm="";
    
    private String passwd="";
    /**
     * 检查登陆 
     */
    @Action(value = "LoginAction_check")
    public String check(){
        try {
            ServletActionContext.getContext().getSession().put("login", "false"); 
            
            // 判断用户姓名和密码是否一致
            // 判断账户是否已经停用
            if (  null==ptoperBean.getOpernm() || null==ptoperBean.getPasswd()||ptoperBean.getOpernm().equals("") ||ptoperBean.getPasswd().equals("")  ) {
                return LOGIN;
            } else {
            	strWhere = " where opernm='" + ptoperBean.getOpernm() + "' and passwd='" + ptoperBean.getPasswd() + "' and  deptid='"+ptoperBean.getDeptid()+"'";
            }
            
            //如果用户名和密码正确
            ptoperBean=ptoperBean.findFirst(strWhere);
            
            String sSqlWhere=" where deptno='"+ ptoperBean.getDeptid() +"'";
            ptdeptBean=ptdeptBean.findFirst(sSqlWhere);
            Map<String,Object> map;
            if (ptoperBean != null) {
            	ServletActionContext.getContext().getSession().put(SystemAttributeNames.USER_INFO_NAME, ptoperBean);  
                ServletActionContext.getContext().getSession().put(SystemAttributeNames.DEPT_INFO_NAME,ptdeptBean);  
                ServletActionContext.getContext().getSession().put(SystemAttributeNames.OPER_TYPE,"1");
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
    @Action(value = "LoginAction_remove")
    public String remove() {
        // 注销情况session
        try
        {   
            ServletActionContext.getContext().getSession().clear();
            messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
            //return SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error(MisConstant.MSG_NO_DATA, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
        }
        
        return  MisConstant.RETMESSAGE;
    }
    

    /**
     * 修改密码
     * @return 分别对返回类型为sucess和error设置返回的对象格式<br>
     *         自定义返回对象checkResult
     */
    @Action(value = "LoginAction_editPassWord")
    public String editPassWord() {
    	
		try {

			
			messageBean = update(ptoperBean, " where  sysno='"+ ptoperBean.getSysno() + "'");

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
	
	public PtoperBean getPtoperBean() {
		return ptoperBean;
	}
	public void setPtoperBean(PtoperBean ptoperBean) {
		this.ptoperBean = ptoperBean;
	}
	public String getStrWhere() {
		return strWhere;
	}
	public void setStrWhere(String strWhere) {
		this.strWhere = strWhere;
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
	
	public PtdeptBean getPtdeptBean() {
		return ptdeptBean;
	}
	public void setPtdeptBean(PtdeptBean ptdeptBean) {
		this.ptdeptBean = ptdeptBean;
	}
    
    
    
}
