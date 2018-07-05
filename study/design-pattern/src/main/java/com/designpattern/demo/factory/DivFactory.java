package com.designpattern.demo.factory;

public class DivFactory implements OperationFactory{

	@Override
	public Operation createOperation() {
		return new DivOperation();
	}

}
