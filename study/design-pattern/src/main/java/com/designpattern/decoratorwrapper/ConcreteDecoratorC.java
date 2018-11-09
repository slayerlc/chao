package com.designpattern.decoratorwrapper;

public class ConcreteDecoratorC extends Decorator{

    public ConcreteDecoratorC(Component component) {
        super.setComponent(component);
    }

    @Override
	public void operation() {
		System.out.println("c");
		super.operation();
	}

}
