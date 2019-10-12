package com.shuaihua.designpatterns.singleton.test;

import java.util.concurrent.CountDownLatch;

import com.shuaihua.designpatterns.singleton.lazy.LazyTwo;

/**
 * 
 * @author shuaihua
 *
 */
/**

LazyOne test result:单例被破坏，产生线程安全隐患
1570864672575: com.shuaihua.designpatterns.singleton.lazy.LazyOne@15a26cf0
1570864672575: com.shuaihua.designpatterns.singleton.lazy.LazyOne@29e5a87f


LazyTwo test result:不存在线程安全隐患
1570864672575: com.shuaihua.designpatterns.singleton.lazy.LazyOne@15a26cf0
1570864672575: com.shuaihua.designpatterns.singleton.lazy.LazyOne@29e5a87f
 */
public class LazyOneTest {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int count = 200;
		
		CountDownLatch latch = new CountDownLatch(count);
		
		for (int i = 0; i < count; i++) {
			new Thread() {

				@Override
				public void run() {
					try {
						//在count=0之前，全部的线程都处于阻塞状态，不会继续向下执行
						latch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//在count=0时，所有的线程被释放共享锁，并发访问getInstance，造成线程安全隐患
					//测试lazyOneTwo线程是否安全
					//LazyOne obj = LazyOne.getInstance();
					//测试lazyTwo线程是否安全
					LazyTwo obj = LazyTwo.getInstance();
					System.out.println(System.currentTimeMillis() + ": " + obj);
				}
				
			}.start();
			
			 latch.countDown();
		}
		
		long end =  System.currentTimeMillis();
		
		System.out.println("总耗时：" + (end - start));
	}
}
