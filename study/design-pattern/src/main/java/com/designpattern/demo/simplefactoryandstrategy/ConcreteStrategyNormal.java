package com.designpattern.demo.simplefactoryandstrategy;

public class ConcreteStrategyNormal implements Strategy{
	
	@Override
	public double algoithmInterface(double money) {
		return money;
	}
}
