package com.shuaihua.designpatterns.proxy.cglib;

/**
 * 
 * @author shuaihua
 *
 */
public class RealPerson{

	public void buyHouse() {
		System.out.println("buyHouse: 支付房款及中介费");
	}

	public void findJob() {
		System.out.println("findJob: 支付工作介绍费用");
	}

	public void findLove() {
		System.out.println("findLove: 支付300W彩礼及婚介费用");
	}

}
