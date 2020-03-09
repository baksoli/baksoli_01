package springweb.a02_di_exp.z02_anno;

import java.util.ArrayList;
import springweb.a02_di_exp.z01_vo.Product;

//springweb.a02_di_exp.z02_anno.A02_Service
public class A02_Service {
	public ArrayList<Product> plist(){
		// DAO에 받아온 Model 데이터.
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(new Product("사과",3000,2));
		list.add(new Product("바나나",4000,3));
		list.add(new Product("딸기",12000,4));
		return list;
	}
}
