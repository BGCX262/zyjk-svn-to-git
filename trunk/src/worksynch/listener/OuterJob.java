package worksynch.listener;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import worksynch.action.SynchZJAction;

public class OuterJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------线程启动");
		SynchZJAction synch=new SynchZJAction();
		synch.synch();
		System.out.println("---------------------------------线程结束");
	}

}
