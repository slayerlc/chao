package com.designpattern.mediator;

public abstract class Colleague {
	
	protected Mediator mediator;
	
	public Colleague(Mediator mediator){
		this.mediator = mediator;
	}
}
