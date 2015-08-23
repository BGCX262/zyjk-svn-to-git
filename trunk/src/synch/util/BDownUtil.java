package synch.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import st.platform.utils.Config;
import synch.beans.Element;
import synch.beans.Error;
import synch.beans.Process;
import synch.beans.Record;
import synch.beans.Result;
import synch.dao.B_corBean;
import synch.dao.B_pxtjBean;
import synch.dao.B_scclBean;
import synch.dao.B_sccpBean;
import synch.dao.B_sczjBean;
import synch.dao.B_siteBean;
import synch.dao.B_whBean;

public class BDownUtil {
	/**
	 * 想webservice发送请求
	 * @param method
	 * @param params
	 * @param oos
	 * @return
	 */
	public static Result downBcor(String method,String[] params ,Object[] oos){
		String code=Config.getProperty("serviceDiscode");
		//String result=WebService.service( method,params,oos);
		String result=WebService.xfireService( method,params,oos);
		Result rs=null;
		try{
			//System.out.println("result:"+result);
			rs= (Result)XmlToObject.xmlToOb(result);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rs;
	}
	/**
	 * B_cor将Result中得记录存入数据库
	 * @param rs
	 * @return
	 */
	public static String resultHandle(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("B_cor", es);
			B_corBean zb=(B_corBean)oo;
			try {
				B_corBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and bakdate='"+zb.getBakdate()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and bakdate='"+zb.getBakdate()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
	/**
	 * 对于B_pxjg的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_B_pxtj(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("B_pxtj", es);
			B_pxtjBean zb=(B_pxtjBean)oo;
			try {
				B_pxtjBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and whDM='"+zb.getWhdm()+"' and ID='"+zb.getId()+"' and jcrenshu='"+zb.getJcrenshu()+"'" +
						" and pxrenshu="+zb.getPxrenshu()+" and tjrenshu="+zb.getTjrenshu()+" and zybrenshu="+zb.getZybrenshu()+" and jcnongmin="+zb.getJcnongmin()+
						" and jcwomen="+zb.getJcwomen()+" and dlrenshu="+zb.getDlrenshu()+" and tjrenshu2="+zb.getTjrenshu2()+" and tjrenshu3="+zb.getTjrenshu3()+"' and bakdate='"+zb.getBakdate()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and whDM='"+zb.getWhdm()+"' and ID='"+zb.getId()+"' and jcrenshu='"+zb.getJcrenshu()+"'" +
							" and pxrenshu="+zb.getPxrenshu()+" and tjrenshu="+zb.getTjrenshu()+" and zybrenshu="+zb.getZybrenshu()+" and jcnongmin="+zb.getJcnongmin()+
							" and jcwomen="+zb.getJcwomen()+" and dlrenshu="+zb.getDlrenshu()+" and tjrenshu2="+zb.getTjrenshu2()+" and tjrenshu3="+zb.getTjrenshu3()+"' and bakdate='"+zb.getBakdate()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}

	/**
	 * 对于B_sccp的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_B_sccp(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("B_sccp", es);
			B_sccpBean zb=(B_sccpBean)oo;
			try {
				B_sccpBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'"+"' and bakdate='"+zb.getBakdate()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'"+"' and bakdate='"+zb.getBakdate()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
	/**
	 * 对于B_sccl的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_B_sccl(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("B_sccl", es);
			B_scclBean zb=(B_scclBean)oo;
			try {
				B_scclBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'"+"' and bakdate='"+zb.getBakdate()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'"+"' and bakdate='"+zb.getBakdate()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
	
	/**
	 * 对于B_sczj的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_B_sczj(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("B_sczj", es);
			B_sczjBean zb=(B_sczjBean)oo;
			try {
				B_sczjBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'"+"' and bakdate='"+zb.getBakdate()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'"+"' and bakdate='"+zb.getBakdate()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
	
	/**
	 * 对于B_site的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_B_site(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("B_site", es);
			B_siteBean zb=(B_siteBean)oo;
			try {
				B_siteBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'"+"' and bakdate='"+zb.getBakdate()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'"+"' and bakdate='"+zb.getBakdate()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
	/**
	 * 对于B_wh的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_B_wh(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("B_wh", es);
			B_whBean zb=(B_whBean)oo;
			try {
				B_whBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and whDM='"+zb.getWhdm()+"' and ID='"+zb.getId()+"'"+"' and bakdate='"+zb.getBakdate()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and whDM='"+zb.getWhdm()+"' and ID='"+zb.getId()+"'"+"' and bakdate='"+zb.getBakdate()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
}
