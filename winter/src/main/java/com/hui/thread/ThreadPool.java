package com.hui.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	static class TaskA implements Runnable
	{

		@Override
		public void run() {
			System.out.println("Hello A");
			return;
		}
		
	}
	
	static class TaskB implements Callable<Boolean>
	{

		@Override
		public Boolean call() throws Exception {
			System.out.println("Hello B");
			return true;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		/*ExecutorService service = Executors.newFixedThreadPool(2);
		TaskA taska = new TaskA();
		TaskB taskB = new TaskB();
		Future<?> future = service.submit(taska);
		Future<Boolean> future2 = service.submit(taskB);
		Thread.sleep(2000);
		System.out.println(future.isDone());
		System.out.println(future2.isDone());
		service.shutdown();*/
		SingleThread st = new SingleThread();
		st.test();
	}
	
	static class SingleThread {
		public void test() throws InterruptedException {
			ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
			ses.scheduleAtFixedRate(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("-------------------");
				}
			}, 0, 10, TimeUnit.SECONDS);
			
			
		}
	}
}
