package st.platform.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.db.ConnectionManager;
import st.platform.db.DBUtil;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;

public class DatabaseAgent {

     DBUtil dbut = new DBUtil();

     /**
      * Retrieve all the basic information of a Operator, Except password.
      * @param operid
      * @return Map which includes all the basic info in a HashMap with Key & Value pare.
      * @throws java.lang.Exception
      */
     public Map getBasicOfOperator(String operatorId)
          throws Exception {

          if(operatorId == null) {
               return null;
          }

          String SQL_getBasicOfOperator = "" +
               "SELECT * " +
               "FROM ptoper " +
               "WHERE operid = '" + operatorId + "'";

          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;
          try {
               cm = ConnectionManager.getInstance();
               dc = cm.get();
               rs = dc.executeQuery(SQL_getBasicOfOperator);
          } catch(Exception ex) {
               System.err.println("Wrong, when data retrieving.   Place zt.platform.security.DatabaseAgent.getBasicOfOperator(String operid).    [" + ex + "] ");
          }

          String nameOfOperator    = null;
          String idOfOperator      = null;
          String departmentId      = null;
          String isSuper           = null;
          String operatorType      = null;
          String sexOfOperator     = null;
          String emailOfOperator   = null;
          String mobilePhone       = null;
          String operatorPhone     = null;
          String otherPhone        = null;
          String enabledOfOperator = null;
          String combinedSequence  = null;
          String isCombined        = null;

          int statusOfOperator     = 0;

          if (rs == null)
               rs = new RecordSet();

          if(!rs.next()) {
               return null;
          } else {
               try {
                    if(rs.getString("opername") != null) {
                         nameOfOperator = rs.getString("opername").trim();
                    } else {
                         nameOfOperator = "";
                    }
                    if(rs.getString("operid") != null) {
                         idOfOperator = rs.getString("operid").trim();
                    } else {
                         idOfOperator = "";
                    }
                    if(rs.getString("deptid") != null) {
                         departmentId = rs.getString("deptid").trim();
                    } else {
                         departmentId = "";
                    }
                    if(rs.getString("issuper") != null) {
                         isSuper = rs.getString("issuper").trim();
                    } else {
                         isSuper = "";
                    }
                    if(rs.getString("opertype") != null) {
                         operatorType = rs.getString("opertype").trim();
                    } else {
                         operatorType = "";
                    }
                    if(rs.getString("mobilephone") != null) {
                         mobilePhone = rs.getString("mobilephone").trim();
                    } else {
                         mobilePhone = "";
                    }
                    if(rs.getString("operphone") != null) {
                         operatorPhone = rs.getString("operphone").trim();
                    } else {
                         operatorPhone = "";
                    }
                    if(rs.getString("otherphone") != null) {
                         otherPhone = rs.getString("otherphone").trim();
                    } else {
                         otherPhone = "";
                    }
                    if(rs.getString("cmbtxnseq") != null) {
                         combinedSequence = rs.getString("cmbtxnseq").trim();
                    } else {
                         combinedSequence = "";
                    }
                    if(rs.getString("iscmbend") != null) {
                         isCombined = rs.getString("iscmbend").trim();
                    } else {
                         isCombined = "";
                    }
                    if(rs.getString("sex") != null) {
                         sexOfOperator = rs.getString("sex").trim();
                    } else {
                         sexOfOperator = "";
                    }
                    if(rs.getString("email") != null) {
                         emailOfOperator = rs.getString("email").trim();
                    } else {
                         emailOfOperator = "";
                    }
                    if(rs.getString("operenabled") != null) {
                         enabledOfOperator = rs.getString("operenabled").trim();
                    } else {
                         enabledOfOperator = "";
                    }
                    rs.close();
                    cm.release();
               } catch(Exception ex1) {
                    System.err.println("Wrong, when getting data from RecordSet.   Place zt.platform.security.DatabaseAgent.getBasicOfOperator(String operid).    ["+ ex1 + "] ");
               }

               Map basicInfo = new HashMap();

               basicInfo.put("opnm", nameOfOperator);
               basicInfo.put("opid", idOfOperator);
               basicInfo.put("sexo", sexOfOperator);
               basicInfo.put("emai", emailOfOperator);
               basicInfo.put("enab", enabledOfOperator);
               basicInfo.put("issu", isSuper);
               basicInfo.put("depi", departmentId);
               basicInfo.put("otyp", operatorType);
               basicInfo.put("mobp", mobilePhone);
               basicInfo.put("opep", operatorPhone);
               basicInfo.put("othp", otherPhone);
               basicInfo.put("comb", combinedSequence);
               basicInfo.put("isco", isCombined);

               return basicInfo;
          }
     }
     public static void  raoluan1()
 	{
 		Keycode keycode = new Keycode();
 		DatabaseAgent  databaseAgent = new DatabaseAgent();
 		
 		Keycode.dateKey = keycode.encodeKeyDate();
 		Keycode.projectKey = databaseAgent.encodeStr3();			
 	}
 	
