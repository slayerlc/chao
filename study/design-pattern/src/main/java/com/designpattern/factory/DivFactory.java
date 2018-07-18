package com.designpattern.factory;

public class DivFactory implements OperationFactory{

	@Override
	public Operation createOperation() {
		return new DivOperation();
	}

}
