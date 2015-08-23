package worksynch.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.sql.AbstractBasicBean;
import worksynch.db.DBConn;
import UI.util.BusinessDate;

public class ReadRecordUtil {
	/**
	 * 内网与网闸同步，读取synchrecord需要同步的记录，并进行相应的操作
	 *
	 */
	public void read(){
		
		ConnectionManager cmm=ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		DBConn db=new DBConn();
		//Connection conn=db.getConnection();
		String sql=" select * from synchrecord where czrq between '"+BusinessDate.getSubtrationDay(-2)+"' and '"+BusinessDate.getNowDay()+"' order by sysno desc";
		
		ResultSet rs=db.getResult(sql);
		try {
			while(rs.next()){
				int i=0;
				String sysno=rs.getString("sysno");
				String classname=rs.getString("classname");
				String tablename=rs.getString("tablename");
				String json=rs.getString("zxyj");
				String mainkey=rs.getString("mainkey");
				String czlx=rs.getString("czlx");
				String keyname=rs.getString("keyname");
				
				AbstractBasicBean obj=(AbstractBasicBean)GsonUtil.jsonToObject(json, classname);
				BeanUtil.putSqlMaker(obj);
				//System.out.println();
				if(czlx.equals("add")){
					i=obj.insert();
				}else if(czlx.equals("update")){
					i=obj.updateByWhere(" where "+keyname+"='"+mainkey+"'");
				}else if(czlx.equals("delete")){
					i=obj.deleteByWhere(" where "+keyname+" in ("+mainkey+")");
				}else {
					i=obj.updateByWhere(" where "+keyname+"='"+mainkey+"'");
				}
				 if(i>0){
					 db.executeSQL("delete from synchrecord where sysno='"+sysno+"'");
				 }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dcc.commit();
			cmm.release();
			db.closeConnection();
		}
	}
	
	public static void main(String[] args) {
		//System.out.println(BusinessDate.getSubtrationDay(-10));
		ReadRecordUtil re=new ReadRecordUtil();
		re.read();
	}

}
