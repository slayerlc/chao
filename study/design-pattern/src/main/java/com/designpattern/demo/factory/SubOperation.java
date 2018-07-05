package com.designpattern.demo.factory;

public class SubOperation extends Operation{
	
	@Override
	public double getResult() {
		return numberA - numberB;
	}
	
}
