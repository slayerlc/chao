package com.designpattern.visitor;

public interface Visitor {
	
	public abstract void visitorConcreteElementA(ConcreteElementA elementA);
	
	public abstract void visitorConcreteElementB(ConcreteElementB elementB);
}
