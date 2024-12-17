package main;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== exception =====");
		
		Test test = new Test();
		
		try {
//			int x = 1/0;
//			throw new ArithmeticException();
			throw new KhException();
		}catch(KhException x) {
			System.out.println("예외 던져짐 .... 메인에서 잡았음...");
		}finally {
			System.out.println("여기는 무조건 실행되는 블럭,,,, try에 진입했다면,, 여기는 무조건임,,,");
		}
		
	}

}
