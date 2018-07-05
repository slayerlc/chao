package com.designpattern.demo.factory;

public class SubFactory implements OperationFactory{

	@Override
	public Operation createOperation() {
		return new SubOperation();
	}

}
