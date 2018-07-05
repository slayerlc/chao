package com.designpattern.demo.abstractfactory.concrete;


import com.designpattern.demo.abstractfactory.entity.User;

public class SqlserverUser implements IUser{

	@Override
	public void insertUser(User user) {
		System.out.println("Sqlserver���ݿ�:����һ��User����!");
	}

	@Override
	public User getUser(Long id) {
		System.out.println("Sqlserver���ݿ�:���һ��User����!");
		return new User("Sqlserver");
	}

}
