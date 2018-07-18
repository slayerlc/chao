package com.designpattern.simplefactory;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("�������һ����");
		double num1 = input.nextDouble();
		
		System.out.println("�������������");
		String operator = input.next();

		System.out.println("������ڶ�����");
		double num2 = input.nextDouble();
		
		input.close();
		
		if (operator.length() <= 0) {
			return;
		}
		
		Operator oper = OperatorFactory.createOperator(operator.charAt(0));
		oper.setNum1(num1);
		oper.setNum2(num2);
		
		double result = oper.getResult();
		
		System.err.println(result);
	}
}
