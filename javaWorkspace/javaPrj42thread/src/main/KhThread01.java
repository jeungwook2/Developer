package main;

public class KhThread01 extends Thread {
	
	@Override
	public void run() {
		Thread.currentThread().setName("kh01t");
		System.out.println(Thread.currentThread().getName());
		System.out.println("kh 쓰레드 일 시작 ~~~");
	}
	
}
