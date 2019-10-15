/**
 * 
 */
package com.shuaihua.designpatterns.prototype.simple;

/**
 * @author shuaihua
 *
 */

/*
 * 
浅复制原型模式
复制出来的对象域会是相同的对象，对克隆出来的TestModel进行修改会影响到原对象的TestModel.
10
Simba
com.shuaihua.designpatterns.prototype.simple.TestModle@15db9742
10
Simba
com.shuaihua.designpatterns.prototype.simple.TestModle@15db9742
Simba
simba_objClone
 * 
 */
public class SimplePrototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		SimplePrototype obj = new SimplePrototype();
		obj.setSize(10);
		obj.setName("Simba");
		obj.setTestModle(new TestModle());
		System.out.println(obj.getSize());
		System.out.println(obj.getName());
		System.out.println(obj.getTestModle());
		
		SimplePrototype objClone = (SimplePrototype)obj.clone();
		System.out.println(objClone.getSize());
		System.out.println(objClone.getName());
		System.out.println(objClone.getTestModle());
		
		objClone.setName("simba_objClone");
		
		System.out.println(obj.getName());
		System.out.println(objClone.getName());
	}
	
	

	/*
	 * String s1 = "abc"; 
	 * String s2 = "abc"; 
	  *  采用new String()的方式构建会指向不同的内存空间。
	 * String s3 = new String("abc");
	 * System.out.println(s1==s2); //true 
	 * System.out.println(s1==s3); //false
	 */
	
}
