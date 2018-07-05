package com.designpattern.demo.templet;

public abstract class Paper {
	//��Ŀ1
	public void testQuestion1(){
		System.out.println("��Ŀ1 a, b, c, d");
		System.out.println("��:"+getAnswer1());
	}

	//��Ŀ2
	public void testQuestion2(){
		System.out.println("��Ŀ2 a,b,c,d");
		System.out.println("��:"+getAnswer2());
	}
	//��Ŀ3
	public void testQuestion3(){
		System.out.println("��Ŀ3 a,b,c,d");
		System.out.println("��:"+getAnswer3());
	}
	
	public abstract String getAnswer1();	
	
	public abstract String getAnswer2();
	
	public abstract String getAnswer3();
	
}
