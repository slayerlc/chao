package com.designpattern.demo.mediator;

public class ConcreteColleague1 extends Colleague{

	public ConcreteColleague1(Mediator mediator) {
		super(mediator);
	}
	
	public void send(String message){
		mediator.send(message, this);
	}
	
	public void inform(String message){
		System.out.println("1�յ�2���͵���Ϣ"+message);
	}
}
