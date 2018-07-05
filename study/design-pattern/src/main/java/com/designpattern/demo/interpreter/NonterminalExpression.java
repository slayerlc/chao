package com.designpattern.demo.interpreter;

public class NonterminalExpression implements Expression{

	@Override
	public void interpret(Context context) {
		System.out.println("���ն˽�����");
	}

}
