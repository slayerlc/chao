package com.designpattern.abstractfactory.factory;


import com.designpattern.abstractfactory.concrete.AccessUser;
import com.designpattern.abstractfactory.concrete.IUser;

public class AccessFactory implements IFactory{

	@Override
	public IUser createUser() {
		return new AccessUser();
	}


}