     /**
      * Looks up a operator's password.
      *
      * @param operator A String containing the operator's name.
      *
      * @return A String containing the operator's password.
      *
      * @throws NotFoundException if the operator does not exist.
      */
     public String getPasswordOfOperator(String operatorId)
          throws Exception {

          // ������Ա�����ڣ��򷵻�false��
          if(operatorId == null) {
               return null;
          }

          String SQL_GetPasswordOfOperator = "" +
               "SELECT operpasswd " +
               "FROM ptoper " +
               "WHERE operid = '" + operatorId + "'";

          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;
          try {
               cm = ConnectionManager.getInstance();
               dc = cm.get();
               rs = dc.executeQuery(SQL_GetPasswordOfOperator);
          } catch(Exception ex) {
               System.err.println("Wrong, when data retrieving.   Place zt.platform.security.DatabaseAgent.getPasswordOfOperator(String operid).    [" +ex + "] ");
          }

          // ������벻���ڣ�����null�����������ڣ��򷵻����롣
          String passwordOfOperator = null;
          if (rs == null)
               rs = new RecordSet();

          if(!rs.next()) {
               return null;
          } else {
               try {
                    passwordOfOperator = rs.getString("operpasswd").trim();
                    rs.close();
                    cm.release();
               } catch(Exception ex1) {
                    System.err.println("Wrong, when getting data from RecordSet.   Place zt.platform.security.DatabaseAgent.getPasswordOfOperator(String operid).    [" +ex1 + "] ");
               }
               return passwordOfOperator;
          }
     }

     /**
      * ͨ��operid�õ��ò���Ա��operid��
      * @param operid
      * @return
      * @throws java.lang.Exception
      */
     public String getOperatorIdOfOperator(String operatorId)
          throws Exception {

          String SQL_GetOperatorIdOfOperator = "" +
               "SELECT operid " +
               "FROM ptoper u " +
               "WHERE operid='" + operatorId + "'";

          String operatorIdOfOperator = null;
          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;

          try {
               cm = ConnectionManager.getInstance();
               dc = cm.get();
               rs = dc.executeQuery(SQL_GetOperatorIdOfOperator);
               if (rs == null)
                    rs = new RecordSet();


               while(rs.next()) {
                    if(rs.getString("operid") != null) {
                         operatorIdOfOperator = rs.getString("operid").trim();
                    } else {
                         operatorIdOfOperator = "";
                    }
               }
               rs.close();
               cm.release();
          } catch(Exception ex) {
               System.err.println("Wrong, when data retrieving.   Place zt.platform.security.DatabaseAgent.getUserIdOfOperator(String operid)    [" + ex+ "] ");
          }

          return operatorIdOfOperator;
     }

