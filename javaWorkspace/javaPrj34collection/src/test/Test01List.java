package test;

import java.util.ArrayList;
import java.util.List;

public class Test01List {

	public static void main(String[] args) {

		// 리스트 타입의 객체 만들기
		List x = new ArrayList();
		
		// 좋아하는 과일 3개 집어넣기
		x.add("포도");
		x.add("딸기");
		x.add("복숭아");

		// 두번째로 집어넣은 과일 출력해보기
		System.out.println(x.get(1));
		
		// 마지막으로 집어넣은 과일 두리안으로 바꾸기
		int idx = x.size() - 1;
		x.set(idx, "두리안");
		
		// 요소가 총 몇개인지 확인해보기
		System.out.println(x.size());
		
		// 요소 중 토마토 포함되어있는지 확인해보기
		boolean result = x.contains("토마토");
		System.out.println(result);
		
		// 요소 중 두리안은 몇번째 인덱스에 있는지 출력
		System.out.println(x.indexOf("두리안"));
		
		// 요소 전부 삭제하기
		x.clear();
	}

}
