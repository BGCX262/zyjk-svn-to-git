package st.system.action.form;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import UI.action.demo.DemoAction;
import UI.dao.DemoBean;
import UI.message.MisConstant;

import st.platform.db.SerialNumber;
import st.platform.utils.BusinessDate;
import st.platform.utils.Config;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.system.dao.PtableBean;
import st.system.dao.PtablecolumnBean;
import st.system.dao.PtactionsBean;

/**
 * <p>
 * 处理内容：创建java文件 有增 删 改 查询单条信息的功能
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * 
 * @author 方立文 改版履历 Rev - Date ------- Name ---------- Note
 *         -------------------------------- 1.0 2010.9.17 方立文 新規作成
 */
public class CreateJAVAFile extends CreateCommonFileUtil {
    /**
     * 写入package头文件
     * 
     * @param packageStr
     */
    private void generateHead(String packageStr) {
        try {
            packageStr   =  packageStr.replaceAll("/", ".");
            packageStr = packageStr.substring(1,packageStr.length());
            
            fos.write(("/****************************************************\n"));
            fos.write((" * <p>处理内容：</p>\n"));
            fos.write((" * <p>Copyright: Copyright (c) 2010</p>;\n"));
            fos.write((" * @author  ;\n"));
            fos.write((" * 改版履历;\n"));
            fos.write((" * Rev - Date ------- Name ---------- Note -------------------\n"));
            fos.write((" * 1.0  " + BusinessDate.getToday() + "               新規作成 ;\n"));
            fos.write((" ****************************************************/\n"));
            fos.write(("package " + packageStr + ";\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入import头文件
     * 
     */
    private void generateImport(String BeanName) {
        try {
           
            PtableBean ptable = new PtableBean();
            String [] beans = BeanName.split(",");
            
          
             fos.write( "\n import org.apache.log4j.Logger;" );
             fos.write( "\n import org.apache.struts2.convention.annotation.Action;" );
             fos.write( "\n import org.apache.struts2.convention.annotation.Namespace;" );
             fos.write( "\n import org.apache.struts2.convention.annotation.ParentPackage;" );
             fos.write( "\n import org.apache.struts2.convention.annotation.Result;" );
             fos.write("\n " );
             fos.write( "\n import st.platform.db.SerialNumber;" );
             fos.write("\n import st.portal.action.BasicAction;" );
             fos.write("\n import st.portal.action.MessageBean;");
             fos.write( "\n import st.portal.action.PageBean;" );
             fos.write("\n import UI.message.MisConstant;" );
             fos.write("\n import UI.util.BusinessDate;");
             
            // ptable =PtableBean.findFirst(" Where beanname = '"+BeanName+"'");
             fos.write("\n import UI.dao.enterfile.*;");
             fos.write("\n import UI.dao.zyjk.*;");
             fos.write("\n import st.system.dao.*;");
             fos.write("\n");
          
        } catch ( Exception e ) {
            e.printStackTrace();
        }
   }

    /**
     * 属性内容
     * 
     * @param ptactionBean
     * @throws Exception
     */
    public void getParams(String Beanname, String paramBean, String className) throws Exception {

        fos.write(("\n"));
        fos.write(("\n"));
        fos.write(("\tprivate static final long serialVersionUID = 1L;\n")); // add
                                                                                // by
                                                                                // Flw,2010.09.19
                                                                                // 序列化
        fos.write(("\t private static Logger logger = Logger.getLogger(" + className + ".class);\n"));

        fos.write(("\t private " + Beanname + " " + paramBean + "; // 返回的信息;\n"));
        fos.write(("\n"));

        fos.write(("\t private String strWhere=\"\"; // 查询条件;\n"));
        fos.write(("\n"));

        fos.write(("\t private String strSysno=\"\"; // 主键编号;\n"));
        fos.write(("\n"));

        fos.write(("\t private PageBean pageBean; // 分页类;\n"));
        fos.write(("\n"));

        fos.write(("\t private MessageBean messageBean;// 操作状态\n"));
        fos.write(("\n"));
    }

    /**
     * 添加方法
     * 
     * @param Beanname
     *            对象
     * @param paramBean
     *            对象属性名称
     * @param className
     *            类名称
     * @param tableName
     *            表名称
     * @param keyMethod
     *            主键名称
     * @throws Exception
     */
    public void getAddMath(String Beanname, String paramBean, String className, String tableName, String keyMethod)
            throws Exception {

        String setMethod = "set" + keyMethod;
        fos.write(("\t/**\n"));
        fos.write(("\t*  \n"));
        fos.write(("\t*添加方法\n"));
        fos.write(("\t* @return \n"));
        fos.write(("\t*/  \n"));
        fos.write(("\t @Action(value = \"" + className + "_insert\") \n"));
        fos.write(("   public String insert() {\n"));
        fos.write(("\t try {\n"));
        fos
                .write(("\t  String number = BusinessDate.getNoFormatToday() + \"-\" + SerialNumber.getNextSerialNo(\"67\");\n"));
        fos.write(("\t  " + paramBean + "." + setMethod + "(number);\n"));
        fos.write(("\t  messageBean = insert(" + paramBean + ");\n"));

        fos.write(("\t } catch (Exception e) {;\n"));
        fos.write(("\t // TODO Auto-generated catch block\n"));
        fos.write(("\t // 设置错误返回的提示\n"));
        fos.write(("\t logger.error(MisConstant.MSG_OPERATE_FAIL, e);\n"));
        fos.write(("\t messageBean.setCheckFlag(MisConstant.MSG_FAIL);\n"));
        fos.write(("\t messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);\n"));
        fos.write(("\t }\n"));
        fos.write(("\t return MisConstant.RETMESSAGE;\n"));
        fos.write(("\t\t}\n"));
        fos.write(("\n"));

    }

    /**
     * 修改方法
     * 
     * @param Beanname
     *            对象
     * @param paramBean
     *            对象属性名称
     * @param className
     *            类名称
     * @param tableName
     *            表名称
     * @param keyMethod
     *            主键名称
     * @throws Exception
     */
    public void getUpdatMethod(String Beanname, String paramBean, String className, String tableName, String keyMethod)
            throws Exception {

        String getMethod = "get" + keyMethod;

        fos.write(("\t/**\n"));
        fos.write(("\t*  \n"));
        fos.write(("\t* 修改方法\n"));
        fos.write(("\t* @return \n"));
        fos.write(("\t*/  \n"));
        fos.write(("\t @Action(value = \"" + className + "_update\") \n"));
        fos.write(("   public String update() {\n"));
        fos.write(("\t try {\n"));
        fos.write(("\t \n"));
        fos.write(("\t  messageBean =  update(" + paramBean + ", \" where " + keyMethod + " ='\" + " + paramBean + "."
                + getMethod + "() + \"'\");;\n"));
        fos.write(("\t \n"));
        fos.write(("\t } catch (Exception e) {;\n"));
        fos.write(("\t // TODO Auto-generated catch block\n"));
        fos.write(("\t // 设置错误返回的提示\n"));
        fos.write(("\t logger.error(MisConstant.MSG_OPERATE_FAIL, e);\n"));
        fos.write(("\t messageBean.setCheckFlag(MisConstant.MSG_FAIL);\n"));
        fos.write(("\t messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);\n"));
        fos.write(("\t }\n"));
        fos.write(("\t return MisConstant.RETMESSAGE;\n"));
        fos.write(("\t\t}\n"));
        fos.write(("\n"));

    }

    /**
     * 删除方法
     * 
     * @param Beanname
     *            对象
     * @param paramBean
     *            对象属性名称
     * @param className
     *            类名称
     * @param tableName
     *            表名称
     * @param keyMethod
     *            主键名称
     * @throws Exception
     */
    public void getDeleteMethod(String Beanname, String paramBean, String className, String tableName, String keyMethod)
            throws Exception {

        String getMethod = "get" + keyMethod;

        fos.write(("\t/**\n"));
        fos.write(("\t*  \n"));
        fos.write(("\t* 删除改方法\n"));
        fos.write(("\t* @return \n"));
        fos.write(("\t*/  \n"));
        fos.write(("\t @Action(value = \"" + className + "_delete\") \n"));
        fos.write(("   public String delete() {\n"));
        fos.write(("\t try {\n"));
        fos.write(("\t " + paramBean + " = new " + Beanname + "();\n"));
        fos.write(("\t  messageBean =  delete(" + paramBean + ", \" where " + keyMethod + " ='\" + " + paramBean + "."
                + getMethod + "() + \"'\");\n"));
        fos.write(("\t \n"));
        fos.write(("\t } catch (Exception e) {;\n"));
        fos.write(("\t // TODO Auto-generated catch block\n"));
        fos.write(("\t // 设置错误返回的提示\n"));
        fos.write(("\t logger.error(MisConstant.MSG_OPERATE_FAIL, e);\n"));
        fos.write(("\t messageBean.setCheckFlag(MisConstant.MSG_FAIL);\n"));
        fos.write(("\t messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);\n"));
        fos.write(("\t }\n"));
        fos.write(("\t return MisConstant.RETMESSAGE;\n"));
        fos.write(("\t\t}\n"));
        fos.write(("\n"));
    }

    /**
     * 查询返回json方法
     * 
     * @param Beanname
     *            对象
     * @param paramBean
     *            对象属性名称
     * @param className
     *            类名称
     * @param tableName
     *            表名称
     * @param keyMethod
     *            主键名称
     * @throws Exception
     */
    public void getFindJsonMethod(String Beanname, String paramBean, String className, String tableName,
            String keyMethod) throws Exception {

        String getMethod = "get" + keyMethod;

        fos.write(("\t/**\n"));
        fos.write(("\t*  \n"));
        fos.write(("\t* 查询信息 返回json信息\n"));
        fos.write(("\t* @return \n"));
        fos.write(("\t*/  \n"));
        fos.write(("\t @Action(value = \"" + className + "_findObjson\", results = { \n"));
        fos
                .write(("\t  @Result(type = \"json\", name = MisConstant.FINDOBJSON, params = { \"includeProperties\",\"messageBean.*,"
                        + paramBean + ".*\" }) }) \n"));
        fos.write(("   public String findObjson() {\n"));
        fos.write(("\t try {\n"));
        fos.write(("\t " + paramBean + " = new " + Beanname + "();\n"));
        fos.write(("\t  if (!(messageBean.getMethod().equals(\"add\"))) {\n"));
        fos
                .write(("\t  " + paramBean + " = (" + Beanname + ")findByKey(" + paramBean + ", \" where " + keyMethod + " ='\" + strSysno + \"'\");\n"));
        fos.write(("\t  if (" + paramBean + " != null) {\n"));
        fos.write(("\t  messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);\n"));
        fos.write(("\t  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);\n"));
        fos.write(("\t   }else{\n"));
        fos.write(("\t  messageBean.setCheckFlag(MisConstant.MSG_FAIL);\n"));
        fos.write(("\t  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);\n"));
        fos.write(("\t   }\n"));
        fos.write(("\t   }\n"));
        fos.write(("\t } catch (Exception e) {;\n"));
        fos.write(("\t // TODO Auto-generated catch block\n"));
        fos.write(("\t // 设置错误返回的提示\n"));
        fos.write(("\t logger.error(MisConstant.MSG_OPERATE_FAIL, e);\n"));
        fos.write(("\t messageBean.setCheckFlag(MisConstant.MSG_FAIL);\n"));
        fos.write(("\t messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);\n"));
        fos.write(("\t }\n"));
        fos.write(("\t return MisConstant.FINDOBJSON;\n"));
        fos.write(("\t\t}\n"));
        fos.write(("\n"));
    }

    /**
     * 查询返回jsp
     * 
     * @param Beanname
     *            对象
     * @param paramBean
     *            对象属性名称
     * @param className
     *            类名称
     * @param tableName
     *            表名称
     * @param keyMethod
     *            主键名称
     * @throws Exception
     */
    public void getFindMethod(String Beanname, String paramBean, String className, String tableName, String keyMethod,
            String jsp) throws Exception {

        String getMethod = "get" + keyMethod;

        fos.write(("\t/**\n"));
        fos.write(("\t*  \n"));
        fos.write(("\t* 查询信息 返回jsp\n"));
        fos.write(("\t* @return \n"));
        fos.write(("\t*/  \n"));
        fos.write(("\t @Action(value = \"" + className + "_findByKey\", results = { \n"));
        fos.write(("\t   @Result(name = MisConstant.FINDBYKEY, location = \"" + jsp + "\") }) \n"));
        fos.write(("   public String findByKey() {\n"));
        fos.write(("\t try {\n"));
        fos.write(("\t " + paramBean + " = new " + Beanname + "();\n"));
        fos.write(("\t  if (!(messageBean.getMethod().equals(\"add\"))) {\n"));
        fos
                .write(("\t  " + paramBean + " = (" + Beanname + ")findByKey(" + paramBean + ", \" where " + keyMethod + " ='\" + strSysno + \"'\");\n"));
        fos.write(("\t  if (" + paramBean + " != null) {\n"));
        fos.write(("\t  messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);\n"));
        fos.write(("\t  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);\n"));
        fos.write(("\t   }else{\n"));
        fos.write(("\t  messageBean.setCheckFlag(MisConstant.MSG_FAIL);\n"));
        fos.write(("\t  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);\n"));
        fos.write(("\t   }\n"));
        fos.write(("\t   }\n"));
        fos.write(("\t } catch (Exception e) {;\n"));
        fos.write(("\t // TODO Auto-generated catch block\n"));
        fos.write(("\t // 设置错误返回的提示\n"));
        fos.write(("\t logger.error(MisConstant.MSG_OPERATE_FAIL, e);\n"));
        fos.write(("\t messageBean.setCheckFlag(MisConstant.MSG_FAIL);\n"));
        fos.write(("\t messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);\n"));
        fos.write(("\t }\n"));
        fos.write(("\t return MisConstant.FINDBYKEY;\n"));
        fos.write(("\t\t}\n"));
        fos.write(("\n"));

    }

    /**
     * 查询分页
     * 
     * @param Beanname
     *            对象
     * @param paramBean
     *            对象属性名称
     * @param className
     *            类名称
     * @param tableName
     *            表名称
     * @param keyMethod
     *            主键名称
     * @throws Exception
     */
    public void getMethodFindList(String className, String GridName) throws Exception {

        fos.write(("\t/**\n"));
        fos.write(("\t*  \n"));
        fos.write(("\t* 分页查询\n"));
        fos.write(("\t* @return \n"));
        fos.write(("\t*/  \n"));
        fos.write(("\t @Action(value = \"" + className + "_findList\")\n"));
        fos.write(("   public String findList() {\n"));
        fos.write(("\t try {\n"));
        fos.write(("\t  messageBean = new MessageBean();\n"));
        fos.write(("\t  String strFSql =\"\";\n"));
        fos.write(("\t  pageBean = findList(strFSql, strWhere,\"\", pageBean);\n"));
        fos.write(("\t  messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);\n"));
        fos.write(("\t  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);\n"));
        fos.write(("\t } catch (Exception e) {;\n"));
        fos.write(("\t // TODO Auto-generated catch block\n"));
        fos.write(("\t // 设置错误返回的提示\n"));
        fos.write(("\t logger.error(MisConstant.MSG_OPERATE_FAIL, e);\n"));
        fos.write(("\t messageBean.setCheckFlag(MisConstant.MSG_FAIL);\n"));
        fos.write(("\t messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);\n"));
        fos.write(("\t }\n"));
        fos.write(("\t return MisConstant.FINDLIST;\n"));
        fos.write(("\t\t}\n"));
        fos.write(("\n"));

    }

    /**
     * 返回属性的get set 方法
     * 
     * @param Beanname
     * @param paramBean
     * @throws Exception
     */
    public void getParamMehtod(String Beanname, String paramBean, String className) throws Exception {

        fos.write(("\t public " + Beanname + " get" + Beanname + "() {\n"));
        fos.write(("\t return " + paramBean + ";\n"));
        fos.write(("\t }\n"));
        fos.write(("\t \n"));

        fos.write(("\t  public void set" + Beanname + "(" + Beanname + " " + paramBean + ") {\n"));
        fos.write(("\t  this." + paramBean + " = " + paramBean + ";\n"));
        fos.write(("\t }\n"));
        fos.write(("\t \n"));

        fos.write(("\t  public MessageBean getMessageBean() {\n"));
        fos.write(("\t  return messageBean;\n"));
        fos.write(("\t }\n"));
        fos.write(("\t \n"));

        fos.write(("\t  public void setMessageBean(MessageBean messageBean) {\n"));
        fos.write(("\t   this.messageBean = messageBean;\n"));
        fos.write(("\t }\n"));
        fos.write(("\t \n"));

        fos.write(("\t  public PageBean getPageBean() {\n"));
        fos.write(("\t  return pageBean;\n"));
        fos.write(("\t }\n"));
        fos.write(("\t \n"));

        fos.write(("\t  public void setPageBean(PageBean pageBean) {\n"));
        fos.write(("\t   this.pageBean = pageBean;\n"));
        fos.write(("\t }\n"));
        fos.write(("\t \n"));

        fos.write(("\t  public String getStrSysno() {\n"));
        fos.write(("\t  return strSysno;\n"));
        fos.write(("\t }\n"));
        fos.write(("\t \n"));

        fos.write(("\t  public void setStrSysno(String strSysno) {\n"));
        fos.write(("\t   this.strSysno = strSysno;\n"));
        fos.write(("\t }\n"));
        fos.write(("\t \n"));

        fos.write(("\t  public String getStrWhere() {\n"));
        fos.write(("\t  return strWhere;\n"));
        fos.write(("\t }\n"));
        fos.write(("\t \n"));

        fos.write(("\t  public void setStrWhere(String strWhere) {\n"));
        fos.write(("\t   this.strWhere = strWhere;\n"));
        fos.write(("\t }\n"));
        fos.write(("\t \n"));

    }

    /**
     * 组成方法
     * 
     * @param ptactionBean
     * @throws Exception
     */
    private OutputStreamWriter fos;

    @SuppressWarnings("unused")
    public void createJava(PtactionsBean ptactionBean) throws Exception {
        String className = ptactionBean.getActionname();
        String Beanname = ptactionBean.getBeanname();
        String [] strbean = Beanname.split(",");
        Beanname = strbean[0];
        String classPath = ptactionBean.getActionpath();
        if (className == null || Beanname == null || classPath == null) {
            System.out.println("Error!");
            return;
        }
        String tableName = Beanname.replace("Bean", "");

        PtablecolumnBean pcolumnBean = new PtablecolumnBean();
        pcolumnBean = (PtablecolumnBean) pcolumnBean.findFirstByWhere("Where tablename ='" + tableName + "' and iskey = 'PRI'");
        String paramKey = "";
        String keyMethod = "";
        if(pcolumnBean == null){
             pcolumnBean = new PtablecolumnBean();
            pcolumnBean = (PtablecolumnBean) pcolumnBean.findFirstByWhere("Where tablename ='" + tableName + "'");
        }
        if (pcolumnBean != null) {
            paramKey = pcolumnBean.getColumnname();
            keyMethod = "" + paramKey.substring(0, 1).toUpperCase()
                    + paramKey.substring(1, paramKey.length()).toLowerCase();
        }//当表中没有主键的时候 就查询出第一个
        else{
           
        }
        String paramBean = Beanname.replace("Bean", "").toLowerCase() + "Bean";
        String bean = Beanname.toLowerCase();

        // String gridName = ptactionBean.getGridname();
        String strJsp = ptactionBean.getInfopage();
        String namespace = "/" + classPath.replace('.', '/') + "/";

        String engPath = Config.getProperty("file");
        String filepath = "src/" + classPath.replace('.', '/') + "/";
        if (engPath != null) {
            filepath = engPath + "/src/" + classPath.replace('.', '/') + "/";
        }

        FileOutputStream stream = new FileOutputStream(filepath + className + ".java");

        fos = new OutputStreamWriter(stream, "UTF-8");
        // package
        generateHead(classPath);
        fos.write(("\n"));
        fos.write(("\n"));
        fos.write(("\n"));
        fos.write(("\n"));
        // 获取import
        generateImport(Beanname);
        fos.write(("@ParentPackage(\"struts-filter\")\n"));
        fos.write(("@Namespace(\"" + namespace + "\") \n"));
        fos.write(("public class " + className + " extends BasicAction {\n"));
      
        // 获取param属性
        getParams(Beanname, paramBean, className);

        // 分页查询
        // getMethodFindList(className, gridName);

        // 查询返回json object
        getFindJsonMethod(Beanname, paramBean, className, tableName, keyMethod);

        // 查询返回jsp
        getFindMethod(Beanname, paramBean, className, tableName, keyMethod, strJsp);

        // 添加方法
        getAddMath(Beanname, paramBean, className, tableName, keyMethod);

        // update方法
        getUpdatMethod(Beanname, paramBean, className, tableName, keyMethod);

        // 删除方法
        getDeleteMethod(Beanname, paramBean, className, tableName, keyMethod);

        // get set
        getParamMehtod(Beanname, paramBean, className);
        fos.write(("}\n"));
        fos.flush();
        fos.close();

        System.out.println("创建成功");
    }

    public static void main(String args[]) {
        CreateJAVAFile crjava = new CreateJAVAFile();
        try {
            PtactionsBean ptactionBean = new PtactionsBean();
            ptactionBean.setActionname("TextACTION");
            ptactionBean.setActiondesc("测试");
            ptactionBean.setActionpath("UI.action.demo");
            ptactionBean.setBeanname("DemoBean");
            ptactionBean.setInfopage("/system/demo/info.jsp");
            // ptactionBean.setGridname("GridName");
            crjava.createJava(ptactionBean);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
