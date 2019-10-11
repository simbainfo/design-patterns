/**
 * 
 */
package com.shuaihua.designpatterns.singleton.lazy;

/**
 * @author shuaihua
 *
 */

// 懒汉式单例 最好的一种实现方式 兼顾饿汉式的执行效率 同时兼顾synchronized性能问题

//特点 在外部类被调用的时候内部类才会被调用 保证了延迟加载 内部类一定是在方法调用前就完成初始化 保证了线程安全
public class LazyThree {

	
	//内部类 默认是不加载的 只有当外部类被调用的时候才会被加载 从而实现延迟加载
	private static class LazyHolder{
		private final static LazyThree lazy = new LazyThree();
	}
	
	public final static LazyThree getInstance() {
		return LazyHolder.lazy;
	}
	
	//避免反射陷阱
	private boolean initialized = false;
	private LazyThree() {
		synchronized(LazyThree.class){
			if(initialized == false) {
				initialized=!initialized;
			}else {
				throw new RuntimeException("单例模式已被破坏");
			}
		}
	}
	
}
