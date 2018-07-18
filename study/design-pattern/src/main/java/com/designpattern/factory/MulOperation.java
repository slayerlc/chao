package com.designpattern.factory;

public class MulOperation extends Operation{
	
	@Override
	public double getResult() {
		return numberA*numberB;
	}

}
