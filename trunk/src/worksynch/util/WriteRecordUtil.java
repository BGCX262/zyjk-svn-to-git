package worksynch.util;

import java.sql.SQLException;

import UI.util.BusinessDate;
import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.SerialNumber;
import st.platform.utils.Config;
import worksynch.dao.SynchrecordBean;

public class WriteRecordUtil {
	/**
	 * 将操作的记录存入同步记录表
	 * @param obj  对象名称
	 * @param classname 类名及包名
	 * @param tablename  表名称
	 * @param keyname  主键名称
	 * @param mainkey  主键
	 * @param czlx 操作类型
	 * @return
	 */
	public static boolean write(Object obj,String classname,String tablename,String keyname,String mainkey,String czlx,ConnectionManager cmm){
		
		boolean state=false;
		int count=0;
		DatabaseConnection dcc = cmm.get();
		dcc.begin();
		SynchrecordBean synch=new SynchrecordBean();
		String json=GsonUtil.beanToJson(obj);
		String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
		+ SerialNumber.getNextSerialNo("200");
		//给记录赋值
		synch.setSysno(number);
		synch.setTablename(tablename);
		synch.setMainkey(mainkey);
		synch.setKeyname(keyname);
		synch.setCzlx(czlx);
		synch.setClassname(classname);
		synch.setZxyj(json);
		synch.setCzrq(BusinessDate.getNowDay());
		synch.setCzsj(BusinessDate.getNoFormatTime());
		synch.setTbrq1(BusinessDate.getNowDay());
		
		try {
			count=synch.insert();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(count>0){
				state=true;
				dcc.commit();
			}else{
				dcc.rollback();
			}
			//cmm.release();
		}
		return state;
	}

}
