package com.designpattern.demo.command;

public abstract class Command {
	
	protected Receiver receiver;
	protected String commandContent;
	
	public Command(Receiver receiver,String commandContent){
		this.receiver = receiver;
		this.commandContent = commandContent;
	}
	
	public abstract void execute();
}
