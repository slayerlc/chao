package com.designpattern.strategy;


public class ConcreteStrategyNormal implements Strategy{
	
	@Override
	public double algoithmInterface(double money) {
		return money;
	}
}
