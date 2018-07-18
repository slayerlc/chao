package com.designpattern.bridge;

public class RefinedAbstraction extends Abstraction{

	@Override
	public void operation() {
		super.implementor.operation();
	}
	
}
