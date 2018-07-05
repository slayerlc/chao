package com.designpattern.demo.mediator;

public class ConcreteMediator extends Mediator{
	
	private ConcreteColleague1 cc1;
	
	private ConcreteColleague2 cc2;
	
	public void setCc1(ConcreteColleague1 cc1) {
		this.cc1 = cc1;
	}

	public void setCc2(ConcreteColleague2 cc2) {
		this.cc2 = cc2;
	}

	@Override
	public void send(String message, Colleague colleague) {
		if(colleague == cc1){
			cc2.inform(message);
		}else{
			cc1.inform(message);
		}
	}

}
