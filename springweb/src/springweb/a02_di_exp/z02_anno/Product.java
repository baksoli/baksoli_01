package springweb.a02_di_exp.z02_anno;

//springweb.a02_di_exp.z01_vo.Product
public class Product {
	private String name;
	private int price;
	private int cnt;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	public void showInfo() {
		System.out.println("단가 "+price+"원인 물건 "+name+"를 "+cnt+"개 "+(price*cnt)+"원에 구매하였다.");
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

