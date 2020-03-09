package springweb.a02_di_exp.z02_anno;

import javax.annotation.Resource;

public class Calculator {
	@Resource(name="num3")
	private Number num3;
	@Resource(name="num4")
	private Number num4;

	public void plus() {
		int rtn1 = num3.toNumber() + num4.toNumber();
		System.out.println("## 두 수의 덧셈 결과 ##");
		System.out.println(num3.toNumber() + " + "+ num4.toNumber() +" = " +rtn1);
	}
	
	public void minus() {
		int rtn2 = num3.toNumber() - num4.toNumber();
		System.out.println("## 두 수의 뺄셈 결과 ##");
		System.out.println(num3.toNumber() + " - "+ num4.toNumber() +" = "+rtn2);
	}
	
}
