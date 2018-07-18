package com.designpattern.simplefactory;

public class OperatorMul extends Operator{

	@Override
	public double getResult() {
		double result = getNum1() * getNum2();
		return result;
	}

}
