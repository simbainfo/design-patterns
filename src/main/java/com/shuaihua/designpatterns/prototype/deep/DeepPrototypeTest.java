package com.shuaihua.designpatterns.prototype.deep;


/**
 * @author shuaihua
 *
 */
/**
 * 
深复制原型模式，被引用的对象也被复制并创建新的对象
com.shuaihua.designpatterns.prototype.deep.TestModle@15db9742
com.shuaihua.designpatterns.prototype.deep.TestModle@682a0b20
false
 *
 */
public class DeepPrototypeTest {

	public static void main(String[] args) throws Exception {
		
		DeepPrototype obj = new DeepPrototype(100,"Simba",new TestModle());
		System.out.println(obj.getTestModle());
		
		DeepPrototype objClone = (DeepPrototype)obj.clone();
		System.out.println(objClone.getTestModle());

		System.out.println(obj.getTestModle() == objClone.getTestModle());

	}
}
