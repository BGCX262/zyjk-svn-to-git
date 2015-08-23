package synch.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.SchedulerException;

public class DownListener implements ServletContextListener {

	Runner run=null;
	public void contextDestroyed(ServletContextEvent arg0) {
	
		//TODO Auto-generated method stub
		try {
			run.stop();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		
		// TODO Auto-generated method stub
		run=new Runner();
		try {
			run.batask();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DownListener dd=new DownListener();
		dd.contextInitialized(null);
	}
}
