package com.designpattern.simplefactory;

public class OperatorDiv extends Operator{

	@Override
	public double getResult() {
		double result = getNum1() / getNum2();
		return result;
	}

	
}
