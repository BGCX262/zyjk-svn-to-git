package st.system.action.databasc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import st.platform.db.RecordSet;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.system.dao.PtableBean;
import st.system.dao.PtablecolumnBean;
import UI.message.MisConstant;

/**
 * 数据库的移植功能
 * 可实现将两个不同数据库直接的移植
 * 
 * 1 mysql 移植到sqlserver
 * 2 sqlserver 到mysql
 * 
 * 1 单表移植
 * 2 数据库移植
 * 3 根据sql语句的移植
 * @author Administrator
 *
 */
@ParentPackage("struts-filter")
@Namespace("/st/system/action/databasc")  
public class DataTransp extends BasicAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static Logger logger = Logger.getLogger(DataTransp.class);

    private PtableBean ptableBean ;//返回的主表

    private PtablecolumnBean ptableColumnBean;//返回的数据字段表
    
    private String strWhere=""; // 查询条件
    
    private String strSQL=""; // 执行sql

    private String strSysno=""; // 主键编号

    private PageBean pageBean; // 分页类

    private MessageBean messageBean;// 操作状态

   
    
    /**
     * 根据表名称 单表移植
     * @return
     *//*
    public String transTable(){
        
        
        
    }*/
    
    /**
     * 向sqlserver数据库整体移植
     * @return
     */
    @Action(value = "DataTransp_initDataBasc")
    public String toSqlServer(){
        try {
            PtableBean ptable = new PtableBean();
            List<PtableBean> list = ptable.findByWhere("");
           
            SQLSERVER sqlserver = new SQLSERVER();
            messageBean = new MessageBean();
            for(int i=0;i<list.size();i++)
            {
                
                PtablecolumnBean ptcolumn  = new PtablecolumnBean();
                //字段查询
                ptable = list.get(i);
                List<PtablecolumnBean> columlist = ptcolumn.findByWhere(" where tablename ='"+ptable.getTablename()+"'  ");
                
                //查询出系统的主键
                ptcolumn = (PtablecolumnBean) ptcolumn.findFirstByWhere(" where tablename ='"+ptable.getTablename()+"' and iskey='PRI'  ");
                //数据查询
                RecordSet gridRS = executeQuery("select * from "+ptable.getTablename()+"");
                String pik ="";
                if(ptcolumn==null)
                {
                    pik = null;
                }else{
                    pik = ptcolumn.getColumnname();
                }
                
                sqlserver.createTable(ptable, columlist,pik );
                ptcolumn  = new PtablecolumnBean();
                List<PtablecolumnBean> columlistz = ptcolumn.findByWhere(" where tablename ='"+ptable.getTablename()+"' and columntype = 'decimal'  ");
                Map<String,String> map = new HashMap<String, String>();
                for(int j=0;j<columlistz.size();j++)
                {
                    PtablecolumnBean ptbcolumns = columlistz.get(j);
                    map.put(ptbcolumns.getColumnname(), ptbcolumns.getColumntype());
                }
                sqlserver.insertData(ptable, gridRS,map);
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
     * 向mysql数据库整体移植
     * @return
     */
    @Action(value = "DataTransp_initMysqlDataBasc")
    public String toMysql(){
        try {
            PtableBean ptable = new PtableBean();
            List<PtableBean> list = ptable.findByWhere("");
           
            MYSQL mysql = new MYSQL();
            messageBean = new MessageBean();
            for(int i=0;i<list.size();i++)
            {
                
                PtablecolumnBean ptcolumn  = new PtablecolumnBean();
                //字段查询
                ptable = list.get(i);
                List<PtablecolumnBean> columlist = ptcolumn.findByWhere(" where tablename ='"+ptable.getTablename()+"'  ");
                
                //查询出系统的主键
                ptcolumn = (PtablecolumnBean) ptcolumn.findFirstByWhere(" where tablename ='"+ptable.getTablename()+"' and iskey='PRI'  ");
                //数据查询
                RecordSet gridRS = executeQuery("select * from "+ptable.getTablename()+"");
                String pik ="";
                if(ptcolumn==null)
                {
                    pik = null;
                }else{
                    pik = ptcolumn.getColumnname();
                }
                
                mysql.createTable(ptable, columlist,pik);
                ptcolumn  = new PtablecolumnBean();
                List<PtablecolumnBean> columlistz = ptcolumn.findByWhere(" where tablename ='"+ptable.getTablename()+"' and columntype IN ('decimal','date') ");
                Map<String,String> map = new HashMap<String, String>();
                for(int j=0;j<columlistz.size();j++)
                {
                    PtablecolumnBean ptbcolumns = columlistz.get(j);
                    map.put(ptbcolumns.getColumnname(), ptbcolumns.getColumntype());
                }
                mysql.insertData(ptable, gridRS,map);
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



    public PtableBean getPtableBean() {
        return ptableBean;
    }



    public void setPtableBean(PtableBean ptableBean) {
        this.ptableBean = ptableBean;
    }



    public PtablecolumnBean getPtableColumnBean() {
        return ptableColumnBean;
    }



    public void setPtableColumnBean(PtablecolumnBean ptableColumnBean) {
        this.ptableColumnBean = ptableColumnBean;
    }



    public String getStrSQL() {
        return strSQL;
    }



    public void setStrSQL(String strSQL) {
        this.strSQL = strSQL;
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
    
    /**
     * 根据sql语句移植
     * @return
     */
    /*public String transSQL(){
        
        
    }*/
    
    
    
}
