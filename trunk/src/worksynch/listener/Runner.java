package worksynch.listener;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import st.platform.utils.Config;

public class Runner {

	 	static Scheduler OuterScheduler = null;
	    static Scheduler InerScheduler = null;
	   // static Scheduler wsbscheduler = null;
	    /**
	     * 数据下载的线程
	     * @throws SchedulerException
	     */
	    public void Outertask() throws SchedulerException {
	        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	        OuterScheduler = schedulerFactory.getScheduler();
	        long ctime = System.currentTimeMillis();
	        JobDetail jobDetail = new JobDetail("jobDetail1", "jobDetailGroup1",
	                OuterJob.class);
	        CronTrigger cronTrigger = new CronTrigger("cronTrigger","triggerGroup1");
	        try {
	            CronExpression cexp = new CronExpression(Config.getProperty("outerdata"));
	            cronTrigger.setCronExpression(cexp.getCronExpression());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        OuterScheduler.scheduleJob(jobDetail, cronTrigger);
	        OuterScheduler.start();
	    }
	    /**
	     * 终止数据下载的线程
	     * @throws SchedulerException
	     */
	    public void stop() throws SchedulerException {
	    	OuterScheduler.shutdown();
	    }
	    /**
	     * 数据的上传
	     * @throws SchedulerException
	     */
	    public void  Inertask() throws SchedulerException {
	    	SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	    	InerScheduler = schedulerFactory.getScheduler();
	        long ctime = System.currentTimeMillis();
	        JobDetail jobDetail = new JobDetail("jobDetail2", "jobDetailGroup2",
	        		InerJob.class);
	        CronTrigger cronTrigger = new CronTrigger("cronTrigger1","triggerGroup2");
	        try {
	            CronExpression cexp = new CronExpression(Config.getProperty("inerdata"));
	            cronTrigger.setCronExpression(cexp.getCronExpression());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        InerScheduler.scheduleJob(jobDetail, cronTrigger);
	        InerScheduler.start();
	    }
	    /**
	     * 数据上传终止
	     * @throws SchedulerException
	     */
	    public void Inerstop() throws SchedulerException {
	    	InerScheduler.shutdown();
	    }
	    
	    public static void main(String[] args) {
	    	
		}
}
