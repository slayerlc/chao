package com.designpattern.demo.adapter;

public class Program {
	
	public static void main(String[] args) {
		Target target = new Adapter();
		target.request();
	}
}