     /**
      *
      * @return
      * @throws java.lang.Exception
      */
     public String[] getRoleIdsOfOperator(String operatorId)
          throws Exception {

          String SQL_GetRolesOfOperator = "" +
               "SELECT roleid " +
               "FROM ptoperrole r " +
               "WHERE operid='" + operatorId + "'";

          String[] roleIdsOfOperator = null;
          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;

          try {
               cm = ConnectionManager.getInstance();
               dc = cm.get();
               rs = dc.executeQuery(SQL_GetRolesOfOperator);
               if (rs == null)
                    rs = new RecordSet();

               List listTemp = new ArrayList();
               while(rs.next()) {
                    String roleId = null;
                    if(rs.getString("roleid") != null) {
                         roleId = rs.getString("roleid").trim();
                    } else {
                         roleId = "";
                    }

                    listTemp.add(roleId);
               }
               roleIdsOfOperator = new String[listTemp.size()];
               for(int i = 0; i < listTemp.size(); i++) {
                    roleIdsOfOperator[i] = listTemp.get(i).toString();
               }
               rs.close();
               cm.release();
          } catch(Exception ex) {
               System.err.println("Wrong, when data retrieving.   Place zt.platform.security.DatabaseAgent.getRoleIdsOfOperator(String operid)    [" +ex + "] ");
          }

          return roleIdsOfOperator;
     }

//     /**
//      * The method is not enabled in this edition.
//      * @param roleId
//      */
//     public String getResourcesOfRole(String roleId)
//          throws Exception {
//
//          String SQL_GetResourcesOfRole = null;
//
//          return new String();
//     }

     /**
      * ����operid�õ��ò���Ա����ʹ�õ�Resource Object��Map
      * @param operid
      * @return
      * @throws java.lang.Exception
      */
     public Map getResourcesOfOperator(String operatorId)
          throws Exception {

          String SQL_GetResourcesOfOperator = "" +
               "SELECT distinct " +
               "rs.resid AS resid, " +
               "rs.resname AS res, " +
               "rs.restype AS tp " +
               "FROM ptoperrole ur, " +
               "ptroleres rr, " +
               "ptresource rs " +
               "WHERE ur.operid='" + operatorId + "' " +
               "and rr.roleid=ur.roleid " +
               "and rs.resid=rr.resid " +
               "and rs.resenabled='1'";


          Map resources = null;
          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;

          try {
               cm = ConnectionManager.getInstance();
               dc = cm.get();
               rs = dc.executeQuery(SQL_GetResourcesOfOperator);

               if (rs == null)
                    rs = new RecordSet();

               resources = new HashMap();
               while(rs.next()) {
                    String resourceId = null;
                    if(rs.getString("resid") != null) {
                         resourceId = rs.getString("resid").trim();
                    } else {
                         resourceId = "";
                    }

                    String resource = null;
                    if(rs.getString("res") != null) {
                         resource = rs.getString("res").trim();
                    } else {
                         resource = "";
                    }

                    int restype = rs.getInt("tp");

                    
               }
               rs.close();
               cm.release();
          } catch(Exception ex) {
               System.err.println("Wrong, when data retrieving.   Place zt.platform.security.DatabaseAgent.getResourcesOfOperator(String operid)    [" +ex + "] ");
          }

          return resources;
     }

     /**
      *
      * @param operid
      * @return
      * @throws java.lang.Exception
      */
     public List getResourceIdsOfOperator(String operatorId)
          throws Exception {

          String SQL_GetResourcesOfOperator = "" +
               "SELECT distinct rs.resid " +
               "FROM ptoperrole rl, " +
               "ptroleres rr, " +
               "ptresource rs, " +
               "WHERE rl.operid='"+operatorId+"' " +
               "and rr.roleid=rl.roleid " +
               "and rs.resid=rl.resid " +
               "and rs.resenabled='1'";

          List resourceIdsOfOperator = null;
          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;

          try {
               cm = ConnectionManager.getInstance();
               dc = cm.get();
               rs = dc.executeQuery(SQL_GetResourcesOfOperator);

               if (rs == null)
                    rs = new RecordSet();

               resourceIdsOfOperator = new ArrayList();
               while(rs.next()) {
                    String resourceId = null;
                    if(rs.getString("resid") != null) {
                         resourceId = rs.getString("resid").trim();
                    } else {
                         resourceId = "";
                    }

                    resourceIdsOfOperator.add(resourceId);
               }
               rs.close();
               cm.release();
          } catch(Exception ex) {
               System.err.println("Wrong, when data retrieving.   Place zt.platform.security.DatabaseAgent.getResourceIdsOfOperator(String operid).    [" + ex + "] ");
          }

          return resourceIdsOfOperator;
     }

