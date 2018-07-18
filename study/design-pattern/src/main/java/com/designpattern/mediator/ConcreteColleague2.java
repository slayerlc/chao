package com.designpattern.mediator;

public class ConcreteColleague2 extends Colleague{

	public ConcreteColleague2(Mediator mediator) {
		super(mediator);
	}
	
	public void send(String message){
		mediator.send(message, this);
	}
	
	public void inform(String message){
		System.out.println("2�յ�1���͵���Ϣ"+message);
	}

}
