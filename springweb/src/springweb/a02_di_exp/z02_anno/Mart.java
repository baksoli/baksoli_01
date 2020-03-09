package springweb.a02_di_exp.z02_anno;

import org.springframework.beans.factory.annotation.Autowired;

//springweb.a02_di_exp.z01_vo.Mart
public class Mart {
	private String name;
	// autowiring 옵션 중에, 객체가 생성되지 않더라도 
	// 에러를 발생시키지 않으려면 반드시 required=false 옵션을
	// 설정하여야 한다.
	@Autowired(required = false)
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
}
