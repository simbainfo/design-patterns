package com.shuaihua.designpatterns.proxy.staticproxy;

/**
 * 
 * @author shuaihua
 *
 */

public class StaticProxyTest {

	public static void main(String[] args) {
		
		HouseAgent houseAgent = new HouseAgent(new HouseBuyer());
		
		houseAgent.buyHouse();
	}
}
