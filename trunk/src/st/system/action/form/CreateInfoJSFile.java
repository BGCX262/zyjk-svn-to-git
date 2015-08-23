package st.system.action.form;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import st.platform.utils.BusinessDate;
import st.platform.utils.Config;
import st.system.dao.PtactionsBean;
import st.system.dao.PtformBean;
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
public class CreateInfoJSFile extends CreateCommonFileUtil {
   
   
    private OutputStreamWriter  fos;
    
    /**
     * 头文件的信息
     * @throws Exception 
     *
     */
    public void createImport(String namespace) throws Exception{
        
        fos.write(("/****************************************************\n"));
        fos.write((" * <p>处理内容：</p>\n"));
        fos.write((" * <p>Copyright: Copyright (c) "+BusinessDate.getToday().substring(0, 4)+"</p>;\n"));
        fos.write((" * @author  ;\n"));
        fos.write((" * 改版履历;\n"));
        fos.write((" * Rev - Date ------- Name ---------- Note -------------------\n"));
        fos.write((" * 1.0  "+BusinessDate.getToday()+"               新規作成 ;\n"));
        fos.write((" ****************************************************/\n"));
       
    }
    
    /**
     * js参数
     * @throws Exception
     */
    public void getParem() throws Exception
    {
        fos.write(" \n");
        fos.write("        var actionurl;\n");
        fos.write("\n");
    }
    
    /**
     * js参数
     * @throws Exception
     */
    public void getSUBMIT() throws Exception
    {
        fos.write("         /* 提交*/\n");
        fos.write("         function submitHandler() {\n");
        fos.write("           $(\"#subButton\").attr(\"disabled\", true);\n");
        fos.write("           $.post(actionurl,$(\"form:first\").serialize(),function(data){\n");
        fos.write("           $(\"#subButton\").removeAttr('disabled'); \n");
        fos.write("           if(data.checkFlag==MSG_SUCCESS)\n");
        fos.write("           {\n");
        fos.write("                parent.f_search();\n");
        fos.write("                $.ligerDialog.success(data.checkMessage);\n");
        fos.write("            }else{\n");
        fos.write("                 $.ligerDialog.error(data.checkMessage);\n");
        fos.write("            }\n");
        fos.write("             },\"json\").error(function() { \n");
        fos.write("             $(\"#subButton\").removeAttr('disabled'); \n");
        fos.write("             $.ligerDialog.error(MSG_LOAD_FALL);\n");
        fos.write("             });\n");
        fos.write("        } \n");
        fos.write(" \n");
    }
    
    
    
    //初始代码
    public void getInit(PtformBean ptform) throws Exception{
        String namespace = ptform.getActionname()+"_";
        fos.write("        $(function () {\n");
        fos.write("        try {\n");
        fos.write("             var method = $(\"#method\").val();  \n");
        fos.write("             if(method==\"add\"){\n");
        fos.write("               actionurl=webpath+\""+namespace+"_insert.action\";\n");
        fos.write("             }else if(method==\"look\"){\n");
        fos.write("               $(\"#subButton\").hide();\n");
        fos.write("             }else if(method==\"update\"){\n");
        fos.write("                actionurl=webpath+\""+namespace+"_update.action\";\n");
        fos.write("             } \n");
        fos.write("             \n");
        fos.write("         /*返回信息状态*/\n");
        fos.write("         var strFlag = $(\"#flag\").val();\n");
        fos.write("         var strMessage = $(\"#message\").val();\n");
        fos.write("         if(strFlag!=MSG_SUCCESS)\n");
        fos.write("         {  \n");
        fos.write("             $.ligerDialog.error(strMessage);\n");
        fos.write("          }\n");
        fos.write("        \n");
        fos.write("         \n");
        fos.write("         /*关闭按钮*/\n");
        fos.write("          $(\"#colButton\").click(function () {\n");
        fos.write("                 parent.myWindow.close();       \n");
        fos.write("             });\n");
        fos.write("          \n");
        fos.write("          /*验证样式提交*/\n");
        fos.write("          var v = Form();\n");
        fos.write("          $(\"form\").ligerForm();\n");
        fos.write("             \n");
        fos.write("          }catch (e) {\n");
        fos.write("            $(\"#subButton\").removeAttr('disabled'); \n");
        fos.write("                $.ligerDialog.error(e.message);\n");
        fos.write("       }\n");
        fos.write("        }); \n");
        fos.write("        \n");
        fos.write("         \n");
        fos.write("      \n");
    }
    
    
    /**
     * 
     * @param ptgrid
     * @throws Exception
     */
    public void createJS(PtformBean ptform)throws Exception
    {
        String gridName = ptform.getFormname();
        String jspName = ptform.getFormname().toLowerCase();
        String namespace = ptform.getFormpath();
        
        String engPath = Config.getProperty("file");
        String filepath = engPath+"/WebRoot/"+namespace+"/"+jspName;
        
        PtactionsBean ptactions = new PtactionsBean();
        ptactions =  (PtactionsBean) ptactions.findFirstByWhere(" where actionname='"+ptform.getActionname()+"'");
        
        
     
       FileOutputStream  stream = new FileOutputStream(filepath+".js"); 

       
       fos = new OutputStreamWriter(stream,"UTF-8"); 
       //头文件
       createImport(namespace+"/"+jspName);
       //参数
       getParem();
       //提交
       getSUBMIT();
       //     初始代码
       ptform.setActionname(ptactions.getNamespace()+"/"+ptactions.getActionname());
       getInit(ptform);
       
       fos.write((""));

        
    

       fos.flush();  
        fos.close(); 
     
    }
    
    
   
    }

