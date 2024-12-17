package main;

public class KhT02 extends Thread {

	@Override
	public void run() {
		String tname = Thread.currentThread().getName();
		System.out.println(tname + "쓰레드 시작~");
		
		for(int i=0; i<=10; i++) {
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
			System.out.println(tname + " : " + i);
		}
	}
}
