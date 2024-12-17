package main;

import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {

		Stack x = new Stack();

		x.add(10);
		x.add(20);
		x.add(30);

		System.out.println(x);
		
		System.out.println(x.pop());
		System.out.println(x.pop());
		System.out.println(x.pop());
		
		System.out.println(x);
	}

}
