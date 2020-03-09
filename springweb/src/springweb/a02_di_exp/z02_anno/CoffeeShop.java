package springweb.a02_di_exp.z02_anno;

import javax.annotation.Resource;

public class CoffeeShop {
	private String name;
	@Resource(name = "coffee1")
	private Coffee coffee1;
	@Resource(name = "coffee2")
	private Coffee coffee2;
	public CoffeeShop(String name) {
		super();
		this.name = name;
	}

	public CoffeeShop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void orderedList() {
		int cnt = 1;
		int tot = 0;
		System.out.println(name+" 주문 리스트");
		System.out.print("주문\t가격\t수량\t계\n");
		if (coffee1 != null) {
			tot += coffee1.order();
		}
		if (coffee2 != null) {
			tot += coffee2.order();
		}
		System.out.println("총합 = "+tot);
	}

}
