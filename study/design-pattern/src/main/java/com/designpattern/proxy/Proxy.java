package com.designpattern.proxy;

public class Proxy implements Subject {

	public Subject subject;
	
	@Override
	public void request() {
		System.out.println("�����Ǵ���������ķ��� �������� ������ִ��������Ҫִ�еķ���");
		if (subject == null) {
			subject = new RealSubject();
		}
		subject.request();
	}

}
