package kh;

public class Main {

	public static void main(String[] args) {
		
		Car[] carArr = new Car[5];
		
		carArr[0] = new OilCar();
		carArr[0].setName("소나타");
		((OilCar)carArr[0]).set기름연비(10);
	
		carArr[1] = new OilCar();
		carArr[1].setName("k5");
		
		carArr[2] = new OilCar();
		carArr[2].setName("k9");
		
		carArr[3] = new ElecCar();
		carArr[3].setName("modelX");
		
		carArr[4] = new ElecCar();
		carArr[4].setName("modelS");
		
		System.out.println(((OilCar)carArr[0]).get기름연비());
		
		for(int i=0; i<carArr.length; i++) {
			System.out.println(carArr[i].getName());
		}
		
	}

}