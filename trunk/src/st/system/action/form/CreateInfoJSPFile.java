package st.system.action.form;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.utils.BusinessDate;
import st.platform.utils.Config;
import st.system.dao.PtformBean;
import st.system.dao.PtformlabelBean;
import st.system.dao.PtgridsBean;
import st.system.dao.PtgridscolumnBean;

/**
 * <p>处理内容：创建js文件 主要有添加function 修改function 查询function 
 * </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * @author  方立文
 * 改版履历
 * Rev - Date ------- Name ---------- Note --------------------------------
 * 1.0   2010.9.17    方立文           新規作成 
 */
public class CreateInfoJSPFile extends CreateCommonFileUtil {
   
    /**
    * map中的数据用于自动生成页面的标签 已经标签的中文名称 
    * @param action  会话层定义的action
    * @param classPath
    * @throws Exception
    */
    private OutputStreamWriter  fos;
    
    /**
     * 头文件的信息
     * @throws Exception 
     *
     */
    public void createImport(String namespace, Map<String,String> map) throws Exception{
        
        fos.write(("<!--\n"));
        fos.write(("/****************************************************\n"));
        fos.write((" * <p>处理内容：</p>\n"));
        fos.write((" * <p>Copyright: Copyright (c) 2010</p>;\n"));
        fos.write((" * @author  ;\n"));
        fos.write((" * 改版履历;\n"));
        fos.write((" * Rev - Date ------- Name ---------- Note -------------------\n"));
        fos.write((" * 1.0  "+BusinessDate.getToday()+"               新規作成 ;\n"));
        fos.write((" ****************************************************/\n"));
        fos.write(("-->\n"));
        fos.write(("<%@ page language=\"java\" import=\"UI.dao.*,st.system.dao.*,st.portal.action.*\" pageEncoding=\"UTF-8\"%>\n"));
        fos.write(("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"));
        fos.write(("<html>\n"));
        fos.write(("<%@ include file=\"/global.jsp\"%>\n"));
        fos.write((" <head>\n"));
        fos.write((" <title></title>\n"));
        fos.write((" <%\n"));
        for(Object obj:map.keySet())
        {
            String tablename = obj.toString();
            String bean = tablename.substring(0, 1).toUpperCase() + tablename.substring(1, tablename.length()).toLowerCase() + "Bean";
            String parem = tablename.substring(0, 1).toLowerCase() + tablename.substring(1, tablename.length()).toLowerCase() + "Bean";
            fos.write((" "+bean+" "+ parem+" = ("+bean+")request.getAttribute(\""+ parem+"\");\n"));
            fos.write(("  if( "+ parem+" ==null)\n"));
            fos.write(("  {\n"));
            fos.write(("        "+ parem+"  = new "+bean+"();\n"));
            fos.write(("  }\n"));
        }
        fos.write((" MessageBean messageBean = (MessageBean)request.getAttribute(\"messageBean\");\n"));
        fos.write(("  if(messageBean==null)\n"));
        fos.write(("  {\n"));
        fos.write(("      messageBean = new MessageBean();\n"));
        fos.write(("  }\n"));
        
        
        fos.write((" %>\n"));     
        fos.write(("    <script language=\"javascript\" src=\"<%=webpath%>/"+namespace+".js\"></script>\n "));
        fos.write((" </head>\n"));
        fos.write(("  <body class=\"menubody\" style=\"width: 580\">\n"));
        fos.write(("  <div class=\"searchtitle\">        \n"));
        fos.write(("  <img width=\"20\" height=\"20\" src=\"<%=webpath%>/js/ligerUI/skins/icons/customers.gif\"/> \n"));
        fos.write(("   </div>        \n"));
        fos.write(("   <div class=\"navline\" ></div>       \n"));
        
    }

