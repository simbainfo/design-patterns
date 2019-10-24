package com.shuaihua.designpatterns.observer;

public class ObserverB implements Observer {

	private String observerState;

	@Override
	public void updateState(String newState) {
		this.observerState = newState;
		System.out.println("ObserverB: " + observerState);
	}

}
