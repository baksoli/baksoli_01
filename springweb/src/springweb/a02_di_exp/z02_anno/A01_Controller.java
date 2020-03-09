package springweb.a02_di_exp.z02_anno;

import org.springframework.beans.factory.annotation.Autowired;

import springweb.a02_di_exp.z01_vo.Product;

public class A01_Controller {
	// 소스 코드 내에서 autowired 설정 처리.
	// container에서 해당 객체가 생성되어 메모리를 잡고 있으면
	// 자동으로 할당하게 처리한다. DI(Dependency Injection)
	// spring에서는 new XXXX() 를 통해서 컨테이너에 있는 객체를
	// 다시 생성하여 할당하지 않는다.
	@Autowired
	private A02_Service service;
	
	public void calling() {
		System.out.println("# 데이터 리스트 #");
		// service에 객체가 할당되어 있는 경우 
		if(service!= null && service.plist().size()>0) {
			for(Product p : service.plist()) {
				p.showInfo();
			}
		}
	}
	
	
	
}
