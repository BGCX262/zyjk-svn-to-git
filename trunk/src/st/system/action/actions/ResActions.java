/*********************************************************************
 *<p>处理内容： Action 管理</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.18---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.actions;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.utils.Config;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.system.action.form.CreateJAVAFile;
import st.system.dao.PtactionsBean;
import st.system.dao.PtactionsmtdBean;
import UI.action.demo.DemoAction;
import UI.dao.DemoBean;
import UI.message.MisConstant;

@ParentPackage("struts-filter")
@Namespace("/st/system/action/actions")  
public class ResActions extends BasicAction{

    private static Logger logger = Logger.getLogger(ResActions.class);

    private static final long serialVersionUID = 1L;

    private PtactionsBean ptactionBean; // 返回的信息

    private String strWhere=""; // 查询条件

    private String strSysno=""; // 主键编号

    private PageBean pageBean; // 分页类

    private MessageBean messageBean;// 操作状态
    
    
    /**
     * 添加
     * 
     * @return
     */

    @Action(value = "ResActions_insert")
    public String insert() {
        try {
            String tablename = ptactionBean.getBeanname();
            String classBean = tablename.substring(0, 1).toUpperCase() + tablename.substring(1, tablename.length()).toLowerCase() + "Bean";
            ptactionBean.setBeanname(classBean);
            String number = "PTACTION_"+System.currentTimeMillis();
            ptactionBean.setSysid(number);
            String namespace = "/"+ptactionBean.getActionpath().replaceAll("\\.", "/");
            ptactionBean.setNamespace(namespace);
            messageBean = insert(ptactionBean);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // 设置错误返回的提示
            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
        }
        return MisConstant.RETMESSAGE;
    }

    /**
     * 查询信息
     * 
     * @return
     */
    @Action(value = "ResActions_findByKey", results = {
            @Result(type = "json", name = SUCCESS, params = { "includeProperties", "messageBean.*,ptactionBean.*" }) })
    public String findByKey() {
        try {
            messageBean = new MessageBean();
            ptactionBean = new PtactionsBean();
            ptactionBean = (PtactionsBean) findByKey(ptactionBean, " where sysid ='" + strSysno + "'");
                if (ptactionBean != null) {
                    messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                    messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
                }else{
                    messageBean.setCheckFlag(MisConstant.MSG_FAIL);
                    messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
                }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // 设置错误返回的提示
            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
        }
        return SUCCESS;
    }

    /**
     * 修改
     * 
     * @return
     */
    @Action(value = "ResActions_update")
    public String update() {
           
        logger.debug("修改");
        try {
            //String classBean = tablename.substring(0, 1).toUpperCase() + tablename.substring(1, tablename.length()).toLowerCase() + "Bean";
            String namespace = "/"+ptactionBean.getActionpath().replaceAll("\\.", "/");
            ptactionBean.setNamespace(namespace);
            messageBean = update(ptactionBean, " where sysid ='" + ptactionBean.getSysid() + "'");
      
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // 设置错误返回的提示
            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
        }
        return MisConstant.RETMESSAGE;
    }

    /**
     * 删除
     * 
     * @return
     */
    @Action(value = "ResActions_delete")
    public String delete() {
        try {
            ptactionBean = new PtactionsBean();
            logger.debug(strSysno+"====================");
            System.out.println(" where sysid in (" + strSysno + ")");
            messageBean = delete(ptactionBean, " where sysid in ('" + strSysno + "')");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // 设置错误返回的提示
            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
        }
        return MisConstant.RETMESSAGE;
    }

    /**
     * 创建ACTION
     * @return
     */
    @Action(value = "ResActions_create")
    public String create(){
        try {
            messageBean = new MessageBean();
            ptactionBean = new PtactionsBean();
            ptactionBean = (PtactionsBean) findByKey(ptactionBean, " where sysid ='" + strSysno + "'");
            CreateJAVAFile crjava=new CreateJAVAFile();
            crjava.createJava(ptactionBean);
            messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // 设置错误返回的提示
            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
        }
        return MisConstant.RETMESSAGE;
        
        
    }
    
    /**
     *初始化
     * @return
     */
    @Action(value = "ResActions_init")
    public String init(){
        try {
            messageBean = new MessageBean();
            String engPath = Config.getProperty("file");
            File file = new File(engPath+"/src/");
//          清空action的记录
            PtactionsmtdBean method = new PtactionsmtdBean();
            PtactionsBean actionBean = new PtactionsBean();
            method.deleteByWhere("");
            actionBean.deleteByWhere("");
            
            CollectAction co = new CollectAction();
            co.method(file);
            
            messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // 设置错误返回的提示
            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
        }
        return MisConstant.RETMESSAGE;
        
        
    }
  

    public PtactionsBean getPtactionBean() {
        return ptactionBean;
    }

    public void setPtactionBean(PtactionsBean ptactionBean) {
        this.ptactionBean = ptactionBean;
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
    
    
    
    
}
