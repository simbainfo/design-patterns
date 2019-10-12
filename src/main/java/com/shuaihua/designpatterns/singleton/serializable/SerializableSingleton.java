package com.shuaihua.designpatterns.singleton.serializable;

import java.io.Serializable;

/**
 * 
 * @author shuaihua
 *
 */
//序列化单例模式
public class SerializableSingleton implements Serializable {
	
	//序列化是把内存中的对象转化成字节码的形式 形成IO流  写入到 磁盘网络等 把内存中的状态永久保存下来
	
	//反序列化 将已经持久化的字节码 读取成IO流  进而将读取的内容转换成java对象，转换的过程中会用new重新创建对象

	/**
	 * 
	 */
	private static final long serialVersionUID = -2690701605716034491L;

	private SerializableSingleton() {}
	
	private final static SerializableSingleton INSTANCE = new SerializableSingleton();
	
	public static SerializableSingleton getInstance() {
		return INSTANCE;
	}
	
	//重新这个方法可以保证序列化单例不被破坏
	private Object readResolve() {
		return INSTANCE;
	}
}
