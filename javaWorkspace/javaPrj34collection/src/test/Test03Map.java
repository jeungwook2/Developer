package test;

import java.util.HashMap;
import java.util.Map;

public class Test03Map {

	public static void main(String[] args) {

		// Map 타입 객체 만들기
		Map x = new HashMap();
		
		// 키 : 과일이름, 밸류 : 과일갯수
		x.put("사과", 10);
		x.put("모과", 5);
		x.put("약과", 30);
		
		// 특정 과일이 몇개 남았는지 확인해보기
		System.out.println(x.get("모과"));
		
		// 특정 과일의 갯수를 777로 바꾸기
		x.put("모과", 777);
		
		// 맵의 모든 요소 갯수 출력
		System.out.println(x.size());
		
		// "사과" 이라는 키가 존재하는지 확인하기
		System.out.println(x.containsKey("사과"));
		
		// 맵의 모든 요소 출력
		System.out.println(x);
		
		// 모든 요소 삭제
		x.clear();
		
		// 맵이 비었는지 확인하기
		System.out.println(x.isEmpty());
	}

}
