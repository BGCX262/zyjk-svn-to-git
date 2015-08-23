package st.system.action.form;




import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")

public class CreateCommonFileUtil  {

        /**
         * 
         * 
         * @return ArrayList
         */

    public static  ArrayList<String> getFieldNamesByClassName(String classname) {
        ArrayList<String> res = null;
        // java.lang.reflect.Field[] fil = T_jbqkBean.class.getDeclaredFields();
        Class cla;
        try {

          cla = Class.forName(classname);
          java.lang.reflect.Field[] fil = cla.getDeclaredFields();
          if (fil.length > 0) {
            res = new ArrayList<String>();
            for (int i = 0; i < fil.length; i++) {
              String str = fil[i].getName();
              if (str == null || "".equals(str.trim()) || "TABLENAME".equals(str)|| "operate_mode".equals(str) || "cf".equals(str) || "serialVersionUID".equals(str))
              {
                  
              }
              else
              {
                  res.add(str);
              }
            }
          }
        } catch (ClassNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return res;
      }
     /**
      * 
      * @return
      * @throws Exception
      */
    public static   String getSQL(List<String>list,String classname)throws Exception
    {
        String sql=null;
        for(String str:list)
        {
            if(sql==null)
                sql="select "+str;
            else
                sql=sql+","+str;
        }
        sql=sql+" from "+classname.replace("Bean", "").toLowerCase();
        System.out.println(sql);
        return sql;
    }
    


    public static void main(String args[])
    {
        try {
            
            getSQL(getFieldNamesByClassName("UI.dao.DemoBean"),"DemoBean");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
