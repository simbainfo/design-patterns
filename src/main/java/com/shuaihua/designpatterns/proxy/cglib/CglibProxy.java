package com.shuaihua.designpatterns.proxy.cglib;

import java.lang.reflect.Method;
import java.util.Random;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @author shuaihua
 *
 */
public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		Random random = new Random();

		if (random.nextBoolean()) {
			System.out.println(method.getName() + ": 代理人去帮被代理人寻找合适的标的");
			proxy.invokeSuper(obj, args);
			System.out.println(method.getName() + ": 代理人收取代理佣金");
		} else {
			System.out.println(method.getName() + ": 代理人暂时没有找到合适的标的");
		}

		return null;
	}

}
