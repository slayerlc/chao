package com.designpattern.abstractfactory.factory;


import com.designpattern.abstractfactory.concrete.IUser;
import com.designpattern.abstractfactory.concrete.SqlserverUser;

public class SqlserverFactory implements IFactory{

	@Override
	public IUser createUser() {
		return new SqlserverUser();
	}


}
