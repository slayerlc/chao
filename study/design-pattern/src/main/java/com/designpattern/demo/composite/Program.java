package com.designpattern.demo.composite;

/**
 * ���ģʽ
 * @author JH
 *
 */
public class Program {
	
	public static void main(String[] args) {
		Component root = new Composite("root");
		root.add(new Leaf("Leaf A"));
		root.add(new Leaf("Leaf B"));
		
		Component c1 = new Composite("c1");
		root.add(c1);
		c1.add(new Leaf("Leaf C"));
		c1.add(new Leaf("Leaf D"));
		
		Component c2 = new Composite("c2");
		c1.add(c2);
		c2.add(new Leaf("Leaf E"));
		
		Leaf f = new Leaf("F");
		root.add(f);
		root.remove(f);
		
		root.Display(0);
	}
}
