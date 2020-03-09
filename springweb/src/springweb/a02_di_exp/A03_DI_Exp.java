package springweb.a02_di_exp;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springweb.a02_di_exp.z01_vo.BookStore;
import springweb.a02_di_exp.z01_vo.Mart2;
import springweb.a02_di_exp.z01_vo.Mart3;
import springweb.a02_di_exp.z01_vo.Monitor;
import springweb.a02_di_exp.z01_vo.Sensor;

public class A03_DI_Exp {
	public static void main(String[] args) {
		// # 호출하는 DL 객체 생성.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springweb\\a02_di_exp\\a02_di.xml");
		// 1. .getBean("id/name", 클래스명.class);
		Mart2 m01 = ctx.getBean("mart01", Mart2.class);
		m01.displayProd();
		
		Mart3 m03 = ctx.getBean("mart03",Mart3.class);
		m03.buyList();
		
		Sensor sensor1 = ctx.getBean("sensor1", Sensor.class);
		System.out.println(sensor1);
		
		Monitor monitor1 = ctx.getBean("monitor", Monitor.class);
		System.out.println(monitor1);
		
		BookStore bookStore1 = ctx.getBean("bookStore01", BookStore.class);
		System.out.println(bookStore1);
		
	}
}
