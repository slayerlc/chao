package com.designpattern.memo;

public class Program {
	public static void main(String[] args) {
		
		Originator originator = new Originator();
		originator.setState("on");
		originator.show();
		
		Caretaker caretaker = new Caretaker();
		caretaker.setMemory(originator.createMemory());
		
		originator.setState("off");
		originator.show();
		
		originator.setMemory(caretaker.getMemory());
		originator.show();
	}
}
