package com.designpattern.demo.decoratorwrapper;

/**
 * װ���� ѡ����super.operation �൱�ڶ�component ���е���װ��
 * @author ����
 *
 */
public class ConcreteDecoratorA extends Decorator{

	@Override
	public void Operation() {
		System.out.println("����װ�ζ���A�Ĳ���");
		super.Operation();
	}
}
