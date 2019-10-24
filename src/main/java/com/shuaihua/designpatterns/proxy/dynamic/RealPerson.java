package com.shuaihua.designpatterns.proxy.dynamic;

/**
 * 
 * @author shuaihua
 *
 */
public class RealPerson implements Person{

	@Override
	public void buyHouse() {
		System.out.println("buyHouse: 支付房款及中介费");
	}

	@Override
	public void findJob() {
		System.out.println("findJob: 支付工作介绍费用");
	}

	@Override
	public void findLove() {
		System.out.println("findLove: 支付300W彩礼及婚介费用");
	}

}
