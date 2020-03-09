package springweb.a02_di_exp;

import org.springframework.context.support.GenericXmlApplicationContext;

import springweb.a02_di_exp.z02_anno.A01_Controller;
import springweb.a02_di_exp.z02_anno.BookStore;
import springweb.a02_di_exp.z02_anno.Calculator;
import springweb.a02_di_exp.z02_anno.CoffeeShop;
import springweb.a02_di_exp.z02_anno.HomeController;
import springweb.a02_di_exp.z02_anno.Man;
import springweb.a02_di_exp.z02_anno.Mart;

public class A06_DI_Exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("springweb\\a02_di_exp\\a06_di.xml");
		
		 A01_Controller ctrl01 = ctx.getBean("ctrl01",A01_Controller.class);
		ctrl01.calling();
		
		Man man = ctx.getBean("man01", Man.class);
		man.show();
		
		Mart mart01 = ctx.getBean("mart01", Mart.class);
		mart01.buy();
	
		BookStore bs01 = ctx.getBean("bookStore01", BookStore.class);
		bs01.bookStoreShow();
		
		HomeController homectrl = ctx.getBean("homectrl", HomeController.class);
		homectrl.display();
		
		Calculator calc01 = ctx.getBean("calc01", Calculator.class);
		calc01.plus();
		calc01.minus();
		
		CoffeeShop cafe1 = ctx.getBean("cafe1", CoffeeShop.class);
		cafe1.orderedList();
	}

}
