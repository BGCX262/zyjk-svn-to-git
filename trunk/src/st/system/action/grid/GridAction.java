/*********************************************************************
 *<p>处理内容： GRID 管理</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.18---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.system.cache.EnumerationType;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.portal.html.DBSelect;
import st.system.action.form.CreateListJSFile;
import st.system.action.form.CreateListJSPFile;
import st.system.dao.PtgridsBean;
import st.system.dao.PtgridscolumnBean;
import UI.message.MisConstant;

@ParentPackage("struts-filter")
@Namespace("/st/system/action/grid")  
public class GridAction extends BasicAction{

    private static Logger logger = Logger.getLogger(GridAction.class);

    private static final long serialVersionUID = 1L;

    private PtgridsBean ptgridBean; // 返回的信息

    private String strWhere=""; // 查询条件

    private String strSysno=""; // 主键编号

    private PageBean pageBean; // 分页类

    private MessageBean messageBean;// 操作状态
    
    private String gridKey ="";
    
    private String strOrderBy =""; //排序
    
    
    /**
     * 公共的分页查询 
     * 
     * @return
     */
    @Action(value = "Grid_findList")
    public String findList() {
        
        try {
           
            messageBean = new MessageBean();
            if(strSysno!=null&&!(strSysno.equals("")))
            {
             //从数据库中取出sql语句   
                ptgridBean  = new PtgridsBean();
                ptgridBean = (PtgridsBean) findByKey(ptgridBean, " where gridid ='" + strSysno + "'");
                if(ptgridBean!=null)
                {
                    String strFSql = ptgridBean.getSqlstr();
                    strOrderBy = ptgridBean.getOrderstr();
                    if(strOrderBy==null){
                        strOrderBy = "";
                    }
                    if(strFSql!=null&&strFSql.length()>0)
                    {
                        strWhere = ptgridBean.getWherestr() +" " +strWhere;
                        pageBean = findList(strSysno,strFSql, strWhere, strOrderBy, pageBean);
                        messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                        messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
                    }
                }
                else{
                    messageBean.setCheckFlag(MisConstant.MSG_FAIL);
                    messageBean.setCheckMessage("GRID IS NULL");
                }
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
      
        return MisConstant.FINDLIST;
    }
    
    
    /**
     * 添加
     * 
     * @return
     */

    @Action(value = "GridAction_insert")
    public String insert() {
        try {
            ptgridBean.setGridid(ptgridBean.getGridname());
            messageBean = insert(ptgridBean);
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
    @Action(value = "GridAction_findByKey", results = {
            @Result(type = "json", name = SUCCESS, params = { "includeProperties", "messageBean.*,ptgridBean.*" }) })
    public String findByKey() {
        try {
            messageBean = new MessageBean();
            ptgridBean = new PtgridsBean();
            ptgridBean = (PtgridsBean) findByKey(ptgridBean, " where gridid ='" + strSysno + "'");
                if (ptgridBean != null) {
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
    @Action(value = "GridAction_update")
    public String update() {
           
        logger.debug("修改");
        try {
            
            messageBean = update( ptgridBean, " where gridid ='" +  ptgridBean.getGridid()+ "'");
      
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
    @Action(value = "GridAction_delete")
    public String delete() {
        try {
            ptgridBean = new PtgridsBean();
            messageBean = delete( ptgridBean, " where gridid in ('" + strSysno + "')");
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
     * 生成sql
     * @return
     */
    @Action(value = "GridAction_createSQL")
    public String createSQL() {
        try {
            messageBean = new MessageBean();
            String arr [] = {"a","b","c","d","e","f","g"};
            
            PtgridscolumnBean ptgridColumn = new PtgridscolumnBean();
            List<PtgridscolumnBean> list =  ptgridColumn.findByWhere(" where gridname ='" + strSysno + "'");
            
            Map<String,String> map = new HashMap<String, String>();
            
            String strSQL ="select ";
            
            String strFrom =" from ";
            //取出涉及的表名称
            for(int i=0;i<list.size();i++)
            {
                ptgridColumn = list.get(i);
                map.put(ptgridColumn.getTablename(), ptgridColumn.getTablename());
            }
            
            
            int state = 0;
            //放入带表名称
            for(Object obj:map.keySet())
            {
               String dname =arr[state];
               String table =  map.get(obj);
               map.put(obj.toString(), dname);
               strFrom = strFrom + table+" as "+arr[state]+",";
               state++;
            }
            strFrom = strFrom.substring(0, strFrom.length()-1)+"";
            
            
            
          
            for(int i=0;i<list.size();i++)
            {
                ptgridColumn = list.get(i);
                strSQL = strSQL +map.get(ptgridColumn.getTablename())+"."+ptgridColumn.getColumnname()+",";
                
            }
            
            strSQL = strSQL.substring(0, strSQL.length()-1)+strFrom;
            
            messageBean.setMethod(strSQL);
            
                if (list != null) {
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
     * 生成LIST JSP页面
     * @return
     */
    @Action(value = "GridAction_creatJsp")
    public String createJsp() {
        try {
            messageBean = new MessageBean();
            CreateListJSPFile jsp = new CreateListJSPFile();
            ptgridBean = new PtgridsBean();
            ptgridBean = (PtgridsBean) findByKey(ptgridBean, " where gridid ='" + strSysno + "'");
            jsp.createJSP(ptgridBean);
            
            CreateListJSFile js = new CreateListJSFile();
            js.createJS(strSysno);
            
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
    
    
    public PtgridsBean getPtgridBean() {
        return ptgridBean;
    }

    public void setPtgridBean(PtgridsBean ptgridBean) {
        this.ptgridBean = ptgridBean;
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


    public String getGridKey() {
        return gridKey;
    }


    public void setGridKey(String gridKey) {
        this.gridKey = gridKey;
    }
    
    
    
    
}
