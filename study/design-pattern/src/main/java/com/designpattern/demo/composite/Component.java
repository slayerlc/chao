package com.designpattern.demo.composite;

public abstract class Component {
	
	protected String name;
	
	public Component(String name){
		this.name = name;
	}
	
	public abstract void add(Component c);
	public abstract void remove(Component c);
	public abstract void Display(int depth);
}