    /**
     * form表单区
     * @throws Exception
     */
    public void getForm(List<PtformlabelBean> list,List<PtformlabelBean> lablist) throws Exception
    {
        fos.write("\n");
        fos.write("<form name=\"form\" method=\"post\"  id=\"form\">\n");
        //隐藏区域
        fos.write("     <div>\n");
       
        fos.write("         <!-- 操作method -->           \n");
        fos.write("         <input type=\"hidden\" id=\"method\" name=\"messageBean.method\" value=\"<%=messageBean.getMethod() %>\"/>\n");
        fos.write("         <!-- 操作状态flag -->   \n");
        fos.write("         <input type=\"hidden\" id=\"flag\" name=\"flag\" value=\"<%=messageBean.getCheckFlag() %>\"/>\n");
        fos.write("         <!-- 操作message信息 -->    \n");
        fos.write("         <input type=\"hidden\" id=\"message\" name=\"message\" value=\"<%=messageBean.getCheckMessage() %>\"/>\n");
        for(int i=0;i<list.size();i++)
        {
            PtformlabelBean ptform = list.get(i);
            String table=ptform.getTablename()+"Bean";
            String label = ptform.getLabelid();
            String value = table+".get"+label.substring(0, 1).toUpperCase() + label.substring(1, label.length()).toLowerCase()+"()";
            fos.write("         <!-- "+ptform.getLabeldesc()+" -->\n");
            fos.write("         <input type=\"hidden\" id=\""+ptform.getLabelid()+"\" name=\""+ptform.getLabelname()+"\" value=\"<%="+value+" %>\"/>\n");
        }
        fos.write("     </div>\n");
        //文本区域
        fos.write("        <table cellpadding=\"0\" cellspacing=\"0\" class=\"form-l-table-edit\" >\n");
        for(int i=0;i<lablist.size();i++)
        {
            PtformlabelBean ptform = lablist.get(i);
            if(ptform.getIsonly().equals(1))
            {
                fos.write("            <tr>\n");
                fos.write("                <td class=\"l-table-edit-td-right\">"+lablist.get(i).getLabeldesc()+"</td>\n");
                fos.write("                <td class=\"l-table-edit-td-left\" colspan=\"4\" >\n");
                fos.write("                   "+getLabel(lablist.get(i)));
                fos.write("                </td>\n");
                fos.write("                <td class=\"td_message\"></td>\n");
                fos.write("            </tr>\n");
            }
            else{
                if(i%2==0)
                {
                    fos.write("            <tr>\n");
                }
                fos.write("                <td class=\"l-table-edit-td-right\">"+lablist.get(i).getLabeldesc()+"</td>\n");
                fos.write("                <td class=\"l-table-edit-td-left\" style=\"width:160px\">\n");
                fos.write("                   "+getLabel(lablist.get(i)));
                fos.write("                </td>\n");
                fos.write("                <td class=\"td_message\"></td>\n");
                if(lablist.size()>i+1)
                {
                    //是第一个 并且下一个label独占一行
                    if(i%2==0&&ptform.getIsonly().equals(1))
                    {
                        fos.write("                <td class=\"l-table-edit-td-right\"></td>\n");
                        fos.write("                <td class=\"l-table-edit-td-left\" style=\"width:160px\">\n");
                        fos.write("                </td>\n");
                        fos.write("                <td class=\"td_message\"></td>\n");
                    }
                }
                //是最后一个 并且需要
                if(i%2==0&&lablist.size()==i-1)
                {
                    fos.write("                <td class=\"l-table-edit-td-right\"></td>\n");
                    fos.write("                <td class=\"l-table-edit-td-left\" style=\"width:160px\">\n");
                    fos.write("                </td>\n");
                    fos.write("                <td class=\"td_message\"></td>\n");
                }
                if(i%2==1)
                {
                    fos.write("            </tr>\n");
                }
            }
        }
        
        
        fos.write("        </table>\n");
        
        
        fos.write(" <br />\n");
        fos.write("<table align=\"center\">\n");
        fos.write("<tr>\n");
        fos.write(" <td>\n");
        fos.write("     <input type=\"submit\" value=\"提交\" id=\"subButton\" class=\"l-button l-button-submit\" /> \n");
        fos.write("     <input type=\"button\" value=\"关闭\" id=\"colButton\" class=\"l-button l-button-test\"/>\n");
        fos.write(" </td>\n");
        fos.write("</tr>\n");
        fos.write(" \n");
        fos.write("</table>\n");
        fos.write(" </form>\n");
        fos.write("    \n");
    }
    
    
    /**
     * 页面结束
     * @throws Exception
     */
    public void getEnd() throws Exception
    {
        fos.write(("</body>  \n"));
        fos.write(("</html> \n"));
    }
      
