package com.designpattern.abstractfactory.concrete;


import com.designpattern.abstractfactory.entity.User;

public class AccessUser implements IUser{
	
	public void insertUser(User user){
		System.out.println("Access���ݿ�:����һ��User���ݣ�");
	}

	@Override
	public User getUser(Long id) {
		System.out.println("Access���ݿ�:���һ��User���ݣ�");
		return new User("Access");
	}
}
