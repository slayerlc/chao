package com.designpattern.demo.state;

public class ConcreteStateA implements State {

	@Override
	public void handle(Context context) {
		context.setState(new ConcreteStateB());
	}


}
