/**
 * 
 */
package com.shuaihua.designpatterns.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shuaihua
 *
 */

//注册时单例 spring采用的单例模式
public class BeanFactory {

	private BeanFactory() {}
	
	private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
	
	public static synchronized Object getBean(String className) throws Exception {
		if(!ioc.containsKey(className)) {
			Object obj = Class.forName(className).newInstance();
			ioc.put(className, obj);
			return obj;
		}else {
			return ioc.get(className);
		}
	}
}
