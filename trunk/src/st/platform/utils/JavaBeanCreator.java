package st.platform.utils;

import st.platform.common.JavaBeanGenerator;

public class JavaBeanCreator
{

    public JavaBeanCreator()
    {
    }

    public static String createBean(String classPath,String tablename)
    {
    	JavaBeanGenerator javaBeanGenerator = new JavaBeanGenerator();
        
        String classBean = tablename.substring(0, 1).toUpperCase() + tablename.substring(1, tablename.length()).toLowerCase() + "Bean";
        try {
            javaBeanGenerator.generate(classPath, classBean, tablename);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return classBean;
    }
}
