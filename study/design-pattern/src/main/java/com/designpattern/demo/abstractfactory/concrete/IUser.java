package com.designpattern.demo.abstractfactory.concrete;


import com.designpattern.demo.abstractfactory.entity.User;

public interface IUser {
	
	public void insertUser(User user);
	
	public User getUser(Long id);
}
