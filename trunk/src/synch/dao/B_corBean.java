package synch.dao;
import java.util.*;
import st.platform.db.*;
 import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;
public class B_corBean extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) throws Exception{           return new B_corBean().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere)throws Exception {           return new B_corBean().findAndLockByWhere(sSqlWhere);      }       public static B_corBean findFirst(String sSqlWhere)throws Exception {           return (B_corBean)new B_corBean().findFirstByWhere(sSqlWhere);      }       public static B_corBean findFirstAndLock(String sSqlWhere)throws Exception {           return (B_corBean)new B_corBean().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) throws Exception{           return new B_corBean().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_corBean bean = new B_corBean();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           B_corBean bean = new B_corBean();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static B_corBean findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_corBean bean = new B_corBean();           bean.setAutoRelease(isAutoRelease);           return (B_corBean)bean.findFirstByWhere(sSqlWhere);      }       public static B_corBean findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{           B_corBean bean = new B_corBean();           bean.setAutoRelease(isAutoRelease);           return (B_corBean)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception {           B_corBean bean = new B_corBean();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      } String  corpkey;
String  dwmc;
String  jcdate;
String  zcdz;
String  zcyzbm;
String  csdz;
String  csyzbm;
String  leader;
String  lxdh;
String  hyfl1;
String  hyfl2;
String  hyfl;
String  zclx;
String  tblb;
String  zywsjg;
String  zywsleader;
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
String  bakdate;
String  dq4;
String  scyj4;
String  scdate4;
String  jcfcren;
String  jchxren;
String  jcwlren;
String  jcfsren;
String  jcqtren;
public static final String TABLENAME ="b_cor";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
B_corBean abb = new B_corBean();
abb.corpkey=rs.getString("corpkey");
abb.setKeyValue("CORPKEY","" + abb.getCorpkey());
abb.dwmc=rs.getString("dwmc");
abb.setKeyValue("DWMC","" + abb.getDwmc());
abb.jcdate=rs.getString("jcdate");
abb.setKeyValue("JCDATE","" + abb.getJcdate());
abb.zcdz=rs.getString("zcdz");
abb.setKeyValue("ZCDZ","" + abb.getZcdz());
abb.zcyzbm=rs.getString("zcyzbm");
abb.setKeyValue("ZCYZBM","" + abb.getZcyzbm());
abb.csdz=rs.getString("csdz");
abb.setKeyValue("CSDZ","" + abb.getCsdz());
abb.csyzbm=rs.getString("csyzbm");
abb.setKeyValue("CSYZBM","" + abb.getCsyzbm());
abb.leader=rs.getString("leader");
abb.setKeyValue("LEADER","" + abb.getLeader());
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
abb.zywsleader=rs.getString("zywsleader");
abb.setKeyValue("ZYWSLEADER","" + abb.getZywsleader());
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
abb.bakdate=rs.getString("bakdate");
abb.setKeyValue("BAKDATE","" + abb.getBakdate());
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
list.add(abb);
abb.operate_mode = "edit";
}public String getCorpkey(){ if ( this.corpkey == null){ return ""; } else {return this.corpkey;}}public String getDwmc(){ if ( this.dwmc == null){ return ""; } else {return this.dwmc;}}public String getJcdate(){ if ( this.jcdate == null){ return ""; } else {return this.jcdate;}}public String getZcdz(){ if ( this.zcdz == null){ return ""; } else {return this.zcdz;}}public String getZcyzbm(){ if ( this.zcyzbm == null){ return ""; } else {return this.zcyzbm;}}public String getCsdz(){ if ( this.csdz == null){ return ""; } else {return this.csdz;}}public String getCsyzbm(){ if ( this.csyzbm == null){ return ""; } else {return this.csyzbm;}}public String getLeader(){ if ( this.leader == null){ return ""; } else {return this.leader;}}public String getLxdh(){ if ( this.lxdh == null){ return ""; } else {return this.lxdh;}}public String getHyfl1(){ if ( this.hyfl1 == null){ return ""; } else {return this.hyfl1;}}public String getHyfl2(){ if ( this.hyfl2 == null){ return ""; } else {return this.hyfl2;}}public String getHyfl(){ if ( this.hyfl == null){ return ""; } else {return this.hyfl;}}public String getZclx(){ if ( this.zclx == null){ return ""; } else {return this.zclx;}}public String getTblb(){ if ( this.tblb == null){ return ""; } else {return this.tblb;}}public String getZywsjg(){ if ( this.zywsjg == null){ return ""; } else {return this.zywsjg;}}public String getZywsleader(){ if ( this.zywsleader == null){ return ""; } else {return this.zywsleader;}}public String getZywslxdh(){ if ( this.zywslxdh == null){ return ""; } else {return this.zywslxdh;}}public String getBgyy(){ if ( this.bgyy == null){ return ""; } else {return this.bgyy;}}public String getQtbgyy(){ if ( this.qtbgyy == null){ return ""; } else {return this.qtbgyy;}}public String getNmzgrs(){ if ( this.nmzgrs == null){ return ""; } else {return this.nmzgrs;}}public String getScwomen(){ if ( this.scwomen == null){ return ""; } else {return this.scwomen;}}public String getScnongmin(){ if ( this.scnongmin == null){ return ""; } else {return this.scnongmin;}}public String getWhrenshu(){ if ( this.whrenshu == null){ return ""; } else {return this.whrenshu;}}public String getWhwomen(){ if ( this.whwomen == null){ return ""; } else {return this.whwomen;}}public String getWhnongmin(){ if ( this.whnongmin == null){ return ""; } else {return this.whnongmin;}}public String getTjrenshu(){ if ( this.tjrenshu == null){ return ""; } else {return this.tjrenshu;}}public String getZybrenshu(){ if ( this.zybrenshu == null){ return ""; } else {return this.zybrenshu;}}public String getDlrenshu(){ if ( this.dlrenshu == null){ return ""; } else {return this.dlrenshu;}}public String getTjrenshu2(){ if ( this.tjrenshu2 == null){ return ""; } else {return this.tjrenshu2;}}public String getTjrenshu3(){ if ( this.tjrenshu3 == null){ return ""; } else {return this.tjrenshu3;}}public String getZybrenshuxz(){ if ( this.zybrenshuxz == null){ return ""; } else {return this.zybrenshuxz;}}public String getZybrenshuys(){ if ( this.zybrenshuys == null){ return ""; } else {return this.zybrenshuys;}}public String getPxrenshu(){ if ( this.pxrenshu == null){ return ""; } else {return this.pxrenshu;}}public String getSwrenshu(){ if ( this.swrenshu == null){ return ""; } else {return this.swrenshu;}}public String getSwrenshuxz(){ if ( this.swrenshuxz == null){ return ""; } else {return this.swrenshuxz;}}public String getZhuguan(){ if ( this.zhuguan == null){ return ""; } else {return this.zhuguan;}}public String getZywsjgshu(){ if ( this.zywsjgshu == null){ return ""; } else {return this.zywsjgshu;}}public String getZywsgl(){ if ( this.zywsgl == null){ return ""; } else {return this.zywsgl;}}public String getChanzhi(){ if ( this.chanzhi == null){ return ""; } else {return this.chanzhi;}}public String getZichan(){ if ( this.zichan == null){ return ""; } else {return this.zichan;}}public String getSbren(){ if ( this.sbren == null){ return ""; } else {return this.sbren;}}public String getSbrendh(){ if ( this.sbrendh == null){ return ""; } else {return this.sbrendh;}}public String getYstbbm(){ if ( this.ystbbm == null){ return ""; } else {return this.ystbbm;}}public String getYstbren(){ if ( this.ystbren == null){ return ""; } else {return this.ystbren;}}public String getYsshren(){ if ( this.ysshren == null){ return ""; } else {return this.ysshren;}}public String getYstbdate(){ if ( this.ystbdate == null){ return ""; } else {return this.ystbdate;}}public String getYsjiancejg(){ if ( this.ysjiancejg == null){ return ""; } else {return this.ysjiancejg;}}public String getYsjiancedate(){ if ( this.ysjiancedate == null){ return ""; } else {return this.ysjiancedate;}}public String getGltbbm(){ if ( this.gltbbm == null){ return ""; } else {return this.gltbbm;}}public String getGltbren(){ if ( this.gltbren == null){ return ""; } else {return this.gltbren;}}public String getGltbdate(){ if ( this.gltbdate == null){ return ""; } else {return this.gltbdate;}}public String getGlpeixunjg(){ if ( this.glpeixunjg == null){ return ""; } else {return this.glpeixunjg;}}public String getGlpeixundate(){ if ( this.glpeixundate == null){ return ""; } else {return this.glpeixundate;}}public String getGltijianjg(){ if ( this.gltijianjg == null){ return ""; } else {return this.gltijianjg;}}public String getGltijiandate(){ if ( this.gltijiandate == null){ return ""; } else {return this.gltijiandate;}}public String getLiuchengid(){ if ( this.liuchengid == null){ return ""; } else {return this.liuchengid;}}public String getTbliucheng(){ if ( this.tbliucheng == null){ return ""; } else {return this.tbliucheng;}}public String getDq1(){ if ( this.dq1 == null){ return ""; } else {return this.dq1;}}public String getDq2(){ if ( this.dq2 == null){ return ""; } else {return this.dq2;}}public String getDq3(){ if ( this.dq3 == null){ return ""; } else {return this.dq3;}}public String getScyj1(){ if ( this.scyj1 == null){ return ""; } else {return this.scyj1;}}public String getScyj2(){ if ( this.scyj2 == null){ return ""; } else {return this.scyj2;}}public String getScyj3(){ if ( this.scyj3 == null){ return ""; } else {return this.scyj3;}}public String getScdate1(){ if ( this.scdate1 == null){ return ""; } else {return this.scdate1;}}public String getScdate2(){ if ( this.scdate2 == null){ return ""; } else {return this.scdate2;}}public String getScdate3(){ if ( this.scdate3 == null){ return ""; } else {return this.scdate3;}}public String getSbyes(){ if ( this.sbyes == null){ return ""; } else {return this.sbyes;}}public String getBeiandate(){ if ( this.beiandate == null){ return ""; } else {return this.beiandate;}}public String getBeianhao(){ if ( this.beianhao == null){ return ""; } else {return this.beianhao;}}public String getScyj0(){ if ( this.scyj0 == null){ return ""; } else {return this.scyj0;}}public String getScdate0(){ if ( this.scdate0 == null){ return ""; } else {return this.scdate0;}}public String getBakdate(){ if ( this.bakdate == null){ return ""; } else {return this.bakdate;}}public String getDq4(){ if ( this.dq4 == null){ return ""; } else {return this.dq4;}}public String getScyj4(){ if ( this.scyj4 == null){ return ""; } else {return this.scyj4;}}public String getScdate4(){ if ( this.scdate4 == null){ return ""; } else {return this.scdate4;}}public String getJcfcren(){ if ( this.jcfcren == null){ return ""; } else {return this.jcfcren;}}public String getJchxren(){ if ( this.jchxren == null){ return ""; } else {return this.jchxren;}}public String getJcwlren(){ if ( this.jcwlren == null){ return ""; } else {return this.jcwlren;}}public String getJcfsren(){ if ( this.jcfsren == null){ return ""; } else {return this.jcfsren;}}public String getJcqtren(){ if ( this.jcqtren == null){ return ""; } else {return this.jcqtren;}}public void setCorpkey( String corpkey){sqlMaker.setField("corpkey",corpkey,Field.TEXT);
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
public void setJcdate( String jcdate){sqlMaker.setField("jcdate",jcdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getJcdate().equals(jcdate))
cf.add("jcdate",this.jcdate,jcdate);
}
this.jcdate=jcdate;
}
public void setZcdz( String zcdz){sqlMaker.setField("zcdz",zcdz,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZcdz().equals(zcdz))
cf.add("zcdz",this.zcdz,zcdz);
}
this.zcdz=zcdz;
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
public void setLeader( String leader){sqlMaker.setField("leader",leader,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getLeader().equals(leader))
cf.add("leader",this.leader,leader);
}
this.leader=leader;
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
public void setZywsleader( String zywsleader){sqlMaker.setField("zywsleader",zywsleader,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getZywsleader().equals(zywsleader))
cf.add("zywsleader",this.zywsleader,zywsleader);
}
this.zywsleader=zywsleader;
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
public void setBakdate( String bakdate){sqlMaker.setField("bakdate",bakdate,Field.TEXT);
if (this.operate_mode.equals("edit")) {
if (!this.getBakdate().equals(bakdate))
cf.add("bakdate",this.bakdate,bakdate);
}
this.bakdate=bakdate;
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
public void init(int i,ActionRequest actionRequest) throws Exception { if (actionRequest.getFieldValue(i, "corpkey") != null) 
this.setCorpkey(actionRequest.getFieldValue(i, "corpkey"));
if (actionRequest.getFieldValue(i, "dwmc") != null) 
this.setDwmc(actionRequest.getFieldValue(i, "dwmc"));
if (actionRequest.getFieldValue(i, "jcdate") != null) 
this.setJcdate(actionRequest.getFieldValue(i, "jcdate"));
if (actionRequest.getFieldValue(i, "zcdz") != null) 
this.setZcdz(actionRequest.getFieldValue(i, "zcdz"));
if (actionRequest.getFieldValue(i, "zcyzbm") != null) 
this.setZcyzbm(actionRequest.getFieldValue(i, "zcyzbm"));
if (actionRequest.getFieldValue(i, "csdz") != null) 
this.setCsdz(actionRequest.getFieldValue(i, "csdz"));
if (actionRequest.getFieldValue(i, "csyzbm") != null) 
this.setCsyzbm(actionRequest.getFieldValue(i, "csyzbm"));
if (actionRequest.getFieldValue(i, "leader") != null) 
this.setLeader(actionRequest.getFieldValue(i, "leader"));
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
if (actionRequest.getFieldValue(i, "zywsleader") != null) 
this.setZywsleader(actionRequest.getFieldValue(i, "zywsleader"));
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
if (actionRequest.getFieldValue(i, "bakdate") != null) 
this.setBakdate(actionRequest.getFieldValue(i, "bakdate"));
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
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { B_corBean obj = (B_corBean)super.clone();obj.setCorpkey(obj.corpkey);
obj.setDwmc(obj.dwmc);
obj.setJcdate(obj.jcdate);
obj.setZcdz(obj.zcdz);
obj.setZcyzbm(obj.zcyzbm);
obj.setCsdz(obj.csdz);
obj.setCsyzbm(obj.csyzbm);
obj.setLeader(obj.leader);
obj.setLxdh(obj.lxdh);
obj.setHyfl1(obj.hyfl1);
obj.setHyfl2(obj.hyfl2);
obj.setHyfl(obj.hyfl);
obj.setZclx(obj.zclx);
obj.setTblb(obj.tblb);
obj.setZywsjg(obj.zywsjg);
obj.setZywsleader(obj.zywsleader);
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
obj.setBakdate(obj.bakdate);
obj.setDq4(obj.dq4);
obj.setScyj4(obj.scyj4);
obj.setScdate4(obj.scdate4);
obj.setJcfcren(obj.jcfcren);
obj.setJchxren(obj.jchxren);
obj.setJcwlren(obj.jcwlren);
obj.setJcfsren(obj.jcfsren);
obj.setJcqtren(obj.jcqtren);
return obj;}}