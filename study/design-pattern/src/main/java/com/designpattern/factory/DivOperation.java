package com.designpattern.factory;

public class DivOperation extends Operation{
	
	@Override
	public double getResult() {
		return numberA/numberB;
	}

}
