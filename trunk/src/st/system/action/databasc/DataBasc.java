/*********************************************************************
 *<p>处理内容：数据库管理 Action</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.18---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.databasc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.RecordSet;
import st.platform.utils.Config;
import st.platform.utils.JavaBeanCreator;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.system.dao.PtableBean;
import st.system.dao.PtablecolumnBean;
import UI.dao.DemoBean;
import UI.message.MisConstant;

@ParentPackage("struts-filter")
@Namespace("/st/system/action/databasc")  
public class DataBasc extends BasicAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static Logger logger = Logger.getLogger(DataBasc.class);

    private PtableBean ptableBean ;//返回的主表

    private PtablecolumnBean ptableColumnBean;//返回的数据字段表
    
    private String strWhere=""; // 查询条件
    
    private String strSQL=""; // 执行sql

    private String strSysno=""; // 主键编号

    private PageBean pageBean; // 分页类

    private MessageBean messageBean;// 操作状态

    private List<Map<String,String>> columnList; //表字段
    
    private String strTableName ="";//表名称
    
    private String strColumnName ="";//字段名称
    
    private String strBeanPath =""; //创建的bean路径
    
    /***
     * 初始化数据库表名称到数据库
     * @return
     */
    @Action(value = "DataBasc_initDataBasc")
    public String initDataBasc(){
        try {
            messageBean = new MessageBean();
            
            PtableBean ptableBean =new PtableBean();
            PtablecolumnBean ptableColumnBean = new  PtablecolumnBean();
            
            //清空现有的信息
          
            String strDataName = Config.getProperty("db2Schema");
            
           
            
            String strSql = "";
            if(dataType.equalsIgnoreCase("mysql"))
            {
                strSql= "SELECT * FROM  INFORMATION_SCHEMA.TABLES WHERE  table_schema ='"+strDataName+"' and table_name ='"+strTableName+"'";
            }else   if(dataType.equalsIgnoreCase("sqlserver"))
            {
         
                strSql= "SELECT * FROM  INFORMATION_SCHEMA.TABLES ";
                
            }
            
            if(strTableName!=null&&!(strTableName.equals("")))
            {
                //单表的操作
                strSql =  strSql + " and  table_name ='"+strTableName+"'";
                
                messageBean =delete(ptableColumnBean, "  where tablename ='"+strTableName+"'");
                
                ptableBean =  (PtableBean) findByKey(ptableBean,"  where tablename ='"+strTableName+"'");
                
                RecordSet gridColumn  = executeQuery("SELECT * FROM  INFORMATION_SCHEMA.COLUMNS WHERE  table_schema ='"+strDataName+"' and table_name ='"+strTableName+"'");
                
                logger.debug("SELECT * FROM  INFORMATION_SCHEMA.COLUMNS WHERE  table_schema ='"+strDataName+"' and table_name ='"+strTableName+"'");
              
                String sqlHear = "Select ";
                String sqlCenter = "";
                String sqlEnd =" from "+strTableName;
                while (gridColumn != null && gridColumn.next()) {
                    ptableColumnBean.setColumnid("PTABLECOLUMN_"+System.currentTimeMillis());
                    ptableColumnBean.setTableid(ptableBean.getTableid());
                    ptableColumnBean.setTablename(strTableName.toLowerCase());
                    ptableColumnBean.setColumndesc(gridColumn.getString("column_comment"));
                    ptableColumnBean.setColumnname(gridColumn.getString("COLUMN_NAME").toLowerCase());
                    ptableColumnBean.setColumnlength(gridColumn.getString("character_maximum_length"));
                    ptableColumnBean.setColumntype(gridColumn.getString("data_type"));
                    ptableColumnBean.setIskey(gridColumn.getString("column_key"));
                    sqlCenter = sqlCenter+ptableColumnBean.getColumnname()+",";
                    ptableColumnBean.insert();
                }
                sqlCenter = sqlCenter.substring(0,sqlCenter.length()-1);
                
                String strSQL = sqlHear + sqlCenter + sqlEnd;
                ptableBean.setStrsql(strSQL);
                ptableBean.setBeanname(strTableName+"Bean");
                messageBean =   update(ptableBean,"  where tablename ='"+strTableName+"'");
            }
            else{
                //全库操作
                messageBean =delete(ptableBean, "");
                messageBean =delete(ptableColumnBean, "");
               
                logger.debug(strSql);
                RecordSet gridRS  = executeQuery(strSql);
                String strTableName;
                String strTableID;
                while (gridRS != null && gridRS.next()) {
                    strTableName = gridRS.getString("table_name").toLowerCase();
                    strTableID = "PTABLE_"+System.currentTimeMillis();
                    ptableBean.setTableid(strTableID);
                    ptableBean.setTablename(strTableName);
                   String sqlSTR ="";
                   
                   //字段说明
                   Map<String,String> mapcolum = new HashMap<String, String>();
                   String pkcolumn = "";
                   
                    if(dataType.equalsIgnoreCase("mysql"))
                    {
                        sqlSTR= "SELECT * FROM  INFORMATION_SCHEMA.COLUMNS WHERE  table_schema ='"+strDataName+"' and table_name ='"+strTableName+"'";
                    }else   if(dataType.equalsIgnoreCase("sqlserver"))
                    {
                 
                        
                        sqlSTR ="SELECT colorder=a.colorder, COLUMN_NAME =a.name,column_key=case when exists(SELECT 1 FROM sysobjects " +
                                "where xtype='PK' and parent_obj=a.id and name in ( SELECT name FROM sysindexes WHERE indid in( " +
                                "SELECT indid FROM sysindexkeys WHERE id = a.id AND colid=a.colid))) then 'PRI' else '' end,data_type =b.name," +
                                " character_maximum_length=COLUMNPROPERTY(a.id,a.name,'PRECISION'), column_comment=cast(g.[value] as nvarchar)" +
                                " FROM syscolumns a left join systypes b on a.xusertype=b.xusertype inner join sysobjects d on a.id=d.id  " +
                                "and d.xtype='U' and  d.name<>'dtproperties' left join syscomments e on a.cdefault=e.id " +
                                "left join sys.extended_properties g on a.id=g.major_id and a.colid=g.minor_id " +
                                "left join sys.extended_properties f on d.id=f.major_id and f.minor_id=0 where d.name='"+strTableName+"'";
                            
                      
                    }
                    RecordSet gridColumn  = executeQuery(sqlSTR);
                    
                    logger.debug(sqlSTR);
                    
                    String sqlHear = "Select ";
                    String sqlCenter = "";
                    String sqlEnd =" from "+strTableName;
                    while (gridColumn != null && gridColumn.next()) {
                        ptableColumnBean.setColumnid("PTABLECOLUMN_"+System.currentTimeMillis());
                        ptableColumnBean.setTableid(strTableID);
                        ptableColumnBean.setTablename(strTableName);
                        ptableColumnBean.setColumnname(gridColumn.getString("COLUMN_NAME").toLowerCase());
                        ptableColumnBean.setColumndesc(gridColumn.getString("column_comment"));
                        ptableColumnBean.setColumnlength(gridColumn.getString("character_maximum_length"));
                        ptableColumnBean.setColumntype(gridColumn.getString("data_type"));
                        ptableColumnBean.setIskey(gridColumn.getString("column_key"));
                        sqlCenter = sqlCenter+ptableColumnBean.getColumnname()+",";
                        ptableColumnBean.insert();
                    }
                    sqlCenter = sqlCenter.substring(0,sqlCenter.length()-1);
                    
                    String strSQL = sqlHear + sqlCenter + sqlEnd;
                    ptableBean.setBeanname(strTableName+"Bean");
                    ptableBean.setStrsql(strSQL);
                    ptableBean.insert();
                }
            }
            
            
        } catch (Exception e) {
            messageBean.setCheckFlag(0);
            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
        }
        
        return MisConstant.RETMESSAGE;
    }
    

    
    /**
     * 根据表名称 生成Bean
     * @return
     */
    @Action(value = "DataBasc_creatBean")
    public String creatBean(){
        messageBean = new MessageBean();
        ptableBean = new PtableBean();
        try {
            ptableBean =  (PtableBean) findByKey(ptableBean,"  where tablename ='"+strTableName+"'");
            
            //System.out.println("strBeanPath"+strBeanPath);
            //System.out.println("strTableName"+strTableName);
            logger.debug(strTableName);
            
            String clasBean = JavaBeanCreator.createBean(strBeanPath,strTableName);
            
            ptableBean.setBeanname(clasBean);
            ptableBean.setBeanpath(strBeanPath);
            
            update(ptableBean, "  where tablename ='"+strTableName+"'");
            
            messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            messageBean.setCheckFlag(0);
            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
            messageBean.setCheckFlag(MisConstant.MSG_FAIL);
            messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
            e.printStackTrace();
        }
        
        return MisConstant.RETMESSAGE;
    }
    
    /**
     * 执行sql语句 
     * 查询返回表格字段
     * 执行返回执行情况
     * @return
     */
    @Action(value = "DataBasc_runSQL" , results = {
            @Result(type = "json", name = "SELECT", params = { "root", "columnList.*" }),
            @Result(type = "json", name = "UPDATE", params = { "root", "messageBean.*" }) })
    public String runSQL()
    {
        String strRet ="";
        try {
            if(strWhere!=null&&!(strWhere.equals("")))
            {
                String strSqlArr[] =strSQL.trim().split(" ");
                String sqlIndex = strSqlArr[0].toLowerCase();
                if(sqlIndex.equals("select")||sqlIndex.equals("show")) {
                    strRet = "SELECT";
                    columnList = new ArrayList<Map<String, String>>();
                    Map<String, String> map;

                    RecordSet gridRS = executeQuery("Select * from ("+strSQL+")as s where (1>1)");
                    while (gridRS != null && gridRS.next()) {
                        map = new HashMap<String, String>();
                        for (int i = 0; i < gridRS.getColumnCount(); i++) {
                            String mark = gridRS.getFieldName(i);
                            map.put("display", mark);
                            map.put("name", mark);
                            map.put("width", "100");
                            map.put("align", "left");
                        }
                        columnList.add(map);
                    }
                    
                }else{
                    //执行操作
                    strRet = "UPDATE";
                    messageBean =  executeUpdate(strSQL);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return strRet;
    }
    
    
    /**
     * 查询
     * 
     * @return
     */
    @Action(value = "DataBasc_findList")
    public String findList() {
        
        try {
           
            messageBean = new MessageBean();
            String strFSql ="Select * from ptablecolumn";
            // 查询条件
            
            pageBean = findList("",strFSql, strWhere, "", pageBean);
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
    @Action(value = "DataBasc_findByKey", results = {
            @Result(type = "json", name = MisConstant.RETMESSAGE, params = { "includeProperties", "messageBean.*, ptableBean.*" }) })
    public String findByKey() {
        try {
            ptableBean = new PtableBean();
            messageBean = new MessageBean();
                ptableBean = (PtableBean) findByKey(ptableBean, "  where tableid ='"+strSysno+"'");
                logger.debug(ptableBean.getStrsql());
                if (ptableBean != null) {
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
     * 根据表名称和字段名称查询
     * 
     * @return
     */
    @Action(value = "DataBasc_findColumn", results = {
            @Result(type = "json", name = MisConstant.RETMESSAGE, params = { "includeProperties", "messageBean.*, ptableColumnBean.*" }) })
    public String findColumn() {
        try {
            ptableColumnBean = new PtablecolumnBean();
            messageBean = new MessageBean();
            ptableColumnBean = (PtablecolumnBean) findByKey(ptableColumnBean, "  where tablename ='"+strTableName+"' and columnname  ='"+strColumnName+"'");
                if (ptableColumnBean != null) {
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

    
    
    public List<Map<String, String>> getColumnList() {
        return columnList;
    }


    public void setColumnList(List<Map<String, String>> columnList) {
        this.columnList = columnList;
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


    public String getStrSQL() {
        return strSQL;
    }


    public void setStrSQL(String strSQL) {
        this.strSQL = strSQL;
    }



    public String getStrBeanPath() {
        return strBeanPath;
    }



    public void setStrBeanPath(String strBeanPath) {
        this.strBeanPath = strBeanPath;
    }



    public String getStrTableName() {
        return strTableName;
    }



    public void setStrTableName(String strTableName) {
        this.strTableName = strTableName;
    }



    public String getStrColumnName() {
        return strColumnName;
    }



    public void setStrColumnName(String strColumnName) {
        this.strColumnName = strColumnName;
    }
    
   
    
    
}