     /**
      * Determines if a operator exists.
      *
      * @param operator A String containing the operator's name.
      * @return A boolean.  true if the operator exists, false otherwise.
      */
     public boolean isOperatorExistent(String operatorId) {

          if(operatorId == null) {
               return false;
          }

          String SQL_GetAnOperatorId = "" +
               "SELECT operid " +
               "FROM ptoper " +
               "WHERE operid='" + operatorId + "'";

          String operatorIdGetFromDB = null;
          ConnectionManager cm;
          DatabaseConnection dc;
          RecordSet rs = null;

          try {
               cm = ConnectionManager.getInstance();
               dc = cm.get();
               rs = dc.executeQuery(SQL_GetAnOperatorId);
               if (rs == null)
                    rs = new RecordSet();
               if(!rs.next()) {
                    return false;
               }
               operatorIdGetFromDB = rs.getString("operid").trim();
               rs.close();
               cm.release();

          } catch(Exception ex) {
               System.err.println("Wrong, when data retrieving.   Place zt.platform.security.DatabaseAgent.isOperatorExistent(String operid).    [" +ex + "] ");
          }

          if(operatorId.equals(operatorIdGetFromDB)) {
               return true;
          } else {
               return false;
          }
     }

//     /**
//      * Determines if a operator's password exists.
//      *
//      * @param operator A String containing the operator's name.
//      * @return A boolean.  true if the operator exists, false otherwise.
//      */
//     public boolean isPasswordExistent(String operid) {
//
//          // ������Ա�����ڣ��򷵻�false��
//          if(operid == null) {
//               return false;
//          }
//
//          String SQL_GetPassworOfOperator = "" +
//               "SELECT operpasswd " +
//               "FROM ptoper " +
//               "WHERE operid = '"+operid+"'";
//
//          ConnectionManager cm = ConnectionManager.getInstance();
//          DatabaseConnection dc = cm.get();
//          RecordSet rs = dc.executeQuery(SQL_GetPassworOfOperator);
//          if(!rs.next()) {
//               return false;
//          } else {
//               return true;
//          }
//			rs.close();
//          cm.release();
//          String passwordOfOperator = rs.getString("password").trim();
//          if(operid.equals(operidGetFromDB)) {
//               return true;
//          } else {
//               return false;
//          }
//     }

