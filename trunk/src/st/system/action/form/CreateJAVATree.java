package st.system.action.form;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import st.platform.utils.BusinessDate;
import st.platform.utils.Config;
import st.system.dao.PtreesBean;

/**
 * <p>处理内容：创建java文件 tree
 * </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * @author  方立文
 * 改版履历
 * Rev - Date ------- Name ---------- Note --------------------------------
 * 1.0   2013.3.17    方立文           新規作成 
 */
public class CreateJAVATree extends CreateCommonFileUtil {
    /**
     * 写入package头文件
     * @param packageStr
     */
    private void generateHead(String packageStr) {
        try {
            fos.write(("/****************************************************\n"));
            fos.write((" * <p>处理内容：Tree</p>\n"));
            fos.write((" * <p>Copyright: Copyright (c) 2010</p>;\n"));
            fos.write((" * @author  ;\n"));
            fos.write((" * 改版履历;\n"));
            fos.write((" * Rev - Date ------- Name ---------- Note -------------------\n"));
            fos.write((" * 1.0  "+BusinessDate.getToday()+"               新規作成 ;\n"));
            fos.write((" ****************************************************/\n"));
            fos.write(("package "+packageStr+";\n"));
        } catch ( Exception e ) {

        }
   }
    /**
     * 写入import头文件
     *
     */
    private void generateImport() {
        try {
             String importStr = "\nimport java.util.ArrayList;\nimport java.util.HashMap;\nimport java.util.List;\nimport java.util.Map;\nimport st.platform.db.RecordSet;\n";
             fos.write(importStr);
        } catch ( Exception e ) {

        }
   }
    /**
     * 
     * @param classPath
     * @param tablename
     * @param className
     * @throws Exception
     */
    private OutputStreamWriter  fos;
    
    @SuppressWarnings("unused")
    public void createJava(PtreesBean ptreesBean)throws Exception
    {
        String className =  ptreesBean.getTreename();
        String classPath =  ptreesBean.getTreepath();

        if ( className == null || classPath == null ) {
            System.out.println("Error!");
            return;
       }
      
        String engPath = Config.getProperty("file");
        String filepath = "src/"+classPath.replace('.','/')+"/";
        if(engPath!=null)
        {
             filepath = engPath + "/src/"+classPath.replace('.','/')+"/";
        }
        FileOutputStream  stream = new FileOutputStream(filepath+className + ".java"); 
        
        
       fos = new OutputStreamWriter(stream,"UTF-8"); 
       
       generateHead(classPath);
       fos.write(("\n"));
       fos.write(("\n"));
       fos.write(("\n"));
       fos.write(("\n"));
       generateImport();
       
       fos.write(("public class "+className+" extends TreeBasic {\n"));
       fos.write(("\tprivate static final long serialVersionUID = 1L;\n"));  //add by Flw,2010.09.19  序列化
       
       fos.write(("\t/**\n"));
       fos.write(("\t* 取得SQL语句\n"));
       fos.write(("\t* @param strWhere\n"));
       fos.write(("\t* @param strTreeID\n"));
       fos.write(("\t* @param isFlag\n"));
       fos.write(("\t* @throws Exception\n")); 
       fos.write(("\t*/  \n"));  
       fos.write(("   public String getSQL(String strWhere,String strTreeID,String isFlag) {\n"));  
       
       fos.write(("\tString strSQL = \""+ptreesBean.getStrsql()+"\";\n"));  
       fos.write(("\t if(strWhere!=null&&!(strWhere.equals(\"\"))) {\n"));  
       fos.write(("\t strSQL = strSQL+strWhere;\n"));  
       fos.write(("\t}\n"));  
       fos.write(("\t return strSQL;\n"));  
       fos.write(("\t}  \n"));
       fos.write(("\t\n"));  
       fos.write(("\t\n"));  
       
       
       
       fos.write(("\t/**\n"));
       fos.write(("\t* 对结果集合进行处理\n"));
       fos.write(("\t* @param rs\n"));
       fos.write(("\t* @@return \n")); 
       fos.write(("\t*/  \n"));  
       fos.write(("   public List<Map<String, Object>> getTree(RecordSet rs)  {\n")); 
     
       fos.write(("\t  List<Map<String, Object>> list = new ArrayList<Map<String, Object>> ();\n"));  
       fos.write(("\t  Map<String, Object> map = new HashMap<String, Object>();\n"));  
       if(ptreesBean.getParampid()==null||ptreesBean.getParampid().equals(""))
       {
           fos.write(("\t map.put(\"id\", \"1\");\n"));  
           fos.write(("\t map.put(\"pid\", \"0\");\n"));  
           fos.write(("\t map.put(\"text\",\""+ptreesBean.getTreedesc()+"\");\n"));  
           fos.write(("\t List<String> childrenlist = new ArrayList<String>(); \n"));
           fos.write(("\t map.put(\"children\", childrenlist);\n"));  
           fos.write(("\t list.add(map);  \n"));
           fos.write(("\t\n"));  
       }
       
       fos.write(("\t while (rs != null && rs.next()) {\n"));  
       fos.write(("\t map = new HashMap<String, Object>();\n"));  
       fos.write(("\t String id = rs.getString(\""+ptreesBean.getParamid()+"\");\n")); 
       if(ptreesBean.getParampid()==null||ptreesBean.getParampid().equals(""))
       {
           fos.write(("\t  String pid = \"1\"; \n"));
       }else{
           fos.write(("\t String pid = rs.getString("+ptreesBean.getParamid()+");\n")); 
       }
       fos.write(("\t String text = rs.getString(\""+ptreesBean.getParamtext()+"\");\n"));  
       fos.write(("\t map.put(\"id\", id); \n"));
       fos.write(("\t map.put(\"pid\", pid); \n"));
       fos.write(("\t map.put(\"text\", text); \n"));
       fos.write(("\t list.add(map);\n"));  
       fos.write(("\t}\n"));  
       fos.write(("\t return list;\n"));  
       
       fos.write(("\t}\n"));  
       fos.write(("\t\n"));  
       fos.write(("\t\n"));  
       
       
       fos.write(("}\n")); 
            fos.flush();  
            fos.close(); 
    }
    
  public static void main(String args[])
  {
      CreateJAVATree crjava=new CreateJAVATree();
      try {
          PtreesBean ptree = new PtreesBean();
          ptree.setStrsql("Select treeid,treename,treedesc from ptrees");
          ptree.setParamid("treeid");
          ptree.setParampid("");
          ptree.setParamtext("treedesc");
          ptree.setTreename("PTree");
          ptree.setTreepath("st.system.action.tree");
          crjava.createJava(ptree);
      } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
  }

}
