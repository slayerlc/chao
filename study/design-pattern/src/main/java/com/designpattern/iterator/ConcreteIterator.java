package com.designpattern.iterator;

public class ConcreteIterator implements Iterator {

	private ConcreteAggregate ca; 
	private int current;
			
	public ConcreteIterator(ConcreteAggregate aggregate){
		this.ca = aggregate;
	}
			
	@Override
	public Object first() {
		return ca.get(0);
	}

	@Override
	public Object next() {
		Object obj = null;
		current++;
		if(current < ca.count()){
			obj =  ca.get(current);
		}
		return obj;
	}

	@Override
	public boolean isDone() {
		return current >= ca.count()? true : false;
	}

	@Override
	public Object currentItem() {
		return ca.get(current);
	}

}
