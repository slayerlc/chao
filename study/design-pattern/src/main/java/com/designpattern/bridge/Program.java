package com.designpattern.bridge;

public class Program {
	
	public static void main(String[] args) {
		
		Abstraction ab = new RefinedAbstraction();
		ab.setImplementor(new ConcreteImplementorA());
		ab.operation();
		
		ab.setImplementor(new ConcreteImplementorB());
		ab.operation();
	}
}
