package springweb.a02_di_exp;

import org.springframework.context.support.GenericXmlApplicationContext;

import springweb.a02_di_exp.z01_vo.Man;
import springweb.a02_di_exp.z01_vo.Person;

public class A00_DI_Exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("springweb\\a02_di_exp\\a04_di.xml");
		
		Person p01 = ctx.getBean("p01",Person.class);
		
	}

}
