package com.designpattern.builderpattern;

public class Program {
	
	public static void main(String[] args) {
		Director director = new Director();
		
		Builder builderA = new ConcreteBuilderA();
		director.Constract(builderA);
		builderA.getProduct().show();
		
		
		Builder builderB = new ConcreteBuilderB();
		director.Constract(builderB);
		builderB.getProduct().show();
		
	}
}
