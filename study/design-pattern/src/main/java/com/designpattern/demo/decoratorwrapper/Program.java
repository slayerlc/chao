package com.designpattern.demo.decoratorwrapper;
/**
 * װ��ģʽ
 * @author JH
 *
 */
public class Program{
	public static void main(String[] args) {
		
		ConcreteComponent cc = new ConcreteComponent(); 
		ConcreteDecoratorA cda = new ConcreteDecoratorA();
		ConcreteDecoratorB cdb = new ConcreteDecoratorB();
		ConcreteDecoratorC cdc = new ConcreteDecoratorC();
		
		cda.SetComponent(cc);
		cdb.SetComponent(cda);
		cdc.SetComponent(cdb);
		
		cdc.Operation();
	}
}
