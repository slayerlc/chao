package com.designpattern.interpreter;

public class TerminalExpression implements Expression{

	@Override
	public void interpret(Context context) {
		System.out.println("�ն˽�����");
	}

}
