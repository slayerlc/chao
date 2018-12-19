package com.designpattern.observer;

public interface Observer {

	void update();

	void setSubject(Subject concreteSubject);

    void setObserverState(String observerState);

}
