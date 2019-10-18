package com.shuaihua.designpatterns.proxy.staticproxy;

import java.util.Random;

/**
 * 
 * @author shuaihua
 *
 */

//静态代理，代理类需要和被代理类实现共同的接口，并拿到被代理类的引用。
//代理类对被代理的对象有控制权，决定其执行或者不执行
//与装饰模式的区别：装饰类对代理对象没有控制权，只能为期增加一层装饰，加强被装饰对象的功能。
public class HouseAgent implements Person{
	
	private HouseBuyer houseBuyer;

	public HouseAgent(HouseBuyer houseBuyer) {
		super();
		this.houseBuyer = houseBuyer;
	}

	@Override
	public void buyHouse() {
		Random random = new Random();
		
		//代理类可以控制是否买房成功
		if(random.nextBoolean()) {
			System.out.println("为购房者找到合适房源");//这是代理角色独有的功能
			houseBuyer.buyHouse();//这是被代理角色的功能
			System.out.println("为购房者办结全部购房事务");//这是代理角色独有的功能
		}else {
			System.out.println("未找到合适房源");//这是代理角色独有的功能
		}
		
		//如果buyHouse()只包含以下三行代码，这种设计模式就可以成为装饰模式了，因为代理类对被代理对象没有控制权
		//System.out.println("为购房者找到合适房源");
		//houseBuyer.buyHouse();
		//System.out.println("为购房者办结全部购房事务");
	}

}
