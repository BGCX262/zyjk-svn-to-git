package synch.listener;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import st.platform.utils.Config;

public class Runner {

	 	static Scheduler scheduler = null;
	    static Scheduler upscheduler = null;
	   // static Scheduler wsbscheduler = null;
	    /**
	     * 数据下载的线程
	     * @throws SchedulerException
	     */
	    public void batask() throws SchedulerException {
	        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	        scheduler = schedulerFactory.getScheduler();
	        long ctime = System.currentTimeMillis();
	        JobDetail jobDetail = new JobDetail("jobDetail1", "jobDetailGroup1",
	                DownJob.class);
	        CronTrigger cronTrigger = new CronTrigger("cronTrigger","triggerGroup1");
	        try {
	            CronExpression cexp = new CronExpression(Config.getProperty("downdata"));
	            cronTrigger.setCronExpression(cexp.getCronExpression());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        scheduler.scheduleJob(jobDetail, cronTrigger);
	        scheduler.start();
	    }
	    /**
	     * 终止数据下载的线程
	     * @throws SchedulerException
	     */
	    public void stop() throws SchedulerException {
	        scheduler.shutdown();
	    }
	    /**
	     * 数据的上传
	     * @throws SchedulerException
	     */
	    public void  uptask() throws SchedulerException {
	    	SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	    	upscheduler = schedulerFactory.getScheduler();
	        long ctime = System.currentTimeMillis();
	        JobDetail jobDetail = new JobDetail("jobDetail2", "jobDetailGroup2",
	        		UpJob.class);
	        CronTrigger cronTrigger = new CronTrigger("cronTrigger1","triggerGroup2");
	        try {
	            CronExpression cexp = new CronExpression(Config.getProperty("updata"));
	            cronTrigger.setCronExpression(cexp.getCronExpression());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        upscheduler.scheduleJob(jobDetail, cronTrigger);
	        upscheduler.start();
	    }
	    /**
	     * 数据上传终止
	     * @throws SchedulerException
	     */
	    public void upstop() throws SchedulerException {
	    	upscheduler.shutdown();
	    }
	    
	    public static void main(String[] args) {
	    	Runner run=new Runner();
	    	try {
				run.batask();
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
