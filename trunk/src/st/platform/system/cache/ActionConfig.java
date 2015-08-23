package st.platform.system.cache;

import java.util.Hashtable;
import st.platform.db.*;


public class ActionConfig {
    private Hashtable acs = new Hashtable();
    private static ActionConfig instance;

    private ActionConfig() {
       if (!load(true))
           System.out.println("Failed to load action config!!!");
    }

    public static ActionConfig getInstance() {

        if (instance == null)
            instance = new ActionConfig();
        return instance;
    }

    public boolean load(boolean autoClose) {
         boolean result = true;
         DatabaseConnection dc = null;
         try {
              if(autoClose) //自动关闭连接时使用非线程数据库
                   dc = ConnectionManager.getInstance().getConnection();
              else //非自动关闭连接时使用线程数据库
                   dc = ConnectionManager.getInstance().get();
              RecordSet rs = dc.executeQuery("select * from ptlogicact");
              while(rs.next()) {
                   LogicAct la = new LogicAct();
                   la.logicCode = rs.getString("logicCode").trim();
                   la.logicClass = rs.getString("logicClass");
                   la.logicMethod = rs.getString("logicMethod");
                   la.logicDesc = rs.getString("logicDesc");
                   la.logicEnabled = rs.getString("logicEnabled");

                   acs.put(la.logicCode.toLowerCase(), la);
              }
         } catch(Exception e) {
              result = false;
         } finally {
              if(dc != null && autoClose) //只处理自动关闭连接的情况
                   dc.close();
         }
         return result;
    }

    public boolean reload() {
        acs.clear();
        return load(false);
    }

    public LogicAct getActionConfig(String logicCode) {
        return (LogicAct)acs.get(logicCode.trim().toLowerCase());
    }

    public static void main(String[] args) {
        ActionConfig ac = ActionConfig.getInstance();
        System.out.println(ac.getActionConfig("sc0011").logicClass);
    }

    public class LogicAct {
        String logicCode;
        public String logicClass;
        String logicMethod;
        String logicDesc;
        String logicEnabled;
    }
}
