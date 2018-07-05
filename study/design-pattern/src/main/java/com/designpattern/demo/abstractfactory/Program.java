package com.designpattern.demo.abstractfactory;

import abstractfactory.concrete.IUser;
import abstractfactory.entity.User;
import abstractfactory.factory.AccessFactory;
import abstractfactory.factory.IFactory;
import abstractfactory.factory.SqlserverFactory;

public class Program {
	
	public static void main(String[] args) {
		IFactory accessFactory = new AccessFactory(); 
		
		IUser accessUser = accessFactory.createUser();
		
		accessUser.insertUser(new User());
		accessUser.getUser(1L);
		
		
		IFactory sqlserverFactory = new SqlserverFactory(); 
		
		IUser sqlserverUser = sqlserverFactory.createUser();
		
		sqlserverUser.insertUser(new User());
		sqlserverUser.getUser(1L);
	}
}
