package main;

import java.util.HashSet;
import java.util.Set;

public class Main02Set {

	public static void main(String[] args) {

		//Set 타입의 객체 생성
		Set s = new HashSet();
		
		//데이터 3개 집어넣기 (중복된 데이터 넣어보기)
		s.add(10);
		s.add(20);
		s.add(10);
		
		//모든 데이터 출력
		System.out.println(s);
		
	}

}
