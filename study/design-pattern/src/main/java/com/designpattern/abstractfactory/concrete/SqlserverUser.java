package com.designpattern.abstractfactory.concrete;


import com.designpattern.abstractfactory.entity.User;

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
