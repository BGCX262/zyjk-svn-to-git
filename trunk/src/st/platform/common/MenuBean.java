package st.platform.common;


import java.io.IOException;

import java.io.Serializable;

public class MenuBean
     implements Serializable {

     private transient DatabaseAgent database;

     /**
      * Generate XML file Stream, formatted into a String,
      * which is to be used by the menu tree generator program, such as a JavaScript.
      * @param operatorName
      * @throws java.lang.Exception
      */
     public String generateStream(String operatorId)
          throws Exception {

          try {


               database = new DatabaseAgent();
               StringBuffer sb = new StringBuffer();
               sb.append("<tree><action>");

               MenuItemBean[] menuItemsLevel1 = database.getMenuItems(operatorId, 1);

               for(int i = 0; i < menuItemsLevel1.length; i++)
               {
                    sb.append(menuItemsLevel1[i].convertToString());
               }
               
               sb.append("</action></tree>");

               String xmlString = sb.toString();

               return xmlString;

          } catch(IOException e) {
               System.err.println("IOException, when generating XML file : [" + e + "]");
               throw e;
          }
     }
     public static void main(String argv[] ) {
          try {
               MenuBean mb = new MenuBean();
               mb.generateStream("9999");
          } catch ( Exception e) {

          }
     }
}
