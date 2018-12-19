package com.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	private List<Observer> observerList = new ArrayList<Observer>();
	
	public void attach(Observer observer){
        observer.setSubject(this);
		observerList.add(observer);
	}

    public abstract String getSubjectState();

	public void detach(Observer observer){
		observerList.remove(observer);
	}
	
	public void notifyObserver(){
		for(Observer observer : observerList){
            observer.setObserverState(this.getSubjectState());
			observer.update();
		}
	}

}
