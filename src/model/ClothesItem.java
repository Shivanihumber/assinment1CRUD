package model;


public class ClothesItem {

	private int id;
	private String color;
	private float price;

	private String name;
	private Type type;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClothesItem(int id, String color, float price, String name, Type type) {
		this.id = id;
		this.color = color;
		this.price = price;
		this.name = name;
		this.type = type;
	}


	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public String getColor() {
		return color;
	}

	public float getPrice() {
		return price;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPrice(float price) {
		this.price = price;
	}










}
