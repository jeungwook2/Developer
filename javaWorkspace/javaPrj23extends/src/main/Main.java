package main;

public class Main {

	public static void main(String[] args) {

		Pokemon x = new Pikachu();

		if( x instanceof Pikachu ) {
			((Pikachu)x).백만볼트();
		}
	}

}
