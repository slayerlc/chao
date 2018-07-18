package com.designpattern.abstractfactory.concrete;


import com.designpattern.abstractfactory.entity.User;

public interface IUser {
	
	 void insertUser(User user);
	
	 User getUser(Long id);
}
