package com.designpattern.abstractfactory.factory;


import com.designpattern.abstractfactory.concrete.IUser;

public interface IFactory {
	
	 IUser createUser();
}