     /**
      *
      * @param operid
      * @param roleId
      * @return
      * @throws java.lang.Exception
      */
     public boolean isOperatorInRole(String operatorId, String roleId)
          throws Exception {

          String SQL_GetRolesOfOperator = "" +
               "SELECT roleid AS roleid " +
               "FROM ptoperrole, " +
               "WHERE operid='" + operatorId + "' ";

          List roleIdsOfOperator = null;
          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;

          try {
               cm = ConnectionManager.getInstance();
               dc = cm.get();
               rs = dc.executeQuery(SQL_GetRolesOfOperator);

               if (rs == null)
                    rs = new RecordSet();
               roleIdsOfOperator = new ArrayList();
               while(rs.next()) {
                    String ri = null;
                    if(rs.getString("roleid") != null) {
                         ri = rs.getString("roleid").trim();
                    } else {
                         ri = "";
                    }

                    roleIdsOfOperator.add(ri);
               }
               rs.close();
               cm.release();
          } catch(Exception ex) {
               System.err.println("Wrong, when data retrieving.   Place zt.platform.security.DatabaseAgent.isOperatorInRole(String operid, String roleId).    [" +ex + "] ");
          }

          if(roleIdsOfOperator.contains(roleId)) {
               return true;
          } else {
               return false;
          }
     }

/////////////////////////////////////////////////////////////////////////////////////////////// Public Methods
     /**
      * ����operid��nodesLevel֮�󣬾͵õ�������Ա��ĳһ���ϵ����е�Node Object Array��
      *
      * 1���õ��ò���Ա�����н�ɫid��
      * 2�����roleid����ptroleresource�еõ�����"where restype=4"��resid�����õ��˸ò���Ա�����е�menuid
      * 3����ptresource��ȡ��restype=4����resid�ķ�Χ����allResourcesForThisOperator�е�resid��
      * 4����������resid����ptmenuͨ��where level='"+nodesLevel+"'�õ���һ��ָ��level�ϵ�����menuid��
      * 5���4θ��ÿһ��menuid��ptmenu����ȡ����Ӧ��label��url��isleaf����ֵ�ֱ𸳸�Node object�е�String label, String url, String isleaf������ÿ��Node Object��
      * 6������һ��Node Object��Array���Ѹò���Ա��ӵ�е����е�Node���Ž�ȥ�����ء��󹦸�ɡ�
      *
      * @param operid ����ԱID������Loged In���Ǹ����Ա��
      * @param nodesLevel ��Ҫ�õ���Menu Item�Ĳ㼶��
      * @return Node] ����һ��ò㼶�ϸò���Ա����Node Oject��һ��Array��
      */
     public MenuItemBean[] getMenuItems(String operatorId, int menuItemsLevel)
          throws Exception {

          String SQL_GetMenuItemsForAnOperator = "" +
               "SELECT distinct " +
               "m.menuid AS menuItemId, " +
               "m.menulabel AS menuItemLabel, " +
               "m.isleaf AS menuItemIsLeaf, " +
               "m.menuaction AS menuItemUrl, " +
               "m.menudesc AS menuItemDescription, "+
               "m.OpenWindow AS menuItemOpenWindow, " +
               "m.WindowWidth AS menuItemWindowWidth, " +
               "m.WindowHeight AS menuItemWindowHeight, m.Levelidx,m.targetmachine "+
               ",(select count(ptmenu.MENULABEL) FROM ptoperrole, ptroleres , ptresource , ptmenu " +
               "WHERE ptoperrole.operid = '" + operatorId + "'  and ptroleres.roleid =ptoperrole.roleid and " +
               "ptresource.resid = ptroleres.resid and ptresource.restype = '4' and " +
               "rtrim(ptmenu.menuid) = ptresource.resname and ptmenu.menulevel = "+(menuItemsLevel+1)+" and ptmenu.PARENTMENUID=m.MENUID) as childcount" +

               " FROM ptoperrole r, " +
               "ptroleres rs, " +
               "ptresource s, " +
               "ptmenu m " +
               "WHERE r.operid = '" + operatorId + "' " +
               "and rs.roleid = r.roleid " +
               "and s.resid = rs.resid " +
               "and s.restype = '4' " +
               "and rtrim(m.menuid) = s.resname " +
               "and m.menulevel = " + menuItemsLevel +"  order by m.Levelidx";

          MenuItemBean[] menuItemsForThisOperator = null;
          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;

          try {
               cm = ConnectionManager.getInstance();
//               dc = cm.get();
               dc = cm.get();
               rs = dc.executeQuery(SQL_GetMenuItemsForAnOperator);
               if (rs == null)
                    rs = new RecordSet();
               List listTemp = new ArrayList();
               while(rs.next()) {
                    String menuItemId = null;
                    if(rs.getString("menuItemId") != null) {
                         menuItemId = rs.getString("menuItemId").trim();
                    } else {
                         menuItemId = "";
                    }

                    String menuItemLabel = null;
                    if(rs.getString("menuItemLabel") != null) {
                         menuItemLabel = rs.getString("menuItemLabel").trim();
                    } else {
                         menuItemLabel = "";
                    }

                    String menuItemIsLeaf = null;
                    if(rs.getString("menuItemIsLeaf") != null) {
                         menuItemIsLeaf = rs.getString("menuItemIsLeaf").trim();
                    } else {
                         menuItemIsLeaf = "";
                    }

                    String menuItemUrl = null;
                    if(rs.getString("menuItemUrl") != null) {
                         menuItemUrl = rs.getString("menuItemUrl").trim();
                    } else {
                         menuItemUrl = "#";
                    }

                    String menuItemDescription = null;
                    if(rs.getString("menuItemDescription") != null) {
                         menuItemDescription = rs.getString("menuItemDescription").trim();
                    } else {
                         menuItemDescription = "#";
                    }
                    String menuItemOpenWindow = "0";
                    if(rs.getString("menuItemOpenWindow") != null) {
                       menuItemOpenWindow = rs.getString("menuItemOpenWindow").trim();
                    } else {
                       menuItemOpenWindow = "0";
                    }

                    String menuItemWindowWidth = "0";
                    if(rs.getString("menuItemWindowWidth") != null) {
                       menuItemWindowWidth = rs.getString("menuItemWindowWidth").trim();
                    } else {
                       menuItemWindowWidth = "0";
                    }

                    String menuItemWindowHeight = "0";
                    if(rs.getString("menuItemWindowHeight") != null) {
                       menuItemWindowHeight = rs.getString("menuItemWindowHeight").trim();
                    } else {
                       menuItemWindowHeight = "0";
                    }
                    String targetmachine = "";
                    if(rs.getString("targetmachine") != null) {
                       targetmachine = rs.getString("targetmachine").trim();
                    } else {
                       targetmachine = "";
                    }
                    String childcount = "";
                    if(rs.getString("childcount") != null) {
                    	childcount = rs.getString("childcount").trim();
                    } else {
                    	childcount = "";
                    }


                    listTemp.add(new MenuItemBean(menuItemId, menuItemLabel, menuItemIsLeaf, menuItemUrl, menuItemDescription,menuItemOpenWindow,menuItemWindowWidth,menuItemWindowHeight,targetmachine,childcount));
               }

               menuItemsForThisOperator = new MenuItemBean[listTemp.size()];
               for(int i = 0; i < listTemp.size(); i++) {
                    menuItemsForThisOperator[i] = (MenuItemBean)listTemp.get(i);
               }
               rs.close();
               //cm.release();
          } catch(Exception ex) {
               System.err.println("Wrong, when data retrieving.   Place zt.platform.security.DatabaseAgent.getMenuItems(String operid, int menuItemsLevel).    [" +ex + "] ");
          }

          return menuItemsForThisOperator;
     }

