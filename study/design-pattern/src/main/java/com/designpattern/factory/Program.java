package com.designpattern.factory;

public class Program {
	
	public static void main(String[] args) {
		OperationFactory operationFactory= new AddFactory();
		Operation operation = operationFactory.createOperation();
		operation.numberA = 1;
		operation.numberB = 2;
		System.out.println(operation.getResult());
	}
}
