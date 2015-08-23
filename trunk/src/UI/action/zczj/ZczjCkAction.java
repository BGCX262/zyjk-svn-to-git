package UI.action.zczj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.SerialNumber;
import st.platform.security.SystemAttributeNames;
import st.platform.utils.Config;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.zyjk.T_officerBean;
import UI.dao.zyjk.T_yhzc_bzbBean;
import UI.dao.zyjk.ZczjdfbBean;
import UI.dao.zyjk.ZczjqyxxzbBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
import UI.util.DistcodeUtil;
@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjkck") 
public class ZczjCkAction extends BasicAction{
	
	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(ZczjCkAction.class);
	
	private List<T_yhzc_bzbBean> list;//检查表的项目列表
	
	private T_yhzc_bzbBean bean;
	
	private String zbid;
	
	private Map<Object,Object> nrmap;//内容
	
	private Map<Object,Object> ffmap;//方法
	
	private Map<Object,Object> dfmap;//打分
	
	
	private ZczjqyxxzbBean zczjqyxxzbBean;
	
	private ZczjdfbBean zczjdfbBean;
	
	private List<ZczjdfbBean> beans;
	
	
	private String strSysno;
	
	private MessageBean messageBean;// 操作状态
	
	
	/**
	 * 取得自查自纠表的信息项，生成自查自纠表
	 * @return
	 */
	 @Action(value = "ZczjAction_getZczjList", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zczj/zywhzczjbc.jsp") }) 
	public String getZczjList(){
		if(null==bean){
			bean=new T_yhzc_bzbBean();
		}
		if(null==ffmap){
			ffmap=new HashMap<Object, Object>();
		}
		if(null==nrmap){
			nrmap=new HashMap<Object, Object>();
		}
		if(null==dfmap){
			dfmap=new HashMap<Object, Object>();
		}
		
		try {
			if(null==zczjqyxxzbBean){
				zczjqyxxzbBean=new ZczjqyxxzbBean();
			}
			zczjqyxxzbBean= ZczjqyxxzbBean.findFirst(" where sysno='"+strSysno+"'");
			if(null==zczjqyxxzbBean){
				zczjqyxxzbBean=new ZczjqyxxzbBean();
				zczjqyxxzbBean.setZbid(zbid);
				 T_officerBean officer=(T_officerBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.CORP_INFO_NAME);
				 if(null!=officer){
					 //Z_corBean cor=new Z_corBean();
					 QyjbqkBean qyjbqkbean=new QyjbqkBean();
					 qyjbqkbean=qyjbqkbean.findFirst(" where corpkey='"+officer.getLogin_id()+"'");
					 if(qyjbqkbean!=null){
						 //cor=new Z_corBean();
						 zczjqyxxzbBean.setDwmc(qyjbqkbean.getDwmc());
						 zczjqyxxzbBean.setLxr(qyjbqkbean.getYstbren());
						 zczjqyxxzbBean.setLxdh(qyjbqkbean.getSbrendh());
						 zczjqyxxzbBean.setDitcode(DistcodeUtil.getDistName(qyjbqkbean.getDistcode()));
						 zczjqyxxzbBean.setCorpkey(qyjbqkbean.getCorpkey());
					 }
				 }
			}
			
			list=bean.find(" where zbid='"+zbid+"' and level=1  order by sxh asc");//根据zbid查询所有的项目
			for(int i=0;i<list.size();i++){
				T_yhzc_bzbBean zb=list.get(i);
				T_yhzc_bzbBean bzb=new T_yhzc_bzbBean();
				List<T_yhzc_bzbBean> listnrs=bzb.find(" where parentid='"+zb.getId()+"' order by sxh asc");//查询项目下的主要内容
				for(int j=0;j<listnrs.size();j++){
					T_yhzc_bzbBean bz=listnrs.get(j);
					T_yhzc_bzbBean jczb=new T_yhzc_bzbBean();
					List<T_yhzc_bzbBean> listffs=jczb.find(" where parentid='"+bz.getId()+"' order by sxh asc");//查询内容对应的检查方法
					
					ffmap.put(bz, listffs);
					ZczjdfbBean df=new ZczjdfbBean();
					//List<ZczjdfbBean> dflist=df.find(" where ffsysno='"++"'");
					for(int b=0;b<listffs.size();b++){
						T_yhzc_bzbBean ffbz=listffs.get(b);
						df=df.findFirst(" where ffsysno='"+ffbz.getId()+"' and zbsysno='"+zczjqyxxzbBean.getSysno()+"'");
						if("".equals(df.getJdhc())||null==df.getJdhc()){
							df.setJdhc("1");
						}
						dfmap.put(ffbz, df);
					}
				}
				//Map map=new HashMap();
				nrmap.put(zb, listnrs);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MisConstant.FINDBYKEY;
	}
		 
		 /**
			*  
			*更新方法
			* @return 
			*/  
			 @Action(value = "ZczjAction_update") 
			public String update(){
				
				 //String number = BusinessDate.getNoFormatToday() + "-" + SerialNumber.getNextSerialNo("67");
				 //zczjqyxxzbBean.setSysno(number);
				 try {
					 messageBean =  update(zczjqyxxzbBean, " where Sysno ='" + zczjqyxxzbBean.getSysno() + "'");
					 
					 ZczjdfbBean zczjdfbBean = new ZczjdfbBean();
					messageBean =  delete(zczjdfbBean, " where zbsysno ='" + zczjqyxxzbBean.getSysno() + "' ");				
					 for(int i=0;i<beans.size();i++){
						ZczjdfbBean fb=beans.get(i);
						String sysno = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-" + SerialNumber.getNextSerialNo("67");
						fb.setSysno(sysno);
						fb.setZbsysno(zczjqyxxzbBean.getSysno());
						messageBean = insert(fb);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// TODO Auto-generated catch block
					 // 设置错误返回的提示
					 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
					 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
					e.printStackTrace();
				}
				 
				return MisConstant.RETMESSAGE;
			}
			 
			 /**
			  * 快捷自改
			  * @return
			  */
			 @Action(value = "ZczjAction_cancelx") 
				public String cancelx(){
					
					 //String number = BusinessDate.getNoFormatToday() + "-" + SerialNumber.getNextSerialNo("67");
					 //zczjqyxxzbBean.setSysno(number);
					 try {
						 //zczjdfbBean=zczjdfbBean.findFirst(" where Sysno = '" + zczjdfbBean.getSysno() + "'");
						 //zczjdfbBean.setZghc("1");
						 messageBean =  update(zczjdfbBean, " where Sysno ='" + zczjdfbBean.getSysno() + "'");
						 
					} catch (Exception e) {
						// TODO Auto-generated catch block
						// TODO Auto-generated catch block
						 // 设置错误返回的提示
						 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
						 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
						 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
						e.printStackTrace();
					}
					 
					return MisConstant.RETMESSAGE;
				}
			 
			 /**
				*  
				* 企业销销隐患
				* @return 
				*/  
				 @Action(value = "ZczjAction_cancel") 
			   public String delete() {
					 try {
						 zczjdfbBean=zczjdfbBean.findFirst(" where Sysno in (" + strSysno + ")");
						 zczjdfbBean.setZghc("1");
						 zczjdfbBean.setZgrq(BusinessDate.getNowDay());
						 messageBean =  update(zczjdfbBean, " where Sysno in (" + strSysno + ")");
						 
						 
					} catch (Exception e) {
						// TODO Auto-generated catch block
						// TODO Auto-generated catch block
						 // 设置错误返回的提示
						 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
						 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
						 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
						e.printStackTrace();
					}
					 
					return MisConstant.RETMESSAGE;
			  }
				 /**
				  * 快捷自改跳转
				  * @return
				  */
					@Action(value = "ZczjAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zczj/bhgdetail.jsp") })
					public String findByKey() {
						try {
							zczjdfbBean = new ZczjdfbBean();
							if (!(messageBean.getMethod().equals("add"))) {
								zczjdfbBean = (ZczjdfbBean) findByKey(zczjdfbBean,
										" where sysno ='" + strSysno + "'");
								if (zczjdfbBean != null) {
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

	public T_yhzc_bzbBean getBean() {
		return bean;
	}

	public void setBean(T_yhzc_bzbBean bean) {
		this.bean = bean;
	}

	public List<T_yhzc_bzbBean> getList() {
		return list;
	}

	public void setList(List<T_yhzc_bzbBean> list) {
		this.list = list;
	}

	public String getZbid() {
		return zbid;
	}

	public void setZbid(String zbid) {
		this.zbid = zbid;
	}

	public Map<Object, Object> getFfmap() {
		return ffmap;
	}

	public void setFfmap(Map<Object, Object> ffmap) {
		this.ffmap = ffmap;
	}

	public Map<Object, Object> getNrmap() {
		return nrmap;
	}

	public void setNrmap(Map<Object, Object> nrmap) {
		this.nrmap = nrmap;
	}

	public List<ZczjdfbBean> getBeans() {
		return beans;
	}

	public void setBeans(List<ZczjdfbBean> beans) {
		this.beans = beans;
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

	public ZczjqyxxzbBean getZczjqyxxzbBean() {
		return zczjqyxxzbBean;
	}

	public void setZczjqyxxzbBean(ZczjqyxxzbBean zczjqyxxzbBean) {
		this.zczjqyxxzbBean = zczjqyxxzbBean;
	}

	public Map<Object, Object> getDfmap() {
		return dfmap;
	}

	public void setDfmap(Map<Object, Object> dfmap) {
		this.dfmap = dfmap;
	}

	public ZczjdfbBean getZczjdfbBean() {
		return zczjdfbBean;
	}

	public void setZczjdfbBean(ZczjdfbBean zczjdfbBean) {
		this.zczjdfbBean = zczjdfbBean;
	}
	 
	 
}
