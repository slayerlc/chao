package com.designpattern.demo.flyweight;

public class ConcreteFlyWeight implements FlyWeight{

	@Override
	public void operation(int extrinsicState) {
		System.out.println("�����flyweight:"+extrinsicState);
	}

}
