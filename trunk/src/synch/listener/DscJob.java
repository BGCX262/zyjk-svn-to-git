package synch.listener;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import synch.action.DownLoadAction;

public class DscJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		try{
			DownLoadAction da=new DownLoadAction();
			da.dscDownload();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
