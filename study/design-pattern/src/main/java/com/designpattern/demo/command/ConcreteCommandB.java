package com.designpattern.demo.command;

public class ConcreteCommandB extends Command{


	public ConcreteCommandB(Receiver receiver, String commandContent) {
		super(receiver, commandContent);
	}

	@Override
	public void execute() {
		receiver.action(commandContent);
	}
}
