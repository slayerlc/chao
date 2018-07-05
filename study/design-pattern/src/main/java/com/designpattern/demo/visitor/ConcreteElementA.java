package com.designpattern.demo.visitor;

public class ConcreteElementA implements Element{

	@Override
	public void accept(Visitor visitor) {
		visitor.visitorConcreteElementA(this);
	}
	
	public void operationA(){
		
	}

}
