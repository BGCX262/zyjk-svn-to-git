package st.system.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class PtmenuBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new PtmenuBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new PtmenuBean().findAndLockByWhere(sSqlWhere);      }       public static PtmenuBean findFirst(String sSqlWhere)throws Exception {           return (PtmenuBean)new PtmenuBean().findFirstByWhere(sSqlWhere);      }       public static PtmenuBean findFirstAndLock(String sSqlWhere)throws Exception {           return (PtmenuBean)new PtmenuBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new PtmenuBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtmenuBean bean = new PtmenuBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtmenuBean bean = new PtmenuBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PtmenuBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtmenuBean bean = new PtmenuBean();           bean.setAutoRelease(isAutoRelease);           return (PtmenuBean)bean.findFirstByWhere(sSqlWhere);      }       public static PtmenuBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           PtmenuBean bean = new PtmenuBean();           bean.setAutoRelease(isAutoRelease);           return (PtmenuBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           PtmenuBean bean = new PtmenuBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  menuid; //菜单编号 
String  parentmenuid; //父菜单菜单编号 
String  menulevel; //菜单级别 
String  isleaf; //是否叶子（无子菜单） 
String  menudesc; //菜单描述 
String  menulabel; //菜单名称 
String  menuicon; //菜单图标 
String  openicon; //展开图标 
String  targetmachine; //匹配目标 
String  menuaction; //菜单动作 
String  openwindow; //打开窗口 
String  windowwidth; //窗口宽度 
String  windowheight; //窗口高度 
String  levelidx; //水平位置 
String  fillstr50; //备用字段 
String  fillstr100; //备用字段 
String  fillint1; //备用字段 
String  filldbl2; //备用字段 
String  filldate; //备用字段 
public static final String TABLENAME ="ptmenu";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
PtmenuBean abb = new PtmenuBean();
abb.menuid=rs.getString("menuid");
abb.setKeyValue("MENUID","" + abb.getMenuid());
abb.parentmenuid=rs.getString("parentmenuid");
abb.setKeyValue("PARENTMENUID","" + abb.getParentmenuid());
abb.menulevel=rs.getString("menulevel");
abb.setKeyValue("MENULEVEL","" + abb.getMenulevel());
abb.isleaf=rs.getString("isleaf");
abb.setKeyValue("ISLEAF","" + abb.getIsleaf());
abb.menudesc=rs.getString("menudesc");
abb.setKeyValue("MENUDESC","" + abb.getMenudesc());
abb.menulabel=rs.getString("menulabel");
abb.setKeyValue("MENULABEL","" + abb.getMenulabel());
abb.menuicon=rs.getString("menuicon");
abb.setKeyValue("MENUICON","" + abb.getMenuicon());
abb.openicon=rs.getString("openicon");
abb.setKeyValue("OPENICON","" + abb.getOpenicon());
abb.targetmachine=rs.getString("targetmachine");
abb.setKeyValue("TARGETMACHINE","" + abb.getTargetmachine());
abb.menuaction=rs.getString("menuaction");
abb.setKeyValue("MENUACTION","" + abb.getMenuaction());
abb.openwindow=rs.getString("openwindow");
abb.setKeyValue("OPENWINDOW","" + abb.getOpenwindow());
abb.windowwidth=rs.getString("windowwidth");
abb.setKeyValue("WINDOWWIDTH","" + abb.getWindowwidth());
abb.windowheight=rs.getString("windowheight");
abb.setKeyValue("WINDOWHEIGHT","" + abb.getWindowheight());
abb.levelidx=rs.getString("levelidx");
abb.setKeyValue("LEVELIDX","" + abb.getLevelidx());
abb.fillstr50=rs.getString("fillstr50");
abb.setKeyValue("FILLSTR50","" + abb.getFillstr50());
abb.fillstr100=rs.getString("fillstr100");
abb.setKeyValue("FILLSTR100","" + abb.getFillstr100());
abb.fillint1=rs.getString("fillint1");
abb.setKeyValue("FILLINT1","" + abb.getFillint1());
abb.filldbl2=rs.getString("filldbl2");
abb.setKeyValue("FILLDBL2","" + abb.getFilldbl2());
abb.filldate=rs.getString("filldate");
abb.setKeyValue("FILLDATE","" + abb.getFilldate());
list.add(abb);
abb.operate_mode = "edit";
}public String getMenuid(){ if ( this.menuid == null){ return ""; } else {return this.menuid;}}public String getParentmenuid(){ if ( this.parentmenuid == null){ return ""; } else {return this.parentmenuid;}}public String getMenulevel(){ if ( this.menulevel == null){ return ""; } else {return this.menulevel;}}public String getIsleaf(){ if ( this.isleaf == null){ return ""; } else {return this.isleaf;}}public String getMenudesc(){ if ( this.menudesc == null){ return ""; } else {return this.menudesc;}}public String getMenulabel(){ if ( this.menulabel == null){ return ""; } else {return this.menulabel;}}public String getMenuicon(){ if ( this.menuicon == null){ return ""; } else {return this.menuicon;}}public String getOpenicon(){ if ( this.openicon == null){ return ""; } else {return this.openicon;}}public String getTargetmachine(){ if ( this.targetmachine == null){ return ""; } else {return this.targetmachine;}}public String getMenuaction(){ if ( this.menuaction == null){ return ""; } else {return this.menuaction;}}public String getOpenwindow(){ if ( this.openwindow == null){ return ""; } else {return this.openwindow;}}public String getWindowwidth(){ if ( this.windowwidth == null){ return ""; } else {return this.windowwidth;}}public String getWindowheight(){ if ( this.windowheight == null){ return ""; } else {return this.windowheight;}}public String getLevelidx(){ if ( this.levelidx == null){ return ""; } else {return this.levelidx;}}public String getFillstr50(){ if ( this.fillstr50 == null){ return ""; } else {return this.fillstr50;}}public String getFillstr100(){ if ( this.fillstr100 == null){ return ""; } else {return this.fillstr100;}}public String getFillint1(){ if ( this.fillint1 == null){ return ""; } else {return this.fillint1;}}public String getFilldbl2(){ if ( this.filldbl2 == null){ return ""; } else {return this.filldbl2;}}public String getFilldate(){ if ( this.filldate == null){ return ""; } else {return this.filldate;}}public void setMenuid( String menuid){sqlMaker.setField("menuid",menuid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMenuid().equals(menuid))
cf.add("menuid",this.menuid,menuid);
}
this.menuid=menuid;
}
public void setParentmenuid( String parentmenuid){sqlMaker.setField("parentmenuid",parentmenuid,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getParentmenuid().equals(parentmenuid))
cf.add("parentmenuid",this.parentmenuid,parentmenuid);
}
this.parentmenuid=parentmenuid;
}
public void setMenulevel( String menulevel){sqlMaker.setField("menulevel",menulevel,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getMenulevel().equals(menulevel))
cf.add("menulevel",this.menulevel,menulevel);
}
this.menulevel=menulevel;
}
public void setIsleaf( String isleaf){sqlMaker.setField("isleaf",isleaf,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getIsleaf().equals(isleaf))
cf.add("isleaf",this.isleaf,isleaf);
}
this.isleaf=isleaf;
}
public void setMenudesc( String menudesc){sqlMaker.setField("menudesc",menudesc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMenudesc().equals(menudesc))
cf.add("menudesc",this.menudesc,menudesc);
}
this.menudesc=menudesc;
}
public void setMenulabel( String menulabel){sqlMaker.setField("menulabel",menulabel,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMenulabel().equals(menulabel))
cf.add("menulabel",this.menulabel,menulabel);
}
this.menulabel=menulabel;
}
public void setMenuicon( String menuicon){sqlMaker.setField("menuicon",menuicon,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMenuicon().equals(menuicon))
cf.add("menuicon",this.menuicon,menuicon);
}
this.menuicon=menuicon;
}
public void setOpenicon( String openicon){sqlMaker.setField("openicon",openicon,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOpenicon().equals(openicon))
cf.add("openicon",this.openicon,openicon);
}
this.openicon=openicon;
}
public void setTargetmachine( String targetmachine){sqlMaker.setField("targetmachine",targetmachine,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTargetmachine().equals(targetmachine))
cf.add("targetmachine",this.targetmachine,targetmachine);
}
this.targetmachine=targetmachine;
}
public void setMenuaction( String menuaction){sqlMaker.setField("menuaction",menuaction,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getMenuaction().equals(menuaction))
cf.add("menuaction",this.menuaction,menuaction);
}
this.menuaction=menuaction;
}
public void setOpenwindow( String openwindow){sqlMaker.setField("openwindow",openwindow,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOpenwindow().equals(openwindow))
cf.add("openwindow",this.openwindow,openwindow);
}
this.openwindow=openwindow;
}
public void setWindowwidth( String windowwidth){sqlMaker.setField("windowwidth",windowwidth,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getWindowwidth().equals(windowwidth))
cf.add("windowwidth",this.windowwidth,windowwidth);
}
this.windowwidth=windowwidth;
}
public void setWindowheight( String windowheight){sqlMaker.setField("windowheight",windowheight,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getWindowheight().equals(windowheight))
cf.add("windowheight",this.windowheight,windowheight);
}
this.windowheight=windowheight;
}
public void setLevelidx( String levelidx){sqlMaker.setField("levelidx",levelidx,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getLevelidx().equals(levelidx))
cf.add("levelidx",this.levelidx,levelidx);
}
this.levelidx=levelidx;
}
public void setFillstr50( String fillstr50){sqlMaker.setField("fillstr50",fillstr50,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFillstr50().equals(fillstr50))
cf.add("fillstr50",this.fillstr50,fillstr50);
}
this.fillstr50=fillstr50;
}
public void setFillstr100( String fillstr100){sqlMaker.setField("fillstr100",fillstr100,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFillstr100().equals(fillstr100))
cf.add("fillstr100",this.fillstr100,fillstr100);
}
this.fillstr100=fillstr100;
}
public void setFillint1( String fillint1){sqlMaker.setField("fillint1",fillint1,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getFillint1().equals(fillint1))
cf.add("fillint1",this.fillint1,fillint1);
}
this.fillint1=fillint1;
}
public void setFilldbl2( String filldbl2){sqlMaker.setField("filldbl2",filldbl2,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getFilldbl2().equals(filldbl2))
cf.add("filldbl2",this.filldbl2,filldbl2);
}
this.filldbl2=filldbl2;
}
public void setFilldate( String filldate){sqlMaker.setField("filldate",filldate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFilldate().equals(filldate))
cf.add("filldate",this.filldate,filldate);
}
this.filldate=filldate;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "menuid") != null) 
this.setMenuid(actionRequest.getFieldValue(i, "menuid"));
if (actionRequest.getFieldValue(i, "parentmenuid") != null) 
this.setParentmenuid(actionRequest.getFieldValue(i, "parentmenuid"));
if (actionRequest.getFieldValue(i, "menulevel") != null) 
this.setMenulevel(actionRequest.getFieldValue(i, "menulevel"));
if (actionRequest.getFieldValue(i, "isleaf") != null) 
this.setIsleaf(actionRequest.getFieldValue(i, "isleaf"));
if (actionRequest.getFieldValue(i, "menudesc") != null) 
this.setMenudesc(actionRequest.getFieldValue(i, "menudesc"));
if (actionRequest.getFieldValue(i, "menulabel") != null) 
this.setMenulabel(actionRequest.getFieldValue(i, "menulabel"));
if (actionRequest.getFieldValue(i, "menuicon") != null) 
this.setMenuicon(actionRequest.getFieldValue(i, "menuicon"));
if (actionRequest.getFieldValue(i, "openicon") != null) 
this.setOpenicon(actionRequest.getFieldValue(i, "openicon"));
if (actionRequest.getFieldValue(i, "targetmachine") != null) 
this.setTargetmachine(actionRequest.getFieldValue(i, "targetmachine"));
if (actionRequest.getFieldValue(i, "menuaction") != null) 
this.setMenuaction(actionRequest.getFieldValue(i, "menuaction"));
if (actionRequest.getFieldValue(i, "openwindow") != null) 
this.setOpenwindow(actionRequest.getFieldValue(i, "openwindow"));
if (actionRequest.getFieldValue(i, "windowwidth") != null) 
this.setWindowwidth(actionRequest.getFieldValue(i, "windowwidth"));
if (actionRequest.getFieldValue(i, "windowheight") != null) 
this.setWindowheight(actionRequest.getFieldValue(i, "windowheight"));
if (actionRequest.getFieldValue(i, "levelidx") != null) 
this.setLevelidx(actionRequest.getFieldValue(i, "levelidx"));
if (actionRequest.getFieldValue(i, "fillstr50") != null) 
this.setFillstr50(actionRequest.getFieldValue(i, "fillstr50"));
if (actionRequest.getFieldValue(i, "fillstr100") != null) 
this.setFillstr100(actionRequest.getFieldValue(i, "fillstr100"));
if (actionRequest.getFieldValue(i, "fillint1") != null) 
this.setFillint1(actionRequest.getFieldValue(i, "fillint1"));
if (actionRequest.getFieldValue(i, "filldbl2") != null) 
this.setFilldbl2(actionRequest.getFieldValue(i, "filldbl2"));
if (actionRequest.getFieldValue(i, "filldate") != null) 
this.setFilldate(actionRequest.getFieldValue(i, "filldate"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PtmenuBean obj = (PtmenuBean)super.clone();obj.setMenuid(obj.menuid);
obj.setParentmenuid(obj.parentmenuid);
obj.setMenulevel(obj.menulevel);
obj.setIsleaf(obj.isleaf);
obj.setMenudesc(obj.menudesc);
obj.setMenulabel(obj.menulabel);
obj.setMenuicon(obj.menuicon);
obj.setOpenicon(obj.openicon);
obj.setTargetmachine(obj.targetmachine);
obj.setMenuaction(obj.menuaction);
obj.setOpenwindow(obj.openwindow);
obj.setWindowwidth(obj.windowwidth);
obj.setWindowheight(obj.windowheight);
obj.setLevelidx(obj.levelidx);
obj.setFillstr50(obj.fillstr50);
obj.setFillstr100(obj.fillstr100);
obj.setFillint1(obj.fillint1);
obj.setFilldbl2(obj.filldbl2);
obj.setFilldate(obj.filldate);
return obj;}}