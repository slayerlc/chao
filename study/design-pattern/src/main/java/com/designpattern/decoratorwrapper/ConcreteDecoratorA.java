package com.designpattern.decoratorwrapper;

/**
 * װ���� ѡ����super.operation �൱�ڶ�component ���е���װ��
 * @author ����
 *
 */
public class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Component component) {
        super.setComponent(component);
    }

	@Override
	public void operation() {
		System.out.println("a");
		super.operation();
	}
}
