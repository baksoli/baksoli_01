package springweb.a02_di_exp.z02_anno;

public class Coffee {
	private String name;
	private int price;
	private int cnt;
	public String getName() {
		return name;
	}
	
	public Coffee(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	public Coffee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int order() {
		//출력
		System.out.print(name+"\t");
		System.out.print(price+"\t");
		System.out.print(cnt+"\t");
		System.out.print(price*cnt+"\n");
		return price*cnt;
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
