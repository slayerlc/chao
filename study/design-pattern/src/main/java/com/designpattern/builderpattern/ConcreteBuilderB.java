package com.designpattern.builderpattern;

public class ConcreteBuilderB implements Builder{
	
	private Product product =  new Product();

	@Override
	public void part1() {
		product.addPart("B����1");
	}

	@Override
	public void part2() {
		product.addPart("B����2");
	}

	@Override
	public void part3() {
		product.addPart("B����3");
	}

	@Override
	public void part4() {
		product.addPart("B����4");
	}

	@Override
	public Product getProduct() {
		return product;
	}
}
