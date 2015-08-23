package synch.listener;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import st.platform.utils.Config;
import synch.action.DownLoadAction;
import synch.action.TofficeAction;
import synch.wgh.dao.WghsynchDAO;

public class DownJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		try{

			DownLoadAction da=new DownLoadAction();
			System.out.println("---------------------------------线程开始");
			//da.download();
			da.baDownload();
			//da.dbaDownload();
			//da.dscDownload();
			da.hzDownload();
			WghsynchDAO wgh=new WghsynchDAO();
			//da.download();
			//wgh.synchB_cor();
			//wgh.synchT_cor();
			wgh.synchZ_cor();
			TofficeAction.checkOffice();
//			//�Ƿ�����δ�ϱ������
//			String wsbstate=Config.getProperty("wsbstate");
//			if(wsbstate.equals("1")){
//				da.wsbDownload();
//			}
//			//�Ƿ����ش��������
//			String dscstate=Config.getProperty("dscstate");
//			//da.dscDownload();
//			if(dscstate.equals("1")){
//				da.dscDownload();
//			}
			System.out.println("--------------------------------线程开始ֹ");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DownJob dj=new DownJob();
		try {
			dj.execute(null);
		} catch (JobExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
