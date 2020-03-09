package springweb.a02_di_exp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import springweb.a02_di_exp.z01_vo.Man;
import springweb.a02_di_exp.z01_vo.Mart;
import springweb.a02_di_exp.z01_vo.Person;
import springweb.a02_di_exp.z01_vo.proTeam;

public class A01_DI_Exp {
	public static void main(String[] args) {
		/*
		 * # DI(Dependency Injection) 호출 연습 환경 구축.
		 * 1. container 선언과 동일한 xml 파일 복사 및 파일명 변경.
		 * 2. 조립기 호출 클래스 선언 
		 * 	1) Resource rs = new ClassPathResource("연습할 xml 파일 경로 및 파일명");
		 * 3. xml 안에 container bean 으로 선언된 부분 id나 name으로 호출
		 *  1) BeanFactory bean = new XmlBeanFactory(rs)
		 *  2) bean.getBean("xml에서 선언한 id명") 로 객체를 호출
		 *  3) file에서 가져오는 모든 객체는 Object 타입이기 때문에 type casting이 필요
		 *  	(typecasting)bean.getBean("아이디명")
		 * 4. 객체의 메서드나 field 사용 가능
		 * 
		 * # 구현 내용 처리.
		 * 1. bean으로 선언할 VO 클래스 선언.
		 * 2. xml컨테이너에서 VO 클래스의 메서드 사용.
		 * 3. 위 조립기 호출 방법으로 처리.
		 */
		
		// 1. xml 파일 소스 메모리 로딩.
		Resource rs = new ClassPathResource("springweb\\a02_di_exp\\a01_di.xml");
		// 2. xml에서 bean 객체 가져오기
		BeanFactory bean = new XmlBeanFactory(rs);
		// 3. bean을 선언한 객체 가져와서 type casting 처리
		Person p01 = (Person)bean.getBean("p02");
		System.out.println(p01.getName());
		System.out.println(p01.getAge());
		System.out.println(p01.getLoc());
		
		proTeam p02 = (proTeam)bean.getBean("pro");
		System.out.println(p02.getTeamName());
		System.out.println(p02.getWin() + "승");
		System.out.println(p02.getSame() + "무");
		System.out.println(p02.getLoose() + "패");
		
		Person p03 = (Person)bean.getBean("p03");
		System.out.println("## Person 생성자 호출 ##");
		System.out.println(p03.getName());
		System.out.println(p03.getAge());
		System.out.println(p03.getLoc());
		
		Man man01 = (Man)bean.getBean("man01");
		man01.show();
		
		Mart mart01= (Mart)bean.getBean("mart01");
		mart01.buy();
	}
}
