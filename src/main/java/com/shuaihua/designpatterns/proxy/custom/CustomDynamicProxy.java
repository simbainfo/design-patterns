package com.shuaihua.designpatterns.proxy.custom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * 
 * @author shuaihua
 *
 */
public class CustomDynamicProxy implements InvocationHandler{
	
	//拿到被代理对象的引用
	private Person person;
	

	public CustomDynamicProxy(Person person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Random random = new Random();
		
		if(random.nextBoolean()) {
			System.out.println(method.getName() + ": 代理人去帮被代理人寻找合适的标的");
			method.invoke(this.person, args);
			System.out.println(method.getName() + ": 代理人收取代理佣金");
		}else {
			System.out.println(method.getName() + ": 代理人暂时没有找到合适的标的");
		}
		
		return null;
	}

}
