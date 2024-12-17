package kh;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== up down =====");
		Scanner sc = new Scanner(System.in);
		
		//set answer
		int answer = (int) (Math.random() * 50 + 1);
		
		boolean isOk = false;
		
		int cnt = 0;
		
		//user input
		while(!isOk) {
				
			int input = sc.nextInt();
			cnt++;
			
			//judge
			if(answer == input) {
				System.out.println("good !");
				isOk = true;
			}
			else if(input>answer){
				System.out.println("down");
			}
			else if(input<answer){
				System.out.println("up");
			}
		}
		
		System.out.println("시도 횟수 : " + cnt);
		
	}// main

}
