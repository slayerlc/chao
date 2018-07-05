package com.designpattern.demo.factory;

public class MulOperation extends Operation{
	
	@Override
	public double getResult() {
		return numberA*numberB;
	}

}
