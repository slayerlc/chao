package com.designpattern.chainofresponsibility;

public class ConcreteHandlerB extends Handler{

	@Override
	public void handleRequest(int request) {
		if(10 < request && request < 20){
			System.out.println(this.getClass().getName()+"���������");
		}
		
		if(successor != null){
			successor.handleRequest(request);
		}
	}

}
