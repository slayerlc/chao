package com.designpattern.builderpattern;

public class ConcreteBuilderA implements Builder{
	
	private Product product =  new Product();

	@Override
	public void part1() {
		product.addPart("A����1");
	}

	@Override
	public void part2() {
		product.addPart("A����2");
	}

	@Override
	public void part3() {
		product.addPart("A����3");
	}

	@Override
	public void part4() {
		product.addPart("A����4");
	}

	@Override
	public Product getProduct() {
		return product;
	}
	
}
