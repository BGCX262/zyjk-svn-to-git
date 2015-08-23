package UI.action.tj;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import st.platform.security.OperatorManager;
import st.platform.security.SystemAttributeNames;
import st.system.dao.OrganizationBean;
import st.system.dao.PtdeptBean;
import st.system.dao.PtenudetailBean;
import st.system.dao.PtoperBean;
import UI.message.MisConstant;
import UI.util.DataTable;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-filter")
@Namespace("/UI/action/gksmtj") 
public class GksmHylbXcTjAction extends ActionSupport{
	
	private DataTable table;
	
	private String distcode;
	
	private String hylb;
	
	private String qygm;
	
	private String zclx;
	
	private String whys;
	
	public String getWhys() {
		return whys;
	}


	public void setWhys(String whys) {
		this.whys = whys;
	}


	public String getDistcode() {
		return distcode;
	}


	public void setDistcode(String distcode) {
		this.distcode = distcode;
	}


	public String getHylb() {
		return hylb;
	}


	public void setHylb(String hylb) {
		this.hylb = hylb;
	}


	public String getQygm() {
		return qygm;
	}


	public void setQygm(String qygm) {
		this.qygm = qygm;
	}


	public String getZclx() {
		return zclx;
	}


	public void setZclx(String zclx) {
		this.zclx = zclx;
	}


	public DataTable getTable() {
		return table;
	}


	public void setTable(DataTable table) {
		this.table = table;
	}


	/**
	 * 按照行政区域进行统计
	 * @return
	 */
	 @Action(value = "GksmHylbXcTjAction_getHylbTable", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/gksm/tj/hylbxcTj.jsp") }) 
	public String getHylbTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		PtoperBean oper = (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
		String dqcode="";
	    PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
        
	   String dis=dept.getDistcode();
		System.out.println("dqcode:"+distcode);
		//String discode =  st.platform.utils.Config.getProperty("discode");
		String sqlc=" and 1=1 ";
		String xsql=" and 1=1";
		if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
			if(distcode.indexOf("00000000")>=0){
				dqcode=distcode.substring(0, 4);
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				dqcode=distcode.substring(0, 6);
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				dqcode=distcode.substring(0, 9);
			}
			sqlc+=" and distcode like '"+dqcode+"%'";
			//xsql+=" and enuitemvalue like '"+distcode+"%'";
		}else{
			if(dis.indexOf("00000000")>=0){
				distcode=dis.substring(0, 4);
			}else if(dis.indexOf("000000")>=0&&dis.indexOf("00000000")<0){
				distcode=dis.substring(0, 6);
			}else if(dis.indexOf("000000")<0&&dis.indexOf("00000000")<0&&dis.indexOf("000")>=0){
				distcode=dis.substring(0, 9);
			}
			sqlc+=" and distcode like '"+distcode+"%'";
			//xsql+=" and code like '"+distcode+"%'";
		}
		
		if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
			sqlc+=" and  hyfl like '"+hylb+"%'";
			if(hylb.length()==2){
				xsql+=" and len(enuitemvalue)<5 and enuitemvalue like '"+hylb+"%' ";
			}else{
				xsql+=" and enuitemvalue like '"+hylb+"%'";
			}
			
		}else{
			xsql+=" and len(enuitemvalue)<3 ";
		}
		
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			sqlc+=" and zczjqyxxzb.corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
		}
		
		
		
		ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		
		List<PtenudetailBean> rows=new ArrayList<PtenudetailBean>();
		PtenudetailBean pt=new PtenudetailBean();
		try {
			System.out.println(xsql);
			rows=pt.find(" where enutype='HYLB' "+xsql+" order by DISPNO");
			table=new DataTable(rows.size(),22);
			for(int i=0;i<rows.size();i++){
				PtenudetailBean pb=rows.get(i);
				table.addRow(pb.getEnuitemvalue(), pb.getEnuitemlabel(), i+1);
			}
			//table.addCol("AA", "小计",0);
			table.addCol("A", "合计", 1);
			table.addCol("B", "岗前", 2);
			table.addCol("C", "在岗", 3);
			table.addCol("D", "离岗", 4);
			table.addCol("E", "合计", 5);
			table.addCol("F", "岗前", 6);
			table.addCol("G", "在岗", 7);
			table.addCol("H", "离岗", 8);
			table.addCol("I", "合计", 9);
			table.addCol("J", "岗前", 10);
			table.addCol("K", "在岗", 11);
			table.addCol("L", "离岗", 12);
			
			table.addCol("M", "合计", 13);
			table.addCol("N", "尘肺", 14);
			table.addCol("O", "职业中毒", 15);
			table.addCol("P", "噪声聋", 16);
			table.addCol("Q", "职业性皮肤病", 17);
			table.addCol("R", "合计", 18);
			table.addCol("S", "尘肺", 19);
			table.addCol("T", "职业中毒", 20);
			table.addCol("T", "噪声聋", 21);
			table.addCol("T", "职业性皮肤病", 22);
			
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return  MisConstant.FINDBYKEY;
	}
	
	
}
