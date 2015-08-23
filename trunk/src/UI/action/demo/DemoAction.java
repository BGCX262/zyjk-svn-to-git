/*********************************************************************
 *<p>处理内容：demo Action</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package UI.action.demo;



import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.SerialNumber;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import UI.dao.DemoBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
@ParentPackage("struts-filter")
@Namespace("/UI/action/demo")  
public class DemoAction extends BasicAction {

    private static Logger logger = Logger.getLogger(DemoAction.class);

    private static final long serialVersionUID = 1L;

    private DemoBean demoBean; // 返回的信息

    private String strWhere=""; // 查询条件

    private String strSysno=""; // 主键编号

    private MessageBean messageBean;// 操作状态
    

    /**
     * 查询信息
     * 
     * @return
     */
    @Action(value = "demo_findByKey", results = {
    @Result(name = MisConstant.FINDBYKEY, location = "/UI/demo/demoinfo.jsp") })
    public String findByKey() {
        try {
            logger.debug(messageBean.getMethod());
            demoBean = new DemoBean();
            if (!(messageBean.getMethod().equals("add"))) {
                demoBean = (DemoBean) findByKey(demoBean, " where CustomerID ='" + strSysno + "'");
                logger.debug(demoBean.getAddress());
                if (demoBean != null) {
                    messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                    messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
                }else{
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
     * 查询信息 返回json信息
     * 
     * @return
     */
    @Action(value = "demo_findObjson", results = {
            @Result(type = "json", name = MisConstant.FINDOBJSON, params = { "includeProperties", "messageBean.*,demoBean.*" }) })
    public String findObjson() {
        try {
            logger.debug(messageBean.getMethod());
            demoBean = new DemoBean();
            if (!(messageBean.getMethod().equals("add"))) {
                demoBean = (DemoBean) findByKey(demoBean, " where CustomerID ='" + strSysno + "'");
                logger.debug(demoBean.getAddress());
                if (demoBean != null) {
                    messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                    messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
                }else{
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
     * 添加
     * 
     * @return
     */

    @Action(value = "demo_insert")
    public String insert() {
        try {
            String number = BusinessDate.getNoFormatToday() + "-" + SerialNumber.getNextSerialNo("67");
            demoBean.setCustomerid(number);
            messageBean = insert(demoBean);
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
     * 修改
     * 
     * @return
     */
    @Action(value = "demo_update")
    public String update() {
           
        logger.debug("修改");
        try {
            messageBean = update(demoBean, " where CustomerID ='" + demoBean.getCustomerid() + "'");
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
    @Action(value = "demo_delete")
    public String delete() {
        try {
            demoBean = new DemoBean();
            messageBean = delete(demoBean, " where CustomerID in (" + strSysno + ")");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // 设置错误返回的提示
            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
        }
        return MisConstant.RETMESSAGE;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        DemoAction.logger = logger;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public DemoBean getDemoBean() {
        return demoBean;
    }

    public void setDemoBean(DemoBean demoBean) {
        this.demoBean = demoBean;
    }

   

    public MessageBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessageBean messageBean) {
        this.messageBean = messageBean;
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
