package st.system.listener.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 初始化系统资源
 * @author Administrator
 *
 */
public class InitServlet extends HttpServlet {
   

    /** 
     * Initialization of the servlet. <br> 
     *  
     * @throws ServletException 
     *             if an error occurs 
     */  
    private static final long serialVersionUID = 1L;  
    // private SystemParamServicesImpl sysParamService;  
 
    public void init() throws ServletException {  
        // Put your code here  
        //枚举
        //Grid
        //部门
        //人员
        
        //将查询结果放入application中
        ServletContext application=this.getServletContext();  
        
        //application.setAttribute("enterNOByWghcode", enterNOByWghcode);
    }  
    /** 
     * Constructor of the object. 
     */  
    public InitServlet() {  
        super();  
    }  
    /** 
     * Destruction of the servlet. <br> 
     */  
    public void destroy() {  
        super.destroy(); // Just puts "destroy" string in log  
        // Put your code here  
    }  
   
    
}
