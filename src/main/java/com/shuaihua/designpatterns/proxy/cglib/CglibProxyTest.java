package com.shuaihua.designpatterns.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {

	public static void main(String[] args) {
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(RealPerson.class);
		enhancer.setCallback(new CglibProxy());
		
		RealPerson realPerson = (RealPerson)enhancer.create();
		
		realPerson.findJob();
		realPerson.buyHouse();
		realPerson.findLove();
	}
}
