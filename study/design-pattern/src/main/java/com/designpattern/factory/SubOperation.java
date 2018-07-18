package com.designpattern.factory;

public class SubOperation extends Operation{
	
	@Override
	public double getResult() {
		return numberA - numberB;
	}
	
}
