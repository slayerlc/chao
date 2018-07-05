package com.designpattern.demo.builderpattern;

public interface Builder {
	
	public abstract void part1();
	public abstract void part2();
	public abstract void part3();
	public abstract void part4();
	public Product getProduct();
}
