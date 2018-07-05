package com.designpattern.demo.strategy;

public class Program {

	public static void main(String[] args) {
		
		Context context = null;
		double money =300;
		char type = 2;
		
		switch (type) {
		case 0:
			context = new Context(new ConcreteStrategyNormal());
			break;
		case 1:
			context = new Context(new ConcreteStrategyRebate(0.8));
			break;
		case 2:
			context = new Context(new ConcreteStrategyReturn(300,100));
			break;
		}
		money = context.contextInterface(money);
		System.out.println(money);
	}
}
