package com.shuaihua.designpatterns.singleton.test;

import java.lang.reflect.Constructor;

import com.shuaihua.designpatterns.singleton.lazy.LazyThree;

/**
 * @author shuaihua
 *
 */
// test result: false
public class LazyThreeTest {

	public static void main(String[] args) throws Exception {
		
		Class<?> clazz = LazyThree.class;
		Constructor<?> constructor = clazz.getDeclaredConstructor(null);
		
		constructor.setAccessible(true);
		
		Object obj1 = constructor.newInstance();
		Object obj2 = constructor.newInstance();
		
		System.out.println(obj1==obj2); //false

		
	}
}
