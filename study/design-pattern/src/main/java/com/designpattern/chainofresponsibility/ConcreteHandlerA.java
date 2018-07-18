package com.designpattern.chainofresponsibility;

public class ConcreteHandlerA extends Handler{

	@Override
	public void handleRequest(int request) {
		if(1 < request && request < 10){
			System.out.println(this.getClass().getName()+"���������");
		}
		
		if(successor != null){
			successor.handleRequest(request);
		}
	}

}
