/*********************************************************************
 *<p>处理内容：action 封裝父类</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package st.portal.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import st.platform.db.sql.AbstractBasicBean;
import st.platform.system.cache.EnumerationType;
import st.system.dao.PtgridscolumnBean;
import UI.dao.zyjk.T_yhzc_bzbBean;
import UI.message.MisConstant;
import UI.util.DistcodeUtil;

import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    ConnectionManager cm = ConnectionManager.getInstance();

    DatabaseConnection DBCon = cm.get();

    private MessageBean messageBean;// 操作状态
    
    public String dataType = DBCon.DbType;//  数据库类型

    /**
     * 分页查询
     * 
     * @param fSQLStr
     *            sql语句
     * @param fwhereStr
     *            查询条件
     * @param forderStr
     *            排序条件
     * @param pageBean
     *            分页Bean
     * @return
     */
    public PageBean findList(String strGridName ,String strFSQL, String strFWhere, String strFOrder, PageBean pageBean) throws Exception {
        try {
            // 初始化查询条件
            if (strFWhere == null) {
                
            }
           
            if (pageBean == null) {
                pageBean = new PageBean();
                
            }
            // 返回的页数
            RecordSet gridRS;
            // 统计记录的数据量
            String strCountSQL = "select count(*) from (" + strFSQL + " " + strFWhere + ") temp";
            System.out.println("countSQL::" + strCountSQL);
            gridRS = DBCon.executeQuery(strCountSQL);
            if (gridRS.next()) {
                pageBean.setTotal(gridRS.getInt(0));
                //System.out.println(pageBean.getTotal());
            }
            // 查询内容
            List<Map<String, String>> listDate = new ArrayList<Map<String, String>>();
            Map<String, String> map;
            gridRS = DBCon.executeQuery(strFSQL, strFWhere, strFOrder, pageBean.getPageSize()
                    * (pageBean.getPage() - 1) + 1, pageBean.getPageSize(), pageBean.getTotal());
            
            //取出需要用到的enum枚举内容
            PtgridscolumnBean ptcolumn = new PtgridscolumnBean();
            List<PtgridscolumnBean> list = ptcolumn.findByWhere(" where gridname ='" + strGridName + "' and columnstate ='dropdown'");
            PtgridscolumnBean ptcolgrid = new PtgridscolumnBean();
            T_yhzc_bzbBean bzbBean=new T_yhzc_bzbBean();
            while (gridRS != null && gridRS.next()) {
                map = new HashMap<String, String>();
                for (int i = 0; i < gridRS.getColumnCount(); i++) {

                    String mark = gridRS.getFieldName(i);
                    String value = gridRS.getString(gridRS.getFieldName(i)).trim().replace("\r\n", "");
                    
                   if(mark.equals("nrsysno")){
                 	   bzbBean=new T_yhzc_bzbBean();
                 	   bzbBean=bzbBean.findFirst(" where id='"+ value +"'");
                 	   value=bzbBean.getBzmc();
                 	   
                    }
                    //查询结果枚举
                    for(int j=0;j<list.size();j++)
                    {
                        ptcolgrid = list.get(j);
                       if(ptcolgrid.getColumnname().equals(mark)){
                    	   if(ptcolgrid.getColumnmenu().equals("distcode")){
                           	value=DistcodeUtil.getDistName(value);
                           }else{
                            value = EnumerationType.getEnu(ptcolgrid.getColumnmenu(),value).split(";")[0];   
                           }
                        }
                    }
                  
                    map.put(mark, value);
                 
                }
                listDate.add(map);
            }
            pageBean.setDataSet(listDate);
        } catch (Exception e) {
            throw e;
        }
        return pageBean;
    }

    /**
     * 查询方法
     * 
     * @param obj
     * @param sqlWhere
     * @return
     */
    public AbstractBasicBean findByKey(AbstractBasicBean obj, String sqlWhere) throws Exception {
        try {

            obj = (AbstractBasicBean) obj.findFirstByWhere(sqlWhere);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw e;
        }

        return obj;
    }

    /**
     * 公共添加的方法
     * 
     * @param obj
     * @return
     */
    public MessageBean insert(AbstractBasicBean obj) throws Exception {
        messageBean = new MessageBean();
        try {
            if (obj.insert() > 0) {
                // 操作成功
                messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
            } else {
                // 操作失败
                messageBean.setCheckFlag(MisConstant.MSG_FAIL);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);

            }
        } catch (Exception e) {
            throw e;
        }
        return messageBean;
    }

    /**
     * 公共删除方法
     * 
     * @param obj
     * @return
     */
    public MessageBean delete(AbstractBasicBean obj, String sqlWhere) throws Exception {
        messageBean = new MessageBean();
      
        try {
            if (obj.deleteByWhere(sqlWhere) > 0) {
                // 操作成功
                messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
            } else {
                // 操作失败
                messageBean.setCheckFlag(MisConstant.MSG_FAIL);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return messageBean;
    }

    /**
     * 公共update方法
     * 
     * @param obj
     * @return
     */
    public MessageBean update(AbstractBasicBean obj, String sqlWhere) throws Exception {
        messageBean = new MessageBean();
        try {
            if (obj.updateByWhere(sqlWhere) > 0) {
                // 操作成功
                messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
            } else {
                // 操作失败
                messageBean.setCheckFlag(MisConstant.MSG_FAIL);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
            }
        } catch (Exception e) {
            throw e;
        }
        return messageBean;
    }
    
    /**
     * 公共查询SQL方法
     */
    @SuppressWarnings("unused")
    public RecordSet  executeQuery(String strSQL) throws Exception {
        RecordSet gridRS = null;
        try {
            System.out.println(strSQL);
            gridRS = DBCon.executeQuery(strSQL);
        
            
        } catch (Exception e) {
            throw e;
        }
        return gridRS;
    }

    /**
     * 公共执行SQL方法
     */
    public MessageBean executeUpdate(String strSQL) throws Exception {
        messageBean = new MessageBean();
        try {
            if (DBCon.executeUpdate(strSQL) > 0) {
                // 操作成功
                messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
            } else {
                // 操作失败
                messageBean.setCheckFlag(MisConstant.MSG_FAIL);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
            }
        } catch (Exception e) {
            throw e;
        }
        return messageBean;
    }
}
