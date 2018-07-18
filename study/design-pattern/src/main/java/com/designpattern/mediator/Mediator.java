package com.designpattern.mediator;

public abstract class Mediator {
	
	protected Mediator mediator;
	
	public abstract void send(String message,Colleague colleague);
	
}
