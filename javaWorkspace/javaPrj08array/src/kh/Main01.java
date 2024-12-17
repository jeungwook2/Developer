package kh;

public class Main01 {

	public static void main(String[] args) {

		int[] x = new int[10];
		x[0] =	100;
		x[1] =	100;
		x[2] =	100;
		x[3] =	100;
		x[4] =	100;
		x[5] =	100;
		x[6] =	100;
		x[7] =	100;
		x[8] =	100;
		x[9] =	100;
		
//		for(int n = 0; n < 배열의 길이; n++)
		for(int n = 0; n < x.length; n++) {
			System.out.println(x[n]);
		}
	}

}