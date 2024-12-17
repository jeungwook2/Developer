package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main03Map {

	public static void main(String[] args) {

		Map<Integer, String> m = new HashMap<Integer, String>();
		
		m.put(0, "김");
		m.put(1, "나");
		m.put(2, "박");
		m.put(3, "이");
		
		System.out.println(m);
		
		Set<Integer> s = m.keySet();
		
		for(int x : s) {
			System.out.print(x+"=");
			String value = m.get(x);
			System.out.print(value+", ");
		}
	}

}