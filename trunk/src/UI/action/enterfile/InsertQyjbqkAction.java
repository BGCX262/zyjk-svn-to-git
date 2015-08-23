/****************************************************
 * <p>处理内容：从z_core表向qyjbqk表导数据</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  孙雁斌;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-06    孙雁斌           新規作成 ;
 ****************************************************/
package UI.action.enterfile;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.SerialNumber;
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.zyjk.Z_corBean;
import UI.util.BusinessDate;

public class InsertQyjbqkAction {
   
	
	public String insertData(String corpkey){
	   String message="fail";
	   ConnectionManager cm  = ConnectionManager.getInstance();
	   DatabaseConnection dc = cm.get();
	   Z_corBean z_corBean=new Z_corBean();
	   try {
		   
		   
		   z_corBean=z_corBean.findFirst(" where corpkey='"+ corpkey +"'");
		   String number = BusinessDate.getNoFormatToday() + "-"
			+ SerialNumber.getNextSerialNo("67");
		   String insertSql="INSERT INTO qyjbqk enterno,corpkey,dwmc,zzjgdm,gszch,zcdz,frdbsfzh,ddremail,zczb,jcdate,sfczzdwxy," +
		   		"zcyzbm,csdz,csyzbm,fddbr,lxdh,hyfl1,hyfl2,hyfl,zclx,tblb,zywsjg,zywsfzr,zywslxdh,bgyy,qtbgyy,nmzgrs,scwomen,scnongmin" +
		   		",whrenshu,whwomen,whnongmin,tjrenshu,zybrenshu,dlrenshu,tjrenshu2,tjrenshu3,zybrenshuxz,zybrenshuys,pxrenshu,swrenshu," +
		   		"swrenshuxz,zhuguan,zywsjgshu,zywsgl,chanzhi,zichan,sbren,sbrendh,ystbbm,ystbren,ysshren,ystbdate,ysjiancejg,ysjiancedate," +
		   		"gltbbm,gltbren,gltbdate,glpeixunjg,glpeixundate,gltijianjg,gltijiandate,liuchengID,tbliucheng,DQ1,DQ2,DQ3,scyj1,scyj2,scyj3," +
		   		"scdate1,scdate2,scdate3,sbyes,beiandate,beianhao,scyj0,scdate0,DQ4,scyj4,scdate4,jcfcren,jchxren,jcwlren,jcfsren,jcqtren," +
		   		"htngzzywhrs,zybzygws,szjsbzgws,yzywspxs,yzyjkjcs,zywhfj,jp,qp,wghdq1,wghdq2,wghdq3,wghdq4,wghdq5,bak1,bak2,bak3,bak4,bak5) " +
		   		"VALUES ("+number+","+ z_corBean.getCorpkey()+")";
		   dc.executeUpdate(insertSql);
		   
	   } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   
	   return message="success";
	}
}
