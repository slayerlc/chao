package com.designpattern.demo.flyweight;
/**
 * �������ʹ�õĴ����Ķ��� ����Щ�����Ķ�������� �洢��������~ 
 * ����Χ�� �������ӵĶ�����ȫ����ֻҪ2�� ��~  ���ӵ����� ������Ϊ���ӵ��ⲿ״̬   
 * �����Ͳ��� ���������� һ������һ����ɫ�� ���Ӷ���
 * @author JH
 *
 */
public class Program {
	
	public static void main(String[] args) {
		int extrinsicState = 22;
		
		FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
		
		FlyWeight x = flyWeightFactory.getFlyWeight("X");
		x.operation(--extrinsicState);
		
		FlyWeight y = flyWeightFactory.getFlyWeight("Y");
		y.operation(--extrinsicState);
		
		FlyWeight z = flyWeightFactory.getFlyWeight("Z");
		z.operation(--extrinsicState);
		
		UnsharedConcreteFlyWeight un = new UnsharedConcreteFlyWeight();
		un.operation(--extrinsicState);
	}
}
