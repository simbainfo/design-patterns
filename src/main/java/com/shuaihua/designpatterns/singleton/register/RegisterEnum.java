package com.shuaihua.designpatterns.singleton.register;

/**
 * 
 * @author shuaihua
 *
 */

//枚举注册式单例
public enum RegisterEnum {

	RED(255,0,0),BLACK(0,0,0),WHITE(255,255,255);
	
	private int r;
	private int g;
	private int b;
	
	private RegisterEnum(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}
