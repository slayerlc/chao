package com.designpattern.demo.observer;

public class ConcreteObserver implements Observer{
	
	private String name;
	private String observerState;
	private ConcreteSubject  concreteSubject;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObserverState() {
		return observerState;
	}

	public void setObserverState(String observerState) {
		this.observerState = observerState;
	}

	public ConcreteSubject getConcreteSubject() {
		return concreteSubject;
	}

	public void setConcreteSubject(ConcreteSubject concreteSubject) {
		this.concreteSubject = concreteSubject;
	}

	public ConcreteObserver(ConcreteSubject concreteSubject,String name){
		this.concreteSubject = concreteSubject;
		this.name = name;
	}
	
	@Override
	public void update() {
		observerState = concreteSubject.getSubjectState();
		System.out.println("�۲���"+this.name+"�µ�״̬��"+this.observerState);
	}

}
