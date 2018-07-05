package com.designpattern.demo.visitor;

public class Program {
	
	public static void main(String[] args) {
		ObjectStructure os = new ObjectStructure();
		os.attach(new ConcreteElementA());
		os.attach(new ConcreteElementB());
		
		ConcreteVisitor1 c1 = new ConcreteVisitor1();
		ConcreteVisitor2 c2 = new ConcreteVisitor2();
		
		os.Accept(c1);
		os.Accept(c2);
	}
}
