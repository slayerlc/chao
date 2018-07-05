package com.designpattern.demo.mediator;

public abstract class Mediator {
	
	protected Mediator mediator;
	
	public abstract void send(String message,Colleague colleague);
	
}
