package mob;

public class Turtle extends Pokemon{

	public Turtle(int hp, int atk) {
		super("꼬부기", hp, atk);
	}
	
	@Override
	public void skill() {
		System.out.println("물대포 !");
	}

}
