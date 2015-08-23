package synch.wgh.dao;

import java.sql.SQLException;
import java.util.List;

import synch.wgh.bean.B_corBean;
import synch.wgh.bean.T_corBean;
import synch.wgh.bean.Z_corBean;
import synch.wgh.util.WghUtil;

public class WghsynchDAO {
	/**
	 * 同步已备案企业的网格信息
	 * @return
	 */
	public boolean synchZ_cor(){
		boolean state=false;
		Z_corBean cor=new Z_corBean();
		try {
			List<Z_corBean> zlist=cor.findByWhere(" where 1=1");
			for(int i=0;i<zlist.size();i++){
				Z_corBean zcor=zlist.get(i);
				zcor=WghUtil.synch_Z(zcor);
				zcor.updateByWhere(" where corpkey='"+zcor.getCorpkey()+"'");
			}
			state=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	/**
	 * 同步待审查企业的网格信息
	 * @return
	 */
	public boolean synchT_cor(){
		boolean state=false;
		T_corBean cor=new T_corBean();
		try {
			List<T_corBean> zlist=cor.findByWhere(" where 1=1");
			for(int i=0;i<zlist.size();i++){
				T_corBean zcor=zlist.get(i);
				zcor=WghUtil.synch_T(zcor);
				zcor.updateByWhere(" where corpkey='"+zcor.getCorpkey()+"'");
			}
			state=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	/**
	 * 同步备案历史企业的网格信息
	 * @return
	 */
	public boolean synchB_cor(){
		boolean state=false;
		B_corBean cor=new B_corBean();
		try {
			List<B_corBean> zlist=cor.findByWhere(" where 1=1");
			for(int i=0;i<zlist.size();i++){
				B_corBean zcor=zlist.get(i);
				zcor=WghUtil.synch_B(zcor);
				zcor.updateByWhere(" where corpkey='"+zcor.getCorpkey()+"'");
			}
			state=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public static void main(String[] args) {
		WghsynchDAO wgh=new WghsynchDAO();
		//da.download();
		wgh.synchB_cor();
		wgh.synchT_cor();
		wgh.synchZ_cor();
	}
}
