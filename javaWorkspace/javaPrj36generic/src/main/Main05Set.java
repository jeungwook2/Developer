package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main05Set {

	public static void main(String[] args) {

		//Set 타입의 객체 생성 // 정수만 받을 예정
		Set<Integer> s = new HashSet<Integer>();
		
		//데이터 3개 넣기
		s.add(10);
		s.add(20);
		s.add(30);
		
		//모든 데이터 출력
		for(int x : s) {
			System.out.println(x);
		}
//		Iterator<Integer> iter = s.iterator();
//		while(iter.hasNext()) {
//			Integer token = iter.next();
//			System.out.println(token);
//		}
	}

}
