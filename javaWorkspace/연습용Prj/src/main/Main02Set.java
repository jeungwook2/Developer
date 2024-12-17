package main;

import java.util.HashSet;
import java.util.Set;

public class Main02Set {

	public static void main(String[] args) {

		int num = 1;
		Set<String> s = new HashSet<String>();
		
		for(int i=0; i<10; i++) {
			s.add(num + "");
			num++;
		}
		
		System.out.println(s);
		
		for(String x : s) {
			System.out.print(x+" ");
		}
	}

}
