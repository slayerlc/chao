package com.designpattern.demo.simplefactory;

public class OperatorAdd extends Operator{

	@Override
	public double getResult() {
		double result = getNum1() + getNum2();
		return result;
	}
}
