package main;

public class Flower {
	// jangan lupa nama2nya nanti disesuaikan dengan column di db dl
	private String flower_name;
	private String type;
	private int price;
	
	public Flower(String flower_name, String type, int price) {
		super();
		this.flower_name = flower_name;
		this.type = type;
		this.price = price;
	}

	public String getFlower_name() {
		return flower_name;
	}

	public void setFlower_name(String flower_name) {
		this.flower_name = flower_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
