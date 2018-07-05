package com.designpattern.demo.factory;

public class DivOperation extends Operation{
	
	@Override
	public double getResult() {
		return numberA/numberB;
	}

}
