package main;

import java.util.ArrayList;

public class ListMain {

	public static void main(String[] args) {
	
		ArrayList x = new ArrayList();
		x.add(new Integer(10));
		x.add(10);
		x.add("abc");
		x.add(3.14);
		x.add(true);
		x.add('A');
		
//		x.remove(2);
//		
//		x.set(0, 777);
//		
//		x.clear();
//		System.out.println(x.indexOf(50));
		
		System.out.println(x.get(0));
		System.out.println(x.get(1));
		System.out.println(x.get(2));
		System.out.println(x.get(3));
		System.out.println(x.get(4));
	}

}
