package kh;

import java.util.Scanner;

public class Calc {
	
	int a;
	int b;
	int result;
	String str;
	// 3가지 한번에 실행하는 메서드
	public void startCalc() {
		scanData();
		calcData();
		printResult();
	}
	
	// 정수, 문자열, 정수 입력받기
	public void scanData() {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		sc.nextLine();
		str = sc.nextLine();
		b = sc.nextInt();
		sc.nextLine();
		
//		calcData(a, b, str);
	}
	
	// 계산하기
	public void calcData() {
		result = 0;
		switch(str) {
		case "+" : result = a+b; break;
		case "-" : result = a-b; break;
		case "*" : result = a*b; break;
		case "/" : result = a/b; break;
		case "%" : result = a%b; break;
		default : System.out.println("잘못된 연산자 입니다.");
		}
		
//		printResult(a, b, str, result);
	}
	
	// 결과 출력하기
	public void printResult() {
		System.out.println(a + str + b + " = " + result);	
		
	}
}
