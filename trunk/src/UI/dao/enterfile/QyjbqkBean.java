package UI.dao.enterfile;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class QyjbqkBean extends AbstractBasicBean implements Cloneable {
private static final long serialVersionUID = 1L;
     public static List find(String sSqlWhere) throws Exception{           return new QyjbqkBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new QyjbqkBean().findAndLockByWhere(sSqlWhere);      }       public static QyjbqkBean findFirst(String sSqlWhere)throws Exception {           return (QyjbqkBean)new QyjbqkBean().findFirstByWhere(sSqlWhere);      }       public static QyjbqkBean findFirstAndLock(String sSqlWhere)throws Exception {           return (QyjbqkBean)new QyjbqkBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new QyjbqkBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyjbqkBean bean = new QyjbqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyjbqkBean bean = new QyjbqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static QyjbqkBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyjbqkBean bean = new QyjbqkBean();           bean.setAutoRelease(isAutoRelease);           return (QyjbqkBean)bean.findFirstByWhere(sSqlWhere);      }       public static QyjbqkBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           QyjbqkBean bean = new QyjbqkBean();           bean.setAutoRelease(isAutoRelease);           return (QyjbqkBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           QyjbqkBean bean = new QyjbqkBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  enterno;
String  corpkey;
String  dwmc;
String  zzjgdm;
String  gszch;
String  zcdz;
String  frdbsfzh;
String  ddremail;
String  zczb;
String  jcdate;
String  sfczzdwxy;
String  zcyzbm;
String  csdz;
String  csyzbm;
String  fddbr;
String  lxdh;
String  hyfl1;
String  hyfl2;
String  hyfl;
String  zclx;
String  tblb;
String  zywsjg;
String  zywsfzr;
String  zywslxdh;
String  bgyy;
String  qtbgyy;
String  nmzgrs;
String  scwomen;
String  scnongmin;
String  whrenshu;
String  whwomen;
String  whnongmin;
String  tjrenshu;
String  zybrenshu;
String  dlrenshu;
String  tjrenshu2;
String  tjrenshu3;
String  zybrenshuxz;
String  zybrenshuys;
String  pxrenshu;
String  swrenshu;
String  swrenshuxz;
String  zhuguan;
String  zywsjgshu;
String  zywsgl;
String  chanzhi;
String  zichan;
String  sbren;
String  sbrendh;
String  ystbbm;
String  ystbren;
String  ysshren;
String  ystbdate;
String  ysjiancejg;
String  ysjiancedate;
String  gltbbm;
String  gltbren;
String  gltbdate;
String  glpeixunjg;
String  glpeixundate;
String  gltijianjg;
String  gltijiandate;
String  liuchengid;
String  tbliucheng;
String  dq1;
String  dq2;
String  dq3;
String  scyj1;
String  scyj2;
String  scyj3;
String  scdate1;
String  scdate2;
String  scdate3;
String  sbyes;
String  beiandate;
String  beianhao;
String  scyj0;
String  scdate0;
String  dq4;
String  scyj4;
String  scdate4;
String  jcfcren;
String  jchxren;
String  jcwlren;
String  jcfsren;
String  jcqtren;
String  htngzzywhrs;
String  zybzygws;
String  szjsbzgws;
String  yzywspxs;
String  yzyjkjcs;
String  zywhfj;
String  jp;
String  qp;
String  wghdq1;
String  wghdq2;
String  wghdq3;
String  wghdq4;
String  wghdq5;
String  bak1;
String  bak2;
String  bak3;
String  bak4;
String  bak5;
String  distcode;
String  whys;
String  whysname;
String  zywsxkzz;
String  zywsxkzf;
String  otherzg;
public static final String TABLENAME ="qyjbqk";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
 @SuppressWarnings("unchecked")
public void addObject(List list,RecordSet rs) {
QyjbqkBean abb = new QyjbqkBean();
abb.enterno=rs.getString("enterno");
abb.setKeyValue("ENTERNO","" + abb.getEnterno());
abb.corpkey=rs.getString("corpkey");
abb.setKeyValue("CORPKEY","" + abb.getCorpkey());
abb.dwmc=rs.getString("dwmc");
abb.setKeyValue("DWMC","" + abb.getDwmc());
abb.zzjgdm=rs.getString("zzjgdm");
abb.setKeyValue("ZZJGDM","" + abb.getZzjgdm());
abb.gszch=rs.getString("gszch");
abb.setKeyValue("GSZCH","" + abb.getGszch());
abb.zcdz=rs.getString("zcdz");
abb.setKeyValue("ZCDZ","" + abb.getZcdz());
abb.frdbsfzh=rs.getString("frdbsfzh");
abb.setKeyValue("FRDBSFZH","" + abb.getFrdbsfzh());
abb.ddremail=rs.getString("ddremail");
abb.setKeyValue("DDREMAIL","" + abb.getDdremail());
abb.zczb=rs.getString("zczb");
abb.setKeyValue("ZCZB","" + abb.getZczb());
abb.jcdate=rs.getString("jcdate");
abb.setKeyValue("JCDATE","" + abb.getJcdate());
abb.sfczzdwxy=rs.getString("sfczzdwxy");
abb.setKeyValue("SFCZZDWXY","" + abb.getSfczzdwxy());
abb.zcyzbm=rs.getString("zcyzbm");
abb.setKeyValue("ZCYZBM","" + abb.getZcyzbm());
abb.csdz=rs.getString("csdz");
abb.setKeyValue("CSDZ","" + abb.getCsdz());
abb.csyzbm=rs.getString("csyzbm");
abb.setKeyValue("CSYZBM","" + abb.getCsyzbm());
abb.fddbr=rs.getString("fddbr");
abb.setKeyValue("FDDBR","" + abb.getFddbr());
abb.lxdh=rs.getString("lxdh");
abb.setKeyValue("LXDH","" + abb.getLxdh());
abb.hyfl1=rs.getString("hyfl1");
abb.setKeyValue("HYFL1","" + abb.getHyfl1());
abb.hyfl2=rs.getString("hyfl2");
abb.setKeyValue("HYFL2","" + abb.getHyfl2());
abb.hyfl=rs.getString("hyfl");
abb.setKeyValue("HYFL","" + abb.getHyfl());
abb.zclx=rs.getString("zclx");
abb.setKeyValue("ZCLX","" + abb.getZclx());
abb.tblb=rs.getString("tblb");
abb.setKeyValue("TBLB","" + abb.getTblb());
abb.zywsjg=rs.getString("zywsjg");
abb.setKeyValue("ZYWSJG","" + abb.getZywsjg());
abb.zywsfzr=rs.getString("zywsfzr");
abb.setKeyValue("ZYWSFZR","" + abb.getZywsfzr());
abb.zywslxdh=rs.getString("zywslxdh");
abb.setKeyValue("ZYWSLXDH","" + abb.getZywslxdh());
abb.bgyy=rs.getString("bgyy");
abb.setKeyValue("BGYY","" + abb.getBgyy());
abb.qtbgyy=rs.getString("qtbgyy");
abb.setKeyValue("QTBGYY","" + abb.getQtbgyy());
abb.nmzgrs=rs.getString("nmzgrs");
abb.setKeyValue("NMZGRS","" + abb.getNmzgrs());
abb.scwomen=rs.getString("scwomen");
abb.setKeyValue("SCWOMEN","" + abb.getScwomen());
abb.scnongmin=rs.getString("scnongmin");
abb.setKeyValue("SCNONGMIN","" + abb.getScnongmin());
abb.whrenshu=rs.getString("whrenshu");
abb.setKeyValue("WHRENSHU","" + abb.getWhrenshu());
abb.whwomen=rs.getString("whwomen");
abb.setKeyValue("WHWOMEN","" + abb.getWhwomen());
abb.whnongmin=rs.getString("whnongmin");
abb.setKeyValue("WHNONGMIN","" + abb.getWhnongmin());
abb.tjrenshu=rs.getString("tjrenshu");
abb.setKeyValue("TJRENSHU","" + abb.getTjrenshu());
abb.zybrenshu=rs.getString("zybrenshu");
abb.setKeyValue("ZYBRENSHU","" + abb.getZybrenshu());
abb.dlrenshu=rs.getString("dlrenshu");
abb.setKeyValue("DLRENSHU","" + abb.getDlrenshu());
abb.tjrenshu2=rs.getString("tjrenshu2");
abb.setKeyValue("TJRENSHU2","" + abb.getTjrenshu2());
abb.tjrenshu3=rs.getString("tjrenshu3");
abb.setKeyValue("TJRENSHU3","" + abb.getTjrenshu3());
abb.zybrenshuxz=rs.getString("zybrenshuxz");
abb.setKeyValue("ZYBRENSHUXZ","" + abb.getZybrenshuxz());
abb.zybrenshuys=rs.getString("zybrenshuys");
abb.setKeyValue("ZYBRENSHUYS","" + abb.getZybrenshuys());
abb.pxrenshu=rs.getString("pxrenshu");
abb.setKeyValue("PXRENSHU","" + abb.getPxrenshu());
abb.swrenshu=rs.getString("swrenshu");
abb.setKeyValue("SWRENSHU","" + abb.getSwrenshu());
abb.swrenshuxz=rs.getString("swrenshuxz");
abb.setKeyValue("SWRENSHUXZ","" + abb.getSwrenshuxz());
abb.zhuguan=rs.getString("zhuguan");
abb.setKeyValue("ZHUGUAN","" + abb.getZhuguan());
abb.zywsjgshu=rs.getString("zywsjgshu");
abb.setKeyValue("ZYWSJGSHU","" + abb.getZywsjgshu());
abb.zywsgl=rs.getString("zywsgl");
abb.setKeyValue("ZYWSGL","" + abb.getZywsgl());
abb.chanzhi=rs.getString("chanzhi");
abb.setKeyValue("CHANZHI","" + abb.getChanzhi());
abb.zichan=rs.getString("zichan");
abb.setKeyValue("ZICHAN","" + abb.getZichan());
abb.sbren=rs.getString("sbren");
abb.setKeyValue("SBREN","" + abb.getSbren());
abb.sbrendh=rs.getString("sbrendh");
abb.setKeyValue("SBRENDH","" + abb.getSbrendh());
abb.ystbbm=rs.getString("ystbbm");
abb.setKeyValue("YSTBBM","" + abb.getYstbbm());
abb.ystbren=rs.getString("ystbren");
abb.setKeyValue("YSTBREN","" + abb.getYstbren());
abb.ysshren=rs.getString("ysshren");
abb.setKeyValue("YSSHREN","" + abb.getYsshren());
abb.ystbdate=rs.getString("ystbdate");
abb.setKeyValue("YSTBDATE","" + abb.getYstbdate());
abb.ysjiancejg=rs.getString("ysjiancejg");
abb.setKeyValue("YSJIANCEJG","" + abb.getYsjiancejg());
abb.ysjiancedate=rs.getString("ysjiancedate");
abb.setKeyValue("YSJIANCEDATE","" + abb.getYsjiancedate());
abb.gltbbm=rs.getString("gltbbm");
abb.setKeyValue("GLTBBM","" + abb.getGltbbm());
abb.gltbren=rs.getString("gltbren");
abb.setKeyValue("GLTBREN","" + abb.getGltbren());
abb.gltbdate=rs.getString("gltbdate");
abb.setKeyValue("GLTBDATE","" + abb.getGltbdate());
abb.glpeixunjg=rs.getString("glpeixunjg");
abb.setKeyValue("GLPEIXUNJG","" + abb.getGlpeixunjg());
abb.glpeixundate=rs.getString("glpeixundate");
abb.setKeyValue("GLPEIXUNDATE","" + abb.getGlpeixundate());
abb.gltijianjg=rs.getString("gltijianjg");
abb.setKeyValue("GLTIJIANJG","" + abb.getGltijianjg());
abb.gltijiandate=rs.getString("gltijiandate");
abb.setKeyValue("GLTIJIANDATE","" + abb.getGltijiandate());
abb.liuchengid=rs.getString("liuchengid");
abb.setKeyValue("LIUCHENGID","" + abb.getLiuchengid());
abb.tbliucheng=rs.getString("tbliucheng");
abb.setKeyValue("TBLIUCHENG","" + abb.getTbliucheng());
abb.dq1=rs.getString("dq1");
abb.setKeyValue("DQ1","" + abb.getDq1());
abb.dq2=rs.getString("dq2");
abb.setKeyValue("DQ2","" + abb.getDq2());
abb.dq3=rs.getString("dq3");
abb.setKeyValue("DQ3","" + abb.getDq3());
abb.scyj1=rs.getString("scyj1");
abb.setKeyValue("SCYJ1","" + abb.getScyj1());
abb.scyj2=rs.getString("scyj2");
abb.setKeyValue("SCYJ2","" + abb.getScyj2());
abb.scyj3=rs.getString("scyj3");
abb.setKeyValue("SCYJ3","" + abb.getScyj3());
abb.scdate1=rs.getString("scdate1");
abb.setKeyValue("SCDATE1","" + abb.getScdate1());
abb.scdate2=rs.getString("scdate2");
abb.setKeyValue("SCDATE2","" + abb.getScdate2());
abb.scdate3=rs.getString("scdate3");
abb.setKeyValue("SCDATE3","" + abb.getScdate3());
abb.sbyes=rs.getString("sbyes");
abb.setKeyValue("SBYES","" + abb.getSbyes());
abb.beiandate=rs.getString("beiandate");
abb.setKeyValue("BEIANDATE","" + abb.getBeiandate());
abb.beianhao=rs.getString("beianhao");
abb.setKeyValue("BEIANHAO","" + abb.getBeianhao());
abb.scyj0=rs.getString("scyj0");
abb.setKeyValue("SCYJ0","" + abb.getScyj0());
abb.scdate0=rs.getString("scdate0");
abb.setKeyValue("SCDATE0","" + abb.getScdate0());
abb.dq4=rs.getString("dq4");
abb.setKeyValue("DQ4","" + abb.getDq4());
abb.scyj4=rs.getString("scyj4");
abb.setKeyValue("SCYJ4","" + abb.getScyj4());
abb.scdate4=rs.getString("scdate4");
abb.setKeyValue("SCDATE4","" + abb.getScdate4());
abb.jcfcren=rs.getString("jcfcren");
abb.setKeyValue("JCFCREN","" + abb.getJcfcren());
abb.jchxren=rs.getString("jchxren");
abb.setKeyValue("JCHXREN","" + abb.getJchxren());
abb.jcwlren=rs.getString("jcwlren");
abb.setKeyValue("JCWLREN","" + abb.getJcwlren());
abb.jcfsren=rs.getString("jcfsren");
abb.setKeyValue("JCFSREN","" + abb.getJcfsren());
abb.jcqtren=rs.getString("jcqtren");
abb.setKeyValue("JCQTREN","" + abb.getJcqtren());
abb.htngzzywhrs=rs.getString("htngzzywhrs");
abb.setKeyValue("HTNGZZYWHRS","" + abb.getHtngzzywhrs());
abb.zybzygws=rs.getString("zybzygws");
abb.setKeyValue("ZYBZYGWS","" + abb.getZybzygws());
abb.szjsbzgws=rs.getString("szjsbzgws");
abb.setKeyValue("SZJSBZGWS","" + abb.getSzjsbzgws());
abb.yzywspxs=rs.getString("yzywspxs");
abb.setKeyValue("YZYWSPXS","" + abb.getYzywspxs());
abb.yzyjkjcs=rs.getString("yzyjkjcs");
abb.setKeyValue("YZYJKJCS","" + abb.getYzyjkjcs());
abb.zywhfj=rs.getString("zywhfj");
abb.setKeyValue("ZYWHFJ","" + abb.getZywhfj());
abb.jp=rs.getString("jp");
abb.setKeyValue("JP","" + abb.getJp());
abb.qp=rs.getString("qp");
abb.setKeyValue("QP","" + abb.getQp());
abb.wghdq1=rs.getString("wghdq1");
abb.setKeyValue("WGHDQ1","" + abb.getWghdq1());
abb.wghdq2=rs.getString("wghdq2");
abb.setKeyValue("WGHDQ2","" + abb.getWghdq2());
abb.wghdq3=rs.getString("wghdq3");
abb.setKeyValue("WGHDQ3","" + abb.getWghdq3());
abb.wghdq4=rs.getString("wghdq4");
abb.setKeyValue("WGHDQ4","" + abb.getWghdq4());
abb.wghdq5=rs.getString("wghdq5");
abb.setKeyValue("WGHDQ5","" + abb.getWghdq5());
abb.bak1=rs.getString("bak1");
abb.setKeyValue("BAK1","" + abb.getBak1());
abb.bak2=rs.getString("bak2");
abb.setKeyValue("BAK2","" + abb.getBak2());
abb.bak3=rs.getString("bak3");
abb.setKeyValue("BAK3","" + abb.getBak3());
abb.bak4=rs.getString("bak4");
abb.setKeyValue("BAK4","" + abb.getBak4());
abb.bak5=rs.getString("bak5");
abb.setKeyValue("BAK5","" + abb.getBak5());
abb.distcode=rs.getString("distcode");
abb.setKeyValue("DISTCODE","" + abb.getDistcode());
abb.whys=rs.getString("whys");
abb.setKeyValue("WHYS","" + abb.getWhys());
abb.whysname=rs.getString("whysname");
abb.setKeyValue("WHYSNAME","" + abb.getWhysname());
abb.zywsxkzz=rs.getString("zywsxkzz");
abb.setKeyValue("ZYWSXKZZ","" + abb.getZywsxkzz());
abb.zywsxkzf=rs.getString("zywsxkzf");
abb.setKeyValue("ZYWSXKZF","" + abb.getZywsxkzf());
abb.otherzg=rs.getString("otherzg");
abb.setKeyValue("OTHERZG","" + abb.getOtherzg());
list.add(abb);
abb.operate_mode = "edit";
}public String getEnterno(){ if ( this.enterno == null){ return ""; } else {return this.enterno;}}public String getCorpkey(){ if ( this.corpkey == null){ return ""; } else {return this.corpkey;}}public String getDwmc(){ if ( this.dwmc == null){ return ""; } else {return this.dwmc;}}public String getZzjgdm(){ if ( this.zzjgdm == null){ return ""; } else {return this.zzjgdm;}}public String getGszch(){ if ( this.gszch == null){ return ""; } else {return this.gszch;}}public String getZcdz(){ if ( this.zcdz == null){ return ""; } else {return this.zcdz;}}public String getFrdbsfzh(){ if ( this.frdbsfzh == null){ return ""; } else {return this.frdbsfzh;}}public String getDdremail(){ if ( this.ddremail == null){ return ""; } else {return this.ddremail;}}public String getZczb(){ if ( this.zczb == null){ return ""; } else {return this.zczb;}}public String getJcdate(){ if ( this.jcdate == null){ return ""; } else {return this.jcdate;}}public String getSfczzdwxy(){ if ( this.sfczzdwxy == null){ return ""; } else {return this.sfczzdwxy;}}public String getZcyzbm(){ if ( this.zcyzbm == null){ return ""; } else {return this.zcyzbm;}}public String getCsdz(){ if ( this.csdz == null){ return ""; } else {return this.csdz;}}public String getCsyzbm(){ if ( this.csyzbm == null){ return ""; } else {return this.csyzbm;}}public String getFddbr(){ if ( this.fddbr == null){ return ""; } else {return this.fddbr;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getHyfl1(){ if ( this.hyfl1 == null){ return ""; } else {return this.hyfl1;}}public String getHyfl2(){ if ( this.hyfl2 == null){ return ""; } else {return this.hyfl2;}}public String getHyfl(){ if ( this.hyfl == null){ return ""; } else {return this.hyfl;}}public String getZclx(){ if ( this.zclx == null){ return ""; } else {return this.zclx;}}public String getTblb(){ if ( this.tblb == null){ return ""; } else {return this.tblb;}}public String getZywsjg(){ if ( this.zywsjg == null){ return ""; } else {return this.zywsjg;}}public String getZywsfzr(){ if ( this.zywsfzr == null){ return ""; } else {return this.zywsfzr;}}public String getZywslxdh(){ if ( this.zywslxdh == null){ return ""; } else {return this.zywslxdh;}}public String getBgyy(){ if ( this.bgyy == null){ return ""; } else {return this.bgyy;}}public String getQtbgyy(){ if ( this.qtbgyy == null){ return ""; } else {return this.qtbgyy;}}public String getNmzgrs(){ if ( this.nmzgrs == null){ return ""; } else {return this.nmzgrs;}}public String getScwomen(){ if ( this.scwomen == null){ return ""; } else {return this.scwomen;}}public String getScnongmin(){ if ( this.scnongmin == null){ return ""; } else {return this.scnongmin;}}public String getWhrenshu(){ if ( this.whrenshu == null){ return ""; } else {return this.whrenshu;}}public String getWhwomen(){ if ( this.whwomen == null){ return ""; } else {return this.whwomen;}}public String getWhnongmin(){ if ( this.whnongmin == null){ return ""; } else {return this.whnongmin;}}public String getTjrenshu(){ if ( this.tjrenshu == null){ return ""; } else {return this.tjrenshu;}}public String getZybrenshu(){ if ( this.zybrenshu == null){ return ""; } else {return this.zybrenshu;}}public String getDlrenshu(){ if ( this.dlrenshu == null){ return ""; } else {return this.dlrenshu;}}public String getTjrenshu2(){ if ( this.tjrenshu2 == null){ return ""; } else {return this.tjrenshu2;}}public String getTjrenshu3(){ if ( this.tjrenshu3 == null){ return ""; } else {return this.tjrenshu3;}}public String getZybrenshuxz(){ if ( this.zybrenshuxz == null){ return ""; } else {return this.zybrenshuxz;}}public String getZybrenshuys(){ if ( this.zybrenshuys == null){ return ""; } else {return this.zybrenshuys;}}public String getPxrenshu(){ if ( this.pxrenshu == null){ return ""; } else {return this.pxrenshu;}}public String getSwrenshu(){ if ( this.swrenshu == null){ return ""; } else {return this.swrenshu;}}public String getSwrenshuxz(){ if ( this.swrenshuxz == null){ return ""; } else {return this.swrenshuxz;}}public String getZhuguan(){ if ( this.zhuguan == null){ return ""; } else {return this.zhuguan;}}public String getZywsjgshu(){ if ( this.zywsjgshu == null){ return ""; } else {return this.zywsjgshu;}}public String getZywsgl(){ if ( this.zywsgl == null){ return ""; } else {return this.zywsgl;}}public String getChanzhi(){ if ( this.chanzhi == null){ return ""; } else {return this.chanzhi;}}public String getZichan(){ if ( this.zichan == null){ return ""; } else {return this.zichan;}}public String getSbren(){ if ( this.sbren == null){ return ""; } else {return this.sbren;}}public String getSbrendh(){ if ( this.sbrendh == null){ return ""; } else {return this.sbrendh;}}public String getYstbbm(){ if ( this.ystbbm == null){ return ""; } else {return this.ystbbm;}}public String getYstbren(){ if ( this.ystbren == null){ return ""; } else {return this.ystbren;}}public String getYsshren(){ if ( this.ysshren == null){ return ""; } else {return this.ysshren;}}public String getYstbdate(){ if ( this.ystbdate == null){ return ""; } else {return this.ystbdate;}}public String getYsjiancejg(){ if ( this.ysjiancejg == null){ return ""; } else {return this.ysjiancejg;}}public String getYsjiancedate(){ if ( this.ysjiancedate == null){ return ""; } else {return this.ysjiancedate;}}public String getGltbbm(){ if ( this.gltbbm == null){ return ""; } else {return this.gltbbm;}}public String getGltbren(){ if ( this.gltbren == null){ return ""; } else {return this.gltbren;}}public String getGltbdate(){ if ( this.gltbdate == null){ return ""; } else {return this.gltbdate;}}public String getGlpeixunjg(){ if ( this.glpeixunjg == null){ return ""; } else {return this.glpeixunjg;}}public String getGlpeixundate(){ if ( this.glpeixundate == null){ return ""; } else {return this.glpeixundate;}}public String getGltijianjg(){ if ( this.gltijianjg == null){ return ""; } else {return this.gltijianjg;}}public String getGltijiandate(){ if ( this.gltijiandate == null){ return ""; } else {return this.gltijiandate;}}public String getLiuchengid(){ if ( this.liuchengid == null){ return ""; } else {return this.liuchengid;}}public String getTbliucheng(){ if ( this.tbliucheng == null){ return ""; } else {return this.tbliucheng;}}public String getDq1(){ if ( this.dq1 == null){ return ""; } else {return this.dq1;}}public String getDq2(){ if ( this.dq2 == null){ return ""; } else {return this.dq2;}}public String getDq3(){ if ( this.dq3 == null){ return ""; } else {return this.dq3;}}public String getScyj1(){ if ( this.scyj1 == null){ return ""; } else {return this.scyj1;}}public String getScyj2(){ if ( this.scyj2 == null){ return ""; } else {return this.scyj2;}}public String getScyj3(){ if ( this.scyj3 == null){ return ""; } else {return this.scyj3;}}public String getScdate1(){ if ( this.scdate1 == null){ return ""; } else {return this.scdate1;}}public String getScdate2(){ if ( this.scdate2 == null){ return ""; } else {return this.scdate2;}}public String getScdate3(){ if ( this.scdate3 == null){ return ""; } else {return this.scdate3;}}public String getSbyes(){ if ( this.sbyes == null){ return ""; } else {return this.sbyes;}}public String getBeiandate(){ if ( this.beiandate == null){ return ""; } else {return this.beiandate;}}public String getBeianhao(){ if ( this.beianhao == null){ return ""; } else {return this.beianhao;}}public String getScyj0(){ if ( this.scyj0 == null){ return ""; } else {return this.scyj0;}}public String getScdate0(){ if ( this.scdate0 == null){ return ""; } else {return this.scdate0;}}public String getDq4(){ if ( this.dq4 == null){ return ""; } else {return this.dq4;}}public String getScyj4(){ if ( this.scyj4 == null){ return ""; } else {return this.scyj4;}}public String getScdate4(){ if ( this.scdate4 == null){ return ""; } else {return this.scdate4;}}public String getJcfcren(){ if ( this.jcfcren == null){ return ""; } else {return this.jcfcren;}}public String getJchxren(){ if ( this.jchxren == null){ return ""; } else {return this.jchxren;}}public String getJcwlren(){ if ( this.jcwlren == null){ return ""; } else {return this.jcwlren;}}public String getJcfsren(){ if ( this.jcfsren == null){ return ""; } else {return this.jcfsren;}}public String getJcqtren(){ if ( this.jcqtren == null){ return ""; } else {return this.jcqtren;}}public String getHtngzzywhrs(){ if ( this.htngzzywhrs == null){ return ""; } else {return this.htngzzywhrs;}}public String getZybzygws(){ if ( this.zybzygws == null){ return ""; } else {return this.zybzygws;}}public String getSzjsbzgws(){ if ( this.szjsbzgws == null){ return ""; } else {return this.szjsbzgws;}}public String getYzywspxs(){ if ( this.yzywspxs == null){ return ""; } else {return this.yzywspxs;}}public String getYzyjkjcs(){ if ( this.yzyjkjcs == null){ return ""; } else {return this.yzyjkjcs;}}public String getZywhfj(){ if ( this.zywhfj == null){ return ""; } else {return this.zywhfj;}}public String getJp(){ if ( this.jp == null){ return ""; } else {return this.jp;}}public String getQp(){ if ( this.qp == null){ return ""; } else {return this.qp;}}public String getWghdq1(){ if ( this.wghdq1 == null){ return ""; } else {return this.wghdq1;}}public String getWghdq2(){ if ( this.wghdq2 == null){ return ""; } else {return this.wghdq2;}}public String getWghdq3(){ if ( this.wghdq3 == null){ return ""; } else {return this.wghdq3;}}public String getWghdq4(){ if ( this.wghdq4 == null){ return ""; } else {return this.wghdq4;}}public String getWghdq5(){ if ( this.wghdq5 == null){ return ""; } else {return this.wghdq5;}}public String getBak1(){ if ( this.bak1 == null){ return ""; } else {return this.bak1;}}public String getBak2(){ if ( this.bak2 == null){ return ""; } else {return this.bak2;}}public String getBak3(){ if ( this.bak3 == null){ return ""; } else {return this.bak3;}}public String getBak4(){ if ( this.bak4 == null){ return ""; } else {return this.bak4;}}public String getBak5(){ if ( this.bak5 == null){ return ""; } else {return this.bak5;}}public String getDistcode(){ if ( this.distcode == null){ return ""; } else {return this.distcode;}}public String getWhys(){ if ( this.whys == null){ return ""; } else {return this.whys;}}public String getWhysname(){ if ( this.whysname == null){ return ""; } else {return this.whysname;}}public String getZywsxkzz(){ if ( this.zywsxkzz == null){ return ""; } else {return this.zywsxkzz;}}public String getZywsxkzf(){ if ( this.zywsxkzf == null){ return ""; } else {return this.zywsxkzf;}}public String getOtherzg(){ if ( this.otherzg == null){ return ""; } else {return this.otherzg;}}public void setEnterno( String enterno){sqlMaker.setField("enterno",enterno,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getEnterno().equals(enterno))
cf.add("enterno",this.enterno,enterno);
}
this.enterno=enterno;
}
public void setCorpkey( String corpkey){sqlMaker.setField("corpkey",corpkey,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCorpkey().equals(corpkey))
cf.add("corpkey",this.corpkey,corpkey);
}
this.corpkey=corpkey;
}
public void setDwmc( String dwmc){sqlMaker.setField("dwmc",dwmc,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDwmc().equals(dwmc))
cf.add("dwmc",this.dwmc,dwmc);
}
this.dwmc=dwmc;
}
public void setZzjgdm( String zzjgdm){sqlMaker.setField("zzjgdm",zzjgdm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZzjgdm().equals(zzjgdm))
cf.add("zzjgdm",this.zzjgdm,zzjgdm);
}
this.zzjgdm=zzjgdm;
}
public void setGszch( String gszch){sqlMaker.setField("gszch",gszch,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGszch().equals(gszch))
cf.add("gszch",this.gszch,gszch);
}
this.gszch=gszch;
}
public void setZcdz( String zcdz){sqlMaker.setField("zcdz",zcdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZcdz().equals(zcdz))
cf.add("zcdz",this.zcdz,zcdz);
}
this.zcdz=zcdz;
}
public void setFrdbsfzh( String frdbsfzh){sqlMaker.setField("frdbsfzh",frdbsfzh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFrdbsfzh().equals(frdbsfzh))
cf.add("frdbsfzh",this.frdbsfzh,frdbsfzh);
}
this.frdbsfzh=frdbsfzh;
}
public void setDdremail( String ddremail){sqlMaker.setField("ddremail",ddremail,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDdremail().equals(ddremail))
cf.add("ddremail",this.ddremail,ddremail);
}
this.ddremail=ddremail;
}
public void setZczb( String zczb){sqlMaker.setField("zczb",zczb,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZczb().equals(zczb))
cf.add("zczb",this.zczb,zczb);
}
this.zczb=zczb;
}
public void setJcdate( String jcdate){sqlMaker.setField("jcdate",jcdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcdate().equals(jcdate))
cf.add("jcdate",this.jcdate,jcdate);
}
this.jcdate=jcdate;
}
public void setSfczzdwxy( String sfczzdwxy){sqlMaker.setField("sfczzdwxy",sfczzdwxy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSfczzdwxy().equals(sfczzdwxy))
cf.add("sfczzdwxy",this.sfczzdwxy,sfczzdwxy);
}
this.sfczzdwxy=sfczzdwxy;
}
public void setZcyzbm( String zcyzbm){sqlMaker.setField("zcyzbm",zcyzbm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZcyzbm().equals(zcyzbm))
cf.add("zcyzbm",this.zcyzbm,zcyzbm);
}
this.zcyzbm=zcyzbm;
}
public void setCsdz( String csdz){sqlMaker.setField("csdz",csdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCsdz().equals(csdz))
cf.add("csdz",this.csdz,csdz);
}
this.csdz=csdz;
}
public void setCsyzbm( String csyzbm){sqlMaker.setField("csyzbm",csyzbm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getCsyzbm().equals(csyzbm))
cf.add("csyzbm",this.csyzbm,csyzbm);
}
this.csyzbm=csyzbm;
}
public void setFddbr( String fddbr){sqlMaker.setField("fddbr",fddbr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getFddbr().equals(fddbr))
cf.add("fddbr",this.fddbr,fddbr);
}
this.fddbr=fddbr;
}
public void setLxdh( String lxdh){sqlMaker.setField("lxdh",lxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLxdh().equals(lxdh))
cf.add("lxdh",this.lxdh,lxdh);
}
this.lxdh=lxdh;
}
public void setHyfl1( String hyfl1){sqlMaker.setField("hyfl1",hyfl1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHyfl1().equals(hyfl1))
cf.add("hyfl1",this.hyfl1,hyfl1);
}
this.hyfl1=hyfl1;
}
public void setHyfl2( String hyfl2){sqlMaker.setField("hyfl2",hyfl2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHyfl2().equals(hyfl2))
cf.add("hyfl2",this.hyfl2,hyfl2);
}
this.hyfl2=hyfl2;
}
public void setHyfl( String hyfl){sqlMaker.setField("hyfl",hyfl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHyfl().equals(hyfl))
cf.add("hyfl",this.hyfl,hyfl);
}
this.hyfl=hyfl;
}
public void setZclx( String zclx){sqlMaker.setField("zclx",zclx,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZclx().equals(zclx))
cf.add("zclx",this.zclx,zclx);
}
this.zclx=zclx;
}
public void setTblb( String tblb){sqlMaker.setField("tblb",tblb,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTblb().equals(tblb))
cf.add("tblb",this.tblb,tblb);
}
this.tblb=tblb;
}
public void setZywsjg( String zywsjg){sqlMaker.setField("zywsjg",zywsjg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZywsjg().equals(zywsjg))
cf.add("zywsjg",this.zywsjg,zywsjg);
}
this.zywsjg=zywsjg;
}
public void setZywsfzr( String zywsfzr){sqlMaker.setField("zywsfzr",zywsfzr,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZywsfzr().equals(zywsfzr))
cf.add("zywsfzr",this.zywsfzr,zywsfzr);
}
this.zywsfzr=zywsfzr;
}
public void setZywslxdh( String zywslxdh){sqlMaker.setField("zywslxdh",zywslxdh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZywslxdh().equals(zywslxdh))
cf.add("zywslxdh",this.zywslxdh,zywslxdh);
}
this.zywslxdh=zywslxdh;
}
public void setBgyy( String bgyy){sqlMaker.setField("bgyy",bgyy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBgyy().equals(bgyy))
cf.add("bgyy",this.bgyy,bgyy);
}
this.bgyy=bgyy;
}
public void setQtbgyy( String qtbgyy){sqlMaker.setField("qtbgyy",qtbgyy,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getQtbgyy().equals(qtbgyy))
cf.add("qtbgyy",this.qtbgyy,qtbgyy);
}
this.qtbgyy=qtbgyy;
}
public void setNmzgrs( String nmzgrs){sqlMaker.setField("nmzgrs",nmzgrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getNmzgrs().equals(nmzgrs))
cf.add("nmzgrs",this.nmzgrs,nmzgrs);
}
this.nmzgrs=nmzgrs;
}
public void setScwomen( String scwomen){sqlMaker.setField("scwomen",scwomen,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScwomen().equals(scwomen))
cf.add("scwomen",this.scwomen,scwomen);
}
this.scwomen=scwomen;
}
public void setScnongmin( String scnongmin){sqlMaker.setField("scnongmin",scnongmin,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScnongmin().equals(scnongmin))
cf.add("scnongmin",this.scnongmin,scnongmin);
}
this.scnongmin=scnongmin;
}
public void setWhrenshu( String whrenshu){sqlMaker.setField("whrenshu",whrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhrenshu().equals(whrenshu))
cf.add("whrenshu",this.whrenshu,whrenshu);
}
this.whrenshu=whrenshu;
}
public void setWhwomen( String whwomen){sqlMaker.setField("whwomen",whwomen,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhwomen().equals(whwomen))
cf.add("whwomen",this.whwomen,whwomen);
}
this.whwomen=whwomen;
}
public void setWhnongmin( String whnongmin){sqlMaker.setField("whnongmin",whnongmin,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhnongmin().equals(whnongmin))
cf.add("whnongmin",this.whnongmin,whnongmin);
}
this.whnongmin=whnongmin;
}
public void setTjrenshu( String tjrenshu){sqlMaker.setField("tjrenshu",tjrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTjrenshu().equals(tjrenshu))
cf.add("tjrenshu",this.tjrenshu,tjrenshu);
}
this.tjrenshu=tjrenshu;
}
public void setZybrenshu( String zybrenshu){sqlMaker.setField("zybrenshu",zybrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZybrenshu().equals(zybrenshu))
cf.add("zybrenshu",this.zybrenshu,zybrenshu);
}
this.zybrenshu=zybrenshu;
}
public void setDlrenshu( String dlrenshu){sqlMaker.setField("dlrenshu",dlrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDlrenshu().equals(dlrenshu))
cf.add("dlrenshu",this.dlrenshu,dlrenshu);
}
this.dlrenshu=dlrenshu;
}
public void setTjrenshu2( String tjrenshu2){sqlMaker.setField("tjrenshu2",tjrenshu2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTjrenshu2().equals(tjrenshu2))
cf.add("tjrenshu2",this.tjrenshu2,tjrenshu2);
}
this.tjrenshu2=tjrenshu2;
}
public void setTjrenshu3( String tjrenshu3){sqlMaker.setField("tjrenshu3",tjrenshu3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTjrenshu3().equals(tjrenshu3))
cf.add("tjrenshu3",this.tjrenshu3,tjrenshu3);
}
this.tjrenshu3=tjrenshu3;
}
public void setZybrenshuxz( String zybrenshuxz){sqlMaker.setField("zybrenshuxz",zybrenshuxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZybrenshuxz().equals(zybrenshuxz))
cf.add("zybrenshuxz",this.zybrenshuxz,zybrenshuxz);
}
this.zybrenshuxz=zybrenshuxz;
}
public void setZybrenshuys( String zybrenshuys){sqlMaker.setField("zybrenshuys",zybrenshuys,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZybrenshuys().equals(zybrenshuys))
cf.add("zybrenshuys",this.zybrenshuys,zybrenshuys);
}
this.zybrenshuys=zybrenshuys;
}
public void setPxrenshu( String pxrenshu){sqlMaker.setField("pxrenshu",pxrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getPxrenshu().equals(pxrenshu))
cf.add("pxrenshu",this.pxrenshu,pxrenshu);
}
this.pxrenshu=pxrenshu;
}
public void setSwrenshu( String swrenshu){sqlMaker.setField("swrenshu",swrenshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSwrenshu().equals(swrenshu))
cf.add("swrenshu",this.swrenshu,swrenshu);
}
this.swrenshu=swrenshu;
}
public void setSwrenshuxz( String swrenshuxz){sqlMaker.setField("swrenshuxz",swrenshuxz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSwrenshuxz().equals(swrenshuxz))
cf.add("swrenshuxz",this.swrenshuxz,swrenshuxz);
}
this.swrenshuxz=swrenshuxz;
}
public void setZhuguan( String zhuguan){sqlMaker.setField("zhuguan",zhuguan,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZhuguan().equals(zhuguan))
cf.add("zhuguan",this.zhuguan,zhuguan);
}
this.zhuguan=zhuguan;
}
public void setZywsjgshu( String zywsjgshu){sqlMaker.setField("zywsjgshu",zywsjgshu,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZywsjgshu().equals(zywsjgshu))
cf.add("zywsjgshu",this.zywsjgshu,zywsjgshu);
}
this.zywsjgshu=zywsjgshu;
}
public void setZywsgl( String zywsgl){sqlMaker.setField("zywsgl",zywsgl,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZywsgl().equals(zywsgl))
cf.add("zywsgl",this.zywsgl,zywsgl);
}
this.zywsgl=zywsgl;
}
public void setChanzhi( String chanzhi){sqlMaker.setField("chanzhi",chanzhi,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getChanzhi().equals(chanzhi))
cf.add("chanzhi",this.chanzhi,chanzhi);
}
this.chanzhi=chanzhi;
}
public void setZichan( String zichan){sqlMaker.setField("zichan",zichan,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZichan().equals(zichan))
cf.add("zichan",this.zichan,zichan);
}
this.zichan=zichan;
}
public void setSbren( String sbren){sqlMaker.setField("sbren",sbren,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSbren().equals(sbren))
cf.add("sbren",this.sbren,sbren);
}
this.sbren=sbren;
}
public void setSbrendh( String sbrendh){sqlMaker.setField("sbrendh",sbrendh,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSbrendh().equals(sbrendh))
cf.add("sbrendh",this.sbrendh,sbrendh);
}
this.sbrendh=sbrendh;
}
public void setYstbbm( String ystbbm){sqlMaker.setField("ystbbm",ystbbm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYstbbm().equals(ystbbm))
cf.add("ystbbm",this.ystbbm,ystbbm);
}
this.ystbbm=ystbbm;
}
public void setYstbren( String ystbren){sqlMaker.setField("ystbren",ystbren,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYstbren().equals(ystbren))
cf.add("ystbren",this.ystbren,ystbren);
}
this.ystbren=ystbren;
}
public void setYsshren( String ysshren){sqlMaker.setField("ysshren",ysshren,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYsshren().equals(ysshren))
cf.add("ysshren",this.ysshren,ysshren);
}
this.ysshren=ysshren;
}
public void setYstbdate( String ystbdate){sqlMaker.setField("ystbdate",ystbdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYstbdate().equals(ystbdate))
cf.add("ystbdate",this.ystbdate,ystbdate);
}
this.ystbdate=ystbdate;
}
public void setYsjiancejg( String ysjiancejg){sqlMaker.setField("ysjiancejg",ysjiancejg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYsjiancejg().equals(ysjiancejg))
cf.add("ysjiancejg",this.ysjiancejg,ysjiancejg);
}
this.ysjiancejg=ysjiancejg;
}
public void setYsjiancedate( String ysjiancedate){sqlMaker.setField("ysjiancedate",ysjiancedate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYsjiancedate().equals(ysjiancedate))
cf.add("ysjiancedate",this.ysjiancedate,ysjiancedate);
}
this.ysjiancedate=ysjiancedate;
}
public void setGltbbm( String gltbbm){sqlMaker.setField("gltbbm",gltbbm,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGltbbm().equals(gltbbm))
cf.add("gltbbm",this.gltbbm,gltbbm);
}
this.gltbbm=gltbbm;
}
public void setGltbren( String gltbren){sqlMaker.setField("gltbren",gltbren,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGltbren().equals(gltbren))
cf.add("gltbren",this.gltbren,gltbren);
}
this.gltbren=gltbren;
}
public void setGltbdate( String gltbdate){sqlMaker.setField("gltbdate",gltbdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGltbdate().equals(gltbdate))
cf.add("gltbdate",this.gltbdate,gltbdate);
}
this.gltbdate=gltbdate;
}
public void setGlpeixunjg( String glpeixunjg){sqlMaker.setField("glpeixunjg",glpeixunjg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGlpeixunjg().equals(glpeixunjg))
cf.add("glpeixunjg",this.glpeixunjg,glpeixunjg);
}
this.glpeixunjg=glpeixunjg;
}
public void setGlpeixundate( String glpeixundate){sqlMaker.setField("glpeixundate",glpeixundate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGlpeixundate().equals(glpeixundate))
cf.add("glpeixundate",this.glpeixundate,glpeixundate);
}
this.glpeixundate=glpeixundate;
}
public void setGltijianjg( String gltijianjg){sqlMaker.setField("gltijianjg",gltijianjg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGltijianjg().equals(gltijianjg))
cf.add("gltijianjg",this.gltijianjg,gltijianjg);
}
this.gltijianjg=gltijianjg;
}
public void setGltijiandate( String gltijiandate){sqlMaker.setField("gltijiandate",gltijiandate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getGltijiandate().equals(gltijiandate))
cf.add("gltijiandate",this.gltijiandate,gltijiandate);
}
this.gltijiandate=gltijiandate;
}
public void setLiuchengid( String liuchengid){sqlMaker.setField("liuchengid",liuchengid,Field.NUMBER);
if (this.operate_mode.equals("edit")) {
if (!this.getLiuchengid().equals(liuchengid))
cf.add("liuchengid",this.liuchengid,liuchengid);
}
this.liuchengid=liuchengid;
}
public void setTbliucheng( String tbliucheng){sqlMaker.setField("tbliucheng",tbliucheng,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getTbliucheng().equals(tbliucheng))
cf.add("tbliucheng",this.tbliucheng,tbliucheng);
}
this.tbliucheng=tbliucheng;
}
public void setDq1( String dq1){sqlMaker.setField("dq1",dq1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDq1().equals(dq1))
cf.add("dq1",this.dq1,dq1);
}
this.dq1=dq1;
}
public void setDq2( String dq2){sqlMaker.setField("dq2",dq2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDq2().equals(dq2))
cf.add("dq2",this.dq2,dq2);
}
this.dq2=dq2;
}
public void setDq3( String dq3){sqlMaker.setField("dq3",dq3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDq3().equals(dq3))
cf.add("dq3",this.dq3,dq3);
}
this.dq3=dq3;
}
public void setScyj1( String scyj1){sqlMaker.setField("scyj1",scyj1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScyj1().equals(scyj1))
cf.add("scyj1",this.scyj1,scyj1);
}
this.scyj1=scyj1;
}
public void setScyj2( String scyj2){sqlMaker.setField("scyj2",scyj2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScyj2().equals(scyj2))
cf.add("scyj2",this.scyj2,scyj2);
}
this.scyj2=scyj2;
}
public void setScyj3( String scyj3){sqlMaker.setField("scyj3",scyj3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScyj3().equals(scyj3))
cf.add("scyj3",this.scyj3,scyj3);
}
this.scyj3=scyj3;
}
public void setScdate1( String scdate1){sqlMaker.setField("scdate1",scdate1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScdate1().equals(scdate1))
cf.add("scdate1",this.scdate1,scdate1);
}
this.scdate1=scdate1;
}
public void setScdate2( String scdate2){sqlMaker.setField("scdate2",scdate2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScdate2().equals(scdate2))
cf.add("scdate2",this.scdate2,scdate2);
}
this.scdate2=scdate2;
}
public void setScdate3( String scdate3){sqlMaker.setField("scdate3",scdate3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScdate3().equals(scdate3))
cf.add("scdate3",this.scdate3,scdate3);
}
this.scdate3=scdate3;
}
public void setSbyes( String sbyes){sqlMaker.setField("sbyes",sbyes,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSbyes().equals(sbyes))
cf.add("sbyes",this.sbyes,sbyes);
}
this.sbyes=sbyes;
}
public void setBeiandate( String beiandate){sqlMaker.setField("beiandate",beiandate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBeiandate().equals(beiandate))
cf.add("beiandate",this.beiandate,beiandate);
}
this.beiandate=beiandate;
}
public void setBeianhao( String beianhao){sqlMaker.setField("beianhao",beianhao,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBeianhao().equals(beianhao))
cf.add("beianhao",this.beianhao,beianhao);
}
this.beianhao=beianhao;
}
public void setScyj0( String scyj0){sqlMaker.setField("scyj0",scyj0,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScyj0().equals(scyj0))
cf.add("scyj0",this.scyj0,scyj0);
}
this.scyj0=scyj0;
}
public void setScdate0( String scdate0){sqlMaker.setField("scdate0",scdate0,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScdate0().equals(scdate0))
cf.add("scdate0",this.scdate0,scdate0);
}
this.scdate0=scdate0;
}
public void setDq4( String dq4){sqlMaker.setField("dq4",dq4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDq4().equals(dq4))
cf.add("dq4",this.dq4,dq4);
}
this.dq4=dq4;
}
public void setScyj4( String scyj4){sqlMaker.setField("scyj4",scyj4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScyj4().equals(scyj4))
cf.add("scyj4",this.scyj4,scyj4);
}
this.scyj4=scyj4;
}
public void setScdate4( String scdate4){sqlMaker.setField("scdate4",scdate4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getScdate4().equals(scdate4))
cf.add("scdate4",this.scdate4,scdate4);
}
this.scdate4=scdate4;
}
public void setJcfcren( String jcfcren){sqlMaker.setField("jcfcren",jcfcren,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcfcren().equals(jcfcren))
cf.add("jcfcren",this.jcfcren,jcfcren);
}
this.jcfcren=jcfcren;
}
public void setJchxren( String jchxren){sqlMaker.setField("jchxren",jchxren,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJchxren().equals(jchxren))
cf.add("jchxren",this.jchxren,jchxren);
}
this.jchxren=jchxren;
}
public void setJcwlren( String jcwlren){sqlMaker.setField("jcwlren",jcwlren,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcwlren().equals(jcwlren))
cf.add("jcwlren",this.jcwlren,jcwlren);
}
this.jcwlren=jcwlren;
}
public void setJcfsren( String jcfsren){sqlMaker.setField("jcfsren",jcfsren,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcfsren().equals(jcfsren))
cf.add("jcfsren",this.jcfsren,jcfsren);
}
this.jcfsren=jcfsren;
}
public void setJcqtren( String jcqtren){sqlMaker.setField("jcqtren",jcqtren,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcqtren().equals(jcqtren))
cf.add("jcqtren",this.jcqtren,jcqtren);
}
this.jcqtren=jcqtren;
}
public void setHtngzzywhrs( String htngzzywhrs){sqlMaker.setField("htngzzywhrs",htngzzywhrs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getHtngzzywhrs().equals(htngzzywhrs))
cf.add("htngzzywhrs",this.htngzzywhrs,htngzzywhrs);
}
this.htngzzywhrs=htngzzywhrs;
}
public void setZybzygws( String zybzygws){sqlMaker.setField("zybzygws",zybzygws,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZybzygws().equals(zybzygws))
cf.add("zybzygws",this.zybzygws,zybzygws);
}
this.zybzygws=zybzygws;
}
public void setSzjsbzgws( String szjsbzgws){sqlMaker.setField("szjsbzgws",szjsbzgws,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getSzjsbzgws().equals(szjsbzgws))
cf.add("szjsbzgws",this.szjsbzgws,szjsbzgws);
}
this.szjsbzgws=szjsbzgws;
}
public void setYzywspxs( String yzywspxs){sqlMaker.setField("yzywspxs",yzywspxs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYzywspxs().equals(yzywspxs))
cf.add("yzywspxs",this.yzywspxs,yzywspxs);
}
this.yzywspxs=yzywspxs;
}
public void setYzyjkjcs( String yzyjkjcs){sqlMaker.setField("yzyjkjcs",yzyjkjcs,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getYzyjkjcs().equals(yzyjkjcs))
cf.add("yzyjkjcs",this.yzyjkjcs,yzyjkjcs);
}
this.yzyjkjcs=yzyjkjcs;
}
public void setZywhfj( String zywhfj){sqlMaker.setField("zywhfj",zywhfj,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZywhfj().equals(zywhfj))
cf.add("zywhfj",this.zywhfj,zywhfj);
}
this.zywhfj=zywhfj;
}
public void setJp( String jp){sqlMaker.setField("jp",jp,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJp().equals(jp))
cf.add("jp",this.jp,jp);
}
this.jp=jp;
}
public void setQp( String qp){sqlMaker.setField("qp",qp,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getQp().equals(qp))
cf.add("qp",this.qp,qp);
}
this.qp=qp;
}
public void setWghdq1( String wghdq1){sqlMaker.setField("wghdq1",wghdq1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghdq1().equals(wghdq1))
cf.add("wghdq1",this.wghdq1,wghdq1);
}
this.wghdq1=wghdq1;
}
public void setWghdq2( String wghdq2){sqlMaker.setField("wghdq2",wghdq2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghdq2().equals(wghdq2))
cf.add("wghdq2",this.wghdq2,wghdq2);
}
this.wghdq2=wghdq2;
}
public void setWghdq3( String wghdq3){sqlMaker.setField("wghdq3",wghdq3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghdq3().equals(wghdq3))
cf.add("wghdq3",this.wghdq3,wghdq3);
}
this.wghdq3=wghdq3;
}
public void setWghdq4( String wghdq4){sqlMaker.setField("wghdq4",wghdq4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghdq4().equals(wghdq4))
cf.add("wghdq4",this.wghdq4,wghdq4);
}
this.wghdq4=wghdq4;
}
public void setWghdq5( String wghdq5){sqlMaker.setField("wghdq5",wghdq5,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWghdq5().equals(wghdq5))
cf.add("wghdq5",this.wghdq5,wghdq5);
}
this.wghdq5=wghdq5;
}
public void setBak1( String bak1){sqlMaker.setField("bak1",bak1,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak1().equals(bak1))
cf.add("bak1",this.bak1,bak1);
}
this.bak1=bak1;
}
public void setBak2( String bak2){sqlMaker.setField("bak2",bak2,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak2().equals(bak2))
cf.add("bak2",this.bak2,bak2);
}
this.bak2=bak2;
}
public void setBak3( String bak3){sqlMaker.setField("bak3",bak3,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak3().equals(bak3))
cf.add("bak3",this.bak3,bak3);
}
this.bak3=bak3;
}
public void setBak4( String bak4){sqlMaker.setField("bak4",bak4,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak4().equals(bak4))
cf.add("bak4",this.bak4,bak4);
}
this.bak4=bak4;
}
public void setBak5( String bak5){sqlMaker.setField("bak5",bak5,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBak5().equals(bak5))
cf.add("bak5",this.bak5,bak5);
}
this.bak5=bak5;
}
public void setDistcode( String distcode){sqlMaker.setField("distcode",distcode,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getDistcode().equals(distcode))
cf.add("distcode",this.distcode,distcode);
}
this.distcode=distcode;
}
public void setWhys( String whys){sqlMaker.setField("whys",whys,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhys().equals(whys))
cf.add("whys",this.whys,whys);
}
this.whys=whys;
}
public void setWhysname( String whysname){sqlMaker.setField("whysname",whysname,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getWhysname().equals(whysname))
cf.add("whysname",this.whysname,whysname);
}
this.whysname=whysname;
}
public void setZywsxkzz( String zywsxkzz){sqlMaker.setField("zywsxkzz",zywsxkzz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZywsxkzz().equals(zywsxkzz))
cf.add("zywsxkzz",this.zywsxkzz,zywsxkzz);
}
this.zywsxkzz=zywsxkzz;
}
public void setZywsxkzf( String zywsxkzf){sqlMaker.setField("zywsxkzf",zywsxkzf,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZywsxkzf().equals(zywsxkzf))
cf.add("zywsxkzf",this.zywsxkzf,zywsxkzf);
}
this.zywsxkzf=zywsxkzf;
}
public void setOtherzg( String otherzg){sqlMaker.setField("otherzg",otherzg,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getOtherzg().equals(otherzg))
cf.add("otherzg",this.otherzg,otherzg);
}
this.otherzg=otherzg;
}
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "enterno") != null) 
this.setEnterno(actionRequest.getFieldValue(i, "enterno"));
if (actionRequest.getFieldValue(i, "corpkey") != null) 
this.setCorpkey(actionRequest.getFieldValue(i, "corpkey"));
if (actionRequest.getFieldValue(i, "dwmc") != null) 
this.setDwmc(actionRequest.getFieldValue(i, "dwmc"));
if (actionRequest.getFieldValue(i, "zzjgdm") != null) 
this.setZzjgdm(actionRequest.getFieldValue(i, "zzjgdm"));
if (actionRequest.getFieldValue(i, "gszch") != null) 
this.setGszch(actionRequest.getFieldValue(i, "gszch"));
if (actionRequest.getFieldValue(i, "zcdz") != null) 
this.setZcdz(actionRequest.getFieldValue(i, "zcdz"));
if (actionRequest.getFieldValue(i, "frdbsfzh") != null) 
this.setFrdbsfzh(actionRequest.getFieldValue(i, "frdbsfzh"));
if (actionRequest.getFieldValue(i, "ddremail") != null) 
this.setDdremail(actionRequest.getFieldValue(i, "ddremail"));
if (actionRequest.getFieldValue(i, "zczb") != null) 
this.setZczb(actionRequest.getFieldValue(i, "zczb"));
if (actionRequest.getFieldValue(i, "jcdate") != null) 
this.setJcdate(actionRequest.getFieldValue(i, "jcdate"));
if (actionRequest.getFieldValue(i, "sfczzdwxy") != null) 
this.setSfczzdwxy(actionRequest.getFieldValue(i, "sfczzdwxy"));
if (actionRequest.getFieldValue(i, "zcyzbm") != null) 
this.setZcyzbm(actionRequest.getFieldValue(i, "zcyzbm"));
if (actionRequest.getFieldValue(i, "csdz") != null) 
this.setCsdz(actionRequest.getFieldValue(i, "csdz"));
if (actionRequest.getFieldValue(i, "csyzbm") != null) 
this.setCsyzbm(actionRequest.getFieldValue(i, "csyzbm"));
if (actionRequest.getFieldValue(i, "fddbr") != null) 
this.setFddbr(actionRequest.getFieldValue(i, "fddbr"));
if (actionRequest.getFieldValue(i, "lxdh") != null) 
this.setLxdh(actionRequest.getFieldValue(i, "lxdh"));
if (actionRequest.getFieldValue(i, "hyfl1") != null) 
this.setHyfl1(actionRequest.getFieldValue(i, "hyfl1"));
if (actionRequest.getFieldValue(i, "hyfl2") != null) 
this.setHyfl2(actionRequest.getFieldValue(i, "hyfl2"));
if (actionRequest.getFieldValue(i, "hyfl") != null) 
this.setHyfl(actionRequest.getFieldValue(i, "hyfl"));
if (actionRequest.getFieldValue(i, "zclx") != null) 
this.setZclx(actionRequest.getFieldValue(i, "zclx"));
if (actionRequest.getFieldValue(i, "tblb") != null) 
this.setTblb(actionRequest.getFieldValue(i, "tblb"));
if (actionRequest.getFieldValue(i, "zywsjg") != null) 
this.setZywsjg(actionRequest.getFieldValue(i, "zywsjg"));
if (actionRequest.getFieldValue(i, "zywsfzr") != null) 
this.setZywsfzr(actionRequest.getFieldValue(i, "zywsfzr"));
if (actionRequest.getFieldValue(i, "zywslxdh") != null) 
this.setZywslxdh(actionRequest.getFieldValue(i, "zywslxdh"));
if (actionRequest.getFieldValue(i, "bgyy") != null) 
this.setBgyy(actionRequest.getFieldValue(i, "bgyy"));
if (actionRequest.getFieldValue(i, "qtbgyy") != null) 
this.setQtbgyy(actionRequest.getFieldValue(i, "qtbgyy"));
if (actionRequest.getFieldValue(i, "nmzgrs") != null) 
this.setNmzgrs(actionRequest.getFieldValue(i, "nmzgrs"));
if (actionRequest.getFieldValue(i, "scwomen") != null) 
this.setScwomen(actionRequest.getFieldValue(i, "scwomen"));
if (actionRequest.getFieldValue(i, "scnongmin") != null) 
this.setScnongmin(actionRequest.getFieldValue(i, "scnongmin"));
if (actionRequest.getFieldValue(i, "whrenshu") != null) 
this.setWhrenshu(actionRequest.getFieldValue(i, "whrenshu"));
if (actionRequest.getFieldValue(i, "whwomen") != null) 
this.setWhwomen(actionRequest.getFieldValue(i, "whwomen"));
if (actionRequest.getFieldValue(i, "whnongmin") != null) 
this.setWhnongmin(actionRequest.getFieldValue(i, "whnongmin"));
if (actionRequest.getFieldValue(i, "tjrenshu") != null) 
this.setTjrenshu(actionRequest.getFieldValue(i, "tjrenshu"));
if (actionRequest.getFieldValue(i, "zybrenshu") != null) 
this.setZybrenshu(actionRequest.getFieldValue(i, "zybrenshu"));
if (actionRequest.getFieldValue(i, "dlrenshu") != null) 
this.setDlrenshu(actionRequest.getFieldValue(i, "dlrenshu"));
if (actionRequest.getFieldValue(i, "tjrenshu2") != null) 
this.setTjrenshu2(actionRequest.getFieldValue(i, "tjrenshu2"));
if (actionRequest.getFieldValue(i, "tjrenshu3") != null) 
this.setTjrenshu3(actionRequest.getFieldValue(i, "tjrenshu3"));
if (actionRequest.getFieldValue(i, "zybrenshuxz") != null) 
this.setZybrenshuxz(actionRequest.getFieldValue(i, "zybrenshuxz"));
if (actionRequest.getFieldValue(i, "zybrenshuys") != null) 
this.setZybrenshuys(actionRequest.getFieldValue(i, "zybrenshuys"));
if (actionRequest.getFieldValue(i, "pxrenshu") != null) 
this.setPxrenshu(actionRequest.getFieldValue(i, "pxrenshu"));
if (actionRequest.getFieldValue(i, "swrenshu") != null) 
this.setSwrenshu(actionRequest.getFieldValue(i, "swrenshu"));
if (actionRequest.getFieldValue(i, "swrenshuxz") != null) 
this.setSwrenshuxz(actionRequest.getFieldValue(i, "swrenshuxz"));
if (actionRequest.getFieldValue(i, "zhuguan") != null) 
this.setZhuguan(actionRequest.getFieldValue(i, "zhuguan"));
if (actionRequest.getFieldValue(i, "zywsjgshu") != null) 
this.setZywsjgshu(actionRequest.getFieldValue(i, "zywsjgshu"));
if (actionRequest.getFieldValue(i, "zywsgl") != null) 
this.setZywsgl(actionRequest.getFieldValue(i, "zywsgl"));
if (actionRequest.getFieldValue(i, "chanzhi") != null) 
this.setChanzhi(actionRequest.getFieldValue(i, "chanzhi"));
if (actionRequest.getFieldValue(i, "zichan") != null) 
this.setZichan(actionRequest.getFieldValue(i, "zichan"));
if (actionRequest.getFieldValue(i, "sbren") != null) 
this.setSbren(actionRequest.getFieldValue(i, "sbren"));
if (actionRequest.getFieldValue(i, "sbrendh") != null) 
this.setSbrendh(actionRequest.getFieldValue(i, "sbrendh"));
if (actionRequest.getFieldValue(i, "ystbbm") != null) 
this.setYstbbm(actionRequest.getFieldValue(i, "ystbbm"));
if (actionRequest.getFieldValue(i, "ystbren") != null) 
this.setYstbren(actionRequest.getFieldValue(i, "ystbren"));
if (actionRequest.getFieldValue(i, "ysshren") != null) 
this.setYsshren(actionRequest.getFieldValue(i, "ysshren"));
if (actionRequest.getFieldValue(i, "ystbdate") != null) 
this.setYstbdate(actionRequest.getFieldValue(i, "ystbdate"));
if (actionRequest.getFieldValue(i, "ysjiancejg") != null) 
this.setYsjiancejg(actionRequest.getFieldValue(i, "ysjiancejg"));
if (actionRequest.getFieldValue(i, "ysjiancedate") != null) 
this.setYsjiancedate(actionRequest.getFieldValue(i, "ysjiancedate"));
if (actionRequest.getFieldValue(i, "gltbbm") != null) 
this.setGltbbm(actionRequest.getFieldValue(i, "gltbbm"));
if (actionRequest.getFieldValue(i, "gltbren") != null) 
this.setGltbren(actionRequest.getFieldValue(i, "gltbren"));
if (actionRequest.getFieldValue(i, "gltbdate") != null) 
this.setGltbdate(actionRequest.getFieldValue(i, "gltbdate"));
if (actionRequest.getFieldValue(i, "glpeixunjg") != null) 
this.setGlpeixunjg(actionRequest.getFieldValue(i, "glpeixunjg"));
if (actionRequest.getFieldValue(i, "glpeixundate") != null) 
this.setGlpeixundate(actionRequest.getFieldValue(i, "glpeixundate"));
if (actionRequest.getFieldValue(i, "gltijianjg") != null) 
this.setGltijianjg(actionRequest.getFieldValue(i, "gltijianjg"));
if (actionRequest.getFieldValue(i, "gltijiandate") != null) 
this.setGltijiandate(actionRequest.getFieldValue(i, "gltijiandate"));
if (actionRequest.getFieldValue(i, "liuchengid") != null) 
this.setLiuchengid(actionRequest.getFieldValue(i, "liuchengid"));
if (actionRequest.getFieldValue(i, "tbliucheng") != null) 
this.setTbliucheng(actionRequest.getFieldValue(i, "tbliucheng"));
if (actionRequest.getFieldValue(i, "dq1") != null) 
this.setDq1(actionRequest.getFieldValue(i, "dq1"));
if (actionRequest.getFieldValue(i, "dq2") != null) 
this.setDq2(actionRequest.getFieldValue(i, "dq2"));
if (actionRequest.getFieldValue(i, "dq3") != null) 
this.setDq3(actionRequest.getFieldValue(i, "dq3"));
if (actionRequest.getFieldValue(i, "scyj1") != null) 
this.setScyj1(actionRequest.getFieldValue(i, "scyj1"));
if (actionRequest.getFieldValue(i, "scyj2") != null) 
this.setScyj2(actionRequest.getFieldValue(i, "scyj2"));
if (actionRequest.getFieldValue(i, "scyj3") != null) 
this.setScyj3(actionRequest.getFieldValue(i, "scyj3"));
if (actionRequest.getFieldValue(i, "scdate1") != null) 
this.setScdate1(actionRequest.getFieldValue(i, "scdate1"));
if (actionRequest.getFieldValue(i, "scdate2") != null) 
this.setScdate2(actionRequest.getFieldValue(i, "scdate2"));
if (actionRequest.getFieldValue(i, "scdate3") != null) 
this.setScdate3(actionRequest.getFieldValue(i, "scdate3"));
if (actionRequest.getFieldValue(i, "sbyes") != null) 
this.setSbyes(actionRequest.getFieldValue(i, "sbyes"));
if (actionRequest.getFieldValue(i, "beiandate") != null) 
this.setBeiandate(actionRequest.getFieldValue(i, "beiandate"));
if (actionRequest.getFieldValue(i, "beianhao") != null) 
this.setBeianhao(actionRequest.getFieldValue(i, "beianhao"));
if (actionRequest.getFieldValue(i, "scyj0") != null) 
this.setScyj0(actionRequest.getFieldValue(i, "scyj0"));
if (actionRequest.getFieldValue(i, "scdate0") != null) 
this.setScdate0(actionRequest.getFieldValue(i, "scdate0"));
if (actionRequest.getFieldValue(i, "dq4") != null) 
this.setDq4(actionRequest.getFieldValue(i, "dq4"));
if (actionRequest.getFieldValue(i, "scyj4") != null) 
this.setScyj4(actionRequest.getFieldValue(i, "scyj4"));
if (actionRequest.getFieldValue(i, "scdate4") != null) 
this.setScdate4(actionRequest.getFieldValue(i, "scdate4"));
if (actionRequest.getFieldValue(i, "jcfcren") != null) 
this.setJcfcren(actionRequest.getFieldValue(i, "jcfcren"));
if (actionRequest.getFieldValue(i, "jchxren") != null) 
this.setJchxren(actionRequest.getFieldValue(i, "jchxren"));
if (actionRequest.getFieldValue(i, "jcwlren") != null) 
this.setJcwlren(actionRequest.getFieldValue(i, "jcwlren"));
if (actionRequest.getFieldValue(i, "jcfsren") != null) 
this.setJcfsren(actionRequest.getFieldValue(i, "jcfsren"));
if (actionRequest.getFieldValue(i, "jcqtren") != null) 
this.setJcqtren(actionRequest.getFieldValue(i, "jcqtren"));
if (actionRequest.getFieldValue(i, "htngzzywhrs") != null) 
this.setHtngzzywhrs(actionRequest.getFieldValue(i, "htngzzywhrs"));
if (actionRequest.getFieldValue(i, "zybzygws") != null) 
this.setZybzygws(actionRequest.getFieldValue(i, "zybzygws"));
if (actionRequest.getFieldValue(i, "szjsbzgws") != null) 
this.setSzjsbzgws(actionRequest.getFieldValue(i, "szjsbzgws"));
if (actionRequest.getFieldValue(i, "yzywspxs") != null) 
this.setYzywspxs(actionRequest.getFieldValue(i, "yzywspxs"));
if (actionRequest.getFieldValue(i, "yzyjkjcs") != null) 
this.setYzyjkjcs(actionRequest.getFieldValue(i, "yzyjkjcs"));
if (actionRequest.getFieldValue(i, "zywhfj") != null) 
this.setZywhfj(actionRequest.getFieldValue(i, "zywhfj"));
if (actionRequest.getFieldValue(i, "jp") != null) 
this.setJp(actionRequest.getFieldValue(i, "jp"));
if (actionRequest.getFieldValue(i, "qp") != null) 
this.setQp(actionRequest.getFieldValue(i, "qp"));
if (actionRequest.getFieldValue(i, "wghdq1") != null) 
this.setWghdq1(actionRequest.getFieldValue(i, "wghdq1"));
if (actionRequest.getFieldValue(i, "wghdq2") != null) 
this.setWghdq2(actionRequest.getFieldValue(i, "wghdq2"));
if (actionRequest.getFieldValue(i, "wghdq3") != null) 
this.setWghdq3(actionRequest.getFieldValue(i, "wghdq3"));
if (actionRequest.getFieldValue(i, "wghdq4") != null) 
this.setWghdq4(actionRequest.getFieldValue(i, "wghdq4"));
if (actionRequest.getFieldValue(i, "wghdq5") != null) 
this.setWghdq5(actionRequest.getFieldValue(i, "wghdq5"));
if (actionRequest.getFieldValue(i, "bak1") != null) 
this.setBak1(actionRequest.getFieldValue(i, "bak1"));
if (actionRequest.getFieldValue(i, "bak2") != null) 
this.setBak2(actionRequest.getFieldValue(i, "bak2"));
if (actionRequest.getFieldValue(i, "bak3") != null) 
this.setBak3(actionRequest.getFieldValue(i, "bak3"));
if (actionRequest.getFieldValue(i, "bak4") != null) 
this.setBak4(actionRequest.getFieldValue(i, "bak4"));
if (actionRequest.getFieldValue(i, "bak5") != null) 
this.setBak5(actionRequest.getFieldValue(i, "bak5"));
if (actionRequest.getFieldValue(i, "distcode") != null) 
this.setDistcode(actionRequest.getFieldValue(i, "distcode"));
if (actionRequest.getFieldValue(i, "whys") != null) 
this.setWhys(actionRequest.getFieldValue(i, "whys"));
if (actionRequest.getFieldValue(i, "whysname") != null) 
this.setWhysname(actionRequest.getFieldValue(i, "whysname"));
if (actionRequest.getFieldValue(i, "zywsxkzz") != null) 
this.setZywsxkzz(actionRequest.getFieldValue(i, "zywsxkzz"));
if (actionRequest.getFieldValue(i, "zywsxkzf") != null) 
this.setZywsxkzf(actionRequest.getFieldValue(i, "zywsxkzf"));
if (actionRequest.getFieldValue(i, "otherzg") != null) 
this.setOtherzg(actionRequest.getFieldValue(i, "otherzg"));
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { QyjbqkBean obj = (QyjbqkBean)super.clone();obj.setEnterno(obj.enterno);
obj.setCorpkey(obj.corpkey);
obj.setDwmc(obj.dwmc);
obj.setZzjgdm(obj.zzjgdm);
obj.setGszch(obj.gszch);
obj.setZcdz(obj.zcdz);
obj.setFrdbsfzh(obj.frdbsfzh);
obj.setDdremail(obj.ddremail);
obj.setZczb(obj.zczb);
obj.setJcdate(obj.jcdate);
obj.setSfczzdwxy(obj.sfczzdwxy);
obj.setZcyzbm(obj.zcyzbm);
obj.setCsdz(obj.csdz);
obj.setCsyzbm(obj.csyzbm);
obj.setFddbr(obj.fddbr);
obj.setLxdh(obj.lxdh);
obj.setHyfl1(obj.hyfl1);
obj.setHyfl2(obj.hyfl2);
obj.setHyfl(obj.hyfl);
obj.setZclx(obj.zclx);
obj.setTblb(obj.tblb);
obj.setZywsjg(obj.zywsjg);
obj.setZywsfzr(obj.zywsfzr);
obj.setZywslxdh(obj.zywslxdh);
obj.setBgyy(obj.bgyy);
obj.setQtbgyy(obj.qtbgyy);
obj.setNmzgrs(obj.nmzgrs);
obj.setScwomen(obj.scwomen);
obj.setScnongmin(obj.scnongmin);
obj.setWhrenshu(obj.whrenshu);
obj.setWhwomen(obj.whwomen);
obj.setWhnongmin(obj.whnongmin);
obj.setTjrenshu(obj.tjrenshu);
obj.setZybrenshu(obj.zybrenshu);
obj.setDlrenshu(obj.dlrenshu);
obj.setTjrenshu2(obj.tjrenshu2);
obj.setTjrenshu3(obj.tjrenshu3);
obj.setZybrenshuxz(obj.zybrenshuxz);
obj.setZybrenshuys(obj.zybrenshuys);
obj.setPxrenshu(obj.pxrenshu);
obj.setSwrenshu(obj.swrenshu);
obj.setSwrenshuxz(obj.swrenshuxz);
obj.setZhuguan(obj.zhuguan);
obj.setZywsjgshu(obj.zywsjgshu);
obj.setZywsgl(obj.zywsgl);
obj.setChanzhi(obj.chanzhi);
obj.setZichan(obj.zichan);
obj.setSbren(obj.sbren);
obj.setSbrendh(obj.sbrendh);
obj.setYstbbm(obj.ystbbm);
obj.setYstbren(obj.ystbren);
obj.setYsshren(obj.ysshren);
obj.setYstbdate(obj.ystbdate);
obj.setYsjiancejg(obj.ysjiancejg);
obj.setYsjiancedate(obj.ysjiancedate);
obj.setGltbbm(obj.gltbbm);
obj.setGltbren(obj.gltbren);
obj.setGltbdate(obj.gltbdate);
obj.setGlpeixunjg(obj.glpeixunjg);
obj.setGlpeixundate(obj.glpeixundate);
obj.setGltijianjg(obj.gltijianjg);
obj.setGltijiandate(obj.gltijiandate);
obj.setLiuchengid(obj.liuchengid);
obj.setTbliucheng(obj.tbliucheng);
obj.setDq1(obj.dq1);
obj.setDq2(obj.dq2);
obj.setDq3(obj.dq3);
obj.setScyj1(obj.scyj1);
obj.setScyj2(obj.scyj2);
obj.setScyj3(obj.scyj3);
obj.setScdate1(obj.scdate1);
obj.setScdate2(obj.scdate2);
obj.setScdate3(obj.scdate3);
obj.setSbyes(obj.sbyes);
obj.setBeiandate(obj.beiandate);
obj.setBeianhao(obj.beianhao);
obj.setScyj0(obj.scyj0);
obj.setScdate0(obj.scdate0);
obj.setDq4(obj.dq4);
obj.setScyj4(obj.scyj4);
obj.setScdate4(obj.scdate4);
obj.setJcfcren(obj.jcfcren);
obj.setJchxren(obj.jchxren);
obj.setJcwlren(obj.jcwlren);
obj.setJcfsren(obj.jcfsren);
obj.setJcqtren(obj.jcqtren);
obj.setHtngzzywhrs(obj.htngzzywhrs);
obj.setZybzygws(obj.zybzygws);
obj.setSzjsbzgws(obj.szjsbzgws);
obj.setYzywspxs(obj.yzywspxs);
obj.setYzyjkjcs(obj.yzyjkjcs);
obj.setZywhfj(obj.zywhfj);
obj.setJp(obj.jp);
obj.setQp(obj.qp);
obj.setWghdq1(obj.wghdq1);
obj.setWghdq2(obj.wghdq2);
obj.setWghdq3(obj.wghdq3);
obj.setWghdq4(obj.wghdq4);
obj.setWghdq5(obj.wghdq5);
obj.setBak1(obj.bak1);
obj.setBak2(obj.bak2);
obj.setBak3(obj.bak3);
obj.setBak4(obj.bak4);
obj.setBak5(obj.bak5);
obj.setDistcode(obj.distcode);
obj.setWhys(obj.whys);
obj.setWhysname(obj.whysname);
obj.setZywsxkzz(obj.zywsxkzz);
obj.setZywsxkzf(obj.zywsxkzf);
obj.setOtherzg(obj.otherzg);
return obj;}}