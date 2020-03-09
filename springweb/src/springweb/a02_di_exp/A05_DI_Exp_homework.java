package springweb.a02_di_exp;

import org.springframework.context.support.GenericXmlApplicationContext;

import springweb.a02_di_exp.z01_vo.Man;
import springweb.a02_di_exp.z01_vo.Person;
import springweb.a02_di_exp.z01_vo.Shopping;

public class A05_DI_Exp_homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("springweb\\a02_di_exp\\a05_di_homework.xml");
		
		Shopping shop01 = ctx.getBean("shop01", Shopping.class);
		shop01.shoppingList();
		
		
	}

}
