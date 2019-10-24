package com.shuaihua.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author shuaihua
 *
 */
public class Subject {

	//被观察者的状态
	private String state;
	
	private List<Observer> observerList = new ArrayList<Observer>();
	
	public void attach(Observer observer){
		observerList.add(observer);
	}

	public String getState() {
		return state;
	}

	public void updateState(String state) {
		this.state = state;
		notifyAll(state);
	}
	
	public void notifyAll(String state) {
		for (Observer observer : observerList) {
			observer.updateState(state);
		}
	}
}
