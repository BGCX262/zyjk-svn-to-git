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
@Namespace("/UI/action/zyjk") 
public class ZczjAction extends BasicAction{
	
	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(ZczjAction.class);
	
	private List<T_yhzc_bzbBean> list;//检查表的项目列表
	
	private T_yhzc_bzbBean bean;
	
	private String zbid;
	
	private Map<Object,Object> nrmap;//内容
	
	private Map<Object,Object> ffmap;//方法
	
	private Map<Object,Object> dfmap;//打分
	
	private Map<Object,Object> ckmap;// 检查
		
	private ZczjqyxxzbBean zczjqyxxzbBean;
	
	private List<ZczjdfbBean> beans;
	
	private List<ZczjdfbBean> beansc;
	
	private String strSysno;
	
	private MessageBean messageBean;// 操作状态
	
	private String sysno;//添加操作完成后，返回的主键
	
	
	/**
	 * 取得自查自纠表的信息项，生成自查自纠表
	 * @return
	 */
	 @Action(value = "ZczjAction_getZczjList", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zczj/zywhzczjbn.jsp") }) 
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
						 
						 zczjqyxxzbBean.setDwmc(qyjbqkbean.getDwmc());
						 zczjqyxxzbBean.setLxr(qyjbqkbean.getYstbren());
						 zczjqyxxzbBean.setLxdh(qyjbqkbean.getSbrendh());
						 zczjqyxxzbBean.setDitcode(qyjbqkbean.getDistcode());
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
						if(null==df){
							df=new ZczjdfbBean();
							df.setFs("1");
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
		 * 取得自查自纠表的信息项，生成自查自纠表
		 * @return
		 */
		 @Action(value = "ZczjAction_getTBZczjList", results = { 
				   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zczj/zywhzczjb.jsp") }) 
		public String getTBZczjList(){
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
				zczjqyxxzbBean= ZczjqyxxzbBean.findFirst(" where enterno='"+strSysno+"' and bak1='2' order by sysno desc");
				if(null==zczjqyxxzbBean){
					zczjqyxxzbBean=new ZczjqyxxzbBean();
					zczjqyxxzbBean.setZbid(zbid);
					 T_officerBean officer=(T_officerBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.CORP_INFO_NAME);
					 if(null!=officer){
						 //Z_corBean cor=new Z_corBean();
						 QyjbqkBean qyjbqkbean=new QyjbqkBean();
						 qyjbqkbean=qyjbqkbean.findFirst(" where corpkey='"+officer.getLogin_id()+"'");
						 if(qyjbqkbean!=null){
							 
							 zczjqyxxzbBean.setDwmc(qyjbqkbean.getDwmc());
							 zczjqyxxzbBean.setLxr(qyjbqkbean.getYstbren());
							 zczjqyxxzbBean.setLxdh(qyjbqkbean.getSbrendh());
							 zczjqyxxzbBean.setDitcode(qyjbqkbean.getDistcode());
							 zczjqyxxzbBean.setCorpkey(qyjbqkbean.getCorpkey());
							 zczjqyxxzbBean.setEnterno(qyjbqkbean.getEnterno());
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
							if(null==df){
								df=new ZczjdfbBean();
								df.setFs("1");
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
		*添加方法
		* @return 
		*/  
		 @Action(value = "ZczjAction_insert") 
		public String insert(){
			 String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-" + SerialNumber.getNextSerialNo("67");
			// T_officerBean officer=(T_officerBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.JCJG_INFO_NAME);
			 T_officerBean corp=(T_officerBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.CORP_INFO_NAME);

			 /*if(null!=officer){
				 zczjqyxxzbBean.setDitcode(officer.getDq_code());
				 
			 }*/
			 try {
			 if(null!=corp){
				 QyjbqkBean qyjbqkbean=new QyjbqkBean();
				 qyjbqkbean=qyjbqkbean.findFirst(" where corpkey='"+corp.getLogin_id()+"'");

				 if(qyjbqkbean!=null){

					 /*zczjqyxxzbBean.setDwmc(qyjbqkbean.getDwmc());
					 zczjqyxxzbBean.setLxr(qyjbqkbean.getFddbr());
					 zczjqyxxzbBean.setLxdh(qyjbqkbean.getLxdh());
					 zczjqyxxzbBean.setDitcode(qyjbqkbean.getDistcode());*/
					 zczjqyxxzbBean.setEnterno(qyjbqkbean.getEnterno());
					 zczjqyxxzbBean.setCorpkey(qyjbqkbean.getCorpkey());
				 }
				 
			 }
			    zczjqyxxzbBean.setSysno(number);
			    sysno=number;
			   // zczjqyxxzbBean.setBak1("1");
				messageBean = insert(zczjqyxxzbBean);
				
				 zczjqyxxzbBean.setBak1("0");
				 messageBean =  update(zczjqyxxzbBean, " where Sysno <>'" + zczjqyxxzbBean.getSysno() + "' and enterno='"+ zczjqyxxzbBean.getEnterno() +"'");
				
				for(int i=0;i<beans.size();i++){
					ZczjdfbBean fb=beans.get(i);
					String sysno = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-" + SerialNumber.getNextSerialNo("67");
					fb.setSysno(sysno);
					fb.setZbsysno(number);
					//fb.setFs(fb.getFs().substring(0, 1));
					messageBean = insert(fb);
				}
				 messageBean.setWidgetName(sysno);
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
					  messageBean =  delete(zczjdfbBean, " where zbsysno ='" + zczjqyxxzbBean.getSysno() + "'");
					 
					for(int i=0;i<beans.size();i++){
						ZczjdfbBean fb=beans.get(i);
						String sysno = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-" + SerialNumber.getNextSerialNo("67");
						fb.setSysno(sysno);
						//fb.setFs(fb.getFs().substring(0, 1));
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
				*  
				* 删除改方法
				* @return 
				*/  
				 @Action(value = "ZczjAction_delete") 
			   public String delete() {
				 try {
					 zczjqyxxzbBean = new ZczjqyxxzbBean();
				  messageBean =  delete(zczjqyxxzbBean, " where Sysno in (" + strSysno + ")");
				  ZczjdfbBean zczjdfbBean = new ZczjdfbBean();
				  messageBean =  delete(zczjdfbBean, " where zbsysno in (" + strSysno + ")");
				 
				 } catch (Exception e) {;
				 // TODO Auto-generated catch block
				 // 设置错误返回的提示
				 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
				 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
				 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				 }
				 return MisConstant.RETMESSAGE;
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

	public List<ZczjdfbBean> getBeansc() {
		return beansc;
	}

	public void setBeansc(List<ZczjdfbBean> beansc) {
		this.beansc = beansc;
	}

	public Map<Object, Object> getCkmap() {
		return ckmap;
	}

	public void setCkmap(Map<Object, Object> ckmap) {
		this.ckmap = ckmap;
	}

	public String getSysno() {
		return sysno;
	}

	public void setSysno(String sysno) {
		this.sysno = sysno;
	}
	 
	 
}
