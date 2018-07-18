package com.designpattern.abstractfactory;


import com.designpattern.abstractfactory.concrete.IUser;
import com.designpattern.abstractfactory.entity.User;
import com.designpattern.abstractfactory.factory.AccessFactory;
import com.designpattern.abstractfactory.factory.IFactory;
import com.designpattern.abstractfactory.factory.SqlserverFactory;

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
