package kh;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 연산자 =====");
		
		/*
		 * <연산자>
		 * 
		 * [산술연산자] : 숫자 * 숫자 => 숫자
		 * +, -, *, /, %
		 * 
		 * [비교연산자] : 숫자 * 숫자 => 논리 (true, false)
		 * <, <=, >, >=, ==, !=
		 * 
		 * [논리연산자] : 논리 * 논리 => 논리
		 * &&, ||, !
		 * 
		 * [증감연산자] : 1증가, 1감소
		 * ++, -- 
		 * 전위증감(먼저), 후위증감(나중)
		 * 
		 * [복합연산자]
		 * +=, -=, *=, /=
		 * 
		 */

		boolean x = 10 != 20;
		System.out.println(x);
		
		boolean y = !false;
		System.out.println(y);
		
		boolean z = (1!=1) && (10>5);
		System.out.println(z);
		
		int a = 10;
		System.out.println(a++); // 후위증가라 출력값 10 그대로
		
		int b = 10;
		b += 3;
		System.out.println(b);
		
	}

}
