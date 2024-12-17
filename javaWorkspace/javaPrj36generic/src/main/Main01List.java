package main;

import java.util.ArrayList;
import java.util.List;

public class Main01List {

	public static void main(String[] args) {

		// 리스트 타입의 객체 생성
		List<Integer> x = new ArrayList<Integer>();
		
		// 리스트에 데이터 3개 넣기
		x.add(10);
		x.add(20);
		x.add(30);
		
		// 리스트의 모든 데이터 출력
		int data = x.get(0);
		System.out.println(data);
		
	}

}
