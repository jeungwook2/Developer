package main;

public class Main {

	public static void main(String[] args) throws Exception {
	
		String tname = Thread.currentThread().getName();
		System.out.println(tname + "쓰레드 시작~");
		
		Thread.sleep(1000);
		
		new KhT01().start();
		new KhT02().start();
		new KhT03().start();
		
		
	}
}
