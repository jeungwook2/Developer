package kh;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== 조건문 =====");
		
		/*
		 * if, else, else if
		 * 
		 * [문법]
		 * if(조건식){실행내용}
		 * else if(조건식){실행내용} // else if 여러개 올 수 있음
		 * else {실행내용}
		 * 
		 */
		
		int num = 0;
		
		if(num>0) {
			System.out.println("양수입니다.");
		}
		else if(num==0) {
			System.out.println("ZERO");
		}
		else {
			System.out.println("음수입니다.");
		}
		
		
	}

}
