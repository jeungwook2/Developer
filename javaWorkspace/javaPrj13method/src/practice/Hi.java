package practice;

import java.util.Scanner;

public class Hi {
	
	// 입력만 있는 메서드
	public void plusXy(int x, int y) {
		System.out.println(x+y);
	}
	
	// 반환만 있는 메서드(입력받은 문자열을 반환하는 메서드)
	public String returnStr() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	// 입력 반환 둘다 있는 메서드
	public String inReturnStr(String str){
		return str;
	}
	
	// 입력 반환 둘다 있는 메서드2
	public double cal(double a, double b) {
		System.out.println("연산자를 선택하세요. +, -, *, /, %");
		Scanner sc = new Scanner(System.in);
		char sign = sc.next().charAt(0);
		double res = 0;
		if(sign == '+') {
			 res = a + b;
		}else if(sign == '-') {
			res = a - b;
		}else if(sign == '*') {
			res = a * b;
		}else if(sign == '/') {
			res = a / b;
		}else if(sign == '%') {
			res = a % b;
		}
		return res;
		
	}
	
	// 매개변수 여러개 설정
	public void m01(int a, String b, double c, boolean isOk, char ch) {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	// 리턴 값 다양하게
	public int m02() {
		if(true) {
			return 10;
		}
		else {
			return 20;
		}
	}
}
