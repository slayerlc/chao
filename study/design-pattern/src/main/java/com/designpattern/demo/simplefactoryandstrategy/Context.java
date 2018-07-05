package com.designpattern.demo.simplefactoryandstrategy;

public class Context {
	
	public Strategy strategy;
	
	public Context(char type) {
		
		switch (type) {
		case 0:
			strategy = new ConcreteStrategyNormal();
			break;
		case 1:
			strategy = new ConcreteStrategyRebate(0.8);
			break;
		case 2:
			strategy = new ConcreteStrategyReturn(300,100);
			break;
		}
	}

	public double contextInterface(double money){
		return strategy.algoithmInterface(money);
	}
}
