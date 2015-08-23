/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-02      孙雁斌         新規作成 ;
 ****************************************************/
package UI.action.zczj;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.SerialNumber;
import st.platform.utils.Config;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import UI.dao.zyjk.T_yhzc_bzbBean;
import UI.dao.zyjk.T_yhzc_bzzbBean;
import UI.dao.zyjk.ZczjsxbBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjkbzb") 
public class ZczjBzbAction extends BasicAction{
	
	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(ZczjBzbAction.class);
	
	
	private T_yhzc_bzzbBean bzzbBean;
	
	private T_yhzc_bzbBean bzbBean;	
	
	private String strSysno;
	
	private MessageBean messageBean;// 操作状态
	
	private String zbid="";
	
	private String parentid="";
	
	//private String allparentid="";
	
	private ZczjsxbBean sxBean;
	
	private String pdnr="";
	

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "BzbAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,bzbBean.*" }) })
	public String findObjson() {
		try {
			T_yhzc_bzbBean bzbBean = new T_yhzc_bzbBean();
			if (!(messageBean.getMethod().equals("add"))) {
				bzbBean = (T_yhzc_bzbBean) findByKey(bzbBean,
						" where  id='" + strSysno + "'");
				if (bzbBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.FINDOBJSON;
	}

	/**
	 * 
	 * 查询信息 返回jsp
	 * 
	 * @return
	 */
	@Action(value = "BzbAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zczj/zczjgl/info/bzbinfo.jsp") })
	public String findByKey() {
		try {
			bzbBean = new T_yhzc_bzbBean();
			bzbBean.setZbid(zbid);
			
			bzbBean.setParentid(parentid);
			String allparentid;
			T_yhzc_bzbBean zbBean=new T_yhzc_bzbBean();
			
			zbBean=zbBean.findFirst(" where id='"+ parentid +"'");

			if(null!=zbBean){
				allparentid=zbBean.getAllparentid();
								
				if(!allparentid.equals(parentid)){
					
				    allparentid=allparentid+"/"+parentid;
					
			    }
			}else{
				allparentid=parentid;
			}

			bzbBean.setAllparentid(allparentid);
			
			
			String[] num_array = allparentid.split("/");  
			int num=num_array.length;
			
			bzbBean.setLevel(Integer.toString(num));
			
			

			
			if (!(messageBean.getMethod().equals("add"))) {
				bzbBean = (T_yhzc_bzbBean) findByKey(bzbBean,
						" where  id='" + strSysno + "'");
				if (bzbBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.FINDBYKEY;
	}

	/**
	 * 
	 * 添加方法
	 * 
	 * @return
	 */
	@Action(value = "BzbAction_insert")
	public String insert() {
		try {
			String number = "T_YHZC_BZB"+Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			bzbBean.setId(number);
			bzbBean.setBz("1");

			if(null!=pdnr&&!"".equals(pdnr)){
				bzbBean.setBzmc(pdnr);	
			}
			
			messageBean = insert(bzbBean);
			
			T_yhzc_bzbBean tbzbBean=new T_yhzc_bzbBean();
			List<T_yhzc_bzbBean> bzblist=new ArrayList<T_yhzc_bzbBean>();
			
			
			if(!bzbBean.getParentid().equals(bzbBean.getAllparentid())){
				
				tbzbBean=tbzbBean.findFirst("where id='"+ bzbBean.getParentid() +"'");
				bzblist=bzbBean.find(" where parentid='"+ bzbBean.getParentid() +"'");
				int size=0;
				if(null!=bzblist){
					size=bzblist.size();
				}
				
				if(size>1){
					tbzbBean.setBz(Integer.parseInt(tbzbBean.getBz())+1+"");
					
					messageBean=update(tbzbBean, " where  id='"+ bzbBean.getParentid() + "'");
					
				}
				
			}
			
			//ZczjsxbBean sx=new ZczjsxbBean();
			
			String sxnumber = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
			+ SerialNumber.getNextSerialNo("67");

			sxBean=new ZczjsxbBean();
			sxBean.setSysno(sxnumber);
			if(bzbBean.getLevel().equals("1")){
				sxBean.setXmsysno(bzbBean.getId());
			}else if(bzbBean.getLevel().equals("2")){
				sxBean.setXmsysno(bzbBean.getParentid());
				sxBean.setRnsysno(bzbBean.getId());
			}else if(bzbBean.getLevel().equals("3")){
				sxBean.setRnsysno(bzbBean.getParentid());
				sxBean.setFfsysno(bzbBean.getId());
			}
			messageBean = insert(sxBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}

	/**
	 * 
	 * 修改方法
	 * 
	 * @return
	 */
	@Action(value = "BzbAction_update")
	public String update() {
		try {
			
			if(null!=pdnr&&!"".equals(pdnr)){
				bzbBean.setBzmc(pdnr);	
			}

			messageBean = update(bzbBean, " where  id='"+ bzbBean.getId() + "'");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}

	/**
	 * 
	 * 删除改方法
	 * 
	 * @return
	 */
	@Action(value = "BzbAction_delete")
	public String delete() {
		try {
			bzbBean = new T_yhzc_bzbBean();
			messageBean = delete(bzbBean, " where  id in (" + strSysno + ")");
			
			T_yhzc_bzbBean tbzbBean=new T_yhzc_bzbBean();
			List<T_yhzc_bzbBean> bzblist=new ArrayList<T_yhzc_bzbBean>();
			
			
			if(!bzbBean.getParentid().equals(bzbBean.getAllparentid())){
				
				tbzbBean=tbzbBean.findFirst("where id='"+ bzbBean.getParentid() +"'");
				bzblist=bzbBean.find(" where parentid='"+ bzbBean.getParentid() +"'");
				int size=0;
				if(null!=bzblist){
					size=bzblist.size();
				}
				
				if(size>1){
					tbzbBean.setBz(Integer.parseInt(tbzbBean.getBz())-1+"");
					
					messageBean=update(tbzbBean, " where  id='"+ bzbBean.getParentid() + "'");
					
				}
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}
    

	public T_yhzc_bzbBean getBzbBean() {
		return bzbBean;
	}

	public void setBzbBean(T_yhzc_bzbBean bzbBean) {
		this.bzbBean = bzbBean;
	}

	public T_yhzc_bzzbBean getBzzbBean() {
		return bzzbBean;
	}

	public void setBzzbBean(T_yhzc_bzzbBean bzzbBean) {
		this.bzzbBean = bzzbBean;
	}


	public MessageBean getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
	}

	public String getStrSysno() {
		return strSysno;
	}

	public void setStrSysno(String strSysno) {
		this.strSysno = strSysno;
	}

	public String getZbid() {
		return zbid;
	}

	public void setZbid(String zbid) {
		this.zbid = zbid;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public ZczjsxbBean getSxBean() {
		return sxBean;
	}

	public void setSxBean(ZczjsxbBean sxBean) {
		this.sxBean = sxBean;
	}

		public String getPdnr() {
		return pdnr;
	}

	public void setPdnr(String pdnr) {
		this.pdnr = pdnr;
	}

	/*public String getAllparentid() {
		return allparentid;
	}

	public void setAllparentid(String allparentid) {
		this.allparentid = allparentid;
	}
*/
	 
	 
}
