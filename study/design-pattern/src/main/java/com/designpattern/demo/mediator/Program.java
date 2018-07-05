package com.designpattern.demo.mediator;

public class Program {
	
	public static void main(String[] args) {
		ConcreteMediator m = new ConcreteMediator();
		
		ConcreteColleague1 c1 = new ConcreteColleague1(m);
		ConcreteColleague2 c2 = new ConcreteColleague2(m);
		
		m.setCc1(c1);
		m.setCc2(c2);
		
		c1.send("c2�Է�����");
		c2.send("���ˣ�");
		
	}
}