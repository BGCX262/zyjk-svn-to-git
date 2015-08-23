package synch.listener;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import synch.action.DownLoadAction;
import synch.wgh.dao.WghsynchDAO;

public class WghSynchJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		try{
			WghsynchDAO wgh=new WghsynchDAO();
			//da.download();
			wgh.synchB_cor();
			wgh.synchT_cor();
			wgh.synchZ_cor();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
