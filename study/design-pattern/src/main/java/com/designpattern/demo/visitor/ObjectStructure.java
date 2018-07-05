package com.designpattern.demo.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
	private List<Element> list = new ArrayList<Element>();
	
	public void attach(Element element){
		list.add(element);
	}
	
	public void detach(Element element){
		list.remove(element);
	}
	
	public void Accept(Visitor visitor){
		for(Element e : list){
			e.accept(visitor);
		}
	}
}
