package com.shuaihua.designpatterns.observer;

public class ObserverC implements Observer {

	private String observerState;

	@Override
	public void updateState(String newState) {
		this.observerState = newState;
		System.out.println("ObserverC: " + observerState);
	}

}
