package com.shuaihua.designpatterns.prototype.deep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author shuaihua
 *
 */

//深复制原型模式，将class引用的全部“基本数据类型”和“对象”进行复制并创建与原对象完全不同的全新obj。
public class DeepPrototype implements Cloneable,Serializable{

	private static final long serialVersionUID = -9102137241253834941L;
	
	private int size;
	private String name;
	private TestModle testModle;
	
	public DeepPrototype(int size, String name, TestModle testModle) {
		super();
		this.size = size;
		this.name = name;
		this.testModle = testModle;
	}


	@Override
	protected DeepPrototype clone() throws CloneNotSupportedException {
		DeepPrototype obj = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			obj = (DeepPrototype)ois.readObject();
			
			bos.close();
			oos.close();
			bis.close();
			ois.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
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
