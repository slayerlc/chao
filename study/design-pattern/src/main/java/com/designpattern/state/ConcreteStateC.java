package com.designpattern.state;

public class ConcreteStateC implements State{

	@Override
	public void handle(Context context) {
		System.out.println("����������ó�A״̬");
		context.setState(new ConcreteStateA());
	}

}
