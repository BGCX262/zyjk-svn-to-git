/*********************************************************************
 *<p>处理内容：TREE Action</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.03.05---- 孙雁斌 --------- 新规作成<br>
 * @------- 1.1 --2013.03.11---- 方立文 --------- update<br>
 ***********************************************************************/
package st.system.action.tree;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.RecordSet;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.system.action.form.CreateJAVATree;
import st.system.dao.PtreesBean;
import UI.message.MisConstant;
@ParentPackage("struts-filter") 
@Namespace("/st/system/action/tree") 
public class TreeAction extends BasicAction {

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(TreeAction.class);

	private String strWhere=""; //查询条件

	private String strTreeID=""; //Tree主键编号

	private MessageBean messageBean;// 操作状态 

	private List<Map<String, Object>> treeList;//返回的信息

    private String strTreeName="";//tree名称
    
    private String isFlag="";   //判断是否上级节点
    
    private PtreesBean ptreesBean ; //tree
	/**
     * 刷新树形结构的方法
     * @return
     */
    @Action(value = "tree_getTree")
    public String getTree(){
        try {
            TreeBasic treeBasic = new TreeBasic();
            Class<?> forName;
            logger.debug(strTreeName);

            forName = Class.forName("st.system.action.tree."+strTreeName);
            treeBasic = (TreeBasic)forName.newInstance();
     
             //根据sql查询返回内容
         
            String strSQL = treeBasic.getSQL(strWhere,strTreeID,isFlag);
            logger.debug(strSQL);
            System.out.println(strSQL);
            RecordSet rs = executeQuery(strSQL);
            treeList = treeBasic.getTree(rs);
             //对内容进行处理
            logger.debug(treeList.size());
         
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
       return MisConstant.TREELIST; 
    }

    
    /**
     * 创建tree方法
     * @return
     */
    @Action(value = "tree_getCreat")
    public String getCreat() {
        try {
            messageBean = new MessageBean();
            ptreesBean = new PtreesBean();
            ptreesBean  = (PtreesBean) findByKey(ptreesBean, " where treeid ='" + strTreeID + "'");
            if (ptreesBean != null) {
                
                //创建文件
                CreateJAVATree createTree = new CreateJAVATree();
                createTree.createJava(ptreesBean);
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
        return MisConstant.RETMESSAGE;
        
    }
    /**
     * 添加
     * 
     * @return
     */

    @Action(value = "tree_insert")
    public String insert() {
        logger.debug("insert");
        try {
            String number = "PTREES_"+System.currentTimeMillis();
            logger.debug(number);
            ptreesBean.setTreeid(number);
            logger.debug(ptreesBean.getTreename());
            logger.debug(ptreesBean.getTreedesc());
            messageBean = insert(ptreesBean);
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
    @Action(value = "tree_findByKey", results = {
            @Result(type = "json", name = SUCCESS, params = { "includeProperties", "messageBean.*,ptreesBean.*" }) })
    public String findByKey() {
        try {
            messageBean = new MessageBean();
            ptreesBean = new PtreesBean();
          
                ptreesBean = (PtreesBean) findByKey(ptreesBean, " where treeid ='" + strTreeID + "'");
                if (ptreesBean != null) {
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
    @Action(value = "tree_update")
    public String update() {
            
        logger.debug("修改");
        try {
            messageBean = update(ptreesBean, " where treeid ='" + ptreesBean.getTreeid() + "'");
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
    @Action(value = "tree_delete")
    public String delete() {
        try {
            ptreesBean = new PtreesBean();
            messageBean = delete(ptreesBean, " where treeid ='" + strTreeID + "'");
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


  


    public String getStrTreeID() {
        return strTreeID;
    }


    public void setStrTreeID(String strTreeID) {
        this.strTreeID = strTreeID;
    }


    public String getStrTreeName() {
        return strTreeName;
    }


    public void setStrTreeName(String strTreeName) {
        this.strTreeName = strTreeName;
    }


    public String getStrWhere() {
        return strWhere;
    }


    public void setStrWhere(String strWhere) {
        this.strWhere = strWhere;
    }


    public List<Map<String, Object>> getTreeList() {
        return treeList;
    }


    public void setTreeList(List<Map<String, Object>> treeList) {
        this.treeList = treeList;
    }


    public static Logger getLogger() {
        return logger;
    }


    public static void setLogger(Logger logger) {
        TreeAction.logger = logger;
    }
    
   
    public String getIsFlag() {
		return isFlag;
	}


	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}


    public PtreesBean getPtreesBean() {
        return ptreesBean;
    }

    public void setPtreesBean(PtreesBean ptreesBean) {
        this.ptreesBean = ptreesBean;
    }


	
    
    
}
