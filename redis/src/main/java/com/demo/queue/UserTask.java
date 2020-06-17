package com.demo.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class UserTask {
	//队列大小  
    private final int QUEUE_LENGTH = 10000*10;  
    //基于内存的阻塞队列  
    private BlockingQueue<String> queue = new LinkedBlockingQueue<String>(QUEUE_LENGTH);  
    //private SynchronousQueue<String> queue = new LinkedBlockingQueue<String>(QUEUE_LENGTH);  

    //创建计划任务执行器  
    private ScheduledExecutorService es = Executors.newScheduledThreadPool(1);  
  
    /** 
     * 构造函数，执行execute方法 
     */  
    public UserTask() {  
        execute();  
    }  
      
    /** 
     * 添加信息至队列中 
     * @param content 
     */  
    public void addQueue(String content) {  
        queue.add(content);  
    }  
      
    /** 
     * 初始化执行 
     */  
    public void execute() {  
    	
  /*  	Thread t=new Thread(){
        		 public void run() {
       			 try {  
       				 while(true) {
       					 Thread.sleep(1000*10);
       					 System.out.println(this.getName());
	                     String content = queue.take();  
	                     //处理队列中的信息。。。。。  
	                     System.out.println(content);
       				 }
                 } catch (InterruptedException e) {  
                     e.printStackTrace();  
                 }  
       		  }
     	};
    	t.start();*/
    	
        //每一分钟执行一次  
       es.scheduleWithFixedDelay(new Runnable(){  
            public void run() {  
                try {  
                    String content = queue.take();  
                    //处理队列中的信息。。。。。  
                    System.out.println(Thread.currentThread().getName()+"队列获取新数据："+content);  
                    System.out.println("开始处理复杂业务需要10s");  
                     Thread.sleep(1000*10);
                    System.out.println("处理完毕");  

                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
              
        }, 1, 10, TimeUnit.SECONDS);   
    	
    	 
    }  
   public static void main(String[]args) {
	   UserTask task=new UserTask();
	   task.addQueue("中国");
	   task.addQueue("日本");
	   task.addQueue("美国");
	   task.addQueue("韩国");
	   
	   task.execute();
	   
   }
}
