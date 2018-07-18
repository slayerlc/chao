package com.designpattern.factory;

public class MulFactory implements OperationFactory{

	@Override
	public Operation createOperation() {
		return new MulOperation();
	}

}
