package com.designpattern.command;

public class ConcreteCommandA extends Command{


	public ConcreteCommandA(Receiver receiver, String commandContent) {
		super(receiver, commandContent);
	}

	@Override
	public void execute() {
		receiver.action(commandContent);
	}

}
