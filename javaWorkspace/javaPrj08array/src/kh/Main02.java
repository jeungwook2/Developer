package kh;

public class Main02 {

	public static void main(String[] args) {

		// 정수 5개를 담을 수 있는 배열 만들기
		int[] x = new int[5];
		
		// 배열의 각 칸에 숫자 10, 20, 30, 40, 50 넣기
		for(int n=0; n<5; n++) {
			x[n] = (n+1) * 10;
		}
		
		// 배열의 모든 칸의 값을 출력해보기
		for(int n=0; n<x.length; n++) {
			System.out.println(x[n]);
		}
				
	}

}
