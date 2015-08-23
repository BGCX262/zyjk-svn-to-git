package worksynch.listener;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import worksynch.action.SynchZJAction;
import worksynch.util.ReadRecordUtil;

public class InerJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------线程启动");
		ReadRecordUtil read=new ReadRecordUtil();
		read.read();
		System.out.println("---------------------------------线程结束");
	}

}
