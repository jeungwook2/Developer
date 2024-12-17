package mob;

public class Lizard extends Pokemon{
	
	public Lizard(int hp, int atk) {
		super("파이리", hp, atk);
	}
	
	@Override
	public void skill() {
		System.out.println("파이어볼 !");
	}

}
