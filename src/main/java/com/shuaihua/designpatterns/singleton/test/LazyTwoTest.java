package com.shuaihua.designpatterns.singleton.test;

import com.shuaihua.designpatterns.singleton.lazy.LazyOne;

/**
 * 
 * @author shuaihua
 *
 */

/*
 * LazyOne test result: 总耗时：4
 * LazyTwo test result: 总耗时：1148, LazyTwo为了解决线程安全，牺牲了性能作为代价。
 */
public class LazyTwoTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
        
		for (int i = 0; i < 200000000;i ++) {
            LazyOne.getInstance();
        }
        
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
	}	
}
