package st.system.action.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import st.system.dao.PtactionsBean;
import st.system.dao.PtactionsmtdBean;

/**
 * 收集action的信息
 * 1 类名称
 * 2 package路径
 * 3 方法名称
 * 
 * @author Administrator
 *
 */
public class CollectAction {

    /**
     * @throws Exception 
     * 
     * 
     */
    public  String analyseAction(String  strFile) throws Exception{
        
        
       
        //Action类的方法名称
        Map<String,String> methodMap = new HashMap<String, String>();
        
        //名称空间
        String namespace ="";
        //action名称
        String pack[] = strFile.split("/");
        String actionName= pack[(pack.length-1)].replace(".java","");
        //action路径
         pack = strFile.split("src");
        String url =pack[1];
        
        String packs[] = url.split("/");
        url="";
        for(int i=1;i<packs.length-1;i++){
            url = url+"/"+packs[i];
        }
        //action中文说明
        String desc ="";
        //bean名称
        String bean ="";
        //infopage
        String info ="";
        
        if(actionName.equals("CollectAction")){
            return "";
        }
      
        FileInputStream inputstream = new FileInputStream(strFile);
        InputStreamReader red  = new InputStreamReader(inputstream,"UTF-8");
        String s;
        BufferedReader in = new BufferedReader(red);
        while ((s = in.readLine()) != null) {
           
            //命名空间
            if(s.indexOf("@Namespace")>=0){
               String strArr[] =  s.split("\"");
               namespace = strArr[1];
            }else if(s.indexOf("@Action")>0){
                
                String strArr[] =  s.split("\"");
                methodMap.put(strArr[1],strArr[1]);
            }else if(s.indexOf("处理内容")>0){
                String strArr[] =  s.split("：");
                System.out.println(s);
                desc = strArr[1].replace("</p>", "");
            }else if(s.indexOf("private")>0&&s.indexOf("Bean")>0)
            {
                if(s.indexOf("PageBean")>0||s.indexOf("MessageBean")>0)
                {
                    
                }else{
                    String strare[] = s.split(" ");
                    for(int i=0;i<strare.length;i++)
                    {
                        if(strare[i].indexOf("Bean")>0){
                            bean = bean +strare[i]+",";
                            break;
                        }
                    }
                   
                }
            }else if(s.indexOf(".jsp")>0)
            {
                String strArr[] =  s.split("\"");
                if(strArr.length>0){
                    info = strArr[1];
                }
            }
        }
        
        System.out.println("名称"+actionName);
        System.out.println("空间"+namespace);
        System.out.println(url);
        System.out.println("说明"+desc);
        System.out.println("bean"+bean);
        System.out.println("info"+info);
        
       
        
        ///////////////////操作插入数据库//////////////////////////
        if(namespace.length()>0)
        {
            PtactionsBean actionBean = new PtactionsBean();
            actionBean.setSysid(""+System.currentTimeMillis());
            actionBean.setActiondesc(desc);
            
            actionBean.setActionname(actionName);
            actionBean.setActionpath(url);
            actionBean.setBeanname(bean);
            actionBean.setNamespace(namespace);
            actionBean.setInfopage(info);
            actionBean.insert();
            
            PtactionsmtdBean method = new PtactionsmtdBean();
            
            int index = 1;
            for(Object obj:methodMap.keySet()){
                method.setSysid(System.currentTimeMillis()+"_"+(index++));
                method.setActionid(actionBean.getSysid());
                method.setMethod(obj.toString());
                method.setNamespace(namespace);
                method.setActionname(actionName);
                method.insert();
            }
        }
        return "";
    }
    
    public void method(File f) throws Exception
    {
        
        
        
        File[] FList = f.listFiles();
        for (int i = 0; i < FList.length; i++)
        {
            if (FList[i].isDirectory()==true)
            {
                method(FList[i]);
            }
            else
            {
                String path = FList[i].getAbsolutePath();
          
                if(path.indexOf("action")>0&&path.indexOf(".java")>0)
                {
                    CollectAction co = new CollectAction();
                    co.analyseAction(path.replace("\\", "/"));
                    System.out.println(FList[i].getAbsolutePath());
                }
                
            }
        }
        
       
    }
    
    public static void main(String args[])
    {
        CollectAction co = new CollectAction();
        try {
            File file = new File("F:/Work4/zpf2/src/");
            co.method(file);
            //String strFile ="F:/Work4/zpf2/src/UI/action/demo/DemoAction.java";
            
            //co.analyseAction(strFile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
