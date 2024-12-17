package main;

import java.util.HashMap;
import java.util.Map;

public class Main03Map {

	public static void main(String[] args) {

		//Map 타입의 객체 생성
		Map<String, String> m = new HashMap<String, String>();
		//데이터 3쌍(k-v) 집어넣기
		m.put("one", "apple");
		m.put("two", "orange");
		m.put("three", "grape");
		
		//모든 데이터 확인
		System.out.println(m);
	}

}