     /**
      * getMenuItems()����һ����ʽ��
      * ����һ��parentId�������ڷǵ�һ��MenuItem��
      *
      * @param operid
      * @param nodesLevel
      * @param parentid
      * @return
      */
     public MenuItemBean[] getMenuItems(String operatorId, int menuItemsLevel, String parentId) {

          String SQL_GetMenuItemsForAnOperator = "" +
               "SELECT distinct " +
               "m.menuid AS menuItemId, " +
               "m.menulabel AS menuItemLabel, " +
               "m.isleaf AS menuItemIsLeaf, " +
               "m.menuaction AS menuItemUrl, " +
               "m.menudesc AS menuItemDescription, "+
               "m.OpenWindow AS menuItemOpenWindow, " +
               "m.WindowWidth AS menuItemWindowWidth, " +
               "m.WindowHeight AS menuItemWindowHeight, m.Levelidx,m.targetmachine "+
               ",(select count(ptmenu.MENULABEL) FROM ptoperrole, ptroleres , ptresource , ptmenu " +
               "WHERE ptoperrole.operid = '" + operatorId + "'  and ptroleres.roleid =ptoperrole.roleid and " +
               "ptresource.resid = ptroleres.resid and ptresource.restype = '4' and " +
               "rtrim(ptmenu.menuid) = ptresource.resname and ptmenu.menulevel = "+(menuItemsLevel+1)+" and ptmenu.PARENTMENUID=m.MENUID) as childcount" +

               " FROM ptoperrole r, " +
               "ptroleres rs, " +
               "ptresource s, " +
               "ptmenu m " +
               "WHERE r.operid = '" + operatorId + "' " +
               "and rs.roleid = r.roleid " +
               "and s.resid = rs.resid " +
               "and s.restype = '4' " +
               "and rtrim(m.menuid) = s.resname " +
               "and m.menulevel = " + menuItemsLevel + " " +
               "and m.parentmenuid = '" + parentId + "'  order by m.Levelidx";

          MenuItemBean[] menuItemsForThisOperator = null;
          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;

          try {
               cm = ConnectionManager.getInstance();
//               dc = cm.get();
               dc = cm.get();
               rs = dc.executeQuery(SQL_GetMenuItemsForAnOperator);
               if (rs == null)
                    rs = new RecordSet();
               List listTemp = new ArrayList();
               while(rs.next()) {
                    String menuItemId = null;
                    if(rs.getString("menuItemId") != null) {
                         menuItemId = rs.getString("menuItemId").trim();
                    } else {
                         menuItemId = "";
                    }

                    String menuItemLabel = null;
                    if(rs.getString("menuItemLabel") != null) {
                         menuItemLabel = rs.getString("menuItemLabel").trim();
                    } else {
                         menuItemLabel = "";
                    }

                    String menuItemIsLeaf = null;
                    if(rs.getString("menuItemIsLeaf") != null) {
                         menuItemIsLeaf = rs.getString("menuItemIsLeaf").trim();
                    } else {
                         menuItemIsLeaf = "";
                    }

                    String menuItemUrl = null;
                    if(rs.getString("menuItemUrl") != null) {
                         menuItemUrl = rs.getString("menuItemUrl").trim();
                    } else {
                         menuItemUrl = "#";
                    }

                    String menuItemDescription = null;
                    if(rs.getString("menuItemDescription") != null) {
                         menuItemDescription = rs.getString("menuItemDescription").trim();
                    } else {
                         menuItemDescription = "#";
                    }

                    String menuItemOpenWindow = "0";
                   if(rs.getString("menuItemOpenWindow") != null) {
                        menuItemOpenWindow = rs.getString("menuItemOpenWindow").trim();
                   } else {
                        menuItemOpenWindow = "0";
                   }

                   String menuItemWindowWidth = "0";
                   if(rs.getString("menuItemWindowWidth") != null) {
                        menuItemWindowWidth = rs.getString("menuItemWindowWidth").trim();
                   } else {
                        menuItemWindowWidth = "0";
                   }

                   String menuItemWindowHeight = "0";
                   if(rs.getString("menuItemWindowHeight") != null) {
                        menuItemWindowHeight = rs.getString("menuItemWindowHeight").trim();
                   } else {
                        menuItemWindowHeight = "0";
                   }

                   String targetmachine = "";
                    if(rs.getString("targetmachine") != null) {
                       targetmachine = rs.getString("targetmachine").trim();
                    } else {
                       targetmachine = "";
                    }

                    String childcount = "";
                    if(rs.getString("childcount") != null) {
                    	childcount = rs.getString("childcount").trim();
                    } else {
                    	childcount = "";
                    }
                    
                    MenuItemBean aMenuItem = new MenuItemBean(menuItemId, menuItemLabel, menuItemIsLeaf, menuItemUrl, menuItemDescription,menuItemOpenWindow,menuItemWindowWidth,menuItemWindowHeight,targetmachine,childcount);
                    listTemp.add(aMenuItem);
               }

               menuItemsForThisOperator = new MenuItemBean[listTemp.size()];
               for(int i = 0; i < listTemp.size(); i++) {
                    menuItemsForThisOperator[i] = (MenuItemBean)listTemp.get(i);
               }
               rs.close();
               //cm.release();
          } catch(Exception ex) {
               System.err.println("Wrong, when data retrieving.   Place zt.platform.security.DatabaseAgent.getMenuItems(String operid, int menuItemsLevel, String parentId).    [" +ex + "] ");
          }

          return menuItemsForThisOperator;
     }

