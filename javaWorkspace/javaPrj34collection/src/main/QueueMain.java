package main;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

	public static void main(String[] args) {

		Queue x = new LinkedList();
		
		x.offer(10);
		x.offer(20);
		x.offer(30);
		
		System.out.println(x.poll());
		System.out.println(x.poll());
		System.out.println(x.poll());
	}

}
