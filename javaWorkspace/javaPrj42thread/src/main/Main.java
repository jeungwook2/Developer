package main;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== thread =====");
		
		new Thread( () -> {
			System.out.println("할일~~~");
		} ).start();
		
//		Runnable obj = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("인터페이스로 객체 바로 만들어봄 ~~~");
//			}
//		};
//		new Thread(obj).start();//Thread()의 괄호안에 runnable 객체를 담으면 run() 이 무조건 실행됨
	}

}
