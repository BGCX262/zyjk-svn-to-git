/*********************************************************************
 *<p>处理内容：分页bean</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package st.portal.action;

import java.util.List;
import java.util.Map;



public class PageBean {   
    private static final long serialVersionUID = -8324911261163634531L;
    private int total = 0; // 记录总数   
  
    private int pageSize = 15; // 每页显示记录数   
  
    private int pageCount = 0; // 总页数   
  
    private int page = 1; // 当前页数   
  
    private List<Map<String,String>> dataSet;//查询的内容 
    
    private String totalCountSQL;// 得到总记录数sql语句   
  
    private String listSQL;// 得到查询记录sql语句   
  
  
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getListSQL() {   
        return listSQL;   
    }   
  
    public void setListSQL(String listSQL) {   
        this.listSQL = listSQL;   
    }   
  
    public int getPage() {   
        return page;   
    }   
  
    public void setPage(int page) {   
        this.page = page;   
    }   
  
    public int getPageCount() {   
        return pageCount;   
    }   
  
    public void setPageCount(int pageCount) {   
        this.pageCount = pageCount;   
    }   
  
   
  

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalCountSQL() {   
        return totalCountSQL;   
    }   
  
    public void setTotalCountSQL(String totalCountSQL) {   
        this.totalCountSQL = totalCountSQL;   
    }

    public List<Map<String, String>> getDataSet() {
        return dataSet;
    }

    public void setDataSet(List<Map<String, String>> dataSet) {
        this.dataSet = dataSet;
    }


  
    
}   