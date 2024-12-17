package kh;

import java.util.Scanner;

public class Hello {
	
	/*
	 * 메서드 : 명령어 묶음
	 * 
	 * [문법]
	 * 접근제한자 리턴타입 메서드명(매개변수){ 실행내용 }
	 * 
	 * [메소드명 작성 시 주의사항]
	 * - 메서드명은 동사 형태로 작성
	 * - 메서드명은 camelCase 로 작성
	 * - 메서드명은 의미있게 작성 (이름만 보고 내용을 파악할 수 있게)
	 * - 하나의 메서드는 하나의 동작만 가지는게 좋음
	 */
	
	Scanner sc = new Scanner(System.in);
	
	public void m01 () {
		System.out.println("m01 called...");
	}
	
	// 정수 10을 출력하는 메서드
	public void printTen() {
		System.out.println(10);
	}
	
	// 전달받은 숫자를 출력하는 메서드
	public void printNum(int num) {
		System.out.println(num);
	}
	
	// 숫자 3을 반환하는 메서드
	public int getThree() {
		return 3;
	}
	
	// 전달받은 숫자에 +1 하여 리턴하는 메서드
	public int getPlusOne(int x) {
		x++;
		return x;
	}
}
