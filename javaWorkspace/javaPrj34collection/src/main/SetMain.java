package main;

import java.util.HashSet;

public class SetMain {

	public static void main(String[] args) {

		HashSet x = new HashSet();
		
		x.add(10);
		x.add(20);
		x.add(30);
		x.add(30);
		x.add(30);
		
		System.out.println(x.size());
		
	}

}
