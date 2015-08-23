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
 * 数据的下载
 * @author jmx
 *
 */
public class DownLoadAction extends ActionSupport{
	
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 备案历史数据数据的下载
	 * @return
	 */
	public String download(){
		String code=Config.getProperty("serviceDiscode");
		String userpwd=Config.getProperty("userpwd");
		String dd=Config.getProperty("timexxx");
		String start="";
		String end="";
		if(null==dd&&dd.equals("")&&dd.equals("null")){
			int ddi=Integer.parseInt(dd);
			start=BusinessDate.getNowDay();
			end=Util.getTime(ddi);
		}
		String[] params={"dqid","bakdts","bakdte","where","col","page","userpwd"};
		Object[] oos={code,start,end,"","","",userpwd};
		Result rs=BDownUtil.downBcor("B_cor", params, oos);
		String xml=BDownUtil.resultHandle(rs);//处理第一批数据，并返回错误的xml格式
		Process pro=rs.getProcess();
		String number=pro.getNumber();
		int num=0;
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		//System.out.println("备案数据开始下载--------");
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] oo={code,start,end," "," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor", params, oo);
				xml=BDownUtil.resultHandle(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//System.out.println("备案数据开始主表下载结束--------");
		//开始下载Z_pxtj附属表的信息
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
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"B_pxtj",code,start,end,"","",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", ofparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_pxtj(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//下载Z_sccp
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
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"B_sccp",code,start,end,""," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", Z_sccpparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_sccp(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//下载B_sccl
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
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"B_sccl",code,start,end,""," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", Z_scclparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_sccl(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//下载Z_sczj
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
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"B_sczj",code,start,end,""," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", Z_sczjparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_sczj(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//下载Z_site
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
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"B_site",code,start,end,""," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", Z_siteparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_site(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		//下载Z_wh
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
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"B_wh",code,start,end,""," ",i+"",userpwd};
				rs=BDownUtil.downBcor("B_cor_of", Z_whparams, ofoo);
				xml=BDownUtil.resultHandle_of_B_wh(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
			}
		}
		
		message="下载成功！";
		
		return "01";
	}
	
	/**
	 * 已备案数据数据的下载
	 * @return
	 */
	public String baDownload(){
		String code=Config.getProperty("serviceDiscode");
		String userpwd=Config.getProperty("userpwd");
		String dd=Config.getProperty("timexxx");
		String start="";
		String end="";
		if(null==dd&&dd.equals("")&&dd.equals("null")){
			int ddi=Integer.parseInt(dd);
			start=BusinessDate.getNowDay();
			end=Util.getTime(ddi);
		}
		String[] params={"dqid","beiandts","beiandte","where","col","page","userpwd"};
		Object[] oos={code,start,end,"","","",userpwd};
		Result rs=DownUtil.downZcor("Z_cor", params, oos);
		String xml=DownUtil.resultHandle(rs);//处理第一批数据，并返回错误的xml格式
		Process pro=rs.getProcess();
		String number=pro.getNumber();
		int num=0;
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		//System.out.println("备案数据开始下载--------");
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] oo={code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor", params, oo);
				xml=DownUtil.resultHandle(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//System.out.println("备案数据开始主表下载结束--------");
		//开始下载Z_pxtj附属表的信息
		String[] ofparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		Object[] ofoos={"Z_pxtj",code,start,end,"","","",userpwd};
		Result ofrs=DownUtil.downZcor("Z_cor_of", ofparams, ofoos);
		xml=DownUtil.resultHandle_of_Z_pxtj(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_pxtj",code,start,end,"","",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_of", ofparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_pxtj(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//下载Z_sccp
		String[] Z_sccpparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		String[] Z_sccpofoos={"Z_sccp",code,start,end,"","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_of", Z_sccpparams, Z_sccpofoos);
		xml=DownUtil.resultHandle_of_Z_sccp(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_sccp",code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_of", Z_sccpparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sccp(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//下载Z_sccl
		String[] Z_scclparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		String[] Z_scclofoos={"Z_sccl",code,start,end,"","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_of", Z_scclparams, Z_scclofoos);
		xml=DownUtil.resultHandle_of_Z_sccl(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_sccl",code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_of", Z_scclparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sccl(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//下载Z_sczj
		String[] Z_sczjparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		String[] Z_sczjofoos={"Z_sczj",code,start,end,"","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_of", Z_sczjparams, Z_sczjofoos);
		xml=DownUtil.resultHandle_of_Z_sczj(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_sczj",code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_of", Z_sczjparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sczj(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//下载Z_site
		String[] Z_siteparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		String[] Z_siteofoos={"Z_site",code,start,end,"","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_of", Z_siteparams, Z_siteofoos);
		xml=DownUtil.resultHandle_of_Z_site(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_site",code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_of", Z_siteparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_site(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//下载Z_wh
		String[] Z_whparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		String[] Z_whofoos={"Z_wh",code,start,end,"","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_of", Z_whparams, Z_whofoos);
		xml=DownUtil.resultHandle_of_Z_wh(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_wh",code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_of", Z_whparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_wh(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		
		message="下载成功！";
		
		return "01";
	}
	/**
	 * 待审查数据下载
	 * @return
	 */
	public String dscDownload(){
		String code=Config.getProperty("serviceDiscode");
		String userpwd=Config.getProperty("userpwd");
		String dd=Config.getProperty("timexxx");
		String start="";
		String end="";
		if(null==dd&&dd.equals("")&&dd.equals("null")){
			int ddi=Integer.parseInt(dd);
			start=BusinessDate.getNowDay();
			end=Util.getTime(ddi);
		}
		String[] params={"dqid","tbdts","tbdte","where","col","page","userpwd"};
		Object[] oos={code,start,end," "," "," ",userpwd};
		
		Result trs=TDownUtil.downTcor("T_cor_dsc", params, oos);
		String xml=TDownUtil.resultHandle(trs);//处理第一批数据，并返回错误的xml格式
		Process pro=trs.getProcess();
		String number=pro.getNumber();
		int num=0;
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			if(i>0){
				String[] oo={code,start,end," ","",i+"",userpwd};
				trs=TDownUtil.downTcor("T_cor_dsc", params, oo);
				xml=TDownUtil.resultHandle(trs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//开始下载T_pxtj附属表的信息
		String[] Tofparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		Object[] Tofoos={"T_pxtj",code,start,end,"","","",userpwd};
		Result Tofrs=TDownUtil.downTcor("T_cor_dsc_of", Tofparams, Tofoos);
		xml=TDownUtil.resultHandle_of_T_pxtj(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_pxtj",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dsc_of", Tofparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_pxtj(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//下载T_sccp
		String[] T_sccpparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		String[] T_sccpofoos={"T_sccp",code,start,end,"","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dsc_of", T_sccpparams, T_sccpofoos);
		xml=TDownUtil.resultHandle_of_T_sccp(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_sccp",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dsc_of", T_sccpparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sccp(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//下载T_sccl
		String[] T_scclparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		String[] T_scclofoos={"T_sccl",code,start,end,"","","",userpwd};
		Tofrs=DownUtil.downZcor("T_cor_dsc_of", T_scclparams, T_scclofoos);
		xml=TDownUtil.resultHandle_of_T_sccl(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_sccl",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dsc_of", T_scclparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sccl(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//下载T_sczj
		String[] T_sczjparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		String[] T_sczjofoos={"T_sczj",code,start,end,"","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dsc_of", T_sczjparams, T_sczjofoos);
		xml=TDownUtil.resultHandle_of_T_sczj(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_sczj",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dsc_of", T_sczjparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sczj(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//下载T_site
		String[] T_siteparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		String[] T_siteofoos={"T_site",code,start,end,"","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dsc_of", T_siteparams, T_siteofoos);
		xml=TDownUtil.resultHandle_of_T_site(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_site",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dsc_of", T_siteparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_site(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//下载T_wh
		String[] T_whparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		String[] T_whofoos={"T_wh",code,start,end,"","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dsc_of", T_whparams, T_whofoos);
		xml=TDownUtil.resultHandle_of_T_wh(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_wh",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dsc_of", T_whparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_wh(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		message="下载成功！";
		return "01";
	}
	
	/**
	 * 待备案数据的下载
	 * @return
	 */
	public String dbaDownload(){
		String code=Config.getProperty("serviceDiscode");
		String userpwd=Config.getProperty("userpwd");
		String dd=Config.getProperty("timexxx");
		String start="";
		String end="";
		if(null==dd&&dd.equals("")&&dd.equals("null")){
			int ddi=Integer.parseInt(dd);
			start=BusinessDate.getNowDay();
			end=Util.getTime(ddi);
		}
		String[] params={"dqid","tbdts","tbdte","where","col","page","userpwd"};
		Object[] oos={code,start,end," "," "," ",userpwd};
		
		Result trs=TDownUtil.downTcor("T_cor_dba", params, oos);
		String xml=TDownUtil.resultHandle(trs);//处理第一批数据，并返回错误的xml格式
		Process pro=trs.getProcess();
		String number=pro.getNumber();
		int num=0;
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			if(i>0){
				String[] oo={code,start,end," ","",i+"",userpwd};
				trs=TDownUtil.downTcor("T_cor_dba", params, oo);
				xml=TDownUtil.resultHandle(trs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//开始下载T_pxtj附属表的信息
		String[] Tofparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		Object[] Tofoos={"T_pxtj",code,start,end,"","","",userpwd};
		Result Tofrs=TDownUtil.downTcor("T_cor_dba_of", Tofparams, Tofoos);
		xml=TDownUtil.resultHandle_of_T_pxtj(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_pxtj",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dba_of", Tofparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_pxtj(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//下载T_sccp
		String[] T_sccpparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		String[] T_sccpofoos={"T_sccp",code,start,end,"","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dba_of", T_sccpparams, T_sccpofoos);
		xml=TDownUtil.resultHandle_of_T_sccp(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_sccp",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dba_of", T_sccpparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sccp(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//下载T_sccl
		String[] T_scclparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		String[] T_scclofoos={"T_sccl",code,start,end,"","","",userpwd};
		Tofrs=DownUtil.downZcor("T_cor_dba_of", T_scclparams, T_scclofoos);
		xml=TDownUtil.resultHandle_of_T_sccl(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_sccl",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dba_of", T_scclparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sccl(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//下载T_sczj
		String[] T_sczjparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		String[] T_sczjofoos={"T_sczj",code,start,end,"","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dba_of", T_sczjparams, T_sczjofoos);
		xml=TDownUtil.resultHandle_of_T_sczj(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_sczj",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dba_of", T_sczjparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_sczj(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//下载T_site
		String[] T_siteparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		String[] T_siteofoos={"T_site",code,start,end,"","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dba_of", T_siteparams, T_siteofoos);
		xml=TDownUtil.resultHandle_of_T_site(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_site",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dba_of", T_siteparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_site(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		//下载T_wh
		String[] T_whparams={"oftablename","dqid","tbdts","tbdte","where","colstr","page","userpwd"};
		String[] T_whofoos={"t_wh",code,start,end,"","","",userpwd};
		Tofrs=TDownUtil.downTcor("T_cor_dba_of", T_whparams, T_whofoos);
		xml=TDownUtil.resultHandle_of_T_wh(Tofrs);
		pro=Tofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"T_wh",code,start,end," ","",i+"",userpwd};
				Tofrs=DownUtil.downZcor("T_cor_dba_of", T_whparams, ofoo);
				xml=TDownUtil.resultHandle_of_T_wh(Tofrs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
			}
		}
		message="下载成功！";
		return "01";
	}
	
	/**
	 * 打印回执据数据的下载
	 * @return
	 */
	public String hzDownload(){
		String code=Config.getProperty("serviceDiscode");
		String userpwd=Config.getProperty("userpwd");
		String dd=Config.getProperty("timexxx");
		String start="";
		String end="";
		if(null==dd&&dd.equals("")&&dd.equals("null")){
			int ddi=Integer.parseInt(dd);
			start=BusinessDate.getNowDay();
			end=Util.getTime(ddi);
		}
		String[] params={"dqid","beiandts","beiandte","where","col","page","userpwd"};
		Object[] oos={code,start,end,"","","",userpwd};
		Result rs=DownUtil.downZcor("Z_cor_hz", params, oos);
		String xml=DownUtil.resultHandle(rs);//处理第一批数据，并返回错误的xml格式
		Process pro=rs.getProcess();
		String number=pro.getNumber();
		int num=0;
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		//System.out.println("备案数据开始下载--------");
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] oo={code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_hz", params, oo);
				xml=DownUtil.resultHandle(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//System.out.println("备案数据开始主表下载结束--------");
		//开始下载Z_pxtj附属表的信息
		String[] ofparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		Object[] ofoos={"Z_pxtj",code,start,end,"","","",userpwd};
		Result ofrs=DownUtil.downZcor("Z_cor_hz_of", ofparams, ofoos);
		xml=DownUtil.resultHandle_of_Z_pxtj(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_pxtj",code,start,end,"","",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_hz_of", ofparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_pxtj(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//下载Z_sccp
		String[] Z_sccpparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		String[] Z_sccpofoos={"Z_sccp",code,start,end,"","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_hz_of", Z_sccpparams, Z_sccpofoos);
		xml=DownUtil.resultHandle_of_Z_sccp(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_sccp",code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_hz_of", Z_sccpparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sccp(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//下载Z_sccl
		String[] Z_scclparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		String[] Z_scclofoos={"Z_sccl",code,start,end,"","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_hz_of", Z_scclparams, Z_scclofoos);
		xml=DownUtil.resultHandle_of_Z_sccl(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_sccl",code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_hz_of", Z_scclparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sccl(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//下载Z_sczj
		String[] Z_sczjparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		String[] Z_sczjofoos={"Z_sczj",code,start,end,"","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_hz_of", Z_sczjparams, Z_sczjofoos);
		xml=DownUtil.resultHandle_of_Z_sczj(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_sczj",code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_hz_of", Z_sczjparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_sczj(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//下载Z_site
		String[] Z_siteparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		String[] Z_siteofoos={"Z_site",code,start,end,"","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_hz_of", Z_siteparams, Z_siteofoos);
		xml=DownUtil.resultHandle_of_Z_site(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_site",code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_hz_of", Z_siteparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_site(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		//下载Z_wh
		String[] Z_whparams={"oftablename","dqid","beiandts","beiandte","where","colstr","page","userpwd"};
		String[] Z_whofoos={"Z_wh",code,start,end,"","","",userpwd};
		ofrs=DownUtil.downZcor("Z_cor_hz_of", Z_whparams, Z_whofoos);
		xml=DownUtil.resultHandle_of_Z_wh(ofrs);
		pro=ofrs.getProcess();
		number=pro.getNumber();
		if(null!=number&&!"".equals(number)&&!"null".equals(number)){
			num=Integer.parseInt(number);
		}
		for(int i=0;i<=num;i++){
			//System.out.println("开始处理第"+i+"页数据");
			if(i>0){
				String[] ofoo={"Z_wh",code,start,end,""," ",i+"",userpwd};
				rs=DownUtil.downZcor("Z_cor_hz_of", Z_whparams, ofoo);
				xml=DownUtil.resultHandle_of_Z_wh(rs);//处理第num批数据，并返回错误的xml格式
				String[] empams={"msgstr","userpwd"};
				String[] empoos={xml,userpwd};
				Result ers=DownUtil.downZcor("msgstate", empams, empoos);
			}
		}
		
		message="下载成功！";
		
		return "01";
	}
	/**
	 * 待审查审核数据的下载
	 * @return
	 */
	public static void main(String[] args) {
		
		DownLoadAction da=new DownLoadAction();
		da.baDownload();
		da.hzDownload();
	}

}
