package com.designpattern.simplefactoryandstrategy;

public class Program {

	public static void main(String[] args) {
		
		double money =300;
		char type = 2;
		
		Context context = new Context(type);
		money = context.contextInterface(money);
		
		System.out.println(money);
	}
}
