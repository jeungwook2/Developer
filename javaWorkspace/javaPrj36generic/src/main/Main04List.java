package main;

import java.util.ArrayList;
import java.util.List;

public class Main04List {

	public static void main(String[] args) {
		
		// 리스트 타입 객체 생성
		List<Integer> list = new ArrayList<Integer>();
		
		// 데이터(정수) 3개 넣기
		list.add(10);
		list.add(20);
		list.add(30);
		
		// 데이터 하나씩 꺼내서 변수에 담고 출력
		for(int i=0; i<list.size(); i++) {
			int data = list.get(i);
			System.out.println(data);
		}
		
		for(int data : list) {
			System.out.println(data);
		}
	}

}
