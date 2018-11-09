package com.designpattern.decoratorwrapper;

public class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Component component) {
        super.setComponent(component);
    }

	@Override
	public void operation() {
		System.out.println("b");
		super.operation();
	}
	
}
