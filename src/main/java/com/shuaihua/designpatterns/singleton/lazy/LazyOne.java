/**
 * 
 */
package com.shuaihua.designpatterns.singleton.lazy;

/**
 * @author shuaihua
 *
 */

//懒汉式单例模式 在被外部调用时才会进行初始化
//这种写法 存在线程安全隐患
public class LazyOne {

	//私有化构造器
	private LazyOne(){}
	
	private static LazyOne lazy = null;
	
	public static LazyOne getInstance() {
		
		if(lazy == null) {
			//多个线程调用的情况下 两个线程可能会同时进入执行new
			lazy= new LazyOne();
		}
		
		return lazy;
	}
}
