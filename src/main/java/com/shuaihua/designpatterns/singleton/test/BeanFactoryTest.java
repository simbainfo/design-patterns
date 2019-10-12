/**
 * 
 */
package com.shuaihua.designpatterns.singleton.test;

import java.util.concurrent.CountDownLatch;

import com.shuaihua.designpatterns.singleton.register.BeanFactory;

/**
 * @author shuaihua
 *
 */
/**
 * 
test result: getBean 方法不加synchronized，会有线程安全隐患
1570871470242: com.shuaihua.designpatterns.singleton.test.TestModel@45401023
1570871470242: com.shuaihua.designpatterns.singleton.test.TestModel@1ec8f532
1570871470242: com.shuaihua.designpatterns.singleton.test.TestModel@1ec8f532
1570871470242: com.shuaihua.designpatterns.singleton.test.TestModel@1ec8f532
 */
public class BeanFactoryTest {

	public static void main(String[] args) throws Exception {
		
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
					
					Object obj;
					try {
						obj = BeanFactory.getBean("com.shuaihua.designpatterns.singleton.test.TestModel");
						System.out.println(System.currentTimeMillis() + ": " + obj);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}.start();
			
			latch.countDown();
		}
		
		long end =  System.currentTimeMillis();
		
		System.out.println("总耗时：" + (end - start));
	}
}