     /**
      *
      * @param operatorName
      * @param url
      * @return
      * @throws java.lang.Exception
      */
     public boolean checkUrl(String operatorId,String url)
          throws Exception {

          String SQL_GetMenuItemsForAnOperator = "" +
               "SELECT " +
               "m.menuaction AS action " +
               "FROM ptoperrole r, " +
               "ptroleres rs, " +
               "ptresource s, " +
               "ptmenu m " +
               "WHERE r.operid = '" + operatorId + "' " +
               "and rs.roleid = r.roleid " +
               "and s.resid = rs.resid " +
               "and s.restype = '4' " +
               "and m.menuid = s.resname " +
               "and m.menuaction like '%"+url+"%' ";

          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;

          boolean checkpass = false;

          try {
               cm = ConnectionManager.getInstance();
               dc = cm.get();
               rs = dc.executeQuery(SQL_GetMenuItemsForAnOperator);
               if (rs == null)
                    rs = new RecordSet();
               if ( rs.next() ) {
                   checkpass = true;
               }
               rs.close();
               cm.release();
          } catch(Exception ex) {
               System.err.println("Wrong, when data check. Place zt.platform.security.DatabaseAgent.checkUrl(String operid, String url).    [" +ex + "] ");
          }

          return checkpass;
     }
         /* ��������jsp���͵���Դ��URL��Ϣ
          *
          *
          */
     public ArrayList getAllUrlInfoOfOperator(String operatorId) throws Exception{
          ArrayList al = null;
          String SQL_getAllUrlInfoOfOperator = "" +
               "select distinct a.menuaction " +
               "from ptmenu a," +
               "ptoperrole r," +
               "ptroleres rs," +
               "ptresource s " +
               "where rtrim(a.menuid) = rtrim(s.RESNAME) " +
               "and rtrim(s.RESID)=rtrim(rs.RESID) " +
               "and rtrim(rs.ROLEID)=rtrim(r.ROLEID) " +
               "and rtrim(r.OPERID) = '" + operatorId + "' " +
               "and a.ISLEAF = 1 " +
               "union all " +
               "select s.RESNAME " +
               "from ptoperrole r," +
               "ptroleres rs," +
               "ptresource s " +
               "where rtrim(s.RESID)=rtrim(rs.RESID) " +
               "and rtrim(rs.ROLEID)=rtrim(r.ROLEID) " +
               "and rtrim(r.OPERID) = '" + operatorId + "' " +
               "and s.restype = '2' ";

          ConnectionManager cm = null;
          DatabaseConnection dc = null;
          RecordSet rs = null;
          
          //System.out.println("SQL_getAllUrlInfoOfOperator"+ SQL_getAllUrlInfoOfOperator);
          try {
               cm = ConnectionManager.getInstance();
               dc = cm.get();
               rs = dc.executeQuery(SQL_getAllUrlInfoOfOperator);
               if (rs == null)
                    rs = new RecordSet();
               al = new ArrayList();
               while ( rs.next() ) {
                   al.add(rs.getString(0));
               }


          } catch(Exception ex) {
               ex.printStackTrace();
               throw new Exception("����(DatabaseAgent:getAllUrlInfoOfOperator):" + ex.getMessage());
          }
          finally{
        	  rs.close();
               cm.release();
          }
          return al;
     }
     
     
     
    public  String encodeStr3()
 	{
 		 		
 		char[] keyBytes = Keycode.encodeStr2().toCharArray();
 		String enKeyStr = "";
 		for (int i=0; i< keyBytes.length; i++)
		{
			enKeyStr = enKeyStr  + java.lang.Long.toHexString(keyBytes[i]);
		
		}	
 		return enKeyStr;		
 	} 
}
