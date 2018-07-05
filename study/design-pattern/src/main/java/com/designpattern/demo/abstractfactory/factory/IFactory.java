package com.designpattern.demo.abstractfactory.factory;

import abstractfactory.concrete.IUser;

public interface IFactory {
	
	public IUser createUser();
}
