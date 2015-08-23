package st.portal.html;
import st.platform.html.CDBSelect;
public class DBSelect {
    CDBSelect cSelect;
    
    /**
     * 声明下拉列表对象
     * @param name 对象标示
     * @param enuType 枚举类型
     * @param defValue 缺省值
     */
    public DBSelect(String name,String enuType,String defValue)
    {
        cSelect = new CDBSelect(name,enuType,defValue);
    }
    /**
     * 声明下拉列表对象
     * @param name 对象标示
     * @param enuType 枚举类型
     */
    public DBSelect(String name,String enuType)
    {
        cSelect = new CDBSelect(name,enuType);
    }
    /**
    * 增加Select的属性
    * @param attrName 属性名称
    * @param attrCont 属性的内容字符串
    */
    public void addAttr(String attrName,String attrCont)
    {
        cSelect.addAttr(attrName,attrCont);
    }

    /**
     * 手工添加选择项
     * @param optName 选择项的名称
     * @param optValue 选择项的值
     */
    public void addOption(String optName,String optValue)
    {
        cSelect.addOption(optName,optValue);
    }
     /**
       * 是否显示值
       * @param displayAll
       */
     public void setDisplayAll(boolean displayAll) 
     {  
         cSelect.setDisplayAll(displayAll);
     }
     /**
      * 赋值Sql语句
      * @param sqlString
      */
     public void setSqlString(String sqlString) {
         cSelect.setSqlString(sqlString);
     }
     
     /**
      * 赋值缺省值
      * @param defValue
      */
     public void setDefValue(String defValue) {
         cSelect.setDefValue(defValue);
     }
      
     /**
      * 返回下拉框对象
      */
     public String toString()
     {
         return cSelect.toString();
     }
    
      
}
