package com.designpattern.demo.simplefactoryandstrategy;

public class ConcreteStrategyRebate implements Strategy {
	
	public double rebate = 1;
	
	public ConcreteStrategyRebate(double rebate) {
		this.rebate = rebate;
	}

	@Override
	public double algoithmInterface(double money) {
		return money*rebate;
	}


}
