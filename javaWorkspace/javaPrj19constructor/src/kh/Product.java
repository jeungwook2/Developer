package kh;

public class Product {

	private String name;
	private int price;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name.length() >= 1) {
			this.name = name;
		}
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
