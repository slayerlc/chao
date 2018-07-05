package com.designpattern.demo.chainofresponsibility;

public class Program {
	
	public static void main(String[] args) {
		Handler h1 = new ConcreteHandlerA();
		Handler h2 = new ConcreteHandlerB();
		Handler h3 = new ConcreteHandlerC();
		
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);
		
		h1.handleRequest(25);
	}
}
