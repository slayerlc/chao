package com.designpattern.simplefactoryandstrategy;

public class ConcreteStrategyNormal implements Strategy{
	
	@Override
	public double algoithmInterface(double money) {
		return money;
	}
}
