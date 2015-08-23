package st.platform.system.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import st.platform.db.*;

public class EnumerationType {
    private static Map types = Collections.synchronizedMap(new HashMap());

  
    static {
        init(true);
    }


    /**
     *  验证值value是否在枚举类型type的取值范围内
     *
     *@param  type
     *@param  value
     *@return        boolean
     *@roseuid       3F71657501F8
     */
    public static boolean validate(String type, String value) {
        EnumerationBean eb = getEnu(type);
        if (eb == null) {
            return false;
        } else {
            Object o = eb.getValue(value);
            if (o == null) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static String getEnu(String type,String value) {
      EnumerationBean eb = getEnu(type);
      if (eb == null)
        return value;
      return (String)eb.getValue(value);
    }

    /**
     * 获取枚举名称 linyw add
     *
     * @param type String 枚举类型
     * @param value String 枚举值
     * @return String
     */
    public static String getEnumName(String type, String value){
         EnumerationBean enumerationBean = (EnumerationBean) types.get(type.toUpperCase());
         if(enumerationBean == null){
              return null;
         }else{
              String values = (String)enumerationBean.getValue(value);
              if(values == null){
                   return null;
              }else{
                   return values.split("\\;")[0];
              }
         }
    }

    /**
     * 获取枚举名称 yuanwzh add
     *
     * @param type String 枚举类型
     * @param value String 枚举值
     * @return String
     */
    public static String getEnumExtend(String type, String value){
         EnumerationBean enumerationBean = (EnumerationBean) types.get(type.toUpperCase());
         if(enumerationBean == null){
              return null;
         }else{
              String values = (String)enumerationBean.getValue(value);
              if(values == null){
                   return null;
              }else{
                   return values.split("\\;")[1];
              }
         }
    }

    /**
     *  得到枚举类型type的实例 可以访问每个枚举值
     *
     *@param  type
     *@return       zt.platform.form.config.EnumerationBean
     *@roseuid      3F7165A503D7
     */
    public static EnumerationBean getEnu(String type) {
        return (EnumerationBean) types.get(type.toUpperCase());
   }


   /**
    * 重新装入枚举数据，修改枚举时调用
    */
   public static void reload() {
        types.clear();
        init(false);
   }

    /**
     *  Description of the Method
     */
    public static void init(boolean autoClose) {

         String enuitemName="";

         DatabaseConnection con = null;
         try {
              if(autoClose) //自动关闭连接时使用非线程数据库
                   con = ConnectionManager.getInstance().getConnection();
              else //非自动关闭连接时使用线程数据库
                   con = ConnectionManager.getInstance().get();
              String str = "select * from ptenumain";
              RecordSet rs = con.executeQuery(str);
              while(rs.next()) {
                   String enuid = rs.getString("EnuType");
                   String enuDesc = rs.getString("EnuName");

                   enuid = enuid.trim();
                   if(enuDesc == null) {
                        enuDesc = "";
                   } else {
                        enuDesc = enuDesc.trim();
                   }
                   EnumerationBean eb = new EnumerationBean(enuid);
                   eb.setEnudesc(enuDesc);
                   types.put(enuid.toUpperCase(), eb);
                   
                   //logger.debug(enuid+"-->"+enuDesc);
              }

              String enuBeanStr = "select * from ptenudetail where enutype in ( "
                                 +"select enutype from ptenumain "
                                 +") order by enutype,DISPNO ";
              RecordSet enuRs = con.executeQuery(enuBeanStr);
              while (enuRs.next()) {
                  EnumerationBean eb = (EnumerationBean) types.get(enuRs.getString("enutype").toUpperCase());
                  enuitemName = "";
                  if (enuRs.getString("ENUITEMEXPAND") != null)
                      enuitemName = enuRs.getString("EnuItemLabel").trim() + ";" + enuRs.getString("ENUITEMEXPAND").trim();
                  else
                      enuitemName = enuRs.getString("EnuItemLabel").trim() + "; ";

                  eb.add(enuRs.getString("EnuItemValue"), enuitemName);
                  //logger.debug(enuRs.getString("enutype")+":"+enuRs.getString("EnuItemValue")+"-->"+DBUtil.fromDB(enuitemName));
              }
              
         } catch(Exception e) {
             
         } finally {
             if(con != null && autoClose) //只处理自动关闭连接的情况
                 con.close();
         }

    }

    public static void main(String[] args) {
        System.out.println(EnumerationType.getEnu("GG_BUSS_TYPE","XKZ_KY"));
      }
    
}
