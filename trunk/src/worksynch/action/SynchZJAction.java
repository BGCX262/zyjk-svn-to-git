package worksynch.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import UI.util.BusinessDate;
import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import worksynch.db.DBConn;

public class SynchZJAction {
	/**
	 * 将外网的记录表读取到中间库中
	 *
	 */
	public void synch(){
		
		ConnectionManager cmm=ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		DBConn db=new DBConn();
		Connection conn=db.getConnection();
		String sql=" select * from synchrecord where czrq between '"+BusinessDate.getSubtrationDay(-2)+"' and '"+BusinessDate.getNowDay()+"'";
		String zjsql="insert into synchrecord (sysno,tablename,keyname,mainkey,classname,czrq,czsj,czlx,zxyj,status1,desc1,tbrq1,tbsj1,exp1,status2," +
				"desc2,tbrq2,tbsj2,exp2,status3,desc3,tbrq3,tbsj3,exp3,status4,desc4,tbrq4,tbsj4,exp4,bak1,bak2,bak3,bak4,bak5) values (?,?,?,?,?,?,?,?,?,?,?," +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst=conn.prepareStatement(zjsql);
			RecordSet rs=dcc.executeQuery(sql);
			while(rs.next()){
				pst.setString(1,rs.getString("sysno"));
				pst.setString(2,rs.getString("tablename"));
				pst.setString(3,rs.getString("keyname"));
				pst.setString(4,rs.getString("mainkey"));
				pst.setString(5,rs.getString("classname"));
				pst.setString(6,rs.getString("czrq"));
				pst.setString(7,rs.getString("czsj"));
				pst.setString(8,rs.getString("czlx"));
				pst.setString(9,rs.getString("zxyj"));
				pst.setString(10,rs.getString("status1"));
				pst.setString(11,rs.getString("desc1"));
				pst.setString(12,rs.getString("tbrq1"));
				pst.setString(13,rs.getString("tbsj1"));
				pst.setString(14,rs.getString("exp1"));
				pst.setString(15,rs.getString("status2"));
				pst.setString(16,rs.getString("desc2"));
				pst.setString(17,rs.getString("tbrq2"));
				pst.setString(18,rs.getString("tbsj2"));
				pst.setString(19,rs.getString("exp2"));
				pst.setString(20,rs.getString("status3"));
				pst.setString(21,rs.getString("desc3"));
				pst.setString(22,rs.getString("tbrq3"));
				pst.setString(23,rs.getString("tbsj3"));
				pst.setString(24,rs.getString("exp3"));
				pst.setString(25,rs.getString("status4"));
				pst.setString(26,rs.getString("desc4"));
				pst.setString(27,rs.getString("tbrq4"));
				pst.setString(28,rs.getString("tbsj4"));
				pst.setString(29,rs.getString("exp4"));
				pst.setString(30,rs.getString("bak1"));
				pst.setString(31,rs.getString("bak2"));
				pst.setString(32,rs.getString("bak3"));
				pst.setString(33,rs.getString("bak4"));
				pst.setString(34,rs.getString("bak5"));
				int num=pst.executeUpdate();
				
				if(num==1){
					dcc.executeUpdate(" delete from synchrecord where sysno='"+rs.getString("sysno")+"'");
					System.out.println(" delete from synchrecord where sysno='"+rs.getString("sysno")+"'");
				}
				pst.clearParameters();
				//pst.clearBatch();
				
			}
			rs.close();
			pst.close();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
			db.closeConnection();
		}
	}
	
	public static void main(String[] args) {
		SynchZJAction sj=new SynchZJAction();
		sj.synch();
	}

}
