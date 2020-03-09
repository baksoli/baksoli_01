package springweb.z01_vo;

public class Product {
	private String type;
	private String name;
	private int price;
	private int cnt;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String type, String name, int price, int cnt) {
		super();
		this.type = type;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
