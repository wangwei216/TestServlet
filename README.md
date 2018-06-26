# TestServlet
正在努力学习JavaEE的基础知识点
## 如何在项目中使用定时器框架Quartz的思路##

 1. 你需要在项目中加入quartz-all-2.1.7.jar的jar包

 2. 然后需要新建一个类去注册定时任务和销毁定时任务,这个类需要实现ServletContextListener的接口中的contextInitialized和contextDestroyed方法,完事之后还需要在web.xml中去监听这个新建的类
```
public class InitListener implements ServletContextListener {

	public static Scheduler scheduler = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		try {
            scheduler.shutdown();
            System.out.print("定时器关闭！");
            
        } catch (SchedulerException se) {
            se.printStackTrace();
        }

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		try {
            // 获取Scheduler实例
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            // 具体任务
            JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();

            // 触发时间点
            SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5).repeatForever();
	 // CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 */2 * * * ?"); 其实也可以用这种定义时间点，这个就表示每隔2分钟执行一次定时器里面的任务
    
            //这个是定义对象触发器
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                    .startNow().withSchedule(simpleScheduleBuilder).build();

            // 交由Scheduler安排触发
            scheduler.scheduleJob(job, trigger);
            
            /* 为观察程序运行，此设置主程序睡眠3分钟才继续往下运行（因下一个步骤是“关闭Scheduler”） */
            try {
                TimeUnit.MINUTES.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 关闭Scheduler
            scheduler.shutdown();

        } catch (SchedulerException se) {
            logger.error(se.getMessage(), se);
        }
    }

}

```

 3. 接着就是去定义你自己的定时任务了，也就是再去新建一个类去实现Job的接口中的execute（）方法，这个方法就是你在定时任务执行的时候要执行的内容

```
public class HelloJob implements Job {
    
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        // 此任务仅打印日志便于调试、观察
        this.logger.debug(this.getClass().getName() + " trigger...");
	//这个下面就需要写你自己需要的定时器需要真正执行的任务都写在这里
    }

}
```
