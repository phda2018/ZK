package com.phda.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 关于线程池测试 
 * @author phda
 *
 */
public class ThreadPoolTest {

	public ThreadPoolTest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 1.一般性的测试
	 */
	public static void fn() {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(10);//创建线程池
		threadPool.execute(new Nums());
		
		threadPool.shutdown();//线程池没有立即关闭，而是等任务运行完毕
//		threadPool.shutdownNow();//立即停止，无论是否运行都会停止
//		try {
//			threadPool.awaitTermination(10, TimeUnit.SECONDS);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		while (!threadPool.isTerminated()) {
			System.out.println("没有终止");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 1.一般性的测试
	 */
	public static void fn02() {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(10);//创建线程池
		Future<String> taskResult = threadPool.submit(new Nums2());//taskResult 记录线程运行的结果
		try {
			System.out.println(taskResult.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		threadPool.shutdown();//线程池没有立即关闭，而是等任务运行完毕
		
		while ( !taskResult.isDone() ) {
			System.out.println("没有终止");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
//		fn();//线程池的一般性调用
		fn02();//线程池的一般性调用
	}
	

}
/**
 * 数数任务，每秒1次
 * @author phda
 */
class Nums implements Runnable{
	@Override
	public void run() {
		
		for(int index = 0; index < 3 ;index++)
		{
			System.err.println(this+"--"+index);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

/**
 * 数数任务，每秒1次
 * @author phda
 */
class Nums2 implements Callable<String>{

	@Override
	public String call() throws Exception {
		for(int index = 0; index < 3 ;index++)
		{
			System.err.println(this+"--"+index);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "执行完毕call";
	}
}



