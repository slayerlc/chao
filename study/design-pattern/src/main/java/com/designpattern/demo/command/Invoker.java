package com.designpattern.demo.command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	private List<Command> commandList = new ArrayList<Command>();
	
	public void setCommand(Command command){
		commandList.add(command);
	}
	
	public void executeCommand(){
		for(Command c : commandList){
			c.execute();
		}
	}
	
	public void cancleCommand(Command command){
		commandList.remove(command);
	}
}
