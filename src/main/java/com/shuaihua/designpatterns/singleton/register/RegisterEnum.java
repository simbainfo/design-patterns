package com.shuaihua.designpatterns.singleton.register;

/**
 * 
 * @author shuaihua
 *
 */

//枚举式单例
public enum RegisterEnum {

	RED(){
	       private int r = 255;
	       private int g = 0;
	       private int b = 0;

	},BLACK(){
	        private int r = 0;
	        private int g = 0;
	        private int b = 0;
	},WHITE(){
	        private int r = 255;
	        private int g = 255;
	        private int b = 255;
	};
}
