package com.shuaihua.designpatterns.singleton.lazy;

/**
 * 
 * @author shuaihua
 *
 */

// 懒汉式 单例模式 增加synchronized
public class LazyTwo {

	//私有化构造器
	private LazyTwo(){}
	
	private static LazyTwo lazy = null;
	
	// 在方法上增加 synchronized 保证线程安全 ，但是执行效率会下降严重
	public static synchronized LazyTwo getInstance() {
		
		if(lazy == null) {
			
			lazy= new LazyTwo();
		}
		
		return lazy;
	}
}
