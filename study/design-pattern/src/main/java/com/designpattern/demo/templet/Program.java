package com.designpattern.demo.templet;

public class Program {
	
	public static void main(String args[]){
		System.out.println("ѧ��A���Ծ�");
		Paper testPaperA = new TestPaperA();
		testPaperA.testQuestion1();
		testPaperA.testQuestion2();
		testPaperA.testQuestion3();
		
		System.out.println("ѧ��B���Ծ�");
		Paper testPaperB = new TestPaperB();
		testPaperB.testQuestion1();
		testPaperB.testQuestion2();
		testPaperB.testQuestion3();
	}
}
