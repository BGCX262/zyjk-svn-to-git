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
public class GksmQygmXaTjAction extends ActionSupport{
	
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
	 @Action(value = "GksmQygmXaTjAction_getQygmTable", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/gksm/tj/qygmxaTj.jsp") }) 
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
		
		
		
		ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		
		List<PtenudetailBean> rows=new ArrayList<PtenudetailBean>();
		PtenudetailBean pt=new PtenudetailBean();
		try {
			//System.out.println(xsql);
			rows=pt.find(" where enutype='QYGM' order by DISPNO");
			table=new DataTable(rows.size(),20);
			for(int i=0;i<rows.size();i++){
				PtenudetailBean pb=rows.get(i);
				table.addRow(pb.getEnuitemvalue(), pb.getEnuitemlabel(), i+1);
			}
			//table.addCol("AA", "小计",0);
			table.addCol("A", "合同告知职业病危害人数", 1);
			table.addCol("B", "职业病危害告知率", 2);
			table.addCol("C", "建立职业健康监护档案人数", 3);
			table.addCol("D", "职业健康监护档案建立率", 4);
			table.addCol("E", "职业病危害作业岗位数", 5);
			table.addCol("F", "设置警示标识岗位数", 6);
			table.addCol("G", "警示标识设置率", 7);
			table.addCol("H", "主要负责人已职业卫生培训企业数", 8);
			table.addCol("I", "主要负责人职业卫生培训率", 9);
			table.addCol("J", "应职业卫生培训人数", 10);
			table.addCol("K", "实际职业卫生培训人数", 11);
			table.addCol("L", "职业卫生培训率", 12);
			table.addCol("M", "配备专职职业卫生管理人员企业数", 13);
			
			table.addCol("N", "专职职业卫生管理人员配备率", 14);
			table.addCol("O", "配备兼职职业卫生管理人员企业数", 15);
			table.addCol("P", "兼职职业卫生管理人员配备率", 16);
			table.addCol("Q", "专职职业卫生管理人数", 17);
			table.addCol("R", "万名工人专职职业卫生管理人数", 18);
			table.addCol("S", "兼职职业卫生管理人数", 19);
			table.addCol("T", "万名工人兼职职业卫生管理人数", 20);
			
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return  MisConstant.FINDBYKEY;
	}
	
	
}
