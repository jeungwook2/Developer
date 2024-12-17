package main;

import java.util.HashMap;

public class MapMain {

	public static void main(String[] args) {

		HashMap x = new HashMap();
		
		x.put("one", "apple");
		x.put("two", "banana");
		x.put("three", "orange");
		
		System.out.println( x.get("one") );
		
	}

}
