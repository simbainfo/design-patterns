package com.shuaihua.designpatterns.observer;

public class ObserverA implements Observer {

	private String observerState;

	@Override
	public void updateState(String newState) {
		this.observerState = newState;
		System.out.println("ObserverA: " + observerState);
	}

}
