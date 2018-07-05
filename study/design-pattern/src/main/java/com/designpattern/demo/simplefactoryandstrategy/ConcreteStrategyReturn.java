package com.designpattern.demo.simplefactoryandstrategy;

public class ConcreteStrategyReturn implements Strategy{
	
	public double moneyCondition = 0.0;
	public double moneyReturn =0.0;
	
	public ConcreteStrategyReturn(double moneyCondition, double moneyReturn) {
		this.moneyCondition = moneyCondition;
		this.moneyReturn = moneyReturn;
	}

	@Override
	public double algoithmInterface(double money) {
		if(money>= moneyCondition){
			money = money - (money/moneyCondition)*moneyReturn;
		}
		return money;
	}
}