     /**
      * 取到标签的类型
      *
      */   
   public String getLabel(PtformlabelBean formBean){
    
       String label ="";
      
       String name=formBean.getTablename()+"Bean."+formBean.getLabelid();
       String id = formBean.getLabelid();
       
       String table=formBean.getTablename()+"Bean";
       String value = table+".get"+id.substring(0, 1).toUpperCase() + id.substring(1, id.length()).toLowerCase()+"()";
       String type = formBean.getLabeltype();
       if(type.equals("text")){
            label ="<input name=\""+name+"\" type=\"text\" id=\""+id+"\"" +
                " value=\"<%="+value+" %>\" " +
           "ltype=\"text\" validate=\"{required:true,minlength:0,maxlength:"+formBean.getColumnlength()+"}\" />\n";
       }else if(type.equals("dropdown")){
           label="<%"+
           "DBSelect dbsel = new DBSelect(\"city\", \"CHKRESULT\",demoBean.getCity());"+
           "dbsel.addAttr(\"style\", \"width: 100%\");"+
           "dbsel.addAttr(\"notnull\", \"true\");"+
           "dbsel.addAttr(\"name\", \"demoBean.city\");"+
           "dbsel.setDisplayAll(false);"+
           "out.print(dbsel);"+
          "%>";
       }else if(type.equals("textarea")){
           label ="<textarea cols=\"110\"  rows=\"3\" class=\"l-textarea\" name=\""+name+"\"  id=\""+id+"\"  style=\"width:430px\" " +
                "\"validate=\"{required:true}\" ><%="+value+"%></textarea>\"";
       }else if(type.equals("radio")){
           label="<%"+
            "DBRadio dbrad = new DBRadio(\"contacttitle\",\"demoBean.contacttitle\",\"SEX\",demoBean.getContacttitle());"+
            "out.print(dbrad.toString());"+
            "%>";
           
       }else if(type.equals("checkbox")){
           label="<%"+
            "DBCheckBox check = new DBCheckBox(\"country\",\"demoBean.country\",\"CHKRESULT\",demoBean.getCountry());"+
            "out.print(check.toString());"+
            "%>";
       }else if(type.equals("data")){
           label ="<input name=\""+name+"\" type=\"text\" id=\""+id+"\"" +
           " value=\"<%="+value+" %>\" " +
           "ltype=\"date\" validate=\"{required:true}\"/>\n";
       }
       
       return label;
   }
   
    
    
    /**
     * 
     * @param ptgrid
     * @throws Exception
     */
    public void createJSP(PtformBean ptform)throws Exception
    {
        String gridName = ptform.getFormname();
        String jspName = ptform.getFormname().toLowerCase();
        String namespace = ptform.getFormpath();
        
        String engPath = Config.getProperty("file");
        String filepath = engPath+"/WebRoot/"+namespace+"/"+jspName;
        
     
       FileOutputStream  stream = new FileOutputStream(filepath+".jsp"); 

       PtformlabelBean formlabel = new PtformlabelBean();
       List<PtformlabelBean> hidlist =  formlabel.findByWhere(" where formid='"+ptform.getFormid()+"' and ishidden='1'");
       List<PtformlabelBean> lablist =formlabel.findByWhere(" where formid='"+ptform.getFormid()+"' and ishidden='0'");
       
       Map<String,String> map = new HashMap<String, String>();
       for(int i=0;i<lablist.size();i++)
       {
           map.put(lablist.get(i).getTablename(), lablist.get(i).getTablename());
       }
       
       fos = new OutputStreamWriter(stream,"UTF-8"); 
       //头文件
       createImport(namespace+"/"+jspName,  map);
       getForm( hidlist, lablist);
       getEnd();
       
       fos.write((""));

        
    

       fos.flush();  
        fos.close(); 
     
    }
    
    
    }

