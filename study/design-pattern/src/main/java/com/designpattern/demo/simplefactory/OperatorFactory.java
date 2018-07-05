package com.designpattern.demo.simplefactory;

public class OperatorFactory {

	public static Operator createOperator(char operator) {
		
		Operator oper = null;
		
		switch (operator) {
		case '+':
			oper = new OperatorAdd();
			break;
		case '-':
			oper = new OperatorSub();
			break;
		case '*':
			oper = new OperatorMul();
			break;
		case '/':
			oper = new OperatorDiv();
			break;
		default:
			oper = new Operator();
			break;
		}
		return oper;
	}
}
