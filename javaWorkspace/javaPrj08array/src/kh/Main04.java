package kh;

public class Main04 {

	public static void main(String[] args) {

		// 문자열 변수 3개를 한번에 만들기
		String[] array = new String[3];
		
		// 3개의 변수에 아무거나(논리값) 집어넣기
		array[0] = "deft";
		array[1] = "chovy";
		array[2] = "kiin";
		
		// 3개의 변수 값 출력해보기
		for(int i=0; i<3; i++) {
			System.out.println(array[i]);
		}
		
	}

}
