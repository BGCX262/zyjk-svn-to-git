package synch.wgh.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import qd.db.DBConn;
import synch.wgh.bean.B_corBean;
import synch.wgh.bean.T_corBean;
import synch.wgh.bean.Z_corBean;

public class WghUtil {
	/**
	 * 读取已备案企业的网格信息
	 * @param cor
	 * @return
	 */
	public static Z_corBean synch_Z (Z_corBean cor ){
		String dq1="";
		String dq2="";
		String dq3="";
		DBConn db=new DBConn();
		ResultSet rs=null;
		try {
			if(null!=cor){
				String sql="select qushicode,jiedaocode,shequcode from wgh_jbqkb where dwmc like '"+cor.getDwmc()+"%'";
				
				rs=db.getResult(sql);
				while(rs.next()){
					dq1=rs.getString("qushicode");
					dq2=rs.getString("jiedaocode");
					dq3=rs.getString("shequcode");
				}
			}else{
				cor=new Z_corBean();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.closeConnection();
		}
		cor.setWghdq1(dq1);
		cor.setWghdq2(dq2);
		cor.setWghdq3(dq3);
		return cor;
	}
	/**
	 * 读取待审查企业的网格信息
	 * @param cor
	 * @return
	 */
	public static T_corBean synch_T (T_corBean cor ){
		String dq1="";
		String dq2="";
		String dq3="";
		DBConn db=new DBConn();
		ResultSet rs=null;
		try {
			if(null!=cor){
				String sql="select qushicode,jiedaocode,shequcode from wgh_jbqkb where dwmc like '"+cor.getDwmc()+"%'";
				
				rs=db.getResult(sql);
				while(rs.next()){
					dq1=rs.getString("qushicode");
					dq2=rs.getString("jiedaocode");
					dq3=rs.getString("shequcode");
				}
			}else{
				cor=new T_corBean();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.closeConnection();
		}
		cor.setWghdq1(dq1);
		cor.setWghdq2(dq2);
		cor.setWghdq3(dq3);
		return cor;
	}
	/**
	 * 读取备案历史企业的网格信息
	 * @param cor
	 * @return
	 */
	public static B_corBean synch_B (B_corBean cor ){
		String dq1="";
		String dq2="";
		String dq3="";
		DBConn db=new DBConn();
		ResultSet rs=null;
		try {
			if(null!=cor){
				String sql="select qushicode,jiedaocode,shequcode from wgh_jbqkb where dwmc like '"+cor.getDwmc()+"%'";
				
				rs=db.getResult(sql);
				while(rs.next()){
					dq1=rs.getString("qushicode");
					dq2=rs.getString("jiedaocode");
					dq3=rs.getString("shequcode");
				}
			}else{
				cor=new B_corBean();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.closeConnection();
		}
		cor.setWghdq1(dq1);
		cor.setWghdq2(dq2);
		cor.setWghdq3(dq3);
		return cor;
	}
}
