package com.designpattern.demo.interpreter;

import java.util.ArrayList;
import java.util.List;

public class Program {
	
	public static void main(String[] args) {
		
		Context context = new Context();
		List<Expression> list = new ArrayList<Expression>();
		list.add(new TerminalExpression());
		list.add(new NonterminalExpression());
		list.add(new TerminalExpression());
		list.add(new TerminalExpression());
		list.add(new NonterminalExpression());
		
		for(Expression e : list){
			e.interpret(context);
		}
	}
}
