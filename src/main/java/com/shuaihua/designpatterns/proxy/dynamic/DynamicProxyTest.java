package com.shuaihua.designpatterns.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 
 * @author shuaihua
 *
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
