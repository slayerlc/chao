package com.designpattern.strategy;

public class Context {
	
	public Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public double contextInterface(double money){
		return strategy.algoithmInterface(money);
	}
}
