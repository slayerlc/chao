package com.designpattern.chainofresponsibility;

public class ConcreteHandlerC extends Handler{

	@Override
	public void handleRequest(int request) {
		if(20 < request && request < 30){
			System.out.println(this.getClass().getName()+"���������");
		}
		
		if(successor != null){
			successor.handleRequest(request);
		}
	}

}
