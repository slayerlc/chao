package com.designpattern.demo.flyweight;

public class UnsharedConcreteFlyWeight implements FlyWeight{

	@Override
	public void operation(int extrinsicState) {
		System.out.println("������ľ���flyweight:"+extrinsicState);
	}

}
