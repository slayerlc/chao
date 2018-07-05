package com.designpattern.demo.iterator;

public class Program {
	
	public static void main(String[] args) {
		ConcreteAggregate ca = new ConcreteAggregate();
		ca.set("lc0");
		ca.set("lc1");
		ca.set("lc2");
		ca.set("lc4");
		ca.set("lc5");
		ca.set("lc7");
		Iterator i = new ConcreteIterator(ca);
		System.out.println(i.first());
		while(!i.isDone()){
			System.out.println(i.currentItem());
			i.next();
		}
	}
}
