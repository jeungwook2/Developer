package kh;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("업다운 게임 ~~~(1~50 사이의 숫자 맞추기)");
		
		//정답 숫자
		int answer = 25;
		boolean x=true;
		
		while(x) {
		
			//유저가 정답 입력하기
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
		
			//정답인지 업인지 다운인지 판단
			if(num==25) {
				System.out.println("정답!");
				x=false;
			}
			else if(num>25) {
				System.out.println("다운!");
			}
			else {
				System.out.println("업!");
			}
		}
	}

}
