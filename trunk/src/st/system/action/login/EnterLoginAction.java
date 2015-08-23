/*********************************************************************
 *<p>处理内容： 企业登陆管理</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.6.7---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.login;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import st.platform.security.SystemAttributeNames;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.zyjk.JcjgbaxxBean;
import UI.dao.zyjk.PxjgbaxxBean;
import UI.dao.zyjk.T_officerBean;
import UI.dao.zyjk.WsjgbaxxBean;
import UI.message.MisConstant;




@ParentPackage("struts-filter")
@Namespace("/st/system/action/enterlogin")  
public class EnterLoginAction extends BasicAction{

    private static Logger logger = Logger.getLogger(EnterLoginAction.class);

    private static final long serialVersionUID = 1L;

    private T_officerBean officerBean = new T_officerBean(); //人员信息
        
    private MessageBean messageBean = new MessageBean();// 操作状态
    
    private String strWhere="";
    
    private String Officer_Name="";
    
    private String C_PWD="";
    
    private String sysno="";
    
    private String rand="";
    

    
    
	/**
     * 检查登陆 
     */
    @Action(value = "EnterLoginAction_check")
    public String check(){
        try {
            ServletActionContext.getContext().getSession().put("login", "false"); 
            
            
            
            //验证码
            String randv=(String)ServletActionContext.getContext().getSession().get("rand");
            if(!rand.equals(randv)){

            	messageBean.setCheckFlag(MisConstant.MSG_FAIL);
                messageBean.setCheckMessage(MisConstant.MSG_VERI_FAIL);
            	return MisConstant.RETMESSAGE;
            }
            // 判断用户姓名和密码是否一致
            
            // 判断账户是否已经停用
            if (  null==officerBean.getOfficer_name()|| null==officerBean.getC_pwd()||officerBean.getOfficer_name().equals("") ||officerBean.getC_pwd().equals("")  ) {
                return MisConstant.RETMESSAGE;
            } else {
            	strWhere = " where officer_name='" + officerBean.getOfficer_name() + "' and c_pwd='" + officerBean.getC_pwd() + "'";
            }
            
            //如果用户名和密码正确
            officerBean=officerBean.findFirst(strWhere);
            
            String corpkey=officerBean.getLogin_id();
            
            
            JcjgbaxxBean jcjgBean=new JcjgbaxxBean();
            
            
            PxjgbaxxBean pxjgBean=new PxjgbaxxBean();
            
            
            WsjgbaxxBean wsjgBean=new WsjgbaxxBean();
            
            
            QyjbqkBean qyBean=new QyjbqkBean();
            
            if (officerBean != null) {
            	

            	ServletActionContext.getContext().getSession().put(SystemAttributeNames.CORP_INFO_NAME, officerBean); 
            	
            	ServletActionContext.getContext().getSession().put(SystemAttributeNames.OPER_TYPE,"2");
                
                QyjbqkBean jbqkBean=new QyjbqkBean();
                
                
                //判断登陆用户类型
  			    String dept_type=officerBean.getDept_type();
  			    messageBean.setWidgetValue(dept_type);
            	messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
                
                corpkey=officerBean.getLogin_id();
    			qyBean=qyBean.findFirst(" where corpkey='"+ corpkey +"'");

    			
    			
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
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error(MisConstant.MSG_NO_DATA, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
        }
        return MisConstant.RETMESSAGE;
    }
    
    
    /**
     * 
     * @return 判断企业端初始登陆状态
     * @throws SQLException
     * @throws Exception
     */
    @Action(value = "LoginAction_loadDlxx")
    public String loadDlxx() throws SQLException, Exception {
    	try{
    		
    		officerBean=(T_officerBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.CORP_INFO_NAME);
    		
    		QyjbqkBean qyBean=new QyjbqkBean();
    		    		
    		if (officerBean != null) {
    			//String corpkey=officerBean.getLogin_id();
    			//qyBean=qyBean.findFirst(" where corpkey='"+ corpkey +"'");
        		//String enterno=qyBean.getEnterno();
        		//System.out.println("企业主键名"+enterno);
        		//messageBean.setWidgetValue(enterno);
   
                //判断登陆用户类型
   			     String dept_type=officerBean.getDept_type();
   			     messageBean.setWidgetValue(dept_type);

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
    
    /**
     * 
     * @return
     * @throws SQLException
     * @throws Exception
     */
    @Action(value = "LoginAction_loadQyxx")
    public String loadQyxx() throws SQLException, Exception {
    	try{
    		

    		officerBean=(T_officerBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.CORP_INFO_NAME);
    		//状态
    		String type=officerBean.getDept_type();
    		//corpkey
    		String corpkey=officerBean.getLogin_id();
    		QyjbqkBean qyBean=new QyjbqkBean();
    		JcjgbaxxBean jcBean=new JcjgbaxxBean();
    		PxjgbaxxBean pxBean=new PxjgbaxxBean();
    		WsjgbaxxBean wsBean=new WsjgbaxxBean();
    		//企业
    		qyBean=qyBean.findFirst(" where corpkey='"+ corpkey +"'");
    		//检测
    		jcBean=jcBean.findFirst(" where sysno='"+ corpkey +"'");
    		//培训
    		pxBean=pxBean.findFirst(" where sysno='"+ corpkey +"'");
    		//卫生
    		wsBean=wsBean.findFirst(" where sysno='"+ corpkey +"'");
    		//判断是否已经保存
    		String flag="";
    		if(type.equals("1")&&qyBean != null){
    			flag="2";
    			
    		}else if(type.equals("2")&&jcBean != null){
    			flag="2";
    		}else if(type.equals("3")&&pxBean != null){
    			flag="2";
    		}else if(type.equals("4")&&wsBean != null){
    			flag="2";
    		}
    		
    		
    		
    		
    		if (flag.equals("2")) {
    			
    			// 设置正确返回的提示
    			if(type.equals("1")&&qyBean != null){
    				String enterno=qyBean.getEnterno();
        			messageBean.setWidgetValue(enterno);	
    			}
    			
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
    
    
    
    

    /**
     * 修改密码
     * @return 分别对返回类型为sucess和error设置返回的对象格式<br>
     *         自定义返回对象checkResult
     */
    @Action(value = "LoginAction_editPassWord")
    public String editPassWord() {
    	
		try {

			//officerBean=officerBean.findFirst(" where  officer_id='"+ officerBean.getOfficer_id() + "'");
			
			messageBean = update(officerBean, " where  officer_id='"+ sysno + "'");

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
	
	public String getStrWhere() {
		return strWhere;
	}
	public void setStrWhere(String strWhere) {
		this.strWhere = strWhere;
	}
	public String getC_PWD() {
		return C_PWD;
	}
	public void setC_PWD(String c_pwd) {
		C_PWD = c_pwd;
	}
	public String getOfficer_Name() {
		return Officer_Name;
	}
	public void setOfficer_Name(String officer_Name) {
		Officer_Name = officer_Name;
	}
	public T_officerBean getOfficerBean() {
		return officerBean;
	}
	public void setOfficerBean(T_officerBean officerBean) {
		this.officerBean = officerBean;
	}
	
    
	public String getSysno() {
		return sysno;
	}
	public void setSysno(String sysno) {
		this.sysno = sysno;
	}
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
    
	
	
}
