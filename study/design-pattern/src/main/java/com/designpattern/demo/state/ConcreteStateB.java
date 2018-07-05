package com.designpattern.demo.state;

public class ConcreteStateB implements State{

	@Override
	public void handle(Context context) {
		context.setState(new ConcreteStateC());
	}

}
