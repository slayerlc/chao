package com.designpattern.demo.adapter;

public class Adapter extends Target{
	
	private Adaptee adaptee = new Adaptee();
	
	public void request(){
		adaptee.specifyRequest();
	}

}
