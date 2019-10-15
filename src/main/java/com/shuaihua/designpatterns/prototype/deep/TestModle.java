package com.shuaihua.designpatterns.prototype.deep;

import java.io.Serializable;

/**
 * 
 * @author shuaihua
 *
 */
public class TestModle implements Cloneable,Serializable{

	private static final long serialVersionUID = -9152658000462710450L;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
