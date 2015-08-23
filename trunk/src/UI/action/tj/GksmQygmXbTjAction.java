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
public class GksmQygmXbTjAction extends ActionSupport{
	
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
	 @Action(value = "GksmQygmXbTjAction_getQygmTable", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/gksm/tj/qygmxbTj.jsp") }) 
	public String getQygmTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		PtoperBean oper = (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
		String dqcode="";
	    PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
        
	   String dis=dept.getDistcode();
		System.out.println("dqcode:"+distcode);
		//String discode =  st.platform.utils.Config.getProperty("discode");
		String sqlc=" and 1=1 ";
		//String xsql=" and 1=1";
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
		}
		
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			sqlc+=" and zczjqyxxzb.corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
		}
		
		
		
		ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		
		List<PtenudetailBean> rows=new ArrayList<PtenudetailBean>();
		PtenudetailBean pt=new PtenudetailBean();
		try {
			//System.out.println(xsql);
			rows=pt.find(" where enutype='QYGM' order by DISPNO");
			table=new DataTable(rows.size(),35);
			for(int i=0;i<rows.size();i++){
				PtenudetailBean pb=rows.get(i);
				table.addRow(pb.getEnuitemvalue(), pb.getEnuitemlabel(), i+1);
			}
			//table.addCol("AA", "小计",0);
			table.addCol("A", "职业病危害因素检测企业数", 1);
			table.addCol("B", "检测率", 2);
			table.addCol("C", "合计", 3);
			table.addCol("D", "小计", 4);
			table.addCol("E", "矽尘", 5);
			table.addCol("F", "石棉尘", 6);
			table.addCol("G", "小计", 7);
			table.addCol("H", "高度和极度、高度危害化学物质", 8);
			table.addCol("I", "小计", 9);
			table.addCol("J", "电离辐射", 10);
			table.addCol("K", "噪声", 11);
			table.addCol("L", "小计", 12);
			table.addCol("M", "炭疽杆菌", 13);
			
			table.addCol("N", "合计", 14);
			table.addCol("O", "小计", 15);
			table.addCol("P", "矽尘", 16);
			table.addCol("Q", "石棉尘", 17);
			table.addCol("R", "小计", 18);
			table.addCol("S", "高度和极度、高度危害化学物质", 19);
			table.addCol("T", "小计", 20);
			table.addCol("U", "电离辐射", 21);
			table.addCol("V", "噪声", 22);
			table.addCol("W", "小计", 23);
			table.addCol("X", "炭疽杆菌", 24);
			table.addCol("Y", "合计", 25);
			table.addCol("Z", "小计", 26);
			table.addCol("AB", "矽尘", 27);
			table.addCol("AC", "石棉尘", 28);
			table.addCol("AD", "小计", 29);
			table.addCol("AE", "高度和极度、高度危害化学物质", 30);
			table.addCol("AF", "小计", 31);
			table.addCol("AG", "电离辐射", 32);
			table.addCol("AH", "噪声", 33);
			table.addCol("AI", "小计", 34);
			table.addCol("AJ", "炭疽杆菌", 35);
			
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return  MisConstant.FINDBYKEY;
	}
	
	
}
