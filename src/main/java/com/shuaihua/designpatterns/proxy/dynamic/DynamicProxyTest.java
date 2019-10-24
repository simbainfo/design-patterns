package com.shuaihua.designpatterns.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 
 * @author shuaihua
 *
 */

/**
 * 1. 拿到被代理對象的引用（RealPerson.class）以及被代理對象的interface
 * 2. jdk proxy 动态生成新的class，新生成的class要实现被代理类接口的全部方法，并且把新增加的业务逻辑按照一定的方法加入到新生成类的方法中
 * 3. 编译新生成的java代码，生成 $proxy0.class 文件
 * 4. 再将class文件重新加载到jvm中
 * 
 * 以上就叫做字节码重组
 * 
 * jdk规范，以$开头的class都是自动生成的
 */
public class DynamicProxyTest {

	public static void main(String[] args) {
		
		Person person = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), 
				new Class[]{Person.class}, 
				new DynamicProxy(new RealPerson()));
		
		person.buyHouse();
		person.findJob();
		person.findLove();
	}
}
