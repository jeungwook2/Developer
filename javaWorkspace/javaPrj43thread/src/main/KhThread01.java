package main;

public class KhThread01 extends Thread {

	@Override
	public void run() {
		String tname = Thread.currentThread().getName();
		System.out.println( tname + "쓰레드 일 시작 ~ !"  );
		
		for(int i = 1; i<=10; ++i) {
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
			System.out.println(tname + ":" + i);
		}
	
	}//run
	
}//class
