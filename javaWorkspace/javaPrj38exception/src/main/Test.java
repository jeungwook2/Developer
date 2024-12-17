package main;

public class Test {

	public void m01() {
		System.out.println("m01 start...");
		
		try {
			int x = 1 / 1;
			System.out.println(x);
		}catch(Exception e) {
			System.out.println("예외 발생 ~~~");
		}
		
		System.out.println("m01 end...");
	}
}
