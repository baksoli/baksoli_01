package springweb.a02_di_exp;

import org.springframework.context.support.GenericXmlApplicationContext;

import springweb.a02_di_exp.z01_vo.Man;
import springweb.a02_di_exp.z01_vo.Person;

public class A03_DI_Exp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("springweb\\a02_di_exp\\a03_di.xml");
		
		Person p01 = ctx.getBean("p01",Person.class);
		System.out.println("## namespace로 호출 처리 ##");
		System.out.println(p01.getName());
		System.out.println(p01.getAge());
		System.out.println(p01.getLoc());
		Person p02 = ctx.getBean("p02", Person.class);
		System.out.println(p01.getName());
		System.out.println(p01.getAge());
		System.out.println(p01.getLoc());
		
		Man m01 = ctx.getBean("m01", Man.class);
		m01.show();
	}

}
