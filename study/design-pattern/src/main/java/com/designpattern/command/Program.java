package com.designpattern.command;

public class Program {
	
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command commandA = new ConcreteCommandA(receiver,"����A");
		Command commandB = new ConcreteCommandB(receiver,"����B");
		Invoker i = new Invoker();
		
		i.setCommand(commandA);
		i.setCommand(commandB);
		
		i.cancleCommand(commandA);
		
		i.executeCommand();
	}
}
