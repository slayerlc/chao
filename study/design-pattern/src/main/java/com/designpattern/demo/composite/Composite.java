package com.designpattern.demo.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * �����������ʾ֧�ڵ�
 * @author JH
 *
 */
public class Composite extends Component{

	List<Component> children = new ArrayList<Component>();
	
	public Composite(String name) {
		super(name);
	}

	@Override
	public void add(Component c) {
		children.add(c);
	}

	@Override
	public void remove(Component c) {
		children.remove(c);
		
	}

	@Override
	public void Display(int depth) {
		String s = "-";
		for(int i=0; i<depth; i++){
			s=s+"-";
		}
		System.out.println(s+name);
		for(Component c : children){
			c.Display(depth+1);
		}
	}
}
