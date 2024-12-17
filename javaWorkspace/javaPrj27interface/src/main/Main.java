package main;

public class Main {

	public static void main(String[] args) {

		System.out.println(" ===== 인터페이스 =====");
		
		Camera x = new Galaxy24();
		((Phone)x).call();
		((Mp3)x).playMusic();
		x.takePicture();
	}

}
