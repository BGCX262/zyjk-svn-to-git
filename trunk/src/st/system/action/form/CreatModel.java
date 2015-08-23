package st.system.action.form;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 创建模板页面方法
 * 读取页面
 * 在每一行前加上写入
 * 并将"前加反斜杠
 * @author Administrator
 *
 */
public class CreatModel {

    String strFile ="F:/Work4/zpf2/WebRoot/UI/demo/demoinfo.js";
    String cretFile ="F:/Work4/zpf2/src/st/system/action/form/Model.java";
    
    
    public void openPage() throws Exception{
        
        FileOutputStream  stream = new FileOutputStream(cretFile); 
        OutputStreamWriter fos = new OutputStreamWriter(stream,"UTF-8");
        
       File file = new File(strFile);
       FileInputStream inputstream = new FileInputStream(strFile);
       InputStreamReader red  = new InputStreamReader(inputstream,"UTF-8");
       String s;
       BufferedReader in = new BufferedReader(red);
       while ((s = in.readLine()) != null) {
           
         s = s.replace("\"","\\\"");
        fos.write("fos.write(\""+s+"\\n\");\n");
         System.out.println(s);
        }
       fos.flush();  
       fos.close(); 
    }
  public static void main(String args[])
  {
      CreatModel model = new CreatModel();
      try {
        model.openPage();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }
        
}
