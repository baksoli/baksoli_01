package springweb.a02_di_exp.z02_anno;

public class Book {
	private String name;
	private int price;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public void showBook() {
		System.out.println(name +" 도서의 가격은 "+price + "입니다.");
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
	
	
}
