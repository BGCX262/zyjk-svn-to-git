package st.system.action.form;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import st.platform.utils.BusinessDate;
import st.platform.utils.Config;
import st.system.dao.PtgridsBean;
import st.system.dao.PtgridscolumnBean;

/**
 * <p>处理内容：创建jsp文件 主要有添加function 修改function 查询function 
 * </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * @author  方立文
 * 改版履历
 * Rev - Date ------- Name ---------- Note --------------------------------
 * 1.0   2010.9.17    方立文           新規作成 
 */
public class CreateListJSPFile extends CreateCommonFileUtil {
   
   
    private OutputStreamWriter  fos;
    
    /**
     * 头文件的信息
     * @throws Exception 
     *
     */
    public void createImport(String namespace,String filename) throws Exception{
        
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
        fos.write(("<%@ page language=\"java\"  pageEncoding=\"UTF-8\"%>\n"));
        fos.write(("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"));
        fos.write(("<html>\n"));
        fos.write(("<%@ include file=\"/global.jsp\"%>\n"));
        fos.write((" <head>\n"));
        fos.write((" <title></title>\n"));
        fos.write(("     <script language=\"javascript\" src=\"<%=webpath%>"+namespace+"/"+filename+".js\"></script>\n "));
        fos.write((" </head>\n"));
        fos.write(("  <body  class=\"bodystyle\">\n"));
        fos.write(("  <div id=\"layout\">\n"));
    }
    
    /**
     * 页面结束
     * @throws Exception
     */
    public void getEnd() throws Exception
    {
        fos.write(("</div>  \n"));
        fos.write(("</body>  \n"));
        fos.write(("</html> \n"));
    }
    
    /**
     * 树形
     * @param gridname
     * @throws IOException 
     */
    public void getTREE() throws IOException
    {
        fos.write((" <!-- TREE区域 -->\n"));
        fos.write((" <div position=\"left\" title=\"菜单\"> <ul id=\"tree\"  style=\"margin-top:3px;\"> </div>\n"));
      
    }
    
   
    
    /**
     * 中间区域
     * @throws Exception 
     * 
     */
    public void getGrid(List<PtgridscolumnBean> list) throws Exception{
        
        fos.write((" <!-- 中间区域 -->\n"));
        fos.write((" <div class=\"lay-center-out\"  position=\"center\"  style=\"border: 0\"  >\n"));
        if(list.size()>0)
        {
            fos.write(("   <!-- 查询区域 -->\n"));
            fos.write(("    <div>\n"));
            fos.write(("    <table class=\"table_search_layout_1\"    cellpadding=\"0\" cellspacing=\"0\"  >\n"));
            //1 3个查询条件
            if(list.size()<4)
            {
                fos.write(("    <tr>\n"));
                for(int i=0;i<list.size();i++)
                {
                    fos.write(("  <td class=\"l-table-edit-td-right\" >"+list.get(i).getColumndesc()+"：</td> \n"));
                    fos.write(("  <td class=\"l-table-edit-td-left\" >   \n"));
                    fos.write(("  <input name=\""+list.get(i).getColumnname()+"\" type=\"text\" id=\""+list.get(i).getColumnname()+"\" ltype=\"text\"  />   \n"));
                    fos.write(("  </td> \n"));
                }
                fos.write(("<td align=\"left\">\n"));
                fos.write(("<input id=\"searchButton\"   class=\"l-button l-button-submit\" type=\"l-button l-button-submit\" value=\" 查询 \" onclick=\"f_search()\" />\n"));
                fos.write((" </td> \n"));
                fos.write((" </tr>\n"));
            }else
            {
                int sta = list.size()-(list.size()/2);
//              2 4个以及以上的查询条件
                fos.write(("<tr>\n"));
                for(int i=0;i<sta-1;i++)
                {
                   
                    fos.write(("  <td class=\"l-table-edit-td-right\" >"+list.get(i).getColumndesc()+"：</td> \n"));
                    fos.write(("  <td class=\"l-table-edit-td-left\" >   \n"));
                    fos.write(("  <input name=\""+list.get(i).getColumnname()+"\" type=\"text\" id=\""+list.get(i).getColumnname()+"\" ltype=\"text\"  />   \n"));
                    fos.write(("  </td> \n"));
                    
                }
                fos.write(("<td align=\"left\">\n"));
                fos.write(("<input id=\"searchButton\"   class=\"l-button l-button-submit\" type=\"l-button l-button-submit\" value=\" 查询 \" onclick=\"f_search()\" />\n"));
                fos.write((" </td> \n"));
                fos.write((" </tr>\n"));
                fos.write(("<tr>\n"));
                for(int i=sta;i<list.size();i++)
                {
                   
                    fos.write(("  <td class=\"l-table-edit-td-right\" >"+list.get(i).getColumndesc()+"：</td> \n"));
                    fos.write(("  <td class=\"l-table-edit-td-left\" >   \n"));
                    fos.write(("  <input name=\""+list.get(i).getColumnname()+"\" type=\"text\" id=\""+list.get(i).getColumnname()+"\" ltype=\"text\"  />   \n"));
                    fos.write(("  </td> \n"));
                    
                }
                fos.write(("<td align=\"left\">\n"));
                fos.write((" </td> \n"));
                fos.write((" </tr>\n"));
                
                
            }
            fos.write(("    </table>\n"));
            fos.write(("    </div>\n"));
        }
        fos.write(("   <!-- grid区域 -->\n"));
        fos.write(("  <div id=\"mainGrid\"></div>\n"));
        fos.write(("  </div>\n"));
    }
    
    
    /**
     * 
     * @param ptgrid
     * @throws Exception
     */
    
    
    public void createJSP(PtgridsBean ptgrid)throws Exception
    {
        String gridName = ptgrid.getGridname();
        String jspName = ptgrid.getFieldname();
        String namespace = ptgrid.getFieldpath();
        
        String engPath = Config.getProperty("file");
        String filepath = engPath+"/WebRoot/"+namespace+"/"+jspName;
        
     
       FileOutputStream  stream = new FileOutputStream(filepath+".jsp"); 

       
       fos = new OutputStreamWriter(stream,"UTF-8"); 
       createImport(ptgrid.getFieldpath(),ptgrid.getFieldname());
       getTREE();
       PtgridscolumnBean ptgridscolumn=new PtgridscolumnBean();
       List<PtgridscolumnBean> columnlist  = ptgridscolumn.findByWhere(" where gridname ='"+ptgrid.getGridname()+"' and isfind = '1'");
       getGrid(columnlist);
       getEnd();
       
       fos.write((""));

        
    

       fos.flush();  
        fos.close(); 
     
    }
    
    
   
    }

