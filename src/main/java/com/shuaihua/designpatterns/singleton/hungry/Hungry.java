package com.shuaihua.designpatterns.singleton.hungry;

/**
 * @author shuaihua
 */

//懒汉式 单例模式 类加载时就立即初始化 并创造出单例对象
//优点  执行效率最高/绝对线程安全
//缺点  不管是否使用都会在类加载时就初始化 稍微浪费内存
public class Hungry {

	//私有化构造方法 避免构造器被直接调用
	private Hungry() {}
	
	private final static Hungry hungry = new Hungry();
	
	public static Hungry getInstance() {
		return hungry;
	}
}
