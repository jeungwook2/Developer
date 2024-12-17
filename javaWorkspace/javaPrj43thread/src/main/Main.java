package main;

public class Main {

	public static void main(String[] args) throws Exception {

		String tname = Thread.currentThread().getName();
		System.out.println("===== " + tname + " 쓰레드 일 시작 =====");
		
		Thread.sleep(3000);
		
		new KhThread01().start();
		new KhThread02().start();
		new KhThread03().start();
		
	}//main

}//class
