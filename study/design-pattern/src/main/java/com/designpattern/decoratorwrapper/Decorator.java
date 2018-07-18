package com.designpattern.decoratorwrapper;

public abstract class Decorator implements Component {
	public Component component;

	public void SetComponent(Component component) {
		this.component = component;
	}

	public void Operation() {
		if (component != null) {
			component.Operation();
		}
	}
}
