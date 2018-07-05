package com.designpattern.demo.abstractfactory.factory;

import abstractfactory.concrete.IUser;
import abstractfactory.concrete.SqlserverUser;

public class SqlserverFactory implements IFactory{

	@Override
	public IUser createUser() {
		return new SqlserverUser();
	}


}
