package main;

import java.util.ArrayList;
import java.util.List;

public class Main01List {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<5; i++) {
			list.add(10);
		}
		
		for(int i=0; i<list.size(); i++) {
			Object num = list.get(i);
			System.out.println(num);
		}
		
	}

}
