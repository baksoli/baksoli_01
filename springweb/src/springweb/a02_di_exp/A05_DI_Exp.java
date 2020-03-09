package springweb.a02_di_exp;

import org.springframework.context.support.GenericXmlApplicationContext;

import springweb.a02_di_exp.z01_vo.Bus;
import springweb.a02_di_exp.z01_vo.Man;
import springweb.a02_di_exp.z01_vo.Mart;

public class A05_DI_Exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("springweb\\a02_di_exp\\a05_di.xml");
		
		Man m01 = ctx.getBean("m01",Man.class);
		m01.show();
		
		Mart mart01 = ctx.getBean("mart01", Mart.class);
		mart01.buy();
		
		Bus bus01 = ctx.getBean("bus01", Bus.class);
		bus01.showInfo();
	}

}
