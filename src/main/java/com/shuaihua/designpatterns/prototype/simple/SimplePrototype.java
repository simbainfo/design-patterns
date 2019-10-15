package com.shuaihua.designpatterns.prototype.simple;

/**
 * 
 * @author shuaihua
 *
 */
public class SimplePrototype implements Cloneable{

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	private int size;
	private String name;
	private TestModle testModle;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TestModle getTestModle() {
		return testModle;
	}
	public void setTestModle(TestModle testModle) {
		this.testModle = testModle;
	}
}
