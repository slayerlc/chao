package com.designpattern.decoratorwrapper;

public abstract class Decorator implements Component {
	public Component component;

	public void setComponent(Component component) {
		this.component = component;
	}

	public void operation() {
		if (component != null) {
			component.operation();
		}
	}
}
