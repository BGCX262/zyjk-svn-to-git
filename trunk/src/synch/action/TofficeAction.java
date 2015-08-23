package synch.action;

import java.util.List;

import UI.dao.zyjk.T_officerBean;
import UI.dao.zyjk.Z_corBean;

public class TofficeAction {

	public static boolean checkOffice(){

		boolean state=false;
		try {
			List<Z_corBean> colist=Z_corBean.find(" where 1=1");
			
			for(int i=0;i<colist.size();i++){
				Z_corBean cor=colist.get(i);
				T_officerBean off=new T_officerBean();
				off=off.findFirst(" where login_id='"+cor.getCorpkey()+"'");
				if(null==off){
					off=new T_officerBean();
					off.setLogin_id(cor.getCorpkey());
					off.setC_pwd("000000");
					off.setDq_code(cor.getDq3());
					off.setDq1(cor.getDq1());
					off.setDq2(cor.getDq2());
					off.setDq3(cor.getDq3());
					off.setDq4(cor.getDq4());
					off.setWghcode1(cor.getWghdq1());
					off.setWghcode2(cor.getWghdq2());
					off.setWghcode3(cor.getWghdq3());
					off.setWghcode4(cor.getWghdq4());
					off.setWghcode5(cor.getWghdq5());
					off.setOfficer_name(cor.getDwmc());
					off.setDept_type("1");
					off.insert();
				}else {
					off.setLogin_id(cor.getCorpkey());
					off.setDq_code(cor.getDq3());
					off.setDq1(cor.getDq1());
					off.setDq2(cor.getDq2());
					off.setDq3(cor.getDq3());
					off.setDq4(cor.getDq4());
					off.setWghcode1(cor.getWghdq1());
					off.setWghcode2(cor.getWghdq2());
					off.setWghcode3(cor.getWghdq3());
					off.setWghcode4(cor.getWghdq4());
					off.setWghcode5(cor.getWghdq5());
					off.setOfficer_name(cor.getDwmc());
					off.setDept_type("1");
					off.updateByWhere(" where Login_id='"+cor.getCorpkey()+"'");
				}
				
			}
			state=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return state;
	}
}
