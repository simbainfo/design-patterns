package com.shuaihua.designpatterns.observer;

/**
 * 
 * @author shuaihua
 *
 */
public class ObserverTest {

	public static void main(String[] args) {
		ObserverA observerA = new ObserverA();
		ObserverB observerB = new ObserverB();
		ObserverC observerC = new ObserverC();
		
		Subject subject = new Subject();
		
		subject.attach(observerA);
		subject.attach(observerB);
		subject.attach(observerC);
		
		subject.updateState("开心");
		
		subject.updateState("不开心了。。。");
	}
}
