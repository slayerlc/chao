package com.designpattern.demo.singleton;

public class Singleton {

	private static Singleton instance;
	private static final Object readOnly = new Object();
	private Singleton() {

	}

	public static Singleton instance() {
		if(instance == null){
			synchronized (readOnly) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
