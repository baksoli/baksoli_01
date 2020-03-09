package springweb.a02_di_exp;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

import springweb.a02_di_exp.z01_vo.Person;
import springweb.a02_di_exp.z01_vo.Woman;
import springweb.a02_di_exp.z02_anno.DBConnect;
import springweb.a02_di_exp.z02_anno.ServerConnect;

public class A07_DI_Exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("springweb\\a02_di_exp\\a07_di.xml");
		
		DBConnect dbc = ctx.getBean("dbcon", DBConnect.class);
		dbc.showInfo();
		
		ServerConnect svc = ctx.getBean("serverCon", ServerConnect.class);
		svc.showInfo1();
		svc.showInfo2();
		
		//p01은 default인 singleton 이기 때문에
		// 이를 통해서 할당된 p1, p2는 같은 객체의 주소를 참조한다.
		// p1의 속성 변경이 p2에 영향을 미친다.
		Person p1 = ctx.getBean("p01", Person.class);
		p1.setName("홍길동");
		Person p2 = ctx.getBean("p01", Person.class);
		// p1과 p2는 같은 주소를 가진 객체.(singleton)
		// singleton이므로 하나의 객체만 생성되기에 동일한 데이터를 가지고 있다.
		System.out.println(p1.getName());
		System.out.println(p2.getName());
		
		//w01 Woman은 컨테이너 내에서 type=prototype 범위로 설정되어
		// 호출 시마다 할당하는 Woman w1, w2 는 다른 객체의 주소값을 가진다.
		// w1과 w2는 서로 영향을 미치지 않는다.
		Woman w1 = ctx.getBean("w01", Woman.class);
		w1.setName("김정아");
		Woman w2 = ctx.getBean("w01", Woman.class);
		// w1과 w2는 다른 주소를 참조하는 객체.
		// scope가 prototype인 경우에는 객체가 호출될 때마다 다른 객체를 생성한다.
		System.out.println(w1.getName());
		System.out.println(w2.getName());
		
		// 해당 코드로 불러오기
		System.out.println("현재 지역코드값 : "+ Locale.getDefault());
		System.out.println(ctx.getMessage("hello", null, Locale.getDefault()));
		// Locale.getDefault() : 현재 개발 소스의 언어 코드값.
		// 매개변수값 처리.
		// ctx.getMessage("코드명", 매개데이터 배열 문자열 객체, 언어코드값)
		System.out.println(ctx.getMessage("welcome", new String[] {"홍길동"}, Locale.getDefault()));
		// 영어 지역 코드 .. Locale.ENGLISH
		System.out.println("영어 지역코드값: "+Locale.ENGLISH);
		System.out.println(ctx.getMessage("hello", null, Locale.ENGLISH));
		System.out.println(ctx.getMessage("welcome", new String[] {"MR.hong"}, Locale.ENGLISH));
		
		System.out.println(ctx.getMessage("login", null, Locale.getDefault()));
		System.out.println(ctx.getMessage("welcomeMessage", new String[] {"김은숙","강남"}, Locale.getDefault()));
		
		System.out.println(ctx.getMessage("login", null, Locale.ENGLISH));
		System.out.println(ctx.getMessage("welcomeMessage", new String[] {"MS.kim","kangnam"}, Locale.ENGLISH));
		
	}

}
