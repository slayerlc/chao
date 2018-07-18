package com.designpattern.flyweight;

import java.util.Hashtable;

public class FlyWeightFactory {

	private Hashtable<String,FlyWeight> flyweight = new Hashtable<String,FlyWeight>();
	
	public FlyWeightFactory(){
		flyweight.put("X",new ConcreteFlyWeight());
		flyweight.put("Y",new ConcreteFlyWeight());
		flyweight.put("Z",new ConcreteFlyWeight());
	}
	
	public FlyWeight getFlyWeight(String key){
		return flyweight.get(key);
	}
}
