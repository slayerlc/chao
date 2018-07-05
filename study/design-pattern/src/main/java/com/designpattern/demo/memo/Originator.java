package com.designpattern.demo.memo;

public class Originator {
	
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Memory createMemory(){
		return new Memory(state);
	}
	
	public void setMemory(Memory memory){
		this.state = memory.getState();
	}
	
	public void show(){
		System.out.println("CurrentState = "+state);
	}
	
}
