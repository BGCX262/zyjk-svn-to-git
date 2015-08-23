/*********************************************************************
 *<p>处理内容： GRIDColumn 管理</p>
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

import st.platform.db.SerialNumber;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.system.dao.PtablecolumnBean;
import st.system.dao.PtgridsBean;
import st.system.dao.PtgridscolumnBean;
import UI.dao.DemoBean;
import UI.message.MisConstant;

@ParentPackage("struts-filter")
@Namespace("/st/system/action/grid")  
public class GridColumnAction extends BasicAction{

    private static Logger logger = Logger.getLogger(GridColumnAction.class);

    private static final long serialVersionUID = 1L;

    private PtgridscolumnBean ptgridcolumnBean; // 返回的信息

    private String strWhere=""; // 查询条件

    private String strSysno=""; // 主键编号

    private PageBean pageBean; // 分页类

    private MessageBean messageBean;// 操作状态
    
    private String strColumnName;//字段COLUMN
    
    private String strGridid; //GRID名称
    
    private String strTableName;//
    
    private String strOrder;// 排序类型
    
    /**
     * 动态添加
     * 
     * @return
     */

    @SuppressWarnings("unchecked")
    @Action(value = "GridColumnAction_insertAll")
    public String insertAll() {
        try {
          String columnArr[] = strColumnName.split(";");
          
          messageBean = new MessageBean();
          
          PtgridsBean ptgridsbean = new PtgridsBean();
          ptgridsbean = (PtgridsBean)ptgridsbean.findFirstByWhere(" where gridid ='"+strGridid+"'");
          
          PtablecolumnBean tableColumn = new PtablecolumnBean();
          List<PtablecolumnBean> list  = tableColumn.findByWhere(" where tablename ='"+strTableName+"'");
          
          Map<String,PtablecolumnBean>map = new HashMap<String,PtablecolumnBean>();
          for(int i=0;i<list.size();i++)
          {
              tableColumn = list.get(i); 
              map.put(tableColumn.getColumnname(), tableColumn);
          }
          
          //查询现有的信息 防止信息重复
          PtgridscolumnBean gridcolumn  = new PtgridscolumnBean();
          List<PtgridscolumnBean> columnlist  = gridcolumn.findByWhere(" where gridname ='"+strGridid+"' and tablename ='"+strTableName+"' order by dispno desc");
          
          Map<String,PtgridscolumnBean>colummap = new HashMap<String,PtgridscolumnBean>();
          for(int i=0;i<columnlist.size();i++)
          {
              gridcolumn = columnlist.get(i); 
              colummap.put(gridcolumn.getColumnname(), gridcolumn);
          }
          
          //排序序号的设立
          int index = 0;
          PtgridscolumnBean columns = (PtgridscolumnBean)gridcolumn.findFirstByWhere(" where gridname ='"+strGridid+"'  order by dispno desc");
          if(columns!=null){
              index = Integer.parseInt(columns.getDispno());
          }
           
          for(int i=0;i<columnArr.length;i++)
          {
             if(colummap.get(columnArr[i])==null)
             {
              ptgridcolumnBean = new PtgridscolumnBean();
              String number = "PTGRIDCOLUMN_" + SerialNumber.getNextSerialNo("67");;
              ptgridcolumnBean.setSysid(number);
              ptgridcolumnBean.setTablename(strTableName);
              ptgridcolumnBean.setGridname(ptgridsbean.getGridname());
              ptgridcolumnBean.setColumnname(columnArr[i]);
              ptgridcolumnBean.setColumndesc(map.get(columnArr[i]).getColumndesc());
              ptgridcolumnBean.setColumnalign("left");
              ptgridcolumnBean.setColumnhide("1");
              ptgridcolumnBean.setColumntype("text");
              ptgridcolumnBean.setColumnstate("text");
              ptgridcolumnBean.setColumnwidth("100");
              ptgridcolumnBean.setIsfind("0");
              //排序 
              int dispno = (index +i+1);
              ptgridcolumnBean.setDispno(""+dispno);
              insert(ptgridcolumnBean);
             } 
          }
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
     * 分页查询 
     * 
     * @return
     */
    @Action(value = "GridColumnAction_findList")
    public String findList() {
        
        try {
           
            messageBean = new MessageBean();
            String strFSql = "select * from ptgridscolumn ";
            // 查询条件
            
            pageBean = findList("",strFSql, strWhere, "order by gridname,dispno", pageBean);
            messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
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
     * 查询信息
     * 
     * @return
     */
    @Action(value = "GridColumnAction_findByKey", results = {
    @Result(name = MisConstant.FINDBYKEY, location = "/UI/system/resource/grid/gridinfo.jsp") })
    public String findByKey() {
        try {
            ptgridcolumnBean = new PtgridscolumnBean();
            if (!(messageBean.getMethod().equals("add"))) {
                ptgridcolumnBean = (PtgridscolumnBean) findByKey(ptgridcolumnBean, " where sysid ='" + strSysno + "'");
                if (ptgridcolumnBean != null) {
                    messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                    messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
                }else{
                    messageBean.setCheckFlag(MisConstant.MSG_FAIL);
                    messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
                }
            }else{
                ptgridcolumnBean = new  PtgridscolumnBean();
                ptgridcolumnBean.setGridname(strSysno);
                
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
     * 添加
     * 
     * @return
     */

    @Action(value = "GridColumnAction_insert")
    public String insert() {
        try {
            String number = "PTGRIDCOLUMN_"+System.currentTimeMillis();
            //查询现有的信息 防止信息重复
            PtgridscolumnBean gridcolumn  = new PtgridscolumnBean();
            List<PtgridscolumnBean> columnlist  = gridcolumn.findByWhere(" where gridname ='"+ptgridcolumnBean.getGridname()+"' and tablename ='"+ptgridcolumnBean.getTablename()+"' order by dispno desc");
            
            
            //排序序号的设立 取出最大的一个
            //排序序号的设立
            int index = 0;
            PtgridscolumnBean columns = (PtgridscolumnBean)gridcolumn.findFirstByWhere(" where gridname ='"+ptgridcolumnBean.getGridname()+"'  order by dispno desc");
            if(columns!=null){
                index = Integer.parseInt(columns.getDispno());
            }
            
            ptgridcolumnBean.setSysid(number);
            int dispno = (index +1);
            ptgridcolumnBean.setDispno(""+dispno);
            messageBean = insert(ptgridcolumnBean);
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
    @Action(value = "GridColumnAction_update")
    public String update() {
        try {
            
            messageBean = update( ptgridcolumnBean, " where sysid ='" + ptgridcolumnBean.getSysid() + "'");
      
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
    @Action(value = "GridColumnAction_delete")
    public String delete() {
        try {
            ptgridcolumnBean = new PtgridscolumnBean();
            messageBean = delete( ptgridcolumnBean, " where sysid in (" + strSysno + ")");
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
     * 排序
     * 
     * @return
     */
    @Action(value = "GridColumnAction_order")
    public String orderBy() {
        try {
            
            //有主键查询信息
            ptgridcolumnBean = new PtgridscolumnBean();
            messageBean = new MessageBean();
                
                //根据主键 取出修改信息
                ptgridcolumnBean = (PtgridscolumnBean)findByKey(ptgridcolumnBean, " where  sysid ='"+strSysno+"'");
                //取出当前的排序
                PtgridscolumnBean updateColumnBean = null;
                if(strOrder.equals("up")){
                    updateColumnBean = (PtgridscolumnBean)findByKey(ptgridcolumnBean, "   where gridname ='"+ptgridcolumnBean.getGridname()+"' and dispno < '"+ptgridcolumnBean.getDispno()+"' order by dispno desc ");
 
                    
                }else if(strOrder.equals("down")){
                    updateColumnBean = (PtgridscolumnBean)findByKey(ptgridcolumnBean, "  where gridname ='"+ptgridcolumnBean.getGridname()+"' and dispno > '"+ptgridcolumnBean.getDispno()+"' order by dispno ");

                }
                
                
                if(updateColumnBean!=null){
                    String dispno = updateColumnBean.getDispno();
                    updateColumnBean.setDispno(ptgridcolumnBean.getDispno());
                    ptgridcolumnBean.setDispno(dispno);
                    
                    //修改排序
                    messageBean = update( ptgridcolumnBean, " where sysid ='" + ptgridcolumnBean.getSysid() + "'");
                    messageBean = update( updateColumnBean, " where sysid ='" + updateColumnBean.getSysid() + "'");
                }else{
                    messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                    messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
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
    
  

  
  
    public PtgridscolumnBean getPtgridcolumnBean() {
        return ptgridcolumnBean;
    }


    public void setPtgridcolumnBean(PtgridscolumnBean ptgridcolumnBean) {
        this.ptgridcolumnBean = ptgridcolumnBean;
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



    public String getStrColumnName() {
        return strColumnName;
    }



    public void setStrColumnName(String strColumnName) {
        this.strColumnName = strColumnName;
    }



    public String getStrTableName() {
        return strTableName;
    }



    public void setStrTableName(String strTableName) {
        this.strTableName = strTableName;
    }

    public String getStrGridid() {
        return strGridid;
    }

    public void setStrGridid(String strGridid) {
        this.strGridid = strGridid;
    }

    public String getStrOrder() {
        return strOrder;
    }

    public void setStrOrder(String strOrder) {
        this.strOrder = strOrder;
    }

    

  
    
    
    
}
