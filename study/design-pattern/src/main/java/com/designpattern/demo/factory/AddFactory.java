package com.designpattern.demo.factory;

public class AddFactory implements OperationFactory{

	@Override
	public Operation createOperation() {
		return new AddOperation();
	}
}
