package com.designpattern.builderpattern;

import java.util.ArrayList;
import java.util.List;

public class Product {
	List<String> list = new ArrayList<String>();
	
	public void addPart(String part){
		list.add(part);
	}
	
	public void show(){
		for(String str : list){
			System.out.println(str);
		}
	}
}
