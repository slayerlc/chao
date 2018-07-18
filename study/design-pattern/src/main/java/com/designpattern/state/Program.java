package com.designpattern.state;
/**
 * ״̬ģʽ
 * @author JH
 *
 */
public class Program {
	public static void main(String[] args) {
		//��ʼ��״̬A
		Context context = new Context(new ConcreteStateA());
		
		context.request();
		
		context.request();
		
		context.request();
	}
}
