package st.platform.system.cache;

import java.util.*;
import st.platform.db.*;

public class PolyChWord {
    private static Map types;



    static {
        init();
    }


    public static void main(String[] args) {

    }


    /**
     *  得到枚举类型type的实例 可以访问每个枚举值
     *
     *@param  type
     *@return       zt.platform.form.config.EnumerationBean
     *@roseuid      3F7165A503D7
     */
    public static boolean getChWord(String PolyChWord) {

         if(types.get(PolyChWord)==null)
            return false;
        else
            return true;
    }


    /**
     *  Description of the Method
     */
    public static void init() {

        types = new HashMap();
        ConnectionManager manager = ConnectionManager.getInstance();
        DatabaseConnection con = manager.get();
        try
        {
            String str = "select PolyChWord from PtWord";
    
            RecordSet rs = con.executeQuery(str);
            while (rs.next()) {
                String PolyChWord = rs.getString("PolyChWord");
    
                String enuDesc = "";
    
                types.put(PolyChWord, enuDesc);
    
            }
            rs.close();
        }
         catch(Exception e)
         {
             e.printStackTrace();
         }

        manager.release();


    }
}
