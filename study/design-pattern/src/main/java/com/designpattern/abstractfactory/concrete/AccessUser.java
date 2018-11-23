package com.designpattern.abstractfactory.concrete;


import com.designpattern.abstractfactory.entity.User;

public class AccessUser implements IUser{
	
	public void insertUser(User user){
		System.out.println("insertUser");
	}

	@Override
	public User getUser(Long id) {
		System.out.println("AccessUser");
		return new User("Access");
	}
}
