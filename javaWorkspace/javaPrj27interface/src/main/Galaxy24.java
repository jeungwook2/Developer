package main;

public class Galaxy24 implements Camera, Mp3, Phone{
	
	@Override
	public void takePicture() {
		System.out.println("딸깍");
	}
	
	@Override
	public void playMusic() {
		System.out.println("🎧🎧~");
	}
	
	@Override
	public void call() {
		System.out.println("따르릉");
	}
	
}
