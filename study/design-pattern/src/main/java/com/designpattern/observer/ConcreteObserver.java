/*
package com.designpattern.observer;

public class ConcreteObserver implements Observer{
	
	private String name;
	private String observerState;
	private Subject  subject;

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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject concreteSubject) {
		this.subject = concreteSubject;
	}

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public ConcreteObserver(Subject subject, String name){
		this.name = name;
        subject.attach(this);
	}
	
	@Override
	public void update() {
		observerState = subject.getSubjectState();
		System.out.println("-------"+this.name+"-------"+this.observerState);
	}

}
*/
