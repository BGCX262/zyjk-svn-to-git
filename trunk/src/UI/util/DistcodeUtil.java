package UI.util;

import java.sql.Connection;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.system.dao.OrganizationBean;
import st.system.dao.T_diquBean;

public class DistcodeUtil {
	/**
	 * 根据区划代码取得区划名称（根据12位编码）
	 * @param distcode
	 * @return
	 */
	public static String getDistName(String distcode){
		String name=distcode;
		ConnectionManager cm=ConnectionManager.getInstance();
		DatabaseConnection con=cm.getConnection();
		OrganizationBean or=new OrganizationBean();
		try {
			or=(OrganizationBean)or.findFirst(" where code='"+distcode+"'");
			if(null!=or){
				name=or.getName();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cm.release();
		}
		return name;
	}
	
	/**
	 * 根据区划代码取得区划名称（根据国家接口同步的区划代码）
	 * @param distcode
	 * @return
	 */
	public static String getDisName(String distcode){
		String name=distcode;
		ConnectionManager cm=ConnectionManager.getInstance();
		DatabaseConnection con=cm.getConnection();
		T_diquBean or=new T_diquBean();
		try {
			or=(T_diquBean)or.findFirst(" where dqbh='"+distcode+"'");
			if(null!=or){
				name=or.getDqmc();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cm.release();
		}
		return name;
	}

}
