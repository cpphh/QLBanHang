package BEAN;

public class Product {
	private int id;
	private String name;
	private int price;
	private int classify;
	private String picture;
	
	public Product(int id, String name, int price, int classify, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.classify = classify;
		this.picture = picture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getClassify() {
		return classify;
	}
	public void setClassify(int classify) {
		this.classify = classify;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}
