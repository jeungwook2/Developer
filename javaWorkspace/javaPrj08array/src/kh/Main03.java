package kh;

import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n+1]; // 일부로 한칸 늘림
		
		for(int i = 0; i < n - 1; i++) {
			int num = sc.nextInt();
			arr[num] = 1;
		}
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == 0) {
				System.out.println(i);
			}
		}
	
	}	
		
}