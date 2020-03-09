package springweb.a02_di_exp.z02_anno;

import javax.annotation.Resource;

public class HomeController {
	// j2ee에서 지원하는 annotation
	// Resource(name="참조변수")
	// autowired 할 참조 변수 값을 선언한다.
	// ex) container에서 bean 의 id로 num1이 있으면,
	//  해당 Number객체로 autowire되어 처리 된다.
	@Resource(name="num1")
	private Number num1;
	
	@Resource(name="num2")
	private Number num2;
	
	public void display() {
		System.out.println("첫번째 숫자 : "+num1);
		System.out.println("두번째 숫자 : "+num2);
	}
}
