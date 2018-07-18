package com.designpattern.singleton;

public class Program {
	public static void main(String[] args) {
		Singleton s1 = Singleton.instance();
		Singleton s2 = Singleton.instance();
		System.out.println(s1 == s2);
	}
}
