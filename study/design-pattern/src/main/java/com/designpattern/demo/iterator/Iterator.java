package com.designpattern.demo.iterator;

public interface Iterator {
	
	public Object first();

	public Object next();

	public boolean isDone();

	public Object currentItem();
}
