package springweb.a02_di_exp.z01_vo;

import org.springframework.beans.factory.annotation.Autowired;

//springweb.a02_di_exp.z01_vo.Mart
public class Mart {
	private String name;
	@Autowired
	private Product product;
	public Mart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mart(String name) {
		super();
		this.name = name;
	}
	public void buy() {
		if(product != null) {
			System.out.print(name + "마트에서 ");
			product.showInfo();
		}else {
			System.out.println(name+"마트에서 아무것도 구매하지 않았다.");
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product getProduct() {
		return product;
	}
	// autowire="byName"으로 할당되려면,
	// Product 클래스가 선언되고, bean의 id값이 product이어야 한다.
	// 즉, setXXXX의 property 값이 product일 때, 자동으로 할당된다.
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
