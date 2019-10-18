package com.shuaihua.designpatterns.proxy.staticproxy;

/**
 * @author shuaihua
 *
 */
public class HouseBuyer implements Person{

	@Override
	public void buyHouse() {
		System.out.println("挑选房子，支付房款及中介费");
	}

}
