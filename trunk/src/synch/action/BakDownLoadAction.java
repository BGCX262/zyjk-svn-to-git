package synch.action;

import st.platform.utils.Config;
import synch.beans.Process;
import synch.beans.Result;
import synch.util.BDownUtil;
import synch.util.DownUtil;
import synch.util.TDownUtil;
import synch.util.Util;

import UI.util.BusinessDate;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ��ݵ�����
 * @author jmx
 *
 */
public class BakDownLoadAction extends ActionSupport{
	
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * ������ʷ�����ݵ�����
	 * @return
	 */
	public String download(){
		String code=Config.getProperty("serviceDiscode");
		String userpwd=Config.getProperty("userpwd");
		String dd=Config.getProperty("timexxx");
		String start="";
		String end="";
		if(null==dd||dd.equals("")||dd.equals("null")){
			int ddi=Integer.parseInt(dd);
			start=BusinessDate.getNowDay();
			end=Util.getTime(ddi);
		}
		String[] params={"dqid","bakdts","bakdte","where","col","page","userpwd"};
		Object[] oos={code,start,end,"","","",userpwd};
		Result rs=BDownUtil.downBcor("B_cor", params, oos);
		String xml=BDownUtil.resultHandle(rs);//�����һ����ݣ������ش����xml��ʽ
		Process pro=rs.getProcess();
		String number=pro.getNumber();
		int num=0;
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		//System.out.println("������ݿ�ʼ����--------");
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] oo={code,start,end," "," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor", params, oo);
				xml=BDownUtil.resultHandle(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//System.out.println("������ݿ�ʼ������ؽ���--------");
		//��ʼ����Z_pxtj��������Ϣ
		String[] ofparams={"oftablename","dqid","bakdts","bakdte","where","colstr","page","userpwd"};
		Object[] ofoos={"B_pxtj",code,start,end,"","","",userpwd};
		Result ofrs=BDownUtil.downBcor("B_cor_of", ofparams, ofoos);
		xml=BDownUtil.resultHandle_of_B_pxtj(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"B_pxtj",code,start,end,"","",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", ofparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_pxtj(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//����Z_sccp
		String[] Z_sccpparams={"oftablename","dqid","bakdts","bakdte","where","colstr","page","userpwd"};
		String[] Z_sccpofoos={"B_sccp",code,start,end,"","","",userpwd};
		ofrs=BDownUtil.downBcor("B_cor_of", Z_sccpparams, Z_sccpofoos);
		xml=BDownUtil.resultHandle_of_B_sccp(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"B_sccp",code,start,end,""," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", Z_sccpparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_sccp(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//����B_sccl
		String[] Z_scclparams={"oftablename","dqid","bakdts","bakdte","where","colstr","page","userpwd"};
		String[] Z_scclofoos={"B_sccl",code,start,end,"","","",userpwd};
		ofrs=BDownUtil.downBcor("B_cor_of", Z_scclparams, Z_scclofoos);
		xml=BDownUtil.resultHandle_of_B_sccl(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"B_sccl",code,start,end,""," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", Z_scclparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_sccl(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//����Z_sczj
		String[] Z_sczjparams={"oftablename","dqid","bakdts","bakdte","where","colstr","page","userpwd"};
		String[] Z_sczjofoos={"B_sczj",code,start,end,"","","",userpwd};
		ofrs=BDownUtil.downBcor("B_cor_of", Z_sczjparams, Z_sczjofoos);
		xml=BDownUtil.resultHandle_of_B_sczj(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"B_sczj",code,start,end,""," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", Z_sczjparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_sczj(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//����Z_site
		String[] Z_siteparams={"oftablename","dqid","bakdts","bakdte","where","colstr","page","userpwd"};
		String[] Z_siteofoos={"B_site",code,start,end,"","","",userpwd};
		ofrs=BDownUtil.downBcor("B_cor_of", Z_siteparams, Z_siteofoos);
		xml=BDownUtil.resultHandle_of_B_site(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"B_site",code,start,end,""," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", Z_siteparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_site(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//����Z_wh
		String[] Z_whparams={"oftablename","dqid","bakdts","bakdte","where","colstr","page","userpwd"};
		String[] Z_whofoos={"B_wh",code,start,end,"","","",userpwd};
		ofrs=BDownUtil.downBcor("B_cor_of", Z_whparams, Z_whofoos);
		xml=BDownUtil.resultHandle_of_B_wh(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"B_wh",code,start,end,""," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", Z_whparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_wh(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		
		message="���سɹ���";
		
		return "01";
	}
	/**
	 * δ�ϱ�����ݵ�����
	 * @return
	 */
	public String wsbDownload(){
		String code=Config.getProperty("serviceDiscode");
		String userpwd=Config.getProperty("userpwd");
		String[] params={"dqid","st","et","col","page","userpwd"};
		Object[] oos={code," "," "," "," ",userpwd};
		//Z����δ�ϱ������
		Result rs=DownUtil.downZcor("Z_cor_wsb", params, oos);
		String xml=DownUtil.resultHandle(rs);//�����һ����ݣ������ش����xml��ʽ
		Process pro=rs.getProcess();
		String number=pro.getNumber();
		int num=0;
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			if(i>0){
				String[] oo={code," "," "," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_wsb", params, oo);
				xml=DownUtil.resultHandle(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//��ʼ����Z_pxtj��������Ϣ
		String[] ofparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		Object[] ofoos={"Z_pxtj",code," "," ","","",userpwd};
		Result ofrs=DownUtil.downZcor("Z_cor_wsb_of", ofparams, ofoos);
		xml=DownUtil.resultHandle_of_Z_pxtj(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_pxtj",code," "," "," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_wsb_of", ofparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_pxtj(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//����Z_sccp
		String[] Z_sccpparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		String[] Z_sccpofoos={"Z_sccp",code," "," ","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_wsb_of", Z_sccpparams, Z_sccpofoos);
		xml=DownUtil.resultHandle_of_Z_sccp(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_sccp",code," "," "," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_wsb_of", Z_sccpparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sccp(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//����Z_sccl
		String[] Z_scclparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		String[] Z_scclofoos={"Z_sccl",code," "," ","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_wsb_of", Z_scclparams, Z_scclofoos);
		xml=DownUtil.resultHandle_of_Z_sccl(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_sccl",code," "," "," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_wsb_of", Z_scclparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sccl(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//����Z_sczj
		String[] Z_sczjparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		String[] Z_sczjofoos={"Z_sczj",code," "," ","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_wsb_of", Z_sczjparams, Z_sczjofoos);
		xml=DownUtil.resultHandle_of_Z_sczj(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_sczj",code," "," "," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_wsb_of", Z_sczjparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sczj(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//����Z_site
		String[] Z_siteparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		String[] Z_siteofoos={"Z_site",code," "," ","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_wsb_of", Z_siteparams, Z_siteofoos);
		xml=DownUtil.resultHandle_of_Z_site(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_site",code," "," "," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_wsb_of", Z_siteparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_site(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//����Z_wh
		String[] Z_whparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		String[] Z_whofoos={"Z_wh",code," "," ","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_wsb_of", Z_whparams, Z_whofoos);
		xml=DownUtil.resultHandle_of_Z_wh(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_wh",code," "," "," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_wsb_of", Z_whparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_wh(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
//-----------------------------------------------------------------------------------------------------------------------
		//T����δ�ϱ������
		Result trs=TDownUtil.downTcor("T_cor_wsb", params, oos);
		xml=TDownUtil.resultHandle(trs);//�����һ����ݣ������ش����xml��ʽ
		pro=trs.getProcess();
		number=pro.getNumber();
		//int num=0;
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			if(i>0){
				String[] oo={code," "," "," ",i+"",userpwd};
				trs=TDownUtil.downTcor("T_cor_wsb", params, oo);
				xml=TDownUtil.resultHandle(trs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//��ʼ����T_pxtj��������Ϣ
		String[] Tofparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		Object[] Tofoos={"T_pxtj",code," "," ","","",userpwd};
		Result Tofrs=TDownUtil.downTcor("T_cor_wsb_of", Tofparams, Tofoos);
		xml=TDownUtil.resultHandle_of_T_pxtj(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"T_pxtj",code," "," "," ",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_wsb_of", Tofparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_pxtj(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//����T_sccp
		String[] T_sccpparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		String[] T_sccpofoos={"T_sccp",code," "," ","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_wsb_of", T_sccpparams, T_sccpofoos);
		xml=TDownUtil.resultHandle_of_T_sccp(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"T_sccp",code," "," "," ",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_wsb_of", T_sccpparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sccp(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//����T_sccl
		String[] T_scclparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		String[] T_scclofoos={"T_sccl",code," "," ","","",userpwd};
		Tofrs=DownUtil.downZcor("T_cor_wsb_of", T_scclparams, T_scclofoos);
		xml=TDownUtil.resultHandle_of_T_sccl(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"T_sccl",code," "," "," ",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_wsb_of", T_scclparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sccl(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//����T_sczj
		String[] T_sczjparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		String[] T_sczjofoos={"T_sczj",code," "," ","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_wsb_of", T_sczjparams, T_sczjofoos);
		xml=TDownUtil.resultHandle_of_T_sczj(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"T_sczj",code," "," "," ",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_wsb_of", T_sczjparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sczj(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//����T_site
		String[] T_siteparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		String[] T_siteofoos={"T_site",code," "," ","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_wsb_of", T_siteparams, T_siteofoos);
		xml=TDownUtil.resultHandle_of_T_site(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_site",code," "," "," ",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_wsb_of", T_siteparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_site(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//����T_wh
		String[] T_whparams={"oftablename","dqid","st","et","colstr","page","userpwd"};
		String[] T_whofoos={"Z_wh",code," "," ","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_wsb_of", T_whparams, T_whofoos);
		xml=TDownUtil.resultHandle_of_T_wh(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_wh",code," "," "," ",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_wsb_of", T_whparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_wh(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		message="���سɹ���";
		return "01";
	}
	/**
	 * ����������ݵ�����
	 * @return
	 */
	public String dscDownload(){
		String code=Config.getProperty("serviceDiscode");
		String userpwd=Config.getProperty("userpwd");
		String[] params={"dqid","st","et","col","liuchengID","page","userpwd"};
		Object[] oos={code," "," "," "," "," ",userpwd};
		//Z���д��������
		Result rs=DownUtil.downZcor("Z_cor_dscba", params, oos);
		String xml=DownUtil.resultHandle(rs);//�����һ����ݣ������ش����xml��ʽ
		Process pro=rs.getProcess();
		String number=pro.getNumber();
		int num=0;
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			if(i>0){
				String[] oo={code," "," "," ","",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_dscba", params, oo);
				xml=DownUtil.resultHandle(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//��ʼ����Z_pxtj��������Ϣ
		String[] ofparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		Object[] ofoos={"Z_pxtj",code," "," ","",""," ",userpwd};
		Result ofrs=DownUtil.downZcor("Z_cor_dscba_of", ofparams, ofoos);
		xml=DownUtil.resultHandle_of_Z_pxtj(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_pxtj",code," "," "," ","",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_dscba_of", ofparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_pxtj(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//����Z_sccp
		String[] Z_sccpparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		String[] Z_sccpofoos={"Z_sccp",code," "," ","","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_dscba_of", Z_sccpparams, Z_sccpofoos);
		xml=DownUtil.resultHandle_of_Z_sccp(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_sccp",code," "," "," ","",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_dscba_of", Z_sccpparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sccp(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//����Z_sccl
		String[] Z_scclparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		String[] Z_scclofoos={"Z_sccl",code," "," ","","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_dscba_of", Z_scclparams, Z_scclofoos);
		xml=DownUtil.resultHandle_of_Z_sccl(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_sccl",code," "," "," ","",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_dscba_of", Z_scclparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sccl(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//����Z_sczj
		String[] Z_sczjparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		String[] Z_sczjofoos={"Z_sczj",code," "," ","","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_dscba_of", Z_sczjparams, Z_sczjofoos);
		xml=DownUtil.resultHandle_of_Z_sczj(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_sczj",code," "," "," ","",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_dscba_of", Z_sczjparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sczj(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//����Z_site
		String[] Z_siteparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		String[] Z_siteofoos={"Z_site",code," "," ","","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_dscba_of", Z_siteparams, Z_siteofoos);
		xml=DownUtil.resultHandle_of_Z_site(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_site",code," "," "," "," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_dscba_of", Z_siteparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_site(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//����Z_wh
		String[] Z_whparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		String[] Z_whofoos={"Z_wh",code," "," ","","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_dscba_of", Z_whparams, Z_whofoos);
		xml=DownUtil.resultHandle_of_Z_wh(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_wh",code," "," "," ","",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_dscba_of", Z_whparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_wh(rs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
//-----------------------------------------------------------------------------------------------------------------------
		//T����δ�ϱ������
		Result trs=TDownUtil.downTcor("T_cor_dscba", params, oos);
		xml=TDownUtil.resultHandle(trs);//�����һ����ݣ������ش����xml��ʽ
		pro=trs.getProcess();
		number=pro.getNumber();
		//int num=0;
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			if(i>0){
				String[] oo={code," "," "," ","",i+"",userpwd};
				trs=TDownUtil.downTcor("T_cor_dscba", params, oo);
				xml=TDownUtil.resultHandle(trs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//��ʼ����T_pxtj��������Ϣ
		String[] Tofparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		Object[] Tofoos={"T_pxtj",code," "," ","","","",userpwd};
		Result Tofrs=TDownUtil.downTcor("T_cor_dscba_of", Tofparams, Tofoos);
		xml=TDownUtil.resultHandle_of_T_pxtj(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"T_pxtj",code," "," "," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dscba_of", Tofparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_pxtj(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//����T_sccp
		String[] T_sccpparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		String[] T_sccpofoos={"T_sccp",code," "," ","","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dscba_of", T_sccpparams, T_sccpofoos);
		xml=TDownUtil.resultHandle_of_T_sccp(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"T_sccp",code," "," "," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dscba_of", T_sccpparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sccp(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//����T_sccl
		String[] T_scclparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		String[] T_scclofoos={"T_sccl",code," "," ","","","",userpwd};
		Tofrs=DownUtil.downZcor("T_cor_dscba_of", T_scclparams, T_scclofoos);
		xml=TDownUtil.resultHandle_of_T_sccl(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"T_sccl",code," "," "," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dscba_of", T_scclparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sccl(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//����T_sczj
		String[] T_sczjparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		String[] T_sczjofoos={"T_sczj",code," "," ","","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dscba_of", T_sczjparams, T_sczjofoos);
		xml=TDownUtil.resultHandle_of_T_sczj(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"T_sczj",code," "," "," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dscba_of", T_sczjparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sczj(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//����T_site
		String[] T_siteparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		String[] T_siteofoos={"T_site",code," "," ","","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dscba_of", T_siteparams, T_siteofoos);
		xml=TDownUtil.resultHandle_of_T_site(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_site",code," "," "," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dscba_of", T_siteparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_site(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//����T_wh
		String[] T_whparams={"oftablename","dqid","st","et","colstr","liuchengID","page","userpwd"};
		String[] T_whofoos={"Z_wh",code," "," ","","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dscba_of", T_whparams, T_whofoos);
		xml=TDownUtil.resultHandle_of_T_wh(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("��ʼ�����"+i+"ҳ���");
			if(i>0){
				String[] ofoo={"Z_wh",code," "," "," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dscba_of", T_whparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_wh(Tofrs);//�����num����ݣ������ش����xml��ʽ
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		message="���سɹ���";
		return "01";
	}
	
	

}
