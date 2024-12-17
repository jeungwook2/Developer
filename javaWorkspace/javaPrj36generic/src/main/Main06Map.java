package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main06Map {

	public static void main(String[] args) {

		Map<String, Integer> m = new HashMap<String, Integer>();
		
		m.put("apple", 10);
		m.put("strawberry", 10);
		m.put("banana", 10);
		
		Set<String> s = m.keySet();
		
		for(String x : s) {
			System.out.println(x);
			Integer value = m.get(x);
			System.out.println(value);
		}
	}

}
