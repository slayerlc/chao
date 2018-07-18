package com.designpattern.visitor;

public class ConcreteVisitor1 implements Visitor{

	@Override
	public void visitorConcreteElementA(ConcreteElementA elementA) {
		System.out.println(elementA.getClass().getSimpleName()+"��"+this.getClass().getSimpleName()+"����");
	}

	@Override
	public void visitorConcreteElementB(ConcreteElementB elementB) {
		System.out.println(elementB.getClass().getSimpleName()+"��"+this.getClass().getSimpleName()+"����");
	}

}
