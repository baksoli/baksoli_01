package springweb.a02_di_exp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springweb.a02_di_exp.z01_vo.Baseball;

public class A03_DI_Exp_Assignment {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springweb\\a02_di_exp\\a02_di_assignment.xml");
		
		Baseball baseTeam01 = ctx.getBean("proTeam01", Baseball.class);
		baseTeam01.teamList();
	}
}
