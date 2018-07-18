package com.designpattern.observer;

public class Program {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject(); 
		
		subject.attach(new ConcreteObserver(subject, "����"));
		subject.attach(new ConcreteObserver(subject, "����"));
		subject.attach(new ConcreteObserver(subject, "����"));
		
		subject.setSubjectState("123");
		
		subject.notifyObserver();
	}
}
