package com.designpattern.demo.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate {
	
	private List<Object> items = new ArrayList<Object>();

	public Iterator CreateIterator() {
		return new ConcreteIterator(this);
	}
	
	public int count(){
		return items.size();
	}
	
	public Object get(int index){
		return items.get(index);
	}
	
	public void set(Object value){
		items.add(value);
	}

}
