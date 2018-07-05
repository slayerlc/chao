package com.designpattern.demo.abstractfactory.factory;

import abstractfactory.concrete.AccessUser;
import abstractfactory.concrete.IUser;

public class AccessFactory implements IFactory{

	@Override
	public IUser createUser() {
		return new AccessUser();
	}


}
