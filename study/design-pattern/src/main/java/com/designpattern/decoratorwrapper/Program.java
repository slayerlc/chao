package com.designpattern.decoratorwrapper;
/**
 * װ��ģʽ
 * @author JH
 *
 */
public class Program{
	public static void main(String[] args) {
		
		ConcreteComponent cc = new ConcreteComponent(); 
		ConcreteDecoratorA cda = new ConcreteDecoratorA(cc);
		ConcreteDecoratorB cdb = new ConcreteDecoratorB(cda);
		ConcreteDecoratorC cdc = new ConcreteDecoratorC(cdb);
		
	/*	cda.SetComponent(cc);
		cdb.SetComponent(cda);
		cdc.SetComponent(cdb);*/
		
		cdc.operation();
	}
}
