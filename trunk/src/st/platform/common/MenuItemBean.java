package st.platform.common;

import java.io.Serializable;

import st.platform.utils.Basic;

public class MenuItemBean implements Serializable  {

     /**
      * The nodeid for this node.
      */
     private String menuItemId = null;
     public String getMenuItemId() {
          return(this.menuItemId);
     }

     /** Defines a isBranch attribute */
     private String isLeaf = null;
     public String getIsLeaf() {
          return(this.isLeaf);
     }
     public void setIsLeaf(String isLeaf) {
          this.isLeaf = isLeaf;
     }

     /** Defines a label attribute */
     private String label = null;
     public String getLabel() {
          return(this.label);
     }
     public void setLabel(String label) {
          this.label = label;
     }

     /** Defines a url attribute */
     public String url = null;
     public String getUrl() {
          return(this.url);
     }
     public void setUrl(String url) {
          this.url = url;
     }

     /** Defines a description */
     public String description = null;
     public String getDescription() {
          return(this.description);
     }
     public void setDescription(String description) {
          this.description = description;
     }
     ///////打开方式 0 ----表示潜入方式；1-----表示弹出方式
     private  String openwindow ="0";
     public String getOpenWindow(){
          return this.openwindow;
     }
     public void setOpenWindow(String openwindow){
          this.openwindow = openwindow;
     }
     
     private  String childcount ="0";
     public String getchildcount(){
          return this.childcount;
     }
     public void setchildcount(String childcount){
          this.childcount = childcount;
     }
     
     ////////////如果是弹出方式 则窗体的宽度
     private String winWidth="";
     public String getwinWidth(){
          return this.winWidth;

     }
     public void setwinWidth(String winWidth){
          this.winWidth = winWidth;
     }
     /////////////如果弹出方式 则窗体的高的
     private String winHeight="";
     private String targetmachine;
     public String getwinHeight(){
          return this.winHeight;

     }
     public void setwinHeight(String winHeight){
          this.winHeight = winHeight;
     }

////////////////////////////////////////////////////////////////////////////////////////////////////////////// Constructors

     /**
      * Constructor: Creates an empty Node object
      */
     public MenuItemBean() {
     }

     public MenuItemBean(String nodeid) {
          super();
          this.menuItemId = nodeid;
     }

     public MenuItemBean(String menuItemId, String label, String isLeaf, String url) {
          super();
          this.menuItemId = menuItemId;
          this.label = label;
          this.isLeaf = isLeaf;
          this.url = url;
     }

     public MenuItemBean(String menuItemId, String label, String isLeaf, String url, String description) {
          super();
          this.menuItemId = menuItemId;
          this.label = label;
          this.isLeaf = isLeaf;
          this.url = url;
          this.description = description;
     }
     public MenuItemBean(String menuItemId, String label, String isLeaf, String url, String description, String openwindow, String winWidth, String winHeight) {
         super();
         this.menuItemId = menuItemId;
         this.label = label;
         this.isLeaf = isLeaf;
         this.url = url;
         this.description = description;
         this.openwindow = openwindow;
         this.winWidth = winWidth;
         this.winHeight = winHeight;

    }
    public MenuItemBean(String menuItemId, String label, String isLeaf, String url, String description, String openwindow, String winWidth, String winHeight,String targetmachine,String childcount) {
         super();
         this.menuItemId = menuItemId;
         this.label = label;
         this.isLeaf = isLeaf;
         this.url = url;
         this.description = description;
         this.openwindow = openwindow;
         this.winWidth = winWidth;
         this.winHeight = winHeight;
         this.targetmachine = targetmachine;
         this.childcount = childcount;
    }


////////////////////////////////////////////////////////////////////////////////////////////////////

     /**
      * Return a String representation of this object.
      */
     public String convertToString()
          throws Exception {

          StringBuffer StrBuf = new StringBuffer("<record>");
          
          StrBuf.append("<field ");
          StrBuf.append(" name = \"text\"");
          StrBuf.append(" type =\"text\"");
          StrBuf.append("  value =\"" +Basic.encode(label) + "\"");
          StrBuf.append(" />");
          
          
          StrBuf.append("<field ");
          StrBuf.append(" name =\"action\"");
          StrBuf.append(" type =\"text\"");
          StrBuf.append(" value =\"" + Basic.encode(url.trim()) + "\"");
          StrBuf.append(" />");
          
          StrBuf.append("<field ");
          StrBuf.append(" name = \"title\"");
          StrBuf.append(" type =\"text\"");
          StrBuf.append("  value =\"" + Basic.encode(description) + "\"");
          StrBuf.append(" />");
          
          StrBuf.append("<field ");
          StrBuf.append(" name = \"openwin\"");
          StrBuf.append(" type =\"text\"");
          StrBuf.append("  value =\"" + openwindow + "\"");
          StrBuf.append(" />");
          
          StrBuf.append("<field ");
          StrBuf.append(" name = \"winwidth\"");
          StrBuf.append(" type =\"text\"");
          StrBuf.append("  value =\"" + winWidth + "\"");
          StrBuf.append(" />");
          
          StrBuf.append("<field ");
          StrBuf.append(" name = \"winheight\"");
          StrBuf.append(" type =\"text\"");
          StrBuf.append("  value =\"" + winHeight + "\"");
          StrBuf.append(" />");
          
          StrBuf.append("<field ");
          StrBuf.append(" name = \"childcount\"");
          StrBuf.append(" type =\"text\"");
          StrBuf.append("  value =\"" + childcount + "\"");
          StrBuf.append(" />");
          
          StrBuf.append("<field ");
          StrBuf.append(" name = \"menuItemId\"");
          StrBuf.append(" type =\"text\"");
          StrBuf.append("  value =\"" + Basic.encode(menuItemId) + "\"");
          StrBuf.append(" />");

          StrBuf.append("</record>");
          
          return (StrBuf.toString());
     }

/** /////////////////////////////////////////////////////////////////////////////////////////////////////////// */

     private String specialCodeTranslate(String codeToBeTrans) {

          String codeAfterTrans = "";

          // 先转换&；后转换其他的符号。
          codeAfterTrans = codeToBeTrans.replaceAll("&", "&amp;");

          codeAfterTrans = codeAfterTrans.replaceAll("<", "&lt;");
          codeAfterTrans = codeAfterTrans.replaceAll(">", "&gt");

          // 先转换双引号；后转换单引号。
          codeAfterTrans = codeAfterTrans.replaceAll("\"", "&quot;"); //
          codeAfterTrans = codeAfterTrans.replaceAll("'", "&apos;");

          return codeAfterTrans;
     }
     public String getTargetmachine() {
          return targetmachine;
     }
     public void setTargetmachine(String targetmachine) {
          this.targetmachine = targetmachine;
     }
}
