/*********************************************************************
 *<p>处理内容：TABLE Column Action</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import st.platform.db.RecordSet;
import st.portal.action.BasicAction;

import UI.message.MisConstant;


@ParentPackage("struts-filter")
@Namespace("/st/system/action/table")
public class TableColumnAction extends BasicAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 插入map的key主键返回设置的tablecolum集合
     * @param columkey
     * @return
     */
    private List<Map<String,Object>> columnList;
    private String key;
    
    /**
     * 根据key的信息返回表头内容
     * @param key
     * @return
     */
    @Action(value = "table_getColumn")
    public  String getColumn()
    {

        try {
          /*  TableBasic tableBasic = new TableBasic();
            Class<?> forName;
            forName = Class.forName("st.system.action.table."+key);
            tableBasic = (TableBasic)forName.newInstance();
            */
            
            
            //查询数据 并编制字段内容
            String strSQL = "SELECT * FROM ptgridscolumn WHERE gridname ='"+key+"' order by dispno";
           
            List<Map<String, Object>> listDate = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            RecordSet gridRS = executeQuery(strSQL);
            while (gridRS != null && gridRS.next()) {
                map = new HashMap<String, Object>();
                
                    String display = gridRS.getString("columndesc");
                    String name = gridRS.getString("columnname");
                    String width = gridRS.getString("columnwidth");
                    String align = gridRS.getString("columnalign");
                    String hide = gridRS.getString("columnhide");
                    map.put("display", display);
                    map.put("name", name);
                    map.put("width", width);
                    map.put("align", align);
                    if(hide.equals("0"))
                    {
                        map.put("hide", "true");
                    }
                listDate.add(map);
            }
            
            columnList = listDate;
             //根据sql查询返回内容
            
             //对内容进行处理

         
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return MisConstant.TABLECOLUMN;
    }


    public List<Map<String, Object>> getColumnList() {
        return columnList;
    }


    public void setColumnList(List<Map<String, Object>> columnList) {
        this.columnList = columnList;
    }


    public String getKey() {
        return key;
    }


    public void setKey(String key) {
        this.key = key;
    }
    
}
